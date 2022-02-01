package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_user_basic_info$UserExtraInfo
  extends MessageMicro<UserExtraInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56 }, new String[] { "uin", "medal_info_list", "uint32_level", "uint32_point", "uint32_next_point", "uint32_pre_point", "version" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserExtraInfo.class);
  public final PBRepeatMessageField<ilive_user_basic_info.MedalInfo> medal_info_list = PBField.initRepeatMessage(ilive_user_basic_info.MedalInfo.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pre_point = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.UserExtraInfo
 * JD-Core Version:    0.7.0.1
 */