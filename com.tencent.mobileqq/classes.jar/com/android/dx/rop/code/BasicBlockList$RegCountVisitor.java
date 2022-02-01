package com.android.dx.rop.code;

class BasicBlockList$RegCountVisitor
  implements Insn.Visitor
{
  private int regCount = 0;
  
  private void processReg(RegisterSpec paramRegisterSpec)
  {
    int i = paramRegisterSpec.getNextReg();
    if (i > this.regCount) {
      this.regCount = i;
    }
  }
  
  private void visit(Insn paramInsn)
  {
    RegisterSpec localRegisterSpec = paramInsn.getResult();
    if (localRegisterSpec != null) {
      processReg(localRegisterSpec);
    }
    paramInsn = paramInsn.getSources();
    int j = paramInsn.size();
    int i = 0;
    while (i < j)
    {
      processReg(paramInsn.get(i));
      i += 1;
    }
  }
  
  public int getRegCount()
  {
    return this.regCount;
  }
  
  public void visitFillArrayDataInsn(FillArrayDataInsn paramFillArrayDataInsn)
  {
    visit(paramFillArrayDataInsn);
  }
  
  public void visitPlainCstInsn(PlainCstInsn paramPlainCstInsn)
  {
    visit(paramPlainCstInsn);
  }
  
  public void visitPlainInsn(PlainInsn paramPlainInsn)
  {
    visit(paramPlainInsn);
  }
  
  public void visitSwitchInsn(SwitchInsn paramSwitchInsn)
  {
    visit(paramSwitchInsn);
  }
  
  public void visitThrowingCstInsn(ThrowingCstInsn paramThrowingCstInsn)
  {
    visit(paramThrowingCstInsn);
  }
  
  public void visitThrowingInsn(ThrowingInsn paramThrowingInsn)
  {
    visit(paramThrowingInsn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.BasicBlockList.RegCountVisitor
 * JD-Core Version:    0.7.0.1
 */