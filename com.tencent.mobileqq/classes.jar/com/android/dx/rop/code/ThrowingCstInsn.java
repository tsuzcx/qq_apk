package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;

public final class ThrowingCstInsn
  extends CstInsn
{
  private final TypeList catches;
  
  public ThrowingCstInsn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList, TypeList paramTypeList, Constant paramConstant)
  {
    super(paramRop, paramSourcePosition, null, paramRegisterSpecList, paramConstant);
    if (paramRop.getBranchingness() != 6) {
      throw new IllegalArgumentException("bogus branchingness");
    }
    if (paramTypeList == null) {
      throw new NullPointerException("catches == null");
    }
    this.catches = paramTypeList;
  }
  
  public void accept(Insn.Visitor paramVisitor)
  {
    paramVisitor.visitThrowingCstInsn(this);
  }
  
  public TypeList getCatches()
  {
    return this.catches;
  }
  
  public String getInlineString()
  {
    Constant localConstant = getConstant();
    String str = localConstant.toHuman();
    if ((localConstant instanceof CstString)) {
      str = ((CstString)localConstant).toQuoted();
    }
    for (;;)
    {
      return str + " " + ThrowingInsn.toCatchString(this.catches);
    }
  }
  
  public Insn withAddedCatch(Type paramType)
  {
    return new ThrowingCstInsn(getOpcode(), getPosition(), getSources(), this.catches.withAddedType(paramType), getConstant());
  }
  
  public Insn withNewRegisters(RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList)
  {
    return new ThrowingCstInsn(getOpcode(), getPosition(), paramRegisterSpecList, this.catches, getConstant());
  }
  
  public Insn withRegisterOffset(int paramInt)
  {
    return new ThrowingCstInsn(getOpcode(), getPosition(), getSources().withOffset(paramInt), this.catches, getConstant());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.ThrowingCstInsn
 * JD-Core Version:    0.7.0.1
 */