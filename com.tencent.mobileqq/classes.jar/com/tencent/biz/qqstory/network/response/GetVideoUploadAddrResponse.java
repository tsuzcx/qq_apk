package com.tencent.biz.qqstory.network.response;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspUploadStoryVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetVideoUploadAddrResponse
  extends BaseResponse
{
  public String a;
  public int b;
  public boolean e;
  public String f;
  public String g;
  
  public GetVideoUploadAddrResponse(@NonNull qqstory_service.RspUploadStoryVideo paramRspUploadStoryVideo)
  {
    super(paramRspUploadStoryVideo.result);
    this.a = paramRspUploadStoryVideo.server_ip.get().toStringUtf8();
    this.b = paramRspUploadStoryVideo.server_port.get();
    int i = paramRspUploadStoryVideo.exists.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.e = bool;
    this.f = paramRspUploadStoryVideo.check_key.get().toStringUtf8();
    this.g = paramRspUploadStoryVideo.vid.get().toStringUtf8();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetStoryVideoUploadAddressRespond{checkKey='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverIp='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverPort=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", exist=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetVideoUploadAddrResponse
 * JD-Core Version:    0.7.0.1
 */