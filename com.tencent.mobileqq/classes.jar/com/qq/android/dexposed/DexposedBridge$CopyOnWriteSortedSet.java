package com.qq.android.dexposed;

import java.util.Arrays;

public class DexposedBridge$CopyOnWriteSortedSet<E>
{
  private volatile transient Object[] elements = DexposedBridge.access$0();
  
  private int indexOf(Object paramObject)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.elements.length) {
        return -1;
      }
      if (paramObject.equals(this.elements[i])) {
        return i;
      }
      i += 1;
    }
  }
  
  public boolean add(E paramE)
  {
    try
    {
      int i = indexOf(paramE);
      if (i >= 0) {
        return false;
      }
      Object[] arrayOfObject = new Object[this.elements.length + 1];
      System.arraycopy(this.elements, 0, arrayOfObject, 0, this.elements.length);
      arrayOfObject[this.elements.length] = paramE;
      Arrays.sort(arrayOfObject);
      this.elements = arrayOfObject;
      return true;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.elements = DexposedBridge.access$0();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Object[] getSnapshot()
  {
    return this.elements;
  }
  
  public boolean remove(E paramE)
  {
    try
    {
      int i = indexOf(paramE);
      if (i == -1) {
        return false;
      }
      paramE = new Object[this.elements.length - 1];
      System.arraycopy(this.elements, 0, paramE, 0, i);
      System.arraycopy(this.elements, i + 1, paramE, i, this.elements.length - i - 1);
      this.elements = paramE;
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.DexposedBridge.CopyOnWriteSortedSet
 * JD-Core Version:    0.7.0.1
 */