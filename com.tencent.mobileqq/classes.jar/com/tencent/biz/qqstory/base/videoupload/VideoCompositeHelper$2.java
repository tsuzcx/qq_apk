package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.videostory.support.VideoStoryPicToVideo.ConvertListener;
import com.tencent.biz.videostory.support.VideoStoryPicToVideo.RetCode;

class VideoCompositeHelper$2
  implements VideoStoryPicToVideo.ConvertListener
{
  VideoCompositeHelper$2(VideoCompositeHelper paramVideoCompositeHelper, VideoStoryPicToVideo.RetCode paramRetCode, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(VideoStoryPicToVideo.RetCode paramRetCode)
  {
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode.a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = 60000;
    VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper, "convertImageToVideo ");
  }
  
  public void b(VideoStoryPicToVideo.RetCode paramRetCode)
  {
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode.a(paramRetCode.a());
    VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper, "convertImageToVideo ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.2
 * JD-Core Version:    0.7.0.1
 */