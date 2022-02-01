package com.android.dx.dex.code;

import com.android.dx.io.OpcodeInfo;
import com.android.dx.io.Opcodes;

public final class Dop
{
  private final int family;
  private final InsnFormat format;
  private final boolean hasResult;
  private final int nextOpcode;
  private final int opcode;
  
  public Dop(int paramInt1, int paramInt2, int paramInt3, InsnFormat paramInsnFormat, boolean paramBoolean)
  {
    if (!Opcodes.isValidShape(paramInt1)) {
      throw new IllegalArgumentException("bogus opcode");
    }
    if (!Opcodes.isValidShape(paramInt2)) {
      throw new IllegalArgumentException("bogus family");
    }
    if (!Opcodes.isValidShape(paramInt3)) {
      throw new IllegalArgumentException("bogus nextOpcode");
    }
    if (paramInsnFormat == null) {
      throw new NullPointerException("format == null");
    }
    this.opcode = paramInt1;
    this.family = paramInt2;
    this.nextOpcode = paramInt3;
    this.format = paramInsnFormat;
    this.hasResult = paramBoolean;
  }
  
  public int getFamily()
  {
    return this.family;
  }
  
  public InsnFormat getFormat()
  {
    return this.format;
  }
  
  public String getName()
  {
    return OpcodeInfo.getName(this.opcode);
  }
  
  public int getNextOpcode()
  {
    return this.nextOpcode;
  }
  
  public int getOpcode()
  {
    return this.opcode;
  }
  
  public Dop getOppositeTest()
  {
    switch (this.opcode)
    {
    default: 
      throw new IllegalArgumentException("bogus opcode: " + this);
    case 50: 
      return Dops.IF_NE;
    case 51: 
      return Dops.IF_EQ;
    case 52: 
      return Dops.IF_GE;
    case 53: 
      return Dops.IF_LT;
    case 54: 
      return Dops.IF_LE;
    case 55: 
      return Dops.IF_GT;
    case 56: 
      return Dops.IF_NEZ;
    case 57: 
      return Dops.IF_EQZ;
    case 58: 
      return Dops.IF_GEZ;
    case 59: 
      return Dops.IF_LTZ;
    case 60: 
      return Dops.IF_LEZ;
    }
    return Dops.IF_GTZ;
  }
  
  public boolean hasResult()
  {
    return this.hasResult;
  }
  
  public String toString()
  {
    return getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.Dop
 * JD-Core Version:    0.7.0.1
 */