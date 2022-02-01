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
  private static final byte[] a = new byte[0];
  private QQAppInterface b;
  private LinkedList<SpringHbReportManager.ReportInfo> c = new LinkedList();
  private int d;
  private int e;
  private long f;
  private long g;
  private long h;
  private boolean i = false;
  private byte[] j = new byte[0];
  private HashMap<Long, LinkedList<newyear_report.NYReportItems>> k = new HashMap();
  private BroadcastReceiver l = new SpringHbReportManager.1(this);
  
  public SpringHbReportManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    b();
  }
  
  private NewIntent a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(this.b.getApp(), SpringHbReportServlet.class);
    localNewIntent.putExtra("cmd", paramString);
    paramString = new Unisso.UniSsoServerReq();
    paramString.reqdata.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localNewIntent.putExtra("data", WupUtil.a(paramString.toByteArray()));
    if (paramLong > 0L) {
      localNewIntent.putExtra("timeout", paramLong);
    }
    return localNewIntent;
  }
  
  private void a(long paramLong)
  {
    long l1;
    if (paramLong < 0L)
    {
      l1 = 0L;
    }
    else
    {
      l1 = paramLong;
      if (paramLong > 86400L) {
        l1 = 86400L;
      }
    }
    this.f = (NetConnInfoCenter.getServerTime() + l1);
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("report_level_time", this.f).apply();
  }
  
  private void a(long paramLong, int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new SpringHbReportManager.8(this, paramLong, paramInt));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis() - this.h;
      if (l1 <= 10000L)
      {
        l1 = 10000L - l1;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[saveReportFile] no need to save, saveDelayTime=");
          ((StringBuilder)localObject).append(l1);
          QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
        }
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this.j);
        ThreadManager.getSubThreadHandler().postAtTime(new SpringHbReportManager.2(this), this.j, SystemClock.uptimeMillis() + l1);
        return;
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this.j);
    this.h = NetConnInfoCenter.getServerTimeMillis();
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("last_save_report_file_time", this.h).apply();
    if (QLog.isColorLevel()) {
      QLog.d("shua2021report_SpringHbReportManager", 2, "[saveReportFile] go to save");
    }
    Object localObject = new LinkedList(this.c);
    ThreadManager.getFileThreadHandler().post(new SpringHbReportManager.3(this, (LinkedList)localObject));
  }
  
  private boolean a(long paramLong, SpringHbReportManager.ReportInfo paramReportInfo)
  {
    long l1 = paramReportInfo.reqSeq;
    boolean bool = true;
    if (l1 != 0L)
    {
      if (paramLong - paramReportInfo.reqSeq > (paramReportInfo.retryCount + 1) * 1200000) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private BusinessObserver b(long paramLong)
  {
    return new SpringHbReportManager.7(this, paramLong);
  }
  
  private void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.plugin.state.change");
      this.b.getApp().registerReceiver(this.l, localIntentFilter);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    Object localObject = this.b.getApp().getSharedPreferences("spring_hb_report", 0);
    this.d = ((SharedPreferences)localObject).getInt("batch_size", 20);
    this.i = ((SharedPreferences)localObject).getBoolean("report_is_overload", false);
    this.e = ((SharedPreferences)localObject).getInt("report_level", 0);
    this.f = ((SharedPreferences)localObject).getLong("report_level_time", 0L);
    this.g = ((SharedPreferences)localObject).getLong("last_report_time", 0L);
    this.h = ((SharedPreferences)localObject).getLong("last_save_report_file_time", 0L);
    this.c = c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[init] mBatchSize:");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(",mLastReportTime:");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(",mLastSaveFileTime:");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(",mReportItems:");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(int paramInt)
  {
    this.e = paramInt;
    paramInt = this.e;
    if ((paramInt < 0) || (paramInt > 3)) {
      this.e = 0;
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putInt("report_level", this.e).apply();
  }
  
  private void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putBoolean("report_is_overload", paramBoolean).apply();
  }
  
  private boolean b(SpringHbReportManager.ReportInfo paramReportInfo)
  {
    if ((paramReportInfo.isRealTime) && (this.i)) {
      paramReportInfo.isRealTime = false;
    }
    if (NetConnInfoCenter.getServerTime() > this.f) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      this.e = 0;
    }
    int m = this.e;
    if (m != 1)
    {
      if (m != 2) {
        return m == 3;
      }
      if ((!TextUtils.equals(ReportConstant.Event.b, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.a, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.c, paramReportInfo.eventName)) && (!TextUtils.equals(ReportConstant.Event.e, paramReportInfo.eventName))) {
        return TextUtils.equals(ReportConstant.Event.d, paramReportInfo.eventName);
      }
      return true;
    }
    paramReportInfo.isRealTime = false;
    return false;
  }
  
  /* Error */
  private LinkedList<SpringHbReportManager.ReportInfo> c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_3
    //   5: astore_1
    //   6: getstatic 32	com/tencent/mobileqq/activity/springfestival/report/SpringHbReportManager:a	[B
    //   9: astore 4
    //   11: aload_3
    //   12: astore_1
    //   13: aload 4
    //   15: monitorenter
    //   16: ldc_w 395
    //   19: invokestatic 401	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   22: checkcast 395	com/tencent/mobileqq/qwallet/IQWalletApi
    //   25: aload_0
    //   26: invokespecial 66	com/tencent/mobileqq/activity/springfestival/report/SpringHbReportManager:d	()Ljava/lang/String;
    //   29: invokeinterface 405 2 0
    //   34: checkcast 39	java/util/LinkedList
    //   37: astore_1
    //   38: aload 4
    //   40: monitorexit
    //   41: goto +24 -> 65
    //   44: astore_2
    //   45: aload_2
    //   46: astore_3
    //   47: goto +6 -> 53
    //   50: astore_3
    //   51: aload_2
    //   52: astore_1
    //   53: aload_1
    //   54: astore_2
    //   55: aload 4
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    //   60: astore_2
    //   61: aload_2
    //   62: invokevirtual 304	java/lang/Throwable:printStackTrace	()V
    //   65: aload_1
    //   66: astore_2
    //   67: aload_1
    //   68: ifnonnull +11 -> 79
    //   71: new 39	java/util/LinkedList
    //   74: dup
    //   75: invokespecial 40	java/util/LinkedList:<init>	()V
    //   78: astore_2
    //   79: aload_2
    //   80: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	SpringHbReportManager
    //   5	63	1	localObject1	Object
    //   3	1	2	localObject2	Object
    //   54	1	2	localObject4	Object
    //   60	2	2	localThrowable	Throwable
    //   66	14	2	localObject5	Object
    //   1	46	3	localObject6	Object
    //   50	9	3	localObject7	Object
    //   9	47	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   38	41	44	finally
    //   16	38	50	finally
    //   55	58	50	finally
    //   6	11	60	java/lang/Throwable
    //   13	16	60	java/lang/Throwable
    //   58	60	60	java/lang/Throwable
  }
  
  private void c(int paramInt)
  {
    this.d = paramInt;
    this.d = Math.min(200, this.d);
    this.d = Math.max(10, this.d);
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putInt("batch_size", this.d).apply();
  }
  
  private void c(long paramLong)
  {
    ThreadManagerV2.executeOnSubThread(new SpringHbReportManager.9(this, paramLong));
  }
  
  private void c(SpringHbReportManager.ReportInfo paramReportInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[addToCache] mReportItems.size() = ");
      ((StringBuilder)localObject).append(this.c.size());
      QLog.i("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
    }
    Iterator localIterator = this.c.iterator();
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
    this.c.add(paramReportInfo);
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
    localStringBuilder.append(this.b.getAccount());
    localStringBuilder.append("/.config/");
    localStringBuilder.append("report.cache");
    return localStringBuilder.toString();
  }
  
  private void d(int paramInt)
  {
    int n = g();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tryReportNow] reportScene:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",reportCount:");
      localStringBuilder.append(n);
      QLog.i("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
    }
    if (n <= 0) {
      return;
    }
    int m = this.d;
    boolean bool3 = true;
    if (n >= m) {
      m = 1;
    } else {
      m = 0;
    }
    long l1 = Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.g);
    boolean bool1;
    if ((l1 >= 600000L) && (this.g != 0L)) {
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
      localStringBuilder.append(n);
      localStringBuilder.append(",mBatchSize:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",isRealTime:");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",reportInterval:");
      localStringBuilder.append(l1);
      localStringBuilder.append(",isTimeOk:");
      localStringBuilder.append(bool1);
      QLog.d("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
    }
    if (((bool2) || (bool1) || (m != 0)) && (NetworkUtil.isNetSupport(this.b.getApp())))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[doReportRequest] tryReportInner,reportCount:");
        localStringBuilder.append(n);
        localStringBuilder.append(",mBatchSize:");
        localStringBuilder.append(this.d);
        localStringBuilder.append(",isRealTime:");
        localStringBuilder.append(bool2);
        localStringBuilder.append(",reportInterval:");
        localStringBuilder.append(l1);
        localStringBuilder.append(",isTimeOk:");
        localStringBuilder.append(bool1);
        QLog.d("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
      }
      f();
      e();
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      return;
    }
    if (this.g == 0L) {
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
  
  private void e()
  {
    this.g = NetConnInfoCenter.getServerTimeMillis();
    BaseApplicationImpl.getApplication().getSharedPreferences("spring_hb_report", 0).edit().putLong("last_report_time", this.g).apply();
  }
  
  private void f()
  {
    try
    {
      this.k.clear();
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject3 = this.c.iterator();
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
            localObject2 = (LinkedList)this.k.get(Long.valueOf(((SpringHbReportManager.ReportInfo)localObject4).reqSeq));
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new LinkedList();
              this.k.put(Long.valueOf(((SpringHbReportManager.ReportInfo)localObject4).reqSeq), localObject1);
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
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(",mToReqMap:");
        ((StringBuilder)localObject1).append(this.k);
        ((StringBuilder)localObject1).append(",convertCost:");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
        QLog.d("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = this.k.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (LinkedList)((Map.Entry)localObject3).getValue();
        localObject4 = new newyear_report.NYReportReq();
        ((newyear_report.NYReportReq)localObject4).commonInfo.set(h());
        ((newyear_report.NYReportReq)localObject4).reportItems.set((List)localObject2);
        localObject5 = new newyear_report.SsoReq();
        ((newyear_report.SsoReq)localObject5).data.set((MessageMicro)localObject4);
        localObject4 = a("NY2021Report.report", ((newyear_report.SsoReq)localObject5).toByteArray(), 30000L);
        localObject3 = (Long)((Map.Entry)localObject3).getKey();
        ((NewIntent)localObject4).setObserver(b(((Long)localObject3).longValue()));
        this.b.startServlet((NewIntent)localObject4);
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
      this.k.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("shua2021report_SpringHbReportManager", 1, localThrowable, new Object[0]);
    }
  }
  
  private int g()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    Iterator localIterator = this.c.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      SpringHbReportManager.ReportInfo localReportInfo = (SpringHbReportManager.ReportInfo)localIterator.next();
      if ((!localReportInfo.isSending) && (a(l1, localReportInfo))) {
        m += 1;
      }
    }
    return m;
  }
  
  private newyear_report.NYCommonInfo h()
  {
    newyear_report.NYCommonInfo localNYCommonInfo = new newyear_report.NYCommonInfo();
    localNYCommonInfo.uin.set(this.b.getLongAccountUin());
    String str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    if (!TextUtils.isEmpty(str)) {
      localNYCommonInfo.adcode.set(str);
    }
    localNYCommonInfo.plat.set(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.b.getLongAccountUin());
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
    localStringBuilder.append(i());
    localStringBuilder.append("&plat=");
    localStringBuilder.append(1);
    localStringBuilder.append("&ver=");
    localStringBuilder.append(DeviceInfoUtil.g());
    localStringBuilder.append("&model=");
    localStringBuilder.append(DeviceInfoUtil.u());
    localStringBuilder.append("&qqver=");
    localStringBuilder.append(DeviceInfoUtil.a(this.b.getApp()));
    localStringBuilder.append("&appid=");
    localStringBuilder.append(AppSetting.d());
    localNYCommonInfo.report_array.set(localStringBuilder.toString());
    return localNYCommonInfo;
  }
  
  private static int i()
  {
    int n = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    int m = 6;
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 4)
          {
            if (n != 6) {
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
      m = 3;
    }
    return m;
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
      this.b.getApp().unregisterReceiver(this.l);
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