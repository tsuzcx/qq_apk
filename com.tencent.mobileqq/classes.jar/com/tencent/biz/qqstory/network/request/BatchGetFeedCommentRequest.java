package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedComment;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class BatchGetFeedCommentRequest
  extends NetworkRequest
{
  private static final String e = StoryApi.a("StorySvc.feed_comment_list_batch_775");
  private List<String> f;
  private int g;
  
  public BatchGetFeedCommentRequest(List<String> paramList, boolean paramBoolean)
  {
    this.f = paramList;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    this.g = i;
  }
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchFeedComment localRspBatchFeedComment = new qqstory_service.RspBatchFeedComment();
    try
    {
      localRspBatchFeedComment.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new BatchGetFeedCommentRequest.BatchGetFeedCommentResp(localRspBatchFeedComment);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqBatchFeedComment localReqBatchFeedComment = new qqstory_service.ReqBatchFeedComment();
    List localList = b(this.f);
    localReqBatchFeedComment.feed_id_list.set(localList);
    localReqBatchFeedComment.source.set(this.g);
    return localReqBatchFeedComment.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */