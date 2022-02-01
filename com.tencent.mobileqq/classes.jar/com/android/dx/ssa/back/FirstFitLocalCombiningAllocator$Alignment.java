package com.android.dx.ssa.back;

import java.util.BitSet;

 enum FirstFitLocalCombiningAllocator$Alignment
{
  EVEN,  ODD,  UNSPECIFIED;
  
  private FirstFitLocalCombiningAllocator$Alignment() {}
  
  abstract int nextClearBit(BitSet paramBitSet, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment
 * JD-Core Version:    0.7.0.1
 */