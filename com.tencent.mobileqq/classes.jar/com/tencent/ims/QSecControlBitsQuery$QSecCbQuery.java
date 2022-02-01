package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QSecControlBitsQuery$QSecCbQuery
  extends MessageMicro<QSecCbQuery>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cb_query_head", "cb_query_body" }, new Object[] { null, null }, QSecCbQuery.class);
  public QSecControlBitsQuery.QSecCbQueryBody cb_query_body = new QSecControlBitsQuery.QSecCbQueryBody();
  public QQProtectCommon.QQProtectQueryHead cb_query_head = new QQProtectCommon.QQProtectQueryHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.QSecControlBitsQuery.QSecCbQuery
 * JD-Core Version:    0.7.0.1
 */