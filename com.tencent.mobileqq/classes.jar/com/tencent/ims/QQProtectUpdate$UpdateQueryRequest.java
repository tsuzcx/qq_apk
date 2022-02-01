package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQProtectUpdate$UpdateQueryRequest
  extends MessageMicro<UpdateQueryRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head_update_query", "body_update_query" }, new Object[] { null, null }, UpdateQueryRequest.class);
  public QQProtectUpdate.UpdateQueryBody body_update_query = new QQProtectUpdate.UpdateQueryBody();
  public QQProtectCommon.QQProtectQueryHead head_update_query = new QQProtectCommon.QQProtectQueryHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ims.QQProtectUpdate.UpdateQueryRequest
 * JD-Core Version:    0.7.0.1
 */