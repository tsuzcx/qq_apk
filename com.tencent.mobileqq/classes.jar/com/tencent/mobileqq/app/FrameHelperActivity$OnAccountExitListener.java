package com.tencent.mobileqq.app;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.onlinestatus.AccountPanel.OnAccountExitListener;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

final class FrameHelperActivity$OnAccountExitListener
  implements AccountPanel.OnAccountExitListener
{
  private WeakReference<FrameHelperActivity> a;
  
  FrameHelperActivity$OnAccountExitListener(FrameHelperActivity paramFrameHelperActivity)
  {
    this.a = new WeakReference(paramFrameHelperActivity);
  }
  
  public void a()
  {
    FrameHelperActivity localFrameHelperActivity = (FrameHelperActivity)this.a.get();
    if (localFrameHelperActivity == null) {}
    FragmentActivity localFragmentActivity;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localFragmentActivity = localFrameHelperActivity.getActivity();
      } while ((localFragmentActivity == null) || (localFragmentActivity.getAppInterface() == null));
      localQQAppInterface = localFragmentActivity.app;
    } while ((PwdSetUtil.a(localQQAppInterface, localFragmentActivity)) || ((FrameHelperActivity.a(localFrameHelperActivity) != null) && (FrameHelperActivity.a(localFrameHelperActivity).isShowing())));
    FrameHelperActivity.a(localFrameHelperActivity, localQQAppInterface, localFragmentActivity);
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A00D", "0X800A00D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.OnAccountExitListener
 * JD-Core Version:    0.7.0.1
 */