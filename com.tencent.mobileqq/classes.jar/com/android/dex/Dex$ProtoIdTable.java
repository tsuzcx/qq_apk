package com.android.dex;

import java.util.AbstractList;
import java.util.RandomAccess;

final class Dex$ProtoIdTable
  extends AbstractList<ProtoId>
  implements RandomAccess
{
  private Dex$ProtoIdTable(Dex paramDex) {}
  
  public ProtoId get(int paramInt)
  {
    Dex.access$1100(paramInt, Dex.access$1000(this.this$0).protoIds.size);
    return this.this$0.open(Dex.access$1000(this.this$0).protoIds.off + paramInt * 12).readProtoId();
  }
  
  public int size()
  {
    return Dex.access$1000(this.this$0).protoIds.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.ProtoIdTable
 * JD-Core Version:    0.7.0.1
 */