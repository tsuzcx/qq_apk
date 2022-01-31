package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBatchVideoBasicInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchVideoBasicInfoList;
import com.tencent.biz.qqstory.network.response.GetVideoBasicInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVideoBasicInfoListRequest
  extends NetworkRequest
{
  public List a = new ArrayList();
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBatchVideoBasicInfoList localRspGetBatchVideoBasicInfoList = new qqstory_service.RspGetBatchVideoBasicInfoList();
    try
    {
      localRspGetBatchVideoBasicInfoList.mergeFrom(paramArrayOfByte);
      return new GetVideoBasicInfoListResponse(localRspGetBatchVideoBasicInfoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.net:GetVideoBasicInfoListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.get_batch_video_basic_desc_new");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetBatchVideoBasicInfoList localReqGetBatchVideoBasicInfoList = new qqstory_service.ReqGetBatchVideoBasicInfoList();
    ArrayList localArrayList = new ArrayList();
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)localIterator.next()));
      }
    }
    localReqGetBatchVideoBasicInfoList.vid_list.addAll(localArrayList);
    return localReqGetBatchVideoBasicInfoList.toByteArray();
  }
  
  public String toString()
  {
    return "GetVideoBasicInfoListRequest{vidList='" + this.a + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetVideoBasicInfoListRequest
 * JD-Core Version:    0.7.0.1
 */