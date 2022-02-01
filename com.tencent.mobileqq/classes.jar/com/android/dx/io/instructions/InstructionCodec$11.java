package com.android.dx.io.instructions;

 enum InstructionCodec$11
{
  InstructionCodec$11()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    return new OneRegisterDecodedInstruction(this, i, 0, null, 0, (short)paramCodeInput.read(), paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getA()), paramDecodedInstruction.getLiteralUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.11
 * JD-Core Version:    0.7.0.1
 */