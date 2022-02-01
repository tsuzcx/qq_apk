package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;

public final class CodeAddress
  extends ZeroSizeInsn
{
  private final boolean bindsClosely;
  
  public CodeAddress(SourcePosition paramSourcePosition)
  {
    this(paramSourcePosition, false);
  }
  
  public CodeAddress(SourcePosition paramSourcePosition, boolean paramBoolean)
  {
    super(paramSourcePosition);
    this.bindsClosely = paramBoolean;
  }
  
  protected String argString()
  {
    return null;
  }
  
  public boolean getBindsClosely()
  {
    return this.bindsClosely;
  }
  
  protected String listingString0(boolean paramBoolean)
  {
    return "code-address";
  }
  
  public final DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new CodeAddress(getPosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.CodeAddress
 * JD-Core Version:    0.7.0.1
 */