package com.tencent.component.media.image;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.component.media.ImageManagerEnv;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import plz;
import pmb;

public class MessageQueueDecodeMultiplexTask
  extends plz
{
  private static int jdField_a_of_type_Int;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static MessageQueueDecodeMultiplexTask jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static boolean jdField_a_of_type_Boolean = false;
  private MessageQueueDecodeMultiplexTask b = null;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = null;
    if (ImageManagerEnv.g().getDispatcher() != null) {}
    HandlerThread localHandlerThread;
    for (jdField_a_of_type_AndroidOsHandler = new pmb(ImageManagerEnv.g().getDispatcher());; jdField_a_of_type_AndroidOsHandler = new pmb(localHandlerThread.getLooper()))
    {
      jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask = null;
      jdField_a_of_type_JavaLangObject = new Object();
      jdField_a_of_type_Int = 0;
      clearAndInitSize();
      return;
      localHandlerThread = new HandlerThread("ImageDecodeMultiplexThread");
      localHandlerThread.start();
    }
  }
  
  private MessageQueueDecodeMultiplexTask(plz paramplz)
  {
    super(paramplz);
  }
  
  private static List b(int paramInt)
  {
    return (List)jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
  }
  
  private static boolean b(MessageQueueDecodeMultiplexTask paramMessageQueueDecodeMultiplexTask)
  {
    if (paramMessageQueueDecodeMultiplexTask.getImageKey() == null) {
      return true;
    }
    int i = paramMessageQueueDecodeMultiplexTask.getImageKey().hashCodeEx();
    LinkedList localLinkedList = (LinkedList)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    if (localLinkedList == null)
    {
      paramMessageQueueDecodeMultiplexTask = new LinkedList();
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramMessageQueueDecodeMultiplexTask);
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      localLinkedList.addLast(paramMessageQueueDecodeMultiplexTask);
    }
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask = new MessageQueueDecodeMultiplexTask(null);
        localMessageQueueDecodeMultiplexTask.b = jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask;
        jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask = localMessageQueueDecodeMultiplexTask;
        jdField_a_of_type_Int += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static MessageQueueDecodeMultiplexTask obtain(plz paramplz)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask != null)
      {
        MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask = jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask;
        jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask = jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask.b;
        localMessageQueueDecodeMultiplexTask.b = null;
        jdField_a_of_type_Int -= 1;
        localMessageQueueDecodeMultiplexTask.setImageTask(paramplz);
        return localMessageQueueDecodeMultiplexTask;
      }
      return new MessageQueueDecodeMultiplexTask(paramplz);
    }
  }
  
  public void excuteTask()
  {
    Message localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1000;
    localMessage.obj = this;
    localMessage.sendToTarget();
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    ImageTracer.end(getImageKey().url);
    switch (paramInt)
    {
    case 10: 
    case 12: 
    default: 
      setResult(paramInt, paramVarArgs);
    }
    do
    {
      return;
      paramVarArgs = jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramVarArgs.what = 13;
      paramVarArgs.obj = new Object[] { this };
      paramVarArgs.sendToTarget();
      return;
      Message localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 11;
      localMessage.obj = new Object[] { this, paramVarArgs[0] };
      localMessage.sendToTarget();
      return;
      localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 8;
      localMessage.obj = new Object[] { this, paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5] };
      localMessage.sendToTarget();
      return;
    } while (jdField_a_of_type_Boolean);
    paramVarArgs = jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramVarArgs.what = 9;
    paramVarArgs.obj = new Object[] { this };
    paramVarArgs.sendToTarget();
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.b = jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask;
        jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDecodeMultiplexTask = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.MessageQueueDecodeMultiplexTask
 * JD-Core Version:    0.7.0.1
 */