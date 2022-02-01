package com.android.dx.ssa;

import java.util.Comparator;

public final class SsaBasicBlock$LabelComparator
  implements Comparator<SsaBasicBlock>
{
  public int compare(SsaBasicBlock paramSsaBasicBlock1, SsaBasicBlock paramSsaBasicBlock2)
  {
    int i = SsaBasicBlock.access$000(paramSsaBasicBlock1);
    int j = SsaBasicBlock.access$000(paramSsaBasicBlock2);
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaBasicBlock.LabelComparator
 * JD-Core Version:    0.7.0.1
 */