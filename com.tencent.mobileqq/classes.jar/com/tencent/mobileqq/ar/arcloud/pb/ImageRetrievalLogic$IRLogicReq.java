package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ImageRetrievalLogic$IRLogicReq
  extends MessageMicro<IRLogicReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iBusiness = PBField.initInt32(0);
  public final PBInt32Field iModel = PBField.initInt32(0);
  public final PBInt32Field iScene = PBField.initInt32(0);
  public ImageRetrievalComm.IRUserInfo stUserInfo = new ImageRetrievalComm.IRUserInfo();
  public final PBBytesField vImage = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "stUserInfo", "iBusiness", "iScene", "vImage", "iModel" }, new Object[] { null, localInteger, localInteger, localByteStringMicro, localInteger }, IRLogicReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.IRLogicReq
 * JD-Core Version:    0.7.0.1
 */