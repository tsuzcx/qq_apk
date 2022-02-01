package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChanneSvr$GetIMSigReq
  extends MessageMicro<GetIMSigReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field refer = PBField.initUInt32(0);
  public final PBBytesField st = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uid", "st", "refer", "appid" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, GetIMSigReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.GetIMSigReq
 * JD-Core Version:    0.7.0.1
 */