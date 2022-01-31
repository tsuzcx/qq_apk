import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager;
import com.tencent.mobileqq.redtouch.RedTouchManager.1;
import com.tencent.mobileqq.redtouch.RedTouchManager.2;
import com.tencent.mobileqq.redtouch.RedTouchManager.3;
import com.tencent.mobileqq.redtouch.RedTouchManager.4;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xd40.DeviceInfo;
import tencent.im.oidb.cmd0xd40.ReqBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class avpq
  extends Observable
  implements Manager
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private static Object b = new Object();
  protected long a;
  public AppInterface a;
  private RedTouchLifeTimeManager jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager;
  protected BusinessInfoCheckUpdate.TimeRspBody a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected String a;
  public boolean a;
  
  public avpq(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager = RedTouchLifeTimeManager.a();
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      a("input path is empty");
    }
    do
    {
      return -1;
      if (!paramString.contains(".")) {
        break;
      }
      paramString = paramString.split("\\.");
    } while ((paramString == null) || (paramString.length <= 0));
    int i;
    try
    {
      i = Integer.parseInt(paramString[(paramString.length - 1)]);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      return -1;
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private BusinessInfoCheckUpdate.NumRedInfo a(int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject1 = a();
        if ((localObject1 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.has()))
        {
          localObject1 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.get();
          if (localObject1 == null)
          {
            a("getNumRedShowNumByAppSet : numRedBusiList is null");
            return null;
          }
          Iterator localIterator = ((List)localObject1).iterator();
          if (localIterator.hasNext())
          {
            localObject1 = (BusinessInfoCheckUpdate.NumRedInfo)localIterator.next();
            if (paramInt != ((BusinessInfoCheckUpdate.NumRedInfo)localObject1).appid.get()) {
              continue;
            }
            if (localObject1 == null)
            {
              a("getNumRedBusiInfoByAppId : cannot find the info by appid");
              return null;
            }
            return localObject1;
          }
        }
      }
      Object localObject3 = null;
    }
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramString);
  }
  
  public static String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder = actn.a().append(paramAppInfo.path.get()).append(":");
    paramAppInfo = RedTouchTextView.a(paramAppInfo);
    if (paramAppInfo != null)
    {
      paramAppInfo = paramAppInfo.iterator();
      while (paramAppInfo.hasNext()) {
        localStringBuilder.append(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next()).red_type.get()).append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody == null) || (!localTimeRspBody.rptMsgNumRedInfo.has())) {
          break label222;
        }
        Object localObject3 = localTimeRspBody.rptMsgNumRedInfo.get();
        if (localObject3 == null)
        {
          a("getNumFromFileByPathAndType : numRedBusiList is null");
          return;
        }
        localObject3 = ((List)localObject3).iterator();
        int i = 0;
        j = i;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject3).next();
          if (((BusinessInfoCheckUpdate.NumRedInfo)localObject4).appid.get() != paramInt1) {
            continue;
          }
          localObject4 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject4).num_red_path.get();
          if (localObject4 == null) {
            continue;
          }
          j = 0;
          if (j < ((List)localObject4).size())
          {
            if (((BusinessInfoCheckUpdate.NumRedPath)((List)localObject4).get(j)).uint64_msgid.get() != paramInt2) {
              break label213;
            }
            ((BusinessInfoCheckUpdate.NumRedPath)((List)localObject4).get(j)).uint32_msg_status.set(paramInt3);
            i = 1;
            break label210;
          }
        }
        else
        {
          if (j != 0) {
            a(localTimeRspBody);
          }
          return;
        }
      }
      label210:
      continue;
      label213:
      j += 1;
      continue;
      label222:
      int j = 0;
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramInt == 6) {
      bhdv.a().a(paramAppInfo, 102);
    }
    while (paramInt != 1) {
      return;
    }
    bhdv.a().a(paramAppInfo, 101);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = a(paramAppInfo.uiAppId.get());
      if (localObject2 == null) {
        return;
      }
      localObject3 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get();
      if (localObject3 == null)
      {
        a("onReportShowMsgs : NumRedPaths is null");
        return;
      }
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject3).next();
      ((List)localObject2).add(Long.valueOf(localNumRedPath.uint64_msgid.get()));
      if (paramBoolean) {
        a(paramAppInfo.uiAppId.get(), (int)localNumRedPath.uint64_msgid.get(), paramInt2);
      }
    }
    a(paramAppInfo, paramInt1, false, null, (List)localObject2, paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, String paramString1, boolean paramBoolean, List<Long> paramList, List<String> paramList1, String paramString2)
  {
    QLog.i("RedPointManage", 1, String.format("onReportSync id = %s type = %d", new Object[] { paramAppInfo.path.get(), Integer.valueOf(paramInt) }));
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.2.8.4440");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(a(paramAppInfo.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(paramInt);
    if (paramAppInfo.extend.has()) {
      localReportReqBody.extend.set(paramAppInfo.extend.get());
    }
    if (paramList != null) {
      localReportReqBody.msgids.set(paramList);
    }
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).q) {
        localReportReqBody.bHebaFlag.set(true);
      }
    }
    else if (paramBoolean)
    {
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break label431;
      }
      localReportReqBody.missionid.set(paramList1);
    }
    for (;;)
    {
      paramList = new ArrayList();
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramList1 = new JSONObject(paramString2);
          if (paramList1 != null)
          {
            paramString2 = paramList1.keys();
            while (paramString2.hasNext())
            {
              String str = (String)paramString2.next();
              BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
              localReportStaticsData.key.set(str);
              localReportStaticsData.value.set(paramList1.getString(str));
              paramList.add(localReportStaticsData);
            }
          }
        }
        localReportReqBody.bHebaFlag.set(false);
      }
      catch (JSONException paramList1)
      {
        QLog.e("RedPointManage", 2, "onReportSync parse json exception ", paramList1);
        if (!TextUtils.isEmpty(paramString1)) {
          localReportReqBody.buffer.set(paramString1);
        }
        localReportReqBody.reportdata.set(paramList);
        paramString1 = a("RedTouchSvc.ClientReport");
        paramString1.putWupBuffer(localReportReqBody.toByteArray());
        a(paramString1);
        a(paramAppInfo, paramInt);
        return;
      }
      break;
      label431:
      if (paramAppInfo.missions.has()) {
        localReportReqBody.missionid.set(paramAppInfo.missions.get());
      }
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, String paramString)
  {
    a(paramAppInfo, paramInt, paramBoolean, paramList, null, paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, List<Long> paramList1, String paramString)
  {
    a(paramAppInfo, paramInt, paramBoolean, paramList, paramList1, paramString, null);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, List<Long> paramList1, String paramString1, String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new RedTouchManager.4(this, paramAppInfo, paramInt, paramString2, paramBoolean, paramList1, paramList, paramString1), 2, null, true);
      return;
    }
    a(paramAppInfo, paramInt, paramString2, paramBoolean, paramList1, paramList, paramString1);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "onRedTouchItemClick path = " + paramString1);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (paramAppInfo.iNewFlag.get() == 1) {
      localSharedPreferences.edit().putString("lastClickPath", paramString1).commit();
    }
    for (;;)
    {
      if (!paramString1.contains("."))
      {
        this.jdField_a_of_type_JavaLangString = paramString1;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      e(paramAppInfo, paramString2);
      b(paramAppInfo);
      a(paramString1, false);
      setChanged();
      if (i != 0) {
        akfi.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      return;
      localSharedPreferences.edit().putString("lastClickPath", "").commit();
      i = 0;
    }
  }
  
  private void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    ThreadManagerV2.excute(new RedTouchManager.2(this, paramTimeRspBody), 64, null, true);
  }
  
  private final void a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg == null) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).sendToService(paramToServiceMsg);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, paramString);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "setNewStatusByID,path = " + paramString);
    }
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody != null) && (localTimeRspBody.rptMsgAppInfo.has()))
        {
          i = 0;
          if (i < localTimeRspBody.rptMsgAppInfo.size())
          {
            Object localObject = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
            if (!paramString.equals(((BusinessInfoCheckUpdate.AppInfo)localObject).path.get())) {
              break label253;
            }
            if ((((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1) && (!paramBoolean)) {
              ((BusinessInfoCheckUpdate.AppInfo)localObject).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            }
            PBInt32Field localPBInt32Field = ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag;
            if (paramBoolean) {
              j = 1;
            }
            localPBInt32Field.set(j);
            localTimeRspBody.rptMsgAppInfo.set(i, (MessageMicro)localObject);
            localObject = (axbt)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(12);
            if (localObject != null) {
              ((axbt)localObject).a(paramString);
            }
          }
        }
        a(localTimeRspBody);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("RedPointManage", 1, "updateNewFlagByPath: " + paramString, localException);
        return;
      }
      label253:
      i += 1;
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences("redTouchPref", 4);
    } while (paramContext == null);
    paramContext.edit().putBoolean("isCacheChange", paramBoolean).commit();
  }
  
  private boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    return false;
  }
  
  private boolean a(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    if (paramNumRedBusiInfo == null) {}
    while ((paramNumRedBusiInfo.uint32_plat_id.get() != 109) && (paramNumRedBusiInfo.uint32_plat_id.get() != 109110)) {
      return false;
    }
    return true;
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int j = 0;
    label227:
    label233:
    label238:
    label244:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = a();
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
          {
            localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
            if (localObject2 == null)
            {
              a("getNumFromFileByPathAndType : numRedBusiList is null");
              return 0;
            }
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject2).hasNext()) {
              break label244;
            }
            Object localObject4 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
            if (((BusinessInfoCheckUpdate.NumRedInfo)localObject4).appid.get() != paramInt1) {
              continue;
            }
            localObject4 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject4).num_red_path.get();
            if (localObject4 == null) {
              continue;
            }
            localObject4 = ((List)localObject4).iterator();
            j = i;
            i = j;
            if (!((Iterator)localObject4).hasNext()) {
              continue;
            }
            BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject4).next();
            if (100 == paramInt2)
            {
              if (localNumRedPath.uint32_msg_status.get() == 0) {
                break label233;
              }
              if (1 != localNumRedPath.uint32_msg_status.get()) {
                break label227;
              }
              break label233;
            }
            if (localNumRedPath.uint32_msg_status.get() != paramInt2) {
              break label227;
            }
            i = j + 1;
            break label238;
          }
        }
        return i;
      }
      int i = j;
      break label238;
      i = j + 1;
      j = i;
    }
  }
  
  /* Error */
  private int b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 35	avpq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   7: astore 5
    //   9: aload 5
    //   11: monitorenter
    //   12: aload_1
    //   13: ifnonnull +8 -> 21
    //   16: aload 5
    //   18: monitorexit
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 78	avpq:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody;
    //   25: astore 6
    //   27: iload 4
    //   29: istore_3
    //   30: aload 6
    //   32: ifnull +196 -> 228
    //   35: iload 4
    //   37: istore_3
    //   38: aload 6
    //   40: getfield 84	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   43: invokevirtual 90	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   46: ifeq +182 -> 228
    //   49: aload 6
    //   51: getfield 84	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   54: invokevirtual 94	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   57: astore 6
    //   59: aload 6
    //   61: ifnonnull +19 -> 80
    //   64: ldc 188
    //   66: invokestatic 52	avpq:a	(Ljava/lang/String;)V
    //   69: aload 5
    //   71: monitorexit
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: aload 5
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: aload 6
    //   82: invokeinterface 102 1 0
    //   87: astore 6
    //   89: iconst_0
    //   90: istore_3
    //   91: aload 6
    //   93: invokeinterface 107 1 0
    //   98: ifeq +152 -> 250
    //   101: aload 6
    //   103: invokeinterface 111 1 0
    //   108: checkcast 113	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo
    //   111: getfield 191	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo:num_red_path	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   114: invokevirtual 94	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   117: astore 7
    //   119: aload 7
    //   121: ifnull -30 -> 91
    //   124: aload 7
    //   126: invokeinterface 102 1 0
    //   131: astore 7
    //   133: iload_3
    //   134: istore 4
    //   136: iload 4
    //   138: istore_3
    //   139: aload 7
    //   141: invokeinterface 107 1 0
    //   146: ifeq -55 -> 91
    //   149: aload 7
    //   151: invokeinterface 111 1 0
    //   156: checkcast 199	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath
    //   159: astore 8
    //   161: aload 8
    //   163: getfield 592	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath:str_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: invokevirtual 159	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   169: aload_1
    //   170: invokevirtual 547	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq -37 -> 136
    //   176: bipush 100
    //   178: iload_2
    //   179: if_icmpne +29 -> 208
    //   182: aload 8
    //   184: getfield 211	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   187: invokevirtual 122	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   190: ifeq +49 -> 239
    //   193: iconst_1
    //   194: aload 8
    //   196: getfield 211	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   199: invokevirtual 122	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   202: if_icmpne +31 -> 233
    //   205: goto +34 -> 239
    //   208: aload 8
    //   210: getfield 211	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   213: invokevirtual 122	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   216: iload_2
    //   217: if_icmpne +16 -> 233
    //   220: iload 4
    //   222: iconst_1
    //   223: iadd
    //   224: istore_3
    //   225: goto +19 -> 244
    //   228: aload 5
    //   230: monitorexit
    //   231: iload_3
    //   232: ireturn
    //   233: iload 4
    //   235: istore_3
    //   236: goto +8 -> 244
    //   239: iload 4
    //   241: iconst_1
    //   242: iadd
    //   243: istore_3
    //   244: iload_3
    //   245: istore 4
    //   247: goto -111 -> 136
    //   250: goto -22 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	avpq
    //   0	253	1	paramString	String
    //   0	253	2	paramInt	int
    //   29	216	3	i	int
    //   1	245	4	j	int
    //   7	222	5	localObject1	Object
    //   117	33	7	localObject3	Object
    //   159	50	8	localNumRedPath	BusinessInfoCheckUpdate.NumRedPath
    // Exception table:
    //   from	to	target	type
    //   16	19	74	finally
    //   21	27	74	finally
    //   38	59	74	finally
    //   64	72	74	finally
    //   75	78	74	finally
    //   80	89	74	finally
    //   91	119	74	finally
    //   124	133	74	finally
    //   139	176	74	finally
    //   182	205	74	finally
    //   208	220	74	finally
    //   228	231	74	finally
  }
  
  private BusinessInfoCheckUpdate.AppInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("getRedTouchAppInfoByPath: input path is Empty");
      return null;
    }
    Object localObject2 = a();
    if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
    {
      a("TimeRspBody is Empty or msgAppInfo is Empty path = " + paramString);
      return c(paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
        if (localAppInfo.path.get().equals(paramString))
        {
          a("getRedTouchAppInfoByPath path = " + paramString + "inewflag = " + localAppInfo.iNewFlag.get());
          return localAppInfo;
        }
      }
    }
    return c(paramString);
  }
  
  private void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (!TextUtils.equals(paramAppInfo.path.get(), "826"))) {
      return;
    }
    if (!TextUtils.isEmpty(paramAppInfo.icon_url.get())) {}
    for (int i = 1;; i = 2)
    {
      axqw.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00899", "Grp_tribe", "", "dynamic", "Clk_tribe", 0, 0, i + "", "", "", "");
      paramAppInfo = new cmd0xd40.ReqBody();
      paramAppInfo.src.set(1);
      paramAppInfo.event.set(2);
      paramAppInfo.redtype.set(i);
      paramAppInfo.dev.uint32_os.set(2);
      a(pow.a("OidbSvc.0xd40_0", 3392, 0, paramAppInfo.toByteArray()));
      return;
    }
  }
  
  private void b(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody = paramTimeRspBody;
      return;
    }
  }
  
  private BusinessInfoCheckUpdate.AppInfo c(String paramString)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    return localAppInfo;
  }
  
  private void c()
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if (!localFile.exists()) {
      a("BusinessInfoCheckUpdateItem pb file does not exist");
    }
    try
    {
      localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          byte[] arrayOfByte = bbdj.a(localFile);
          if (arrayOfByte != null) {
            break;
          }
          a("Can not translate BusinessInfoCheckUpdateItem pb file to byte");
          return;
        }
        finally {}
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
    try
    {
      localTimeRspBody.mergeFrom(localIOException);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody = localTimeRspBody;
        a(false, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    a("handler after push");
    Object localObject = null;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    }
    if (localObject == null) {
      return;
    }
    if (BaseActivity.mAppForground)
    {
      ((akfi)((QQAppInterface)localObject).a(87)).a(true, true);
      return;
    }
    localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("check_update_sp_key", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("redtouch_force", true);
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  private void d(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {}
    while (paramAppInfo.iNewFlag.get() == 0) {
      return;
    }
    a(paramAppInfo, 1, true, null, paramString);
  }
  
  private void d(String paramString)
  {
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody != null) && (localTimeRspBody.rptMsgAppInfo.has()))
        {
          i = 0;
          if (i < localTimeRspBody.rptMsgAppInfo.size())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
            if (!paramString.equals(localAppInfo.path.get())) {
              break label168;
            }
            localAppInfo.exposure_max.set(localAppInfo.exposure_max.get() - 1);
            if (localAppInfo.exposure_max.get() < 0)
            {
              localAppInfo.iNewFlag.set(0);
              QLog.d("RedPointManage", 2, "updateMaxExposeTimes less than 0 ");
            }
          }
        }
        a(localTimeRspBody);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("RedPointManage", 1, "updateNewFlagByPath: " + paramString, localException);
        return;
      }
      label168:
      i += 1;
    }
  }
  
  private void e(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (paramAppInfo.iNewFlag.get() == 0)
    {
      a(paramAppInfo, 6, false, null, paramString);
      return;
    }
    a(paramAppInfo, 6, true, null, paramString);
  }
  
  public int a(int paramInt)
  {
    a("getExtraNumRedTotalNum appId = " + paramInt);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(paramInt);
      if (localNumRedInfo == null)
      {
        a("getNumFromFileByAppid : cannot find the info by appid");
        return 0;
      }
      paramInt = localNumRedInfo.red_total_num.get();
      return paramInt;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    a("getExtraNumRedTotalNum appId = " + paramInt1);
    return b(paramInt1, paramInt2);
  }
  
  public int a(int paramInt, boolean paramBoolean, long paramLong)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
        localAppSetting.appid.set(paramInt);
        localAppSetting.setting.set(paramBoolean);
        localAppSetting.modify_ts.set(paramLong);
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody != null) && ((localTimeRspBody.has()) || (localTimeRspBody.rptSetting.has())))
        {
          List localList = localTimeRspBody.rptSetting.get();
          int j = localList.size();
          i = 0;
          if (i < j)
          {
            if (paramInt == ((BusinessInfoCheckUpdate.AppSetting)((BusinessInfoCheckUpdate.AppSetting)localList.get(i)).get()).appid.get()) {
              localList.set(i, localAppSetting);
            }
          }
          else
          {
            if (i == j) {
              localList.add(localAppSetting);
            }
            a(localTimeRspBody);
            return 0;
          }
        }
        else
        {
          localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
          localTimeRspBody.rptSetting.add(localAppSetting);
          a(localTimeRspBody);
        }
      }
      i += 1;
    }
  }
  
  public int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramAppInfo != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!paramAppInfo.path.has())
        {
          a("updateAppInfo failed , appInfo is empty or appInfo path is null");
          return -3;
        }
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if (localTimeRspBody == null)
        {
          a("updateAppInfo failed,TimeRspBody is Empty");
          return -3;
        }
        List localList = localTimeRspBody.rptMsgAppInfo.get();
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (paramAppInfo.path.get().equals(((BusinessInfoCheckUpdate.AppInfo)localList.get(i)).path.get()))
          {
            a("path is same = " + paramAppInfo.path);
            localList.set(i, paramAppInfo);
          }
        }
        else
        {
          if (i == j)
          {
            if (paramBoolean) {
              localTimeRspBody.rptMsgAppInfo.add(paramAppInfo);
            }
          }
          else
          {
            a(localTimeRspBody);
            return 0;
          }
          return -3;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    return b(paramString, paramInt);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramString, paramInt3, true);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramString, paramInt3, true, "");
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean, String paramString2)
  {
    paramString1 = c(paramString1);
    paramString1.uiAppId.set(paramInt2);
    paramString1.type.set(5);
    paramString1.iNewFlag.set(1);
    paramString1.appset.set(paramInt1);
    paramString1.mission_level.set(0);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.extend.set(paramString2);
    }
    paramString2 = new BusinessInfoCheckUpdate.RedDisplayInfo();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(9);
    localRedTypeInfo.red_content.set("-1");
    localRedTypeInfo.red_desc.set("");
    paramString2.red_type_info.add(localRedTypeInfo);
    localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(5);
    localRedTypeInfo.red_content.set(paramInt3 + "");
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    paramString2.tab_display_info.set(localRedTypeInfo);
    paramString2.red_type_info.add(localRedTypeInfo);
    paramString1.red_display_info.set(paramString2);
    if (paramBoolean)
    {
      a(paramString1, true);
      akfi.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    return paramString1;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("input path is Empty");
      return null;
    }
    a("getAppInfoByPath path = " + paramString);
    int i = b(paramString, 100);
    if (i > 0)
    {
      int j = Integer.parseInt(paramString.split("\\.")[0]);
      BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(j);
      String str = "";
      if (localNumRedInfo != null) {
        str = localNumRedInfo.extend.get();
      }
      return a(paramInt, j, paramString, i, false, str);
    }
    return b(paramString);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("input path is Empty");
      return null;
    }
    a("getAppInfoByPath path = " + paramString);
    return b(paramString);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt)
  {
    List localList1 = b(paramInt);
    Object localObject4;
    if ((localList1 == null) || (localList1.size() == 0))
    {
      localObject4 = null;
      return localObject4;
    }
    List localList2 = a();
    Object localObject2 = null;
    Object localObject1 = null;
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("getRedTouchInfoByAppSet:redpoint path List:");
    int i = 0;
    label62:
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (i < localList1.size())
    {
      localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
      if (localAppInfo.mission_level.get() != 0)
      {
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
    }
    for (;;)
    {
      i += 1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break label62;
      Object localObject5 = localObject2;
      if (999999 != localAppInfo.uiAppId.get())
      {
        if (localAppInfo.path.get().contains("."))
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        if (localAppInfo.iNewFlag.get() != 1)
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        if (((paramInt == 0) || (paramInt == 1)) && (localAppInfo.exposure_max.get() <= 0))
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        int j = 0;
        for (;;)
        {
          if ((j >= localList2.size()) || (localAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).appid.get()))
          {
            if ((j >= localList2.size()) || (((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).setting.get())) {
              break label333;
            }
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            break;
          }
          j += 1;
        }
        label333:
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)localAppInfo.red_display_info.tab_display_info.get();
        if ((localAppInfo.uiAppId.get() == 100510) && (localRedTypeInfo.red_type.get() == 5) && (!a(localAppInfo)))
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        if (localObject2 != null)
        {
          localObject4 = localObject2;
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
        }
        else
        {
          localObject4 = localRedTypeInfo;
        }
        localStringBuilder.append(localAppInfo.path.get()).append(",");
        if (localRedTypeInfo.red_type.get() == 5)
        {
          if (localObject1 == null)
          {
            localObject1 = localObject4;
            localObject2 = localRedTypeInfo;
            continue;
          }
          try
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("RedPointManage", 4, "getRedTouchInfoByAppSet, content=" + localObject1.red_content.get() + ", path=" + localAppInfo.path.get() + ",redTypeInfoContent=" + localRedTypeInfo.red_content.get());
            }
            localObject2 = localObject1.red_content;
            localObject5 = new StringBuilder();
            j = Integer.parseInt(localObject1.red_content.get());
            ((PBStringField)localObject2).set(Integer.parseInt(localRedTypeInfo.red_content.get()) + j + "");
            localObject2 = localObject1;
            localObject1 = localObject4;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
            localObject3 = localObject1;
            localObject1 = localObject4;
          }
          continue;
        }
        if (localObject4 != null)
        {
          localObject5 = localObject4;
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
        }
        else
        {
          localObject3 = localObject1;
          localObject1 = localRedTypeInfo;
          continue;
          localObject4 = localObject1;
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel())
          {
            if (localObject3 == null) {
              break label744;
            }
            QLog.e("RedPointManage", 2, "getRedTouchInfoByAppSet appset = " + paramInt + ";result != nullpathList = " + localStringBuilder.toString());
          }
          for (;;)
          {
            return localObject3;
            label744:
            QLog.e("RedPointManage", 2, "getRedTouchInfoByAppSet appset = " + paramInt + ";result = null");
          }
        }
      }
      Object localObject3 = localObject1;
      localObject1 = localObject5;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(QQAppInterface paramQQAppInterface, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap)
  {
    List localList1 = b(0);
    if ((localList1 == null) || (localList1.size() == 0))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    List localList2 = a();
    Object localObject2 = null;
    Object localObject1 = null;
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("getRedTouchInfoForLeba:redpoint path List:");
    int i = 0;
    label61:
    Object localObject5;
    Object localObject4;
    if (i < localList1.size())
    {
      localObject5 = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
      localStringBuilder.append(", for ").append(((BusinessInfoCheckUpdate.AppInfo)localObject5).path.get());
      if (((BusinessInfoCheckUpdate.AppInfo)localObject5).mission_level.get() != 0)
      {
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
    }
    for (;;)
    {
      i += 1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break label61;
      if ((999999 == ((BusinessInfoCheckUpdate.AppInfo)localObject5).uiAppId.get()) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).path.get().contains(".")))
      {
        localStringBuilder.append(" second ");
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if ((((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get() != 1) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).exposure_max.get() <= 0))
      {
        localStringBuilder.append(" isNewFlag exposure_max error").append(((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get()).append(((BusinessInfoCheckUpdate.AppInfo)localObject5).exposure_max.get());
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if (!ajzq.a(paramQQAppInterface, ((BusinessInfoCheckUpdate.AppInfo)localObject5).uiAppId.get(), paramBoolean, paramMap))
      {
        localStringBuilder.append(" !needShowRedDot");
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else
      {
        int j = 0;
        for (;;)
        {
          if ((j >= localList2.size()) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).appid.get()))
          {
            if ((j >= localList2.size()) || (((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).setting.get())) {
              break label426;
            }
            localStringBuilder.append(" hide ");
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            break;
          }
          j += 1;
        }
        label426:
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.AppInfo)localObject5).red_display_info.tab_display_info.get();
        if ((((BusinessInfoCheckUpdate.AppInfo)localObject5).uiAppId.get() == 100510) && (localRedTypeInfo.red_type.get() == 5) && (!a((BusinessInfoCheckUpdate.AppInfo)localObject5)))
        {
          localStringBuilder.append(" !nearby");
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
        }
        else
        {
          if (localObject2 != null)
          {
            localObject4 = localObject2;
            if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
          }
          else
          {
            localObject4 = localRedTypeInfo;
          }
          localStringBuilder.append(" show ");
          Object localObject3;
          if (localRedTypeInfo.red_type.get() == 5)
          {
            if (localObject1 == null)
            {
              localObject1 = localObject4;
              localObject2 = localRedTypeInfo;
            }
            else
            {
              try
              {
                if (QLog.isDevelopLevel()) {
                  QLog.e("RedPointManage", 4, "getRedTouchInfoForLeba, content=" + localObject1.red_content.get() + ", path=" + ((BusinessInfoCheckUpdate.AppInfo)localObject5).path.get() + ",redTypeInfoContent=" + localRedTypeInfo.red_content.get());
                }
                localObject2 = localObject1.red_content;
                localObject5 = new StringBuilder();
                j = Integer.parseInt(localObject1.red_content.get());
                ((PBStringField)localObject2).set(Integer.parseInt(localRedTypeInfo.red_content.get()) + j + "");
                localObject2 = localObject1;
                localObject1 = localObject4;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                localNumberFormatException.printStackTrace();
                localObject3 = localObject1;
                localObject1 = localObject4;
              }
            }
          }
          else
          {
            if ((localObject4 == null) || (localObject4.red_priority.get() < localRedTypeInfo.red_priority.get()))
            {
              localObject3 = localObject1;
              localObject1 = localRedTypeInfo;
              continue;
              paramQQAppInterface = localObject1;
              if (localObject1 != null) {
                break;
              }
              if (localObject3 != null) {
                QLog.i("RedPointManage", 1, "getRedTouchInfoForLeba result != nullpathList = " + localStringBuilder.toString());
              }
              for (;;)
              {
                return localObject3;
                QLog.i("RedPointManage", 1, "getRedTouchInfoForLeba result = nullpathList = " + localStringBuilder.toString());
              }
            }
            localObject3 = localObject1;
            localObject1 = localObject4;
          }
        }
      }
    }
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((!a()) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody != null))
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody;
        return localTimeRspBody;
      }
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new RedTouchManager.1(this), 5, null, true);
        return null;
      }
    }
    c();
    return null;
  }
  
  public String a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("lastClickPath", "");
  }
  
  public String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInfo == null))
    {
      a("url is empty or appInfo is Empty");
      return paramString;
    }
    int j = -1;
    int i = j;
    if (paramAppInfo != null)
    {
      i = j;
      if (paramAppInfo.iNewFlag.get() != 0)
      {
        new ArrayList();
        i = j;
        if (paramAppInfo.red_display_info != null)
        {
          i = j;
          if (paramAppInfo.red_display_info.red_type_info != null)
          {
            List localList = paramAppInfo.red_display_info.red_type_info.get();
            i = j;
            if (localList != null)
            {
              i = j;
              if (localList.size() >= 2) {
                i = ((BusinessInfoCheckUpdate.RedTypeInfo)localList.get(1)).red_type.get();
              }
            }
          }
        }
      }
    }
    paramString = new StringBuilder(paramString);
    paramString.append("&status=").append(i).append("&number=").append(paramAppInfo.num.get()).append("&path=").append(paramAppInfo.path.get());
    return paramString.toString();
  }
  
  public String a(String paramString1, String paramString2)
  {
    int k = 0;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new HashMap();
    Object localObject4;
    Object localObject5;
    Object localObject1;
    int i;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("msg"))
      {
        paramString2 = paramString2.getJSONObject("msg");
        if (paramString2 == null) {
          break label233;
        }
        localObject4 = paramString2.keys();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label233;
          }
          new JSONObject();
          localObject5 = (String)((Iterator)localObject4).next();
          localObject1 = paramString2.getJSONObject((String)localObject5);
          if (!((JSONObject)localObject1).has("stat")) {
            break;
          }
          i = ((JSONObject)localObject1).getInt("stat");
          label134:
          if (i == 2)
          {
            ((List)localObject2).add(localObject5);
            if (!((JSONObject)localObject1).has("content")) {
              break label225;
            }
            localObject1 = ((JSONObject)localObject1).getString("content");
            label170:
            ((Map)localObject3).put(localObject5, localObject1);
          }
        }
      }
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      localObject1 = null;
      for (paramString2 = null;; paramString2 = (String)localObject2)
      {
        if ((localObject1 != null) && (((Map)localObject1).size() >= 1)) {
          break label243;
        }
        return "";
        paramString2 = null;
        break;
        i = -1;
        break label134;
        label225:
        localObject1 = "";
        break label170;
        label233:
        localObject1 = localObject3;
      }
      label243:
      localObject2 = new ArrayList();
      paramString1 = a(paramString1);
      if (paramString1 == null) {}
    }
    label390:
    label530:
    label535:
    label540:
    label676:
    label682:
    for (paramString1 = paramString1.buffer.get();; paramString1 = null)
    {
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      if (!TextUtils.isEmpty(paramString1)) {
        try
        {
          paramString1 = new JSONObject(paramString1);
          if (!paramString1.has("msg")) {
            break label530;
          }
          paramString1 = paramString1.getJSONObject("msg");
          if (paramString1 != null)
          {
            localObject5 = paramString1.keys();
            while (((Iterator)localObject5).hasNext())
            {
              new JSONObject();
              String str = (String)((Iterator)localObject5).next();
              JSONObject localJSONObject = paramString1.getJSONObject(str);
              if (!localJSONObject.has("stat")) {
                break label535;
              }
              i = localJSONObject.getInt("stat");
              ((List)localObject4).add(str);
              if (i == 1) {
                ((List)localObject3).add(str);
              }
            }
          }
          if (localObject3 == null) {
            break label439;
          }
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      } else {
        if (((List)localObject3).size() >= 1) {
          break label540;
        }
      }
      label439:
      for (paramString1 = paramString2;; paramString1 = (String)localObject2)
      {
        label441:
        if ((paramString1 != null) && (paramString1.size() > 0)) {}
        for (;;)
        {
          try
          {
            paramString2 = new JSONArray();
            i = k;
            if (i < paramString1.size())
            {
              localObject2 = new JSONObject();
              localObject3 = (String)paramString1.get(i);
              ((JSONObject)localObject2).put((String)localObject3, (String)((Map)localObject1).get(localObject3));
              paramString2.put(localObject2);
              i += 1;
              continue;
              paramString1 = null;
              break;
              i = -1;
              break label390;
              i = 0;
              if (i >= paramString2.size()) {
                break label682;
              }
              paramString1 = (String)paramString2.get(i);
              if (!((List)localObject4).contains(paramString1))
              {
                ((List)localObject2).add(paramString1);
                paramString1 = (String)localObject2;
                break label441;
              }
              j = 0;
              if (j >= ((List)localObject3).size()) {
                break label676;
              }
              if (paramString1.equals((String)((List)localObject3).get(j)))
              {
                j = 1;
                if (j != 0) {
                  ((List)localObject2).add(paramString1);
                }
                i += 1;
                continue;
              }
              j += 1;
              continue;
            }
            paramString1 = paramString2.toString();
            return paramString1;
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            return "";
          }
          return "";
          int j = 0;
        }
      }
    }
  }
  
  public List<BusinessInfoCheckUpdate.AppSetting> a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = a();
      if ((localObject3 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject3).rptSetting.has())) {
        return localArrayList;
      }
      localObject3 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject3).rptSetting.get();
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      return localArrayList;
    }
  }
  
  public List<BusinessInfoCheckUpdate.NumRedPath> a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = a(paramInt);
      if (localObject2 == null) {
        return null;
      }
      localObject2 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get();
      return localObject2;
    }
  }
  
  public JSONObject a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramAppInfo.buffer.has())
        {
          JSONObject localJSONObject = new JSONObject(paramAppInfo.buffer.get());
          paramAppInfo = localJSONObject.optString("_show_mission");
          if (!TextUtils.isEmpty(paramAppInfo))
          {
            localJSONObject = localJSONObject.optJSONObject("param");
            if (localJSONObject != null)
            {
              paramAppInfo = localJSONObject.optJSONObject(paramAppInfo);
              return paramAppInfo;
            }
          }
        }
      }
      catch (Throwable paramAppInfo)
      {
        QLog.e("RedPointManage", 1, "getBufferExtParamAppInfo() JSONException ", paramAppInfo);
      }
    }
    return null;
  }
  
  public void a()
  {
    label193:
    label198:
    label207:
    for (;;)
    {
      int k;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody == null) || (!localTimeRspBody.rptMsgNumRedInfo.has())) {
          break label193;
        }
        Object localObject3 = localTimeRspBody.rptMsgNumRedInfo.get();
        if (localObject3 == null) {
          return;
        }
        localObject3 = ((List)localObject3).iterator();
        i = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label207;
        }
        List localList = ((BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject3).next()).num_red_path.get();
        if (localList == null) {
          continue;
        }
        k = 0;
        j = i;
        i = j;
        if (k >= localList.size()) {
          continue;
        }
        BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)localList.get(k);
        if (localNumRedPath.uint32_push_num_red_ts.get() + localNumRedPath.uint32_expire_time.get() < (int)(System.currentTimeMillis() / 1000L))
        {
          localNumRedPath.uint32_msg_status.set(4);
          i = 1;
          break label198;
          if (i != 0) {
            a(localTimeRspBody);
          }
          return;
        }
      }
      int i = j;
      break label198;
      i = 0;
      continue;
      k += 1;
      int j = i;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramInt1 + "");
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {}
    switch (paramInt2)
    {
    default: 
    case 30: 
      do
      {
        return;
        d(localAppInfo.path.get());
      } while (localAppInfo.exposure_max.get() < 0);
      a(localAppInfo, paramInt2, true, null, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager.a(localAppInfo.buffer.get());
    a(localAppInfo.path.get(), false);
    a(localAppInfo, paramInt2, true, null, null);
    akfi.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void a(int paramInt, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = b(paramString, 100);
      if (i > 0)
      {
        BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(paramInt);
        if (localNumRedInfo != null)
        {
          String str = localNumRedInfo.extend.get();
          a(a(localNumRedInfo.appset.get(), paramInt, paramString, i, false, str), 9, "", true, 3);
        }
      }
      return;
    }
  }
  
  public void a(int paramInt1, ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.2.8.4440");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(paramInt2);
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(paramInt1);
    if (paramArrayList != null) {
      localReportReqBody.missionid.set(paramArrayList);
    }
    paramInt1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences("check_update_sp_key", 0).getInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString3))
        {
          paramArrayList = new JSONObject();
          paramString3 = paramArrayList;
        }
      }
      catch (Exception paramArrayList)
      {
        paramString3 = null;
      }
      try
      {
        paramArrayList.put("msg", "");
        paramString3 = paramArrayList;
        paramArrayList.put("red", paramString1);
        paramString3 = paramArrayList;
        paramArrayList.put("ret", paramString2);
        paramString3 = paramArrayList;
        paramArrayList.put("lastTime", paramInt1);
        paramString3 = paramArrayList;
        paramArrayList.put("callback", paramString5);
        paramString3 = paramArrayList;
        paramArrayList.put("waterid", paramString4);
        paramString1 = paramArrayList;
        if (paramString1 != null) {
          localReportReqBody.buffer.set(paramString1.toString());
        }
        paramArrayList = a("RedTouchSvc.ClientReport");
        paramArrayList.putWupBuffer(localReportReqBody.toByteArray());
        a(paramArrayList);
        return;
      }
      catch (Exception paramArrayList)
      {
        break label308;
      }
      paramArrayList = new JSONObject(paramString3);
      continue;
      label308:
      paramString1 = paramString3;
      if (QLog.isColorLevel())
      {
        QLog.e("RedPointManage", 2, "getAndSetAppInfoJsReport buffer json is empty", paramArrayList);
        paramString1 = paramString3;
      }
    }
  }
  
  public void a(long paramLong)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.contains("."))) {}
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      localAppInfo = a(this.jdField_a_of_type_JavaLangString);
    } while ((localAppInfo == null) || (paramLong < 0L));
    paramLong = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.e("residenceReport", 2, "residenceReport time = " + paramLong + ";path = " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangString = null;
    ThreadManager.post(new RedTouchManager.3(this, localAppInfo, paramLong), 2, null, true);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    d(paramAppInfo, null);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {
      return;
    }
    String str = paramAppInfo.path.get();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager.a(paramAppInfo.buffer.get());
    if (paramAppInfo.type.get() == 5)
    {
      a(paramAppInfo, 9, paramString, true, 3);
      return;
    }
    a(paramAppInfo, str, paramString);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject != null)
    {
      BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
      localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
      localReportReqBody.clientver.set("8.2.8.4440");
      localReportReqBody.platid.set(109);
      localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
      localReportReqBody.buffer.set(paramJSONObject.toString());
      localReportReqBody.cmd.set(paramInt);
      if (paramAppInfo != null)
      {
        localReportReqBody.appid.set(a(paramAppInfo.path.get()));
        if (paramAppInfo.missions.has()) {
          localReportReqBody.missionid.set(paramAppInfo.missions.get());
        }
      }
      paramAppInfo = a("RedTouchSvc.ClientReport");
      paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
      a(paramAppInfo);
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "onReportRedPointClickWithMissions");
    }
    if (paramAppInfo == null)
    {
      QLog.e("RedPointManage", 1, "onReportRedPointClickWithMissions appinfo = null");
      return;
    }
    a(paramAppInfo, 6, paramBoolean, paramList, null);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        Object localObject = new Submsgtype0x89.MsgBody();
        ((Submsgtype0x89.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((Submsgtype0x89.MsgBody)localObject).rpt_msg_num_red.get();
        if (paramArrayOfByte == null) {
          return;
        }
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (Submsgtype0x89.NumRedBusiInfo)paramArrayOfByte.next();
          if ((a((Submsgtype0x89.NumRedBusiInfo)localObject)) && (avpt.a((Submsgtype0x89.NumRedBusiInfo)localObject))) {
            a(a(((Submsgtype0x89.NumRedBusiInfo)localObject).int32_appset.get(), ((Submsgtype0x89.NumRedBusiInfo)localObject).uint32_app_id.get(), String.valueOf(((Submsgtype0x89.NumRedBusiInfo)localObject).uint64_msgid.get()), 1), 1, "", false, -1);
          }
        }
        d();
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, String paramString, avpl paramavpl)
  {
    ((avpm)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(65)).a(paramArrayOfLong, paramString, paramavpl);
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localSharedPreferences == null) {
      return true;
    }
    return localSharedPreferences.getBoolean("isCacheChange", true);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (a(paramInt, 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	avpq:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 138	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 35	avpq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   13: astore 4
    //   15: aload 4
    //   17: monitorenter
    //   18: aload_1
    //   19: invokevirtual 1092	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:toByteArray	()[B
    //   22: astore 6
    //   24: aload 4
    //   26: monitorexit
    //   27: getstatic 30	avpq:b	Ljava/lang/Object;
    //   30: astore 4
    //   32: aload 4
    //   34: monitorenter
    //   35: getstatic 25	avpq:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   38: invokevirtual 1095	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   41: istore_2
    //   42: new 676	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: getfield 37	avpq:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   50: invokevirtual 679	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   53: invokevirtual 685	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   56: new 161	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 687
    //   66: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 5
    //   71: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 690	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   80: invokevirtual 1098	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: aload 6
    //   85: iconst_0
    //   86: invokestatic 1101	bbdj:a	(Ljava/lang/String;[BZ)Z
    //   89: istore_3
    //   90: iload_3
    //   91: ifeq +91 -> 182
    //   94: getstatic 1104	axbt:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload 5
    //   99: iconst_0
    //   100: invokestatic 1109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   103: invokevirtual 1112	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload 4
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 35	avpq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   114: astore 4
    //   116: aload 4
    //   118: monitorenter
    //   119: iload_3
    //   120: ifeq +18 -> 138
    //   123: iload_2
    //   124: getstatic 25	avpq:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   127: invokevirtual 1113	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   130: if_icmpne +8 -> 138
    //   133: aload_0
    //   134: aload_1
    //   135: invokespecial 1115	avpq:b	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody;)V
    //   138: aload 4
    //   140: monitorexit
    //   141: iload_3
    //   142: ireturn
    //   143: astore_1
    //   144: ldc_w 268
    //   147: iconst_1
    //   148: ldc_w 1117
    //   151: aload_1
    //   152: invokestatic 386	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload 4
    //   157: monitorexit
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: aload 4
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: ldc_w 268
    //   170: iconst_1
    //   171: ldc_w 1119
    //   174: invokestatic 445	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 4
    //   179: monitorexit
    //   180: iconst_0
    //   181: ireturn
    //   182: ldc_w 268
    //   185: iconst_1
    //   186: ldc_w 1121
    //   189: invokestatic 445	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: goto -85 -> 107
    //   195: astore_1
    //   196: aload 4
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: aload 4
    //   204: monitorexit
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	avpq
    //   0	207	1	paramTimeRspBody	BusinessInfoCheckUpdate.TimeRspBody
    //   41	90	2	i	int
    //   89	53	3	bool	boolean
    //   7	91	5	str	String
    //   22	62	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	24	143	java/lang/Exception
    //   18	24	160	finally
    //   24	27	160	finally
    //   144	158	160	finally
    //   161	164	160	finally
    //   167	180	160	finally
    //   18	24	166	java/lang/OutOfMemoryError
    //   35	90	195	finally
    //   94	107	195	finally
    //   107	110	195	finally
    //   182	192	195	finally
    //   196	199	195	finally
    //   123	138	201	finally
    //   138	141	201	finally
    //   202	205	201	finally
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "parsePushRedTouchInfo start");
    }
    try
    {
      d();
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "parsePushRedTouchInfo end");
      }
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e("RedPointManage", 1, "push parse error : e = " + paramArrayOfByte.getMessage());
      }
    }
  }
  
  public int b(int paramInt)
  {
    int j = 0;
    label169:
    label172:
    label175:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = a();
        int i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
          {
            localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
            if (localObject2 == null)
            {
              a("getNumRedShowNumByAppSet : numRedBusiList is null");
              return 0;
            }
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject2).hasNext()) {
              break label175;
            }
            BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
            if (paramInt != localNumRedInfo.appset.get()) {
              break label169;
            }
            if (localNumRedInfo.appid.get() == 7719) {
              continue;
            }
            if (!a(localNumRedInfo.appid.get())) {
              break label169;
            }
            i = a(localNumRedInfo.appid.get(), 100) + i;
            break label172;
          }
        }
        return i;
      }
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo b(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      a("input path is Empty");
    }
    int i;
    do
    {
      return null;
      a("getAppInfoByPath path = " + paramString);
      i = a(paramString, 100);
    } while (i <= 0);
    int j = Integer.parseInt(paramString.split("\\.")[0]);
    BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(j);
    String str = "";
    if (localNumRedInfo != null) {
      str = localNumRedInfo.extend.get();
    }
    return a(paramInt, j, paramString, i, false, str);
  }
  
  public List<BusinessInfoCheckUpdate.AppInfo> b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = a();
      if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
      {
        localObject2 = new ArrayList();
        return localObject2;
      }
      Object localObject3 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get();
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject3).next();
        if (localAppInfo.appset.get() == paramInt) {
          ((List)localObject2).add(localAppInfo);
        }
      }
    }
    return localList;
  }
  
  public void b()
  {
    QLog.d("RedPointManage", 2, "getNewFlagOp:send redInfo start");
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("check_update_sp_key", 0);
    long l1 = ((SharedPreferences)localObject).getLong("conversation_remain_last_report", -1L);
    long l2 = QzoneConfig.getInstance().getConfig("WNSSettting", "conversation_remain_report_control", 60);
    long l3 = System.currentTimeMillis() / 1000L;
    if (l1 > l3 - l2) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("conversation_remain_last_report", l3);
    ((SharedPreferences.Editor)localObject).apply();
    a(null, null, 50);
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo.type.get() == 5)
    {
      a(paramAppInfo, 8, paramString, false, -1);
      return;
    }
    d(paramAppInfo, paramString);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("onRedTouchItemClick path is empty");
      return;
    }
    a(a(paramString), paramString, null);
  }
  
  /* Error */
  public boolean b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	avpq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: aload_3
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: invokevirtual 78	avpq:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnonnull +7 -> 30
    //   26: aload_3
    //   27: monitorexit
    //   28: iconst_1
    //   29: ireturn
    //   30: aload 4
    //   32: getfield 84	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   35: invokevirtual 94	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +66 -> 108
    //   45: aload 4
    //   47: invokeinterface 102 1 0
    //   52: astore 4
    //   54: aload 4
    //   56: invokeinterface 107 1 0
    //   61: ifeq +47 -> 108
    //   64: aload 4
    //   66: invokeinterface 111 1 0
    //   71: checkcast 113	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo
    //   74: astore 5
    //   76: aload 5
    //   78: getfield 117	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: invokevirtual 122	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   84: iload_1
    //   85: if_icmpne -31 -> 54
    //   88: aload 5
    //   90: getfield 1172	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo:flag	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   93: invokevirtual 852	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   96: istore_2
    //   97: aload_3
    //   98: monitorexit
    //   99: iload_2
    //   100: ireturn
    //   101: astore 4
    //   103: aload_3
    //   104: monitorexit
    //   105: aload 4
    //   107: athrow
    //   108: aload_3
    //   109: monitorexit
    //   110: iconst_1
    //   111: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	avpq
    //   0	112	1	paramInt	int
    //   96	4	2	bool	boolean
    //   4	105	3	localObject1	Object
    //   101	5	4	localObject3	Object
    //   74	15	5	localNumRedInfo	BusinessInfoCheckUpdate.NumRedInfo
    // Exception table:
    //   from	to	target	type
    //   11	13	101	finally
    //   15	21	101	finally
    //   26	28	101	finally
    //   30	40	101	finally
    //   45	54	101	finally
    //   54	99	101	finally
    //   103	105	101	finally
    //   108	110	101	finally
  }
  
  public void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if ((paramAppInfo == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    d(paramAppInfo.path.get());
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.2.8.4440");
    localReportReqBody.platid.set(109);
    localReportReqBody.missionid.set(paramAppInfo.missions.get());
    localReportReqBody.appid.set(paramAppInfo.uiAppId.get());
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(5);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramAppInfo = new JSONObject();
      if (paramAppInfo != null) {}
      try
      {
        paramAppInfo.put("cmd", 5);
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = paramAppInfo;
        if (localJSONObject == null) {
          break label265;
        }
        Iterator localIterator = localJSONObject.keys();
        for (;;)
        {
          paramString = paramAppInfo;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
          localReportStaticsData.key.set(paramString);
          localReportStaticsData.value.set(localJSONObject.getString(paramString));
          localArrayList.add(localReportStaticsData);
        }
        paramString.printStackTrace();
      }
      catch (JSONException paramString) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        label265:
        paramAppInfo = null;
      }
    }
    paramString = paramAppInfo;
    if (paramString != null) {
      localReportReqBody.buffer.set(paramString.toString());
    }
    localReportReqBody.reportdata.set(localArrayList);
    paramAppInfo = a("RedTouchSvc.ClientReport");
    paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
    a(paramAppInfo);
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("onRedTouchItemClick path is empty");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localObject != null)
    {
      if (a(paramString).iNewFlag.get() == 1) {
        ((SharedPreferences)localObject).edit().putString("lastClickPath", paramString).commit();
      }
    }
    else
    {
      localObject = a(paramString);
      if (localObject != null)
      {
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0) {
          break label146;
        }
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 14, false, null, null);
      }
    }
    for (;;)
    {
      a(paramString, false);
      setChanged();
      akfi.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return;
      ((SharedPreferences)localObject).edit().putString("lastClickPath", "").commit();
      break;
      label146:
      a((BusinessInfoCheckUpdate.AppInfo)localObject, 14, true, null, null);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avpq
 * JD-Core Version:    0.7.0.1
 */