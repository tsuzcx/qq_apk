package com.android.dx.io.instructions;

 enum InstructionCodec$4
{
  InstructionCodec$4()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    int j = InstructionCodec.access$300(paramInt);
    return new OneRegisterDecodedInstruction(this, i, 0, null, 0, InstructionCodec.access$400(paramInt) << 28 >> 28, j);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcodeUnit(), InstructionCodec.access$500(paramDecodedInstruction.getA(), paramDecodedInstruction.getLiteralNibble())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.4
 * JD-Core Version:    0.7.0.1
 */