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
    int i = Build.VERSION.SDK_INT;
    boolean bool3 = false;
    boolean bool1;
    if (i >= 21)
    {
      MediaCodecList localMediaCodecList = new MediaCodecList(1);
      localObject1 = localMediaCodecList.getCodecInfos();
      int k = localObject1.length;
      i = 0;
      bool1 = false;
      while (i < k)
      {
        Object localObject3 = localObject1[i];
        Object localObject4 = localObject3.getSupportedTypes();
        Object localObject2;
        int m;
        int j;
        if (localObject3.isEncoder())
        {
          localObject2 = localObject1;
        }
        else
        {
          m = localObject4.length;
          j = 0;
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (j < m)
          {
            localObject2 = localObject4[j];
            if (((String)localObject2).contains("video/hevc"))
            {
              localObject4 = localObject3.getCapabilitiesForType((String)localObject2);
              if (localObject4 != null)
              {
                localObject4 = ((MediaCodecInfo.CodecCapabilities)localObject4).getVideoCapabilities();
                if (localObject4 != null)
                {
                  double d = paramInt3;
                  bool2 = ((MediaCodecInfo.VideoCapabilities)localObject4).areSizeAndRateSupported(paramInt1, paramInt2, d);
                  boolean bool4 = ((MediaCodecInfo.VideoCapabilities)localObject4).areSizeAndRateSupported(paramInt2, paramInt1, d);
                  TXCLog.i("TXCVideoDecoderUtils", "got hevc decoder:%s, type:%s, supportPort= %b,supportLand=%b", new Object[] { localObject3.getName(), localObject2, Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
                  if ((bool4) && (bool2)) {}
                  for (;;)
                  {
                    bool1 = true;
                    localObject3 = localObject1;
                    break;
                    localObject2 = null;
                    if ((bool4) || (bool2)) {
                      if (!bool4) {
                        localObject2 = MediaFormat.createVideoFormat("video/hevc", paramInt2, paramInt1);
                      } else if (!bool2) {
                        localObject2 = MediaFormat.createVideoFormat("video/hevc", paramInt1, paramInt2);
                      }
                    }
                    localObject3 = localObject1;
                    if (localObject2 == null) {
                      break;
                    }
                    localObject2 = localMediaCodecList.findDecoderForFormat((MediaFormat)localObject2);
                    TXCLog.i("TXCVideoDecoderUtils", "findDecoderForFormat hevc decodername:%s", new Object[] { localObject2 });
                    localObject3 = localObject1;
                    if (localObject2 == null) {
                      break;
                    }
                  }
                }
              }
              localObject2 = localObject1;
            }
          }
          else
          {
            localObject3 = localObject2;
            break;
          }
          j += 1;
        }
        i += 1;
        localObject1 = localObject3;
      }
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (bool1)
    {
      bool2 = bool3;
      if (c.a().k()) {
        bool2 = true;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.e
 * JD-Core Version:    0.7.0.1
 */