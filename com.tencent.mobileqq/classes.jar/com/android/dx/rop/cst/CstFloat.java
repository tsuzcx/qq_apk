package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

public final class CstFloat
  extends CstLiteral32
{
  public static final CstFloat VALUE_0 = make(Float.floatToIntBits(0.0F));
  public static final CstFloat VALUE_1 = make(Float.floatToIntBits(1.0F));
  public static final CstFloat VALUE_2 = make(Float.floatToIntBits(2.0F));
  
  private CstFloat(int paramInt)
  {
    super(paramInt);
  }
  
  public static CstFloat make(int paramInt)
  {
    return new CstFloat(paramInt);
  }
  
  public Type getType()
  {
    return Type.FLOAT;
  }
  
  public float getValue()
  {
    return Float.intBitsToFloat(getIntBits());
  }
  
  public String toHuman()
  {
    return Float.toString(Float.intBitsToFloat(getIntBits()));
  }
  
  public String toString()
  {
    int i = getIntBits();
    return "float{0x" + Hex.u4(i) + " / " + Float.intBitsToFloat(i) + '}';
  }
  
  public String typeName()
  {
    return "float";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstFloat
 * JD-Core Version:    0.7.0.1
 */