package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetUserGuide
  extends MessageMicro<RspGetUserGuide>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cancel_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField confirm_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50 }, new String[] { "result", "pic_url", "word", "seqno", "confirm_word", "cancel_word" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, RspGetUserGuide.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserGuide
 * JD-Core Version:    0.7.0.1
 */