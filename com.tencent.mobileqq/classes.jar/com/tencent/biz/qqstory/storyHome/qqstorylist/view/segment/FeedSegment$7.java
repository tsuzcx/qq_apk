package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

class FeedSegment$7
  implements MessageProgressView.AnimRunnableListener
{
  FeedSegment$7(FeedSegment paramFeedSegment, String paramString, QQStoryAutoPlayView paramQQStoryAutoPlayView) {}
  
  public void a(String paramString)
  {
    SLog.a("Q.qqstory.home:FeedSegment", "vid:%s, animation end", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().a(4);
    StoryVideoUploadProgressManager.a().a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.7
 * JD-Core Version:    0.7.0.1
 */