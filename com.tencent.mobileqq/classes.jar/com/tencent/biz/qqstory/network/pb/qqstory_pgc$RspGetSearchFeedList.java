package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_pgc$RspGetSearchFeedList
  extends MessageMicro<RspGetSearchFeedList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qqstory_pgc.UserInfo> feed_list = PBField.initRepeatMessage(qqstory_pgc.UserInfo.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatField<ByteStringMicro> key_word_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
  public final PBUInt32Field result_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50 }, new String[] { "result", "result_type", "feed_list", "is_end", "next_cookie", "key_word_list" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, RspGetSearchFeedList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetSearchFeedList
 * JD-Core Version:    0.7.0.1
 */