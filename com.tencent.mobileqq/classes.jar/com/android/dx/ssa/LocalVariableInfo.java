package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.util.MutabilityControl;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalVariableInfo
  extends MutabilityControl
{
  private final RegisterSpecSet[] blockStarts;
  private final RegisterSpecSet emptySet;
  private final HashMap<SsaInsn, RegisterSpec> insnAssignments;
  private final int regCount;
  
  public LocalVariableInfo(SsaMethod paramSsaMethod)
  {
    if (paramSsaMethod == null) {
      throw new NullPointerException("method == null");
    }
    ArrayList localArrayList = paramSsaMethod.getBlocks();
    this.regCount = paramSsaMethod.getRegCount();
    this.emptySet = new RegisterSpecSet(this.regCount);
    this.blockStarts = new RegisterSpecSet[localArrayList.size()];
    this.insnAssignments = new HashMap();
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
      throw new IllegalArgumentException("bogus index");
    }
  }
  
  public void addAssignment(SsaInsn paramSsaInsn, RegisterSpec paramRegisterSpec)
  {
    throwIfImmutable();
    if (paramSsaInsn == null) {
      throw new NullPointerException("insn == null");
    }
    if (paramRegisterSpec == null) {
      throw new NullPointerException("spec == null");
    }
    this.insnAssignments.put(paramSsaInsn, paramRegisterSpec);
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
  
  public RegisterSpec getAssignment(SsaInsn paramSsaInsn)
  {
    return (RegisterSpec)this.insnAssignments.get(paramSsaInsn);
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
  
  public RegisterSpecSet getStarts(SsaBasicBlock paramSsaBasicBlock)
  {
    return getStarts(paramSsaBasicBlock.getIndex());
  }
  
  public boolean mergeStarts(int paramInt, RegisterSpecSet paramRegisterSpecSet)
  {
    RegisterSpecSet localRegisterSpecSet1 = getStarts0(paramInt);
    if (localRegisterSpecSet1 == null)
    {
      setStarts(paramInt, paramRegisterSpecSet);
      return true;
    }
    RegisterSpecSet localRegisterSpecSet2 = localRegisterSpecSet1.mutableCopy();
    localRegisterSpecSet2.intersect(paramRegisterSpecSet, true);
    if (localRegisterSpecSet1.equals(localRegisterSpecSet2)) {
      return false;
    }
    localRegisterSpecSet2.setImmutable();
    setStarts(paramInt, localRegisterSpecSet2);
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
      throw new IllegalArgumentException("bogus index");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.LocalVariableInfo
 * JD-Core Version:    0.7.0.1
 */