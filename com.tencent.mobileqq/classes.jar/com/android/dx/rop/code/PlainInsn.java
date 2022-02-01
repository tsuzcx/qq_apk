package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.rop.type.TypeList;

public final class PlainInsn
  extends Insn
{
  public PlainInsn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    this(paramRop, paramSourcePosition, paramRegisterSpec1, RegisterSpecList.make(paramRegisterSpec2));
  }
  
  public PlainInsn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList)
  {
    super(paramRop, paramSourcePosition, paramRegisterSpec, paramRegisterSpecList);
    switch (paramRop.getBranchingness())
    {
    default: 
      if ((paramRegisterSpec != null) && (paramRop.getBranchingness() != 1)) {
        throw new IllegalArgumentException("can't mix branchingness with result");
      }
      break;
    case 5: 
    case 6: 
      throw new IllegalArgumentException("bogus branchingness");
    }
  }
  
  public void accept(Insn.Visitor paramVisitor)
  {
    paramVisitor.visitPlainInsn(this);
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
    return new PlainInsn(getOpcode(), getPosition(), paramRegisterSpec, paramRegisterSpecList);
  }
  
  public Insn withRegisterOffset(int paramInt)
  {
    return new PlainInsn(getOpcode(), getPosition(), getResult().withOffset(paramInt), getSources().withOffset(paramInt));
  }
  
  public Insn withSourceLiteral()
  {
    RegisterSpecList localRegisterSpecList = getSources();
    int i = localRegisterSpecList.size();
    if (i == 0) {}
    do
    {
      return this;
      localObject = localRegisterSpecList.get(i - 1).getTypeBearer();
      if (((TypeBearer)localObject).isConstant()) {
        break;
      }
      localObject = localRegisterSpecList.get(0).getTypeBearer();
    } while ((i != 2) || (!((TypeBearer)localObject).isConstant()));
    Object localObject = (Constant)localObject;
    localRegisterSpecList = localRegisterSpecList.withoutFirst();
    return new PlainCstInsn(Rops.ropFor(getOpcode().getOpcode(), getResult(), localRegisterSpecList, (Constant)localObject), getPosition(), getResult(), localRegisterSpecList, (Constant)localObject);
    localObject = (Constant)localObject;
    localRegisterSpecList = localRegisterSpecList.withoutLast();
    for (;;)
    {
      try
      {
        i = getOpcode().getOpcode();
        if ((i == 15) && ((localObject instanceof CstInteger)))
        {
          localObject = CstInteger.make(-((CstInteger)localObject).getValue());
          i = 14;
          Rop localRop = Rops.ropFor(i, getResult(), localRegisterSpecList, (Constant)localObject);
          return new PlainCstInsn(localRop, getPosition(), getResult(), localRegisterSpecList, (Constant)localObject);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.PlainInsn
 * JD-Core Version:    0.7.0.1
 */