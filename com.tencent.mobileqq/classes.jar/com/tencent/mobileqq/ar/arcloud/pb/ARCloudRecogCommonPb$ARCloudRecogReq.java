package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARCloudRecogCommonPb$ARCloudRecogReq
  extends MessageMicro<ARCloudRecogReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public ARCloudRecogCustomPb.ARMarkerRecogInfo msg_ar_marker_recog_info = new ARCloudRecogCustomPb.ARMarkerRecogInfo();
  public ARCloudRecogCommonPb.ARFileReqInfo msg_ar_req_file_info = new ARCloudRecogCommonPb.ARFileReqInfo();
  public ARCloudRecogCustomPb.ARFaceDetectInfo msg_face_detect_info = new ARCloudRecogCustomPb.ARFaceDetectInfo();
  public ARCloudRecogCustomPb.ARFaceRecogInfo msg_face_recog_info = new ARCloudRecogCustomPb.ARFaceRecogInfo();
  public ARCloudRecogCustomPb.ARFaceRegInfo msg_face_reg_info = new ARCloudRecogCustomPb.ARFaceRegInfo();
  public ARCloudRecogCustomPb.ARGameInfo msg_game_info = new ARCloudRecogCustomPb.ARGameInfo();
  public ARCloudRecogCustomPb.ImageTranslateReqInfo msg_image_translate_req_info = new ARCloudRecogCustomPb.ImageTranslateReqInfo();
  public ARCloudRecogCustomPb.ImgRetrievalInfo msg_img_retrieval_info = new ARCloudRecogCustomPb.ImgRetrievalInfo();
  public ARCloudRecogCustomPb.ARObjectClassifyInfo msg_object_classify_info = new ARCloudRecogCustomPb.ARObjectClassifyInfo();
  public ARCloudRecogCustomPb.AROcrInfo msg_ocr_info = new ARCloudRecogCustomPb.AROcrInfo();
  public ARCloudRecogCustomPb.ARSceneClassifyInfo msg_scene_classify_info = new ARCloudRecogCustomPb.ARSceneClassifyInfo();
  public ARCloudRecogCustomPb.SearchQuestionInfo msg_search_question_info = new ARCloudRecogCustomPb.SearchQuestionInfo();
  public ARCloudRecogCustomPb.ARWordDetectInfo msg_word_detect_info = new ARCloudRecogCustomPb.ARWordDetectInfo();
  public final PBStringField str_clt_version = PBField.initString("");
  public final PBStringField str_session_id = PBField.initString("");
  public final PBUInt32Field uin32_business_type = PBField.initUInt32(0);
  public final PBUInt64Field uin64_req_recog_type = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_lat = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lon = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130, 138, 146, 162, 170 }, new String[] { "str_session_id", "msg_ar_req_file_info", "uint32_lon", "uint32_lat", "uin64_req_recog_type", "uin32_business_type", "msg_ar_marker_recog_info", "msg_object_classify_info", "msg_face_recog_info", "msg_face_reg_info", "str_clt_version", "uint64_uin", "msg_ocr_info", "msg_game_info", "msg_word_detect_info", "msg_img_retrieval_info", "msg_face_detect_info", "msg_search_question_info", "msg_scene_classify_info", "msg_image_translate_req_info" }, new Object[] { "", null, localInteger, localInteger, Long.valueOf(0L), localInteger, null, null, null, null, "", Long.valueOf(0L), null, null, null, null, null, null, null, null }, ARCloudRecogReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb.ARCloudRecogReq
 * JD-Core Version:    0.7.0.1
 */