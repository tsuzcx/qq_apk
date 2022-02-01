package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTranslateToken;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspTranslateToken;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class StoryShareTranslateTokenRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.translate_share_parameters_to_token");
  public String f;
  public int g;
  public String h;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspTranslateToken localRspTranslateToken = new qqstory_service.RspTranslateToken();
    try
    {
      localRspTranslateToken.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.share.trans.req", 2, "decode failed", paramArrayOfByte);
      }
    }
    return new StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse(localRspTranslateToken);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqTranslateToken localReqTranslateToken = new qqstory_service.ReqTranslateToken();
    localReqTranslateToken.src_buffer.set(ByteStringMicro.copyFromUtf8(this.f));
    localReqTranslateToken.type.set(this.g);
    if ((this.g == 1) && (this.h != null)) {
      localReqTranslateToken.feed_id.set(ByteStringMicro.copyFromUtf8(this.h));
    }
    return localReqTranslateToken.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryShareTranslateTokenRequest{feedId='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", srcBuffer='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest
 * JD-Core Version:    0.7.0.1
 */