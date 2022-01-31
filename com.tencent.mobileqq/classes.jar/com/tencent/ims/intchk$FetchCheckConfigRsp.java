package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$FetchCheckConfigRsp
  extends MessageMicro
{
  public static final int RPT_MSG_CHECK_ITEM_FIELD_NUMBER = 3;
  public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 2;
  public static final int UINT32_NEED_INTCHK_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_need_intchk", "uint32_intchk_id", "rpt_msg_check_item" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, FetchCheckConfigRsp.class);
  public final PBRepeatMessageField rpt_msg_check_item = PBField.initRepeatMessage(intchk.CheckItem.class);
  public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_intchk = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.ims.intchk.FetchCheckConfigRsp
 * JD-Core Version:    0.7.0.1
 */