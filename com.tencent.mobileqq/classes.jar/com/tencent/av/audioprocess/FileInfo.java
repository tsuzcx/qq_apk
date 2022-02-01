package com.tencent.av.audioprocess;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import java.io.RandomAccessFile;

public class FileInfo
  extends DecodeInfo
{
  public String c = "";
  public int d = 0;
  public int e = 2147483647;
  public float f = 1.0F;
  public int g = 0;
  public RandomAccessFile h = null;
  public long i = 0L;
  public MediaExtractor j = null;
  public MediaCodec.BufferInfo k = null;
  public int l = 0;
  public byte[] m = null;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileInfo{filename = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", fileType = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", volumeScale = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mixCnt = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", channelNum = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.audioprocess.FileInfo
 * JD-Core Version:    0.7.0.1
 */