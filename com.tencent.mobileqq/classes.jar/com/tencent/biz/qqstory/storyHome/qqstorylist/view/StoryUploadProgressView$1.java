package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import com.tencent.mobileqq.widget.MessageProgressView;

class StoryUploadProgressView$1
  implements Runnable
{
  StoryUploadProgressView$1(StoryUploadProgressView paramStoryUploadProgressView) {}
  
  public void run()
  {
    MessageProgressView localMessageProgressView = this.this$0.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StoryUploadProgressView.a(this.this$0));
    localStringBuilder.append("_");
    localStringBuilder.append(hashCode());
    localMessageProgressView.b(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView.1
 * JD-Core Version:    0.7.0.1
 */