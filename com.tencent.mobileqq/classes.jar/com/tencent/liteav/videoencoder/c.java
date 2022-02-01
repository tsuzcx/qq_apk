package com.tencent.liteav.videoencoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;

public class c
{
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (2 == com.tencent.liteav.basic.d.c.a().d()) {
      if (com.tencent.liteav.basic.d.c.a().m())
      {
        if (com.tencent.liteav.basic.d.c.a().j())
        {
          if (b(paramInt1, paramInt2, paramInt3))
          {
            TXCLog.i("TXCVideoEncoderUtils", "config hevc switch on!");
            return true;
          }
        }
        else {
          TXCLog.w("TXCVideoEncoderUtils", "not support hevc encoder: in blacklist!");
        }
      }
      else {
        TXCLog.w("TXCVideoEncoderUtils", "local not support hevc encoder");
      }
    }
    return false;
  }
  
  private static boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      MediaCodecInfo[] arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
      int k = arrayOfMediaCodecInfo.length;
      int i = 0;
      while (i < k)
      {
        MediaCodecInfo localMediaCodecInfo = arrayOfMediaCodecInfo[i];
        if (localMediaCodecInfo.isEncoder())
        {
          Object localObject = localMediaCodecInfo.getSupportedTypes();
          int m = localObject.length;
          int j = 0;
          while (j < m)
          {
            String str = localObject[j];
            if (str.contains("video/hevc"))
            {
              localObject = localMediaCodecInfo.getCapabilitiesForType(str);
              if (localObject == null) {
                break;
              }
              localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getVideoCapabilities();
              if (localObject == null) {
                break;
              }
              double d = paramInt3;
              if ((!((MediaCodecInfo.VideoCapabilities)localObject).areSizeAndRateSupported(paramInt1, paramInt2, d)) || (!((MediaCodecInfo.VideoCapabilities)localObject).areSizeAndRateSupported(paramInt2, paramInt1, d))) {
                break;
              }
              TXCLog.i("TXCVideoEncoderUtils", "got hevc encoder:%s, type:%s", new Object[] { localMediaCodecInfo.getName(), str });
              return true;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    TXCLog.w("TXCVideoEncoderUtils", "not got hevc encoder");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.c
 * JD-Core Version:    0.7.0.1
 */