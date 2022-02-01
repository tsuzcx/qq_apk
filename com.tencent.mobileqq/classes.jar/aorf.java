import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.ARClassifyLBSCheckReq;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.ARClassifyLBSCheckRsp;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.LBSPoint;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.ReqBody;
import com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.RspBody;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class aorf
  extends anii
{
  public aorf(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private static aozm a(oidb_cmd0xb49.LBSPoint paramLBSPoint)
  {
    int j = 0;
    aozm localaozm = new aozm();
    int i;
    if (paramLBSPoint.int32_lat.has())
    {
      i = paramLBSPoint.int32_lat.get();
      localaozm.jdField_a_of_type_Int = i;
      if (!paramLBSPoint.int32_lon.has()) {
        break label141;
      }
      i = paramLBSPoint.int32_lon.get();
      label53:
      localaozm.jdField_b_of_type_Int = i;
      if (!paramLBSPoint.str_name.has()) {
        break label146;
      }
      str = paramLBSPoint.str_name.get();
      label77:
      localaozm.jdField_a_of_type_JavaLangString = str;
      if (!paramLBSPoint.str_addr.has()) {
        break label152;
      }
    }
    label141:
    label146:
    label152:
    for (String str = paramLBSPoint.str_addr.get();; str = "")
    {
      localaozm.jdField_b_of_type_JavaLangString = str;
      i = j;
      if (paramLBSPoint.uint32_dist.has()) {
        i = paramLBSPoint.uint32_dist.get();
      }
      localaozm.c = i;
      return localaozm;
      i = 0;
      break;
      i = 0;
      break label53;
      str = "";
      break label77;
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("ARLBSHandler", 1, "requestToCheckLBSLocation. imageId = " + paramString + ", latitude = " + paramInt1 + ", longitude = " + paramInt2);
    Object localObject = new oidb_cmd0xb49.ReqBody();
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
  
  protected Class<? extends anil> observerClass()
  {
    return aorg.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    while (!"OidbSvc.0xb49".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    aozl localaozl = new aozl();
    String str = (String)paramToServiceMsg.getAttribute("imageId", "");
    QLog.i("ARLBSHandler", 1, "req.getAttribute id imageIdSend:" + str);
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new oidb_cmd0xb49.RspBody();
      parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      paramFromServiceMsg.extraData.getString("str_error_msg");
      if (paramToServiceMsg.msg_ar_classify_rsp.has())
      {
        paramFromServiceMsg = (oidb_cmd0xb49.ARClassifyLBSCheckRsp)paramToServiceMsg.msg_ar_classify_rsp.get();
        if (paramFromServiceMsg.str_id.has()) {}
        for (paramToServiceMsg = paramFromServiceMsg.str_id.get(); !paramToServiceMsg.equalsIgnoreCase(str); paramToServiceMsg = "")
        {
          QLog.i("ARLBSHandler", 1, "onReceiveLBSLocation. resp is success. err: image id is not equals. req image id = " + str + ", rsp image id = " + paramToServiceMsg);
          return;
        }
        if (paramFromServiceMsg.uint32_lbs_result.has())
        {
          i = paramFromServiceMsg.uint32_lbs_result.get();
          localaozl.jdField_a_of_type_Int = i;
          localaozl.jdField_a_of_type_JavaLangString = paramToServiceMsg;
          if (!paramFromServiceMsg.msg_nearest_point.has()) {
            break label291;
          }
          paramToServiceMsg = a(paramFromServiceMsg.msg_nearest_point);
          label241:
          localaozl.jdField_a_of_type_Aozm = paramToServiceMsg;
        }
      }
      else
      {
        QLog.i("ARLBSHandler", 1, "onReceiveLBSLocation. resp is success. retCode = " + localaozl.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      notifyUI(1, true, localaozl);
      return;
      i = -1;
      break;
      label291:
      paramToServiceMsg = null;
      break label241;
      QLog.i("ARLBSHandler", 1, "onReceiveLBSLocation. resp is failed. ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aorf
 * JD-Core Version:    0.7.0.1
 */