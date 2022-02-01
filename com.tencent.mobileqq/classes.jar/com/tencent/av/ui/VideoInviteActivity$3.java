package com.tencent.av.ui;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VideoInviteActivity$3
  implements ActionSheet.OnButtonClickListener
{
  VideoInviteActivity$3(VideoInviteActivity paramVideoInviteActivity, ActionSheet paramActionSheet, boolean paramBoolean, long paramLong) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if ((this.d.B != null) && (this.d.C != null))
    {
      this.d.B.setEnabled(true);
      this.d.C.setEnabled(true);
    }
    VideoInviteActivity.3.1 local1 = null;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            paramView = local1;
          }
        }
      }
    }
    for (;;)
    {
      break;
      paramView = this.d;
      paramView.S = true;
      if (this.b)
      {
        if (paramView.g) {
          paramView = "0X80043A3";
        } else {
          paramView = "0X80043B5";
        }
      }
      else if (paramView.g) {
        paramView = "0X80043A9";
      } else {
        paramView = "0X80043AF";
      }
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.d.i), Integer.toString(this.d.K), "", "");
      paramView = local1;
      continue;
      if (this.b)
      {
        if (this.d.g) {
          paramView = "0X80043A2";
        } else {
          paramView = "0X80043B4";
        }
      }
      else if (this.d.g) {
        paramView = "0X80043A8";
      } else {
        paramView = "0X80043AE";
      }
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.d.i), Integer.toString(this.d.K), "", "");
      paramView = VideoInviteActivity.c(this.d).getString(2131893421);
      continue;
      if (this.b)
      {
        if (this.d.g) {
          paramView = "0X80043A1";
        } else {
          paramView = "0X80043B3";
        }
      }
      else if (this.d.g) {
        paramView = "0X80043A7";
      } else {
        paramView = "0X80043AD";
      }
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.d.i), Integer.toString(this.d.K), "", "");
      paramView = VideoInviteActivity.b(this.d).getString(2131893422);
      continue;
      if (this.b)
      {
        if (this.d.g) {
          paramView = "0X80043A0";
        } else {
          paramView = "0X80043B2";
        }
      }
      else if (this.d.g) {
        paramView = "0X80043A6";
      } else {
        paramView = "0X80043AC";
      }
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.d.i), Integer.toString(this.d.K), Integer.toString(this.d.M), "");
      paramView = VideoInviteActivity.a(this.d).getString(2131893420);
    }
    this.d.a(this.c, true);
    this.d.d().a(this.d.j, this.d.o, this.d.p, this.d.q, paramView, this.d.S);
    if ((this.d.S) && (QQUtils.a(VideoInviteActivity.d(this.d))))
    {
      paramView = this.d.H.a();
      local1 = new VideoInviteActivity.3.1(this);
      VideoInviteActivity localVideoInviteActivity = this.d;
      long l;
      if (GesturePWDUtils.getJumpLock(localVideoInviteActivity, localVideoInviteActivity.H.getCurrentAccountUin())) {
        l = 500L;
      } else {
        l = 0L;
      }
      paramView.postDelayed(local1, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.3
 * JD-Core Version:    0.7.0.1
 */