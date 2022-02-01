package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;

public abstract class Item
{
  public abstract void addContents(DexFile paramDexFile);
  
  public abstract ItemType itemType();
  
  public final String typeName()
  {
    return itemType().toHuman();
  }
  
  public abstract int writeSize();
  
  public abstract void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.Item
 * JD-Core Version:    0.7.0.1
 */