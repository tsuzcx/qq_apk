package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBatchFeedFeature;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchFeedFeature;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class GetFeedFeatureRequest
  extends NetworkRequest<GetFeedFeatureResponse>
{
  public static final String e = StoryApi.a("StorySvc.feed_feature_775");
  public List<String> f;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBatchFeedFeature localRspGetBatchFeedFeature = new qqstory_service.RspGetBatchFeedFeature();
    try
    {
      localRspGetBatchFeedFeature.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetFeedFeatureResponse(localRspGetBatchFeedFeature);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetBatchFeedFeature localReqGetBatchFeedFeature = new qqstory_service.ReqGetBatchFeedFeature();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str)) {
        localReqGetBatchFeedFeature.feed_id_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    return localReqGetBatchFeedFeature.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest
 * JD-Core Version:    0.7.0.1
 */