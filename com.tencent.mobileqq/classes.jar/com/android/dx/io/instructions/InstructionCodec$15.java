package com.android.dx.io.instructions;

 enum InstructionCodec$15
{
  InstructionCodec$15()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    int j = paramCodeInput.read();
    int k = InstructionCodec.access$100(j);
    return new TwoRegisterDecodedInstruction(this, i, 0, null, 0, (byte)InstructionCodec.access$200(j), paramInt, k);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getA()), InstructionCodec.access$600(paramDecodedInstruction.getB(), paramDecodedInstruction.getLiteralByte()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.15
 * JD-Core Version:    0.7.0.1
 */