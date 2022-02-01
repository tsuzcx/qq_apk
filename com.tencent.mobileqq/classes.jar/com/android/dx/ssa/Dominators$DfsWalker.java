package com.android.dx.ssa;

import java.util.ArrayList;

class Dominators$DfsWalker
  implements SsaBasicBlock.Visitor
{
  private int dfsNum = 0;
  
  private Dominators$DfsWalker(Dominators paramDominators) {}
  
  public void visitBlock(SsaBasicBlock paramSsaBasicBlock1, SsaBasicBlock paramSsaBasicBlock2)
  {
    Dominators.DFSInfo localDFSInfo = new Dominators.DFSInfo();
    int i = this.dfsNum + 1;
    this.dfsNum = i;
    localDFSInfo.semidom = i;
    localDFSInfo.rep = paramSsaBasicBlock1;
    localDFSInfo.parent = paramSsaBasicBlock2;
    Dominators.access$100(this.this$0).add(paramSsaBasicBlock1);
    Dominators.access$200(this.this$0)[paramSsaBasicBlock1.getIndex()] = localDFSInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.Dominators.DfsWalker
 * JD-Core Version:    0.7.0.1
 */