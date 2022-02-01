package com.tencent.mobileqq.activity.framebusiness;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig.INotifyTabRefresh;
import com.tencent.qphone.base.util.QLog;

final class QCircleInjectImpl$7
  implements QCircleThirdTabConfig.INotifyTabRefresh
{
  public void a(MainFragment paramMainFragment)
  {
    if ((paramMainFragment != null) && (paramMainFragment.getActivity() == null))
    {
      QLog.d("TabFrameControllerImplBusiness", 1, "MainFragment is empty");
      return;
    }
    paramMainFragment.getActivity().runOnUiThread(new QCircleInjectImpl.7.1(this, paramMainFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.7
 * JD-Core Version:    0.7.0.1
 */