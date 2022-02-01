package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;

public final class CstBoolean
  extends CstLiteral32
{
  public static final CstBoolean VALUE_FALSE = new CstBoolean(false);
  public static final CstBoolean VALUE_TRUE = new CstBoolean(true);
  
  private CstBoolean(boolean paramBoolean) {}
  
  public static CstBoolean make(int paramInt)
  {
    if (paramInt == 0) {
      return VALUE_FALSE;
    }
    if (paramInt == 1) {
      return VALUE_TRUE;
    }
    throw new IllegalArgumentException("bogus value: " + paramInt);
  }
  
  public static CstBoolean make(boolean paramBoolean)
  {
    if (paramBoolean) {
      return VALUE_TRUE;
    }
    return VALUE_FALSE;
  }
  
  public Type getType()
  {
    return Type.BOOLEAN;
  }
  
  public boolean getValue()
  {
    return getIntBits() != 0;
  }
  
  public String toHuman()
  {
    if (getValue()) {
      return "true";
    }
    return "false";
  }
  
  public String toString()
  {
    if (getValue()) {
      return "boolean{true}";
    }
    return "boolean{false}";
  }
  
  public String typeName()
  {
    return "boolean";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstBoolean
 * JD-Core Version:    0.7.0.1
 */