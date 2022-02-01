package com.android.dx.rop.code;

import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;

public final class ThrowingInsn
  extends Insn
{
  private final TypeList catches;
  
  public ThrowingInsn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList, TypeList paramTypeList)
  {
    super(paramRop, paramSourcePosition, null, paramRegisterSpecList);
    if (paramRop.getBranchingness() != 6) {
      throw new IllegalArgumentException("bogus branchingness");
    }
    if (paramTypeList == null) {
      throw new NullPointerException("catches == null");
    }
    this.catches = paramTypeList;
  }
  
  public static String toCatchString(TypeList paramTypeList)
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append("catch");
    int j = paramTypeList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(paramTypeList.getType(i).toHuman());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void accept(Insn.Visitor paramVisitor)
  {
    paramVisitor.visitThrowingInsn(this);
  }
  
  public TypeList getCatches()
  {
    return this.catches;
  }
  
  public String getInlineString()
  {
    return toCatchString(this.catches);
  }
  
  public Insn withAddedCatch(Type paramType)
  {
    return new ThrowingInsn(getOpcode(), getPosition(), getSources(), this.catches.withAddedType(paramType));
  }
  
  public Insn withNewRegisters(RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList)
  {
    return new ThrowingInsn(getOpcode(), getPosition(), paramRegisterSpecList, this.catches);
  }
  
  public Insn withRegisterOffset(int paramInt)
  {
    return new ThrowingInsn(getOpcode(), getPosition(), getSources().withOffset(paramInt), this.catches);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.ThrowingInsn
 * JD-Core Version:    0.7.0.1
 */