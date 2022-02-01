package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;

public abstract class VariableSizeInsn
  extends DalvInsn
{
  public VariableSizeInsn(SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList)
  {
    super(Dops.SPECIAL_FORMAT, paramSourcePosition, paramRegisterSpecList);
  }
  
  public final DalvInsn withOpcode(Dop paramDop)
  {
    throw new RuntimeException("unsupported");
  }
  
  public final DalvInsn withRegisterOffset(int paramInt)
  {
    return withRegisters(getRegisters().withOffset(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.VariableSizeInsn
 * JD-Core Version:    0.7.0.1
 */