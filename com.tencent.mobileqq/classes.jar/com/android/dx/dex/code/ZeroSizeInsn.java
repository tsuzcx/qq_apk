package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.AnnotatedOutput;

public abstract class ZeroSizeInsn
  extends DalvInsn
{
  public ZeroSizeInsn(SourcePosition paramSourcePosition)
  {
    super(Dops.SPECIAL_FORMAT, paramSourcePosition, RegisterSpecList.EMPTY);
  }
  
  public final int codeSize()
  {
    return 0;
  }
  
  public final DalvInsn withOpcode(Dop paramDop)
  {
    throw new RuntimeException("unsupported");
  }
  
  public DalvInsn withRegisterOffset(int paramInt)
  {
    return withRegisters(getRegisters().withOffset(paramInt));
  }
  
  public final void writeTo(AnnotatedOutput paramAnnotatedOutput) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.ZeroSizeInsn
 * JD-Core Version:    0.7.0.1
 */