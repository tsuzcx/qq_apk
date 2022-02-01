package com.tencent.mobileqq.activity.aio.coreui.input;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PatchedButton;
import java.util.Iterator;
import java.util.List;

public class FunBtnUI
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  
  public FunBtnUI(AIOContext paramAIOContext, PatchedButton paramPatchedButton)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = paramPatchedButton;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(new FunBtnUI.1(this));
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnLongClickListener(new FunBtnUI.2(this));
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a().length() > 0)
    {
      b(true);
      if (QLog.isColorLevel()) {
        QLog.d("AIO:FunBtnUI", 2, "set FunBtn enable because has text");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().d().iterator();
    while (((Iterator)localObject).hasNext())
    {
      IFunBtnEnabledCheck localIFunBtnEnabledCheck = (IFunBtnEnabledCheck)((Iterator)localObject).next();
      if (localIFunBtnEnabledCheck.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext))
      {
        b(true);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("set FunBtn enable by:");
          ((StringBuilder)localObject).append(localIFunBtnEnabledCheck);
          QLog.d("AIO:FunBtnUI", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIO:FunBtnUI", 2, "set FunBtn unable click");
    }
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI
 * JD-Core Version:    0.7.0.1
 */