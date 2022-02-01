package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

public final class CstLong
  extends CstLiteral64
{
  public static final CstLong VALUE_0 = make(0L);
  public static final CstLong VALUE_1 = make(1L);
  
  private CstLong(long paramLong)
  {
    super(paramLong);
  }
  
  public static CstLong make(long paramLong)
  {
    return new CstLong(paramLong);
  }
  
  public Type getType()
  {
    return Type.LONG;
  }
  
  public long getValue()
  {
    return getLongBits();
  }
  
  public String toHuman()
  {
    return Long.toString(getLongBits());
  }
  
  public String toString()
  {
    long l = getLongBits();
    return "long{0x" + Hex.u8(l) + " / " + l + '}';
  }
  
  public String typeName()
  {
    return "long";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstLong
 * JD-Core Version:    0.7.0.1
 */