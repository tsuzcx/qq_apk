package com.android.dx.ssa;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;

public final class NormalSsaInsn
  extends SsaInsn
  implements Cloneable
{
  private Insn insn;
  
  NormalSsaInsn(Insn paramInsn, SsaBasicBlock paramSsaBasicBlock)
  {
    super(paramInsn.getResult(), paramSsaBasicBlock);
    this.insn = paramInsn;
  }
  
  public void accept(SsaInsn.Visitor paramVisitor)
  {
    if (isNormalMoveInsn())
    {
      paramVisitor.visitMoveInsn(this);
      return;
    }
    paramVisitor.visitNonMoveInsn(this);
  }
  
  public boolean canThrow()
  {
    return this.insn.canThrow();
  }
  
  public final void changeOneSource(int paramInt, RegisterSpec paramRegisterSpec)
  {
    RegisterSpecList localRegisterSpecList2 = this.insn.getSources();
    int j = localRegisterSpecList2.size();
    RegisterSpecList localRegisterSpecList1 = new RegisterSpecList(j);
    int i = 0;
    if (i < j)
    {
      if (i == paramInt) {}
      for (localRegisterSpec = paramRegisterSpec;; localRegisterSpec = localRegisterSpecList2.get(i))
      {
        localRegisterSpecList1.set(i, localRegisterSpec);
        i += 1;
        break;
      }
    }
    localRegisterSpecList1.setImmutable();
    RegisterSpec localRegisterSpec = localRegisterSpecList2.get(paramInt);
    if (localRegisterSpec.getReg() != paramRegisterSpec.getReg()) {
      getBlock().getParent().onSourceChanged(this, localRegisterSpec, paramRegisterSpec);
    }
    this.insn = this.insn.withNewRegisters(getResult(), localRegisterSpecList1);
  }
  
  public NormalSsaInsn clone()
  {
    return (NormalSsaInsn)super.clone();
  }
  
  public RegisterSpec getLocalAssignment()
  {
    RegisterSpec localRegisterSpec;
    if (this.insn.getOpcode().getOpcode() == 54)
    {
      localRegisterSpec = this.insn.getSources().get(0);
      if (localRegisterSpec != null) {
        break label41;
      }
    }
    label41:
    while (localRegisterSpec.getLocalItem() == null)
    {
      return null;
      localRegisterSpec = getResult();
      break;
    }
    return localRegisterSpec;
  }
  
  public Rop getOpcode()
  {
    return this.insn.getOpcode();
  }
  
  public Insn getOriginalRopInsn()
  {
    return this.insn;
  }
  
  public RegisterSpecList getSources()
  {
    return this.insn.getSources();
  }
  
  public boolean hasSideEffect()
  {
    Rop localRop = getOpcode();
    if (localRop.getBranchingness() != 1) {
      return true;
    }
    if ((Optimizer.getPreserveLocals()) && (getLocalAssignment() != null)) {}
    for (boolean bool = true;; bool = false)
    {
      switch (localRop.getOpcode())
      {
      default: 
        return true;
      }
      return bool;
    }
  }
  
  public boolean isMoveException()
  {
    return this.insn.getOpcode().getOpcode() == 4;
  }
  
  public boolean isNormalMoveInsn()
  {
    return this.insn.getOpcode().getOpcode() == 2;
  }
  
  public boolean isPhiOrMove()
  {
    return isNormalMoveInsn();
  }
  
  public final void mapSourceRegisters(RegisterMapper paramRegisterMapper)
  {
    RegisterSpecList localRegisterSpecList = this.insn.getSources();
    paramRegisterMapper = paramRegisterMapper.map(localRegisterSpecList);
    if (paramRegisterMapper != localRegisterSpecList)
    {
      this.insn = this.insn.withNewRegisters(getResult(), paramRegisterMapper);
      getBlock().getParent().onSourcesChanged(this, localRegisterSpecList);
    }
  }
  
  public final void setNewSources(RegisterSpecList paramRegisterSpecList)
  {
    if (this.insn.getSources().size() != paramRegisterSpecList.size()) {
      throw new RuntimeException("Sources counts don't match");
    }
    this.insn = this.insn.withNewRegisters(getResult(), paramRegisterSpecList);
  }
  
  public String toHuman()
  {
    return toRopInsn().toHuman();
  }
  
  public Insn toRopInsn()
  {
    return this.insn.withNewRegisters(getResult(), this.insn.getSources());
  }
  
  public void upgradeToLiteral()
  {
    RegisterSpecList localRegisterSpecList = this.insn.getSources();
    this.insn = this.insn.withSourceLiteral();
    getBlock().getParent().onSourcesChanged(this, localRegisterSpecList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.NormalSsaInsn
 * JD-Core Version:    0.7.0.1
 */