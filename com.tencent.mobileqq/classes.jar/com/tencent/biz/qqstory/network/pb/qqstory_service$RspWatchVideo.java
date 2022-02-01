package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspWatchVideo
  extends MessageMicro<RspWatchVideo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "unread_count" }, new Object[] { null, Integer.valueOf(0) }, RspWatchVideo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field unread_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo
 * JD-Core Version:    0.7.0.1
 */