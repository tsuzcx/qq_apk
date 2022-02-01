package com.tencent.mobileqq.activity.home;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class MainFragment$1
  implements QQTabWidget.onTabWidgetTouchMoveListener
{
  MainFragment$1(MainFragment paramMainFragment) {}
  
  public void a()
  {
    int i = GesturePWDUtils.getGesturePWDState(this.a.a.getApp(), this.a.a.getCurrentAccountUin());
    int j = GesturePWDUtils.getGesturePWDMode(this.a.a.getApp(), this.a.a.getCurrentAccountUin());
    if ((i == 2) && (j == 20))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mainactivity", 2, "gesturepwd manual move.");
      }
      this.a.getActivity().startUnlockActivity();
      this.a.getActivity().overridePendingTransition(2130771999, 2130771992);
      com.tencent.mobileqq.app.FrameFragment.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.1
 * JD-Core Version:    0.7.0.1
 */