package com.android.dx.io.instructions;

 enum InstructionCodec$2
{
  InstructionCodec$2()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    return new ZeroRegisterDecodedInstruction(this, InstructionCodec.access$100(paramInt), 0, null, 0, InstructionCodec.access$200(paramInt));
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(paramDecodedInstruction.getOpcodeUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.2
 * JD-Core Version:    0.7.0.1
 */