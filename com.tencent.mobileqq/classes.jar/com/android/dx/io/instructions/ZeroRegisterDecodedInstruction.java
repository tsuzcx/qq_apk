package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

public final class ZeroRegisterDecodedInstruction
  extends DecodedInstruction
{
  public ZeroRegisterDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt1, int paramInt2, IndexType paramIndexType, int paramInt3, long paramLong)
  {
    super(paramInstructionCodec, paramInt1, paramInt2, paramIndexType, paramInt3, paramLong);
  }
  
  public int getRegisterCount()
  {
    return 0;
  }
  
  public DecodedInstruction withIndex(int paramInt)
  {
    return new ZeroRegisterDecodedInstruction(getFormat(), getOpcode(), paramInt, getIndexType(), getTarget(), getLiteral());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.ZeroRegisterDecodedInstruction
 * JD-Core Version:    0.7.0.1
 */