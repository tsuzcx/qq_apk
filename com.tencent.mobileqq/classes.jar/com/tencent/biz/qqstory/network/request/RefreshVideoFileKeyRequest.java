package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.biz.qqstory.network.response.RefreshVideoFileKeyResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class RefreshVideoFileKeyRequest
  extends NetworkRequest
{
  public RefreshVideoFileKeyResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspAuthKey localRspAuthKey = new qqstory_service.RspAuthKey();
    try
    {
      localRspAuthKey.mergeFrom(paramArrayOfByte);
      return new RefreshVideoFileKeyResponse(localRspAuthKey);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:RefreshVideoFileKeyRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.video_apply_authkey");
  }
  
  protected byte[] a()
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.RefreshVideoFileKeyRequest
 * JD-Core Version:    0.7.0.1
 */