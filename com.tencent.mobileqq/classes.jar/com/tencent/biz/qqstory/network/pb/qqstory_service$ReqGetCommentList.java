package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqGetCommentList
  extends MessageMicro<ReqGetCommentList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field latest_comment_id = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "vid", "latest_comment_id", "cookie" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ReqGetCommentList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetCommentList
 * JD-Core Version:    0.7.0.1
 */