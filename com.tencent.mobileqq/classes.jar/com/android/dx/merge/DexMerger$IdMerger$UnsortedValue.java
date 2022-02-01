package com.android.dx.merge;

import com.android.dex.Dex;

class DexMerger$IdMerger$UnsortedValue
  implements Comparable<DexMerger.IdMerger<T>.UnsortedValue>
{
  final int index;
  final IndexMap indexMap;
  final int offset;
  final Dex source;
  final T value;
  
  DexMerger$IdMerger$UnsortedValue(Dex paramDex, IndexMap paramIndexMap, T paramT, int paramInt1, int paramInt2)
  {
    this.source = paramIndexMap;
    this.indexMap = paramT;
    this.value = paramInt1;
    this.index = paramInt2;
    int i;
    this.offset = i;
  }
  
  public int compareTo(DexMerger.IdMerger<T>.UnsortedValue paramIdMerger)
  {
    return this.value.compareTo(paramIdMerger.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger.IdMerger.UnsortedValue
 * JD-Core Version:    0.7.0.1
 */