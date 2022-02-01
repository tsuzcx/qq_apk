package com.tencent.component.media.image;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

class MessageQueueDownloadMultiplexTask$ImageDownloadMultiplexHandler
  extends Handler
{
  public MessageQueueDownloadMultiplexTask$ImageDownloadMultiplexHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2;
    ImageTask localImageTask;
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          paramMessage = (MessageQueueDownloadMultiplexTask)paramMessage.obj;
        } while (MessageQueueDownloadMultiplexTask.access$000(paramMessage));
        if (paramMessage.getNextTask() != null)
        {
          if (!paramMessage.getImageKey().needDecode()) {
            ImageTracer.start(paramMessage.getImageKey().url);
          }
          paramMessage.getNextTask().excuteTask();
          return;
        }
        paramMessage.setResult(1, new Object[] { paramMessage.getImageKey().url });
        return;
        paramMessage = (Object[])paramMessage.obj;
        localObject1 = (MessageQueueDownloadMultiplexTask)paramMessage[0];
        localObject2 = MessageQueueDownloadMultiplexTask.access$100(((MessageQueueDownloadMultiplexTask)localObject1).getImageKey().urlKey);
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localImageTask = (ImageTask)((Iterator)localObject2).next();
            if (localImageTask != null) {
              localImageTask.setResult(0, new Object[] { paramMessage[1] });
            }
          }
        }
        ((MessageQueueDownloadMultiplexTask)localObject1).setResult(0, new Object[] { paramMessage[1] });
        return;
        paramMessage = (Object[])paramMessage.obj;
        localObject1 = (MessageQueueDownloadMultiplexTask)paramMessage[0];
        localObject2 = MessageQueueDownloadMultiplexTask.access$100(((MessageQueueDownloadMultiplexTask)localObject1).getImageKey().urlKey);
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localImageTask = (ImageTask)((Iterator)localObject2).next();
            if (localImageTask != null) {
              localImageTask.setResult(1, new Object[] { paramMessage[1] });
            }
          }
        }
        ((MessageQueueDownloadMultiplexTask)localObject1).setResult(1, new Object[] { paramMessage[1] });
        return;
        paramMessage = (Object[])paramMessage.obj;
        localObject1 = (MessageQueueDownloadMultiplexTask)paramMessage[0];
      } while ((localObject1 == null) || (((MessageQueueDownloadMultiplexTask)localObject1).getImageKey() == null));
      localObject2 = MessageQueueDownloadMultiplexTask.access$100(((MessageQueueDownloadMultiplexTask)localObject1).getImageKey().urlKey);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localImageTask = (ImageTask)((Iterator)localObject2).next();
          if (localImageTask != null) {
            localImageTask.setResult(2, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3] });
          }
        }
      }
      ((MessageQueueDownloadMultiplexTask)localObject1).setResult(2, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3] });
      return;
    case 11: 
      paramMessage = (Object[])paramMessage.obj;
      localObject1 = (MessageQueueDownloadMultiplexTask)paramMessage[0];
      localObject2 = MessageQueueDownloadMultiplexTask.access$100(((MessageQueueDownloadMultiplexTask)localObject1).getImageKey().urlKey);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localImageTask = (ImageTask)((Iterator)localObject2).next();
          if (localImageTask != null) {
            localImageTask.setResult(11, new Object[] { paramMessage[1] });
          }
        }
      }
      ((MessageQueueDownloadMultiplexTask)localObject1).setResult(11, new Object[] { paramMessage[1] });
      return;
    }
    paramMessage = (MessageQueueDownloadMultiplexTask)((Object[])(Object[])paramMessage.obj)[0];
    Object localObject1 = MessageQueueDownloadMultiplexTask.access$100(paramMessage.getImageKey().urlKey);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ImageTask)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ImageTask)localObject2).setResult(12, new Object[0]);
        }
      }
    }
    paramMessage.setResult(12, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.MessageQueueDownloadMultiplexTask.ImageDownloadMultiplexHandler
 * JD-Core Version:    0.7.0.1
 */