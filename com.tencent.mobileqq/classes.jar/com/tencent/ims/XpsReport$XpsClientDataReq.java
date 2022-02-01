package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class XpsReport$XpsClientDataReq
  extends MessageMicro<XpsClientDataReq>
{
  public static final int CCDATA_FIELD_NUMBER = 2;
  public static final int SCENE_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField ccdata = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field scene_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "scene_id", "ccdata" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, XpsClientDataReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.XpsReport.XpsClientDataReq
 * JD-Core Version:    0.7.0.1
 */