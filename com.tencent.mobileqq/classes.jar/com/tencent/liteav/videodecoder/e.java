package com.tencent.liteav.videodecoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;

public class e
{
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (a.a()) {
      return true;
    }
    return b(paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    MediaCodecList localMediaCodecList = new MediaCodecList(0);
    MediaCodecInfo[] arrayOfMediaCodecInfo = localMediaCodecList.getCodecInfos();
    int k = arrayOfMediaCodecInfo.length;
    int i = 0;
    boolean bool1 = false;
    boolean bool2;
    for (;;)
    {
      bool2 = true;
      if (i >= k) {
        break;
      }
      localObject1 = arrayOfMediaCodecInfo[i];
      Object localObject2 = ((MediaCodecInfo)localObject1).getSupportedTypes();
      if (((MediaCodecInfo)localObject1).isEncoder()) {}
      String str;
      label118:
      do
      {
        do
        {
          for (;;)
          {
            bool2 = bool1;
            break label226;
            int m = localObject2.length;
            int j = 0;
            while (j < m)
            {
              str = localObject2[j];
              if (str.contains("video/hevc")) {
                break label118;
              }
              j += 1;
            }
          }
          localObject2 = ((MediaCodecInfo)localObject1).getCapabilitiesForType(str);
        } while (localObject2 == null);
        localObject2 = ((MediaCodecInfo.CodecCapabilities)localObject2).getVideoCapabilities();
      } while (localObject2 == null);
      double d = paramInt3;
      bool2 = ((MediaCodecInfo.VideoCapabilities)localObject2).areSizeAndRateSupported(paramInt1, paramInt2, d);
      boolean bool3 = ((MediaCodecInfo.VideoCapabilities)localObject2).areSizeAndRateSupported(paramInt2, paramInt1, d);
      TXCLog.i("TXCVideoDecoderUtils", "got hevc decoder:%s, type:%s, supportPort= %b,supportLand=%b", new Object[] { ((MediaCodecInfo)localObject1).getName(), str, Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((bool3) && (bool2)) {
        bool2 = true;
      }
      label226:
      do
      {
        bool1 = bool2;
        break;
        localObject1 = null;
        if ((bool3) || (bool2)) {
          if (!bool3) {
            localObject1 = MediaFormat.createVideoFormat("video/hevc", paramInt2, paramInt1);
          } else if (!bool2) {
            localObject1 = MediaFormat.createVideoFormat("video/hevc", paramInt1, paramInt2);
          }
        }
        bool2 = bool1;
      } while (localObject1 == null);
      localObject1 = localMediaCodecList.findDecoderForFormat((MediaFormat)localObject1);
      TXCLog.i("TXCVideoDecoderUtils", "findDecoderForFormat hevc decodername:%s", new Object[] { localObject1 });
      if (localObject1 != null) {
        bool1 = true;
      }
      i += 1;
    }
    if ((!bool1) || (!c.a().l())) {
      bool2 = false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("config hevc decoder switch : ");
    ((StringBuilder)localObject1).append(bool2);
    ((StringBuilder)localObject1).append(" ,isSupport=");
    ((StringBuilder)localObject1).append(bool1);
    TXCLog.i("TXCVideoDecoderUtils", ((StringBuilder)localObject1).toString());
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.e
 * JD-Core Version:    0.7.0.1
 */