package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedCommentDataProvider
  extends LegoDataProvider
{
  public static final String a;
  public static final String b = StoryApi.a("StorySvc.del_feed_comment");
  public static final String c = StoryApi.a("StorySvc.get_comment_list");
  protected int a;
  protected FeedCommentLego a;
  protected boolean a;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.add_feed_comment");
  }
  
  public FeedCommentDataProvider(FeedCommentLego paramFeedCommentLego)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego = paramFeedCommentLego;
  }
  
  public static void a(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    paramCommentEntry = new FeedCommentDataProvider.DelFeedCommentRequest(paramCommentEntry, paramLegoResponseCallBack);
    paramLegoResponseCallBack = new FeedCommentDataProvider.DelFeedCommentResponse(paramLegoResponseCallBack);
    LegoNetworkRequester.a().a(paramCommentEntry, paramLegoResponseCallBack);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).putOpt("vid", paramString3);
      ((JSONObject)localObject2).putOpt("feedid", paramString4);
      ((JSONObject)localObject2).putOpt("pvid", paramString5);
      ((JSONObject)localObject2).putOpt("styles", new JSONArray(paramString6));
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.qqstory:FeedCommentDataProvider", 2, "addGamePKComment jsonException " + localJSONException);
      }
    }
    a(paramString1, null, paramString2, l, paramInt, localObject1, 4, new FeedCommentDataProvider.1(paramString1, paramInt, l, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, LegoResponseCallBack paramLegoResponseCallBack)
  {
    paramString1 = new FeedCommentDataProvider.AddFeedCommentRequest(paramString1, paramString2, paramString3, paramLong, paramInt1, paramString4, paramInt2, paramLegoResponseCallBack);
    paramString2 = new FeedCommentDataProvider.AddFeedCommentResponse(paramLegoResponseCallBack);
    LegoNetworkRequester.a().a(paramString1, paramString2);
  }
  
  public static void b(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    paramCommentEntry = new FeedCommentDataProvider.AddFeedCommentRequest(paramCommentEntry, paramLegoResponseCallBack);
    paramLegoResponseCallBack = new FeedCommentDataProvider.AddFeedCommentResponse(paramLegoResponseCallBack);
    LegoNetworkRequester.a().a(paramCommentEntry, paramLegoResponseCallBack);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a.feedId, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new FeedCommentDataProvider.GetCommentListRequest(this, paramString, paramInt);
    FeedCommentDataProvider.GetCommentListResponse localGetCommentListResponse = new FeedCommentDataProvider.GetCommentListResponse(this);
    LegoNetworkRequester.a().a(paramString, localGetCommentListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider
 * JD-Core Version:    0.7.0.1
 */