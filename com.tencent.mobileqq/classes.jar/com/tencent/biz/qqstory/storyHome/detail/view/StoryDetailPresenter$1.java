package com.tencent.biz.qqstory.storyHome.detail.view;

class StoryDetailPresenter$1
  implements StoryDetailPresenter.DetailFeedPushObserver.OnPushCallback
{
  StoryDetailPresenter$1(StoryDetailPresenter paramStoryDetailPresenter) {}
  
  public void a(int paramInt)
  {
    if (StoryDetailPresenter.a(this.a) == null) {
      return;
    }
    if (paramInt == 1) {
      StoryDetailPresenter.b(this.a);
    } else if (paramInt == 2) {
      StoryDetailPresenter.c(this.a);
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.1
 * JD-Core Version:    0.7.0.1
 */