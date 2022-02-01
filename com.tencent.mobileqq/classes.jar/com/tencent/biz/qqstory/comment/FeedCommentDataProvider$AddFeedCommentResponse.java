package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;

public class FeedCommentDataProvider$AddFeedCommentResponse
  extends LegoResponseBase
{
  LegoResponseCallBack jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack;
  qqstory_service.RspAddFeedComment jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment;
  
  public FeedCommentDataProvider$AddFeedCommentResponse(LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack = paramLegoResponseCallBack;
  }
  
  public FeedCommentDataProvider$AddFeedCommentResponse(qqstory_service.RspAddFeedComment paramRspAddFeedComment, LegoResponseCallBack paramLegoResponseCallBack)
  {
    super(paramRspAddFeedComment.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment = paramRspAddFeedComment;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack = paramLegoResponseCallBack;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack.a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack.a(paramInt, paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack.a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.AddFeedCommentResponse
 * JD-Core Version:    0.7.0.1
 */