package com.tencent.mobileqq.ar;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.ARClassifyLBSCheckReq;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.ARClassifyLBSCheckRsp;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.LBSPoint;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.ReqBody;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.RspBody;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult.POIInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ARLBSHandler
  extends BusinessHandler
{
  public ARLBSHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private static ARCloudLBSLocationCheckResult.POIInfo a(oidb_cmd0xb49.LBSPoint paramLBSPoint)
  {
    ARCloudLBSLocationCheckResult.POIInfo localPOIInfo = new ARCloudLBSLocationCheckResult.POIInfo();
    boolean bool = paramLBSPoint.int32_lat.has();
    int j = 0;
    if (bool) {
      i = paramLBSPoint.int32_lat.get();
    } else {
      i = 0;
    }
    localPOIInfo.jdField_a_of_type_Int = i;
    if (paramLBSPoint.int32_lon.has()) {
      i = paramLBSPoint.int32_lon.get();
    } else {
      i = 0;
    }
    localPOIInfo.jdField_b_of_type_Int = i;
    bool = paramLBSPoint.str_name.has();
    String str2 = "";
    if (bool) {
      str1 = paramLBSPoint.str_name.get();
    } else {
      str1 = "";
    }
    localPOIInfo.jdField_a_of_type_JavaLangString = str1;
    String str1 = str2;
    if (paramLBSPoint.str_addr.has()) {
      str1 = paramLBSPoint.str_addr.get();
    }
    localPOIInfo.jdField_b_of_type_JavaLangString = str1;
    int i = j;
    if (paramLBSPoint.uint32_dist.has()) {
      i = paramLBSPoint.uint32_dist.get();
    }
    localPOIInfo.c = i;
    return localPOIInfo;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestToCheckLBSLocation. imageId = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", latitude = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", longitude = ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ARLBSHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xb49.ReqBody();
    ((oidb_cmd0xb49.ReqBody)localObject).int32_lat.set(paramInt1);
    ((oidb_cmd0xb49.ReqBody)localObject).int32_lon.set(paramInt2);
    oidb_cmd0xb49.ARClassifyLBSCheckReq localARClassifyLBSCheckReq = new oidb_cmd0xb49.ARClassifyLBSCheckReq();
    localARClassifyLBSCheckReq.str_id.set(paramString);
    ((oidb_cmd0xb49.ReqBody)localObject).msg_ar_classify_req.set(localARClassifyLBSCheckReq);
    localObject = makeOIDBPkg("OidbSvc.0xb49", 2889, 10, ((oidb_cmd0xb49.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("imageId", paramString);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ARLBSObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if ("OidbSvc.0xb49".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ARCloudLBSLocationCheckResult localARCloudLBSLocationCheckResult = new ARCloudLBSLocationCheckResult();
        String str1 = "";
        String str2 = (String)paramToServiceMsg.getAttribute("imageId", "");
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("req.getAttribute id imageIdSend:");
        paramToServiceMsg.append(str2);
        QLog.i("ARLBSHandler", 1, paramToServiceMsg.toString());
        if (paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg = new oidb_cmd0xb49.RspBody();
          parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
          paramFromServiceMsg.extraData.getString("str_error_msg");
          if (paramToServiceMsg.msg_ar_classify_rsp.has())
          {
            paramFromServiceMsg = (oidb_cmd0xb49.ARClassifyLBSCheckRsp)paramToServiceMsg.msg_ar_classify_rsp.get();
            paramToServiceMsg = str1;
            if (paramFromServiceMsg.str_id.has()) {
              paramToServiceMsg = paramFromServiceMsg.str_id.get();
            }
            if (!paramToServiceMsg.equalsIgnoreCase(str2))
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("onReceiveLBSLocation. resp is success. err: image id is not equals. req image id = ");
              paramFromServiceMsg.append(str2);
              paramFromServiceMsg.append(", rsp image id = ");
              paramFromServiceMsg.append(paramToServiceMsg);
              QLog.i("ARLBSHandler", 1, paramFromServiceMsg.toString());
              return;
            }
            int i;
            if (paramFromServiceMsg.uint32_lbs_result.has()) {
              i = paramFromServiceMsg.uint32_lbs_result.get();
            } else {
              i = -1;
            }
            localARCloudLBSLocationCheckResult.jdField_a_of_type_Int = i;
            localARCloudLBSLocationCheckResult.jdField_a_of_type_JavaLangString = paramToServiceMsg;
            if (paramFromServiceMsg.msg_nearest_point.has()) {
              paramToServiceMsg = a(paramFromServiceMsg.msg_nearest_point);
            } else {
              paramToServiceMsg = null;
            }
            localARCloudLBSLocationCheckResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult$POIInfo = paramToServiceMsg;
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("onReceiveLBSLocation. resp is success. retCode = ");
          paramToServiceMsg.append(localARCloudLBSLocationCheckResult.jdField_a_of_type_Int);
          QLog.i("ARLBSHandler", 1, paramToServiceMsg.toString());
        }
        else
        {
          QLog.i("ARLBSHandler", 1, "onReceiveLBSLocation. resp is failed. ");
        }
        notifyUI(1, true, localARCloudLBSLocationCheckResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARLBSHandler
 * JD-Core Version:    0.7.0.1
 */