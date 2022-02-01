package com.android.dx.cf.code;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlock.Visitor;
import com.android.dx.util.IntList;

class Ropper$2
  implements BasicBlock.Visitor
{
  Ropper$2(Ropper paramRopper, IntList paramIntList) {}
  
  public void visitBlock(BasicBlock paramBasicBlock)
  {
    this.val$reachableLabels.add(paramBasicBlock.getLabel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper.2
 * JD-Core Version:    0.7.0.1
 */