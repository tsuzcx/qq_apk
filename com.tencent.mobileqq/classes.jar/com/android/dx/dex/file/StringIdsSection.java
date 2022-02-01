package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public final class StringIdsSection
  extends UniformItemSection
{
  private final TreeMap<CstString, StringIdItem> strings = new TreeMap();
  
  public StringIdsSection(DexFile paramDexFile)
  {
    super("string_ids", paramDexFile, 4);
  }
  
  public IndexedItem get(Constant paramConstant)
  {
    if (paramConstant == null) {
      throw new NullPointerException("cst == null");
    }
    throwIfNotPrepared();
    paramConstant = (IndexedItem)this.strings.get((CstString)paramConstant);
    if (paramConstant == null) {
      throw new IllegalArgumentException("not found");
    }
    return paramConstant;
  }
  
  public int indexOf(CstString paramCstString)
  {
    if (paramCstString == null) {
      throw new NullPointerException("string == null");
    }
    throwIfNotPrepared();
    paramCstString = (StringIdItem)this.strings.get(paramCstString);
    if (paramCstString == null) {
      throw new IllegalArgumentException("not found");
    }
    return paramCstString.getIndex();
  }
  
  public StringIdItem intern(StringIdItem paramStringIdItem)
  {
    if (paramStringIdItem == null) {
      try
      {
        throw new NullPointerException("string == null");
      }
      finally {}
    }
    throwIfPrepared();
    CstString localCstString = paramStringIdItem.getValue();
    StringIdItem localStringIdItem = (StringIdItem)this.strings.get(localCstString);
    if (localStringIdItem != null) {
      paramStringIdItem = localStringIdItem;
    }
    for (;;)
    {
      return paramStringIdItem;
      this.strings.put(localCstString, paramStringIdItem);
    }
  }
  
  public StringIdItem intern(CstString paramCstString)
  {
    return intern(new StringIdItem(paramCstString));
  }
  
  public StringIdItem intern(String paramString)
  {
    return intern(new StringIdItem(new CstString(paramString)));
  }
  
  public void intern(CstNat paramCstNat)
  {
    try
    {
      intern(paramCstNat.getName());
      intern(paramCstNat.getDescriptor());
      return;
    }
    finally
    {
      paramCstNat = finally;
      throw paramCstNat;
    }
  }
  
  public Collection<? extends Item> items()
  {
    return this.strings.values();
  }
  
  protected void orderItems()
  {
    Iterator localIterator = this.strings.values().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ((StringIdItem)localIterator.next()).setIndex(i);
      i += 1;
    }
  }
  
  public void writeHeaderPart(AnnotatedOutput paramAnnotatedOutput)
  {
    throwIfNotPrepared();
    int j = this.strings.size();
    if (j == 0) {}
    for (int i = 0;; i = getFileOffset())
    {
      if (paramAnnotatedOutput.annotates())
      {
        paramAnnotatedOutput.annotate(4, "string_ids_size: " + Hex.u4(j));
        paramAnnotatedOutput.annotate(4, "string_ids_off:  " + Hex.u4(i));
      }
      paramAnnotatedOutput.writeInt(j);
      paramAnnotatedOutput.writeInt(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.StringIdsSection
 * JD-Core Version:    0.7.0.1
 */