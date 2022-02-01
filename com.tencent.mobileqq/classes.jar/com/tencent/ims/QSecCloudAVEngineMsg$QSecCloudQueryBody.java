package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QSecCloudAVEngineMsg$QSecCloudQueryBody
  extends MessageMicro<QSecCloudQueryBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "version", "queryEntry" }, new Object[] { Integer.valueOf(0), null }, QSecCloudQueryBody.class);
  public final PBRepeatMessageField<QSecCloudAVEngineMsg.QSecCloudQueryEntry> queryEntry = PBField.initRepeatMessage(QSecCloudAVEngineMsg.QSecCloudQueryEntry.class);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryBody
 * JD-Core Version:    0.7.0.1
 */