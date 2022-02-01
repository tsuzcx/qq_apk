package com.android.dx.ssa.back;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.ssa.BasicRegisterMapper;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SsaToRop
{
  private static final boolean DEBUG = false;
  private final InterferenceGraph interference;
  private final boolean minimizeRegisters;
  private final SsaMethod ssaMeth;
  
  private SsaToRop(SsaMethod paramSsaMethod, boolean paramBoolean)
  {
    this.minimizeRegisters = paramBoolean;
    this.ssaMeth = paramSsaMethod;
    this.interference = LivenessAnalyzer.constructInterferenceGraph(paramSsaMethod);
  }
  
  private RopMethod convert()
  {
    FirstFitLocalCombiningAllocator localFirstFitLocalCombiningAllocator = new FirstFitLocalCombiningAllocator(this.ssaMeth, this.interference, this.minimizeRegisters);
    RegisterMapper localRegisterMapper = localFirstFitLocalCombiningAllocator.allocateRegisters();
    this.ssaMeth.setBackMode();
    this.ssaMeth.mapRegisters(localRegisterMapper);
    removePhiFunctions();
    if (localFirstFitLocalCombiningAllocator.wantsParamsMovedHigh()) {
      moveParametersToHighRegisters();
    }
    removeEmptyGotos();
    return new IdenticalBlockCombiner(new RopMethod(convertBasicBlocks(), this.ssaMeth.blockIndexToRopLabel(this.ssaMeth.getEntryBlockIndex()))).process();
  }
  
  private BasicBlock convertBasicBlock(SsaBasicBlock paramSsaBasicBlock)
  {
    int j = -1;
    IntList localIntList = paramSsaBasicBlock.getRopLabelSuccessorList();
    int k = paramSsaBasicBlock.getPrimarySuccessorRopLabel();
    SsaBasicBlock localSsaBasicBlock = this.ssaMeth.getExitBlock();
    if (localSsaBasicBlock == null) {
      i = -1;
    }
    while (localIntList.contains(i)) {
      if (localIntList.size() > 1)
      {
        throw new RuntimeException("Exit predecessor must have no other successors" + Hex.u2(paramSsaBasicBlock.getRopLabel()));
        i = localSsaBasicBlock.getRopLabel();
      }
      else
      {
        localIntList = IntList.EMPTY;
        verifyValidExitPredecessor(paramSsaBasicBlock);
      }
    }
    for (int i = j;; i = k)
    {
      localIntList.setImmutable();
      return new BasicBlock(paramSsaBasicBlock.getRopLabel(), convertInsns(paramSsaBasicBlock.getInsns()), localIntList, i);
    }
  }
  
  private BasicBlockList convertBasicBlocks()
  {
    int j = 0;
    Object localObject = this.ssaMeth.getBlocks();
    SsaBasicBlock localSsaBasicBlock1 = this.ssaMeth.getExitBlock();
    this.ssaMeth.computeReachability();
    int k = this.ssaMeth.getCountReachableBlocks();
    if ((localSsaBasicBlock1 != null) && (localSsaBasicBlock1.isReachable())) {}
    BasicBlockList localBasicBlockList;
    for (int i = 1;; i = 0)
    {
      localBasicBlockList = new BasicBlockList(k - i);
      localObject = ((ArrayList)localObject).iterator();
      i = j;
      while (((Iterator)localObject).hasNext())
      {
        SsaBasicBlock localSsaBasicBlock2 = (SsaBasicBlock)((Iterator)localObject).next();
        if ((localSsaBasicBlock2.isReachable()) && (localSsaBasicBlock2 != localSsaBasicBlock1))
        {
          localBasicBlockList.set(i, convertBasicBlock(localSsaBasicBlock2));
          i += 1;
        }
      }
    }
    if ((localSsaBasicBlock1 != null) && (localSsaBasicBlock1.getInsns().size() != 0)) {
      throw new RuntimeException("Exit block must have no insns when leaving SSA form");
    }
    return localBasicBlockList;
  }
  
  private InsnList convertInsns(ArrayList<SsaInsn> paramArrayList)
  {
    int j = paramArrayList.size();
    InsnList localInsnList = new InsnList(j);
    int i = 0;
    while (i < j)
    {
      localInsnList.set(i, ((SsaInsn)paramArrayList.get(i)).toRopInsn());
      i += 1;
    }
    localInsnList.setImmutable();
    return localInsnList;
  }
  
  public static RopMethod convertToRopMethod(SsaMethod paramSsaMethod, boolean paramBoolean)
  {
    return new SsaToRop(paramSsaMethod, paramBoolean).convert();
  }
  
  private void moveParametersToHighRegisters()
  {
    int j = this.ssaMeth.getParamWidth();
    BasicRegisterMapper localBasicRegisterMapper = new BasicRegisterMapper(this.ssaMeth.getRegCount());
    int k = this.ssaMeth.getRegCount();
    int i = 0;
    if (i < k)
    {
      if (i < j) {
        localBasicRegisterMapper.addMapping(i, k - j + i, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        localBasicRegisterMapper.addMapping(i, i - j, 1);
      }
    }
    this.ssaMeth.mapRegisters(localBasicRegisterMapper);
  }
  
  private void removeEmptyGotos()
  {
    ArrayList localArrayList = this.ssaMeth.getBlocks();
    this.ssaMeth.forEachBlockDepthFirst(false, new SsaToRop.1(this, localArrayList));
  }
  
  private void removePhiFunctions()
  {
    Object localObject = this.ssaMeth.getBlocks();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      SsaBasicBlock localSsaBasicBlock = (SsaBasicBlock)localIterator.next();
      localSsaBasicBlock.forEachPhiInsn(new SsaToRop.PhiVisitor((ArrayList)localObject));
      localSsaBasicBlock.removeAllPhiInsns();
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((SsaBasicBlock)((Iterator)localObject).next()).scheduleMovesFromPhis();
    }
  }
  
  private void verifyValidExitPredecessor(SsaBasicBlock paramSsaBasicBlock)
  {
    paramSsaBasicBlock = paramSsaBasicBlock.getInsns();
    paramSsaBasicBlock = ((SsaInsn)paramSsaBasicBlock.get(paramSsaBasicBlock.size() - 1)).getOpcode();
    if ((paramSsaBasicBlock.getBranchingness() != 2) && (paramSsaBasicBlock != Rops.THROW)) {
      throw new RuntimeException("Exit predecessor must end in valid exit statement.");
    }
  }
  
  public int[] getRegistersByFrequency()
  {
    int j = 0;
    int k = this.ssaMeth.getRegCount();
    Integer[] arrayOfInteger = new Integer[k];
    int i = 0;
    while (i < k)
    {
      arrayOfInteger[i] = Integer.valueOf(i);
      i += 1;
    }
    Arrays.sort(arrayOfInteger, new SsaToRop.2(this));
    int[] arrayOfInt = new int[k];
    i = j;
    while (i < k)
    {
      arrayOfInt[i] = arrayOfInteger[i].intValue();
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.SsaToRop
 * JD-Core Version:    0.7.0.1
 */