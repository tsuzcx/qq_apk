package com.android.dx.cf.code;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlock.Visitor;
import com.android.dx.util.IntList;

class Ropper$1
  implements BasicBlock.Visitor
{
  Ropper$1(Ropper paramRopper, IntList paramIntList) {}
  
  public void visitBlock(BasicBlock paramBasicBlock)
  {
    if (Ropper.access$600(this.this$0, paramBasicBlock)) {
      this.val$reachableSubroutineCallerLabels.add(paramBasicBlock.getLabel());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper.1
 * JD-Core Version:    0.7.0.1
 */