package com.android.dx.dex.code;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.LocalVariableInfo;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.SwitchInsn;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;

class RopTranslator$LocalVariableAwareTranslationVisitor
  extends RopTranslator.TranslationVisitor
{
  private LocalVariableInfo locals;
  
  public RopTranslator$LocalVariableAwareTranslationVisitor(RopTranslator paramRopTranslator, OutputCollector paramOutputCollector, LocalVariableInfo paramLocalVariableInfo)
  {
    super(paramRopTranslator, paramOutputCollector);
    this.locals = paramLocalVariableInfo;
  }
  
  public void addIntroductionIfNecessary(Insn paramInsn)
  {
    RegisterSpec localRegisterSpec = this.locals.getAssignment(paramInsn);
    if (localRegisterSpec != null) {
      addOutput(new LocalStart(paramInsn.getPosition(), localRegisterSpec));
    }
  }
  
  public void visitPlainCstInsn(PlainCstInsn paramPlainCstInsn)
  {
    super.visitPlainCstInsn(paramPlainCstInsn);
    addIntroductionIfNecessary(paramPlainCstInsn);
  }
  
  public void visitPlainInsn(PlainInsn paramPlainInsn)
  {
    super.visitPlainInsn(paramPlainInsn);
    addIntroductionIfNecessary(paramPlainInsn);
  }
  
  public void visitSwitchInsn(SwitchInsn paramSwitchInsn)
  {
    super.visitSwitchInsn(paramSwitchInsn);
    addIntroductionIfNecessary(paramSwitchInsn);
  }
  
  public void visitThrowingCstInsn(ThrowingCstInsn paramThrowingCstInsn)
  {
    super.visitThrowingCstInsn(paramThrowingCstInsn);
    addIntroductionIfNecessary(paramThrowingCstInsn);
  }
  
  public void visitThrowingInsn(ThrowingInsn paramThrowingInsn)
  {
    super.visitThrowingInsn(paramThrowingInsn);
    addIntroductionIfNecessary(paramThrowingInsn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.RopTranslator.LocalVariableAwareTranslationVisitor
 * JD-Core Version:    0.7.0.1
 */