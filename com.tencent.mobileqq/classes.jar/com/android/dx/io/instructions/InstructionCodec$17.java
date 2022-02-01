package com.android.dx.io.instructions;

 enum InstructionCodec$17
{
  InstructionCodec$17()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    int j = InstructionCodec.access$300(paramInt);
    paramInt = InstructionCodec.access$400(paramInt);
    return new TwoRegisterDecodedInstruction(this, i, 0, null, 0, (short)paramCodeInput.read(), j, paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), InstructionCodec.access$500(paramDecodedInstruction.getA(), paramDecodedInstruction.getB())), paramDecodedInstruction.getLiteralUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.17
 * JD-Core Version:    0.7.0.1
 */