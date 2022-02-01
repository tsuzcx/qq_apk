package com.android.dx.ssa;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.RegOps;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.TranslationAdvice;

class LiteralOpUpgrader$1
  implements SsaInsn.Visitor
{
  LiteralOpUpgrader$1(LiteralOpUpgrader paramLiteralOpUpgrader, TranslationAdvice paramTranslationAdvice) {}
  
  public void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn) {}
  
  public void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    Rop localRop = paramNormalSsaInsn.getOriginalRopInsn().getOpcode();
    RegisterSpecList localRegisterSpecList = paramNormalSsaInsn.getSources();
    if (LiteralOpUpgrader.access$000(this.this$0, paramNormalSsaInsn)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (localRegisterSpecList.size() != 2);
        if (localRop.getBranchingness() != 4) {
          break;
        }
        if (LiteralOpUpgrader.access$100(localRegisterSpecList.get(0)))
        {
          LiteralOpUpgrader.access$200(this.this$0, paramNormalSsaInsn, localRegisterSpecList.withoutFirst(), RegOps.flippedIfOpcode(localRop.getOpcode()), null);
          return;
        }
      } while (!LiteralOpUpgrader.access$100(localRegisterSpecList.get(1)));
      LiteralOpUpgrader.access$200(this.this$0, paramNormalSsaInsn, localRegisterSpecList.withoutLast(), localRop.getOpcode(), null);
      return;
      if (this.val$advice.hasConstantOperation(localRop, localRegisterSpecList.get(0), localRegisterSpecList.get(1)))
      {
        paramNormalSsaInsn.upgradeToLiteral();
        return;
      }
    } while ((!localRop.isCommutative()) || (!this.val$advice.hasConstantOperation(localRop, localRegisterSpecList.get(1), localRegisterSpecList.get(0))));
    paramNormalSsaInsn.setNewSources(RegisterSpecList.make(localRegisterSpecList.get(1), localRegisterSpecList.get(0)));
    paramNormalSsaInsn.upgradeToLiteral();
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.LiteralOpUpgrader.1
 * JD-Core Version:    0.7.0.1
 */