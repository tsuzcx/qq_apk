package com.tencent.biz.pubaccount.readinjoy.ugc.video;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import cooperation.readinjoy.ReadInJoyHelper;

class VideoCompressTask$HWCompressProcessor
  implements VideoConverter.Processor
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  VideoCompressTask$HWCompressProcessor(VideoCompressTask paramVideoCompressTask, String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
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
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    int i;
    String str;
    if (paramInt1 <= paramInt2)
    {
      localVideoConverterConfig.output = this.jdField_a_of_type_JavaLangString;
      i = ReadInJoyConstants.jdField_a_of_type_Int;
      paramInt1 = ReadInJoyHelper.r(BaseApplicationImpl.getApplication().getRuntime());
      if (paramInt1 > 0) {
        i = paramInt1;
      }
      if (paramInt2 < 1280) {
        break label273;
      }
      str = "720p";
      paramInt1 = j;
      label62:
      localVideoConverterConfig.videoBitRate = ((int)(i * 1.0F / 640.0F * paramInt1));
      localVideoConverterConfig.scaleRate = (paramInt1 / paramInt2);
      if (this.jdField_b_of_type_Int > 30) {
        break label302;
      }
    }
    label273:
    label302:
    for (j = this.jdField_b_of_type_Int;; j = 30)
    {
      localVideoConverterConfig.videoFrameRate = j;
      localVideoConverterConfig.beginTime = this.jdField_a_of_type_Long;
      localVideoConverterConfig.endTime = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: getEncodeConfig()\n quality:" + str + ", sourceLongEdge:" + paramInt2 + ", targetLongEdge:" + paramInt1 + ", scaleRate:" + localVideoConverterConfig.scaleRate + "\n defaultBitRate:" + i + ", videoBitRate:" + localVideoConverterConfig.videoBitRate + ", videoFrameRate:" + localVideoConverterConfig.videoFrameRate + "\n setRotation:" + localVideoConverterConfig.setRotation + ", beginTime:" + localVideoConverterConfig.beginTime + ", endTime:" + localVideoConverterConfig.endTime);
      }
      return localVideoConverterConfig;
      paramInt2 = paramInt1;
      break;
      if (paramInt2 >= 960)
      {
        str = "640p";
        paramInt1 = 960;
        break label62;
      }
      paramInt1 = 640;
      str = "480p";
      break label62;
    }
  }
  
  public void onCancel() {}
  
  public void onFail(Throwable paramThrowable)
  {
    QLog.e("ReadInJoyUploadVideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
  }
  
  public void onProgress(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask.a != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask.isCancelled())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask.a.a(paramInt / 100.0F);
    }
  }
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoCompressTask.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */