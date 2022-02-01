package com.tencent.biz.qqstory.channel;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class BaseResponse
{
  public int a;
  public String b;
  
  public BaseResponse() {}
  
  public BaseResponse(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public BaseResponse(qqstory_struct.ErrorInfo paramErrorInfo)
  {
    this.a = paramErrorInfo.error_code.get();
    this.b = paramErrorInfo.error_desc.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.BaseResponse
 * JD-Core Version:    0.7.0.1
 */