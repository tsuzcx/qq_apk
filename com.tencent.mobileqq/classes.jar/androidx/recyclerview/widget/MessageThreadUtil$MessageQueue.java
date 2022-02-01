package androidx.recyclerview.widget;

class MessageThreadUtil$MessageQueue
{
  private MessageThreadUtil.SyncQueueItem mRoot;
  
  /* Error */
  MessageThreadUtil.SyncQueueItem next()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	androidx/recyclerview/widget/MessageThreadUtil$MessageQueue:mRoot	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 15	androidx/recyclerview/widget/MessageThreadUtil$MessageQueue:mRoot	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   21: astore_1
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 15	androidx/recyclerview/widget/MessageThreadUtil$MessageQueue:mRoot	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   27: getfield 19	androidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem:next	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   30: putfield 15	androidx/recyclerview/widget/MessageThreadUtil$MessageQueue:mRoot	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   33: goto -20 -> 13
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	MessageQueue
    //   6	16	1	localSyncQueueItem	MessageThreadUtil.SyncQueueItem
    //   36	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   17	33	36	finally
  }
  
  void removeMessages(int paramInt)
  {
    try
    {
      while ((this.mRoot != null) && (this.mRoot.what == paramInt))
      {
        MessageThreadUtil.SyncQueueItem localSyncQueueItem1 = this.mRoot;
        this.mRoot = this.mRoot.next;
        localSyncQueueItem1.recycle();
      }
      if (this.mRoot == null) {
        break label104;
      }
    }
    finally {}
    Object localObject3 = this.mRoot;
    Object localObject2 = ((MessageThreadUtil.SyncQueueItem)localObject3).next;
    if (localObject2 != null)
    {
      MessageThreadUtil.SyncQueueItem localSyncQueueItem2 = ((MessageThreadUtil.SyncQueueItem)localObject2).next;
      if (((MessageThreadUtil.SyncQueueItem)localObject2).what == paramInt)
      {
        ((MessageThreadUtil.SyncQueueItem)localObject3).next = localSyncQueueItem2;
        ((MessageThreadUtil.SyncQueueItem)localObject2).recycle();
      }
      for (;;)
      {
        localObject2 = localSyncQueueItem2;
        break;
        localObject3 = localObject2;
      }
    }
    label104:
  }
  
  /* Error */
  void sendMessage(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	androidx/recyclerview/widget/MessageThreadUtil$MessageQueue:mRoot	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 15	androidx/recyclerview/widget/MessageThreadUtil$MessageQueue:mRoot	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 15	androidx/recyclerview/widget/MessageThreadUtil$MessageQueue:mRoot	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   21: astore_2
    //   22: aload_2
    //   23: getfield 19	androidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem:next	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   26: ifnull +11 -> 37
    //   29: aload_2
    //   30: getfield 19	androidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem:next	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   33: astore_2
    //   34: goto -12 -> 22
    //   37: aload_2
    //   38: aload_1
    //   39: putfield 19	androidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem:next	Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
    //   42: goto -28 -> 14
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	MessageQueue
    //   0	50	1	paramSyncQueueItem	MessageThreadUtil.SyncQueueItem
    //   21	17	2	localSyncQueueItem	MessageThreadUtil.SyncQueueItem
    // Exception table:
    //   from	to	target	type
    //   2	14	45	finally
    //   17	22	45	finally
    //   22	34	45	finally
    //   37	42	45	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.MessageQueue
 * JD-Core Version:    0.7.0.1
 */