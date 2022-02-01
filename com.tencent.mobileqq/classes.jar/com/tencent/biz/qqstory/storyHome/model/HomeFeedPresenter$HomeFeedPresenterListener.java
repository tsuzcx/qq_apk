package com.tencent.biz.qqstory.storyHome.model;

public abstract interface HomeFeedPresenter$HomeFeedPresenterListener
  extends FeedListPageLoaderBase.OnFeedItemPageLoadListener<HomeFeedData>
{
  public abstract void a(VideoListHomeFeed paramVideoListHomeFeed);
  
  public abstract void a(String paramString);
  
  public abstract void b(String paramString);
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.HomeFeedPresenterListener
 * JD-Core Version:    0.7.0.1
 */