package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper.OnCloseListener;

class QCircleOutboxTaskCacheManager$CacheHolder$1
  implements IDBManagerWrapper.OnCloseListener
{
  QCircleOutboxTaskCacheManager$CacheHolder$1(QCircleOutboxTaskCacheManager.CacheHolder paramCacheHolder) {}
  
  public void onClosed(IDBManagerWrapper paramIDBManagerWrapper)
  {
    try
    {
      this.a.a = 0L;
      this.a.b = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskCacheManager.CacheHolder.1
 * JD-Core Version:    0.7.0.1
 */