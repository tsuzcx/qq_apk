package com.android.dx.io.instructions;

 enum InstructionCodec$9
{
  InstructionCodec$9()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    return new TwoRegisterDecodedInstruction(this, InstructionCodec.access$100(paramInt), 0, null, 0, 0L, InstructionCodec.access$200(paramInt), paramCodeInput.read());
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getA()), paramDecodedInstruction.getBUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.9
 * JD-Core Version:    0.7.0.1
 */