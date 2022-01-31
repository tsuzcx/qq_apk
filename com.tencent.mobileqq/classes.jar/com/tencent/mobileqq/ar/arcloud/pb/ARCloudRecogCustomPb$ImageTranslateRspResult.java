package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ARCloudRecogCustomPb$ImageTranslateRspResult
  extends MessageMicro<ImageTranslateRspResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field image_translate_err_code = PBField.initInt32(0);
  public final PBBytesField image_translate_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<ARCloudRecogCustomPb.ImageRecord> msg_image_record_list = PBField.initRepeatMessage(ARCloudRecogCustomPb.ImageRecord.class);
  public final PBBytesField session_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField source_lange = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> support_translate_lang = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField target_lang = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "image_translate_err_code", "image_translate_err_msg", "session_uuid", "source_lange", "target_lang", "msg_image_record_list", "support_translate_lang" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, localByteStringMicro5 }, ImageTranslateRspResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageTranslateRspResult
 * JD-Core Version:    0.7.0.1
 */