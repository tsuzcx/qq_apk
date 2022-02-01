package com.android.dx.merge;

import com.android.dx.io.CodeReader.Visitor;
import com.android.dx.io.instructions.DecodedInstruction;

class InstructionTransformer$GenericVisitor
  implements CodeReader.Visitor
{
  private InstructionTransformer$GenericVisitor(InstructionTransformer paramInstructionTransformer) {}
  
  public void visit(DecodedInstruction[] paramArrayOfDecodedInstruction, DecodedInstruction paramDecodedInstruction)
  {
    InstructionTransformer.access$500(this.this$0)[InstructionTransformer.access$608(this.this$0)] = paramDecodedInstruction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.InstructionTransformer.GenericVisitor
 * JD-Core Version:    0.7.0.1
 */