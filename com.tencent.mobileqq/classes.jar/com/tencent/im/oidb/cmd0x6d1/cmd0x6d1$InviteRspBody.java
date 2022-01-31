package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x6d1$InviteRspBody
  extends MessageMicro<InviteRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_invited_uin_list", "rpt_uninvited_uin_list" }, new Object[] { null, null }, InviteRspBody.class);
  public final PBRepeatMessageField<cmd0x6d1.ItemInfo> rpt_invited_uin_list = PBField.initRepeatMessage(cmd0x6d1.ItemInfo.class);
  public final PBRepeatMessageField<cmd0x6d1.ItemInfo> rpt_uninvited_uin_list = PBField.initRepeatMessage(cmd0x6d1.ItemInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.InviteRspBody
 * JD-Core Version:    0.7.0.1
 */