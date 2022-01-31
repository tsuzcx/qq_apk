package com.tencent.mobileqq.binhai;

import abks;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.ClickPackageReq;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.ClickPackageRsp;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.JoinActivityRsp;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.LBSInfo;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.LBSSig;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.OpenPackageReq;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.OpenPackageRsp;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.ReportPackageReq;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.ReportPackageRsp;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.ReqBody;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.RspBody;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.StartActivityRsp;

public class BinHaiHandler
  extends BusinessHandler
{
  public static String a;
  public static oidb_0x98b.LBSInfo a;
  public static boolean a;
  public static boolean b;
  
  public BinHaiHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static oidb_0x98b.LBSInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d1 = paramSosoLbsInfo.a.b;
    double d2 = paramSosoLbsInfo.a.jdField_a_of_type_Double;
    Object localObject = paramSosoLbsInfo.a.l;
    double d3 = paramSosoLbsInfo.a.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "getLbsInfo , lon=" + d1 + ", lat=" + d2 + ",ver=" + (String)localObject + ", time=" + d2);
    }
    boolean bool;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSosoLbsInfo = new StringBuilder().append("getLbsInfo binhai info's verify key is null, local verify is null?:");
      if (jdField_a_of_type_JavaLangString == null)
      {
        bool = true;
        QLog.i("BinHaiHandler", 2, bool);
        if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          break label275;
        }
      }
    }
    for (paramSosoLbsInfo = jdField_a_of_type_JavaLangString;; paramSosoLbsInfo = (SosoInterface.SosoLbsInfo)localObject)
    {
      localObject = new oidb_0x98b.LBSSig();
      ((oidb_0x98b.LBSSig)localObject).int32_lat.set((int)ArMapUtil.a(d2, 1000000.0D));
      ((oidb_0x98b.LBSSig)localObject).int32_lon.set((int)ArMapUtil.a(d1, 1000000.0D));
      ((oidb_0x98b.LBSSig)localObject).uint32_time.set((int)(d3 / 1000.0D));
      ((oidb_0x98b.LBSSig)localObject).bytes_verify_key.set(ByteStringMicro.copyFromUtf8(paramSosoLbsInfo));
      paramSosoLbsInfo = new oidb_0x98b.LBSInfo();
      paramSosoLbsInfo.msg_lbs_sig.set((MessageMicro)localObject);
      paramSosoLbsInfo.int32_lat.set(((oidb_0x98b.LBSSig)localObject).int32_lat.get());
      paramSosoLbsInfo.int32_lon.set(((oidb_0x98b.LBSSig)localObject).int32_lon.get());
      return paramSosoLbsInfo;
      bool = false;
      break;
      label275:
      return null;
      jdField_a_of_type_JavaLangString = (String)localObject;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "report key=" + paramString + ", success=" + paramBoolean1 + ", errCode=" + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", "errCode");
    StatisticCollector.a(BaseApplication.getContext()).a("", paramString, paramBoolean1, 0L, 0L, localHashMap, "", paramBoolean2);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new oidb_0x98b.RspBody();
      i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      paramFromServiceMsg = paramFromServiceMsg.extraData.getString("str_error_msg");
      paramToServiceMsg = (oidb_0x98b.StartActivityRsp)paramToServiceMsg.msg_start_activity_rsp.get();
      if (paramToServiceMsg == null) {
        break label155;
      }
    }
    label155:
    for (paramToServiceMsg = paramToServiceMsg.bytes_failed_notice.get().toStringUtf8();; paramToServiceMsg = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BinHaiHandler", 2, "handleStartActivity, result=" + i + ", errMsg=" + paramFromServiceMsg + ", tips=" + paramToServiceMsg);
      }
      a(1, true, new Object[] { Integer.valueOf(i), paramToServiceMsg });
      return;
      a(1, true, new Object[] { Integer.valueOf(-1), "网络请求超时，\n请稍后再试" });
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "handleJoinActivity, req=" + paramToServiceMsg + ", resp=" + paramFromServiceMsg + ", data=" + paramObject + ", code=" + paramFromServiceMsg.getBusinessFailCode());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      oidb_0x98b.RspBody localRspBody = new oidb_0x98b.RspBody();
      int n = a(paramFromServiceMsg, paramObject, localRspBody);
      paramFromServiceMsg = paramFromServiceMsg.extraData.getString("str_error_msg");
      int i;
      label197:
      int j;
      label216:
      int k;
      label235:
      int m;
      label254:
      long l1;
      label277:
      long l2;
      if (TextUtils.isEmpty(paramFromServiceMsg))
      {
        paramFromServiceMsg = "";
        if (QLog.isColorLevel()) {
          QLog.d("BinHaiHandler", 2, "handleJoinActivity, result=" + n + ", errMsg=" + paramFromServiceMsg);
        }
        if (n != 0) {
          break label571;
        }
        paramToServiceMsg = (oidb_0x98b.JoinActivityRsp)localRspBody.msg_join_activity_rsp.get();
        paramFromServiceMsg = paramToServiceMsg.bytes_act_id.get().toStringUtf8();
        if (!paramToServiceMsg.uint32_rain_time.has()) {
          break label528;
        }
        i = paramToServiceMsg.uint32_rain_time.get();
        if (!paramToServiceMsg.uint32_pack_limit.has()) {
          break label535;
        }
        j = paramToServiceMsg.uint32_pack_limit.get();
        if (!paramToServiceMsg.uint32_delay_open_time.has()) {
          break label541;
        }
        k = paramToServiceMsg.uint32_delay_open_time.get();
        if (!paramToServiceMsg.uint32_is_boom.has()) {
          break label547;
        }
        m = paramToServiceMsg.uint32_is_boom.get();
        if (!paramToServiceMsg.uint64_boom_time.has()) {
          break label553;
        }
        l1 = paramToServiceMsg.uint64_boom_time.get() * 1000L;
        if (!paramToServiceMsg.uint32_boom_remain_time.has()) {
          break label559;
        }
        l2 = paramToServiceMsg.uint32_boom_remain_time.get() * 1000;
        label301:
        if (!paramToServiceMsg.bytes_failed_notice.has()) {
          break label565;
        }
        paramToServiceMsg = paramToServiceMsg.bytes_failed_notice.get().toStringUtf8();
        label322:
        if (QLog.isColorLevel()) {
          QLog.d("BinHaiHandler", 2, "handleJoinActivity, id=" + paramFromServiceMsg + ", time=" + i + ", limit=" + j + ", tips=" + paramToServiceMsg + ", openDelay=" + k + ", isBoom=" + m + ", boomTime=" + l1 + ", boomDuration=" + l2);
        }
        a(2, true, new Object[] { Integer.valueOf(0), paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
        if (n != 0) {
          break label716;
        }
      }
      label528:
      label535:
      label541:
      label547:
      label553:
      label559:
      label565:
      label571:
      label711:
      label716:
      for (boolean bool = true;; bool = false)
      {
        a("binhai_join", bool, n, true);
        return;
        break;
        i = 30;
        break label197;
        j = 1;
        break label216;
        k = 0;
        break label235;
        m = 0;
        break label254;
        l1 = 1L;
        break label277;
        l2 = 1L;
        break label301;
        paramToServiceMsg = "";
        break label322;
        paramToServiceMsg = null;
        if (localRspBody.msg_join_activity_rsp.has())
        {
          if (((oidb_0x98b.JoinActivityRsp)localRspBody.msg_join_activity_rsp.get()).bytes_failed_notice.has()) {
            paramToServiceMsg = ((oidb_0x98b.JoinActivityRsp)localRspBody.msg_join_activity_rsp.get()).bytes_failed_notice.get().toStringUtf8();
          }
        }
        else
        {
          label625:
          QLog.d("BinHaiHandler", 1, "handleJoinActivity, str=" + paramToServiceMsg + ", err=" + n);
          if (!TextUtils.isEmpty(paramToServiceMsg)) {
            break label711;
          }
        }
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (TextUtils.isEmpty(paramFromServiceMsg)) {
            paramToServiceMsg = "网络请求超时，\n请稍后再试";
          }
          a(2, false, new Object[] { Integer.valueOf(n), paramToServiceMsg });
          break;
          paramToServiceMsg = null;
          break label625;
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
    }
    a(2, false, new Object[] { Integer.valueOf(-1), "网络请求超时，\n请稍后再试" });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "handleReportClick, req=" + paramToServiceMsg + ", resp=" + paramFromServiceMsg + ", data=" + paramObject + ", code=" + paramFromServiceMsg.getBusinessFailCode() + ", errMsg=" + paramFromServiceMsg.getBusinessFailMsg());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new oidb_0x98b.RspBody();
      int j = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("BinHaiHandler", 2, "handleReportClick, result=" + j);
      }
      paramToServiceMsg = (oidb_0x98b.ClickPackageRsp)paramToServiceMsg.msg_click_package_rsp.get();
      int i;
      if (j == 0)
      {
        int k = paramToServiceMsg.uint32_is_boom.get();
        if (paramToServiceMsg.uint32_interval.has())
        {
          i = paramToServiceMsg.uint32_interval.get();
          long l = 1000L * i;
          i = paramToServiceMsg.uint32_boom_rate.get();
          if (!paramToServiceMsg.bytes_failed_notice.has()) {
            break label347;
          }
          paramToServiceMsg = paramToServiceMsg.bytes_failed_notice.get().toStringUtf8();
          label215:
          if (QLog.isColorLevel()) {
            QLog.d("BinHaiHandler", 2, "handleReportClick, isBoom=" + k + ", rate=" + i + ", interval=" + l + ", tips=" + paramToServiceMsg);
          }
          a(3, true, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(i) });
          if (j != 0) {
            break label459;
          }
        }
      }
      label459:
      for (boolean bool = true;; bool = false)
      {
        a("binhai_click", bool, j, false);
        return;
        i = 1;
        break;
        label347:
        paramToServiceMsg = "";
        break label215;
        if (paramToServiceMsg.bytes_failed_notice.has()) {}
        for (paramToServiceMsg = paramToServiceMsg.bytes_failed_notice.get().toStringUtf8();; paramToServiceMsg = "")
        {
          QLog.d("BinHaiHandler", 1, "handleReportClick, tips=" + paramToServiceMsg + ", err=" + j);
          a(3, false, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) });
          break;
        }
      }
    }
    a(3, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("id");
    int i = ((Integer)paramToServiceMsg.getAttribute("redpack_count")).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "handleOpenRedPack, req=" + paramToServiceMsg + ", resp=" + paramFromServiceMsg + ", data=" + paramObject + ", code=" + paramFromServiceMsg.getBusinessFailCode() + ", activityId=" + str);
    }
    int j;
    boolean bool;
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new oidb_0x98b.RspBody();
      j = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      paramFromServiceMsg = paramFromServiceMsg.extraData.getString("str_error_msg");
      if (TextUtils.isEmpty(paramFromServiceMsg))
      {
        paramFromServiceMsg = "";
        paramObject = (oidb_0x98b.OpenPackageRsp)paramToServiceMsg.msg_open_package_rsp.get();
        paramToServiceMsg = "";
        if (paramObject.bytes_failed_notice.has()) {
          paramToServiceMsg = paramObject.bytes_failed_notice.get().toStringUtf8();
        }
        if (QLog.isColorLevel()) {
          QLog.d("BinHaiHandler", 2, "handleOpenRedPack, result=" + j + ", errMsg=" + paramFromServiceMsg + ", tips=" + paramToServiceMsg);
        }
        if (paramObject.uint32_can_retry.get() != 1) {
          break label327;
        }
      }
      label312:
      label327:
      for (bool = true;; bool = false)
      {
        if (j != 0) {
          break label333;
        }
        a(4, true, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), paramToServiceMsg, paramObject.rpt_pack_list.get() });
        if (j != 0) {
          break label425;
        }
        bool = true;
        a("binhai_open_redpack", bool, j, true);
        return;
        break;
      }
      label333:
      if (j != 154) {
        break label512;
      }
      paramToServiceMsg = "网络请求超时，\n请稍后再试";
      bool = true;
    }
    label512:
    for (;;)
    {
      a(4, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), paramToServiceMsg, null });
      QLog.d("BinHaiHandler", 1, "handleOpenRedPack, err=" + j);
      break;
      label425:
      bool = false;
      break label312;
      if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) {}
      for (bool = true;; bool = false)
      {
        a(4, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramFromServiceMsg.getResultCode()), "网络请求超时，\n请稍后再试", null });
        return;
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = (String)paramToServiceMsg.getAttribute("actId");
    String str2 = (String)paramToServiceMsg.getAttribute("redBagId");
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "handleReportRedBag, req=" + paramToServiceMsg + ", resp=" + paramFromServiceMsg + ", data=" + paramObject + ", code=" + paramFromServiceMsg.getBusinessFailCode() + ", activityId=" + str1 + ", redBagId=" + str2);
    }
    if (paramFromServiceMsg.isSuccess())
    {
      oidb_0x98b.RspBody localRspBody = new oidb_0x98b.RspBody();
      int i = a(paramFromServiceMsg, paramObject, localRspBody);
      paramToServiceMsg = paramFromServiceMsg.extraData.getString("str_error_msg");
      if (TextUtils.isEmpty(paramToServiceMsg))
      {
        paramToServiceMsg = "";
        if (!((oidb_0x98b.ReportPackageRsp)localRspBody.msg_report_package_rsp.get()).bytes_failed_notice.has()) {
          break label343;
        }
        paramFromServiceMsg = ((oidb_0x98b.ReportPackageRsp)localRspBody.msg_report_package_rsp.get()).bytes_failed_notice.get().toStringUtf8();
        label196:
        if (QLog.isColorLevel()) {
          QLog.d("BinHaiHandler", 2, "handleReportRedBag, result=" + i + ", errMsg=" + paramToServiceMsg + ", tips=" + paramFromServiceMsg);
        }
        if (i != 0) {
          break label349;
        }
        bool = true;
        label255:
        a(5, bool, new Object[] { str1, Integer.valueOf(i), paramFromServiceMsg, str2 });
        if (i != 0) {
          break label355;
        }
      }
      label343:
      label349:
      label355:
      for (boolean bool = true;; bool = false)
      {
        a("binhai_report_redpack", bool, i, true);
        if (i != 0) {
          QLog.d("BinHaiHandler", 1, "handleReportRedBag, err=" + i);
        }
        return;
        break;
        paramFromServiceMsg = "";
        break label196;
        bool = false;
        break label255;
      }
    }
    a(5, false, new Object[] { str1, Integer.valueOf(-1), "网络请求超时，\n请稍后再试", null });
  }
  
  protected Class a()
  {
    return BinHaiObserver.class;
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "reqJoinActivity, picId=" + paramString);
    }
    jdField_a_of_type_TencentImOidbCmd0x98bOidb_0x98b$LBSInfo = null;
    SosoInterface.a(new abks(this, 3, true, true, 1000L, true, false, "binhai", paramString));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    while (!"OidbSvc.0x98b".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    int i = ((Integer)paramToServiceMsg.getAttribute("action", Integer.valueOf(0))).intValue();
    switch (i)
    {
    default: 
      QLog.d("BinHaiHandler", 1, "onReceive switch default, action=" + i);
      return;
    case 2: 
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 3: 
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 4: 
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 5: 
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "reqReportClick, id=" + paramString + ", count=" + paramInt);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt < 0)) {
      return;
    }
    oidb_0x98b.ClickPackageReq localClickPackageReq = new oidb_0x98b.ClickPackageReq();
    localClickPackageReq.bytes_act_id.set(ByteStringMicro.copyFromUtf8(paramString));
    localClickPackageReq.uint32_click_count.set(paramInt);
    paramString = new oidb_0x98b.ReqBody();
    paramString.msg_click_package_req.set(localClickPackageReq);
    paramString = a("OidbSvc.0x98b", 2443, 3, paramString.toByteArray());
    paramString.addAttribute("action", Integer.valueOf(3));
    paramString.setTimeout(15000L);
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "reqReportRedPack, id=" + paramString1 + ", redBagId=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = new oidb_0x98b.ReportPackageReq();
    ((oidb_0x98b.ReportPackageReq)localObject).bytes_act_id.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((oidb_0x98b.ReportPackageReq)localObject).bytes_pack_id.set(ByteStringMicro.copyFromUtf8(paramString2));
    oidb_0x98b.ReqBody localReqBody = new oidb_0x98b.ReqBody();
    localReqBody.msg_report_package_req.set((MessageMicro)localObject);
    localObject = a("OidbSvc.0x98b", 2443, 5, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).addAttribute("action", Integer.valueOf(5));
    ((ToServiceMsg)localObject).addAttribute("actId", paramString1);
    ((ToServiceMsg)localObject).addAttribute("redBagId", paramString2);
    b((ToServiceMsg)localObject);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "reqOpenRedPack, activityId=" + paramString + ", count=" + paramInt);
    }
    Object localObject = new oidb_0x98b.OpenPackageReq();
    ((oidb_0x98b.OpenPackageReq)localObject).bytes_act_id.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_0x98b.OpenPackageReq)localObject).uint32_grab_pack_count.set(paramInt);
    oidb_0x98b.ReqBody localReqBody = new oidb_0x98b.ReqBody();
    localReqBody.msg_lbs_info.set(jdField_a_of_type_TencentImOidbCmd0x98bOidb_0x98b$LBSInfo);
    localReqBody.msg_open_package_req.set((MessageMicro)localObject);
    localObject = a("OidbSvc.0x98b", 2443, 4, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).addAttribute("action", Integer.valueOf(4));
    ((ToServiceMsg)localObject).addAttribute("id", paramString);
    ((ToServiceMsg)localObject).addAttribute("redpack_count", Integer.valueOf(paramInt));
    b((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.binhai.BinHaiHandler
 * JD-Core Version:    0.7.0.1
 */