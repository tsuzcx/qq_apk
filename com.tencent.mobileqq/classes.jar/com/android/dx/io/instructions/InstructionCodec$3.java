package com.android.dx.io.instructions;

 enum InstructionCodec$3
{
  InstructionCodec$3()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    return new TwoRegisterDecodedInstruction(this, InstructionCodec.access$100(paramInt), 0, null, 0, 0L, InstructionCodec.access$300(paramInt), InstructionCodec.access$400(paramInt));
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcodeUnit(), InstructionCodec.access$500(paramDecodedInstruction.getA(), paramDecodedInstruction.getB())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.3
 * JD-Core Version:    0.7.0.1
 */