package com.tencent.mobileqq.ar.arcloud;

import aalm;
import aaln;
import aalo;
import android.text.TextUtils;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARLBSHandler;
import com.tencent.mobileqq.ar.ARLBSObserver;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb.ARCloudRecogReq;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb.ARCloudRecogRsp;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb.ARFileReqInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARFaceRecogInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARFaceRecogRes;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARFaceRecogResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARMarkerRecogInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARMarkerRecogResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARObjectClassifyInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARObjectClassifyResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.AROcrInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.AROcrResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARSceneClassifyInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARSceneClassifyResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARWordDetectInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARWordDetectResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.FaceRect;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageARSearchRes;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageARTag;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImgRetrievalInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImgRetrievalResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.QuestionRes;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.SearchQuestionInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.SearchQuestionResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.StarInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalComm.OD_BBox;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.IRLogicRsp;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.LabelSource;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.LabelSource1003;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.LabelSource1004;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.LabelSourceCommon;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.RetrievalClassInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.RetrievalItem;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchReq;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchRsp;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrReq;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrRsp;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult.ImageTag;
import com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult.ImageTag;
import com.tencent.mobileqq.ar.arengine.ARCloudPreOcrResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogReqFaceInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogReqObjectClassifyInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogReqPreOcrInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogReqSceneRecogInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult.StarInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqMarkerInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudSceneRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudSceneRecogResult.ImageTag;
import com.tencent.mobileqq.ar.arengine.ARFaceDataCollector;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.LabelSource;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.ObjectBox;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalClassInfo;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalItem;
import com.tencent.mobileqq.ar.arengine.SearchQuestionResult;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.ocr.ARCloudReqOcrInfo;
import com.tencent.mobileqq.ocr.data.ARCloudOcrResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ARCloudFileUpload
{
  protected AppInterface a;
  ARLBSObserver jdField_a_of_type_ComTencentMobileqqArARLBSObserver = null;
  private ARCloudFileUpload.ARCloudLBSLocationCheckCallback jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudLBSLocationCheckCallback;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public ARCloudFileUpload(AppInterface paramAppInterface)
  {
    this(paramAppInterface, false);
  }
  
  public ARCloudFileUpload(AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(paramBoolean);
  }
  
  private ARCloudRecogResult a(byte[] paramArrayOfByte, ARCloudReqInfo paramARCloudReqInfo)
  {
    ARCloudRecogResult localARCloudRecogResult = new ARCloudRecogResult();
    ARCloudRecogCommonPb.ARCloudRecogRsp localARCloudRecogRsp = new ARCloudRecogCommonPb.ARCloudRecogRsp();
    long l1;
    label72:
    label100:
    Object localObject1;
    Object localObject2;
    label161:
    label188:
    label239:
    int k;
    label266:
    label292:
    Object localObject3;
    Object localObject4;
    label394:
    label420:
    int j;
    label447:
    float f;
    label475:
    label503:
    boolean bool;
    for (;;)
    {
      try
      {
        localARCloudRecogRsp.mergeFrom(paramArrayOfByte);
        if (!localARCloudRecogRsp.str_session_id.has()) {
          break label5265;
        }
        paramArrayOfByte = localARCloudRecogRsp.str_session_id.get();
        localARCloudRecogResult.jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.uin64_req_recog_type.has()) {
          break label5271;
        }
        l1 = localARCloudRecogRsp.uin64_req_recog_type.get();
        localARCloudRecogResult.jdField_a_of_type_Long = l1;
        if (!localARCloudRecogRsp.uin32_business_type.has()) {
          break label5277;
        }
        i = localARCloudRecogRsp.uin32_business_type.get();
        localARCloudRecogResult.jdField_a_of_type_Int = i;
        if (!localARCloudRecogRsp.msg_ar_marker_recog_result.has()) {
          break label1292;
        }
        localObject1 = new ARCloudMarkerRecogResult();
        localObject2 = (ARCloudRecogCustomPb.ARMarkerRecogResult)localARCloudRecogRsp.msg_ar_marker_recog_result.get();
        if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errorcode.has()) {
          break label5283;
        }
        i = ((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errorcode.get();
        ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errormsg.has()) {
          break label5289;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errormsg.get();
        ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_res.has()) {
          break label1245;
        }
        localObject2 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_res.get();
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.has()) {
          break label5295;
        }
        i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.get();
        ((ARCloudMarkerRecogResult)localObject1).jdField_b_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.has()) {
          break label5301;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.get();
        ((ARCloudMarkerRecogResult)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.has()) {
          break label5307;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.get();
        ((ARCloudMarkerRecogResult)localObject1).jdField_d_of_type_JavaLangString = paramArrayOfByte;
        if ((((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.has()) && (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size() > 0))
        {
          k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size();
          ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag = new ARCloudMarkerRecogResult.ImageTag[k];
          i = 0;
          if (i < k)
          {
            localObject3 = new ARCloudMarkerRecogResult.ImageTag();
            localObject4 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.get(i);
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.has()) {
              break label5313;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.get();
            ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.has()) {
              break label5319;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.get();
            ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_b_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.has()) {
              break label5325;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.get();
            ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_a_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.has()) {
              break label5331;
            }
            f = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.get();
            ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_a_of_type_Float = f;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.has()) {
              break label5337;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.get();
            ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_b_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.has()) {
              break label5343;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.get();
            label531:
            ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_c_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.has()) {
              break label5349;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.get().toByteArray();
            label561:
            ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag[i] = localObject3;
            i += 1;
            continue;
          }
          if (k > 0)
          {
            if (localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag[0].jdField_b_of_type_Int != 1) {
              break label5354;
            }
            bool = true;
            label608:
            ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_Boolean = bool;
          }
          if (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.has())
          {
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.get();
            ((ARCloudMarkerRecogResult)localObject1).jdField_c_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.has()) {
              break label1233;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.get();
            ((ARCloudMarkerRecogResult)localObject1).jdField_d_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.has()) {
              break label1239;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.get();
            ((ARCloudMarkerRecogResult)localObject1).e = i;
            localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult = ((ARCloudMarkerRecogResult)localObject1);
            if (!localARCloudRecogRsp.msg_ar_object_classify_result.has()) {
              break label2988;
            }
            localObject1 = new ARCloudObjectClassifyResult();
            localObject2 = (ARCloudRecogCustomPb.ARObjectClassifyResult)localARCloudRecogRsp.msg_ar_object_classify_result.get();
            if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errorcode.has()) {
              break label5360;
            }
            i = ((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errorcode.get();
            label760:
            ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errormsg.has()) {
              break label5366;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errormsg.get();
            label787:
            ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).image_ar_search_res.has()) {
              break label2941;
            }
            localObject2 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).image_ar_search_res.get();
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.has()) {
              break label5372;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.get();
            label838:
            ((ARCloudObjectClassifyResult)localObject1).jdField_b_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.has()) {
              break label5378;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.get();
            label865:
            ((ARCloudObjectClassifyResult)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.has()) {
              break label5384;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.get();
            label891:
            ((ARCloudObjectClassifyResult)localObject1).jdField_d_of_type_JavaLangString = paramArrayOfByte;
            if ((!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.has()) || (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size() <= 0)) {
              break label2932;
            }
            k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size();
            ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag = new ARCloudObjectClassifyResult.ImageTag[k];
            i = 0;
            if (i >= k) {
              break;
            }
            localObject3 = new ARCloudObjectClassifyResult.ImageTag();
            localObject4 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.get(i);
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.has()) {
              break label5390;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.get();
            label993:
            ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.has()) {
              break label5396;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.get();
            label1019:
            ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_b_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.has()) {
              break label5402;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.get();
            label1046:
            ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_a_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.has()) {
              break label5408;
            }
            f = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.get();
            label1074:
            ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_a_of_type_Float = f;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.has()) {
              break label5414;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.get();
            label1102:
            ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_b_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.has()) {
              break label5420;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.get();
            label1130:
            ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_c_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.has()) {
              break label5426;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.get().toByteArray();
            label1160:
            ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[i] = localObject3;
            i += 1;
            continue;
          }
        }
        else
        {
          ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag = null;
          continue;
        }
        i = 0;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("AREngine_ARCloudFileUpload", 1, "deserialize pb failed. error msg = " + paramArrayOfByte.getMessage());
        return null;
      }
      continue;
      label1233:
      i = 0;
      continue;
      label1239:
      i = 0;
      continue;
      label1245:
      ((ARCloudMarkerRecogResult)localObject1).jdField_b_of_type_Int = -1;
      ((ARCloudMarkerRecogResult)localObject1).jdField_c_of_type_JavaLangString = "";
      ((ARCloudMarkerRecogResult)localObject1).jdField_d_of_type_JavaLangString = "";
      ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag = null;
      ((ARCloudMarkerRecogResult)localObject1).jdField_c_of_type_Int = 0;
      ((ARCloudMarkerRecogResult)localObject1).jdField_d_of_type_Int = 0;
      ((ARCloudMarkerRecogResult)localObject1).e = 0;
      continue;
      label1292:
      localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult = null;
    }
    label1323:
    label1351:
    label1379:
    label1407:
    double d;
    if (k > 0)
    {
      if (localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].jdField_b_of_type_Int == 1)
      {
        bool = true;
        ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_Boolean = bool;
      }
    }
    else
    {
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.has()) {
        break label5437;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.get();
      ((ARCloudObjectClassifyResult)localObject1).jdField_c_of_type_Int = i;
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.has()) {
        break label5443;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.get();
      ((ARCloudObjectClassifyResult)localObject1).jdField_d_of_type_Int = i;
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.has()) {
        break label5449;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.get();
      ((ARCloudObjectClassifyResult)localObject1).e = i;
      label1414:
      localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult = ((ARCloudObjectClassifyResult)localObject1);
      label1421:
      localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
      label1489:
      label1516:
      label1651:
      label1784:
      label1916:
      Object localObject5;
      if (localARCloudRecogRsp.msg_img_retrieval_result.has())
      {
        localObject1 = new ARMIGObjectClassifyResult();
        ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        localObject2 = (ARCloudRecogCustomPb.ImgRetrievalResult)localARCloudRecogRsp.msg_img_retrieval_result.get();
        if (!((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).errorcode.has()) {
          break label5455;
        }
        i = ((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).errorcode.get();
        ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).errormsg.has()) {
          break label5461;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).errormsg.get();
        ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).jd_search_rsp.has()) {
          ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult = ARMIGObjectClassifyResult.a((JDSearch.JdSearchRsp)((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).jd_search_rsp.get());
        }
        if (((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).msg_ir_logic_rsp.has())
        {
          localObject2 = (ImageRetrievalLogic.IRLogicRsp)((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).msg_ir_logic_rsp.get();
          if (!((ImageRetrievalLogic.IRLogicRsp)localObject2).iRetCode.has()) {
            break label5467;
          }
          i = ((ImageRetrievalLogic.IRLogicRsp)localObject2).iRetCode.get();
          label1597:
          ((ARMIGObjectClassifyResult)localObject1).jdField_b_of_type_Int = i;
          if (!((ImageRetrievalLogic.IRLogicRsp)localObject2).sMsg.has()) {
            break label5473;
          }
          paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject2).sMsg.get();
          label1624:
          ((ARMIGObjectClassifyResult)localObject1).jdField_b_of_type_JavaLangString = paramArrayOfByte;
          if (!((ImageRetrievalLogic.IRLogicRsp)localObject2).iBusiness.has()) {
            break label5479;
          }
          i = ((ImageRetrievalLogic.IRLogicRsp)localObject2).iBusiness.get();
          ((ARMIGObjectClassifyResult)localObject1).jdField_c_of_type_Int = i;
          if (!((ImageRetrievalLogic.IRLogicRsp)localObject2).sKey.has()) {
            break label5485;
          }
          paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject2).sKey.get();
          label1678:
          ((ARMIGObjectClassifyResult)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
          ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox = null;
          if (((ImageRetrievalLogic.IRLogicRsp)localObject2).stBBox.has())
          {
            ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox = new ARMIGObjectClassifyResult.ObjectBox();
            paramArrayOfByte = (ImageRetrievalComm.OD_BBox)((ImageRetrievalLogic.IRLogicRsp)localObject2).stBBox.get();
            localObject3 = ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
            if (!paramArrayOfByte.xmin.has()) {
              break label5491;
            }
            i = paramArrayOfByte.xmin.get();
            label1751:
            ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_a_of_type_Int = i;
            localObject3 = ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
            if (!paramArrayOfByte.xmax.has()) {
              break label5497;
            }
            i = paramArrayOfByte.xmax.get();
            ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_b_of_type_Int = i;
            localObject3 = ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
            if (!paramArrayOfByte.ymin.has()) {
              break label5503;
            }
            i = paramArrayOfByte.ymin.get();
            label1817:
            ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_c_of_type_Int = i;
            localObject3 = ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
            if (!paramArrayOfByte.ymax.has()) {
              break label5509;
            }
            i = paramArrayOfByte.ymax.get();
            label1850:
            ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_d_of_type_Int = i;
            localObject3 = ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
            if (!paramArrayOfByte.fScore.has()) {
              break label5515;
            }
            f = paramArrayOfByte.fScore.get();
            label1883:
            ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_a_of_type_Float = f;
            localObject3 = ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
            if (!paramArrayOfByte.iLabelID.has()) {
              break label5521;
            }
            i = paramArrayOfByte.iLabelID.get();
            ((ARMIGObjectClassifyResult.ObjectBox)localObject3).e = i;
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARCloudFileUpload", 2, "[MIGObjectclassifyResult 矩形区域原始数据打印]" + ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.toString());
            }
          }
          if ((((ImageRetrievalLogic.IRLogicRsp)localObject2).vClassInfo.has()) && (((ImageRetrievalLogic.IRLogicRsp)localObject2).vClassInfo.size() > 0))
          {
            int m = ((ImageRetrievalLogic.IRLogicRsp)localObject2).vClassInfo.size();
            ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo = new ARMIGObjectClassifyResult.RetrievalClassInfo[m];
            localObject2 = ((ImageRetrievalLogic.IRLogicRsp)localObject2).vClassInfo.get();
            i = 0;
            for (;;)
            {
              if (i >= m) {
                break label3016;
              }
              localObject3 = (ImageRetrievalLogic.RetrievalClassInfo)((List)localObject2).get(i);
              localObject4 = new ARMIGObjectClassifyResult.RetrievalClassInfo();
              if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iClass.has()) {
                break label5527;
              }
              j = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iClass.get();
              label2069:
              ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_Int = j;
              if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iStatus.has()) {
                break label5533;
              }
              j = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iStatus.get();
              label2097:
              ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_b_of_type_Int = j;
              if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).dClassProb.has()) {
                break label5539;
              }
              d = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).dClassProb.get();
              label2124:
              ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_Double = d;
              if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).sClass.has()) {
                break label5544;
              }
              paramArrayOfByte = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).sClass.get();
              label2150:
              ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_JavaLangString = paramArrayOfByte;
              if ((((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.has()) && (((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size() > 0)) {
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem = new ARMIGObjectClassifyResult.RetrievalItem[((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size()];
              }
              if ((((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.has()) && (((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size() > 0))
              {
                j = 0;
                for (;;)
                {
                  if (j < ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size())
                  {
                    localObject5 = new ARMIGObjectClassifyResult.RetrievalItem();
                    Object localObject6 = (ImageRetrievalLogic.RetrievalItem)((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.get(j);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iClass.has()) {
                      break label5550;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iClass.get();
                    label2277:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sClass.has()) {
                      break label5556;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sClass.get();
                    label2304:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).dProb.has()) {
                      break label5562;
                    }
                    d = ((ImageRetrievalLogic.RetrievalItem)localObject6).dProb.get();
                    label2330:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_Double = d;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sItemID.has()) {
                      break label5567;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sItemID.get();
                    label2356:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_b_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iSource.has()) {
                      break label5573;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iSource.get();
                    label2383:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_b_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sPicUrl.has()) {
                      break label5579;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sPicUrl.get();
                    label2410:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_c_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sTitle.has()) {
                      break label5585;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sTitle.get();
                    label2436:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_d_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sWiki.has()) {
                      break label5591;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sWiki.get();
                    label2462:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sJumpUrl.has()) {
                      break label5597;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sJumpUrl.get();
                    label2488:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).f = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sCdbRes.has()) {
                      break label5603;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sCdbRes.get().toByteArray();
                    label2517:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iAutoJump.has()) {
                      break label5614;
                    }
                    if (((ImageRetrievalLogic.RetrievalItem)localObject6).iAutoJump.get() != 1) {
                      break label5608;
                    }
                    bool = true;
                    label2549:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_Boolean = bool;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iNeedCheckLBS.has()) {
                      break label5620;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iNeedCheckLBS.get();
                    label2577:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_c_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sImageId.has()) {
                      break label5626;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sImageId.get();
                    label2604:
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).g = paramArrayOfByte;
                    if (((ImageRetrievalLogic.RetrievalItem)localObject6).stLabel.has())
                    {
                      localObject6 = (ImageRetrievalLogic.LabelSource)((ImageRetrievalLogic.RetrievalItem)localObject6).stLabel.get();
                      ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource = new ARMIGObjectClassifyResult.LabelSource();
                      ARMIGObjectClassifyResult.LabelSource localLabelSource;
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.sLabel.has()) {
                          break label5632;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.sLabel.get();
                        label2690:
                        localLabelSource.jdField_a_of_type_JavaLangString = paramArrayOfByte;
                      }
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sTitle.has()) {
                          break label5638;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sTitle.get();
                        label2740:
                        localLabelSource.jdField_b_of_type_JavaLangString = paramArrayOfByte;
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sISBN.has()) {
                          break label5644;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sISBN.get();
                        label2779:
                        localLabelSource.jdField_c_of_type_JavaLangString = paramArrayOfByte;
                      }
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCity.has()) {
                          break label5650;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCity.get();
                        label2829:
                        localLabelSource.e = paramArrayOfByte;
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCountry.has()) {
                          break label5656;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCountry.get();
                        label2868:
                        localLabelSource.jdField_d_of_type_JavaLangString = paramArrayOfByte;
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sTour.has()) {
                          break label5662;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sTour.get();
                        label2907:
                        localLabelSource.f = paramArrayOfByte;
                      }
                    }
                    ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem[j] = localObject5;
                    j += 1;
                    continue;
                    label2932:
                    ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag = null;
                    break;
                    label2941:
                    ((ARCloudObjectClassifyResult)localObject1).jdField_b_of_type_Int = -1;
                    ((ARCloudObjectClassifyResult)localObject1).jdField_c_of_type_JavaLangString = "";
                    ((ARCloudObjectClassifyResult)localObject1).jdField_d_of_type_JavaLangString = "";
                    ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag = null;
                    ((ARCloudObjectClassifyResult)localObject1).jdField_c_of_type_Int = 0;
                    ((ARCloudObjectClassifyResult)localObject1).jdField_d_of_type_Int = 0;
                    ((ARCloudObjectClassifyResult)localObject1).e = 0;
                    break label1414;
                    label2988:
                    localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult = null;
                    break label1421;
                  }
                }
              }
              ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i] = localObject4;
              i += 1;
            }
          }
        }
        label3016:
        ((ARMIGObjectClassifyResult)localObject1).jdField_a_of_type_Boolean = ((ARMIGObjectClassifyResult)localObject1).d();
        ((ARMIGObjectClassifyResult)localObject1).jdField_d_of_type_JavaLangString = ((ARMIGObjectClassifyResult)localObject1).b();
        localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = ((ARMIGObjectClassifyResult)localObject1);
      }
      if (localARCloudRecogRsp.msg_word_detect_result.has())
      {
        localObject1 = new ARCloudPreOcrResult();
        if (!localARCloudRecogRsp.msg_word_detect_result.errorcode.has()) {
          break label5668;
        }
        i = localARCloudRecogRsp.msg_word_detect_result.errorcode.get();
        label3090:
        ((ARCloudPreOcrResult)localObject1).jdField_a_of_type_Int = i;
        if (!localARCloudRecogRsp.msg_word_detect_result.errormsg.has()) {
          break label5674;
        }
        paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.errormsg.get();
        label3123:
        ((ARCloudPreOcrResult)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.msg_word_detect_result.session_id.has()) {
          break label5680;
        }
        paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.session_id.get();
        label3155:
        ((ARCloudPreOcrResult)localObject1).jdField_b_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.has()) {
          break label5686;
        }
        i = localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.get();
        label3188:
        ((ARCloudPreOcrResult)localObject1).jdField_b_of_type_Int = i;
        if (!localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.has()) {
          break label5692;
        }
        paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.get();
        label3221:
        ((ARCloudPreOcrResult)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.msg_word_detect_result.word_type.has()) {
          break label5698;
        }
        i = localARCloudRecogRsp.msg_word_detect_result.word_type.get();
        label3254:
        ((ARCloudPreOcrResult)localObject1).jdField_c_of_type_Int = i;
        if (!localARCloudRecogRsp.msg_word_detect_result.confidence.has()) {
          break label5704;
        }
        f = localARCloudRecogRsp.msg_word_detect_result.confidence.get();
        label3288:
        ((ARCloudPreOcrResult)localObject1).jdField_a_of_type_Float = f;
        if (((ARCloudPreOcrResult)localObject1).a())
        {
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult = ((ARCloudPreOcrResult)localObject1);
          if (!localARCloudRecogRsp.msg_ocr_result.has()) {
            break label4191;
          }
          paramArrayOfByte = new ARCloudOcrResult();
          localObject1 = (ARCloudRecogCustomPb.AROcrResult)localARCloudRecogRsp.msg_ocr_result.get();
          if (!((ARCloudRecogCustomPb.AROcrResult)localObject1).uin64_ocr_recog_type.has()) {
            break label5710;
          }
          l1 = ((ARCloudRecogCustomPb.AROcrResult)localObject1).uin64_ocr_recog_type.get();
          label3363:
          if (((1L & l1) == 1L) && (((ARCloudRecogCustomPb.AROcrResult)localObject1).youtu_ocr_rsp.has())) {
            paramArrayOfByte.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult = ARCloudOcrResult.a((YoutuOcr.YoutuOcrRsp)((ARCloudRecogCustomPb.AROcrResult)localObject1).youtu_ocr_rsp.get());
          }
          if (((l1 & 0x10) > 1L) && (((ARCloudRecogCustomPb.AROcrResult)localObject1).jd_search_rsp.has())) {
            paramArrayOfByte.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult = ARCloudOcrResult.a((JDSearch.JdSearchRsp)((ARCloudRecogCustomPb.AROcrResult)localObject1).jd_search_rsp.get());
          }
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult = paramArrayOfByte;
        }
      }
      label3501:
      label3528:
      label3665:
      label3691:
      label3951:
      label4084:
      for (;;)
      {
        label3447:
        if (localARCloudRecogRsp.msg_face_recog_result.has())
        {
          localObject2 = new ARCloudRecogRspFaceResult();
          localObject1 = (ARCloudRecogCustomPb.ARFaceRecogResult)localARCloudRecogRsp.msg_face_recog_result.get();
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errorcode.has()) {
            break label5718;
          }
          i = ((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errorcode.get();
          ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_Int = i;
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errormsg.has()) {
            break label5724;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errormsg.get();
          ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize  faceResult.errCode_MQ = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_Int + ",faceResult.errMsg_MQ = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_JavaLangString);
          }
          if (((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_Int != 0) {
            break label4951;
          }
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).image_ar_face_recog_res.has()) {
            break label5730;
          }
          paramArrayOfByte = (ARCloudRecogCustomPb.ARFaceRecogRes)((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).image_ar_face_recog_res.get();
          if (paramArrayOfByte != null)
          {
            if (!paramArrayOfByte.errorcode.has()) {
              break label5735;
            }
            i = paramArrayOfByte.errorcode.get();
            ((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_Int = i;
            if (!paramArrayOfByte.errormsg.has()) {
              break label5741;
            }
            localObject1 = paramArrayOfByte.errormsg.get();
            ((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
            if (!paramArrayOfByte.session_id.has()) {
              break label5748;
            }
            localObject1 = paramArrayOfByte.session_id.get();
            ((ARCloudRecogRspFaceResult)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
            if (!paramArrayOfByte.time_ms.has()) {
              break label5755;
            }
            i = paramArrayOfByte.time_ms.get();
            ((ARCloudRecogRspFaceResult)localObject2).jdField_c_of_type_Int = i;
            if (!paramArrayOfByte.group_size.has()) {
              break label5761;
            }
            i = paramArrayOfByte.group_size.get();
            ((ARCloudRecogRspFaceResult)localObject2).jdField_d_of_type_Int = i;
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize  faceResult.errCode_YT = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_Int + ",faceResult.errMsg_YT = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_JavaLangString + ",faceResult.sessionID = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_c_of_type_JavaLangString + ",faceResult.time_ms_YT = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_c_of_type_Int + ",faceResult.group_size_YT = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_d_of_type_Int);
            }
            if (((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_Int == 0)
            {
              if (!paramArrayOfByte.star_info.has()) {
                break label5767;
              }
              paramArrayOfByte = paramArrayOfByte.star_info.get();
              if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
              {
                localObject1 = new ArrayList();
                localObject3 = paramArrayOfByte.iterator();
                for (;;)
                {
                  if (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (ARCloudRecogCustomPb.StarInfo)((Iterator)localObject3).next();
                    localObject5 = new ARCloudRecogRspFaceResult.StarInfo();
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).uin.has()) {
                      break label5772;
                    }
                    l1 = ((ARCloudRecogCustomPb.StarInfo)localObject4).uin.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_a_of_type_Long = l1;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).face_rect_id.has()) {
                      break label5780;
                    }
                    i = ((ARCloudRecogCustomPb.StarInfo)localObject4).face_rect_id.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_a_of_type_Int = i;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).name.has()) {
                      break label5786;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).name.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_a_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).pinyin_name.has()) {
                      break label5792;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).pinyin_name.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_b_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki.has()) {
                      break label5798;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_c_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_title.has()) {
                      break label5804;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_title.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_d_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_jumpurl.has()) {
                      break label5810;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_jumpurl.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).e = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).confidence.has()) {
                      break label5816;
                    }
                    f = ((ARCloudRecogCustomPb.StarInfo)localObject4).confidence.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_a_of_type_Float = f;
                    ((ArrayList)localObject1).add(localObject5);
                    continue;
                    if (QLog.isColorLevel()) {
                      QLog.d("ARCloudRecogResult", 2, ((ARCloudPreOcrResult)localObject1).toString());
                    }
                    localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult = null;
                    break;
                    localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult = null;
                    break;
                    localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult = null;
                    break label3447;
                  }
                }
                ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
              }
              ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus = paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus;
            }
          }
        }
      }
      for (;;)
      {
        label3616:
        label3639:
        label4032:
        label4058:
        label4191:
        localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult = ((ARCloudRecogRspFaceResult)localObject2);
        label3717:
        label3743:
        label4006:
        label4137:
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize recog face result  = " + localObject2);
        }
        label3869:
        l1 = System.currentTimeMillis();
        label3979:
        label4110:
        long l2 = paramARCloudReqInfo.jdField_c_of_type_Long;
        ARFaceDataCollector.a().d = (l1 - l2);
        ARFaceDataCollector.a(paramARCloudReqInfo, (ARCloudRecogRspFaceResult)localObject2);
        if (localARCloudRecogRsp.msg_search_question_result.has())
        {
          paramArrayOfByte = (ARCloudRecogCustomPb.SearchQuestionResult)localARCloudRecogRsp.msg_search_question_result.get();
          paramARCloudReqInfo = new SearchQuestionResult();
          if (!paramArrayOfByte.search_question_errorcode.has()) {
            break label5822;
          }
          i = paramArrayOfByte.search_question_errorcode.get();
          label4338:
          paramARCloudReqInfo.jdField_a_of_type_Int = i;
          if (!paramArrayOfByte.search_question_errormsg.has()) {
            break label5828;
          }
          paramArrayOfByte = paramArrayOfByte.search_question_errormsg.get();
          label4362:
          paramARCloudReqInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (localARCloudRecogRsp.msg_search_question_result.question_res.has())
          {
            localObject1 = (ARCloudRecogCustomPb.QuestionRes)localARCloudRecogRsp.msg_search_question_result.question_res.get();
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).uin64_question_id.has()) {
              break label5834;
            }
            l1 = ((ARCloudRecogCustomPb.QuestionRes)localObject1).uin64_question_id.get();
            label4418:
            paramARCloudReqInfo.jdField_a_of_type_Long = l1;
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).str_question_content.has()) {
              break label5842;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.QuestionRes)localObject1).str_question_content.get();
            label4444:
            paramARCloudReqInfo.jdField_b_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).str_jump_url.has()) {
              break label5848;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.QuestionRes)localObject1).str_jump_url.get();
            label4469:
            paramARCloudReqInfo.jdField_c_of_type_JavaLangString = paramArrayOfByte;
          }
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineSearchQuestionResult = paramARCloudReqInfo;
        }
        if (!localARCloudRecogRsp.msg_scene_classify_result.has()) {
          break label5247;
        }
        paramARCloudReqInfo = new ARCloudSceneRecogResult();
        localObject1 = (ARCloudRecogCustomPb.ARSceneClassifyResult)localARCloudRecogRsp.msg_scene_classify_result.get();
        if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errorcode.has()) {
          break label5854;
        }
        i = ((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errorcode.get();
        label4533:
        paramARCloudReqInfo.jdField_a_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errormsg.has()) {
          break label5860;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errormsg.get();
        label4559:
        paramARCloudReqInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).image_ar_search_res.has()) {
          break label5207;
        }
        localObject1 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).image_ar_search_res.get();
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errorcode.has()) {
          break label5866;
        }
        i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errorcode.get();
        label4609:
        paramARCloudReqInfo.jdField_b_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errormsg.has()) {
          break label5872;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errormsg.get();
        label4635:
        paramARCloudReqInfo.jdField_c_of_type_JavaLangString = paramArrayOfByte;
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).session_id.has()) {
          break label5878;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).session_id.get();
        label4660:
        paramARCloudReqInfo.jdField_d_of_type_JavaLangString = paramArrayOfByte;
        if ((!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.has()) || (((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.size() <= 0)) {
          break label5199;
        }
        k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.size();
        paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag = new ARCloudSceneRecogResult.ImageTag[k];
        i = 0;
        while (i < k)
        {
          localObject2 = new ARCloudSceneRecogResult.ImageTag();
          localObject3 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.get(i);
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).image_id.has()) {
            break label5884;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).image_id.get();
          label4760:
          ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_name.has()) {
            break label5890;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_name.get();
          label4786:
          ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_b_of_type_JavaLangString = paramArrayOfByte;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence.has()) {
            break label5896;
          }
          j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence.get();
          label4813:
          ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_a_of_type_Int = j;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence_f.has()) {
            break label5902;
          }
          f = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence_f.get();
          label4841:
          ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_a_of_type_Float = f;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).need_check_lbs.has()) {
            break label5908;
          }
          j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).need_check_lbs.get();
          label4869:
          ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_b_of_type_Int = j;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_errorcode.has()) {
            break label5914;
          }
          j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_errorcode.get();
          label4897:
          ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_c_of_type_Int = j;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_res.has()) {
            break label5920;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_res.get().toByteArray();
          label4927:
          ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag[i] = localObject2;
          i += 1;
        }
        label4951:
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize recog face failed from MQ, faceResult.errCode_MQ = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_Int + ",faceResult.errMsg_MQ = " + ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
      if (k > 0)
      {
        if (paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag[0].jdField_b_of_type_Int != 1) {
          break label5925;
        }
        bool = true;
        label5026:
        paramARCloudReqInfo.jdField_a_of_type_Boolean = bool;
      }
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).time_ms.has()) {
        break label5931;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).time_ms.get();
      label5053:
      paramARCloudReqInfo.jdField_c_of_type_Int = i;
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).score.has()) {
        break label5937;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).score.get();
      label5080:
      paramARCloudReqInfo.jdField_d_of_type_Int = i;
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).kpt_num.has()) {
        break label5943;
      }
    }
    label5262:
    label5265:
    label5271:
    label5277:
    label5283:
    label5289:
    label5295:
    label5301:
    label5686:
    label5943:
    for (int i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).kpt_num.get();; i = 0)
    {
      paramARCloudReqInfo.e = i;
      label5113:
      localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult = paramARCloudReqInfo;
      label5119:
      if (localARCloudRecogRsp.uint64_uin.has()) {}
      for (l1 = localARCloudRecogRsp.uint64_uin.get();; l1 = 0L)
      {
        localARCloudRecogResult.jdField_b_of_type_Long = l1;
        if (localARCloudRecogResult.jdField_b_of_type_Long == Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) {
          break label5262;
        }
        QLog.i("AREngine_ARCloudFileUpload", 1, "deserialize pb failed. error uin. recogResult.uin = " + localARCloudRecogResult.jdField_b_of_type_Long);
        return null;
        label5199:
        paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag = null;
        break;
        label5207:
        paramARCloudReqInfo.jdField_b_of_type_Int = -1;
        paramARCloudReqInfo.jdField_c_of_type_JavaLangString = "";
        paramARCloudReqInfo.jdField_d_of_type_JavaLangString = "";
        paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag = null;
        paramARCloudReqInfo.jdField_c_of_type_Int = 0;
        paramARCloudReqInfo.jdField_d_of_type_Int = 0;
        paramARCloudReqInfo.e = 0;
        break label5113;
        label5247:
        localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult = null;
        break label5119;
      }
      return localARCloudRecogResult;
      paramArrayOfByte = "";
      break;
      l1 = 0L;
      break label72;
      i = -1;
      break label100;
      i = -1;
      break label161;
      paramArrayOfByte = "";
      break label188;
      i = -1;
      break label239;
      paramArrayOfByte = "";
      break label266;
      label5307:
      paramArrayOfByte = "";
      break label292;
      label5313:
      paramArrayOfByte = "";
      break label394;
      label5319:
      paramArrayOfByte = "";
      break label420;
      label5325:
      j = 0;
      break label447;
      label5331:
      f = 0.0F;
      break label475;
      label5337:
      j = 0;
      break label503;
      label5343:
      j = -1;
      break label531;
      label5349:
      paramArrayOfByte = null;
      break label561;
      label5354:
      bool = false;
      break label608;
      label5360:
      i = -1;
      break label760;
      label5366:
      paramArrayOfByte = "";
      break label787;
      label5372:
      i = -1;
      break label838;
      paramArrayOfByte = "";
      break label865;
      paramArrayOfByte = "";
      break label891;
      paramArrayOfByte = "";
      break label993;
      paramArrayOfByte = "";
      break label1019;
      j = 0;
      break label1046;
      f = 0.0F;
      break label1074;
      j = 0;
      break label1102;
      j = -1;
      break label1130;
      paramArrayOfByte = null;
      break label1160;
      bool = false;
      break label1323;
      label5437:
      i = 0;
      break label1351;
      label5443:
      i = 0;
      break label1379;
      label5449:
      i = 0;
      break label1407;
      label5455:
      i = -1;
      break label1489;
      label5461:
      paramArrayOfByte = "";
      break label1516;
      label5467:
      i = -1;
      break label1597;
      label5473:
      paramArrayOfByte = "";
      break label1624;
      label5479:
      i = -1;
      break label1651;
      label5485:
      paramArrayOfByte = "";
      break label1678;
      label5491:
      i = 0;
      break label1751;
      label5497:
      i = 0;
      break label1784;
      label5503:
      i = 0;
      break label1817;
      i = 0;
      break label1850;
      f = 0.0F;
      break label1883;
      i = 0;
      break label1916;
      j = 0;
      break label2069;
      j = 0;
      break label2097;
      d = 0.0D;
      break label2124;
      paramArrayOfByte = "";
      break label2150;
      k = 0;
      break label2277;
      paramArrayOfByte = "";
      break label2304;
      label5562:
      d = 0.0D;
      break label2330;
      label5567:
      paramArrayOfByte = "";
      break label2356;
      label5573:
      k = 0;
      break label2383;
      label5579:
      paramArrayOfByte = "";
      break label2410;
      label5585:
      paramArrayOfByte = "";
      break label2436;
      label5591:
      paramArrayOfByte = "";
      break label2462;
      label5597:
      paramArrayOfByte = "";
      break label2488;
      label5603:
      paramArrayOfByte = null;
      break label2517;
      label5608:
      bool = false;
      break label2549;
      label5614:
      bool = false;
      break label2549;
      label5620:
      k = 0;
      break label2577;
      label5626:
      paramArrayOfByte = "";
      break label2604;
      paramArrayOfByte = "";
      break label2690;
      paramArrayOfByte = "";
      break label2740;
      paramArrayOfByte = "";
      break label2779;
      paramArrayOfByte = "";
      break label2829;
      paramArrayOfByte = "";
      break label2868;
      paramArrayOfByte = "";
      break label2907;
      i = -1;
      break label3090;
      paramArrayOfByte = "";
      break label3123;
      paramArrayOfByte = "";
      break label3155;
      i = -1;
      break label3188;
      label5692:
      paramArrayOfByte = "";
      break label3221;
      label5698:
      i = 0;
      break label3254;
      label5704:
      f = 0.0F;
      break label3288;
      label5710:
      l1 = -1L;
      break label3363;
      label5718:
      i = -1;
      break label3501;
      label5724:
      paramArrayOfByte = "";
      break label3528;
      label5730:
      paramArrayOfByte = null;
      break label3616;
      label5735:
      i = -1;
      break label3639;
      label5741:
      localObject1 = "";
      break label3665;
      label5748:
      localObject1 = "";
      break label3691;
      label5755:
      i = -1;
      break label3717;
      i = -1;
      break label3743;
      paramArrayOfByte = null;
      break label3869;
      l1 = -1L;
      break label3951;
      i = -1;
      break label3979;
      paramArrayOfByte = "";
      break label4006;
      paramArrayOfByte = "";
      break label4032;
      paramArrayOfByte = "";
      break label4058;
      paramArrayOfByte = "";
      break label4084;
      paramArrayOfByte = "";
      break label4110;
      label5816:
      f = 0.0F;
      break label4137;
      label5822:
      i = -1;
      break label4338;
      label5828:
      paramArrayOfByte = "";
      break label4362;
      label5834:
      l1 = -1L;
      break label4418;
      label5842:
      paramArrayOfByte = "";
      break label4444;
      label5848:
      paramArrayOfByte = "";
      break label4469;
      label5854:
      i = -1;
      break label4533;
      label5860:
      paramArrayOfByte = "";
      break label4559;
      label5866:
      i = -1;
      break label4609;
      label5872:
      paramArrayOfByte = "";
      break label4635;
      label5878:
      paramArrayOfByte = "";
      break label4660;
      label5884:
      paramArrayOfByte = "";
      break label4760;
      paramArrayOfByte = "";
      break label4786;
      j = 0;
      break label4813;
      f = 0.0F;
      break label4841;
      j = 0;
      break label4869;
      j = -1;
      break label4897;
      paramArrayOfByte = null;
      break label4927;
      bool = false;
      break label5026;
      i = 0;
      break label5053;
      i = 0;
      break label5080;
    }
  }
  
  private byte[] a(ARCloudReqInfo paramARCloudReqInfo)
  {
    ARCloudRecogCommonPb.ARCloudRecogReq localARCloudRecogReq = new ARCloudRecogCommonPb.ARCloudRecogReq();
    localARCloudRecogReq.str_session_id.set(paramARCloudReqInfo.jdField_a_of_type_JavaLangString);
    Object localObject1 = new ARCloudRecogCommonPb.ARFileReqInfo();
    ((ARCloudRecogCommonPb.ARFileReqInfo)localObject1).str_file_name.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString);
    ((ARCloudRecogCommonPb.ARFileReqInfo)localObject1).uint32_file_format.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_Int);
    localARCloudRecogReq.msg_ar_req_file_info.set((MessageMicro)localObject1);
    localARCloudRecogReq.uint32_lon.set(paramARCloudReqInfo.jdField_a_of_type_Int);
    localARCloudRecogReq.uint32_lat.set(paramARCloudReqInfo.jdField_b_of_type_Int);
    localARCloudRecogReq.uin32_business_type.set(paramARCloudReqInfo.jdField_c_of_type_Int);
    long l2 = paramARCloudReqInfo.jdField_a_of_type_Long;
    if ((1L & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARMarkerRecogInfo();
      ((ARCloudRecogCustomPb.ARMarkerRecogInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqMarkerInfo.jdField_a_of_type_Int);
      localARCloudRecogReq.msg_ar_marker_recog_info.set((MessageMicro)localObject1);
    }
    if ((0x2 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARObjectClassifyInfo();
      ((ARCloudRecogCustomPb.ARObjectClassifyInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqObjectClassifyInfo.jdField_a_of_type_Int);
      localARCloudRecogReq.msg_object_classify_info.set((MessageMicro)localObject1);
    }
    if ((0x80 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ImgRetrievalInfo();
      ((ARCloudRecogCustomPb.ImgRetrievalInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.jdField_b_of_type_ComTencentMobileqqArArengineARCloudRecogReqObjectClassifyInfo.jdField_a_of_type_Int);
      localARCloudRecogReq.msg_img_retrieval_info.set((MessageMicro)localObject1);
    }
    if ((0x40 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARWordDetectInfo();
      ((ARCloudRecogCustomPb.ARWordDetectInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqPreOcrInfo.jdField_a_of_type_Int);
      localARCloudRecogReq.msg_word_detect_info.set((MessageMicro)localObject1);
    }
    Object localObject2;
    if ((0x10 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.AROcrInfo();
      localObject2 = new YoutuOcr.YoutuOcrReq();
      ((YoutuOcr.YoutuOcrReq)localObject2).uin32_timeout_ms.set(30000);
      if ((paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo == null) || (TextUtils.isEmpty(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo.jdField_a_of_type_JavaLangString))) {
        break label599;
      }
      ((YoutuOcr.YoutuOcrReq)localObject2).language.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      Object localObject3 = new JDSearch.JdSearchReq();
      ((JDSearch.JdSearchReq)localObject3).uin32_timeout_ms.set(30000);
      ((ARCloudRecogCustomPb.AROcrInfo)localObject1).uin64_ocr_recog_type.set(17);
      ((ARCloudRecogCustomPb.AROcrInfo)localObject1).youtu_ocr_req.set((MessageMicro)localObject2);
      ((ARCloudRecogCustomPb.AROcrInfo)localObject1).jd_search_req.set((MessageMicro)localObject3);
      localARCloudRecogReq.msg_ocr_info.set((MessageMicro)localObject1);
      l1 = l2;
      if ((0x4 & l2) == 0L) {
        break label672;
      }
      if ((paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo == null) || (paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null) || (paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length <= 0)) {
        break label830;
      }
      localObject1 = new ARCloudRecogCustomPb.ARFaceRecogInfo();
      localObject2 = new ArrayList();
      int j = paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length;
      int i = 0;
      while (i < j)
      {
        localObject3 = paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        ARCloudRecogCustomPb.FaceRect localFaceRect = new ARCloudRecogCustomPb.FaceRect();
        localFaceRect.face_rect_id.set(i);
        localFaceRect.face_origin_x.set(((FaceStatus)localObject3).x);
        localFaceRect.face_origin_y.set(((FaceStatus)localObject3).y);
        localFaceRect.face_size_w.set(((FaceStatus)localObject3).width);
        localFaceRect.face_size_h.set(((FaceStatus)localObject3).height);
        ((ArrayList)localObject2).add(localFaceRect);
        i += 1;
      }
      label599:
      ((YoutuOcr.YoutuOcrReq)localObject2).language.set("auto");
    }
    ((ARCloudRecogCustomPb.ARFaceRecogInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_Int);
    ((ARCloudRecogCustomPb.ARFaceRecogInfo)localObject1).face_rect.set((List)localObject2);
    localARCloudRecogReq.msg_face_recog_info.set((MessageMicro)localObject1);
    long l1 = l2;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace] serialize add faceRectInfo");
    }
    label672:
    label830:
    for (l1 = l2;; l1 = l2 & 0xFFFFFFFB)
    {
      if ((0x200 & l1) != 0L)
      {
        localObject1 = new ARCloudRecogCustomPb.SearchQuestionInfo();
        ((ARCloudRecogCustomPb.SearchQuestionInfo)localObject1).uin32_timeout_ms.set(30000);
        ((ARCloudRecogCustomPb.SearchQuestionInfo)localObject1).uin64_pic_height.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_b_of_type_Int);
        ((ARCloudRecogCustomPb.SearchQuestionInfo)localObject1).uin64_pic_width.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_c_of_type_Int);
        localARCloudRecogReq.msg_search_question_info.set((MessageMicro)localObject1);
      }
      if ((0x800 & l1) != 0L)
      {
        localObject1 = new ARCloudRecogCustomPb.ARSceneClassifyInfo();
        ((ARCloudRecogCustomPb.ARSceneClassifyInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqSceneRecogInfo.jdField_a_of_type_Int);
        localARCloudRecogReq.msg_scene_classify_info.set((MessageMicro)localObject1);
      }
      localARCloudRecogReq.uin64_req_recog_type.set(l1);
      localARCloudRecogReq.str_clt_version.set(paramARCloudReqInfo.jdField_b_of_type_JavaLangString);
      localARCloudRecogReq.uint64_uin.set(paramARCloudReqInfo.jdField_b_of_type_Long);
      return localARCloudRecogReq.toByteArray();
    }
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 1196	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 1198	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 7
    //   16: new 1200	java/io/FileInputStream
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 1203	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: aload 7
    //   34: invokevirtual 1206	java/io/File:length	()J
    //   37: invokestatic 1212	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   40: astore 7
    //   42: aload 7
    //   44: astore_1
    //   45: aload_1
    //   46: astore_3
    //   47: aload 4
    //   49: ifnull +10 -> 59
    //   52: aload 4
    //   54: invokevirtual 1215	java/io/FileInputStream:close	()V
    //   57: aload_1
    //   58: astore_3
    //   59: aload_3
    //   60: areturn
    //   61: astore_3
    //   62: aload 4
    //   64: astore_3
    //   65: new 1196	java/io/File
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 1198	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 7
    //   75: aload 4
    //   77: astore_3
    //   78: aload 7
    //   80: invokevirtual 1218	java/io/File:exists	()Z
    //   83: istore_2
    //   84: aload 5
    //   86: astore_1
    //   87: iload_2
    //   88: ifeq -43 -> 45
    //   91: aload 4
    //   93: astore_3
    //   94: aload 7
    //   96: invokestatic 1223	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +14 -> 115
    //   104: aload 4
    //   106: astore_3
    //   107: aload_1
    //   108: invokestatic 1227	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   111: astore_1
    //   112: goto -67 -> 45
    //   115: ldc 25
    //   117: astore_1
    //   118: goto -14 -> 104
    //   121: astore_3
    //   122: aload_3
    //   123: invokevirtual 1230	java/io/IOException:printStackTrace	()V
    //   126: aload_1
    //   127: areturn
    //   128: astore 5
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: astore_3
    //   134: aload 5
    //   136: invokevirtual 1231	java/lang/Exception:printStackTrace	()V
    //   139: aload 6
    //   141: astore_3
    //   142: aload_1
    //   143: ifnull -84 -> 59
    //   146: aload_1
    //   147: invokevirtual 1215	java/io/FileInputStream:close	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 1230	java/io/IOException:printStackTrace	()V
    //   157: aconst_null
    //   158: areturn
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_3
    //   162: aload_3
    //   163: ifnull +7 -> 170
    //   166: aload_3
    //   167: invokevirtual 1215	java/io/FileInputStream:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual 1230	java/io/IOException:printStackTrace	()V
    //   177: goto -7 -> 170
    //   180: astore_1
    //   181: goto -19 -> 162
    //   184: astore 5
    //   186: aload 4
    //   188: astore_1
    //   189: goto -57 -> 132
    //   192: astore_1
    //   193: aload 5
    //   195: astore_1
    //   196: goto -151 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	ARCloudFileUpload
    //   0	199	1	paramString	String
    //   83	5	2	bool	boolean
    //   29	31	3	localObject1	Object
    //   61	1	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   64	43	3	localFileInputStream1	java.io.FileInputStream
    //   121	2	3	localIOException1	java.io.IOException
    //   133	34	3	localObject2	Object
    //   172	2	3	localIOException2	java.io.IOException
    //   25	162	4	localFileInputStream2	java.io.FileInputStream
    //   4	81	5	localObject3	Object
    //   128	7	5	localException1	java.lang.Exception
    //   184	10	5	localException2	java.lang.Exception
    //   1	139	6	localObject4	Object
    //   14	81	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   30	42	61	java/lang/UnsatisfiedLinkError
    //   52	57	121	java/io/IOException
    //   6	27	128	java/lang/Exception
    //   146	150	152	java/io/IOException
    //   6	27	159	finally
    //   166	170	172	java/io/IOException
    //   30	42	180	finally
    //   65	75	180	finally
    //   78	84	180	finally
    //   94	100	180	finally
    //   107	112	180	finally
    //   134	139	180	finally
    //   30	42	184	java/lang/Exception
    //   65	75	184	java/lang/Exception
    //   78	84	184	java/lang/Exception
    //   94	100	184	java/lang/Exception
    //   107	112	184	java/lang/Exception
    //   94	100	192	java/io/IOException
    //   107	112	192	java/io/IOException
  }
  
  public int a()
  {
    int i = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int j = this.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "cancelTransactionTask. sessionId = " + ((aalo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(((aalo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = j;
      }
      return i;
    }
  }
  
  public String a()
  {
    return String.format("%s_%s_%05d", new Object[] { this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().preConnect();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARLBSObserver = new aalm(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArARLBSObserver);
  }
  
  public boolean a(ARCloudReqInfo paramARCloudReqInfo, ARCloudFileUpload.ARCloudFileUploadCallback arg2)
  {
    if ((paramARCloudReqInfo == null) || (??? == null)) {
      QLog.i("AREngine_ARCloudFileUpload", 1, "reqInfo == null || callBack == null");
    }
    for (;;)
    {
      return false;
      long l = 0L;
      Object localObject1 = new File(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 != null) {
        l = ((File)localObject1).length();
      }
      localObject1 = new aaln(this, paramARCloudReqInfo, l);
      Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0)) {}
      int i;
      try
      {
        if (SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session() != null)
        {
          i = SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session().length;
          this.jdField_a_of_type_ArrayOfByte = new byte[i];
          System.arraycopy(SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session(), 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
        }
        if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0))
        {
          HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject2);
          QLog.i("AREngine_ARCloudFileUpload", 1, "requestToUpload failed. mSigSession == null || mSigSession.length == 0.");
          return false;
        }
      }
      finally {}
      byte[] arrayOfByte1 = a(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString);
      if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0))
      {
        QLog.i("AREngine_ARCloudFileUpload", 1, "requestToUpload failed. fileMd5 == null || fileMd5.length == 0.");
        return false;
      }
      byte[] arrayOfByte2 = a(paramARCloudReqInfo);
      localObject1 = new Transaction((String)localObject2, 42, paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, arrayOfByte1, (ITransactionCallback)localObject1, arrayOfByte2);
      localObject2 = new aalo();
      ((aalo)localObject2).jdField_a_of_type_JavaLangString = paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString;
      ((aalo)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo = paramARCloudReqInfo;
      ((aalo)localObject2).jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = ((Transaction)localObject1);
      ((aalo)localObject2).jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback = ???;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject1);
        QLog.i("AREngine_ARCloudFileUpload", 1, "submitTransactionTask. retCode = " + i + ", reqInfo = " + paramARCloudReqInfo);
        if (i != 0) {
          continue;
        }
        return true;
      }
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, ARCloudFileUpload.ARCloudLBSLocationCheckCallback paramARCloudLBSLocationCheckCallback)
  {
    QLog.i("AREngine_ARCloudFileUpload", 1, "requestToCheckLBSLocation. imageId = " + paramString + ", latitude = " + paramInt1 + ", longitude = " + paramInt2);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudLBSLocationCheckCallback = paramARCloudLBSLocationCheckCallback;
    ((ARLBSHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(5)).a(paramString, paramInt1, paramInt2);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARLBSObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArARLBSObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload
 * JD-Core Version:    0.7.0.1
 */