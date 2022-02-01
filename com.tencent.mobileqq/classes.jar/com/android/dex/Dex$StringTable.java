package com.android.dex;

import java.util.AbstractList;
import java.util.RandomAccess;

final class Dex$StringTable
  extends AbstractList<String>
  implements RandomAccess
{
  private Dex$StringTable(Dex paramDex) {}
  
  public String get(int paramInt)
  {
    Dex.access$1100(paramInt, Dex.access$1000(this.this$0).stringIds.size);
    return this.this$0.open(Dex.access$1000(this.this$0).stringIds.off + paramInt * 4).readString();
  }
  
  public int size()
  {
    return Dex.access$1000(this.this$0).stringIds.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.StringTable
 * JD-Core Version:    0.7.0.1
 */