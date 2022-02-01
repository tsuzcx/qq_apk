package com.android.dx.dex.file;

public abstract class IndexedItem
  extends Item
{
  private int index = -1;
  
  public final int getIndex()
  {
    if (this.index < 0) {
      throw new RuntimeException("index not yet set");
    }
    return this.index;
  }
  
  public final boolean hasIndex()
  {
    return this.index >= 0;
  }
  
  public final String indexString()
  {
    return '[' + Integer.toHexString(this.index) + ']';
  }
  
  public final void setIndex(int paramInt)
  {
    if (this.index != -1) {
      throw new RuntimeException("index already set");
    }
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.IndexedItem
 * JD-Core Version:    0.7.0.1
 */