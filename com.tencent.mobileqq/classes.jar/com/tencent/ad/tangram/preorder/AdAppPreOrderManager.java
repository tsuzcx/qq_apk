package com.tencent.ad.tangram.preorder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.account.AdAccount;
import com.tencent.ad.tangram.account.AdAccountListener;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.downloader.IAdDownloader;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdConnectivityManager;
import com.tencent.ad.tangram.net.AdConnectivityManager.Listener;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAppPreOrder;
import com.tencent.ad.tangram.protocol.msg_content;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdLifecycleManager;
import com.tencent.ad.tangram.util.AdLifecycleManager.a;
import com.tencent.ad.tangram.util.AdScreenStatusManager;
import com.tencent.ad.tangram.util.AdScreenStatusManager.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Keep
public enum AdAppPreOrderManager
{
  INSTANCE;
  
  private static final int STATUS_CHECK_TASKS = 2;
  private static final int STATUS_CHECK_TASKS_WITH_PENDING_TASKS = 3;
  private static final int STATUS_READY = 1;
  private static final int STATUS_UNKNOWN = 0;
  private static final String TAG = "AdAppPreOrderManager";
  private AdAccountListener accountListener = new AdAppPreOrderManager.1(this);
  private d appReceiver = new d();
  private a cache = new a();
  private AdConnectivityManager.Listener connectivityListener = new AdAppPreOrderManager.9(this);
  private volatile WeakReference<Context> context;
  private IAdDownloader.Callback downloadCallback = AdAppPreOrderDownloadListener.getAdapter();
  int downloadingTaskCount = 0;
  private long lastOnBackgroundTimeMillis;
  private AdLifecycleManager.a lifecycleListener = new AdAppPreOrderManager.10(this);
  private boolean messagesSynced = false;
  private boolean messagesSynced30SecondsDelay = false;
  private boolean netWorkStatusChanged = true;
  private boolean onBackgroundAtFirstTime20SecondsDelay = false;
  private boolean reminderStatusChanged = true;
  private AdScreenStatusManager.a screenListener = new AdAppPreOrderManager.8(this);
  private volatile int status = 0;
  
  private AdAppPreOrderManager() {}
  
  private boolean afterRunTasks()
  {
    try
    {
      if (this.status == 2)
      {
        this.status = 1;
        return false;
      }
      if (this.status == 3)
      {
        this.status = 1;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  private boolean beforeRunTasks()
  {
    if ((this.status != 1) && (this.status != 2)) {
      return false;
    }
    try
    {
      if ((this.status != 1) && (this.status != 2)) {
        return false;
      }
    }
    finally {}
    if (this.status == 2)
    {
      this.status = 3;
      return false;
    }
    this.status = 2;
    return true;
  }
  
  private AdAppPreOrderTask getTaskById(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.cache == null)) {
      return null;
    }
    return this.cache.getTaskById(paramString);
  }
  
  private List<AdAppPreOrderTask> getTasksByUrl(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.cache == null)) {
      return null;
    }
    return this.cache.getTasksByUrl(paramString);
  }
  
  private boolean isReady()
  {
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      AdLog.e("AdAppPreOrderManager", "not in main process");
      return false;
    }
    if (this.status == 0)
    {
      AdLog.e("AdAppPreOrderManager", "appendTask failed manager not ready!");
      return false;
    }
    return true;
  }
  
  private void onTaskStageChanged(String paramString)
  {
    int k = -2147483648;
    AdAppPreOrderTask localAdAppPreOrderTask = getTaskById(paramString);
    int j;
    label33:
    label99:
    Context localContext;
    if (localAdAppPreOrderTask != null)
    {
      i = localAdAppPreOrderTask.status;
      if (localAdAppPreOrderTask == null) {
        break label169;
      }
      j = localAdAppPreOrderTask.reportStage;
      AdLog.i("AdAppPreOrderManager", String.format("onTaskStageChanged taskId:%s status:%d reportStage:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) }));
      if ((localAdAppPreOrderTask == null) || (localAdAppPreOrderTask.content == null)) {
        break label175;
      }
      paramString = String.valueOf(localAdAppPreOrderTask.content.ad_info.report_info.trace_info.aid);
      localContext = getContext();
      if (localAdAppPreOrderTask == null) {
        break label180;
      }
    }
    label169:
    label175:
    label180:
    for (int i = localAdAppPreOrderTask.status;; i = -2147483648)
    {
      j = k;
      if (localAdAppPreOrderTask != null) {
        j = localAdAppPreOrderTask.reportStage;
      }
      AdReporterForAnalysis.reportForAppPreOrderTaskReportStageStatusChanged(localContext, i, j, this.messagesSynced, this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, AdScreenStatusManager.getInstance().isScreenOn(), AdLifecycleManager.INSTANCE.isOnForeground(), paramString);
      return;
      i = -2147483648;
      break;
      j = -2147483648;
      break label33;
      paramString = null;
      break label99;
    }
  }
  
  private void onTaskStatusChanged(String paramString, int paramInt)
  {
    int k = -2147483648;
    runTasks();
    AdAppPreOrderTask localAdAppPreOrderTask = getTaskById(paramString);
    int j;
    label38:
    label113:
    Context localContext;
    if (localAdAppPreOrderTask != null)
    {
      i = localAdAppPreOrderTask.status;
      if (localAdAppPreOrderTask == null) {
        break label187;
      }
      j = localAdAppPreOrderTask.reportStage;
      AdLog.i("AdAppPreOrderManager", String.format("onTaskStatusChanged taskId:%s status:%d reportStage:%d errorCode:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) }));
      if ((localAdAppPreOrderTask == null) || (localAdAppPreOrderTask.content == null)) {
        break label194;
      }
      paramString = String.valueOf(localAdAppPreOrderTask.content.ad_info.report_info.trace_info.aid);
      localContext = getContext();
      if (localAdAppPreOrderTask == null) {
        break label199;
      }
    }
    label187:
    label194:
    label199:
    for (int i = localAdAppPreOrderTask.status;; i = -2147483648)
    {
      j = k;
      if (localAdAppPreOrderTask != null) {
        j = localAdAppPreOrderTask.reportStage;
      }
      AdReporterForAnalysis.reportForAppPreOrderTaskStatusChanged(localContext, i, j, this.messagesSynced, this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, AdScreenStatusManager.getInstance().isScreenOn(), AdLifecycleManager.INSTANCE.isOnForeground(), paramString, paramInt);
      return;
      i = -2147483648;
      break;
      j = -2147483648;
      break label38;
      paramString = null;
      break label113;
    }
  }
  
  private void pauseActiveDownloadTasks()
  {
    if ((this.cache != null) && (!this.cache.getQueue().isEmpty()))
    {
      Iterator localIterator = this.cache.getQueue().iterator();
      while (localIterator.hasNext())
      {
        AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)localIterator.next();
        if ((localAdAppPreOrderTask.status >= 7) && (localAdAppPreOrderTask.status <= 10)) {
          b.pauseDownload(localAdAppPreOrderTask);
        }
      }
    }
  }
  
  private void registerListeners()
  {
    AdAccount.INSTANCE.addAccountListener(this.accountListener);
    AdConnectivityManager.getInstance().registerListener(this.connectivityListener);
    AdLifecycleManager.INSTANCE.registerListener(this.lifecycleListener);
    IAdDownloader localIAdDownloader = AdDownloader.getDownloader();
    if ((localIAdDownloader != null) && (this.downloadCallback != null)) {
      localIAdDownloader.registerListener(this.downloadCallback);
    }
    AdScreenStatusManager.getInstance().registerListener(this.screenListener);
  }
  
  private void runTaskOnFileThread(AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    if (paramAdAppPreOrderTask == null) {}
    do
    {
      return;
      if (!paramAdAppPreOrderTask.isValid(getContext()))
      {
        setTaskFinishedAndCommit(paramAdAppPreOrderTask.taskId, 13);
        return;
      }
      AdLog.i("AdAppPreOrderManager", String.format("runTaskOnFileThread taskId:%s status%d ", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
      if ((paramAdAppPreOrderTask.status == 2) || (paramAdAppPreOrderTask.status == 5) || (paramAdAppPreOrderTask.status == 6) || (paramAdAppPreOrderTask.status == 4) || (paramAdAppPreOrderTask.status == 7) || (paramAdAppPreOrderTask.status == 8) || (paramAdAppPreOrderTask.status == 9) || (paramAdAppPreOrderTask.status == 11))
      {
        b.runTask(getContext(), paramAdAppPreOrderTask, this.netWorkStatusChanged);
        return;
      }
      if ((paramAdAppPreOrderTask.status == 10) || ((paramAdAppPreOrderTask.status >= 12) && (paramAdAppPreOrderTask.status <= AdAppPreOrderTask.Status.QQREMINDER_END)))
      {
        c.runTask(getContext(), paramAdAppPreOrderTask, this.reminderStatusChanged, this.netWorkStatusChanged);
        return;
      }
    } while ((paramAdAppPreOrderTask.status == 33) || (paramAdAppPreOrderTask.status != -1));
  }
  
  private void unRegisterListeners()
  {
    AdAccount.INSTANCE.removeAccountListener(this.accountListener);
    AdConnectivityManager.getInstance().unRegisterListener(this.connectivityListener);
    AdLifecycleManager.INSTANCE.unRegisterListener(this.lifecycleListener);
    IAdDownloader localIAdDownloader = AdDownloader.getDownloader();
    if ((localIAdDownloader != null) && (this.downloadCallback != null)) {
      localIAdDownloader.unregisterListener(this.downloadCallback);
    }
    AdScreenStatusManager.getInstance().unRegisterListener(this.screenListener);
  }
  
  boolean canScheduleQQReminder()
  {
    return (this.messagesSynced30SecondsDelay) && (AdScreenStatusManager.getInstance().isScreenOn());
  }
  
  boolean canStartDownload(String paramString)
  {
    paramString = getTaskById(paramString);
    if (paramString != null) {}
    for (paramString = String.valueOf(paramString.content.ad_info.report_info.trace_info.aid);; paramString = null)
    {
      boolean bool = AdLifecycleManager.INSTANCE.isOnForeground();
      AdReporterForAnalysis.reportForAppPreOrderCanStartDownload(getContext(), this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, this.downloadingTaskCount, bool, paramString);
      if ((!this.messagesSynced30SecondsDelay) || (!this.onBackgroundAtFirstTime20SecondsDelay) || (AdNet.getType(getContext()) != 1) || (this.downloadingTaskCount >= 1) || (bool)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  Context getContext()
  {
    if (this.context != null) {
      return (Context)this.context.get();
    }
    return null;
  }
  
  public void init(Context paramContext, String paramString)
  {
    AdLog.i("AdAppPreOrderManager", String.format("init status:%d", new Object[] { Integer.valueOf(this.status) }));
    if (TextUtils.isEmpty(paramString)) {
      AdLog.e("AdAppPreOrderManager", "uin is null");
    }
    Context localContext;
    Boolean localBoolean;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.status != 0) || (paramContext == null));
        localContext = paramContext.getApplicationContext();
      } while (localContext == null);
      localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    } while ((localBoolean == null) || (!localBoolean.booleanValue()));
    this.context = new WeakReference(localContext);
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.11(this, paramContext, paramString), 5);
  }
  
  public boolean isAppPreOrderDownloadLaunched()
  {
    return this.downloadingTaskCount >= 1;
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1)
  {
    boolean bool = isReady();
    AdLog.i("AdAppPreOrderManager", String.format("onDownloadProgressUpdate ready:%b", new Object[] { Boolean.valueOf(bool) }));
    if ((paramList == null) || (paramList1 == null) || (paramList.isEmpty()) || (paramList1.isEmpty()) || (!bool)) {
      return;
    }
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.3(this, paramList1), 5);
  }
  
  public void onDownloadStatusChanged(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = isReady();
    AdLog.i("AdAppPreOrderManager", String.format("onDownloadStatusChanged ready:%b newStatus %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) }));
    if (!bool) {
      return;
    }
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.2(this, paramString, paramInt1, paramInt2), 5);
  }
  
  public void onMessagesSynced()
  {
    AdLog.i("AdAppPreOrderManager", String.format("onMessagesSynced messagesSynced:%b messagesSynced30SecondsDelay%b", new Object[] { Boolean.valueOf(this.messagesSynced), Boolean.valueOf(this.messagesSynced30SecondsDelay) }));
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.12(this), 5);
  }
  
  public void onQQReminderClicked(WeakReference<Activity> paramWeakReference, String paramString1, String paramString2, Bundle paramBundle, String paramString3)
  {
    boolean bool = isReady();
    AdLog.i("AdAppPreOrderManager", String.format("onQQReminderClicked taskId:%s reminderId:%s ready:%b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) }));
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.6(this, paramString1, paramWeakReference, paramString2, paramBundle, paramString3, bool), 5);
  }
  
  public void onQQReminderDisplayed(String paramString1, String paramString2)
  {
    boolean bool = isReady();
    AdLog.i("AdAppPreOrderManager", String.format("onQQReminderDisplayed taskId:%s reminderId:%s ready:%b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) }));
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.5(this, paramString1, paramString2, bool), 5);
  }
  
  public void onQQReminderSwitchStatusChagned()
  {
    boolean bool = isReady();
    AdLog.i("AdAppPreOrderManager", String.format("onQQReminderSwitchStatusChagned ready:%b", new Object[] { Boolean.valueOf(bool) }));
    if (!bool) {
      return;
    }
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.4(this), 5);
  }
  
  public void processPublishMessage(String paramString1, String paramString2, long paramLong)
  {
    int i = 0;
    AdReporterForAnalysis.reportForAppPreOrderTaskStatusChanged(getContext(), 1, 1, this.messagesSynced, this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, AdScreenStatusManager.getInstance().isScreenOn(), AdLifecycleManager.INSTANCE.isOnForeground(), null, 0);
    paramString2 = AdProcessManager.INSTANCE.isOnMainProcess();
    int j;
    if ((paramString2 == null) || (!paramString2.booleanValue()))
    {
      AdLog.e("AdAppPreOrderManager", "processPublishMessage error, not in main process");
      i = 20;
      AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.15(this, paramString1, paramLong), 5);
      paramString1 = getContext();
      if (i != 0) {
        break label164;
      }
      j = 2;
      label99:
      if (i != 0) {
        break label170;
      }
    }
    label164:
    label170:
    for (int k = 2;; k = -2147483648)
    {
      AdReporterForAnalysis.reportForAppPreOrderTaskStatusChanged(paramString1, j, k, this.messagesSynced, this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, AdScreenStatusManager.getInstance().isScreenOn(), AdLifecycleManager.INSTANCE.isOnForeground(), null, i);
      return;
      if (!TextUtils.isEmpty(paramString1)) {
        break;
      }
      AdLog.e("AdAppPreOrderManager", "processPublishMessage error, taskId is null");
      i = 4;
      break;
      j = 3;
      break label99;
    }
  }
  
  public void runTasks()
  {
    gdt_settings.Settings localSettings = AdSettingsUtil.INSTANCE.getSettingsCache(getContext());
    if (localSettings != null) {}
    for (long l = localSettings.settingsForAppPreOrder.intervalMillisOfRunningTasks; !beforeRunTasks(); l = 1000L) {
      return;
    }
    AdThreadManager.INSTANCE.postDelayed(new AdAppPreOrderManager.13(this), 5, l);
  }
  
  void setTaskFinishedAndCommit(String paramString, int paramInt)
  {
    AdLog.i("AdAppPreOrderManager", String.format("setTaskFinishedAndCommit taskId:%s newStatus:%d errorCode:%d", new Object[] { paramString, Integer.valueOf(-1), Integer.valueOf(paramInt) }));
    int i = this.cache.setTaskStatusAndCommit(paramString, -1, paramInt);
    if (i > 0) {
      onTaskStatusChanged(paramString, paramInt);
    }
    if (i == 1) {
      onTaskStageChanged(paramString);
    }
  }
  
  void setTaskStatus(String paramString, int paramInt)
  {
    AdLog.i("AdAppPreOrderManager", String.format("setTaskStatus taskId:%s newStatus:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.7(this, paramString, paramInt), 5);
  }
  
  void setTaskStatusAndCommit(String paramString, int paramInt)
  {
    AdLog.i("AdAppPreOrderManager", String.format("setTaskStatusAndCommit taskId:%s newStatus:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    paramInt = this.cache.setTaskStatusAndCommit(paramString, paramInt);
    if (paramInt > 0) {
      onTaskStatusChanged(paramString, -2147483648);
    }
    if (paramInt == 1) {
      onTaskStageChanged(paramString);
    }
  }
  
  void setTaskStatusAndCommit(String paramString, int paramInt1, int paramInt2)
  {
    AdLog.i("AdAppPreOrderManager", String.format("setTaskStatusAndCommit taskId:%s newStatus:%d errorCode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    paramInt1 = this.cache.setTaskStatusAndCommit(paramString, paramInt1, paramInt2);
    if (paramInt1 > 0) {
      onTaskStatusChanged(paramString, -2147483648);
    }
    if (paramInt1 == 1) {
      onTaskStageChanged(paramString);
    }
  }
  
  void setTaskStatusAndCommit(String paramString, int paramInt1, int paramInt2, int paramInt3, AdAppPreOrderTask.a[] paramArrayOfa)
  {
    AdLog.i("AdAppPreOrderManager", String.format("setTaskStatusAndCommit taskId:%s newStatus:%d", new Object[] { paramString, Integer.valueOf(paramInt1) }));
    paramInt1 = this.cache.setTaskStatusAndCommit(paramString, paramInt1, paramInt2, paramInt3, paramArrayOfa);
    if (paramInt1 > 0) {
      onTaskStatusChanged(paramString, -2147483648);
    }
    if (paramInt1 == 1) {
      onTaskStageChanged(paramString);
    }
  }
  
  void setTaskStatusAndCommit(String paramString, int paramInt, msg_content parammsg_content)
  {
    AdLog.i("AdAppPreOrderManager", String.format("setTaskStatusAndCommit taskId:%s newStatus:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    paramInt = this.cache.setTaskStatusAndCommit(paramString, paramInt, parammsg_content);
    if (paramInt > 0) {
      onTaskStatusChanged(paramString, -2147483648);
    }
    if (paramInt == 1) {
      onTaskStageChanged(paramString);
    }
  }
  
  void setTaskStatusAndCommit(String paramString, int paramInt, boolean paramBoolean)
  {
    AdLog.i("AdAppPreOrderManager", String.format("setTaskStatusAndCommit taskId:%s newStatus:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    paramInt = this.cache.setTaskStatusAndCommit(paramString, paramInt, paramBoolean);
    if (paramInt > 0) {
      onTaskStatusChanged(paramString, -2147483648);
    }
    if (paramInt == 1) {
      onTaskStageChanged(paramString);
    }
  }
  
  public void stopTasks(String paramString)
  {
    if (!isReady())
    {
      AdLog.e("AdAppPreOrderManager", "already stopped or not ready");
      return;
    }
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.14(this, paramString), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager
 * JD-Core Version:    0.7.0.1
 */