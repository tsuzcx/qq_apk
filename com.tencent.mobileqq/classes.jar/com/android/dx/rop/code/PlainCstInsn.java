package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;

public final class PlainCstInsn
  extends CstInsn
{
  public PlainCstInsn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList, Constant paramConstant)
  {
    super(paramRop, paramSourcePosition, paramRegisterSpec, paramRegisterSpecList, paramConstant);
    if (paramRop.getBranchingness() != 1) {
      throw new IllegalArgumentException("bogus branchingness");
    }
  }
  
  public void accept(Insn.Visitor paramVisitor)
  {
    paramVisitor.visitPlainCstInsn(this);
  }
  
  public TypeList getCatches()
  {
    return StdTypeList.EMPTY;
  }
  
  public Insn withAddedCatch(Type paramType)
  {
    throw new UnsupportedOperationException("unsupported");
  }
  
  public Insn withNewRegisters(RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList)
  {
    return new PlainCstInsn(getOpcode(), getPosition(), paramRegisterSpec, paramRegisterSpecList, getConstant());
  }
  
  public Insn withRegisterOffset(int paramInt)
  {
    return new PlainCstInsn(getOpcode(), getPosition(), getResult().withOffset(paramInt), getSources().withOffset(paramInt), getConstant());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.PlainCstInsn
 * JD-Core Version:    0.7.0.1
 */