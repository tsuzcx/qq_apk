package com.android.dx.ssa.back;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.util.IntList;
import java.util.BitSet;

public class IdenticalBlockCombiner
{
  private final BasicBlockList blocks;
  private final BasicBlockList newBlocks;
  private final RopMethod ropMethod;
  
  public IdenticalBlockCombiner(RopMethod paramRopMethod)
  {
    this.ropMethod = paramRopMethod;
    this.blocks = this.ropMethod.getBlocks();
    this.newBlocks = this.blocks.getMutableCopy();
  }
  
  private void combineBlocks(int paramInt, IntList paramIntList)
  {
    int k = paramIntList.size();
    int i = 0;
    while (i < k)
    {
      int m = paramIntList.get(i);
      Object localObject = this.blocks.labelToBlock(m);
      localObject = this.ropMethod.labelToPredecessors(((BasicBlock)localObject).getLabel());
      int n = ((IntList)localObject).size();
      int j = 0;
      while (j < n)
      {
        replaceSucc(this.newBlocks.labelToBlock(((IntList)localObject).get(j)), m, paramInt);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static boolean compareInsns(BasicBlock paramBasicBlock1, BasicBlock paramBasicBlock2)
  {
    return paramBasicBlock1.getInsns().contentEquals(paramBasicBlock2.getInsns());
  }
  
  private void replaceSucc(BasicBlock paramBasicBlock, int paramInt1, int paramInt2)
  {
    Object localObject = paramBasicBlock.getSuccessors().mutableCopy();
    ((IntList)localObject).set(((IntList)localObject).indexOf(paramInt1), paramInt2);
    int i = paramBasicBlock.getPrimarySuccessor();
    if (i == paramInt1) {}
    for (;;)
    {
      ((IntList)localObject).setImmutable();
      localObject = new BasicBlock(paramBasicBlock.getLabel(), paramBasicBlock.getInsns(), (IntList)localObject, paramInt2);
      this.newBlocks.set(this.newBlocks.indexOfLabel(paramBasicBlock.getLabel()), (BasicBlock)localObject);
      return;
      paramInt2 = i;
    }
  }
  
  public RopMethod process()
  {
    int m = this.blocks.size();
    BitSet localBitSet = new BitSet(this.blocks.getMaxLabel());
    int i = 0;
    while (i < m)
    {
      Object localObject = this.blocks.get(i);
      if (localBitSet.get(((BasicBlock)localObject).getLabel()))
      {
        i += 1;
      }
      else
      {
        localObject = this.ropMethod.labelToPredecessors(((BasicBlock)localObject).getLabel());
        int n = ((IntList)localObject).size();
        int j = 0;
        label86:
        int i1;
        BasicBlock localBasicBlock1;
        if (j < n)
        {
          i1 = ((IntList)localObject).get(j);
          localBasicBlock1 = this.blocks.labelToBlock(i1);
          if ((!localBitSet.get(i1)) && (localBasicBlock1.getSuccessors().size() <= 1) && (localBasicBlock1.getFirstInsn().getOpcode().getOpcode() != 55)) {
            break label156;
          }
        }
        for (;;)
        {
          j += 1;
          break label86;
          break;
          label156:
          IntList localIntList = new IntList();
          int k = j + 1;
          while (k < n)
          {
            int i2 = ((IntList)localObject).get(k);
            BasicBlock localBasicBlock2 = this.blocks.labelToBlock(i2);
            if ((localBasicBlock2.getSuccessors().size() == 1) && (compareInsns(localBasicBlock1, localBasicBlock2)))
            {
              localIntList.add(i2);
              localBitSet.set(i2);
            }
            k += 1;
          }
          combineBlocks(i1, localIntList);
        }
      }
    }
    i = m - 1;
    while (i >= 0)
    {
      if (localBitSet.get(this.newBlocks.get(i).getLabel())) {
        this.newBlocks.set(i, null);
      }
      i -= 1;
    }
    this.newBlocks.shrinkToFit();
    this.newBlocks.setImmutable();
    return new RopMethod(this.newBlocks, this.ropMethod.getFirstLabel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.IdenticalBlockCombiner
 * JD-Core Version:    0.7.0.1
 */