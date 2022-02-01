package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public final class ClassDefsSection
  extends UniformItemSection
{
  private final TreeMap<Type, ClassDefItem> classDefs = new TreeMap();
  private ArrayList<ClassDefItem> orderedDefs = null;
  
  public ClassDefsSection(DexFile paramDexFile)
  {
    super("class_defs", paramDexFile, 4);
  }
  
  private int orderItems0(Type paramType, int paramInt1, int paramInt2)
  {
    ClassDefItem localClassDefItem = (ClassDefItem)this.classDefs.get(paramType);
    if ((localClassDefItem == null) || (localClassDefItem.hasIndex())) {
      return paramInt1;
    }
    if (paramInt2 < 0) {
      throw new RuntimeException("class circularity with " + paramType);
    }
    int i = paramInt2 - 1;
    paramType = localClassDefItem.getSuperclass();
    paramInt2 = paramInt1;
    if (paramType != null) {
      paramInt2 = orderItems0(paramType.getClassType(), paramInt1, i);
    }
    paramType = localClassDefItem.getInterfaces();
    int j = paramType.size();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramInt2 = orderItems0(paramType.getType(paramInt1), paramInt2, i);
      paramInt1 += 1;
    }
    localClassDefItem.setIndex(paramInt2);
    this.orderedDefs.add(localClassDefItem);
    return paramInt2 + 1;
  }
  
  public void add(ClassDefItem paramClassDefItem)
  {
    Type localType;
    try
    {
      localType = paramClassDefItem.getThisClass().getClassType();
      throwIfPrepared();
      if (this.classDefs.get(localType) != null) {
        throw new IllegalArgumentException("already added: " + localType);
      }
    }
    catch (NullPointerException paramClassDefItem)
    {
      throw new NullPointerException("clazz == null");
    }
    this.classDefs.put(localType, paramClassDefItem);
  }
  
  public IndexedItem get(Constant paramConstant)
  {
    if (paramConstant == null) {
      throw new NullPointerException("cst == null");
    }
    throwIfNotPrepared();
    paramConstant = ((CstType)paramConstant).getClassType();
    paramConstant = (IndexedItem)this.classDefs.get(paramConstant);
    if (paramConstant == null) {
      throw new IllegalArgumentException("not found");
    }
    return paramConstant;
  }
  
  public Collection<? extends Item> items()
  {
    if (this.orderedDefs != null) {
      return this.orderedDefs;
    }
    return this.classDefs.values();
  }
  
  protected void orderItems()
  {
    int j = this.classDefs.size();
    this.orderedDefs = new ArrayList(j);
    Iterator localIterator = this.classDefs.keySet().iterator();
    for (int i = 0; localIterator.hasNext(); i = orderItems0((Type)localIterator.next(), i, j - i)) {}
  }
  
  public void writeHeaderPart(AnnotatedOutput paramAnnotatedOutput)
  {
    throwIfNotPrepared();
    int j = this.classDefs.size();
    if (j == 0) {}
    for (int i = 0;; i = getFileOffset())
    {
      if (paramAnnotatedOutput.annotates())
      {
        paramAnnotatedOutput.annotate(4, "class_defs_size: " + Hex.u4(j));
        paramAnnotatedOutput.annotate(4, "class_defs_off:  " + Hex.u4(i));
      }
      paramAnnotatedOutput.writeInt(j);
      paramAnnotatedOutput.writeInt(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.ClassDefsSection
 * JD-Core Version:    0.7.0.1
 */