package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SecSharedInfo$FileInfo
  extends MessageMicro<FileInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "package_name", "soft_name", "cert_md5", "apk_filesize" }, new Object[] { "", "", "", Integer.valueOf(0) }, FileInfo.class);
  public final PBUInt32Field apk_filesize = PBField.initUInt32(0);
  public final PBStringField cert_md5 = PBField.initString("");
  public final PBStringField package_name = PBField.initString("");
  public final PBStringField soft_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.SecSharedInfo.FileInfo
 * JD-Core Version:    0.7.0.1
 */