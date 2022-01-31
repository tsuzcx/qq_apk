package com.tencent.common;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Log;
import java.io.FileOutputStream;

public class Mp4Decoder
{
  private static final String TAG = Mp4Decoder.class.getSimpleName();
  private byte[] framebuffer;
  private int height;
  private long mHandler;
  private int width;
  
  static
  {
    System.loadLibrary("getframe");
  }
  
  public Mp4Decoder(String paramString)
  {
    int[] arrayOfInt = new int[2];
    this.mHandler = initDecoder(paramString, arrayOfInt);
    this.width = arrayOfInt[0];
    this.height = arrayOfInt[1];
    this.framebuffer = new byte[this.width * this.height * 3 / 2];
    Log.i(TAG, "init MP4 Decoder: width =  " + this.width + ", height = " + this.height);
  }
  
  public static native int getFrameAtTime(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public static native long initDecoder(String paramString, int[] paramArrayOfInt);
  
  public static native int releaseDecoder(long paramLong);
  
  public int getJpegFrameAtTime(String paramString, int paramInt)
  {
    getFrameAtTime(this.mHandler, this.framebuffer, paramInt);
    try
    {
      paramString = new FileOutputStream(paramString);
      new YuvImage(this.framebuffer, 17, this.width, this.height, null).compressToJpeg(new Rect(0, 0, this.width, this.height), 90, paramString);
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public void release()
  {
    releaseDecoder(this.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.Mp4Decoder
 * JD-Core Version:    0.7.0.1
 */