package com.android.dx.ssa;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.IntSet;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class SsaBasicBlock
{
  public static final Comparator<SsaBasicBlock> LABEL_COMPARATOR = new SsaBasicBlock.LabelComparator();
  private final ArrayList<SsaBasicBlock> domChildren;
  private int index;
  private ArrayList<SsaInsn> insns;
  private IntSet liveIn;
  private IntSet liveOut;
  private int movesFromPhisAtBeginning = 0;
  private int movesFromPhisAtEnd = 0;
  private SsaMethod parent;
  private BitSet predecessors;
  private int primarySuccessor = -1;
  private int reachable = -1;
  private int ropLabel;
  private IntList successorList;
  private BitSet successors;
  
  public SsaBasicBlock(int paramInt1, int paramInt2, SsaMethod paramSsaMethod)
  {
    this.parent = paramSsaMethod;
    this.index = paramInt1;
    this.insns = new ArrayList();
    this.ropLabel = paramInt2;
    this.predecessors = new BitSet(paramSsaMethod.getBlocks().size());
    this.successors = new BitSet(paramSsaMethod.getBlocks().size());
    this.successorList = new IntList();
    this.domChildren = new ArrayList();
  }
  
  private static boolean checkRegUsed(BitSet paramBitSet, RegisterSpec paramRegisterSpec)
  {
    int i = paramRegisterSpec.getReg();
    int j = paramRegisterSpec.getCategory();
    return (paramBitSet.get(i)) || ((j == 2) && (paramBitSet.get(i + 1)));
  }
  
  private int getCountPhiInsns()
  {
    int j = this.insns.size();
    int i = 0;
    for (;;)
    {
      if ((i >= j) || (!((SsaInsn)this.insns.get(i) instanceof PhiInsn))) {
        return i;
      }
      i += 1;
    }
  }
  
  public static SsaBasicBlock newFromRop(RopMethod paramRopMethod, int paramInt, SsaMethod paramSsaMethod)
  {
    BasicBlockList localBasicBlockList = paramRopMethod.getBlocks();
    BasicBlock localBasicBlock = localBasicBlockList.get(paramInt);
    paramSsaMethod = new SsaBasicBlock(paramInt, localBasicBlock.getLabel(), paramSsaMethod);
    InsnList localInsnList = localBasicBlock.getInsns();
    paramSsaMethod.insns.ensureCapacity(localInsnList.size());
    paramInt = 0;
    int i = localInsnList.size();
    while (paramInt < i)
    {
      paramSsaMethod.insns.add(new NormalSsaInsn(localInsnList.get(paramInt), paramSsaMethod));
      paramInt += 1;
    }
    paramSsaMethod.predecessors = SsaMethod.bitSetFromLabelList(localBasicBlockList, paramRopMethod.labelToPredecessors(localBasicBlock.getLabel()));
    paramSsaMethod.successors = SsaMethod.bitSetFromLabelList(localBasicBlockList, localBasicBlock.getSuccessors());
    paramSsaMethod.successorList = SsaMethod.indexListFromLabelList(localBasicBlockList, localBasicBlock.getSuccessors());
    if (paramSsaMethod.successorList.size() != 0)
    {
      paramInt = localBasicBlock.getPrimarySuccessor();
      if (paramInt >= 0) {
        break label165;
      }
    }
    label165:
    for (paramInt = -1;; paramInt = localBasicBlockList.indexOfLabel(paramInt))
    {
      paramSsaMethod.primarySuccessor = paramInt;
      return paramSsaMethod;
    }
  }
  
  private void scheduleUseBeforeAssigned(List<SsaInsn> paramList)
  {
    BitSet localBitSet1 = new BitSet(this.parent.getRegCount());
    BitSet localBitSet2 = new BitSet(this.parent.getRegCount());
    int k = paramList.size();
    int i = 0;
    int j;
    int m;
    if (i < k)
    {
      j = i;
      while (j < k)
      {
        setRegsUsed(localBitSet1, ((SsaInsn)paramList.get(j)).getSources().get(0));
        setRegsUsed(localBitSet2, ((SsaInsn)paramList.get(j)).getResult());
        j += 1;
      }
      m = i;
      j = i;
      label108:
      if (m < k)
      {
        if (checkRegUsed(localBitSet1, ((SsaInsn)paramList.get(m)).getResult())) {
          break label391;
        }
        int n = j + 1;
        Collections.swap(paramList, m, j);
        j = n;
      }
    }
    label391:
    for (;;)
    {
      m += 1;
      break label108;
      label168:
      Object localObject;
      if (i == j)
      {
        i = j;
        if (i < k)
        {
          localObject = (SsaInsn)paramList.get(i);
          if ((checkRegUsed(localBitSet1, ((SsaInsn)localObject).getResult())) && (checkRegUsed(localBitSet2, ((SsaInsn)localObject).getSources().get(0))))
          {
            Collections.swap(paramList, j, i);
            label222:
            RegisterSpec localRegisterSpec1 = ((SsaInsn)localObject).getResult();
            RegisterSpec localRegisterSpec2 = localRegisterSpec1.withReg(this.parent.borrowSpareRegister(localRegisterSpec1.getCategory()));
            localObject = new NormalSsaInsn(new PlainInsn(Rops.opMove(localRegisterSpec1.getType()), SourcePosition.NO_INFO, localRegisterSpec2, ((SsaInsn)localObject).getSources()), this);
            k = j + 1;
            paramList.add(j, localObject);
            localObject = RegisterSpecList.make(localRegisterSpec2);
            paramList.set(k, new NormalSsaInsn(new PlainInsn(Rops.opMove(localRegisterSpec1.getType()), SourcePosition.NO_INFO, localRegisterSpec1, (RegisterSpecList)localObject), this));
            i = paramList.size();
            j = k;
          }
        }
      }
      for (;;)
      {
        localBitSet1.clear();
        localBitSet2.clear();
        k = i;
        i = j;
        break;
        i += 1;
        break label168;
        return;
        localObject = null;
        break label222;
        i = k;
      }
    }
  }
  
  private static void setRegsUsed(BitSet paramBitSet, RegisterSpec paramRegisterSpec)
  {
    paramBitSet.set(paramRegisterSpec.getReg());
    if (paramRegisterSpec.getCategory() > 1) {
      paramBitSet.set(paramRegisterSpec.getReg() + 1);
    }
  }
  
  public void addDomChild(SsaBasicBlock paramSsaBasicBlock)
  {
    this.domChildren.add(paramSsaBasicBlock);
  }
  
  public void addInsnToHead(Insn paramInsn)
  {
    paramInsn = SsaInsn.makeFromRop(paramInsn, this);
    this.insns.add(getCountPhiInsns(), paramInsn);
    this.parent.onInsnAdded(paramInsn);
  }
  
  public void addLiveIn(int paramInt)
  {
    if (this.liveIn == null) {
      this.liveIn = SetFactory.makeLivenessSet(this.parent.getRegCount());
    }
    this.liveIn.add(paramInt);
  }
  
  public void addLiveOut(int paramInt)
  {
    if (this.liveOut == null) {
      this.liveOut = SetFactory.makeLivenessSet(this.parent.getRegCount());
    }
    this.liveOut.add(paramInt);
  }
  
  public void addMoveToBeginning(RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    if (paramRegisterSpec1.getReg() == paramRegisterSpec2.getReg()) {
      return;
    }
    paramRegisterSpec2 = RegisterSpecList.make(paramRegisterSpec2);
    paramRegisterSpec1 = new NormalSsaInsn(new PlainInsn(Rops.opMove(paramRegisterSpec1.getType()), SourcePosition.NO_INFO, paramRegisterSpec1, paramRegisterSpec2), this);
    this.insns.add(getCountPhiInsns(), paramRegisterSpec1);
    this.movesFromPhisAtBeginning += 1;
  }
  
  public void addMoveToEnd(RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    if (paramRegisterSpec1.getReg() == paramRegisterSpec2.getReg()) {}
    for (;;)
    {
      return;
      NormalSsaInsn localNormalSsaInsn = (NormalSsaInsn)this.insns.get(this.insns.size() - 1);
      if ((localNormalSsaInsn.getResult() == null) && (localNormalSsaInsn.getSources().size() <= 0)) {
        break;
      }
      for (int i = this.successors.nextSetBit(0); i >= 0; i = this.successors.nextSetBit(i + 1)) {
        ((SsaBasicBlock)this.parent.getBlocks().get(i)).addMoveToBeginning(paramRegisterSpec1, paramRegisterSpec2);
      }
    }
    paramRegisterSpec2 = RegisterSpecList.make(paramRegisterSpec2);
    paramRegisterSpec1 = new NormalSsaInsn(new PlainInsn(Rops.opMove(paramRegisterSpec1.getType()), SourcePosition.NO_INFO, paramRegisterSpec1, paramRegisterSpec2), this);
    this.insns.add(this.insns.size() - 1, paramRegisterSpec1);
    this.movesFromPhisAtEnd += 1;
  }
  
  public void addPhiInsnForReg(int paramInt)
  {
    this.insns.add(0, new PhiInsn(paramInt, this));
  }
  
  public void addPhiInsnForReg(RegisterSpec paramRegisterSpec)
  {
    this.insns.add(0, new PhiInsn(paramRegisterSpec, this));
  }
  
  public void exitBlockFixup(SsaBasicBlock paramSsaBasicBlock)
  {
    if (this == paramSsaBasicBlock) {}
    while (this.successorList.size() != 0) {
      return;
    }
    this.successors.set(paramSsaBasicBlock.index);
    this.successorList.add(paramSsaBasicBlock.index);
    this.primarySuccessor = paramSsaBasicBlock.index;
    paramSsaBasicBlock.predecessors.set(this.index);
  }
  
  public void forEachInsn(SsaInsn.Visitor paramVisitor)
  {
    int j = this.insns.size();
    int i = 0;
    while (i < j)
    {
      ((SsaInsn)this.insns.get(i)).accept(paramVisitor);
      i += 1;
    }
  }
  
  public void forEachPhiInsn(PhiInsn.Visitor paramVisitor)
  {
    int j = this.insns.size();
    int i = 0;
    while (i < j)
    {
      SsaInsn localSsaInsn = (SsaInsn)this.insns.get(i);
      if (!(localSsaInsn instanceof PhiInsn)) {
        break;
      }
      paramVisitor.visitPhiInsn((PhiInsn)localSsaInsn);
      i += 1;
    }
  }
  
  public ArrayList<SsaBasicBlock> getDomChildren()
  {
    return this.domChildren;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public ArrayList<SsaInsn> getInsns()
  {
    return this.insns;
  }
  
  public IntSet getLiveInRegs()
  {
    if (this.liveIn == null) {
      this.liveIn = SetFactory.makeLivenessSet(this.parent.getRegCount());
    }
    return this.liveIn;
  }
  
  public IntSet getLiveOutRegs()
  {
    if (this.liveOut == null) {
      this.liveOut = SetFactory.makeLivenessSet(this.parent.getRegCount());
    }
    return this.liveOut;
  }
  
  public SsaMethod getParent()
  {
    return this.parent;
  }
  
  public List<SsaInsn> getPhiInsns()
  {
    return this.insns.subList(0, getCountPhiInsns());
  }
  
  public BitSet getPredecessors()
  {
    return this.predecessors;
  }
  
  public SsaBasicBlock getPrimarySuccessor()
  {
    if (this.primarySuccessor < 0) {
      return null;
    }
    return (SsaBasicBlock)this.parent.getBlocks().get(this.primarySuccessor);
  }
  
  public int getPrimarySuccessorIndex()
  {
    return this.primarySuccessor;
  }
  
  public int getPrimarySuccessorRopLabel()
  {
    return this.parent.blockIndexToRopLabel(this.primarySuccessor);
  }
  
  public int getRopLabel()
  {
    return this.ropLabel;
  }
  
  public String getRopLabelString()
  {
    return Hex.u2(this.ropLabel);
  }
  
  public IntList getRopLabelSuccessorList()
  {
    IntList localIntList = new IntList(this.successorList.size());
    int j = this.successorList.size();
    int i = 0;
    while (i < j)
    {
      localIntList.add(this.parent.blockIndexToRopLabel(this.successorList.get(i)));
      i += 1;
    }
    return localIntList;
  }
  
  public IntList getSuccessorList()
  {
    return this.successorList;
  }
  
  public BitSet getSuccessors()
  {
    return this.successors;
  }
  
  public SsaBasicBlock insertNewPredecessor()
  {
    SsaBasicBlock localSsaBasicBlock = this.parent.makeNewGotoBlock();
    localSsaBasicBlock.predecessors = this.predecessors;
    localSsaBasicBlock.successors.set(this.index);
    localSsaBasicBlock.successorList.add(this.index);
    localSsaBasicBlock.primarySuccessor = this.index;
    this.predecessors = new BitSet(this.parent.getBlocks().size());
    this.predecessors.set(localSsaBasicBlock.index);
    for (int i = localSsaBasicBlock.predecessors.nextSetBit(0); i >= 0; i = localSsaBasicBlock.predecessors.nextSetBit(i + 1)) {
      ((SsaBasicBlock)this.parent.getBlocks().get(i)).replaceSuccessor(this.index, localSsaBasicBlock.index);
    }
    return localSsaBasicBlock;
  }
  
  public SsaBasicBlock insertNewSuccessor(SsaBasicBlock paramSsaBasicBlock)
  {
    SsaBasicBlock localSsaBasicBlock = this.parent.makeNewGotoBlock();
    if (!this.successors.get(paramSsaBasicBlock.index)) {
      throw new RuntimeException("Block " + paramSsaBasicBlock.getRopLabelString() + " not successor of " + getRopLabelString());
    }
    localSsaBasicBlock.predecessors.set(this.index);
    localSsaBasicBlock.successors.set(paramSsaBasicBlock.index);
    localSsaBasicBlock.successorList.add(paramSsaBasicBlock.index);
    localSsaBasicBlock.primarySuccessor = paramSsaBasicBlock.index;
    int i = this.successorList.size() - 1;
    while (i >= 0)
    {
      if (this.successorList.get(i) == paramSsaBasicBlock.index) {
        this.successorList.set(i, localSsaBasicBlock.index);
      }
      i -= 1;
    }
    if (this.primarySuccessor == paramSsaBasicBlock.index) {
      this.primarySuccessor = localSsaBasicBlock.index;
    }
    this.successors.clear(paramSsaBasicBlock.index);
    this.successors.set(localSsaBasicBlock.index);
    paramSsaBasicBlock.predecessors.set(localSsaBasicBlock.index);
    paramSsaBasicBlock.predecessors.set(this.index, this.successors.get(paramSsaBasicBlock.index));
    return localSsaBasicBlock;
  }
  
  public boolean isExitBlock()
  {
    return this.index == this.parent.getExitBlockIndex();
  }
  
  public boolean isReachable()
  {
    if (this.reachable == -1) {
      this.parent.computeReachability();
    }
    return this.reachable == 1;
  }
  
  public void removeAllPhiInsns()
  {
    this.insns.subList(0, getCountPhiInsns()).clear();
  }
  
  public void removeSuccessor(int paramInt)
  {
    int j = 0;
    int i = this.successorList.size() - 1;
    if (i >= 0)
    {
      if (this.successorList.get(i) == paramInt) {
        j = i;
      }
      for (;;)
      {
        i -= 1;
        break;
        this.primarySuccessor = this.successorList.get(i);
      }
    }
    this.successorList.removeIndex(j);
    this.successors.clear(paramInt);
    ((SsaBasicBlock)this.parent.getBlocks().get(paramInt)).predecessors.clear(this.index);
  }
  
  public void replaceLastInsn(Insn paramInsn)
  {
    if (paramInsn.getOpcode().getBranchingness() == 1) {
      throw new IllegalArgumentException("last insn must branch");
    }
    SsaInsn localSsaInsn = (SsaInsn)this.insns.get(this.insns.size() - 1);
    paramInsn = SsaInsn.makeFromRop(paramInsn, this);
    this.insns.set(this.insns.size() - 1, paramInsn);
    this.parent.onInsnRemoved(localSsaInsn);
    this.parent.onInsnAdded(paramInsn);
  }
  
  public void replaceSuccessor(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    this.successors.set(paramInt2);
    if (this.primarySuccessor == paramInt1) {
      this.primarySuccessor = paramInt2;
    }
    int i = this.successorList.size() - 1;
    while (i >= 0)
    {
      if (this.successorList.get(i) == paramInt1) {
        this.successorList.set(i, paramInt2);
      }
      i -= 1;
    }
    this.successors.clear(paramInt1);
    ((SsaBasicBlock)this.parent.getBlocks().get(paramInt2)).predecessors.set(this.index);
    ((SsaBasicBlock)this.parent.getBlocks().get(paramInt1)).predecessors.clear(this.index);
  }
  
  public void scheduleMovesFromPhis()
  {
    if (this.movesFromPhisAtBeginning > 1)
    {
      scheduleUseBeforeAssigned(this.insns.subList(0, this.movesFromPhisAtBeginning));
      if (((SsaInsn)this.insns.get(this.movesFromPhisAtBeginning)).isMoveException()) {
        throw new RuntimeException("Unexpected: moves from phis before move-exception");
      }
    }
    if (this.movesFromPhisAtEnd > 1) {
      scheduleUseBeforeAssigned(this.insns.subList(this.insns.size() - this.movesFromPhisAtEnd - 1, this.insns.size() - 1));
    }
    this.parent.returnSpareRegisters();
  }
  
  public void setReachable(int paramInt)
  {
    this.reachable = paramInt;
  }
  
  public String toString()
  {
    return "{" + this.index + ":" + Hex.u2(this.ropLabel) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaBasicBlock
 * JD-Core Version:    0.7.0.1
 */