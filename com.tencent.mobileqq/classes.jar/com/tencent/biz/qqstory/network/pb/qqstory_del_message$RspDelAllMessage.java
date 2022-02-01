package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_del_message$RspDelAllMessage
  extends MessageMicro<RspDelAllMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "errinfo", "remain_num", "image_uid", "last_time" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspDelAllMessage.class);
  public qqstory_del_message.ErrorInfo errinfo = new qqstory_del_message.ErrorInfo();
  public final PBUInt64Field image_uid = PBField.initUInt64(0L);
  public final PBUInt32Field last_time = PBField.initUInt32(0);
  public final PBUInt32Field remain_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_del_message.RspDelAllMessage
 * JD-Core Version:    0.7.0.1
 */