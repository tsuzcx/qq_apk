package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.videoupload.meta.LinkRichObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;

class StoryVideoUploadTask$5
  implements UploadObject.UploadFinishListener
{
  StoryVideoUploadTask$5(StoryVideoUploadTask paramStoryVideoUploadTask, VideoLinkInfo paramVideoLinkInfo, LinkRichObject paramLinkRichObject) {}
  
  public void a(UploadObject paramUploadObject)
  {
    paramUploadObject = this.a;
    int i;
    if (this.b.e == 0) {
      i = 2;
    } else {
      i = 3;
    }
    paramUploadObject.g = i;
    this.a.c = this.b.b;
    this.a.d = this.b.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask.5
 * JD-Core Version:    0.7.0.1
 */