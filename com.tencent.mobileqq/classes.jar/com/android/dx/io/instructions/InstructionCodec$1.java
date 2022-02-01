package com.android.dx.io.instructions;

 enum InstructionCodec$1
{
  InstructionCodec$1()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    return new ZeroRegisterDecodedInstruction(this, paramInt, 0, null, 0, 0L);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(paramDecodedInstruction.getOpcodeUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.1
 * JD-Core Version:    0.7.0.1
 */