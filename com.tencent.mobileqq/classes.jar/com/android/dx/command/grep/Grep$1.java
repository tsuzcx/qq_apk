package com.android.dx.command.grep;

import com.android.dx.io.CodeReader.Visitor;
import com.android.dx.io.instructions.DecodedInstruction;

class Grep$1
  implements CodeReader.Visitor
{
  Grep$1(Grep paramGrep) {}
  
  public void visit(DecodedInstruction[] paramArrayOfDecodedInstruction, DecodedInstruction paramDecodedInstruction)
  {
    Grep.access$000(this.this$0, paramDecodedInstruction.getIndex());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.grep.Grep.1
 * JD-Core Version:    0.7.0.1
 */