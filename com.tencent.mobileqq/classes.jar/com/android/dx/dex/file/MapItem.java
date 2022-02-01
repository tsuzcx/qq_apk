package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class MapItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 4;
  private static final int WRITE_SIZE = 12;
  private final Item firstItem;
  private final int itemCount;
  private final Item lastItem;
  private final Section section;
  private final ItemType type;
  
  private MapItem(ItemType paramItemType, Section paramSection, Item paramItem1, Item paramItem2, int paramInt)
  {
    super(4, 12);
    if (paramItemType == null) {
      throw new NullPointerException("type == null");
    }
    if (paramSection == null) {
      throw new NullPointerException("section == null");
    }
    if (paramItem1 == null) {
      throw new NullPointerException("firstItem == null");
    }
    if (paramItem2 == null) {
      throw new NullPointerException("lastItem == null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("itemCount <= 0");
    }
    this.type = paramItemType;
    this.section = paramSection;
    this.firstItem = paramItem1;
    this.lastItem = paramItem2;
    this.itemCount = paramInt;
  }
  
  private MapItem(Section paramSection)
  {
    super(4, 12);
    if (paramSection == null) {
      throw new NullPointerException("section == null");
    }
    this.type = ItemType.TYPE_MAP_LIST;
    this.section = paramSection;
    this.firstItem = null;
    this.lastItem = null;
    this.itemCount = 1;
  }
  
  public static void addMap(Section[] paramArrayOfSection, MixedItemSection paramMixedItemSection)
  {
    if (paramArrayOfSection == null) {
      throw new NullPointerException("sections == null");
    }
    if (paramMixedItemSection.items().size() != 0) {
      throw new IllegalArgumentException("mapSection.items().size() != 0");
    }
    ArrayList localArrayList = new ArrayList(50);
    int m = paramArrayOfSection.length;
    int j = 0;
    if (j < m)
    {
      Section localSection = paramArrayOfSection[j];
      Iterator localIterator = localSection.items().iterator();
      int i = 0;
      Object localObject2 = null;
      Object localObject1 = null;
      Object localObject4 = null;
      while (localIterator.hasNext())
      {
        Item localItem = (Item)localIterator.next();
        ItemType localItemType = localItem.itemType();
        Object localObject5 = localObject4;
        Object localObject3 = localObject1;
        int k = i;
        if (localItemType != localObject4)
        {
          if (i != 0) {
            localArrayList.add(new MapItem((ItemType)localObject4, localSection, (Item)localObject1, (Item)localObject2, i));
          }
          k = 0;
          localObject3 = localItem;
          localObject5 = localItemType;
        }
        i = k + 1;
        localObject2 = localItem;
        localObject4 = localObject5;
        localObject1 = localObject3;
      }
      if (i != 0) {
        localArrayList.add(new MapItem((ItemType)localObject4, localSection, (Item)localObject1, (Item)localObject2, i));
      }
      for (;;)
      {
        j += 1;
        break;
        if (localSection == paramMixedItemSection) {
          localArrayList.add(new MapItem(paramMixedItemSection));
        }
      }
    }
    paramMixedItemSection.add(new UniformListItem(ItemType.TYPE_MAP_LIST, localArrayList));
  }
  
  public void addContents(DexFile paramDexFile) {}
  
  public ItemType itemType()
  {
    return ItemType.TYPE_MAP_ITEM;
  }
  
  public final String toHuman()
  {
    return toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append('{');
    localStringBuffer.append(this.section.toString());
    localStringBuffer.append(' ');
    localStringBuffer.append(this.type.toHuman());
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int j = this.type.getMapValue();
    if (this.firstItem == null) {}
    for (int i = this.section.getFileOffset();; i = this.section.getAbsoluteItemOffset(this.firstItem))
    {
      if (paramAnnotatedOutput.annotates())
      {
        paramAnnotatedOutput.annotate(0, offsetString() + ' ' + this.type.getTypeName() + " map");
        paramAnnotatedOutput.annotate(2, "  type:   " + Hex.u2(j) + " // " + this.type.toString());
        paramAnnotatedOutput.annotate(2, "  unused: 0");
        paramAnnotatedOutput.annotate(4, "  size:   " + Hex.u4(this.itemCount));
        paramAnnotatedOutput.annotate(4, "  offset: " + Hex.u4(i));
      }
      paramAnnotatedOutput.writeShort(j);
      paramAnnotatedOutput.writeShort(0);
      paramAnnotatedOutput.writeInt(this.itemCount);
      paramAnnotatedOutput.writeInt(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.MapItem
 * JD-Core Version:    0.7.0.1
 */