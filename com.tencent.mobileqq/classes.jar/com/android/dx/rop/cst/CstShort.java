package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

public final class CstShort
  extends CstLiteral32
{
  public static final CstShort VALUE_0 = make();
  
  private CstShort(short paramShort)
  {
    super(paramShort);
  }
  
  public static CstShort make(int paramInt)
  {
    int i = (short)paramInt;
    if (i != paramInt) {
      throw new IllegalArgumentException("bogus short value: " + paramInt);
    }
    return make(i);
  }
  
  public static CstShort make(short paramShort)
  {
    return new CstShort(paramShort);
  }
  
  public Type getType()
  {
    return Type.SHORT;
  }
  
  public short getValue()
  {
    return (short)getIntBits();
  }
  
  public String toHuman()
  {
    return Integer.toString(getIntBits());
  }
  
  public String toString()
  {
    int i = getIntBits();
    return "short{0x" + Hex.u2(i) + " / " + i + '}';
  }
  
  public String typeName()
  {
    return "short";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstShort
 * JD-Core Version:    0.7.0.1
 */