package com.android.dx.cf.code;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.util.Bits;
import com.android.dx.util.IntList;
import java.util.BitSet;

class Ropper$Subroutine
{
  private BitSet callerBlocks;
  private BitSet retBlocks;
  private int startBlock;
  
  Ropper$Subroutine(Ropper paramRopper, int paramInt)
  {
    this.startBlock = paramInt;
    this.retBlocks = new BitSet(Ropper.access$100(paramRopper));
    this.callerBlocks = new BitSet(Ropper.access$100(paramRopper));
    Ropper.access$202(paramRopper, true);
  }
  
  Ropper$Subroutine(Ropper paramRopper, int paramInt1, int paramInt2)
  {
    this(paramRopper, paramInt1);
    addRetBlock(paramInt2);
  }
  
  void addCallerBlock(int paramInt)
  {
    this.callerBlocks.set(paramInt);
  }
  
  void addRetBlock(int paramInt)
  {
    this.retBlocks.set(paramInt);
  }
  
  int getStartBlock()
  {
    return this.startBlock;
  }
  
  IntList getSuccessors()
  {
    IntList localIntList = new IntList(this.callerBlocks.size());
    for (int i = this.callerBlocks.nextSetBit(0); i >= 0; i = this.callerBlocks.nextSetBit(i + 1)) {
      localIntList.add(Ropper.access$300(this.this$0, i).getSuccessors().get(0));
    }
    localIntList.setImmutable();
    return localIntList;
  }
  
  void mergeToSuccessors(Frame paramFrame, int[] paramArrayOfInt)
  {
    int i = this.callerBlocks.nextSetBit(0);
    if (i >= 0)
    {
      int j = Ropper.access$300(this.this$0, i).getSuccessors().get(0);
      Frame localFrame = paramFrame.subFrameForLabel(this.startBlock, i);
      if (localFrame != null) {
        Ropper.access$400(this.this$0, j, -1, null, localFrame, paramArrayOfInt);
      }
      for (;;)
      {
        i = this.callerBlocks.nextSetBit(i + 1);
        break;
        Bits.set(paramArrayOfInt, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper.Subroutine
 * JD-Core Version:    0.7.0.1
 */