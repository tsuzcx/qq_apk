package com.android.dx.rop.code;

import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.LabeledItem;

public final class BasicBlock
  implements LabeledItem
{
  private final InsnList insns;
  private final int label;
  private final int primarySuccessor;
  private final IntList successors;
  
  public BasicBlock(int paramInt1, InsnList paramInsnList, IntList paramIntList, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("label < 0");
    }
    int j;
    try
    {
      paramInsnList.throwIfMutable();
      j = paramInsnList.size();
      if (j == 0) {
        throw new IllegalArgumentException("insns.size() == 0");
      }
    }
    catch (NullPointerException paramInsnList)
    {
      throw new NullPointerException("insns == null");
    }
    int i = j - 2;
    while (i >= 0)
    {
      if (paramInsnList.get(i).getOpcode().getBranchingness() != 1) {
        throw new IllegalArgumentException("insns[" + i + "] is a branch or can throw");
      }
      i -= 1;
    }
    if (paramInsnList.get(j - 1).getOpcode().getBranchingness() == 1) {
      throw new IllegalArgumentException("insns does not end with a branch or throwing instruction");
    }
    try
    {
      paramIntList.throwIfMutable();
      if (paramInt2 < -1) {
        throw new IllegalArgumentException("primarySuccessor < -1");
      }
    }
    catch (NullPointerException paramInsnList)
    {
      throw new NullPointerException("successors == null");
    }
    if ((paramInt2 >= 0) && (!paramIntList.contains(paramInt2))) {
      throw new IllegalArgumentException("primarySuccessor " + paramInt2 + " not in successors " + paramIntList);
    }
    this.label = paramInt1;
    this.insns = paramInsnList;
    this.successors = paramIntList;
    this.primarySuccessor = paramInt2;
  }
  
  public boolean canThrow()
  {
    return this.insns.getLast().canThrow();
  }
  
  public boolean equals(Object paramObject)
  {
    return this == paramObject;
  }
  
  public TypeList getExceptionHandlerTypes()
  {
    return this.insns.getLast().getCatches();
  }
  
  public Insn getFirstInsn()
  {
    return this.insns.get(0);
  }
  
  public InsnList getInsns()
  {
    return this.insns;
  }
  
  public int getLabel()
  {
    return this.label;
  }
  
  public Insn getLastInsn()
  {
    return this.insns.getLast();
  }
  
  public int getPrimarySuccessor()
  {
    return this.primarySuccessor;
  }
  
  public int getSecondarySuccessor()
  {
    if (this.successors.size() != 2) {
      throw new UnsupportedOperationException("block doesn't have exactly two successors");
    }
    int j = this.successors.get(0);
    int i = j;
    if (j == this.primarySuccessor) {
      i = this.successors.get(1);
    }
    return i;
  }
  
  public IntList getSuccessors()
  {
    return this.successors;
  }
  
  public boolean hasExceptionHandlers()
  {
    return this.insns.getLast().getCatches().size() != 0;
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this);
  }
  
  public String toString()
  {
    return '{' + Hex.u2(this.label) + '}';
  }
  
  public BasicBlock withRegisterOffset(int paramInt)
  {
    return new BasicBlock(this.label, this.insns.withRegisterOffset(paramInt), this.successors, this.primarySuccessor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.BasicBlock
 * JD-Core Version:    0.7.0.1
 */