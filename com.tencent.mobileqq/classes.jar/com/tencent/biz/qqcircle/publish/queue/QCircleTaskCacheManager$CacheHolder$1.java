package com.tencent.biz.qqcircle.publish.queue;

import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper.OnCloseListener;

class QCircleTaskCacheManager$CacheHolder$1
  implements IDBManagerWrapper.OnCloseListener
{
  QCircleTaskCacheManager$CacheHolder$1(QCircleTaskCacheManager.CacheHolder paramCacheHolder) {}
  
  public void onClosed(IDBManagerWrapper paramIDBManagerWrapper)
  {
    paramIDBManagerWrapper = this.a;
    paramIDBManagerWrapper.a = 0L;
    paramIDBManagerWrapper.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.QCircleTaskCacheManager.CacheHolder.1
 * JD-Core Version:    0.7.0.1
 */