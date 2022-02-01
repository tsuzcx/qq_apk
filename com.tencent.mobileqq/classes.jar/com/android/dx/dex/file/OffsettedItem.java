package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.util.AnnotatedOutput;

public abstract class OffsettedItem
  extends Item
  implements Comparable<OffsettedItem>
{
  private Section addedTo;
  private final int alignment;
  private int offset;
  private int writeSize;
  
  public OffsettedItem(int paramInt1, int paramInt2)
  {
    Section.validateAlignment(paramInt1);
    if (paramInt2 < -1) {
      throw new IllegalArgumentException("writeSize < -1");
    }
    this.alignment = paramInt1;
    this.writeSize = paramInt2;
    this.addedTo = null;
    this.offset = -1;
  }
  
  public static int getAbsoluteOffsetOr0(OffsettedItem paramOffsettedItem)
  {
    if (paramOffsettedItem == null) {
      return 0;
    }
    return paramOffsettedItem.getAbsoluteOffset();
  }
  
  public final int compareTo(OffsettedItem paramOffsettedItem)
  {
    if (this == paramOffsettedItem) {
      return 0;
    }
    ItemType localItemType1 = itemType();
    ItemType localItemType2 = paramOffsettedItem.itemType();
    if (localItemType1 != localItemType2) {
      return localItemType1.compareTo(localItemType2);
    }
    return compareTo0(paramOffsettedItem);
  }
  
  protected int compareTo0(OffsettedItem paramOffsettedItem)
  {
    throw new UnsupportedOperationException("unsupported");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      paramObject = (OffsettedItem)paramObject;
      if (itemType() != paramObject.itemType()) {
        return false;
      }
    } while (compareTo0(paramObject) == 0);
    return false;
  }
  
  public final int getAbsoluteOffset()
  {
    if (this.offset < 0) {
      throw new RuntimeException("offset not yet known");
    }
    return this.addedTo.getAbsoluteOffset(this.offset);
  }
  
  public final int getAlignment()
  {
    return this.alignment;
  }
  
  public final int getRelativeOffset()
  {
    if (this.offset < 0) {
      throw new RuntimeException("offset not yet known");
    }
    return this.offset;
  }
  
  public final String offsetString()
  {
    return '[' + Integer.toHexString(getAbsoluteOffset()) + ']';
  }
  
  public final int place(Section paramSection, int paramInt)
  {
    if (paramSection == null) {
      throw new NullPointerException("addedTo == null");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("offset < 0");
    }
    if (this.addedTo != null) {
      throw new RuntimeException("already written");
    }
    int i = this.alignment - 1;
    paramInt = (i ^ 0xFFFFFFFF) & paramInt + i;
    this.addedTo = paramSection;
    this.offset = paramInt;
    place0(paramSection, paramInt);
    return paramInt;
  }
  
  protected void place0(Section paramSection, int paramInt) {}
  
  public final void setWriteSize(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("writeSize < 0");
    }
    if (this.writeSize >= 0) {
      throw new UnsupportedOperationException("writeSize already set");
    }
    this.writeSize = paramInt;
  }
  
  public abstract String toHuman();
  
  public final int writeSize()
  {
    if (this.writeSize < 0) {
      throw new UnsupportedOperationException("writeSize is unknown");
    }
    return this.writeSize;
  }
  
  public final void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    paramAnnotatedOutput.alignTo(this.alignment);
    try
    {
      if (this.writeSize < 0) {
        throw new UnsupportedOperationException("writeSize is unknown");
      }
    }
    catch (RuntimeException paramDexFile)
    {
      throw ExceptionWithContext.withContext(paramDexFile, "...while writing " + this);
    }
    paramAnnotatedOutput.assertCursor(getAbsoluteOffset());
    writeTo0(paramDexFile, paramAnnotatedOutput);
  }
  
  protected abstract void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.OffsettedItem
 * JD-Core Version:    0.7.0.1
 */