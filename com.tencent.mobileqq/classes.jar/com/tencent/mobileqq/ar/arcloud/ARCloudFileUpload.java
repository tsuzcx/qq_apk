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
  protected AppInterface a = null;
  ARLBSObserver b = null;
  private ArrayList<ARCloudFileUpload.TaskInfo> c = null;
  private byte[] d = null;
  private Object e = new Object();
  private String f = "";
  private ARCloudFileUpload.ARCloudLBSLocationCheckCallback g = null;
  
  public ARCloudFileUpload(AppInterface paramAppInterface)
  {
    this(paramAppInterface, false);
  }
  
  public ARCloudFileUpload(AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.a = paramAppInterface;
    this.c = new ArrayList();
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
        localARCloudRecogResult.a = paramArrayOfByte;
        if (!localARCloudRecogRsp.uin64_req_recog_type.has()) {
          break label5719;
        }
        l1 = localARCloudRecogRsp.uin64_req_recog_type.get();
        localARCloudRecogResult.b = l1;
        if (!localARCloudRecogRsp.uin32_business_type.has()) {
          break label5725;
        }
        i = localARCloudRecogRsp.uin32_business_type.get();
        localARCloudRecogResult.c = i;
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
          ((ARCloudMarkerRecogResult)localObject1).a = i;
          if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errormsg.has()) {
            break label5737;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errormsg.get();
          ((ARCloudMarkerRecogResult)localObject1).b = paramArrayOfByte;
          if (((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_res.has())
          {
            localObject2 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_res.get();
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.has()) {
              break label5743;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.get();
            ((ARCloudMarkerRecogResult)localObject1).d = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.has()) {
              break label5749;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.get();
            ((ARCloudMarkerRecogResult)localObject1).e = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.has()) {
              break label5755;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.get();
            ((ARCloudMarkerRecogResult)localObject1).f = paramArrayOfByte;
            if ((((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.has()) && (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size() > 0))
            {
              k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size();
              ((ARCloudMarkerRecogResult)localObject1).g = new ARCloudMarkerRecogResult.ImageTag[k];
              i = 0;
              if (i < k)
              {
                localObject3 = new ARCloudMarkerRecogResult.ImageTag();
                localObject4 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.get(i);
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.has()) {
                  break label5761;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).a = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.has()) {
                  break label5767;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).b = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.has()) {
                  break label5773;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).c = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.has()) {
                  break label5779;
                }
                f1 = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).d = f1;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.has()) {
                  break label5785;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).e = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.has()) {
                  break label5791;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.get();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).f = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.has()) {
                  break label5797;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.get().toByteArray();
                ((ARCloudMarkerRecogResult.ImageTag)localObject3).g = paramArrayOfByte;
                ((ARCloudMarkerRecogResult)localObject1).g[i] = localObject3;
                i += 1;
                continue;
              }
              if (k > 0)
              {
                if (localObject1.g[0].e != 1) {
                  break label5802;
                }
                bool = true;
                ((ARCloudMarkerRecogResult)localObject1).k = bool;
              }
            }
            else
            {
              ((ARCloudMarkerRecogResult)localObject1).g = null;
            }
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.has()) {
              break label5808;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.get();
            ((ARCloudMarkerRecogResult)localObject1).h = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.has()) {
              break label5814;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.get();
            ((ARCloudMarkerRecogResult)localObject1).i = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.has()) {
              break label5820;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.get();
            ((ARCloudMarkerRecogResult)localObject1).j = i;
          }
          else
          {
            ((ARCloudMarkerRecogResult)localObject1).d = -1;
            ((ARCloudMarkerRecogResult)localObject1).e = "";
            ((ARCloudMarkerRecogResult)localObject1).f = "";
            ((ARCloudMarkerRecogResult)localObject1).g = null;
            ((ARCloudMarkerRecogResult)localObject1).h = 0;
            ((ARCloudMarkerRecogResult)localObject1).i = 0;
            ((ARCloudMarkerRecogResult)localObject1).j = 0;
          }
          localARCloudRecogResult.d = ((ARCloudMarkerRecogResult)localObject1);
        }
        else
        {
          localARCloudRecogResult.d = null;
        }
        if (localARCloudRecogRsp.msg_ar_object_classify_result.has())
        {
          localObject1 = new ARCloudObjectClassifyResult();
          localObject2 = (ARCloudRecogCustomPb.ARObjectClassifyResult)localARCloudRecogRsp.msg_ar_object_classify_result.get();
          if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errorcode.has()) {
            break label5826;
          }
          i = ((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errorcode.get();
          ((ARCloudObjectClassifyResult)localObject1).a = i;
          if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errormsg.has()) {
            break label5832;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errormsg.get();
          ((ARCloudObjectClassifyResult)localObject1).b = paramArrayOfByte;
          if (((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).image_ar_search_res.has())
          {
            localObject2 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).image_ar_search_res.get();
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.has()) {
              break label5838;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.get();
            ((ARCloudObjectClassifyResult)localObject1).d = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.has()) {
              break label5844;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.get();
            ((ARCloudObjectClassifyResult)localObject1).e = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.has()) {
              break label5850;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.get();
            ((ARCloudObjectClassifyResult)localObject1).f = paramArrayOfByte;
            if ((((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.has()) && (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size() > 0))
            {
              k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size();
              ((ARCloudObjectClassifyResult)localObject1).g = new ARCloudObjectClassifyResult.ImageTag[k];
              i = 0;
              if (i < k)
              {
                localObject3 = new ARCloudObjectClassifyResult.ImageTag();
                localObject4 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.get(i);
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.has()) {
                  break label5856;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).a = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.has()) {
                  break label5862;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).b = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.has()) {
                  break label5868;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).c = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.has()) {
                  break label5874;
                }
                f1 = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).d = f1;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.has()) {
                  break label5880;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).e = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.has()) {
                  break label5886;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.get();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).f = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.has()) {
                  break label5892;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.get().toByteArray();
                ((ARCloudObjectClassifyResult.ImageTag)localObject3).g = paramArrayOfByte;
                ((ARCloudObjectClassifyResult)localObject1).g[i] = localObject3;
                i += 1;
                continue;
              }
              if (k > 0)
              {
                if (localObject1.g[0].e != 1) {
                  break label5897;
                }
                bool = true;
                ((ARCloudObjectClassifyResult)localObject1).k = bool;
              }
            }
            else
            {
              ((ARCloudObjectClassifyResult)localObject1).g = null;
            }
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.has()) {
              break label5903;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.get();
            ((ARCloudObjectClassifyResult)localObject1).h = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.has()) {
              break label5909;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.get();
            ((ARCloudObjectClassifyResult)localObject1).i = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.has()) {
              break label5915;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.get();
            ((ARCloudObjectClassifyResult)localObject1).j = i;
          }
          else
          {
            ((ARCloudObjectClassifyResult)localObject1).d = -1;
            ((ARCloudObjectClassifyResult)localObject1).e = "";
            ((ARCloudObjectClassifyResult)localObject1).f = "";
            ((ARCloudObjectClassifyResult)localObject1).g = null;
            ((ARCloudObjectClassifyResult)localObject1).h = 0;
            ((ARCloudObjectClassifyResult)localObject1).i = 0;
            ((ARCloudObjectClassifyResult)localObject1).j = 0;
          }
          localARCloudRecogResult.e = ((ARCloudObjectClassifyResult)localObject1);
        }
        else
        {
          localARCloudRecogResult.e = null;
        }
        localARCloudRecogResult.j = null;
        Object localObject5;
        if (localARCloudRecogRsp.msg_img_retrieval_result.has())
        {
          localObject2 = new ARMIGObjectClassifyResult();
          ((ARMIGObjectClassifyResult)localObject2).d = System.currentTimeMillis();
          localObject1 = (ARCloudRecogCustomPb.ImgRetrievalResult)localARCloudRecogRsp.msg_img_retrieval_result.get();
          if (!((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).errorcode.has()) {
            break label5921;
          }
          i = ((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).errorcode.get();
          ((ARMIGObjectClassifyResult)localObject2).b = i;
          if (!((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).errormsg.has()) {
            break label5927;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).errormsg.get();
          ((ARMIGObjectClassifyResult)localObject2).c = paramArrayOfByte;
          if (((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).jd_search_rsp.has()) {
            ((ARMIGObjectClassifyResult)localObject2).m = ARMIGObjectClassifyResult.a((JDSearch.JdSearchRsp)((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).jd_search_rsp.get());
          }
          if (((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).msg_ir_logic_rsp.has())
          {
            localObject1 = (ImageRetrievalLogic.IRLogicRsp)((ARCloudRecogCustomPb.ImgRetrievalResult)localObject1).msg_ir_logic_rsp.get();
            if (!((ImageRetrievalLogic.IRLogicRsp)localObject1).iRetCode.has()) {
              break label5933;
            }
            i = ((ImageRetrievalLogic.IRLogicRsp)localObject1).iRetCode.get();
            ((ARMIGObjectClassifyResult)localObject2).e = i;
            if (!((ImageRetrievalLogic.IRLogicRsp)localObject1).sMsg.has()) {
              break label5939;
            }
            paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject1).sMsg.get();
            ((ARMIGObjectClassifyResult)localObject2).f = paramArrayOfByte;
            if (!((ImageRetrievalLogic.IRLogicRsp)localObject1).iBusiness.has()) {
              break label5945;
            }
            i = ((ImageRetrievalLogic.IRLogicRsp)localObject1).iBusiness.get();
            ((ARMIGObjectClassifyResult)localObject2).h = i;
            if (!((ImageRetrievalLogic.IRLogicRsp)localObject1).sKey.has()) {
              break label5951;
            }
            paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject1).sKey.get();
            ((ARMIGObjectClassifyResult)localObject2).i = paramArrayOfByte;
            ((ARMIGObjectClassifyResult)localObject2).j = null;
            if (((ImageRetrievalLogic.IRLogicRsp)localObject1).stBBox.has())
            {
              ((ARMIGObjectClassifyResult)localObject2).j = new ARMIGObjectClassifyResult.ObjectBox();
              paramArrayOfByte = (ImageRetrievalComm.OD_BBox)((ImageRetrievalLogic.IRLogicRsp)localObject1).stBBox.get();
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).j;
              if (!paramArrayOfByte.xmin.has()) {
                break label5957;
              }
              i = paramArrayOfByte.xmin.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).a = i;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).j;
              if (!paramArrayOfByte.xmax.has()) {
                break label5963;
              }
              i = paramArrayOfByte.xmax.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).b = i;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).j;
              if (!paramArrayOfByte.ymin.has()) {
                break label5969;
              }
              i = paramArrayOfByte.ymin.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).c = i;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).j;
              if (!paramArrayOfByte.ymax.has()) {
                break label5975;
              }
              i = paramArrayOfByte.ymax.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).d = i;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).j;
              if (!paramArrayOfByte.fScore.has()) {
                break label5981;
              }
              f1 = paramArrayOfByte.fScore.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).e = f1;
              localObject3 = ((ARMIGObjectClassifyResult)localObject2).j;
              if (!paramArrayOfByte.iLabelID.has()) {
                break label5987;
              }
              i = paramArrayOfByte.iLabelID.get();
              ((ARMIGObjectClassifyResult.ObjectBox)localObject3).f = i;
              if (QLog.isColorLevel())
              {
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append("[MIGObjectclassifyResult 矩形区域原始数据打印]");
                paramArrayOfByte.append(((ARMIGObjectClassifyResult)localObject2).j.toString());
                QLog.d("AREngine_ARCloudFileUpload", 2, paramArrayOfByte.toString());
              }
            }
            if ((((ImageRetrievalLogic.IRLogicRsp)localObject1).vClassInfo.has()) && (((ImageRetrievalLogic.IRLogicRsp)localObject1).vClassInfo.size() > 0))
            {
              int m = ((ImageRetrievalLogic.IRLogicRsp)localObject1).vClassInfo.size();
              ((ARMIGObjectClassifyResult)localObject2).g = new ARMIGObjectClassifyResult.RetrievalClassInfo[m];
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
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).a = j;
                if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iStatus.has()) {
                  break label5999;
                }
                j = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iStatus.get();
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).e = j;
                if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).dClassProb.has()) {
                  break label6005;
                }
                d1 = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).dClassProb.get();
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).c = d1;
                if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).sClass.has()) {
                  break label6010;
                }
                localObject1 = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).sClass.get();
                ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).b = ((String)localObject1);
                if ((((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.has()) && (((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size() > 0)) {
                  ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).d = new ARMIGObjectClassifyResult.RetrievalItem[((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size()];
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
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).a = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sClass.has()) {
                      break label6023;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sClass.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).b = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).dProb.has()) {
                      break label6030;
                    }
                    d1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).dProb.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).c = d1;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sItemID.has()) {
                      break label6035;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sItemID.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).d = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iSource.has()) {
                      break label6042;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iSource.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).f = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sPicUrl.has()) {
                      break label6048;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sPicUrl.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).g = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sTitle.has()) {
                      break label6055;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sTitle.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).h = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sWiki.has()) {
                      break label6062;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sWiki.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).i = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sJumpUrl.has()) {
                      break label6069;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sJumpUrl.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).j = ((String)localObject1);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sCdbRes.has()) {
                      break label6076;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sCdbRes.get().toByteArray();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).k = ((byte[])localObject1);
                    if ((!((ImageRetrievalLogic.RetrievalItem)localObject6).iAutoJump.has()) || (((ImageRetrievalLogic.RetrievalItem)localObject6).iAutoJump.get() != 1)) {
                      break label6082;
                    }
                    bool = true;
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).l = bool;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iNeedCheckLBS.has()) {
                      break label6088;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iNeedCheckLBS.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).n = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sImageId.has()) {
                      break label6094;
                    }
                    localObject1 = ((ImageRetrievalLogic.RetrievalItem)localObject6).sImageId.get();
                    ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).o = ((String)localObject1);
                    if (((ImageRetrievalLogic.RetrievalItem)localObject6).stLabel.has())
                    {
                      localObject6 = (ImageRetrievalLogic.LabelSource)((ImageRetrievalLogic.RetrievalItem)localObject6).stLabel.get();
                      ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e = new ARMIGObjectClassifyResult.LabelSource();
                      ARMIGObjectClassifyResult.LabelSource localLabelSource;
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.sLabel.has()) {
                          break label6101;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.sLabel.get();
                        localLabelSource.a = ((String)localObject1);
                      }
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sTitle.has()) {
                          break label6108;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sTitle.get();
                        localLabelSource.b = ((String)localObject1);
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sISBN.has()) {
                          break label6115;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sISBN.get();
                        localLabelSource.c = ((String)localObject1);
                      }
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.has())
                      {
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCity.has()) {
                          break label6122;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCity.get();
                        localLabelSource.e = ((String)localObject1);
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCountry.has()) {
                          break label6129;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCountry.get();
                        localLabelSource.d = ((String)localObject1);
                        localLabelSource = ((ARMIGObjectClassifyResult.RetrievalItem)localObject5).e;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sTour.has()) {
                          break label6136;
                        }
                        localObject1 = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sTour.get();
                        localLabelSource.f = ((String)localObject1);
                      }
                    }
                    ((ARMIGObjectClassifyResult.RetrievalClassInfo)localObject4).d[j] = localObject5;
                    j += 1;
                    continue;
                  }
                }
                ((ARMIGObjectClassifyResult)localObject2).g[i] = localObject4;
                i += 1;
                continue;
              }
            }
          }
          ((ARMIGObjectClassifyResult)localObject2).k = ((ARMIGObjectClassifyResult)localObject2).f();
          ((ARMIGObjectClassifyResult)localObject2).n = ((ARMIGObjectClassifyResult)localObject2).g();
          localARCloudRecogResult.j = ((ARMIGObjectClassifyResult)localObject2);
        }
        if (localARCloudRecogRsp.msg_word_detect_result.has())
        {
          localObject1 = new ARCloudPreOcrResult();
          if (!localARCloudRecogRsp.msg_word_detect_result.errorcode.has()) {
            break label6143;
          }
          i = localARCloudRecogRsp.msg_word_detect_result.errorcode.get();
          ((ARCloudPreOcrResult)localObject1).a = i;
          if (!localARCloudRecogRsp.msg_word_detect_result.errormsg.has()) {
            break label6149;
          }
          paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.errormsg.get();
          ((ARCloudPreOcrResult)localObject1).b = paramArrayOfByte;
          if (!localARCloudRecogRsp.msg_word_detect_result.session_id.has()) {
            break label6155;
          }
          paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.session_id.get();
          ((ARCloudPreOcrResult)localObject1).c = paramArrayOfByte;
          if (!localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.has()) {
            break label6161;
          }
          i = localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.get();
          ((ARCloudPreOcrResult)localObject1).d = i;
          if (!localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.has()) {
            break label6167;
          }
          paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.get();
          ((ARCloudPreOcrResult)localObject1).e = paramArrayOfByte;
          if (!localARCloudRecogRsp.msg_word_detect_result.word_type.has()) {
            break label6173;
          }
          i = localARCloudRecogRsp.msg_word_detect_result.word_type.get();
          ((ARCloudPreOcrResult)localObject1).f = i;
          if (!localARCloudRecogRsp.msg_word_detect_result.confidence.has()) {
            break label6179;
          }
          f1 = localARCloudRecogRsp.msg_word_detect_result.confidence.get();
          ((ARCloudPreOcrResult)localObject1).g = f1;
          if (((ARCloudPreOcrResult)localObject1).a())
          {
            localARCloudRecogResult.h = ((ARCloudPreOcrResult)localObject1);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ARCloudRecogResult", 2, ((ARCloudPreOcrResult)localObject1).toString());
            }
            localARCloudRecogResult.h = null;
          }
        }
        else
        {
          localARCloudRecogResult.h = null;
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
          localARCloudRecogResult.g = paramArrayOfByte;
        }
        else
        {
          localARCloudRecogResult.g = null;
        }
        if (localARCloudRecogRsp.msg_face_recog_result.has())
        {
          localObject2 = new ARCloudRecogRspFaceResult();
          localObject1 = (ARCloudRecogCustomPb.ARFaceRecogResult)localARCloudRecogRsp.msg_face_recog_result.get();
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errorcode.has()) {
            break label6193;
          }
          i = ((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errorcode.get();
          ((ARCloudRecogRspFaceResult)localObject2).a = i;
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errormsg.has()) {
            break label6199;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errormsg.get();
          ((ARCloudRecogRspFaceResult)localObject2).b = paramArrayOfByte;
          bool = QLog.isColorLevel();
          if (bool)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("[ScanStarFace]deserialize  faceResult.errCode_MQ = ");
            paramArrayOfByte.append(((ARCloudRecogRspFaceResult)localObject2).a);
            paramArrayOfByte.append(",faceResult.errMsg_MQ = ");
            paramArrayOfByte.append(((ARCloudRecogRspFaceResult)localObject2).b);
            QLog.d("AREngine_ARCloudFileUpload", 2, paramArrayOfByte.toString());
          }
          if (((ARCloudRecogRspFaceResult)localObject2).a == 0)
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
              ((ARCloudRecogRspFaceResult)localObject2).c = i;
              if (!paramArrayOfByte.errormsg.has()) {
                break label6216;
              }
              localObject1 = paramArrayOfByte.errormsg.get();
              ((ARCloudRecogRspFaceResult)localObject2).d = ((String)localObject1);
              if (!paramArrayOfByte.session_id.has()) {
                break label6223;
              }
              localObject1 = paramArrayOfByte.session_id.get();
              ((ARCloudRecogRspFaceResult)localObject2).g = ((String)localObject1);
              if (!paramArrayOfByte.time_ms.has()) {
                break label6230;
              }
              i = paramArrayOfByte.time_ms.get();
              ((ARCloudRecogRspFaceResult)localObject2).e = i;
              if (!paramArrayOfByte.group_size.has()) {
                break label6236;
              }
              i = paramArrayOfByte.group_size.get();
              ((ARCloudRecogRspFaceResult)localObject2).f = i;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("[ScanStarFace]deserialize  faceResult.errCode_YT = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).c);
                ((StringBuilder)localObject1).append(",faceResult.errMsg_YT = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).d);
                ((StringBuilder)localObject1).append(",faceResult.sessionID = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).g);
                ((StringBuilder)localObject1).append(",faceResult.time_ms_YT = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).e);
                ((StringBuilder)localObject1).append(",faceResult.group_size_YT = ");
                ((StringBuilder)localObject1).append(((ARCloudRecogRspFaceResult)localObject2).f);
                QLog.d("AREngine_ARCloudFileUpload", 2, ((StringBuilder)localObject1).toString());
              }
              if (((ARCloudRecogRspFaceResult)localObject2).c == 0)
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
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).a = l1;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).face_rect_id.has()) {
                      break label6255;
                    }
                    i = ((ARCloudRecogCustomPb.StarInfo)localObject4).face_rect_id.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).b = i;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).name.has()) {
                      break label6261;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).name.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).c = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).pinyin_name.has()) {
                      break label6267;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).pinyin_name.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).d = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki.has()) {
                      break label6273;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).e = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_title.has()) {
                      break label6279;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_title.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).f = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_jumpurl.has()) {
                      break label6285;
                    }
                    paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_jumpurl.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).g = paramArrayOfByte;
                    if (!((ARCloudRecogCustomPb.StarInfo)localObject4).confidence.has()) {
                      break label6291;
                    }
                    f1 = ((ARCloudRecogCustomPb.StarInfo)localObject4).confidence.get();
                    ((ARCloudRecogRspFaceResult.StarInfo)localObject5).h = f1;
                    ((ArrayList)localObject1).add(localObject5);
                    continue;
                  }
                  ((ARCloudRecogRspFaceResult)localObject2).h = ((ArrayList)localObject1);
                }
                ((ARCloudRecogRspFaceResult)localObject2).i = paramARCloudReqInfo.i.b;
              }
              else
              {
                FaceCluster.getInstance().releaseFaceStatusArray(paramARCloudReqInfo.i.b);
              }
            }
          }
          else
          {
            FaceCluster.getInstance().releaseFaceStatusArray(paramARCloudReqInfo.i.b);
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("[ScanStarFace]deserialize recog face failed from MQ, faceResult.errCode_MQ = ");
              paramArrayOfByte.append(((ARCloudRecogRspFaceResult)localObject2).a);
              paramArrayOfByte.append(",faceResult.errMsg_MQ = ");
              paramArrayOfByte.append(((ARCloudRecogRspFaceResult)localObject2).b);
              QLog.d("AREngine_ARCloudFileUpload", 2, paramArrayOfByte.toString());
            }
          }
          localARCloudRecogResult.f = ((ARCloudRecogRspFaceResult)localObject2);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("[ScanStarFace]deserialize recog face result  = ");
            paramArrayOfByte.append(localObject2);
            QLog.d("AREngine_ARCloudFileUpload", 2, paramArrayOfByte.toString());
          }
          l1 = System.currentTimeMillis();
          long l3 = paramARCloudReqInfo.q;
          ARFaceDataCollector.b().e = (l1 - l3);
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
          paramARCloudReqInfo.a = i;
          if (!paramArrayOfByte.search_question_errormsg.has()) {
            break label6303;
          }
          paramArrayOfByte = paramArrayOfByte.search_question_errormsg.get();
          paramARCloudReqInfo.b = paramArrayOfByte;
          if (localARCloudRecogRsp.msg_search_question_result.question_res.has())
          {
            localObject1 = (ARCloudRecogCustomPb.QuestionRes)localARCloudRecogRsp.msg_search_question_result.question_res.get();
            l1 = l2;
            if (((ARCloudRecogCustomPb.QuestionRes)localObject1).uin64_question_id.has()) {
              l1 = ((ARCloudRecogCustomPb.QuestionRes)localObject1).uin64_question_id.get();
            }
            paramARCloudReqInfo.c = l1;
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).str_question_content.has()) {
              break label6309;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.QuestionRes)localObject1).str_question_content.get();
            paramARCloudReqInfo.d = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).str_jump_url.has()) {
              break label6315;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.QuestionRes)localObject1).str_jump_url.get();
            paramARCloudReqInfo.e = paramArrayOfByte;
          }
          localARCloudRecogResult.i = paramARCloudReqInfo;
        }
        if (localARCloudRecogRsp.msg_scene_classify_result.has())
        {
          paramARCloudReqInfo = new ARCloudSceneRecogResult();
          localObject1 = (ARCloudRecogCustomPb.ARSceneClassifyResult)localARCloudRecogRsp.msg_scene_classify_result.get();
          if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errorcode.has()) {
            break label6321;
          }
          i = ((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errorcode.get();
          paramARCloudReqInfo.a = i;
          if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errormsg.has()) {
            break label6327;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errormsg.get();
          paramARCloudReqInfo.b = paramArrayOfByte;
          if (((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).image_ar_search_res.has())
          {
            localObject1 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).image_ar_search_res.get();
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errorcode.has()) {
              break label6333;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errorcode.get();
            paramARCloudReqInfo.d = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errormsg.has()) {
              break label6339;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errormsg.get();
            paramARCloudReqInfo.e = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).session_id.has()) {
              break label6345;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).session_id.get();
            paramARCloudReqInfo.f = paramArrayOfByte;
            if ((((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.has()) && (((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.size() > 0))
            {
              k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.size();
              paramARCloudReqInfo.g = new ARCloudSceneRecogResult.ImageTag[k];
              i = 0;
              if (i < k)
              {
                localObject2 = new ARCloudSceneRecogResult.ImageTag();
                localObject3 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.get(i);
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).image_id.has()) {
                  break label6351;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).image_id.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).a = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_name.has()) {
                  break label6357;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_name.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).b = paramArrayOfByte;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence.has()) {
                  break label6363;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).c = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence_f.has()) {
                  break label6369;
                }
                f1 = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence_f.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).d = f1;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).need_check_lbs.has()) {
                  break label6375;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).need_check_lbs.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).e = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_errorcode.has()) {
                  break label6381;
                }
                j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_errorcode.get();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).f = j;
                if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_res.has()) {
                  break label6387;
                }
                paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_res.get().toByteArray();
                ((ARCloudSceneRecogResult.ImageTag)localObject2).g = paramArrayOfByte;
                paramARCloudReqInfo.g[i] = localObject2;
                i += 1;
                continue;
              }
              if (k > 0)
              {
                if (paramARCloudReqInfo.g[0].e != 1) {
                  break label6392;
                }
                bool = true;
                paramARCloudReqInfo.k = bool;
              }
            }
            else
            {
              paramARCloudReqInfo.g = null;
            }
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).time_ms.has()) {
              break label6398;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).time_ms.get();
            paramARCloudReqInfo.h = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).score.has()) {
              break label6404;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).score.get();
            paramARCloudReqInfo.i = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).kpt_num.has()) {
              break label6410;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).kpt_num.get();
            paramARCloudReqInfo.j = i;
          }
          else
          {
            paramARCloudReqInfo.d = -1;
            paramARCloudReqInfo.e = "";
            paramARCloudReqInfo.f = "";
            paramARCloudReqInfo.g = null;
            paramARCloudReqInfo.h = 0;
            paramARCloudReqInfo.i = 0;
            paramARCloudReqInfo.j = 0;
          }
          localARCloudRecogResult.k = paramARCloudReqInfo;
        }
        else
        {
          localARCloudRecogResult.k = null;
        }
        if (!localARCloudRecogRsp.uint64_uin.has()) {
          break label6416;
        }
        l1 = localARCloudRecogRsp.uint64_uin.get();
        localARCloudRecogResult.m = l1;
        l1 = localARCloudRecogResult.m;
        try
        {
          if (l1 != Long.parseLong(this.a.getCurrentAccountUin()))
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("deserialize pb failed. error uin. recogResult.uin = ");
            paramArrayOfByte.append(localARCloudRecogResult.m);
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
      float f1 = 0.0F;
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
      f1 = 0.0F;
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
      f1 = 0.0F;
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
      double d1 = 0.0D;
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
      d1 = 0.0D;
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
      f1 = 0.0F;
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
      f1 = 0.0F;
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
      f1 = 0.0F;
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
    localARCloudRecogReq.str_session_id.set(paramARCloudReqInfo.a);
    Object localObject1 = new ARCloudRecogCommonPb.ARFileReqInfo();
    ((ARCloudRecogCommonPb.ARFileReqInfo)localObject1).str_file_name.set(paramARCloudReqInfo.b.a);
    ((ARCloudRecogCommonPb.ARFileReqInfo)localObject1).uint32_file_format.set(paramARCloudReqInfo.b.b);
    localARCloudRecogReq.msg_ar_req_file_info.set((MessageMicro)localObject1);
    localARCloudRecogReq.uint32_lon.set(paramARCloudReqInfo.c);
    localARCloudRecogReq.uint32_lat.set(paramARCloudReqInfo.d);
    localARCloudRecogReq.uin32_business_type.set(paramARCloudReqInfo.f);
    long l2 = paramARCloudReqInfo.e;
    if ((1L & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARMarkerRecogInfo();
      ((ARCloudRecogCustomPb.ARMarkerRecogInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.g.a);
      localARCloudRecogReq.msg_ar_marker_recog_info.set((MessageMicro)localObject1);
    }
    if ((0x2 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARObjectClassifyInfo();
      ((ARCloudRecogCustomPb.ARObjectClassifyInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.h.a);
      localARCloudRecogReq.msg_object_classify_info.set((MessageMicro)localObject1);
    }
    if ((0x80 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ImgRetrievalInfo();
      ((ARCloudRecogCustomPb.ImgRetrievalInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.k.a);
      localARCloudRecogReq.msg_img_retrieval_info.set((MessageMicro)localObject1);
    }
    if ((0x40 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARWordDetectInfo();
      ((ARCloudRecogCustomPb.ARWordDetectInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.j.a);
      localARCloudRecogReq.msg_word_detect_info.set((MessageMicro)localObject1);
    }
    Object localObject2;
    Object localObject3;
    if ((0x10 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.AROcrInfo();
      localObject2 = new YoutuOcr.YoutuOcrReq();
      ((YoutuOcr.YoutuOcrReq)localObject2).uin32_timeout_ms.set(30000);
      if ((paramARCloudReqInfo.m != null) && (!TextUtils.isEmpty(paramARCloudReqInfo.m.a))) {
        ((YoutuOcr.YoutuOcrReq)localObject2).language.set(paramARCloudReqInfo.m.a);
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
      if ((paramARCloudReqInfo.i != null) && (paramARCloudReqInfo.i.b != null) && (paramARCloudReqInfo.i.b.length > 0))
      {
        localObject1 = new ARCloudRecogCustomPb.ARFaceRecogInfo();
        localObject2 = new ArrayList();
        int j = paramARCloudReqInfo.i.b.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = paramARCloudReqInfo.i.b[i];
          ARCloudRecogCustomPb.FaceRect localFaceRect = new ARCloudRecogCustomPb.FaceRect();
          localFaceRect.face_rect_id.set(i);
          localFaceRect.face_origin_x.set(((FaceStatus)localObject3).x);
          localFaceRect.face_origin_y.set(((FaceStatus)localObject3).y);
          localFaceRect.face_size_w.set(((FaceStatus)localObject3).width);
          localFaceRect.face_size_h.set(((FaceStatus)localObject3).height);
          ((ArrayList)localObject2).add(localFaceRect);
          i += 1;
        }
        ((ARCloudRecogCustomPb.ARFaceRecogInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.i.a);
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
      ((ARCloudRecogCustomPb.SearchQuestionInfo)localObject1).uin64_pic_height.set(paramARCloudReqInfo.b.c);
      ((ARCloudRecogCustomPb.SearchQuestionInfo)localObject1).uin64_pic_width.set(paramARCloudReqInfo.b.d);
      localARCloudRecogReq.msg_search_question_info.set((MessageMicro)localObject1);
    }
    if ((0x800 & l1) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARSceneClassifyInfo();
      ((ARCloudRecogCustomPb.ARSceneClassifyInfo)localObject1).uin32_timeout_ms.set(paramARCloudReqInfo.l.a);
      localARCloudRecogReq.msg_scene_classify_info.set((MessageMicro)localObject1);
    }
    if ((0x2000 & l1) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ImageTranslateReqInfo();
      if (paramARCloudReqInfo.n != null)
      {
        ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).session_uuid.set(ByteStringMicro.copyFromUtf8(paramARCloudReqInfo.n.a));
        ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).source_lang.set(ByteStringMicro.copyFromUtf8(paramARCloudReqInfo.n.a()));
        ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).target_lang.set(ByteStringMicro.copyFromUtf8(paramARCloudReqInfo.n.b()));
        ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).plateform.set(ByteStringMicro.copyFromUtf8("android"));
      }
      localARCloudRecogReq.msg_image_translate_req_info.set((MessageMicro)localObject1);
    }
    localARCloudRecogReq.uin64_req_recog_type.set(l1);
    localARCloudRecogReq.str_clt_version.set(paramARCloudReqInfo.o);
    localARCloudRecogReq.uint64_uin.set(paramARCloudReqInfo.p);
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
    //   6: new 1307	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1308	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: new 1310	java/io/FileInputStream
    //   19: dup
    //   20: aload 6
    //   22: invokespecial 1313	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: aload 6
    //   31: invokevirtual 1316	java/io/File:length	()J
    //   34: invokestatic 1322	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
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
    //   55: new 1307	java/io/File
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 1308	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore 6
    //   65: aload_3
    //   66: astore_2
    //   67: aload 6
    //   69: invokevirtual 1325	java/io/File:exists	()Z
    //   72: istore_1
    //   73: aload 5
    //   75: astore_0
    //   76: iload_1
    //   77: ifeq +28 -> 105
    //   80: aload_3
    //   81: astore_2
    //   82: aload 6
    //   84: invokestatic 1330	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull +95 -> 184
    //   92: goto +3 -> 95
    //   95: aload_3
    //   96: astore_2
    //   97: aload_0
    //   98: invokestatic 1335	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   101: astore_0
    //   102: goto -60 -> 42
    //   105: aload_0
    //   106: astore_2
    //   107: aload_3
    //   108: invokevirtual 1338	java/io/FileInputStream:close	()V
    //   111: aload_0
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 1341	java/io/IOException:printStackTrace	()V
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
    //   132: invokevirtual 1342	java/lang/Exception:printStackTrace	()V
    //   135: aload_0
    //   136: ifnull +10 -> 146
    //   139: aload 4
    //   141: astore_2
    //   142: aload_0
    //   143: invokevirtual 1338	java/io/FileInputStream:close	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: aload_2
    //   150: ifnull +15 -> 165
    //   153: aload_2
    //   154: invokevirtual 1338	java/io/FileInputStream:close	()V
    //   157: goto +8 -> 165
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual 1341	java/io/IOException:printStackTrace	()V
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
    //   184: ldc 38
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
  
  public String a()
  {
    return a(this.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.b = new ARCloudFileUpload.1(this);
    this.a.addObserver(this.b);
  }
  
  public boolean a(ARCloudReqInfo paramARCloudReqInfo, ARCloudFileUpload.ARCloudFileUploadCallback arg2)
  {
    if ((paramARCloudReqInfo != null) && (??? != null))
    {
      Object localObject1 = new ARCloudFileUpload.2(this, paramARCloudReqInfo, new File(paramARCloudReqInfo.b.a).length());
      Object localObject2 = this.a.getCurrentAccountUin();
      byte[] arrayOfByte1 = this.d;
      if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0)) {}
      try
      {
        int i;
        if (SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session() != null)
        {
          i = SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session().length;
          this.d = new byte[i];
          System.arraycopy(SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session(), 0, this.d, 0, i);
        }
        arrayOfByte1 = this.d;
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
        {
          arrayOfByte1 = a(paramARCloudReqInfo.b.a);
          if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0))
          {
            byte[] arrayOfByte2 = a(paramARCloudReqInfo);
            localObject1 = new Transaction((String)localObject2, 42, paramARCloudReqInfo.b.a, 0, this.d, arrayOfByte1, (ITransactionCallback)localObject1, arrayOfByte2);
            localObject2 = new ARCloudFileUpload.TaskInfo();
            ((ARCloudFileUpload.TaskInfo)localObject2).a = paramARCloudReqInfo.b.a;
            ((ARCloudFileUpload.TaskInfo)localObject2).b = paramARCloudReqInfo;
            ((ARCloudFileUpload.TaskInfo)localObject2).c = ((Transaction)localObject1);
            ((ARCloudFileUpload.TaskInfo)localObject2).d = ???;
            synchronized (this.e)
            {
              this.c.add(localObject2);
              i = this.a.getHwEngine().submitTransactionTask((Transaction)localObject1);
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
        HwServlet.getConfig(this.a, (String)localObject2);
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
    this.f = paramString;
    this.g = paramARCloudLBSLocationCheckCallback;
    ((ARLBSHandler)this.a.getBusinessHandler(ArMapConstant.b)).a(paramString, paramInt1, paramInt2);
    return true;
  }
  
  public void b()
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface != null) {
      localAppInterface.getHwEngine().preConnect();
    }
  }
  
  public int c()
  {
    int i;
    synchronized (this.e)
    {
      Object localObject2 = this.c;
      i = 0;
      if (localObject2 != null)
      {
        int j = this.c.size();
        while (i < this.c.size())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cancelTransactionTask. sessionId = ");
          ((StringBuilder)localObject2).append(((ARCloudFileUpload.TaskInfo)this.c.get(i)).b.a);
          QLog.i("AREngine_ARCloudFileUpload", 1, ((StringBuilder)localObject2).toString());
          this.a.getHwEngine().cancelTransactionTask(((ARCloudFileUpload.TaskInfo)this.c.get(i)).c);
          i += 1;
        }
        this.c.clear();
        i = j;
        return i;
      }
    }
  }
  
  public void d()
  {
    ARLBSObserver localARLBSObserver = this.b;
    if (localARLBSObserver != null) {
      this.a.removeObserver(localARLBSObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload
 * JD-Core Version:    0.7.0.1
 */