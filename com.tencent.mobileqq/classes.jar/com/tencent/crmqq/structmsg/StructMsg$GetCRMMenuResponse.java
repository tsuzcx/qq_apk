package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StructMsg$GetCRMMenuResponse
  extends MessageMicro<GetCRMMenuResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<StructMsg.ButtonInfo> button_info = PBField.initRepeatMessage(StructMsg.ButtonInfo.class);
  public StructMsg.RetInfo ret_info = new StructMsg.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field update_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "ret_info", "seqno", "uin", "button_info", "update_type" }, new Object[] { null, localInteger, Long.valueOf(0L), null, localInteger }, GetCRMMenuResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse
 * JD-Core Version:    0.7.0.1
 */