package android.support.v4.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;

class MQLruCache$1
  extends AsyncLruCache<K, MQLruCache<K, O>.CacheItem>
{
  MQLruCache$1(MQLruCache paramMQLruCache, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, MQLruCache<K, O>.CacheItem paramMQLruCache1, MQLruCache<K, O>.CacheItem paramMQLruCache2)
  {
    if ((paramBoolean) && (this.val$priority > 0))
    {
      MQLruCache.access$200(this.this$0)[this.val$priority].add(Pair.create(paramK, paramMQLruCache1));
    }
    else
    {
      Object localObject = null;
      if (paramMQLruCache1 != null) {
        paramMQLruCache1 = paramMQLruCache1.value;
      } else {
        paramMQLruCache1 = null;
      }
      if (paramMQLruCache2 != null) {
        localObject = paramMQLruCache2.value;
      }
      this.this$0.entryObjRemoved(paramBoolean, paramK, paramMQLruCache1, localObject);
    }
    if ((MQLruCache.access$100(this.this$0).size() > 0) && (MQLruCache.access$100(this.this$0).contains(paramK))) {
      MQLruCache.access$100(this.this$0).remove(paramK);
    }
  }
  
  protected int sizeOf(K paramK, MQLruCache<K, O>.CacheItem paramMQLruCache)
  {
    int i = this.this$0.sizeOfObj(paramK, paramMQLruCache.value);
    if ((MQLruCache.access$000(this.this$0) > 0) && (i >= MQLruCache.access$000(this.this$0)) && (!MQLruCache.access$100(this.this$0).contains(paramK)))
    {
      MQLruCache.access$100(this.this$0).add(paramK);
      this.this$0.warningLargeItem(paramK, i);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.util.MQLruCache.1
 * JD-Core Version:    0.7.0.1
 */