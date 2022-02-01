package com.android.dx;

import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.type.TypeList;

 enum Comparison$1
{
  Comparison$1()
  {
    super(str, i, null);
  }
  
  Rop rop(TypeList paramTypeList)
  {
    return Rops.opIfLt(paramTypeList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.Comparison.1
 * JD-Core Version:    0.7.0.1
 */