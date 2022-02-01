package com.android.dx.io.instructions;

 enum InstructionCodec$23
{
  InstructionCodec$23()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = paramCodeInput.cursor() - 1;
    int j = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    int k = i + paramCodeInput.readInt();
    switch (j)
    {
    }
    for (;;)
    {
      return new OneRegisterDecodedInstruction(this, j, 0, null, k, 0L, paramInt);
      paramCodeInput.setBaseAddress(k, i);
    }
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    int i = paramDecodedInstruction.getTarget(paramCodeOutput.cursor());
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getA()), InstructionCodec.access$700(i), InstructionCodec.access$800(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.23
 * JD-Core Version:    0.7.0.1
 */