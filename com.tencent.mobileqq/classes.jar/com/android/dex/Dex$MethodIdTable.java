package com.android.dex;

import java.util.AbstractList;
import java.util.RandomAccess;

final class Dex$MethodIdTable
  extends AbstractList<MethodId>
  implements RandomAccess
{
  private Dex$MethodIdTable(Dex paramDex) {}
  
  public MethodId get(int paramInt)
  {
    Dex.access$1100(paramInt, Dex.access$1000(this.this$0).methodIds.size);
    return this.this$0.open(Dex.access$1000(this.this$0).methodIds.off + paramInt * 8).readMethodId();
  }
  
  public int size()
  {
    return Dex.access$1000(this.this$0).methodIds.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.MethodIdTable
 * JD-Core Version:    0.7.0.1
 */