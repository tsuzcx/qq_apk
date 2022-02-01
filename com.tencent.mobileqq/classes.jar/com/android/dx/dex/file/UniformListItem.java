package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Iterator;
import java.util.List;

public final class UniformListItem<T extends OffsettedItem>
  extends OffsettedItem
{
  private static final int HEADER_SIZE = 4;
  private final ItemType itemType;
  private final List<T> items;
  
  public UniformListItem(ItemType paramItemType, List<T> paramList)
  {
    super(getAlignment(paramList), writeSize(paramList));
    if (paramItemType == null) {
      throw new NullPointerException("itemType == null");
    }
    this.items = paramList;
    this.itemType = paramItemType;
  }
  
  private static int getAlignment(List<? extends OffsettedItem> paramList)
  {
    try
    {
      int i = Math.max(4, ((OffsettedItem)paramList.get(0)).getAlignment());
      return i;
    }
    catch (IndexOutOfBoundsException paramList)
    {
      throw new IllegalArgumentException("items.size() == 0");
    }
    catch (NullPointerException paramList)
    {
      throw new NullPointerException("items == null");
    }
  }
  
  private int headerSize()
  {
    return getAlignment();
  }
  
  private static int writeSize(List<? extends OffsettedItem> paramList)
  {
    OffsettedItem localOffsettedItem = (OffsettedItem)paramList.get(0);
    int i = paramList.size();
    return localOffsettedItem.writeSize() * i + getAlignment(paramList);
  }
  
  public void addContents(DexFile paramDexFile)
  {
    Iterator localIterator = this.items.iterator();
    while (localIterator.hasNext()) {
      ((OffsettedItem)localIterator.next()).addContents(paramDexFile);
    }
  }
  
  public final List<T> getItems()
  {
    return this.items;
  }
  
  public ItemType itemType()
  {
    return this.itemType;
  }
  
  protected void place0(Section paramSection, int paramInt)
  {
    int j = headerSize();
    Iterator localIterator = this.items.iterator();
    int i = 1;
    paramInt += j;
    j = -1;
    int k = -1;
    if (localIterator.hasNext())
    {
      OffsettedItem localOffsettedItem = (OffsettedItem)localIterator.next();
      int n = localOffsettedItem.writeSize();
      int m;
      if (i != 0)
      {
        m = localOffsettedItem.getAlignment();
        i = 0;
        k = n;
      }
      do
      {
        paramInt = localOffsettedItem.place(paramSection, paramInt) + n;
        j = m;
        break;
        if (n != k) {
          throw new UnsupportedOperationException("item size mismatch");
        }
        m = j;
      } while (localOffsettedItem.getAlignment() == j);
      throw new UnsupportedOperationException("item alignment mismatch");
    }
  }
  
  public final String toHuman()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append("{");
    Iterator localIterator = this.items.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      OffsettedItem localOffsettedItem = (OffsettedItem)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuffer.append(localOffsettedItem.toHuman());
        break;
        localStringBuffer.append(", ");
      }
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append(this.items);
    return localStringBuffer.toString();
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int i = this.items.size();
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, offsetString() + " " + typeName());
      paramAnnotatedOutput.annotate(4, "  size: " + Hex.u4(i));
    }
    paramAnnotatedOutput.writeInt(i);
    Iterator localIterator = this.items.iterator();
    while (localIterator.hasNext()) {
      ((OffsettedItem)localIterator.next()).writeTo(paramDexFile, paramAnnotatedOutput);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.UniformListItem
 * JD-Core Version:    0.7.0.1
 */