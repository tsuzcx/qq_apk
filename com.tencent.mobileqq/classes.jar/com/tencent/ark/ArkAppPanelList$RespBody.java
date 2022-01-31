package com.tencent.ark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ArkAppPanelList$RespBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "apps" }, new Object[] { null }, RespBody.class);
  public final PBRepeatMessageField apps = PBField.initRepeatMessage(ArkAppPanelList.AppDetail.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.ark.ArkAppPanelList.RespBody
 * JD-Core Version:    0.7.0.1
 */