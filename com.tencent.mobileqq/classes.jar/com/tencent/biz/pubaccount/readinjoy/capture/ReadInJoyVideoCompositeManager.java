package com.tencent.biz.pubaccount.readinjoy.capture;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class ReadInJoyVideoCompositeManager
{
  private ReadInJoyVideoCompositeManager.OnVideoCompositeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener;
  private VideoCompositeHelper jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper = new VideoCompositeHelper();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(ReadInJoyVideoCompositeManager.OnVideoCompositeListener paramOnVideoCompositeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener = paramOnVideoCompositeListener;
  }
  
  public void a(String paramString)
  {
    VideoCompositeHelper.a(VideoCompositeHelper.a(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = VideoCompositeHelper.a(paramString1);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper.a(paramString1, paramString2 + ".tmp.mp4", false, true, new ReadInJoyVideoCompositeManager.1(this, l, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager
 * JD-Core Version:    0.7.0.1
 */