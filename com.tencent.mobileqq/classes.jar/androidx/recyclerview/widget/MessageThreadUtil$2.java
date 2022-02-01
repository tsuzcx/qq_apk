package androidx.recyclerview.widget;

import android.os.AsyncTask;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil$2
  implements ThreadUtil.BackgroundCallback<T>
{
  static final int LOAD_TILE = 3;
  static final int RECYCLE_TILE = 4;
  static final int REFRESH = 1;
  static final int UPDATE_RANGE = 2;
  private Runnable mBackgroundRunnable = new MessageThreadUtil.2.1(this);
  AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
  private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
  final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();
  
  MessageThreadUtil$2(MessageThreadUtil paramMessageThreadUtil, ThreadUtil.BackgroundCallback paramBackgroundCallback) {}
  
  private void maybeExecuteBackgroundRunnable()
  {
    if (this.mBackgroundRunning.compareAndSet(false, true)) {
      this.mExecutor.execute(this.mBackgroundRunnable);
    }
  }
  
  private void sendMessage(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
  {
    this.mQueue.sendMessage(paramSyncQueueItem);
    maybeExecuteBackgroundRunnable();
  }
  
  private void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
  {
    this.mQueue.sendMessageAtFrontOfQueue(paramSyncQueueItem);
    maybeExecuteBackgroundRunnable();
  }
  
  public void loadTile(int paramInt1, int paramInt2)
  {
    sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, paramInt1, paramInt2));
  }
  
  public void recycleTile(TileList.Tile<T> paramTile)
  {
    sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(4, 0, paramTile));
  }
  
  public void refresh(int paramInt)
  {
    sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(1, paramInt, null));
  }
  
  public void updateRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil.2
 * JD-Core Version:    0.7.0.1
 */