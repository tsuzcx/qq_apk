package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SafeReport$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "LogItem_reportdata" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<SafeReport.LogItem> LogItem_reportdata = PBField.initRepeatMessage(SafeReport.LogItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ims.SafeReport.ReqBody
 * JD-Core Version:    0.7.0.1
 */