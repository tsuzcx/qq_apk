package com.tencent.ad.tangram.preorder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdBuilder;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.downloader.IAdDownloader;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.net.AdTime;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAppPreOrder;
import com.tencent.ad.tangram.protocol.msg_content;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.statistics.b;
import com.tencent.ad.tangram.util.AdAppReceiver;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.ad.tangram.web.AdBrowser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

final class c
{
  private static final String TAG = "AdAppPreOrderManagerForQQReminder";
  
  private static AdClickUtil.Params build(WeakReference<Activity> paramWeakReference, AdAppPreOrderTask paramAdAppPreOrderTask, Bundle paramBundle, WeakReference<AdAppReceiver> paramWeakReference1)
  {
    AdClickUtil.Params localParams = new AdClickUtil.Params();
    localParams.activity = paramWeakReference;
    localParams.extrasForIntent = paramBundle;
    localParams.ad = AdBuilder.INSTANCE.build(paramAdAppPreOrderTask.content.ad_info);
    localParams.reportForClick = false;
    localParams.enableAutoDownload = true;
    localParams.appReceiver = paramWeakReference1;
    localParams.isAppPreOrderPublished = true;
    if (paramAdAppPreOrderTask != null) {}
    for (paramWeakReference = paramAdAppPreOrderTask.taskId;; paramWeakReference = null)
    {
      if (!TextUtils.isEmpty(paramWeakReference))
      {
        if (localParams.extrasForIntent == null) {
          localParams.extrasForIntent = new Bundle();
        }
        localParams.extrasForIntent.putString("APP_PREORDER_TASK_ID", paramWeakReference);
      }
      return localParams;
    }
  }
  
  private static AdClickUtil.Result click(WeakReference<Activity> paramWeakReference, AdAppPreOrderTask paramAdAppPreOrderTask, Bundle paramBundle, String paramString, WeakReference<AdAppReceiver> paramWeakReference1, boolean paramBoolean)
  {
    Context localContext;
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      localContext = ((Activity)paramWeakReference.get()).getApplicationContext();
      if (paramBoolean) {
        break label73;
      }
      label28:
      if (paramBoolean) {
        break label229;
      }
    }
    for (;;)
    {
      label33:
      AdLog.e("AdAppPreOrderManagerForQQReminder", "click handle error");
      paramAdAppPreOrderTask = new AdClickUtil.Result(AdBrowser.showWithoutAd(paramWeakReference, paramString, paramBundle), 1);
      paramAdAppPreOrderTask.urlType = 0;
      paramAdAppPreOrderTask.errorHandled = true;
      label73:
      label229:
      do
      {
        return paramAdAppPreOrderTask;
        localContext = null;
        break;
        if ((localContext == null) || (AdAppUtil.isInstalled(localContext, paramAdAppPreOrderTask.content.ad_info.app_info.app_package_name)) || (!AdDownloader.getDownloader().isPkgExist(localContext, paramAdAppPreOrderTask.content.ad_info.app_info.app_package_name, paramAdAppPreOrderTask.content.ad_info.app_info.pkg_url))) {
          break label28;
        }
        Object localObject = AdDownloader.getDownloader().getDownloadInfoByUrl(paramAdAppPreOrderTask.content.ad_info.app_info.pkg_url);
        if (localObject == null) {
          break label28;
        }
        paramWeakReference = build(paramWeakReference, paramAdAppPreOrderTask, paramBundle, paramWeakReference1);
        if (paramWeakReference1.get() != null)
        {
          ((AdAppReceiver)paramWeakReference1.get()).register(localContext);
          ((AdAppReceiver)paramWeakReference1.get()).observe(paramWeakReference);
        }
        AdDownloader.getDownloader().installDownload(localObject);
        return new AdClickUtil.Result(0, 11);
        if ((paramWeakReference1 != null) && (paramWeakReference1.get() != null)) {
          ((AdAppReceiver)paramWeakReference1.get()).register(localContext);
        }
        paramWeakReference1 = AdClickUtil.handle(build(paramWeakReference, paramAdAppPreOrderTask, paramBundle, paramWeakReference1));
        if (paramWeakReference1 == null) {
          break label33;
        }
        paramAdAppPreOrderTask = paramWeakReference1;
      } while (paramWeakReference1.action != 0);
    }
  }
  
  private static long getScheduleTimeMillis(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext != null) {}
    Date localDate;
    for (long l1 = paramContext.settingsForAppPreOrder.intervalMillisOfSchedulingReminder;; l1 = 300000L)
    {
      long l2 = AdTime.INSTANCE.getServerTimeMillis();
      paramContext = new Date(l2);
      localDate = new Date(paramContext.getYear(), paramContext.getMonth(), paramContext.getDate() + 1);
      if (localDate.getTime() - paramContext.getTime() < l1) {
        break;
      }
      return l2;
    }
    localDate.setMinutes(5);
    return localDate.getTime();
  }
  
  public static void onClicked(WeakReference<Activity> paramWeakReference, AdAppPreOrderTask paramAdAppPreOrderTask, String paramString1, Bundle paramBundle, String paramString2, WeakReference<AdAppReceiver> paramWeakReference1, boolean paramBoolean)
  {
    Context localContext;
    boolean bool;
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      localContext = ((Activity)paramWeakReference.get()).getApplicationContext();
      bool = false;
      if ((paramBoolean) && (paramAdAppPreOrderTask != null) && (paramAdAppPreOrderTask.isValid(localContext))) {
        break label171;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", "onClicked error");
      paramBoolean = bool;
      label55:
      paramString1 = click(paramWeakReference, paramAdAppPreOrderTask, paramBundle, paramString2, paramWeakReference1, paramBoolean);
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("onClicked actionId:%d errorCode:%d", new Object[] { Integer.valueOf(paramString1.action), Integer.valueOf(paramString1.getErrorCode()) }));
      paramWeakReference = AdBuilder.INSTANCE.build(paramAdAppPreOrderTask.content.ad_info);
      b.reportAsync(new WeakReference(localContext), paramWeakReference, 319);
      if (paramAdAppPreOrderTask == null) {
        break label619;
      }
    }
    label171:
    label619:
    for (paramWeakReference = String.valueOf(paramAdAppPreOrderTask.content.ad_info.report_info.trace_info.aid);; paramWeakReference = null)
    {
      AdReporterForAnalysis.reportForAppPreOrderClicked(localContext, paramWeakReference, paramString1);
      return;
      localContext = null;
      break;
      int j = paramAdAppPreOrderTask.getQQReminderIndex(paramString1);
      int k = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
      int i = AdAppPreOrderTask.a.getStage(paramAdAppPreOrderTask.status);
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("onClicked taskId:%s status:%d indexFromStatus:%d indexFromReminderId:%d stage:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      if ((paramAdAppPreOrderTask.status < 12) || (paramAdAppPreOrderTask.status > AdAppPreOrderTask.Status.QQREMINDER_END) || (j == -2147483648) || (j != k))
      {
        AdLog.e("AdAppPreOrderManagerForQQReminder", "onClicked error");
        paramBoolean = bool;
        break label55;
      }
      k = AdAppPreOrderTask.a.getStatus(4, j);
      int m = AdAppPreOrderTask.a.getStatus(5, j);
      j = AdAppPreOrderTask.a.getStatus(6, j);
      if (i == 0)
      {
        AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onClicked error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
        paramBoolean = bool;
        break label55;
      }
      if (i == 1)
      {
        AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onClicked error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
        paramBoolean = bool;
        break label55;
      }
      if (i == 2)
      {
        AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onClicked error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
        paramBoolean = bool;
        break label55;
      }
      if (i == 3)
      {
        AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, k);
        AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, m);
        AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, j);
        paramBoolean = true;
        break label55;
      }
      if (i == 4)
      {
        AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, m);
        AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, j);
        paramBoolean = true;
        break label55;
      }
      if (i == 5)
      {
        AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, j);
        paramBoolean = true;
        break label55;
      }
      if (i == 6)
      {
        paramBoolean = true;
        break label55;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onClicked error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
      paramBoolean = bool;
      break label55;
    }
  }
  
  public static void onDisplayed(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramAdAppPreOrderTask == null) || (!paramAdAppPreOrderTask.isValid(paramContext)))
    {
      AdLog.e("AdAppPreOrderManagerForQQReminder", "onDisplayed error");
      return;
    }
    int j = paramAdAppPreOrderTask.getQQReminderIndex(paramString);
    int k = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
    int i = AdAppPreOrderTask.a.getStage(paramAdAppPreOrderTask.status);
    AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("onDisplayed taskId:%s status:%d indexFromStatus:%d indexFromReminderId:%d stage:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
    if ((paramAdAppPreOrderTask.status < 12) || (paramAdAppPreOrderTask.status > AdAppPreOrderTask.Status.QQREMINDER_END) || (j == -2147483648) || (j != k))
    {
      AdLog.e("AdAppPreOrderManagerForQQReminder", "onDisplayed error");
      return;
    }
    k = AdAppPreOrderTask.a.getStatus(4, j);
    j = AdAppPreOrderTask.a.getStatus(5, j);
    if (i == 0) {}
    for (;;)
    {
      paramAdAppPreOrderTask = AdBuilder.INSTANCE.build(paramAdAppPreOrderTask.content.ad_info);
      b.reportAsync(new WeakReference(paramContext), paramAdAppPreOrderTask, 318);
      return;
      if ((i != 1) && (i != 2)) {
        if (i == 3)
        {
          AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, k);
          AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, j);
        }
        else if (i == 4)
        {
          AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, j);
        }
        else if ((i != 5) && (i != 6))
        {
          AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onDisplayed error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
        }
      }
    }
  }
  
  private static void reschedule(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, int paramInt)
  {
    Object localObject = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    long l;
    int i;
    if (localObject != null)
    {
      l = ((gdt_settings.Settings)localObject).settingsForAppPreOrder.intervalMillisOfReschedulingReminder;
      if (localObject == null) {
        break label75;
      }
      i = ((gdt_settings.Settings)localObject).settingsForAppPreOrder.maxCountOfReschedulingReminder;
      label38:
      localObject = paramAdAppPreOrderTask.getQQReminder(paramInt);
      if ((localObject != null) && (((AdAppPreOrderTask.a)localObject).isValid())) {
        break label80;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", "reschedule error, reminder is null or not valid");
    }
    label75:
    label80:
    while (l + ((AdAppPreOrderTask.a)localObject).scheduleTimeMillis >= AdTime.INSTANCE.getServerTimeMillis())
    {
      return;
      l = 3000L;
      break;
      i = 3;
      break label38;
    }
    if (paramAdAppPreOrderTask.reminderRescheduleCount >= i)
    {
      AdAppPreOrderManager.INSTANCE.setTaskFinishedAndCommit(paramAdAppPreOrderTask.taskId, 221);
      return;
    }
    AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("reschedule taskId:%s status:%d index:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(paramInt) }));
    AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, paramAdAppPreOrderTask.status, paramAdAppPreOrderTask.reminderSwichOnCount, paramAdAppPreOrderTask.reminderRescheduleCount + 1, paramAdAppPreOrderTask.reminders);
    schedule(paramContext, paramAdAppPreOrderTask, paramInt);
  }
  
  public static void runTask(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = AdAppPreOrderTask.a.getStage(paramAdAppPreOrderTask.status);
    AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("runTask taskId:%s status:%d stage:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(i) }));
    if (paramAdAppPreOrderTask.status == 10) {
      runTaskOnDownloadSuccess(paramContext, paramAdAppPreOrderTask);
    }
    do
    {
      do
      {
        return;
      } while ((paramAdAppPreOrderTask.status < 12) || (paramAdAppPreOrderTask.status > AdAppPreOrderTask.Status.QQREMINDER_END));
      if (i == 0)
      {
        runTaskOnSwichOnStart(paramContext, paramAdAppPreOrderTask, paramBoolean1);
        return;
      }
      if (i == 1)
      {
        runTaskOnSwichOnFailed(paramContext, paramAdAppPreOrderTask, paramBoolean2);
        return;
      }
      if (i == 2)
      {
        runTaskOnSwichOnSuccess(paramContext, paramAdAppPreOrderTask);
        return;
      }
      if (i == 3)
      {
        runTaskOnScheduled(paramContext, paramAdAppPreOrderTask);
        return;
      }
      if (i == 4)
      {
        runTaskOnNotified(paramContext, paramAdAppPreOrderTask);
        return;
      }
    } while (i == 5);
    if (i == 6)
    {
      runTaskOnClicked(paramContext, paramAdAppPreOrderTask);
      return;
    }
    AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("runTask error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
  }
  
  private static void runTaskOnClicked(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    if (!AdAppUtil.isInstalled(paramContext, paramAdAppPreOrderTask.content.ad_info.app_info.app_package_name)) {
      return;
    }
    AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, 33);
  }
  
  private static void runTaskOnDownloadSuccess(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    schedule(paramContext, paramAdAppPreOrderTask, 0);
  }
  
  private static void runTaskOnNotified(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    Object localObject1 = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    int i;
    int j;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((gdt_settings.Settings)localObject1).settingsForAppPreOrder.maxCountOfReminder;
      j = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
      localObject2 = paramAdAppPreOrderTask.getQQReminder(j);
      if ((j >= 0) && (localObject2 != null) && (((AdAppPreOrderTask.a)localObject2).isValid())) {
        break label69;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", "runTaskOnNoticed error, index < 0 or scheduleTimeMillis is null");
    }
    label69:
    do
    {
      return;
      i = 3;
      break;
      localObject1 = new Date(AdTime.INSTANCE.getServerTimeMillis());
      localObject1 = new Date(((Date)localObject1).getYear(), ((Date)localObject1).getMonth(), ((Date)localObject1).getDay());
      localObject2 = new Date(((AdAppPreOrderTask.a)localObject2).scheduleTimeMillis);
      localObject2 = new Date(((Date)localObject2).getYear(), ((Date)localObject2).getMonth(), ((Date)localObject2).getDay());
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("runTaskOnNotified taskId:%s status%d index%d currentDate:%s scheduleDate:%s", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(j), localObject1, localObject2 }));
    } while ((j == i - 1) || (((Date)localObject2).equals(localObject1)));
    if (((Date)localObject2).before((Date)localObject1))
    {
      schedule(paramContext, paramAdAppPreOrderTask, j + 1);
      return;
    }
    AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("runTaskOnNotified error taskId:%s status%d scheduleDate after currentDate ", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
  }
  
  private static void runTaskOnScheduled(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    int i = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
    int j = AdAppPreOrderTask.a.getStatus(4, i);
    AdAppPreOrderTask.a locala = paramAdAppPreOrderTask.getQQReminder(i);
    if ((i < 0) || (j < 0) || (locala == null) || (!locala.isValid()))
    {
      AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("runTaskOnScheduled failed taskId:%s status:%d index:%d statusNotified:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(i), Integer.valueOf(j) }));
      return;
    }
    boolean bool = AdQQReminderManager.INSTANCE.isQQReminderNotified(locala.id, paramAdAppPreOrderTask.taskId);
    AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("runTaskOnScheduled taskId:%s status:%d index:%d reminderId:%s notified:%b", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(i), locala.id, Boolean.valueOf(bool) }));
    if (bool)
    {
      AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, j);
      return;
    }
    reschedule(paramContext, paramAdAppPreOrderTask, i);
  }
  
  private static void runTaskOnSwichOnFailed(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, boolean paramBoolean)
  {
    if (paramBoolean) {
      swichOn(paramContext, paramAdAppPreOrderTask);
    }
  }
  
  private static void runTaskOnSwichOnStart(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    int j = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
    if (AdQQReminderManager.INSTANCE.isQQReminderSwichOn()) {}
    for (int i = 2;; i = 1)
    {
      i = AdAppPreOrderTask.a.getStatus(i, j);
      if ((j >= 0) && (i >= 0)) {
        break;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", "runTaskOnSwichOnStart error");
      return;
    }
    AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, i);
  }
  
  private static void runTaskOnSwichOnSuccess(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    schedule(paramContext, paramAdAppPreOrderTask, AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status));
  }
  
  private static void schedule(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, int paramInt)
  {
    if (paramInt < 0)
    {
      AdLog.e("AdAppPreOrderManagerForQQReminder", "schedule error, index < 0");
      return;
    }
    if (!AdAppPreOrderManager.INSTANCE.canScheduleQQReminder())
    {
      AdLog.e("AdAppPreOrderManagerForQQReminder", "schedule error, can not ScheduleQQReminder");
      return;
    }
    boolean bool = AdQQReminderManager.INSTANCE.isQQReminderSwichOn();
    AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("schedule taskId:%s status:%d index:%d switchOn:%b", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
    Object localObject;
    if (bool)
    {
      localObject = (AdAppPreOrderTask.a[])paramAdAppPreOrderTask.reminders.clone();
      if (paramInt <= paramAdAppPreOrderTask.getQQRemindersSize() - 1) {
        break label285;
      }
      AdAppPreOrderTask.a locala = new AdAppPreOrderTask.a();
      locala.id = AdQQReminderManager.INSTANCE.generateQQReminderId();
      localObject = new ArrayList(Arrays.asList((Object[])localObject));
      ((ArrayList)localObject).add(locala);
      localObject = (AdAppPreOrderTask.a[])((ArrayList)localObject).toArray(new AdAppPreOrderTask.a[0]);
    }
    label285:
    for (;;)
    {
      localObject[paramInt].scheduleTimeMillis = getScheduleTimeMillis(paramContext);
      if (!localObject[paramInt].isValid())
      {
        AdLog.e("AdAppPreOrderManagerForQQReminder", "schedule error, newReminder is not valid");
        return;
      }
      int i = AdAppPreOrderTask.a.getStatus(3, paramInt);
      AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, i, paramAdAppPreOrderTask.reminderSwichOnCount, paramAdAppPreOrderTask.reminderRescheduleCount, (AdAppPreOrderTask.a[])localObject);
      AdQQReminderManager.INSTANCE.scheduleQQReminder(localObject[paramInt].id, paramAdAppPreOrderTask.taskId, paramAdAppPreOrderTask.content.str_title, paramAdAppPreOrderTask.content.str_content, paramAdAppPreOrderTask.content.str_button_txt, paramAdAppPreOrderTask.content.str_img_url, localObject[paramInt].scheduleTimeMillis);
      return;
      swichOn(paramContext, paramAdAppPreOrderTask);
      return;
    }
  }
  
  private static void swichOn(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    gdt_settings.Settings localSettings = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    int i;
    int j;
    label38:
    int k;
    int m;
    if (localSettings != null)
    {
      i = localSettings.settingsForAppPreOrder.maxCountOfSwitchingOnReminder;
      j = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
      if (j == -2147483648) {
        break label127;
      }
      k = AdAppPreOrderTask.a.getStatus(0, j);
      m = AdAppPreOrderTask.a.getStatus(2, j);
      if ((j >= 0) && (k >= 0) && (m >= 0)) {
        break label132;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("swichOn failed taskId:%s status%d index%d statusSwitchOnStart:%d statusSwitchOnSuccess%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    label127:
    do
    {
      return;
      i = 3;
      break;
      j = 0;
      break label38;
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("swichOn taskId:%s status:%d index:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(j) }));
      if (AdQQReminderManager.INSTANCE.isQQReminderSwichOn())
      {
        AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, k);
        AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, m);
        return;
      }
      if (paramAdAppPreOrderTask.reminderSwichOnCount >= i)
      {
        AdAppPreOrderManager.INSTANCE.setTaskFinishedAndCommit(paramAdAppPreOrderTask.taskId, 220);
        return;
      }
    } while (!AdNet.isNetValid(paramContext));
    label132:
    AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, k, paramAdAppPreOrderTask.reminderSwichOnCount + 1, paramAdAppPreOrderTask.reminderRescheduleCount, paramAdAppPreOrderTask.reminders);
    AdQQReminderManager.INSTANCE.swichOnQQReminder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.c
 * JD-Core Version:    0.7.0.1
 */