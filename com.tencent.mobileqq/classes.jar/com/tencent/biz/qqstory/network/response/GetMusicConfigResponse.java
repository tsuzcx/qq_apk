package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;

public class GetMusicConfigResponse
  extends BaseResponse
{
  public qqstory_service.RspGetMusicListConfig a = null;
  
  public GetMusicConfigResponse(qqstory_service.RspGetMusicListConfig paramRspGetMusicListConfig)
  {
    super(paramRspGetMusicListConfig.result);
    this.a = paramRspGetMusicListConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetMusicConfigResponse
 * JD-Core Version:    0.7.0.1
 */