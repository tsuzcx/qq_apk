package com.tencent.ad.tangram.preorder;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdTime;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAppPreOrder;
import com.tencent.ad.tangram.protocol.msg_content;
import com.tencent.ad.tangram.settings.AdSettingsManager;

@Keep
public final class AdAppPreOrderTask
{
  public static final int NOTHING_CHANGED = 0;
  public static final int REPORT_STAGE_CHANGED = 1;
  public static final int STATUS_CHANGED = 1;
  private static final String TAG = "AdAppPreOrderTask";
  public msg_content content;
  public int errorCode = -2147483648;
  public boolean isDownloadLaunched = false;
  public int reminderRescheduleCount = 0;
  public int reminderSwichOnCount = 0;
  public AdAppPreOrderTask.a[] reminders = new AdAppPreOrderTask.a[0];
  public int reportStage = -2147483648;
  public int status = -2147483648;
  public long taskCraetedTimeMillis = -2147483648L;
  public String taskId;
  
  public AdAppPreOrderTask()
  {
    this.status = 2;
    this.reportStage = 2;
  }
  
  public AdAppPreOrderTask(String paramString)
  {
    this.taskId = paramString;
    this.status = 2;
    this.reportStage = 2;
  }
  
  private static boolean canSetStatus(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool12 = false;
    boolean bool13 = false;
    boolean bool14 = false;
    boolean bool15 = false;
    boolean bool1 = false;
    if (paramInt1 == paramInt2) {
      return false;
    }
    if (paramInt2 == -1) {
      return true;
    }
    if (paramInt1 == 1) {
      return false;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == 4) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 3) {
      return false;
    }
    if (paramInt1 == 4)
    {
      if (paramInt2 != 5)
      {
        bool1 = bool2;
        if (paramInt2 != 6) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 5)
    {
      bool1 = bool3;
      if (paramInt2 == 7) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 6)
    {
      bool1 = bool4;
      if (paramInt2 == 4) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 7)
    {
      if ((paramInt2 != 8) && (paramInt2 != 9) && (paramInt2 != 10))
      {
        bool1 = bool5;
        if (paramInt2 != 11) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 8)
    {
      if ((paramInt2 != 9) && (paramInt2 != 10))
      {
        bool1 = bool6;
        if (paramInt2 != 11) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 9)
    {
      if ((paramInt2 != 8) && (paramInt2 != 10))
      {
        bool1 = bool7;
        if (paramInt2 != 11) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 10)
    {
      if (paramInt2 != AdAppPreOrderTask.a.getStatus(0, 0))
      {
        bool1 = bool8;
        if (paramInt2 != AdAppPreOrderTask.a.getStatus(3, 0)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 11)
    {
      if ((paramInt2 != 10) && (paramInt2 != 9) && (paramInt2 != 7))
      {
        bool1 = bool9;
        if (paramInt2 != 8) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if ((paramInt1 >= 12) && (paramInt1 <= AdAppPreOrderTask.Status.QQREMINDER_END))
    {
      int i = AdAppPreOrderTask.a.getIndex(paramInt1);
      paramInt1 = AdAppPreOrderTask.a.getStage(paramInt1);
      if (paramInt1 == 0)
      {
        if (paramInt2 != AdAppPreOrderTask.a.getStatus(1, i))
        {
          bool1 = bool10;
          if (paramInt2 != AdAppPreOrderTask.a.getStatus(2, i)) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      if (paramInt1 == 1)
      {
        bool1 = bool11;
        if (paramInt2 == AdAppPreOrderTask.a.getStatus(0, i)) {
          bool1 = true;
        }
        return bool1;
      }
      if (paramInt1 == 2)
      {
        bool1 = bool12;
        if (paramInt2 == AdAppPreOrderTask.a.getStatus(3, i)) {
          bool1 = true;
        }
        return bool1;
      }
      if (paramInt1 == 3)
      {
        if (paramInt2 != AdAppPreOrderTask.a.getStatus(0, i))
        {
          bool1 = bool13;
          if (paramInt2 != AdAppPreOrderTask.a.getStatus(4, i)) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 != AdAppPreOrderTask.a.getStatus(5, i))
        {
          paramInt1 = i + 1;
          if (paramInt2 != AdAppPreOrderTask.a.getStatus(0, paramInt1))
          {
            bool1 = bool14;
            if (paramInt2 != AdAppPreOrderTask.a.getStatus(3, paramInt1)) {
              break label477;
            }
          }
        }
        bool1 = true;
        label477:
        return bool1;
      }
      if (paramInt1 == 5)
      {
        bool1 = bool15;
        if (paramInt2 == AdAppPreOrderTask.a.getStatus(6, i)) {
          bool1 = true;
        }
        return bool1;
      }
      if (paramInt1 != 6) {}
    }
    return false;
  }
  
  private static int getNewReportStage(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -2147483648)
    {
      if (paramInt2 == 1) {
        return 1;
      }
    }
    else if (paramInt1 == 1)
    {
      if (paramInt2 == 2) {
        return 2;
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 3) {
        return 3;
      }
    }
    else if (paramInt1 == 3)
    {
      if (paramInt2 == 7) {
        return 4;
      }
    }
    else if (paramInt1 == 4)
    {
      if (paramInt2 == 10) {
        return 5;
      }
    }
    else if (paramInt1 == 5)
    {
      if (AdAppPreOrderTask.a.getStage(paramInt2) == 3) {
        return 6;
      }
    }
    else if (paramInt1 == 6)
    {
      if (AdAppPreOrderTask.a.getStage(paramInt2) == 4) {
        return 7;
      }
    }
    else if (paramInt1 == 7)
    {
      if (AdAppPreOrderTask.a.getStage(paramInt2) == 5) {
        return 8;
      }
    }
    else if (paramInt1 == 8)
    {
      if (AdAppPreOrderTask.a.getStage(paramInt2) == 6) {
        return 9;
      }
    }
    else if (paramInt1 == 9)
    {
      if (paramInt2 == 33) {
        return 10;
      }
    }
    else if (paramInt1 != 10) {}
    return paramInt1;
  }
  
  private boolean isExpired(Context paramContext)
  {
    paramContext = AdSettingsManager.INSTANCE.getCache();
    long l1;
    if (paramContext != null) {
      l1 = paramContext.settingsForAppPreOrder.validMillis;
    } else {
      l1 = 604800000L;
    }
    long l2 = this.taskCraetedTimeMillis;
    boolean bool = false;
    if (l2 == -2147483648L) {
      return false;
    }
    if (AdTime.INSTANCE.getServerTimeMillis() - this.taskCraetedTimeMillis >= l1) {
      bool = true;
    }
    return bool;
  }
  
  private boolean updateReportStage()
  {
    int i = this.reportStage;
    this.reportStage = getNewReportStage(i, this.status);
    return i == this.reportStage;
  }
  
  public AdAppPreOrderTask.a getQQReminder(int paramInt)
  {
    AdAppPreOrderTask.a[] arrayOfa = this.reminders;
    if (arrayOfa == null) {
      return null;
    }
    if (paramInt >= 0)
    {
      if (paramInt > arrayOfa.length - 1) {
        return null;
      }
      return arrayOfa[paramInt];
    }
    return null;
  }
  
  public int getQQReminderIndex(String paramString)
  {
    if (this.reminders == null) {
      return -2147483648;
    }
    int i = 0;
    for (;;)
    {
      Object localObject = this.reminders;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if ((localObject != null) && (((AdAppPreOrderTask.a)localObject).isValid()) && (TextUtils.equals(((AdAppPreOrderTask.a)localObject).id, paramString))) {
        return i;
      }
      i += 1;
    }
    return -2147483648;
  }
  
  public int getQQRemindersSize()
  {
    AdAppPreOrderTask.a[] arrayOfa = this.reminders;
    if (arrayOfa != null) {
      return arrayOfa.length;
    }
    return 0;
  }
  
  public int getStatus(String paramString)
  {
    return this.status;
  }
  
  public boolean isValid(Context paramContext)
  {
    return (!TextUtils.isEmpty(this.taskId)) && (!isExpired(paramContext));
  }
  
  public int setStatus(int paramInt)
  {
    boolean bool2 = canSetStatus(this.status, paramInt);
    boolean bool1;
    if (bool2)
    {
      this.status = paramInt;
      bool1 = updateReportStage();
    }
    else
    {
      bool1 = false;
    }
    AdLog.i("AdAppPreOrderTask", String.format("setStatus statusChanged:%b reportStageChanged:%b taskId:%s oldStatus:%d newStatus:%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), this.taskId, Integer.valueOf(this.status), Integer.valueOf(paramInt) }));
    if (bool1) {
      return 1;
    }
    if (bool2) {
      return 1;
    }
    return 0;
  }
  
  public int setStatus(int paramInt1, int paramInt2)
  {
    boolean bool2 = canSetStatus(this.status, paramInt1);
    boolean bool1;
    if (bool2)
    {
      this.status = paramInt1;
      this.errorCode = paramInt2;
      bool1 = updateReportStage();
    }
    else
    {
      bool1 = false;
    }
    AdLog.i("AdAppPreOrderTask", String.format("setStatus statusChanged:%b reportStageChanged:%b taskId:%s oldStatus:%d newStatus:%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), this.taskId, Integer.valueOf(this.status), Integer.valueOf(paramInt1) }));
    if (bool1) {
      return 1;
    }
    if (bool2) {
      return 1;
    }
    return 0;
  }
  
  public int setStatus(int paramInt, msg_content parammsg_content)
  {
    boolean bool2 = canSetStatus(this.status, paramInt);
    boolean bool1;
    if (bool2)
    {
      this.status = paramInt;
      this.content = parammsg_content;
      bool1 = updateReportStage();
    }
    else
    {
      bool1 = false;
    }
    AdLog.i("AdAppPreOrderTask", String.format("setStatus statusChanged:%b reportStageChanged:%b taskId:%s oldStatus:%d newStatus:%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), this.taskId, Integer.valueOf(this.status), Integer.valueOf(paramInt) }));
    if (bool1) {
      return 1;
    }
    if (bool2) {
      return 1;
    }
    return 0;
  }
  
  public int setStatus(int paramInt, boolean paramBoolean)
  {
    boolean bool = canSetStatus(this.status, paramInt);
    if (bool)
    {
      this.status = paramInt;
      this.isDownloadLaunched = paramBoolean;
      paramBoolean = updateReportStage();
    }
    else
    {
      paramBoolean = false;
    }
    AdLog.i("AdAppPreOrderTask", String.format("setStatus statusChanged:%b reportStageChanged:%b taskId:%s oldStatus:%d newStatus:%d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), this.taskId, Integer.valueOf(this.status), Integer.valueOf(paramInt) }));
    if (paramBoolean) {
      return 1;
    }
    if (bool) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderTask
 * JD-Core Version:    0.7.0.1
 */