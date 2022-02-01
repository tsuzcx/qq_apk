package com.tencent.component.media.image;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.component.media.ImageManagerEnv;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MessageQueueDecodeMultiplexTask
  extends ImageTask
{
  private static final int MSG_CHECK_SAME_IMAGE_TASK = 1000;
  private static final int MSG_RETRY = 2;
  private static final int MSG_SET_RESULT = 1;
  private static HashMap<Integer, LinkedList<MessageQueueDecodeMultiplexTask>> mDecodeImageTaskQueue = new HashMap();
  private static Handler mDispatcher;
  private static int mObjectPoolSize;
  private static boolean needRetry = false;
  private static MessageQueueDecodeMultiplexTask sPool;
  private static final Object sPoolSync;
  private MessageQueueDecodeMultiplexTask next = null;
  
  static
  {
    mDispatcher = null;
    if (ImageManagerEnv.g().getDispatcher() != null)
    {
      mDispatcher = new MessageQueueDecodeMultiplexTask.ImageDecodeMultiplexHandler(ImageManagerEnv.g().getDispatcher());
    }
    else
    {
      HandlerThread localHandlerThread = new HandlerThread("ImageDecodeMultiplexThread");
      localHandlerThread.start();
      mDispatcher = new MessageQueueDecodeMultiplexTask.ImageDecodeMultiplexHandler(localHandlerThread.getLooper());
    }
    sPool = null;
    sPoolSync = new Object();
    mObjectPoolSize = 0;
    clearAndInitSize();
  }
  
  private MessageQueueDecodeMultiplexTask(ImageTask paramImageTask)
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
        MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask = new MessageQueueDecodeMultiplexTask(null);
        localMessageQueueDecodeMultiplexTask.next = sPool;
        sPool = localMessageQueueDecodeMultiplexTask;
        mObjectPoolSize += 1;
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private static MessageQueueDecodeMultiplexTask getNextSameDecodeImageTask(int paramInt)
  {
    LinkedList localLinkedList = (LinkedList)mDecodeImageTaskQueue.get(Integer.valueOf(paramInt));
    Object localObject = null;
    MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask = null;
    if (localLinkedList != null)
    {
      localObject = localMessageQueueDecodeMultiplexTask;
      while (localLinkedList.size() > 0)
      {
        localMessageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask)localLinkedList.removeFirst();
        localObject = localMessageQueueDecodeMultiplexTask;
        if (localMessageQueueDecodeMultiplexTask != null) {
          localObject = localMessageQueueDecodeMultiplexTask;
        }
      }
    }
    if (localObject == null) {
      mDecodeImageTaskQueue.remove(Integer.valueOf(paramInt));
    }
    return localObject;
  }
  
  private static boolean hasSameDecodeImageTask(MessageQueueDecodeMultiplexTask paramMessageQueueDecodeMultiplexTask)
  {
    if (paramMessageQueueDecodeMultiplexTask.getImageKey() == null) {
      return true;
    }
    int i = paramMessageQueueDecodeMultiplexTask.getImageKey().hashCodeEx();
    LinkedList localLinkedList = (LinkedList)mDecodeImageTaskQueue.get(Integer.valueOf(i));
    if (localLinkedList == null)
    {
      paramMessageQueueDecodeMultiplexTask = new LinkedList();
      mDecodeImageTaskQueue.put(Integer.valueOf(i), paramMessageQueueDecodeMultiplexTask);
      return false;
    }
    localLinkedList.addLast(paramMessageQueueDecodeMultiplexTask);
    return true;
  }
  
  public static MessageQueueDecodeMultiplexTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {
      synchronized (sPoolSync)
      {
        if (sPool != null)
        {
          MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask = sPool;
          sPool = sPool.next;
          localMessageQueueDecodeMultiplexTask.next = null;
          mObjectPoolSize -= 1;
          localMessageQueueDecodeMultiplexTask.setImageTask(paramImageTask);
          return localMessageQueueDecodeMultiplexTask;
        }
      }
    }
    return new MessageQueueDecodeMultiplexTask(paramImageTask);
  }
  
  private static List<MessageQueueDecodeMultiplexTask> removeSameDecodeImageTask(int paramInt)
  {
    return (List)mDecodeImageTaskQueue.remove(Integer.valueOf(paramInt));
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
    ImageTracer.end(getImageKey().url);
    if (paramInt != 8)
    {
      if (paramInt != 9)
      {
        if (paramInt != 11)
        {
          if (paramInt != 13)
          {
            setResult(paramInt, paramVarArgs);
            return;
          }
          paramVarArgs = mDispatcher.obtainMessage();
          paramVarArgs.what = 13;
          paramVarArgs.obj = new Object[] { this };
          paramVarArgs.sendToTarget();
          return;
        }
        localMessage = mDispatcher.obtainMessage();
        localMessage.what = 11;
        localMessage.obj = new Object[] { this, paramVarArgs[0] };
        localMessage.sendToTarget();
        return;
      }
      if (needRetry) {
        return;
      }
      paramVarArgs = mDispatcher.obtainMessage();
      paramVarArgs.what = 9;
      paramVarArgs.obj = new Object[] { this };
      paramVarArgs.sendToTarget();
      return;
    }
    Message localMessage = mDispatcher.obtainMessage();
    localMessage.what = 8;
    localMessage.obj = new Object[] { this, paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5] };
    localMessage.sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.MessageQueueDecodeMultiplexTask
 * JD-Core Version:    0.7.0.1
 */