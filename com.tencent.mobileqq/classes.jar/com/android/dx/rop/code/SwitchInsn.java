package com.android.dx.rop.code;

import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.IntList;

public final class SwitchInsn
  extends Insn
{
  private final IntList cases;
  
  public SwitchInsn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList, IntList paramIntList)
  {
    super(paramRop, paramSourcePosition, paramRegisterSpec, paramRegisterSpecList);
    if (paramRop.getBranchingness() != 5) {
      throw new IllegalArgumentException("bogus branchingness");
    }
    if (paramIntList == null) {
      throw new NullPointerException("cases == null");
    }
    this.cases = paramIntList;
  }
  
  public void accept(Insn.Visitor paramVisitor)
  {
    paramVisitor.visitSwitchInsn(this);
  }
  
  public boolean contentEquals(Insn paramInsn)
  {
    return false;
  }
  
  public IntList getCases()
  {
    return this.cases;
  }
  
  public TypeList getCatches()
  {
    return StdTypeList.EMPTY;
  }
  
  public String getInlineString()
  {
    return this.cases.toString();
  }
  
  public Insn withAddedCatch(Type paramType)
  {
    throw new UnsupportedOperationException("unsupported");
  }
  
  public Insn withNewRegisters(RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList)
  {
    return new SwitchInsn(getOpcode(), getPosition(), paramRegisterSpec, paramRegisterSpecList, this.cases);
  }
  
  public Insn withRegisterOffset(int paramInt)
  {
    return new SwitchInsn(getOpcode(), getPosition(), getResult().withOffset(paramInt), getSources().withOffset(paramInt), this.cases);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.SwitchInsn
 * JD-Core Version:    0.7.0.1
 */