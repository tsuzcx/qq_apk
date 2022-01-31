package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Crm$QidianGroupMsg
  extends MessageMicro<QidianGroupMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint32_group_task_id", "uint32_group_msg_type", "uint64_kfuin", "uint32_show_tip", "str_tip_text" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, QidianGroupMsg.class);
  public final PBStringField str_tip_text = PBField.initString("");
  public final PBUInt32Field uint32_group_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_task_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_tip = PBField.initUInt32(0);
  public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.Crm.QidianGroupMsg
 * JD-Core Version:    0.7.0.1
 */