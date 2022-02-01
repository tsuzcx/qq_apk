package com.tencent.av.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.ArrayUtils;
import java.util.List;

public class AndroidCodecUtil
{
  public static boolean a = false;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  
  @RequiresApi(api=16)
  public static void a()
  {
    if (a) {
      return;
    }
    String[] arrayOfString = new String[2];
    int i = 0;
    arrayOfString[0] = "video/avc";
    arrayOfString[1] = "video/hevc";
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      a(str);
      b(str);
      i += 1;
    }
    a = true;
  }
  
  @RequiresApi(api=16)
  private static void a(String paramString)
  {
    Object localObject = AndroidCodec.getEndoderInfos(paramString);
    int k = 0;
    int j = 0;
    int i = 0;
    while (i < ((List)localObject).size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(i), paramString);
      if (localCodecCapabilities == null) {
        break;
      }
      if ((ArrayUtils.contains(localCodecCapabilities.colorFormats, 21)) || (ArrayUtils.contains(localCodecCapabilities.colorFormats, 19))) {
        break label89;
      }
      i += 1;
    }
    i = 0;
    label89:
    if (((List)localObject).size() == 0)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("NativeCodec", "getEndoderInfos list.size为0");
      }
      return;
    }
    localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(i), paramString);
    if (localObject != null)
    {
      if (paramString.contains("video/avc"))
      {
        i = j;
        while (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          paramString = new StringBuilder();
          paramString.append("AVC ENC caps: ");
          paramString.append(i);
          paramString.append(", profile: ");
          paramString.append(localObject.profileLevels[i].profile);
          paramString.append(", level:");
          paramString.append(localObject.profileLevels[i].level);
          AVCoreLog.d("NativeCodec", paramString.toString());
          j = localObject.profileLevels[i].profile;
          if (j != 1)
          {
            if (j == 8) {
              d = localObject.profileLevels[i].level;
            }
          }
          else {
            b = localObject.profileLevels[i].level;
          }
          i += 1;
        }
      }
      if (paramString.contains("video/hevc"))
      {
        i = k;
        while (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          paramString = new StringBuilder();
          paramString.append("HEVC ENC caps: ");
          paramString.append(i);
          paramString.append(", profile: ");
          paramString.append(localObject.profileLevels[i].profile);
          paramString.append(", level:");
          paramString.append(localObject.profileLevels[i].level);
          AVCoreLog.d("NativeCodec", paramString.toString());
          if (localObject.profileLevels[i].profile == 1)
          {
            f = localObject.profileLevels[i].level;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  @RequiresApi(api=16)
  private static void b(String paramString)
  {
    Object localObject = AndroidCodec.getDecoderInfos(paramString);
    if (((List)localObject).size() == 0)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("NativeCodec", "getDecoderInfos list.size为0");
      }
      return;
    }
    int j = 0;
    int i = 0;
    localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), paramString);
    if ((localObject != null) && (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels != null))
    {
      if (paramString.contains("video/avc")) {
        while (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          paramString = new StringBuilder();
          paramString.append("AVC DEC caps: ");
          paramString.append(i);
          paramString.append(", profile: ");
          paramString.append(localObject.profileLevels[i].profile);
          paramString.append(", level:");
          paramString.append(localObject.profileLevels[i].level);
          AVCoreLog.d("NativeCodec", paramString.toString());
          j = localObject.profileLevels[i].profile;
          if (j != 1)
          {
            if (j == 8) {
              e = localObject.profileLevels[i].level;
            }
          }
          else {
            c = localObject.profileLevels[i].level;
          }
          i += 1;
        }
      }
      if (paramString.contains("video/hevc"))
      {
        i = j;
        while (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          paramString = new StringBuilder();
          paramString.append("HEVC DEC caps: ");
          paramString.append(i);
          paramString.append(", profile: ");
          paramString.append(localObject.profileLevels[i].profile);
          paramString.append(", level:");
          paramString.append(localObject.profileLevels[i].level);
          AVCoreLog.d("NativeCodec", paramString.toString());
          if (localObject.profileLevels[i].profile == 1)
          {
            g = localObject.profileLevels[i].level;
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.mediacodec.AndroidCodecUtil
 * JD-Core Version:    0.7.0.1
 */