package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

public final class MixedItemSection
  extends Section
{
  private static final Comparator<OffsettedItem> TYPE_SORTER = new MixedItemSection.1();
  private final HashMap<OffsettedItem, OffsettedItem> interns = new HashMap(100);
  private final ArrayList<OffsettedItem> items = new ArrayList(100);
  private final MixedItemSection.SortType sort;
  private int writeSize;
  
  public MixedItemSection(String paramString, DexFile paramDexFile, int paramInt, MixedItemSection.SortType paramSortType)
  {
    super(paramString, paramDexFile, paramInt);
    this.sort = paramSortType;
    this.writeSize = -1;
  }
  
  public void add(OffsettedItem paramOffsettedItem)
  {
    throwIfPrepared();
    try
    {
      if (paramOffsettedItem.getAlignment() > getAlignment()) {
        throw new IllegalArgumentException("incompatible item alignment");
      }
    }
    catch (NullPointerException paramOffsettedItem)
    {
      throw new NullPointerException("item == null");
    }
    this.items.add(paramOffsettedItem);
  }
  
  public <T extends OffsettedItem> T get(T paramT)
  {
    throwIfNotPrepared();
    OffsettedItem localOffsettedItem = (OffsettedItem)this.interns.get(paramT);
    if (localOffsettedItem != null) {
      return localOffsettedItem;
    }
    throw new NoSuchElementException(paramT.toString());
  }
  
  public int getAbsoluteItemOffset(Item paramItem)
  {
    return ((OffsettedItem)paramItem).getAbsoluteOffset();
  }
  
  /* Error */
  public <T extends OffsettedItem> T intern(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 54	com/android/dx/dex/file/MixedItemSection:throwIfPrepared	()V
    //   6: aload_0
    //   7: getfield 43	com/android/dx/dex/file/MixedItemSection:interns	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 82	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 56	com/android/dx/dex/file/OffsettedItem
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +9 -> 28
    //   22: aload_2
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 101	com/android/dx/dex/file/MixedItemSection:add	(Lcom/android/dx/dex/file/OffsettedItem;)V
    //   33: aload_0
    //   34: getfield 43	com/android/dx/dex/file/MixedItemSection:interns	Ljava/util/HashMap;
    //   37: aload_1
    //   38: aload_1
    //   39: invokevirtual 105	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: goto -19 -> 24
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	MixedItemSection
    //   0	51	1	paramT	T
    //   17	6	2	localOffsettedItem	OffsettedItem
    // Exception table:
    //   from	to	target	type
    //   2	18	46	finally
    //   28	43	46	finally
  }
  
  public Collection<? extends Item> items()
  {
    return this.items;
  }
  
  public void placeItems()
  {
    throwIfNotPrepared();
    int k;
    int i;
    int j;
    switch (MixedItemSection.2.$SwitchMap$com$android$dx$dex$file$MixedItemSection$SortType[this.sort.ordinal()])
    {
    default: 
      k = this.items.size();
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (i >= k) {
        break label178;
      }
      OffsettedItem localOffsettedItem = (OffsettedItem)this.items.get(i);
      int m;
      try
      {
        m = localOffsettedItem.place(this, j);
        if (m >= j) {
          break label160;
        }
        throw new RuntimeException("bogus place() result for " + localOffsettedItem);
      }
      catch (RuntimeException localRuntimeException)
      {
        throw ExceptionWithContext.withContext(localRuntimeException, "...while placing " + localOffsettedItem);
      }
      Collections.sort(this.items);
      break;
      Collections.sort(this.items, TYPE_SORTER);
      break;
      label160:
      j = localOffsettedItem.writeSize();
      j = m + j;
      i += 1;
    }
    label178:
    this.writeSize = j;
  }
  
  protected void prepare0()
  {
    DexFile localDexFile = getFile();
    int i = 0;
    int j = this.items.size();
    if (i >= j) {
      return;
    }
    for (;;)
    {
      if (i < j)
      {
        ((OffsettedItem)this.items.get(i)).addContents(localDexFile);
        i += 1;
      }
      else
      {
        break;
      }
    }
  }
  
  public int size()
  {
    return this.items.size();
  }
  
  public void writeHeaderPart(AnnotatedOutput paramAnnotatedOutput)
  {
    throwIfNotPrepared();
    if (this.writeSize == -1) {
      throw new RuntimeException("write size not yet set");
    }
    int j = this.writeSize;
    if (j == 0) {}
    for (int i = 0;; i = getFileOffset())
    {
      Object localObject2 = getName();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "<unnamed>";
      }
      localObject2 = new char[15 - ((String)localObject1).length()];
      Arrays.fill((char[])localObject2, ' ');
      localObject2 = new String((char[])localObject2);
      if (paramAnnotatedOutput.annotates())
      {
        paramAnnotatedOutput.annotate(4, (String)localObject1 + "_size:" + (String)localObject2 + Hex.u4(j));
        paramAnnotatedOutput.annotate(4, (String)localObject1 + "_off: " + (String)localObject2 + Hex.u4(i));
      }
      paramAnnotatedOutput.writeInt(j);
      paramAnnotatedOutput.writeInt(i);
      return;
    }
  }
  
  public void writeIndexAnnotation(AnnotatedOutput paramAnnotatedOutput, ItemType paramItemType, String paramString)
  {
    throwIfNotPrepared();
    Object localObject = new TreeMap();
    Iterator localIterator = this.items.iterator();
    while (localIterator.hasNext())
    {
      OffsettedItem localOffsettedItem = (OffsettedItem)localIterator.next();
      if (localOffsettedItem.itemType() == paramItemType) {
        ((TreeMap)localObject).put(localOffsettedItem.toHuman(), localOffsettedItem);
      }
    }
    if (((TreeMap)localObject).size() == 0) {}
    for (;;)
    {
      return;
      paramAnnotatedOutput.annotate(0, paramString);
      paramItemType = ((TreeMap)localObject).entrySet().iterator();
      while (paramItemType.hasNext())
      {
        localObject = (Map.Entry)paramItemType.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (OffsettedItem)((Map.Entry)localObject).getValue();
        paramAnnotatedOutput.annotate(0, ((OffsettedItem)localObject).offsetString() + ' ' + paramString + '\n');
      }
    }
  }
  
  public int writeSize()
  {
    throwIfNotPrepared();
    return this.writeSize;
  }
  
  protected void writeTo0(AnnotatedOutput paramAnnotatedOutput)
  {
    boolean bool = paramAnnotatedOutput.annotates();
    DexFile localDexFile = getFile();
    Iterator localIterator = this.items.iterator();
    int i = 0;
    int k = 1;
    if (localIterator.hasNext())
    {
      OffsettedItem localOffsettedItem = (OffsettedItem)localIterator.next();
      int j = k;
      if (bool) {
        if (k == 0) {
          break label131;
        }
      }
      for (j = 0;; j = k)
      {
        k = localOffsettedItem.getAlignment() - 1;
        int m = (k ^ 0xFFFFFFFF) & i + k;
        k = i;
        if (i != m)
        {
          paramAnnotatedOutput.writeZeroes(m - i);
          k = m;
        }
        localOffsettedItem.writeTo(localDexFile, paramAnnotatedOutput);
        i = localOffsettedItem.writeSize() + k;
        k = j;
        break;
        label131:
        paramAnnotatedOutput.annotate(0, "\n");
      }
    }
    if (i != this.writeSize) {
      throw new RuntimeException("output size mismatch");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.MixedItemSection
 * JD-Core Version:    0.7.0.1
 */