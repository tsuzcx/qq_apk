package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class mobileqq_bmqq$CorpcardRspHead
  extends MessageMicro<CorpcardRspHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rspHead" }, new Object[] { null }, CorpcardRspHead.class);
  public mobileqq_bmqq.HRTXHead rspHead = new mobileqq_bmqq.HRTXHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardRspHead
 * JD-Core Version:    0.7.0.1
 */