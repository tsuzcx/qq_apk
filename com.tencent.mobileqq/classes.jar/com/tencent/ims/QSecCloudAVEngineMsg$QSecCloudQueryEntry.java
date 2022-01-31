package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QSecCloudAVEngineMsg$QSecCloudQueryEntry
  extends MessageMicro<QSecCloudQueryEntry>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField appName = PBField.initString("");
  public final PBStringField certMd5 = PBField.initString("");
  public final PBUInt32Field entryId = PBField.initUInt32(0);
  public final PBBytesField extraInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField fileMd5 = PBField.initString("");
  public final PBStringField fileName = PBField.initString("");
  public final PBUInt32Field fileSize = PBField.initUInt32(0);
  public final PBUInt32Field fileType = PBField.initUInt32(0);
  public final PBStringField packageName = PBField.initString("");
  public final PBUInt32Field scenarioType = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82 }, new String[] { "entryId", "fileType", "scenarioType", "fileSize", "packageName", "fileName", "appName", "fileMd5", "certMd5", "extraInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", localByteStringMicro }, QSecCloudQueryEntry.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryEntry
 * JD-Core Version:    0.7.0.1
 */