package com.tencent.component.media.image;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.component.media.ImageManagerEnv;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MessageQueueDownloadMultiplexTask
  extends ImageTask
{
  private static final int MSG_CHECK_SAME_IMAGE_TASK = 1000;
  private static Handler mDispatcher;
  private static HashMap<String, LinkedList<MessageQueueDownloadMultiplexTask>> mDownloadImageTaskQueue = new HashMap();
  private static int mObjectPoolSize;
  private static boolean needRetry = false;
  private static MessageQueueDownloadMultiplexTask sPool;
  private static final Object sPoolSync;
  private MessageQueueDownloadMultiplexTask next = null;
  
  static
  {
    mDispatcher = null;
    HandlerThread localHandlerThread;
    if (ImageManagerEnv.g().getDispatcher() == null)
    {
      localHandlerThread = new HandlerThread("ImageDownloadMultiplexThread");
      localHandlerThread.start();
    }
    for (mDispatcher = new MessageQueueDownloadMultiplexTask.ImageDownloadMultiplexHandler(localHandlerThread.getLooper());; mDispatcher = new MessageQueueDownloadMultiplexTask.ImageDownloadMultiplexHandler(ImageManagerEnv.g().getDispatcher()))
    {
      sPool = null;
      sPoolSync = new Object();
      mObjectPoolSize = 0;
      clearAndInitSize();
      return;
    }
  }
  
  private MessageQueueDownloadMultiplexTask(ImageTask paramImageTask)
  {
    super(paramImageTask);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (sPoolSync)
    {
      sPool = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        MessageQueueDownloadMultiplexTask localMessageQueueDownloadMultiplexTask = new MessageQueueDownloadMultiplexTask(null);
        localMessageQueueDownloadMultiplexTask.next = sPool;
        sPool = localMessageQueueDownloadMultiplexTask;
        mObjectPoolSize += 1;
        i += 1;
      }
      return;
    }
  }
  
  private static MessageQueueDownloadMultiplexTask getNextSameDownloadImageTask(String paramString)
  {
    Object localObject = null;
    MessageQueueDownloadMultiplexTask localMessageQueueDownloadMultiplexTask = null;
    LinkedList localLinkedList = (LinkedList)mDownloadImageTaskQueue.get(paramString);
    if (localLinkedList != null)
    {
      localObject = localMessageQueueDownloadMultiplexTask;
      while (localLinkedList.size() > 0)
      {
        localMessageQueueDownloadMultiplexTask = (MessageQueueDownloadMultiplexTask)localLinkedList.removeFirst();
        localObject = localMessageQueueDownloadMultiplexTask;
        if (localMessageQueueDownloadMultiplexTask != null) {
          localObject = localMessageQueueDownloadMultiplexTask;
        }
      }
    }
    if (localObject == null) {
      mDownloadImageTaskQueue.remove(paramString);
    }
    return localObject;
  }
  
  private static boolean hasSameDownloadImageTask(MessageQueueDownloadMultiplexTask paramMessageQueueDownloadMultiplexTask)
  {
    String str = paramMessageQueueDownloadMultiplexTask.getImageKey().urlKey;
    LinkedList localLinkedList = (LinkedList)mDownloadImageTaskQueue.get(str);
    if (localLinkedList == null)
    {
      paramMessageQueueDownloadMultiplexTask = new LinkedList();
      mDownloadImageTaskQueue.put(str, paramMessageQueueDownloadMultiplexTask);
      return false;
    }
    localLinkedList.addLast(paramMessageQueueDownloadMultiplexTask);
    return true;
  }
  
  public static MessageQueueDownloadMultiplexTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        MessageQueueDownloadMultiplexTask localMessageQueueDownloadMultiplexTask = sPool;
        sPool = sPool.next;
        localMessageQueueDownloadMultiplexTask.next = null;
        mObjectPoolSize -= 1;
        localMessageQueueDownloadMultiplexTask.setImageTask(paramImageTask);
        return localMessageQueueDownloadMultiplexTask;
      }
      return new MessageQueueDownloadMultiplexTask(paramImageTask);
    }
  }
  
  private static List<MessageQueueDownloadMultiplexTask> removeSameDownloadImageTask(String paramString)
  {
    return (List)mDownloadImageTaskQueue.remove(paramString);
  }
  
  public void excuteTask()
  {
    Message localMessage = mDispatcher.obtainMessage();
    localMessage.what = 1000;
    localMessage.obj = this;
    localMessage.sendToTarget();
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    if (!getImageKey().needDecode()) {
      ImageTracer.end(getImageKey().url);
    }
    Message localMessage;
    switch (paramInt)
    {
    default: 
      setResult(paramInt, paramVarArgs);
    case 0: 
    case 1: 
      do
      {
        do
        {
          return;
        } while (needRetry);
        localMessage = mDispatcher.obtainMessage();
        localMessage.what = 0;
        localMessage.obj = new Object[] { this, paramVarArgs[0] };
        localMessage.sendToTarget();
        return;
      } while (needRetry);
      localMessage = mDispatcher.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = new Object[] { this, paramVarArgs[0] };
      localMessage.sendToTarget();
      return;
    case 2: 
      localMessage = mDispatcher.obtainMessage();
      localMessage.what = 2;
      localMessage.obj = new Object[] { this, paramVarArgs[0], paramVarArgs[1], paramVarArgs[2] };
      localMessage.sendToTarget();
      return;
    case 11: 
      localMessage = mDispatcher.obtainMessage();
      localMessage.what = 11;
      localMessage.obj = new Object[] { this, paramVarArgs[0] };
      localMessage.sendToTarget();
      return;
    }
    paramVarArgs = mDispatcher.obtainMessage();
    paramVarArgs.what = 12;
    paramVarArgs.obj = new Object[] { this };
    paramVarArgs.sendToTarget();
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    synchronized (sPoolSync)
    {
      if (mObjectPoolSize < 50)
      {
        this.next = sPool;
        sPool = this;
        mObjectPoolSize += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.MessageQueueDownloadMultiplexTask
 * JD-Core Version:    0.7.0.1
 */