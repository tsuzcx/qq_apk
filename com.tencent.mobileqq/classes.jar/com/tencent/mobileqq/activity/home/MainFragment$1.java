package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.QBaseActivity;
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
    int i = GesturePWDUtils.getGesturePWDState(this.a.A.getApp(), this.a.A.getCurrentAccountUin());
    int j = GesturePWDUtils.getGesturePWDMode(this.a.A.getApp(), this.a.A.getCurrentAccountUin());
    if ((i == 2) && (j == 20))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mainactivity", 2, "gesturepwd manual move.");
      }
      this.a.C().startUnlockActivity();
      this.a.C().overridePendingTransition(2130772014, 2130772007);
      com.tencent.mobileqq.app.FrameFragment.o = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.1
 * JD-Core Version:    0.7.0.1
 */