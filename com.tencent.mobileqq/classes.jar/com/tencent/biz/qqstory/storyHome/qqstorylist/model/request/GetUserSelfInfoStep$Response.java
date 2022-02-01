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
  public String a;
  public int b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  
  public GetUserSelfInfoStep$Response(qqstory_service.RspGetUserSelfInfo paramRspGetUserSelfInfo)
  {
    String str = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    Object localObject = paramRspGetUserSelfInfo.result;
    this.jdField_a_of_type_Int = ((qqstory_struct.ErrorInfo)localObject).error_code.get();
    this.jdField_b_of_type_JavaLangString = ((qqstory_struct.ErrorInfo)localObject).error_desc.get().toStringUtf8();
    boolean bool = paramRspGetUserSelfInfo.is_vip.has();
    int j = 0;
    if (bool) {
      i = paramRspGetUserSelfInfo.is_vip.get();
    } else {
      i = 0;
    }
    this.jdField_b_of_type_Int = i;
    if (paramRspGetUserSelfInfo.union_id.has()) {
      localObject = paramRspGetUserSelfInfo.union_id.get().toStringUtf8();
    } else {
      localObject = "";
    }
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    if (paramRspGetUserSelfInfo.fans_count.has()) {
      i = paramRspGetUserSelfInfo.fans_count.get();
    } else {
      i = 0;
    }
    this.jdField_c_of_type_Int = i;
    if (paramRspGetUserSelfInfo.video_count.has()) {
      i = paramRspGetUserSelfInfo.video_count.get();
    } else {
      i = 0;
    }
    this.jdField_d_of_type_Int = i;
    int i = j;
    if (paramRspGetUserSelfInfo.visit_total_count.has()) {
      i = paramRspGetUserSelfInfo.visit_total_count.get();
    }
    this.e = i;
    if (paramRspGetUserSelfInfo.newest_video_cover.has()) {
      localObject = paramRspGetUserSelfInfo.newest_video_cover.get().toStringUtf8();
    } else {
      localObject = "";
    }
    this.jdField_c_of_type_JavaLangString = ((String)localObject);
    localObject = str;
    if (paramRspGetUserSelfInfo.newest_video_vid.has()) {
      localObject = paramRspGetUserSelfInfo.newest_video_vid.get().toStringUtf8();
    }
    this.jdField_d_of_type_JavaLangString = ((String)localObject);
  }
  
  public String toString()
  {
    return StringAppendTool.a(new Object[] { "Response{ isVip=", Integer.valueOf(this.jdField_b_of_type_Int), " fansCount=", Integer.valueOf(this.jdField_c_of_type_Int), " myVideoCount=", Integer.valueOf(this.jdField_d_of_type_Int), " myVisitTotalCount=", Integer.valueOf(this.e), " newestVideoCover=", this.jdField_c_of_type_JavaLangString, " newestVideoVid=", this.jdField_d_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.Response
 * JD-Core Version:    0.7.0.1
 */