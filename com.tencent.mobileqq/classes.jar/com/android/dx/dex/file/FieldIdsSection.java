package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.TreeMap;

public final class FieldIdsSection
  extends MemberIdsSection
{
  private final TreeMap<CstFieldRef, FieldIdItem> fieldIds = new TreeMap();
  
  public FieldIdsSection(DexFile paramDexFile)
  {
    super("field_ids", paramDexFile);
  }
  
  public IndexedItem get(Constant paramConstant)
  {
    if (paramConstant == null) {
      throw new NullPointerException("cst == null");
    }
    throwIfNotPrepared();
    paramConstant = (IndexedItem)this.fieldIds.get((CstFieldRef)paramConstant);
    if (paramConstant == null) {
      throw new IllegalArgumentException("not found");
    }
    return paramConstant;
  }
  
  public int indexOf(CstFieldRef paramCstFieldRef)
  {
    if (paramCstFieldRef == null) {
      throw new NullPointerException("ref == null");
    }
    throwIfNotPrepared();
    paramCstFieldRef = (FieldIdItem)this.fieldIds.get(paramCstFieldRef);
    if (paramCstFieldRef == null) {
      throw new IllegalArgumentException("not found");
    }
    return paramCstFieldRef.getIndex();
  }
  
  public FieldIdItem intern(CstFieldRef paramCstFieldRef)
  {
    if (paramCstFieldRef == null) {
      try
      {
        throw new NullPointerException("field == null");
      }
      finally {}
    }
    throwIfPrepared();
    FieldIdItem localFieldIdItem2 = (FieldIdItem)this.fieldIds.get(paramCstFieldRef);
    FieldIdItem localFieldIdItem1 = localFieldIdItem2;
    if (localFieldIdItem2 == null)
    {
      localFieldIdItem1 = new FieldIdItem(paramCstFieldRef);
      this.fieldIds.put(paramCstFieldRef, localFieldIdItem1);
    }
    return localFieldIdItem1;
  }
  
  public Collection<? extends Item> items()
  {
    return this.fieldIds.values();
  }
  
  public void writeHeaderPart(AnnotatedOutput paramAnnotatedOutput)
  {
    throwIfNotPrepared();
    int j = this.fieldIds.size();
    if (j == 0) {}
    for (int i = 0;; i = getFileOffset())
    {
      if (paramAnnotatedOutput.annotates())
      {
        paramAnnotatedOutput.annotate(4, "field_ids_size:  " + Hex.u4(j));
        paramAnnotatedOutput.annotate(4, "field_ids_off:   " + Hex.u4(i));
      }
      paramAnnotatedOutput.writeInt(j);
      paramAnnotatedOutput.writeInt(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.FieldIdsSection
 * JD-Core Version:    0.7.0.1
 */