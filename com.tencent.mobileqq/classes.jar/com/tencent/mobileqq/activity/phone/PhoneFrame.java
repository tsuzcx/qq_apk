package com.tencent.mobileqq.activity.phone;

import akgz;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;

public class PhoneFrame
  extends PhoneInnerFrame
{
  private akgz a;
  
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
  
  protected akgz a()
  {
    return this.a;
  }
  
  public void f()
  {
    a().finish();
  }
  
  public void setPhoneContext(akgz paramakgz)
  {
    this.a = paramakgz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrame
 * JD-Core Version:    0.7.0.1
 */