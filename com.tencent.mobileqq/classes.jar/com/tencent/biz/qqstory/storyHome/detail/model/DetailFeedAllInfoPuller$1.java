package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class DetailFeedAllInfoPuller$1
  implements Runnable
{
  DetailFeedAllInfoPuller$1(DetailFeedAllInfoPuller paramDetailFeedAllInfoPuller) {}
  
  public void run()
  {
    Object localObject1 = (CommentLikeFeedItem)((FeedManager)SuperManager.a(11)).b(DetailFeedAllInfoPuller.a(this.this$0));
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      DetailFeedAllInfoPuller.a((DetailFeedAllInfoPuller)localObject1, DetailFeedAllInfoPuller.b((DetailFeedAllInfoPuller)localObject1), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((FeedVideoManager)SuperManager.a(12)).a(DetailFeedAllInfoPuller.a(this.this$0), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        localObject1 = this.this$0;
        DetailFeedAllInfoPuller.a((DetailFeedAllInfoPuller)localObject1, DetailFeedAllInfoPuller.b((DetailFeedAllInfoPuller)localObject1), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      DetailFeedAllInfoPuller.b(this.this$0).a(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((TagManager)SuperManager.a(27)).a(DetailFeedAllInfoPuller.a(this.this$0), ((FeedVideoInfo)localObject3).mVideoItemList);
      DetailFeedAllInfoPuller.b(this.this$0).b((List)localObject2, true);
    }
    DetailFeedAllInfoPuller.b(this.this$0).a = ((CommentLikeFeedItem)localObject1);
    if (this.this$0.a)
    {
      localObject1 = (LikeManager)SuperManager.a(15);
      localObject2 = ((LikeManager)localObject1).a(DetailFeedAllInfoPuller.a(this.this$0), DetailFeedAllInfoPuller.c(this.this$0));
      DetailFeedAllInfoPuller.b(this.this$0).b((List)localObject2, true, DetailFeedAllInfoPuller.c(this.this$0));
      localObject2 = (CommentManager)SuperManager.a(17);
      localObject3 = ((CommentManager)localObject2).a(DetailFeedAllInfoPuller.a(this.this$0), DetailFeedAllInfoPuller.c(this.this$0));
      DetailFeedAllInfoPuller.b(this.this$0).a((List)localObject3, true, DetailFeedAllInfoPuller.c(this.this$0));
      if (DetailFeedAllInfoPuller.b(this.this$0).b())
      {
        localObject1 = ((LikeManager)localObject1).a(DetailFeedAllInfoPuller.a(this.this$0), DetailFeedAllInfoPuller.c(this.this$0) ^ true);
        DetailFeedAllInfoPuller.b(this.this$0).b((List)localObject1, true, DetailFeedAllInfoPuller.c(this.this$0) ^ true);
        localObject1 = ((CommentManager)localObject2).a(DetailFeedAllInfoPuller.a(this.this$0), DetailFeedAllInfoPuller.c(this.this$0) ^ true);
        DetailFeedAllInfoPuller.b(this.this$0).a((List)localObject1, true, DetailFeedAllInfoPuller.c(this.this$0) ^ true);
      }
    }
    SLog.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", DetailFeedAllInfoPuller.b(this.this$0).toString());
    localObject1 = this.this$0;
    DetailFeedAllInfoPuller.a((DetailFeedAllInfoPuller)localObject1, DetailFeedAllInfoPuller.b((DetailFeedAllInfoPuller)localObject1), true, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.1
 * JD-Core Version:    0.7.0.1
 */