package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

public class ShortVideoPreviewActivity$HWCompressProcessor
  implements VideoConverter.Processor
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  ShortVideoPreviewActivity$HWCompressProcessor(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if (paramInt2 > 0) {}
    for (this.jdField_b_of_type_Int = paramInt2;; this.jdField_b_of_type_Int = 30)
    {
      if (paramString == null) {}
      return;
    }
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    int j = 1280;
    int i = 30;
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    String str;
    if (paramInt1 <= paramInt2)
    {
      localVideoConverterConfig.output = this.jdField_a_of_type_JavaLangString;
      if (paramInt2 < 1280) {
        break label244;
      }
      str = "720p";
      paramInt1 = j;
      label45:
      if (paramInt2 >= paramInt1) {
        break label273;
      }
    }
    label273:
    for (localVideoConverterConfig.videoBitRate = ((int)(819200 * 1.0D / paramInt1 * paramInt2));; localVideoConverterConfig.videoBitRate = 819200)
    {
      localVideoConverterConfig.scaleRate = (paramInt1 / paramInt2);
      paramInt2 = i;
      if (this.jdField_b_of_type_Int <= 30) {
        paramInt2 = this.jdField_b_of_type_Int;
      }
      localVideoConverterConfig.videoFrameRate = paramInt2;
      localVideoConverterConfig.beginTime = this.jdField_a_of_type_Long;
      localVideoConverterConfig.endTime = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localVideoConverterConfig.setRotation + ", scaleRate=" + localVideoConverterConfig.scaleRate + ", videoBitRate=" + localVideoConverterConfig.videoBitRate + ", videoFrameRate=" + localVideoConverterConfig.videoFrameRate + ", beginTime=" + localVideoConverterConfig.beginTime + ", endTime=" + localVideoConverterConfig.endTime + ",quality:" + str + ",videoLongestEdge=" + paramInt1);
      }
      return localVideoConverterConfig;
      paramInt2 = paramInt1;
      break;
      label244:
      if (paramInt2 >= 960)
      {
        str = "540p";
        paramInt1 = 960;
        break label45;
      }
      paramInt1 = 640;
      str = "480p";
      break label45;
    }
  }
  
  public void onCancel() {}
  
  public void onFail(Throwable paramThrowable)
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
  }
  
  public void onProgress(int paramInt) {}
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */