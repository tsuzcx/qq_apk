package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDeleteVideo;

public class DeleteVideoRespond
  extends BaseResponse
{
  public DeleteVideoRespond(qqstory_service.RspDeleteVideo paramRspDeleteVideo)
  {
    super(paramRspDeleteVideo.result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.DeleteVideoRespond
 * JD-Core Version:    0.7.0.1
 */