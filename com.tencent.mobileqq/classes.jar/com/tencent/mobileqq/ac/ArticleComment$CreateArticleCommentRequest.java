package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ArticleComment$CreateArticleCommentRequest
  extends MessageMicro<CreateArticleCommentRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField comment = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field hide_name = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "article_id", "uin", "comment", "hide_name" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0) }, CreateArticleCommentRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.CreateArticleCommentRequest
 * JD-Core Version:    0.7.0.1
 */