package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

public final class CstChar
  extends CstLiteral32
{
  public static final CstChar VALUE_0 = make('\000');
  
  private CstChar(char paramChar)
  {
    super(paramChar);
  }
  
  public static CstChar make(char paramChar)
  {
    return new CstChar(paramChar);
  }
  
  public static CstChar make(int paramInt)
  {
    int i = (char)paramInt;
    if (i != paramInt) {
      throw new IllegalArgumentException("bogus char value: " + paramInt);
    }
    return make(i);
  }
  
  public Type getType()
  {
    return Type.CHAR;
  }
  
  public char getValue()
  {
    return (char)getIntBits();
  }
  
  public String toHuman()
  {
    return Integer.toString(getIntBits());
  }
  
  public String toString()
  {
    int i = getIntBits();
    return "char{0x" + Hex.u2(i) + " / " + i + '}';
  }
  
  public String typeName()
  {
    return "char";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstChar
 * JD-Core Version:    0.7.0.1
 */