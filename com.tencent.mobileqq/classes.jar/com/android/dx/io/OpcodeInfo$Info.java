package com.android.dx.io;

import com.android.dx.io.instructions.InstructionCodec;

public class OpcodeInfo$Info
{
  private final InstructionCodec format;
  private final IndexType indexType;
  private final String name;
  private final int opcode;
  
  public OpcodeInfo$Info(int paramInt, String paramString, InstructionCodec paramInstructionCodec, IndexType paramIndexType)
  {
    this.opcode = paramInt;
    this.name = paramString;
    this.format = paramInstructionCodec;
    this.indexType = paramIndexType;
  }
  
  public InstructionCodec getFormat()
  {
    return this.format;
  }
  
  public IndexType getIndexType()
  {
    return this.indexType;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getOpcode()
  {
    return this.opcode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.OpcodeInfo.Info
 * JD-Core Version:    0.7.0.1
 */