package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x6d1$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "invite_req_body", "uninvite_req_body", "deal_invite_req_body" }, new Object[] { null, null, null }, ReqBody.class);
  public cmd0x6d1.DealInviteReqBody deal_invite_req_body = new cmd0x6d1.DealInviteReqBody();
  public cmd0x6d1.InviteReqBody invite_req_body = new cmd0x6d1.InviteReqBody();
  public final PBUInt32Field uint32_app_type = PBField.initUInt32(0);
  public cmd0x6d1.UninviteReqBody uninvite_req_body = new cmd0x6d1.UninviteReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.ReqBody
 * JD-Core Version:    0.7.0.1
 */