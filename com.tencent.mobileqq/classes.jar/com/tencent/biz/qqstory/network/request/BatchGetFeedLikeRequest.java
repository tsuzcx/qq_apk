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
  public static final String a;
  private List<String> a;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.feed_like_list_batch_715");
  }
  
  public BatchGetFeedLikeRequest(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    this.c = i;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
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
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqBatchFeedLike localReqBatchFeedLike = new qqstory_service.ReqBatchFeedLike();
    List localList = a(this.jdField_a_of_type_JavaUtilList);
    localReqBatchFeedLike.feed_id_list.set(localList);
    localReqBatchFeedLike.source.set(this.c);
    return localReqBatchFeedLike.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest
 * JD-Core Version:    0.7.0.1
 */