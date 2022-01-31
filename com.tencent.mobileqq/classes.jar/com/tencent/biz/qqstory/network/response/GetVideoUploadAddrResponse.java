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
  public boolean a;
  public int b;
  public String c;
  public String d;
  
  public GetVideoUploadAddrResponse(@NonNull qqstory_service.RspUploadStoryVideo paramRspUploadStoryVideo)
  {
    super(paramRspUploadStoryVideo.result);
    this.jdField_a_of_type_JavaLangString = paramRspUploadStoryVideo.server_ip.get().toStringUtf8();
    this.b = paramRspUploadStoryVideo.server_port.get();
    if (paramRspUploadStoryVideo.exists.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.c = paramRspUploadStoryVideo.check_key.get().toStringUtf8();
      this.d = paramRspUploadStoryVideo.vid.get().toStringUtf8();
      return;
      bool = false;
    }
  }
  
  public String toString()
  {
    return "GetStoryVideoUploadAddressRespond{checkKey='" + this.c + '\'' + ", serverIp='" + this.jdField_a_of_type_JavaLangString + '\'' + ", serverPort=" + this.b + ", exist=" + this.jdField_a_of_type_Boolean + ", vid='" + this.d + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetVideoUploadAddrResponse
 * JD-Core Version:    0.7.0.1
 */