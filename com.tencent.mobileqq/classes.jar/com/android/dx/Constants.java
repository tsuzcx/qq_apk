package com.android.dx;

import com.android.dx.rop.cst.CstBoolean;
import com.android.dx.rop.cst.CstByte;
import com.android.dx.rop.cst.CstChar;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstShort;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;

final class Constants
{
  static TypedConstant getConstant(Object paramObject)
  {
    if (paramObject == null) {
      return CstKnownNull.THE_ONE;
    }
    if ((paramObject instanceof Boolean)) {
      return CstBoolean.make(((Boolean)paramObject).booleanValue());
    }
    if ((paramObject instanceof Byte)) {
      return CstByte.make(((Byte)paramObject).byteValue());
    }
    if ((paramObject instanceof Character)) {
      return CstChar.make(((Character)paramObject).charValue());
    }
    if ((paramObject instanceof Double)) {
      return CstDouble.make(Double.doubleToLongBits(((Double)paramObject).doubleValue()));
    }
    if ((paramObject instanceof Float)) {
      return CstFloat.make(Float.floatToIntBits(((Float)paramObject).floatValue()));
    }
    if ((paramObject instanceof Integer)) {
      return CstInteger.make(((Integer)paramObject).intValue());
    }
    if ((paramObject instanceof Long)) {
      return CstLong.make(((Long)paramObject).longValue());
    }
    if ((paramObject instanceof Short)) {
      return CstShort.make(((Short)paramObject).shortValue());
    }
    if ((paramObject instanceof String)) {
      return new CstString((String)paramObject);
    }
    if ((paramObject instanceof Class)) {
      return new CstType(TypeId.get((Class)paramObject).ropType);
    }
    if ((paramObject instanceof TypeId)) {
      return new CstType(((TypeId)paramObject).ropType);
    }
    throw new UnsupportedOperationException("Not a constant: " + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.Constants
 * JD-Core Version:    0.7.0.1
 */