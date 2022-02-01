package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;

public final class SimpleInsn
  extends FixedSizeInsn
{
  public SimpleInsn(Dop paramDop, SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList)
  {
    super(paramDop, paramSourcePosition, paramRegisterSpecList);
  }
  
  protected String argString()
  {
    return null;
  }
  
  public DalvInsn withOpcode(Dop paramDop)
  {
    return new SimpleInsn(paramDop, getPosition(), getRegisters());
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new SimpleInsn(getOpcode(), getPosition(), paramRegisterSpecList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.SimpleInsn
 * JD-Core Version:    0.7.0.1
 */