package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QSecCloudAVEngineMsg$QSecCloudRespBody
  extends MessageMicro<QSecCloudRespBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "status", "version", "respEntry" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, QSecCloudRespBody.class);
  public final PBRepeatMessageField<QSecCloudAVEngineMsg.QSecCloudRespEntry> respEntry = PBField.initRepeatMessage(QSecCloudAVEngineMsg.QSecCloudRespEntry.class);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespBody
 * JD-Core Version:    0.7.0.1
 */