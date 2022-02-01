package com.android.dx.io.instructions;

 enum InstructionCodec$12
{
  InstructionCodec$12()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    int j = InstructionCodec.access$200(paramInt);
    long l = (short)paramCodeInput.read();
    if (i == 21) {}
    for (paramInt = 16;; paramInt = 48) {
      return new OneRegisterDecodedInstruction(this, i, 0, null, 0, l << paramInt, j);
    }
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    int j = paramDecodedInstruction.getOpcode();
    if (j == 21) {}
    for (int i = 16;; i = 48)
    {
      short s = (short)(int)(paramDecodedInstruction.getLiteral() >> i);
      paramCodeOutput.write(InstructionCodec.access$600(j, paramDecodedInstruction.getA()), s);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.12
 * JD-Core Version:    0.7.0.1
 */