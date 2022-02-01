package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x6d1$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "invite_rsp_body", "uninvite_rsp_body", "deal_invite_rsp_body" }, new Object[] { null, null, null }, RspBody.class);
  public cmd0x6d1.DealInviteRspBody deal_invite_rsp_body = new cmd0x6d1.DealInviteRspBody();
  public cmd0x6d1.InviteRspBody invite_rsp_body = new cmd0x6d1.InviteRspBody();
  public cmd0x6d1.UniviteRspBody uninvite_rsp_body = new cmd0x6d1.UniviteRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.RspBody
 * JD-Core Version:    0.7.0.1
 */