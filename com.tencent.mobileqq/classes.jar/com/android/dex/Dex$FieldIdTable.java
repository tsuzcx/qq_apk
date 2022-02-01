package com.android.dex;

import java.util.AbstractList;
import java.util.RandomAccess;

final class Dex$FieldIdTable
  extends AbstractList<FieldId>
  implements RandomAccess
{
  private Dex$FieldIdTable(Dex paramDex) {}
  
  public FieldId get(int paramInt)
  {
    Dex.access$1100(paramInt, Dex.access$1000(this.this$0).fieldIds.size);
    return this.this$0.open(Dex.access$1000(this.this$0).fieldIds.off + paramInt * 8).readFieldId();
  }
  
  public int size()
  {
    return Dex.access$1000(this.this$0).fieldIds.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.FieldIdTable
 * JD-Core Version:    0.7.0.1
 */