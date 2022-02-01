package com.android.dx.io.instructions;

 enum InstructionCodec$6
{
  InstructionCodec$6()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = paramCodeInput.cursor();
    return new ZeroRegisterDecodedInstruction(this, InstructionCodec.access$100(paramInt), 0, null, (byte)InstructionCodec.access$200(paramInt) + (i - 1), 0L);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    int i = paramDecodedInstruction.getTargetByte(paramCodeOutput.cursor());
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.6
 * JD-Core Version:    0.7.0.1
 */