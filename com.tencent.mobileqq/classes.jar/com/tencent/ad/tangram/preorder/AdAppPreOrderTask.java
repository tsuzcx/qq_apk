package com.tencent.ad.tangram.preorder;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdTime;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAppPreOrder;
import com.tencent.ad.tangram.protocol.msg_content;
import com.tencent.ad.tangram.settings.AdSettingsUtil;

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
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool1 = true;
    if (paramInt1 == paramInt2) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return false;
                              if (paramInt2 == -1) {
                                return true;
                              }
                            } while (paramInt1 == 1);
                            if (paramInt1 == 2)
                            {
                              if (paramInt2 == 4) {}
                              for (;;)
                              {
                                return bool1;
                                bool1 = false;
                              }
                            }
                          } while (paramInt1 == 3);
                          if (paramInt1 != 4) {
                            break;
                          }
                        } while ((paramInt2 != 5) && (paramInt2 != 6));
                        return true;
                        if (paramInt1 == 5)
                        {
                          if (paramInt2 == 7) {}
                          for (bool1 = bool2;; bool1 = false) {
                            return bool1;
                          }
                        }
                        if (paramInt1 == 6)
                        {
                          if (paramInt2 == 4) {}
                          for (bool1 = bool3;; bool1 = false) {
                            return bool1;
                          }
                        }
                        if (paramInt1 != 7) {
                          break;
                        }
                      } while ((paramInt2 != 8) && (paramInt2 != 9) && (paramInt2 != 10) && (paramInt2 != 11));
                      return true;
                      if (paramInt1 != 8) {
                        break;
                      }
                    } while ((paramInt2 != 9) && (paramInt2 != 10) && (paramInt2 != 11));
                    return true;
                    if (paramInt1 != 9) {
                      break;
                    }
                  } while ((paramInt2 != 8) && (paramInt2 != 10) && (paramInt2 != 11));
                  return true;
                  if (paramInt1 != 10) {
                    break;
                  }
                } while ((paramInt2 != AdAppPreOrderTask.a.getStatus(0, 0)) && (paramInt2 != AdAppPreOrderTask.a.getStatus(3, 0)));
                return true;
                if (paramInt1 != 11) {
                  break;
                }
              } while ((paramInt2 != 10) && (paramInt2 != 9) && (paramInt2 != 7) && (paramInt2 != 8));
              return true;
            } while ((paramInt1 < 12) || (paramInt1 > AdAppPreOrderTask.Status.QQREMINDER_END));
            i = AdAppPreOrderTask.a.getIndex(paramInt1);
            paramInt1 = AdAppPreOrderTask.a.getStage(paramInt1);
            if (paramInt1 != 0) {
              break;
            }
          } while ((paramInt2 != AdAppPreOrderTask.a.getStatus(1, i)) && (paramInt2 != AdAppPreOrderTask.a.getStatus(2, i)));
          return true;
          if (paramInt1 == 1)
          {
            if (paramInt2 == AdAppPreOrderTask.a.getStatus(0, i)) {}
            for (bool1 = bool4;; bool1 = false) {
              return bool1;
            }
          }
          if (paramInt1 == 2)
          {
            if (paramInt2 == AdAppPreOrderTask.a.getStatus(3, i)) {}
            for (bool1 = bool5;; bool1 = false) {
              return bool1;
            }
          }
          if (paramInt1 != 3) {
            break;
          }
        } while ((paramInt2 != AdAppPreOrderTask.a.getStatus(0, i)) && (paramInt2 != AdAppPreOrderTask.a.getStatus(4, i)));
        return true;
        if (paramInt1 != 4) {
          break;
        }
      } while ((paramInt2 != AdAppPreOrderTask.a.getStatus(5, i)) && (paramInt2 != AdAppPreOrderTask.a.getStatus(0, i + 1)) && (paramInt2 != AdAppPreOrderTask.a.getStatus(3, i + 1)));
      return true;
      if (paramInt1 == 5)
      {
        if (paramInt2 == AdAppPreOrderTask.a.getStatus(6, i)) {}
        for (bool1 = bool6;; bool1 = false) {
          return bool1;
        }
      }
    } while (paramInt1 != 6);
    return false;
  }
  
  private static int getNewReportStage(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == -2147483648)
    {
      i = paramInt1;
      if (paramInt2 == 1) {
        i = 1;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return i;
                        if (paramInt1 != 1) {
                          break;
                        }
                        i = paramInt1;
                      } while (paramInt2 != 2);
                      return 2;
                      if (paramInt1 != 2) {
                        break;
                      }
                      i = paramInt1;
                    } while (paramInt2 != 3);
                    return 3;
                    if (paramInt1 != 3) {
                      break;
                    }
                    i = paramInt1;
                  } while (paramInt2 != 7);
                  return 4;
                  if (paramInt1 != 4) {
                    break;
                  }
                  i = paramInt1;
                } while (paramInt2 != 10);
                return 5;
                if (paramInt1 != 5) {
                  break;
                }
                i = paramInt1;
              } while (AdAppPreOrderTask.a.getStage(paramInt2) != 3);
              return 6;
              if (paramInt1 != 6) {
                break;
              }
              i = paramInt1;
            } while (AdAppPreOrderTask.a.getStage(paramInt2) != 4);
            return 7;
            if (paramInt1 != 7) {
              break;
            }
            i = paramInt1;
          } while (AdAppPreOrderTask.a.getStage(paramInt2) != 5);
          return 8;
          if (paramInt1 != 8) {
            break;
          }
          i = paramInt1;
        } while (AdAppPreOrderTask.a.getStage(paramInt2) != 6);
        return 9;
        if (paramInt1 != 9) {
          break;
        }
        i = paramInt1;
      } while (paramInt2 != 33);
      return 10;
      i = paramInt1;
    } while (paramInt1 != 10);
    return paramInt1;
  }
  
  private boolean isExpired(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext != null) {}
    for (long l = paramContext.settingsForAppPreOrder.validMillis; this.taskCraetedTimeMillis == -2147483648L; l = 604800000L) {
      return false;
    }
    if (AdTime.INSTANCE.getServerTimeMillis() - this.taskCraetedTimeMillis >= l) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean updateReportStage()
  {
    int i = this.reportStage;
    this.reportStage = getNewReportStage(i, this.status);
    return i == this.reportStage;
  }
  
  public AdAppPreOrderTask.a getQQReminder(int paramInt)
  {
    if (this.reminders == null) {}
    while ((paramInt < 0) || (paramInt > this.reminders.length - 1)) {
      return null;
    }
    return this.reminders[paramInt];
  }
  
  public int getQQReminderIndex(String paramString)
  {
    int j;
    if (this.reminders == null)
    {
      j = -2147483648;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.reminders.length) {
        break label65;
      }
      AdAppPreOrderTask.a locala = this.reminders[i];
      if ((locala != null) && (locala.isValid()))
      {
        j = i;
        if (TextUtils.equals(locala.id, paramString)) {
          break;
        }
      }
      i += 1;
    }
    label65:
    return -2147483648;
  }
  
  public int getQQRemindersSize()
  {
    if (this.reminders != null) {
      return this.reminders.length;
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
    int i = 0;
    boolean bool2 = canSetStatus(this.status, paramInt);
    if (bool2) {
      this.status = paramInt;
    }
    for (boolean bool1 = updateReportStage();; bool1 = false)
    {
      AdLog.i("AdAppPreOrderTask", String.format("setStatus statusChanged:%b reportStageChanged:%b taskId:%s oldStatus:%d newStatus:%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), this.taskId, Integer.valueOf(this.status), Integer.valueOf(paramInt) }));
      if (bool1) {
        paramInt = 1;
      }
      do
      {
        return paramInt;
        paramInt = i;
      } while (!bool2);
      return 1;
    }
  }
  
  public int setStatus(int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool2 = canSetStatus(this.status, paramInt1);
    if (bool2)
    {
      this.status = paramInt1;
      this.errorCode = paramInt2;
    }
    for (boolean bool1 = updateReportStage();; bool1 = false)
    {
      AdLog.i("AdAppPreOrderTask", String.format("setStatus statusChanged:%b reportStageChanged:%b taskId:%s oldStatus:%d newStatus:%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), this.taskId, Integer.valueOf(this.status), Integer.valueOf(paramInt1) }));
      if (bool1) {
        paramInt1 = 1;
      }
      do
      {
        return paramInt1;
        paramInt1 = i;
      } while (!bool2);
      return 1;
    }
  }
  
  public int setStatus(int paramInt, msg_content parammsg_content)
  {
    int i = 0;
    boolean bool2 = canSetStatus(this.status, paramInt);
    if (bool2)
    {
      this.status = paramInt;
      this.content = parammsg_content;
    }
    for (boolean bool1 = updateReportStage();; bool1 = false)
    {
      AdLog.i("AdAppPreOrderTask", String.format("setStatus statusChanged:%b reportStageChanged:%b taskId:%s oldStatus:%d newStatus:%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), this.taskId, Integer.valueOf(this.status), Integer.valueOf(paramInt) }));
      if (bool1) {
        paramInt = 1;
      }
      do
      {
        return paramInt;
        paramInt = i;
      } while (!bool2);
      return 1;
    }
  }
  
  public int setStatus(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    boolean bool = canSetStatus(this.status, paramInt);
    if (bool)
    {
      this.status = paramInt;
      this.isDownloadLaunched = paramBoolean;
    }
    for (paramBoolean = updateReportStage();; paramBoolean = false)
    {
      AdLog.i("AdAppPreOrderTask", String.format("setStatus statusChanged:%b reportStageChanged:%b taskId:%s oldStatus:%d newStatus:%d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), this.taskId, Integer.valueOf(this.status), Integer.valueOf(paramInt) }));
      if (paramBoolean) {
        paramInt = 1;
      }
      do
      {
        return paramInt;
        paramInt = i;
      } while (!bool);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderTask
 * JD-Core Version:    0.7.0.1
 */