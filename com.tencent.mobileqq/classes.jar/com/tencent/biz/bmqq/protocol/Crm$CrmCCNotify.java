package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Crm$CrmCCNotify
  extends MessageMicro<CrmCCNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_video_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public Crm.CrmAllocKfext crm_alloc_kfext = new Crm.CrmAllocKfext();
  public final PBUInt32Field crm_flag = PBField.initUInt32(0);
  public final PBUInt32Field crm_user_type = PBField.initUInt32(0);
  public Crm.LightTalkMsg light_talk_msg = new Crm.LightTalkMsg();
  public Crm.C2CActionReport msg_c2c_action_report = new Crm.C2CActionReport();
  public Crm.GrayMsg msg_gray_msg = new Crm.GrayMsg();
  public Crm.LinkTextWithOpenAIOAction msg_linktext_withOepenAIO = new Crm.LinkTextWithOpenAIOAction();
  public Crm.QidianGroupMsg qidian_group_msg = new Crm.QidianGroupMsg();
  public final PBStringField str_check_id = PBField.initString("");
  public final PBStringField str_client_headurl = PBField.initString("");
  public final PBStringField str_client_nickname = PBField.initString("");
  public final PBStringField str_ext_nick_name = PBField.initString("");
  public final PBStringField str_publicacc_name = PBField.initString("");
  public final PBStringField str_visitId = PBField.initString("");
  public final PBStringField str_wx_openid = PBField.initString("");
  public Crm.SvrCCMsgFlag svr_cc_msg_flag = new Crm.SvrCCMsgFlag();
  public final PBUInt32Field uint32_IsTipsMode = PBField.initUInt32(0);
  public final PBUInt64Field uint64_pubacc_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_real_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 106, 112, 122, 130, 138, 226, 338, 354 }, new String[] { "crm_flag", "crm_alloc_kfext", "str_wx_openid", "bytes_video_uuid", "crm_user_type", "uint64_real_uin", "str_client_headurl", "str_client_nickname", "uint64_pubacc_id", "str_publicacc_name", "light_talk_msg", "msg_linktext_withOepenAIO", "msg_c2c_action_report", "uint32_IsTipsMode", "svr_cc_msg_flag", "qidian_group_msg", "str_visitId", "msg_gray_msg", "str_check_id", "str_ext_nick_name" }, new Object[] { Integer.valueOf(0), null, "", localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), "", "", Long.valueOf(0L), "", null, null, null, Integer.valueOf(0), null, null, "", null, "", "" }, CrmCCNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify
 * JD-Core Version:    0.7.0.1
 */