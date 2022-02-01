package com.android.dx.rop.cst;

public abstract class CstLiteral32
  extends CstLiteralBits
{
  private final int bits;
  
  CstLiteral32(int paramInt)
  {
    this.bits = paramInt;
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    int i = ((CstLiteral32)paramConstant).bits;
    if (this.bits < i) {
      return -1;
    }
    if (this.bits > i) {
      return 1;
    }
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (getClass() == paramObject.getClass()) && (this.bits == ((CstLiteral32)paramObject).bits);
  }
  
  public final boolean fitsInInt()
  {
    return true;
  }
  
  public final int getIntBits()
  {
    return this.bits;
  }
  
  public final long getLongBits()
  {
    return this.bits;
  }
  
  public final int hashCode()
  {
    return this.bits;
  }
  
  public final boolean isCategory2()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstLiteral32
 * JD-Core Version:    0.7.0.1
 */