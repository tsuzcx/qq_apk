package com.android.dx.rop.code;

import com.android.dx.util.MutabilityControl;
import java.io.PrintStream;
import java.util.HashMap;

public final class LocalVariableInfo
  extends MutabilityControl
{
  private final RegisterSpecSet[] blockStarts;
  private final RegisterSpecSet emptySet;
  private final HashMap<Insn, RegisterSpec> insnAssignments;
  private final int regCount;
  
  public LocalVariableInfo(RopMethod paramRopMethod)
  {
    if (paramRopMethod == null) {
      throw new NullPointerException("method == null");
    }
    paramRopMethod = paramRopMethod.getBlocks();
    int i = paramRopMethod.getMaxLabel();
    this.regCount = paramRopMethod.getRegCount();
    this.emptySet = new RegisterSpecSet(this.regCount);
    this.blockStarts = new RegisterSpecSet[i];
    this.insnAssignments = new HashMap(paramRopMethod.getInstructionCount());
    this.emptySet.setImmutable();
  }
  
  private RegisterSpecSet getStarts0(int paramInt)
  {
    try
    {
      RegisterSpecSet localRegisterSpecSet = this.blockStarts[paramInt];
      return localRegisterSpecSet;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IllegalArgumentException("bogus label");
    }
  }
  
  public void addAssignment(Insn paramInsn, RegisterSpec paramRegisterSpec)
  {
    throwIfImmutable();
    if (paramInsn == null) {
      throw new NullPointerException("insn == null");
    }
    if (paramRegisterSpec == null) {
      throw new NullPointerException("spec == null");
    }
    this.insnAssignments.put(paramInsn, paramRegisterSpec);
  }
  
  public void debugDump()
  {
    int i = 0;
    if (i < this.blockStarts.length)
    {
      if (this.blockStarts[i] == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (this.blockStarts[i] == this.emptySet) {
          System.out.printf("%04x: empty set\n", new Object[] { Integer.valueOf(i) });
        } else {
          System.out.printf("%04x: %s\n", new Object[] { Integer.valueOf(i), this.blockStarts[i] });
        }
      }
    }
  }
  
  public RegisterSpec getAssignment(Insn paramInsn)
  {
    return (RegisterSpec)this.insnAssignments.get(paramInsn);
  }
  
  public int getAssignmentCount()
  {
    return this.insnAssignments.size();
  }
  
  public RegisterSpecSet getStarts(int paramInt)
  {
    RegisterSpecSet localRegisterSpecSet = getStarts0(paramInt);
    if (localRegisterSpecSet != null) {
      return localRegisterSpecSet;
    }
    return this.emptySet;
  }
  
  public RegisterSpecSet getStarts(BasicBlock paramBasicBlock)
  {
    return getStarts(paramBasicBlock.getLabel());
  }
  
  public boolean mergeStarts(int paramInt, RegisterSpecSet paramRegisterSpecSet)
  {
    RegisterSpecSet localRegisterSpecSet2 = getStarts0(paramInt);
    if (localRegisterSpecSet2 == null)
    {
      setStarts(paramInt, paramRegisterSpecSet);
      return true;
    }
    RegisterSpecSet localRegisterSpecSet1 = localRegisterSpecSet2.mutableCopy();
    if (localRegisterSpecSet2.size() != 0) {
      localRegisterSpecSet1.intersect(paramRegisterSpecSet, true);
    }
    for (paramRegisterSpecSet = localRegisterSpecSet1; localRegisterSpecSet2.equals(paramRegisterSpecSet); paramRegisterSpecSet = paramRegisterSpecSet.mutableCopy()) {
      return false;
    }
    paramRegisterSpecSet.setImmutable();
    setStarts(paramInt, paramRegisterSpecSet);
    return true;
  }
  
  public RegisterSpecSet mutableCopyOfStarts(int paramInt)
  {
    RegisterSpecSet localRegisterSpecSet = getStarts0(paramInt);
    if (localRegisterSpecSet != null) {
      return localRegisterSpecSet.mutableCopy();
    }
    return new RegisterSpecSet(this.regCount);
  }
  
  public void setStarts(int paramInt, RegisterSpecSet paramRegisterSpecSet)
  {
    throwIfImmutable();
    if (paramRegisterSpecSet == null) {
      throw new NullPointerException("specs == null");
    }
    try
    {
      this.blockStarts[paramInt] = paramRegisterSpecSet;
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramRegisterSpecSet)
    {
      throw new IllegalArgumentException("bogus label");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.LocalVariableInfo
 * JD-Core Version:    0.7.0.1
 */