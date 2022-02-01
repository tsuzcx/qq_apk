package com.tencent.gdtad.basics.motivebrowsing;

import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingExperimentReportHelper$ReportCallback;", "()V", "autoCountAfter5Second", "Lrx/Subscription;", "countDownTime", "", "gdtThirdProcessorProxy", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "getGdtThirdProcessorProxy", "()Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "hasCountDown", "", "leftSecond", "leftSecondSubscription", "mGdtMotiveBrowsingExperimentReportHelper", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingExperimentReportHelper;", "getMGdtMotiveBrowsingExperimentReportHelper", "()Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingExperimentReportHelper;", "motiveBrowsingData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/gdtad/basics/motivebrowsing/MotiveBrowsingData;", "getMotiveBrowsingData", "()Landroidx/lifecycle/MutableLiveData;", "msgPathPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "autoCountCheck", "", "callbackJs", "url", "", "onCleared", "onCountDown", "onHandleUrl", "model", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "onReport", "pauseCountDown", "report", "type", "reportUrl", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "resumeCountDown", "unSubscribe", "subscription", "Companion", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingViewModel
  extends ViewModel
  implements GdtMotiveBrowsingExperimentReportHelper.ReportCallback
{
  public static final GdtMotiveBrowsingViewModel.Companion a = new GdtMotiveBrowsingViewModel.Companion(null);
  private Subscription b;
  private Subscription c;
  private boolean d;
  @NotNull
  private final MutableLiveData<MotiveBrowsingData> e = new MutableLiveData();
  private int f;
  private final Pattern g = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  private int h;
  @NotNull
  private final GdtThirdProcessorProxy i = new GdtThirdProcessorProxy();
  @NotNull
  private final GdtMotiveBrowsingExperimentReportHelper j = new GdtMotiveBrowsingExperimentReportHelper();
  
  private final void a(int paramInt, String paramString, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report reportUrl : ");
      localStringBuilder.append(paramString);
      QLog.d("GdtMotiveBrowsingViewModel", 2, localStringBuilder.toString());
    }
    this.i.a(paramInt, 0, paramAdInfo);
    ThreadManager.excute((Runnable)new GdtMotiveBrowsingViewModel.report.1(paramString), 128, null, true);
  }
  
  private final void a(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("callbackJs url : ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("GdtMotiveBrowsingViewModel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = Uri.parse(paramString);
    Object localObject3;
    if (localObject2 != null)
    {
      paramString = ((Uri)localObject2).getPath();
      localObject1 = this.g.matcher((CharSequence)paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "msgPathPattern.matcher(path)");
      if (((Matcher)localObject1).matches())
      {
        paramString = ((Matcher)localObject1).group(2);
        localObject1 = ((Matcher)localObject1).group(3);
        localObject3 = ((Uri)localObject2).getQueryParameter("q");
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("action", paramString);
        ((JSONObject)localObject2).put("data", localJSONObject);
        ((JSONObject)localObject2).put("code", 0);
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label354;
        }
        paramString = new JSONObject((String)localObject3).optString("bridgeName");
        if (TextUtils.isEmpty((CharSequence)paramString)) {
          break label354;
        }
        Intrinsics.checkExpressionValueIsNotNull(paramString, "paramBridgeName");
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("callbackid", localObject1);
        ((JSONObject)localObject3).put("status", 0);
        ((JSONObject)localObject3).put("data", ((JSONObject)localObject2).toString());
        ((JSONObject)localObject3).put("keep", 0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(((JSONObject)localObject3).toString());
        ((StringBuilder)localObject1).append(");");
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("callbackJs script: ");
          paramString.append(localObject1);
          QLog.d("GdtMotiveBrowsingViewModel", 2, paramString.toString());
        }
        paramString = this.e;
        localObject1 = ((StringBuilder)localObject1).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "sb.toString()");
        paramString.setValue(new MotiveBrowsingData(0, (String)localObject1, 0, 4, null));
        return;
      }
      catch (Throwable paramString)
      {
        QLog.d("GdtMotiveBrowsingViewModel", 2, paramString, new Object[0]);
      }
      return;
      label354:
      paramString = "bridge.callback";
    }
  }
  
  private final void a(Subscription paramSubscription)
  {
    if ((paramSubscription != null) && (!paramSubscription.isUnsubscribed())) {
      paramSubscription.unsubscribe();
    }
  }
  
  private final void e()
  {
    a(this.c);
    this.c = ((Subscription)null);
    if (!this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown");
      }
      this.d = true;
      this.h = this.f;
      d();
    }
  }
  
  @NotNull
  public final MutableLiveData<MotiveBrowsingData> a()
  {
    return this.e;
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "autoCountCheck");
    }
    this.c = Observable.timer(5L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe((Action1)new GdtMotiveBrowsingViewModel.autoCountCheck.1(this));
  }
  
  public void a(@NotNull String paramString, @Nullable GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onHandleUrl url: ");
    ((StringBuilder)localObject1).append(paramString);
    GdtLog.b("GdtMotiveBrowsingViewModel", ((StringBuilder)localObject1).toString());
    if (paramGdtMotiveVideoModel != null)
    {
      localObject1 = null;
      Object localObject2 = null;
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/reportExposureRewardAd/rewardAD", false, 2, null))
      {
        localObject1 = paramGdtMotiveVideoModel.d();
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = ((GdtAd)localObject1).getUrlForImpression();
        }
        if (TextUtils.isEmpty((CharSequence)paramString)) {
          return;
        }
        paramGdtMotiveVideoModel = paramGdtMotiveVideoModel.b();
        Intrinsics.checkExpressionValueIsNotNull(paramGdtMotiveVideoModel, "model.adInfo");
        a(0, paramString, paramGdtMotiveVideoModel);
        return;
      }
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/", false, 2, null))
      {
        paramString = paramGdtMotiveVideoModel.d();
        if (paramString != null) {
          paramString = paramString.getUrlForClick();
        } else {
          paramString = null;
        }
        if (TextUtils.isEmpty((CharSequence)paramString)) {
          return;
        }
        if (paramString != null) {
          localObject1 = this.j.a(paramString);
        }
        paramString = paramGdtMotiveVideoModel.b();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "model.adInfo");
        a(1, (String)localObject1, paramString);
      }
    }
  }
  
  @NotNull
  public final GdtMotiveBrowsingExperimentReportHelper b()
  {
    return this.j;
  }
  
  public final boolean b(@NotNull String paramString, @Nullable GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onHandleUrl url: ");
    ((StringBuilder)localObject).append(paramString);
    GdtLog.b("GdtMotiveBrowsingViewModel", ((StringBuilder)localObject).toString());
    if (paramGdtMotiveVideoModel != null)
    {
      GdtAd localGdtAd1 = null;
      localObject = null;
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/reportExposureRewardAd/rewardAD", false, 2, null))
      {
        localGdtAd1 = paramGdtMotiveVideoModel.d();
        Intrinsics.checkExpressionValueIsNotNull(localGdtAd1, "it.gdtAd");
        if (localGdtAd1.isMotiveBrowserStatisticsExperiment()) {
          return false;
        }
        localGdtAd1 = paramGdtMotiveVideoModel.d();
        if (localGdtAd1 != null) {
          localObject = localGdtAd1.getUrlForImpression();
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return false;
        }
        paramGdtMotiveVideoModel = paramGdtMotiveVideoModel.b();
        Intrinsics.checkExpressionValueIsNotNull(paramGdtMotiveVideoModel, "model.adInfo");
        a(0, (String)localObject, paramGdtMotiveVideoModel);
        a(paramString);
        return true;
      }
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/", false, 2, null))
      {
        localObject = paramGdtMotiveVideoModel.d();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.gdtAd");
        if (((GdtAd)localObject).isMotiveBrowserStatisticsExperiment()) {
          return false;
        }
        GdtAd localGdtAd2 = paramGdtMotiveVideoModel.d();
        localObject = localGdtAd1;
        if (localGdtAd2 != null) {
          localObject = localGdtAd2.getUrlForClick();
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return false;
        }
        paramGdtMotiveVideoModel = paramGdtMotiveVideoModel.b();
        Intrinsics.checkExpressionValueIsNotNull(paramGdtMotiveVideoModel, "model.adInfo");
        a(1, (String)localObject, paramGdtMotiveVideoModel);
        a(paramString);
        return true;
      }
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/startCountDown/rewardAD/", false, 2, null))
      {
        e();
        return true;
      }
      return false;
    }
    return true;
  }
  
  public final void c()
  {
    a(this.b);
    this.b = ((Subscription)null);
  }
  
  public final void d()
  {
    if (this.b == null)
    {
      int k = this.h;
      if (k > 0)
      {
        this.e.setValue(new MotiveBrowsingData(1, null, k, 2, null));
        this.b = Observable.interval(1L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe((Action1)new GdtMotiveBrowsingViewModel.resumeCountDown.1(this));
      }
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onCleared");
    }
    a(this.b);
    Subscription localSubscription = (Subscription)null;
    this.b = localSubscription;
    a(this.c);
    this.c = localSubscription;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingViewModel
 * JD-Core Version:    0.7.0.1
 */