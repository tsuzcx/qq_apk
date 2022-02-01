package androidx.recyclerview.widget;

import android.util.Log;

class MessageThreadUtil$1$1
  implements Runnable
{
  MessageThreadUtil$1$1(MessageThreadUtil.1 param1) {}
  
  public void run()
  {
    for (MessageThreadUtil.SyncQueueItem localSyncQueueItem = this.this$1.mQueue.next(); localSyncQueueItem != null; localSyncQueueItem = this.this$1.mQueue.next())
    {
      int i = localSyncQueueItem.what;
      if (i != 1)
      {
        Object localObject;
        if (i != 2)
        {
          if (i != 3)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unsupported message, what=");
            ((StringBuilder)localObject).append(localSyncQueueItem.what);
            Log.e("ThreadUtil", ((StringBuilder)localObject).toString());
          }
          else
          {
            this.this$1.val$callback.removeTile(localSyncQueueItem.arg1, localSyncQueueItem.arg2);
          }
        }
        else
        {
          localObject = (TileList.Tile)localSyncQueueItem.data;
          this.this$1.val$callback.addTile(localSyncQueueItem.arg1, (TileList.Tile)localObject);
        }
      }
      else
      {
        this.this$1.val$callback.updateItemCount(localSyncQueueItem.arg1, localSyncQueueItem.arg2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.1.1
 * JD-Core Version:    0.7.0.1
 */