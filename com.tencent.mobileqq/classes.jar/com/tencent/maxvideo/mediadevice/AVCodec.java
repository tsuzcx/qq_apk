package com.tencent.maxvideo.mediadevice;

import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.CommonThread;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.watermark.WatermarkInfo;
import com.tencent.maxvideo.watermark.WatermarkRecordInfo;
import java.util.ArrayList;
import java.util.List;

public class AVCodec
{
  private static final int MSG_PARAM_PROCESS_FRAME_WITH_CALLBACK = 16;
  private static final int MSG_PARAM_PROCESS_ONE_FRAME = 8;
  private static AVCodec instance = new AVCodec();
  public String TAG = getClass().getSimpleName();
  private List<AVCodecCallback> mCallbackList = new ArrayList();
  
  static
  {
    CommonThread.post(new Runnable()
    {
      public void run()
      {
        try
        {
          AVCodec.getCallbackMethods();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
      }
    });
  }
  
  private int callFunction(MessageStruct paramMessageStruct)
  {
    function(paramMessageStruct);
    return 1;
  }
  
  public static AVCodec get()
  {
    return instance;
  }
  
  public static native void getCallbackMethods();
  
  private void notifyAllCallback(MessageStruct paramMessageStruct)
  {
    for (;;)
    {
      int i;
      try
      {
        AVCodecCallback[] arrayOfAVCodecCallback = new AVCodecCallback[this.mCallbackList.size()];
        i = 0;
        int j = arrayOfAVCodecCallback.length;
        if (i >= j)
        {
          if (arrayOfAVCodecCallback != null)
          {
            j = arrayOfAVCodecCallback.length;
            i = 0;
            if (i < j) {
              break label75;
            }
          }
        }
        else
        {
          arrayOfAVCodecCallback[i] = ((AVCodecCallback)this.mCallbackList.get(i));
          i += 1;
          continue;
        }
        localAVCodecCallback = arrayOfAVCodecCallback[i];
      }
      finally {}
      label75:
      AVCodecCallback localAVCodecCallback;
      localAVCodecCallback.onAVCodecEvent(localAVCodecCallback, paramMessageStruct);
      i += 1;
    }
  }
  
  /* Error */
  public boolean addCodecCallback(AVCodecCallback paramAVCodecCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/maxvideo/mediadevice/AVCodec:mCallbackList	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 83 2 0
    //   12: ifne +20 -> 32
    //   15: aload_0
    //   16: getfield 54	com/tencent/maxvideo/mediadevice/AVCodec:mCallbackList	Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface 86 2 0
    //   25: pop
    //   26: iconst_1
    //   27: istore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -6 -> 28
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	AVCodec
    //   0	42	1	paramAVCodecCallback	AVCodecCallback
    //   27	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	26	37	finally
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/maxvideo/mediadevice/AVCodec:mCallbackList	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 54	com/tencent/maxvideo/mediadevice/AVCodec:mCallbackList	Ljava/util/List;
    //   18: invokeinterface 89 1 0
    //   23: goto -12 -> 11
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	AVCodec
    //   6	2	1	localList	List
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public int copyBuf(byte[] paramArrayOfByte, AVIOStruct paramAVIOStruct)
  {
    MessageStruct localMessageStruct = new MessageStruct(33554442);
    localMessageStruct.mObj0 = paramArrayOfByte;
    localMessageStruct.mObj1 = paramAVIOStruct;
    return callFunction(localMessageStruct);
  }
  
  public int copyQQBuf(byte[] paramArrayOfByte, AVIOStruct paramAVIOStruct)
  {
    MessageStruct localMessageStruct = new MessageStruct(33554474);
    localMessageStruct.mObj0 = paramArrayOfByte;
    localMessageStruct.mObj1 = paramAVIOStruct;
    return callFunction(localMessageStruct);
  }
  
  public int deleteDraft()
  {
    return callFunction(new MessageStruct(33554439));
  }
  
  public int encode(String paramString)
  {
    MessageStruct localMessageStruct = new MessageStruct(50331649);
    localMessageStruct.mObj0 = paramString;
    return callFunction(localMessageStruct);
  }
  
  public int encodeCancel(String paramString)
  {
    MessageStruct localMessageStruct = new MessageStruct(50331654);
    localMessageStruct.mObj0 = paramString;
    return callFunction(localMessageStruct);
  }
  
  public native int function(MessageStruct paramMessageStruct);
  
  public int getWatermarkFrame(WatermarkInfo paramWatermarkInfo, int paramInt)
  {
    if (paramWatermarkInfo == null) {
      return -1;
    }
    MessageStruct localMessageStruct = new MessageStruct(83886082);
    localMessageStruct.mObj0 = paramWatermarkInfo.mDir;
    localMessageStruct.mParam0 = paramInt;
    return callFunction(localMessageStruct);
  }
  
  public int handleAudio(byte[] paramArrayOfByte, AVIOStruct paramAVIOStruct, int paramInt)
  {
    MessageStruct localMessageStruct = new MessageStruct(33554437);
    localMessageStruct.mObj0 = paramArrayOfByte;
    localMessageStruct.mObj1 = paramAVIOStruct;
    localMessageStruct.mParam0 = paramInt;
    return callFunction(localMessageStruct);
  }
  
  public int handleQQVideo()
  {
    return callFunction(new MessageStruct(33554475));
  }
  
  public int handleQQVideoFrameWithCallback()
  {
    MessageStruct localMessageStruct = new MessageStruct(33554475);
    localMessageStruct.mParam0 = 16;
    return callFunction(localMessageStruct);
  }
  
  public int handleQQVideoOneFrame()
  {
    MessageStruct localMessageStruct = new MessageStruct(33554475);
    localMessageStruct.mParam0 = 8;
    return callFunction(localMessageStruct);
  }
  
  public int handleVideo(byte[] paramArrayOfByte, AVIOStruct paramAVIOStruct)
  {
    MessageStruct localMessageStruct = new MessageStruct(33554438);
    localMessageStruct.mObj0 = paramArrayOfByte;
    localMessageStruct.mObj1 = paramAVIOStruct;
    return callFunction(localMessageStruct);
  }
  
  public int init()
  {
    return callFunction(new MessageStruct(33554433));
  }
  
  public int onNativieCallback(MessageStruct paramMessageStruct)
  {
    notifyAllCallback(paramMessageStruct);
    return 0;
  }
  
  public int recordEnd(String paramString)
  {
    MessageStruct localMessageStruct = new MessageStruct(33554434);
    localMessageStruct.mObj0 = paramString;
    return callFunction(localMessageStruct);
  }
  
  public int recordSubmit()
  {
    return callFunction(new MessageStruct(33554443));
  }
  
  public void recycle()
  {
    clear();
  }
  
  /* Error */
  public boolean removeCodecCallback(AVCodecCallback paramAVCodecCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/maxvideo/mediadevice/AVCodec:mCallbackList	Ljava/util/List;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 54	com/tencent/maxvideo/mediadevice/AVCodec:mCallbackList	Ljava/util/List;
    //   21: aload_1
    //   22: invokeinterface 150 2 0
    //   27: istore_2
    //   28: goto -15 -> 13
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	AVCodec
    //   0	36	1	paramAVCodecCallback	AVCodecCallback
    //   12	16	2	bool	boolean
    //   6	2	3	localList	List
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   17	28	31	finally
  }
  
  public int removeLastCapture()
  {
    return callFunction(new MessageStruct(33554450));
  }
  
  public int retake()
  {
    return callFunction(new MessageStruct(33554441));
  }
  
  public int saveDraft()
  {
    return callFunction(new MessageStruct(33554440));
  }
  
  public int startCapture()
  {
    return callFunction(new MessageStruct(33554448));
  }
  
  public int stopCapture()
  {
    return callFunction(new MessageStruct(33554449));
  }
  
  public int updateWatermarkList(List<WatermarkRecordInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return -1;
    }
    MessageStruct localMessageStruct = new MessageStruct(83886081);
    localMessageStruct.mObj0 = WatermarkRecordInfo.getJson(paramList);
    return callFunction(localMessageStruct);
  }
  
  public static abstract interface AVCodecCallback
  {
    public abstract void onAVCodecEvent(AVCodecCallback paramAVCodecCallback, MessageStruct paramMessageStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.maxvideo.mediadevice.AVCodec
 * JD-Core Version:    0.7.0.1
 */