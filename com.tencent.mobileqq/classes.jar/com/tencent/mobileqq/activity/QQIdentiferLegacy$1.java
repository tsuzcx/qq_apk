package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QQIdentiferLegacy$1
  implements Runnable
{
  QQIdentiferLegacy$1(QQIdentiferLegacy paramQQIdentiferLegacy) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()))
    {
      QLog.d("QQIdentiferLegacy", 1, "mResLoadingRunnable null == activity || activity.isFinishing()");
      return;
    }
    ForwardUtils.a(null, "0X800B307", new String[0]);
    QQToast.a(this.this$0.getActivity(), 2131693284, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.1
 * JD-Core Version:    0.7.0.1
 */