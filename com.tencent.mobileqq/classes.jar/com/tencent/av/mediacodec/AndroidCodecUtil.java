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
  public static int a;
  public static boolean a;
  public static int b = 0;
  public static int c = 0;
  public static int d = 0;
  public static int e = 0;
  public static int f = 0;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
  }
  
  @RequiresApi(api=16)
  public static void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "video/avc";
    arrayOfString[1] = "video/hevc";
    int m = arrayOfString.length;
    int k = 0;
    String str;
    Object localObject;
    int i;
    label51:
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    int j;
    if (k < m)
    {
      str = arrayOfString[k];
      localObject = AndroidCodec.getEndoderInfos(str);
      i = 0;
      if (i >= ((List)localObject).size()) {
        break label790;
      }
      localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(i), str);
      if (localCodecCapabilities != null) {
        break label115;
      }
      j = 0;
    }
    for (;;)
    {
      if (((List)localObject).size() == 0)
      {
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.e("NativeCodec", "getEndoderInfos list.size为0");
        }
        jdField_a_of_type_Boolean = true;
        return;
        label115:
        j = i;
        if (ArrayUtils.contains(localCodecCapabilities.colorFormats, 21)) {
          continue;
        }
        j = i;
        if (ArrayUtils.contains(localCodecCapabilities.colorFormats, 19)) {
          continue;
        }
        i += 1;
        break label51;
      }
      localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(j), str);
      if (localObject != null) {
        if (str.contains("video/avc"))
        {
          i = 0;
          if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
          {
            AVCoreLog.d("NativeCodec", "AVC ENC caps: " + i + ", profile: " + localObject.profileLevels[i].profile + ", level:" + localObject.profileLevels[i].level);
            switch (localObject.profileLevels[i].profile)
            {
            }
            for (;;)
            {
              i += 1;
              break;
              jdField_a_of_type_Int = localObject.profileLevels[i].level;
              continue;
              c = localObject.profileLevels[i].level;
            }
          }
        }
        else if (str.contains("video/hevc"))
        {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          AVCoreLog.d("NativeCodec", "HEVC ENC caps: " + i + ", profile: " + localObject.profileLevels[i].profile + ", level:" + localObject.profileLevels[i].level);
          if (localObject.profileLevels[i].profile == 1) {
            e = localObject.profileLevels[i].level;
          }
        }
        else
        {
          localObject = AndroidCodec.getDecoderInfos(str);
          if (((List)localObject).size() != 0) {
            break label480;
          }
          if (!AVCoreLog.isColorLevel()) {
            break;
          }
          AVCoreLog.e("NativeCodec", "getDecoderInfos list.size为0");
          break;
        }
        i += 1;
      }
      label480:
      localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), str);
      if ((localObject != null) && (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels != null)) {
        if (str.contains("video/avc"))
        {
          i = 0;
          if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
          {
            AVCoreLog.d("NativeCodec", "AVC DEC caps: " + i + ", profile: " + localObject.profileLevels[i].profile + ", level:" + localObject.profileLevels[i].level);
            switch (localObject.profileLevels[i].profile)
            {
            }
            for (;;)
            {
              i += 1;
              break;
              b = localObject.profileLevels[i].level;
              continue;
              d = localObject.profileLevels[i].level;
            }
          }
        }
        else if (str.contains("video/hevc"))
        {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          AVCoreLog.d("NativeCodec", "HEVC DEC caps: " + i + ", profile: " + localObject.profileLevels[i].profile + ", level:" + localObject.profileLevels[i].level);
          if (localObject.profileLevels[i].profile == 1) {
            f = localObject.profileLevels[i].level;
          }
        }
        else
        {
          k += 1;
          break;
        }
        i += 1;
      }
      label790:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.mediacodec.AndroidCodecUtil
 * JD-Core Version:    0.7.0.1
 */