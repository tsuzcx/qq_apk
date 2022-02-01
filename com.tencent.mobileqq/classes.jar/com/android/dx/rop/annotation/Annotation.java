package com.android.dx.rop.annotation;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.MutabilityControl;
import com.android.dx.util.ToHuman;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public final class Annotation
  extends MutabilityControl
  implements ToHuman, Comparable<Annotation>
{
  private final TreeMap<CstString, NameValuePair> elements;
  private final CstType type;
  private final AnnotationVisibility visibility;
  
  public Annotation(CstType paramCstType, AnnotationVisibility paramAnnotationVisibility)
  {
    if (paramCstType == null) {
      throw new NullPointerException("type == null");
    }
    if (paramAnnotationVisibility == null) {
      throw new NullPointerException("visibility == null");
    }
    this.type = paramCstType;
    this.visibility = paramAnnotationVisibility;
    this.elements = new TreeMap();
  }
  
  public void add(NameValuePair paramNameValuePair)
  {
    throwIfImmutable();
    if (paramNameValuePair == null) {
      throw new NullPointerException("pair == null");
    }
    CstString localCstString = paramNameValuePair.getName();
    if (this.elements.get(localCstString) != null) {
      throw new IllegalArgumentException("name already added: " + localCstString);
    }
    this.elements.put(localCstString, paramNameValuePair);
  }
  
  public int compareTo(Annotation paramAnnotation)
  {
    int i = this.type.compareTo(paramAnnotation.type);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = this.visibility.compareTo(paramAnnotation.visibility);
      i = j;
    } while (j != 0);
    Iterator localIterator = this.elements.values().iterator();
    paramAnnotation = paramAnnotation.elements.values().iterator();
    while ((localIterator.hasNext()) && (paramAnnotation.hasNext()))
    {
      i = ((NameValuePair)localIterator.next()).compareTo((NameValuePair)paramAnnotation.next());
      if (i != 0) {
        return i;
      }
    }
    if (localIterator.hasNext()) {
      return 1;
    }
    if (paramAnnotation.hasNext()) {
      return -1;
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Annotation)) {}
    do
    {
      return false;
      paramObject = (Annotation)paramObject;
    } while ((!this.type.equals(paramObject.type)) || (this.visibility != paramObject.visibility));
    return this.elements.equals(paramObject.elements);
  }
  
  public Collection<NameValuePair> getNameValuePairs()
  {
    return Collections.unmodifiableCollection(this.elements.values());
  }
  
  public CstType getType()
  {
    return this.type;
  }
  
  public AnnotationVisibility getVisibility()
  {
    return this.visibility;
  }
  
  public int hashCode()
  {
    return (this.type.hashCode() * 31 + this.elements.hashCode()) * 31 + this.visibility.hashCode();
  }
  
  public void put(NameValuePair paramNameValuePair)
  {
    throwIfImmutable();
    if (paramNameValuePair == null) {
      throw new NullPointerException("pair == null");
    }
    this.elements.put(paramNameValuePair.getName(), paramNameValuePair);
  }
  
  public String toHuman()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.visibility.toHuman());
    localStringBuilder.append("-annotation ");
    localStringBuilder.append(this.type.toHuman());
    localStringBuilder.append(" {");
    Iterator localIterator = this.elements.values().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localNameValuePair.getName().toHuman());
        localStringBuilder.append(": ");
        localStringBuilder.append(localNameValuePair.getValue().toHuman());
        break;
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return toHuman();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.annotation.Annotation
 * JD-Core Version:    0.7.0.1
 */