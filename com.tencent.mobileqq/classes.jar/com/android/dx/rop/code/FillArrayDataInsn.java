package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import java.util.ArrayList;

public final class FillArrayDataInsn
  extends Insn
{
  private final Constant arrayType;
  private final ArrayList<Constant> initValues;
  
  public FillArrayDataInsn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList, ArrayList<Constant> paramArrayList, Constant paramConstant)
  {
    super(paramRop, paramSourcePosition, null, paramRegisterSpecList);
    if (paramRop.getBranchingness() != 1) {
      throw new IllegalArgumentException("bogus branchingness");
    }
    this.initValues = paramArrayList;
    this.arrayType = paramConstant;
  }
  
  public void accept(Insn.Visitor paramVisitor)
  {
    paramVisitor.visitFillArrayDataInsn(this);
  }
  
  public TypeList getCatches()
  {
    return StdTypeList.EMPTY;
  }
  
  public Constant getConstant()
  {
    return this.arrayType;
  }
  
  public ArrayList<Constant> getInitValues()
  {
    return this.initValues;
  }
  
  public Insn withAddedCatch(Type paramType)
  {
    throw new UnsupportedOperationException("unsupported");
  }
  
  public Insn withNewRegisters(RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList)
  {
    return new FillArrayDataInsn(getOpcode(), getPosition(), paramRegisterSpecList, this.initValues, this.arrayType);
  }
  
  public Insn withRegisterOffset(int paramInt)
  {
    return new FillArrayDataInsn(getOpcode(), getPosition(), getSources().withOffset(paramInt), this.initValues, this.arrayType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.FillArrayDataInsn
 * JD-Core Version:    0.7.0.1
 */