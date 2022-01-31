package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ArticleComment$RecommendInfo
  extends MessageMicro<RecommendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField echo_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rowkey", "echo_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, RecommendInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.RecommendInfo
 * JD-Core Version:    0.7.0.1
 */