package com.android.dx.dex.file;

import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.ToHuman;

public final class FieldAnnotationStruct
  implements ToHuman, Comparable<FieldAnnotationStruct>
{
  private AnnotationSetItem annotations;
  private final CstFieldRef field;
  
  public FieldAnnotationStruct(CstFieldRef paramCstFieldRef, AnnotationSetItem paramAnnotationSetItem)
  {
    if (paramCstFieldRef == null) {
      throw new NullPointerException("field == null");
    }
    if (paramAnnotationSetItem == null) {
      throw new NullPointerException("annotations == null");
    }
    this.field = paramCstFieldRef;
    this.annotations = paramAnnotationSetItem;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    FieldIdsSection localFieldIdsSection = paramDexFile.getFieldIds();
    paramDexFile = paramDexFile.getWordData();
    localFieldIdsSection.intern(this.field);
    this.annotations = ((AnnotationSetItem)paramDexFile.intern(this.annotations));
  }
  
  public int compareTo(FieldAnnotationStruct paramFieldAnnotationStruct)
  {
    return this.field.compareTo(paramFieldAnnotationStruct.field);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FieldAnnotationStruct)) {
      return false;
    }
    return this.field.equals(((FieldAnnotationStruct)paramObject).field);
  }
  
  public Annotations getAnnotations()
  {
    return this.annotations.getAnnotations();
  }
  
  public CstFieldRef getField()
  {
    return this.field;
  }
  
  public int hashCode()
  {
    return this.field.hashCode();
  }
  
  public String toHuman()
  {
    return this.field.toHuman() + ": " + this.annotations;
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int i = paramDexFile.getFieldIds().indexOf(this.field);
    int j = this.annotations.getAbsoluteOffset();
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, "    " + this.field.toHuman());
      paramAnnotatedOutput.annotate(4, "      field_idx:       " + Hex.u4(i));
      paramAnnotatedOutput.annotate(4, "      annotations_off: " + Hex.u4(j));
    }
    paramAnnotatedOutput.writeInt(i);
    paramAnnotatedOutput.writeInt(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.FieldAnnotationStruct
 * JD-Core Version:    0.7.0.1
 */