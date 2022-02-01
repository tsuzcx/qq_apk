package com.android.dx.merge;

import com.android.dx.io.CodeReader.Visitor;
import com.android.dx.io.instructions.DecodedInstruction;

class InstructionTransformer$StringVisitor
  implements CodeReader.Visitor
{
  private InstructionTransformer$StringVisitor(InstructionTransformer paramInstructionTransformer) {}
  
  public void visit(DecodedInstruction[] paramArrayOfDecodedInstruction, DecodedInstruction paramDecodedInstruction)
  {
    int i = paramDecodedInstruction.getIndex();
    i = InstructionTransformer.access$700(this.this$0).adjustString(i);
    if (paramDecodedInstruction.getOpcode() == 27) {}
    for (boolean bool = true;; bool = false)
    {
      InstructionTransformer.access$800(bool, i);
      InstructionTransformer.access$500(this.this$0)[InstructionTransformer.access$608(this.this$0)] = paramDecodedInstruction.withIndex(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.InstructionTransformer.StringVisitor
 * JD-Core Version:    0.7.0.1
 */