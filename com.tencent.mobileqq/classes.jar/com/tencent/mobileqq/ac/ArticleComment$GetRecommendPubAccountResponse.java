package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ArticleComment$GetRecommendPubAccountResponse
  extends MessageMicro<GetRecommendPubAccountResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<ArticleComment.Record> recom_list = PBField.initRepeatMessage(ArticleComment.Record.class);
  public final PBBytesField recom_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret", "recom_list", "recom_title" }, new Object[] { null, null, localByteStringMicro }, GetRecommendPubAccountResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.GetRecommendPubAccountResponse
 * JD-Core Version:    0.7.0.1
 */