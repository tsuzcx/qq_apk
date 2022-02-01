package com.android.dx.io.instructions;

 enum InstructionCodec$21
{
  InstructionCodec$21()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    int j = paramCodeInput.read();
    int k = paramCodeInput.read();
    return new TwoRegisterDecodedInstruction(this, i, 0, null, 0, paramInt, j, k);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(paramDecodedInstruction.getOpcodeUnit(), paramDecodedInstruction.getAUnit(), paramDecodedInstruction.getBUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.21
 * JD-Core Version:    0.7.0.1
 */