package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

public final class CstInteger
  extends CstLiteral32
{
  public static final CstInteger VALUE_0 = make(0);
  public static final CstInteger VALUE_1 = make(1);
  public static final CstInteger VALUE_2 = make(2);
  public static final CstInteger VALUE_3 = make(3);
  public static final CstInteger VALUE_4 = make(4);
  public static final CstInteger VALUE_5 = make(5);
  public static final CstInteger VALUE_M1;
  private static final CstInteger[] cache = new CstInteger[511];
  
  static
  {
    VALUE_M1 = make(-1);
  }
  
  private CstInteger(int paramInt)
  {
    super(paramInt);
  }
  
  public static CstInteger make(int paramInt)
  {
    int i = (0x7FFFFFFF & paramInt) % cache.length;
    CstInteger localCstInteger = cache[i];
    if ((localCstInteger != null) && (localCstInteger.getValue() == paramInt)) {
      return localCstInteger;
    }
    localCstInteger = new CstInteger(paramInt);
    cache[i] = localCstInteger;
    return localCstInteger;
  }
  
  public Type getType()
  {
    return Type.INT;
  }
  
  public int getValue()
  {
    return getIntBits();
  }
  
  public String toHuman()
  {
    return Integer.toString(getIntBits());
  }
  
  public String toString()
  {
    int i = getIntBits();
    return "int{0x" + Hex.u4(i) + " / " + i + '}';
  }
  
  public String typeName()
  {
    return "int";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstInteger
 * JD-Core Version:    0.7.0.1
 */