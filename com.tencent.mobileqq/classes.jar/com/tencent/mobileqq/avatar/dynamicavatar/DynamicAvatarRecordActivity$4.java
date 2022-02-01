package com.tencent.mobileqq.avatar.dynamicavatar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

class DynamicAvatarRecordActivity$4
  implements View.OnTouchListener
{
  DynamicAvatarRecordActivity$4(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.a.i) {
      return false;
    }
    int i;
    if ((paramView == this.a.I) || (paramView == this.a.K))
    {
      i = paramMotionEvent.getAction();
      if (i == 0) {
        break label165;
      }
      if ((i == 1) || (i == 3)) {}
    }
    else
    {
      return false;
    }
    if (this.a.e.b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("DynamicAvatarRecordActivity", 2, "ACTION_UP, current state is already preview!");
      }
      return true;
    }
    if (this.a.e != null) {
      this.a.e.m();
    }
    if (System.currentTimeMillis() - this.a.e.c < 500L)
    {
      this.a.e.b(false);
      this.a.e.h();
      DynamicAvatarRecordActivity.a(this.a);
      return true;
    }
    DynamicAvatarRecordActivity.b(this.a);
    return true;
    label165:
    this.a.n.setVisibility(4);
    this.a.B.setVisibility(4);
    this.a.C.setText("0\"");
    this.a.C.setVisibility(0);
    this.a.D.setVisibility(4);
    this.a.F.setVisibility(4);
    this.a.G.setVisibility(4);
    this.a.I.setVisibility(4);
    this.a.J.setVisibility(0);
    this.a.K.setVisibility(0);
    this.a.H.setVisibility(4);
    this.a.K.setProgress(0.0F);
    this.a.e.c = System.currentTimeMillis();
    this.a.e.i();
    if (this.a.d == 1) {
      i = 0;
    } else {
      i = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X8007106", "0X8007106", i, 0, "", "", "", "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.4
 * JD-Core Version:    0.7.0.1
 */