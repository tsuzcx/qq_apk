package com.android.dx.merge;

import com.android.dex.ClassDef;
import com.android.dex.Dex;
import java.util.Comparator;

final class SortableType
{
  public static final Comparator<SortableType> NULLS_LAST_ORDER = new SortableType.1();
  private ClassDef classDef;
  private int depth = -1;
  private final Dex dex;
  private final IndexMap indexMap;
  
  public SortableType(Dex paramDex, IndexMap paramIndexMap, ClassDef paramClassDef)
  {
    this.dex = paramDex;
    this.indexMap = paramIndexMap;
    this.classDef = paramClassDef;
  }
  
  public ClassDef getClassDef()
  {
    return this.classDef;
  }
  
  public Dex getDex()
  {
    return this.dex;
  }
  
  public IndexMap getIndexMap()
  {
    return this.indexMap;
  }
  
  public int getTypeIndex()
  {
    return this.classDef.getTypeIndex();
  }
  
  public boolean isDepthAssigned()
  {
    return this.depth != -1;
  }
  
  public boolean tryAssignDepth(SortableType[] paramArrayOfSortableType)
  {
    Object localObject;
    int j;
    label29:
    SortableType localSortableType;
    if (this.classDef.getSupertypeIndex() == -1)
    {
      i = 0;
      localObject = this.classDef.getInterfaces();
      int k = localObject.length;
      j = 0;
      if (j >= k) {
        break label124;
      }
      localSortableType = paramArrayOfSortableType[localObject[j]];
      if (localSortableType != null) {
        break label102;
      }
    }
    for (int i = Math.max(i, 1);; i = Math.max(i, localSortableType.depth))
    {
      j += 1;
      break label29;
      localObject = paramArrayOfSortableType[this.classDef.getSupertypeIndex()];
      if (localObject == null)
      {
        i = 1;
        break;
      }
      if (((SortableType)localObject).depth == -1) {}
      label102:
      do
      {
        return false;
        i = ((SortableType)localObject).depth;
        break;
      } while (localSortableType.depth == -1);
    }
    label124:
    this.depth = (i + 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.SortableType
 * JD-Core Version:    0.7.0.1
 */