package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class StructMsg$SendMenuEventResponse
  extends MessageMicro<SendMenuEventResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ret_info", "seqno" }, new Object[] { null, Integer.valueOf(0) }, SendMenuEventResponse.class);
  public StructMsg.RetInfo ret_info = new StructMsg.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.crmqq.structmsg.StructMsg.SendMenuEventResponse
 * JD-Core Version:    0.7.0.1
 */