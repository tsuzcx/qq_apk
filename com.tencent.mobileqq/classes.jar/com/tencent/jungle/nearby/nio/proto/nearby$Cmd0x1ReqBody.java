package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby$Cmd0x1ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_bars = PBField.initBool(false);
  public final PBBoolField bool_face_score = PBField.initBool(false);
  public final PBBoolField bool_fans = PBField.initBool(false);
  public final PBBoolField bool_published = PBField.initBool(false);
  public oidb_common.CommParamReq bytes_comm_param = new oidb_common.CommParamReq();
  public final PBBytesField bytes_user_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field uint32_client_addr = PBField.initFixed32(0);
  public final PBUInt32Field uint32_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_req_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_req_uid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_user_uid = PBField.initUInt64(0L);
  public nearby.LoginSig user_login_sig = new nearby.LoginSig();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 45, 48, 56, 64, 72, 82, 88, 96, 106 }, new String[] { "uint32_seq", "uint64_req_uid", "uint64_req_tinyid", "bytes_user_cookie", "uint32_client_addr", "bool_published", "bool_bars", "bool_fans", "uint64_user_uid", "user_login_sig", "uint32_from", "bool_face_score", "bytes_comm_param" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(0L), null, Integer.valueOf(0), Boolean.valueOf(false), null }, Cmd0x1ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1ReqBody
 * JD-Core Version:    0.7.0.1
 */