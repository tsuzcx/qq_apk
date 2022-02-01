package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

public class ShortVideoPreviewActivity$HWCompressProcessor
  implements VideoConverter.Processor
{
  final String a;
  final int b;
  final int c;
  final long d;
  final long e;
  
  ShortVideoPreviewActivity$HWCompressProcessor(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.d = paramLong1;
    this.e = paramLong2;
    if (paramInt2 > 0)
    {
      this.c = paramInt2;
      return;
    }
    this.c = 30;
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    int i = paramInt1;
    if (paramInt1 <= paramInt2) {
      i = paramInt2;
    }
    localVideoConverterConfig.output = this.a;
    paramInt1 = 960;
    String str;
    if (i >= 1280)
    {
      str = "720p";
      paramInt1 = 1280;
    }
    else if (i >= 960)
    {
      str = "540p";
    }
    else
    {
      paramInt1 = 640;
      str = "480p";
    }
    if (i < paramInt1)
    {
      double d1 = 819200;
      Double.isNaN(d1);
      double d2 = paramInt1;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      d2 = i;
      Double.isNaN(d2);
      localVideoConverterConfig.videoBitRate = ((int)(d1 * d2));
    }
    else
    {
      localVideoConverterConfig.videoBitRate = 819200;
    }
    localVideoConverterConfig.scaleRate = (paramInt1 / i);
    paramInt2 = this.c;
    if (paramInt2 > 30) {
      paramInt2 = 30;
    }
    localVideoConverterConfig.videoFrameRate = paramInt2;
    localVideoConverterConfig.beginTime = this.d;
    localVideoConverterConfig.endTime = this.e;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CompressTask, step: getEncodeConfig() config.setRotation = ");
      localStringBuilder.append(localVideoConverterConfig.setRotation);
      localStringBuilder.append(", scaleRate=");
      localStringBuilder.append(localVideoConverterConfig.scaleRate);
      localStringBuilder.append(", videoBitRate=");
      localStringBuilder.append(localVideoConverterConfig.videoBitRate);
      localStringBuilder.append(", videoFrameRate=");
      localStringBuilder.append(localVideoConverterConfig.videoFrameRate);
      localStringBuilder.append(", beginTime=");
      localStringBuilder.append(localVideoConverterConfig.beginTime);
      localStringBuilder.append(", endTime=");
      localStringBuilder.append(localVideoConverterConfig.endTime);
      localStringBuilder.append(",quality:");
      localStringBuilder.append(str);
      localStringBuilder.append(",videoLongestEdge=");
      localStringBuilder.append(paramInt1);
      QLog.d("VideoCompressTask", 2, localStringBuilder.toString());
    }
    return localVideoConverterConfig;
  }
  
  public void onCancel() {}
  
  public void onFail(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompressTask, step: HWCompressProcessor onFailed:");
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.e("VideoCompressTask", 1, localStringBuilder.toString());
  }
  
  public void onProgress(int paramInt) {}
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */