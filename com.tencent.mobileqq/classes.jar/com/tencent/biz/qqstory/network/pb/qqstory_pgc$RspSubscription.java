package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_pgc$RspSubscription
  extends MessageMicro<RspSubscription>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "is_subscribe" }, new Object[] { null, Integer.valueOf(0) }, RspSubscription.class);
  public final PBUInt32Field is_subscribe = PBField.initUInt32(0);
  public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspSubscription
 * JD-Core Version:    0.7.0.1
 */