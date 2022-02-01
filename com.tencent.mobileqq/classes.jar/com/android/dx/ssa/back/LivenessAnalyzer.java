package com.android.dx.ssa.back;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class LivenessAnalyzer
{
  private SsaBasicBlock blockN;
  private final InterferenceGraph interference;
  private final BitSet liveOutBlocks;
  private LivenessAnalyzer.NextFunction nextFunction;
  private final int regV;
  private final SsaMethod ssaMeth;
  private int statementIndex;
  private final BitSet visitedBlocks;
  
  private LivenessAnalyzer(SsaMethod paramSsaMethod, int paramInt, InterferenceGraph paramInterferenceGraph)
  {
    int i = paramSsaMethod.getBlocks().size();
    this.ssaMeth = paramSsaMethod;
    this.regV = paramInt;
    this.visitedBlocks = new BitSet(i);
    this.liveOutBlocks = new BitSet(i);
    this.interference = paramInterferenceGraph;
  }
  
  private static void coInterferePhis(SsaMethod paramSsaMethod, InterferenceGraph paramInterferenceGraph)
  {
    paramSsaMethod = paramSsaMethod.getBlocks().iterator();
    while (paramSsaMethod.hasNext())
    {
      List localList = ((SsaBasicBlock)paramSsaMethod.next()).getPhiInsns();
      int k = localList.size();
      int i = 0;
      while (i < k)
      {
        int j = 0;
        if (j < k)
        {
          if (i == j) {}
          for (;;)
          {
            j += 1;
            break;
            paramInterferenceGraph.add(((SsaInsn)localList.get(i)).getResult().getReg(), ((SsaInsn)localList.get(j)).getResult().getReg());
          }
        }
        i += 1;
      }
    }
  }
  
  public static InterferenceGraph constructInterferenceGraph(SsaMethod paramSsaMethod)
  {
    int j = paramSsaMethod.getRegCount();
    InterferenceGraph localInterferenceGraph = new InterferenceGraph(j);
    int i = 0;
    while (i < j)
    {
      new LivenessAnalyzer(paramSsaMethod, i, localInterferenceGraph).run();
      i += 1;
    }
    coInterferePhis(paramSsaMethod, localInterferenceGraph);
    return localInterferenceGraph;
  }
  
  private void handleTailRecursion()
  {
    while (this.nextFunction != LivenessAnalyzer.NextFunction.DONE)
    {
      switch (LivenessAnalyzer.1.$SwitchMap$com$android$dx$ssa$back$LivenessAnalyzer$NextFunction[this.nextFunction.ordinal()])
      {
      default: 
        break;
      case 1: 
        this.nextFunction = LivenessAnalyzer.NextFunction.DONE;
        liveInAtStatement();
        break;
      case 2: 
        this.nextFunction = LivenessAnalyzer.NextFunction.DONE;
        liveOutAtStatement();
        break;
      }
      this.nextFunction = LivenessAnalyzer.NextFunction.DONE;
      liveOutAtBlock();
    }
  }
  
  private void liveInAtStatement()
  {
    if (this.statementIndex == 0)
    {
      this.blockN.addLiveIn(this.regV);
      BitSet localBitSet = this.blockN.getPredecessors();
      this.liveOutBlocks.or(localBitSet);
      return;
    }
    this.statementIndex -= 1;
    this.nextFunction = LivenessAnalyzer.NextFunction.LIVE_OUT_AT_STATEMENT;
  }
  
  private void liveOutAtBlock()
  {
    if (!this.visitedBlocks.get(this.blockN.getIndex()))
    {
      this.visitedBlocks.set(this.blockN.getIndex());
      this.blockN.addLiveOut(this.regV);
      this.statementIndex = (this.blockN.getInsns().size() - 1);
      this.nextFunction = LivenessAnalyzer.NextFunction.LIVE_OUT_AT_STATEMENT;
    }
  }
  
  private void liveOutAtStatement()
  {
    SsaInsn localSsaInsn = (SsaInsn)this.blockN.getInsns().get(this.statementIndex);
    RegisterSpec localRegisterSpec = localSsaInsn.getResult();
    if (!localSsaInsn.isResultReg(this.regV))
    {
      if (localRegisterSpec != null) {
        this.interference.add(this.regV, localRegisterSpec.getReg());
      }
      this.nextFunction = LivenessAnalyzer.NextFunction.LIVE_IN_AT_STATEMENT;
    }
  }
  
  public void run()
  {
    Iterator localIterator = this.ssaMeth.getUseListForRegister(this.regV).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (SsaInsn)localIterator.next();
      this.nextFunction = LivenessAnalyzer.NextFunction.DONE;
      if ((localObject instanceof PhiInsn))
      {
        localObject = ((PhiInsn)localObject).predBlocksForReg(this.regV, this.ssaMeth).iterator();
        while (((Iterator)localObject).hasNext())
        {
          this.blockN = ((SsaBasicBlock)((Iterator)localObject).next());
          this.nextFunction = LivenessAnalyzer.NextFunction.LIVE_OUT_AT_BLOCK;
          handleTailRecursion();
        }
      }
      else
      {
        this.blockN = ((SsaInsn)localObject).getBlock();
        this.statementIndex = this.blockN.getInsns().indexOf(localObject);
        if (this.statementIndex < 0) {
          throw new RuntimeException("insn not found in it's own block");
        }
        this.nextFunction = LivenessAnalyzer.NextFunction.LIVE_IN_AT_STATEMENT;
        handleTailRecursion();
      }
    }
    for (;;)
    {
      int i = this.liveOutBlocks.nextSetBit(0);
      if (i < 0) {
        break;
      }
      this.blockN = ((SsaBasicBlock)this.ssaMeth.getBlocks().get(i));
      this.liveOutBlocks.clear(i);
      this.nextFunction = LivenessAnalyzer.NextFunction.LIVE_OUT_AT_BLOCK;
      handleTailRecursion();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.LivenessAnalyzer
 * JD-Core Version:    0.7.0.1
 */