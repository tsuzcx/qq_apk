package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$ToolbarAnimationListener
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int = 0;
  
  VideoControlUI$ToolbarAnimationListener(VideoControlUI paramVideoControlUI, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @TargetApi(11)
  public void onAnimationEnd(Animation paramAnimation)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramAnimation != null) && (2 == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h), Boolean.valueOf(false), Long.valueOf(paramAnimation.getDuration()) });
    }
    String str = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAnimationEnd, mToolBarType[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], animation[");
    localStringBuilder.append(paramAnimation);
    localStringBuilder.append("], mToolbarDisplay[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(4);
      }
      if (Build.VERSION.SDK_INT >= 19) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
      }
      TipsUtil.b(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
      paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      paramAnimation.y = 0;
      if (paramAnimation.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a();
        if (((paramAnimation.E == 2) || (paramAnimation.E == 1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().q()))
        {
          paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
          paramAnimation.a(l, 360 - paramAnimation.t);
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiQavPanel.setAlpha(1.0F);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_JavaLangString, 2, "onAnimationEnd, change member list ui to visible");
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      VideoControlUI.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, true);
      paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      paramAnimation.y = 5;
      if (paramAnimation.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramAnimation.E == 2) || (paramAnimation.E == 1)) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l, 0.0F);
        }
      }
    }
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    paramAnimation.l = false;
    paramAnimation.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    ((VideoControlUI)localObject).l = true;
    if ((((VideoControlUI)localObject).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramAnimation != null) && (2 == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h), Boolean.valueOf(true), Long.valueOf(paramAnimation.getDuration()) });
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("]onAnimationStart[");
    localStringBuilder.append(paramAnimation);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    VideoControlUI.a(paramAnimation, (int)(paramAnimation.jdField_a_of_type_AndroidViewAnimationAnimation.getDuration() / 5L));
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.y = 0;
    }
    else
    {
      paramAnimation = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      paramAnimation.y = 5;
      VideoControlUI.a(paramAnimation, false);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.ToolbarAnimationListener
 * JD-Core Version:    0.7.0.1
 */