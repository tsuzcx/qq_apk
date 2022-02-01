package com.android.dx.command.findusages;

import com.android.dex.Dex;
import com.android.dx.io.CodeReader.Visitor;
import com.android.dx.io.OpcodeInfo;
import com.android.dx.io.instructions.DecodedInstruction;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

class FindUsages$1
  implements CodeReader.Visitor
{
  FindUsages$1(FindUsages paramFindUsages, PrintWriter paramPrintWriter, Dex paramDex) {}
  
  public void visit(DecodedInstruction[] paramArrayOfDecodedInstruction, DecodedInstruction paramDecodedInstruction)
  {
    int i = paramDecodedInstruction.getIndex();
    if (FindUsages.access$000(this.this$0).contains(Integer.valueOf(i))) {
      this.val$out.println(FindUsages.access$100(this.this$0) + ": field reference " + this.val$dex.fieldIds().get(i) + " (" + OpcodeInfo.getName(paramDecodedInstruction.getOpcode()) + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.findusages.FindUsages.1
 * JD-Core Version:    0.7.0.1
 */