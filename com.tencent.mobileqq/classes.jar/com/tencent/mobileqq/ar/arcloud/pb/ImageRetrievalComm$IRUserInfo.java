package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ImageRetrievalComm$IRUserInfo
  extends MessageMicro<IRUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "sUid", "sUname" }, new Object[] { "", "" }, IRUserInfo.class);
  public final PBStringField sUid = PBField.initString("");
  public final PBStringField sUname = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalComm.IRUserInfo
 * JD-Core Version:    0.7.0.1
 */