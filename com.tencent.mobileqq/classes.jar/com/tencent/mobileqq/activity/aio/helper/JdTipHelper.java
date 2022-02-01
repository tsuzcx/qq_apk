package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class JdTipHelper
  implements Handler.Callback, ILifeCycleHelper
{
  int jdField_a_of_type_Int = DisplayUtil.a(BaseApplicationImpl.getContext(), 50.0F);
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new JdTipHelper.1(this);
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  int jdField_b_of_type_Int = DisplayUtil.a(BaseApplicationImpl.getContext(), 30.0F);
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  Animation c;
  
  public JdTipHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return;
      }
      int i = this.jdField_a_of_type_Int;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.addRule(11);
      Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      i = 2131379149;
      localObject = ((RelativeLayout)localObject).findViewById(2131379149);
      View localView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379143);
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        i = -1;
      }
      int j = i;
      if (localView != null)
      {
        j = i;
        if (localView.getVisibility() == 0) {
          j = 2131379143;
        }
      }
      i = this.jdField_b_of_type_Int;
      int k = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168);
      if (j == -1)
      {
        localLayoutParams.addRule(10);
        i += k;
      }
      else
      {
        localLayoutParams.addRule(3, j);
      }
      localLayoutParams.topMargin = i;
      localLayoutParams.rightMargin = DisplayUtil.a(BaseApplicationImpl.getContext(), 40.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "JdTipHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 68)
    {
      a();
      return true;
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 15)
    {
      RelativeLayout localRelativeLayout1 = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout1 != null)
      {
        RelativeLayout localRelativeLayout2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if ((localRelativeLayout2 != null) && (localRelativeLayout1.indexOfChild(localRelativeLayout2) != -1))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.JdTipHelper
 * JD-Core Version:    0.7.0.1
 */