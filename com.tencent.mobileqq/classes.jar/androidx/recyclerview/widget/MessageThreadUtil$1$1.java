package androidx.recyclerview.widget;

import android.util.Log;

class MessageThreadUtil$1$1
  implements Runnable
{
  MessageThreadUtil$1$1(MessageThreadUtil.1 param1) {}
  
  public void run()
  {
    MessageThreadUtil.SyncQueueItem localSyncQueueItem = this.this$1.mQueue.next();
    if (localSyncQueueItem != null)
    {
      switch (localSyncQueueItem.what)
      {
      default: 
        Log.e("ThreadUtil", "Unsupported message, what=" + localSyncQueueItem.what);
      }
      for (;;)
      {
        localSyncQueueItem = this.this$1.mQueue.next();
        break;
        this.this$1.val$callback.updateItemCount(localSyncQueueItem.arg1, localSyncQueueItem.arg2);
        continue;
        TileList.Tile localTile = (TileList.Tile)localSyncQueueItem.data;
        this.this$1.val$callback.addTile(localSyncQueueItem.arg1, localTile);
        continue;
        this.this$1.val$callback.removeTile(localSyncQueueItem.arg1, localSyncQueueItem.arg2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.1.1
 * JD-Core Version:    0.7.0.1
 */