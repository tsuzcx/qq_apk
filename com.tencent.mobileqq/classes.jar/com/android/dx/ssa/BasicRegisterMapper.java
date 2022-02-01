package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.util.IntList;

public class BasicRegisterMapper
  extends RegisterMapper
{
  private IntList oldToNew;
  private int runningCountNewRegisters;
  
  public BasicRegisterMapper(int paramInt)
  {
    this.oldToNew = new IntList(paramInt);
  }
  
  public void addMapping(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= this.oldToNew.size())
    {
      int i = paramInt1 - this.oldToNew.size();
      while (i >= 0)
      {
        this.oldToNew.add(-1);
        i -= 1;
      }
    }
    this.oldToNew.set(paramInt1, paramInt2);
    if (this.runningCountNewRegisters < paramInt2 + paramInt3) {
      this.runningCountNewRegisters = (paramInt2 + paramInt3);
    }
  }
  
  public int getNewRegisterCount()
  {
    return this.runningCountNewRegisters;
  }
  
  public RegisterSpec map(RegisterSpec paramRegisterSpec)
  {
    if (paramRegisterSpec == null) {
      return null;
    }
    int i;
    try
    {
      i = this.oldToNew.get(paramRegisterSpec.getReg());
      if (i < 0) {
        throw new RuntimeException("no mapping specified for register");
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    return paramRegisterSpec.withReg(i);
  }
  
  public int oldToNew(int paramInt)
  {
    if (paramInt >= this.oldToNew.size()) {
      return -1;
    }
    return this.oldToNew.get(paramInt);
  }
  
  public String toHuman()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Old\tNew\n");
    int j = this.oldToNew.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(i);
      localStringBuilder.append('\t');
      localStringBuilder.append(this.oldToNew.get(i));
      localStringBuilder.append('\n');
      i += 1;
    }
    localStringBuilder.append("new reg count:");
    localStringBuilder.append(this.runningCountNewRegisters);
    localStringBuilder.append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.BasicRegisterMapper
 * JD-Core Version:    0.7.0.1
 */