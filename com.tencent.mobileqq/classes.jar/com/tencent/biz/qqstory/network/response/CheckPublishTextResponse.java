package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckText;

public class CheckPublishTextResponse
  extends BaseResponse
{
  public CheckPublishTextResponse(qqstory_service.RspCheckText paramRspCheckText)
  {
    super(paramRspCheckText.result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.CheckPublishTextResponse
 * JD-Core Version:    0.7.0.1
 */