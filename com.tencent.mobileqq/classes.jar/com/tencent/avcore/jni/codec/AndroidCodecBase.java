package com.tencent.avcore.jni.codec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.util.AVCoreLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(api=16)
public abstract class AndroidCodecBase
  implements MediaCodecConstants
{
  public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    Object localObject = null;
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception localException)
    {
      do
      {
        paramMediaCodecInfo = localObject;
      } while (!AVCoreLog.isDevelopLevel());
      AVCoreLog.e("AndroidCodec", "getCodecCapabilities, Exception, mime[" + paramString + "]", localException);
    }
    return null;
  }
  
  public static MediaCodecInfo getCodecInfo(String paramString)
  {
    try
    {
      int j = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        boolean bool = localMediaCodecInfo.getName().equalsIgnoreCase(paramString);
        if (bool) {
          return localMediaCodecInfo;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString) {}
  }
  
  @SuppressLint({"NewApi"})
  public static List<MediaCodecInfo> getDecoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((!localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
  
  public static List<MediaCodecInfo> getEndoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
  
  public abstract BufferData dequeueDecoderOutputBuffer(long paramLong);
  
  public abstract BufferData dequeueOutputBuffer();
  
  public abstract void flush();
  
  public abstract BufferData getInputBuffer();
  
  public abstract ByteBuffer getInputBuffer(int paramInt);
  
  public abstract ByteBuffer getOutputBuffer(int paramInt);
  
  public abstract MediaFormat getOutputFormat(int paramInt);
  
  public abstract boolean init(MediaFormat paramMediaFormat, int paramInt, IMediaCodecCallback paramIMediaCodecCallback);
  
  public abstract boolean init(MediaFormat paramMediaFormat, String paramString, Surface paramSurface, IMediaCodecCallback paramIMediaCodecCallback);
  
  public abstract boolean init(MediaFormat paramMediaFormat, String paramString, IMediaCodecCallback paramIMediaCodecCallback);
  
  public abstract void queueInputBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3);
  
  public abstract void release();
  
  public abstract void releaseOutputBuffer(int paramInt);
  
  public abstract void reset();
  
  public abstract void setParameters(Bundle paramBundle);
  
  public abstract boolean start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.AndroidCodecBase
 * JD-Core Version:    0.7.0.1
 */