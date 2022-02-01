package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

public final class CstByte
  extends CstLiteral32
{
  public static final CstByte VALUE_0 = make();
  
  private CstByte(byte paramByte)
  {
    super(paramByte);
  }
  
  public static CstByte make(byte paramByte)
  {
    return new CstByte(paramByte);
  }
  
  public static CstByte make(int paramInt)
  {
    int i = (byte)paramInt;
    if (i != paramInt) {
      throw new IllegalArgumentException("bogus byte value: " + paramInt);
    }
    return make(i);
  }
  
  public Type getType()
  {
    return Type.BYTE;
  }
  
  public byte getValue()
  {
    return (byte)getIntBits();
  }
  
  public String toHuman()
  {
    return Integer.toString(getIntBits());
  }
  
  public String toString()
  {
    int i = getIntBits();
    return "byte{0x" + Hex.u1(i) + " / " + i + '}';
  }
  
  public String typeName()
  {
    return "byte";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstByte
 * JD-Core Version:    0.7.0.1
 */