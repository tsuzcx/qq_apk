package com.tencent.mobileqq.activity.aio.coreui.input;

import android.annotation.TargetApi;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class AIOInputState
{
  private int jdField_a_of_type_Int = 0;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  
  public AIOInputState(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @TargetApi(11)
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMessageFacade().a() == null) {
      return;
    }
    if (((EditTextUI)localObject).a() == null) {
      return;
    }
    this.jdField_a_of_type_Int = 2;
    ((EditTextUI)localObject).a(8);
    ((EditTextUI)localObject).a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().b(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().e().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IInputStateChangeCallback)((Iterator)localObject).next()).a(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" setInputStat start stat = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" mInputStat= ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("AIOInputState", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramInt;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
      ((EditTextUI)localObject).a(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().c();
      ((EditTextUI)localObject).a(true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().e().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IInputStateChangeCallback)((Iterator)localObject).next()).a(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" setInputStat end currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("AIOInputState", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.AIOInputState
 * JD-Core Version:    0.7.0.1
 */