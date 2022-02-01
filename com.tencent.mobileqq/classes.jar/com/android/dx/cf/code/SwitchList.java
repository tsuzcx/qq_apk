package com.android.dx.cf.code;

import com.android.dx.util.IntList;
import com.android.dx.util.MutabilityControl;

public final class SwitchList
  extends MutabilityControl
{
  private int size;
  private final IntList targets;
  private final IntList values;
  
  public SwitchList(int paramInt)
  {
    super(true);
    this.values = new IntList(paramInt);
    this.targets = new IntList(paramInt + 1);
    this.size = paramInt;
  }
  
  public void add(int paramInt1, int paramInt2)
  {
    throwIfImmutable();
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("target < 0");
    }
    this.values.add(paramInt1);
    this.targets.add(paramInt2);
  }
  
  public int getDefaultTarget()
  {
    return this.targets.get(this.size);
  }
  
  public int getTarget(int paramInt)
  {
    return this.targets.get(paramInt);
  }
  
  public IntList getTargets()
  {
    return this.targets;
  }
  
  public int getValue(int paramInt)
  {
    return this.values.get(paramInt);
  }
  
  public IntList getValues()
  {
    return this.values;
  }
  
  public void removeSuperfluousDefaults()
  {
    int j = 0;
    throwIfImmutable();
    int m = this.size;
    if (m != this.targets.size() - 1) {
      throw new IllegalArgumentException("incomplete instance");
    }
    int n = this.targets.get(m);
    int i = 0;
    while (i < m)
    {
      int i1 = this.targets.get(i);
      int k = j;
      if (i1 != n)
      {
        if (i != j)
        {
          this.targets.set(j, i1);
          this.values.set(j, this.values.get(i));
        }
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j != m)
    {
      this.values.shrink(j);
      this.targets.set(j, n);
      this.targets.shrink(j + 1);
      this.size = j;
    }
  }
  
  public void setDefaultTarget(int paramInt)
  {
    throwIfImmutable();
    if (paramInt < 0) {
      throw new IllegalArgumentException("target < 0");
    }
    if (this.targets.size() != this.size) {
      throw new RuntimeException("non-default elements not all set");
    }
    this.targets.add(paramInt);
  }
  
  public void setImmutable()
  {
    this.values.setImmutable();
    this.targets.setImmutable();
    super.setImmutable();
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.SwitchList
 * JD-Core Version:    0.7.0.1
 */