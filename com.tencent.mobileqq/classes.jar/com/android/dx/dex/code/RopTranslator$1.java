package com.android.dx.dex.code;

import com.android.dx.rop.code.Insn.BaseVisitor;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.cst.CstInteger;

final class RopTranslator$1
  extends Insn.BaseVisitor
{
  RopTranslator$1(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2) {}
  
  public void visitPlainCstInsn(PlainCstInsn paramPlainCstInsn)
  {
    boolean[] arrayOfBoolean;
    if (paramPlainCstInsn.getOpcode().getOpcode() == 3)
    {
      int i = ((CstInteger)paramPlainCstInsn.getConstant()).getValue();
      arrayOfBoolean = this.val$paramsAreInOrder;
      if ((this.val$paramsAreInOrder[0] == 0) || (i + (this.val$initialRegCount - this.val$paramSize) != paramPlainCstInsn.getResult().getReg())) {
        break label66;
      }
    }
    label66:
    for (int j = 1;; j = 0)
    {
      arrayOfBoolean[0] = j;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.RopTranslator.1
 * JD-Core Version:    0.7.0.1
 */