package com.tencent.biz.pubaccount.readinjoy.capture;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyVideoCompositeManager$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  ReadInJoyVideoCompositeManager$1(ReadInJoyVideoCompositeManager paramReadInJoyVideoCompositeManager, long paramLong, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = (l1 - this.jdField_a_of_type_Long) / 1000L;
      l1 = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish) {
        l1 = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd - this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
      }
      QLog.d("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, "CameraCaptureMerge: duration: " + l1 + ", time cost: " + l2 + "s");
    }
    if (paramInt == 0)
    {
      ReadInJoyVideoCompositeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, paramString2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, new Object[] { "doCompositeCameraCaptureVideo: errorcode=%s, errorMsg=%s", Integer.valueOf(paramInt), paramString1 });
    }
    ReadInJoyVideoCompositeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager.1
 * JD-Core Version:    0.7.0.1
 */