package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_user_basic_info$GetDisplayMinMedalLevelReq
  extends MessageMicro<GetDisplayMinMedalLevelReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "from_type" }, new Object[] { Integer.valueOf(0) }, GetDisplayMinMedalLevelReq.class);
  public final PBUInt32Field from_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.GetDisplayMinMedalLevelReq
 * JD-Core Version:    0.7.0.1
 */