package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspMsgTabNodeList
  extends MessageMicro<RspMsgTabNodeList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_animate = PBField.initUInt32(0);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField list_seq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_service.MsgTabNodeInfo> node_list = PBField.initRepeatMessage(qqstory_service.MsgTabNodeInfo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "result", "list_seq", "next_cookie", "is_end", "node_list", "is_animate" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null, Integer.valueOf(0) }, RspMsgTabNodeList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeList
 * JD-Core Version:    0.7.0.1
 */