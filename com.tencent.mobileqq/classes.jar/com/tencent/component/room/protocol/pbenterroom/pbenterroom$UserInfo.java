package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class pbenterroom$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBUInt64Field explicit_uid = PBField.initUInt64(0L);
  public final PBStringField head_url = PBField.initString("");
  public final PBUInt64Field imsdk_tinyid = PBField.initUInt64(0L);
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt64Field noble_begin_ts = PBField.initUInt64(0L);
  public final PBUInt64Field noble_end_ts = PBField.initUInt64(0L);
  public final PBUInt32Field noble_level = PBField.initUInt32(0);
  public final PBUInt32Field sex = PBField.initUInt32(0);
  public final PBUInt32Field user_role = PBField.initUInt32(0);
  public final PBUInt32Field user_type = PBField.initUInt32(0);
  public final PBUInt64Field userid = PBField.initUInt64(0L);
  public final PBUInt64Field vip_explicit_uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 64, 72, 82, 88, 96, 104, 120 }, new String[] { "userid", "sex", "name", "logo", "user_type", "explicit_uid", "noble_level", "noble_begin_ts", "noble_end_ts", "head_url", "user_role", "imsdk_tinyid", "vip_explicit_uid", "client_type" }, new Object[] { localLong, localInteger, "", "", localInteger, localLong, localInteger, localLong, localLong, "", localInteger, localLong, localLong, localInteger }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.UserInfo
 * JD-Core Version:    0.7.0.1
 */