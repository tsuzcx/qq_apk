package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetFeedVisitor
  extends MessageMicro<RspGetFeedVisitor>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 72 }, new String[] { "result", "user_list", "view_total_num" }, new Object[] { null, null, Integer.valueOf(0) }, RspGetFeedVisitor.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_struct.UserSimpleInfo> user_list = PBField.initRepeatMessage(qqstory_struct.UserSimpleInfo.class);
  public final PBUInt32Field view_total_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFeedVisitor
 * JD-Core Version:    0.7.0.1
 */