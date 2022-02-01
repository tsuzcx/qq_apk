package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

public final class TwoRegisterDecodedInstruction
  extends DecodedInstruction
{
  private final int a;
  private final int b;
  
  public TwoRegisterDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt1, int paramInt2, IndexType paramIndexType, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    super(paramInstructionCodec, paramInt1, paramInt2, paramIndexType, paramInt3, paramLong);
    this.a = paramInt4;
    this.b = paramInt5;
  }
  
  public int getA()
  {
    return this.a;
  }
  
  public int getB()
  {
    return this.b;
  }
  
  public int getRegisterCount()
  {
    return 2;
  }
  
  public DecodedInstruction withIndex(int paramInt)
  {
    return new TwoRegisterDecodedInstruction(getFormat(), getOpcode(), paramInt, getIndexType(), getTarget(), getLiteral(), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.TwoRegisterDecodedInstruction
 * JD-Core Version:    0.7.0.1
 */