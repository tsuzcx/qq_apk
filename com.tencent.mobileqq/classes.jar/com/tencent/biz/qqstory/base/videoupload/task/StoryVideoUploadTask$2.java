package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;

class StoryVideoUploadTask$2
  implements UploadObject.UploadFinishListener
{
  StoryVideoUploadTask$2(StoryVideoUploadTask paramStoryVideoUploadTask, StoryVideoTaskInfo paramStoryVideoTaskInfo) {}
  
  public void a(UploadObject paramUploadObject)
  {
    this.a.x = ((ImageFileObject)paramUploadObject).b;
    this.b.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask.2
 * JD-Core Version:    0.7.0.1
 */