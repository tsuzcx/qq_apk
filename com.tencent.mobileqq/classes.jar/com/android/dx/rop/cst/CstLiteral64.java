package com.android.dx.rop.cst;

public abstract class CstLiteral64
  extends CstLiteralBits
{
  private final long bits;
  
  CstLiteral64(long paramLong)
  {
    this.bits = paramLong;
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    long l = ((CstLiteral64)paramConstant).bits;
    if (this.bits < l) {
      return -1;
    }
    if (this.bits > l) {
      return 1;
    }
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (getClass() == paramObject.getClass()) && (this.bits == ((CstLiteral64)paramObject).bits);
  }
  
  public final boolean fitsInInt()
  {
    return (int)this.bits == this.bits;
  }
  
  public final int getIntBits()
  {
    return (int)this.bits;
  }
  
  public final long getLongBits()
  {
    return this.bits;
  }
  
  public final int hashCode()
  {
    return (int)this.bits ^ (int)(this.bits >> 32);
  }
  
  public final boolean isCategory2()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstLiteral64
 * JD-Core Version:    0.7.0.1
 */