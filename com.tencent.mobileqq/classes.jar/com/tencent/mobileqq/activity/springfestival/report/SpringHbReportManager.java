package com.tencent.mobileqq.activity.springfestival.report;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.new_year_2021.Unisso.UniSsoServerReq;
import tencent.im.new_year_2021.newyear_report.NYCommonInfo;
import tencent.im.new_year_2021.newyear_report.NYReportItems;
import tencent.im.new_year_2021.newyear_report.NYReportReq;
import tencent.im.new_year_2021.newyear_report.SsoReq;

public class SpringHbReportManager
  implements Manager
{
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new SpringHbReportManager.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, LinkedList<newyear_report.NYReportItems>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedList<SpringHbReportManager.ReportInfo> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private long c;
  
  public SpringHbReportManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private int a()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      SpringHbReportManager.ReportInfo localReportInfo = (SpringHbReportManager.ReportInfo)localIterator.next();
      if ((!localReportInfo.isSending) && (a(l, localReportInfo))) {
        i += 1;
      }
    }
    return i;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localStringBuilder.append("/.config/");
    localStringBuilder.append("report.cache");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private LinkedList<SpringHbReportManager.ReportInfo> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_3
    //   5: astore_1
    //   6: getstatic 23	com/tencent/mobileqq/activity/springfestival/report/SpringHbReportManager:jdField_a_of_type_ArrayOfByte	[B
    //   9: astore 4
    //   11: aload_3
    //   12: astore_1
    //   13: aload 4
    //   15: monitorenter
    //   16: ldc 129
    //   18: invokestatic 99	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   21: checkcast 129	com/tencent/mobileqq/qwallet/IQWalletApi
    //   24: aload_0
    //   25: invokespecial 124	com/tencent/mobileqq/activity/springfestival/report/SpringHbReportManager:a	()Ljava/lang/String;
    //   28: invokeinterface 133 2 0
    //   33: checkcast 30	java/util/LinkedList
    //   36: astore_1
    //   37: aload 4
    //   39: monitorexit
    //   40: goto +24 -> 64
    //   43: astore_2
    //   44: aload_2
    //   45: astore_3
    //   46: goto +6 -> 52
    //   49: astore_3
    //   50: aload_2
    //   51: astore_1
    //   52: aload_1
    //   53: astore_2
    //   54: aload 4
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 136	java/lang/Throwable:printStackTrace	()V
    //   64: aload_1
    //   65: astore_2
    //   66: aload_1
    //   67: ifnonnull +11 -> 78
    //   70: new 30	java/util/LinkedList
    //   73: dup
    //   74: invokespecial 31	java/util/LinkedList:<init>	()V
    //   77: astore_2
    //   78: aload_2
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	SpringHbReportManager
    //   5	62	1	localObject1	Object
    //   3	1	2	localObject2	Object
    //   53	1	2	localObject4	Object
    //   59	2	2	localThrowable	Throwable
    //   65	14	2	localObject5	Object
    //   1	45	3	localObject6	Object
    //   49	9	3	localObject7	Object
    //   9	46	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   37	40	43	finally
    //   16	37	49	finally
    //   54	57	49	finally
    //   6	11	59	java/lang/Throwable
    //   13	16	59	java/lang/Throwable
    //   57	59	59	java/lang/Throwable
  }
  
  private NewIntent a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SpringHbReportServlet.class);
    localNewIntent.putExtra("cmd", paramString);
    paramString = new Unisso.UniSsoServerReq();
    paramString.reqdata.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localNewIntent.putExtra("data", WupUtil.a(paramString.toByteArray()));
    if (paramLong > 0L) {
      localNewIntent.putExtra("timeout", paramLong);
    }
    return localNewIntent;
  }
  
  private BusinessObserver a(long paramLong)
  {
    return new SpringHbReportManager.7(this, paramLong);
  }
  
  private newyear_report.NYCommonInfo a()
  {
    newyear_report.NYCommonInfo localNYCommonInfo = new newyear_report.NYCommonInfo();
    localNYCommonInfo.uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    String str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    if (!TextUtils.isEmpty(str)) {
      localNYCommonInfo.adcode.set(str);
    }
    localNYCommonInfo.plat.set(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    Object localObject = MobileInfoUtil.getImei();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append("&imei=");
      localStringBuilder.append((String)localObject);
    }
    localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qq_spring_hb");
    if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
    {
      localStringBuilder.append("&lt=");
      localStringBuilder.append(((SosoLbsInfo)localObject).mLocation.mLon02);
      localStringBuilder.append("&la=");
      localStringBuilder.append(((SosoLbsInfo)localObject).mLocation.mLat02);
    }
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder.append("&adcode=");
      localStringBuilder.append(str);
    }
    localStringBuilder.append("&net=");
    localStringBuilder.append(b());
    localStringBuilder.append("&plat=");
    localStringBuilder.append(1);
    localStringBuilder.append("&ver=");
    localStringBuilder.append(DeviceInfoUtil.e());
    localStringBuilder.append("&model=");
    localStringBuilder.append(DeviceInfoUtil.i());
    localStringBuilder.append("&qqver=");
    localStringBuilder.append(DeviceInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    localStringBuilder.append("&appid=");
    localStringBuilder.append(AppSetting.a());
    localNYCommonInfo.report_array.set(localStringBuilder.toString());
    return localNYCommonInfo;
  }
  
  private void a()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.plugin.state.change");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("spring_hb_report", 0);
    this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("batch_size", 20);
    this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("report_is_overload", false);
    this.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("report_level", 0);
    this.jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong("report_level_time", 0L);
    this.jdField_b_of_type_Long = ((SharedPreferences)localObject).getLong("last_report_time", 0L);
    this.c = ((SharedPreferences)localObject).getLong("last_save_report_file_time", 0L);
    this.jdField_a_of_type_JavaUtilLinkedList = a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[init] mBatchSize:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",mLastReportTime:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append(",mLastSaveFileTime:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(",mReportItems:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilLinkedList);
      QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(long paramLong)
  {
    long l;
    if (paramLong < 0L)
    {
      l = 0L;
    }
    else
    {
      l = paramLong;
      if (paramLong > 86400L) {
        l = 86400L;
      }
    }
    this.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + l);
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("report_level_time", this.jdField_a_of_type_Long).apply();
  }
  
  private void a(long paramLong, int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new SpringHbReportManager.8(this, paramLong, paramInt));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      long l = NetConnInfoCenter.getServerTimeMillis() - this.c;
      if (l <= 10000L)
      {
        l = 10000L - l;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[saveReportFile] no need to save, saveDelayTime=");
          ((StringBuilder)localObject).append(l);
          QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
        }
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this.jdField_b_of_type_ArrayOfByte);
        ThreadManager.getSubThreadHandler().postAtTime(new SpringHbReportManager.2(this), this.jdField_b_of_type_ArrayOfByte, SystemClock.uptimeMillis() + l);
        return;
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this.jdField_b_of_type_ArrayOfByte);
    this.c = NetConnInfoCenter.getServerTimeMillis();
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("last_save_report_file_time", this.c).apply();
    if (QLog.isColorLevel()) {
      QLog.d("shua2021report_SpringHbReportManager", 2, "[saveReportFile] go to save");
    }
    Object localObject = new LinkedList(this.jdField_a_of_type_JavaUtilLinkedList);
    ThreadManager.getFileThreadHandler().post(new SpringHbReportManager.3(this, (LinkedList)localObject));
  }
  
  private boolean a(long paramLong, SpringHbReportManager.ReportInfo paramReportInfo)
  {
    long l = paramReportInfo.reqSeq;
    boolean bool = true;
    if (l != 0L)
    {
      if (paramLong - paramReportInfo.reqSeq > (paramReportInfo.retryCount + 1) * 1200000) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean a(SpringHbReportManager.ReportInfo paramReportInfo)
  {
    if ((paramReportInfo.isRealTime) && (this.jdField_a_of_type_Boolean)) {
      paramReportInfo.isRealTime = false;
    }
    if (NetConnInfoCenter.getServerTime() > this.jdField_a_of_type_Long) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.jdField_b_of_type_Int = 0;
    }
    int i = this.jdField_b_of_type_Int;
    if (i != 1)
    {
      if (i != 2) {
        return i == 3;
      }
      if ((!TextUtils.equals(ReportConstant.Event.b, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.a, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.c, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.e, paramReportInfo.eventName))) {
        return TextUtils.equals(ReportConstant.Event.d, paramReportInfo.eventName);
      }
      return true;
    }
    paramReportInfo.isRealTime = false;
    return false;
  }
  
  private static int b()
  {
    int j = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    int i = 6;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 6) {
              return 1;
            }
            return 7;
          }
          return 4;
        }
        return 5;
      }
    }
    else {
      i = 3;
    }
    return i;
  }
  
  private void b()
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("last_report_time", this.jdField_b_of_type_Long).apply();
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    paramInt = this.jdField_b_of_type_Int;
    if ((paramInt < 0) || (paramInt > 3)) {
      this.jdField_b_of_type_Int = 0;
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putInt("report_level", this.jdField_b_of_type_Int).apply();
  }
  
  private void b(long paramLong)
  {
    ThreadManagerV2.executeOnSubThread(new SpringHbReportManager.9(this, paramLong));
  }
  
  private void b(SpringHbReportManager.ReportInfo paramReportInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[addToCache] mReportItems.size() = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilLinkedList.size());
      QLog.i("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (SpringHbReportManager.ReportInfo)localIterator.next();
      if (((SpringHbReportManager.ReportInfo)localObject).merge(paramReportInfo))
      {
        if (QLog.isColorLevel())
        {
          paramReportInfo = new StringBuilder();
          paramReportInfo.append("[addToCache] merge succ:");
          paramReportInfo.append(localObject);
          QLog.i("shua2021report_SpringHbReportManager", 2, paramReportInfo.toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbReportManager", 2, "[addToCache] merge fail, directly added");
    }
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramReportInfo);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putBoolean("report_is_overload", paramBoolean).apply();
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject3 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      Object localObject4;
      Object localObject2;
      Object localObject5;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SpringHbReportManager.ReportInfo)((Iterator)localObject3).next();
        if (((SpringHbReportManager.ReportInfo)localObject4).retryCount >= 2)
        {
          ((Iterator)localObject3).remove();
        }
        else
        {
          long l2 = ((SpringHbReportManager.ReportInfo)localObject4).reqSeq;
          if (a(l1, (SpringHbReportManager.ReportInfo)localObject4))
          {
            if (l2 == 0L) {
              ((SpringHbReportManager.ReportInfo)localObject4).reqSeq = l1;
            } else {
              ((SpringHbReportManager.ReportInfo)localObject4).retryCount += 1;
            }
            ((SpringHbReportManager.ReportInfo)localObject4).isSending = true;
            localObject2 = (LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((SpringHbReportManager.ReportInfo)localObject4).reqSeq));
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new LinkedList();
              this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((SpringHbReportManager.ReportInfo)localObject4).reqSeq), localObject1);
            }
            localObject2 = new newyear_report.NYReportItems();
            ((newyear_report.NYReportItems)localObject2).optime.set(((SpringHbReportManager.ReportInfo)localObject4).optime);
            ((newyear_report.NYReportItems)localObject2).event.set(((SpringHbReportManager.ReportInfo)localObject4).eventName);
            ((newyear_report.NYReportItems)localObject2).action.set(((SpringHbReportManager.ReportInfo)localObject4).action);
            ((newyear_report.NYReportItems)localObject2).result.set(((SpringHbReportManager.ReportInfo)localObject4).result);
            ((newyear_report.NYReportItems)localObject2).count.set(((SpringHbReportManager.ReportInfo)localObject4).count);
            ((newyear_report.NYReportItems)localObject2).str_action.set(((SpringHbReportManager.ReportInfo)localObject4).strAction);
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(((SpringHbReportManager.ReportInfo)localObject4).paramsStr);
            ((StringBuilder)localObject5).append("&optime=");
            ((StringBuilder)localObject5).append(((SpringHbReportManager.ReportInfo)localObject4).optime);
            ((SpringHbReportManager.ReportInfo)localObject4).paramsStr = ((StringBuilder)localObject5).toString();
            ((newyear_report.NYReportItems)localObject2).param_array.set(((SpringHbReportManager.ReportInfo)localObject4).paramsStr);
            ((LinkedList)localObject1).add(localObject2);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[doReportRequest] ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilLinkedList);
        ((StringBuilder)localObject1).append(",mToReqMap:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilHashMap);
        ((StringBuilder)localObject1).append(",convertCost:");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
        QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (LinkedList)((Map.Entry)localObject3).getValue();
        localObject4 = new newyear_report.NYReportReq();
        ((newyear_report.NYReportReq)localObject4).commonInfo.set(a());
        ((newyear_report.NYReportReq)localObject4).reportItems.set((List)localObject2);
        localObject5 = new newyear_report.SsoReq();
        ((newyear_report.SsoReq)localObject5).data.set((MessageMicro)localObject4);
        localObject4 = a("NY2021Report.report", ((newyear_report.SsoReq)localObject5).toByteArray(), 30000L);
        localObject3 = (Long)((Map.Entry)localObject3).getKey();
        ((NewIntent)localObject4).setObserver(a(((Long)localObject3).longValue()));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject4);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[doReportRequest],reqSeq:");
          ((StringBuilder)localObject4).append(localObject3);
          ((StringBuilder)localObject4).append(",startTime:");
          ((StringBuilder)localObject4).append(l1);
          ((StringBuilder)localObject4).append(",batchReqSize:");
          ((StringBuilder)localObject4).append(((LinkedList)localObject2).size());
          QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject4).toString());
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("shua2021report_SpringHbReportManager", 1, localThrowable, new Object[0]);
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = Math.min(200, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = Math.max(10, this.jdField_a_of_type_Int);
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putInt("batch_size", this.jdField_a_of_type_Int).apply();
  }
  
  private void d(int paramInt)
  {
    int j = a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tryReportNow] reportScene:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",reportCount:");
      localStringBuilder.append(j);
      QLog.i("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
    }
    if (j <= 0) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    boolean bool3 = true;
    if (j >= i) {
      i = 1;
    } else {
      i = 0;
    }
    long l1 = Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long);
    boolean bool1;
    if ((l1 >= 600000L) && (this.jdField_b_of_type_Long != 0L)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (paramInt != 1)
    {
      bool2 = bool3;
      if (paramInt != 3) {
        if (paramInt == 4) {
          bool2 = bool3;
        } else {
          bool2 = false;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tryReportInner] reportCount:");
      localStringBuilder.append(j);
      localStringBuilder.append(",mBatchSize:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",isRealTime:");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",reportInterval:");
      localStringBuilder.append(l1);
      localStringBuilder.append(",isTimeOk:");
      localStringBuilder.append(bool1);
      QLog.d("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
    }
    if (((bool2) || (bool1) || (i != 0)) && (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[doReportRequest] tryReportInner,reportCount:");
        localStringBuilder.append(j);
        localStringBuilder.append(",mBatchSize:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(",isRealTime:");
        localStringBuilder.append(bool2);
        localStringBuilder.append(",reportInterval:");
        localStringBuilder.append(l1);
        localStringBuilder.append(",isTimeOk:");
        localStringBuilder.append(bool1);
        QLog.d("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
      }
      c();
      b();
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      return;
    }
    if (this.jdField_b_of_type_Long == 0L) {
      l1 = 600000L;
    } else {
      l1 = 600000L - l1;
    }
    long l2 = 600000L;
    if (l1 <= 0L) {
      l1 = l2;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tryReportInner] schedule delayTime:");
      localStringBuilder.append(l1);
      QLog.i("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    ThreadManager.getSubThreadHandler().postAtTime(new SpringHbReportManager.6(this), this, SystemClock.uptimeMillis() + l1);
    a(false);
  }
  
  public void a(int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new SpringHbReportManager.5(this, paramInt));
  }
  
  public void a(SpringHbReportManager.ReportInfo paramReportInfo)
  {
    ThreadManagerV2.executeOnSubThread(new SpringHbReportManager.4(this, paramReportInfo));
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbReportManager", 2, "[onDestroy]");
    }
    a(3);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager
 * JD-Core Version:    0.7.0.1
 */