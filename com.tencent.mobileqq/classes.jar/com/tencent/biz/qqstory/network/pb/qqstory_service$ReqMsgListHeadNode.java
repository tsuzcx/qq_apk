package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqMsgListHeadNode
  extends MessageMicro<ReqMsgListHeadNode>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "current_seq", "uin_list", "source" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, ReqMsgListHeadNode.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgListHeadNode
 * JD-Core Version:    0.7.0.1
 */