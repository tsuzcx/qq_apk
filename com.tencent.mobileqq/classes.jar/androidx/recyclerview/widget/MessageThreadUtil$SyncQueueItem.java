package androidx.recyclerview.widget;

class MessageThreadUtil$SyncQueueItem
{
  private static SyncQueueItem sPool;
  private static final Object sPoolLock = new Object();
  public int arg1;
  public int arg2;
  public int arg3;
  public int arg4;
  public int arg5;
  public Object data;
  SyncQueueItem next;
  public int what;
  
  static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    return obtainMessage(paramInt1, paramInt2, paramInt3, 0, 0, 0, null);
  }
  
  static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject)
  {
    synchronized (sPoolLock)
    {
      SyncQueueItem localSyncQueueItem;
      if (sPool == null)
      {
        localSyncQueueItem = new SyncQueueItem();
      }
      else
      {
        localSyncQueueItem = sPool;
        sPool = sPool.next;
        localSyncQueueItem.next = null;
      }
      localSyncQueueItem.what = paramInt1;
      localSyncQueueItem.arg1 = paramInt2;
      localSyncQueueItem.arg2 = paramInt3;
      localSyncQueueItem.arg3 = paramInt4;
      localSyncQueueItem.arg4 = paramInt5;
      localSyncQueueItem.arg5 = paramInt6;
      localSyncQueueItem.data = paramObject;
      return localSyncQueueItem;
    }
  }
  
  static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, Object paramObject)
  {
    return obtainMessage(paramInt1, paramInt2, 0, 0, 0, 0, paramObject);
  }
  
  void recycle()
  {
    this.next = null;
    this.arg5 = 0;
    this.arg4 = 0;
    this.arg3 = 0;
    this.arg2 = 0;
    this.arg1 = 0;
    this.what = 0;
    this.data = null;
    synchronized (sPoolLock)
    {
      if (sPool != null) {
        this.next = sPool;
      }
      sPool = this;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem
 * JD-Core Version:    0.7.0.1
 */