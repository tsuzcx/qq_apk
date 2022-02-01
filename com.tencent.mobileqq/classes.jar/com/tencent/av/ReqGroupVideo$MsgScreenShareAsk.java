package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReqGroupVideo$MsgScreenShareAsk
  extends MessageMicro<MsgScreenShareAsk>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField ask_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "from_uin", "ask_wording" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, MsgScreenShareAsk.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.MsgScreenShareAsk
 * JD-Core Version:    0.7.0.1
 */