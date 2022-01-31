package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_pgc$ReqGetSearchFeedList
  extends MessageMicro<ReqGetSearchFeedList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField ignore_keyword = PBField.initBool(false);
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_pgc.SearchType> type_list = PBField.initRepeatMessage(qqstory_pgc.SearchType.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "key_word", "type_list", "ignore_keyword" }, new Object[] { localByteStringMicro, null, Boolean.valueOf(false) }, ReqGetSearchFeedList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetSearchFeedList
 * JD-Core Version:    0.7.0.1
 */