package com.tencent.mobileqq.activity;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QQIdentiferLegacy$1
  implements Runnable
{
  QQIdentiferLegacy$1(QQIdentiferLegacy paramQQIdentiferLegacy) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B307", "0X800B307", 0, 0, "", "", "", "");
      QQToast.a(this.this$0.getActivity(), 2131693238, 0).a();
      return;
    }
    QLog.d("QQIdentiferLegacy", 1, "mResLoadingRunnable null == activity || activity.isFinishing()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.1
 * JD-Core Version:    0.7.0.1
 */