package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdMiniGameGuideManager;", "", "()V", "MINIGAME_COUNT", "", "TAG", "dayLimit", "", "enterTime", "", "getEnterTime", "()Ljava/lang/Long;", "setEnterTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "followListener", "Lcom/tencent/mobileqq/kandian/repo/follow/IFollowStatusObserver;", "isAllowShow", "", "isFollowedSmallGame", "()Z", "setFollowedSmallGame", "(Z)V", "isRegister", "miniAppNotifyListener", "Lcom/tencent/mobileqq/mini/notify/MiniAppNotify$IMiniAppNotifyListener;", "smallGameViews", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/adsmallgame/IAdMiniGamePts;", "stayTime", "addSmallGameView", "", "ptsView", "checkIsAllowShow", "checkIsFollowed", "destory", "followMiniGameAccount", "gameId", "isDifferentDay", "recordTime", "leftSlideCard", "view", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "position", "notifySmallGameView", "appid", "registerMini", "resetSlideCard", "isReset", "resetView", "setLimitConfig", "slideAnimStart", "distance", "", "slideCard", "stayTimeValid", "(Ljava/lang/Long;)Z", "unRegisterMini", "updateShowInfo", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdMiniGameGuideManager
{
  private static int jdField_a_of_type_Int;
  public static final AdMiniGameGuideManager a;
  private static IFollowStatusObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFollowIFollowStatusObserver = (IFollowStatusObserver)AdMiniGameGuideManager.followListener.1.a;
  private static final MiniAppNotify.IMiniAppNotifyListener jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener;
  @Nullable
  private static Long jdField_a_of_type_JavaLangLong;
  private static ConcurrentHashMap<Integer, SoftReference<IAdMiniGamePts>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  private static boolean jdField_b_of_type_Boolean;
  private static boolean c;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsAdMiniGameGuideManager = new AdMiniGameGuideManager();
    jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = 180000;
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener = (MiniAppNotify.IMiniAppNotifyListener)AdMiniGameGuideManager.miniAppNotifyListener.1.a;
  }
  
  private final void a(ViewBase paramViewBase, float paramFloat)
  {
    try
    {
      paramViewBase.getNativeView().clearAnimation();
      ObjectAnimator.ofFloat(paramViewBase.getNativeView(), "translationX", new float[] { paramFloat }).setDuration(500L).start();
      return;
    }
    catch (Exception paramViewBase)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ad mini game SlideCard error : ");
      localStringBuilder.append(paramViewBase.getMessage());
      QLog.e("AdMiniGameUtil", 2, localStringBuilder.toString());
    }
  }
  
  private final void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    QLog.d("AdMiniGameUtil", 2, "ad mini game leftSlideCard");
    ThreadManager.getUIHandler().postDelayed((Runnable)new AdMiniGameGuideManager.leftSlideCard.1(paramViewBase, paramAbsBaseArticleInfo, paramInt), 1000L);
  }
  
  private final boolean a()
  {
    if (a(SharedPreUtils.f((Context)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount())))
    {
      QLog.d("AdMiniGameUtil", 2, "is different day showNum 0");
      SharedPreUtils.N((Context)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount(), 0);
      return true;
    }
    int i = SharedPreUtils.av((Context)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is same day showNum ");
    localStringBuilder.append(i);
    localStringBuilder.append("  dayLimit ");
    localStringBuilder.append(jdField_b_of_type_Int);
    QLog.d("AdMiniGameUtil", 2, localStringBuilder.toString());
    if (jdField_b_of_type_Int > i)
    {
      QLog.d("AdMiniGameUtil", 2, "is same day dayLimit > showNum ");
      return true;
    }
    return false;
  }
  
  private final boolean a(long paramLong)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        Object localObject = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "Calendar.getInstance()");
        int i = ((Calendar)localObject).get(5);
        ((Calendar)localObject).setTime(new Date(paramLong));
        int j = ((Calendar)localObject).get(5);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("today  ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("  recordDay ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("  isDifferent:");
        if (i != j)
        {
          bool1 = true;
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(' ');
          QLog.e("AdMiniGameUtil", 2, ((StringBuilder)localObject).toString());
          bool1 = bool2;
          if (i != j) {
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("AdMiniGameUtil", 2, String.valueOf(localException.getMessage()));
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  private final boolean a(Long paramLong)
  {
    boolean bool = false;
    if (paramLong == null) {
      return false;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - paramLong.longValue() > jdField_a_of_type_Int) {
      bool = true;
    }
    paramLong = new StringBuilder();
    paramLong.append("stayTimeValid ");
    paramLong.append(bool);
    QLog.e("AdMiniGameUtil", 2, paramLong.toString());
    return bool;
  }
  
  private final void b(ViewBase paramViewBase, boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ad mini game resetSlideCard ");
    localStringBuilder.append(paramBoolean);
    QLog.d("AdMiniGameUtil", 2, localStringBuilder.toString());
    long l;
    if (paramBoolean) {
      l = 0L;
    } else {
      l = 6000L;
    }
    int i;
    if (paramBoolean) {
      i = 5040704;
    } else {
      i = 5040705;
    }
    ThreadManager.getUIHandler().postDelayed((Runnable)new AdMiniGameGuideManager.resetSlideCard.1(paramViewBase, paramAbsBaseArticleInfo, paramInt, i), l);
  }
  
  private final void d()
  {
    if (!c)
    {
      c = true;
      try
      {
        MiniAppNotify.g.register(jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registerMini : ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("AdMiniGameUtil", 2, localStringBuilder.toString());
      }
    }
  }
  
  private final void e()
  {
    try
    {
      c = false;
      MiniAppNotify.g.remove(jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregisterMini : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("AdMiniGameUtil", 2, localStringBuilder.toString());
    }
  }
  
  private final void f()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(416);
    jdField_b_of_type_Int = localAladdinConfig.getIntegerFromString("show_frequency_per_day", 1);
    jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("play_time", 180) * 1000;
  }
  
  public final void a()
  {
    d();
    f();
    jdField_b_of_type_Boolean = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFollowed :  isAllowShow ");
      localStringBuilder.append(jdField_b_of_type_Boolean);
      QLog.d("AdMiniGameUtil", 2, localStringBuilder.toString());
    }
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    ThreadUtil.postOnSubThread((Runnable)AdMiniGameGuideManager.checkIsFollowed.1.a);
  }
  
  public final void a(@Nullable ViewBase paramViewBase, boolean paramBoolean, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ad mini game slideCard ");
    localStringBuilder.append(paramBoolean);
    QLog.d("AdMiniGameUtil", 2, localStringBuilder.toString());
    b(paramViewBase, paramBoolean, paramAbsBaseArticleInfo, paramInt);
    if (!paramBoolean) {
      a(paramViewBase, paramAbsBaseArticleInfo, paramInt);
    }
  }
  
  public final void a(@Nullable IAdMiniGamePts paramIAdMiniGamePts)
  {
    if (paramIAdMiniGamePts == null) {
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    SoftReference localSoftReference = new SoftReference(paramIAdMiniGamePts);
    ConcurrentHashMap localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      paramIAdMiniGamePts = (SoftReference)localConcurrentHashMap.put(Integer.valueOf(System.identityHashCode(paramIAdMiniGamePts)), localSoftReference);
    }
  }
  
  public final void a(@Nullable Long paramLong)
  {
    jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    ((IUserOperationModule)QRoute.api(IUserOperationModule.class)).request0x978(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount(), "1001008899179", true, "", (Ox978RespCallBack)new AdMiniGameGuideManager.followMiniGameAccount.1(paramString));
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void b()
  {
    try
    {
      SharedPreUtils.e((Context)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount(), NetConnInfoCenter.getServerTimeMillis());
      int i = SharedPreUtils.av((Context)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount()) + 1;
      SharedPreUtils.N((Context)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount(), i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShowInfo showNum ");
      localStringBuilder.append(i);
      QLog.d("AdMiniGameUtil", 2, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("AdMiniGameUtil", 2, String.valueOf(localException.getMessage()));
    }
  }
  
  public final void b(@Nullable String paramString)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = jdField_a_of_type_JavaLangLong;
    if ((localObject1 != null) && (a((Long)localObject1)) && (jdField_b_of_type_Boolean) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      localObject1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if ((((SoftReference)((Map.Entry)localObject2).getValue()).get() != null) && ((((SoftReference)((Map.Entry)localObject2).getValue()).get() instanceof IAdMiniGamePts)))
          {
            localObject2 = ((SoftReference)((Map.Entry)localObject2).getValue()).get();
            if (localObject2 != null) {
              ((IAdMiniGamePts)localObject2).a(paramString, false);
            } else {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts");
            }
          }
        }
      }
    }
  }
  
  public final void c()
  {
    ConcurrentHashMap localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = (ConcurrentHashMap)null;
    e();
  }
  
  public final void c(@Nullable String paramString)
  {
    QLog.d("AdMiniGameUtil", 2, "resetView");
    Object localObject1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((SoftReference)((Map.Entry)localObject2).getValue()).get() != null) && ((((SoftReference)((Map.Entry)localObject2).getValue()).get() instanceof IAdMiniGamePts)))
        {
          localObject2 = ((SoftReference)((Map.Entry)localObject2).getValue()).get();
          if (localObject2 != null) {
            ((IAdMiniGamePts)localObject2).a(paramString, true);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager
 * JD-Core Version:    0.7.0.1
 */