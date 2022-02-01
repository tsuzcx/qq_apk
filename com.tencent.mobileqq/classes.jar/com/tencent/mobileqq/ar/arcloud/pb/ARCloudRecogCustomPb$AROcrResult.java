package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARCloudRecogCustomPb$AROcrResult
  extends MessageMicro<AROcrResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uin64_ocr_recog_type", "youtu_ocr_rsp", "sougou_rsp", "jd_pic_search_rsp", "jd_hot_search_rsp", "jd_search_rsp" }, new Object[] { Long.valueOf(0L), null, null, null, null, null }, AROcrResult.class);
  public JDSearch.JdHotSearchRsp jd_hot_search_rsp = new JDSearch.JdHotSearchRsp();
  public JDSearch.JdPicSearchRsp jd_pic_search_rsp = new JDSearch.JdPicSearchRsp();
  public JDSearch.JdSearchRsp jd_search_rsp = new JDSearch.JdSearchRsp();
  public SougouSearch.ServerResponseBodyV2 sougou_rsp = new SougouSearch.ServerResponseBodyV2();
  public final PBUInt64Field uin64_ocr_recog_type = PBField.initUInt64(0L);
  public YoutuOcr.YoutuOcrRsp youtu_ocr_rsp = new YoutuOcr.YoutuOcrRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.AROcrResult
 * JD-Core Version:    0.7.0.1
 */