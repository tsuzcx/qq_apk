package com.tencent.mobileqq.activity;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQLSActivity$22
  implements Runnable
{
  QQLSActivity$22(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    Object localObject1 = (ActivityManager)this.this$0.getSystemService("activity");
    try
    {
      localObject2 = ((ActivityManager)localObject1).getRunningTasks(1);
      localObject1 = AppSetting.c;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((ActivityManager.RunningTaskInfo)((List)localObject2).get(0)).topActivity.getClassName();
        boolean bool = QQLSActivity.e(this.this$0);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("qqlsActivity onpause by :");
          localStringBuilder.append((String)localObject2);
          QLog.d("QQLSActivity", 2, localStringBuilder.toString());
        }
        if ((((String)localObject2).equals("com.tencent.mobileqq.activity.GesturePWDUnlockActivity")) && (bool))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "qqlsActivity onpause by locking activity need to front");
          }
          if (QQLSActivity.a(this.this$0).hasMessages(10)) {
            QQLSActivity.a(this.this$0).removeMessages(10);
          }
          localObject2 = QQLSActivity.a(this.this$0).obtainMessage(10);
          if (((String)localObject1).equalsIgnoreCase("Xiaomi-2013022"))
          {
            QQLSActivity.a(this.this$0).sendMessageDelayed((Message)localObject2, 600L);
            return;
          }
          QQLSActivity.a(this.this$0).sendMessage((Message)localObject2);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("qqlsActivity MSG_SETTO_FRONT by locking activity not to front e=");
        ((StringBuilder)localObject2).append(localException);
        QLog.d("QQLSActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.22
 * JD-Core Version:    0.7.0.1
 */