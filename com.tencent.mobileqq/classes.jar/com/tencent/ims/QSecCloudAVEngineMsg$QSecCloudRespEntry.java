package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QSecCloudAVEngineMsg$QSecCloudRespEntry
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field actionType = PBField.initUInt32(0);
  public final PBUInt32Field attrType = PBField.initUInt32(0);
  public final PBUInt32Field category = PBField.initUInt32(0);
  public final PBUInt32Field entryId = PBField.initUInt32(0);
  public final PBBytesField extraInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field subCategory = PBField.initUInt32(0);
  public final PBUInt32Field timeToLive = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "entryId", "attrType", "category", "subCategory", "timeToLive", "actionType", "extraInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, QSecCloudRespEntry.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespEntry
 * JD-Core Version:    0.7.0.1
 */