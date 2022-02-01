package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class FeedCommentDataProvider
  extends LegoDataProvider
{
  public static final String a = StoryApi.a("StorySvc.add_feed_comment");
  public static final String b = StoryApi.a("StorySvc.del_feed_comment");
  public static final String c = StoryApi.a("StorySvc.get_comment_list");
  protected FeedCommentLego d;
  protected boolean e = false;
  protected int f = 0;
  private String g;
  
  public FeedCommentDataProvider(FeedCommentLego paramFeedCommentLego)
  {
    this.d = paramFeedCommentLego;
  }
  
  public static void a(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    paramCommentEntry = new FeedCommentDataProvider.DelFeedCommentRequest(paramCommentEntry, paramLegoResponseCallBack);
    paramLegoResponseCallBack = new FeedCommentDataProvider.DelFeedCommentResponse(paramLegoResponseCallBack);
    LegoNetworkRequester.a().a(paramCommentEntry, paramLegoResponseCallBack);
  }
  
  public static void b(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    paramCommentEntry = new FeedCommentDataProvider.AddFeedCommentRequest(paramCommentEntry, paramLegoResponseCallBack);
    paramLegoResponseCallBack = new FeedCommentDataProvider.AddFeedCommentResponse(paramLegoResponseCallBack);
    LegoNetworkRequester.a().a(paramCommentEntry, paramLegoResponseCallBack);
  }
  
  public void a()
  {
    a(this.d.g.feedId, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new FeedCommentDataProvider.GetCommentListRequest(this, paramString, paramInt);
    FeedCommentDataProvider.GetCommentListResponse localGetCommentListResponse = new FeedCommentDataProvider.GetCommentListResponse(this);
    LegoNetworkRequester.a().a(paramString, localGetCommentListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider
 * JD-Core Version:    0.7.0.1
 */