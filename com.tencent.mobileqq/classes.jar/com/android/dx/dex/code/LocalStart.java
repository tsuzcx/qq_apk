package com.android.dx.dex.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.ssa.RegisterMapper;

public final class LocalStart
  extends ZeroSizeInsn
{
  private final RegisterSpec local;
  
  public LocalStart(SourcePosition paramSourcePosition, RegisterSpec paramRegisterSpec)
  {
    super(paramSourcePosition);
    if (paramRegisterSpec == null) {
      throw new NullPointerException("local == null");
    }
    this.local = paramRegisterSpec;
  }
  
  public static String localString(RegisterSpec paramRegisterSpec)
  {
    return paramRegisterSpec.regString() + ' ' + paramRegisterSpec.getLocalItem().toString() + ": " + paramRegisterSpec.getTypeBearer().toHuman();
  }
  
  protected String argString()
  {
    return this.local.toString();
  }
  
  public RegisterSpec getLocal()
  {
    return this.local;
  }
  
  protected String listingString0(boolean paramBoolean)
  {
    return "local-start " + localString(this.local);
  }
  
  public DalvInsn withMapper(RegisterMapper paramRegisterMapper)
  {
    return new LocalStart(getPosition(), paramRegisterMapper.map(this.local));
  }
  
  public DalvInsn withRegisterOffset(int paramInt)
  {
    return new LocalStart(getPosition(), this.local.withOffset(paramInt));
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new LocalStart(getPosition(), this.local);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.LocalStart
 * JD-Core Version:    0.7.0.1
 */