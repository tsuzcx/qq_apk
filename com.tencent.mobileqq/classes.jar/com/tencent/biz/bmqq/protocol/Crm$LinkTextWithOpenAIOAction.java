package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Crm$LinkTextWithOpenAIOAction
  extends MessageMicro<LinkTextWithOpenAIOAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_uin", "str_link_text", "str_attach_content" }, new Object[] { Long.valueOf(0L), "", "" }, LinkTextWithOpenAIOAction.class);
  public final PBStringField str_attach_content = PBField.initString("");
  public final PBStringField str_link_text = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.Crm.LinkTextWithOpenAIOAction
 * JD-Core Version:    0.7.0.1
 */