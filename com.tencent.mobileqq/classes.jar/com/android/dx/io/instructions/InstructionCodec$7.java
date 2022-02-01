package com.android.dx.io.instructions;

 enum InstructionCodec$7
{
  InstructionCodec$7()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = paramCodeInput.cursor();
    int j = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    return new ZeroRegisterDecodedInstruction(this, j, 0, null, (short)paramCodeInput.read() + (i - 1), paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    short s = paramDecodedInstruction.getTargetUnit(paramCodeOutput.cursor());
    paramCodeOutput.write(paramDecodedInstruction.getOpcodeUnit(), s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.7
 * JD-Core Version:    0.7.0.1
 */