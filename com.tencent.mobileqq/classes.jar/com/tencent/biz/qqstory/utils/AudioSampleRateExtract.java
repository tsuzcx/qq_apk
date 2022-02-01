package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.tencent.mobileqq.shortvideo.util.AudioResample;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

@TargetApi(16)
public class AudioSampleRateExtract
{
  private static final int[] a = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350, 0, 0, 0 };
  
  public static int a(MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat == null) {
      return -1;
    }
    ByteBuffer localByteBuffer = paramMediaFormat.getByteBuffer("csd-0");
    if (localByteBuffer.remaining() <= 2) {
      return paramMediaFormat.getInteger("sample-rate");
    }
    int i = localByteBuffer.remaining();
    int j = localByteBuffer.position();
    byte[] arrayOfByte = new byte[i];
    localByteBuffer.get(arrayOfByte);
    localByteBuffer.position(j);
    localByteBuffer.limit(j + i);
    i = (arrayOfByte.length - 2) * 8;
    if (i > 11) {
      if (((arrayOfByte[2] & 0xFF) << 3 | (arrayOfByte[3] & 0xFF) >>> 5) == 695)
      {
        if (((arrayOfByte[3] & 0x1F) == 5) && (i - 16 > 0) && ((arrayOfByte[4] & 0xFF) >>> 7 == 1))
        {
          i = (arrayOfByte[4] & 0x7F) >>> 3;
          if (i < 13) {
            return a[i];
          }
          return paramMediaFormat.getInteger("sample-rate");
        }
      }
      else if (((arrayOfByte[1] & 0x7) << 8 | arrayOfByte[2] & 0xFF) == 520) {
        return a[4];
      }
    }
    return paramMediaFormat.getInteger("sample-rate");
  }
  
  public static int a(MediaFormat paramMediaFormat, String paramString)
  {
    if (paramMediaFormat == null) {
      return -1;
    }
    int j = paramMediaFormat.getInteger("channel-count");
    try
    {
      i = AudioResample.parseMp4Info(paramString);
    }
    catch (UnsatisfiedLinkError paramMediaFormat)
    {
      int i;
      label21:
      break label21;
    }
    i = -2000;
    if (QLog.isColorLevel())
    {
      paramMediaFormat = new StringBuilder();
      paramMediaFormat.append("getRealAudioChannel:  channels=");
      paramMediaFormat.append(i);
      paramMediaFormat.append(" channelsBake: ");
      paramMediaFormat.append(j);
      QLog.d("SegmentClipUtils", 2, paramMediaFormat.toString());
    }
    if (i > 0) {
      return i;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.AudioSampleRateExtract
 * JD-Core Version:    0.7.0.1
 */