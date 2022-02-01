package com.tencent.commonsdk.cache;

import android.support.v4.util.LruCache;
import java.util.List;

class QQLruCache$1
  extends LruCache<K, V>
{
  QQLruCache$1(QQLruCache paramQQLruCache, int paramInt, boolean paramBoolean)
  {
    super(paramInt, paramBoolean);
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2)
  {
    this.this$0.entryRemoved(paramBoolean, paramK, paramV1, paramV2);
    if (paramBoolean) {
      if (paramV1 == null) {}
    }
    try
    {
      if ((paramV1 instanceof List)) {
        QQLruCache.access$002(this.this$0, QQLruCache.access$000(this.this$0) - ((List)paramV1).size());
      }
      if ((paramV2 != null) && ((paramV2 instanceof List))) {
        QQLruCache.access$002(this.this$0, QQLruCache.access$000(this.this$0) + ((List)paramV2).size());
      }
      return;
    }
    finally
    {
      label99:
      break label99;
    }
    throw paramK;
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return this.this$0.sizeOf(paramK, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.cache.QQLruCache.1
 * JD-Core Version:    0.7.0.1
 */