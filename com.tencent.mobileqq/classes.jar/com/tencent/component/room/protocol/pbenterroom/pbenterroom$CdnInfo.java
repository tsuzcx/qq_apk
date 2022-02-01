package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class pbenterroom$CdnInfo
  extends MessageMicro<CdnInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "url_host", "url_param" }, new Object[] { "", "" }, CdnInfo.class);
  public final PBStringField url_host = PBField.initString("");
  public final PBStringField url_param = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.CdnInfo
 * JD-Core Version:    0.7.0.1
 */