package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.biz.qqstory.network.response.RefreshVideoFileKeyResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class RefreshVideoFileKeyRequest
  extends NetworkRequest<RefreshVideoFileKeyResponse>
{
  public RefreshVideoFileKeyResponse a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspAuthKey();
    try
    {
      ((qqstory_service.RspAuthKey)localObject).mergeFrom(paramArrayOfByte);
      return new RefreshVideoFileKeyResponse((qqstory_service.RspAuthKey)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:RefreshVideoFileKeyRequest", ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.RefreshVideoFileKeyRequest
 * JD-Core Version:    0.7.0.1
 */