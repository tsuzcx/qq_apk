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
    VideoInviteActivity.3.1 local1;
    switch (paramInt)
    {
    default: 
      paramView = null;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(this.jdField_a_of_type_Long, true);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_e_of_type_JavaLangString, paramView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.j);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.j) && (QQUtils.a(VideoInviteActivity.d(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))))
      {
        paramView = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        local1 = new VideoInviteActivity.3.1(this);
        if (!GesturePWDUtils.getJumpLock(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
          break label630;
        }
      }
      break;
    }
    label630:
    for (long l = 500L;; l = 0L)
    {
      paramView.postDelayed(local1, l);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
        for (paramView = "0X80043A0";; paramView = "0X80043B2")
        {
          ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i), "");
          paramView = VideoInviteActivity.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity).getString(2131695647);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
      for (paramView = "0X80043A6";; paramView = "0X80043AC") {
        break;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
        for (paramView = "0X80043A1";; paramView = "0X80043B3")
        {
          ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), "", "");
          paramView = VideoInviteActivity.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity).getString(2131695649);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
      for (paramView = "0X80043A7";; paramView = "0X80043AD") {
        break;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
        for (paramView = "0X80043A2";; paramView = "0X80043B4")
        {
          ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), "", "");
          paramView = VideoInviteActivity.c(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity).getString(2131695648);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
      for (paramView = "0X80043A8";; paramView = "0X80043AE") {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.j = true;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
        for (paramView = "0X80043A3";; paramView = "0X80043B5")
        {
          ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), "", "");
          paramView = null;
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {}
      for (paramView = "0X80043A9";; paramView = "0X80043AF") {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.3
 * JD-Core Version:    0.7.0.1
 */