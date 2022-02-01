package com.tencent.mobileqq.activity;

import android.content.IntentFilter;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$15
  implements Runnable
{
  QQLSActivity$15(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
      if (QQLSActivity.a(this.this$0) == 0)
      {
        BaseApplicationImpl.getContext().registerReceiver(this.this$0.a, (IntentFilter)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("registerScreenListener real mScreenReceiver:");
          ((StringBuilder)localObject).append(this.this$0.a.hashCode());
          ((StringBuilder)localObject).append("context :");
          ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().hashCode());
          QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
        }
        QQLSActivity.a(this.this$0, 1);
      }
      QQLSActivity.a(this.this$0, AnimationUtils.loadAnimation(this.this$0, 2130772274));
      QQLSActivity.a(this.this$0).setFillAfter(true);
      if (QLog.isColorLevel())
      {
        QLog.d("QQLSActivity", 2, "registerScreenListener");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registerScreenListener:");
        localStringBuilder.append(localException.toString());
        QLog.e("QQLSActivity", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.15
 * JD-Core Version:    0.7.0.1
 */