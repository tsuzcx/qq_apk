package com.tencent.biz.pubaccount.readinjoy.video.videoconverter;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;

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
    for (this.jdField_b_of_type_Int = paramInt2; paramString == null; this.jdField_b_of_type_Int = 30) {
      throw new IllegalArgumentException("null == outputFilePath");
    }
  }
  
  private void a()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    int i = 30;
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    localVideoConverterConfig.output = this.jdField_a_of_type_JavaLangString;
    long l = VideoConvertUtil.a(paramInt1, paramInt2);
    int j = VideoConvertUtil.a(paramInt1, paramInt2);
    localVideoConverterConfig.videoBitRate = ((int)l);
    paramInt2 = Math.min(paramInt1, paramInt2);
    localVideoConverterConfig.scaleRate = (j / paramInt2);
    paramInt1 = i;
    if (this.jdField_b_of_type_Int <= 30) {
      paramInt1 = this.jdField_b_of_type_Int;
    }
    localVideoConverterConfig.videoFrameRate = paramInt1;
    localVideoConverterConfig.beginTime = this.jdField_a_of_type_Long;
    localVideoConverterConfig.endTime = this.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig()\n  sourceShortEdge:" + paramInt2 + ", dstResolution:" + j + ", scaleRate:" + localVideoConverterConfig.scaleRate + "\n  targetVideoBitRate:" + localVideoConverterConfig.videoBitRate + ", videoFrameRate:" + localVideoConverterConfig.videoFrameRate + "\n setRotation:" + localVideoConverterConfig.setRotation + ", beginTime:" + localVideoConverterConfig.beginTime + ", endTime:" + localVideoConverterConfig.endTime);
    }
    return localVideoConverterConfig;
  }
  
  public void onCancel()
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onCanceled:");
    a();
    if (VideoCompressTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask) != null) {
      VideoCompressTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask).a(6, null, null);
    }
  }
  
  public void onFail(Throwable paramThrowable)
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
  }
  
  public void onProgress(int paramInt)
  {
    if ((VideoCompressTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask) != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask.isCancelled())) {
      VideoCompressTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask).a(paramInt / 100.0F);
    }
  }
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoCompressTask.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */