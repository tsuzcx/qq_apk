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
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if ((this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetImageButton != null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(true);
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
      paramView = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity;
      paramView.j = true;
      if (this.jdField_a_of_type_Boolean)
      {
        if (paramView.jdField_b_of_type_Boolean) {
          paramView = "0X80043A3";
        } else {
          paramView = "0X80043B5";
        }
      }
      else if (paramView.jdField_b_of_type_Boolean) {
        paramView = "0X80043A9";
      } else {
        paramView = "0X80043AF";
      }
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), "", "");
      paramView = local1;
      continue;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
          paramView = "0X80043A2";
        } else {
          paramView = "0X80043B4";
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        paramView = "0X80043A8";
      } else {
        paramView = "0X80043AE";
      }
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), "", "");
      paramView = VideoInviteActivity.c(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity).getString(2131695662);
      continue;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
          paramView = "0X80043A1";
        } else {
          paramView = "0X80043B3";
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        paramView = "0X80043A7";
      } else {
        paramView = "0X80043AD";
      }
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), "", "");
      paramView = VideoInviteActivity.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity).getString(2131695663);
      continue;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
          paramView = "0X80043A0";
        } else {
          paramView = "0X80043B2";
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        paramView = "0X80043A6";
      } else {
        paramView = "0X80043AC";
      }
      ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i), "");
      paramView = VideoInviteActivity.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity).getString(2131695661);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(this.jdField_a_of_type_Long, true);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_e_of_type_JavaLangString, paramView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.j);
    if ((this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.j) && (QQUtils.a(VideoInviteActivity.d(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))))
    {
      paramView = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      local1 = new VideoInviteActivity.3.1(this);
      VideoInviteActivity localVideoInviteActivity = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity;
      long l;
      if (GesturePWDUtils.getJumpLock(localVideoInviteActivity, localVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
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