package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ArticleCenter$GetUrlByVidResponse
  extends MessageMicro<GetUrlByVidResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField definition = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field encode_type = PBField.initUInt32(0);
  public final PBUInt32Field file_size = PBField.initUInt32(0);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBBytesField json_video_detail = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field prefer_h265 = PBField.initUInt32(0);
  public final PBBytesField rate = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field rate_type = PBField.initUInt32(0);
  public ArticleCenter.RetInfo ret_info = new ArticleCenter.RetInfo();
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<ArticleCenter.VideoInfo> video_info = PBField.initRepeatMessage(ArticleCenter.VideoInfo.class);
  public final PBUInt32Field video_type = PBField.initUInt32(0);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48, 56, 64, 72, 80, 90, 96, 106, 114 }, new String[] { "ret_info", "vid", "url", "video_type", "rate", "rate_type", "prefer_h265", "encode_type", "width", "height", "definition", "file_size", "video_info", "json_video_detail" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), null, localByteStringMicro5 }, GetUrlByVidResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidResponse
 * JD-Core Version:    0.7.0.1
 */