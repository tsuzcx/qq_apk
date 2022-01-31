package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetConfigFile;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfigFile;
import com.tencent.biz.qqstory.network.response.GetConfigFileResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetConfigFileRequest
  extends NetworkRequest
{
  private int c;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetConfigFile localRspGetConfigFile = new qqstory_service.RspGetConfigFile();
    try
    {
      localRspGetConfigFile.mergeFrom(paramArrayOfByte);
      return new GetConfigFileResponse(localRspGetConfigFile);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.e("GetConfigFileRequest", "GetEmojiPackInfoListRequest error : " + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.video_pendant_config_get");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetConfigFile localReqGetConfigFile = new qqstory_service.ReqGetConfigFile();
    localReqGetConfigFile.config_file_type.set(this.c);
    localReqGetConfigFile.mobile_type.set(1);
    return localReqGetConfigFile.toByteArray();
  }
  
  public String toString()
  {
    return "GetConfigFileRequest{mType=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetConfigFileRequest
 * JD-Core Version:    0.7.0.1
 */