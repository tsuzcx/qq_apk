package com.tencent.biz.huiyin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class HuiyinRedDotProto$RetInfo
  extends MessageMicro<RetInfo>
{
  public static final int ERR_MSG_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.huiyin.HuiyinRedDotProto.RetInfo
 * JD-Core Version:    0.7.0.1
 */