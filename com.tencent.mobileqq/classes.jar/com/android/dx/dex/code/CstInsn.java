package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.Constant;

public final class CstInsn
  extends FixedSizeInsn
{
  private int classIndex;
  private final Constant constant;
  private int index;
  
  public CstInsn(Dop paramDop, SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList, Constant paramConstant)
  {
    super(paramDop, paramSourcePosition, paramRegisterSpecList);
    if (paramConstant == null) {
      throw new NullPointerException("constant == null");
    }
    this.constant = paramConstant;
    this.index = -1;
    this.classIndex = -1;
  }
  
  protected String argString()
  {
    return this.constant.toHuman();
  }
  
  public int getClassIndex()
  {
    if (this.classIndex < 0) {
      throw new RuntimeException("class index not yet set");
    }
    return this.classIndex;
  }
  
  public Constant getConstant()
  {
    return this.constant;
  }
  
  public int getIndex()
  {
    if (this.index < 0) {
      throw new RuntimeException("index not yet set for " + this.constant);
    }
    return this.index;
  }
  
  public boolean hasClassIndex()
  {
    return this.classIndex >= 0;
  }
  
  public boolean hasIndex()
  {
    return this.index >= 0;
  }
  
  public void setClassIndex(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("index < 0");
    }
    if (this.classIndex >= 0) {
      throw new RuntimeException("class index already set");
    }
    this.classIndex = paramInt;
  }
  
  public void setIndex(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("index < 0");
    }
    if (this.index >= 0) {
      throw new RuntimeException("index already set");
    }
    this.index = paramInt;
  }
  
  public DalvInsn withOpcode(Dop paramDop)
  {
    paramDop = new CstInsn(paramDop, getPosition(), getRegisters(), this.constant);
    if (this.index >= 0) {
      paramDop.setIndex(this.index);
    }
    if (this.classIndex >= 0) {
      paramDop.setClassIndex(this.classIndex);
    }
    return paramDop;
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    paramRegisterSpecList = new CstInsn(getOpcode(), getPosition(), paramRegisterSpecList, this.constant);
    if (this.index >= 0) {
      paramRegisterSpecList.setIndex(this.index);
    }
    if (this.classIndex >= 0) {
      paramRegisterSpecList.setClassIndex(this.classIndex);
    }
    return paramRegisterSpecList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.CstInsn
 * JD-Core Version:    0.7.0.1
 */