package com.android.dx.dex.file;

import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.ToHuman;

public final class MethodAnnotationStruct
  implements ToHuman, Comparable<MethodAnnotationStruct>
{
  private AnnotationSetItem annotations;
  private final CstMethodRef method;
  
  public MethodAnnotationStruct(CstMethodRef paramCstMethodRef, AnnotationSetItem paramAnnotationSetItem)
  {
    if (paramCstMethodRef == null) {
      throw new NullPointerException("method == null");
    }
    if (paramAnnotationSetItem == null) {
      throw new NullPointerException("annotations == null");
    }
    this.method = paramCstMethodRef;
    this.annotations = paramAnnotationSetItem;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    MethodIdsSection localMethodIdsSection = paramDexFile.getMethodIds();
    paramDexFile = paramDexFile.getWordData();
    localMethodIdsSection.intern(this.method);
    this.annotations = ((AnnotationSetItem)paramDexFile.intern(this.annotations));
  }
  
  public int compareTo(MethodAnnotationStruct paramMethodAnnotationStruct)
  {
    return this.method.compareTo(paramMethodAnnotationStruct.method);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MethodAnnotationStruct)) {
      return false;
    }
    return this.method.equals(((MethodAnnotationStruct)paramObject).method);
  }
  
  public Annotations getAnnotations()
  {
    return this.annotations.getAnnotations();
  }
  
  public CstMethodRef getMethod()
  {
    return this.method;
  }
  
  public int hashCode()
  {
    return this.method.hashCode();
  }
  
  public String toHuman()
  {
    return this.method.toHuman() + ": " + this.annotations;
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int i = paramDexFile.getMethodIds().indexOf(this.method);
    int j = this.annotations.getAbsoluteOffset();
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, "    " + this.method.toHuman());
      paramAnnotatedOutput.annotate(4, "      method_idx:      " + Hex.u4(i));
      paramAnnotatedOutput.annotate(4, "      annotations_off: " + Hex.u4(j));
    }
    paramAnnotatedOutput.writeInt(i);
    paramAnnotatedOutput.writeInt(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.MethodAnnotationStruct
 * JD-Core Version:    0.7.0.1
 */