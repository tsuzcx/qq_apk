package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ArticleCenter$GetUrlByVidRequest
  extends MessageMicro<GetUrlByVidRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBBytesField mobile_detail_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField mv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field net_type = PBField.initUInt32(0);
  public final PBUInt32Field prefer_h265 = PBField.initUInt32(0);
  public final PBBytesField user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 53, 61, 64, 74 }, new String[] { "vid", "mv", "net_type", "user_ip", "video_type", "longitude", "latitude", "prefer_h265", "mobile_detail_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), localByteStringMicro4 }, GetUrlByVidRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidRequest
 * JD-Core Version:    0.7.0.1
 */