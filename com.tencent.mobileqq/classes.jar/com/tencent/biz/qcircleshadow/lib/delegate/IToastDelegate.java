package com.tencent.biz.qcircleshadow.lib.delegate;

public abstract interface IToastDelegate
{
  public abstract int getIconTypeDefault();
  
  public abstract int getIconTypeError();
  
  public abstract int getIconTypeNone();
  
  public abstract int getIconTypeSuccess();
  
  public abstract void makeTextAndShow(int paramInt1, String paramString, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.delegate.IToastDelegate
 * JD-Core Version:    0.7.0.1
 */