package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;

class StoryVideoUploadTask$1
  implements UploadObject.UploadFinishListener
{
  StoryVideoUploadTask$1(StoryVideoUploadTask paramStoryVideoUploadTask, StoryVideoTaskInfo paramStoryVideoTaskInfo) {}
  
  public void a(UploadObject paramUploadObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskStoryVideoTaskInfo.k = ((ImageFileObject)paramUploadObject).b;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskStoryVideoUploadTask.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask.1
 * JD-Core Version:    0.7.0.1
 */