package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;

public class PhoneFrame
  extends PhoneInnerFrame
{
  private BaseActivityView.IPhoneContext b;
  
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
  
  protected BaseActivityView.IPhoneContext f()
  {
    return this.b;
  }
  
  public void g()
  {
    getActivity().finish();
  }
  
  public void setPhoneContext(BaseActivityView.IPhoneContext paramIPhoneContext)
  {
    this.b = paramIPhoneContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrame
 * JD-Core Version:    0.7.0.1
 */