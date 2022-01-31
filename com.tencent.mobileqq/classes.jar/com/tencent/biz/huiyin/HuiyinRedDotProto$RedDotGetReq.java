package com.tencent.biz.huiyin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HuiyinRedDotProto$RedDotGetReq
  extends MessageMicro<RedDotGetReq>
{
  public static final int APPID_FIELD_NUMBER = 1;
  public static final int UID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "uid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, RedDotGetReq.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotGetReq
 * JD-Core Version:    0.7.0.1
 */