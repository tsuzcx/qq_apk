package com.android.dx.io.instructions;

public final class FillArrayDataPayloadDecodedInstruction
  extends DecodedInstruction
{
  private final Object data;
  private final int elementWidth;
  private final int size;
  
  private FillArrayDataPayloadDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    super(paramInstructionCodec, paramInt1, 0, null, 0, 0L);
    this.data = paramObject;
    this.size = paramInt2;
    this.elementWidth = paramInt3;
  }
  
  public FillArrayDataPayloadDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInstructionCodec, paramInt, paramArrayOfByte, paramArrayOfByte.length, 1);
  }
  
  public FillArrayDataPayloadDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt, int[] paramArrayOfInt)
  {
    this(paramInstructionCodec, paramInt, paramArrayOfInt, paramArrayOfInt.length, 4);
  }
  
  public FillArrayDataPayloadDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt, long[] paramArrayOfLong)
  {
    this(paramInstructionCodec, paramInt, paramArrayOfLong, paramArrayOfLong.length, 8);
  }
  
  public FillArrayDataPayloadDecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt, short[] paramArrayOfShort)
  {
    this(paramInstructionCodec, paramInt, paramArrayOfShort, paramArrayOfShort.length, 2);
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public short getElementWidthUnit()
  {
    return (short)this.elementWidth;
  }
  
  public int getRegisterCount()
  {
    return 0;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public DecodedInstruction withIndex(int paramInt)
  {
    throw new UnsupportedOperationException("no index in instruction");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.FillArrayDataPayloadDecodedInstruction
 * JD-Core Version:    0.7.0.1
 */