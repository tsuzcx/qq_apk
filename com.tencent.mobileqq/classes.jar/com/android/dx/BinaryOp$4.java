package com.android.dx;

import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.type.TypeList;

 enum BinaryOp$4
{
  BinaryOp$4()
  {
    super(str, i, null);
  }
  
  Rop rop(TypeList paramTypeList)
  {
    return Rops.opDiv(paramTypeList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.BinaryOp.4
 * JD-Core Version:    0.7.0.1
 */