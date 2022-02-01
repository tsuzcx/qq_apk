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
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
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
    if (paramAdAppPreOrderTask != null) {
      paramWeakReference = paramAdAppPreOrderTask.taskId;
    } else {
      paramWeakReference = null;
    }
    if (!TextUtils.isEmpty(paramWeakReference))
    {
      if (localParams.extrasForIntent == null) {
        localParams.extrasForIntent = new Bundle();
      }
      localParams.extrasForIntent.putString("APP_PREORDER_TASK_ID", paramWeakReference);
    }
    return localParams;
  }
  
  private static AdClickUtil.Result click(WeakReference<Activity> paramWeakReference, AdAppPreOrderTask paramAdAppPreOrderTask, Bundle paramBundle, String paramString, WeakReference<AdAppReceiver> paramWeakReference1, boolean paramBoolean)
  {
    Context localContext;
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      localContext = ((Activity)paramWeakReference.get()).getApplicationContext();
    } else {
      localContext = null;
    }
    Object localObject;
    if ((paramBoolean) && (localContext != null) && (!AdAppUtil.isInstalled(localContext, paramAdAppPreOrderTask.content.ad_info.app_info.app_package_name)) && (AdDownloader.getDownloader().isPkgExist(localContext, paramAdAppPreOrderTask.content.ad_info.app_info.app_package_name, paramAdAppPreOrderTask.content.ad_info.app_info.pkg_url)))
    {
      localObject = AdDownloader.getDownloader().getDownloadInfoByUrl(paramAdAppPreOrderTask.content.ad_info.app_info.pkg_url);
      if (localObject != null) {}
    }
    else
    {
      if (paramBoolean)
      {
        if ((paramWeakReference1 != null) && (paramWeakReference1.get() != null)) {
          ((AdAppReceiver)paramWeakReference1.get()).register(localContext);
        }
        paramAdAppPreOrderTask = AdClickUtil.handle(build(paramWeakReference, paramAdAppPreOrderTask, paramBundle, paramWeakReference1));
        if ((paramAdAppPreOrderTask != null) && (paramAdAppPreOrderTask.action != 0)) {
          return paramAdAppPreOrderTask;
        }
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", "click handle error");
      paramWeakReference = new AdClickUtil.Result(AdBrowser.showWithoutAd(paramWeakReference, paramString, paramBundle), 1);
      paramWeakReference.urlType = 0;
      paramWeakReference.errorHandled = true;
      return paramWeakReference;
    }
    paramWeakReference = build(paramWeakReference, paramAdAppPreOrderTask, paramBundle, paramWeakReference1);
    if (paramWeakReference1.get() != null)
    {
      ((AdAppReceiver)paramWeakReference1.get()).register(localContext);
      ((AdAppReceiver)paramWeakReference1.get()).observe(paramWeakReference);
    }
    AdDownloader.getDownloader().installDownload(localObject);
    return new AdClickUtil.Result(0, 11);
  }
  
  private static long getScheduleTimeMillis(Context paramContext)
  {
    paramContext = AdSettingsManager.INSTANCE.getCache();
    long l1;
    if (paramContext != null) {
      l1 = paramContext.settingsForAppPreOrder.intervalMillisOfSchedulingReminder;
    } else {
      l1 = 300000L;
    }
    long l2 = AdTime.INSTANCE.getServerTimeMillis();
    paramContext = new Date(l2);
    Date localDate = new Date(paramContext.getYear(), paramContext.getMonth(), paramContext.getDate() + 1);
    if (localDate.getTime() - paramContext.getTime() >= l1) {
      return l2;
    }
    localDate.setMinutes(5);
    return localDate.getTime();
  }
  
  public static void onClicked(WeakReference<Activity> paramWeakReference, AdAppPreOrderTask paramAdAppPreOrderTask, String paramString1, Bundle paramBundle, String paramString2, WeakReference<AdAppReceiver> paramWeakReference1, boolean paramBoolean)
  {
    Object localObject = null;
    Context localContext;
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      localContext = ((Activity)paramWeakReference.get()).getApplicationContext();
    } else {
      localContext = null;
    }
    if ((paramBoolean) && (paramAdAppPreOrderTask != null) && (paramAdAppPreOrderTask.isValid(localContext)))
    {
      int j = paramAdAppPreOrderTask.getQQReminderIndex(paramString1);
      int k = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
      int i = AdAppPreOrderTask.a.getStage(paramAdAppPreOrderTask.status);
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("onClicked taskId:%s status:%d indexFromStatus:%d indexFromReminderId:%d stage:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      if ((paramAdAppPreOrderTask.status >= 12) && (paramAdAppPreOrderTask.status <= AdAppPreOrderTask.Status.QQREMINDER_END) && (j != -2147483648) && (j == k))
      {
        k = AdAppPreOrderTask.a.getStatus(4, j);
        int m = AdAppPreOrderTask.a.getStatus(5, j);
        j = AdAppPreOrderTask.a.getStatus(6, j);
        if (i == 0)
        {
          AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onClicked error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
        }
        else if (i == 1)
        {
          AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onClicked error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
        }
        else if (i == 2)
        {
          AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onClicked error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
        }
        else
        {
          if (i == 3)
          {
            AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, k);
            AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, m);
            AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, j);
          }
          do
          {
            for (;;)
            {
              paramBoolean = true;
              break label487;
              if (i == 4)
              {
                AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, m);
                AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, j);
              }
              else
              {
                if (i != 5) {
                  break;
                }
                AdAppPreOrderManager.INSTANCE.setTaskStatus(paramAdAppPreOrderTask.taskId, j);
              }
            }
          } while (i == 6);
          AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("onClicked error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
        }
      }
      else
      {
        AdLog.e("AdAppPreOrderManagerForQQReminder", "onClicked error");
      }
    }
    else
    {
      AdLog.e("AdAppPreOrderManagerForQQReminder", "onClicked error");
    }
    paramBoolean = false;
    label487:
    paramString1 = click(paramWeakReference, paramAdAppPreOrderTask, paramBundle, paramString2, paramWeakReference1, paramBoolean);
    AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("onClicked actionId:%d errorCode:%d", new Object[] { Integer.valueOf(paramString1.action), Integer.valueOf(paramString1.getErrorCode()) }));
    paramWeakReference = AdBuilder.INSTANCE.build(paramAdAppPreOrderTask.content.ad_info);
    com.tencent.ad.tangram.statistics.c.reportAsync(new WeakReference(localContext), paramWeakReference, 319);
    paramWeakReference = localObject;
    if (paramAdAppPreOrderTask != null) {
      paramWeakReference = String.valueOf(paramAdAppPreOrderTask.content.ad_info.report_info.trace_info.aid);
    }
    AdAnalysisHelperForUtil.reportForAppPreOrderClicked(localContext, paramWeakReference, paramString1);
  }
  
  public static void onDisplayed(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramAdAppPreOrderTask != null) && (paramAdAppPreOrderTask.isValid(paramContext)))
    {
      int j = paramAdAppPreOrderTask.getQQReminderIndex(paramString);
      int k = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
      int i = AdAppPreOrderTask.a.getStage(paramAdAppPreOrderTask.status);
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("onDisplayed taskId:%s status:%d indexFromStatus:%d indexFromReminderId:%d stage:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      if ((paramAdAppPreOrderTask.status >= 12) && (paramAdAppPreOrderTask.status <= AdAppPreOrderTask.Status.QQREMINDER_END) && (j != -2147483648) && (j == k))
      {
        k = AdAppPreOrderTask.a.getStatus(4, j);
        j = AdAppPreOrderTask.a.getStatus(5, j);
        if ((i != 0) && (i != 1) && (i != 2)) {
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
        paramAdAppPreOrderTask = AdBuilder.INSTANCE.build(paramAdAppPreOrderTask.content.ad_info);
        com.tencent.ad.tangram.statistics.c.reportAsync(new WeakReference(paramContext), paramAdAppPreOrderTask, 318);
        return;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", "onDisplayed error");
      return;
    }
    AdLog.e("AdAppPreOrderManagerForQQReminder", "onDisplayed error");
  }
  
  private static void reschedule(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, int paramInt)
  {
    Object localObject = AdSettingsManager.INSTANCE.getCache();
    long l;
    if (localObject != null) {
      l = ((gdt_settings.Settings)localObject).settingsForAppPreOrder.intervalMillisOfReschedulingReminder;
    } else {
      l = 3000L;
    }
    int i;
    if (localObject != null) {
      i = ((gdt_settings.Settings)localObject).settingsForAppPreOrder.maxCountOfReschedulingReminder;
    } else {
      i = 3;
    }
    localObject = paramAdAppPreOrderTask.getQQReminder(paramInt);
    if ((localObject != null) && (((AdAppPreOrderTask.a)localObject).isValid()))
    {
      if (((AdAppPreOrderTask.a)localObject).scheduleTimeMillis + l >= AdTime.INSTANCE.getServerTimeMillis()) {
        return;
      }
      if (paramAdAppPreOrderTask.reminderRescheduleCount >= i)
      {
        AdAppPreOrderManager.INSTANCE.setTaskFinishedAndCommit(paramAdAppPreOrderTask.taskId, 221);
        return;
      }
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("reschedule taskId:%s status:%d index:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(paramInt) }));
      AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, paramAdAppPreOrderTask.status, paramAdAppPreOrderTask.reminderSwichOnCount, paramAdAppPreOrderTask.reminderRescheduleCount + 1, paramAdAppPreOrderTask.reminders);
      schedule(paramContext, paramAdAppPreOrderTask, paramInt);
      return;
    }
    AdLog.e("AdAppPreOrderManagerForQQReminder", "reschedule error, reminder is null or not valid");
  }
  
  public static void runTask(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = AdAppPreOrderTask.a.getStage(paramAdAppPreOrderTask.status);
    AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("runTask taskId:%s status:%d stage:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(i) }));
    if (paramAdAppPreOrderTask.status == 10)
    {
      runTaskOnDownloadSuccess(paramContext, paramAdAppPreOrderTask);
      return;
    }
    if ((paramAdAppPreOrderTask.status >= 12) && (paramAdAppPreOrderTask.status <= AdAppPreOrderTask.Status.QQREMINDER_END))
    {
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
      if (i == 5) {
        return;
      }
      if (i == 6)
      {
        runTaskOnClicked(paramContext, paramAdAppPreOrderTask);
        return;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("runTask error taskId:%s status%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
    }
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
    Object localObject1 = AdSettingsManager.INSTANCE.getCache();
    int i;
    if (localObject1 != null) {
      i = ((gdt_settings.Settings)localObject1).settingsForAppPreOrder.maxCountOfReminder;
    } else {
      i = 3;
    }
    int j = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
    Object localObject2 = paramAdAppPreOrderTask.getQQReminder(j);
    if ((j >= 0) && (localObject2 != null) && (((AdAppPreOrderTask.a)localObject2).isValid()))
    {
      localObject1 = new Date(AdTime.INSTANCE.getServerTimeMillis());
      localObject1 = new Date(((Date)localObject1).getYear(), ((Date)localObject1).getMonth(), ((Date)localObject1).getDay());
      localObject2 = new Date(((AdAppPreOrderTask.a)localObject2).scheduleTimeMillis);
      localObject2 = new Date(((Date)localObject2).getYear(), ((Date)localObject2).getMonth(), ((Date)localObject2).getDay());
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("runTaskOnNotified taskId:%s status%d index%d currentDate:%s scheduleDate:%s", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(j), localObject1, localObject2 }));
      if (j == i - 1) {
        return;
      }
      if (((Date)localObject2).equals(localObject1)) {
        return;
      }
      if (((Date)localObject2).before((Date)localObject1))
      {
        schedule(paramContext, paramAdAppPreOrderTask, j + 1);
        return;
      }
      AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("runTaskOnNotified error taskId:%s status%d scheduleDate after currentDate ", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
      return;
    }
    AdLog.e("AdAppPreOrderManagerForQQReminder", "runTaskOnNoticed error, index < 0 or scheduleTimeMillis is null");
  }
  
  private static void runTaskOnScheduled(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    int i = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
    int j = AdAppPreOrderTask.a.getStatus(4, i);
    AdAppPreOrderTask.a locala = paramAdAppPreOrderTask.getQQReminder(i);
    if ((i >= 0) && (j >= 0) && (locala != null) && (locala.isValid()))
    {
      boolean bool = AdQQReminderManager.INSTANCE.isQQReminderNotified(locala.id, paramAdAppPreOrderTask.taskId);
      AdLog.i("AdAppPreOrderManagerForQQReminder", String.format("runTaskOnScheduled taskId:%s status:%d index:%d reminderId:%s notified:%b", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(i), locala.id, Boolean.valueOf(bool) }));
      if (bool)
      {
        AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, j);
        return;
      }
      reschedule(paramContext, paramAdAppPreOrderTask, i);
      return;
    }
    AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("runTaskOnScheduled failed taskId:%s status:%d index:%d statusNotified:%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(i), Integer.valueOf(j) }));
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
    if (AdQQReminderManager.INSTANCE.isQQReminderSwichOn()) {
      i = 2;
    } else {
      i = 1;
    }
    int i = AdAppPreOrderTask.a.getStatus(i, j);
    if ((j >= 0) && (i >= 0))
    {
      AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, i);
      return;
    }
    AdLog.e("AdAppPreOrderManagerForQQReminder", "runTaskOnSwichOnStart error");
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
    if (bool)
    {
      Object localObject2 = (AdAppPreOrderTask.a[])paramAdAppPreOrderTask.reminders.clone();
      Object localObject1 = localObject2;
      if (paramInt > paramAdAppPreOrderTask.getQQRemindersSize() - 1)
      {
        localObject1 = new AdAppPreOrderTask.a();
        ((AdAppPreOrderTask.a)localObject1).id = AdQQReminderManager.INSTANCE.generateQQReminderId();
        localObject2 = new ArrayList(Arrays.asList((Object[])localObject2));
        ((ArrayList)localObject2).add(localObject1);
        localObject1 = (AdAppPreOrderTask.a[])((ArrayList)localObject2).toArray(new AdAppPreOrderTask.a[0]);
      }
      localObject1[paramInt].scheduleTimeMillis = getScheduleTimeMillis(paramContext);
      if (!localObject1[paramInt].isValid())
      {
        AdLog.e("AdAppPreOrderManagerForQQReminder", "schedule error, newReminder is not valid");
        return;
      }
      int i = AdAppPreOrderTask.a.getStatus(3, paramInt);
      AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, i, paramAdAppPreOrderTask.reminderSwichOnCount, paramAdAppPreOrderTask.reminderRescheduleCount, (AdAppPreOrderTask.a[])localObject1);
      AdQQReminderManager.INSTANCE.scheduleQQReminder(localObject1[paramInt].id, paramAdAppPreOrderTask.taskId, paramAdAppPreOrderTask.content.str_title, paramAdAppPreOrderTask.content.str_content, paramAdAppPreOrderTask.content.str_button_txt, paramAdAppPreOrderTask.content.str_img_url, localObject1[paramInt].scheduleTimeMillis);
      return;
    }
    swichOn(paramContext, paramAdAppPreOrderTask);
  }
  
  private static void swichOn(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCache();
    int i;
    if (localSettings != null) {
      i = localSettings.settingsForAppPreOrder.maxCountOfSwitchingOnReminder;
    } else {
      i = 3;
    }
    int j = AdAppPreOrderTask.a.getIndex(paramAdAppPreOrderTask.status);
    if (j == -2147483648) {
      j = 0;
    }
    int k = AdAppPreOrderTask.a.getStatus(0, j);
    int m = AdAppPreOrderTask.a.getStatus(2, j);
    if ((j >= 0) && (k >= 0) && (m >= 0))
    {
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
      if (AdNet.isNetValid(paramContext))
      {
        AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, k, 1 + paramAdAppPreOrderTask.reminderSwichOnCount, paramAdAppPreOrderTask.reminderRescheduleCount, paramAdAppPreOrderTask.reminders);
        AdQQReminderManager.INSTANCE.swichOnQQReminder();
      }
      return;
    }
    AdLog.e("AdAppPreOrderManagerForQQReminder", String.format("swichOn failed taskId:%s status%d index%d statusSwitchOnStart:%d statusSwitchOnSuccess%d", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.c
 * JD-Core Version:    0.7.0.1
 */