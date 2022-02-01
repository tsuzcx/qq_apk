package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARRelationShipListPb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rsp_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<ARRelationShipListPb.SendRecvShareInfo> rpt_send_recv_share_list = PBField.initRepeatMessage(ARRelationShipListPb.SendRecvShareInfo.class);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_recv_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_send_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "uint32_share_flag", "rpt_send_recv_share_list", "uint32_is_end", "bytes_rsp_page_cookies", "uint32_total_send_count", "uint32_total_recv_count" }, new Object[] { localInteger, null, localInteger, localByteStringMicro, localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.RspBody
 * JD-Core Version:    0.7.0.1
 */