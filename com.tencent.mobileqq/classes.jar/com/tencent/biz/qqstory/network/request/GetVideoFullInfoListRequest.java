package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVideoFullInfoListRequest
  extends NetworkRequest<GetVideoFullInfoListResponse>
{
  public static final String g = StoryApi.a("StorySvc.union_batch_vid_basic_info");
  public List<String> e = new ArrayList();
  public int f = 0;
  
  public String a()
  {
    return g;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchGetVideoFullInfoList localRspBatchGetVideoFullInfoList = new qqstory_service.RspBatchGetVideoFullInfoList();
    try
    {
      localRspBatchGetVideoFullInfoList.mergeFrom(paramArrayOfByte);
      SLog.a("Q.qqstory.net:GetVideoFullInfoListRequest", "%s", PBUtils.b(localRspBatchGetVideoFullInfoList));
      return new GetVideoFullInfoListResponse(localRspBatchGetVideoFullInfoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.net:GetVideoFullInfoListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqBatchGetVideoFullInfoList localReqBatchGetVideoFullInfoList = new qqstory_service.ReqBatchGetVideoFullInfoList();
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        AssertUtils.assertTrue(str.startsWith("Loading") ^ true);
        localReqBatchGetVideoFullInfoList.vid_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    localReqBatchGetVideoFullInfoList.source.set(this.f);
    return localReqBatchGetVideoFullInfoList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetVideoFullInfoListRequest{vidList='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest
 * JD-Core Version:    0.7.0.1
 */