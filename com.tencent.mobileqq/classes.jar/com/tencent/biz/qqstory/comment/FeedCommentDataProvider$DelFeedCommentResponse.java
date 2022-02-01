package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDelFeedComment;

public class FeedCommentDataProvider$DelFeedCommentResponse
  extends LegoResponseBase
{
  LegoResponseCallBack jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack;
  qqstory_service.RspDelFeedComment jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment;
  
  public FeedCommentDataProvider$DelFeedCommentResponse(LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack = paramLegoResponseCallBack;
  }
  
  public FeedCommentDataProvider$DelFeedCommentResponse(qqstory_service.RspDelFeedComment paramRspDelFeedComment, LegoResponseCallBack paramLegoResponseCallBack)
  {
    super(paramRspDelFeedComment.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment = paramRspDelFeedComment;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack = paramLegoResponseCallBack;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.DelFeedCommentResponse
 * JD-Core Version:    0.7.0.1
 */