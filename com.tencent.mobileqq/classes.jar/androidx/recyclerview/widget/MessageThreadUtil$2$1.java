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
      int i = ((MessageThreadUtil.SyncQueueItem)localObject).what;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Unsupported message, what=");
              localStringBuilder.append(((MessageThreadUtil.SyncQueueItem)localObject).what);
              Log.e("ThreadUtil", localStringBuilder.toString());
            }
            else
            {
              localObject = (TileList.Tile)((MessageThreadUtil.SyncQueueItem)localObject).data;
              this.this$1.val$callback.recycleTile((TileList.Tile)localObject);
            }
          }
          else {
            this.this$1.val$callback.loadTile(((MessageThreadUtil.SyncQueueItem)localObject).arg1, ((MessageThreadUtil.SyncQueueItem)localObject).arg2);
          }
        }
        else
        {
          this.this$1.mQueue.removeMessages(2);
          this.this$1.mQueue.removeMessages(3);
          this.this$1.val$callback.updateRange(((MessageThreadUtil.SyncQueueItem)localObject).arg1, ((MessageThreadUtil.SyncQueueItem)localObject).arg2, ((MessageThreadUtil.SyncQueueItem)localObject).arg3, ((MessageThreadUtil.SyncQueueItem)localObject).arg4, ((MessageThreadUtil.SyncQueueItem)localObject).arg5);
        }
      }
      else
      {
        this.this$1.mQueue.removeMessages(1);
        this.this$1.val$callback.refresh(((MessageThreadUtil.SyncQueueItem)localObject).arg1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.2.1
 * JD-Core Version:    0.7.0.1
 */