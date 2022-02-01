package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;

public final class Zeroes
{
  public static Constant zeroFor(Type paramType)
  {
    switch (paramType.getBasicType())
    {
    default: 
      throw new UnsupportedOperationException("no zero for type: " + paramType.toHuman());
    case 1: 
      return CstBoolean.VALUE_FALSE;
    case 2: 
      return CstByte.VALUE_0;
    case 3: 
      return CstChar.VALUE_0;
    case 4: 
      return CstDouble.VALUE_0;
    case 5: 
      return CstFloat.VALUE_0;
    case 6: 
      return CstInteger.VALUE_0;
    case 7: 
      return CstLong.VALUE_0;
    case 8: 
      return CstShort.VALUE_0;
    }
    return CstKnownNull.THE_ONE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.Zeroes
 * JD-Core Version:    0.7.0.1
 */