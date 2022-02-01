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
    int i = paramRspGetPublishConfig.show_now_entry.get();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    if (paramRspGetPublishConfig.can_take_picture.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    if (paramRspGetPublishConfig.is_firsttime_show_take_pic.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    boolean bool1 = bool2;
    if (paramRspGetPublishConfig.video_use_bdh.get() == 1) {
      bool1 = true;
    }
    this.d = bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishConfigResponse{firstTimePic=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", nowEntry=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", takePic=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.PublishConfigResponse
 * JD-Core Version:    0.7.0.1
 */