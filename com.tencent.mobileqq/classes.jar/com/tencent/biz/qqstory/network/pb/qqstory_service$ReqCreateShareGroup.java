package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqCreateShareGroup
  extends MessageMicro<ReqCreateShareGroup>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "share_group_info", "member_list", "show_in_friend_story_main_page" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, ReqCreateShareGroup.class);
  public final PBRepeatField<Long> member_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public qqstory_struct.ShareGroupInfo share_group_info = new qqstory_struct.ShareGroupInfo();
  public final PBUInt32Field show_in_friend_story_main_page = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCreateShareGroup
 * JD-Core Version:    0.7.0.1
 */