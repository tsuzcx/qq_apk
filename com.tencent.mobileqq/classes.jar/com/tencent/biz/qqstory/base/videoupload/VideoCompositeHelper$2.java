package com.tencent.biz.qqstory.base.videoupload;

import aane;
import aanf;
import com.tencent.biz.qqstory.database.PublishVideoEntry;

class VideoCompositeHelper$2
  implements aane
{
  VideoCompositeHelper$2(VideoCompositeHelper paramVideoCompositeHelper, aanf paramaanf, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void failed(aanf paramaanf)
  {
    this.val$code.a(paramaanf.a());
    VideoCompositeHelper.access$000(this.this$0, "convertImageToVideo ");
  }
  
  public void success(aanf paramaanf)
  {
    this.val$code.a(0);
    this.val$info.videoRangeEnd = 60000;
    VideoCompositeHelper.access$000(this.this$0, "convertImageToVideo ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.2
 * JD-Core Version:    0.7.0.1
 */