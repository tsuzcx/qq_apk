package com.android.dx.io.instructions;

 enum InstructionCodec$20
{
  InstructionCodec$20()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = paramCodeInput.cursor();
    int j = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    return new ZeroRegisterDecodedInstruction(this, j, 0, null, paramCodeInput.readInt() + (i - 1), paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    int i = paramDecodedInstruction.getTarget(paramCodeOutput.cursor());
    paramCodeOutput.write(paramDecodedInstruction.getOpcodeUnit(), InstructionCodec.access$700(i), InstructionCodec.access$800(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.20
 * JD-Core Version:    0.7.0.1
 */