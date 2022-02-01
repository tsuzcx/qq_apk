package com.tencent.hippy.qq.preload;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.hippy.qq.api.MainTabPreloadInterpolator;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.config.TabPreloadConfigManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.api.IStateManager;
import com.tencent.statemachine.api.StateObserver;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class TabPreloadManager
{
  private static final int MESSAGE_TAB_FIRST_PRELOAD_WAIT_TIME = 5000;
  private static final int MSG_PRELOAD_HIPPY = 2;
  private static final int MSG_TAB_CHANGED = 1;
  private static final int TAB_PRELOAD_WAIT_TIME = 1000;
  private static final String TAG = "TabPreloadManager";
  private static HashMap<String, MainTabPreloadInterpolator> sPreloadInterpolatorMap = new HashMap();
  private static volatile TabPreloadManager sTabPreloadManager;
  private boolean mIsPreloading = false;
  private StateObserver mMainTabStateObserver = new TabPreloadManager.2(this);
  private Object mPreloadDataLock = new Object();
  private TabPreloadManager.PreloadHandler mPreloadHandler = new TabPreloadManager.PreloadHandler(this, ThreadManager.getSubThreadLooper());
  private ArrayList<TabPreloadManager.PreloadInfo> mPreloadWaitList = new ArrayList();
  private ArrayList<TabPreloadManager.PreloadInfo> mPreloadedList = new ArrayList();
  
  static
  {
    sPreloadInterpolatorMap.put("QQGameCenter", new GameCenterInterpolator());
    sPreloadInterpolatorMap.put("qqMiniGame", new MiniGameInterpolator());
  }
  
  private String convertStateToTabName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.equals("main_message_tab_show")) {
      return "msgList";
    }
    if (paramString.equals("main_contacts_tab_show")) {
      return "contacts";
    }
    if (paramString.equals("main_kandian_tab_show")) {
      return "kandian";
    }
    if (paramString.equals("main_dynamic_tab_show")) {
      return "dynamic";
    }
    if (paramString.equals("main_drawer_tab_show")) {
      return "drawer";
    }
    return null;
  }
  
  private boolean doPreload(TabPreloadManager.PreloadInfo paramPreloadInfo)
  {
    if ((paramPreloadInfo != null) && (paramPreloadInfo.mPreloadItem != null) && (paramPreloadInfo.mPreloadItem.checkData()))
    {
      TabPreloadItem localTabPreloadItem = paramPreloadInfo.mPreloadItem;
      String str = localTabPreloadItem.bundleName;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preloadHippyPage moduleName:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" preloadType:");
      ((StringBuilder)localObject1).append(localTabPreloadItem.preloadType);
      QLog.d("TabPreloadManager", 1, ((StringBuilder)localObject1).toString());
      Object localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      Object localObject2 = HippyAccessHelper.getJSInitData((AppRuntime)localObject3, str, null, localTabPreloadItem.domain);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
      HippyAccessHelper.addPreloadParameters((JSONObject)localObject1, localTabPreloadItem.isPredraw());
      if (localObject3 == null) {
        localObject2 = "";
      } else {
        localObject2 = ((AppRuntime)localObject3).getAccount();
      }
      localObject3 = new HippyQQPreloadEngine(null, str, null);
      ((HippyQQPreloadEngine)localObject3).setInitData((JSONObject)localObject1, (JSONObject)localObject1);
      localObject1 = new TabPreloadManager.1(this, (HippyQQPreloadEngine)localObject3, str, localTabPreloadItem, (String)localObject2, paramPreloadInfo);
      if (localTabPreloadItem.isPredraw())
      {
        ((HippyQQPreloadEngine)localObject3).predrawHippy((HippyQQEngine.HippyQQEngineListener)localObject1, localTabPreloadItem.needCheckPreload, paramPreloadInfo.mPreloadScene);
        return true;
      }
      ((HippyQQPreloadEngine)localObject3).preloadHippy((HippyQQEngine.HippyQQEngineListener)localObject1, localTabPreloadItem.needCheckPreload, paramPreloadInfo.mPreloadScene);
      return true;
    }
    QLog.d("TabPreloadManager", 1, "doPreload parameters error");
    onPreloadFinish();
    return false;
  }
  
  public static TabPreloadManager getInstance()
  {
    if (sTabPreloadManager == null) {
      try
      {
        if (sTabPreloadManager == null)
        {
          sTabPreloadManager = new TabPreloadManager();
          ((IStateManager)QRoute.api(IStateManager.class)).addMainStateObserver(sTabPreloadManager.mMainTabStateObserver);
        }
      }
      finally {}
    }
    return sTabPreloadManager;
  }
  
  private void onPreloadFinish()
  {
    this.mPreloadHandler.removeMessages(2);
    this.mPreloadHandler.sendEmptyMessage(2);
  }
  
  private void onTabShow(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i;
    label143:
    synchronized (this.mPreloadDataLock)
    {
      this.mPreloadWaitList.clear();
      clearOtherTabPreloads(paramString);
      ArrayList localArrayList = getNeedPreloads(paramString);
      if (localArrayList.size() > 0)
      {
        i = 0;
        if (i < localArrayList.size())
        {
          if (isPreloaded(((TabPreloadItem)localArrayList.get(i)).bundleName)) {
            break label143;
          }
          this.mPreloadWaitList.add(new TabPreloadManager.PreloadInfo(paramString, (TabPreloadItem)localArrayList.get(i)));
          break label143;
        }
        if (!this.mIsPreloading)
        {
          this.mIsPreloading = true;
          this.mPreloadHandler.removeMessages(2);
          this.mPreloadHandler.sendEmptyMessage(2);
        }
      }
      return;
    }
  }
  
  protected void checkForToolProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (getNeedPreloads(paramString, "tool").size() <= 0) {
      return;
    }
    try
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("show_tab_name", paramString);
      ((IHippyUtils)QRoute.api(IHippyUtils.class)).preloadHippyInToolProcess((Intent)localObject);
      return;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndPreloadHippyPage sendBroadcast:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("TabPreloadManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void clearOtherTabPreloads(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList = getNeedPreloads(paramString);
    int i = this.mPreloadedList.size() - 1;
    while (i >= 0)
    {
      int j = 0;
      while (j < localArrayList.size())
      {
        ((TabPreloadManager.PreloadInfo)this.mPreloadedList.get(i)).mPreloadItem.bundleName.equals(((TabPreloadItem)localArrayList.get(j)).bundleName);
        j += 1;
      }
      if (!((TabPreloadManager.PreloadInfo)this.mPreloadedList.get(i)).mPreloadTab.equals(paramString)) {
        ((TabPreloadManager.PreloadInfo)this.mPreloadedList.remove(i)).destroyHippyEngine();
      }
      i -= 1;
    }
  }
  
  public void doAfterLogin()
  {
    int i = 0;
    this.mIsPreloading = false;
    this.mPreloadHandler.removeCallbacksAndMessages(null);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mPreloadDataLock)
    {
      this.mPreloadWaitList.clear();
      localArrayList.addAll(this.mPreloadedList);
      this.mPreloadedList.clear();
      while (i < localArrayList.size())
      {
        ((TabPreloadManager.PreloadInfo)localArrayList.get(i)).destroyHippyEngine();
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected String getCurrentProcessName()
  {
    int i = MobileQQ.sProcessId;
    if (i != 1)
    {
      if (i != 7) {
        return null;
      }
      return "tool";
    }
    return "main";
  }
  
  protected ArrayList<TabPreloadItem> getNeedPreloads(String paramString)
  {
    return getNeedPreloads(paramString, getCurrentProcessName());
  }
  
  protected ArrayList<TabPreloadItem> getNeedPreloads(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return localArrayList;
      }
      Map localMap = HippyUpdateManager.getInstance().getTabPreloadConfigManager().getTabPreloadConfig();
      if (localMap == null) {
        return localArrayList;
      }
      paramString1 = (ArrayList)localMap.get(paramString1);
      if (paramString1 != null)
      {
        int i = 0;
        while (i < paramString1.size())
        {
          if ((isCanPreload(((TabPreloadItem)paramString1.get(i)).bundleName)) && (!isPreloaded(((TabPreloadItem)paramString1.get(i)).bundleName)) && (paramString2.equals(((TabPreloadItem)paramString1.get(i)).preloadProcess))) {
            localArrayList.add(paramString1.get(i));
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public HippyQQPreloadEngine getPreloadedHippyQQEngine(String paramString)
  {
    Object localObject = this.mPreloadDataLock;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mPreloadedList.size())
        {
          TabPreloadManager.PreloadInfo localPreloadInfo = (TabPreloadManager.PreloadInfo)this.mPreloadedList.get(i);
          if ((localPreloadInfo.mHippyEngine != null) && (localPreloadInfo.mHippyEngine.getModuleName().equals(paramString)))
          {
            this.mPreloadedList.remove(i);
            int j = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(paramString);
            if (localPreloadInfo.mHippyEngine.getPreloadModuleVersion() == j)
            {
              paramString = localPreloadInfo.mHippyEngine;
              return paramString;
            }
            localPreloadInfo.mHippyEngine.destoryEngineImmediately();
          }
        }
        else
        {
          return null;
        }
      }
      finally
      {
        continue;
        throw paramString;
        continue;
        i += 1;
      }
    }
  }
  
  public StateObserver getStateObserver()
  {
    return this.mMainTabStateObserver;
  }
  
  public boolean hasNewMessage(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = (MainTabPreloadInterpolator)sPreloadInterpolatorMap.get(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.hasNewMessage()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isCanPreload(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = (MainTabPreloadInterpolator)sPreloadInterpolatorMap.get(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.isCanPreload()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isInTabPreload(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!isCanPreload(paramString)) {
        return false;
      }
      Object localObject = HippyUpdateManager.getInstance().getTabPreloadConfigManager().getTabPreloadConfig();
      if (localObject == null) {
        return false;
      }
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Iterator)localObject).next();
        if (localArrayList != null)
        {
          int i = 0;
          while (i < localArrayList.size())
          {
            if (paramString.equals(((TabPreloadItem)localArrayList.get(i)).bundleName)) {
              return true;
            }
            i += 1;
          }
        }
      }
    }
    return false;
  }
  
  protected boolean isPreloaded(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = 0;
    while (i < this.mPreloadedList.size())
    {
      if (paramString.equals(((TabPreloadManager.PreloadInfo)this.mPreloadedList.get(i)).mPreloadItem.bundleName)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected void onPreload()
  {
    for (;;)
    {
      synchronized (this.mPreloadDataLock)
      {
        Object localObject1 = HippyUpdateManager.getInstance().getTabPreloadConfigManager();
        if (this.mPreloadedList.size() >= ((TabPreloadConfigManager)localObject1).getPreloadMaxCount())
        {
          this.mIsPreloading = false;
          return;
        }
        if (this.mPreloadWaitList.size() > 0)
        {
          localObject1 = (TabPreloadManager.PreloadInfo)this.mPreloadWaitList.remove(0);
          if (localObject1 == null)
          {
            this.mIsPreloading = false;
            return;
          }
          this.mIsPreloading = true;
          doPreload((TabPreloadManager.PreloadInfo)localObject1);
          return;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public void onTabChangeForTool(String paramString)
  {
    Object localObject = QIPCClientHelper.getInstance().callServer("module_hippy", "action_get_main_state", null);
    if (localObject != null)
    {
      if (((EIPCResult)localObject).data == null) {
        return;
      }
      localObject = convertStateToTabName(((EIPCResult)localObject).data.getString("current_main_state"));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!((String)localObject).equals(paramString)) {
          return;
        }
        if (this.mPreloadHandler != null)
        {
          paramString = new Message();
          paramString.what = 1;
          paramString.obj = localObject;
          this.mPreloadHandler.removeMessages(1);
          this.mPreloadHandler.sendMessage(paramString);
        }
      }
    }
  }
  
  public boolean preloadWhenBack(OpenHippyInfo paramOpenHippyInfo)
  {
    int j = 0;
    if ((paramOpenHippyInfo != null) && (paramOpenHippyInfo.checkData()))
    {
      Map localMap = HippyUpdateManager.getInstance().getTabPreloadConfigManager().getTabPreloadConfig();
      if (localMap == null) {
        return false;
      }
      Iterator localIterator = localMap.keySet().iterator();
      Object localObject2 = null;
      ??? = null;
      Object localObject3;
      Object localObject4;
      int i;
      do
      {
        String str;
        ArrayList localArrayList;
        do
        {
          localObject3 = localObject2;
          localObject4 = ???;
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
          localArrayList = (ArrayList)localMap.get(str);
        } while (localArrayList == null);
        i = 0;
        for (;;)
        {
          localObject3 = localObject2;
          localObject4 = ???;
          if (i >= localArrayList.size()) {
            break;
          }
          if (paramOpenHippyInfo.bundleName.equals(((TabPreloadItem)localArrayList.get(i)).bundleName))
          {
            localObject3 = (TabPreloadItem)localArrayList.get(i);
            localObject4 = str;
            break;
          }
          i += 1;
        }
        localObject2 = localObject3;
        ??? = localObject4;
      } while (localObject3 == null);
      if (localObject3 != null)
      {
        if (TextUtils.isEmpty(localObject4)) {
          return false;
        }
        if (paramOpenHippyInfo.isPredraw) {
          ??? = "predraw";
        } else {
          ??? = "preload";
        }
        ((TabPreloadItem)localObject3).preloadType = ((String)???);
        synchronized (this.mPreloadDataLock)
        {
          localObject2 = new TabPreloadManager.PreloadInfo(localObject4, (TabPreloadItem)localObject3);
          i = j;
          if (paramOpenHippyInfo.isPreloadFromExitPage) {
            i = 2;
          }
          ((TabPreloadManager.PreloadInfo)localObject2).mPreloadScene = i;
          this.mPreloadWaitList.add(localObject2);
          if (!this.mIsPreloading)
          {
            this.mIsPreloading = true;
            this.mPreloadHandler.removeMessages(2);
            this.mPreloadHandler.sendEmptyMessage(2);
          }
          return true;
        }
      }
      return false;
    }
    QLog.d("TabPreloadManager", 1, "preloadHippyPage parameters error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.TabPreloadManager
 * JD-Core Version:    0.7.0.1
 */