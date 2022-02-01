package com.android.dx.rop.code;

import com.android.dx.util.Hex;
import com.android.dx.util.IntList;

public final class RopMethod
{
  private final BasicBlockList blocks;
  private IntList exitPredecessors;
  private final int firstLabel;
  private IntList[] predecessors;
  
  public RopMethod(BasicBlockList paramBasicBlockList, int paramInt)
  {
    if (paramBasicBlockList == null) {
      throw new NullPointerException("blocks == null");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("firstLabel < 0");
    }
    this.blocks = paramBasicBlockList;
    this.firstLabel = paramInt;
    this.predecessors = null;
    this.exitPredecessors = null;
  }
  
  private void calcPredecessors()
  {
    int k = this.blocks.getMaxLabel();
    IntList[] arrayOfIntList = new IntList[k];
    IntList localIntList2 = new IntList(10);
    int m = this.blocks.size();
    int i = 0;
    Object localObject;
    if (i < m)
    {
      localObject = this.blocks.get(i);
      int n = ((BasicBlock)localObject).getLabel();
      IntList localIntList3 = ((BasicBlock)localObject).getSuccessors();
      int i1 = localIntList3.size();
      if (i1 == 0) {
        localIntList2.add(n);
      }
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while (j < i1)
        {
          int i2 = localIntList3.get(j);
          IntList localIntList1 = arrayOfIntList[i2];
          localObject = localIntList1;
          if (localIntList1 == null)
          {
            localObject = new IntList(10);
            arrayOfIntList[i2] = localObject;
          }
          ((IntList)localObject).add(n);
          j += 1;
        }
      }
    }
    i = 0;
    while (i < k)
    {
      localObject = arrayOfIntList[i];
      if (localObject != null)
      {
        ((IntList)localObject).sort();
        ((IntList)localObject).setImmutable();
      }
      i += 1;
    }
    localIntList2.sort();
    localIntList2.setImmutable();
    if (arrayOfIntList[this.firstLabel] == null) {
      arrayOfIntList[this.firstLabel] = IntList.EMPTY;
    }
    this.predecessors = arrayOfIntList;
    this.exitPredecessors = localIntList2;
  }
  
  public BasicBlockList getBlocks()
  {
    return this.blocks;
  }
  
  public IntList getExitPredecessors()
  {
    if (this.exitPredecessors == null) {
      calcPredecessors();
    }
    return this.exitPredecessors;
  }
  
  public int getFirstLabel()
  {
    return this.firstLabel;
  }
  
  public IntList labelToPredecessors(int paramInt)
  {
    if (this.exitPredecessors == null) {
      calcPredecessors();
    }
    IntList localIntList = this.predecessors[paramInt];
    if (localIntList == null) {
      throw new RuntimeException("no such block: " + Hex.u2(paramInt));
    }
    return localIntList;
  }
  
  public RopMethod withRegisterOffset(int paramInt)
  {
    RopMethod localRopMethod = new RopMethod(this.blocks.withRegisterOffset(paramInt), this.firstLabel);
    if (this.exitPredecessors != null)
    {
      localRopMethod.exitPredecessors = this.exitPredecessors;
      localRopMethod.predecessors = this.predecessors;
    }
    return localRopMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.RopMethod
 * JD-Core Version:    0.7.0.1
 */