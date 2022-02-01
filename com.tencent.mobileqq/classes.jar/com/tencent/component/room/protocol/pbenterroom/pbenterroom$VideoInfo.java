package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbenterroom$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> bytes_video_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<pbenterroom.CdnInfo> cdn_infos = PBField.initRepeatMessage(pbenterroom.CdnInfo.class);
  public final PBBytesField tptm = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_id = PBField.initUInt32(0);
  public final PBRepeatField<Integer> video_mgr_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field video_status = PBField.initUInt32(0);
  public final PBRepeatField<Integer> video_svr_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> video_svr_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 56, 66 }, new String[] { "video_status", "video_id", "cdn_infos", "video_svr_ip", "video_svr_port", "tptm", "video_mgr_ip", "bytes_video_urls" }, new Object[] { localInteger, localInteger, null, localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2 }, VideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.VideoInfo
 * JD-Core Version:    0.7.0.1
 */