package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbenterroom$VoiceInfo
  extends MessageMicro<VoiceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> bytes_voice_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Integer> ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBBytesField voiceConnKey = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "ip", "port", "voiceConnKey", "bytes_voice_urls" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2 }, VoiceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.VoiceInfo
 * JD-Core Version:    0.7.0.1
 */