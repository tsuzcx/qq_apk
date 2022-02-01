package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

public class VipProfileCardDiyActivity$HiBoomTemplateView
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public VipProfileCardDiyActivity$HiBoomTemplateView(VipProfileCardDiyActivity paramVipProfileCardDiyActivity, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    paramContext = paramVipProfileCardDiyActivity.getLayoutInflater().inflate(2131561472, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131379005));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131377749));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131368819);
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131373568);
    this.jdField_a_of_type_Int = paramInt;
    if (paramBoolean)
    {
      this.jdField_b_of_type_Int = 2;
      HiBoomFont.a().a(paramInt, 1, HiBoomManager.b);
    }
    for (;;)
    {
      setOnClickListener(this);
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new VipProfileCardDiyActivity.HiBoomTemplateView.1(this, paramVipProfileCardDiyActivity);
      paramVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasQuickUpdateService.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
    }
    setChecked(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = this;
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_Int, 1, HiBoomManager.b);
    HiBoomFontDrawer localHiBoomFontDrawer = HiBoomFont.a().a(this.jdField_a_of_type_Int, 1, HiBoomManager.b);
    if (this.jdField_b_of_type_Int == 0)
    {
      if (!localHiBoomFontDrawer.b.get()) {
        break label212;
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
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008114", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", String.valueOf(this.jdField_a_of_type_Int));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label212:
      if (!localHiBoomFontDrawer.a.get())
      {
        this.jdField_b_of_type_Int = 1;
        localHiBoomFontDrawer.a(true);
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasQuickUpdateService != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasQuickUpdateService.removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_AndroidContentResResources.getColor(2131165939));
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