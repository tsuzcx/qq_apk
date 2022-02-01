package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryVideoUploadTask$4
  implements UploadObject.UploadFinishListener
{
  StoryVideoUploadTask$4(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(UploadObject paramUploadObject)
  {
    ((StoryVideoTaskInfo)this.a.b).v = ((ImageFileObject)paramUploadObject).b;
    SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "make video thumbnail finish:%s", ((StoryVideoTaskInfo)this.a.b).v);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask.4
 * JD-Core Version:    0.7.0.1
 */