package com.android.dx.cf.code;

import com.android.dx.rop.type.Type;

class Ropper$ExceptionHandlerSetup
{
  private Type caughtType;
  private int label;
  
  Ropper$ExceptionHandlerSetup(Type paramType, int paramInt)
  {
    this.caughtType = paramType;
    this.label = paramInt;
  }
  
  Type getCaughtType()
  {
    return this.caughtType;
  }
  
  public int getLabel()
  {
    return this.label;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper.ExceptionHandlerSetup
 * JD-Core Version:    0.7.0.1
 */