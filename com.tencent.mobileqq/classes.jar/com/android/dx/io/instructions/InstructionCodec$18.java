package com.android.dx.io.instructions;

import com.android.dx.io.OpcodeInfo;

 enum InstructionCodec$18
{
  InstructionCodec$18()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    int j = InstructionCodec.access$300(paramInt);
    paramInt = InstructionCodec.access$400(paramInt);
    return new TwoRegisterDecodedInstruction(this, i, paramCodeInput.read(), OpcodeInfo.getIndexType(i), 0, 0L, j, paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), InstructionCodec.access$500(paramDecodedInstruction.getA(), paramDecodedInstruction.getB())), paramDecodedInstruction.getIndexUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.18
 * JD-Core Version:    0.7.0.1
 */