package com.android.dx.dex.file;

import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.ToHuman;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ParameterAnnotationStruct
  implements ToHuman, Comparable<ParameterAnnotationStruct>
{
  private final UniformListItem<AnnotationSetRefItem> annotationsItem;
  private final AnnotationsList annotationsList;
  private final CstMethodRef method;
  
  public ParameterAnnotationStruct(CstMethodRef paramCstMethodRef, AnnotationsList paramAnnotationsList, DexFile paramDexFile)
  {
    if (paramCstMethodRef == null) {
      throw new NullPointerException("method == null");
    }
    if (paramAnnotationsList == null) {
      throw new NullPointerException("annotationsList == null");
    }
    this.method = paramCstMethodRef;
    this.annotationsList = paramAnnotationsList;
    int j = paramAnnotationsList.size();
    paramCstMethodRef = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      paramCstMethodRef.add(new AnnotationSetRefItem(new AnnotationSetItem(paramAnnotationsList.get(i), paramDexFile)));
      i += 1;
    }
    this.annotationsItem = new UniformListItem(ItemType.TYPE_ANNOTATION_SET_REF_LIST, paramCstMethodRef);
  }
  
  public void addContents(DexFile paramDexFile)
  {
    MethodIdsSection localMethodIdsSection = paramDexFile.getMethodIds();
    paramDexFile = paramDexFile.getWordData();
    localMethodIdsSection.intern(this.method);
    paramDexFile.add(this.annotationsItem);
  }
  
  public int compareTo(ParameterAnnotationStruct paramParameterAnnotationStruct)
  {
    return this.method.compareTo(paramParameterAnnotationStruct.method);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ParameterAnnotationStruct)) {
      return false;
    }
    return this.method.equals(((ParameterAnnotationStruct)paramObject).method);
  }
  
  public AnnotationsList getAnnotationsList()
  {
    return this.annotationsList;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.method.toHuman());
    localStringBuilder.append(": ");
    Iterator localIterator = this.annotationsItem.getItems().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      AnnotationSetRefItem localAnnotationSetRefItem = (AnnotationSetRefItem)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localAnnotationSetRefItem.toHuman());
        break;
        localStringBuilder.append(", ");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int i = paramDexFile.getMethodIds().indexOf(this.method);
    int j = this.annotationsItem.getAbsoluteOffset();
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
 * Qualified Name:     com.android.dx.dex.file.ParameterAnnotationStruct
 * JD-Core Version:    0.7.0.1
 */