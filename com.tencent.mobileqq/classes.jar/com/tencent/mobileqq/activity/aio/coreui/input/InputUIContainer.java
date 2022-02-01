package com.tencent.mobileqq.activity.aio.coreui.input;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnPrivateIMECommandListener;
import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;

public class InputUIContainer
{
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final AIOInputState jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputAIOInputState;
  private final EditTextUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI;
  private final FakeInputUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFakeInputUI;
  private final FunBtnUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI;
  private final InputBarUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputBarUI;
  private final InputRightIconUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputRightIconUI;
  
  public InputUIContainer(AIOContext paramAIOContext, InputBarUI paramInputBarUI, EditTextUI paramEditTextUI, FunBtnUI paramFunBtnUI, InputRightIconUI paramInputRightIconUI)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputBarUI = paramInputBarUI;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI = paramEditTextUI;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI = paramFunBtnUI;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputRightIconUI = paramInputRightIconUI;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFakeInputUI = new FakeInputUI(paramAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputAIOInputState = new AIOInputState(paramAIOContext);
  }
  
  public AIOInputState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputAIOInputState;
  }
  
  public EditTextUI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI;
  }
  
  public FakeInputUI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFakeInputUI;
  }
  
  public FunBtnUI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI;
  }
  
  public InputBarUI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputBarUI;
  }
  
  public InputRightIconUI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputRightIconUI;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI.a(HardCodeUtil.a(2131701189));
    if (AppSetting.d) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI.b(HardCodeUtil.a(2131701180));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI.b();
  }
  
  public void a(boolean paramBoolean)
  {
    ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(24)).a(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI.f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI.a("");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI.a(QQTextBuilder.EMOTION_INPUT_FACTORY);
    }
    catch (Exception localException)
    {
      QLog.e("InputContainer", 1, "input set error", localException);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI.a(true).putInt("SOGOU_EXPRESSION", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI.c();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFakeInputUI.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFakeInputUI.e();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputRightIconUI.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputBarUI.a();
  }
  
  public void f()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getCurrentFocus();
      if (localObject != null)
      {
        QLog.i("InputContainer", 1, localObject.toString());
        ((View)localObject).clearFocus();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != null) {
      localObject = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getSystemService("input_method");
    } else {
      localObject = null;
    }
    a(true);
    if (localObject != null) {
      try
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(a().a().getWindowToken(), 0);
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("InputContainer", 1, localRuntimeException, new Object[0]);
      }
    }
    if (a() != null)
    {
      a().f();
      if (a().a(false) != null) {
        a().a(false).clear();
      }
      a().a(null, null, null, null);
      a().a(2131373876, null);
      try
      {
        a().c(0);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("InputContainer", 1, "doOnDestroy: ", localThrowable);
      }
      a().d();
      a().a().setOnEditorActionListener(null);
      a().a().setOnKeyListener(null);
      a().a().setOnTouchListener(null);
      a().a().setOnFocusChangeListener(null);
      a().b();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().l) {
        a().a("");
      }
      try
      {
        if (AIOUtils.a())
        {
          ViewTreeObserver localViewTreeObserver = a().a().getViewTreeObserver();
          Field localField = ViewTreeObserver.class.getDeclaredField("mOnTouchModeChangeListeners");
          localField.setAccessible(true);
          localField.set(localViewTreeObserver, new CopyOnWriteArrayList());
          QLog.d("InputContainer", 1, "force clear mOnTouchModeChangeListeners success.");
        }
      }
      catch (Exception localException)
      {
        QLog.d("InputContainer", 1, "force clear mOnTouchModeChangeListeners", localException);
      }
      a().g();
    }
    if (a().a != null) {
      a().a.a();
    }
    if (a() != null) {
      a().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer
 * JD-Core Version:    0.7.0.1
 */