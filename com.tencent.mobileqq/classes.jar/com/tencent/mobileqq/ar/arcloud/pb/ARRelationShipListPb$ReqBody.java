package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARRelationShipListPb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> rpt_uint64_peer_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_list_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_recv_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_del_to_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_share_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint32_req_list_type", "bytes_req_page_cookies", "uint32_req_count", "uint64_start_time", "uint64_topic_id", "rpt_uint64_peer_uin", "uint64_share_id", "uint32_send_recv_flag", "uint64_del_to_uin" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.ReqBody
 * JD-Core Version:    0.7.0.1
 */