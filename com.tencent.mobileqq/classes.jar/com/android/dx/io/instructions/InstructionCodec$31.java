package com.android.dx.io.instructions;

 enum InstructionCodec$31
{
  InstructionCodec$31()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    return new OneRegisterDecodedInstruction(this, i, 0, null, 0, paramCodeInput.readLong(), paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    long l = paramDecodedInstruction.getLiteral();
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getA()), InstructionCodec.access$1300(l), InstructionCodec.access$1400(l), InstructionCodec.access$1500(l), InstructionCodec.access$1600(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.31
 * JD-Core Version:    0.7.0.1
 */