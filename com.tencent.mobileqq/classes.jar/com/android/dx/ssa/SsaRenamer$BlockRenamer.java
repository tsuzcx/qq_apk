package com.android.dx.ssa;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.type.TypeBearer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class SsaRenamer$BlockRenamer
  implements SsaInsn.Visitor
{
  private final SsaBasicBlock block;
  private final RegisterSpec[] currentMapping;
  private final HashMap<SsaInsn, SsaInsn> insnsToReplace;
  private final SsaRenamer.BlockRenamer.RenamingMapper mapper;
  private final HashSet<SsaInsn> movesToKeep;
  
  SsaRenamer$BlockRenamer(SsaRenamer paramSsaRenamer, SsaBasicBlock paramSsaBasicBlock)
  {
    this.block = paramSsaBasicBlock;
    this.currentMapping = SsaRenamer.access$000(paramSsaRenamer)[paramSsaBasicBlock.getIndex()];
    this.movesToKeep = new HashSet();
    this.insnsToReplace = new HashMap();
    this.mapper = new SsaRenamer.BlockRenamer.RenamingMapper(this);
    SsaRenamer.access$000(paramSsaRenamer)[paramSsaBasicBlock.getIndex()] = null;
  }
  
  private void addMapping(int paramInt, RegisterSpec paramRegisterSpec)
  {
    int i = paramRegisterSpec.getReg();
    LocalItem localLocalItem = paramRegisterSpec.getLocalItem();
    this.currentMapping[paramInt] = paramRegisterSpec;
    paramInt = this.currentMapping.length - 1;
    while (paramInt >= 0)
    {
      if (i == this.currentMapping[paramInt].getReg()) {
        this.currentMapping[paramInt] = paramRegisterSpec;
      }
      paramInt -= 1;
    }
    if (localLocalItem == null) {}
    for (;;)
    {
      return;
      SsaRenamer.access$400(this.this$0, paramRegisterSpec);
      paramInt = this.currentMapping.length - 1;
      while (paramInt >= 0)
      {
        paramRegisterSpec = this.currentMapping[paramInt];
        if ((i != paramRegisterSpec.getReg()) && (localLocalItem.equals(paramRegisterSpec.getLocalItem()))) {
          this.currentMapping[paramInt] = paramRegisterSpec.withLocalItem(null);
        }
        paramInt -= 1;
      }
    }
  }
  
  private void updateSuccessorPhis()
  {
    SsaRenamer.BlockRenamer.1 local1 = new SsaRenamer.BlockRenamer.1(this);
    BitSet localBitSet = this.block.getSuccessors();
    for (int i = localBitSet.nextSetBit(0); i >= 0; i = localBitSet.nextSetBit(i + 1)) {
      ((SsaBasicBlock)SsaRenamer.access$1100(this.this$0).getBlocks().get(i)).forEachPhiInsn(local1);
    }
  }
  
  public void process()
  {
    this.block.forEachInsn(this);
    updateSuccessorPhis();
    Object localObject1 = this.block.getInsns();
    int i = ((ArrayList)localObject1).size() - 1;
    Object localObject3;
    if (i >= 0)
    {
      localObject2 = (SsaInsn)((ArrayList)localObject1).get(i);
      localObject3 = (SsaInsn)this.insnsToReplace.get(localObject2);
      if (localObject3 != null) {
        ((ArrayList)localObject1).set(i, localObject3);
      }
      for (;;)
      {
        i -= 1;
        break;
        if ((((SsaInsn)localObject2).isNormalMoveInsn()) && (!this.movesToKeep.contains(localObject2))) {
          ((ArrayList)localObject1).remove(i);
        }
      }
    }
    Object localObject2 = this.block.getDomChildren().iterator();
    i = 1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (SsaBasicBlock)((Iterator)localObject2).next();
      if (localObject3 == this.block) {
        break label182;
      }
      if (i != 0)
      {
        localObject1 = this.currentMapping;
        label151:
        SsaRenamer.access$000(this.this$0)[localObject3.getIndex()] = localObject1;
        i = 0;
      }
    }
    label182:
    for (;;)
    {
      break;
      localObject1 = SsaRenamer.access$300(this.currentMapping);
      break label151;
      return;
    }
  }
  
  void processResultReg(SsaInsn paramSsaInsn)
  {
    RegisterSpec localRegisterSpec = paramSsaInsn.getResult();
    if (localRegisterSpec == null) {}
    int i;
    do
    {
      return;
      i = localRegisterSpec.getReg();
    } while (SsaRenamer.access$800(this.this$0, i));
    paramSsaInsn.changeResultReg(SsaRenamer.access$100(this.this$0));
    addMapping(i, paramSsaInsn.getResult());
    SsaRenamer.access$108(this.this$0);
  }
  
  public void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    int i = 0;
    RegisterSpec localRegisterSpec = paramNormalSsaInsn.getResult();
    int j = localRegisterSpec.getReg();
    int m = paramNormalSsaInsn.getSources().get(0).getReg();
    paramNormalSsaInsn.mapSourceRegisters(this.mapper);
    int k = paramNormalSsaInsn.getSources().get(0).getReg();
    LocalItem localLocalItem = this.currentMapping[m].getLocalItem();
    Object localObject2 = localRegisterSpec.getLocalItem();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localLocalItem;
    }
    localObject2 = SsaRenamer.access$500(this.this$0, k);
    if ((localObject2 == null) || (localObject1 == null) || (((LocalItem)localObject1).equals(localObject2))) {
      i = 1;
    }
    localObject2 = RegisterSpec.makeLocalOptional(k, localRegisterSpec.getType(), (LocalItem)localObject1);
    if ((!Optimizer.getPreserveLocals()) || ((i != 0) && (SsaRenamer.access$600(localObject1, localLocalItem)) && (SsaRenamer.access$700(this.this$0) == 0)))
    {
      addMapping(j, (RegisterSpec)localObject2);
      return;
    }
    if ((i != 0) && (localLocalItem == null) && (SsaRenamer.access$700(this.this$0) == 0))
    {
      localObject1 = RegisterSpecList.make(RegisterSpec.make(((RegisterSpec)localObject2).getReg(), ((RegisterSpec)localObject2).getType(), (LocalItem)localObject1));
      localObject1 = SsaInsn.makeFromRop(new PlainInsn(Rops.opMarkLocal((TypeBearer)localObject2), SourcePosition.NO_INFO, null, (RegisterSpecList)localObject1), this.block);
      this.insnsToReplace.put(paramNormalSsaInsn, localObject1);
      addMapping(j, (RegisterSpec)localObject2);
      return;
    }
    processResultReg(paramNormalSsaInsn);
    this.movesToKeep.add(paramNormalSsaInsn);
  }
  
  public void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    paramNormalSsaInsn.mapSourceRegisters(this.mapper);
    processResultReg(paramNormalSsaInsn);
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn)
  {
    processResultReg(paramPhiInsn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaRenamer.BlockRenamer
 * JD-Core Version:    0.7.0.1
 */