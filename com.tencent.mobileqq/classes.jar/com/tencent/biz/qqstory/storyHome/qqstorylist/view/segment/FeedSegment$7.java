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
    SLog.a("Q.qqstory.home:FeedSegment", "vid:%s, animation end", this.a);
    this.b.getProgressView().a(4);
    StoryVideoUploadProgressManager.a().a(this.b.getProgressView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.7
 * JD-Core Version:    0.7.0.1
 */