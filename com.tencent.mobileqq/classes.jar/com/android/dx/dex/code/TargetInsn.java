package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;

public final class TargetInsn
  extends FixedSizeInsn
{
  private CodeAddress target;
  
  public TargetInsn(Dop paramDop, SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList, CodeAddress paramCodeAddress)
  {
    super(paramDop, paramSourcePosition, paramRegisterSpecList);
    if (paramCodeAddress == null) {
      throw new NullPointerException("target == null");
    }
    this.target = paramCodeAddress;
  }
  
  protected String argString()
  {
    if (this.target == null) {
      return "????";
    }
    return this.target.identifierString();
  }
  
  public CodeAddress getTarget()
  {
    return this.target;
  }
  
  public int getTargetAddress()
  {
    return this.target.getAddress();
  }
  
  public int getTargetOffset()
  {
    return this.target.getAddress() - getAddress();
  }
  
  public boolean hasTargetOffset()
  {
    return (hasAddress()) && (this.target.hasAddress());
  }
  
  public TargetInsn withNewTargetAndReversed(CodeAddress paramCodeAddress)
  {
    return new TargetInsn(getOpcode().getOppositeTest(), getPosition(), getRegisters(), paramCodeAddress);
  }
  
  public DalvInsn withOpcode(Dop paramDop)
  {
    return new TargetInsn(paramDop, getPosition(), getRegisters(), this.target);
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new TargetInsn(getOpcode(), getPosition(), paramRegisterSpecList, this.target);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.TargetInsn
 * JD-Core Version:    0.7.0.1
 */