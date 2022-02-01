import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsDetailInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsSubnation;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class antv
  extends anii
  implements anij
{
  public static final HashSet<String> a;
  public int a;
  private aoou a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public antv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 600000;
    this.jdField_a_of_type_Aoou = new antw(this, "vas_red_point", false);
  }
  
  private BusinessInfoCheckUpdate.LbsInfo a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    BusinessInfoCheckUpdate.LbsInfo localLbsInfo = new BusinessInfoCheckUpdate.LbsInfo();
    BusinessInfoCheckUpdate.LbsDetailInfo localLbsDetailInfo = new BusinessInfoCheckUpdate.LbsDetailInfo();
    BusinessInfoCheckUpdate.LbsSubnation localLbsSubnation = new BusinessInfoCheckUpdate.LbsSubnation();
    if (TextUtils.isEmpty(paramSosoLocation.f)) {}
    for (paramSosoLocation = "";; paramSosoLocation = paramSosoLocation.f)
    {
      localLbsSubnation.code.set(paramSosoLocation);
      localLbsSubnation.nation.set("unknown");
      localLbsSubnation.province.set("unknown");
      localLbsSubnation.city.set("unknown");
      localLbsSubnation.district.set("unknown");
      localLbsDetailInfo.subnation.set(localLbsSubnation);
      localLbsInfo.detail_info.set(localLbsDetailInfo);
      return localLbsInfo;
    }
  }
  
  public static List<antx> a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramAppRuntime = LebaPluginInfo.getAll(((QQAppInterface)paramAppRuntime).a().createEntityManager());
    } while (paramAppRuntime == null);
    int i = 0;
    while (i < paramAppRuntime.size())
    {
      antx localantx = new antx();
      localantx.jdField_a_of_type_Long = ((LebaPluginInfo)paramAppRuntime.get(i)).uiResId;
      localantx.jdField_a_of_type_Int = ((int)((LebaPluginInfo)paramAppRuntime.get(i)).uiResId);
      localArrayList.add(localantx);
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new RedpointHandler.2(this, paramInt, paramSosoLbsInfo), 5, null, true);
      return;
    }
    b(paramInt, paramSosoLbsInfo);
  }
  
  private void a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilHashSet == null) {}
    do
    {
      return;
      if (paramLong == 1113L)
      {
        jdField_a_of_type_JavaUtilHashSet.add("1113.100800");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100801");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100802");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100803");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100804");
        return;
      }
    } while (paramLong != 100001113L);
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100800");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100801");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100802");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100803");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100804");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (bccg)paramQQAppInterface.getManager(12);
    if (localObject != null) {
      ((bccg)localObject).a();
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), bccj.class);
    ((NewIntent)localObject).setAction("gc_refresh_ui");
    ((NewIntent)localObject).putExtra("gc_notify_type", 6);
    paramQQAppInterface.startServlet((NewIntent)localObject);
    ((antv)paramQQAppInterface.a(87)).notifyUI(3, true, null);
  }
  
  private void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    StringBuilder localStringBuilder = new StringBuilder("Rsp Body :");
    Object localObject;
    if (paramTimeRspBody.rptMsgAppInfo.has())
    {
      localObject = paramTimeRspBody.rptMsgAppInfo.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject).next();
        if (localAppInfo != null)
        {
          localStringBuilder.append("appid = ").append(localAppInfo.uiAppId.get());
          localStringBuilder.append(" path = ").append(localAppInfo.path.get());
          localStringBuilder.append(" inewflag = ").append(localAppInfo.iNewFlag.get());
          localStringBuilder.append(" exposure_max = ").append(localAppInfo.exposure_max.get());
          localStringBuilder.append(" mission_level = ").append(localAppInfo.mission_level.get());
          localStringBuilder.append(" missions = ").append(localAppInfo.missions.get());
          localStringBuilder.append(";");
        }
      }
    }
    if (paramTimeRspBody.rptMsgNumRedInfo.has())
    {
      paramTimeRspBody = paramTimeRspBody.rptMsgNumRedInfo.get().iterator();
      while (paramTimeRspBody.hasNext())
      {
        localObject = (BusinessInfoCheckUpdate.NumRedInfo)paramTimeRspBody.next();
        if (localObject != null)
        {
          localStringBuilder.append("numred appid = ").append(((BusinessInfoCheckUpdate.NumRedInfo)localObject).appid.get());
          localStringBuilder.append(" appset = ").append(((BusinessInfoCheckUpdate.NumRedInfo)localObject).appset.get());
          localStringBuilder.append(";");
        }
      }
    }
    QLog.d("RedpointHandler", 2, localStringBuilder.toString());
  }
  
  private void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody, baif parambaif)
  {
    List localList = paramTimeRspBody.rptSetting.get();
    parambaif = parambaif.a();
    ArrayList localArrayList = new ArrayList();
    int i;
    BusinessInfoCheckUpdate.AppSetting localAppSetting;
    if ((localList != null) && (parambaif != null))
    {
      i = 0;
      if (i < localList.size())
      {
        localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localList.get(i);
        j = 0;
        label61:
        if (j >= parambaif.size()) {
          break label176;
        }
        if (((BusinessInfoCheckUpdate.AppSetting)parambaif.get(j)).appid.get() == localAppSetting.appid.get()) {
          parambaif.set(j, localAppSetting);
        }
      }
    }
    label176:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(localAppSetting);
      }
      i += 1;
      break;
      j += 1;
      break label61;
      parambaif.addAll(localArrayList);
      for (;;)
      {
        paramTimeRspBody.rptSetting.set(parambaif);
        return;
        if (parambaif == null) {
          parambaif = localList;
        }
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {
      QLog.e("RedpointHandler", 1, "handleResponse data = null");
    }
    Object localObject;
    do
    {
      return;
      try
      {
        localObject = new BusinessInfoCheckUpdate.TimeRspBody();
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
          QLog.e("RedpointHandler", 1, "mergeFrom failed");
          paramObject = null;
        }
      }
      if (paramObject == null)
      {
        QLog.e("RedpointHandler", 1, "handleResponse prb = null");
        return;
      }
      if (paramObject.iResult.get() == 0) {
        break;
      }
      QLog.d("RedpointHandler", 2, "handleResponse,return fail ,TimeRspBody result:" + paramObject.iResult.get());
    } while (paramObject.iResult.get() != 104005);
    paramObject = new BusinessInfoCheckUpdate.TimeRspBody();
    for (;;)
    {
      for (;;)
      {
        QLog.i("RedpointHandler", 1, "handleResponse");
        b(paramObject);
        this.app.a().createEntityManager();
        localObject = (baif)this.app.getManager(36);
        try
        {
          if (!a(paramObject, (baif)localObject)) {
            break;
          }
          a(paramObject, (baif)localObject);
          a(paramObject);
          ((baif)localObject).a(paramObject);
          c(paramObject);
          a(this.app);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("RedpointHandler", 2, "handleResponse", localException);
          }
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return false;
      if (paramAppInfo.appset.get() == 3) {
        return true;
      }
      Object localObject1 = a(paramQQAppInterface);
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int j = ((List)localObject1).size();
        i = 0;
        while (i < j)
        {
          long l = ((antx)((List)localObject1).get(i)).jdField_a_of_type_Long;
          localObject2 = "100600." + (100000000L + l) + "";
          if (((((antx)((List)localObject1).get(i)).jdField_a_of_type_Long + "").equals(paramAppInfo.path.get())) || (((String)localObject2).equals(paramAppInfo.path.get()))) {
            return true;
          }
          if ((jdField_a_of_type_JavaUtilHashSet != null) && (jdField_a_of_type_JavaUtilHashSet.contains(paramAppInfo.path.get()))) {
            return true;
          }
          i += 1;
        }
      }
      localObject1 = anij.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (anik)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((anik)localObject2).a(paramQQAppInterface);
          if ((localObject2 != null) && (((List)localObject2).contains(paramAppInfo.path.get()))) {
            return true;
          }
        }
      }
      int i = 0;
      while (i < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        paramQQAppInterface = paramAppInfo.path.get();
        if (jdField_a_of_type_Array2dOfJavaLangString[i][1].equals(paramQQAppInterface)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody, baif parambaif)
  {
    if (paramTimeRspBody.rptMsgAppInfo.has())
    {
      Iterator localIterator = paramTimeRspBody.rptMsgAppInfo.get().iterator();
      while (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo1 = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        if (localAppInfo1 != null)
        {
          if ((!a(this.app, localAppInfo1)) && (1 == localAppInfo1.iNewFlag.get()))
          {
            localAppInfo1.modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            localAppInfo1.iNewFlag.set(0);
            if (QLog.isColorLevel()) {
              QLog.d("RedpointHandler", 2, "verifyDataCorrect,return false ,appInfo.path.get():" + localAppInfo1.path.get());
            }
          }
          if (localAppInfo1.use_cache.get())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo2 = parambaif.a(localAppInfo1.path.get());
            if (localAppInfo2 != null) {
              localAppInfo1.buffer.set(localAppInfo2.buffer.get());
            }
          }
        }
      }
    }
    if (paramTimeRspBody.rptMsgNumRedInfo.has())
    {
      paramTimeRspBody = paramTimeRspBody.rptMsgNumRedInfo.get();
      if (paramTimeRspBody == null) {
        return false;
      }
      paramTimeRspBody = paramTimeRspBody.iterator();
      while (paramTimeRspBody.hasNext())
      {
        parambaif = ((BusinessInfoCheckUpdate.NumRedInfo)paramTimeRspBody.next()).num_red_path.get();
        if (parambaif != null)
        {
          int i = 0;
          while (i < parambaif.size())
          {
            ((BusinessInfoCheckUpdate.NumRedPath)parambaif.get(i)).uint32_push_num_red_ts.set((int)(System.currentTimeMillis() / 1000L));
            i += 1;
          }
        }
      }
    }
    return true;
  }
  
  private void b(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    int i = 0;
    QLog.d("RedpointHandler", 1, "sendReq start");
    BusinessInfoCheckUpdate.TimeReqBody localTimeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
    localTimeReqBody.iProtocolVer.set(1);
    localTimeReqBody.uiClientPlatID.set(109);
    localTimeReqBody.sClientVer.set("8.4.1.4680");
    localTimeReqBody.uiUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    int j = bgnt.a(BaseApplication.getContext());
    localTimeReqBody.uiNetType.set(j);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = a(paramSosoLbsInfo.a);
      if (paramSosoLbsInfo != null) {
        localTimeReqBody.lbs.set(paramSosoLbsInfo);
      }
    }
    Object localObject = a(this.app);
    baif localbaif = (baif)this.app.getManager(36);
    if (localbaif == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    for (paramSosoLbsInfo = null;; paramSosoLbsInfo = localbaif.a())
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      a(localTimeReqBody, (List)localObject, paramSosoLbsInfo, localArrayList1);
      localArrayList1.addAll(jdField_a_of_type_JavaUtilHashSet);
      paramSosoLbsInfo = anij.a.iterator();
      while (paramSosoLbsInfo.hasNext())
      {
        localObject = (anik)paramSosoLbsInfo.next();
        if (localObject != null) {
          try
          {
            if (((anik)localObject).a(this.app) != null) {
              localArrayList1.addAll(((anik)localObject).a(this.app));
            }
          }
          catch (Exception localException)
          {
            QLog.e("RedpointHandler", 1, "add exception error" + localException);
          }
        }
      }
    }
    paramInt = 0;
    while (paramInt < jdField_a_of_type_Array2dOfJavaLangString.length)
    {
      localArrayList1.add(jdField_a_of_type_Array2dOfJavaLangString[paramInt][1]);
      paramInt += 1;
    }
    if (localbaif != null)
    {
      paramSosoLbsInfo = localbaif.b(3).iterator();
      while (paramSosoLbsInfo.hasNext()) {
        localArrayList1.add(((BusinessInfoCheckUpdate.AppInfo)paramSosoLbsInfo.next()).path.get());
      }
      if (localbaif.a() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedpointHandler", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
        }
        localArrayList2.addAll(localArrayList1);
      }
    }
    else
    {
      localTimeReqBody.rptMsgAppInfo.set(localArrayList3);
      localTimeReqBody.rptNoRedPath.set(localArrayList2);
      localTimeReqBody.sQimei.set(String.valueOf(UserAction.getQIMEI()));
      if (!this.app.q) {
        break label632;
      }
      localTimeReqBody.bHebaFlag.set(true);
      label486:
      if ((!((gc)this.app.getManager(42)).jdField_a_of_type_Boolean) && (localTimeReqBody.rptMsgAppInfo.has())) {
        paramInt = i;
      }
    }
    for (;;)
    {
      if (paramInt < localTimeReqBody.rptMsgAppInfo.size())
      {
        if ("100005.100011".equals(((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt)).path.get())) {
          localTimeReqBody.rptMsgAppInfo.remove(paramInt);
        }
      }
      else
      {
        a(localTimeReqBody);
        QLog.d("RedpointHandler", 1, "getNewFlagOp local message ok");
        paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQClubComm.getNewFlag");
        paramSosoLbsInfo.putWupBuffer(localTimeReqBody.toByteArray());
        sendPbReq(paramSosoLbsInfo);
        return;
        a(localbaif, localArrayList1, localArrayList2, localArrayList3);
        break;
        label632:
        localTimeReqBody.bHebaFlag.set(false);
        break label486;
      }
      paramInt += 1;
    }
  }
  
  private void b(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    int i = 0;
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
    if (paramTimeRspBody.iInterval.has())
    {
      String str = "businessinfo_check_update_interval_" + this.app.getCurrentAccountUin();
      if (paramTimeRspBody.iInterval.get() > 0) {
        i = paramTimeRspBody.iInterval.get();
      }
      localEditor.putInt(str, i);
    }
    for (;;)
    {
      localEditor.putInt("businessinfo_check_update_interval_lbsinfo_" + this.app.getCurrentAccountUin(), paramTimeRspBody.iLbsInterval.get());
      QLog.d("RedpointHandler", 1, "handleResponse, iInterval = " + paramTimeRspBody.iInterval.get() + "; lbsInterval = " + paramTimeRspBody.iLbsInterval.get());
      localEditor.putInt("businessinfo_last_check_update_timestamp_" + this.app.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L));
      localEditor.apply();
      return;
      localEditor.remove("businessinfo_check_update_interval_" + this.app.getCurrentAccountUin());
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("RedpointHandler", 2, "getNewFlagOp:send redInfo start");
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("businessinfo_check_update_interval_" + this.app.getCurrentAccountUin(), 600);
    this.jdField_a_of_type_Int = (i * 1000);
    int j = localSharedPreferences.getInt("businessinfo_check_update_interval_lbsinfo_" + this.app.getCurrentAccountUin(), 43200000);
    int k = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.app.getCurrentAccountUin(), 0);
    int m = localSharedPreferences.getInt("businessinfo_last_check_lbsinfo_timestamp_" + this.app.getCurrentAccountUin(), 0);
    int n = (int)(System.currentTimeMillis() / 1000L);
    boolean bool = localSharedPreferences.getBoolean("redtouch_force", false);
    QLog.d("RedpointHandler", 1, "getNewFlagOp:sendredInfo :systemTimestamp = " + n + ";lastUpdateTimestamp = " + k + ";updateInterval = " + i + ";updateLbsInterval = " + j + ";lastCheckLbsInfo = " + m + ";isDebugVersion = " + false);
    if ((!bool) && (!paramBoolean1) && (n - k <= i) && (n >= k)) {
      return;
    }
    localEditor.putInt("businessinfo_last_check_update_timestamp_" + this.app.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L));
    localEditor.putBoolean("redtouch_force", false);
    localEditor.apply();
    if ((paramBoolean2) && ((n - m > j) || (n < k)))
    {
      localEditor.putInt("businessinfo_last_check_lbsinfo_timestamp_" + this.app.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L)).commit();
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.app.getApplication().getApplicationContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          a(-1, null);
          return;
        }
        aoor.a(this.jdField_a_of_type_Aoou);
        return;
      }
      aoor.a(this.jdField_a_of_type_Aoou);
      return;
    }
    a(-1, null);
  }
  
  private void c(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    Object localObject1 = (bgyc)this.app.getManager(177);
    if ((!((bgyc)localObject1).jdField_b_of_type_Boolean) && (!((bgyc)localObject1).jdField_a_of_type_Boolean)) {
      ((bgyc)localObject1).a(this.app.getCurrentAccountUin());
    }
    int j;
    int i;
    if (paramTimeRspBody.rptMsgAppInfo.has())
    {
      j = paramTimeRspBody.rptMsgAppInfo.size();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject2 = (BusinessInfoCheckUpdate.AppInfo)paramTimeRspBody.rptMsgAppInfo.get(i);
        if (localObject2 == null) {
          break label269;
        }
        if (String.valueOf(100005).equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get()))
        {
          if ((((bgyc)localObject1).jdField_a_of_type_Int == 0) || (TextUtils.isEmpty(((bgyc)localObject1).jdField_a_of_type_JavaLangString)) || (((bgyc)localObject1).jdField_b_of_type_Int != 0)) {
            break label269;
          }
          ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(0);
          ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
        }
      }
      else
      {
        if (!paramTimeRspBody.rptMsgNumRedInfo.has()) {
          break label346;
        }
        localObject1 = new ArrayList();
        localObject2 = paramTimeRspBody.rptMsgNumRedInfo.get();
        if (localObject2 != null) {
          break;
        }
        return;
      }
      if (((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get() == 769) {
        this.app.getApp().getSharedPreferences("check_update_sp_key", 0).edit().putInt("reader_zone_appinfo_last_pull_timestamp_" + this.app.getCurrentAccountUin(), (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)).apply();
      }
      label269:
      i += 1;
    }
    Object localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
      if (((BusinessInfoCheckUpdate.NumRedInfo)localObject3).appid.get() == 7719) {
        ((List)localObject1).add(localObject3);
      }
    }
    axdj.a().a(this.app, (List)localObject1);
    label346:
    if (QLog.isColorLevel()) {
      QLog.d("RedpointHandler", 2, "individuation jump open");
    }
    if (paramTimeRspBody.rptSetting.get() != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder("switch ");
        localObject3 = paramTimeRspBody.rptSetting.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)((Iterator)localObject3).next();
          if (localAppSetting != null)
          {
            StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("appid: ");
            if (localAppSetting.appid.has())
            {
              localObject1 = Integer.valueOf(localAppSetting.appid.get());
              label465:
              localStringBuilder = localStringBuilder.append(localObject1).append("  setting:");
              if (!localAppSetting.setting.has()) {
                break label568;
              }
              localObject1 = Boolean.valueOf(localAppSetting.setting.get());
              label504:
              localStringBuilder = localStringBuilder.append(localObject1).append(" modify_ts:");
              if (!localAppSetting.modify_ts.has()) {
                break label576;
              }
            }
            label568:
            label576:
            for (localObject1 = Long.valueOf(localAppSetting.modify_ts.get());; localObject1 = "null")
            {
              localStringBuilder.append(localObject1).append(",");
              break;
              localObject1 = "null";
              break label465;
              localObject1 = "null";
              break label504;
            }
          }
        }
        QLog.i("RedpointHandler", 2, ((StringBuilder)localObject2).toString());
      }
      ajvi.a().a(paramTimeRspBody.rptSetting.get());
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedpointHandler", 2, "update NearbyNumAppinfo");
    }
    aybu.a(this.app, true);
  }
  
  public void a(int paramInt)
  {
    QLog.d("RedpointHandler", 1, "forceSendReq fromSrc:" + paramInt);
    a(-1, null);
  }
  
  protected void a(baif parambaif, List<String> paramList1, List<String> paramList2, List<BusinessInfoCheckUpdate.AppInfo> paramList)
  {
    parambaif = parambaif.a();
    int j;
    String str;
    int i;
    label45:
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    Object localObject;
    if (parambaif.rptMsgAppInfo.has())
    {
      j = 0;
      if (j >= paramList1.size()) {
        break label370;
      }
      str = (String)paramList1.get(j);
      i = 0;
      if (i >= parambaif.rptMsgAppInfo.size()) {
        break label377;
      }
      localAppInfo = (BusinessInfoCheckUpdate.AppInfo)parambaif.rptMsgAppInfo.get(i);
      if (str.equals(localAppInfo.path.get()))
      {
        localObject = localAppInfo.missions.get();
        if ((localObject != null) && (((List)localObject).size() != 0)) {
          break label371;
        }
        i = 1;
        label115:
        if ((localAppInfo.iNewFlag.get() == 0) && (i != 0)) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramList2.add(str);
      }
      j += 1;
      break;
      localObject = new BusinessInfoCheckUpdate.AppInfo();
      ((BusinessInfoCheckUpdate.AppInfo)localObject).path.set(localAppInfo.path.get());
      ((BusinessInfoCheckUpdate.AppInfo)localObject).uiAppId.set(localAppInfo.uiAppId.get());
      ((BusinessInfoCheckUpdate.AppInfo)localObject).buffer.set(localAppInfo.buffer.get());
      ((BusinessInfoCheckUpdate.AppInfo)localObject).modify_ts.set(localAppInfo.modify_ts.get());
      ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.set(localAppInfo.iNewFlag.get());
      ((BusinessInfoCheckUpdate.AppInfo)localObject).type.set(localAppInfo.type.get());
      ((BusinessInfoCheckUpdate.AppInfo)localObject).push_red_ts.set(localAppInfo.push_red_ts.get());
      ((BusinessInfoCheckUpdate.AppInfo)localObject).mission_level.set(localAppInfo.mission_level.get());
      i = 0;
      while (i < localAppInfo.missions.size())
      {
        ((BusinessInfoCheckUpdate.AppInfo)localObject).missions.add(localAppInfo.missions.get(i));
        i += 1;
      }
      paramList.add(localObject);
      i = 0;
      continue;
      i += 1;
      break label45;
      paramList2.addAll(paramList1);
      label370:
      return;
      label371:
      i = 0;
      break label115;
      label377:
      i = 1;
    }
  }
  
  protected void a(BusinessInfoCheckUpdate.TimeReqBody paramTimeReqBody)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("req red pathlist:");
      if (paramTimeReqBody.rptMsgAppInfo.has())
      {
        int i = 0;
        while (i < paramTimeReqBody.rptMsgAppInfo.size())
        {
          String str = ((BusinessInfoCheckUpdate.AppInfo)paramTimeReqBody.rptMsgAppInfo.get(i)).path.get();
          if (!TextUtils.isEmpty(str))
          {
            localStringBuilder.append(str);
            localStringBuilder.append(";");
          }
          i += 1;
        }
      }
      QLog.d("RedpointHandler", 1, "getNewFlagOp rptMsginfoPath:" + localStringBuilder.toString());
    }
    if (QLog.isColorLevel()) {}
  }
  
  protected void a(BusinessInfoCheckUpdate.TimeReqBody paramTimeReqBody, List<antx> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1, List<String> paramList2)
  {
    BusinessInfoCheckUpdate.AppSetting localAppSetting;
    int j;
    String str;
    if (paramList != null)
    {
      localAppSetting = null;
      int i;
      int m;
      int k;
      if (paramList1 == null)
      {
        i = 0;
        j = 0;
        if (j >= paramList.size()) {
          break label302;
        }
        str = ((antx)paramList.get(j)).jdField_a_of_type_Long + "";
        m = ((antx)paramList.get(j)).jdField_a_of_type_Int;
        k = 0;
        label81:
        if (k >= i) {
          break label139;
        }
        localAppSetting = (BusinessInfoCheckUpdate.AppSetting)paramList1.get(k);
        if (localAppSetting != null) {
          break label126;
        }
      }
      label126:
      while (m != localAppSetting.appid.get())
      {
        k += 1;
        break label81;
        i = paramList1.size();
        break;
      }
      label139:
      if ((k != i) && (localAppSetting != null)) {
        break label303;
      }
      localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
      localAppSetting.appid.set(m);
      localAppSetting.setting.set(true);
      localAppSetting.modify_ts.set(0L);
    }
    label302:
    label303:
    for (;;)
    {
      if (!localAppSetting.setting.get())
      {
        long l = 100000000L + ((antx)paramList.get(j)).jdField_a_of_type_Long;
        str = "100600." + l + "";
        a(l);
      }
      for (;;)
      {
        paramTimeReqBody.rptSetting.add(localAppSetting);
        paramList2.add(str);
        j += 1;
        break;
        a(((antx)paramList.get(j)).jdField_a_of_type_Long);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramBoolean1, paramBoolean2);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return anty.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aoor.b(this.jdField_a_of_type_Aoou);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (("QQClubComm.getNewFlag".equals(paramFromServiceMsg.getServiceCmd())) && (i != 0)) {
        a(paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antv
 * JD-Core Version:    0.7.0.1
 */