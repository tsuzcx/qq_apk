package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

public final class CstDouble
  extends CstLiteral64
{
  public static final CstDouble VALUE_0 = new CstDouble(Double.doubleToLongBits(0.0D));
  public static final CstDouble VALUE_1 = new CstDouble(Double.doubleToLongBits(1.0D));
  
  private CstDouble(long paramLong)
  {
    super(paramLong);
  }
  
  public static CstDouble make(long paramLong)
  {
    return new CstDouble(paramLong);
  }
  
  public Type getType()
  {
    return Type.DOUBLE;
  }
  
  public double getValue()
  {
    return Double.longBitsToDouble(getLongBits());
  }
  
  public String toHuman()
  {
    return Double.toString(Double.longBitsToDouble(getLongBits()));
  }
  
  public String toString()
  {
    long l = getLongBits();
    return "double{0x" + Hex.u8(l) + " / " + Double.longBitsToDouble(l) + '}';
  }
  
  public String typeName()
  {
    return "double";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstDouble
 * JD-Core Version:    0.7.0.1
 */