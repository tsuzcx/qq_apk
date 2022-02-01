package com.tencent.ark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ArkAppPanelList$AppDetail
  extends MessageMicro<AppDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "appName", "cnName", "iconUrl" }, new Object[] { "", "", "" }, AppDetail.class);
  public final PBStringField appName = PBField.initString("");
  public final PBStringField cnName = PBField.initString("");
  public final PBStringField iconUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkAppPanelList.AppDetail
 * JD-Core Version:    0.7.0.1
 */