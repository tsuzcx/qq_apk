package com.android.dx.merge;

import com.android.dex.Dex;
import com.android.dex.Dex.Section;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

abstract class DexMerger$IdMerger<T extends Comparable<T>>
{
  private final Dex.Section out;
  
  protected DexMerger$IdMerger(DexMerger paramDexMerger, Dex.Section paramSection)
  {
    this.out = paramSection;
  }
  
  private int readIntoMap(Dex.Section paramSection, TableOfContents.Section paramSection1, IndexMap paramIndexMap, int paramInt1, TreeMap<T, List<Integer>> paramTreeMap, int paramInt2)
  {
    if (paramSection != null) {}
    for (int i = paramSection.getPosition();; i = -1)
    {
      if (paramInt1 < paramSection1.size)
      {
        paramIndexMap = read(paramSection, paramIndexMap, paramInt1);
        paramSection1 = (List)paramTreeMap.get(paramIndexMap);
        paramSection = paramSection1;
        if (paramSection1 == null)
        {
          paramSection = new ArrayList();
          paramTreeMap.put(paramIndexMap, paramSection);
        }
        paramSection.add(new Integer(paramInt2));
      }
      return i;
    }
  }
  
  private List<IdMerger<T>.UnsortedValue> readUnsortedValues(Dex paramDex, IndexMap paramIndexMap)
  {
    TableOfContents.Section localSection = getSection(paramDex.getTableOfContents());
    if (!localSection.exists()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    Dex.Section localSection1 = paramDex.open(localSection.off);
    int i = 0;
    while (i < localSection.size)
    {
      int j = localSection1.getPosition();
      localArrayList.add(new DexMerger.IdMerger.UnsortedValue(this, paramDex, paramIndexMap, read(localSection1, paramIndexMap, 0), i, j));
      i += 1;
    }
    return localArrayList;
  }
  
  abstract TableOfContents.Section getSection(TableOfContents paramTableOfContents);
  
  public final void mergeSorted()
  {
    int j = 0;
    TableOfContents.Section[] arrayOfSection = new TableOfContents.Section[DexMerger.access$1300(this.this$0).length];
    Dex.Section[] arrayOfSection1 = new Dex.Section[DexMerger.access$1300(this.this$0).length];
    int[] arrayOfInt1 = new int[DexMerger.access$1300(this.this$0).length];
    int[] arrayOfInt2 = new int[DexMerger.access$1300(this.this$0).length];
    TreeMap localTreeMap = new TreeMap();
    int i = 0;
    Object localObject;
    if (i < DexMerger.access$1300(this.this$0).length)
    {
      arrayOfSection[i] = getSection(DexMerger.access$1300(this.this$0)[i].getTableOfContents());
      if (arrayOfSection[i].exists()) {}
      for (localObject = DexMerger.access$1300(this.this$0)[i].open(arrayOfSection[i].off);; localObject = null)
      {
        arrayOfSection1[i] = localObject;
        arrayOfInt1[i] = readIntoMap(arrayOfSection1[i], arrayOfSection[i], DexMerger.access$1400(this.this$0)[i], arrayOfInt2[i], localTreeMap, i);
        i += 1;
        break;
      }
    }
    getSection(DexMerger.access$1500(this.this$0)).off = this.out.getPosition();
    i = j;
    while (!localTreeMap.isEmpty())
    {
      localObject = localTreeMap.pollFirstEntry();
      Iterator localIterator = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        j = arrayOfInt1[localInteger.intValue()];
        IndexMap localIndexMap = DexMerger.access$1400(this.this$0)[localInteger.intValue()];
        int k = localInteger.intValue();
        int m = arrayOfInt2[k];
        arrayOfInt2[k] = (m + 1);
        updateIndex(j, localIndexMap, m, i);
        arrayOfInt1[localInteger.intValue()] = readIntoMap(arrayOfSection1[localInteger.intValue()], arrayOfSection[localInteger.intValue()], DexMerger.access$1400(this.this$0)[localInteger.intValue()], arrayOfInt2[localInteger.intValue()], localTreeMap, localInteger.intValue());
      }
      write((Comparable)((Map.Entry)localObject).getKey());
      i += 1;
    }
    getSection(DexMerger.access$1500(this.this$0)).size = i;
  }
  
  public final void mergeUnsorted()
  {
    int k = 0;
    getSection(DexMerger.access$1500(this.this$0)).off = this.out.getPosition();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < DexMerger.access$1300(this.this$0).length)
    {
      localArrayList.addAll(readUnsortedValues(DexMerger.access$1300(this.this$0)[i], DexMerger.access$1400(this.this$0)[i]));
      i += 1;
    }
    Collections.sort(localArrayList);
    int j = 0;
    i = k;
    while (i < localArrayList.size())
    {
      k = i + 1;
      DexMerger.IdMerger.UnsortedValue localUnsortedValue1 = (DexMerger.IdMerger.UnsortedValue)localArrayList.get(i);
      updateIndex(localUnsortedValue1.offset, localUnsortedValue1.indexMap, localUnsortedValue1.index, j - 1);
      i = k;
      while ((i < localArrayList.size()) && (localUnsortedValue1.compareTo((DexMerger.IdMerger.UnsortedValue)localArrayList.get(i)) == 0))
      {
        DexMerger.IdMerger.UnsortedValue localUnsortedValue2 = (DexMerger.IdMerger.UnsortedValue)localArrayList.get(i);
        updateIndex(localUnsortedValue2.offset, localUnsortedValue2.indexMap, localUnsortedValue2.index, j - 1);
        i += 1;
      }
      write(localUnsortedValue1.value);
      j += 1;
    }
    getSection(DexMerger.access$1500(this.this$0)).size = j;
  }
  
  abstract T read(Dex.Section paramSection, IndexMap paramIndexMap, int paramInt);
  
  abstract void updateIndex(int paramInt1, IndexMap paramIndexMap, int paramInt2, int paramInt3);
  
  abstract void write(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger.IdMerger
 * JD-Core Version:    0.7.0.1
 */