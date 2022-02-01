package com.android.dx.rop.annotation;

import com.android.dx.util.FixedSizeList;

public final class AnnotationsList
  extends FixedSizeList
{
  public static final AnnotationsList EMPTY = new AnnotationsList(0);
  
  public AnnotationsList(int paramInt)
  {
    super(paramInt);
  }
  
  public static AnnotationsList combine(AnnotationsList paramAnnotationsList1, AnnotationsList paramAnnotationsList2)
  {
    int j = paramAnnotationsList1.size();
    if (j != paramAnnotationsList2.size()) {
      throw new IllegalArgumentException("list1.size() != list2.size()");
    }
    AnnotationsList localAnnotationsList = new AnnotationsList(j);
    int i = 0;
    while (i < j)
    {
      localAnnotationsList.set(i, Annotations.combine(paramAnnotationsList1.get(i), paramAnnotationsList2.get(i)));
      i += 1;
    }
    localAnnotationsList.setImmutable();
    return localAnnotationsList;
  }
  
  public Annotations get(int paramInt)
  {
    return (Annotations)get0(paramInt);
  }
  
  public void set(int paramInt, Annotations paramAnnotations)
  {
    paramAnnotations.throwIfMutable();
    set0(paramInt, paramAnnotations);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.annotation.AnnotationsList
 * JD-Core Version:    0.7.0.1
 */