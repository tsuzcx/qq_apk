package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;

class MessageThreadUtil$1
  implements ThreadUtil.MainThreadCallback<T>
{
  static final int ADD_TILE = 2;
  static final int REMOVE_TILE = 3;
  static final int UPDATE_ITEM_COUNT = 1;
  private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
  private Runnable mMainThreadRunnable = new MessageThreadUtil.1.1(this);
  final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();
  
  MessageThreadUtil$1(MessageThreadUtil paramMessageThreadUtil, ThreadUtil.MainThreadCallback paramMainThreadCallback) {}
  
  private void sendMessage(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
  {
    this.mQueue.sendMessage(paramSyncQueueItem);
    this.mMainThreadHandler.post(this.mMainThreadRunnable);
  }
  
  public void addTile(int paramInt, TileList.Tile<T> paramTile)
  {
    sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(2, paramInt, paramTile));
  }
  
  public void removeTile(int paramInt1, int paramInt2)
  {
    sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, paramInt1, paramInt2));
  }
  
  public void updateItemCount(int paramInt1, int paramInt2)
  {
    sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(1, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.1
 * JD-Core Version:    0.7.0.1
 */