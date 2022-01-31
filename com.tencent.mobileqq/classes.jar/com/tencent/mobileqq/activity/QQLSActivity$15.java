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
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      if (QQLSActivity.a(this.this$0) == 0)
      {
        BaseApplicationImpl.getContext().registerReceiver(this.this$0.a, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "registerScreenListener real mScreenReceiver:" + this.this$0.a.hashCode() + "context :" + BaseApplicationImpl.getContext().hashCode());
        }
        QQLSActivity.a(this.this$0, 1);
      }
      QQLSActivity.a(this.this$0, AnimationUtils.loadAnimation(this.this$0, 2130772226));
      QQLSActivity.a(this.this$0).setFillAfter(true);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "registerScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("QQLSActivity", 2, "registerScreenListener:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.15
 * JD-Core Version:    0.7.0.1
 */