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
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
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
      if (this.status == 2)
      {
        this.status = 3;
        return false;
      }
      this.status = 2;
      return true;
    }
    finally {}
  }
  
  private AdAppPreOrderTask getTaskById(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      a locala = this.cache;
      if (locala != null) {
        return locala.getTaskById(paramString);
      }
    }
    return null;
  }
  
  private List<AdAppPreOrderTask> getTasksByUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      a locala = this.cache;
      if (locala != null) {
        return locala.getTasksByUrl(paramString);
      }
    }
    return null;
  }
  
  private boolean isReady()
  {
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      if (this.status == 0)
      {
        AdLog.e("AdAppPreOrderManager", "appendTask failed manager not ready!");
        return false;
      }
      return true;
    }
    AdLog.e("AdAppPreOrderManager", "not in main process");
    return false;
  }
  
  private void onTaskStageChanged(String paramString)
  {
    AdAppPreOrderTask localAdAppPreOrderTask = getTaskById(paramString);
    int i;
    if (localAdAppPreOrderTask != null) {
      i = localAdAppPreOrderTask.status;
    } else {
      i = -2147483648;
    }
    int j;
    if (localAdAppPreOrderTask != null) {
      j = localAdAppPreOrderTask.reportStage;
    } else {
      j = -2147483648;
    }
    AdLog.i("AdAppPreOrderManager", String.format("onTaskStageChanged taskId:%s status:%d reportStage:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) }));
    if ((localAdAppPreOrderTask != null) && (localAdAppPreOrderTask.content != null)) {
      paramString = String.valueOf(localAdAppPreOrderTask.content.ad_info.report_info.trace_info.aid);
    } else {
      paramString = null;
    }
    Context localContext = getContext();
    if (localAdAppPreOrderTask != null) {
      i = localAdAppPreOrderTask.status;
    } else {
      i = -2147483648;
    }
    if (localAdAppPreOrderTask != null) {
      j = localAdAppPreOrderTask.reportStage;
    } else {
      j = -2147483648;
    }
    AdAnalysisHelperForUtil.reportForAppPreOrderTaskReportStageStatusChanged(localContext, i, j, this.messagesSynced, this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, AdScreenStatusManager.getInstance().isScreenOn(), AdLifecycleManager.INSTANCE.isOnForeground(), paramString);
  }
  
  private void onTaskStatusChanged(String paramString, int paramInt)
  {
    runTasks();
    AdAppPreOrderTask localAdAppPreOrderTask = getTaskById(paramString);
    int i;
    if (localAdAppPreOrderTask != null) {
      i = localAdAppPreOrderTask.status;
    } else {
      i = -2147483648;
    }
    int j;
    if (localAdAppPreOrderTask != null) {
      j = localAdAppPreOrderTask.reportStage;
    } else {
      j = -2147483648;
    }
    AdLog.i("AdAppPreOrderManager", String.format("onTaskStatusChanged taskId:%s status:%d reportStage:%d errorCode:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) }));
    if ((localAdAppPreOrderTask != null) && (localAdAppPreOrderTask.content != null)) {
      paramString = String.valueOf(localAdAppPreOrderTask.content.ad_info.report_info.trace_info.aid);
    } else {
      paramString = null;
    }
    Context localContext = getContext();
    if (localAdAppPreOrderTask != null) {
      i = localAdAppPreOrderTask.status;
    } else {
      i = -2147483648;
    }
    if (localAdAppPreOrderTask != null) {
      j = localAdAppPreOrderTask.reportStage;
    } else {
      j = -2147483648;
    }
    AdAnalysisHelperForUtil.reportForAppPreOrderTaskStatusChanged(localContext, i, j, this.messagesSynced, this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, AdScreenStatusManager.getInstance().isScreenOn(), AdLifecycleManager.INSTANCE.isOnForeground(), paramString, paramInt);
  }
  
  private void pauseActiveDownloadTasks()
  {
    Object localObject = this.cache;
    if ((localObject != null) && (!((a)localObject).getQueue().isEmpty()))
    {
      localObject = this.cache.getQueue().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)((Iterator)localObject).next();
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
    if (localIAdDownloader != null)
    {
      IAdDownloader.Callback localCallback = this.downloadCallback;
      if (localCallback != null) {
        localIAdDownloader.registerListener(localCallback);
      }
    }
    AdScreenStatusManager.getInstance().registerListener(this.screenListener);
  }
  
  private void runTaskOnFileThread(AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    if (paramAdAppPreOrderTask == null) {
      return;
    }
    if (!paramAdAppPreOrderTask.isValid(getContext()))
    {
      setTaskFinishedAndCommit(paramAdAppPreOrderTask.taskId, 13);
      return;
    }
    AdLog.i("AdAppPreOrderManager", String.format("runTaskOnFileThread taskId:%s status%d ", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
    if ((paramAdAppPreOrderTask.status != 2) && (paramAdAppPreOrderTask.status != 5) && (paramAdAppPreOrderTask.status != 6) && (paramAdAppPreOrderTask.status != 4) && (paramAdAppPreOrderTask.status != 7) && (paramAdAppPreOrderTask.status != 8) && (paramAdAppPreOrderTask.status != 9) && (paramAdAppPreOrderTask.status != 11))
    {
      if ((paramAdAppPreOrderTask.status != 10) && ((paramAdAppPreOrderTask.status < 12) || (paramAdAppPreOrderTask.status > AdAppPreOrderTask.Status.QQREMINDER_END)))
      {
        if (paramAdAppPreOrderTask.status == 33) {
          return;
        }
        int i = paramAdAppPreOrderTask.status;
        return;
      }
      c.runTask(getContext(), paramAdAppPreOrderTask, this.reminderStatusChanged, this.netWorkStatusChanged);
      return;
    }
    b.runTask(getContext(), paramAdAppPreOrderTask, this.netWorkStatusChanged);
  }
  
  private void unRegisterListeners()
  {
    AdAccount.INSTANCE.removeAccountListener(this.accountListener);
    AdConnectivityManager.getInstance().unRegisterListener(this.connectivityListener);
    AdLifecycleManager.INSTANCE.unRegisterListener(this.lifecycleListener);
    IAdDownloader localIAdDownloader = AdDownloader.getDownloader();
    if (localIAdDownloader != null)
    {
      IAdDownloader.Callback localCallback = this.downloadCallback;
      if (localCallback != null) {
        localIAdDownloader.unregisterListener(localCallback);
      }
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
    if (paramString != null) {
      paramString = String.valueOf(paramString.content.ad_info.report_info.trace_info.aid);
    } else {
      paramString = null;
    }
    boolean bool = AdLifecycleManager.INSTANCE.isOnForeground();
    AdAnalysisHelperForUtil.reportForAppPreOrderCanStartDownload(getContext(), this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, this.downloadingTaskCount, bool, paramString);
    return (this.messagesSynced30SecondsDelay) && (this.onBackgroundAtFirstTime20SecondsDelay) && (AdNet.getType(getContext()) == 1) && (this.downloadingTaskCount < 1) && (!bool);
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
    if (TextUtils.isEmpty(paramString))
    {
      AdLog.e("AdAppPreOrderManager", "uin is null");
      return;
    }
    if (this.status != 0) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return;
    }
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    if (localBoolean != null)
    {
      if (!localBoolean.booleanValue()) {
        return;
      }
      this.context = new WeakReference(localContext);
      AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.11(this, paramContext, paramString), 5);
    }
  }
  
  public boolean isAppPreOrderDownloadLaunched()
  {
    return this.downloadingTaskCount >= 1;
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1)
  {
    boolean bool = isReady();
    AdLog.i("AdAppPreOrderManager", String.format("onDownloadProgressUpdate ready:%b", new Object[] { Boolean.valueOf(bool) }));
    if ((paramList != null) && (paramList1 != null) && (!paramList.isEmpty()) && (!paramList1.isEmpty()))
    {
      if (!bool) {
        return;
      }
      AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.3(this, paramList1), 5);
    }
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
    AdAnalysisHelperForUtil.reportForAppPreOrderTaskStatusChanged(getContext(), 1, 1, this.messagesSynced, this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, AdScreenStatusManager.getInstance().isScreenOn(), AdLifecycleManager.INSTANCE.isOnForeground(), null, 0);
    paramString2 = AdProcessManager.INSTANCE.isOnMainProcess();
    int i;
    if ((paramString2 != null) && (paramString2.booleanValue()))
    {
      if (TextUtils.isEmpty(paramString1))
      {
        AdLog.e("AdAppPreOrderManager", "processPublishMessage error, taskId is null");
        i = 4;
      }
      else
      {
        i = 0;
      }
    }
    else
    {
      AdLog.e("AdAppPreOrderManager", "processPublishMessage error, not in main process");
      i = 20;
    }
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.15(this, paramString1, paramLong), 5);
    paramString1 = getContext();
    int j;
    if (i == 0) {
      j = 2;
    } else {
      j = 3;
    }
    int k;
    if (i == 0) {
      k = 2;
    } else {
      k = -2147483648;
    }
    AdAnalysisHelperForUtil.reportForAppPreOrderTaskStatusChanged(paramString1, j, k, this.messagesSynced, this.messagesSynced30SecondsDelay, this.onBackgroundAtFirstTime20SecondsDelay, AdScreenStatusManager.getInstance().isScreenOn(), AdLifecycleManager.INSTANCE.isOnForeground(), null, i);
  }
  
  public void runTasks()
  {
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCache();
    long l;
    if (localSettings != null) {
      l = localSettings.settingsForAppPreOrder.intervalMillisOfRunningTasks;
    } else {
      l = 1000L;
    }
    if (!beforeRunTasks()) {
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