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
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    Object localObject = paramRspGetUserSelfInfo.result;
    this.jdField_a_of_type_Int = ((qqstory_struct.ErrorInfo)localObject).error_code.get();
    this.jdField_b_of_type_JavaLangString = ((qqstory_struct.ErrorInfo)localObject).error_desc.get().toStringUtf8();
    int i;
    if (paramRspGetUserSelfInfo.is_vip.has())
    {
      i = paramRspGetUserSelfInfo.is_vip.get();
      this.jdField_b_of_type_Int = i;
      if (!paramRspGetUserSelfInfo.union_id.has()) {
        break label233;
      }
      localObject = paramRspGetUserSelfInfo.union_id.get().toStringUtf8();
      label96:
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (!paramRspGetUserSelfInfo.fans_count.has()) {
        break label240;
      }
      i = paramRspGetUserSelfInfo.fans_count.get();
      label120:
      this.jdField_c_of_type_Int = i;
      if (!paramRspGetUserSelfInfo.video_count.has()) {
        break label245;
      }
      i = paramRspGetUserSelfInfo.video_count.get();
      label143:
      this.jdField_d_of_type_Int = i;
      i = j;
      if (paramRspGetUserSelfInfo.visit_total_count.has()) {
        i = paramRspGetUserSelfInfo.visit_total_count.get();
      }
      this.e = i;
      if (!paramRspGetUserSelfInfo.newest_video_cover.has()) {
        break label250;
      }
      localObject = paramRspGetUserSelfInfo.newest_video_cover.get().toStringUtf8();
      label195:
      this.jdField_c_of_type_JavaLangString = ((String)localObject);
      if (!paramRspGetUserSelfInfo.newest_video_vid.has()) {
        break label257;
      }
    }
    label257:
    for (paramRspGetUserSelfInfo = paramRspGetUserSelfInfo.newest_video_vid.get().toStringUtf8();; paramRspGetUserSelfInfo = "")
    {
      this.jdField_d_of_type_JavaLangString = paramRspGetUserSelfInfo;
      return;
      i = 0;
      break;
      label233:
      localObject = "";
      break label96;
      label240:
      i = 0;
      break label120;
      label245:
      i = 0;
      break label143;
      label250:
      localObject = "";
      break label195;
    }
  }
  
  public String toString()
  {
    return StringAppendTool.a(new Object[] { "Response{ isVip=", Integer.valueOf(this.jdField_b_of_type_Int), " fansCount=", Integer.valueOf(this.jdField_c_of_type_Int), " myVideoCount=", Integer.valueOf(this.jdField_d_of_type_Int), " myVisitTotalCount=", Integer.valueOf(this.e), " newestVideoCover=", this.jdField_c_of_type_JavaLangString, " newestVideoVid=", this.jdField_d_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.Response
 * JD-Core Version:    0.7.0.1
 */