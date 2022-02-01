package com.android.dx.util;

public abstract interface IntSet
{
  public abstract void add(int paramInt);
  
  public abstract int elements();
  
  public abstract boolean has(int paramInt);
  
  public abstract IntIterator iterator();
  
  public abstract void merge(IntSet paramIntSet);
  
  public abstract void remove(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.IntSet
 * JD-Core Version:    0.7.0.1
 */