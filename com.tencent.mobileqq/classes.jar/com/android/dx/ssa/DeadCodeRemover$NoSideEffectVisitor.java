package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import java.util.BitSet;

class DeadCodeRemover$NoSideEffectVisitor
  implements SsaInsn.Visitor
{
  BitSet noSideEffectRegs;
  
  public DeadCodeRemover$NoSideEffectVisitor(BitSet paramBitSet)
  {
    this.noSideEffectRegs = paramBitSet;
  }
  
  public void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    if (!DeadCodeRemover.access$000(paramNormalSsaInsn)) {
      this.noSideEffectRegs.set(paramNormalSsaInsn.getResult().getReg());
    }
  }
  
  public void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    RegisterSpec localRegisterSpec = paramNormalSsaInsn.getResult();
    if ((!DeadCodeRemover.access$000(paramNormalSsaInsn)) && (localRegisterSpec != null)) {
      this.noSideEffectRegs.set(localRegisterSpec.getReg());
    }
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn)
  {
    if (!DeadCodeRemover.access$000(paramPhiInsn)) {
      this.noSideEffectRegs.set(paramPhiInsn.getResult().getReg());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.DeadCodeRemover.NoSideEffectVisitor
 * JD-Core Version:    0.7.0.1
 */