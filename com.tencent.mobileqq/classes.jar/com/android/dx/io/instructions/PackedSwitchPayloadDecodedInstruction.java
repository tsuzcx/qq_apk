package com.android.dx.io.instructions;

public final class PackedSwitchPayloadDecodedInstruction
  extends DecodedInstruction
{
  private final int firstKey;
  private final int[] targets;
  
  public PackedSwitchPayloadDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    super(paramInstructionCodec, paramInt1, 0, null, 0, 0L);
    this.firstKey = paramInt2;
    this.targets = paramArrayOfInt;
  }
  
  public int getFirstKey()
  {
    return this.firstKey;
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
 * Qualified Name:     com.android.dx.io.instructions.PackedSwitchPayloadDecodedInstruction
 * JD-Core Version:    0.7.0.1
 */