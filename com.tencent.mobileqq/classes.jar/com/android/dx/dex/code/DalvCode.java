package com.android.dx.dex.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.Type;
import java.util.HashSet;

public final class DalvCode
{
  private CatchTable catches;
  private DalvInsnList insns;
  private LocalList locals;
  private final int positionInfo;
  private PositionList positions;
  private CatchBuilder unprocessedCatches;
  private OutputFinisher unprocessedInsns;
  
  public DalvCode(int paramInt, OutputFinisher paramOutputFinisher, CatchBuilder paramCatchBuilder)
  {
    if (paramOutputFinisher == null) {
      throw new NullPointerException("unprocessedInsns == null");
    }
    if (paramCatchBuilder == null) {
      throw new NullPointerException("unprocessedCatches == null");
    }
    this.positionInfo = paramInt;
    this.unprocessedInsns = paramOutputFinisher;
    this.unprocessedCatches = paramCatchBuilder;
    this.catches = null;
    this.positions = null;
    this.locals = null;
    this.insns = null;
  }
  
  private void finishProcessingIfNecessary()
  {
    if (this.insns != null) {
      return;
    }
    this.insns = this.unprocessedInsns.finishProcessingAndGetList();
    this.positions = PositionList.make(this.insns, this.positionInfo);
    this.locals = LocalList.make(this.insns);
    this.catches = this.unprocessedCatches.build();
    this.unprocessedInsns = null;
    this.unprocessedCatches = null;
  }
  
  public void assignIndices(DalvCode.AssignIndicesCallback paramAssignIndicesCallback)
  {
    this.unprocessedInsns.assignIndices(paramAssignIndicesCallback);
  }
  
  public HashSet<Type> getCatchTypes()
  {
    return this.unprocessedCatches.getCatchTypes();
  }
  
  public CatchTable getCatches()
  {
    finishProcessingIfNecessary();
    return this.catches;
  }
  
  public HashSet<Constant> getInsnConstants()
  {
    return this.unprocessedInsns.getAllConstants();
  }
  
  public DalvInsnList getInsns()
  {
    finishProcessingIfNecessary();
    return this.insns;
  }
  
  public LocalList getLocals()
  {
    finishProcessingIfNecessary();
    return this.locals;
  }
  
  public PositionList getPositions()
  {
    finishProcessingIfNecessary();
    return this.positions;
  }
  
  public boolean hasAnyCatches()
  {
    return this.unprocessedCatches.hasAnyCatches();
  }
  
  public boolean hasLocals()
  {
    return this.unprocessedInsns.hasAnyLocalInfo();
  }
  
  public boolean hasPositions()
  {
    return (this.positionInfo != 1) && (this.unprocessedInsns.hasAnyPositionInfo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.DalvCode
 * JD-Core Version:    0.7.0.1
 */