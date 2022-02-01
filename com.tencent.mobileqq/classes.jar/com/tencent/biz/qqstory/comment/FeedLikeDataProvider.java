package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class FeedLikeDataProvider
  extends LegoDataProvider
{
  public static final String a = StoryApi.a("StorySvc.feed_like_list_715");
  public static final String b = StoryApi.a("StorySvc.like_feed");
  protected FeedLikeLego c;
  protected String d;
  private boolean e;
  
  public FeedLikeDataProvider(FeedLikeLego paramFeedLikeLego, boolean paramBoolean)
  {
    this.c = paramFeedLikeLego;
    this.d = this.c.b.feedId;
    this.e = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LegoNetworkRequester.a().a(new FeedLikeDataProvider.LikeFeedRequest(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new FeedLikeDataProvider.LikeFeedRespone());
  }
  
  public void a()
  {
    a(this.d, this.e);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    LegoNetworkRequester.a().a(new FeedLikeDataProvider.GetLikeListRequest(this, paramString, paramBoolean), new FeedLikeDataProvider.GetLikeListResponse(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider
 * JD-Core Version:    0.7.0.1
 */