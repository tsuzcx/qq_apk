package com.android.dx.io.instructions;

import com.android.dx.io.OpcodeInfo;

 enum InstructionCodec$13
{
  InstructionCodec$13()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    return new OneRegisterDecodedInstruction(this, i, paramCodeInput.read(), OpcodeInfo.getIndexType(i), 0, 0L, paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getA()), paramDecodedInstruction.getIndexUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.13
 * JD-Core Version:    0.7.0.1
 */