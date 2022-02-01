package com.tencent.biz.qqstory.network.request;

import android.os.Bundle;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.mobileqq.pb.MessageMicro;

public class CommonRequest<REQ extends MessageMicro>
  extends NetworkRequest<CommonResponse>
{
  public final Bundle e;
  public final REQ f;
  public final String g;
  
  public CommonRequest(String paramString, REQ paramREQ, Bundle paramBundle)
  {
    this.g = paramString;
    this.f = paramREQ;
    this.e = paramBundle;
  }
  
  public String a()
  {
    return this.g;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    return new CommonResponse(paramArrayOfByte);
  }
  
  protected byte[] c()
  {
    return this.f.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.CommonRequest
 * JD-Core Version:    0.7.0.1
 */