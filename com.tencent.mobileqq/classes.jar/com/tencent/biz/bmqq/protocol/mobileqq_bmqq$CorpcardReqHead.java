package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class mobileqq_bmqq$CorpcardReqHead
  extends MessageMicro<CorpcardReqHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqHead" }, new Object[] { null }, CorpcardReqHead.class);
  public mobileqq_bmqq.HRTXHead reqHead = new mobileqq_bmqq.HRTXHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardReqHead
 * JD-Core Version:    0.7.0.1
 */