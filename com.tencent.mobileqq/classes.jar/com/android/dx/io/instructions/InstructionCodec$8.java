package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

 enum InstructionCodec$8
{
  InstructionCodec$8()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int i = InstructionCodec.access$100(paramInt);
    paramInt = InstructionCodec.access$200(paramInt);
    return new ZeroRegisterDecodedInstruction(this, i, paramCodeInput.read(), IndexType.VARIES, 0, paramInt);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramCodeOutput.write(InstructionCodec.access$600(paramDecodedInstruction.getOpcode(), paramDecodedInstruction.getLiteralByte()), paramDecodedInstruction.getIndexUnit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.8
 * JD-Core Version:    0.7.0.1
 */