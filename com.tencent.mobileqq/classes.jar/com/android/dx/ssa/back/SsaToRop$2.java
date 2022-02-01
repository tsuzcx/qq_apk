package com.android.dx.ssa.back;

import com.android.dx.ssa.SsaMethod;
import java.util.Comparator;
import java.util.List;

class SsaToRop$2
  implements Comparator<Integer>
{
  SsaToRop$2(SsaToRop paramSsaToRop) {}
  
  public int compare(Integer paramInteger1, Integer paramInteger2)
  {
    return SsaToRop.access$000(this.this$0).getUseListForRegister(paramInteger2.intValue()).size() - SsaToRop.access$000(this.this$0).getUseListForRegister(paramInteger1.intValue()).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.SsaToRop.2
 * JD-Core Version:    0.7.0.1
 */