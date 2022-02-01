package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.IScenesRecommendManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class ScenesRecommendManagerImpl
  extends BroadcastReceiver
  implements IScenesRecommendManager
{
  public static final boolean IS_DEBUG_DATA = false;
  public static final int SCENES_REC_KOV_NOT_FIND = 1;
  public static final int SCENES_REC_SUCCESS = 0;
  public static final int SCENES_REC_UIN_NOT_CURRENT = 2;
  public static final String TAG = "ScenesRecommendManager";
  AppInterface mApp = null;
  List<ScenesRecommendItem> scencesItemList = null;
  WeakReference<ScenesRecommendManagerImpl.IScenesRecEmoUIHelper> uiHelperWeakReference;
  
  private boolean checkNotifyUinIsCurrentSession(String paramString)
  {
    ScenesRecommendManagerImpl.IScenesRecEmoUIHelper localIScenesRecEmoUIHelper = tryGetUIHelper();
    if (localIScenesRecEmoUIHelper == null)
    {
      QLog.d("ScenesRecommendManager", 1, "helper is null");
      return false;
    }
    return localIScenesRecEmoUIHelper.a(paramString);
  }
  
  private void doScenesEmotionRecommend(ScenesRecommendItem paramScenesRecommendItem)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doScenesEmotionRecommend ScenesRecommendItem is ");
    ((StringBuilder)localObject).append(paramScenesRecommendItem.a());
    QLog.i("ScenesRecommendManager", 2, ((StringBuilder)localObject).toString());
    localObject = tryGetUIHelper();
    if (localObject == null) {
      return;
    }
    ((ScenesRecommendManagerImpl.IScenesRecEmoUIHelper)localObject).a(paramScenesRecommendItem);
  }
  
  private ScenesRecommendItem findScenesRecItemByKOV(String paramString)
  {
    Object localObject1 = this.scencesItemList;
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((List)localObject1).iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (ScenesRecommendItem)localIterator.next();
    } while ((((ScenesRecommendItem)localObject1).d() == null) || (!((ScenesRecommendItem)localObject1).d().equalsIgnoreCase(paramString)));
    return localObject1;
  }
  
  public static ScenesRecommendManagerImpl get(AppInterface paramAppInterface)
  {
    return (ScenesRecommendManagerImpl)paramAppInterface.getRuntimeService(IScenesRecommendManager.class, "");
  }
  
  protected boolean checkUin(String paramString1, String paramString2)
  {
    return (checkNotifyUinIsCurrentSession(paramString1)) && (!checkUinisCurrent(paramString2));
  }
  
  protected boolean checkUinisCurrent(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return false;
    }
    return paramString.equalsIgnoreCase(this.mApp.getCurrentUin());
  }
  
  public ScenesRecommendItem findScenesRecItemByID(String paramString)
  {
    Object localObject1 = this.scencesItemList;
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((List)localObject1).iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (ScenesRecommendItem)localIterator.next();
    } while ((((ScenesRecommendItem)localObject1).a() == null) || (!((ScenesRecommendItem)localObject1).a().equalsIgnoreCase(paramString)));
    return localObject1;
  }
  
  public void loadConfigFromLoacl()
  {
    String str = ScenesRecommendUtils.a(this.mApp);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadConfigFromLoacl config is ");
    localStringBuilder.append(str);
    QLog.i("ScenesRecommendManager", 2, localStringBuilder.toString());
    parseDataByJson(str);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    paramAppRuntime = new IntentFilter("mqq.scenesrecommendemo.notify.action");
    this.mApp.getApp().getApplicationContext().registerReceiver(this, paramAppRuntime);
    loadConfigFromLoacl();
  }
  
  public void onDestroy()
  {
    this.mApp.getApp().getApplicationContext().unregisterReceiver(this);
    this.mApp = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == "mqq.scenesrecommendemo.notify.action")
    {
      paramContext = paramIntent.getStringExtra("scenes_kov");
      boolean bool = paramIntent.getBooleanExtra("need_check_uin", true);
      String str = paramIntent.getStringExtra("check_uin");
      paramIntent = paramIntent.getStringExtra("HONGBAO_KEY_SENDERUIN");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive NOTIFY_SCENES_RECOMMEND_EMO_ACTION is ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("|");
      localStringBuilder.append(bool);
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      localStringBuilder.append("|");
      localStringBuilder.append(paramIntent);
      QLog.i("ScenesRecommendManager", 2, localStringBuilder.toString());
      onReceiveScenesRecNotify(paramContext, bool, str, paramIntent);
    }
  }
  
  public void onReceiveScenesRecNotify(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    int i;
    if ((paramBoolean) && (!checkUin(paramString2, paramString3))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      paramString2 = findScenesRecItemByKOV(paramString1);
      if (paramString2 != null)
      {
        doScenesEmotionRecommend(paramString2);
        reportScenesRecNotifyMonitor(0, paramString1);
        return;
      }
      reportScenesRecNotifyMonitor(1, paramString1);
      return;
    }
    reportScenesRecNotifyMonitor(2, paramString1);
  }
  
  public void parseDataByJson(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return;
    }
    List localList = this.scencesItemList;
    if (localList == null) {
      this.scencesItemList = new ArrayList();
    } else {
      localList.clear();
    }
    paramString = ScenesRecommendUtils.a(paramString);
    if (paramString != null) {
      this.scencesItemList.addAll(paramString);
    }
  }
  
  public void reportScenesRecNotifyMonitor(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportScenesRecNotifyError result: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ScenesRecommendManager", 2, ((StringBuilder)localObject).toString());
    }
    HashMap localHashMap = new HashMap();
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    localHashMap.put("kov", localObject);
    paramString = new StringBuilder();
    paramString.append(paramInt);
    paramString.append("");
    localHashMap.put("result", paramString.toString());
    paramString = StatisticCollector.getInstance(BaseApplication.getContext());
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramString.collectPerformance(null, "scenes_rec_emo_monitor", bool, 0L, 0L, localHashMap, null);
  }
  
  public void setUiHelper(ScenesRecommendManagerImpl.IScenesRecEmoUIHelper paramIScenesRecEmoUIHelper)
  {
    if (paramIScenesRecEmoUIHelper == null)
    {
      this.uiHelperWeakReference = null;
      return;
    }
    this.uiHelperWeakReference = new WeakReference(paramIScenesRecEmoUIHelper);
  }
  
  ScenesRecommendManagerImpl.IScenesRecEmoUIHelper tryGetUIHelper()
  {
    WeakReference localWeakReference = this.uiHelperWeakReference;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (ScenesRecommendManagerImpl.IScenesRecEmoUIHelper)this.uiHelperWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl
 * JD-Core Version:    0.7.0.1
 */