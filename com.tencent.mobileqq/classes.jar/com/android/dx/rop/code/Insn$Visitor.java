package com.android.dx.rop.code;

public abstract interface Insn$Visitor
{
  public abstract void visitFillArrayDataInsn(FillArrayDataInsn paramFillArrayDataInsn);
  
  public abstract void visitPlainCstInsn(PlainCstInsn paramPlainCstInsn);
  
  public abstract void visitPlainInsn(PlainInsn paramPlainInsn);
  
  public abstract void visitSwitchInsn(SwitchInsn paramSwitchInsn);
  
  public abstract void visitThrowingCstInsn(ThrowingCstInsn paramThrowingCstInsn);
  
  public abstract void visitThrowingInsn(ThrowingInsn paramThrowingInsn);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.Insn.Visitor
 * JD-Core Version:    0.7.0.1
 */