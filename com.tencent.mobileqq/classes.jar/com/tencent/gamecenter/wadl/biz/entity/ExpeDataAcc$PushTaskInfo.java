package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$PushTaskInfo
  extends MessageMicro<PushTaskInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "task_sys_transfer", "channel_type" }, new Object[] { "", Long.valueOf(0L) }, PushTaskInfo.class);
  public final PBInt64Field channel_type = PBField.initInt64(0L);
  public final PBStringField task_sys_transfer = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.PushTaskInfo
 * JD-Core Version:    0.7.0.1
 */