package com.tencent.biz.qqcircle.publish.service.video;

import android.annotation.TargetApi;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

@TargetApi(18)
class VideoTrimmer$HWCompressProcessor
  implements VideoConverter.Processor
{
  private static final int[] h = { 1, 2, 8 };
  private static final int[] i = { 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
  final String a;
  final int b;
  final int c;
  final boolean d;
  final long e;
  final long f;
  boolean g;
  
  VideoTrimmer$HWCompressProcessor(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.d = paramBoolean;
    this.e = paramLong1;
    this.f = paramLong2;
    if (paramInt2 > 0) {
      this.c = paramInt2;
    } else {
      this.c = 30;
    }
    if (paramString != null) {
      return;
    }
    throw new IllegalArgumentException("null == outputFilePath");
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    int j = paramInt1;
    if (paramInt1 <= paramInt2) {
      j = paramInt2;
    }
    localVideoConverterConfig.output = this.a;
    localVideoConverterConfig.bitrateMode = VideoTrimmer.b()[VideoTrimmer.c()];
    if (!this.d)
    {
      if (j < VideoTrimmer.d())
      {
        double d1 = VideoTrimmer.e();
        Double.isNaN(d1);
        double d2 = VideoTrimmer.d();
        Double.isNaN(d2);
        d1 = d1 * 1.0D / d2;
        d2 = j;
        Double.isNaN(d2);
        localVideoConverterConfig.videoBitRate = ((int)(d1 * d2));
        localVideoConverterConfig.scaleRate = 1.0F;
      }
      else
      {
        localVideoConverterConfig.videoBitRate = VideoTrimmer.e();
        localVideoConverterConfig.scaleRate = (VideoTrimmer.d() / j);
      }
      if (this.c <= VideoTrimmer.f()) {
        paramInt1 = this.c;
      } else {
        paramInt1 = VideoTrimmer.f();
      }
      localVideoConverterConfig.videoFrameRate = paramInt1;
    }
    else
    {
      localVideoConverterConfig.videoBitRate = this.b;
      localVideoConverterConfig.videoFrameRate = this.c;
      localVideoConverterConfig.scaleRate = 1.0F;
    }
    localVideoConverterConfig.iFrameInterval = VideoTrimmer.g();
    localVideoConverterConfig.setProfileLevel = (Build.MANUFACTURER.equalsIgnoreCase("xiaomi") ^ true);
    j = 0;
    paramInt1 = 0;
    for (;;)
    {
      paramInt2 = j;
      if (paramInt1 >= VideoTrimmer.h().length) {
        break;
      }
      if (VideoTrimmer.i().equalsIgnoreCase(VideoTrimmer.h()[paramInt1]))
      {
        localVideoConverterConfig.profile = h[paramInt1];
        paramInt2 = j;
        break;
      }
      paramInt1 += 1;
    }
    while (paramInt2 < VideoTrimmer.j().length)
    {
      if (VideoTrimmer.k().equalsIgnoreCase(VideoTrimmer.j()[paramInt2]))
      {
        localVideoConverterConfig.level = i[paramInt2];
        break;
      }
      paramInt2 += 1;
    }
    localVideoConverterConfig.beginTime = this.e;
    localVideoConverterConfig.endTime = this.f;
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
      localStringBuilder.append(", mIsOrigin=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", beginTime=");
      localStringBuilder.append(localVideoConverterConfig.beginTime);
      localStringBuilder.append(", endTime=");
      localStringBuilder.append(localVideoConverterConfig.endTime);
      QLog.d("[upload2]VideoTrimmer", 2, localStringBuilder.toString());
    }
    return localVideoConverterConfig;
  }
  
  public void onCancel()
  {
    QLog.i("[upload2]VideoTrimmer", 1, "CompressTask, step: HWCompressProcessor onCanceled");
    this.g = true;
  }
  
  public void onFail(Throwable paramThrowable)
  {
    QLog.e("[upload2]VideoTrimmer", 1, "CompressTask, step: HWCompressProcessor onFailed");
  }
  
  public void onProgress(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompressTask, step: HWCompressProcessor onProgress:");
    localStringBuilder.append(paramInt);
    QLog.d("[upload2]VideoTrimmer", 1, localStringBuilder.toString());
  }
  
  public void onSuccess()
  {
    QLog.d("[upload2]VideoTrimmer", 1, "CompressTask, step: HWCompressProcessor onSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.VideoTrimmer.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */