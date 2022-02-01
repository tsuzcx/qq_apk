package com.android.dx.ssa.back;

import com.android.dx.ssa.SetFactory;
import com.android.dx.util.IntSet;
import java.io.PrintStream;
import java.util.ArrayList;

public class InterferenceGraph
{
  private final ArrayList<IntSet> interference;
  
  public InterferenceGraph(int paramInt)
  {
    this.interference = new ArrayList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      this.interference.add(SetFactory.makeInterferenceSet(paramInt));
      i += 1;
    }
  }
  
  private void ensureCapacity(int paramInt)
  {
    int i = this.interference.size();
    this.interference.ensureCapacity(paramInt);
    while (i < paramInt)
    {
      this.interference.add(SetFactory.makeInterferenceSet(paramInt));
      i += 1;
    }
  }
  
  public void add(int paramInt1, int paramInt2)
  {
    ensureCapacity(Math.max(paramInt1, paramInt2) + 1);
    ((IntSet)this.interference.get(paramInt1)).add(paramInt2);
    ((IntSet)this.interference.get(paramInt2)).add(paramInt1);
  }
  
  public void dumpToStdout()
  {
    int j = this.interference.size();
    int i = 0;
    while (i < j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Reg " + i + ":" + ((IntSet)this.interference.get(i)).toString());
      System.out.println(localStringBuilder.toString());
      i += 1;
    }
  }
  
  public void mergeInterferenceSet(int paramInt, IntSet paramIntSet)
  {
    if (paramInt < this.interference.size()) {
      paramIntSet.merge((IntSet)this.interference.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.InterferenceGraph
 * JD-Core Version:    0.7.0.1
 */