package com.tencent.ilivesdk.playview.codec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import com.tencent.qt.base.video.AVCEncoder;
import java.util.ArrayList;
import java.util.List;

public class SoftCodecUtils
{
  public static String AVC_CODEC_MIME = "video/avc";
  public static final int H_360_SUPPORT = 1920;
  public static final int W_360_SUPPORT = 3840;
  
  public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception paramMediaCodecInfo) {}
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public static List<MediaCodecInfo> getDecoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static long getPTS()
  {
    return AVCEncoder.native_getpts();
  }
  
  public static int i420clip(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    AVCEncoder.native_i420clipto(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3, paramInt4);
    return 0;
  }
  
  public static int i420toNv12(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte2 == null) {
      return -1;
    }
    AVCEncoder.native_i420tonv12(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
    return 0;
  }
  
  public static int i420toRgba(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte2 == null) {
      return -1;
    }
    AVCEncoder.native_i420torgba(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean isAVCDecSupport360Size()
  {
    boolean bool2 = false;
    List localList = getDecoderInfos(AVC_CODEC_MIME);
    int i = 0;
    boolean bool1 = bool2;
    if (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = getCodecCapabilities((MediaCodecInfo)localList.get(i), AVC_CODEC_MIME);
      if (localCodecCapabilities == null) {}
      while ((Build.VERSION.SDK_INT < 21) || (localCodecCapabilities.getVideoCapabilities() == null) || (!localCodecCapabilities.getVideoCapabilities().isSizeSupported(3840, 1920)))
      {
        i += 1;
        break;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public static int nv21clip(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    AVCEncoder.native_nv21clipto(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3, paramInt4);
    return 0;
  }
  
  public static int nv21toi420rotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return -1;
    }
    AVCEncoder.native_nv21toi420rotate(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4);
    return 0;
  }
  
  public static int setImageBeauty(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    AVCEncoder.native_setimagebeauty(paramArrayOfByte, paramInt);
    return 0;
  }
  
  public static int setImageClear(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    AVCEncoder.native_setimageclear(paramInt1, paramInt2, paramArrayOfByte);
    return 0;
  }
  
  public static int yv12tonv21(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return -1;
    }
    AVCEncoder.native_yv12tonv21(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.codec.SoftCodecUtils
 * JD-Core Version:    0.7.0.1
 */