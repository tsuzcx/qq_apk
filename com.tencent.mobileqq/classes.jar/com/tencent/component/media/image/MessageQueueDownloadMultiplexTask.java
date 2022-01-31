package com.tencent.component.media.image;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.component.media.ImageManagerEnv;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import plz;
import pmc;

public class MessageQueueDownloadMultiplexTask
  extends plz
{
  private static int jdField_a_of_type_Int;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static MessageQueueDownloadMultiplexTask jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static boolean jdField_a_of_type_Boolean = false;
  private MessageQueueDownloadMultiplexTask b = null;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = null;
    HandlerThread localHandlerThread;
    if (ImageManagerEnv.g().getDispatcher() == null)
    {
      localHandlerThread = new HandlerThread("ImageDownloadMultiplexThread");
      localHandlerThread.start();
    }
    for (jdField_a_of_type_AndroidOsHandler = new pmc(localHandlerThread.getLooper());; jdField_a_of_type_AndroidOsHandler = new pmc(ImageManagerEnv.g().getDispatcher()))
    {
      jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask = null;
      jdField_a_of_type_JavaLangObject = new Object();
      jdField_a_of_type_Int = 0;
      clearAndInitSize();
      return;
    }
  }
  
  private MessageQueueDownloadMultiplexTask(plz paramplz)
  {
    super(paramplz);
  }
  
  private static List b(String paramString)
  {
    return (List)jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  private static boolean b(MessageQueueDownloadMultiplexTask paramMessageQueueDownloadMultiplexTask)
  {
    String str = paramMessageQueueDownloadMultiplexTask.getImageKey().urlKey;
    LinkedList localLinkedList = (LinkedList)jdField_a_of_type_JavaUtilHashMap.get(str);
    if (localLinkedList == null)
    {
      paramMessageQueueDownloadMultiplexTask = new LinkedList();
      jdField_a_of_type_JavaUtilHashMap.put(str, paramMessageQueueDownloadMultiplexTask);
      return false;
    }
    localLinkedList.addLast(paramMessageQueueDownloadMultiplexTask);
    return true;
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        MessageQueueDownloadMultiplexTask localMessageQueueDownloadMultiplexTask = new MessageQueueDownloadMultiplexTask(null);
        localMessageQueueDownloadMultiplexTask.b = jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask;
        jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask = localMessageQueueDownloadMultiplexTask;
        jdField_a_of_type_Int += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static MessageQueueDownloadMultiplexTask obtain(plz paramplz)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask != null)
      {
        MessageQueueDownloadMultiplexTask localMessageQueueDownloadMultiplexTask = jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask;
        jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask = jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask.b;
        localMessageQueueDownloadMultiplexTask.b = null;
        jdField_a_of_type_Int -= 1;
        localMessageQueueDownloadMultiplexTask.setImageTask(paramplz);
        return localMessageQueueDownloadMultiplexTask;
      }
      return new MessageQueueDownloadMultiplexTask(paramplz);
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
        } while (jdField_a_of_type_Boolean);
        localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
        localMessage.what = 0;
        localMessage.obj = new Object[] { this, paramVarArgs[0] };
        localMessage.sendToTarget();
        return;
      } while (jdField_a_of_type_Boolean);
      localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = new Object[] { this, paramVarArgs[0] };
      localMessage.sendToTarget();
      return;
    case 2: 
      localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 2;
      localMessage.obj = new Object[] { this, paramVarArgs[0], paramVarArgs[1], paramVarArgs[2] };
      localMessage.sendToTarget();
      return;
    case 11: 
      localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 11;
      localMessage.obj = new Object[] { this, paramVarArgs[0] };
      localMessage.sendToTarget();
      return;
    }
    paramVarArgs = jdField_a_of_type_AndroidOsHandler.obtainMessage();
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
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.b = jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask;
        jdField_a_of_type_ComTencentComponentMediaImageMessageQueueDownloadMultiplexTask = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.MessageQueueDownloadMultiplexTask
 * JD-Core Version:    0.7.0.1
 */