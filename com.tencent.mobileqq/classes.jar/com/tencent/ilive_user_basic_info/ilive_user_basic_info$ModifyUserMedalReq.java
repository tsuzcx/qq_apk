package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_user_basic_info$ModifyUserMedalReq
  extends MessageMicro<ModifyUserMedalReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uid", "op_type", "level", "point", "medal_id", "medal_level", "medal_point", "start_time", "end_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ModifyUserMedalReq.class);
  public final PBUInt64Field end_time = PBField.initUInt64(0L);
  public final PBUInt32Field level = PBField.initUInt32(0);
  public final PBUInt32Field medal_id = PBField.initUInt32(0);
  public final PBUInt32Field medal_level = PBField.initUInt32(0);
  public final PBUInt32Field medal_point = PBField.initUInt32(0);
  public final PBUInt32Field op_type = PBField.initUInt32(0);
  public final PBUInt32Field point = PBField.initUInt32(0);
  public final PBUInt64Field start_time = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.ModifyUserMedalReq
 * JD-Core Version:    0.7.0.1
 */