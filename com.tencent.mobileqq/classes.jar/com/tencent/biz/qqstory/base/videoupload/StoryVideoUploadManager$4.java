package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;

class StoryVideoUploadManager$4
  implements Runnable
{
  StoryVideoUploadManager$4(StoryVideoUploadManager paramStoryVideoUploadManager, StoryVideoTaskInfo paramStoryVideoTaskInfo, StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent) {}
  
  public void run()
  {
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskStoryVideoTaskInfo });
    StoryDispatcher.a().dispatch(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadManager$StoryVideoPublishStatusEvent);
    StoryDispatcher.a().dispatch(new StoryVideoUploadManager.CreateFakeVideoEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */