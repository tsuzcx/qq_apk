package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.leba.LebaGridManager;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.LbsCellInfo;
import com.tencent.mobileqq.redtouch.LbsWLanInfo;
import com.tencent.mobileqq.redtouch.RedLbsInfoUtil;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.GameCenterServlet;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsCellInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsDetailInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsLocationInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsSubnation;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsWlanInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import zmc;
import zmd;

public class RedpointHandler
  extends BusinessHandler
  implements BusinessInfoCheckUpdateItem
{
  public static final HashSet a;
  public int a;
  SosoInterface.OnLocationListener a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  protected RedpointHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 600000;
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new zmc(this, 0, false, false, this.jdField_a_of_type_Int, false, false, "RedpointHandler");
  }
  
  private BusinessInfoCheckUpdate.LbsInfo a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    BusinessInfoCheckUpdate.LbsInfo localLbsInfo = new BusinessInfoCheckUpdate.LbsInfo();
    BusinessInfoCheckUpdate.LbsLocationInfo localLbsLocationInfo = new BusinessInfoCheckUpdate.LbsLocationInfo();
    localLbsLocationInfo.coordinate.set(1);
    localLbsLocationInfo.latitude.set((int)(paramSosoLocation.jdField_a_of_type_Double * 1000000.0D));
    localLbsLocationInfo.longitude.set((int)(paramSosoLocation.b * 1000000.0D));
    double d = paramSosoLocation.jdField_e_of_type_Double;
    float f = paramSosoLocation.jdField_a_of_type_Float;
    if (QLog.isColorLevel()) {
      QLog.d("RedpointHandler", 2, "getLbsInfo: altitude = " + d + ";accuracy = " + f);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(d).append(",").append(f).append(",0,0,0");
    localLbsLocationInfo.additional.set(((StringBuilder)localObject1).toString());
    BusinessInfoCheckUpdate.LbsDetailInfo localLbsDetailInfo = new BusinessInfoCheckUpdate.LbsDetailInfo();
    BusinessInfoCheckUpdate.LbsSubnation localLbsSubnation = new BusinessInfoCheckUpdate.LbsSubnation();
    Object localObject2;
    label209:
    Object localObject3;
    label223:
    Object localObject4;
    label237:
    Object localObject5;
    label251:
    String str1;
    label265:
    String str2;
    label279:
    label292:
    label441:
    label456:
    int i;
    if (TextUtils.isEmpty(paramSosoLocation.c))
    {
      localObject1 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.d)) {
        break label737;
      }
      localObject2 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.jdField_e_of_type_JavaLangString)) {
        break label746;
      }
      localObject3 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.g)) {
        break label755;
      }
      localObject4 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.h)) {
        break label764;
      }
      localObject5 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.i)) {
        break label773;
      }
      str1 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.j)) {
        break label782;
      }
      str2 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.k)) {
        break label791;
      }
      paramSosoLocation = "";
      localLbsSubnation.nation.set((String)localObject1);
      localLbsSubnation.province.set((String)localObject2);
      localLbsSubnation.city.set((String)localObject3);
      localLbsSubnation.district.set((String)localObject4);
      localLbsSubnation.town.set((String)localObject5);
      localLbsSubnation.village.set(str1);
      localLbsSubnation.street.set(str2);
      localLbsSubnation.street_no.set(paramSosoLocation);
      localLbsDetailInfo.subnation.set(localLbsSubnation);
      localObject3 = new RedLbsInfoUtil(this.b.getApp());
      localObject2 = new ArrayList();
      localObject4 = ((RedLbsInfoUtil)localObject3).a();
      if (localObject4 != null)
      {
        localObject5 = new BusinessInfoCheckUpdate.LbsWlanInfo();
        if (((LbsWLanInfo)localObject4).jdField_a_of_type_JavaLangString == null) {
          break label799;
        }
        paramSosoLocation = ((LbsWLanInfo)localObject4).jdField_a_of_type_JavaLangString;
        if (((LbsWLanInfo)localObject4).b == null) {
          break label805;
        }
        localObject1 = ((LbsWLanInfo)localObject4).b;
        ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).mac.set(paramSosoLocation);
        ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).rssi.set(((LbsWLanInfo)localObject4).jdField_a_of_type_Int);
        ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).ssid.set((String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("RedpointHandler", 2, "wlanInfo : mac = " + paramSosoLocation + ";rssi = " + ((LbsWLanInfo)localObject4).jdField_a_of_type_Int + ";ssid = " + (String)localObject1);
        }
        ((List)localObject2).add(localObject5);
      }
      localObject1 = ((RedLbsInfoUtil)localObject3).a();
      if (localObject1 == null) {
        break label818;
      }
      i = 0;
      label567:
      if (i >= ((List)localObject1).size()) {
        break label818;
      }
      if (i < 4)
      {
        localObject5 = new BusinessInfoCheckUpdate.LbsWlanInfo();
        if (((LbsWLanInfo)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString == null) {
          break label812;
        }
      }
    }
    label773:
    label782:
    label791:
    label799:
    label805:
    label812:
    for (paramSosoLocation = ((LbsWLanInfo)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString;; paramSosoLocation = "")
    {
      ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).mac.set(paramSosoLocation);
      ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).rssi.set(((LbsWLanInfo)((List)localObject1).get(i)).jdField_a_of_type_Int);
      if ((QLog.isColorLevel()) && (localObject4 != null)) {
        QLog.d("RedpointHandler", 2, "near wlanInfo : mac = " + paramSosoLocation + ";rssi = " + ((LbsWLanInfo)localObject4).jdField_a_of_type_Int);
      }
      ((List)localObject2).add(localObject5);
      i += 1;
      break label567;
      localObject1 = paramSosoLocation.c;
      break;
      label737:
      localObject2 = paramSosoLocation.d;
      break label209;
      label746:
      localObject3 = paramSosoLocation.jdField_e_of_type_JavaLangString;
      break label223;
      label755:
      localObject4 = paramSosoLocation.g;
      break label237;
      label764:
      localObject5 = paramSosoLocation.h;
      break label251;
      str1 = paramSosoLocation.i;
      break label265;
      str2 = paramSosoLocation.j;
      break label279;
      paramSosoLocation = paramSosoLocation.k;
      break label292;
      paramSosoLocation = "";
      break label441;
      localObject1 = "";
      break label456;
    }
    label818:
    paramSosoLocation = new ArrayList();
    localObject1 = ((RedLbsInfoUtil)localObject3).a();
    if (localObject1 != null)
    {
      localObject4 = new BusinessInfoCheckUpdate.LbsCellInfo();
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).cellid.set(((LbsCellInfo)localObject1).d);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).lac.set(((LbsCellInfo)localObject1).c);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).mcc.set(((LbsCellInfo)localObject1).jdField_a_of_type_Int);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).mnc.set(((LbsCellInfo)localObject1).jdField_b_of_type_Int);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).rssi.set(((LbsCellInfo)localObject1).e);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).stationLat.set(((LbsCellInfo)localObject1).f);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).stationLng.set(((LbsCellInfo)localObject1).g);
      paramSosoLocation.add(localObject4);
    }
    localObject1 = ((RedLbsInfoUtil)localObject3).b();
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((List)localObject1).size())
      {
        if (i < 4)
        {
          localObject3 = new BusinessInfoCheckUpdate.LbsCellInfo();
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).cellid.set(((LbsCellInfo)((List)localObject1).get(i)).d);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).lac.set(((LbsCellInfo)((List)localObject1).get(i)).c);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).mcc.set(((LbsCellInfo)((List)localObject1).get(i)).jdField_a_of_type_Int);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).mnc.set(((LbsCellInfo)((List)localObject1).get(i)).jdField_b_of_type_Int);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).rssi.set(((LbsCellInfo)((List)localObject1).get(i)).e);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).stationLat.set(((LbsCellInfo)((List)localObject1).get(i)).f);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).stationLng.set(((LbsCellInfo)((List)localObject1).get(i)).g);
          paramSosoLocation.add(localObject3);
        }
        i += 1;
      }
    }
    localLbsInfo.cells.set(paramSosoLocation);
    localLbsInfo.location.set(localLbsLocationInfo);
    localLbsInfo.wlan.set((List)localObject2);
    localLbsInfo.detail_info.set(localLbsDetailInfo);
    return localLbsInfo;
  }
  
  public static List a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramAppRuntime = ResourcePluginInfo.getAll(((QQAppInterface)paramAppRuntime).getEntityManagerFactory().createEntityManager(), 64, false);
    if (paramAppRuntime == null) {
      return null;
    }
    int i = 0;
    while (i < paramAppRuntime.size())
    {
      RedpointHandler.RedPointHolder localRedPointHolder = new RedpointHandler.RedPointHolder();
      localRedPointHolder.jdField_a_of_type_Long = ((ResourcePluginInfo)paramAppRuntime.get(i)).uiResId;
      localRedPointHolder.jdField_a_of_type_Int = ((int)((ResourcePluginInfo)paramAppRuntime.get(i)).uiResId);
      localArrayList.add(localRedPointHolder);
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new zmd(this, paramInt, paramSosoLbsInfo), 5, null, true);
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
    Object localObject = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    if (localObject != null) {
      ((GameCenterManagerImp)localObject).a();
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), GameCenterServlet.class);
    ((NewIntent)localObject).setAction("gc_refresh_ui");
    ((NewIntent)localObject).putExtra("gc_notify_type", 6);
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("RedpointHandler", 1, "handleResponse data = null");
      return;
    }
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody;
    Object localObject2;
    int i;
    label218:
    int j;
    label386:
    label422:
    Object localObject4;
    try
    {
      localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
      localTimeRspBody.mergeFrom((byte[])paramObject);
      if (localTimeRspBody == null)
      {
        QLog.e("RedpointHandler", 1, "handleResponse prb = null");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
        QLog.e("RedpointHandler", 1, "mergeFrom failed");
        localTimeRspBody = null;
      }
      if (localTimeRspBody.iResult.get() != 0)
      {
        QLog.d("RedpointHandler", 2, "handleResponse,return fail ,TimeRspBody result:" + localTimeRspBody.iResult.get());
        return;
      }
      QLog.i("RedpointHandler", 1, "handleResponse");
      localObject1 = this.b.getApp().getSharedPreferences("check_update_sp_key", 0);
      paramObject = ((SharedPreferences)localObject1).edit();
      if (localTimeRspBody.iInterval.has())
      {
        localObject2 = "businessinfo_check_update_interval_" + this.b.getCurrentAccountUin();
        if (localTimeRspBody.iInterval.get() > 0) {
          i = localTimeRspBody.iInterval.get();
        }
      }
      for (;;)
      {
        paramObject.putInt((String)localObject2, i);
        paramObject.putInt("businessinfo_check_update_interval_lbsinfo_" + this.b.getCurrentAccountUin(), localTimeRspBody.iLbsInterval.get());
        QLog.d("RedpointHandler", 1, "handleResponse, iInterval = " + localTimeRspBody.iInterval.get() + "; lbsInterval = " + localTimeRspBody.iLbsInterval.get());
        paramObject.putInt("businessinfo_last_check_update_timestamp_" + this.b.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L));
        paramObject.commit();
        this.b.getEntityManagerFactory().createEntityManager();
        if (this.b.q)
        {
          paramObject = b(this.b);
          localObject2 = (RedTouchManager)this.b.getManager(35);
        }
        try
        {
          if (!localTimeRspBody.rptMsgAppInfo.has()) {
            break label1011;
          }
          j = localTimeRspBody.rptMsgAppInfo.size();
          i = 0;
          if (i >= j) {
            break label1011;
          }
          localObject3 = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
          if ((localObject3 != null) && (1 == ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get()))
          {
            if (a(paramObject, (BusinessInfoCheckUpdate.AppInfo)localObject3)) {
              break label664;
            }
            ((BusinessInfoCheckUpdate.AppInfo)localObject3).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.set(0);
            localTimeRspBody.rptMsgAppInfo.set(i, (MessageMicro)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("RedpointHandler", 2, "verifyDataCorrect,return false ,appInfo.path.get():" + ((BusinessInfoCheckUpdate.AppInfo)localObject3).path.get());
            }
          }
          for (;;)
          {
            if ((localObject3 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject3).use_cache.get()))
            {
              localObject4 = ((RedTouchManager)localObject2).a(((BusinessInfoCheckUpdate.AppInfo)localObject3).path.get());
              if (localObject4 != null)
              {
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject4).buffer.get());
                localTimeRspBody.rptMsgAppInfo.set(i, (MessageMicro)localObject3);
              }
            }
            i += 1;
            break label422;
            i = 0;
            break;
            paramObject.remove("businessinfo_check_update_interval_" + this.b.getCurrentAccountUin());
            break label218;
            paramObject = a(this.b);
            break label386;
            label664:
            if (((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.get() == 769) {
              ((SharedPreferences)localObject1).edit().putInt("reader_zone_appinfo_last_pull_timestamp_" + this.b.getCurrentAccountUin(), (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)).commit();
            }
          }
          ((RedTouchManager)localObject2).a(localTimeRspBody);
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
        }
      }
    }
    paramObject = (IndividuationABTestManager)this.b.getManager(176);
    if ((!paramObject.jdField_b_of_type_Boolean) && (!paramObject.jdField_a_of_type_Boolean)) {
      paramObject.a(this.b.getCurrentAccountUin());
    }
    if ((paramObject.jdField_a_of_type_Int != 0) && (!TextUtils.isEmpty(paramObject.jdField_a_of_type_JavaLangString)) && (paramObject.jdField_b_of_type_Int == 0))
    {
      if (localTimeRspBody.rptMsgAppInfo.has())
      {
        j = localTimeRspBody.rptMsgAppInfo.size();
        i = 0;
        label831:
        if (i < j)
        {
          paramObject = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
          if ((paramObject == null) || (!String.valueOf(100005).equals(paramObject.path.get()))) {
            break label1345;
          }
          paramObject.iNewFlag.set(0);
          paramObject.modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RedpointHandler", 2, "individuation jump open");
      }
    }
    if ((localTimeRspBody != null) && (localTimeRspBody.rptSetting != null) && (localTimeRspBody.rptSetting.get() != null)) {
      LebaShowListManager.a().a(localTimeRspBody.rptSetting.get());
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedpointHandler", 2, "update NearbyNumAppinfo");
    }
    NearbyMineHelper.a(this.b, true);
    if (QLog.isColorLevel()) {
      QLog.i("RedpointHandler", 2, "on pull Appinfos");
    }
    ((LocalRedTouchManager)this.b.getManager(159)).c();
    a(this.b);
    return;
    label1011:
    Object localObject1 = localTimeRspBody.rptSetting.get();
    paramObject = ((RedTouchManager)localObject2).b();
    Object localObject3 = new ArrayList();
    if ((localObject1 != null) && (paramObject != null))
    {
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject4 = (BusinessInfoCheckUpdate.AppSetting)((List)localObject1).get(i);
        j = 0;
        label1073:
        if (j < paramObject.size())
        {
          if (((BusinessInfoCheckUpdate.AppSetting)paramObject.get(j)).appid.get() != ((BusinessInfoCheckUpdate.AppSetting)localObject4).appid.get()) {
            break label1367;
          }
          paramObject.set(j, localObject4);
          j = 1;
          label1122:
          if (j != 0) {
            break label1360;
          }
          ((List)localObject3).add(localObject4);
          break label1360;
        }
      }
      else
      {
        paramObject.addAll((Collection)localObject3);
      }
    }
    for (;;)
    {
      label1148:
      localTimeRspBody.rptSetting.set(paramObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramObject = new StringBuilder();
      paramObject.append("redinfo:");
      if (localTimeRspBody.rptMsgAppInfo.has())
      {
        j = localTimeRspBody.rptMsgAppInfo.size();
        i = 0;
        label1201:
        if (i < j)
        {
          localObject1 = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
          if (localObject1 == null) {
            break label1374;
          }
          paramObject.append("appid = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.get());
          paramObject.append("path = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get());
          paramObject.append("inewflag = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get());
          paramObject.append(";");
          break label1374;
        }
      }
      QLog.d("RedpointHandler", 2, paramObject.toString());
      break;
      label1345:
      i += 1;
      break label831;
      label1360:
      label1367:
      label1374:
      do
      {
        break label1148;
        j = 0;
        break label1122;
        i += 1;
        break;
        j += 1;
        break label1073;
        i += 1;
        break label1201;
      } while (paramObject != null);
      paramObject = localObject1;
    }
  }
  
  public static boolean a(List paramList, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return false;
      if (paramAppInfo.appset.get() == 3) {
        return true;
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        int j = paramList.size();
        i = 0;
        while (i < j)
        {
          long l = ((RedpointHandler.RedPointHolder)paramList.get(i)).jdField_a_of_type_Long;
          String str = "100600." + (100000000L + l) + "";
          if (((((RedpointHandler.RedPointHolder)paramList.get(i)).jdField_a_of_type_Long + "").equals(paramAppInfo.path.get())) || (str.equals(paramAppInfo.path.get()))) {
            return true;
          }
          if ((jdField_a_of_type_JavaUtilHashSet != null) && (jdField_a_of_type_JavaUtilHashSet.contains(paramAppInfo.path.get()))) {
            return true;
          }
          i += 1;
        }
      }
      int i = 0;
      while (i < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        paramList = paramAppInfo.path.get();
        if (jdField_a_of_type_Array2dOfJavaLangString[i][1].equals(paramList)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static List b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramAppRuntime = ((LebaGridManager)paramAppRuntime.getManager(211)).a(2);
    if (paramAppRuntime == null) {
      return null;
    }
    int i = 0;
    while (i < paramAppRuntime.size())
    {
      RedpointHandler.RedPointHolder localRedPointHolder = new RedpointHandler.RedPointHolder();
      localRedPointHolder.jdField_a_of_type_Long = ((PluginInfo)paramAppRuntime.get(i)).pluginId;
      localRedPointHolder.jdField_a_of_type_Int = ((PluginInfo)paramAppRuntime.get(i)).pluginId;
      localArrayList.add(localRedPointHolder);
      i += 1;
    }
    return localArrayList;
  }
  
  private void b(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.d("RedpointHandler", 1, "sendReq start");
    BusinessInfoCheckUpdate.TimeReqBody localTimeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
    localTimeReqBody.iProtocolVer.set(1);
    localTimeReqBody.uiClientPlatID.set(109);
    localTimeReqBody.sClientVer.set("7.6.3.3565");
    localTimeReqBody.uiUin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    int i = NetworkUtil.a(BaseApplication.getContext());
    localTimeReqBody.uiNetType.set(i);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = a(paramSosoLbsInfo.a);
      if (paramSosoLbsInfo != null) {
        localTimeReqBody.lbs.set(paramSosoLbsInfo);
      }
    }
    this.b.getEntityManagerFactory().createEntityManager();
    Object localObject1;
    RedTouchManager localRedTouchManager;
    Object localObject2;
    label171:
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    label212:
    Object localObject3;
    int k;
    int j;
    if (this.b.q)
    {
      localObject1 = b(this.b);
      localRedTouchManager = (RedTouchManager)this.b.getManager(35);
      if (localRedTouchManager != null) {
        break label322;
      }
      localObject2 = null;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      if (localObject1 == null) {
        break label509;
      }
      paramSosoLbsInfo = null;
      if (localObject2 != null) {
        break label332;
      }
      paramInt = 0;
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label509;
      }
      localObject3 = ((RedpointHandler.RedPointHolder)((List)localObject1).get(i)).jdField_a_of_type_Long + "";
      k = ((RedpointHandler.RedPointHolder)((List)localObject1).get(i)).jdField_a_of_type_Int;
      j = 0;
      label278:
      if (j >= paramInt) {
        break label355;
      }
      paramSosoLbsInfo = (BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(j);
      if (paramSosoLbsInfo != null) {
        break label343;
      }
    }
    label322:
    label332:
    label343:
    while (k != paramSosoLbsInfo.appid.get())
    {
      j += 1;
      break label278;
      localObject1 = a(this.b);
      break;
      localObject2 = localRedTouchManager.b();
      break label171;
      paramInt = ((List)localObject2).size();
      break label212;
    }
    label355:
    if ((j == paramInt) || (paramSosoLbsInfo == null))
    {
      paramSosoLbsInfo = new BusinessInfoCheckUpdate.AppSetting();
      paramSosoLbsInfo.appid.set(k);
      paramSosoLbsInfo.setting.set(true);
      paramSosoLbsInfo.modify_ts.set(0L);
    }
    for (;;)
    {
      if (!paramSosoLbsInfo.setting.get())
      {
        long l = 100000000L + ((RedpointHandler.RedPointHolder)((List)localObject1).get(i)).jdField_a_of_type_Long;
        localObject3 = "100600." + l + "";
        a(l);
      }
      for (;;)
      {
        localTimeReqBody.rptSetting.add(paramSosoLbsInfo);
        localArrayList1.add(localObject3);
        i += 1;
        break;
        a(((RedpointHandler.RedPointHolder)((List)localObject1).get(i)).jdField_a_of_type_Long);
      }
      label509:
      localArrayList1.addAll(jdField_a_of_type_JavaUtilHashSet);
      paramInt = 0;
      while (paramInt < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        localArrayList1.add(jdField_a_of_type_Array2dOfJavaLangString[paramInt][1]);
        paramInt += 1;
      }
      if (localRedTouchManager != null)
      {
        paramSosoLbsInfo = localRedTouchManager.a(3).iterator();
        while (paramSosoLbsInfo.hasNext()) {
          localArrayList1.add(((BusinessInfoCheckUpdate.AppInfo)paramSosoLbsInfo.next()).path.get());
        }
        if (localRedTouchManager.a() == null)
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
        if (!this.b.q) {
          break label1213;
        }
        localTimeReqBody.bHebaFlag.set(true);
        label676:
        if ((!((FontManager)this.b.getManager(41)).jdField_a_of_type_Boolean) && (localTimeReqBody.rptMsgAppInfo.has()))
        {
          paramInt = 0;
          label707:
          if (paramInt < localTimeReqBody.rptMsgAppInfo.size())
          {
            if (!"100005.100011".equals(((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt)).path.get())) {
              break label1225;
            }
            localTimeReqBody.rptMsgAppInfo.remove(paramInt);
          }
        }
        if (!QLog.isColorLevel()) {
          break label1261;
        }
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("req red pathlist:");
        if (!localTimeReqBody.rptMsgAppInfo.has()) {
          break label1232;
        }
        paramInt = 0;
        while (paramInt < localTimeReqBody.rptMsgAppInfo.size())
        {
          localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt)).path.get();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramSosoLbsInfo.append((String)localObject1);
            paramSosoLbsInfo.append(";");
          }
          paramInt += 1;
        }
      }
      paramSosoLbsInfo = localRedTouchManager.a();
      label896:
      if (paramSosoLbsInfo.rptMsgAppInfo.has())
      {
        i = 0;
        label870:
        if (i < localArrayList1.size())
        {
          localObject1 = (String)localArrayList1.get(i);
          paramInt = 0;
          if (paramInt >= paramSosoLbsInfo.rptMsgAppInfo.size()) {
            break label1312;
          }
          localObject2 = (BusinessInfoCheckUpdate.AppInfo)paramSosoLbsInfo.rptMsgAppInfo.get(paramInt);
          if (!((String)localObject1).equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get())) {
            break label1193;
          }
          localObject3 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get();
          paramInt = 0;
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {
            paramInt = 1;
          }
          if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0) || (paramInt == 0)) {
            break label1003;
          }
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0) {
          localArrayList2.add(localObject1);
        }
        i += 1;
        break label870;
        break;
        label1003:
        localObject3 = new BusinessInfoCheckUpdate.AppInfo();
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).path.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).modify_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).type.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).push_red_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).push_red_ts.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).mission_level.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).mission_level.get());
        paramInt = 0;
        while (paramInt < ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.size())
        {
          ((BusinessInfoCheckUpdate.AppInfo)localObject3).missions.add(((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get(paramInt));
          paramInt += 1;
        }
        localArrayList3.add(localObject3);
        paramInt = 0;
        continue;
        label1193:
        paramInt += 1;
        break label896;
        localArrayList2.addAll(localArrayList1);
        break;
        label1213:
        localTimeReqBody.bHebaFlag.set(false);
        break label676;
        label1225:
        paramInt += 1;
        break label707;
        label1232:
        QLog.d("RedpointHandler", 2, "getNewFlagOp rptMsginfoPath:" + paramSosoLbsInfo.toString());
        label1261:
        if (QLog.isColorLevel()) {}
        QLog.d("RedpointHandler", 1, "getNewFlagOp local message ok");
        paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "QQClubComm.getNewFlag");
        paramSosoLbsInfo.putWupBuffer(localTimeReqBody.toByteArray());
        b(paramSosoLbsInfo);
        return;
        label1312:
        paramInt = 1;
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("RedpointHandler", 2, "getNewFlagOp:send redInfo start");
    SharedPreferences localSharedPreferences = this.b.getApp().getSharedPreferences("check_update_sp_key", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("businessinfo_check_update_interval_" + this.b.getCurrentAccountUin(), 600);
    this.jdField_a_of_type_Int = (i * 1000);
    int j = localSharedPreferences.getInt("businessinfo_check_update_interval_lbsinfo_" + this.b.getCurrentAccountUin(), 43200000);
    int k = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.b.getCurrentAccountUin(), 0);
    int m = localSharedPreferences.getInt("businessinfo_last_check_lbsinfo_timestamp_" + this.b.getCurrentAccountUin(), 0);
    int n = (int)(System.currentTimeMillis() / 1000L);
    QLog.d("RedpointHandler", 1, "getNewFlagOp:sendredInfo :systemTimestamp = " + n + ";lastUpdateTimestamp = " + k + ";updateInterval = " + i + ";updateLbsInterval = " + j + ";lastCheckLbsInfo = " + m + ";isDebugVersion = " + false);
    if ((!paramBoolean1) && (n - k <= i) && (n >= k)) {
      return;
    }
    localEditor.putInt("businessinfo_last_check_update_timestamp_" + this.b.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L)).commit();
    if ((paramBoolean2) && ((n - m > j) || (n < k)))
    {
      localEditor.putInt("businessinfo_last_check_lbsinfo_timestamp_" + this.b.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L)).commit();
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      return;
    }
    a(-1, null);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RedpointHandler
 * JD-Core Version:    0.7.0.1
 */