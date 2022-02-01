package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyNewRedDotManager;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.GameCenterServlet;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.tianshu.data.RedPointHolder;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsDetailInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsSubnation;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeReqBody;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class RedpointHandler
  extends BusinessHandler
  implements BusinessInfoCheckUpdateItem
{
  private static final HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LbsManagerServiceOnLocationChangeListener jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener = new RedpointHandler.1(this, "vas_red_point", false);
  
  protected RedpointHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private BusinessInfoCheckUpdate.LbsInfo a(SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    BusinessInfoCheckUpdate.LbsInfo localLbsInfo = new BusinessInfoCheckUpdate.LbsInfo();
    BusinessInfoCheckUpdate.LbsDetailInfo localLbsDetailInfo = new BusinessInfoCheckUpdate.LbsDetailInfo();
    BusinessInfoCheckUpdate.LbsSubnation localLbsSubnation = new BusinessInfoCheckUpdate.LbsSubnation();
    if (TextUtils.isEmpty(paramSosoLocation.cityCode)) {}
    for (paramSosoLocation = "";; paramSosoLocation = paramSosoLocation.cityCode)
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
  
  public static List<RedPointHolder> a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramAppRuntime = LebaPluginInfo.getAll(((QQAppInterface)paramAppRuntime).getEntityManagerFactory().createEntityManager());
    } while (paramAppRuntime == null);
    int i = 0;
    while (i < paramAppRuntime.size())
    {
      RedPointHolder localRedPointHolder = new RedPointHolder();
      localRedPointHolder.jdField_a_of_type_Long = ((LebaPluginInfo)paramAppRuntime.get(i)).uiResId;
      localRedPointHolder.jdField_a_of_type_Int = ((int)((LebaPluginInfo)paramAppRuntime.get(i)).uiResId);
      localArrayList.add(localRedPointHolder);
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, SosoLbsInfo paramSosoLbsInfo, int paramInt2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new RedpointHandler.2(this, paramInt1, paramSosoLbsInfo, paramInt2), 5, null, true);
      return;
    }
    b(paramInt1, paramSosoLbsInfo, paramInt2);
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
  
  private void a(BusinessInfoCheckUpdate.TimeReqBody paramTimeReqBody)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("req red pathlist:");
      if (paramTimeReqBody.rptMsgAppInfo.has())
      {
        int i = 0;
        while (i < paramTimeReqBody.rptMsgAppInfo.size())
        {
          localObject = ((BusinessInfoCheckUpdate.AppInfo)paramTimeReqBody.rptMsgAppInfo.get(i)).path.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localStringBuilder1.append((String)localObject);
            localStringBuilder1.append(";");
          }
          i += 1;
        }
      }
      QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp rptMsginfoPath:" + localStringBuilder1.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("req setting pathlist:");
    localStringBuilder1.append("leba_study");
    if (paramTimeReqBody.rptSetting.has())
    {
      localObject = paramTimeReqBody.rptSetting.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)((Iterator)localObject).next();
        if (localAppSetting != null)
        {
          StringBuilder localStringBuilder2 = localStringBuilder1.append("appid: ");
          if (localAppSetting.appid.has())
          {
            paramTimeReqBody = Integer.valueOf(localAppSetting.appid.get());
            label226:
            localStringBuilder2 = localStringBuilder2.append(paramTimeReqBody).append("  setting:");
            if (!localAppSetting.setting.has()) {
              break label323;
            }
            paramTimeReqBody = Boolean.valueOf(localAppSetting.setting.get());
            label263:
            localStringBuilder2 = localStringBuilder2.append(paramTimeReqBody).append(" modify_ts:");
            if (!localAppSetting.modify_ts.has()) {
              break label330;
            }
          }
          label323:
          label330:
          for (paramTimeReqBody = Long.valueOf(localAppSetting.modify_ts.get());; paramTimeReqBody = "null")
          {
            localStringBuilder2.append(paramTimeReqBody).append(",");
            break;
            paramTimeReqBody = "null";
            break label226;
            paramTimeReqBody = "null";
            break label263;
          }
        }
      }
    }
    QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp setting:" + localStringBuilder1.toString());
    if (QLog.isColorLevel()) {}
  }
  
  private void a(BusinessInfoCheckUpdate.TimeReqBody paramTimeReqBody, List<RedPointHolder> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1, List<String> paramList2)
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
        str = ((RedPointHolder)paramList.get(j)).jdField_a_of_type_Long + "";
        m = ((RedPointHolder)paramList.get(j)).jdField_a_of_type_Int;
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
        long l = 100000000L + ((RedPointHolder)paramList.get(j)).jdField_a_of_type_Long;
        str = "100600." + l + "";
        a(l);
      }
      for (;;)
      {
        paramTimeReqBody.rptSetting.add(localAppSetting);
        paramList2.add(str);
        j += 1;
        break;
        a(((RedPointHolder)paramList.get(j)).jdField_a_of_type_Long);
      }
      return;
    }
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
    QLog.d("RedPointLog.RedpointHandler", 1, localStringBuilder.toString());
  }
  
  private void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody, RedTouchManager paramRedTouchManager)
  {
    List localList = paramTimeRspBody.rptSetting.get();
    paramRedTouchManager = paramRedTouchManager.a();
    ArrayList localArrayList = new ArrayList();
    int i;
    BusinessInfoCheckUpdate.AppSetting localAppSetting;
    if ((localList != null) && (paramRedTouchManager != null))
    {
      i = 0;
      if (i < localList.size())
      {
        localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localList.get(i);
        j = 0;
        label61:
        if (j >= paramRedTouchManager.size()) {
          break label176;
        }
        if (((BusinessInfoCheckUpdate.AppSetting)paramRedTouchManager.get(j)).appid.get() == localAppSetting.appid.get()) {
          paramRedTouchManager.set(j, localAppSetting);
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
      paramRedTouchManager.addAll(localArrayList);
      for (;;)
      {
        paramTimeRspBody.rptSetting.set(paramRedTouchManager);
        return;
        if (paramRedTouchManager == null) {
          paramRedTouchManager = localList;
        }
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {
      QLog.e("RedPointLog.RedpointHandler", 1, "handleResponse data = null");
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
          QLog.e("RedPointLog.RedpointHandler", 1, "mergeFrom failed");
          paramObject = null;
        }
      }
      if (paramObject == null)
      {
        QLog.e("RedPointLog.RedpointHandler", 1, "handleResponse prb = null");
        return;
      }
      if (paramObject.iResult.get() == 0) {
        break;
      }
      QLog.d("RedPointLog.RedpointHandler", 2, "handleResponse,return fail ,TimeRspBody result:" + paramObject.iResult.get());
    } while (paramObject.iResult.get() != 104005);
    paramObject = new BusinessInfoCheckUpdate.TimeRspBody();
    for (;;)
    {
      for (;;)
      {
        QLog.i("RedPointLog.RedpointHandler", 1, "handleResponse");
        b(paramObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
        try
        {
          if (!a(paramObject, (RedTouchManager)localObject)) {
            break;
          }
          a(paramObject, (RedTouchManager)localObject);
          a(paramObject);
          ((RedTouchManager)localObject).a(paramObject);
          c(paramObject);
          ((RedTouchManager)localObject).jdField_a_of_type_Int = 0;
          ((RedTouchManager)localObject).b = 0;
          ((RedTouchManager)localObject).a(paramObject);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("RedPointLog.RedpointHandler", 2, "handleResponse", localException);
          }
        }
      }
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
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
          long l = ((RedPointHolder)((List)localObject1).get(i)).jdField_a_of_type_Long;
          localObject2 = "100600." + (100000000L + l) + "";
          if (((((RedPointHolder)((List)localObject1).get(i)).jdField_a_of_type_Long + "").equals(paramAppInfo.path.get())) || (((String)localObject2).equals(paramAppInfo.path.get()))) {
            return true;
          }
          if ((jdField_a_of_type_JavaUtilHashSet != null) && (jdField_a_of_type_JavaUtilHashSet.contains(paramAppInfo.path.get()))) {
            return true;
          }
          i += 1;
        }
      }
      localObject1 = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      if (localObject1 != null)
      {
        localObject1 = ((IRedTouchManager)localObject1).getRegisterInterfaces().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ((BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localObject2).getRedPointPaths(paramQQAppInterface);
            if ((localObject2 != null) && (((List)localObject2).contains(paramAppInfo.path.get()))) {
              return true;
            }
          }
        }
      }
      int i = 0;
      while (i < ALL_PLUGITEM.length)
      {
        paramQQAppInterface = paramAppInfo.path.get();
        if (ALL_PLUGITEM[i][1].equals(paramQQAppInterface)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody, RedTouchManager paramRedTouchManager)
  {
    if (paramTimeRspBody.rptMsgAppInfo.has())
    {
      Iterator localIterator = paramTimeRspBody.rptMsgAppInfo.get().iterator();
      while (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo1 = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        if (localAppInfo1 != null)
        {
          if ((!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localAppInfo1)) && (1 == localAppInfo1.iNewFlag.get()))
          {
            localAppInfo1.modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            localAppInfo1.iNewFlag.set(0);
            if (QLog.isColorLevel()) {
              QLog.d("RedPointLog.RedpointHandler", 2, "verifyDataCorrect,return false ,appInfo.path.get():" + localAppInfo1.path.get());
            }
          }
          if (localAppInfo1.use_cache.get())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo2 = paramRedTouchManager.a(localAppInfo1.path.get());
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
        paramRedTouchManager = ((BusinessInfoCheckUpdate.NumRedInfo)paramTimeRspBody.next()).num_red_path.get();
        if (paramRedTouchManager != null)
        {
          int i = 0;
          while (i < paramRedTouchManager.size())
          {
            ((BusinessInfoCheckUpdate.NumRedPath)paramRedTouchManager.get(i)).uint32_push_num_red_ts.set((int)(System.currentTimeMillis() / 1000L));
            i += 1;
          }
        }
      }
    }
    return true;
  }
  
  private void b(int paramInt1, SosoLbsInfo paramSosoLbsInfo, int paramInt2)
  {
    int i = 0;
    QLog.d("RedPointLog.RedpointHandler", 1, "sendReq start");
    BusinessInfoCheckUpdate.TimeReqBody localTimeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
    localTimeReqBody.iProtocolVer.set(1);
    localTimeReqBody.uiClientPlatID.set(109);
    localTimeReqBody.sClientVer.set("8.5.5.5105");
    localTimeReqBody.uiUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localTimeReqBody.uReqType.set(paramInt2);
    paramInt2 = NetworkUtil.a(BaseApplication.getContext());
    localTimeReqBody.uiNetType.set(paramInt2);
    if ((paramInt1 == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramSosoLbsInfo = a(paramSosoLbsInfo.mLocation);
      if (paramSosoLbsInfo != null) {
        localTimeReqBody.lbs.set(paramSosoLbsInfo);
      }
    }
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (localRedTouchManager == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    for (paramSosoLbsInfo = null;; paramSosoLbsInfo = localRedTouchManager.a())
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      a(localTimeReqBody, (List)localObject, paramSosoLbsInfo, localArrayList1);
      localArrayList1.addAll(jdField_a_of_type_JavaUtilHashSet);
      paramSosoLbsInfo = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getRegisterInterfaces().iterator();
      while (paramSosoLbsInfo.hasNext())
      {
        localObject = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)paramSosoLbsInfo.next();
        if (localObject != null) {
          try
          {
            if (((BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localObject).getRedPointPaths(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) {
              localArrayList1.addAll(((BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localObject).getRedPointPaths(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            }
          }
          catch (Exception localException)
          {
            QLog.e("RedPointLog.RedpointHandler", 1, "add exception error" + localException);
          }
        }
      }
    }
    paramInt1 = 0;
    while (paramInt1 < ALL_PLUGITEM.length)
    {
      localArrayList1.add(ALL_PLUGITEM[paramInt1][1]);
      paramInt1 += 1;
    }
    if (localRedTouchManager != null)
    {
      paramSosoLbsInfo = localRedTouchManager.b(3).iterator();
      while (paramSosoLbsInfo.hasNext()) {
        localArrayList1.add(((BusinessInfoCheckUpdate.AppInfo)paramSosoLbsInfo.next()).path.get());
      }
      if (localRedTouchManager.a() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedPointLog.RedpointHandler", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
        }
        localArrayList2.addAll(localArrayList1);
      }
    }
    else
    {
      localTimeReqBody.rptMsgAppInfo.set(localArrayList3);
      localTimeReqBody.rptNoRedPath.set(localArrayList2);
      localTimeReqBody.sQimei.set(String.valueOf(UserAction.getQIMEI()));
      paramSosoLbsInfo = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localTimeReqBody.rptIdList.set(paramSosoLbsInfo.c());
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mIsShowNewLeba) {
        break label682;
      }
      localTimeReqBody.bHebaFlag.set(true);
      label535:
      if ((!((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a) && (localTimeReqBody.rptMsgAppInfo.has())) {
        paramInt1 = i;
      }
    }
    for (;;)
    {
      if (paramInt1 < localTimeReqBody.rptMsgAppInfo.size())
      {
        if ("100005.100011".equals(((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt1)).path.get())) {
          localTimeReqBody.rptMsgAppInfo.remove(paramInt1);
        }
      }
      else
      {
        a(localTimeReqBody);
        QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp local message ok");
        paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), MessageConstants.D);
        paramSosoLbsInfo.putWupBuffer(localTimeReqBody.toByteArray());
        sendPbReq(paramSosoLbsInfo);
        return;
        a(localRedTouchManager, localArrayList1, localArrayList2, localArrayList3);
        break;
        label682:
        localTimeReqBody.bHebaFlag.set(false);
        break label535;
      }
      paramInt1 += 1;
    }
  }
  
  private void b(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    int i = 0;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
    if (paramTimeRspBody.iInterval.has())
    {
      String str = "businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramTimeRspBody.iInterval.get() > 0) {
        i = paramTimeRspBody.iInterval.get();
      }
      localEditor.putInt(str, i);
    }
    for (;;)
    {
      localEditor.putInt("businessinfo_check_update_interval_lbsinfo_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramTimeRspBody.iLbsInterval.get());
      QLog.d("RedPointLog.RedpointHandler", 1, "handleResponse, iInterval = " + paramTimeRspBody.iInterval.get() + "; lbsInterval = " + paramTimeRspBody.iLbsInterval.get());
      localEditor.putInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L));
      localEditor.apply();
      return;
      localEditor.remove("businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  private void c(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    Object localObject1;
    if (paramTimeRspBody.rptMsgAppInfo.has())
    {
      int j = paramTimeRspBody.rptMsgAppInfo.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (BusinessInfoCheckUpdate.AppInfo)paramTimeRspBody.rptMsgAppInfo.get(i);
        if (localObject1 != null)
        {
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get();
          if (((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.get() == 769) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0).edit().putInt("reader_zone_appinfo_last_pull_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)).apply();
          }
        }
        i += 1;
      }
    }
    Object localObject2;
    Object localObject3;
    if (paramTimeRspBody.rptMsgNumRedInfo.has())
    {
      localObject1 = new ArrayList();
      localObject2 = paramTimeRspBody.rptMsgNumRedInfo.get();
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
        if (((BusinessInfoCheckUpdate.NumRedInfo)localObject3).appid.get() == 7719) {
          ((List)localObject1).add(localObject3);
        }
      }
      NearbyNewRedDotManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPointLog.RedpointHandler", 2, "individuation jump open");
    }
    if (paramTimeRspBody.rptSetting.get() != null)
    {
      localObject2 = new StringBuilder("switch ");
      ((StringBuilder)localObject2).append("leba_study");
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
            label361:
            localStringBuilder = localStringBuilder.append(localObject1).append("  setting:");
            if (!localAppSetting.setting.has()) {
              break label464;
            }
            localObject1 = Boolean.valueOf(localAppSetting.setting.get());
            label400:
            localStringBuilder = localStringBuilder.append(localObject1).append(" modify_ts:");
            if (!localAppSetting.modify_ts.has()) {
              break label472;
            }
          }
          label464:
          label472:
          for (localObject1 = Long.valueOf(localAppSetting.modify_ts.get());; localObject1 = "null")
          {
            localStringBuilder.append(localObject1).append(",");
            break;
            localObject1 = "null";
            break label361;
            localObject1 = "null";
            break label400;
          }
        }
      }
      QLog.i("RedPointLog.RedpointHandler", 1, ((StringBuilder)localObject2).toString());
      localObject1 = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
      if (localObject1 == null) {
        break label552;
      }
      ((ILebaHelperService)localObject1).updateAllLebaListFlag(paramTimeRspBody.rptSetting.get());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RedPointLog.RedpointHandler", 2, "update NearbyNumAppinfo");
      }
      NearbyMineHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      return;
      label552:
      QLog.d("RedPointLog.RedpointHandler", 1, "processExtraData lebaHelperService == null");
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("RedPointLog.RedpointHandler", 1, "forceSendReq fromSrc:" + paramInt);
    a(-1, null, 6);
  }
  
  protected void a(RedTouchManager paramRedTouchManager, List<String> paramList1, List<String> paramList2, List<BusinessInfoCheckUpdate.AppInfo> paramList)
  {
    paramRedTouchManager = paramRedTouchManager.a();
    int j;
    String str;
    if ((paramRedTouchManager != null) && (paramRedTouchManager.rptMsgAppInfo.has()))
    {
      j = 0;
      if (j >= paramList1.size()) {
        break label385;
      }
      str = (String)paramList1.get(j);
      if (!TextUtils.isEmpty(str)) {}
    }
    label136:
    label396:
    for (;;)
    {
      j += 1;
      break;
      int i = 0;
      label66:
      BusinessInfoCheckUpdate.AppInfo localAppInfo;
      Object localObject;
      if (i < paramRedTouchManager.rptMsgAppInfo.size())
      {
        localAppInfo = (BusinessInfoCheckUpdate.AppInfo)paramRedTouchManager.rptMsgAppInfo.get(i);
        if (str.equals(localAppInfo.path.get()))
        {
          localObject = localAppInfo.missions.get();
          if ((localObject != null) && (((List)localObject).size() != 0)) {
            break label386;
          }
          i = 1;
          if ((localAppInfo.iNewFlag.get() == 0) && (i != 0)) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label396;
        }
        paramList2.add(str);
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
        break label66;
        paramList2.addAll(paramList1);
        return;
        i = 0;
        break label136;
        i = 1;
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    Object localObject = (GameCenterManagerImp)paramAppRuntime.getManager(QQManagerFactory.GAMECENTER_MANAGER);
    if (localObject != null) {
      ((GameCenterManagerImp)localObject).a();
    }
    localObject = new NewIntent(paramAppRuntime.getApplication(), GameCenterServlet.class);
    ((NewIntent)localObject).setAction("gc_refresh_ui");
    ((NewIntent)localObject).putExtra("gc_notify_type", 6);
    paramAppRuntime.startServlet((NewIntent)localObject);
    notifyUI(3, true, null);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    QLog.d("RedPointLog.RedpointHandler", 2, "getNewFlagOp:send redInfo start");
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 600);
    int j = localSharedPreferences.getInt("businessinfo_check_update_interval_lbsinfo_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 43200000);
    int k = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    int m = localSharedPreferences.getInt("businessinfo_last_check_lbsinfo_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    int n = (int)(System.currentTimeMillis() / 1000L);
    boolean bool = localSharedPreferences.getBoolean("redtouch_force", false);
    QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp:sendredInfo :systemTimestamp = " + n + ";lastUpdateTimestamp = " + k + ";updateInterval = " + i + ";updateLbsInterval = " + j + ";lastCheckLbsInfo = " + m + ";isDebugVersion = " + false);
    if ((!bool) && (!paramBoolean1) && (n - k <= i) && (n >= k)) {
      return;
    }
    localEditor.putInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), n);
    localEditor.putBoolean("redtouch_force", false);
    localEditor.apply();
    this.jdField_a_of_type_Int = paramInt;
    if ((BaseActivity.mAppForground) && (paramBoolean2) && ((n - m > j) || (n < k)))
    {
      localEditor.putInt("businessinfo_last_check_lbsinfo_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L)).commit();
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          a(-1, null, paramInt);
          return;
        }
        ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener);
        return;
      }
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener);
      return;
    }
    a(-1, null, paramInt);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return RedpointObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if ((MessageConstants.D.equals(paramFromServiceMsg.getServiceCmd())) && (i != 0)) {
        a(paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RedpointHandler
 * JD-Core Version:    0.7.0.1
 */