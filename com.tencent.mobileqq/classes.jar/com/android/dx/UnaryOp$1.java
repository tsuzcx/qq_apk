package com.android.dx;

import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;

 enum UnaryOp$1
{
  UnaryOp$1()
  {
    super(str, i, null);
  }
  
  Rop rop(TypeId<?> paramTypeId)
  {
    return Rops.opNot(paramTypeId.ropType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.UnaryOp.1
 * JD-Core Version:    0.7.0.1
 */