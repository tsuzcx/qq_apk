package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AccountSecurityInfo$SecCheckBanner
  extends MessageMicro<SecCheckBanner>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_wording", "u32_timeToShow" }, new Object[] { "", Integer.valueOf(0) }, SecCheckBanner.class);
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field u32_timeToShow = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ims.AccountSecurityInfo.SecCheckBanner
 * JD-Core Version:    0.7.0.1
 */