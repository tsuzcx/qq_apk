package com.android.dx.ssa.back;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.PhiInsn.Visitor;
import com.android.dx.ssa.SsaBasicBlock;
import java.util.ArrayList;

class SsaToRop$PhiVisitor
  implements PhiInsn.Visitor
{
  private final ArrayList<SsaBasicBlock> blocks;
  
  public SsaToRop$PhiVisitor(ArrayList<SsaBasicBlock> paramArrayList)
  {
    this.blocks = paramArrayList;
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn)
  {
    RegisterSpecList localRegisterSpecList = paramPhiInsn.getSources();
    RegisterSpec localRegisterSpec1 = paramPhiInsn.getResult();
    int j = localRegisterSpecList.size();
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec2 = localRegisterSpecList.get(i);
      ((SsaBasicBlock)this.blocks.get(paramPhiInsn.predBlockIndexForSourcesIndex(i))).addMoveToEnd(localRegisterSpec1, localRegisterSpec2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.SsaToRop.PhiVisitor
 * JD-Core Version:    0.7.0.1
 */