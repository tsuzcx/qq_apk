package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_user_basic_info$BatchGetUserInfoReq
  extends MessageMicro<BatchGetUserInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field from_type = PBField.initUInt32(0);
  public final PBUInt32Field op_type = PBField.initUInt32(0);
  public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin_list", "op_type", "from_type" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, BatchGetUserInfoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.BatchGetUserInfoReq
 * JD-Core Version:    0.7.0.1
 */