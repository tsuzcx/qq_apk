package com.tencent.maxvideo.mediadevice;

import android.os.Handler;
import android.os.Message;

public class EncodeVideo
{
  private Handler mHandler;
  public String mReportMsg;
  
  public EncodeVideo(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public static native void cancelCurrentEncoder();
  
  private void doNotify(Message paramMessage)
  {
    if (this.mHandler != null) {}
    try
    {
      this.mHandler.sendMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private void notifyEncodeProgress(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    doNotify(localMessage);
  }
  
  public static native void setMosaicData(byte[] paramArrayOfByte, int paramInt);
  
  public void onEncodeProgressCallback(int paramInt)
  {
    notifyEncodeProgress(paramInt);
  }
  
  public void setReportMsg(String paramString)
  {
    this.mReportMsg = paramString;
  }
  
  public native int startEncode(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public native int startPartEncode(String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3, long paramLong4, String paramString3, String paramString4, int[] paramArrayOfInt);
  
  public native int startQQEncode(String paramString1, String paramString2, String paramString3, String paramString4, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.maxvideo.mediadevice.EncodeVideo
 * JD-Core Version:    0.7.0.1
 */