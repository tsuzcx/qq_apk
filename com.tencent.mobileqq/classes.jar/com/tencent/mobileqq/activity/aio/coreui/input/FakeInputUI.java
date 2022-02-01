package com.tencent.mobileqq.activity.aio.coreui.input;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class FakeInputUI
  implements View.OnClickListener
{
  protected float a;
  public View a;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  public View b;
  RelativeLayout.LayoutParams b;
  
  public FakeInputUI(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_Float = paramAIOContext.a().getApplication().getResources().getDisplayMetrics().density;
  }
  
  public void a()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      if (paramInt >= 1) {
        localView.setVisibility(8);
      } else {
        localView.setVisibility(0);
      }
    }
    localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      if (paramInt >= 1)
      {
        localView.setVisibility(8);
        return;
      }
      localView.setVisibility(0);
    }
  }
  
  public void b()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(4);
    }
    localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 15.0F + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(3, 2131368875);
      this.jdField_a_of_type_AndroidViewView.setId(2131362363);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131364485);
      if (localRelativeLayout != null) {
        localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.d) {
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidViewView, false);
    }
  }
  
  protected void e()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 12.0F + 0.5F));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(6, 2131368875);
      this.jdField_b_of_type_AndroidViewView.setId(2131362364);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131364485);
      if (localRelativeLayout != null) {
        localRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.d) {
      AccessibilityUtil.a(this.jdField_b_of_type_AndroidViewView, false);
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(1, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.FakeInputUI
 * JD-Core Version:    0.7.0.1
 */