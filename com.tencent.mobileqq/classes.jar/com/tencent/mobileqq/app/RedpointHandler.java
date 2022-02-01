package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.INearbyNewRedDotManager;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
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
import com.tencent.mobileqq.service.message.MessageConstants;
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
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
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
    if (TextUtils.isEmpty(paramSosoLocation.cityCode)) {
      paramSosoLocation = "";
    } else {
      paramSosoLocation = paramSosoLocation.cityCode;
    }
    localLbsSubnation.code.set(paramSosoLocation);
    localLbsSubnation.nation.set("unknown");
    localLbsSubnation.province.set("unknown");
    localLbsSubnation.city.set("unknown");
    localLbsSubnation.district.set("unknown");
    localLbsDetailInfo.subnation.set(localLbsSubnation);
    localLbsInfo.detail_info.set(localLbsDetailInfo);
    return localLbsInfo;
  }
  
  public static List<RedPointHolder> a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramAppRuntime = LebaPluginInfo.getAll(((QQAppInterface)paramAppRuntime).getEntityManagerFactory().createEntityManager());
    if (paramAppRuntime == null) {
      return null;
    }
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
    HashSet localHashSet = jdField_a_of_type_JavaUtilHashSet;
    if (localHashSet == null) {
      return;
    }
    if (paramLong == 1113L)
    {
      localHashSet.add("1113.100800");
      jdField_a_of_type_JavaUtilHashSet.add("1113.100801");
      jdField_a_of_type_JavaUtilHashSet.add("1113.100802");
      jdField_a_of_type_JavaUtilHashSet.add("1113.100803");
      jdField_a_of_type_JavaUtilHashSet.add("1113.100804");
      return;
    }
    if (paramLong == 100001113L)
    {
      localHashSet.add("100600.100001113.100100800");
      jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100801");
      jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100802");
      jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100803");
      jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100804");
    }
  }
  
  private void a(BusinessInfoCheckUpdate.TimeReqBody paramTimeReqBody)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("req red pathlist:");
      if (paramTimeReqBody.rptMsgAppInfo.has())
      {
        int i = 0;
        while (i < paramTimeReqBody.rptMsgAppInfo.size())
        {
          localObject2 = ((BusinessInfoCheckUpdate.AppInfo)paramTimeReqBody.rptMsgAppInfo.get(i)).path.get();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(";");
          }
          i += 1;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getNewFlagOp rptMsginfoPath:");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("RedPointLog.RedpointHandler", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("req setting pathlist:");
    ((StringBuilder)localObject2).append("leba_study");
    if (paramTimeReqBody.rptSetting.has())
    {
      Iterator localIterator = paramTimeReqBody.rptSetting.get().iterator();
      while (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
        if (localAppSetting != null)
        {
          ((StringBuilder)localObject2).append("appid: ");
          boolean bool = localAppSetting.appid.has();
          localObject1 = "null";
          if (bool) {
            paramTimeReqBody = Integer.valueOf(localAppSetting.appid.get());
          } else {
            paramTimeReqBody = "null";
          }
          ((StringBuilder)localObject2).append(paramTimeReqBody);
          ((StringBuilder)localObject2).append("  setting:");
          if (localAppSetting.setting.has()) {
            paramTimeReqBody = Boolean.valueOf(localAppSetting.setting.get());
          } else {
            paramTimeReqBody = "null";
          }
          ((StringBuilder)localObject2).append(paramTimeReqBody);
          ((StringBuilder)localObject2).append(" modify_ts:");
          paramTimeReqBody = (BusinessInfoCheckUpdate.TimeReqBody)localObject1;
          if (localAppSetting.modify_ts.has()) {
            paramTimeReqBody = Long.valueOf(localAppSetting.modify_ts.get());
          }
          ((StringBuilder)localObject2).append(paramTimeReqBody);
          ((StringBuilder)localObject2).append(",");
        }
      }
    }
    paramTimeReqBody = new StringBuilder();
    paramTimeReqBody.append("getNewFlagOp setting:");
    paramTimeReqBody.append(((StringBuilder)localObject2).toString());
    QLog.d("RedPointLog.RedpointHandler", 1, paramTimeReqBody.toString());
    QLog.isColorLevel();
  }
  
  private void a(BusinessInfoCheckUpdate.TimeReqBody paramTimeReqBody, List<RedPointHolder> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1, List<String> paramList2)
  {
    if (paramList != null)
    {
      int i;
      if (paramList1 == null) {
        i = 0;
      } else {
        i = paramList1.size();
      }
      BusinessInfoCheckUpdate.AppSetting localAppSetting = null;
      int j = 0;
      while (j < paramList.size())
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(((RedPointHolder)paramList.get(j)).jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        int m = ((RedPointHolder)paramList.get(j)).jdField_a_of_type_Int;
        int k = 0;
        while (k < i)
        {
          localAppSetting = (BusinessInfoCheckUpdate.AppSetting)paramList1.get(k);
          if ((localAppSetting != null) && (m == localAppSetting.appid.get())) {
            break;
          }
          k += 1;
        }
        if ((k != i) && (localAppSetting != null)) {
          break label210;
        }
        localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
        localAppSetting.appid.set(m);
        localAppSetting.setting.set(true);
        localAppSetting.modify_ts.set(0L);
        label210:
        if (!localAppSetting.setting.get())
        {
          long l = ((RedPointHolder)paramList.get(j)).jdField_a_of_type_Long + 100000000L;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("100600.");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
          a(l);
        }
        else
        {
          a(((RedPointHolder)paramList.get(j)).jdField_a_of_type_Long);
        }
        paramTimeReqBody.rptSetting.add(localAppSetting);
        paramList2.add(localObject);
        j += 1;
      }
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
          localStringBuilder.append("appid = ");
          localStringBuilder.append(localAppInfo.uiAppId.get());
          localStringBuilder.append(" path = ");
          localStringBuilder.append(localAppInfo.path.get());
          localStringBuilder.append(" inewflag = ");
          localStringBuilder.append(localAppInfo.iNewFlag.get());
          localStringBuilder.append(" exposure_max = ");
          localStringBuilder.append(localAppInfo.exposure_max.get());
          localStringBuilder.append(" mission_level = ");
          localStringBuilder.append(localAppInfo.mission_level.get());
          localStringBuilder.append(" missions = ");
          localStringBuilder.append(localAppInfo.missions.get());
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
          localStringBuilder.append("numred appid = ");
          localStringBuilder.append(((BusinessInfoCheckUpdate.NumRedInfo)localObject).appid.get());
          localStringBuilder.append(" appset = ");
          localStringBuilder.append(((BusinessInfoCheckUpdate.NumRedInfo)localObject).appset.get());
          localStringBuilder.append(";");
        }
      }
    }
    QLog.d("RedPointLog.RedpointHandler", 1, localStringBuilder.toString());
  }
  
  private void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody, IRedTouchManager paramIRedTouchManager)
  {
    List localList1 = paramTimeRspBody.rptSetting.get();
    List localList2 = paramIRedTouchManager.requestSettingInfoList();
    paramIRedTouchManager = new ArrayList();
    if ((localList1 != null) && (localList2 != null))
    {
      int i = 0;
      while (i < localList1.size())
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localList1.get(i);
        int j = 0;
        while (j < localList2.size())
        {
          if (((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).appid.get() == localAppSetting.appid.get())
          {
            localList2.set(j, localAppSetting);
            j = 1;
            break label135;
          }
          j += 1;
        }
        j = 0;
        label135:
        if (j == 0) {
          paramIRedTouchManager.add(localAppSetting);
        }
        i += 1;
      }
      localList2.addAll(paramIRedTouchManager);
      paramIRedTouchManager = localList2;
    }
    else
    {
      paramIRedTouchManager = localList2;
      if (localList2 == null) {
        paramIRedTouchManager = localList1;
      }
    }
    paramTimeRspBody.rptSetting.set(paramIRedTouchManager);
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("RedPointLog.RedpointHandler", 1, "handleResponse data = null");
      return;
    }
    try
    {
      localObject = new BusinessInfoCheckUpdate.TimeRspBody();
      ((BusinessInfoCheckUpdate.TimeRspBody)localObject).mergeFrom((byte[])paramObject);
      paramObject = localObject;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      paramObject.printStackTrace();
      QLog.e("RedPointLog.RedpointHandler", 1, "mergeFrom failed");
      paramObject = null;
    }
    if (paramObject == null)
    {
      QLog.e("RedPointLog.RedpointHandler", 1, "handleResponse prb = null");
      return;
    }
    Object localObject = paramObject;
    if (paramObject.iResult.get() != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleResponse,return fail ,TimeRspBody result:");
      ((StringBuilder)localObject).append(paramObject.iResult.get());
      QLog.d("RedPointLog.RedpointHandler", 2, ((StringBuilder)localObject).toString());
      if (paramObject.iResult.get() == 104005) {
        localObject = new BusinessInfoCheckUpdate.TimeRspBody();
      } else {
        return;
      }
    }
    QLog.i("RedPointLog.RedpointHandler", 1, "handleResponse");
    b((BusinessInfoCheckUpdate.TimeRspBody)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    try
    {
      if (!a((BusinessInfoCheckUpdate.TimeRspBody)localObject, paramObject)) {
        return;
      }
      a((BusinessInfoCheckUpdate.TimeRspBody)localObject, paramObject);
      a((BusinessInfoCheckUpdate.TimeRspBody)localObject);
    }
    catch (Exception localException)
    {
      QLog.i("RedPointLog.RedpointHandler", 2, "handleResponse", localException);
    }
    paramObject.saveTimeRepBody((BusinessInfoCheckUpdate.TimeRspBody)localObject);
    c((BusinessInfoCheckUpdate.TimeRspBody)localObject);
    paramObject.resetFlag();
    paramObject.reportRedTouchsArrived((BusinessInfoCheckUpdate.TimeRspBody)localObject);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return false;
    }
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("100600.");
        ((StringBuilder)localObject2).append(l + 100000000L);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((RedPointHolder)((List)localObject1).get(i)).jdField_a_of_type_Long);
        localStringBuilder.append("");
        if (!localStringBuilder.toString().equals(paramAppInfo.path.get()))
        {
          if (((String)localObject2).equals(paramAppInfo.path.get())) {
            return true;
          }
          localObject2 = jdField_a_of_type_JavaUtilHashSet;
          if ((localObject2 != null) && (((HashSet)localObject2).contains(paramAppInfo.path.get()))) {
            return true;
          }
          i += 1;
        }
        else
        {
          return true;
        }
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
    return false;
  }
  
  private boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody, IRedTouchManager paramIRedTouchManager)
  {
    if (paramTimeRspBody.rptMsgAppInfo.has())
    {
      Iterator localIterator = paramTimeRspBody.rptMsgAppInfo.get().iterator();
      while (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        if (localAppInfo != null)
        {
          Object localObject;
          if ((!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localAppInfo)) && (1 == localAppInfo.iNewFlag.get()))
          {
            localAppInfo.modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            localAppInfo.iNewFlag.set(0);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("verifyDataCorrect,return false ,appInfo.path.get():");
              ((StringBuilder)localObject).append(localAppInfo.path.get());
              QLog.d("RedPointLog.RedpointHandler", 2, ((StringBuilder)localObject).toString());
            }
          }
          if (localAppInfo.use_cache.get())
          {
            localObject = paramIRedTouchManager.getAppInfoByPath(localAppInfo.path.get());
            if (localObject != null) {
              localAppInfo.buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject).buffer.get());
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
        paramIRedTouchManager = ((BusinessInfoCheckUpdate.NumRedInfo)paramTimeRspBody.next()).num_red_path.get();
        if (paramIRedTouchManager != null)
        {
          int i = 0;
          while (i < paramIRedTouchManager.size())
          {
            ((BusinessInfoCheckUpdate.NumRedPath)paramIRedTouchManager.get(i)).uint32_push_num_red_ts.set((int)(System.currentTimeMillis() / 1000L));
            i += 1;
          }
        }
      }
    }
    return true;
  }
  
  private void b(int paramInt1, SosoLbsInfo paramSosoLbsInfo, int paramInt2)
  {
    QLog.d("RedPointLog.RedpointHandler", 1, "sendReq start");
    BusinessInfoCheckUpdate.TimeReqBody localTimeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
    localTimeReqBody.iProtocolVer.set(1);
    localTimeReqBody.uiClientPlatID.set(109);
    localTimeReqBody.sClientVer.set("8.7.0.5295");
    localTimeReqBody.uiUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localTimeReqBody.uReqType.set(paramInt2);
    paramInt2 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    localTimeReqBody.uiNetType.set(paramInt2);
    if ((paramInt1 == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramSosoLbsInfo = a(paramSosoLbsInfo.mLocation);
      if (paramSosoLbsInfo != null) {
        localTimeReqBody.lbs.set(paramSosoLbsInfo);
      }
    }
    Object localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramSosoLbsInfo = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    Object localObject2 = paramSosoLbsInfo.requestSettingInfoList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    a(localTimeReqBody, (List)localObject1, (List)localObject2, localArrayList1);
    localArrayList1.addAll(jdField_a_of_type_JavaUtilHashSet);
    localObject1 = paramSosoLbsInfo.getRegisterInterfaces().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)((Iterator)localObject1).next();
      if (localObject2 != null) {
        try
        {
          if (((BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localObject2).getRedPointPaths(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) {
            localArrayList1.addAll(((BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localObject2).getRedPointPaths(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          }
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("add exception error");
          localStringBuilder.append(localException);
          QLog.e("RedPointLog.RedpointHandler", 1, localStringBuilder.toString());
        }
      }
    }
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < ALL_PLUGITEM.length)
    {
      localArrayList1.add(ALL_PLUGITEM[paramInt1][1]);
      paramInt1 += 1;
    }
    localObject1 = paramSosoLbsInfo.requestAppInfoListByAppSet(3);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList1.add(((BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject1).next()).path.get());
      }
    }
    if (paramSosoLbsInfo.getLocalTimeRspBody() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointLog.RedpointHandler", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      localArrayList2.addAll(localArrayList1);
    }
    else
    {
      a(paramSosoLbsInfo, localArrayList1, localArrayList2, localArrayList3);
    }
    localTimeReqBody.rptMsgAppInfo.set(localArrayList3);
    localTimeReqBody.rptNoRedPath.set(localArrayList2);
    localTimeReqBody.sQimei.set(String.valueOf(UserAction.getQIMEI()));
    paramSosoLbsInfo = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    localTimeReqBody.rptIdList.set(paramSosoLbsInfo.c());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mIsShowNewLeba) {
      localTimeReqBody.bHebaFlag.set(true);
    } else {
      localTimeReqBody.bHebaFlag.set(false);
    }
    if ((!((IFontManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFontManagerService.class, "")).isSupportFont()) && (localTimeReqBody.rptMsgAppInfo.has()))
    {
      paramInt1 = paramInt2;
      while (paramInt1 < localTimeReqBody.rptMsgAppInfo.size())
      {
        if ("100005.100011".equals(((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt1)).path.get()))
        {
          localTimeReqBody.rptMsgAppInfo.remove(paramInt1);
          break;
        }
        paramInt1 += 1;
      }
    }
    a(localTimeReqBody);
    QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp local message ok");
    try
    {
      paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), MessageConstants.D);
      paramSosoLbsInfo.putWupBuffer(localTimeReqBody.toByteArray());
      sendPbReq(paramSosoLbsInfo);
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      QLog.e("RedPointLog.RedpointHandler", 1, "error send request ", paramSosoLbsInfo);
    }
  }
  
  private void b(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    int i = 0;
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences("check_update_sp_key", 0).edit();
    if (paramTimeRspBody.iInterval.has())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("businessinfo_check_update_interval_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject2).toString();
      if (paramTimeRspBody.iInterval.get() > 0) {
        i = paramTimeRspBody.iInterval.get();
      }
      ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, i);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("businessinfo_check_update_interval_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("businessinfo_check_update_interval_lbsinfo_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramTimeRspBody.iLbsInterval.get());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleResponse, iInterval = ");
    ((StringBuilder)localObject2).append(paramTimeRspBody.iInterval.get());
    ((StringBuilder)localObject2).append("; lbsInterval = ");
    ((StringBuilder)localObject2).append(paramTimeRspBody.iLbsInterval.get());
    QLog.d("RedPointLog.RedpointHandler", 1, ((StringBuilder)localObject2).toString());
    paramTimeRspBody = new StringBuilder();
    paramTimeRspBody.append("businessinfo_last_check_update_timestamp_");
    paramTimeRspBody.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((SharedPreferences.Editor)localObject1).putInt(paramTimeRspBody.toString(), (int)(System.currentTimeMillis() / 1000L));
    ((SharedPreferences.Editor)localObject1).apply();
  }
  
  private void c(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    Object localObject1;
    Object localObject2;
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
          if (((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.get() == 769)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reader_zone_appinfo_last_pull_timestamp_");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)).apply();
          }
        }
        i += 1;
      }
    }
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
      ((INearbyNewRedDotManager)QRoute.api(INearbyNewRedDotManager.class)).queryNearbyMsgInfos(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPointLog.RedpointHandler", 2, "individuation jump open");
    }
    if (paramTimeRspBody.rptSetting.get() != null)
    {
      localObject3 = new StringBuilder("switch ");
      ((StringBuilder)localObject3).append("leba_study");
      Iterator localIterator = paramTimeRspBody.rptSetting.get().iterator();
      while (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
        if (localAppSetting != null)
        {
          ((StringBuilder)localObject3).append("appid: ");
          boolean bool = localAppSetting.appid.has();
          localObject2 = "null";
          if (bool) {
            localObject1 = Integer.valueOf(localAppSetting.appid.get());
          } else {
            localObject1 = "null";
          }
          ((StringBuilder)localObject3).append(localObject1);
          ((StringBuilder)localObject3).append("  setting:");
          if (localAppSetting.setting.has()) {
            localObject1 = Boolean.valueOf(localAppSetting.setting.get());
          } else {
            localObject1 = "null";
          }
          ((StringBuilder)localObject3).append(localObject1);
          ((StringBuilder)localObject3).append(" modify_ts:");
          localObject1 = localObject2;
          if (localAppSetting.modify_ts.has()) {
            localObject1 = Long.valueOf(localAppSetting.modify_ts.get());
          }
          ((StringBuilder)localObject3).append(localObject1);
          ((StringBuilder)localObject3).append(",");
        }
      }
      QLog.i("RedPointLog.RedpointHandler", 1, ((StringBuilder)localObject3).toString());
      localObject1 = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
      if (localObject1 != null) {
        ((ILebaHelperService)localObject1).updateAllLebaListFlag(paramTimeRspBody.rptSetting.get());
      } else {
        QLog.d("RedPointLog.RedpointHandler", 1, "processExtraData lebaHelperService == null");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedPointLog.RedpointHandler", 2, "update NearbyNumAppinfo");
    }
    ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).updateNearbyNumAppinfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("forceSendReq fromSrc:");
    localStringBuilder.append(paramInt);
    QLog.d("RedPointLog.RedpointHandler", 1, localStringBuilder.toString());
    a(-1, null, 6);
  }
  
  protected void a(IRedTouchManager paramIRedTouchManager, List<String> paramList1, List<String> paramList2, List<BusinessInfoCheckUpdate.AppInfo> paramList)
  {
    paramIRedTouchManager = paramIRedTouchManager.getLocalTimeRspBody();
    int i;
    if ((paramIRedTouchManager != null) && (paramIRedTouchManager.rptMsgAppInfo.has())) {
      i = 0;
    }
    while (i < paramList1.size())
    {
      String str = (String)paramList1.get(i);
      if (!TextUtils.isEmpty(str))
      {
        int j = 0;
        int k;
        for (;;)
        {
          int n = paramIRedTouchManager.rptMsgAppInfo.size();
          int m = 1;
          k = m;
          if (j >= n) {
            break;
          }
          BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)paramIRedTouchManager.rptMsgAppInfo.get(j);
          if (str.equals(localAppInfo.path.get()))
          {
            Object localObject = localAppInfo.missions.get();
            if ((localObject != null) && (((List)localObject).size() != 0)) {
              j = 0;
            } else {
              j = 1;
            }
            if ((localAppInfo.iNewFlag.get() == 0) && (j != 0))
            {
              k = m;
              break;
            }
            localObject = new BusinessInfoCheckUpdate.AppInfo();
            ((BusinessInfoCheckUpdate.AppInfo)localObject).path.set(localAppInfo.path.get());
            ((BusinessInfoCheckUpdate.AppInfo)localObject).uiAppId.set(localAppInfo.uiAppId.get());
            ((BusinessInfoCheckUpdate.AppInfo)localObject).buffer.set(localAppInfo.buffer.get());
            ((BusinessInfoCheckUpdate.AppInfo)localObject).modify_ts.set(localAppInfo.modify_ts.get());
            ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.set(localAppInfo.iNewFlag.get());
            ((BusinessInfoCheckUpdate.AppInfo)localObject).type.set(localAppInfo.type.get());
            ((BusinessInfoCheckUpdate.AppInfo)localObject).push_red_ts.set(localAppInfo.push_red_ts.get());
            ((BusinessInfoCheckUpdate.AppInfo)localObject).mission_level.set(localAppInfo.mission_level.get());
            j = 0;
            while (j < localAppInfo.missions.size())
            {
              ((BusinessInfoCheckUpdate.AppInfo)localObject).missions.add(localAppInfo.missions.get(j));
              j += 1;
            }
            paramList.add(localObject);
            k = 0;
            break;
          }
          j += 1;
        }
        if (k != 0) {
          paramList2.add(str);
        }
      }
      i += 1;
      continue;
      paramList2.addAll(paramList1);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), GameCenterServlet.class);
    localNewIntent.setAction("gc_refresh_ui");
    localNewIntent.putExtra("gc_notify_type", 6);
    paramAppRuntime.startServlet(localNewIntent);
    notifyUI(3, true, null);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    QLog.d("RedPointLog.RedpointHandler", 2, "getNewFlagOp:send redInfo start");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_check_update_interval_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 600);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_check_update_interval_lbsinfo_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int j = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 43200000);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_last_check_update_timestamp_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int k = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_last_check_lbsinfo_timestamp_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int m = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    int n = (int)(System.currentTimeMillis() / 1000L);
    boolean bool = ((SharedPreferences)localObject).getBoolean("redtouch_force", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getNewFlagOp:sendredInfo :systemTimestamp = ");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(";lastUpdateTimestamp = ");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(";updateInterval = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(";updateLbsInterval = ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(";lastCheckLbsInfo = ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(";isDebugVersion = ");
    ((StringBuilder)localObject).append(false);
    QLog.d("RedPointLog.RedpointHandler", 1, ((StringBuilder)localObject).toString());
    if ((!bool) && (!paramBoolean1) && (n - k <= i) && (n >= k)) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("businessinfo_last_check_update_timestamp_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(((StringBuilder)localObject).toString(), n);
    localEditor.putBoolean("redtouch_force", false);
    localEditor.apply();
    this.jdField_a_of_type_Int = paramInt;
    if ((BaseActivity.mAppForground) && (paramBoolean2) && ((n - m > j) || (n < k)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("businessinfo_last_check_lbsinfo_timestamp_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localEditor.putInt(((StringBuilder)localObject).toString(), (int)(System.currentTimeMillis() / 1000L)).commit();
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
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((MessageConstants.D.equals(paramFromServiceMsg.getServiceCmd())) && (i != 0)) {
      a(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.RedpointHandler
 * JD-Core Version:    0.7.0.1
 */