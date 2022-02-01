package com.tencent.mobileqq.activity.aio.coreui.input;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import java.util.Iterator;
import java.util.List;

public class InputBarUI
  implements View.OnLayoutChangeListener
{
  private final InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  
  public InputBarUI(AIOContext paramAIOContext, InputLinearLayout paramInputLinearLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = paramInputLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight();
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
  }
  
  public InputLinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addOnLayoutChangeListener(this);
  }
  
  public void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeOnLayoutChangeListener(this);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.requestLayout();
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().g().iterator();
    while (localIterator.hasNext()) {
      ((IInputBarLayoutChangeCallback)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI
 * JD-Core Version:    0.7.0.1
 */