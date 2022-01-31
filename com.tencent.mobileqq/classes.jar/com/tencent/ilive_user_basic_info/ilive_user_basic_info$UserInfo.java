package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_user_basic_info$UserInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin", "basic_info", "extra_info" }, new Object[] { Long.valueOf(0L), null, null }, UserInfo.class);
  public ilive_user_basic_info.UserBasicInfo basic_info = new ilive_user_basic_info.UserBasicInfo();
  public ilive_user_basic_info.UserExtraInfo extra_info = new ilive_user_basic_info.UserExtraInfo();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.UserInfo
 * JD-Core Version:    0.7.0.1
 */