package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.experiment.AdExperimentData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.experiment.AdExperimentData.VideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide.AdGuideClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdVideo185UIStateUtil;", "", "()V", "ANIMATE_IN", "", "ANIMATE_OUT", "HORIZONTAL", "TAG", "", "VERTICAL", "fillVideoBeforeEndGuide", "", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;", "guideView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/ReadInJoyAdVideoGuide;", "getBtnText", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "context", "Landroid/content/Context;", "handleCompleteState", "playManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager;", "hideThirdAdBarWithAnimate", "logAdConfig", "maskTranslateAnimate", "orientation", "type", "view", "Landroid/view/View;", "duration", "repeatCount", "onProgressUpdate", "adVideoFeedsManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/RecommendADVideoFeedsManager;", "updateGuideBtnText", "highLightBar", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/ReadInJoyVideoAdHighLightBar;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AdVideo185UIStateUtil
{
  public static final AdVideo185UIStateUtil a = new AdVideo185UIStateUtil();
  
  private final String a(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if ((paramAdvertisementInfo == null) || ((int)paramAdvertisementInfo.mChannelID != 0)) {
      return "";
    }
    String str1 = paramAdvertisementInfo.mAdExtInfo;
    String str2;
    if (str1 != null)
    {
      str2 = paramAdvertisementInfo.mAdExt;
      if (str2 == null) {
        break label57;
      }
    }
    for (;;)
    {
      if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramAdvertisementInfo)) {
        break label64;
      }
      return "";
      str1 = "";
      break;
      label57:
      str2 = "";
    }
    label64:
    if (!AdvertisementInfo.isAppAdvertisementInfo((BaseArticleInfo)paramAdvertisementInfo))
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mAdBtnTxt;
      if (!TextUtils.isEmpty((CharSequence)paramAdvertisementInfo))
      {
        Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "mAdBtnTxt");
        return paramAdvertisementInfo;
      }
      return "查看详情";
    }
    int i = ReadInJoyAdUtils.a(paramAdvertisementInfo);
    if (i == 2)
    {
      paramAdvertisementInfo = new JSONObject(str1).optString("game_pkg_name");
      Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "jsonObject.optString(Rea…SwitchUtil.GAME_PKG_NAME)");
      if (!AdDownloadUtil.a(paramAdvertisementInfo)) {
        break label178;
      }
      if (i != 2) {
        break label172;
      }
      paramAdvertisementInfo = "打开";
    }
    for (;;)
    {
      return paramAdvertisementInfo;
      paramAdvertisementInfo = new JSONObject(str2).optString("pkg_name");
      Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "jsonObject.optString(\"pkg_name\")");
      break;
      label172:
      paramAdvertisementInfo = "立即打开";
      continue;
      label178:
      if (ADBaseAppDownloadManager.a(paramContext, paramAdvertisementInfo))
      {
        if (i == 2) {
          paramAdvertisementInfo = "安装";
        } else {
          paramAdvertisementInfo = "立即安装";
        }
      }
      else if (i == 2) {
        paramAdvertisementInfo = "下载";
      } else {
        paramAdvertisementInfo = "立即下载";
      }
    }
  }
  
  private final void a(int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4)
  {
    Object localObject;
    label26:
    float f4;
    float f1;
    float f2;
    if (paramView != null)
    {
      paramView.setVisibility(0);
      if (paramInt1 != 0) {
        break label183;
      }
      localObject = "translationX";
      if (paramInt1 != 0) {
        break label190;
      }
      paramInt1 = paramView.getWidth();
      if (paramInt2 != 0) {
        break label198;
      }
      f4 = 2 * paramInt1;
      f1 = 1.0F;
      f2 = 0.0F;
    }
    for (float f3 = 0.0F;; f3 = 1.0F)
    {
      localObject = ObjectAnimator.ofFloat(paramView, (String)localObject, new float[] { f4, f2 });
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this");
      ((ObjectAnimator)localObject).setRepeatCount(paramInt4);
      paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { f3, f1 });
      Intrinsics.checkExpressionValueIsNotNull(paramView, "this");
      paramView.setRepeatCount(paramInt4);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(paramInt3 * 11 / 10);
      localAnimatorSet.playSequentially(new Animator[] { (Animator)paramView, (Animator)localObject });
      localAnimatorSet.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      localAnimatorSet.start();
      return;
      label183:
      localObject = "translationY";
      break;
      label190:
      paramInt1 = paramView.getHeight();
      break label26;
      label198:
      f4 = 0.0F;
      f2 = 2;
      f3 = paramInt1;
      f1 = 0.0F;
      f2 *= f3;
    }
  }
  
  private final void b(VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null)
    {
      paramVideoPlayManager = paramVideoPlayManager.a();
      if (paramVideoPlayManager == null) {}
    }
    for (paramVideoPlayManager = paramVideoPlayManager.a(); (paramVideoPlayManager == null) || (paramVideoPlayManager.getVisibility() == 8); paramVideoPlayManager = null) {
      return;
    }
    a(0, 1, (View)paramVideoPlayManager, 200, 0);
  }
  
  public final void a(@Nullable VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    int j = -1;
    Object localObject;
    AdExperimentData.VideoGuide localVideoGuide;
    if (paramVideoPlayParam != null)
    {
      paramVideoPlayParam = paramVideoPlayParam.a;
      localObject = paramVideoPlayParam;
      if (!(paramVideoPlayParam instanceof AdvertisementInfo)) {
        localObject = null;
      }
      paramVideoPlayParam = (AdvertisementInfo)localObject;
      if (paramVideoPlayParam != null)
      {
        localObject = new StringBuilder().append("secondStateTime = ");
        localVideoGuide = paramVideoPlayParam.adExperimentData.a();
        if (localVideoGuide == null) {
          break label143;
        }
      }
    }
    label143:
    for (int i = localVideoGuide.a();; i = -1)
    {
      localObject = ((StringBuilder)localObject).append(i).append("    thirdStateTime = ");
      localVideoGuide = paramVideoPlayParam.adExperimentData.a();
      i = j;
      if (localVideoGuide != null) {
        i = localVideoGuide.b();
      }
      ReadInJoyAdLog.a("AdVideo185UIStateUtil", i + ' ' + "button_flag = " + paramVideoPlayParam.mShowAdButton);
      return;
      paramVideoPlayParam = null;
      break;
    }
  }
  
  public final void a(@Nullable VideoPlayManager.VideoPlayParam paramVideoPlayParam, @Nullable VideoPlayManager paramVideoPlayManager, @Nullable RecommendADVideoFeedsManager paramRecommendADVideoFeedsManager)
  {
    if (paramVideoPlayParam != null) {}
    Object localObject2;
    AdvertisementInfo localAdvertisementInfo;
    for (Object localObject1 = paramVideoPlayParam.a;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof AdvertisementInfo)) {
        localObject2 = null;
      }
      localAdvertisementInfo = (AdvertisementInfo)localObject2;
      if ((localAdvertisementInfo != null) && ((int)localAdvertisementInfo.mChannelID == 0)) {
        break;
      }
      return;
    }
    label97:
    int i;
    label128:
    int j;
    label159:
    long l1;
    label169:
    int k;
    long l3;
    if (paramVideoPlayManager != null)
    {
      localObject1 = paramVideoPlayManager.a();
      if (localObject1 != null)
      {
        localObject1 = ((VideoUIManager)localObject1).a();
        if (paramVideoPlayManager == null) {
          break label229;
        }
        localObject2 = paramVideoPlayManager.a();
        if (localObject2 == null) {
          break label229;
        }
        localObject2 = ((VideoUIManager)localObject2).a();
        Object localObject3 = localAdvertisementInfo.adExperimentData;
        if (localObject3 == null) {
          break label235;
        }
        localObject3 = ((AdExperimentData)localObject3).a();
        if (localObject3 == null) {
          break label235;
        }
        i = ((AdExperimentData.VideoGuide)localObject3).a();
        localObject3 = localAdvertisementInfo.adExperimentData;
        if (localObject3 == null) {
          break label241;
        }
        localObject3 = ((AdExperimentData)localObject3).a();
        if (localObject3 == null) {
          break label241;
        }
        j = ((AdExperimentData.VideoGuide)localObject3).b();
        if (paramVideoPlayManager == null) {
          break label247;
        }
        l1 = paramVideoPlayManager.d();
        k = i * 1000;
        l3 = l1 - j * 1000;
        if (paramVideoPlayManager == null) {
          break label253;
        }
      }
    }
    label229:
    label235:
    label241:
    label247:
    label253:
    for (long l2 = paramVideoPlayManager.a();; l2 = -1L)
    {
      if (l1 > 0L) {
        break label261;
      }
      AdVideoButtonUIUtils.b((View)localObject1);
      AdVideoButtonUIUtils.b((View)localObject2);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label97;
      i = -1;
      break label128;
      j = -1;
      break label159;
      l1 = 0L;
      break label169;
    }
    label261:
    boolean bool2 = false;
    label278:
    label287:
    boolean bool1;
    if (i > 0)
    {
      if (k > l3)
      {
        if (k <= l2) {
          break label502;
        }
        bool1 = false;
        label290:
        bool2 = bool1;
      }
    }
    else
    {
      if ((bool2) || (j <= 0) || (l3 <= 0L) || (l3 <= k) || (l3 >= l1) || (l1 <= 7000)) {
        break label659;
      }
      if (l3 <= l2) {
        break label516;
      }
      label346:
      bool1 = false;
    }
    for (;;)
    {
      ReadInJoyAdLog.a("AdVideo185UIStateUtil", "inSecondArea = " + bool2 + "   inThirdArea = " + bool1);
      if (bool2)
      {
        if (localObject1 == null) {
          break;
        }
        if ((((ReadInJoyVideoAdHighLightBar)localObject1).getTag() == null) || ((Intrinsics.areEqual(((ReadInJoyVideoAdHighLightBar)localObject1).getTag(), localAdvertisementInfo) ^ true)))
        {
          ((ReadInJoyVideoAdHighLightBar)localObject1).setTag(localAdvertisementInfo);
          ((ReadInJoyVideoAdHighLightBar)localObject1).setOnClickListener((View.OnClickListener)new AdVideo185UIStateUtil.onProgressUpdate..inlined.let.lambda.1((ReadInJoyVideoAdHighLightBar)localObject1, localAdvertisementInfo, paramRecommendADVideoFeedsManager, paramVideoPlayParam));
        }
        if (((ReadInJoyVideoAdHighLightBar)localObject1).getVisibility() == 8) {
          ((ReadInJoyVideoAdHighLightBar)localObject1).setVisibility(0);
        }
        return;
        if (l1 < l3) {
          break label278;
        }
        if (k > l2) {}
        while (l3 <= l2)
        {
          bool1 = false;
          break;
        }
        bool1 = true;
        break label290;
        label502:
        if (l1 <= l2) {
          break label287;
        }
        bool1 = true;
        break label290;
        label516:
        if (l1 <= l2) {
          break label346;
        }
        bool1 = true;
        continue;
      }
      if (bool1)
      {
        if (localObject1 != null) {
          ((ReadInJoyVideoAdHighLightBar)localObject1).setVisibility(8);
        }
        if (localObject2 == null) {
          break;
        }
        if ((((ReadInJoyAdVideoGuide)localObject2).getTag() == null) || ((Intrinsics.areEqual(((ReadInJoyAdVideoGuide)localObject2).getTag(), localAdvertisementInfo) ^ true)))
        {
          ((ReadInJoyAdVideoGuide)localObject2).setTag(localAdvertisementInfo);
          ((ReadInJoyAdVideoGuide)localObject2).setAdGuideClickListener((ReadInJoyAdVideoGuide.AdGuideClickListener)new AdVideo185UIStateUtil.onProgressUpdate..inlined.let.lambda.2((ReadInJoyAdVideoGuide)localObject2, localAdvertisementInfo, paramRecommendADVideoFeedsManager, paramVideoPlayParam));
        }
        ((ReadInJoyAdVideoGuide)localObject2).a();
        if (((ReadInJoyAdVideoGuide)localObject2).getVisibility() == 8)
        {
          ((ReadInJoyAdVideoGuide)localObject2).setVisibility(0);
          a.a(0, 0, (View)localObject2, 200, 0);
        }
        return;
      }
      AdVideoButtonUIUtils.b((View)localObject1);
      AdVideoButtonUIUtils.b((View)localObject2);
      return;
      label659:
      bool1 = false;
    }
  }
  
  public final void a(@Nullable VideoPlayManager.VideoPlayParam paramVideoPlayParam, @Nullable ReadInJoyAdVideoGuide paramReadInJoyAdVideoGuide)
  {
    Object localObject;
    if (paramVideoPlayParam != null)
    {
      localObject = paramVideoPlayParam.a;
      if ((localObject instanceof AdvertisementInfo)) {
        break label244;
      }
      localObject = null;
    }
    label244:
    for (;;)
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject;
      String str2;
      String str3;
      if (localAdvertisementInfo != null)
      {
        str2 = "";
        str3 = "";
      }
      try
      {
        String str4 = new JSONObject(localAdvertisementInfo.mAdExt).optString("pkg_name");
        Intrinsics.checkExpressionValueIsNotNull(str4, "jsonObject.optString(\"pkg_name\")");
        String str1 = str2;
        localObject = str3;
        if (!TextUtils.isEmpty((CharSequence)localAdvertisementInfo.mJsonVideoList))
        {
          JSONArray localJSONArray = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
          Intrinsics.checkExpressionValueIsNotNull(localJSONArray, "videoJson.getJSONArray(\"videos\")");
          str1 = str2;
          localObject = str3;
          if (localJSONArray.length() > 0)
          {
            localObject = localJSONArray.getJSONObject(0);
            str1 = ((JSONObject)localObject).optString("thirdIcon");
            Intrinsics.checkExpressionValueIsNotNull(str1, "videoJsonInfo.optString(\"thirdIcon\")");
            localObject = ((JSONObject)localObject).optString("thirdName");
            Intrinsics.checkExpressionValueIsNotNull(localObject, "videoJsonInfo.optString(\"thirdName\")");
          }
        }
        b(paramVideoPlayParam, paramReadInJoyAdVideoGuide);
        if (paramReadInJoyAdVideoGuide != null) {
          paramReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, str1, (String)localObject, str4, ReadInJoyAdUtils.b(localAdvertisementInfo), localAdvertisementInfo);
        }
        if (paramReadInJoyAdVideoGuide != null) {
          paramReadInJoyAdVideoGuide.a = true;
        }
        return;
      }
      catch (JSONException paramVideoPlayParam)
      {
        QLog.e("RecommendADVideoFeedsManager", 1, "showGuideView, e=" + paramVideoPlayParam.getMessage());
        return;
      }
      localObject = null;
      break;
    }
  }
  
  public final void a(@Nullable VideoPlayManager.VideoPlayParam paramVideoPlayParam, @Nullable ReadInJoyVideoAdHighLightBar paramReadInJoyVideoAdHighLightBar)
  {
    if (paramVideoPlayParam != null) {}
    for (paramVideoPlayParam = paramVideoPlayParam.a;; paramVideoPlayParam = null)
    {
      VideoPlayManager.VideoPlayParam localVideoPlayParam = paramVideoPlayParam;
      if (!(paramVideoPlayParam instanceof AdvertisementInfo)) {
        localVideoPlayParam = null;
      }
      paramVideoPlayParam = (AdvertisementInfo)localVideoPlayParam;
      if ((paramVideoPlayParam != null) && (paramReadInJoyVideoAdHighLightBar != null)) {
        paramReadInJoyVideoAdHighLightBar.setText(a(paramVideoPlayParam, paramReadInJoyVideoAdHighLightBar.getContext()));
      }
      return;
    }
  }
  
  public final void a(@Nullable VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null)
    {
      Object localObject = paramVideoPlayManager.a();
      if (localObject != null)
      {
        localObject = ((VideoUIManager)localObject).a();
        if (localObject != null) {
          ((ReadInJoyVideoAdHighLightBar)localObject).setVisibility(8);
        }
      }
    }
    b(paramVideoPlayManager);
  }
  
  public final void b(@Nullable VideoPlayManager.VideoPlayParam paramVideoPlayParam, @Nullable ReadInJoyAdVideoGuide paramReadInJoyAdVideoGuide)
  {
    if (paramVideoPlayParam != null) {}
    for (paramVideoPlayParam = paramVideoPlayParam.a;; paramVideoPlayParam = null)
    {
      VideoPlayManager.VideoPlayParam localVideoPlayParam = paramVideoPlayParam;
      if (!(paramVideoPlayParam instanceof AdvertisementInfo)) {
        localVideoPlayParam = null;
      }
      paramVideoPlayParam = (AdvertisementInfo)localVideoPlayParam;
      if ((paramVideoPlayParam != null) && (paramReadInJoyAdVideoGuide != null)) {
        paramReadInJoyAdVideoGuide.setBtnInfo(a(paramVideoPlayParam, paramReadInJoyAdVideoGuide.getContext()));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideo185UIStateUtil
 * JD-Core Version:    0.7.0.1
 */