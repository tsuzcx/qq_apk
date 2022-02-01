package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QSecCloudAVEngineMsg$QSecCloudQuery
  extends MessageMicro<QSecCloudQuery>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "body" }, new Object[] { null, null }, QSecCloudQuery.class);
  public QSecCloudAVEngineMsg.QSecCloudQueryBody body = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
  public QQProtectCommon.QQProtectQueryHead head = new QQProtectCommon.QQProtectQueryHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQuery
 * JD-Core Version:    0.7.0.1
 */