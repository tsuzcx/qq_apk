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
    if (localIterator.hasNext())
    {
      SpringHbReportManager.ReportInfo localReportInfo = (SpringHbReportManager.ReportInfo)localIterator.next();
      if ((localReportInfo.isSending) || (!a(l, localReportInfo))) {
        break label64;
      }
      i += 1;
    }
    label64:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath()).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).append("/.config/");
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
    //   16: aload_0
    //   17: invokespecial 124	com/tencent/mobileqq/activity/springfestival/report/SpringHbReportManager:a	()Ljava/lang/String;
    //   20: invokestatic 132	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 30	java/util/LinkedList
    //   26: astore_1
    //   27: aload 4
    //   29: monitorexit
    //   30: aload_1
    //   31: astore_2
    //   32: aload_1
    //   33: ifnonnull +11 -> 44
    //   36: new 30	java/util/LinkedList
    //   39: dup
    //   40: invokespecial 31	java/util/LinkedList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: areturn
    //   46: astore_3
    //   47: aload_2
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload 4
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 135	java/lang/Throwable:printStackTrace	()V
    //   61: goto -31 -> 30
    //   64: astore_3
    //   65: goto -16 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	SpringHbReportManager
    //   5	45	1	localObject1	Object
    //   3	48	2	localObject2	Object
    //   56	2	2	localThrowable	Throwable
    //   1	11	3	localObject3	Object
    //   46	9	3	localObject4	Object
    //   64	1	3	localObject5	Object
    //   9	43	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	27	46	finally
    //   51	54	46	finally
    //   6	11	56	java/lang/Throwable
    //   13	16	56	java/lang/Throwable
    //   54	56	56	java/lang/Throwable
    //   27	30	64	finally
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
    localStringBuilder.append("uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    Object localObject = MobileInfoUtil.c();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localStringBuilder.append("&imei=").append((String)localObject);
    }
    localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qq_spring_hb");
    if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
    {
      localStringBuilder.append("&lt=").append(((SosoLbsInfo)localObject).mLocation.mLon02);
      localStringBuilder.append("&la=").append(((SosoLbsInfo)localObject).mLocation.mLat02);
    }
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append("&adcode=").append(str);
    }
    localStringBuilder.append("&net=").append(b());
    localStringBuilder.append("&plat=").append(1);
    localStringBuilder.append("&ver=").append(DeviceInfoUtil.e());
    localStringBuilder.append("&model=").append(DeviceInfoUtil.i());
    localStringBuilder.append("&qqver=").append(DeviceInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    localStringBuilder.append("&appid=").append(AppSetting.a());
    localNYCommonInfo.report_array.set(localStringBuilder.toString());
    return localNYCommonInfo;
  }
  
  private void a()
  {
    try
    {
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.plugin.state.change");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("spring_hb_report", 0);
      this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("batch_size", 20);
      this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("report_is_overload", false);
      this.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("report_level", 0);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong("report_level_time", 0L);
      this.jdField_b_of_type_Long = ((SharedPreferences)localObject).getLong("last_report_time", 0L);
      this.c = ((SharedPreferences)localObject).getLong("last_save_report_file_time", 0L);
      this.jdField_a_of_type_JavaUtilLinkedList = a();
      if (QLog.isColorLevel()) {
        QLog.d("shua2021report_SpringHbReportManager", 2, "[init] mBatchSize:" + this.jdField_a_of_type_Int + ",mLastReportTime:" + this.jdField_b_of_type_Long + ",mLastSaveFileTime:" + this.c + ",mReportItems:" + this.jdField_a_of_type_JavaUtilLinkedList);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void a(long paramLong)
  {
    long l;
    if (paramLong < 0L) {
      l = 0L;
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + l);
      BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("report_level_time", this.jdField_a_of_type_Long).apply();
      return;
      l = paramLong;
      if (paramLong > 86400L) {
        l = 86400L;
      }
    }
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
        if (QLog.isColorLevel()) {
          QLog.d("shua2021report_SpringHbReportManager", 2, "[saveReportFile] no need to save, saveDelayTime=" + l);
        }
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this.jdField_b_of_type_ArrayOfByte);
        ThreadManager.getSubThreadHandler().postAtTime(new SpringHbReportManager.2(this), this.jdField_b_of_type_ArrayOfByte, l + SystemClock.uptimeMillis());
        return;
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this.jdField_b_of_type_ArrayOfByte);
    this.c = NetConnInfoCenter.getServerTimeMillis();
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("last_save_report_file_time", this.c).apply();
    if (QLog.isColorLevel()) {
      QLog.d("shua2021report_SpringHbReportManager", 2, "[saveReportFile] go to save");
    }
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_JavaUtilLinkedList);
    ThreadManager.getFileThreadHandler().post(new SpringHbReportManager.3(this, localLinkedList));
  }
  
  private boolean a(long paramLong, SpringHbReportManager.ReportInfo paramReportInfo)
  {
    return (paramReportInfo.reqSeq == 0L) || (paramLong - paramReportInfo.reqSeq > 1200000 * (paramReportInfo.retryCount + 1));
  }
  
  private boolean a(SpringHbReportManager.ReportInfo paramReportInfo)
  {
    if ((paramReportInfo.isRealTime) && (this.jdField_a_of_type_Boolean)) {
      paramReportInfo.isRealTime = false;
    }
    int i;
    if (NetConnInfoCenter.getServerTime() > this.jdField_a_of_type_Long)
    {
      i = 1;
      if (i != 0) {
        this.jdField_b_of_type_Int = 0;
      }
    }
    switch (this.jdField_b_of_type_Int)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return false;
        i = 0;
        break;
        paramReportInfo.isRealTime = false;
        return false;
      } while ((!TextUtils.equals(ReportConstant.Event.b, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.a, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.c, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.e, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.d, paramReportInfo.eventName)));
      return true;
    }
    return true;
  }
  
  private static int b()
  {
    switch (NetworkUtil.b(BaseApplicationImpl.getContext()))
    {
    case 5: 
    default: 
      return 1;
    case 1: 
      return 3;
    case 4: 
      return 4;
    case 3: 
      return 5;
    case 2: 
      return 6;
    }
    return 7;
  }
  
  private void b()
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("last_report_time", this.jdField_b_of_type_Long).apply();
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if ((this.jdField_b_of_type_Int < 0) || (this.jdField_b_of_type_Int > 3)) {
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
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbReportManager", 2, "[addToCache] mReportItems.size() = " + this.jdField_a_of_type_JavaUtilLinkedList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      SpringHbReportManager.ReportInfo localReportInfo = (SpringHbReportManager.ReportInfo)localIterator.next();
      if (localReportInfo.merge(paramReportInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021report_SpringHbReportManager", 2, "[addToCache] merge succ:" + localReportInfo);
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
    long l1;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        l1 = NetConnInfoCenter.getServerTimeMillis();
        localObject3 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (SpringHbReportManager.ReportInfo)((Iterator)localObject3).next();
        if (((SpringHbReportManager.ReportInfo)localObject4).retryCount >= 2)
        {
          ((Iterator)localObject3).remove();
          continue;
        }
        l2 = ((SpringHbReportManager.ReportInfo)localObject4).reqSeq;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("shua2021report_SpringHbReportManager", 1, localThrowable, new Object[0]);
        return;
      }
      long l2;
      if (a(l1, (SpringHbReportManager.ReportInfo)localObject4))
      {
        if (l2 == 0L) {
          ((SpringHbReportManager.ReportInfo)localObject4).reqSeq = l1;
        }
        for (;;)
        {
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
          ((SpringHbReportManager.ReportInfo)localObject4).paramsStr = (((SpringHbReportManager.ReportInfo)localObject4).paramsStr + "&optime=" + ((SpringHbReportManager.ReportInfo)localObject4).optime);
          ((newyear_report.NYReportItems)localObject2).param_array.set(((SpringHbReportManager.ReportInfo)localObject4).paramsStr);
          ((LinkedList)localObject1).add(localObject2);
          break;
          ((SpringHbReportManager.ReportInfo)localObject4).retryCount += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("shua2021report_SpringHbReportManager", 2, "[doReportRequest] " + this.jdField_a_of_type_JavaUtilLinkedList + ",mToReqMap:" + this.jdField_a_of_type_JavaUtilHashMap + ",convertCost:" + (System.currentTimeMillis() - l1));
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (LinkedList)((Map.Entry)localObject3).getValue();
      localObject4 = new newyear_report.NYReportReq();
      ((newyear_report.NYReportReq)localObject4).commonInfo.set(a());
      ((newyear_report.NYReportReq)localObject4).reportItems.set((List)localObject2);
      newyear_report.SsoReq localSsoReq = new newyear_report.SsoReq();
      localSsoReq.data.set((MessageMicro)localObject4);
      localObject4 = a("NY2021Report.report", localSsoReq.toByteArray(), 30000L);
      localObject3 = (Long)((Map.Entry)localObject3).getKey();
      ((NewIntent)localObject4).setObserver(a(((Long)localObject3).longValue()));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject4);
      if (QLog.isColorLevel()) {
        QLog.d("shua2021report_SpringHbReportManager", 2, "[doReportRequest],reqSeq:" + localObject3 + ",startTime:" + l1 + ",batchReqSize:" + ((LinkedList)localObject2).size());
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
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
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbReportManager", 2, "[tryReportNow] reportScene:" + paramInt + ",reportCount:" + j);
    }
    if (j <= 0) {
      return;
    }
    int i;
    boolean bool1;
    if (j >= this.jdField_a_of_type_Int)
    {
      i = 1;
      l1 = Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long);
      if ((l1 < 600000L) || (this.jdField_b_of_type_Long == 0L)) {
        break label321;
      }
      bool1 = true;
      label97:
      if ((paramInt != 1) && (paramInt != 3) && (paramInt != 4)) {
        break label327;
      }
    }
    label321:
    label327:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("shua2021report_SpringHbReportManager", 2, "[tryReportInner] reportCount:" + j + ",mBatchSize:" + this.jdField_a_of_type_Int + ",isRealTime:" + bool2 + ",reportInterval:" + l1 + ",isTimeOk:" + bool1);
      }
      if (((!bool2) && (!bool1) && (i == 0)) || (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))) {
        break label333;
      }
      if (QLog.isColorLevel()) {
        QLog.d("shua2021report_SpringHbReportManager", 2, "[doReportRequest] tryReportInner,reportCount:" + j + ",mBatchSize:" + this.jdField_a_of_type_Int + ",isRealTime:" + bool2 + ",reportInterval:" + l1 + ",isTimeOk:" + bool1);
      }
      c();
      b();
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      return;
      i = 0;
      break;
      bool1 = false;
      break label97;
    }
    label333:
    if (this.jdField_b_of_type_Long == 0L) {}
    for (long l1 = 600000L;; l1 = 600000L - l1)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 600000L;
      }
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbReportManager", 2, "[tryReportInner] schedule delayTime:" + l2);
      }
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new SpringHbReportManager.6(this), this, l2 + SystemClock.uptimeMillis());
      a(false);
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager
 * JD-Core Version:    0.7.0.1
 */