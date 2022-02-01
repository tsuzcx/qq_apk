package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_2$CmdS2CInviteReqBody
  extends MessageMicro<CmdS2CInviteReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 114, 136 }, new String[] { "msg_temp_session", "uint32_new_business_flag" }, new Object[] { null, Integer.valueOf(0) }, CmdS2CInviteReqBody.class);
  public hd_video_2.InviteTempSessionData msg_temp_session = new hd_video_2.InviteTempSessionData();
  public final PBUInt32Field uint32_new_business_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.hd_video_2.CmdS2CInviteReqBody
 * JD-Core Version:    0.7.0.1
 */