package androidx.recyclerview.widget;

class MessageThreadUtil$MessageQueue
{
  private MessageThreadUtil.SyncQueueItem mRoot;
  
  MessageThreadUtil.SyncQueueItem next()
  {
    try
    {
      MessageThreadUtil.SyncQueueItem localSyncQueueItem = this.mRoot;
      if (localSyncQueueItem == null) {
        return null;
      }
      localSyncQueueItem = this.mRoot;
      this.mRoot = this.mRoot.next;
      return localSyncQueueItem;
    }
    finally {}
  }
  
  void removeMessages(int paramInt)
  {
    try
    {
      Object localObject1;
      while ((this.mRoot != null) && (this.mRoot.what == paramInt))
      {
        localObject1 = this.mRoot;
        this.mRoot = this.mRoot.next;
        ((MessageThreadUtil.SyncQueueItem)localObject1).recycle();
      }
      if (this.mRoot != null)
      {
        Object localObject3 = this.mRoot;
        MessageThreadUtil.SyncQueueItem localSyncQueueItem;
        for (localObject1 = ((MessageThreadUtil.SyncQueueItem)localObject3).next; localObject1 != null; localObject1 = localSyncQueueItem)
        {
          localSyncQueueItem = ((MessageThreadUtil.SyncQueueItem)localObject1).next;
          if (((MessageThreadUtil.SyncQueueItem)localObject1).what == paramInt)
          {
            ((MessageThreadUtil.SyncQueueItem)localObject3).next = localSyncQueueItem;
            ((MessageThreadUtil.SyncQueueItem)localObject1).recycle();
          }
          else
          {
            localObject3 = localObject1;
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void sendMessage(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
  {
    try
    {
      if (this.mRoot == null)
      {
        this.mRoot = paramSyncQueueItem;
        return;
      }
      for (MessageThreadUtil.SyncQueueItem localSyncQueueItem = this.mRoot; localSyncQueueItem.next != null; localSyncQueueItem = localSyncQueueItem.next) {}
      localSyncQueueItem.next = paramSyncQueueItem;
      return;
    }
    finally {}
    for (;;)
    {
      throw paramSyncQueueItem;
    }
  }
  
  void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
  {
    try
    {
      paramSyncQueueItem.next = this.mRoot;
      this.mRoot = paramSyncQueueItem;
      return;
    }
    finally
    {
      paramSyncQueueItem = finally;
      throw paramSyncQueueItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.MessageQueue
 * JD-Core Version:    0.7.0.1
 */