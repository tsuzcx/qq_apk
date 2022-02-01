package com.tencent.mobileqq.ar.arcloud;

import android.text.TextUtils;
import com.tencent.YTFace.cluster.FaceCluster;
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
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageTranslateReqInfo;
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
import com.tencent.mobileqq.ar.arengine.ARCloudReqTranslateInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudSceneRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudSceneRecogResult.ImageTag;
import com.tencent.mobileqq.ar.arengine.ARFaceDataCollector;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.LabelSource;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.ObjectBox;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalClassInfo;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalItem;
import com.tencent.mobileqq.ar.arengine.SearchQuestionResult;
import com.tencent.mobileqq.armap.ArMapConstant;
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
  private ARCloudFileUpload.ARCloudLBSLocationCheckCallback jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudLBSLocationCheckCallback = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ARCloudFileUpload.TaskInfo> jdField_a_of_type_JavaUtilArrayList = null;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  
  public ARCloudFileUpload(AppInterface paramAppInterface)
  {
    this(paramAppInterface, false);
  }
  
  public ARCloudFileUpload(AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(paramBoolean);
  }
  
  private ARCloudRecogResult a(byte[] paramArrayOfByte, ARCloudReqInfo paramARCloudReqInfo)
  {
    ARCloudRecogResult localARCloudRecogResult = new ARCloudRecogResult();
    ARCloudRecogCommonPb.ARCloudRecogRsp localARCloudRecogRsp = new ARCloudRecogCommonPb.ARCloudRecogRsp();
    for (;;)
    {
      try
      {
        localARCloudRecogRsp.mergeFrom(paramArrayOfByte);
        bool = localARCloudRecogRsp.str_session_id.has();
        if (!bool) {
          break label5713;
        }
        paramArrayOfByte = localARCloudRecogRsp.str_session_id.get();
        localARCloudRecogResult.jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.uin64_req_recog_type.has()) {
          break label5719;
        }
        l1 = localARCloudRecogRsp.uin64_req_recog_type.get();
        localARCloudRecogResult.jdField_a_of_type_Long = l1;
        if (!localARCloudRecogRsp.uin32_business_type.has()) {
          break label5725;
        }
        i = localARCloudRecogRsp.uin32_business_type.get();
        localARCloudRecogResult.jdField_a_of_type_Int = i;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if (localARCloudRecogRsp.msg_ar_marker_recog_result.has())
        {
          localObject1 = new ARCloudMarkerRecogResult();
          localObject2 = (ARCloudRecogCustomPb.ARMarkerRecogResult)localARCloudRecogRsp.msg_ar_marker_recog_result.get();
          if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errorcode.has()) {
            break label5731;
          }
          i = ((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errorcode.get();
          ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_Int = i;
          if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errormsg.has()) {
            break label5737;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errormsg.get();
          ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_res.has())
          {
            localObject2 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_res.get();
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.has()) {
              break label5743;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.get();
            ((ARCloudMarkerRecogResult)localObject1).jdField_b_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.has()) {
              break label5749;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.get();
            ((ARCloudMarkerRecogResult)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.has()) {
              break label5755;
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
                  break label5761;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_a_of_type_JavaLangString = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.has()) {
                  break label5767;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_b_of_type_JavaLangString = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.has()) {
                  break label5773;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_a_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.has()) {
                  break label5779;
                }
                f = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_a_of_type_Float = f;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.has()) {
                  break label5785;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_b_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.has()) {
                  break label5791;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_c_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.has()) {
                  break label5797;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.get().toByteArray();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
                ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag[i] = localObject3;
                i += 1;
                continue;
              }
              if (k > 0)
              {
                if (localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag[0].jdField_b_of_type_Int != 1) {
                  break label5802;
                }
                bool = true;
                ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_Boolean = bool;
              }
            }
            else
            {
              ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag = null;
            }
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.has()) {
              break label5808;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.get();
            ((ARCloudMarkerRecogResult)localObject1).jdField_c_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.has()) {
              break label5814;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.get();
            ((ARCloudMarkerRecogResult)localObject1).jdField_d_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.has()) {
              break label5820;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.get();
            ((ARCloudMarkerRecogResult)localObject1).e = i;
          }
          else
          {
            ((ARCloudMarkerRecogResult)localObject1).jdField_b_of_type_Int = -1;
            ((ARCloudMarkerRecogResult)localObject1).jdField_c_of_type_JavaLangString = "";
            ((ARCloudMarkerRecogResult)localObject1).jdField_d_of_type_JavaLangString = "";
            ((ARCloudMarkerRecogResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag = null;
            ((ARCloudMarkerRecogResult)localObject1).jdField_c_of_type_Int = 0;
            ((ARCloudMarkerRecogResult)localObject1).jdField_d_of_type_Int = 0;
            ((ARCloudMarkerRecogResult)localObject1).e = 0;
          }
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult = ((ARCloudMarkerRecogResult)localObject1);
        }
        else
        {
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult = null;
        }
        if (localARCloudRecogRsp.msg_ar_object_classify_result.has())
        {
          localObject1 = new ARCloudObjectClassifyResult();
          localObject2 = (ARCloudRecogCustomPb.ARObjectClassifyResult)localARCloudRecogRsp.msg_ar_object_classify_result.get();
          if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errorcode.has()) {
            break label5826;
          }
          i = ((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errorcode.get();
          ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_Int = i;
          if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errormsg.has()) {
            break label5832;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errormsg.get();
          ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).image_ar_search_res.has())
          {
            localObject2 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).image_ar_search_res.get();
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.has()) {
              break label5838;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.get();
            ((ARCloudObjectClassifyResult)localObject1).jdField_b_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.has()) {
              break label5844;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.get();
            ((ARCloudObjectClassifyResult)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.has()) {
              break label5850;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.get();
            ((ARCloudObjectClassifyResult)localObject1).jdField_d_of_type_JavaLangString = paramArrayOfByte;
            if ((((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.has()) && (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size() > 0))
            {
              k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size();
              ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag = new ARCloudObjectClassifyResult.ImageTag[k];
              i = 0;
              if (i < k)
              {
                localObject3 = new ARCloudObjectClassifyResult.ImageTag();
                localObject4 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.get(i);
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.has()) {
                  break label5856;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_a_of_type_JavaLangString = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.has()) {
                  break label5862;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_b_of_type_JavaLangString = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.has()) {
                  break label5868;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_a_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.has()) {
                  break label5874;
                }
                f = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_a_of_type_Float = f;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.has()) {
                  break label5880;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_b_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.has()) {
                  break label5886;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_c_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.has()) {
                  break label5892;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.get().toByteArray();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
                ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[i] = localObject3;
                i += 1;
                continue;
              }
              if (k > 0)
              {
                if (localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].jdField_b_of_type_Int != 1) {
                  break label5897;
                }
                bool = true;
                ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_Boolean = bool;
              }
            }
            else
            {
              ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag = null;
            }
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.has()) {
              break label5903;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.get();
            ((ARCloudObjectClassifyResult)localObject1).jdField_c_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.has()) {
              break label5909;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.get();
            ((ARCloudObjectClassifyResult)localObject1).jdField_d_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.has()) {
              break label5915;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.get();
            ((ARCloudObjectClassifyResult)localObject1).e = i;
          }
          else
          {
            ((ARCloudObjectClassifyResult)localObject1).jdField_b_of_type_Int = -1;
            ((ARCloudObjectClassifyResult)localObject1).jdField_c_of_type_JavaLangString = "";
            ((ARCloudObjectClassifyResult)localObject1).jdField_d_of_type_JavaLangString = "";
            ((ARCloudObjectClassifyResult)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag = null;
            ((ARCloudObjectClassifyResult)localObject1).jdField_c_of_type_Int = 0;
            ((ARCloudObjectClassifyResult)localObject1).jdField_d_of_type_Int = 0;
            ((ARCloudObjectClassifyResult)localObject1).e = 0;
          }
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult = ((ARCloudObjectClassifyResult)localObject1);
        }
        else
        {
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult = null;
        }
        localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
        Object localObject5;
        if (localARCloudRecogRsp.msg_img_retrieval_result.has())
        {
          localObject2 = new ARMIGObjectClassifyResult();
          ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
          localObject1 = (ARCloudRecogCustomPb.ImgRetrievalResult)localARCloudRecogRsp.msg_img_retrieval_result.get();
          if (!((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).errorcode.has()) {
            break label5921;
          }
          i = ((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).errorcode.get();
          ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_Int = i;
          if (!((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).errormsg.has()) {
            break label5927;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).errormsg.get();
          ((ARMIGObjectClassifyResult)localObject2).jdField_b_of_type_JavaLangString = paramArrayOfByte;
          if (((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).jd_search_rsp.has()) {
            ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult = ARMIGObjectClassifyResult.a((JDSearch.JdSearchRsp)((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).jd_search_rsp.get());
          }
          if (((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).msg_ir_logic_rsp.has())
          {
            localObject1 = (ImageRetrievalLogic.IRLogicRsp)((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).msg_ir_logic_rsp.get();
            if (!((ImageRetrievalLogic.IRLogicRsp)localObject1).iRetCode.has()) {
              break label5933;
            }
            i = ((ImageRetrievalLogic.IRLogicRsp)localObject1).iRetCode.get();
            ((ARMIGObjectClassifyResult)localObject2).jdField_b_of_type_Int = i;
            if (!((ImageRetrievalLogic.IRLogicRsp)localObject1).sMsg.has()) {
              break label5939;
            }
            paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject1).sMsg.get();
            ((ARMIGObjectClassifyResult)localObject2).jdField_c_of_type_JavaLangString = paramArrayOfByte;
            if (!((ImageRetrievalLogic.IRLogicRsp)localObject1).iBusiness.has()) {
              break label5945;
            }
            i = ((ImageRetrievalLogic.IRLogicRsp)localObject1).iBusiness.get();
            ((ARMIGObjectClassifyResult)localObject2).jdField_c_of_type_Int = i;
            if (!((ImageRetrievalLogic.IRLogicRsp)localObject1).sKey.has()) {
              break label5951;
            }
            paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject1).sKey.get();
            ((ARMIGObjectClassifyResult)localObject2).jdField_d_of_type_JavaLangString = paramArrayOfByte;
            ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox = null;
            if (((ImageRetrievalLogic.IRLogicRsp)localObject1).stBBox.has())
            {
              ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox = new ARMIGObjectClassifyResult.ObjectBox();
              paramArrayOfByte = (ImageRetrievalComm.OD_BBox)((ImageRetrievalLogic.IRLogicRsp)localObject1).stBBox.get();
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
              if (!paramArrayOfByte.xmin.has()) {
                break label5957;
              }
              i = paramArrayOfByte.xmin.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_a_of_type_Int = i;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
              if (!paramArrayOfByte.xmax.has()) {
                break label5963;
              }
              i = paramArrayOfByte.xmax.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_b_of_type_Int = i;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
              if (!paramArrayOfByte.ymin.has()) {
                break label5969;
              }
              i = paramArrayOfByte.ymin.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_c_of_type_Int = i;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
              if (!paramArrayOfByte.ymax.has()) {
                break label5975;
              }
              i = paramArrayOfByte.ymax.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_d_of_type_Int = i;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
              if (!paramArrayOfByte.fScore.has()) {
                break label5981;
              }
              f = paramArrayOfByte.fScore.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).jdField_a_of_type_Float = f;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
              if (!paramArrayOfByte.iLabelID.has()) {
                break label5987;
              }
              i = paramArrayOfByte.iLabelID.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).e = i;
              if (QLog.isColorLevel())
              {
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append("[MIGObjectclassifyResult 矩形区域原始数据打印]");
                paramArrayOfByte.append(((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.toString());
                QLog.d("AREngine_ARCloudFileUpload", 2, paramArrayOfByte.toString());
              }
            }
            if ((((ImageRetrievalLogic.IRLogicRsp)localObject1).vClassInfo.has()) && (((ImageRetrievalLogic.IRLogicRsp)localObject1).vClassInfo.size() > 0))
            {
              int m = ((ImageRetrievalLogic.IRLogicRsp)localObject1).vClassInfo.size();
              ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo = new ARMIGObjectClassifyResult.RetrievalClassInfo[m];
              paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject1).vClassInfo.get();
              i = 0;
              if (i < m)
              {
                localObject3 = (ImageRetrievalLogic.RetrievalClassInfo)paramArrayOfByte.get(i);
                localObject4 = new ARMIGObjectClassifyResult.RetrievalClassInfo();
                if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iClass.has()) {
                  break label5993;
                }
                j = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iClass.get();
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_Int = j;
                if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iStatus.has()) {
                  break label5999;
                }
                j = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iStatus.get();
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_b_of_type_Int = j;
                if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).dClassProb.has()) {
                  break label6005;
                }
                d = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).dClassProb.get();
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_Double = d;
                if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).sClass.has()) {
                  break label6010;
                }
                localObject1 = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).sClass.get();
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject1);
                if ((((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.has()) && (((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size() > 0)) {
                  ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem = new ARMIGObjectClassifyResult.RetrievalItem[((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size()];
                }
                if ((((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.has()) && (((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size() > 0))
                {
                  j = 0;
                  if (j < ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size())
                  {
                    localObject5 = new ARMIGObjectClassifyResult.RetrievalItem();
                    Object localObject6 = (ImageRetrievalLogic.RetrievalItem)((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.get(j);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iClass.has()) {
                      break label6017;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iClass.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sClass.has()) {
                      break label6023;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sClass.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).dProb.has()) {
                      break label6030;
                    }
                    d = ((ImageRetrievalLogic.RetrievalItem)localObject6).dProb.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_Double = d;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sItemID.has()) {
                      break label6035;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sItemID.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_b_of_type_JavaLangString = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iSource.has()) {
                      break label6042;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iSource.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_b_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sPicUrl.has()) {
                      break label6048;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sPicUrl.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_c_of_type_JavaLangString = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sTitle.has()) {
                      break label6055;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sTitle.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_d_of_type_JavaLangString = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sWiki.has()) {
                      break label6062;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sWiki.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sJumpUrl.has()) {
                      break label6069;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sJumpUrl.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).f = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sCdbRes.has()) {
                      break label6076;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sCdbRes.get().toByteArray();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ArrayOfByte = ((byte[])localObject1);
                    if ((!((ImageRetrievalLogic.RetrievalItem)localObject6).iAutoJump.has()) || (((ImageRetrievalLogic.RetrievalItem)localObject6).iAutoJump.get() != 1)) {
                      break label6082;
                    }
                    bool = true;
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_Boolean = bool;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iNeedCheckLBS.has()) {
                      break label6088;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iNeedCheckLBS.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_c_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sImageId.has()) {
                      break label6094;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sImageId.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).g = ((String)localObject1);
                    if (((ImageRetrievalLogic.RetrievalItem)localObject6).stLabel.has())
                    {
                      localObject6 = (ImageRetrievalLogic.LabelSource)((ImageRetrievalLogic.RetrievalItem)localObject6).stLabel.get();
                      ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource = new ARMIGObjectClassifyResult.LabelSource();
                      ARMIGObjectClassifyResult.LabelSource localLabelSource;
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.sLabel.has()) {
                          break label6101;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.sLabel.get();
                        localLabelSource.jdField_a_of_type_JavaLangString = ((String)localObject1);
                      }
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sTitle.has()) {
                          break label6108;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sTitle.get();
                        localLabelSource.jdField_b_of_type_JavaLangString = ((String)localObject1);
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sISBN.has()) {
                          break label6115;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sISBN.get();
                        localLabelSource.jdField_c_of_type_JavaLangString = ((String)localObject1);
                      }
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCity.has()) {
                          break label6122;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCity.get();
                        localLabelSource.e = ((String)localObject1);
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCountry.has()) {
                          break label6129;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCountry.get();
                        localLabelSource.jdField_d_of_type_JavaLangString = ((String)localObject1);
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sTour.has()) {
                          break label6136;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sTour.get();
                        localLabelSource.f = ((String)localObject1);
                      }
                    }
                    ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem[j] = localObject5;
                    j += 1;
                    continue;
                  }
                }
                ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i] = localObject4;
                i += 1;
                continue;
              }
            }
          }
          ((ARMIGObjectClassifyResult)localObject2).jdField_a_of_type_Boolean = ((ARMIGObjectClassifyResult)localObject2).d();
          ((ARMIGObjectClassifyResult)localObject2).e = ((ARMIGObjectClassifyResult)localObject2).a();
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = ((ARMIGObjectClassifyResult)localObject2);
        }
        if (localARCloudRecogRsp.msg_word_detect_result.has())
        {
          localObject1 = new ARCloudPreOcrResult();
          if (!localARCloudRecogRsp.msg_word_detect_result.errorcode.has()) {
            break label6143;
          }
          i = localARCloudRecogRsp.msg_word_detect_result.errorcode.get();
          ((ARCloudPreOcrResult)localObject1).jdField_a_of_type_Int = i;
          if (!localARCloudRecogRsp.msg_word_detect_result.errormsg.has()) {
            break label6149;
          }
          paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.errormsg.get();
          ((ARCloudPreOcrResult)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (!localARCloudRecogRsp.msg_word_detect_result.session_id.has()) {
            break label6155;
          }
          paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.session_id.get();
          ((ARCloudPreOcrResult)localObject1).jdField_b_of_type_JavaLangString = paramArrayOfByte;
          if (!localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.has()) {
            break label6161;
          }
          i = localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.get();
          ((ARCloudPreOcrResult)localObject1).jdField_b_of_type_Int = i;
          if (!localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.has()) {
            break label6167;
          }
          paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.get();
          ((ARCloudPreOcrResult)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
          if (!localARCloudRecogRsp.msg_word_detect_result.word_type.has()) {
            break label6173;
          }
          i = localARCloudRecogRsp.msg_word_detect_result.word_type.get();
          ((ARCloudPreOcrResult)localObject1).jdField_c_of_type_Int = i;
          if (!localARCloudRecogRsp.msg_word_detect_result.confidence.has()) {
            break label6179;
          }
          f = localARCloudRecogRsp.msg_word_detect_result.confidence.get();
          ((ARCloudPreOcrResult)localObject1).jdField_a_of_type_Float = f;
          if (((ARCloudPreOcrResult)localObject1).a())
          {
            localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult = ((ARCloudPreOcrResult)localObject1);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ARCloudRecogResult", 2, ((ARCloudPreOcrResult)localObject1).toString());
            }
            localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult = null;
          }
        }
        else
        {
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult = null;
        }
        bool = localARCloudRecogRsp.msg_ocr_result.has();
        long l2 = -1L;
        if (bool)
        {
          paramArrayOfByte = new ARCloudOcrResult();
          localObject1 = (ARCloudRecogCustomPb.AROcrResult)localARCloudRecogRsp.msg_ocr_result.get();
          if (!((ARCloudRecogCustomPb.AROcrResult)localObject1).uin64_ocr_recog_type.has()) {
            break label6185;
          }
          l1 = ((ARCloudRecogCustomPb.AROcrResult)localObject1).uin64_ocr_recog_type.get();
          if (((l1 & 1L) == 1L) && (((ARCloudRecogCustomPb.AROcrResult)localObject1).youtu_ocr_rsp.has())) {
            paramArrayOfByte.a = ARCloudOcrResult.a((YoutuOcr.YoutuOcrRsp)((ARCloudRecogCustomPb.AROcrResult)localObject1).youtu_ocr_rsp.get());
          }
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult = paramArrayOfByte;
        }
        else
        {
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult = null;
        }
        if (localARCloudRecogRsp.msg_face_recog_result.has())
        {
          localObject2 = new ARCloudRecogRspFaceResult();
          localObject1 = (ARCloudRecogCustomPb.ARFaceRecogResult)localARCloudRecogRsp.msg_face_recog_result.get();
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errorcode.has()) {
            break label6193;
          }
          i = ((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errorcode.get();
          ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_Int = i;
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errormsg.has()) {
            break label6199;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errormsg.get();
          ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          bool = QLog.isColorLevel();
          if (bool)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("[ScanStarFace]deserialize  faceResult.errCode_MQ = ");
            paramArrayOfByte.append(((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_Int);
            paramArrayOfByte.append(",faceResult.errMsg_MQ = ");
            paramArrayOfByte.append(((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_JavaLangString);
            QLog.d("AREngine_ARCloudFileUpload", 2, paramArrayOfByte.toString());
          }
          if (((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_Int == 0)
          {
            if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).image_ar_face_recog_res.has()) {
              break label6205;
            }
            paramArrayOfByte = (ARCloudRecogCustomPb.ARFaceRecogRes)((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).image_ar_face_recog_res.get();
            if (paramArrayOfByte != null)
            {
              if (!paramArrayOfByte.errorcode.has()) {
                break label6210;
              }
              i = paramArrayOfByte.errorcode.get();
              ((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_Int = i;
              if (!paramArrayOfByte.errormsg.has()) {
                break label6216;
              }
              localObject1 = paramArrayOfByte.errormsg.get();
              ((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
              if (!paramArrayOfByte.session_id.has()) {
                break label6223;
              }
              localObject1 = paramArrayOfByte.session_id.get();
              ((ARCloudRecogRspFaceResult)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
              if (!paramArrayOfByte.time_ms.has()) {
                break label6230;
              }
              i = paramArrayOfByte.time_ms.get();
              ((ARCloudRecogRspFaceResult)localObject2).jdField_c_of_type_Int = i;
              if (!paramArrayOfByte.group_size.has()) {
                break label6236;
              }
              i = paramArrayOfByte.group_size.get();
              ((ARCloudRecogRspFaceResult)localObject2).jdField_d_of_type_Int = i;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("[ScanStarFace]deserialize  faceResult.errCode_YT = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_Int);
                ((StringBuilder)localObject1).append(",faceResult.errMsg_YT = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_JavaLangString);
                ((StringBuilder)localObject1).append(",faceResult.sessionID = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).jdField_c_of_type_JavaLangString);
                ((StringBuilder)localObject1).append(",faceResult.time_ms_YT = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).jdField_c_of_type_Int);
                ((StringBuilder)localObject1).append(",faceResult.group_size_YT = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).jdField_d_of_type_Int);
                QLog.d("AREngine_ARCloudFileUpload", 2, ((StringBuilder)localObject1).toString());
              }
              if (((ARCloudRecogRspFaceResult)localObject2).jdField_b_of_type_Int == 0)
              {
                if (!paramArrayOfByte.star_info.has()) {
                  break label6242;
                }
                paramArrayOfByte = paramArrayOfByte.star_info.get();
                if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
                {
                  localObject1 = new ArrayList();
                  localObject3 = paramArrayOfByte.iterator();
                  if (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (ARCloudRecogCustomPb.StarInfo)((Iterator)localObject3).next();
                    localObject5 = new ARCloudRecogRspFaceResult.StarInfo();
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).uin.has()) {
                      break label6247;
                    }
                    l1 = ((ARCloudRecogCustomPb.StarInfo)localObject4).uin.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_a_of_type_Long = l1;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).face_rect_id.has()) {
                      break label6255;
                    }
                    i = ((ARCloudRecogCustomPb.StarInfo)localObject4).face_rect_id.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_a_of_type_Int = i;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).name.has()) {
                      break label6261;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).name.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_a_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).pinyin_name.has()) {
                      break label6267;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).pinyin_name.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_b_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki.has()) {
                      break label6273;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_c_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_title.has()) {
                      break label6279;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_title.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_d_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_jumpurl.has()) {
                      break label6285;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_jumpurl.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).e = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).confidence.has()) {
                      break label6291;
                    }
                    f = ((ARCloudRecogCustomPb.StarInfo)localObject4).confidence.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).jdField_a_of_type_Float = f;
                    ((ArrayList)localObject1).add(localObject5);
                    continue;
                  }
                  ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
                }
                ((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus = paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus;
              }
              else
              {
                FaceCluster.getInstance().releaseFaceStatusArray(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus);
              }
            }
          }
          else
          {
            FaceCluster.getInstance().releaseFaceStatusArray(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus);
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("[ScanStarFace]deserialize recog face failed from MQ, faceResult.errCode_MQ = ");
              paramArrayOfByte.append(((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_Int);
              paramArrayOfByte.append(",faceResult.errMsg_MQ = ");
              paramArrayOfByte.append(((ARCloudRecogRspFaceResult)localObject2).jdField_a_of_type_JavaLangString);
              QLog.d("AREngine_ARCloudFileUpload", 2, paramArrayOfByte.toString());
            }
          }
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult = ((ARCloudRecogRspFaceResult)localObject2);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("[ScanStarFace]deserialize recog face result  = ");
            paramArrayOfByte.append(localObject2);
            QLog.d("AREngine_ARCloudFileUpload", 2, paramArrayOfByte.toString());
          }
          l1 = System.currentTimeMillis();
          long l3 = paramARCloudReqInfo.jdField_c_of_type_Long;
          ARFaceDataCollector.a().d = (l1 - l3);
          ARFaceDataCollector.a(paramARCloudReqInfo, (ARCloudRecogRspFaceResult)localObject2);
        }
        if (localARCloudRecogRsp.msg_search_question_result.has())
        {
          paramArrayOfByte = (ARCloudRecogCustomPb.SearchQuestionResult)localARCloudRecogRsp.msg_search_question_result.get();
          paramARCloudReqInfo = new SearchQuestionResult();
          if (!paramArrayOfByte.search_question_errorcode.has()) {
            break label6297;
          }
          i = paramArrayOfByte.search_question_errorcode.get();
          paramARCloudReqInfo.jdField_a_of_type_Int = i;
          if (!paramArrayOfByte.search_question_errormsg.has()) {
            break label6303;
          }
          paramArrayOfByte = paramArrayOfByte.search_question_errormsg.get();
          paramARCloudReqInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (localARCloudRecogRsp.msg_search_question_result.question_res.has())
          {
            localObject1 = (ARCloudRecogCustomPb.QuestionRes)localARCloudRecogRsp.msg_search_question_result.question_res.get();
            l1 = l2;
            if (((ARCloudRecogCustomPb.QuestionRes)localObject1).uin64_question_id.has()) {
              l1 = ((ARCloudRecogCustomPb.QuestionRes)localObject1).uin64_question_id.get();
            }
            paramARCloudReqInfo.jdField_a_of_type_Long = l1;
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).str_question_content.has()) {
              break label6309;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.QuestionRes)localObject1).str_question_content.get();
            paramARCloudReqInfo.jdField_b_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).str_jump_url.has()) {
              break label6315;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.QuestionRes)localObject1).str_jump_url.get();
            paramARCloudReqInfo.jdField_c_of_type_JavaLangString = paramArrayOfByte;
          }
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineSearchQuestionResult = paramARCloudReqInfo;
        }
        if (localARCloudRecogRsp.msg_scene_classify_result.has())
        {
          paramARCloudReqInfo = new ARCloudSceneRecogResult();
          localObject1 = (ARCloudRecogCustomPb.ARSceneClassifyResult)localARCloudRecogRsp.msg_scene_classify_result.get();
          if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errorcode.has()) {
            break label6321;
          }
          i = ((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errorcode.get();
          paramARCloudReqInfo.jdField_a_of_type_Int = i;
          if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errormsg.has()) {
            break label6327;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errormsg.get();
          paramARCloudReqInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).image_ar_search_res.has())
          {
            localObject1 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).image_ar_search_res.get();
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errorcode.has()) {
              break label6333;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errorcode.get();
            paramARCloudReqInfo.jdField_b_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errormsg.has()) {
              break label6339;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errormsg.get();
            paramARCloudReqInfo.jdField_c_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).session_id.has()) {
              break label6345;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).session_id.get();
            paramARCloudReqInfo.jdField_d_of_type_JavaLangString = paramArrayOfByte;
            if ((((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.has()) && (((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.size() > 0))
            {
              k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.size();
              paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag = new ARCloudSceneRecogResult.ImageTag[k];
              i = 0;
              if (i < k)
              {
                localObject2 = new ARCloudSceneRecogResult.ImageTag();
                localObject3 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.get(i);
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).image_id.has()) {
                  break label6351;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).image_id.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_name.has()) {
                  break label6357;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_name.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_b_of_type_JavaLangString = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence.has()) {
                  break label6363;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_a_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence_f.has()) {
                  break label6369;
                }
                f = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence_f.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_a_of_type_Float = f;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).need_check_lbs.has()) {
                  break label6375;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).need_check_lbs.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_b_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_errorcode.has()) {
                  break label6381;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_errorcode.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_c_of_type_Int = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_res.has()) {
                  break label6387;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_res.get().toByteArray();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
                paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag[i] = localObject2;
                i += 1;
                continue;
              }
              if (k > 0)
              {
                if (paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag[0].jdField_b_of_type_Int != 1) {
                  break label6392;
                }
                bool = true;
                paramARCloudReqInfo.jdField_a_of_type_Boolean = bool;
              }
            }
            else
            {
              paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag = null;
            }
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).time_ms.has()) {
              break label6398;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).time_ms.get();
            paramARCloudReqInfo.jdField_c_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).score.has()) {
              break label6404;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).score.get();
            paramARCloudReqInfo.jdField_d_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).kpt_num.has()) {
              break label6410;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).kpt_num.get();
            paramARCloudReqInfo.e = i;
          }
          else
          {
            paramARCloudReqInfo.jdField_b_of_type_Int = -1;
            paramARCloudReqInfo.jdField_c_of_type_JavaLangString = "";
            paramARCloudReqInfo.jdField_d_of_type_JavaLangString = "";
            paramARCloudReqInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag = null;
            paramARCloudReqInfo.jdField_c_of_type_Int = 0;
            paramARCloudReqInfo.jdField_d_of_type_Int = 0;
            paramARCloudReqInfo.e = 0;
          }
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult = paramARCloudReqInfo;
        }
        else
        {
          localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult = null;
        }
        if (!localARCloudRecogRsp.uint64_uin.has()) {
          break label6416;
        }
        l1 = localARCloudRecogRsp.uint64_uin.get();
        localARCloudRecogResult.jdField_b_of_type_Long = l1;
        l1 = localARCloudRecogResult.jdField_b_of_type_Long;
        try
        {
          if (l1 != Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("deserialize pb failed. error uin. recogResult.uin = ");
            paramArrayOfByte.append(localARCloudRecogResult.jdField_b_of_type_Long);
            QLog.i("AREngine_ARCloudFileUpload", 1, paramArrayOfByte.toString());
            return null;
          }
          return localARCloudRecogResult;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        paramARCloudReqInfo = new StringBuilder();
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      paramARCloudReqInfo.append("deserialize pb failed. error msg = ");
      paramARCloudReqInfo.append(paramArrayOfByte.getMessage());
      QLog.i("AREngine_ARCloudFileUpload", 1, paramARCloudReqInfo.toString());
      return null;
      label5713:
      paramArrayOfByte = "";
      continue;
      label5719:
      long l1 = 0L;
      continue;
      label5725:
      int i = -1;
      continue;
      label5731:
      i = -1;
      continue;
      label5737:
      paramArrayOfByte = "";
      continue;
      label5743:
      i = -1;
      continue;
      label5749:
      paramArrayOfByte = "";
      continue;
      label5755:
      paramArrayOfByte = "";
      continue;
      label5761:
      paramArrayOfByte = "";
      continue;
      label5767:
      paramArrayOfByte = "";
      continue;
      label5773:
      int j = 0;
      continue;
      label5779:
      float f = 0.0F;
      continue;
      label5785:
      j = 0;
      continue;
      label5791:
      j = -1;
      continue;
      label5797:
      paramArrayOfByte = null;
      continue;
      label5802:
      boolean bool = false;
      continue;
      label5808:
      i = 0;
      continue;
      label5814:
      i = 0;
      continue;
      label5820:
      i = 0;
      continue;
      label5826:
      i = -1;
      continue;
      label5832:
      paramArrayOfByte = "";
      continue;
      label5838:
      i = -1;
      continue;
      label5844:
      paramArrayOfByte = "";
      continue;
      label5850:
      paramArrayOfByte = "";
      continue;
      label5856:
      paramArrayOfByte = "";
      continue;
      label5862:
      paramArrayOfByte = "";
      continue;
      label5868:
      j = 0;
      continue;
      label5874:
      f = 0.0F;
      continue;
      label5880:
      j = 0;
      continue;
      label5886:
      j = -1;
      continue;
      label5892:
      paramArrayOfByte = null;
      continue;
      label5897:
      bool = false;
      continue;
      label5903:
      i = 0;
      continue;
      label5909:
      i = 0;
      continue;
      label5915:
      i = 0;
      continue;
      label5921:
      i = -1;
      continue;
      label5927:
      paramArrayOfByte = "";
      continue;
      label5933:
      i = -1;
      continue;
      label5939:
      paramArrayOfByte = "";
      continue;
      label5945:
      i = -1;
      continue;
      label5951:
      paramArrayOfByte = "";
      continue;
      label5957:
      i = 0;
      continue;
      label5963:
      i = 0;
      continue;
      label5969:
      i = 0;
      continue;
      label5975:
      i = 0;
      continue;
      label5981:
      f = 0.0F;
      continue;
      label5987:
      i = 0;
      continue;
      label5993:
      j = 0;
      continue;
      label5999:
      j = 0;
      continue;
      label6005:
      double d = 0.0D;
      continue;
      label6010:
      Object localObject1 = "";
      continue;
      label6017:
      int k = 0;
      continue;
      label6023:
      localObject1 = "";
      continue;
      label6030:
      d = 0.0D;
      continue;
      label6035:
      localObject1 = "";
      continue;
      label6042:
      k = 0;
      continue;
      label6048:
      localObject1 = "";
      continue;
      label6055:
      localObject1 = "";
      continue;
      label6062:
      localObject1 = "";
      continue;
      label6069:
      localObject1 = "";
      continue;
      label6076:
      localObject1 = null;
      continue;
      label6082:
      bool = false;
      continue;
      label6088:
      k = 0;
      continue;
      label6094:
      localObject1 = "";
      continue;
      label6101:
      localObject1 = "";
      continue;
      label6108:
      localObject1 = "";
      continue;
      label6115:
      localObject1 = "";
      continue;
      label6122:
      localObject1 = "";
      continue;
      label6129:
      localObject1 = "";
      continue;
      label6136:
      localObject1 = "";
      continue;
      label6143:
      i = -1;
      continue;
      label6149:
      paramArrayOfByte = "";
      continue;
      label6155:
      paramArrayOfByte = "";
      continue;
      label6161:
      i = -1;
      continue;
      label6167:
      paramArrayOfByte = "";
      continue;
      label6173:
      i = 0;
      continue;
      label6179:
      f = 0.0F;
      continue;
      label6185:
      l1 = -1L;
      continue;
      label6193:
      i = -1;
      continue;
      label6199:
      paramArrayOfByte = "";
      continue;
      label6205:
      paramArrayOfByte = null;
      continue;
      label6210:
      i = -1;
      continue;
      label6216:
      localObject1 = "";
      continue;
      label6223:
      localObject1 = "";
      continue;
      label6230:
      i = -1;
      continue;
      label6236:
      i = -1;
      continue;
      label6242:
      paramArrayOfByte = null;
      continue;
      label6247:
      l1 = -1L;
      continue;
      label6255:
      i = -1;
      continue;
      label6261:
      paramArrayOfByte = "";
      continue;
      label6267:
      paramArrayOfByte = "";
      continue;
      label6273:
      paramArrayOfByte = "";
      continue;
      label6279:
      paramArrayOfByte = "";
      continue;
      label6285:
      paramArrayOfByte = "";
      continue;
      label6291:
      f = 0.0F;
      continue;
      label6297:
      i = -1;
      continue;
      label6303:
      paramArrayOfByte = "";
      continue;
      label6309:
      paramArrayOfByte = "";
      continue;
      label6315:
      paramArrayOfByte = "";
      continue;
      label6321:
      i = -1;
      continue;
      label6327:
      paramArrayOfByte = "";
      continue;
      label6333:
      i = -1;
      continue;
      label6339:
      paramArrayOfByte = "";
      continue;
      label6345:
      paramArrayOfByte = "";
      continue;
      label6351:
      paramArrayOfByte = "";
      continue;
      label6357:
      paramArrayOfByte = "";
      continue;
      label6363:
      j = 0;
      continue;
      label6369:
      f = 0.0F;
      continue;
      label6375:
      j = 0;
      continue;
      label6381:
      j = -1;
      continue;
      label6387:
      paramArrayOfByte = null;
      continue;
      label6392:
      bool = false;
      continue;
      label6398:
      i = 0;
      continue;
      label6404:
      i = 0;
      continue;
      label6410:
      i = 0;
      continue;
      label6416:
      l1 = 0L;
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return String.format("%s_%s_%05d", new Object[] { paramAppInterface.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
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
    Object localObject3;
    if ((0x10 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.AROcrInfo();
      localObject2 = new YoutuOcr.YoutuOcrReq();
      ((YoutuOcr.YoutuOcrReq)localObject2).uin32_timeout_ms.set(30000);
      if ((paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo != null) && (!TextUtils.isEmpty(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo.jdField_a_of_type_JavaLangString))) {
        ((YoutuOcr.YoutuOcrReq)localObject2).language.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo.jdField_a_of_type_JavaLangString);
      } else {
        ((YoutuOcr.YoutuOcrReq)localObject2).language.set("auto");
      }
      localObject3 = new JDSearch.JdSearchReq();
      ((JDSearch.JdSearchReq)localObject3).uin32_timeout_ms.set(30000);
      ((ARCloudRecogCustomPb.AROcrInfo)localObject1).uin64_ocr_recog_type.set(17);
      ((ARCloudRecogCustomPb.AROcrInfo)localObject1).youtu_ocr_req.set((MessageMicro)localObject2);
      ((ARCloudRecogCustomPb.AROcrInfo)localObject1).jd_search_req.set((MessageMicro)localObject3);
      localARCloudRecogReq.msg_ocr_info.set((MessageMicro)localObject1);
    }
    long l1 = l2;
    if ((0x4 & l2) != 0L) {
      if ((paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo != null) && (paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus != null) && (paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 0))
      {
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
        ((ARCloudRecogCustomPb.ARFaceRecogInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo.jdField_a_of_type_Int);
        ((ARCloudRecogCustomPb.ARFaceRecogInfo)localObject1).face_rect.set((List)localObject2);
        localARCloudRecogReq.msg_face_recog_info.set((MessageMicro)localObject1);
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace] serialize add faceRectInfo");
          l1 = l2;
        }
      }
      else
      {
        l1 = l2 & 0xFFFFFFFB;
      }
    }
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
    if ((0x2000 & l1) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ImageTranslateReqInfo();
      if (paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqTranslateInfo != null)
      {
        ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).session_uuid.set(ByteStringMicro.copyFromUtf8(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqTranslateInfo.jdField_a_of_type_JavaLangString));
        ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).source_lang.set(ByteStringMicro.copyFromUtf8(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqTranslateInfo.a()));
        ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).target_lang.set(ByteStringMicro.copyFromUtf8(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqTranslateInfo.b()));
        ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).plateform.set(ByteStringMicro.copyFromUtf8("android"));
      }
      localARCloudRecogReq.msg_image_translate_req_info.set((MessageMicro)localObject1);
    }
    localARCloudRecogReq.uin64_req_recog_type.set(l1);
    localARCloudRecogReq.str_clt_version.set(paramARCloudReqInfo.jdField_b_of_type_JavaLangString);
    localARCloudRecogReq.uint64_uin.set(paramARCloudReqInfo.jdField_b_of_type_Long);
    return localARCloudRecogReq.toByteArray();
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 1277	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1278	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: new 1280	java/io/FileInputStream
    //   19: dup
    //   20: aload 6
    //   22: invokespecial 1283	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: aload 6
    //   31: invokevirtual 1286	java/io/File:length	()J
    //   34: invokestatic 1292	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   37: astore 6
    //   39: aload 6
    //   41: astore_0
    //   42: goto +63 -> 105
    //   45: astore_2
    //   46: aload_3
    //   47: astore_0
    //   48: aload_2
    //   49: astore_3
    //   50: goto +79 -> 129
    //   53: aload_3
    //   54: astore_2
    //   55: new 1277	java/io/File
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 1278	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore 6
    //   65: aload_3
    //   66: astore_2
    //   67: aload 6
    //   69: invokevirtual 1295	java/io/File:exists	()Z
    //   72: istore_1
    //   73: aload 5
    //   75: astore_0
    //   76: iload_1
    //   77: ifeq +28 -> 105
    //   80: aload_3
    //   81: astore_2
    //   82: aload 6
    //   84: invokestatic 1300	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull +95 -> 184
    //   92: goto +3 -> 95
    //   95: aload_3
    //   96: astore_2
    //   97: aload_0
    //   98: invokestatic 1305	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   101: astore_0
    //   102: goto -60 -> 42
    //   105: aload_0
    //   106: astore_2
    //   107: aload_3
    //   108: invokevirtual 1308	java/io/FileInputStream:close	()V
    //   111: aload_0
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 1311	java/io/IOException:printStackTrace	()V
    //   118: aload_2
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_2
    //   123: goto +26 -> 149
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_0
    //   130: astore_2
    //   131: aload_3
    //   132: invokevirtual 1312	java/lang/Exception:printStackTrace	()V
    //   135: aload_0
    //   136: ifnull +10 -> 146
    //   139: aload 4
    //   141: astore_2
    //   142: aload_0
    //   143: invokevirtual 1308	java/io/FileInputStream:close	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: aload_2
    //   150: ifnull +15 -> 165
    //   153: aload_2
    //   154: invokevirtual 1308	java/io/FileInputStream:close	()V
    //   157: goto +8 -> 165
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual 1311	java/io/IOException:printStackTrace	()V
    //   165: goto +5 -> 170
    //   168: aload_0
    //   169: athrow
    //   170: goto -2 -> 168
    //   173: astore_2
    //   174: goto -121 -> 53
    //   177: astore_0
    //   178: aload 5
    //   180: astore_0
    //   181: goto -76 -> 105
    //   184: ldc 32
    //   186: astore_0
    //   187: goto -92 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString	String
    //   72	5	1	bool	boolean
    //   27	1	2	localObject1	Object
    //   45	4	2	localException1	java.lang.Exception
    //   54	100	2	localObject2	Object
    //   160	2	2	localIOException	java.io.IOException
    //   173	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   25	83	3	localObject3	Object
    //   126	6	3	localException2	java.lang.Exception
    //   1	139	4	localObject4	Object
    //   4	175	5	localObject5	Object
    //   14	69	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   28	39	45	java/lang/Exception
    //   55	65	45	java/lang/Exception
    //   67	73	45	java/lang/Exception
    //   82	88	45	java/lang/Exception
    //   97	102	45	java/lang/Exception
    //   107	111	113	java/io/IOException
    //   142	146	113	java/io/IOException
    //   6	26	120	finally
    //   6	26	126	java/lang/Exception
    //   28	39	148	finally
    //   55	65	148	finally
    //   67	73	148	finally
    //   82	88	148	finally
    //   97	102	148	finally
    //   131	135	148	finally
    //   153	157	160	java/io/IOException
    //   28	39	173	java/lang/UnsatisfiedLinkError
    //   82	88	177	java/io/IOException
    //   97	102	177	java/io/IOException
  }
  
  public int a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      i = 0;
      if (localObject2 != null)
      {
        int j = this.jdField_a_of_type_JavaUtilArrayList.size();
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cancelTransactionTask. sessionId = ");
          ((StringBuilder)localObject2).append(((ARCloudFileUpload.TaskInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_JavaLangString);
          QLog.i("AREngine_ARCloudFileUpload", 1, ((StringBuilder)localObject2).toString());
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(((ARCloudFileUpload.TaskInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = j;
        return i;
      }
    }
  }
  
  public String a()
  {
    return a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void a()
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null) {
      localAppInterface.getHwEngine().preConnect();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARLBSObserver = new ARCloudFileUpload.1(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArARLBSObserver);
  }
  
  public boolean a(ARCloudReqInfo paramARCloudReqInfo, ARCloudFileUpload.ARCloudFileUploadCallback arg2)
  {
    if ((paramARCloudReqInfo != null) && (??? != null))
    {
      Object localObject1 = new ARCloudFileUpload.2(this, paramARCloudReqInfo, new File(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString).length());
      Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      byte[] arrayOfByte1 = this.jdField_a_of_type_ArrayOfByte;
      if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0)) {}
      try
      {
        int i;
        if (SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session() != null)
        {
          i = SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session().length;
          this.jdField_a_of_type_ArrayOfByte = new byte[i];
          System.arraycopy(SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session(), 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
        }
        arrayOfByte1 = this.jdField_a_of_type_ArrayOfByte;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          arrayOfByte1 = a(paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString);
          if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
          {
            byte[] arrayOfByte2 = a(paramARCloudReqInfo);
            localObject1 = new Transaction((String)localObject2, 42, paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, arrayOfByte1, (ITransactionCallback)localObject1, arrayOfByte2);
            localObject2 = new ARCloudFileUpload.TaskInfo();
            ((ARCloudFileUpload.TaskInfo)localObject2).jdField_a_of_type_JavaLangString = paramARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.jdField_a_of_type_JavaLangString;
            ((ARCloudFileUpload.TaskInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo = paramARCloudReqInfo;
            ((ARCloudFileUpload.TaskInfo)localObject2).jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = ((Transaction)localObject1);
            ((ARCloudFileUpload.TaskInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback = ???;
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject1);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("submitTransactionTask. retCode = ");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(", reqInfo = ");
              ((StringBuilder)localObject1).append(paramARCloudReqInfo);
              QLog.i("AREngine_ARCloudFileUpload", 1, ((StringBuilder)localObject1).toString());
              if (i != 0) {
                break label391;
              }
              return true;
            }
          }
          QLog.i("AREngine_ARCloudFileUpload", 1, "requestToUpload failed. fileMd5 == null || fileMd5.length == 0.");
          return false;
        }
        HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject2);
        QLog.i("AREngine_ARCloudFileUpload", 1, "requestToUpload failed. mSigSession == null || mSigSession.length == 0.");
        return false;
      }
      finally {}
    }
    else
    {
      QLog.i("AREngine_ARCloudFileUpload", 1, "reqInfo == null || callBack == null");
      return false;
    }
    label391:
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, ARCloudFileUpload.ARCloudLBSLocationCheckCallback paramARCloudLBSLocationCheckCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestToCheckLBSLocation. imageId = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", latitude = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", longitude = ");
    localStringBuilder.append(paramInt2);
    QLog.i("AREngine_ARCloudFileUpload", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudLBSLocationCheckCallback = paramARCloudLBSLocationCheckCallback;
    ((ARLBSHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(ArMapConstant.jdField_b_of_type_JavaLangString)).a(paramString, paramInt1, paramInt2);
    return true;
  }
  
  public void b()
  {
    ARLBSObserver localARLBSObserver = this.jdField_a_of_type_ComTencentMobileqqArARLBSObserver;
    if (localARLBSObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(localARLBSObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload
 * JD-Core Version:    0.7.0.1
 */