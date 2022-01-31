package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ArticleComment$RecommendItemInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField recommend_source = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "url", "title", "recommend_source", "article_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RecommendItemInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.RecommendItemInfo
 * JD-Core Version:    0.7.0.1
 */