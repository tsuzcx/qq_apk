package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.ssa.RegisterMapper;

public final class LocalSnapshot
  extends ZeroSizeInsn
{
  private final RegisterSpecSet locals;
  
  public LocalSnapshot(SourcePosition paramSourcePosition, RegisterSpecSet paramRegisterSpecSet)
  {
    super(paramSourcePosition);
    if (paramRegisterSpecSet == null) {
      throw new NullPointerException("locals == null");
    }
    this.locals = paramRegisterSpecSet;
  }
  
  protected String argString()
  {
    return this.locals.toString();
  }
  
  public RegisterSpecSet getLocals()
  {
    return this.locals;
  }
  
  protected String listingString0(boolean paramBoolean)
  {
    int i = this.locals.size();
    int j = this.locals.getMaxSize();
    StringBuffer localStringBuffer = new StringBuffer(i * 40 + 100);
    localStringBuffer.append("local-snapshot");
    i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = this.locals.get(i);
      if (localRegisterSpec != null)
      {
        localStringBuffer.append("\n  ");
        localStringBuffer.append(LocalStart.localString(localRegisterSpec));
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public DalvInsn withMapper(RegisterMapper paramRegisterMapper)
  {
    return new LocalSnapshot(getPosition(), paramRegisterMapper.map(this.locals));
  }
  
  public DalvInsn withRegisterOffset(int paramInt)
  {
    return new LocalSnapshot(getPosition(), this.locals.withOffset(paramInt));
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new LocalSnapshot(getPosition(), this.locals);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.LocalSnapshot
 * JD-Core Version:    0.7.0.1
 */