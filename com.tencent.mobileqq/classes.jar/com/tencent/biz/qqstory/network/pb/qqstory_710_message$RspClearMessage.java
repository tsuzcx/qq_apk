package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$RspClearMessage
  extends MessageMicro<RspClearMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50 }, new String[] { "errinfo", "remain_num", "image_uid", "last_time", "msg_tab", "msg_dynamic" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null }, RspClearMessage.class);
  public qqstory_710_message.ErrorInfo errinfo = new qqstory_710_message.ErrorInfo();
  public final PBUInt64Field image_uid = PBField.initUInt64(0L);
  public final PBUInt32Field last_time = PBField.initUInt32(0);
  public qqstory_710_message.ClearMessageResult msg_dynamic = new qqstory_710_message.ClearMessageResult();
  public qqstory_710_message.ClearMessageResult msg_tab = new qqstory_710_message.ClearMessageResult();
  public final PBUInt32Field remain_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspClearMessage
 * JD-Core Version:    0.7.0.1
 */