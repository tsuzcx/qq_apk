package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchFeedLike;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedLike;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class BatchGetFeedLikeRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.feed_like_list_batch_715");
  private List<String> f;
  private int g;
  
  public BatchGetFeedLikeRequest(List<String> paramList, boolean paramBoolean)
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
    qqstory_service.RspBatchFeedLike localRspBatchFeedLike = new qqstory_service.RspBatchFeedLike();
    try
    {
      localRspBatchFeedLike.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new BatchGetFeedLikeRequest.BatchGetFeedLikeResp(localRspBatchFeedLike);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqBatchFeedLike localReqBatchFeedLike = new qqstory_service.ReqBatchFeedLike();
    List localList = b(this.f);
    localReqBatchFeedLike.feed_id_list.set(localList);
    localReqBatchFeedLike.source.set(this.g);
    return localReqBatchFeedLike.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest
 * JD-Core Version:    0.7.0.1
 */