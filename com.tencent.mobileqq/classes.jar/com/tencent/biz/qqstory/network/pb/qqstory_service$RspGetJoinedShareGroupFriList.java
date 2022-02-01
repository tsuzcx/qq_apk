package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class qqstory_service$RspGetJoinedShareGroupFriList
  extends MessageMicro<RspGetJoinedShareGroupFriList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatField<ByteStringMicro> uin_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "uin_list" }, new Object[] { null, localByteStringMicro }, RspGetJoinedShareGroupFriList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetJoinedShareGroupFriList
 * JD-Core Version:    0.7.0.1
 */