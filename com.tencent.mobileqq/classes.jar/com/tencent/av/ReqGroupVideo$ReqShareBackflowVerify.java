package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReqGroupVideo$ReqShareBackflowVerify
  extends MessageMicro<ReqShareBackflowVerify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_crypt_room_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_crypt_room_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ReqShareBackflowVerify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.ReqShareBackflowVerify
 * JD-Core Version:    0.7.0.1
 */