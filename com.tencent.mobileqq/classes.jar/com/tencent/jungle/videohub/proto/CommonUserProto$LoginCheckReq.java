package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CommonUserProto$LoginCheckReq
  extends MessageMicro<LoginCheckReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "refresh", "is_test", "group_code", "room_code" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L) }, LoginCheckReq.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBBoolField is_test = PBField.initBool(false);
  public final PBBoolField refresh = PBField.initBool(false);
  public final PBUInt64Field room_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.jungle.videohub.proto.CommonUserProto.LoginCheckReq
 * JD-Core Version:    0.7.0.1
 */