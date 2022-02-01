package com.tencent.mobileqq.activity.aio.coreui.input;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import java.util.Iterator;
import java.util.List;

public class InputRightIconUI
  implements View.OnTouchListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public InputRightIconUI(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
  }
  
  private void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.onClick(paramView);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext()) {
      if (((IOnRightIconClickListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramView)) {
        return;
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IOnRightIconClickListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramView);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ImageButton a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageButton;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131362371);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131362370));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnTouchListener(this);
    AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetImageButton, new InputRightIconUI.1(this));
    AIOZhituHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetImageButton);
  }
  
  public boolean a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton == null) {
      return false;
    }
    if (localImageButton.getLeft() <= paramFloat1)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageButton.getRight() < paramFloat1) {
        return true;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageButton.getTop() <= paramFloat2) {
        return this.jdField_a_of_type_AndroidWidgetImageButton.getBottom() < paramFloat2;
      }
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(paramView, paramMotionEvent);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != 28) && (paramMotionEvent.getAction() == 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "CliOper", "", "", "0X80094D1", "0X80094D1", 0, 0, "", "", "", "");
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((IOnRightIconTouchListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramView, paramMotionEvent)) {
        return true;
      }
    }
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      onClick(this.jdField_a_of_type_AndroidWidgetImageButton);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI
 * JD-Core Version:    0.7.0.1
 */