package com.android.dx.rop.cst;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.util.Hex;
import com.android.dx.util.MutabilityControl;

public final class StdConstantPool
  extends MutabilityControl
  implements ConstantPool
{
  private final Constant[] entries;
  
  public StdConstantPool(int paramInt) {}
  
  private static Constant throwInvalid(int paramInt)
  {
    throw new ExceptionWithContext("invalid constant pool index " + Hex.u2(paramInt));
  }
  
  public Constant get(int paramInt)
  {
    try
    {
      Constant localConstant = this.entries[paramInt];
      if (localConstant == null) {
        throwInvalid(paramInt);
      }
      return localConstant;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
    return throwInvalid(paramInt);
  }
  
  public Constant get0Ok(int paramInt)
  {
    if (paramInt == 0) {
      return null;
    }
    return get(paramInt);
  }
  
  public Constant[] getEntries()
  {
    return this.entries;
  }
  
  public Constant getOrNull(int paramInt)
  {
    try
    {
      Constant localConstant = this.entries[paramInt];
      return localConstant;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
    return throwInvalid(paramInt);
  }
  
  public void set(int paramInt, Constant paramConstant)
  {
    throwIfImmutable();
    if ((paramConstant != null) && (paramConstant.isCategory2())) {}
    for (int i = 1; paramInt < 1; i = 0) {
      throw new IllegalArgumentException("n < 1");
    }
    if (i != 0)
    {
      if (paramInt == this.entries.length - 1) {
        throw new IllegalArgumentException("(n == size - 1) && cst.isCategory2()");
      }
      this.entries[(paramInt + 1)] = null;
    }
    if ((paramConstant != null) && (this.entries[paramInt] == null))
    {
      Constant localConstant = this.entries[(paramInt - 1)];
      if ((localConstant != null) && (localConstant.isCategory2())) {
        this.entries[(paramInt - 1)] = null;
      }
    }
    this.entries[paramInt] = paramConstant;
  }
  
  public int size()
  {
    return this.entries.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.StdConstantPool
 * JD-Core Version:    0.7.0.1
 */