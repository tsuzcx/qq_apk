package com.android.dx.dex.file;

import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.Iterator;

public final class AnnotationSetItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 4;
  private static final int ENTRY_WRITE_SIZE = 4;
  private final Annotations annotations;
  private final AnnotationItem[] items;
  
  public AnnotationSetItem(Annotations paramAnnotations, DexFile paramDexFile)
  {
    super(4, writeSize(paramAnnotations));
    this.annotations = paramAnnotations;
    this.items = new AnnotationItem[paramAnnotations.size()];
    paramAnnotations = paramAnnotations.getAnnotations().iterator();
    int i = 0;
    while (paramAnnotations.hasNext())
    {
      Annotation localAnnotation = (Annotation)paramAnnotations.next();
      this.items[i] = new AnnotationItem(localAnnotation, paramDexFile);
      i += 1;
    }
  }
  
  private static int writeSize(Annotations paramAnnotations)
  {
    try
    {
      int i = paramAnnotations.size();
      return i * 4 + 4;
    }
    catch (NullPointerException paramAnnotations)
    {
      throw new NullPointerException("list == null");
    }
  }
  
  public void addContents(DexFile paramDexFile)
  {
    paramDexFile = paramDexFile.getByteData();
    int j = this.items.length;
    int i = 0;
    while (i < j)
    {
      this.items[i] = ((AnnotationItem)paramDexFile.intern(this.items[i]));
      i += 1;
    }
  }
  
  protected int compareTo0(OffsettedItem paramOffsettedItem)
  {
    paramOffsettedItem = (AnnotationSetItem)paramOffsettedItem;
    return this.annotations.compareTo(paramOffsettedItem.annotations);
  }
  
  public Annotations getAnnotations()
  {
    return this.annotations;
  }
  
  public int hashCode()
  {
    return this.annotations.hashCode();
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_ANNOTATION_SET_ITEM;
  }
  
  protected void place0(Section paramSection, int paramInt)
  {
    AnnotationItem.sortByTypeIdIndex(this.items);
  }
  
  public String toHuman()
  {
    return this.annotations.toString();
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int i = 0;
    boolean bool = paramAnnotatedOutput.annotates();
    int j = this.items.length;
    if (bool)
    {
      paramAnnotatedOutput.annotate(0, offsetString() + " annotation set");
      paramAnnotatedOutput.annotate(4, "  size: " + Hex.u4(j));
    }
    paramAnnotatedOutput.writeInt(j);
    while (i < j)
    {
      int k = this.items[i].getAbsoluteOffset();
      if (bool)
      {
        paramAnnotatedOutput.annotate(4, "  entries[" + Integer.toHexString(i) + "]: " + Hex.u4(k));
        this.items[i].annotateTo(paramAnnotatedOutput, "    ");
      }
      paramAnnotatedOutput.writeInt(k);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.AnnotationSetItem
 * JD-Core Version:    0.7.0.1
 */