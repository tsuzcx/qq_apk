package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.AnnotatedOutput;

public final class OddSpacer
  extends VariableSizeInsn
{
  public OddSpacer(SourcePosition paramSourcePosition)
  {
    super(paramSourcePosition, RegisterSpecList.EMPTY);
  }
  
  protected String argString()
  {
    return null;
  }
  
  public int codeSize()
  {
    return getAddress() & 0x1;
  }
  
  protected String listingString0(boolean paramBoolean)
  {
    if (codeSize() == 0) {
      return null;
    }
    return "nop // spacer";
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new OddSpacer(getPosition());
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput)
  {
    if (codeSize() != 0) {
      paramAnnotatedOutput.writeShort(InsnFormat.codeUnit(0, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.OddSpacer
 * JD-Core Version:    0.7.0.1
 */