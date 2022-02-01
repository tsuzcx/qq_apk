package com.etrump.mixlayout;

import java.util.Comparator;

class ETLayout$ETComparator
  implements Comparator<ETLayout.ETRange>
{
  public int a(ETLayout.ETRange paramETRange1, ETLayout.ETRange paramETRange2)
  {
    if (paramETRange1.a != paramETRange2.a)
    {
      if (paramETRange1.a > paramETRange2.a) {
        return 1;
      }
      return -1;
    }
    return paramETRange1.b - paramETRange2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETLayout.ETComparator
 * JD-Core Version:    0.7.0.1
 */