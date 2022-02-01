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
  private List<AVCodec.AVCodecCallback> mCallbackList = new ArrayList();
  
  static
  {
    CommonThread.post(new AVCodec.1());
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
    try
    {
      AVCodec.AVCodecCallback[] arrayOfAVCodecCallback = new AVCodec.AVCodecCallback[this.mCallbackList.size()];
      int k = arrayOfAVCodecCallback.length;
      int j = 0;
      int i = 0;
      for (;;)
      {
        if (i >= k)
        {
          k = arrayOfAVCodecCallback.length;
          i = j;
          for (;;)
          {
            if (i >= k) {
              return;
            }
            AVCodec.AVCodecCallback localAVCodecCallback = arrayOfAVCodecCallback[i];
            localAVCodecCallback.onAVCodecEvent(localAVCodecCallback, paramMessageStruct);
            i += 1;
          }
        }
        arrayOfAVCodecCallback[i] = ((AVCodec.AVCodecCallback)this.mCallbackList.get(i));
        i += 1;
      }
      throw paramMessageStruct;
    }
    finally {}
    for (;;) {}
  }
  
  public boolean addCodecCallback(AVCodec.AVCodecCallback paramAVCodecCallback)
  {
    try
    {
      if (!this.mCallbackList.contains(paramAVCodecCallback))
      {
        this.mCallbackList.add(paramAVCodecCallback);
        return true;
      }
      return false;
    }
    finally
    {
      paramAVCodecCallback = finally;
      throw paramAVCodecCallback;
    }
  }
  
  public void clear()
  {
    try
    {
      List localList = this.mCallbackList;
      if (localList == null) {
        return;
      }
      this.mCallbackList.clear();
      return;
    }
    finally {}
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
  
  public boolean removeCodecCallback(AVCodec.AVCodecCallback paramAVCodecCallback)
  {
    try
    {
      List localList = this.mCallbackList;
      if (localList == null) {
        return false;
      }
      boolean bool = this.mCallbackList.remove(paramAVCodecCallback);
      return bool;
    }
    finally {}
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
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      MessageStruct localMessageStruct = new MessageStruct(83886081);
      localMessageStruct.mObj0 = WatermarkRecordInfo.getJson(paramList);
      return callFunction(localMessageStruct);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.maxvideo.mediadevice.AVCodec
 * JD-Core Version:    0.7.0.1
 */