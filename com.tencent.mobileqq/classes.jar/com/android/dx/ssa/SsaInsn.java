package com.android.dx.ssa;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.util.ToHuman;

public abstract class SsaInsn
  implements ToHuman, Cloneable
{
  private final SsaBasicBlock block;
  private RegisterSpec result;
  
  protected SsaInsn(RegisterSpec paramRegisterSpec, SsaBasicBlock paramSsaBasicBlock)
  {
    if (paramSsaBasicBlock == null) {
      throw new NullPointerException("block == null");
    }
    this.block = paramSsaBasicBlock;
    this.result = paramRegisterSpec;
  }
  
  public static SsaInsn makeFromRop(Insn paramInsn, SsaBasicBlock paramSsaBasicBlock)
  {
    return new NormalSsaInsn(paramInsn, paramSsaBasicBlock);
  }
  
  public abstract void accept(SsaInsn.Visitor paramVisitor);
  
  public abstract boolean canThrow();
  
  public void changeResultReg(int paramInt)
  {
    if (this.result != null) {
      this.result = this.result.withReg(paramInt);
    }
  }
  
  public SsaInsn clone()
  {
    try
    {
      SsaInsn localSsaInsn = (SsaInsn)super.clone();
      return localSsaInsn;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException("unexpected", localCloneNotSupportedException);
    }
  }
  
  public SsaBasicBlock getBlock()
  {
    return this.block;
  }
  
  public RegisterSpec getLocalAssignment()
  {
    if ((this.result != null) && (this.result.getLocalItem() != null)) {
      return this.result;
    }
    return null;
  }
  
  public abstract Rop getOpcode();
  
  public abstract Insn getOriginalRopInsn();
  
  public RegisterSpec getResult()
  {
    return this.result;
  }
  
  public abstract RegisterSpecList getSources();
  
  public abstract boolean hasSideEffect();
  
  public boolean isMoveException()
  {
    return false;
  }
  
  public boolean isNormalMoveInsn()
  {
    return false;
  }
  
  public abstract boolean isPhiOrMove();
  
  public boolean isRegASource(int paramInt)
  {
    return getSources().specForRegister(paramInt) != null;
  }
  
  public boolean isResultReg(int paramInt)
  {
    return (this.result != null) && (this.result.getReg() == paramInt);
  }
  
  public final void mapRegisters(RegisterMapper paramRegisterMapper)
  {
    RegisterSpec localRegisterSpec = this.result;
    this.result = paramRegisterMapper.map(this.result);
    this.block.getParent().updateOneDefinition(this, localRegisterSpec);
    mapSourceRegisters(paramRegisterMapper);
  }
  
  public abstract void mapSourceRegisters(RegisterMapper paramRegisterMapper);
  
  protected void setResult(RegisterSpec paramRegisterSpec)
  {
    if (paramRegisterSpec == null) {
      throw new NullPointerException("result == null");
    }
    this.result = paramRegisterSpec;
  }
  
  public final void setResultLocal(LocalItem paramLocalItem)
  {
    if ((paramLocalItem != this.result.getLocalItem()) && ((paramLocalItem == null) || (!paramLocalItem.equals(this.result.getLocalItem())))) {
      this.result = RegisterSpec.makeLocalOptional(this.result.getReg(), this.result.getType(), paramLocalItem);
    }
  }
  
  public abstract Insn toRopInsn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaInsn
 * JD-Core Version:    0.7.0.1
 */