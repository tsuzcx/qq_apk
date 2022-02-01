package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSimpleInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSimpleInfoList;
import com.tencent.biz.qqstory.network.response.GetSimpleInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetSimpleInfoListRequest
  extends NetworkRequest
{
  public List<String> e = new ArrayList();
  public boolean f = false;
  
  public String a()
  {
    return StoryApi.a("StorySvc.get_date_video_list");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspSimpleInfoList localRspSimpleInfoList = new qqstory_service.RspSimpleInfoList();
    try
    {
      localRspSimpleInfoList.mergeFrom(paramArrayOfByte);
      return new GetSimpleInfoListResponse(localRspSimpleInfoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.net:GetSimpleInfoListResponse", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqSimpleInfoList localReqSimpleInfoList = new qqstory_service.ReqSimpleInfoList();
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)((Iterator)localObject).next()));
      }
    }
    localReqSimpleInfoList.vid_list.addAll(localArrayList);
    return localReqSimpleInfoList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetSimpleInfoListResponse{vidList='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetSimpleInfoListRequest
 * JD-Core Version:    0.7.0.1
 */