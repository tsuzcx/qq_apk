package com.tencent.mobileqq.activity.phone;

import aknm;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;

public class PhoneFrame
  extends PhoneInnerFrame
{
  private aknm a;
  
  public PhoneFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhoneFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected aknm a()
  {
    return this.a;
  }
  
  public void f()
  {
    a().finish();
  }
  
  public void setPhoneContext(aknm paramaknm)
  {
    this.a = paramaknm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrame
 * JD-Core Version:    0.7.0.1
 */