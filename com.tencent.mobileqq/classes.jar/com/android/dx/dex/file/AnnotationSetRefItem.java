package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;

public final class AnnotationSetRefItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 4;
  private static final int WRITE_SIZE = 4;
  private AnnotationSetItem annotations;
  
  public AnnotationSetRefItem(AnnotationSetItem paramAnnotationSetItem)
  {
    super(4, 4);
    if (paramAnnotationSetItem == null) {
      throw new NullPointerException("annotations == null");
    }
    this.annotations = paramAnnotationSetItem;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    this.annotations = ((AnnotationSetItem)paramDexFile.getWordData().intern(this.annotations));
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_ANNOTATION_SET_REF_ITEM;
  }
  
  public String toHuman()
  {
    return this.annotations.toHuman();
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int i = this.annotations.getAbsoluteOffset();
    if (paramAnnotatedOutput.annotates()) {
      paramAnnotatedOutput.annotate(4, "  annotations_off: " + Hex.u4(i));
    }
    paramAnnotatedOutput.writeInt(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.AnnotationSetRefItem
 * JD-Core Version:    0.7.0.1
 */