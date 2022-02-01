package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.TreeMap;

public final class MethodIdsSection
  extends MemberIdsSection
{
  private final TreeMap<CstBaseMethodRef, MethodIdItem> methodIds = new TreeMap();
  
  public MethodIdsSection(DexFile paramDexFile)
  {
    super("method_ids", paramDexFile);
  }
  
  public IndexedItem get(Constant paramConstant)
  {
    if (paramConstant == null) {
      throw new NullPointerException("cst == null");
    }
    throwIfNotPrepared();
    paramConstant = (IndexedItem)this.methodIds.get((CstBaseMethodRef)paramConstant);
    if (paramConstant == null) {
      throw new IllegalArgumentException("not found");
    }
    return paramConstant;
  }
  
  public int indexOf(CstBaseMethodRef paramCstBaseMethodRef)
  {
    if (paramCstBaseMethodRef == null) {
      throw new NullPointerException("ref == null");
    }
    throwIfNotPrepared();
    paramCstBaseMethodRef = (MethodIdItem)this.methodIds.get(paramCstBaseMethodRef);
    if (paramCstBaseMethodRef == null) {
      throw new IllegalArgumentException("not found");
    }
    return paramCstBaseMethodRef.getIndex();
  }
  
  public MethodIdItem intern(CstBaseMethodRef paramCstBaseMethodRef)
  {
    if (paramCstBaseMethodRef == null) {
      try
      {
        throw new NullPointerException("method == null");
      }
      finally {}
    }
    throwIfPrepared();
    MethodIdItem localMethodIdItem2 = (MethodIdItem)this.methodIds.get(paramCstBaseMethodRef);
    MethodIdItem localMethodIdItem1 = localMethodIdItem2;
    if (localMethodIdItem2 == null)
    {
      localMethodIdItem1 = new MethodIdItem(paramCstBaseMethodRef);
      this.methodIds.put(paramCstBaseMethodRef, localMethodIdItem1);
    }
    return localMethodIdItem1;
  }
  
  public Collection<? extends Item> items()
  {
    return this.methodIds.values();
  }
  
  public void writeHeaderPart(AnnotatedOutput paramAnnotatedOutput)
  {
    throwIfNotPrepared();
    int j = this.methodIds.size();
    if (j == 0) {}
    for (int i = 0;; i = getFileOffset())
    {
      if (paramAnnotatedOutput.annotates())
      {
        paramAnnotatedOutput.annotate(4, "method_ids_size: " + Hex.u4(j));
        paramAnnotatedOutput.annotate(4, "method_ids_off:  " + Hex.u4(i));
      }
      paramAnnotatedOutput.writeInt(j);
      paramAnnotatedOutput.writeInt(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.MethodIdsSection
 * JD-Core Version:    0.7.0.1
 */