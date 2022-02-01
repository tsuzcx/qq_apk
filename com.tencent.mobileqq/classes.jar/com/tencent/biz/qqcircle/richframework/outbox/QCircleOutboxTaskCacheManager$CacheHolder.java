package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper.OnCloseListener;

final class QCircleOutboxTaskCacheManager$CacheHolder
{
  volatile long a;
  volatile IDBManagerWrapper b;
  IDBManagerWrapper.OnCloseListener c = new QCircleOutboxTaskCacheManager.CacheHolder.1(this);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskCacheManager.CacheHolder
 * JD-Core Version:    0.7.0.1
 */