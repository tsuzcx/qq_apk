package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

public final class RegisterRangeDecodedInstruction
  extends DecodedInstruction
{
  private final int a;
  private final int registerCount;
  
  public RegisterRangeDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt1, int paramInt2, IndexType paramIndexType, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    super(paramInstructionCodec, paramInt1, paramInt2, paramIndexType, paramInt3, paramLong);
    this.a = paramInt4;
    this.registerCount = paramInt5;
  }
  
  public int getA()
  {
    return this.a;
  }
  
  public int getRegisterCount()
  {
    return this.registerCount;
  }
  
  public DecodedInstruction withIndex(int paramInt)
  {
    return new RegisterRangeDecodedInstruction(getFormat(), getOpcode(), paramInt, getIndexType(), getTarget(), getLiteral(), this.a, this.registerCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.RegisterRangeDecodedInstruction
 * JD-Core Version:    0.7.0.1
 */