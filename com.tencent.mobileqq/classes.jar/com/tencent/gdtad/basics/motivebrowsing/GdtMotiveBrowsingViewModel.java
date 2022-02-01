package com.tencent.gdtad.basics.motivebrowsing;

import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "autoCountAfter5Second", "Lrx/Subscription;", "countDownTime", "", "gdtThirdProcessorProxy", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "getGdtThirdProcessorProxy", "()Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "hasCountDown", "", "leftSecond", "leftSecondSubscription", "motiveBrowsingData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/gdtad/basics/motivebrowsing/MotiveBrowsingData;", "getMotiveBrowsingData", "()Landroidx/lifecycle/MutableLiveData;", "msgPathPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "autoCountCheck", "", "callbackJs", "url", "", "onCleared", "onCountDown", "onHandleUrl", "model", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "pauseCountDown", "report", "type", "reportUrl", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "resumeCountDown", "unSubscribe", "subscription", "Companion", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingViewModel
  extends ViewModel
{
  public static final GdtMotiveBrowsingViewModel.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final MutableLiveData<MotiveBrowsingData> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  @NotNull
  private final GdtThirdProcessorProxy jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy = new GdtThirdProcessorProxy();
  private final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  private Subscription jdField_a_of_type_RxSubscription;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Subscription jdField_b_of_type_RxSubscription;
  
  static
  {
    jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingViewModel$Companion = new GdtMotiveBrowsingViewModel.Companion(null);
  }
  
  private final void a(int paramInt, String paramString, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report reportUrl : ");
      localStringBuilder.append(paramString);
      QLog.d("GdtMotiveBrowsingViewModel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy.a(paramInt, 0, paramAdInfo);
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
      localObject1 = this.jdField_a_of_type_JavaUtilRegexPattern.matcher((CharSequence)paramString);
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
          break label353;
        }
        paramString = new JSONObject((String)localObject3).optString("bridgeName");
        if (TextUtils.isEmpty((CharSequence)paramString)) {
          break label353;
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
        paramString = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
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
      label353:
      paramString = "bridge.callback";
    }
  }
  
  private final void a(Subscription paramSubscription)
  {
    if ((paramSubscription != null) && (!paramSubscription.isUnsubscribed())) {
      paramSubscription.unsubscribe();
    }
  }
  
  private final void c()
  {
    a(this.jdField_b_of_type_RxSubscription);
    this.jdField_b_of_type_RxSubscription = ((Subscription)null);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      b();
    }
  }
  
  @NotNull
  public final MutableLiveData<MotiveBrowsingData> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public final void a()
  {
    a(this.jdField_a_of_type_RxSubscription);
    this.jdField_a_of_type_RxSubscription = ((Subscription)null);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "autoCountCheck");
    }
    this.jdField_b_of_type_RxSubscription = Observable.timer(5L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe((Action1)new GdtMotiveBrowsingViewModel.autoCountCheck.1(this));
  }
  
  public final boolean a(@NotNull String paramString, @Nullable GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHandleUrl url: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("GdtMotiveBrowsingViewModel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramGdtMotiveVideoModel != null)
    {
      GdtAd localGdtAd1 = null;
      localObject = null;
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/reportExposureRewardAd/rewardAD", false, 2, null))
      {
        localGdtAd1 = paramGdtMotiveVideoModel.a();
        if (localGdtAd1 != null) {
          localObject = localGdtAd1.getUrlForImpression();
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return false;
        }
        paramGdtMotiveVideoModel = paramGdtMotiveVideoModel.a();
        Intrinsics.checkExpressionValueIsNotNull(paramGdtMotiveVideoModel, "model.adInfo");
        a(0, (String)localObject, paramGdtMotiveVideoModel);
        a(paramString);
        return true;
      }
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/", false, 2, null))
      {
        GdtAd localGdtAd2 = paramGdtMotiveVideoModel.a();
        localObject = localGdtAd1;
        if (localGdtAd2 != null) {
          localObject = localGdtAd2.getUrlForClick();
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return false;
        }
        paramGdtMotiveVideoModel = paramGdtMotiveVideoModel.a();
        Intrinsics.checkExpressionValueIsNotNull(paramGdtMotiveVideoModel, "model.adInfo");
        a(1, (String)localObject, paramGdtMotiveVideoModel);
        a(paramString);
        return true;
      }
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/startCountDown/rewardAD/", false, 2, null))
      {
        c();
        return true;
      }
      return false;
    }
    return true;
  }
  
  public final void b()
  {
    if (this.jdField_a_of_type_RxSubscription == null)
    {
      int i = this.jdField_b_of_type_Int;
      if (i > 0)
      {
        this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(new MotiveBrowsingData(1, null, i, 2, null));
        this.jdField_a_of_type_RxSubscription = Observable.interval(1L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe((Action1)new GdtMotiveBrowsingViewModel.resumeCountDown.1(this));
      }
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onCleared");
    }
    a(this.jdField_a_of_type_RxSubscription);
    Subscription localSubscription = (Subscription)null;
    this.jdField_a_of_type_RxSubscription = localSubscription;
    a(this.jdField_b_of_type_RxSubscription);
    this.jdField_b_of_type_RxSubscription = localSubscription;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingViewModel
 * JD-Core Version:    0.7.0.1
 */