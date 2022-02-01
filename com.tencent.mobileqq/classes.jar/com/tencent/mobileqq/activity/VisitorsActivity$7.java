package com.tencent.mobileqq.activity;

import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.flutter.config.QFlutterDPC;
import com.tencent.mobileqq.profile.vote.LikeRankingUtil;
import com.tencent.mobileqq.statistics.ReportController;

class VisitorsActivity$7
  implements View.OnTouchListener
{
  VisitorsActivity$7(VisitorsActivity paramVisitorsActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.a.z.setAlpha(255);
          this.a.B.setAlpha(1.0F);
          this.a.A.setAlpha(255);
          return true;
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.a.z.setAlpha(255);
          this.a.B.setAlpha(1.0F);
          this.a.A.setAlpha(255);
        }
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
        LikeRankingUtil.a(this.a, QFlutterDPC.a().d());
        this.a.F.setVisibility(8);
        this.a.L.clearAnimation();
        paramView = this.a;
        paramView.M = 0;
        paramView.ar.removeCallbacks(this.a.N);
        return true;
      }
    }
    else if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.z.setAlpha(127);
      this.a.B.setAlpha(0.5F);
      this.a.A.setAlpha(127);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.7
 * JD-Core Version:    0.7.0.1
 */