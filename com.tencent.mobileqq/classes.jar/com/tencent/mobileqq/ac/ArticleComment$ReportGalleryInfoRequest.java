package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ArticleComment$ReportGalleryInfoRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field article_id = PBField.initUInt32(0);
  public final PBBytesField article_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field browse_time = PBField.initUInt32(0);
  public final PBUInt32Field client_ip = PBField.initUInt32(0);
  public final PBBytesField echo_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_qq = PBField.initUInt32(0);
  public final PBBytesField mv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField network = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField os = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBUInt32Field recommend_index = PBField.initUInt32(0);
  public final PBRepeatMessageField recommend_info = PBField.initRepeatMessage(ArticleComment.RecommendInfo.class);
  public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field site_id = PBField.initUInt32(0);
  public final PBBytesField subv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ts = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 66, 74, 82, 88, 96, 104, 114, 120, 128, 138 }, new String[] { "uin", "puin", "article_id", "article_url", "is_qq", "os", "mv", "subv", "network", "rowkey", "ts", "site_id", "recommend_index", "echo_info", "client_ip", "browse_time", "recommend_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), null }, ReportGalleryInfoRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.ReportGalleryInfoRequest
 * JD-Core Version:    0.7.0.1
 */