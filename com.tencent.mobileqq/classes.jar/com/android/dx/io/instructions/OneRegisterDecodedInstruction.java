package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

public final class OneRegisterDecodedInstruction
  extends DecodedInstruction
{
  private final int a;
  
  public OneRegisterDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt1, int paramInt2, IndexType paramIndexType, int paramInt3, long paramLong, int paramInt4)
  {
    super(paramInstructionCodec, paramInt1, paramInt2, paramIndexType, paramInt3, paramLong);
    this.a = paramInt4;
  }
  
  public int getA()
  {
    return this.a;
  }
  
  public int getRegisterCount()
  {
    return 1;
  }
  
  public DecodedInstruction withIndex(int paramInt)
  {
    return new OneRegisterDecodedInstruction(getFormat(), getOpcode(), paramInt, getIndexType(), getTarget(), getLiteral(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.OneRegisterDecodedInstruction
 * JD-Core Version:    0.7.0.1
 */