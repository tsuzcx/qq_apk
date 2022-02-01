package com.android.dx.io.instructions;

 enum InstructionCodec$5
{
  InstructionCodec$5()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    return new OneRegisterDecodedInstruction(this, InstructionCodec.access$100(paramInt), 0, null, 0, 0L, InstructionCodec.access$200(paramInt));
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getA()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.5
 * JD-Core Version:    0.7.0.1
 */