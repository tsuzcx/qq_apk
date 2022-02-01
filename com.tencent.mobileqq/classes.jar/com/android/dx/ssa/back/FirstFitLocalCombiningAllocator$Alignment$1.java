package com.android.dx.ssa.back;

import java.util.BitSet;

 enum FirstFitLocalCombiningAllocator$Alignment$1
{
  FirstFitLocalCombiningAllocator$Alignment$1()
  {
    super(str, i, null);
  }
  
  int nextClearBit(BitSet paramBitSet, int paramInt)
  {
    for (paramInt = paramBitSet.nextClearBit(paramInt); !FirstFitLocalCombiningAllocator.access$100(paramInt); paramInt = paramBitSet.nextClearBit(paramInt + 1)) {}
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment.1
 * JD-Core Version:    0.7.0.1
 */