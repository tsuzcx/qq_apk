package com.tencent.mobileqq.activity.aio.coreui.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;

public final class InputUIContainerBuilder
{
  private AIOContext a;
  private InputBarUI b;
  private EditTextUI c;
  private FunBtnUI d;
  private InputRightIconUI e;
  
  public InputUIContainer a()
  {
    return new InputUIContainer(this.a, this.b, this.c, this.d, this.e);
  }
  
  public InputUIContainerBuilder a(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    return this;
  }
  
  public InputUIContainerBuilder a(EditTextUI paramEditTextUI)
  {
    this.c = paramEditTextUI;
    return this;
  }
  
  public InputUIContainerBuilder a(FunBtnUI paramFunBtnUI)
  {
    this.d = paramFunBtnUI;
    return this;
  }
  
  public InputUIContainerBuilder a(InputBarUI paramInputBarUI)
  {
    this.b = paramInputBarUI;
    return this;
  }
  
  public InputUIContainerBuilder a(InputRightIconUI paramInputRightIconUI)
  {
    this.e = paramInputRightIconUI;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainerBuilder
 * JD-Core Version:    0.7.0.1
 */