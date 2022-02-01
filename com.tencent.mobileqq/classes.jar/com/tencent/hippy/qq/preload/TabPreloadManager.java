package com.tencent.hippy.qq.preload;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.MainTabPreloadInterpolator;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.api.TabPreloadItem.PreloadType;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.update.HippyPredownloadManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.config.TabPreloadConfigManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.api.IStateManager;
import com.tencent.statemachine.api.StateObserver;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
  private ComponentCallbacks2 mComponentCallbacks = new TabPreloadManager.2(this);
  private boolean mHasPreloadInToolProcess;
  private boolean mIsPreloading = false;
  private StateObserver mMainTabStateObserver = new TabPreloadManager.3(this);
  private Object mPreloadDataLock = new Object();
  private TabPreloadManager.PreloadHandler mPreloadHandler = new TabPreloadManager.PreloadHandler(this, ThreadManager.getSubThreadLooper());
  private ArrayList<TabPreloadManager.PreloadInfo> mPreloadWaitList = new ArrayList();
  private ArrayList<TabPreloadManager.PreloadInfo> mPreloadedList = new ArrayList();
  
  static
  {
    sPreloadInterpolatorMap.put("QQNearby", new NearbyInterpolator());
    sPreloadInterpolatorMap.put("QQGameCenter", new GameCenterInterpolator());
    sPreloadInterpolatorMap.put("qqMiniGame", new MiniGameInterpolator());
    sPreloadInterpolatorMap.put("qqWeather", new WeatherInterpolator());
  }
  
  private TabPreloadManager()
  {
    MobileQQ.getContext().getApplicationContext().registerComponentCallbacks(this.mComponentCallbacks);
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
  
  private void doPreLoad(String paramString)
  {
    int i;
    label147:
    synchronized (this.mPreloadDataLock)
    {
      this.mPreloadWaitList.clear();
      clearOtherTabPreloads(paramString);
      List localList = getNeedPreloads(paramString, getCurrentProcessName());
      if (localList.size() > 0)
      {
        i = 0;
        if (i < localList.size())
        {
          if (isPreloaded(((TabPreloadItem)localList.get(i)).bundleName)) {
            break label147;
          }
          this.mPreloadWaitList.add(new TabPreloadManager.PreloadInfo(paramString, (TabPreloadItem)localList.get(i)));
          break label147;
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
  
  private void doPreUpdate(String paramString)
  {
    paramString = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getItemsOfTab(paramString, null, TabPreloadItem.PreloadType.PRE_UPDATE);
    int i = 0;
    while (i < paramString.size())
    {
      TabPreloadItem localTabPreloadItem = (TabPreloadItem)paramString.get(i);
      if (HippyUpdateManager.getInstance().checkUpdateJsBundleInterval(localTabPreloadItem.bundleName, localTabPreloadItem.preUpdateInterval))
      {
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isSkipInterval", true);
        HippyUpdateManager.getInstance().updateJsBundle(localTabPreloadItem.bundleName, ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, localBundle, null);
      }
      i += 1;
    }
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
    doPreLoad(paramString);
    if (MobileQQ.sProcessId == 1) {
      doPreUpdate(paramString);
    }
  }
  
  private boolean preloadOneItem(TabPreloadManager.PreloadInfo paramPreloadInfo)
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
      ((HippyQQPreloadEngine)localObject3).setJsBundleType(localTabPreloadItem.preloadFramework);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tab_");
      ((StringBuilder)localObject1).append(paramPreloadInfo.mPreloadTab);
      ((HippyQQPreloadEngine)localObject3).setPreloadFrom(((StringBuilder)localObject1).toString());
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
  
  protected void checkForToolProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = getNeedPreloads(paramString, "tool");
    if ((((List)localObject).size() <= 0) && (!this.mHasPreloadInToolProcess)) {
      return;
    }
    boolean bool;
    if (((List)localObject).size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasPreloadInToolProcess = bool;
    try
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("show_tab_name", paramString);
      HippyUtils.preloadHippyInToolProcess((Intent)localObject);
      return;
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndPreloadHippyPage sendBroadcast:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("TabPreloadManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void clearAllPreloads(String paramString)
  {
    QLog.e("TabPreloadManager", 1, "clearAllPreloads");
    synchronized (this.mPreloadDataLock)
    {
      int i = this.mPreloadedList.size() - 1;
      while (i >= 0)
      {
        ((TabPreloadManager.PreloadInfo)this.mPreloadedList.remove(i)).destroyHippyEngine(paramString);
        i -= 1;
      }
      HippyAccessHelper.clearAllPreloads();
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected void clearOtherTabPreloads(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    List localList = getNeedPreloads(paramString, getCurrentProcessName());
    int i = this.mPreloadedList.size() - 1;
    while (i >= 0)
    {
      int j = 0;
      while (j < localList.size())
      {
        ((TabPreloadManager.PreloadInfo)this.mPreloadedList.get(i)).mPreloadItem.bundleName.equals(((TabPreloadItem)localList.get(j)).bundleName);
        j += 1;
      }
      if (!((TabPreloadManager.PreloadInfo)this.mPreloadedList.get(i)).mPreloadTab.equals(paramString))
      {
        TabPreloadManager.PreloadInfo localPreloadInfo = (TabPreloadManager.PreloadInfo)this.mPreloadedList.remove(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tab_");
        localStringBuilder.append(paramString);
        localPreloadInfo.destroyHippyEngine(localStringBuilder.toString());
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
        ((TabPreloadManager.PreloadInfo)localArrayList.get(i)).destroyHippyEngine("logout");
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
        return "unknown";
      }
      return "tool";
    }
    return "main";
  }
  
  protected List<TabPreloadItem> getNeedPreloads(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(TabPreloadItem.PreloadType.PRE_DRAW);
    localArrayList.add(TabPreloadItem.PreloadType.PRE_LOAD);
    return HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getItemsOfTab(paramString1, paramString2, localArrayList);
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
            localPreloadInfo.mHippyEngine.destroyEngineImmediately("oldVersion");
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = (MainTabPreloadInterpolator)sPreloadInterpolatorMap.get(paramString);
      if (paramString != null)
      {
        boolean bool = paramString.hasNewMessage();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNewMessage error:");
      localStringBuilder.append(paramString);
      QLog.e("TabPreloadManager", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean isCanPreload(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = true;
    try
    {
      paramString = (MainTabPreloadInterpolator)sPreloadInterpolatorMap.get(paramString);
      if (paramString != null)
      {
        bool = paramString.isCanPreload();
        if (bool) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isCanPreload error:");
      localStringBuilder.append(paramString);
      QLog.e("TabPreloadManager", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean isInTabPreload(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!isCanPreload(paramString)) {
        return false;
      }
      Object localObject = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getTabPreloadConfig();
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
        Object localObject1 = HippyPredownloadManager.getInstance().getTabPreloadConfigManager();
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
          preloadOneItem((TabPreloadManager.PreloadInfo)localObject1);
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
      Map localMap = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getTabPreloadConfig();
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
          ??? = TabPreloadItem.PreloadType.PRE_DRAW;
        } else {
          ??? = TabPreloadItem.PreloadType.PRE_LOAD;
        }
        ((TabPreloadItem)localObject3).preloadType = ((TabPreloadItem.PreloadType)???);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.TabPreloadManager
 * JD-Core Version:    0.7.0.1
 */