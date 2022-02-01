package com.tencent.mobileqq.auto.engine.lib;

public abstract interface IToastDelegate
{
  public abstract int getIconTypeDefault();
  
  public abstract int getIconTypeError();
  
  public abstract int getIconTypeNone();
  
  public abstract int getIconTypeSuccess();
  
  public abstract void makeTextAndShow(int paramInt1, String paramString, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.lib.IToastDelegate
 * JD-Core Version:    0.7.0.1
 */