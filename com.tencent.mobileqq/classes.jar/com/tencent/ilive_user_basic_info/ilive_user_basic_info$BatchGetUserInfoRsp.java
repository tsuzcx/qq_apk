package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_user_basic_info$BatchGetUserInfoRsp
  extends MessageMicro<BatchGetUserInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "userinfo_list", "result" }, new Object[] { null, Integer.valueOf(0) }, BatchGetUserInfoRsp.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBRepeatMessageField<ilive_user_basic_info.UserInfo> userinfo_list = PBField.initRepeatMessage(ilive_user_basic_info.UserInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.BatchGetUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */