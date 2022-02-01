package com.android.dx.cf.code;

import com.android.dx.rop.cst.CstType;

public class ByteCatchList$Item
{
  private final int endPc;
  private final CstType exceptionClass;
  private final int handlerPc;
  private final int startPc;
  
  public ByteCatchList$Item(int paramInt1, int paramInt2, int paramInt3, CstType paramCstType)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("startPc < 0");
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endPc < startPc");
    }
    if (paramInt3 < 0) {
      throw new IllegalArgumentException("handlerPc < 0");
    }
    this.startPc = paramInt1;
    this.endPc = paramInt2;
    this.handlerPc = paramInt3;
    this.exceptionClass = paramCstType;
  }
  
  public boolean covers(int paramInt)
  {
    return (paramInt >= this.startPc) && (paramInt < this.endPc);
  }
  
  public int getEndPc()
  {
    return this.endPc;
  }
  
  public CstType getExceptionClass()
  {
    if (this.exceptionClass != null) {
      return this.exceptionClass;
    }
    return CstType.OBJECT;
  }
  
  public int getHandlerPc()
  {
    return this.handlerPc;
  }
  
  public int getStartPc()
  {
    return this.startPc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.ByteCatchList.Item
 * JD-Core Version:    0.7.0.1
 */