package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ILiveChanneSvr$GetIMSigRsp
  extends MessageMicro<GetIMSigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field err = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "err", "sig" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GetIMSigRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.GetIMSigRsp
 * JD-Core Version:    0.7.0.1
 */