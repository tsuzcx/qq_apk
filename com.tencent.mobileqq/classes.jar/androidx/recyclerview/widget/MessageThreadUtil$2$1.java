package androidx.recyclerview.widget;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil$2$1
  implements Runnable
{
  MessageThreadUtil$2$1(MessageThreadUtil.2 param2) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject = this.this$1.mQueue.next();
      if (localObject == null)
      {
        this.this$1.mBackgroundRunning.set(false);
        return;
      }
      switch (((MessageThreadUtil.SyncQueueItem)localObject).what)
      {
      default: 
        Log.e("ThreadUtil", "Unsupported message, what=" + ((MessageThreadUtil.SyncQueueItem)localObject).what);
        break;
      case 1: 
        this.this$1.mQueue.removeMessages(1);
        this.this$1.val$callback.refresh(((MessageThreadUtil.SyncQueueItem)localObject).arg1);
        break;
      case 2: 
        this.this$1.mQueue.removeMessages(2);
        this.this$1.mQueue.removeMessages(3);
        this.this$1.val$callback.updateRange(((MessageThreadUtil.SyncQueueItem)localObject).arg1, ((MessageThreadUtil.SyncQueueItem)localObject).arg2, ((MessageThreadUtil.SyncQueueItem)localObject).arg3, ((MessageThreadUtil.SyncQueueItem)localObject).arg4, ((MessageThreadUtil.SyncQueueItem)localObject).arg5);
        break;
      case 3: 
        this.this$1.val$callback.loadTile(((MessageThreadUtil.SyncQueueItem)localObject).arg1, ((MessageThreadUtil.SyncQueueItem)localObject).arg2);
        break;
      }
      localObject = (TileList.Tile)((MessageThreadUtil.SyncQueueItem)localObject).data;
      this.this$1.val$callback.recycleTile((TileList.Tile)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.2.1
 * JD-Core Version:    0.7.0.1
 */