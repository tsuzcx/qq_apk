package com.tencent.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class VideoPngDecoder
{
  private static final String TAG = VideoPngDecoder.class.getSimpleName();
  private Bitmap bitmap;
  private int[] colorbuffer;
  private int height;
  private long mHandler;
  private int mRet;
  private char[] rgbBuffer;
  private int width;
  
  static
  {
    System.loadLibrary("getframe");
  }
  
  public VideoPngDecoder(String paramString)
  {
    int[] arrayOfInt = new int[2];
    this.mHandler = initDecoder(paramString, arrayOfInt);
    this.width = arrayOfInt[0];
    this.height = (arrayOfInt[1] / 2);
    this.colorbuffer = new int[this.width * this.height];
    this.rgbBuffer = new char[this.width * this.height * 2 * 3];
    Log.i(TAG, "init video rgba decoder: width =  " + this.width + ", height = " + this.height);
  }
  
  public static native int getNextArgbFrame(long paramLong, int[] paramArrayOfInt);
  
  public static native int getNextRgbFrame(long paramLong, char[] paramArrayOfChar);
  
  public static native long initDecoder(String paramString, int[] paramArrayOfInt);
  
  public static native int releaseDecoder(long paramLong);
  
  public Bitmap getNextBitmap(int paramInt)
  {
    Bitmap localBitmap2 = null;
    this.mRet = getNextArgbFrame(this.mHandler, this.colorbuffer);
    Bitmap localBitmap1 = localBitmap2;
    try
    {
      Bitmap localBitmap3 = Bitmap.createBitmap(this.colorbuffer, this.width, this.height, Bitmap.Config.ARGB_8888);
      localBitmap1 = localBitmap2;
      localBitmap2 = Bitmap.createScaledBitmap(localBitmap3, this.width / paramInt, this.height / paramInt, true);
      if (localBitmap2 != localBitmap3)
      {
        localBitmap1 = localBitmap2;
        localBitmap3.recycle();
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return localBitmap1;
  }
  
  public int getNextPngFrame(List<String> paramList)
  {
    int i;
    if (paramList == null)
    {
      i = 0;
      return i;
    }
    int j = getNextArgbFrame(this.mHandler, this.colorbuffer);
    paramList = paramList.iterator();
    for (;;)
    {
      i = j;
      if (!paramList.hasNext()) {
        break;
      }
      Object localObject = (String)paramList.next();
      try
      {
        this.bitmap = Bitmap.createBitmap(this.colorbuffer, this.width, this.height, Bitmap.Config.ARGB_8888);
        localObject = new FileOutputStream((String)localObject);
        this.bitmap.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)localObject);
        this.bitmap.recycle();
        ((OutputStream)localObject).close();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int getNextRGBFrame(List<String> paramList)
  {
    int i;
    if (paramList == null)
    {
      i = 0;
      return i;
    }
    int j = getNextRgbFrame(this.mHandler, this.rgbBuffer);
    paramList = paramList.iterator();
    for (;;)
    {
      i = j;
      if (!paramList.hasNext()) {
        break;
      }
      String str = (String)paramList.next();
    }
  }
  
  public boolean isDecodeFinish()
  {
    return this.mRet != 0;
  }
  
  public void release()
  {
    releaseDecoder(this.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.VideoPngDecoder
 * JD-Core Version:    0.7.0.1
 */