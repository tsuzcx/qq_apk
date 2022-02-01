package com.android.dx.cf.code;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

class Ropper$SubroutineInliner
{
  private final Ropper.LabelAllocator labelAllocator;
  private final ArrayList<IntList> labelToSubroutines;
  private final HashMap<Integer, Integer> origLabelToCopiedLabel = new HashMap();
  private int subroutineStart;
  private int subroutineSuccessor;
  private final BitSet workList;
  
  Ropper$SubroutineInliner(Ropper.LabelAllocator paramLabelAllocator, ArrayList<IntList> paramArrayList)
  {
    this.workList = new BitSet(Ropper.access$100(paramLabelAllocator));
    this.labelAllocator = paramArrayList;
    Object localObject;
    this.labelToSubroutines = localObject;
  }
  
  private void copyBlock(int paramInt1, int paramInt2)
  {
    BasicBlock localBasicBlock = Ropper.access$300(this.this$0, paramInt1);
    IntList localIntList = localBasicBlock.getSuccessors();
    int j = -1;
    if (Ropper.access$600(this.this$0, localBasicBlock)) {
      localObject = IntList.makeImmutable(mapOrAllocateLabel(localIntList.get(0)), localIntList.get(1));
    }
    for (paramInt1 = j;; paramInt1 = this.subroutineSuccessor)
    {
      Ropper.access$1200(this.this$0, new BasicBlock(paramInt2, Ropper.access$1100(this.this$0, localBasicBlock.getInsns()), (IntList)localObject, paramInt1), (IntList)this.labelToSubroutines.get(paramInt2));
      return;
      localObject = Ropper.access$900(this.this$0, paramInt1);
      if (localObject == null) {
        break;
      }
      if (Ropper.Subroutine.access$1000((Ropper.Subroutine)localObject) != this.subroutineStart) {
        throw new RuntimeException("ret instruction returns to label " + Hex.u2(Ropper.Subroutine.access$1000((Ropper.Subroutine)localObject)) + " expected: " + Hex.u2(this.subroutineStart));
      }
      localObject = IntList.makeImmutable(this.subroutineSuccessor);
    }
    int k = localBasicBlock.getPrimarySuccessor();
    int m = localIntList.size();
    Object localObject = new IntList(m);
    int i = 0;
    paramInt1 = j;
    label221:
    if (i < m)
    {
      int n = localIntList.get(i);
      j = mapOrAllocateLabel(n);
      ((IntList)localObject).add(j);
      if (k != n) {
        break label275;
      }
      paramInt1 = j;
    }
    label275:
    for (;;)
    {
      i += 1;
      break label221;
      ((IntList)localObject).setImmutable();
      break;
    }
  }
  
  private boolean involvedInSubroutine(int paramInt1, int paramInt2)
  {
    IntList localIntList = (IntList)this.labelToSubroutines.get(paramInt1);
    return (localIntList != null) && (localIntList.size() > 0) && (localIntList.top() == paramInt2);
  }
  
  private int mapOrAllocateLabel(int paramInt)
  {
    Integer localInteger = (Integer)this.origLabelToCopiedLabel.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      i = localInteger.intValue();
    }
    do
    {
      return i;
      i = paramInt;
    } while (!involvedInSubroutine(paramInt, this.subroutineStart));
    int i = this.labelAllocator.getNextLabel();
    this.workList.set(paramInt);
    this.origLabelToCopiedLabel.put(Integer.valueOf(paramInt), Integer.valueOf(i));
    while (this.labelToSubroutines.size() <= i) {
      this.labelToSubroutines.add(null);
    }
    this.labelToSubroutines.set(i, this.labelToSubroutines.get(paramInt));
    return i;
  }
  
  void inlineSubroutineCalledFrom(BasicBlock paramBasicBlock)
  {
    this.subroutineSuccessor = paramBasicBlock.getSuccessors().get(0);
    this.subroutineStart = paramBasicBlock.getSuccessors().get(1);
    int j = mapOrAllocateLabel(this.subroutineStart);
    for (int i = this.workList.nextSetBit(0); i >= 0; i = this.workList.nextSetBit(0))
    {
      this.workList.clear(i);
      int k = ((Integer)this.origLabelToCopiedLabel.get(Integer.valueOf(i))).intValue();
      copyBlock(i, k);
      if (Ropper.access$600(this.this$0, Ropper.access$300(this.this$0, i))) {
        new SubroutineInliner(this.this$0, this.labelAllocator, this.labelToSubroutines).inlineSubroutineCalledFrom(Ropper.access$300(this.this$0, k));
      }
    }
    Ropper.access$800(this.this$0, new BasicBlock(paramBasicBlock.getLabel(), paramBasicBlock.getInsns(), IntList.makeImmutable(j), j), (IntList)this.labelToSubroutines.get(paramBasicBlock.getLabel()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper.SubroutineInliner
 * JD-Core Version:    0.7.0.1
 */