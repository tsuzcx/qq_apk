package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class FeedLikeDataProvider
  extends LegoDataProvider
{
  public static final String a;
  public static final String b = StoryApi.a("StorySvc.like_feed");
  protected FeedLikeLego a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.feed_like_list_715");
  }
  
  public FeedLikeDataProvider(FeedLikeLego paramFeedLikeLego, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego = paramFeedLikeLego;
    this.c = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LegoNetworkRequester.a().a(new FeedLikeDataProvider.LikeFeedRequest(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new FeedLikeDataProvider.LikeFeedRespone());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    LegoNetworkRequester.a().a(new FeedLikeDataProvider.GetLikeListRequest(this, paramString, paramBoolean), new FeedLikeDataProvider.GetLikeListResponse(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider
 * JD-Core Version:    0.7.0.1
 */