package com.android.dex;

import java.util.AbstractList;
import java.util.RandomAccess;

final class Dex$TypeIndexToDescriptorTable
  extends AbstractList<String>
  implements RandomAccess
{
  private Dex$TypeIndexToDescriptorTable(Dex paramDex) {}
  
  public String get(int paramInt)
  {
    return Dex.access$1200(this.this$0).get(this.this$0.descriptorIndexFromTypeIndex(paramInt));
  }
  
  public int size()
  {
    return Dex.access$1000(this.this$0).typeIds.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.TypeIndexToDescriptorTable
 * JD-Core Version:    0.7.0.1
 */