package com.android.dx.rop.annotation;

import com.android.dx.rop.cst.CstType;
import com.android.dx.util.MutabilityControl;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public final class Annotations
  extends MutabilityControl
  implements Comparable<Annotations>
{
  public static final Annotations EMPTY = new Annotations();
  private final TreeMap<CstType, Annotation> annotations = new TreeMap();
  
  static
  {
    EMPTY.setImmutable();
  }
  
  public static Annotations combine(Annotations paramAnnotations, Annotation paramAnnotation)
  {
    Annotations localAnnotations = new Annotations();
    localAnnotations.addAll(paramAnnotations);
    localAnnotations.add(paramAnnotation);
    localAnnotations.setImmutable();
    return localAnnotations;
  }
  
  public static Annotations combine(Annotations paramAnnotations1, Annotations paramAnnotations2)
  {
    Annotations localAnnotations = new Annotations();
    localAnnotations.addAll(paramAnnotations1);
    localAnnotations.addAll(paramAnnotations2);
    localAnnotations.setImmutable();
    return localAnnotations;
  }
  
  public void add(Annotation paramAnnotation)
  {
    throwIfImmutable();
    if (paramAnnotation == null) {
      throw new NullPointerException("annotation == null");
    }
    CstType localCstType = paramAnnotation.getType();
    if (this.annotations.containsKey(localCstType)) {
      throw new IllegalArgumentException("duplicate type: " + localCstType.toHuman());
    }
    this.annotations.put(localCstType, paramAnnotation);
  }
  
  public void addAll(Annotations paramAnnotations)
  {
    throwIfImmutable();
    if (paramAnnotations == null) {
      throw new NullPointerException("toAdd == null");
    }
    paramAnnotations = paramAnnotations.annotations.values().iterator();
    while (paramAnnotations.hasNext()) {
      add((Annotation)paramAnnotations.next());
    }
  }
  
  public int compareTo(Annotations paramAnnotations)
  {
    Iterator localIterator = this.annotations.values().iterator();
    paramAnnotations = paramAnnotations.annotations.values().iterator();
    while ((localIterator.hasNext()) && (paramAnnotations.hasNext()))
    {
      int i = ((Annotation)localIterator.next()).compareTo((Annotation)paramAnnotations.next());
      if (i != 0) {
        return i;
      }
    }
    if (localIterator.hasNext()) {
      return 1;
    }
    if (paramAnnotations.hasNext()) {
      return -1;
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Annotations)) {
      return false;
    }
    paramObject = (Annotations)paramObject;
    return this.annotations.equals(paramObject.annotations);
  }
  
  public Collection<Annotation> getAnnotations()
  {
    return Collections.unmodifiableCollection(this.annotations.values());
  }
  
  public int hashCode()
  {
    return this.annotations.hashCode();
  }
  
  public int size()
  {
    return this.annotations.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("annotations{");
    Iterator localIterator = this.annotations.values().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Annotation localAnnotation = (Annotation)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localAnnotation.toHuman());
        break;
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.annotation.Annotations
 * JD-Core Version:    0.7.0.1
 */