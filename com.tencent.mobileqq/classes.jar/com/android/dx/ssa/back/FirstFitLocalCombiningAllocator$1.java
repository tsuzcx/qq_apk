package com.android.dx.ssa.back;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.Optimizer;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaInsn.Visitor;
import java.util.ArrayList;
import java.util.Map;

class FirstFitLocalCombiningAllocator$1
  implements SsaInsn.Visitor
{
  FirstFitLocalCombiningAllocator$1(FirstFitLocalCombiningAllocator paramFirstFitLocalCombiningAllocator) {}
  
  private void processInsn(SsaInsn paramSsaInsn)
  {
    RegisterSpec localRegisterSpec = paramSsaInsn.getLocalAssignment();
    if (localRegisterSpec != null)
    {
      LocalItem localLocalItem = localRegisterSpec.getLocalItem();
      ArrayList localArrayList2 = (ArrayList)FirstFitLocalCombiningAllocator.access$200(this.this$0).get(localLocalItem);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        FirstFitLocalCombiningAllocator.access$200(this.this$0).put(localLocalItem, localArrayList1);
      }
      localArrayList1.add(localRegisterSpec);
    }
    if ((paramSsaInsn instanceof NormalSsaInsn)) {
      if (paramSsaInsn.getOpcode().getOpcode() != 56) {}
    }
    while (!(paramSsaInsn instanceof PhiInsn))
    {
      FirstFitLocalCombiningAllocator.access$300(this.this$0).add((NormalSsaInsn)paramSsaInsn);
      do
      {
        return;
      } while (!Optimizer.getAdvice().requiresSourcesInOrder(paramSsaInsn.getOriginalRopInsn().getOpcode(), paramSsaInsn.getSources()));
      FirstFitLocalCombiningAllocator.access$400(this.this$0).add((NormalSsaInsn)paramSsaInsn);
      return;
    }
    FirstFitLocalCombiningAllocator.access$500(this.this$0).add((PhiInsn)paramSsaInsn);
  }
  
  public void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    processInsn(paramNormalSsaInsn);
  }
  
  public void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    processInsn(paramNormalSsaInsn);
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn)
  {
    processInsn(paramPhiInsn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.1
 * JD-Core Version:    0.7.0.1
 */