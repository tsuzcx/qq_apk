package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$ImageARTag
  extends MessageMicro<ImageARTag>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field cdb_errorcode = PBField.initInt32(0);
  public final PBBytesField cdb_res = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field conf_id = PBField.initInt32(0);
  public final PBStringField image_id = PBField.initString("");
  public final PBUInt32Field need_check_lbs = PBField.initUInt32(0);
  public final PBInt32Field tag_confidence = PBField.initInt32(0);
  public final PBFloatField tag_confidence_f = PBField.initFloat(0.0F);
  public final PBStringField tag_name = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 37, 40, 808, 818, 824 }, new String[] { "image_id", "tag_name", "tag_confidence", "tag_confidence_f", "need_check_lbs", "cdb_errorcode", "cdb_res", "conf_id" }, new Object[] { "", "", Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, ImageARTag.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageARTag
 * JD-Core Version:    0.7.0.1
 */