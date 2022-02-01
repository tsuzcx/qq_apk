package com.android.dex;

import java.util.AbstractList;
import java.util.RandomAccess;

final class Dex$TypeIndexToDescriptorIndexTable
  extends AbstractList<Integer>
  implements RandomAccess
{
  private Dex$TypeIndexToDescriptorIndexTable(Dex paramDex) {}
  
  public Integer get(int paramInt)
  {
    return Integer.valueOf(this.this$0.descriptorIndexFromTypeIndex(paramInt));
  }
  
  public int size()
  {
    return Dex.access$1000(this.this$0).typeIds.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.TypeIndexToDescriptorIndexTable
 * JD-Core Version:    0.7.0.1
 */