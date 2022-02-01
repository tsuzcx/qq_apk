package com.android.dx.io.instructions;

 enum InstructionCodec$33
{
  InstructionCodec$33()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int k = 0;
    int m = paramCodeInput.baseAddressForCursor();
    int n = paramCodeInput.read();
    int[] arrayOfInt1 = new int[n];
    int[] arrayOfInt2 = new int[n];
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= n) {
        break;
      }
      arrayOfInt1[i] = paramCodeInput.readInt();
      i += 1;
    }
    while (j < n)
    {
      arrayOfInt2[j] = (paramCodeInput.readInt() + (m - 1));
      j += 1;
    }
    return new SparseSwitchPayloadDecodedInstruction(this, paramInt, arrayOfInt1, arrayOfInt2);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    int j = 0;
    paramDecodedInstruction = (SparseSwitchPayloadDecodedInstruction)paramDecodedInstruction;
    int[] arrayOfInt1 = paramDecodedInstruction.getKeys();
    int[] arrayOfInt2 = paramDecodedInstruction.getTargets();
    int k = paramCodeOutput.baseAddressForCursor();
    paramCodeOutput.write(paramDecodedInstruction.getOpcodeUnit());
    paramCodeOutput.write(InstructionCodec.access$1700(arrayOfInt2.length));
    int m = arrayOfInt1.length;
    int i = 0;
    while (i < m)
    {
      paramCodeOutput.writeInt(arrayOfInt1[i]);
      i += 1;
    }
    m = arrayOfInt2.length;
    i = j;
    while (i < m)
    {
      paramCodeOutput.writeInt(arrayOfInt2[i] - k);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.33
 * JD-Core Version:    0.7.0.1
 */