package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpecList;
import java.util.ArrayList;

class SsaMethod$2
  implements SsaInsn.Visitor
{
  SsaMethod$2(SsaMethod paramSsaMethod) {}
  
  private void addToUses(SsaInsn paramSsaInsn)
  {
    RegisterSpecList localRegisterSpecList = paramSsaInsn.getSources();
    int j = localRegisterSpecList.size();
    int i = 0;
    while (i < j)
    {
      SsaMethod.access$100(this.this$0)[localRegisterSpecList.get(i).getReg()].add(paramSsaInsn);
      i += 1;
    }
  }
  
  public void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    addToUses(paramNormalSsaInsn);
  }
  
  public void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    addToUses(paramNormalSsaInsn);
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn)
  {
    addToUses(paramPhiInsn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaMethod.2
 * JD-Core Version:    0.7.0.1
 */