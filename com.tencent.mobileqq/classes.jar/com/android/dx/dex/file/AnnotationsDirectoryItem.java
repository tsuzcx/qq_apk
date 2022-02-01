package com.android.dx.dex.file;

import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class AnnotationsDirectoryItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 4;
  private static final int ELEMENT_SIZE = 8;
  private static final int HEADER_SIZE = 16;
  private AnnotationSetItem classAnnotations = null;
  private ArrayList<FieldAnnotationStruct> fieldAnnotations = null;
  private ArrayList<MethodAnnotationStruct> methodAnnotations = null;
  private ArrayList<ParameterAnnotationStruct> parameterAnnotations = null;
  
  public AnnotationsDirectoryItem()
  {
    super(4, -1);
  }
  
  private static int listSize(ArrayList<?> paramArrayList)
  {
    if (paramArrayList == null) {
      return 0;
    }
    return paramArrayList.size();
  }
  
  public void addContents(DexFile paramDexFile)
  {
    Object localObject = paramDexFile.getWordData();
    if (this.classAnnotations != null) {
      this.classAnnotations = ((AnnotationSetItem)((MixedItemSection)localObject).intern(this.classAnnotations));
    }
    if (this.fieldAnnotations != null)
    {
      localObject = this.fieldAnnotations.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FieldAnnotationStruct)((Iterator)localObject).next()).addContents(paramDexFile);
      }
    }
    if (this.methodAnnotations != null)
    {
      localObject = this.methodAnnotations.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MethodAnnotationStruct)((Iterator)localObject).next()).addContents(paramDexFile);
      }
    }
    if (this.parameterAnnotations != null)
    {
      localObject = this.parameterAnnotations.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ParameterAnnotationStruct)((Iterator)localObject).next()).addContents(paramDexFile);
      }
    }
  }
  
  public void addFieldAnnotations(CstFieldRef paramCstFieldRef, Annotations paramAnnotations, DexFile paramDexFile)
  {
    if (this.fieldAnnotations == null) {
      this.fieldAnnotations = new ArrayList();
    }
    this.fieldAnnotations.add(new FieldAnnotationStruct(paramCstFieldRef, new AnnotationSetItem(paramAnnotations, paramDexFile)));
  }
  
  public void addMethodAnnotations(CstMethodRef paramCstMethodRef, Annotations paramAnnotations, DexFile paramDexFile)
  {
    if (this.methodAnnotations == null) {
      this.methodAnnotations = new ArrayList();
    }
    this.methodAnnotations.add(new MethodAnnotationStruct(paramCstMethodRef, new AnnotationSetItem(paramAnnotations, paramDexFile)));
  }
  
  public void addParameterAnnotations(CstMethodRef paramCstMethodRef, AnnotationsList paramAnnotationsList, DexFile paramDexFile)
  {
    if (this.parameterAnnotations == null) {
      this.parameterAnnotations = new ArrayList();
    }
    this.parameterAnnotations.add(new ParameterAnnotationStruct(paramCstMethodRef, paramAnnotationsList, paramDexFile));
  }
  
  public int compareTo0(OffsettedItem paramOffsettedItem)
  {
    if (!isInternable()) {
      throw new UnsupportedOperationException("uninternable instance");
    }
    paramOffsettedItem = (AnnotationsDirectoryItem)paramOffsettedItem;
    return this.classAnnotations.compareTo(paramOffsettedItem.classAnnotations);
  }
  
  void debugPrint(PrintWriter paramPrintWriter)
  {
    if (this.classAnnotations != null) {
      paramPrintWriter.println("  class annotations: " + this.classAnnotations);
    }
    Iterator localIterator;
    Object localObject;
    if (this.fieldAnnotations != null)
    {
      paramPrintWriter.println("  field annotations:");
      localIterator = this.fieldAnnotations.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FieldAnnotationStruct)localIterator.next();
        paramPrintWriter.println("    " + ((FieldAnnotationStruct)localObject).toHuman());
      }
    }
    if (this.methodAnnotations != null)
    {
      paramPrintWriter.println("  method annotations:");
      localIterator = this.methodAnnotations.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MethodAnnotationStruct)localIterator.next();
        paramPrintWriter.println("    " + ((MethodAnnotationStruct)localObject).toHuman());
      }
    }
    if (this.parameterAnnotations != null)
    {
      paramPrintWriter.println("  parameter annotations:");
      localIterator = this.parameterAnnotations.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ParameterAnnotationStruct)localIterator.next();
        paramPrintWriter.println("    " + ((ParameterAnnotationStruct)localObject).toHuman());
      }
    }
  }
  
  public Annotations getMethodAnnotations(CstMethodRef paramCstMethodRef)
  {
    if (this.methodAnnotations == null) {
      return null;
    }
    Iterator localIterator = this.methodAnnotations.iterator();
    while (localIterator.hasNext())
    {
      MethodAnnotationStruct localMethodAnnotationStruct = (MethodAnnotationStruct)localIterator.next();
      if (localMethodAnnotationStruct.getMethod().equals(paramCstMethodRef)) {
        return localMethodAnnotationStruct.getAnnotations();
      }
    }
    return null;
  }
  
  public AnnotationsList getParameterAnnotations(CstMethodRef paramCstMethodRef)
  {
    if (this.parameterAnnotations == null) {
      return null;
    }
    Iterator localIterator = this.parameterAnnotations.iterator();
    while (localIterator.hasNext())
    {
      ParameterAnnotationStruct localParameterAnnotationStruct = (ParameterAnnotationStruct)localIterator.next();
      if (localParameterAnnotationStruct.getMethod().equals(paramCstMethodRef)) {
        return localParameterAnnotationStruct.getAnnotationsList();
      }
    }
    return null;
  }
  
  public int hashCode()
  {
    if (this.classAnnotations == null) {
      return 0;
    }
    return this.classAnnotations.hashCode();
  }
  
  public boolean isEmpty()
  {
    return (this.classAnnotations == null) && (this.fieldAnnotations == null) && (this.methodAnnotations == null) && (this.parameterAnnotations == null);
  }
  
  public boolean isInternable()
  {
    return (this.classAnnotations != null) && (this.fieldAnnotations == null) && (this.methodAnnotations == null) && (this.parameterAnnotations == null);
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_ANNOTATIONS_DIRECTORY_ITEM;
  }
  
  protected void place0(Section paramSection, int paramInt)
  {
    setWriteSize((listSize(this.fieldAnnotations) + listSize(this.methodAnnotations) + listSize(this.parameterAnnotations)) * 8 + 16);
  }
  
  public void setClassAnnotations(Annotations paramAnnotations, DexFile paramDexFile)
  {
    if (paramAnnotations == null) {
      throw new NullPointerException("annotations == null");
    }
    if (this.classAnnotations != null) {
      throw new UnsupportedOperationException("class annotations already set");
    }
    this.classAnnotations = new AnnotationSetItem(paramAnnotations, paramDexFile);
  }
  
  public String toHuman()
  {
    throw new RuntimeException("unsupported");
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    boolean bool = paramAnnotatedOutput.annotates();
    int i = OffsettedItem.getAbsoluteOffsetOr0(this.classAnnotations);
    int j = listSize(this.fieldAnnotations);
    int k = listSize(this.methodAnnotations);
    int m = listSize(this.parameterAnnotations);
    if (bool)
    {
      paramAnnotatedOutput.annotate(0, offsetString() + " annotations directory");
      paramAnnotatedOutput.annotate(4, "  class_annotations_off: " + Hex.u4(i));
      paramAnnotatedOutput.annotate(4, "  fields_size:           " + Hex.u4(j));
      paramAnnotatedOutput.annotate(4, "  methods_size:          " + Hex.u4(k));
      paramAnnotatedOutput.annotate(4, "  parameters_size:       " + Hex.u4(m));
    }
    paramAnnotatedOutput.writeInt(i);
    paramAnnotatedOutput.writeInt(j);
    paramAnnotatedOutput.writeInt(k);
    paramAnnotatedOutput.writeInt(m);
    Iterator localIterator;
    if (j != 0)
    {
      Collections.sort(this.fieldAnnotations);
      if (bool) {
        paramAnnotatedOutput.annotate(0, "  fields:");
      }
      localIterator = this.fieldAnnotations.iterator();
      while (localIterator.hasNext()) {
        ((FieldAnnotationStruct)localIterator.next()).writeTo(paramDexFile, paramAnnotatedOutput);
      }
    }
    if (k != 0)
    {
      Collections.sort(this.methodAnnotations);
      if (bool) {
        paramAnnotatedOutput.annotate(0, "  methods:");
      }
      localIterator = this.methodAnnotations.iterator();
      while (localIterator.hasNext()) {
        ((MethodAnnotationStruct)localIterator.next()).writeTo(paramDexFile, paramAnnotatedOutput);
      }
    }
    if (m != 0)
    {
      Collections.sort(this.parameterAnnotations);
      if (bool) {
        paramAnnotatedOutput.annotate(0, "  parameters:");
      }
      localIterator = this.parameterAnnotations.iterator();
      while (localIterator.hasNext()) {
        ((ParameterAnnotationStruct)localIterator.next()).writeTo(paramDexFile, paramAnnotatedOutput);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.AnnotationsDirectoryItem
 * JD-Core Version:    0.7.0.1
 */