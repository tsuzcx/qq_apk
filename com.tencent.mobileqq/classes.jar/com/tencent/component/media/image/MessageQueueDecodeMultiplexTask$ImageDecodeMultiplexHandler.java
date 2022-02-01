package com.tencent.component.media.image;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.Iterator;
import java.util.List;

class MessageQueueDecodeMultiplexTask$ImageDecodeMultiplexHandler
  extends Handler
{
  public MessageQueueDecodeMultiplexTask$ImageDecodeMultiplexHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    Object localObject2;
    MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask;
    if (i != 8)
    {
      if (i != 9)
      {
        if (i != 11)
        {
          if (i != 13)
          {
            if (i != 1000) {
              return;
            }
            paramMessage = (MessageQueueDecodeMultiplexTask)paramMessage.obj;
            if (!MessageQueueDecodeMultiplexTask.access$000(paramMessage))
            {
              ImageManager.getInstance().imageKeyFilePathCheck(paramMessage.getImageKey());
              if (paramMessage.getNextTask() != null)
              {
                ImageTracer.start(paramMessage.getImageKey().url);
                paramMessage.getNextTask().excuteTask();
                return;
              }
              localObject1 = paramMessage.getImageKey();
              if ((localObject1 != null) && (((ImageKey)localObject1).options != null)) {
                ((ImageKey)localObject1).options.errCode = ImageManager.getErrorString((ImageKey)localObject1, 700);
              }
              paramMessage.setResult(9, new Object[0]);
            }
          }
          else
          {
            paramMessage = (MessageQueueDecodeMultiplexTask)((Object[])(Object[])paramMessage.obj)[0];
            if (paramMessage != null)
            {
              if (paramMessage.getImageKey() == null) {
                return;
              }
              localObject1 = MessageQueueDecodeMultiplexTask.access$100(paramMessage.getImageKey().hashCodeEx());
              if (localObject1 != null)
              {
                localObject1 = ((List)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (MessageQueueDecodeMultiplexTask)((Iterator)localObject1).next();
                  if ((localObject2 != null) && (((MessageQueueDecodeMultiplexTask)localObject2).isCanceled()))
                  {
                    ((MessageQueueDecodeMultiplexTask)localObject2).setResult(13, new Object[0]);
                  }
                  else if ((localObject2 != null) && (!((MessageQueueDecodeMultiplexTask)localObject2).isCanceled()) && (!MessageQueueDecodeMultiplexTask.access$000((MessageQueueDecodeMultiplexTask)localObject2)))
                  {
                    ImageManager.getInstance().imageKeyFilePathCheck(((MessageQueueDecodeMultiplexTask)localObject2).getImageKey());
                    if (((MessageQueueDecodeMultiplexTask)localObject2).getNextTask() != null)
                    {
                      ImageTracer.start(((MessageQueueDecodeMultiplexTask)localObject2).getImageKey().url);
                      ((MessageQueueDecodeMultiplexTask)localObject2).getNextTask().excuteTask();
                    }
                    else
                    {
                      ((MessageQueueDecodeMultiplexTask)localObject2).setResult(9, new Object[0]);
                    }
                  }
                }
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("decode cancel, url = ");
              ((StringBuilder)localObject1).append(paramMessage.getImageKey().url);
              ImageManagerLog.d("MessageQueueDecodeMultiplexTask", ((StringBuilder)localObject1).toString());
            }
          }
        }
        else
        {
          paramMessage = (Object[])paramMessage.obj;
          localObject1 = (MessageQueueDecodeMultiplexTask)paramMessage[0];
          localObject2 = MessageQueueDecodeMultiplexTask.access$100(((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().hashCodeEx());
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localMessageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask)((Iterator)localObject2).next();
              if (localMessageQueueDecodeMultiplexTask != null) {
                localMessageQueueDecodeMultiplexTask.setResult(11, new Object[] { paramMessage[1] });
              }
            }
          }
          ((MessageQueueDecodeMultiplexTask)localObject1).setResult(11, new Object[] { paramMessage[1] });
        }
      }
      else
      {
        paramMessage = (MessageQueueDecodeMultiplexTask)((Object[])(Object[])paramMessage.obj)[0];
        if ((paramMessage != null) && (paramMessage.getImageKey() != null))
        {
          ProgressTracer.print(1002, paramMessage.getImageKey().url);
          localObject1 = MessageQueueDecodeMultiplexTask.access$100(paramMessage.getImageKey().hashCodeEx());
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageQueueDecodeMultiplexTask)((Iterator)localObject1).next();
              if (localObject2 != null) {
                ((MessageQueueDecodeMultiplexTask)localObject2).setResult(9, new Object[0]);
              }
            }
          }
        }
        paramMessage.setResult(9, new Object[0]);
      }
    }
    else
    {
      paramMessage = (Object[])paramMessage.obj;
      localObject1 = (MessageQueueDecodeMultiplexTask)paramMessage[0];
      if (localObject1 != null)
      {
        if (((MessageQueueDecodeMultiplexTask)localObject1).getImageKey() == null) {
          return;
        }
        ProgressTracer.print(4, ((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().urlKey);
        localObject2 = MessageQueueDecodeMultiplexTask.access$100(((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().hashCodeEx());
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localMessageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask)((Iterator)localObject2).next();
            if (localMessageQueueDecodeMultiplexTask != null) {
              localMessageQueueDecodeMultiplexTask.setResult(8, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3], paramMessage[4], paramMessage[5], paramMessage[6] });
            }
          }
        }
        ((MessageQueueDecodeMultiplexTask)localObject1).setResult(8, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3], paramMessage[4], paramMessage[5], paramMessage[6] });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.MessageQueueDecodeMultiplexTask.ImageDecodeMultiplexHandler
 * JD-Core Version:    0.7.0.1
 */