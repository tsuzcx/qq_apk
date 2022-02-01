package com.android.dx.ssa;

import com.android.dx.rop.cst.Constant;
import java.util.Comparator;
import java.util.HashMap;

class ConstCollector$1
  implements Comparator<Constant>
{
  ConstCollector$1(ConstCollector paramConstCollector, HashMap paramHashMap) {}
  
  public int compare(Constant paramConstant1, Constant paramConstant2)
  {
    int j = ((Integer)this.val$countUses.get(paramConstant2)).intValue() - ((Integer)this.val$countUses.get(paramConstant1)).intValue();
    int i = j;
    if (j == 0) {
      i = paramConstant1.compareTo(paramConstant2);
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.ConstCollector.1
 * JD-Core Version:    0.7.0.1
 */