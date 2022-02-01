package com.android.dx.io.instructions;

 enum InstructionCodec$32
{
  InstructionCodec$32()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int j = paramCodeInput.baseAddressForCursor();
    int k = paramCodeInput.read();
    int m = paramCodeInput.readInt();
    int[] arrayOfInt = new int[k];
    int i = 0;
    while (i < k)
    {
      arrayOfInt[i] = (paramCodeInput.readInt() + (j - 1));
      i += 1;
    }
    return new PackedSwitchPayloadDecodedInstruction(this, paramInt, m, arrayOfInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramDecodedInstruction = (PackedSwitchPayloadDecodedInstruction)paramDecodedInstruction;
    int[] arrayOfInt = paramDecodedInstruction.getTargets();
    int j = paramCodeOutput.baseAddressForCursor();
    paramCodeOutput.write(paramDecodedInstruction.getOpcodeUnit());
    paramCodeOutput.write(InstructionCodec.access$1700(arrayOfInt.length));
    paramCodeOutput.writeInt(paramDecodedInstruction.getFirstKey());
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      paramCodeOutput.writeInt(arrayOfInt[i] - j);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.32
 * JD-Core Version:    0.7.0.1
 */