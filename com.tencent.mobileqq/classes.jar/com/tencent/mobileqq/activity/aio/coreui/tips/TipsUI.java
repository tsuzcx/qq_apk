package com.tencent.mobileqq.activity.aio.coreui.tips;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.BaseActivity;

public class TipsUI
{
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AIOTipsController jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  
  public TipsUI(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public AIOTipsController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131374119);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131374124));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = new AIOTipsController(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = (paramInt + (int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getResources().getDimension(2131299168));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI
 * JD-Core Version:    0.7.0.1
 */