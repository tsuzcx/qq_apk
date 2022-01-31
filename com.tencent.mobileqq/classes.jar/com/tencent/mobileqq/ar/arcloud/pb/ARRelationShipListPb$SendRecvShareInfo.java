package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARRelationShipListPb$SendRecvShareInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 72, 80, 160, 168, 178, 186 }, new String[] { "uint64_from_uin", "uint64_topic_id", "uint64_share_id", "enum_content_type", "uint64_create_time", "str_video_url", "str_cover_url", "str_desc", "uint32_duration", "uint32_size", "rpt_uint64_to_uin", "uint32_send_recv_flag", "str_to_from_nick", "str_to_from_remark" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "" }, SendRecvShareInfo.class);
  public final PBEnumField enum_content_type = PBField.initEnum(1);
  public final PBRepeatField rpt_uint64_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField str_cover_url = PBField.initString("");
  public final PBStringField str_desc = PBField.initString("");
  public final PBStringField str_to_from_nick = PBField.initString("");
  public final PBStringField str_to_from_remark = PBField.initString("");
  public final PBStringField str_video_url = PBField.initString("");
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_recv_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_share_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.SendRecvShareInfo
 * JD-Core Version:    0.7.0.1
 */