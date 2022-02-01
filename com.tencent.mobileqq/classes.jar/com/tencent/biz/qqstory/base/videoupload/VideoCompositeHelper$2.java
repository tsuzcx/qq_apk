package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import zxs;
import zxt;

class VideoCompositeHelper$2
  implements zxs
{
  VideoCompositeHelper$2(VideoCompositeHelper paramVideoCompositeHelper, zxt paramzxt, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void failed(zxt paramzxt)
  {
    this.val$code.a(paramzxt.a());
    VideoCompositeHelper.access$000(this.this$0, "convertImageToVideo ");
  }
  
  public void success(zxt paramzxt)
  {
    this.val$code.a(0);
    this.val$info.videoRangeEnd = 60000;
    VideoCompositeHelper.access$000(this.this$0, "convertImageToVideo ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.2
 * JD-Core Version:    0.7.0.1
 */