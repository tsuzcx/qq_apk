package com.tencent.biz.huiyin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HuiyinRedDotProto$RedDotSetReq
  extends MessageMicro<RedDotSetReq>
{
  public static final int APPID_FIELD_NUMBER = 3;
  public static final int CLEAR_FIELD_NUMBER = 5;
  public static final int FROM_UID_FIELD_NUMBER = 1;
  public static final int NUM_FIELD_NUMBER = 4;
  public static final int TO_UID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "from_uid", "to_uid", "appid", "num", "clear" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, RedDotSetReq.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBBoolField clear = PBField.initBool(false);
  public final PBUInt64Field from_uid = PBField.initUInt64(0L);
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBUInt64Field to_uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotSetReq
 * JD-Core Version:    0.7.0.1
 */