package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.FollowStatusObserver;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdMiniGameGuideManager;", "", "()V", "MINIGAME_COUNT", "", "TAG", "dayLimit", "", "enterTime", "", "getEnterTime", "()Ljava/lang/Long;", "setEnterTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "followListener", "Lcom/tencent/biz/pubaccount/readinjoy/model/FollowListInfoModule$FollowStatusObserver;", "isAllowShow", "", "isFollowedSmallGame", "()Z", "setFollowedSmallGame", "(Z)V", "isRegister", "miniAppNotifyListener", "Lcom/tencent/mobileqq/mini/notify/MiniAppNotify$IMiniAppNotifyListener;", "smallGameViews", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/adsmallgame/IAdMiniGamePts;", "stayTime", "addSmallGameView", "", "ptsView", "checkIsAllowShow", "checkIsFollowed", "destory", "followMiniGameAccount", "gameId", "isDifferentDay", "recordTime", "leftSlideCard", "view", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "position", "notifySmallGameView", "appid", "registerMini", "resetSlideCard", "isReset", "resetView", "setLimitConfig", "slideAnimStart", "distance", "", "slideCard", "stayTimeValid", "(Ljava/lang/Long;)Z", "unRegisterMini", "updateShowInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AdMiniGameGuideManager
{
  private static int jdField_a_of_type_Int;
  private static FollowListInfoModule.FollowStatusObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule$FollowStatusObserver = (FollowListInfoModule.FollowStatusObserver)AdMiniGameGuideManager.followListener.1.a;
  public static final AdMiniGameGuideManager a;
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
      QLog.e("AdMiniGameUtil", 2, "ad mini game SlideCard error : " + paramViewBase.getMessage());
    }
  }
  
  private final void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo, int paramInt)
  {
    QLog.d("AdMiniGameUtil", 2, "ad mini game leftSlideCard");
    ThreadManager.getUIHandler().postDelayed((Runnable)new AdMiniGameGuideManager.leftSlideCard.1(paramViewBase, paramArticleInfo, paramInt), 1000L);
  }
  
  private final boolean a()
  {
    Object localObject = ReadInJoyUtils.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime()");
    localObject = (Context)((AppRuntime)localObject).getApplication();
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "ReadInJoyUtils.getAppRuntime()");
    if (a(SharedPreUtils.i((Context)localObject, localAppRuntime.getAccount())))
    {
      QLog.d("AdMiniGameUtil", 2, "is different day showNum 0");
      localObject = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime()");
      localObject = (Context)((AppRuntime)localObject).getApplication();
      localAppRuntime = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "ReadInJoyUtils.getAppRuntime()");
      SharedPreUtils.W((Context)localObject, localAppRuntime.getAccount(), 0);
      return true;
    }
    localObject = ReadInJoyUtils.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime()");
    localObject = (Context)((AppRuntime)localObject).getApplication();
    localAppRuntime = ReadInJoyUtils.a();
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "ReadInJoyUtils.getAppRuntime()");
    int i = SharedPreUtils.aC((Context)localObject, localAppRuntime.getAccount());
    QLog.d("AdMiniGameUtil", 2, "is same day showNum " + i + "  dayLimit " + jdField_b_of_type_Int);
    if (jdField_b_of_type_Int > i)
    {
      QLog.d("AdMiniGameUtil", 2, "is same day dayLimit > showNum ");
      return true;
    }
    return false;
  }
  
  private final boolean a(long paramLong)
  {
    try
    {
      Object localObject = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Calendar.getInstance()");
      int i = ((Calendar)localObject).get(5);
      ((Calendar)localObject).setTime(new Date(paramLong));
      int j = ((Calendar)localObject).get(5);
      localObject = new StringBuilder().append("today  ").append(i).append("  recordDay ").append(j).append("  isDifferent:");
      if (i != j) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("AdMiniGameUtil", 2, bool + ' ');
        if (i == j) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("AdMiniGameUtil", 2, String.valueOf(localException.getMessage()));
    }
    return false;
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
    QLog.e("AdMiniGameUtil", 2, "stayTimeValid " + bool);
    return bool;
  }
  
  private final void b(ViewBase paramViewBase, boolean paramBoolean, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("AdMiniGameUtil", 2, "ad mini game resetSlideCard " + paramBoolean);
    long l;
    if (paramBoolean)
    {
      l = 0L;
      if (!paramBoolean) {
        break label81;
      }
    }
    label81:
    for (int i = 5040704;; i = 5040705)
    {
      ThreadManager.getUIHandler().postDelayed((Runnable)new AdMiniGameGuideManager.resetSlideCard.1(paramViewBase, paramArticleInfo, paramInt, i), l);
      return;
      l = 6000L;
      break;
    }
  }
  
  private final void d()
  {
    if (!c) {
      c = true;
    }
    try
    {
      MiniAppNotify.g.register(jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AdMiniGameUtil", 2, "registerMini : " + localException.getMessage());
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
      QLog.e("AdMiniGameUtil", 2, "unregisterMini : " + localException.getMessage());
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
    if (QLog.isColorLevel()) {
      QLog.d("AdMiniGameUtil", 2, "checkFollowed :  isAllowShow " + jdField_b_of_type_Boolean);
    }
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    ThreadUtil.postOnSubThread((Runnable)AdMiniGameGuideManager.checkIsFollowed.1.a);
  }
  
  public final void a(@Nullable ViewBase paramViewBase, boolean paramBoolean, @Nullable ArticleInfo paramArticleInfo, int paramInt)
  {
    QLog.d("AdMiniGameUtil", 2, "ad mini game slideCard " + paramBoolean);
    b(paramViewBase, paramBoolean, paramArticleInfo, paramInt);
    if (!paramBoolean) {
      a(paramViewBase, paramArticleInfo, paramInt);
    }
  }
  
  public final void a(@Nullable IAdMiniGamePts paramIAdMiniGamePts)
  {
    if (paramIAdMiniGamePts == null) {}
    SoftReference localSoftReference;
    ConcurrentHashMap localConcurrentHashMap;
    do
    {
      return;
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      localSoftReference = new SoftReference(paramIAdMiniGamePts);
      localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    } while (localConcurrentHashMap == null);
    paramIAdMiniGamePts = (SoftReference)localConcurrentHashMap.put(Integer.valueOf(System.identityHashCode(paramIAdMiniGamePts)), localSoftReference);
  }
  
  public final void a(@Nullable Long paramLong)
  {
    jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    Object localObject = ReadInJoyLogicEngine.a();
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicEngine)localObject).a();
      if (localObject != null)
      {
        AppRuntime localAppRuntime = ReadInJoyUtils.a();
        Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "ReadInJoyUtils.getAppRuntime()");
        ((UserOperationModule)localObject).a(localAppRuntime.getAccount(), "1001008899179", true, "", (UserOperationModule.Ox978RespCallBack)new AdMiniGameGuideManager.followMiniGameAccount.1(paramString));
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void b()
  {
    try
    {
      Object localObject = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime()");
      localObject = (Context)((AppRuntime)localObject).getApplication();
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "ReadInJoyUtils.getAppRuntime()");
      SharedPreUtils.h((Context)localObject, localAppRuntime.getAccount(), NetConnInfoCenter.getServerTimeMillis());
      localObject = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime()");
      localObject = (Context)((AppRuntime)localObject).getApplication();
      localAppRuntime = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "ReadInJoyUtils.getAppRuntime()");
      int i = SharedPreUtils.aC((Context)localObject, localAppRuntime.getAccount()) + 1;
      localObject = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime()");
      localObject = (Context)((AppRuntime)localObject).getApplication();
      localAppRuntime = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "ReadInJoyUtils.getAppRuntime()");
      SharedPreUtils.W((Context)localObject, localAppRuntime.getAccount(), i);
      QLog.d("AdMiniGameUtil", 2, "updateShowInfo showNum " + i);
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
      break label6;
    }
    for (;;)
    {
      label6:
      return;
      if ((jdField_a_of_type_JavaLangLong != null) && (a(jdField_a_of_type_JavaLangLong)) && (jdField_b_of_type_Boolean) && (!TextUtils.isEmpty((CharSequence)paramString)))
      {
        Object localObject1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if ((((SoftReference)((Map.Entry)localObject2).getValue()).get() != null) && ((((SoftReference)((Map.Entry)localObject2).getValue()).get() instanceof IAdMiniGamePts)))
          {
            localObject2 = ((SoftReference)((Map.Entry)localObject2).getValue()).get();
            if (localObject2 == null) {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts");
            }
            ((IAdMiniGamePts)localObject2).a(paramString, false);
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
          if (localObject2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts");
          }
          ((IAdMiniGamePts)localObject2).a(paramString, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager
 * JD-Core Version:    0.7.0.1
 */