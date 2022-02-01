package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_user_basic_info$BatchGetMedalInfoReq
  extends MessageMicro<BatchGetMedalInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "medal_id_list" }, new Object[] { Integer.valueOf(0) }, BatchGetMedalInfoReq.class);
  public final PBRepeatField<Integer> medal_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.BatchGetMedalInfoReq
 * JD-Core Version:    0.7.0.1
 */