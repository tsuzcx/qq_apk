package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_user_basic_info$BatchGetMedalInfoRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "medalinfo_list", "result" }, new Object[] { null, Integer.valueOf(0) }, BatchGetMedalInfoRsp.class);
  public final PBRepeatMessageField medalinfo_list = PBField.initRepeatMessage(ilive_user_basic_info.MedalInfo.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.BatchGetMedalInfoRsp
 * JD-Core Version:    0.7.0.1
 */