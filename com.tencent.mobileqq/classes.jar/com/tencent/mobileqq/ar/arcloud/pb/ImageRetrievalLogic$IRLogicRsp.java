package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ImageRetrievalLogic$IRLogicRsp
  extends MessageMicro<IRLogicRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iBusiness = PBField.initInt32(0);
  public final PBInt32Field iRetCode = PBField.initInt32(0);
  public final PBStringField sKey = PBField.initString("");
  public final PBStringField sMsg = PBField.initString("");
  public ImageRetrievalComm.OD_BBox stBBox = new ImageRetrievalComm.OD_BBox();
  public final PBRepeatMessageField<ImageRetrievalLogic.RetrievalClassInfo> vClassInfo = PBField.initRepeatMessage(ImageRetrievalLogic.RetrievalClassInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "iRetCode", "sMsg", "vClassInfo", "iBusiness", "sKey", "stBBox" }, new Object[] { localInteger, "", null, localInteger, "", null }, IRLogicRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.IRLogicRsp
 * JD-Core Version:    0.7.0.1
 */