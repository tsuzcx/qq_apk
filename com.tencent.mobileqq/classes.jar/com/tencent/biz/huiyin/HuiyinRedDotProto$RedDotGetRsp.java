package com.tencent.biz.huiyin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HuiyinRedDotProto$RedDotGetRsp
  extends MessageMicro<RedDotGetRsp>
{
  public static final int RETINFO_FIELD_NUMBER = 1;
  public static final int TOTALNUM_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "retinfo", "totalNum" }, new Object[] { null, Long.valueOf(0L) }, RedDotGetRsp.class);
  public HuiyinRedDotProto.RetInfo retinfo = new HuiyinRedDotProto.RetInfo();
  public final PBUInt64Field totalNum = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotGetRsp
 * JD-Core Version:    0.7.0.1
 */