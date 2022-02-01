package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPublishConfig;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class PublishConfigResponse
  extends BaseResponse
{
  @Deprecated
  public boolean a;
  @Deprecated
  public boolean b;
  @Deprecated
  public boolean c;
  public boolean d;
  
  public PublishConfigResponse(qqstory_service.RspGetPublishConfig paramRspGetPublishConfig)
  {
    super(paramRspGetPublishConfig.result);
    if (paramRspGetPublishConfig.show_now_entry.get() == 1)
    {
      bool1 = true;
      this.a = bool1;
      if (paramRspGetPublishConfig.can_take_picture.get() != 1) {
        break label88;
      }
      bool1 = true;
      label41:
      this.b = bool1;
      if (paramRspGetPublishConfig.is_firsttime_show_take_pic.get() != 1) {
        break label93;
      }
      bool1 = true;
      label59:
      this.c = bool1;
      if (paramRspGetPublishConfig.video_use_bdh.get() != 1) {
        break label98;
      }
    }
    label88:
    label93:
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label41;
      bool1 = false;
      break label59;
    }
  }
  
  public String toString()
  {
    return "PublishConfigResponse{firstTimePic=" + this.c + ", nowEntry=" + this.a + ", takePic=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.PublishConfigResponse
 * JD-Core Version:    0.7.0.1
 */