package com.tencent.mobileqq.app.message.messageclean;

import java.util.Comparator;

public class CleanMessageComparator
  implements Comparator<CleanMessageItemInfo>
{
  private int a;
  
  public CleanMessageComparator(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(CleanMessageItemInfo paramCleanMessageItemInfo1, CleanMessageItemInfo paramCleanMessageItemInfo2)
  {
    if (this.a == 2) {
      if (paramCleanMessageItemInfo1.b <= paramCleanMessageItemInfo2.b) {}
    }
    while (paramCleanMessageItemInfo1.a > paramCleanMessageItemInfo2.a)
    {
      return -1;
      if (paramCleanMessageItemInfo1.b < paramCleanMessageItemInfo2.b) {
        return 1;
      }
      return 0;
    }
    if (paramCleanMessageItemInfo1.a < paramCleanMessageItemInfo2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.CleanMessageComparator
 * JD-Core Version:    0.7.0.1
 */