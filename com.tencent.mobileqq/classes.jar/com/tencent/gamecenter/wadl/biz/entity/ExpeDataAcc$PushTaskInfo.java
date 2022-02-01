package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$PushTaskInfo
  extends MessageMicro<PushTaskInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "taskSysTransfer", "channelType" }, new Object[] { "", Long.valueOf(0L) }, PushTaskInfo.class);
  public final PBInt64Field channelType = PBField.initInt64(0L);
  public final PBStringField taskSysTransfer = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.PushTaskInfo
 * JD-Core Version:    0.7.0.1
 */