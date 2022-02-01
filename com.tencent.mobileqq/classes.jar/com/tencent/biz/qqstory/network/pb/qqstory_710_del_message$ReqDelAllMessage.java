package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_710_del_message$ReqDelAllMessage
  extends MessageMicro<ReqDelAllMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start_time", "source", "version_ctrl" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqDelAllMessage.class);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBUInt32Field version_ctrl = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelAllMessage
 * JD-Core Version:    0.7.0.1
 */