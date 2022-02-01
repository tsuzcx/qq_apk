package com.android.dx.rop.cst;

import com.android.dx.util.ToHuman;

public abstract class Constant
  implements ToHuman, Comparable<Constant>
{
  public final int compareTo(Constant paramConstant)
  {
    Class localClass1 = getClass();
    Class localClass2 = paramConstant.getClass();
    if (localClass1 != localClass2) {
      return localClass1.getName().compareTo(localClass2.getName());
    }
    return compareTo0(paramConstant);
  }
  
  protected abstract int compareTo0(Constant paramConstant);
  
  public abstract boolean isCategory2();
  
  public abstract String typeName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.Constant
 * JD-Core Version:    0.7.0.1
 */