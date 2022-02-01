package com.android.dx.ssa.back;

import com.android.dx.rop.code.Rops;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaBasicBlock.Visitor;
import com.android.dx.ssa.SsaInsn;
import java.util.ArrayList;
import java.util.BitSet;

class SsaToRop$1
  implements SsaBasicBlock.Visitor
{
  SsaToRop$1(SsaToRop paramSsaToRop, ArrayList paramArrayList) {}
  
  public void visitBlock(SsaBasicBlock paramSsaBasicBlock1, SsaBasicBlock paramSsaBasicBlock2)
  {
    paramSsaBasicBlock2 = paramSsaBasicBlock1.getInsns();
    if ((paramSsaBasicBlock2.size() == 1) && (((SsaInsn)paramSsaBasicBlock2.get(0)).getOpcode() == Rops.GOTO))
    {
      paramSsaBasicBlock2 = (BitSet)paramSsaBasicBlock1.getPredecessors().clone();
      for (int i = paramSsaBasicBlock2.nextSetBit(0); i >= 0; i = paramSsaBasicBlock2.nextSetBit(i + 1)) {
        ((SsaBasicBlock)this.val$blocks.get(i)).replaceSuccessor(paramSsaBasicBlock1.getIndex(), paramSsaBasicBlock1.getPrimarySuccessorIndex());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.SsaToRop.1
 * JD-Core Version:    0.7.0.1
 */