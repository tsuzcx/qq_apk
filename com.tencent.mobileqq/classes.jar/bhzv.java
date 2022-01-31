import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
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

public class bhzv
{
  private static bhzv jdField_a_of_type_Bhzv;
  private static String jdField_a_of_type_JavaLangString = "";
  private long jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).getLong("time_delay", 3000L);
  private final ArrayList<bhzw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, WeakReference<bhzu>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static bhzv a()
  {
    if (jdField_a_of_type_Bhzv == null) {}
    try
    {
      if (jdField_a_of_type_Bhzv == null) {
        jdField_a_of_type_Bhzv = new bhzv();
      }
      return jdField_a_of_type_Bhzv;
    }
    finally {}
  }
  
  private static TianShuAccess.AdPosItem a(bhzt parambhzt)
  {
    TianShuAccess.AdPosItem localAdPosItem = new TianShuAccess.AdPosItem();
    localAdPosItem.posId.set(parambhzt.jdField_a_of_type_Int);
    localAdPosItem.nNeedCnt.set(parambhzt.jdField_b_of_type_Int);
    if (parambhzt.jdField_a_of_type_JavaUtilHashMap != null)
    {
      parambhzt = parambhzt.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (parambhzt.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)parambhzt.next();
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
    String str = akug.b();
    localCommInfo.strCityCode.set(String.valueOf(str));
    return localCommInfo;
  }
  
  private static TianShuReport.UserActionReport a(bhzw parambhzw)
  {
    TianShuReport.UserActionReport localUserActionReport = new TianShuReport.UserActionReport();
    localUserActionReport.to_uid.set(String.valueOf(parambhzw.jdField_a_of_type_JavaLangString));
    localUserActionReport.trace_id.set(String.valueOf(parambhzw.jdField_b_of_type_JavaLangString));
    localUserActionReport.trace_num.set(parambhzw.jdField_a_of_type_Int);
    localUserActionReport.trace_detail.set(String.valueOf(parambhzw.jdField_c_of_type_JavaLangString));
    localUserActionReport.trace_index.set(String.valueOf(parambhzw.jdField_d_of_type_JavaLangString));
    localUserActionReport.appid.set(String.valueOf(parambhzw.jdField_e_of_type_JavaLangString));
    localUserActionReport.page_id.set(String.valueOf(parambhzw.jdField_f_of_type_JavaLangString));
    localUserActionReport.item_id.set(String.valueOf(parambhzw.g));
    localUserActionReport.sub_item_id.set(String.valueOf(parambhzw.h));
    localUserActionReport.module_id.set(String.valueOf(parambhzw.i));
    localUserActionReport.sub_module_id.set(String.valueOf(parambhzw.j));
    localUserActionReport.position_id.set(String.valueOf(parambhzw.k));
    localUserActionReport.test_id.set(parambhzw.jdField_b_of_type_Int);
    localUserActionReport.rule_id.set(parambhzw.jdField_c_of_type_Int);
    localUserActionReport.oper_time.set(parambhzw.jdField_a_of_type_Long);
    localUserActionReport.action_id.set(parambhzw.jdField_d_of_type_Int);
    localUserActionReport.action_value.set(parambhzw.jdField_e_of_type_Int);
    localUserActionReport.action_attr.set(parambhzw.jdField_f_of_type_Int);
    localUserActionReport.trigger_info.set(String.valueOf(parambhzw.l));
    localUserActionReport.busi_info.set(String.valueOf(parambhzw.m));
    localUserActionReport.item_type.set(String.valueOf(parambhzw.n));
    return localUserActionReport;
  }
  
  private static TianShuReport.UserCommReport a()
  {
    TianShuReport.UserCommReport localUserCommReport = new TianShuReport.UserCommReport();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localUserCommReport.uid.set(str);
    localUserCommReport.guid.set(String.valueOf(a()));
    str = akug.b();
    localUserCommReport.city_code.set(String.valueOf(str));
    localUserCommReport.platform.set("AND");
    localUserCommReport.client_type.set("SQ");
    localUserCommReport.app_version.set(AppSetting.f());
    localUserCommReport.qua.set(String.valueOf(bgxr.a()));
    localUserCommReport.network_type.set(b());
    localUserCommReport.mobile_type.set(String.valueOf(Build.MODEL));
    localUserCommReport.os_version.set(String.valueOf(bbct.e()));
    return localUserCommReport;
  }
  
  public static String a()
  {
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_JavaLangString.length() > 0)) {
      return jdField_a_of_type_JavaLangString;
    }
    try
    {
      jdField_a_of_type_JavaLangString = bfmw.a("07aa5e");
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
  
  private void a(ArrayList<bhzw> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    TianShuReport.UserActionMultiReportReq localUserActionMultiReportReq = new TianShuReport.UserActionMultiReportReq();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), bhzx.class);
    localUserActionMultiReportReq.user_comm_report.set(a());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bhzw localbhzw = (bhzw)paramArrayList.next();
      localUserActionMultiReportReq.report_infos.add(a(localbhzw));
    }
    localNewIntent.putExtra("data", bblm.a(localUserActionMultiReportReq.toByteArray()));
    localNewIntent.putExtra("cmd", "TianShu.UserActionMultiReport");
    localAppRuntime.startServlet(localNewIntent);
  }
  
  private static String b()
  {
    switch (bbev.b(BaseApplicationImpl.getContext()))
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
  
  private void b(bhzw parambhzw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambhzw);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        ThreadManager.getSubThreadHandler().postDelayed(new TianShuManager.1(this), this.jdField_a_of_type_Long);
      }
      return;
    }
  }
  
  void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = null;
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i];
      bbmj.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
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
  
  public void a(bhzw parambhzw)
  {
    if (parambhzw == null) {
      return;
    }
    b(parambhzw);
  }
  
  public void a(List<bhzt> paramList, bhzu parambhzu)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (parambhzu == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), new WeakReference(parambhzu));
    parambhzu = BaseApplicationImpl.getApplication().getRuntime();
    TianShuAccess.GetAdsReq localGetAdsReq = new TianShuAccess.GetAdsReq();
    localGetAdsReq.stComminfo.set(a());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bhzt localbhzt = (bhzt)paramList.next();
      localGetAdsReq.lstPos.add(a(localbhzt));
    }
    paramList = new NewIntent(parambhzu.getApplication(), bhzx.class);
    paramList.putExtra("data", bblm.a(localGetAdsReq.toByteArray()));
    paramList.putExtra("cmd", "TianShu.GetAds");
    paramList.putExtra("requestKey", l);
    parambhzu.startServlet(paramList);
  }
  
  void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = null;
    if (paramIntent != null)
    {
      long l = paramIntent.getLongExtra("requestKey", -1L);
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l)) != null)
      {
        paramIntent = (bhzu)((WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l))).get();
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
        bbmj.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhzv
 * JD-Core Version:    0.7.0.1
 */