import MQQ.GuanjiaReportReq;
import MQQ.GuanjiaReportRsp;
import MQQ.PrivExtV2Req;
import MQQ.PrivExtV2Rsp;
import MQQ.VAResourcesReq;
import MQQ.VAResourcesRsp;
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

public class bcqf
  extends abiv
{
  private static final String[] a = { "ClubInfoSvc", "VipCustom", "QCUniBusinessLogic" };
  
  private long a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      long l = biik.a((QQAppInterface)localAppRuntime, "name_plate_config_version", 0L);
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
    paramUniPacket.setFuncName("queryLhResources");
    paramToServiceMsg = paramToServiceMsg.extraData.getString(aokv.a);
    VAResourcesReq localVAResourcesReq = new VAResourcesReq();
    localVAResourcesReq.sUin = paramToServiceMsg;
    localVAResourcesReq.resourcesFlag = 1;
    localVAResourcesReq.lastVisitTime = bhyu.a;
    paramUniPacket.put("req", localVAResourcesReq);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
    paramUniPacket.setFuncName("queryPrivInfoExtV2");
    String str3 = paramToServiceMsg.extraData.getString(aokv.a);
    Object localObject = paramToServiceMsg.extraData.getString(aokv.c);
    long l1 = paramToServiceMsg.extraData.getLong(aokv.m);
    boolean bool3 = bhzq.a();
    boolean bool1 = false;
    boolean bool2 = false;
    PrivExtV2Req localPrivExtV2Req = new PrivExtV2Req();
    localPrivExtV2Req.sUin = str3;
    localPrivExtV2Req.sKey = ((String)localObject);
    localPrivExtV2Req.iGetType = 0;
    localPrivExtV2Req.qua = bmsw.a();
    QLog.e("VIPService", 1, "Ilive handleGetVipInfoReq qua = " + bmsw.a());
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + str3, 4);
    String str4 = bihq.a(0, BaseApplicationImpl.getContext());
    localObject = bihq.a(1, BaseApplicationImpl.getContext());
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
        break label662;
      }
    }
    for (;;)
    {
      for (;;)
      {
        localPrivExtV2Req.sImsi2 = ((String)localObject);
        localObject = paramToServiceMsg.extraData.getString(aokv.d);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("vip_drawer")))
        {
          localPrivExtV2Req.trace_info = bmfq.a("drawer_trace_info");
          QLog.e("VIPService", 1, "handleGetVipInfoReq getVipInfo set trace_info " + localPrivExtV2Req.trace_info);
        }
        int k = localSharedPreferences.getInt("kingCardSdk", -1);
        if ((!bool3) || (k < 0)) {
          break label669;
        }
        localPrivExtV2Req.sImsi2 = "";
        localPrivExtV2Req.sImsi1 = "";
        localPrivExtV2Req.iWkOrderState1 = k;
        localPrivExtV2Req.iToastVer = localSharedPreferences.getInt("toast_version", 0);
        localPrivExtV2Req.iPopupVer = localSharedPreferences.getInt("popup_version_v2", 0);
        localPrivExtV2Req.pullPayRuleCfgTime = biik.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "last_pull_pay_rule", 0L);
        localPrivExtV2Req.clientLangugeId = 0;
        QLog.e("VIPService", 1, "handleGetVipInfoReq, pullPayRuleCfgTime=" + localPrivExtV2Req.pullPayRuleCfgTime);
        if (QLog.isColorLevel()) {
          QLog.i("VIPService", 2, "handleGetVipInfoReq, iPopupVer: " + localPrivExtV2Req.iPopupVer + " iToastVer:" + localPrivExtV2Req.iToastVer + " canUseTMS:" + bool3 + " sdkCardStatus:" + k + ", send sim1: " + bool1 + ", send sim2:" + bool2);
        }
        paramToServiceMsg.extraData.putBoolean(aokv.i, bool1);
        paramToServiceMsg.extraData.putBoolean(aokv.j, bool2);
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
          localPrivExtV2Req.sImsi1 = blhc.b("a4bd32");
        }
        catch (Exception localException)
        {
          QLog.e("VIPService", 1, "handleGetVipInfoReq", localException);
        }
      }
      break;
      label662:
      localObject = "";
    }
    label669:
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
      label778:
      if (((TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) || (localPrivExtV2Req.sImsi2.equals(str1))) && (!TextUtils.isEmpty(localPrivExtV2Req.sImsi2))) {
        break label1033;
      }
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putString("imsiTwo", "");
      ((SharedPreferences.Editor)localObject).putInt("kingCard2", -1);
      ((SharedPreferences.Editor)localObject).commit();
      j = 1;
      label857:
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi1)) {
        break label1060;
      }
      bool1 = true;
      label871:
      if (TextUtils.isEmpty(localPrivExtV2Req.sImsi2)) {
        break label1066;
      }
    }
    label1033:
    label1060:
    label1066:
    for (bool2 = true;; bool2 = false)
    {
      if (bool1) {
        paramToServiceMsg.extraData.putString(aokv.k, localPrivExtV2Req.sImsi1);
      }
      if (bool2) {
        paramToServiceMsg.extraData.putString(aokv.l, localPrivExtV2Req.sImsi2);
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
        break label778;
      }
      localPrivExtV2Req.sImsi1 = "";
      i = j;
      break label778;
      j = i;
      if (l4 - l2 >= l3) {
        break label857;
      }
      localPrivExtV2Req.sImsi2 = "";
      j = i;
      break label857;
      bool1 = false;
      break label871;
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ClubInfoSvc.queryPrivExt".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramToServiceMsg.extraData.getInt(aokv.b) == 6) {
        return a(paramToServiceMsg, paramFromServiceMsg, new VAResourcesRsp());
      }
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
      if (paramToServiceMsg.extraData.getInt(aokv.b) == 6) {
        bool = b(paramToServiceMsg, paramUniPacket);
      }
    }
    do
    {
      return bool;
      return c(paramToServiceMsg, paramUniPacket);
      if ("ClubInfoSvc.guanjiaReport".equals(paramToServiceMsg.getServiceCmd()))
      {
        paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
        paramUniPacket.setFuncName("guanjiaDoReport");
        localObject = paramToServiceMsg.extraData.getString(aokv.a);
        GuanjiaReportReq localGuanjiaReportReq = new GuanjiaReportReq();
        localGuanjiaReportReq.sPkgName = "mobileQQ";
        localGuanjiaReportReq.uin = Long.parseLong((String)localObject);
        localGuanjiaReportReq.iImplat = 109;
        localGuanjiaReportReq.sPhoneNum = paramToServiceMsg.extraData.getString(aokv.e);
        localGuanjiaReportReq.bKingCard = paramToServiceMsg.extraData.getBoolean(aokv.f);
        localGuanjiaReportReq.iCardType = paramToServiceMsg.extraData.getInt(aokv.g);
        localGuanjiaReportReq.iCardStatus = paramToServiceMsg.extraData.getInt(aokv.h);
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
      ((GetCustomOnlineStatusReq)localObject).lUin = paramToServiceMsg.extraData.getLong(aokv.n);
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
 * Qualified Name:     bcqf
 * JD-Core Version:    0.7.0.1
 */