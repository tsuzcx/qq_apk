package com.tencent.biz.pubaccount.readinjoy.reward;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJUserLevelTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.IRIJRewardTaskTimingContract.IView;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingPresenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskArticleTimer;", "Lcom/tencent/biz/pubaccount/readinjoy/reward/IRIJRewardTaskTimer;", "()V", "rewardTaskTimingPresenter", "Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingPresenter;", "kotlin.jvm.PlatformType", "getRewardTaskTimingPresenter", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingPresenter;", "rewardTaskTimingPresenter$delegate", "Lkotlin/Lazy;", "stationaryTime", "", "timingHandler", "Landroid/os/Handler;", "getTimingHandler", "()Landroid/os/Handler;", "timingHandler$delegate", "timingRunnable", "Ljava/lang/Runnable;", "attachDebugView", "", "activity", "Lmqq/app/AppActivity;", "enabled", "", "pauseTiming", "resetStationaryTime", "resumeTiming", "rowKey", "", "maxTaskTimeInMs", "startTiming", "stopTiming", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskArticleTimer
  implements IRIJRewardTaskTimer
{
  public static final RIJRewardTaskArticleTimer.Companion a;
  private int jdField_a_of_type_Int;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJRewardTaskArticleTimer.timingHandler.2.INSTANCE);
  private final Lazy b = LazyKt.lazy((Function0)RIJRewardTaskArticleTimer.rewardTaskTimingPresenter.2.INSTANCE);
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskArticleTimer$Companion = new RIJRewardTaskArticleTimer.Companion(null);
  }
  
  private final Handler a()
  {
    return (Handler)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final RIJRewardTaskTimingPresenter a()
  {
    return (RIJRewardTaskTimingPresenter)this.b.getValue();
  }
  
  private final void b(String paramString, int paramInt)
  {
    a().removeCallbacksAndMessages(null);
    QLog.i("RIJRewardTaskArticleTimer", 1, "resume timing:  stationaryTime: " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new RIJRewardTaskArticleTimer.resumeTiming.1(this, paramString, paramInt));
    a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  @JvmStatic
  public static final boolean b()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskArticleTimer$Companion.a();
  }
  
  private final void c()
  {
    a().a();
    QLog.i("RIJRewardTaskArticleTimer", 1, "pause timing");
    a().removeCallbacksAndMessages(null);
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
    c();
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    if (!a()) {
      return;
    }
    b(paramString, paramInt);
  }
  
  public final void a(@NotNull AppActivity paramAppActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramAppActivity, "activity");
    if (!ReadInJoyHelper.k(paramAppActivity.getAppRuntime())) {
      return;
    }
    Object localObject = paramAppActivity.findViewById(16908290);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    if (((ViewGroup)localObject).findViewById(2131376609) == null) {
      ((ViewGroup)localObject).addView(LayoutInflater.from((Context)paramAppActivity).inflate(2131562892, (ViewGroup)localObject, false));
    }
    paramAppActivity = (IRIJRewardTaskTimingContract.IView)new RIJRewardTaskArticleTimer.attachDebugView.view.1((TextView)((ViewGroup)localObject).findViewById(2131379733), (TextView)((ViewGroup)localObject).findViewById(2131363064), (TextView)((ViewGroup)localObject).findViewById(2131363065), (TextView)((ViewGroup)localObject).findViewById(2131379727), (TextView)((ViewGroup)localObject).findViewById(2131365502));
    a().a(paramAppActivity);
  }
  
  public boolean a()
  {
    return (RIJRewardTaskConfig.a()) || (RIJUserLevelTimeUtils.a());
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskArticleTimer
 * JD-Core Version:    0.7.0.1
 */