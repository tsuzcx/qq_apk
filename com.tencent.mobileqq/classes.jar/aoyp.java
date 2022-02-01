import android.text.TextUtils;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageTranslateRspResult;
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
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.ocr.data.TranslateResult;
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

public class aoyp
{
  aorg jdField_a_of_type_Aorg = null;
  private aoyt jdField_a_of_type_Aoyt;
  protected AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<aoyu> jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public aoyp(AppInterface paramAppInterface)
  {
    this(paramAppInterface, false);
  }
  
  public aoyp(AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(paramBoolean);
  }
  
  private apad a(byte[] paramArrayOfByte, apai paramapai)
  {
    apad localapad = new apad();
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
          break label5299;
        }
        paramArrayOfByte = localARCloudRecogRsp.str_session_id.get();
        localapad.jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.uin64_req_recog_type.has()) {
          break label5305;
        }
        l1 = localARCloudRecogRsp.uin64_req_recog_type.get();
        localapad.jdField_a_of_type_Long = l1;
        if (!localARCloudRecogRsp.uin32_business_type.has()) {
          break label5311;
        }
        i = localARCloudRecogRsp.uin32_business_type.get();
        localapad.jdField_a_of_type_Int = i;
        if (!localARCloudRecogRsp.msg_ar_marker_recog_result.has()) {
          break label1292;
        }
        localObject1 = new aozo();
        localObject2 = (ARCloudRecogCustomPb.ARMarkerRecogResult)localARCloudRecogRsp.msg_ar_marker_recog_result.get();
        if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errorcode.has()) {
          break label5317;
        }
        i = ((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errorcode.get();
        ((aozo)localObject1).jdField_a_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errormsg.has()) {
          break label5323;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_errormsg.get();
        ((aozo)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_res.has()) {
          break label1245;
        }
        localObject2 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARMarkerRecogResult)localObject2).image_ar_search_res.get();
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.has()) {
          break label5329;
        }
        i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.get();
        ((aozo)localObject1).jdField_b_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.has()) {
          break label5335;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.get();
        ((aozo)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.has()) {
          break label5341;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.get();
        ((aozo)localObject1).jdField_d_of_type_JavaLangString = paramArrayOfByte;
        if ((((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.has()) && (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size() > 0))
        {
          k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size();
          ((aozo)localObject1).jdField_a_of_type_ArrayOfAozp = new aozp[k];
          i = 0;
          if (i < k)
          {
            localObject3 = new aozp();
            localObject4 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.get(i);
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.has()) {
              break label5347;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.get();
            ((aozp)localObject3).jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.has()) {
              break label5353;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.get();
            ((aozp)localObject3).jdField_b_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.has()) {
              break label5359;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.get();
            ((aozp)localObject3).jdField_a_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.has()) {
              break label5365;
            }
            f = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.get();
            ((aozp)localObject3).jdField_a_of_type_Float = f;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.has()) {
              break label5371;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.get();
            ((aozp)localObject3).jdField_b_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.has()) {
              break label5377;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.get();
            label531:
            ((aozp)localObject3).jdField_c_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.has()) {
              break label5383;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.get().toByteArray();
            label561:
            ((aozp)localObject3).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            ((aozo)localObject1).jdField_a_of_type_ArrayOfAozp[i] = localObject3;
            i += 1;
            continue;
          }
          if (k > 0)
          {
            if (localObject1.jdField_a_of_type_ArrayOfAozp[0].jdField_b_of_type_Int != 1) {
              break label5388;
            }
            bool = true;
            label608:
            ((aozo)localObject1).jdField_a_of_type_Boolean = bool;
          }
          if (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.has())
          {
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.get();
            ((aozo)localObject1).jdField_c_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.has()) {
              break label1233;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.get();
            ((aozo)localObject1).jdField_d_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.has()) {
              break label1239;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.get();
            ((aozo)localObject1).e = i;
            localapad.jdField_a_of_type_Aozo = ((aozo)localObject1);
            if (!localARCloudRecogRsp.msg_ar_object_classify_result.has()) {
              break label2988;
            }
            localObject1 = new aozt();
            localObject2 = (ARCloudRecogCustomPb.ARObjectClassifyResult)localARCloudRecogRsp.msg_ar_object_classify_result.get();
            if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errorcode.has()) {
              break label5394;
            }
            i = ((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errorcode.get();
            label760:
            ((aozt)localObject1).jdField_a_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errormsg.has()) {
              break label5400;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).ar_object_classify_errormsg.get();
            label787:
            ((aozt)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).image_ar_search_res.has()) {
              break label2941;
            }
            localObject2 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARObjectClassifyResult)localObject2).image_ar_search_res.get();
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.has()) {
              break label5406;
            }
            i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errorcode.get();
            label838:
            ((aozt)localObject1).jdField_b_of_type_Int = i;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.has()) {
              break label5412;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).errormsg.get();
            label865:
            ((aozt)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.has()) {
              break label5418;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).session_id.get();
            label891:
            ((aozt)localObject1).jdField_d_of_type_JavaLangString = paramArrayOfByte;
            if ((!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.has()) || (((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size() <= 0)) {
              break label2932;
            }
            k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.size();
            ((aozt)localObject1).jdField_a_of_type_ArrayOfAozu = new aozu[k];
            i = 0;
            if (i >= k) {
              break;
            }
            localObject3 = new aozu();
            localObject4 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).tags.get(i);
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.has()) {
              break label5424;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).image_id.get();
            label993:
            ((aozu)localObject3).jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.has()) {
              break label5430;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_name.get();
            label1019:
            ((aozu)localObject3).jdField_b_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.has()) {
              break label5436;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence.get();
            label1046:
            ((aozu)localObject3).jdField_a_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.has()) {
              break label5442;
            }
            f = ((ARCloudRecogCustomPb.ImageARTag)localObject4).tag_confidence_f.get();
            label1074:
            ((aozu)localObject3).jdField_a_of_type_Float = f;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.has()) {
              break label5448;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).need_check_lbs.get();
            label1102:
            ((aozu)localObject3).jdField_b_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.has()) {
              break label5454;
            }
            j = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_errorcode.get();
            label1130:
            ((aozu)localObject3).jdField_c_of_type_Int = j;
            if (!((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.has()) {
              break label5460;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject4).cdb_res.get().toByteArray();
            label1160:
            ((aozu)localObject3).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            ((aozt)localObject1).jdField_a_of_type_ArrayOfAozu[i] = localObject3;
            i += 1;
            continue;
          }
        }
        else
        {
          ((aozo)localObject1).jdField_a_of_type_ArrayOfAozp = null;
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
      ((aozo)localObject1).jdField_b_of_type_Int = -1;
      ((aozo)localObject1).jdField_c_of_type_JavaLangString = "";
      ((aozo)localObject1).jdField_d_of_type_JavaLangString = "";
      ((aozo)localObject1).jdField_a_of_type_ArrayOfAozp = null;
      ((aozo)localObject1).jdField_c_of_type_Int = 0;
      ((aozo)localObject1).jdField_d_of_type_Int = 0;
      ((aozo)localObject1).e = 0;
      continue;
      label1292:
      localapad.jdField_a_of_type_Aozo = null;
    }
    label1323:
    label1351:
    label1379:
    label1407:
    double d;
    if (k > 0)
    {
      if (localObject1.jdField_a_of_type_ArrayOfAozu[0].jdField_b_of_type_Int == 1)
      {
        bool = true;
        ((aozt)localObject1).jdField_a_of_type_Boolean = bool;
      }
    }
    else
    {
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.has()) {
        break label5471;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).time_ms.get();
      ((aozt)localObject1).jdField_c_of_type_Int = i;
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.has()) {
        break label5477;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).score.get();
      ((aozt)localObject1).jdField_d_of_type_Int = i;
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.has()) {
        break label5483;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject2).kpt_num.get();
      ((aozt)localObject1).e = i;
      label1414:
      localapad.jdField_a_of_type_Aozt = ((aozt)localObject1);
      label1421:
      localapad.jdField_a_of_type_Apbk = null;
      label1489:
      label1516:
      label1651:
      label1784:
      label1916:
      Object localObject5;
      if (localARCloudRecogRsp.msg_img_retrieval_result.has())
      {
        localObject1 = new apbk();
        ((apbk)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        localObject2 = (ARCloudRecogCustomPb.ImgRetrievalResult)localARCloudRecogRsp.msg_img_retrieval_result.get();
        if (!((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).errorcode.has()) {
          break label5489;
        }
        i = ((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).errorcode.get();
        ((apbk)localObject1).jdField_a_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).errormsg.has()) {
          break label5495;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).errormsg.get();
        ((apbk)localObject1).jdField_b_of_type_JavaLangString = paramArrayOfByte;
        if (((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).jd_search_rsp.has()) {
          ((apbk)localObject1).jdField_a_of_type_Apbn = apbk.a((JDSearch.JdSearchRsp)((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).jd_search_rsp.get());
        }
        if (((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).msg_ir_logic_rsp.has())
        {
          localObject2 = (ImageRetrievalLogic.IRLogicRsp)((ARCloudRecogCustomPb.ImgRetrievalResult)localObject2).msg_ir_logic_rsp.get();
          if (!((ImageRetrievalLogic.IRLogicRsp)localObject2).iRetCode.has()) {
            break label5501;
          }
          i = ((ImageRetrievalLogic.IRLogicRsp)localObject2).iRetCode.get();
          label1597:
          ((apbk)localObject1).jdField_b_of_type_Int = i;
          if (!((ImageRetrievalLogic.IRLogicRsp)localObject2).sMsg.has()) {
            break label5507;
          }
          paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject2).sMsg.get();
          label1624:
          ((apbk)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
          if (!((ImageRetrievalLogic.IRLogicRsp)localObject2).iBusiness.has()) {
            break label5513;
          }
          i = ((ImageRetrievalLogic.IRLogicRsp)localObject2).iBusiness.get();
          ((apbk)localObject1).jdField_c_of_type_Int = i;
          if (!((ImageRetrievalLogic.IRLogicRsp)localObject2).sKey.has()) {
            break label5519;
          }
          paramArrayOfByte = ((ImageRetrievalLogic.IRLogicRsp)localObject2).sKey.get();
          label1678:
          ((apbk)localObject1).jdField_d_of_type_JavaLangString = paramArrayOfByte;
          ((apbk)localObject1).jdField_a_of_type_Apbq = null;
          if (((ImageRetrievalLogic.IRLogicRsp)localObject2).stBBox.has())
          {
            ((apbk)localObject1).jdField_a_of_type_Apbq = new apbq();
            paramArrayOfByte = (ImageRetrievalComm.OD_BBox)((ImageRetrievalLogic.IRLogicRsp)localObject2).stBBox.get();
            localObject3 = ((apbk)localObject1).jdField_a_of_type_Apbq;
            if (!paramArrayOfByte.xmin.has()) {
              break label5525;
            }
            i = paramArrayOfByte.xmin.get();
            label1751:
            ((apbq)localObject3).jdField_a_of_type_Int = i;
            localObject3 = ((apbk)localObject1).jdField_a_of_type_Apbq;
            if (!paramArrayOfByte.xmax.has()) {
              break label5531;
            }
            i = paramArrayOfByte.xmax.get();
            ((apbq)localObject3).jdField_b_of_type_Int = i;
            localObject3 = ((apbk)localObject1).jdField_a_of_type_Apbq;
            if (!paramArrayOfByte.ymin.has()) {
              break label5537;
            }
            i = paramArrayOfByte.ymin.get();
            label1817:
            ((apbq)localObject3).jdField_c_of_type_Int = i;
            localObject3 = ((apbk)localObject1).jdField_a_of_type_Apbq;
            if (!paramArrayOfByte.ymax.has()) {
              break label5543;
            }
            i = paramArrayOfByte.ymax.get();
            label1850:
            ((apbq)localObject3).jdField_d_of_type_Int = i;
            localObject3 = ((apbk)localObject1).jdField_a_of_type_Apbq;
            if (!paramArrayOfByte.fScore.has()) {
              break label5549;
            }
            f = paramArrayOfByte.fScore.get();
            label1883:
            ((apbq)localObject3).jdField_a_of_type_Float = f;
            localObject3 = ((apbk)localObject1).jdField_a_of_type_Apbq;
            if (!paramArrayOfByte.iLabelID.has()) {
              break label5555;
            }
            i = paramArrayOfByte.iLabelID.get();
            ((apbq)localObject3).e = i;
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARCloudFileUpload", 2, "[MIGObjectclassifyResult 矩形区域原始数据打印]" + ((apbk)localObject1).jdField_a_of_type_Apbq.toString());
            }
          }
          if ((((ImageRetrievalLogic.IRLogicRsp)localObject2).vClassInfo.has()) && (((ImageRetrievalLogic.IRLogicRsp)localObject2).vClassInfo.size() > 0))
          {
            int m = ((ImageRetrievalLogic.IRLogicRsp)localObject2).vClassInfo.size();
            ((apbk)localObject1).jdField_a_of_type_ArrayOfApbr = new apbr[m];
            localObject2 = ((ImageRetrievalLogic.IRLogicRsp)localObject2).vClassInfo.get();
            i = 0;
            for (;;)
            {
              if (i >= m) {
                break label3016;
              }
              localObject3 = (ImageRetrievalLogic.RetrievalClassInfo)((List)localObject2).get(i);
              localObject4 = new apbr();
              if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iClass.has()) {
                break label5561;
              }
              j = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iClass.get();
              label2069:
              ((apbr)localObject4).jdField_a_of_type_Int = j;
              if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iStatus.has()) {
                break label5567;
              }
              j = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).iStatus.get();
              label2097:
              ((apbr)localObject4).jdField_b_of_type_Int = j;
              if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).dClassProb.has()) {
                break label5573;
              }
              d = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).dClassProb.get();
              label2124:
              ((apbr)localObject4).jdField_a_of_type_Double = d;
              if (!((ImageRetrievalLogic.RetrievalClassInfo)localObject3).sClass.has()) {
                break label5578;
              }
              paramArrayOfByte = ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).sClass.get();
              label2150:
              ((apbr)localObject4).jdField_a_of_type_JavaLangString = paramArrayOfByte;
              if ((((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.has()) && (((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size() > 0)) {
                ((apbr)localObject4).jdField_a_of_type_ArrayOfApbs = new apbs[((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size()];
              }
              if ((((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.has()) && (((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size() > 0))
              {
                j = 0;
                for (;;)
                {
                  if (j < ((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.size())
                  {
                    localObject5 = new apbs();
                    Object localObject6 = (ImageRetrievalLogic.RetrievalItem)((ImageRetrievalLogic.RetrievalClassInfo)localObject3).vItem.get(j);
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iClass.has()) {
                      break label5584;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iClass.get();
                    label2277:
                    ((apbs)localObject5).jdField_a_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sClass.has()) {
                      break label5590;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sClass.get();
                    label2304:
                    ((apbs)localObject5).jdField_a_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).dProb.has()) {
                      break label5596;
                    }
                    d = ((ImageRetrievalLogic.RetrievalItem)localObject6).dProb.get();
                    label2330:
                    ((apbs)localObject5).jdField_a_of_type_Double = d;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sItemID.has()) {
                      break label5601;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sItemID.get();
                    label2356:
                    ((apbs)localObject5).jdField_b_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iSource.has()) {
                      break label5607;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iSource.get();
                    label2383:
                    ((apbs)localObject5).jdField_b_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sPicUrl.has()) {
                      break label5613;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sPicUrl.get();
                    label2410:
                    ((apbs)localObject5).jdField_c_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sTitle.has()) {
                      break label5619;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sTitle.get();
                    label2436:
                    ((apbs)localObject5).jdField_d_of_type_JavaLangString = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sWiki.has()) {
                      break label5625;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sWiki.get();
                    label2462:
                    ((apbs)localObject5).e = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sJumpUrl.has()) {
                      break label5631;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sJumpUrl.get();
                    label2488:
                    ((apbs)localObject5).f = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sCdbRes.has()) {
                      break label5637;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sCdbRes.get().toByteArray();
                    label2517:
                    ((apbs)localObject5).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iAutoJump.has()) {
                      break label5648;
                    }
                    if (((ImageRetrievalLogic.RetrievalItem)localObject6).iAutoJump.get() != 1) {
                      break label5642;
                    }
                    bool = true;
                    label2549:
                    ((apbs)localObject5).jdField_a_of_type_Boolean = bool;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).iNeedCheckLBS.has()) {
                      break label5654;
                    }
                    k = ((ImageRetrievalLogic.RetrievalItem)localObject6).iNeedCheckLBS.get();
                    label2577:
                    ((apbs)localObject5).jdField_c_of_type_Int = k;
                    if (!((ImageRetrievalLogic.RetrievalItem)localObject6).sImageId.has()) {
                      break label5660;
                    }
                    paramArrayOfByte = ((ImageRetrievalLogic.RetrievalItem)localObject6).sImageId.get();
                    label2604:
                    ((apbs)localObject5).g = paramArrayOfByte;
                    if (((ImageRetrievalLogic.RetrievalItem)localObject6).stLabel.has())
                    {
                      localObject6 = (ImageRetrievalLogic.LabelSource)((ImageRetrievalLogic.RetrievalItem)localObject6).stLabel.get();
                      ((apbs)localObject5).jdField_a_of_type_Apbo = new apbo();
                      apbo localapbo;
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.has())
                      {
                        localapbo = ((apbs)localObject5).jdField_a_of_type_Apbo;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.sLabel.has()) {
                          break label5666;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLabelComm.sLabel.get();
                        label2690:
                        localapbo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
                      }
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.has())
                      {
                        localapbo = ((apbs)localObject5).jdField_a_of_type_Apbo;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sTitle.has()) {
                          break label5672;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sTitle.get();
                        label2740:
                        localapbo.jdField_b_of_type_JavaLangString = paramArrayOfByte;
                        localapbo = ((apbs)localObject5).jdField_a_of_type_Apbo;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sISBN.has()) {
                          break label5678;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1003.sISBN.get();
                        label2779:
                        localapbo.jdField_c_of_type_JavaLangString = paramArrayOfByte;
                      }
                      if (((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.has())
                      {
                        localapbo = ((apbs)localObject5).jdField_a_of_type_Apbo;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCity.has()) {
                          break label5684;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCity.get();
                        label2829:
                        localapbo.e = paramArrayOfByte;
                        localapbo = ((apbs)localObject5).jdField_a_of_type_Apbo;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCountry.has()) {
                          break label5690;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sCountry.get();
                        label2868:
                        localapbo.jdField_d_of_type_JavaLangString = paramArrayOfByte;
                        localapbo = ((apbs)localObject5).jdField_a_of_type_Apbo;
                        if (!((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sTour.has()) {
                          break label5696;
                        }
                        paramArrayOfByte = ((ImageRetrievalLogic.LabelSource)localObject6).stLable1004.sTour.get();
                        label2907:
                        localapbo.f = paramArrayOfByte;
                      }
                    }
                    ((apbr)localObject4).jdField_a_of_type_ArrayOfApbs[j] = localObject5;
                    j += 1;
                    continue;
                    label2932:
                    ((aozt)localObject1).jdField_a_of_type_ArrayOfAozu = null;
                    break;
                    label2941:
                    ((aozt)localObject1).jdField_b_of_type_Int = -1;
                    ((aozt)localObject1).jdField_c_of_type_JavaLangString = "";
                    ((aozt)localObject1).jdField_d_of_type_JavaLangString = "";
                    ((aozt)localObject1).jdField_a_of_type_ArrayOfAozu = null;
                    ((aozt)localObject1).jdField_c_of_type_Int = 0;
                    ((aozt)localObject1).jdField_d_of_type_Int = 0;
                    ((aozt)localObject1).e = 0;
                    break label1414;
                    label2988:
                    localapad.jdField_a_of_type_Aozt = null;
                    break label1421;
                  }
                }
              }
              ((apbk)localObject1).jdField_a_of_type_ArrayOfApbr[i] = localObject4;
              i += 1;
            }
          }
        }
        label3016:
        ((apbk)localObject1).jdField_a_of_type_Boolean = ((apbk)localObject1).d();
        ((apbk)localObject1).e = ((apbk)localObject1).a();
        localapad.jdField_a_of_type_Apbk = ((apbk)localObject1);
      }
      if (localARCloudRecogRsp.msg_word_detect_result.has())
      {
        localObject1 = new aozv();
        if (!localARCloudRecogRsp.msg_word_detect_result.errorcode.has()) {
          break label5702;
        }
        i = localARCloudRecogRsp.msg_word_detect_result.errorcode.get();
        label3090:
        ((aozv)localObject1).jdField_a_of_type_Int = i;
        if (!localARCloudRecogRsp.msg_word_detect_result.errormsg.has()) {
          break label5708;
        }
        paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.errormsg.get();
        label3123:
        ((aozv)localObject1).jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.msg_word_detect_result.session_id.has()) {
          break label5714;
        }
        paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.session_id.get();
        label3155:
        ((aozv)localObject1).jdField_b_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.has()) {
          break label5720;
        }
        i = localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.get();
        label3188:
        ((aozv)localObject1).jdField_b_of_type_Int = i;
        if (!localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.has()) {
          break label5726;
        }
        paramArrayOfByte = localARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.get();
        label3221:
        ((aozv)localObject1).jdField_c_of_type_JavaLangString = paramArrayOfByte;
        if (!localARCloudRecogRsp.msg_word_detect_result.word_type.has()) {
          break label5732;
        }
        i = localARCloudRecogRsp.msg_word_detect_result.word_type.get();
        label3254:
        ((aozv)localObject1).jdField_c_of_type_Int = i;
        if (!localARCloudRecogRsp.msg_word_detect_result.confidence.has()) {
          break label5738;
        }
        f = localARCloudRecogRsp.msg_word_detect_result.confidence.get();
        label3288:
        ((aozv)localObject1).jdField_a_of_type_Float = f;
        if (((aozv)localObject1).a())
        {
          localapad.jdField_a_of_type_Aozv = ((aozv)localObject1);
          if (!localARCloudRecogRsp.msg_ocr_result.has()) {
            break label4151;
          }
          paramArrayOfByte = new ayhk();
          localObject1 = (ARCloudRecogCustomPb.AROcrResult)localARCloudRecogRsp.msg_ocr_result.get();
          if (!((ARCloudRecogCustomPb.AROcrResult)localObject1).uin64_ocr_recog_type.has()) {
            break label5744;
          }
          l1 = ((ARCloudRecogCustomPb.AROcrResult)localObject1).uin64_ocr_recog_type.get();
          label3363:
          if (((l1 & 1L) == 1L) && (((ARCloudRecogCustomPb.AROcrResult)localObject1).youtu_ocr_rsp.has())) {
            paramArrayOfByte.a = ayhk.a((YoutuOcr.YoutuOcrRsp)((ARCloudRecogCustomPb.AROcrResult)localObject1).youtu_ocr_rsp.get());
          }
          localapad.jdField_a_of_type_Ayhk = paramArrayOfByte;
        }
      }
      label3407:
      label3677:
      label3829:
      for (;;)
      {
        label3703:
        if (localARCloudRecogRsp.msg_face_recog_result.has())
        {
          localObject2 = new apaf();
          localObject1 = (ARCloudRecogCustomPb.ARFaceRecogResult)localARCloudRecogRsp.msg_face_recog_result.get();
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errorcode.has()) {
            break label5752;
          }
          i = ((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errorcode.get();
          ((apaf)localObject2).jdField_a_of_type_Int = i;
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errormsg.has()) {
            break label5758;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).ar_face_recog_errormsg.get();
          ((apaf)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize  faceResult.errCode_MQ = " + ((apaf)localObject2).jdField_a_of_type_Int + ",faceResult.errMsg_MQ = " + ((apaf)localObject2).jdField_a_of_type_JavaLangString);
          }
          if (((apaf)localObject2).jdField_a_of_type_Int != 0) {
            break label4927;
          }
          if (!((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).image_ar_face_recog_res.has()) {
            break label5764;
          }
          paramArrayOfByte = (ARCloudRecogCustomPb.ARFaceRecogRes)((ARCloudRecogCustomPb.ARFaceRecogResult)localObject1).image_ar_face_recog_res.get();
          label3576:
          if (paramArrayOfByte != null)
          {
            if (!paramArrayOfByte.errorcode.has()) {
              break label5769;
            }
            i = paramArrayOfByte.errorcode.get();
            ((apaf)localObject2).jdField_b_of_type_Int = i;
            if (!paramArrayOfByte.errormsg.has()) {
              break label5775;
            }
            localObject1 = paramArrayOfByte.errormsg.get();
            ((apaf)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
            if (!paramArrayOfByte.session_id.has()) {
              break label5782;
            }
            localObject1 = paramArrayOfByte.session_id.get();
            ((apaf)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
            if (!paramArrayOfByte.time_ms.has()) {
              break label5789;
            }
            i = paramArrayOfByte.time_ms.get();
            ((apaf)localObject2).jdField_c_of_type_Int = i;
            if (!paramArrayOfByte.group_size.has()) {
              break label5795;
            }
            i = paramArrayOfByte.group_size.get();
            ((apaf)localObject2).jdField_d_of_type_Int = i;
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize  faceResult.errCode_YT = " + ((apaf)localObject2).jdField_b_of_type_Int + ",faceResult.errMsg_YT = " + ((apaf)localObject2).jdField_b_of_type_JavaLangString + ",faceResult.sessionID = " + ((apaf)localObject2).jdField_c_of_type_JavaLangString + ",faceResult.time_ms_YT = " + ((apaf)localObject2).jdField_c_of_type_Int + ",faceResult.group_size_YT = " + ((apaf)localObject2).jdField_d_of_type_Int);
            }
            if (((apaf)localObject2).jdField_b_of_type_Int != 0) {
              break label4911;
            }
            if (!paramArrayOfByte.star_info.has()) {
              break label5801;
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
                  localObject5 = new apag();
                  if (!((ARCloudRecogCustomPb.StarInfo)localObject4).uin.has()) {
                    break label5806;
                  }
                  l1 = ((ARCloudRecogCustomPb.StarInfo)localObject4).uin.get();
                  ((apag)localObject5).jdField_a_of_type_Long = l1;
                  if (!((ARCloudRecogCustomPb.StarInfo)localObject4).face_rect_id.has()) {
                    break label5814;
                  }
                  i = ((ARCloudRecogCustomPb.StarInfo)localObject4).face_rect_id.get();
                  ((apag)localObject5).jdField_a_of_type_Int = i;
                  if (!((ARCloudRecogCustomPb.StarInfo)localObject4).name.has()) {
                    break label5820;
                  }
                  paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).name.get();
                  label3966:
                  ((apag)localObject5).jdField_a_of_type_JavaLangString = paramArrayOfByte;
                  if (!((ARCloudRecogCustomPb.StarInfo)localObject4).pinyin_name.has()) {
                    break label5826;
                  }
                  paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).pinyin_name.get();
                  ((apag)localObject5).jdField_b_of_type_JavaLangString = paramArrayOfByte;
                  if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki.has()) {
                    break label5832;
                  }
                  paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki.get();
                  ((apag)localObject5).jdField_c_of_type_JavaLangString = paramArrayOfByte;
                  if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_title.has()) {
                    break label5838;
                  }
                  paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_title.get();
                  ((apag)localObject5).jdField_d_of_type_JavaLangString = paramArrayOfByte;
                  if (!((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_jumpurl.has()) {
                    break label5844;
                  }
                  paramArrayOfByte = ((ARCloudRecogCustomPb.StarInfo)localObject4).star_wiki_jumpurl.get();
                  ((apag)localObject5).e = paramArrayOfByte;
                  if (!((ARCloudRecogCustomPb.StarInfo)localObject4).confidence.has()) {
                    break label5850;
                  }
                  f = ((ARCloudRecogCustomPb.StarInfo)localObject4).confidence.get();
                  ((apag)localObject5).jdField_a_of_type_Float = f;
                  ((ArrayList)localObject1).add(localObject5);
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.d("ARCloudRecogResult", 2, ((aozv)localObject1).toString());
                  }
                  localapad.jdField_a_of_type_Aozv = null;
                  break;
                  localapad.jdField_a_of_type_Aozv = null;
                  break;
                  localapad.jdField_a_of_type_Ayhk = null;
                  break label3407;
                }
              }
              ((apaf)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
            }
            ((apaf)localObject2).jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus = paramapai.jdField_a_of_type_Aozz.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus;
          }
        }
      }
      for (;;)
      {
        label3461:
        label3488:
        label3625:
        label3651:
        label3911:
        label3939:
        label4070:
        localapad.jdField_a_of_type_Apaf = ((apaf)localObject2);
        label3599:
        label3992:
        label4018:
        label4044:
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize recog face result  = " + localObject2);
        }
        label4097:
        label4151:
        l1 = System.currentTimeMillis();
        long l2 = paramapai.jdField_c_of_type_Long;
        apaq.a().d = (l1 - l2);
        apaq.a(paramapai, (apaf)localObject2);
        if (localARCloudRecogRsp.msg_search_question_result.has())
        {
          paramArrayOfByte = (ARCloudRecogCustomPb.SearchQuestionResult)localARCloudRecogRsp.msg_search_question_result.get();
          paramapai = new apct();
          if (!paramArrayOfByte.search_question_errorcode.has()) {
            break label5856;
          }
          i = paramArrayOfByte.search_question_errorcode.get();
          label4298:
          paramapai.jdField_a_of_type_Int = i;
          if (!paramArrayOfByte.search_question_errormsg.has()) {
            break label5862;
          }
          paramArrayOfByte = paramArrayOfByte.search_question_errormsg.get();
          label4322:
          paramapai.jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (localARCloudRecogRsp.msg_search_question_result.question_res.has())
          {
            localObject1 = (ARCloudRecogCustomPb.QuestionRes)localARCloudRecogRsp.msg_search_question_result.question_res.get();
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).uin64_question_id.has()) {
              break label5868;
            }
            l1 = ((ARCloudRecogCustomPb.QuestionRes)localObject1).uin64_question_id.get();
            label4378:
            paramapai.jdField_a_of_type_Long = l1;
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).str_question_content.has()) {
              break label5876;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.QuestionRes)localObject1).str_question_content.get();
            label4404:
            paramapai.jdField_b_of_type_JavaLangString = paramArrayOfByte;
            if (!((ARCloudRecogCustomPb.QuestionRes)localObject1).str_jump_url.has()) {
              break label5882;
            }
            paramArrayOfByte = ((ARCloudRecogCustomPb.QuestionRes)localObject1).str_jump_url.get();
            label4429:
            paramapai.jdField_c_of_type_JavaLangString = paramArrayOfByte;
          }
          localapad.jdField_a_of_type_Apct = paramapai;
        }
        if (!localARCloudRecogRsp.msg_scene_classify_result.has()) {
          break label5281;
        }
        paramapai = new apal();
        localObject1 = (ARCloudRecogCustomPb.ARSceneClassifyResult)localARCloudRecogRsp.msg_scene_classify_result.get();
        if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errorcode.has()) {
          break label5888;
        }
        i = ((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errorcode.get();
        label4493:
        paramapai.jdField_a_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errormsg.has()) {
          break label5894;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).ar_errormsg.get();
        label4519:
        paramapai.jdField_a_of_type_JavaLangString = paramArrayOfByte;
        if (!((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).image_ar_search_res.has()) {
          break label5241;
        }
        localObject1 = (ARCloudRecogCustomPb.ImageARSearchRes)((ARCloudRecogCustomPb.ARSceneClassifyResult)localObject1).image_ar_search_res.get();
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errorcode.has()) {
          break label5900;
        }
        i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errorcode.get();
        label4569:
        paramapai.jdField_b_of_type_Int = i;
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errormsg.has()) {
          break label5906;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).errormsg.get();
        label4595:
        paramapai.jdField_c_of_type_JavaLangString = paramArrayOfByte;
        if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).session_id.has()) {
          break label5912;
        }
        paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).session_id.get();
        label4620:
        paramapai.jdField_d_of_type_JavaLangString = paramArrayOfByte;
        if ((!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.has()) || (((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.size() <= 0)) {
          break label5233;
        }
        k = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.size();
        paramapai.jdField_a_of_type_ArrayOfApam = new apam[k];
        i = 0;
        while (i < k)
        {
          localObject2 = new apam();
          localObject3 = (ARCloudRecogCustomPb.ImageARTag)((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).tags.get(i);
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).image_id.has()) {
            break label5918;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).image_id.get();
          label4720:
          ((apam)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_name.has()) {
            break label5924;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_name.get();
          label4746:
          ((apam)localObject2).jdField_b_of_type_JavaLangString = paramArrayOfByte;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence.has()) {
            break label5930;
          }
          j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence.get();
          label4773:
          ((apam)localObject2).jdField_a_of_type_Int = j;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence_f.has()) {
            break label5936;
          }
          f = ((ARCloudRecogCustomPb.ImageARTag)localObject3).tag_confidence_f.get();
          label4801:
          ((apam)localObject2).jdField_a_of_type_Float = f;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).need_check_lbs.has()) {
            break label5942;
          }
          j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).need_check_lbs.get();
          label4829:
          ((apam)localObject2).jdField_b_of_type_Int = j;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_errorcode.has()) {
            break label5948;
          }
          j = ((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_errorcode.get();
          label4857:
          ((apam)localObject2).jdField_c_of_type_Int = j;
          if (!((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_res.has()) {
            break label5954;
          }
          paramArrayOfByte = ((ARCloudRecogCustomPb.ImageARTag)localObject3).cdb_res.get().toByteArray();
          label4887:
          ((apam)localObject2).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          paramapai.jdField_a_of_type_ArrayOfApam[i] = localObject2;
          i += 1;
        }
        label4911:
        FaceCluster.getInstance().releaseFaceStatusArray(paramapai.jdField_a_of_type_Aozz.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus);
        continue;
        label4927:
        FaceCluster.getInstance().releaseFaceStatusArray(paramapai.jdField_a_of_type_Aozz.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize recog face failed from MQ, faceResult.errCode_MQ = " + ((apaf)localObject2).jdField_a_of_type_Int + ",faceResult.errMsg_MQ = " + ((apaf)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
      if (k > 0)
      {
        if (paramapai.jdField_a_of_type_ArrayOfApam[0].jdField_b_of_type_Int != 1) {
          break label5959;
        }
        bool = true;
        label5015:
        paramapai.jdField_a_of_type_Boolean = bool;
      }
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).time_ms.has()) {
        break label5965;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).time_ms.get();
      label5042:
      paramapai.jdField_c_of_type_Int = i;
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).score.has()) {
        break label5971;
      }
      i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).score.get();
      label5069:
      paramapai.jdField_d_of_type_Int = i;
      if (!((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).kpt_num.has()) {
        break label5977;
      }
    }
    label5281:
    label5296:
    label5299:
    label5305:
    label5311:
    label5317:
    label5323:
    label5329:
    label5335:
    label5720:
    label5977:
    for (int i = ((ARCloudRecogCustomPb.ImageARSearchRes)localObject1).kpt_num.get();; i = 0)
    {
      paramapai.e = i;
      label5102:
      localapad.jdField_a_of_type_Apal = paramapai;
      label5108:
      if (localARCloudRecogRsp.msg_image_translate_rsp_result.has())
      {
        paramArrayOfByte = (ARCloudRecogCustomPb.ImageTranslateRspResult)localARCloudRecogRsp.msg_image_translate_rsp_result.get();
        localapad.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult = new TranslateResult(2);
        localapad.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a(paramArrayOfByte);
      }
      if (localARCloudRecogRsp.uint64_uin.has()) {}
      for (l1 = localARCloudRecogRsp.uint64_uin.get();; l1 = 0L)
      {
        localapad.jdField_b_of_type_Long = l1;
        if (localapad.jdField_b_of_type_Long == Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) {
          break label5296;
        }
        QLog.i("AREngine_ARCloudFileUpload", 1, "deserialize pb failed. error uin. recogResult.uin = " + localapad.jdField_b_of_type_Long);
        return null;
        label5233:
        paramapai.jdField_a_of_type_ArrayOfApam = null;
        break;
        label5241:
        paramapai.jdField_b_of_type_Int = -1;
        paramapai.jdField_c_of_type_JavaLangString = "";
        paramapai.jdField_d_of_type_JavaLangString = "";
        paramapai.jdField_a_of_type_ArrayOfApam = null;
        paramapai.jdField_c_of_type_Int = 0;
        paramapai.jdField_d_of_type_Int = 0;
        paramapai.e = 0;
        break label5102;
        localapad.jdField_a_of_type_Apal = null;
        break label5108;
      }
      return localapad;
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
      label5341:
      paramArrayOfByte = "";
      break label292;
      label5347:
      paramArrayOfByte = "";
      break label394;
      label5353:
      paramArrayOfByte = "";
      break label420;
      label5359:
      j = 0;
      break label447;
      label5365:
      f = 0.0F;
      break label475;
      label5371:
      j = 0;
      break label503;
      j = -1;
      break label531;
      paramArrayOfByte = null;
      break label561;
      bool = false;
      break label608;
      i = -1;
      break label760;
      paramArrayOfByte = "";
      break label787;
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
      label5471:
      i = 0;
      break label1351;
      label5477:
      i = 0;
      break label1379;
      label5483:
      i = 0;
      break label1407;
      label5489:
      i = -1;
      break label1489;
      label5495:
      paramArrayOfByte = "";
      break label1516;
      label5501:
      i = -1;
      break label1597;
      paramArrayOfByte = "";
      break label1624;
      i = -1;
      break label1651;
      paramArrayOfByte = "";
      break label1678;
      i = 0;
      break label1751;
      i = 0;
      break label1784;
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
      label5596:
      d = 0.0D;
      break label2330;
      label5601:
      paramArrayOfByte = "";
      break label2356;
      label5607:
      k = 0;
      break label2383;
      label5613:
      paramArrayOfByte = "";
      break label2410;
      label5619:
      paramArrayOfByte = "";
      break label2436;
      label5625:
      paramArrayOfByte = "";
      break label2462;
      label5631:
      paramArrayOfByte = "";
      break label2488;
      paramArrayOfByte = null;
      break label2517;
      bool = false;
      break label2549;
      bool = false;
      break label2549;
      k = 0;
      break label2577;
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
      label5726:
      paramArrayOfByte = "";
      break label3221;
      label5732:
      i = 0;
      break label3254;
      label5738:
      f = 0.0F;
      break label3288;
      label5744:
      l1 = -1L;
      break label3363;
      label5752:
      i = -1;
      break label3461;
      label5758:
      paramArrayOfByte = "";
      break label3488;
      paramArrayOfByte = null;
      break label3576;
      i = -1;
      break label3599;
      localObject1 = "";
      break label3625;
      localObject1 = "";
      break label3651;
      i = -1;
      break label3677;
      i = -1;
      break label3703;
      paramArrayOfByte = null;
      break label3829;
      l1 = -1L;
      break label3911;
      i = -1;
      break label3939;
      paramArrayOfByte = "";
      break label3966;
      paramArrayOfByte = "";
      break label3992;
      paramArrayOfByte = "";
      break label4018;
      paramArrayOfByte = "";
      break label4044;
      paramArrayOfByte = "";
      break label4070;
      label5850:
      f = 0.0F;
      break label4097;
      label5856:
      i = -1;
      break label4298;
      label5862:
      paramArrayOfByte = "";
      break label4322;
      label5868:
      l1 = -1L;
      break label4378;
      label5876:
      paramArrayOfByte = "";
      break label4404;
      label5882:
      paramArrayOfByte = "";
      break label4429;
      i = -1;
      break label4493;
      paramArrayOfByte = "";
      break label4519;
      i = -1;
      break label4569;
      paramArrayOfByte = "";
      break label4595;
      paramArrayOfByte = "";
      break label4620;
      paramArrayOfByte = "";
      break label4720;
      paramArrayOfByte = "";
      break label4746;
      j = 0;
      break label4773;
      f = 0.0F;
      break label4801;
      j = 0;
      break label4829;
      j = -1;
      break label4857;
      paramArrayOfByte = null;
      break label4887;
      bool = false;
      break label5015;
      i = 0;
      break label5042;
      i = 0;
      break label5069;
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return String.format("%s_%s_%05d", new Object[] { paramAppInterface.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  private byte[] a(apai paramapai)
  {
    ARCloudRecogCommonPb.ARCloudRecogReq localARCloudRecogReq = new ARCloudRecogCommonPb.ARCloudRecogReq();
    localARCloudRecogReq.str_session_id.set(paramapai.jdField_a_of_type_JavaLangString);
    Object localObject1 = new ARCloudRecogCommonPb.ARFileReqInfo();
    ((ARCloudRecogCommonPb.ARFileReqInfo)localObject1).str_file_name.set(paramapai.jdField_a_of_type_Apah.jdField_a_of_type_JavaLangString);
    ((ARCloudRecogCommonPb.ARFileReqInfo)localObject1).uint32_file_format.set(paramapai.jdField_a_of_type_Apah.jdField_a_of_type_Int);
    localARCloudRecogReq.msg_ar_req_file_info.set((MessageMicro)localObject1);
    localARCloudRecogReq.uint32_lon.set(paramapai.jdField_a_of_type_Int);
    localARCloudRecogReq.uint32_lat.set(paramapai.jdField_b_of_type_Int);
    localARCloudRecogReq.uin32_business_type.set(paramapai.jdField_c_of_type_Int);
    long l2 = paramapai.jdField_a_of_type_Long;
    if ((1L & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARMarkerRecogInfo();
      ((ARCloudRecogCustomPb.ARMarkerRecogInfo)localObject1).uin32_timeout_ms.set(paramapai.jdField_a_of_type_Apaj.jdField_a_of_type_Int);
      localARCloudRecogReq.msg_ar_marker_recog_info.set((MessageMicro)localObject1);
    }
    if ((0x2 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARObjectClassifyInfo();
      ((ARCloudRecogCustomPb.ARObjectClassifyInfo)localObject1).uin32_timeout_ms.set(paramapai.jdField_a_of_type_Apaa.jdField_a_of_type_Int);
      localARCloudRecogReq.msg_object_classify_info.set((MessageMicro)localObject1);
    }
    if ((0x80 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ImgRetrievalInfo();
      ((ARCloudRecogCustomPb.ImgRetrievalInfo)localObject1).uin32_timeout_ms.set(paramapai.jdField_b_of_type_Apaa.jdField_a_of_type_Int);
      localARCloudRecogReq.msg_img_retrieval_info.set((MessageMicro)localObject1);
    }
    if ((0x40 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.ARWordDetectInfo();
      ((ARCloudRecogCustomPb.ARWordDetectInfo)localObject1).uin32_timeout_ms.set(paramapai.jdField_a_of_type_Apab.jdField_a_of_type_Int);
      localARCloudRecogReq.msg_word_detect_info.set((MessageMicro)localObject1);
    }
    Object localObject2;
    if ((0x10 & l2) != 0L)
    {
      localObject1 = new ARCloudRecogCustomPb.AROcrInfo();
      localObject2 = new YoutuOcr.YoutuOcrReq();
      ((YoutuOcr.YoutuOcrReq)localObject2).uin32_timeout_ms.set(30000);
      if ((paramapai.jdField_a_of_type_Ayex == null) || (TextUtils.isEmpty(paramapai.jdField_a_of_type_Ayex.jdField_a_of_type_JavaLangString))) {
        break label599;
      }
      ((YoutuOcr.YoutuOcrReq)localObject2).language.set(paramapai.jdField_a_of_type_Ayex.jdField_a_of_type_JavaLangString);
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
      if ((paramapai.jdField_a_of_type_Aozz == null) || (paramapai.jdField_a_of_type_Aozz.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null) || (paramapai.jdField_a_of_type_Aozz.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length <= 0)) {
        break label935;
      }
      localObject1 = new ARCloudRecogCustomPb.ARFaceRecogInfo();
      localObject2 = new ArrayList();
      int j = paramapai.jdField_a_of_type_Aozz.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length;
      int i = 0;
      while (i < j)
      {
        localObject3 = paramapai.jdField_a_of_type_Aozz.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
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
    ((ARCloudRecogCustomPb.ARFaceRecogInfo)localObject1).uin32_timeout_ms.set(paramapai.jdField_a_of_type_Aozz.jdField_a_of_type_Int);
    ((ARCloudRecogCustomPb.ARFaceRecogInfo)localObject1).face_rect.set((List)localObject2);
    localARCloudRecogReq.msg_face_recog_info.set((MessageMicro)localObject1);
    long l1 = l2;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace] serialize add faceRectInfo");
    }
    label672:
    label935:
    for (l1 = l2;; l1 = l2 & 0xFFFFFFFB)
    {
      if ((0x200 & l1) != 0L)
      {
        localObject1 = new ARCloudRecogCustomPb.SearchQuestionInfo();
        ((ARCloudRecogCustomPb.SearchQuestionInfo)localObject1).uin32_timeout_ms.set(30000);
        ((ARCloudRecogCustomPb.SearchQuestionInfo)localObject1).uin64_pic_height.set(paramapai.jdField_a_of_type_Apah.jdField_b_of_type_Int);
        ((ARCloudRecogCustomPb.SearchQuestionInfo)localObject1).uin64_pic_width.set(paramapai.jdField_a_of_type_Apah.jdField_c_of_type_Int);
        localARCloudRecogReq.msg_search_question_info.set((MessageMicro)localObject1);
      }
      if ((0x800 & l1) != 0L)
      {
        localObject1 = new ARCloudRecogCustomPb.ARSceneClassifyInfo();
        ((ARCloudRecogCustomPb.ARSceneClassifyInfo)localObject1).uin32_timeout_ms.set(paramapai.jdField_a_of_type_Apac.jdField_a_of_type_Int);
        localARCloudRecogReq.msg_scene_classify_info.set((MessageMicro)localObject1);
      }
      if ((0x2000 & l1) != 0L)
      {
        localObject1 = new ARCloudRecogCustomPb.ImageTranslateReqInfo();
        if (paramapai.jdField_a_of_type_Apak != null)
        {
          ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).session_uuid.set(ByteStringMicro.copyFromUtf8(paramapai.jdField_a_of_type_Apak.jdField_a_of_type_JavaLangString));
          ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).source_lang.set(ByteStringMicro.copyFromUtf8(paramapai.jdField_a_of_type_Apak.a()));
          ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).target_lang.set(ByteStringMicro.copyFromUtf8(paramapai.jdField_a_of_type_Apak.b()));
          ((ARCloudRecogCustomPb.ImageTranslateReqInfo)localObject1).plateform.set(ByteStringMicro.copyFromUtf8("android"));
        }
        localARCloudRecogReq.msg_image_translate_req_info.set((MessageMicro)localObject1);
      }
      localARCloudRecogReq.uin64_req_recog_type.set(l1);
      localARCloudRecogReq.str_clt_version.set(paramapai.jdField_b_of_type_JavaLangString);
      localARCloudRecogReq.uint64_uin.set(paramapai.jdField_b_of_type_Long);
      return localARCloudRecogReq.toByteArray();
    }
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 1294	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1295	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: new 1297	java/io/FileInputStream
    //   19: dup
    //   20: aload 6
    //   22: invokespecial 1300	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: aload 6
    //   31: invokevirtual 1303	java/io/File:length	()J
    //   34: invokestatic 1309	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   37: astore 6
    //   39: aload 6
    //   41: astore_0
    //   42: aload_0
    //   43: astore_2
    //   44: aload_3
    //   45: ifnull +9 -> 54
    //   48: aload_3
    //   49: invokevirtual 1312	java/io/FileInputStream:close	()V
    //   52: aload_0
    //   53: astore_2
    //   54: aload_2
    //   55: areturn
    //   56: astore_2
    //   57: aload_3
    //   58: astore_2
    //   59: new 1294	java/io/File
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 1295	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload_3
    //   70: astore_2
    //   71: aload 6
    //   73: invokevirtual 1315	java/io/File:exists	()Z
    //   76: istore_1
    //   77: aload 4
    //   79: astore_0
    //   80: iload_1
    //   81: ifeq -39 -> 42
    //   84: aload_3
    //   85: astore_2
    //   86: aload 6
    //   88: invokestatic 1320	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull +13 -> 106
    //   96: aload_3
    //   97: astore_2
    //   98: aload_0
    //   99: invokestatic 1324	bgmj:a	(Ljava/lang/String;)[B
    //   102: astore_0
    //   103: goto -61 -> 42
    //   106: ldc 26
    //   108: astore_0
    //   109: goto -13 -> 96
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual 1327	java/io/IOException:printStackTrace	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore 4
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: astore_2
    //   125: aload 4
    //   127: invokevirtual 1328	java/lang/Exception:printStackTrace	()V
    //   130: aload 5
    //   132: astore_2
    //   133: aload_0
    //   134: ifnull -80 -> 54
    //   137: aload_0
    //   138: invokevirtual 1312	java/io/FileInputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 1327	java/io/IOException:printStackTrace	()V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_0
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 1312	java/io/FileInputStream:close	()V
    //   161: aload_0
    //   162: athrow
    //   163: astore_2
    //   164: aload_2
    //   165: invokevirtual 1327	java/io/IOException:printStackTrace	()V
    //   168: goto -7 -> 161
    //   171: astore_0
    //   172: goto -19 -> 153
    //   175: astore 4
    //   177: aload_3
    //   178: astore_0
    //   179: goto -56 -> 123
    //   182: astore_0
    //   183: aload 4
    //   185: astore_0
    //   186: goto -144 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString	String
    //   76	5	1	bool	boolean
    //   27	28	2	localObject1	Object
    //   56	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   58	40	2	localFileInputStream1	java.io.FileInputStream
    //   112	2	2	localIOException1	java.io.IOException
    //   124	34	2	localObject2	Object
    //   163	2	2	localIOException2	java.io.IOException
    //   25	153	3	localFileInputStream2	java.io.FileInputStream
    //   4	74	4	localObject3	Object
    //   119	7	4	localException1	java.lang.Exception
    //   175	9	4	localException2	java.lang.Exception
    //   1	130	5	localObject4	Object
    //   14	73	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   28	39	56	java/lang/UnsatisfiedLinkError
    //   48	52	112	java/io/IOException
    //   6	26	119	java/lang/Exception
    //   137	141	143	java/io/IOException
    //   6	26	150	finally
    //   157	161	163	java/io/IOException
    //   28	39	171	finally
    //   59	69	171	finally
    //   71	77	171	finally
    //   86	92	171	finally
    //   98	103	171	finally
    //   125	130	171	finally
    //   28	39	175	java/lang/Exception
    //   59	69	175	java/lang/Exception
    //   71	77	175	java/lang/Exception
    //   86	92	175	java/lang/Exception
    //   98	103	175	java/lang/Exception
    //   86	92	182	java/io/IOException
    //   98	103	182	java/io/IOException
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
          QLog.i("AREngine_ARCloudFileUpload", 1, "cancelTransactionTask. sessionId = " + ((aoyu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Apai.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(((aoyu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
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
    return a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
    this.jdField_a_of_type_Aorg = new aoyq(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Aorg);
  }
  
  public boolean a(apai paramapai, aoys arg2)
  {
    if ((paramapai == null) || (??? == null)) {
      QLog.i("AREngine_ARCloudFileUpload", 1, "reqInfo == null || callBack == null");
    }
    for (;;)
    {
      return false;
      long l = 0L;
      Object localObject1 = new File(paramapai.jdField_a_of_type_Apah.jdField_a_of_type_JavaLangString);
      if (localObject1 != null) {
        l = ((File)localObject1).length();
      }
      localObject1 = new aoyr(this, paramapai, l);
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
      byte[] arrayOfByte1 = a(paramapai.jdField_a_of_type_Apah.jdField_a_of_type_JavaLangString);
      if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0))
      {
        QLog.i("AREngine_ARCloudFileUpload", 1, "requestToUpload failed. fileMd5 == null || fileMd5.length == 0.");
        return false;
      }
      byte[] arrayOfByte2 = a(paramapai);
      localObject1 = new Transaction((String)localObject2, 42, paramapai.jdField_a_of_type_Apah.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, arrayOfByte1, (ITransactionCallback)localObject1, arrayOfByte2);
      localObject2 = new aoyu();
      ((aoyu)localObject2).jdField_a_of_type_JavaLangString = paramapai.jdField_a_of_type_Apah.jdField_a_of_type_JavaLangString;
      ((aoyu)localObject2).jdField_a_of_type_Apai = paramapai;
      ((aoyu)localObject2).jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = ((Transaction)localObject1);
      ((aoyu)localObject2).jdField_a_of_type_Aoys = ???;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject1);
        QLog.i("AREngine_ARCloudFileUpload", 1, "submitTransactionTask. retCode = " + i + ", reqInfo = " + paramapai);
        if (i != 0) {
          continue;
        }
        return true;
      }
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, aoyt paramaoyt)
  {
    QLog.i("AREngine_ARCloudFileUpload", 1, "requestToCheckLBSLocation. imageId = " + paramString + ", latitude = " + paramInt1 + ", longitude = " + paramInt2);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aoyt = paramaoyt;
    ((aorf)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(5)).a(paramString, paramInt1, paramInt2);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aorg != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Aorg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyp
 * JD-Core Version:    0.7.0.1
 */