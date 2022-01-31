import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdPosItem;
import cooperation.vip.pb.TianShuAccess.CommInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsReq;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuReport.UserActionMultiReportReq;
import cooperation.vip.pb.TianShuReport.UserActionMultiReportRsp;
import cooperation.vip.pb.TianShuReport.UserActionReport;
import cooperation.vip.pb.TianShuReport.UserCommReport;
import cooperation.vip.tianshu.TianShuManager.1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class bkci
{
  private static bkci jdField_a_of_type_Bkci;
  private static String jdField_a_of_type_JavaLangString = "";
  private static String b;
  private long jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).getLong("time_delay", 3000L);
  private final ArrayList<bkcj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, WeakReference<bkch>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  public static bkci a()
  {
    if (jdField_a_of_type_Bkci == null) {}
    try
    {
      if (jdField_a_of_type_Bkci == null) {
        jdField_a_of_type_Bkci = new bkci();
      }
      return jdField_a_of_type_Bkci;
    }
    finally {}
  }
  
  private static TianShuAccess.AdPosItem a(bkcg parambkcg)
  {
    TianShuAccess.AdPosItem localAdPosItem = new TianShuAccess.AdPosItem();
    localAdPosItem.posId.set(parambkcg.jdField_a_of_type_Int);
    localAdPosItem.nNeedCnt.set(parambkcg.jdField_b_of_type_Int);
    if (parambkcg.jdField_a_of_type_JavaUtilHashMap != null)
    {
      parambkcg = parambkcg.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (parambkcg.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)parambkcg.next();
        TianShuAccess.MapEntry localMapEntry = new TianShuAccess.MapEntry();
        localMapEntry.key.set(String.valueOf(localEntry.getKey()));
        localMapEntry.value.set(String.valueOf(localEntry.getValue()));
        localAdPosItem.extra_info.add(localMapEntry);
      }
    }
    return localAdPosItem;
  }
  
  private static TianShuAccess.CommInfo a()
  {
    TianShuAccess.CommInfo localCommInfo = new TianShuAccess.CommInfo();
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localCommInfo.lUin.set(l);
    localCommInfo.strApp.set("sq");
    localCommInfo.strOs.set("and");
    localCommInfo.strDeviceInfo.set(String.valueOf(a()));
    localCommInfo.strVersion.set(AppSetting.f());
    String str = amkv.b();
    localCommInfo.strCityCode.set(String.valueOf(str));
    localCommInfo.strQimei.set(String.valueOf(b()));
    localCommInfo.strQua.set(String.valueOf(bizf.a()));
    return localCommInfo;
  }
  
  private static TianShuReport.UserActionReport a(bkcj parambkcj)
  {
    TianShuReport.UserActionReport localUserActionReport = new TianShuReport.UserActionReport();
    localUserActionReport.to_uid.set(String.valueOf(parambkcj.jdField_a_of_type_JavaLangString));
    localUserActionReport.trace_id.set(String.valueOf(parambkcj.jdField_b_of_type_JavaLangString));
    localUserActionReport.trace_num.set(parambkcj.jdField_a_of_type_Int);
    localUserActionReport.trace_detail.set(String.valueOf(parambkcj.jdField_c_of_type_JavaLangString));
    localUserActionReport.trace_index.set(String.valueOf(parambkcj.jdField_d_of_type_JavaLangString));
    localUserActionReport.appid.set(String.valueOf(parambkcj.jdField_e_of_type_JavaLangString));
    localUserActionReport.page_id.set(String.valueOf(parambkcj.jdField_f_of_type_JavaLangString));
    localUserActionReport.item_id.set(String.valueOf(parambkcj.g));
    localUserActionReport.sub_item_id.set(String.valueOf(parambkcj.h));
    localUserActionReport.module_id.set(String.valueOf(parambkcj.i));
    localUserActionReport.sub_module_id.set(String.valueOf(parambkcj.j));
    localUserActionReport.position_id.set(String.valueOf(parambkcj.k));
    localUserActionReport.test_id.set(parambkcj.jdField_b_of_type_Int);
    localUserActionReport.rule_id.set(parambkcj.jdField_c_of_type_Int);
    localUserActionReport.oper_time.set(parambkcj.jdField_a_of_type_Long);
    localUserActionReport.action_id.set(parambkcj.jdField_d_of_type_Int);
    localUserActionReport.action_value.set(parambkcj.jdField_e_of_type_Int);
    localUserActionReport.action_attr.set(parambkcj.jdField_f_of_type_Int);
    localUserActionReport.trigger_info.set(String.valueOf(parambkcj.l));
    localUserActionReport.busi_info.set(String.valueOf(parambkcj.m));
    localUserActionReport.item_type.set(String.valueOf(parambkcj.n));
    return localUserActionReport;
  }
  
  private static TianShuReport.UserCommReport a()
  {
    TianShuReport.UserCommReport localUserCommReport = new TianShuReport.UserCommReport();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localUserCommReport.uid.set(str);
    localUserCommReport.guid.set(String.valueOf(a()));
    str = amkv.b();
    localUserCommReport.city_code.set(String.valueOf(str));
    localUserCommReport.platform.set("AND");
    localUserCommReport.client_type.set("SQ");
    localUserCommReport.app_version.set(AppSetting.f());
    localUserCommReport.qua.set(String.valueOf(bizf.a()));
    localUserCommReport.network_type.set(c());
    localUserCommReport.mobile_type.set(String.valueOf(Build.MODEL));
    localUserCommReport.os_version.set(String.valueOf(bdcb.e()));
    localUserCommReport.qimei.set(String.valueOf(b()));
    return localUserCommReport;
  }
  
  public static String a()
  {
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_JavaLangString.length() > 0)) {
      return jdField_a_of_type_JavaLangString;
    }
    try
    {
      jdField_a_of_type_JavaLangString = bhoi.a("07aa5e");
      label28:
      return jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_Long = (paramInt * 1000);
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).edit();
      localEditor.putLong("time_delay", this.jdField_a_of_type_Long);
      localEditor.apply();
    }
  }
  
  private void a(ArrayList<bkcj> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    TianShuReport.UserActionMultiReportReq localUserActionMultiReportReq = new TianShuReport.UserActionMultiReportReq();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), bkck.class);
    localUserActionMultiReportReq.user_comm_report.set(a());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bkcj localbkcj = (bkcj)paramArrayList.next();
      localUserActionMultiReportReq.report_infos.add(a(localbkcj));
    }
    localNewIntent.putExtra("data", bdku.a(localUserActionMultiReportReq.toByteArray()));
    localNewIntent.putExtra("cmd", "TianShu.UserActionMultiReport");
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public static String b()
  {
    if ((jdField_b_of_type_JavaLangString != null) && (jdField_b_of_type_JavaLangString.length() > 0)) {
      return jdField_b_of_type_JavaLangString;
    }
    try
    {
      jdField_b_of_type_JavaLangString = UserAction.getQIMEI();
      label25:
      return jdField_b_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  private void b(bkcj parambkcj)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambkcj);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        ThreadManager.getSubThreadHandler().postDelayed(new TianShuManager.1(this), this.jdField_a_of_type_Long);
      }
      return;
    }
  }
  
  private static String c()
  {
    switch (bdee.b(BaseApplicationImpl.getContext()))
    {
    default: 
      return "UNKNOW";
    case 1: 
      return "WIFI";
    case 4: 
      return "4G";
    case 3: 
      return "3G";
    }
    return "2G";
  }
  
  void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = null;
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i];
      bdlr.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    TianShuReport.UserActionMultiReportRsp localUserActionMultiReportRsp = new TianShuReport.UserActionMultiReportRsp();
    int i = paramFromServiceMsg.getResultCode();
    if (i == 1000) {
      try
      {
        localUserActionMultiReportRsp.mergeFrom(paramIntent);
        i = localUserActionMultiReportRsp.err_code.get();
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TianShuManager", 2, "onReceive ret " + i);
          }
          a(localUserActionMultiReportRsp.multi_duration.get());
          return;
        }
        QLog.d("TianShuManager", 2, "onReceive ret " + i);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("TianShuManager", 2, "onReceive exception " + paramIntent);
        return;
      }
    }
    QLog.e("TianShuManager", 2, "onReceive result fail with result " + i);
  }
  
  public void a(bkcj parambkcj)
  {
    if (parambkcj == null) {
      return;
    }
    b(parambkcj);
  }
  
  public void a(List<bkcg> paramList, bkch parambkch)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (parambkch == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), new WeakReference(parambkch));
    parambkch = BaseApplicationImpl.getApplication().getRuntime();
    TianShuAccess.GetAdsReq localGetAdsReq = new TianShuAccess.GetAdsReq();
    localGetAdsReq.stComminfo.set(a());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bkcg localbkcg = (bkcg)paramList.next();
      localGetAdsReq.lstPos.add(a(localbkcg));
    }
    paramList = new NewIntent(parambkch.getApplication(), bkck.class);
    paramList.putExtra("data", bdku.a(localGetAdsReq.toByteArray()));
    paramList.putExtra("cmd", "TianShu.GetAds");
    paramList.putExtra("requestKey", l);
    parambkch.startServlet(paramList);
  }
  
  void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = null;
    if (paramIntent != null)
    {
      long l = paramIntent.getLongExtra("requestKey", -1L);
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l)) != null)
      {
        paramIntent = (bkch)((WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l))).get();
        if (paramIntent != null) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l));
        }
      }
    }
    for (;;)
    {
      if (paramFromServiceMsg.isSuccess())
      {
        i = paramFromServiceMsg.getWupBuffer().length - 4;
        arrayOfByte = new byte[i];
        bdlr.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      }
      TianShuAccess.GetAdsRsp localGetAdsRsp = new TianShuAccess.GetAdsRsp();
      int i = paramFromServiceMsg.getResultCode();
      if (i == 1000)
      {
        try
        {
          localGetAdsRsp.mergeFrom(arrayOfByte);
          i = localGetAdsRsp.code.get();
          if (i != 0) {
            break label247;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TianShuManager", 2, "onReceive success " + i);
          }
          if (paramIntent != null)
          {
            paramIntent.onGetAdvs(true, localGetAdsRsp);
            return;
          }
          QLog.e("TianShuManager", 1, "callback == null");
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.e("TianShuManager", 2, "onReceive exception " + paramFromServiceMsg);
          if (paramIntent == null) {
            return;
          }
        }
        paramIntent.onGetAdvs(false, localGetAdsRsp);
        return;
        label247:
        QLog.d("TianShuManager", 2, "onReceive ret " + i);
        if (paramIntent == null) {
          return;
        }
        paramIntent.onGetAdvs(false, localGetAdsRsp);
        return;
      }
      QLog.e("TianShuManager", 2, "onReceive result fail with result " + i);
      if (paramIntent == null) {
        return;
      }
      paramIntent.onGetAdvs(false, localGetAdsRsp);
      return;
      paramIntent = null;
      break;
      paramIntent = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkci
 * JD-Core Version:    0.7.0.1
 */