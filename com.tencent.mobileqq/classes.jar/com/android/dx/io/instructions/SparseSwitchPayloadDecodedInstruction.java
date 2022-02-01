package com.android.dx.io.instructions;

public final class SparseSwitchPayloadDecodedInstruction
  extends DecodedInstruction
{
  private final int[] keys;
  private final int[] targets;
  
  public SparseSwitchPayloadDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    super(paramInstructionCodec, paramInt, 0, null, 0, 0L);
    if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      throw new IllegalArgumentException("keys/targets length mismatch");
    }
    this.keys = paramArrayOfInt1;
    this.targets = paramArrayOfInt2;
  }
  
  public int[] getKeys()
  {
    return this.keys;
  }
  
  public int getRegisterCount()
  {
    return 0;
  }
  
  public int[] getTargets()
  {
    return this.targets;
  }
  
  public DecodedInstruction withIndex(int paramInt)
  {
    throw new UnsupportedOperationException("no index in instruction");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.SparseSwitchPayloadDecodedInstruction
 * JD-Core Version:    0.7.0.1
 */