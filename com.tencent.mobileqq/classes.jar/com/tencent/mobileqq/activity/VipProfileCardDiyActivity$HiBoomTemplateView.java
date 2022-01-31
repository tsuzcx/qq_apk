package com.tencent.mobileqq.activity;

import acpt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aqxb;
import aqxd;
import aqxj;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import naj;

public class VipProfileCardDiyActivity$HiBoomTemplateView
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker;
  public int b;
  public View b;
  ImageView b;
  
  public VipProfileCardDiyActivity$HiBoomTemplateView(VipProfileCardDiyActivity paramVipProfileCardDiyActivity, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    paramContext = paramVipProfileCardDiyActivity.getLayoutInflater().inflate(2131560968, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131376946));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131375821));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131367864);
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131372018);
    this.jdField_a_of_type_Int = paramInt;
    if (paramBoolean)
    {
      this.jdField_b_of_type_Int = 2;
      aqxb.a().a(paramInt, 1, aqxj.b);
    }
    for (;;)
    {
      setOnClickListener(this);
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new acpt(this, paramVipProfileCardDiyActivity);
      paramVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
    }
    setChecked(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = this;
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_Int, 1, aqxj.b);
    paramView = aqxb.a().a(this.jdField_a_of_type_Int, 1, aqxj.b);
    if (this.jdField_b_of_type_Int == 0)
    {
      if (!paramView.b.get()) {
        break label205;
      }
      this.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setCenterPoint(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2, this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() / 2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.onTextChanged(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.a(), 0, 0, 0);
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008114", "", 1, 0, 0, naj.a(), "", String.valueOf(this.jdField_a_of_type_Int));
      return;
      label205:
      if (!paramView.a.get())
      {
        this.jdField_b_of_type_Int = 1;
        paramView.a(true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager.removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_AndroidContentResResources.getColor(2131165815));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.HiBoomTemplateView
 * JD-Core Version:    0.7.0.1
 */