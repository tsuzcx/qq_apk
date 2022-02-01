package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskConfigMgr;", "", "()V", "CONFIG_KEY_KANDIAN_SUPER_MASK_AD_REQ_SWITCH", "", "CONFIG_KEY_KANDIAN_SUPER_MASK_AD_SWITCH", "RIJSUPER_MASK_LAST_SHOW_MASK_TIME_KEY", "SuperMaskTag", "adReqNumDaily", "Ljava/util/concurrent/atomic/AtomicInteger;", "getAdReqNumDaily", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAdReqNumDaily", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "adReqNumMainFeeds", "getAdReqNumMainFeeds", "setAdReqNumMainFeeds", "value", "", "aladdinSwitch", "getAladdinSwitch", "()Z", "setAladdinSwitch", "(Z)V", "preloadInterval", "", "getPreloadInterval", "()J", "setPreloadInterval", "(J)V", "preloadTag", "preloadTime", "getPreloadTime", "setPreloadTime", "", "previewMode", "getPreviewMode", "()I", "setPreviewMode", "(I)V", "refreshNumDaily", "getRefreshNumDaily", "setRefreshNumDaily", "refreshNumMainFeeds", "getRefreshNumMainFeeds", "setRefreshNumMainFeeds", "requestTag", "showTag", "getLastShowTime", "channelID", "getReqConfigFromAladding", "getShowConfigFromAladdin", "getSpKey", "currentUin", "refreshDailyReqAndRefreshNum", "", "refreshMainFeedsReqAndRefreshNum", "updateLastShowTime", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskConfigMgr
{
  private static long jdField_a_of_type_Long;
  public static final SuperMaskConfigMgr a;
  @NotNull
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  private static long jdField_b_of_type_Long;
  @NotNull
  private static AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  @NotNull
  private static AtomicInteger c = new AtomicInteger(1);
  @NotNull
  private static AtomicInteger d = new AtomicInteger(1);
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskConfigMgr = new SuperMaskConfigMgr();
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Long = 1800L;
  }
  
  private final String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt + "_" + "RIJSuperMaskLastShowMaskTimeKey";
  }
  
  private final boolean c()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(206);
    if (localAladdinConfig != null) {
      return localAladdinConfig.getIntegerFromString("ad_mengceng", 0) == 1;
    }
    return false;
  }
  
  public final int a()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "RIJQQAppInterfaceUtil.getQQApp()");
    return SharedPreUtils.aB((Context)localQQAppInterface.getApp(), ReadInJoyUtils.a());
  }
  
  public final long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public final long a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
    localObject = ((AppRuntime)localObject).getAccount();
    NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences("ReadInJoySuperMaskAd", 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "currentUin");
    return localSharedPreferences.getLong(a((String)localObject, paramInt), -1L);
  }
  
  @NotNull
  public final AtomicInteger a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public final void a()
  {
    QLog.d("ReadInJoySuperMaskAd", 1, "refreshMainFeedsReqAndRefreshNum");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    c.set(0);
  }
  
  public final void a(int paramInt)
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "RIJQQAppInterfaceUtil.getQQApp()");
    SharedPreUtils.V((Context)localQQAppInterface.getApp(), ReadInJoyUtils.a(), paramInt);
  }
  
  public final void a(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public final boolean a()
  {
    return c();
  }
  
  public final long b()
  {
    return jdField_b_of_type_Long;
  }
  
  @NotNull
  public final AtomicInteger b()
  {
    return jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public final void b()
  {
    QLog.d("ReadInJoySuperMaskAd", 1, "refreshDailyReqAndRefreshNum");
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    d.set(0);
  }
  
  public final void b(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
    localObject = ((AppRuntime)localObject).getAccount();
    long l = NetConnInfoCenter.getServerTimeMillis();
    QLog.d("ReadInJoySuperMaskAd", 1, "updateLastShowTime = " + l);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences("ReadInJoySuperMaskAd", 0).edit();
    Intrinsics.checkExpressionValueIsNotNull(localEditor, "sharedPreferences.edit()");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "currentUin");
    localEditor.putLong(a((String)localObject, paramInt), l);
    localEditor.apply();
  }
  
  public final void b(long paramLong)
  {
    jdField_b_of_type_Long = paramLong;
  }
  
  public final boolean b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(206);
    if (localAladdinConfig != null) {
      return localAladdinConfig.getIntegerFromString("ad_req_switch", 0) == 1;
    }
    return false;
  }
  
  @NotNull
  public final AtomicInteger c()
  {
    return c;
  }
  
  @NotNull
  public final AtomicInteger d()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr
 * JD-Core Version:    0.7.0.1
 */