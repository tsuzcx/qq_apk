package com.android.dx.ssa;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.Rop;
import java.util.HashSet;
import java.util.List;

class MoveParamCombiner$1
  implements SsaInsn.Visitor
{
  MoveParamCombiner$1(MoveParamCombiner paramMoveParamCombiner, RegisterSpec[] paramArrayOfRegisterSpec, HashSet paramHashSet) {}
  
  public void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn) {}
  
  public void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    if (paramNormalSsaInsn.getOpcode().getOpcode() != 3) {
      return;
    }
    int i = MoveParamCombiner.access$000(this.this$0, paramNormalSsaInsn);
    if (this.val$paramSpecs[i] == null)
    {
      this.val$paramSpecs[i] = paramNormalSsaInsn.getResult();
      return;
    }
    RegisterSpec localRegisterSpec2 = this.val$paramSpecs[i];
    RegisterSpec localRegisterSpec1 = paramNormalSsaInsn.getResult();
    Object localObject1 = localRegisterSpec2.getLocalItem();
    Object localObject2 = localRegisterSpec1.getLocalItem();
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      MoveParamCombiner.access$100(this.this$0).getDefinitionForRegister(localRegisterSpec2.getReg()).setResultLocal((LocalItem)localObject1);
      localObject1 = new MoveParamCombiner.1.1(this, localRegisterSpec1, localRegisterSpec2);
      localObject2 = MoveParamCombiner.access$100(this.this$0).getUseListForRegister(localRegisterSpec1.getReg());
      i = ((List)localObject2).size() - 1;
      while (i >= 0)
      {
        ((SsaInsn)((List)localObject2).get(i)).mapSourceRegisters((RegisterMapper)localObject1);
        i -= 1;
      }
      if (localObject2 != null) {
        if (!((LocalItem)localObject1).equals(localObject2)) {
          break;
        }
      }
    }
    this.val$deletedInsns.add(paramNormalSsaInsn);
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.MoveParamCombiner.1
 * JD-Core Version:    0.7.0.1
 */