package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ReqGroupVideo$RspCheckGroupCanJoin
  extends MessageMicro<RspCheckGroupCanJoin>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField is_can_join = PBField.initBool(false);
  public final PBBytesField join_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public common.ErrorInfo result = new common.ErrorInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "result", "is_can_join", "join_wording" }, new Object[] { null, Boolean.valueOf(false), localByteStringMicro }, RspCheckGroupCanJoin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.RspCheckGroupCanJoin
 * JD-Core Version:    0.7.0.1
 */