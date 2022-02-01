package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.util.AnnotatedOutput;
import java.util.Collection;
import java.util.Iterator;

public abstract class UniformItemSection
  extends Section
{
  public UniformItemSection(String paramString, DexFile paramDexFile, int paramInt)
  {
    super(paramString, paramDexFile, paramInt);
  }
  
  public abstract IndexedItem get(Constant paramConstant);
  
  public final int getAbsoluteItemOffset(Item paramItem)
  {
    paramItem = (IndexedItem)paramItem;
    return getAbsoluteOffset(paramItem.getIndex() * paramItem.writeSize());
  }
  
  protected abstract void orderItems();
  
  protected final void prepare0()
  {
    DexFile localDexFile = getFile();
    orderItems();
    Iterator localIterator = items().iterator();
    while (localIterator.hasNext()) {
      ((Item)localIterator.next()).addContents(localDexFile);
    }
  }
  
  public final int writeSize()
  {
    Collection localCollection = items();
    int i = localCollection.size();
    if (i == 0) {
      return 0;
    }
    return ((Item)localCollection.iterator().next()).writeSize() * i;
  }
  
  protected final void writeTo0(AnnotatedOutput paramAnnotatedOutput)
  {
    DexFile localDexFile = getFile();
    int i = getAlignment();
    Iterator localIterator = items().iterator();
    while (localIterator.hasNext())
    {
      ((Item)localIterator.next()).writeTo(localDexFile, paramAnnotatedOutput);
      paramAnnotatedOutput.alignTo(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.UniformItemSection
 * JD-Core Version:    0.7.0.1
 */