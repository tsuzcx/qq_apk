package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspQQStoryGuide;

public class QQStoryGuideRequest$QQStoryGuideResponse
  extends BaseResponse
{
  public QQStoryGuideRequest$QQStoryGuideResponse(qqstory_service.RspQQStoryGuide paramRspQQStoryGuide)
  {
    super(paramRspQQStoryGuide.result);
  }
  
  public String toString()
  {
    return "QQStoryGuideResponse{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest.QQStoryGuideResponse
 * JD-Core Version:    0.7.0.1
 */