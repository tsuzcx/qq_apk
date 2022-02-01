package com.android.dx.ssa;

import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public final class SsaMethod
{
  private boolean backMode;
  private ArrayList<SsaBasicBlock> blocks;
  private int borrowedSpareRegisters;
  private SsaInsn[] definitionList;
  private int entryBlockIndex;
  private int exitBlockIndex;
  private final boolean isStatic;
  private int maxLabel;
  private final int paramWidth;
  private int registerCount;
  private int spareRegisterBase;
  private List<SsaInsn>[] unmodifiableUseList;
  private ArrayList<SsaInsn>[] useList;
  
  private SsaMethod(RopMethod paramRopMethod, int paramInt, boolean paramBoolean)
  {
    this.paramWidth = paramInt;
    this.isStatic = paramBoolean;
    this.backMode = false;
    this.maxLabel = paramRopMethod.getBlocks().getMaxLabel();
    this.registerCount = paramRopMethod.getBlocks().getRegCount();
    this.spareRegisterBase = this.registerCount;
  }
  
  static BitSet bitSetFromLabelList(BasicBlockList paramBasicBlockList, IntList paramIntList)
  {
    BitSet localBitSet = new BitSet(paramBasicBlockList.size());
    int i = 0;
    int j = paramIntList.size();
    while (i < j)
    {
      localBitSet.set(paramBasicBlockList.indexOfLabel(paramIntList.get(i)));
      i += 1;
    }
    return localBitSet;
  }
  
  private void buildUseList()
  {
    int j = 0;
    if (this.backMode) {
      throw new RuntimeException("No use list in back mode");
    }
    this.useList = new ArrayList[this.registerCount];
    int i = 0;
    while (i < this.registerCount)
    {
      this.useList[i] = new ArrayList();
      i += 1;
    }
    forEachInsn(new SsaMethod.2(this));
    this.unmodifiableUseList = new List[this.registerCount];
    i = j;
    while (i < this.registerCount)
    {
      this.unmodifiableUseList[i] = Collections.unmodifiableList(this.useList[i]);
      i += 1;
    }
  }
  
  private void convertRopToSsaBlocks(RopMethod paramRopMethod)
  {
    int j = paramRopMethod.getBlocks().size();
    this.blocks = new ArrayList(j + 2);
    int i = 0;
    while (i < j)
    {
      SsaBasicBlock localSsaBasicBlock = SsaBasicBlock.newFromRop(paramRopMethod, i, this);
      this.blocks.add(localSsaBasicBlock);
      i += 1;
    }
    i = paramRopMethod.getBlocks().indexOfLabel(paramRopMethod.getFirstLabel());
    this.entryBlockIndex = ((SsaBasicBlock)this.blocks.get(i)).insertNewPredecessor().getIndex();
    this.exitBlockIndex = -1;
  }
  
  private static SsaInsn getGoto(SsaBasicBlock paramSsaBasicBlock)
  {
    return new NormalSsaInsn(new PlainInsn(Rops.GOTO, SourcePosition.NO_INFO, null, RegisterSpecList.EMPTY), paramSsaBasicBlock);
  }
  
  public static IntList indexListFromLabelList(BasicBlockList paramBasicBlockList, IntList paramIntList)
  {
    IntList localIntList = new IntList(paramIntList.size());
    int i = 0;
    int j = paramIntList.size();
    while (i < j)
    {
      localIntList.add(paramBasicBlockList.indexOfLabel(paramIntList.get(i)));
      i += 1;
    }
    return localIntList;
  }
  
  public static SsaMethod newFromRopMethod(RopMethod paramRopMethod, int paramInt, boolean paramBoolean)
  {
    SsaMethod localSsaMethod = new SsaMethod(paramRopMethod, paramInt, paramBoolean);
    localSsaMethod.convertRopToSsaBlocks(paramRopMethod);
    return localSsaMethod;
  }
  
  private void removeFromUseList(SsaInsn paramSsaInsn, RegisterSpecList paramRegisterSpecList)
  {
    if (paramRegisterSpecList == null) {}
    for (;;)
    {
      return;
      int j = paramRegisterSpecList.size();
      int i = 0;
      while (i < j)
      {
        if (!this.useList[paramRegisterSpecList.get(i).getReg()].remove(paramSsaInsn)) {
          throw new RuntimeException("use not found");
        }
        i += 1;
      }
    }
  }
  
  public int blockIndexToRopLabel(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    return ((SsaBasicBlock)this.blocks.get(paramInt)).getRopLabel();
  }
  
  public int borrowSpareRegister(int paramInt)
  {
    int i = this.spareRegisterBase + this.borrowedSpareRegisters;
    this.borrowedSpareRegisters += paramInt;
    this.registerCount = Math.max(this.registerCount, i + paramInt);
    return i;
  }
  
  public void computeReachability()
  {
    Object localObject1 = this.blocks.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((SsaBasicBlock)((Iterator)localObject1).next()).setReachable(0);
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getEntryBlock());
    while (!((ArrayList)localObject1).isEmpty())
    {
      Object localObject2 = (SsaBasicBlock)((ArrayList)localObject1).remove(0);
      if (!((SsaBasicBlock)localObject2).isReachable())
      {
        ((SsaBasicBlock)localObject2).setReachable(1);
        localObject2 = ((SsaBasicBlock)localObject2).getSuccessors();
        for (int i = ((BitSet)localObject2).nextSetBit(0); i >= 0; i = ((BitSet)localObject2).nextSetBit(i + 1)) {
          ((ArrayList)localObject1).add(this.blocks.get(i));
        }
      }
    }
  }
  
  public void deleteInsns(Set<SsaInsn> paramSet)
  {
    Iterator localIterator = getBlocks().iterator();
    label218:
    while (localIterator.hasNext())
    {
      SsaBasicBlock localSsaBasicBlock = (SsaBasicBlock)localIterator.next();
      ArrayList localArrayList = localSsaBasicBlock.getInsns();
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        localObject = (SsaInsn)localArrayList.get(i);
        if (paramSet.contains(localObject))
        {
          onInsnRemoved((SsaInsn)localObject);
          localArrayList.remove(i);
        }
        i -= 1;
      }
      i = localArrayList.size();
      if (i == 0) {}
      for (Object localObject = null;; localObject = (SsaInsn)localArrayList.get(i - 1))
      {
        if ((localSsaBasicBlock == getExitBlock()) || ((i != 0) && (((SsaInsn)localObject).getOriginalRopInsn() != null) && (((SsaInsn)localObject).getOriginalRopInsn().getOpcode().getBranchingness() != 1))) {
          break label218;
        }
        localArrayList.add(SsaInsn.makeFromRop(new PlainInsn(Rops.GOTO, SourcePosition.NO_INFO, null, RegisterSpecList.EMPTY), localSsaBasicBlock));
        localObject = localSsaBasicBlock.getSuccessors();
        for (i = ((BitSet)localObject).nextSetBit(0); i >= 0; i = ((BitSet)localObject).nextSetBit(i + 1)) {
          if (i != localSsaBasicBlock.getPrimarySuccessorIndex()) {
            localSsaBasicBlock.removeSuccessor(i);
          }
        }
        break;
      }
    }
  }
  
  public void forEachBlockDepthFirst(boolean paramBoolean, SsaBasicBlock.Visitor paramVisitor)
  {
    BitSet localBitSet = new BitSet(this.blocks.size());
    Stack localStack = new Stack();
    Object localObject;
    if (paramBoolean)
    {
      localObject = getExitBlock();
      if (localObject != null) {
        break label50;
      }
    }
    for (;;)
    {
      return;
      localObject = getEntryBlock();
      break;
      label50:
      localStack.add(null);
      localStack.add(localObject);
      while (localStack.size() > 0)
      {
        SsaBasicBlock localSsaBasicBlock1 = (SsaBasicBlock)localStack.pop();
        SsaBasicBlock localSsaBasicBlock2 = (SsaBasicBlock)localStack.pop();
        if (!localBitSet.get(localSsaBasicBlock1.getIndex()))
        {
          if (paramBoolean) {}
          for (localObject = localSsaBasicBlock1.getPredecessors();; localObject = localSsaBasicBlock1.getSuccessors()) {
            for (int i = ((BitSet)localObject).nextSetBit(0); i >= 0; i = ((BitSet)localObject).nextSetBit(i + 1))
            {
              localStack.add(localSsaBasicBlock1);
              localStack.add(this.blocks.get(i));
            }
          }
          localBitSet.set(localSsaBasicBlock1.getIndex());
          paramVisitor.visitBlock(localSsaBasicBlock1, localSsaBasicBlock2);
        }
      }
    }
  }
  
  public void forEachBlockDepthFirstDom(SsaBasicBlock.Visitor paramVisitor)
  {
    BitSet localBitSet = new BitSet(getBlocks().size());
    Stack localStack = new Stack();
    localStack.add(getEntryBlock());
    while (localStack.size() > 0)
    {
      SsaBasicBlock localSsaBasicBlock = (SsaBasicBlock)localStack.pop();
      ArrayList localArrayList = localSsaBasicBlock.getDomChildren();
      if (!localBitSet.get(localSsaBasicBlock.getIndex()))
      {
        int i = localArrayList.size() - 1;
        while (i >= 0)
        {
          localStack.add((SsaBasicBlock)localArrayList.get(i));
          i -= 1;
        }
        localBitSet.set(localSsaBasicBlock.getIndex());
        paramVisitor.visitBlock(localSsaBasicBlock, null);
      }
    }
  }
  
  public void forEachInsn(SsaInsn.Visitor paramVisitor)
  {
    Iterator localIterator = this.blocks.iterator();
    while (localIterator.hasNext()) {
      ((SsaBasicBlock)localIterator.next()).forEachInsn(paramVisitor);
    }
  }
  
  public void forEachPhiInsn(PhiInsn.Visitor paramVisitor)
  {
    Iterator localIterator = this.blocks.iterator();
    while (localIterator.hasNext()) {
      ((SsaBasicBlock)localIterator.next()).forEachPhiInsn(paramVisitor);
    }
  }
  
  public ArrayList<SsaBasicBlock> getBlocks()
  {
    return this.blocks;
  }
  
  public int getCountReachableBlocks()
  {
    Iterator localIterator = this.blocks.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((SsaBasicBlock)localIterator.next()).isReachable()) {
        break label43;
      }
      i += 1;
    }
    label43:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public SsaInsn getDefinitionForRegister(int paramInt)
  {
    if (this.backMode) {
      throw new RuntimeException("No def list in back mode");
    }
    if (this.definitionList != null) {
      return this.definitionList[paramInt];
    }
    this.definitionList = new SsaInsn[getRegCount()];
    forEachInsn(new SsaMethod.1(this));
    return this.definitionList[paramInt];
  }
  
  public SsaBasicBlock getEntryBlock()
  {
    return (SsaBasicBlock)this.blocks.get(this.entryBlockIndex);
  }
  
  public int getEntryBlockIndex()
  {
    return this.entryBlockIndex;
  }
  
  public SsaBasicBlock getExitBlock()
  {
    if (this.exitBlockIndex < 0) {
      return null;
    }
    return (SsaBasicBlock)this.blocks.get(this.exitBlockIndex);
  }
  
  public int getExitBlockIndex()
  {
    return this.exitBlockIndex;
  }
  
  public int getParamWidth()
  {
    return this.paramWidth;
  }
  
  public int getRegCount()
  {
    return this.registerCount;
  }
  
  public ArrayList<SsaInsn>[] getUseListCopy()
  {
    if (this.useList == null) {
      buildUseList();
    }
    ArrayList[] arrayOfArrayList = (ArrayList[])new ArrayList[this.registerCount];
    int i = 0;
    while (i < this.registerCount)
    {
      arrayOfArrayList[i] = new ArrayList(this.useList[i]);
      i += 1;
    }
    return arrayOfArrayList;
  }
  
  public List<SsaInsn> getUseListForRegister(int paramInt)
  {
    if (this.unmodifiableUseList == null) {
      buildUseList();
    }
    return this.unmodifiableUseList[paramInt];
  }
  
  public boolean isRegALocal(RegisterSpec paramRegisterSpec)
  {
    Object localObject = getDefinitionForRegister(paramRegisterSpec.getReg());
    if (localObject == null) {
      return false;
    }
    if (((SsaInsn)localObject).getLocalAssignment() != null) {
      return true;
    }
    paramRegisterSpec = getUseListForRegister(paramRegisterSpec.getReg()).iterator();
    while (paramRegisterSpec.hasNext())
    {
      localObject = ((SsaInsn)paramRegisterSpec.next()).getOriginalRopInsn();
      if ((localObject != null) && (((Insn)localObject).getOpcode().getOpcode() == 54)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isStatic()
  {
    return this.isStatic;
  }
  
  void makeExitBlock()
  {
    if (this.exitBlockIndex >= 0) {
      throw new RuntimeException("must be called at most once");
    }
    this.exitBlockIndex = this.blocks.size();
    int i = this.exitBlockIndex;
    int j = this.maxLabel;
    this.maxLabel = (j + 1);
    SsaBasicBlock localSsaBasicBlock = new SsaBasicBlock(i, j, this);
    this.blocks.add(localSsaBasicBlock);
    Iterator localIterator = this.blocks.iterator();
    while (localIterator.hasNext()) {
      ((SsaBasicBlock)localIterator.next()).exitBlockFixup(localSsaBasicBlock);
    }
    if (localSsaBasicBlock.getPredecessors().cardinality() == 0)
    {
      this.blocks.remove(this.exitBlockIndex);
      this.exitBlockIndex = -1;
      this.maxLabel -= 1;
    }
  }
  
  public SsaBasicBlock makeNewGotoBlock()
  {
    int i = this.blocks.size();
    int j = this.maxLabel;
    this.maxLabel = (j + 1);
    SsaBasicBlock localSsaBasicBlock = new SsaBasicBlock(i, j, this);
    localSsaBasicBlock.getInsns().add(getGoto(localSsaBasicBlock));
    this.blocks.add(localSsaBasicBlock);
    return localSsaBasicBlock;
  }
  
  public int makeNewSsaReg()
  {
    int i = this.registerCount;
    this.registerCount = (i + 1);
    this.spareRegisterBase = this.registerCount;
    onInsnsChanged();
    return i;
  }
  
  public void mapRegisters(RegisterMapper paramRegisterMapper)
  {
    Iterator localIterator1 = getBlocks().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((SsaBasicBlock)localIterator1.next()).getInsns().iterator();
      while (localIterator2.hasNext()) {
        ((SsaInsn)localIterator2.next()).mapRegisters(paramRegisterMapper);
      }
    }
    this.registerCount = paramRegisterMapper.getNewRegisterCount();
    this.spareRegisterBase = this.registerCount;
  }
  
  void onInsnAdded(SsaInsn paramSsaInsn)
  {
    onSourcesChanged(paramSsaInsn, null);
    updateOneDefinition(paramSsaInsn, null);
  }
  
  void onInsnRemoved(SsaInsn paramSsaInsn)
  {
    if (this.useList != null) {
      removeFromUseList(paramSsaInsn, paramSsaInsn.getSources());
    }
    paramSsaInsn = paramSsaInsn.getResult();
    if ((this.definitionList != null) && (paramSsaInsn != null)) {
      this.definitionList[paramSsaInsn.getReg()] = null;
    }
  }
  
  public void onInsnsChanged()
  {
    this.definitionList = null;
    this.useList = null;
    this.unmodifiableUseList = null;
  }
  
  void onSourceChanged(SsaInsn paramSsaInsn, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    if (this.useList == null) {
      return;
    }
    if (paramRegisterSpec1 != null)
    {
      i = paramRegisterSpec1.getReg();
      this.useList[i].remove(paramSsaInsn);
    }
    int i = paramRegisterSpec2.getReg();
    if (this.useList.length <= i)
    {
      this.useList = null;
      return;
    }
    this.useList[i].add(paramSsaInsn);
  }
  
  void onSourcesChanged(SsaInsn paramSsaInsn, RegisterSpecList paramRegisterSpecList)
  {
    if (this.useList == null) {}
    for (;;)
    {
      return;
      if (paramRegisterSpecList != null) {
        removeFromUseList(paramSsaInsn, paramRegisterSpecList);
      }
      paramRegisterSpecList = paramSsaInsn.getSources();
      int j = paramRegisterSpecList.size();
      int i = 0;
      while (i < j)
      {
        int k = paramRegisterSpecList.get(i).getReg();
        this.useList[k].add(paramSsaInsn);
        i += 1;
      }
    }
  }
  
  public void returnSpareRegisters()
  {
    this.borrowedSpareRegisters = 0;
  }
  
  public void setBackMode()
  {
    this.backMode = true;
    this.useList = null;
    this.definitionList = null;
  }
  
  void setNewRegCount(int paramInt)
  {
    this.registerCount = paramInt;
    this.spareRegisterBase = this.registerCount;
    onInsnsChanged();
  }
  
  void updateOneDefinition(SsaInsn paramSsaInsn, RegisterSpec paramRegisterSpec)
  {
    if (this.definitionList == null) {}
    do
    {
      return;
      if (paramRegisterSpec != null)
      {
        i = paramRegisterSpec.getReg();
        this.definitionList[i] = null;
      }
      paramRegisterSpec = paramSsaInsn.getResult();
    } while (paramRegisterSpec == null);
    int i = paramRegisterSpec.getReg();
    if (this.definitionList[i] != null) {
      throw new RuntimeException("Duplicate add of insn");
    }
    this.definitionList[paramRegisterSpec.getReg()] = paramSsaInsn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaMethod
 * JD-Core Version:    0.7.0.1
 */