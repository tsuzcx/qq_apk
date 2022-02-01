package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspTranslateToken;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class StoryShareTranslateTokenRequest$StoryShareTranslateTokenResponse
  extends BaseResponse
{
  public String a;
  public String b;
  public long e;
  
  public StoryShareTranslateTokenRequest$StoryShareTranslateTokenResponse(qqstory_service.RspTranslateToken paramRspTranslateToken)
  {
    super(i, paramRspTranslateToken.result.error_desc.get().toStringUtf8());
    this.a = paramRspTranslateToken.dst_buffer.get().toStringUtf8();
    String str;
    if (paramRspTranslateToken.cover_url.has()) {
      str = paramRspTranslateToken.cover_url.get().toStringUtf8();
    } else {
      str = "";
    }
    this.b = str;
    long l;
    if (paramRspTranslateToken.shoot_time.has()) {
      l = paramRspTranslateToken.shoot_time.get() * 1000L;
    } else {
      l = 0L;
    }
    this.e = l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryShareTranslateTokenResponse{coverUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dstBuffer='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shootTimeMillis=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse
 * JD-Core Version:    0.7.0.1
 */