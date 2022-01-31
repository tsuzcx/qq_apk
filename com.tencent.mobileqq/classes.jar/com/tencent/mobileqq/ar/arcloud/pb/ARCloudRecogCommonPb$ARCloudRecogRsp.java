package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARCloudRecogCommonPb$ARCloudRecogRsp
  extends MessageMicro<ARCloudRecogRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 130, 138 }, new String[] { "str_session_id", "uin64_req_recog_type", "uin32_business_type", "msg_ar_marker_recog_result", "msg_ar_object_classify_result", "msg_face_recog_result", "msg_face_reg_result", "uint64_uin", "msg_ocr_result", "msg_game_result", "msg_word_detect_result", "msg_img_retrieval_result", "msg_face_detect_result", "msg_search_question_result", "msg_scene_classify_result", "msg_image_translate_rsp_result" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, Long.valueOf(0L), null, null, null, null, null, null, null, null }, ARCloudRecogRsp.class);
  public ARCloudRecogCustomPb.ARMarkerRecogResult msg_ar_marker_recog_result = new ARCloudRecogCustomPb.ARMarkerRecogResult();
  public ARCloudRecogCustomPb.ARObjectClassifyResult msg_ar_object_classify_result = new ARCloudRecogCustomPb.ARObjectClassifyResult();
  public ARCloudRecogCustomPb.ARFaceDetectResult msg_face_detect_result = new ARCloudRecogCustomPb.ARFaceDetectResult();
  public ARCloudRecogCustomPb.ARFaceRecogResult msg_face_recog_result = new ARCloudRecogCustomPb.ARFaceRecogResult();
  public ARCloudRecogCustomPb.ARFaceRegResult msg_face_reg_result = new ARCloudRecogCustomPb.ARFaceRegResult();
  public ARCloudRecogCustomPb.ARGameResult msg_game_result = new ARCloudRecogCustomPb.ARGameResult();
  public ARCloudRecogCustomPb.ImageTranslateRspResult msg_image_translate_rsp_result = new ARCloudRecogCustomPb.ImageTranslateRspResult();
  public ARCloudRecogCustomPb.ImgRetrievalResult msg_img_retrieval_result = new ARCloudRecogCustomPb.ImgRetrievalResult();
  public ARCloudRecogCustomPb.AROcrResult msg_ocr_result = new ARCloudRecogCustomPb.AROcrResult();
  public ARCloudRecogCustomPb.ARSceneClassifyResult msg_scene_classify_result = new ARCloudRecogCustomPb.ARSceneClassifyResult();
  public ARCloudRecogCustomPb.SearchQuestionResult msg_search_question_result = new ARCloudRecogCustomPb.SearchQuestionResult();
  public ARCloudRecogCustomPb.ARWordDetectResult msg_word_detect_result = new ARCloudRecogCustomPb.ARWordDetectResult();
  public final PBStringField str_session_id = PBField.initString("");
  public final PBUInt32Field uin32_business_type = PBField.initUInt32(0);
  public final PBUInt64Field uin64_req_recog_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb.ARCloudRecogRsp
 * JD-Core Version:    0.7.0.1
 */