package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARCloudRecogCustomPb$AROcrInfo
  extends MessageMicro<AROcrInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uin64_ocr_recog_type", "youtu_ocr_req", "sougou_req", "jd_pic_search_req", "jd_hot_search_req", "jd_search_req" }, new Object[] { Long.valueOf(0L), null, null, null, null, null }, AROcrInfo.class);
  public JDSearch.JdHotSearchReq jd_hot_search_req = new JDSearch.JdHotSearchReq();
  public JDSearch.JdPicSearchReq jd_pic_search_req = new JDSearch.JdPicSearchReq();
  public JDSearch.JdSearchReq jd_search_req = new JDSearch.JdSearchReq();
  public SougouSearch.ClientRequestBodyV2 sougou_req = new SougouSearch.ClientRequestBodyV2();
  public final PBUInt64Field uin64_ocr_recog_type = PBField.initUInt64(0L);
  public YoutuOcr.YoutuOcrReq youtu_ocr_req = new YoutuOcr.YoutuOcrReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.AROcrInfo
 * JD-Core Version:    0.7.0.1
 */