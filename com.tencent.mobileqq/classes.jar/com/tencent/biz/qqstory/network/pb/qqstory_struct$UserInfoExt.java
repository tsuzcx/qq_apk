package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$UserInfoExt
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "my_story_forbidden", "his_story_forbidden", "deny_comment" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserInfoExt.class);
  public final PBUInt32Field deny_comment = PBField.initUInt32(0);
  public final PBUInt32Field his_story_forbidden = PBField.initUInt32(0);
  public final PBUInt32Field my_story_forbidden = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfoExt
 * JD-Core Version:    0.7.0.1
 */