package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetOfficialRecommends;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetOfficialRecommends;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.response.GetOfficialRecommendStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetOfficialRecommendStoryListRequest
  extends NetworkRequest
{
  public static final String e = QQStoryHandler.g;
  public String f = "";
  public BasicLocation g;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    if (!QQStoryHandler.a(paramArrayOfByte))
    {
      SLog.d("Q.qqstory:GetOfficialRecommendStoryListRequest", "GetOfficialRecommendStoryListRequest data is no valid");
      return null;
    }
    Object localObject = new qqstory_service.RspGetOfficialRecommends();
    try
    {
      ((qqstory_service.RspGetOfficialRecommends)localObject).mergeFrom(paramArrayOfByte);
      return new GetOfficialRecommendStoryListResponse((qqstory_service.RspGetOfficialRecommends)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:GetOfficialRecommendStoryListRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetOfficialRecommends localReqGetOfficialRecommends = new qqstory_service.ReqGetOfficialRecommends();
    localReqGetOfficialRecommends.count.set(50);
    localReqGetOfficialRecommends.start_cookie.set(ByteStringMicro.copyFromUtf8(this.f));
    if (this.g != null)
    {
      localReqGetOfficialRecommends.gps.lat.set(this.g.a);
      localReqGetOfficialRecommends.gps.lng.set(this.g.b);
      localReqGetOfficialRecommends.gps.setHasFlag(true);
    }
    return localReqGetOfficialRecommends.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetOfficialRecommendStoryListRequest{count=50start_cookie=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("location");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetOfficialRecommendStoryListRequest
 * JD-Core Version:    0.7.0.1
 */