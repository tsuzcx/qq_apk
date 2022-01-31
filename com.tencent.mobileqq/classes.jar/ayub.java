import MQQ.GuanjiaReportReq;
import MQQ.GuanjiaReportRsp;
import MQQ.PrivExtV2Req;
import MQQ.PrivExtV2Rsp;
import QC.UniGetRsp;
import QC.UniSetRsp;
import VIP.GetCustomOnlineStatusReq;
import VIP.GetCustomOnlineStatusRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ayub
  extends zdf
{
  private static final String[] a = { "ClubInfoSvc", "VipCustom", "QCUniBusinessLogic" };
  
  private long a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      long l = bdwk.a((QQAppInterface)localAppRuntime, "name_plate_config_version", 0L);
      if (TextUtils.isEmpty(NamePlateCfgInfo.getVipNamePlateCfgInfo((QQAppInterface)localAppRuntime, paramString))) {
        return 0L;
      }
      return l;
    }
    return 0L;
  }
  
  private <T> T a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, T paramT)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramToServiceMsg.getByClass("rsp", paramT);
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("VIPService", 1, "decodeWUP: ", paramToServiceMsg);
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
    paramUniPacket.setFuncName("queryPrivInfoExtV2");
    String str3 = paramToServiceMsg.extraData.getString(ambd.a);
    Object localObject = paramToServiceMsg.extraData.getString(ambd.c);
    long l1 = paramToServiceMsg.extraData.getLong(ambd.l);
    boolean bool3 = bdqa.a();
    boolean bool1 = false;
    boolean bool2 = false;
    PrivExtV2Req localPrivExtV2Req = new PrivExtV2Req();
    localPrivExtV2Req.sUin = str3;
    localPrivExtV2Req.sKey = ((String)localObject);
    localPrivExtV2Req.iGetType = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + str3, 4);
    String str4 = bdvr.a(0, BaseApplicationImpl.getContext());
    localObject = bdvr.a(1, BaseApplicationImpl.getContext());
    String str2 = localSharedPreferences.getString("imsiOne", "");
    String str1 = localSharedPreferences.getString("imsiTwo", "");
    long l2 = localSharedPreferences.getLong("kingCardLastRequest", 0L);
    long l3 = localSharedPreferences.getInt("kingCardRequestInterval", 0);
    long l4 = System.currentTimeMillis() / 1000L;
    localPrivExtV2Req.lastVisitTime = l1;
    localPrivExtV2Req.iItemCfgVer = a(str3);
    if (!TextUtils.isEmpty(str4))
    {
      localPrivExtV2Req.sImsi1 = str4;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label551;
      }
    }
    for (;;)
    {
      for (;;)
      {
        localPrivExtV2Req.sImsi2 = ((String)localObject);
        int k = localSharedPreferences.getInt("kingCardSdk", -1);
        if ((!bool3) || (k < 0)) {
          break label558;
        }
        localPrivExtV2Req.sImsi2 = "";
        localPrivExtV2Req.sImsi1 = "";
        localPrivExtV2Req.iWkOrderState1 = k;
        localPrivExtV2Req.iToastVer = localSharedPreferences.getInt("toast_version", 0);
        localPrivExtV2Req.iPopupVer = localSharedPreferences.getInt("popup_version_v2", 0);
        localPrivExtV2Req.pullPayRuleCfgTime = bdwk.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "last_pull_pay_rule", 0L);
        localPrivExtV2Req.clientLangugeId = 0;
        QLog.e("VIPService", 1, "handleGetVipInfoReq, pullPayRuleCfgTime=" + localPrivExtV2Req.pullPayRuleCfgTime);
        if (QLog.isColorLevel()) {
          QLog.i("VIPService", 2, "handleGetVipInfoReq, iPopupVer: " + localPrivExtV2Req.iPopupVer + " iToastVer:" + localPrivExtV2Req.iToastVer + " canUseTMS:" + bool3 + " sdkCardStatus:" + k + ", send sim1: " + bool1 + ", send sim2:" + bool2);
        }
        paramToServiceMsg.extraData.putBoolean(ambd.h, bool1);
        paramToServiceMsg.extraData.putBoolean(ambd.i, bool2);
        paramUniPacket.put("req", localPrivExtV2Req);
        return true;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localPrivExtV2Req.sImsi1 = ((String)localObject);
          localObject = null;
          break;
        }
        try
        {
          localPrivExtV2Req.sImsi1 = bhoi.b("a4bd32");
        }
        catch (Exception localException)
        {
          QLog.e("VIPService", 1, "handleGetVipInfoReq", localException);
        }
      }
      break;
      label551:
      localObject = "";
    }
    label558:
    if ((TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) && (TextUtils.isEmpty(localPrivExtV2Req.sImsi2))) {
      localPrivExtV2Req.iGetType = 1;
    }
    int j = 0;
    int i;
    if (((!TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) && (!localPrivExtV2Req.sImsi1.equals(str2))) || (TextUtils.isEmpty(localPrivExtV2Req.sImsi1)))
    {
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putString("imsiOne", "");
      ((SharedPreferences.Editor)localObject).putInt("kingCard", -1);
      ((SharedPreferences.Editor)localObject).commit();
      i = 1;
      label667:
      if (((TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) || (localPrivExtV2Req.sImsi2.equals(str1))) && (!TextUtils.isEmpty(localPrivExtV2Req.sImsi2))) {
        break label920;
      }
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putString("imsiTwo", "");
      ((SharedPreferences.Editor)localObject).putInt("kingCard2", -1);
      ((SharedPreferences.Editor)localObject).commit();
      j = 1;
      label746:
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) {
        break label947;
      }
      bool1 = true;
      label760:
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) {
        break label953;
      }
    }
    label920:
    label947:
    label953:
    for (bool2 = true;; bool2 = false)
    {
      if (bool1) {
        paramToServiceMsg.extraData.putString(ambd.j, localPrivExtV2Req.sImsi1);
      }
      if (bool2) {
        paramToServiceMsg.extraData.putString(ambd.k, localPrivExtV2Req.sImsi2);
      }
      localPrivExtV2Req.iWkOrderState1 = localSharedPreferences.getInt("kingCard", -1);
      localPrivExtV2Req.iWkOrderState2 = localSharedPreferences.getInt("kingCard2", -1);
      if (j != 0)
      {
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putInt("toast_version", 0);
        ((SharedPreferences.Editor)localObject).putInt("popup_version_v2", 0);
        ((SharedPreferences.Editor)localObject).commit();
      }
      break;
      i = j;
      if (l4 - l2 >= l3) {
        break label667;
      }
      localPrivExtV2Req.sImsi1 = "";
      i = j;
      break label667;
      j = i;
      if (l4 - l2 >= l3) {
        break label746;
      }
      localPrivExtV2Req.sImsi2 = "";
      j = i;
      break label746;
      bool1 = false;
      break label760;
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new PrivExtV2Rsp());
    }
    if ("ClubInfoSvc.guanjiaReport".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new GuanjiaReportRsp());
    }
    if ("VipCustom.GetCustomOnlineStatus".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "decode");
      }
      return a(paramToServiceMsg, paramFromServiceMsg, new GetCustomOnlineStatusRsp());
    }
    if ("QCUniBusinessLogic.uniSet".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new UniSetRsp());
    }
    if ("QCUniBusinessLogic.uniGet".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg, new UniGetRsp());
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool = true;
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd())) {
      bool = b(paramToServiceMsg, paramUniPacket);
    }
    do
    {
      return bool;
      if ("ClubInfoSvc.guanjiaReport".equals(paramToServiceMsg.getServiceCmd()))
      {
        paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
        paramUniPacket.setFuncName("guanjiaDoReport");
        localObject = paramToServiceMsg.extraData.getString(ambd.a);
        GuanjiaReportReq localGuanjiaReportReq = new GuanjiaReportReq();
        localGuanjiaReportReq.sPkgName = "mobileQQ";
        localGuanjiaReportReq.uin = Long.parseLong((String)localObject);
        localGuanjiaReportReq.iImplat = 109;
        localGuanjiaReportReq.sPhoneNum = paramToServiceMsg.extraData.getString(ambd.d);
        localGuanjiaReportReq.bKingCard = paramToServiceMsg.extraData.getBoolean(ambd.e);
        localGuanjiaReportReq.iCardType = paramToServiceMsg.extraData.getInt(ambd.f);
        localGuanjiaReportReq.iCardStatus = paramToServiceMsg.extraData.getInt(ambd.g);
        localGuanjiaReportReq.bReportFlag = false;
        paramUniPacket.put("req", localGuanjiaReportReq);
        return true;
      }
      if (!"VipCustom.GetCustomOnlineStatus".equals(paramToServiceMsg.getServiceCmd())) {
        break;
      }
      paramUniPacket.setServantName("VIP.CustomOnlineStatusServer.CustomOnlineStatusObj");
      paramUniPacket.setFuncName("GetCustomOnlineStatus");
      Object localObject = new GetCustomOnlineStatusReq();
      ((GetCustomOnlineStatusReq)localObject).lUin = paramToServiceMsg.extraData.getLong(ambd.m);
      ((GetCustomOnlineStatusReq)localObject).sIMei = MsfSdkUtils.getIMEIForMain("bussiness_id_customize_online_status");
      paramUniPacket.put("req", localObject);
    } while (!QLog.isDevelopLevel());
    QLog.d("CustomOnlineStatusManager", 4, "encodeReqMsg");
    return true;
    if ("QCUniBusinessLogic.uniSet".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
      paramUniPacket.setFuncName("uniSet");
      paramUniPacket.put("stReq", paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    if ("QCUniBusinessLogic.uniGet".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
      paramUniPacket.setFuncName("uniGet");
      paramUniPacket.put("stReq", paramToServiceMsg.extraData.getSerializable("req"));
      return true;
    }
    return false;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayub
 * JD-Core Version:    0.7.0.1
 */