package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserSelfInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetUserSelfInfoStep$Response
  extends BaseResponse
{
  public int a;
  public String b;
  public int e;
  public int f;
  public int g;
  public String h;
  public String i;
  
  public GetUserSelfInfoStep$Response(qqstory_service.RspGetUserSelfInfo paramRspGetUserSelfInfo)
  {
    String str = "";
    this.h = "";
    this.i = "";
    Object localObject = paramRspGetUserSelfInfo.result;
    this.c = ((qqstory_struct.ErrorInfo)localObject).error_code.get();
    this.d = ((qqstory_struct.ErrorInfo)localObject).error_desc.get().toStringUtf8();
    boolean bool = paramRspGetUserSelfInfo.is_vip.has();
    int k = 0;
    if (bool) {
      j = paramRspGetUserSelfInfo.is_vip.get();
    } else {
      j = 0;
    }
    this.a = j;
    if (paramRspGetUserSelfInfo.union_id.has()) {
      localObject = paramRspGetUserSelfInfo.union_id.get().toStringUtf8();
    } else {
      localObject = "";
    }
    this.b = ((String)localObject);
    if (paramRspGetUserSelfInfo.fans_count.has()) {
      j = paramRspGetUserSelfInfo.fans_count.get();
    } else {
      j = 0;
    }
    this.e = j;
    if (paramRspGetUserSelfInfo.video_count.has()) {
      j = paramRspGetUserSelfInfo.video_count.get();
    } else {
      j = 0;
    }
    this.f = j;
    int j = k;
    if (paramRspGetUserSelfInfo.visit_total_count.has()) {
      j = paramRspGetUserSelfInfo.visit_total_count.get();
    }
    this.g = j;
    if (paramRspGetUserSelfInfo.newest_video_cover.has()) {
      localObject = paramRspGetUserSelfInfo.newest_video_cover.get().toStringUtf8();
    } else {
      localObject = "";
    }
    this.h = ((String)localObject);
    localObject = str;
    if (paramRspGetUserSelfInfo.newest_video_vid.has()) {
      localObject = paramRspGetUserSelfInfo.newest_video_vid.get().toStringUtf8();
    }
    this.i = ((String)localObject);
  }
  
  public String toString()
  {
    return StringAppendTool.a(new Object[] { "Response{ isVip=", Integer.valueOf(this.a), " fansCount=", Integer.valueOf(this.e), " myVideoCount=", Integer.valueOf(this.f), " myVisitTotalCount=", Integer.valueOf(this.g), " newestVideoCover=", this.h, " newestVideoVid=", this.i });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.Response
 * JD-Core Version:    0.7.0.1
 */