package com.android.dx.io.instructions;

 enum InstructionCodec$22
{
  InstructionCodec$22()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    return new OneRegisterDecodedInstruction(this, i, 0, null, 0, paramCodeInput.readInt(), paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    int i = paramDecodedInstruction.getLiteralInt();
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getA()), InstructionCodec.access$700(i), InstructionCodec.access$800(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.22
 * JD-Core Version:    0.7.0.1
 */