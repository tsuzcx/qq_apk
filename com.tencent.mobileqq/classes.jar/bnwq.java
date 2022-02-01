import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPosItem;
import cooperation.vip.pb.TianShuAccess.CommInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsReq;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuReport.UserActionMultiReportReq;
import cooperation.vip.pb.TianShuReport.UserActionMultiReportRsp;
import cooperation.vip.pb.TianShuReport.UserCommReport;
import cooperation.vip.tianshu.TianShuManager.1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class bnwq
{
  private static bnwq jdField_a_of_type_Bnwq;
  private long jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).getLong("time_delay", 3000L);
  private final ArrayList<bnwr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, WeakReference<bnwp>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static bnwq a()
  {
    if (jdField_a_of_type_Bnwq == null) {}
    try
    {
      if (jdField_a_of_type_Bnwq == null) {
        jdField_a_of_type_Bnwq = new bnwq();
      }
      return jdField_a_of_type_Bnwq;
    }
    finally {}
  }
  
  private static TianShuAccess.AdPosItem a(bnwo parambnwo)
  {
    TianShuAccess.AdPosItem localAdPosItem = new TianShuAccess.AdPosItem();
    localAdPosItem.posId.set(parambnwo.jdField_a_of_type_Int);
    localAdPosItem.nNeedCnt.set(parambnwo.b);
    if (parambnwo.jdField_a_of_type_JavaUtilHashMap != null)
    {
      parambnwo = parambnwo.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (parambnwo.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)parambnwo.next();
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
    localCommInfo.strDeviceInfo.set(String.valueOf(bnwt.b()));
    localCommInfo.strVersion.set(AppSetting.f());
    String str = apch.b();
    localCommInfo.strCityCode.set(String.valueOf(str));
    localCommInfo.strQimei.set(String.valueOf(bnwt.a()));
    localCommInfo.strQua.set(String.valueOf(bmsw.a()));
    return localCommInfo;
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
  
  private void a(ArrayList<bnwr> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    TianShuReport.UserActionMultiReportReq localUserActionMultiReportReq = new TianShuReport.UserActionMultiReportReq();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), bnws.class);
    localUserActionMultiReportReq.user_comm_report.set(bnwt.a());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bnwr localbnwr = (bnwr)paramArrayList.next();
      localUserActionMultiReportReq.report_infos.add(bnwt.a(localbnwr));
    }
    localNewIntent.putExtra("data", bhuf.a(localUserActionMultiReportReq.toByteArray()));
    localNewIntent.putExtra("cmd", "TianShu.UserActionMultiReport");
    localAppRuntime.startServlet(localNewIntent);
  }
  
  private void b(bnwr parambnwr)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambnwr);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        ThreadManager.getSubThreadHandler().postDelayed(new TianShuManager.1(this), this.jdField_a_of_type_Long);
      }
      return;
    }
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("TianShuManager", 1, "getADFromTianShuCache mTianshuTraceInfoCache is null");
      return "";
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = null;
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i];
      bhvd.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
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
  
  public void a(bnwr parambnwr)
  {
    if (parambnwr == null) {
      return;
    }
    b(parambnwr);
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {}
    String str;
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
      {
        QLog.e("TianShuManager", 1, "cacheTraceInfo mTianshuTraceInfoCache is null");
        return;
      }
      str = String.valueOf(paramAdItem.iAdId.get());
      paramAdItem = paramAdItem.traceinfo.get();
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramAdItem)));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramAdItem);
    QLog.i("TianShuManager", 1, "cacheTraceInfo mTianshuTraceInfoCache done:" + str + "---" + paramAdItem);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = apeg.a(paramString);
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
    QLog.i("TianShuManager", 1, "cacheTraceInfo mTianshuTraceInfoCache done:" + str + "---" + paramString);
  }
  
  public void a(List<bnwo> paramList, bnwp parambnwp)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (parambnwp == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), new WeakReference(parambnwp));
    parambnwp = BaseApplicationImpl.getApplication().getRuntime();
    TianShuAccess.GetAdsReq localGetAdsReq = new TianShuAccess.GetAdsReq();
    localGetAdsReq.stComminfo.set(a());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bnwo localbnwo = (bnwo)paramList.next();
      localGetAdsReq.lstPos.add(a(localbnwo));
    }
    paramList = new NewIntent(parambnwp.getApplication(), bnws.class);
    paramList.putExtra("data", bhuf.a(localGetAdsReq.toByteArray()));
    paramList.putExtra("cmd", "TianShu.GetAds");
    paramList.putExtra("requestKey", l);
    parambnwp.startServlet(paramList);
  }
  
  void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = null;
    if (paramIntent != null)
    {
      long l = paramIntent.getLongExtra("requestKey", -1L);
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l)) != null)
      {
        paramIntent = (bnwp)((WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l))).get();
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
        bhvd.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
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
 * Qualified Name:     bnwq
 * JD-Core Version:    0.7.0.1
 */