package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Crm$SvrCCMsgFlag
  extends MessageMicro<SvrCCMsgFlag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "str_text_msg" }, new Object[] { Integer.valueOf(0), "" }, SvrCCMsgFlag.class);
  public final PBStringField str_text_msg = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.Crm.SvrCCMsgFlag
 * JD-Core Version:    0.7.0.1
 */