package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfigFile;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetConfigFileResponse
  extends BaseResponse
{
  public final String a;
  public final int b;
  public final String c;
  
  public GetConfigFileResponse(qqstory_service.RspGetConfigFile paramRspGetConfigFile)
  {
    super(paramRspGetConfigFile.result);
    this.b = paramRspGetConfigFile.config_file_type.get();
    this.a = paramRspGetConfigFile.config_download_url.get().toStringUtf8();
    this.c = paramRspGetConfigFile.config_download_md5.get().toStringUtf8();
  }
  
  public String toString()
  {
    return "GetConfigFileResponse{mType=" + this.b + ", mDownloadZipUrl='" + this.a + '\'' + ", mDownloadFileMd5='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetConfigFileResponse
 * JD-Core Version:    0.7.0.1
 */