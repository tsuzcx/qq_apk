package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

class FeedItemThumbAdapter$1
  implements MessageProgressView.AnimRunnableListener
{
  FeedItemThumbAdapter$1(FeedItemThumbAdapter paramFeedItemThumbAdapter, String paramString, QQStoryAutoPlayView paramQQStoryAutoPlayView) {}
  
  public void a(String paramString)
  {
    SLog.a("Q.qqstory.detail.FeedItemThumbAdapter", "vid:%s, animation end", this.a);
    this.b.getProgressView().a(4);
    StoryVideoUploadProgressManager.a().a(this.b.getProgressView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter.1
 * JD-Core Version:    0.7.0.1
 */