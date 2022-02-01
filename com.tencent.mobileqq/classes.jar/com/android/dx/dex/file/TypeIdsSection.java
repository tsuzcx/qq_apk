package com.android.dx.dex.file;

import com.android.dex.DexIndexOverflowException;
import com.android.dx.command.dexer.Main;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public final class TypeIdsSection
  extends UniformItemSection
{
  private final TreeMap<Type, TypeIdItem> typeIds = new TreeMap();
  
  public TypeIdsSection(DexFile paramDexFile)
  {
    super("type_ids", paramDexFile, 4);
  }
  
  public IndexedItem get(Constant paramConstant)
  {
    if (paramConstant == null) {
      throw new NullPointerException("cst == null");
    }
    throwIfNotPrepared();
    Object localObject = ((CstType)paramConstant).getClassType();
    localObject = (IndexedItem)this.typeIds.get(localObject);
    if (localObject == null) {
      throw new IllegalArgumentException("not found: " + paramConstant);
    }
    return localObject;
  }
  
  public int indexOf(CstType paramCstType)
  {
    if (paramCstType == null) {
      throw new NullPointerException("type == null");
    }
    return indexOf(paramCstType.getClassType());
  }
  
  public int indexOf(Type paramType)
  {
    if (paramType == null) {
      throw new NullPointerException("type == null");
    }
    throwIfNotPrepared();
    TypeIdItem localTypeIdItem = (TypeIdItem)this.typeIds.get(paramType);
    if (localTypeIdItem == null) {
      throw new IllegalArgumentException("not found: " + paramType);
    }
    return localTypeIdItem.getIndex();
  }
  
  public TypeIdItem intern(CstType paramCstType)
  {
    if (paramCstType == null) {
      try
      {
        throw new NullPointerException("type == null");
      }
      finally {}
    }
    throwIfPrepared();
    Type localType = paramCstType.getClassType();
    TypeIdItem localTypeIdItem2 = (TypeIdItem)this.typeIds.get(localType);
    TypeIdItem localTypeIdItem1 = localTypeIdItem2;
    if (localTypeIdItem2 == null)
    {
      localTypeIdItem1 = new TypeIdItem(paramCstType);
      this.typeIds.put(localType, localTypeIdItem1);
    }
    return localTypeIdItem1;
  }
  
  public TypeIdItem intern(Type paramType)
  {
    if (paramType == null) {
      try
      {
        throw new NullPointerException("type == null");
      }
      finally {}
    }
    throwIfPrepared();
    TypeIdItem localTypeIdItem2 = (TypeIdItem)this.typeIds.get(paramType);
    TypeIdItem localTypeIdItem1 = localTypeIdItem2;
    if (localTypeIdItem2 == null)
    {
      localTypeIdItem1 = new TypeIdItem(new CstType(paramType));
      this.typeIds.put(paramType, localTypeIdItem1);
    }
    return localTypeIdItem1;
  }
  
  public Collection<? extends Item> items()
  {
    return this.typeIds.values();
  }
  
  protected void orderItems()
  {
    Iterator localIterator = items().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ((TypeIdItem)localIterator.next()).setIndex(i);
      i += 1;
    }
  }
  
  public void writeHeaderPart(AnnotatedOutput paramAnnotatedOutput)
  {
    throwIfNotPrepared();
    int j = this.typeIds.size();
    if (j == 0) {}
    for (int i = 0; j > 65536; i = getFileOffset()) {
      throw new DexIndexOverflowException("Too many type references: " + j + "; max is " + 65536 + ".\n" + Main.getTooManyIdsErrorMessage());
    }
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(4, "type_ids_size:   " + Hex.u4(j));
      paramAnnotatedOutput.annotate(4, "type_ids_off:    " + Hex.u4(i));
    }
    paramAnnotatedOutput.writeInt(j);
    paramAnnotatedOutput.writeInt(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.TypeIdsSection
 * JD-Core Version:    0.7.0.1
 */