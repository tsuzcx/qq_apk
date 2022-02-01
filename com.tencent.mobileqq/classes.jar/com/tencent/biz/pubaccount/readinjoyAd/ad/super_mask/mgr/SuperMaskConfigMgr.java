package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskConfigMgr;", "", "()V", "CONFIG_KEY_KANDIAN_SUPER_MASK_AD_REQ_SWITCH", "", "adReqNumDaily", "Ljava/util/concurrent/atomic/AtomicInteger;", "getAdReqNumDaily", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAdReqNumDaily", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "adReqNumMainFeeds", "getAdReqNumMainFeeds", "setAdReqNumMainFeeds", "value", "", "aladdinSwitch", "getAladdinSwitch", "()Z", "setAladdinSwitch", "(Z)V", "preloadInterval", "", "getPreloadInterval", "()J", "setPreloadInterval", "(J)V", "preloadTime", "getPreloadTime", "setPreloadTime", "", "previewMode", "getPreviewMode", "()I", "setPreviewMode", "(I)V", "refreshNumDaily", "getRefreshNumDaily", "setRefreshNumDaily", "refreshNumMainFeeds", "getRefreshNumMainFeeds", "setRefreshNumMainFeeds", "getLastShowTime", "channelID", "getReqConfigFromAladding", "getShowConfigFromAladdin", "getSpKey", "currentUin", "refreshDailyReqAndRefreshNum", "", "refreshMainFeedsReqAndRefreshNum", "updateLastShowTime", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskConfigMgr
{
  public static final SuperMaskConfigMgr a = new SuperMaskConfigMgr();
  private static long b = -1L;
  private static long c = 1800L;
  @NotNull
  private static AtomicInteger d = new AtomicInteger(1);
  @NotNull
  private static AtomicInteger e = new AtomicInteger(1);
  @NotNull
  private static AtomicInteger f = new AtomicInteger(1);
  @NotNull
  private static AtomicInteger g = new AtomicInteger(1);
  
  private final String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append("RIJSuperMaskLastShowMaskTimeKey");
    return localStringBuilder.toString();
  }
  
  private final boolean l()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(206);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAladdinConfig != null)
    {
      bool1 = bool2;
      if (localAladdinConfig.getIntegerFromString("ad_mengceng", 0) == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final long a()
  {
    return b;
  }
  
  public final void a(int paramInt)
  {
    Object localObject = ((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getApp();
    } else {
      localObject = null;
    }
    SharedPreUtils.Q((Context)localObject, ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount(), paramInt);
  }
  
  public final void a(long paramLong)
  {
    b = paramLong;
  }
  
  public final long b()
  {
    return c;
  }
  
  public final void b(int paramInt)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "com.tencent.common.app.B…tionImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "com.tencent.common.app.B….getApplication().runtime");
    localObject1 = ((AppRuntime)localObject1).getAccount();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateLastShowTime = ");
    ((StringBuilder)localObject2).append(l);
    QLog.d("ReadInJoySuperMaskAd", 1, ((StringBuilder)localObject2).toString());
    localObject2 = BaseApplicationImpl.getApplication().getSystemSharedPreferences("ReadInJoySuperMaskAd", 0).edit();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "sharedPreferences.edit()");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "currentUin");
    ((SharedPreferences.Editor)localObject2).putLong(a((String)localObject1, paramInt), l);
    ((SharedPreferences.Editor)localObject2).apply();
  }
  
  public final void b(long paramLong)
  {
    c = paramLong;
  }
  
  public final int c()
  {
    Object localObject = ((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getApp();
    } else {
      localObject = null;
    }
    return SharedPreUtils.bw((Context)localObject, ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount());
  }
  
  public final long c(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "com.tencent.common.app.B…tionImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "com.tencent.common.app.B….getApplication().runtime");
    localObject = ((AppRuntime)localObject).getAccount();
    NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences("ReadInJoySuperMaskAd", 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "currentUin");
    return localSharedPreferences.getLong(a((String)localObject, paramInt), -1L);
  }
  
  public final boolean d()
  {
    return l();
  }
  
  public final boolean e()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(206);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAladdinConfig != null)
    {
      bool1 = bool2;
      if (localAladdinConfig.getIntegerFromString("ad_req_switch", 0) == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @NotNull
  public final AtomicInteger f()
  {
    return d;
  }
  
  @NotNull
  public final AtomicInteger g()
  {
    return e;
  }
  
  @NotNull
  public final AtomicInteger h()
  {
    return f;
  }
  
  @NotNull
  public final AtomicInteger i()
  {
    return g;
  }
  
  public final void j()
  {
    QLog.d("ReadInJoySuperMaskAd", 1, "refreshMainFeedsReqAndRefreshNum");
    d.set(0);
    f.set(0);
  }
  
  public final void k()
  {
    QLog.d("ReadInJoySuperMaskAd", 1, "refreshDailyReqAndRefreshNum");
    e.set(0);
    g.set(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr
 * JD-Core Version:    0.7.0.1
 */