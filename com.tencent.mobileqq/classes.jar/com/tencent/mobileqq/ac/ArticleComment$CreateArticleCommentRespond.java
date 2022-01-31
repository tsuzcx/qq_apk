package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ArticleComment$CreateArticleCommentRespond
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret", "comment_id" }, new Object[] { null, localByteStringMicro }, CreateArticleCommentRespond.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.CreateArticleCommentRespond
 * JD-Core Version:    0.7.0.1
 */