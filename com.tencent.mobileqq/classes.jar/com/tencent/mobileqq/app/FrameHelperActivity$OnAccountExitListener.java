package com.tencent.mobileqq.app;

import android.app.Dialog;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.onlinestatus.IAccountPanel.OnAccountExitListener;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

final class FrameHelperActivity$OnAccountExitListener
  implements IAccountPanel.OnAccountExitListener
{
  private WeakReference<FrameHelperActivity> a;
  
  FrameHelperActivity$OnAccountExitListener(FrameHelperActivity paramFrameHelperActivity)
  {
    this.a = new WeakReference(paramFrameHelperActivity);
  }
  
  public void a()
  {
    FrameHelperActivity localFrameHelperActivity = (FrameHelperActivity)this.a.get();
    if (localFrameHelperActivity == null) {
      return;
    }
    QBaseActivity localQBaseActivity = localFrameHelperActivity.a();
    if (localQBaseActivity != null)
    {
      if (localQBaseActivity.getAppRuntime() == null) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)localQBaseActivity.getAppRuntime();
      if (PwdSetUtil.a(localQQAppInterface, localQBaseActivity)) {
        return;
      }
      if ((FrameHelperActivity.a(localFrameHelperActivity) != null) && (FrameHelperActivity.a(localFrameHelperActivity).isShowing())) {
        return;
      }
      FrameHelperActivity.a(localFrameHelperActivity, localQQAppInterface, localQBaseActivity);
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A00D", "0X800A00D", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.OnAccountExitListener
 * JD-Core Version:    0.7.0.1
 */