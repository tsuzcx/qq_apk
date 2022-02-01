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
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.experiment.AdExperimentData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.experiment.AdExperimentData.VideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide.AdGuideClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdVideo185UIStateUtil;", "", "()V", "ANIMATE_IN", "", "ANIMATE_OUT", "HORIZONTAL", "TAG", "", "VERTICAL", "fillVideoBeforeEndGuide", "", "playParam", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/entity/VideoPlayParam;", "guideView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/ReadInJoyAdVideoGuide;", "getBtnText", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "context", "Landroid/content/Context;", "handleCompleteState", "playManager", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/api/IVideoPlayManager;", "hideThirdAdBarWithAnimate", "logAdConfig", "maskTranslateAnimate", "orientation", "type", "view", "Landroid/view/View;", "duration", "repeatCount", "onProgressUpdate", "adVideoFeedsManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/RecommendADVideoFeedsManager;", "updateGuideBtnText", "highLightBar", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/ReadInJoyVideoAdHighLightBar;", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdVideo185UIStateUtil
{
  public static final AdVideo185UIStateUtil a = new AdVideo185UIStateUtil();
  
  private final String a(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if (paramAdvertisementInfo != null)
    {
      if ((int)paramAdvertisementInfo.mChannelID != 0) {
        return "";
      }
      String str1 = paramAdvertisementInfo.mAdExtInfo;
      if (str1 == null) {
        str1 = "";
      }
      String str2 = paramAdvertisementInfo.mAdExt;
      if (str2 == null) {
        str2 = "";
      }
      IRIJAdUtilService localIRIJAdUtilService = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAdvertisementInfo;
      if (!localIRIJAdUtilService.isAdvertisementInfo(localAbsBaseArticleInfo)) {
        return "";
      }
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(localAbsBaseArticleInfo))
      {
        paramAdvertisementInfo = paramAdvertisementInfo.mAdBtnTxt;
        if (!TextUtils.isEmpty((CharSequence)paramAdvertisementInfo))
        {
          Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "mAdBtnTxt");
          return paramAdvertisementInfo;
        }
        return "查看详情";
      }
      int i = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getGameType(paramAdvertisementInfo);
      if (i == 2)
      {
        paramAdvertisementInfo = new JSONObject(str1).optString("game_pkg_name");
        Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "jsonObject.optString(RIJ…nts.GameAd.GAME_PKG_NAME)");
      }
      else
      {
        paramAdvertisementInfo = new JSONObject(str2).optString("pkg_name");
        Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "jsonObject.optString(\"pkg_name\")");
      }
      if (AdDownloadUtil.a(paramAdvertisementInfo))
      {
        if (i == 2) {
          return "打开";
        }
        return "立即打开";
      }
      if (ADBaseAppDownloadManager.a(paramContext, paramAdvertisementInfo))
      {
        if (i == 2) {
          return "安装";
        }
        return "立即安装";
      }
      if (i == 2) {
        return "下载";
      }
      return "立即下载";
    }
    return "";
  }
  
  private final void a(int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      paramView.setVisibility(0);
      if (paramInt1 == 0) {
        localObject = "translationX";
      } else {
        localObject = "translationY";
      }
      if (paramInt1 == 0) {
        paramInt1 = paramView.getWidth();
      } else {
        paramInt1 = paramView.getHeight();
      }
      float f1 = 1.0F;
      float f2 = 0.0F;
      float f3;
      float f4;
      if (paramInt2 == 0)
      {
        f1 = 2;
        f3 = paramInt1 * f1;
        f4 = 1.0F;
        f1 = 0.0F;
      }
      else
      {
        f2 = 2;
        f2 = paramInt1 * f2;
        f3 = 0.0F;
        f4 = 0.0F;
      }
      Object localObject = ObjectAnimator.ofFloat(paramView, (String)localObject, new float[] { f3, f2 });
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this");
      ((ObjectAnimator)localObject).setRepeatCount(paramInt4);
      paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { f1, f4 });
      Intrinsics.checkExpressionValueIsNotNull(paramView, "this");
      paramView.setRepeatCount(paramInt4);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(paramInt3 * 11 / 10);
      localAnimatorSet.playSequentially(new Animator[] { (Animator)paramView, (Animator)localObject });
      localAnimatorSet.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      localAnimatorSet.start();
    }
  }
  
  private final void b(IVideoPlayManager paramIVideoPlayManager)
  {
    if (paramIVideoPlayManager != null)
    {
      paramIVideoPlayManager = paramIVideoPlayManager.a();
      if (paramIVideoPlayManager != null)
      {
        paramIVideoPlayManager = paramIVideoPlayManager.b();
        break label27;
      }
    }
    paramIVideoPlayManager = null;
    label27:
    paramIVideoPlayManager = (ReadInJoyAdVideoGuide)paramIVideoPlayManager;
    if (paramIVideoPlayManager != null)
    {
      if (paramIVideoPlayManager.getVisibility() == 8) {
        return;
      }
      a(0, 1, (View)paramIVideoPlayManager, 200, 0);
    }
  }
  
  public final void a(@Nullable IVideoPlayManager paramIVideoPlayManager)
  {
    if (paramIVideoPlayManager != null)
    {
      localObject = paramIVideoPlayManager.a();
      if (localObject != null)
      {
        localObject = ((IVideoUIManager)localObject).c();
        break label27;
      }
    }
    Object localObject = null;
    label27:
    localObject = (ReadInJoyVideoAdHighLightBar)localObject;
    if (localObject != null) {
      ((ReadInJoyVideoAdHighLightBar)localObject).setVisibility(8);
    }
    b(paramIVideoPlayManager);
  }
  
  public final void a(@Nullable VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      paramVideoPlayParam = paramVideoPlayParam.a;
    } else {
      paramVideoPlayParam = null;
    }
    Object localObject = paramVideoPlayParam;
    if (!(paramVideoPlayParam instanceof AdvertisementInfo)) {
      localObject = null;
    }
    paramVideoPlayParam = (AdvertisementInfo)localObject;
    if (paramVideoPlayParam != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("secondStateTime = ");
      AdExperimentData.VideoGuide localVideoGuide = paramVideoPlayParam.adExperimentData.a();
      int j = -1;
      if (localVideoGuide != null) {
        i = localVideoGuide.a();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("    thirdStateTime = ");
      localVideoGuide = paramVideoPlayParam.adExperimentData.a();
      int i = j;
      if (localVideoGuide != null) {
        i = localVideoGuide.b();
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(' ');
      ((StringBuilder)localObject).append("button_flag = ");
      ((StringBuilder)localObject).append(paramVideoPlayParam.mShowAdButton);
      ReadInJoyAdLog.a("AdVideo185UIStateUtil", ((StringBuilder)localObject).toString());
    }
  }
  
  public final void a(@Nullable VideoPlayParam paramVideoPlayParam, @Nullable ReadInJoyAdVideoGuide paramReadInJoyAdVideoGuide)
  {
    String str1 = null;
    Object localObject;
    if (paramVideoPlayParam != null) {
      localObject = paramVideoPlayParam.a;
    } else {
      localObject = null;
    }
    if (!(localObject instanceof AdvertisementInfo)) {
      localObject = str1;
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject;
    if (localAdvertisementInfo != null) {}
    for (;;)
    {
      try
      {
        String str2 = new JSONObject(localAdvertisementInfo.mAdExt).optString("pkg_name");
        Intrinsics.checkExpressionValueIsNotNull(str2, "jsonObject.optString(\"pkg_name\")");
        boolean bool = TextUtils.isEmpty((CharSequence)localAdvertisementInfo.mJsonVideoList);
        if (bool) {
          break label261;
        }
        localObject = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "videoJson.getJSONArray(\"videos\")");
        if (((JSONArray)localObject).length() <= 0) {
          break label261;
        }
        localObject = ((JSONArray)localObject).getJSONObject(0);
        str1 = ((JSONObject)localObject).optString("thirdIcon");
        Intrinsics.checkExpressionValueIsNotNull(str1, "videoJsonInfo.optString(\"thirdIcon\")");
        localObject = ((JSONObject)localObject).optString("thirdName");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "videoJsonInfo.optString(\"thirdName\")");
        b(paramVideoPlayParam, paramReadInJoyAdVideoGuide);
        if (paramReadInJoyAdVideoGuide != null) {
          paramReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, str1, (String)localObject, str2, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(localAdvertisementInfo), localAdvertisementInfo);
        }
        if (paramReadInJoyAdVideoGuide != null)
        {
          paramReadInJoyAdVideoGuide.a = true;
          return;
        }
      }
      catch (JSONException paramVideoPlayParam)
      {
        paramReadInJoyAdVideoGuide = new StringBuilder();
        paramReadInJoyAdVideoGuide.append("showGuideView, e=");
        paramReadInJoyAdVideoGuide.append(paramVideoPlayParam.getMessage());
        QLog.e("RecommendADVideoFeedsManager", 1, paramReadInJoyAdVideoGuide.toString());
      }
      return;
      label261:
      str1 = "";
      localObject = str1;
    }
  }
  
  public final void a(@Nullable VideoPlayParam paramVideoPlayParam, @Nullable ReadInJoyVideoAdHighLightBar paramReadInJoyVideoAdHighLightBar)
  {
    if (paramVideoPlayParam != null) {
      paramVideoPlayParam = paramVideoPlayParam.a;
    } else {
      paramVideoPlayParam = null;
    }
    VideoPlayParam localVideoPlayParam = paramVideoPlayParam;
    if (!(paramVideoPlayParam instanceof AdvertisementInfo)) {
      localVideoPlayParam = null;
    }
    paramVideoPlayParam = (AdvertisementInfo)localVideoPlayParam;
    if ((paramVideoPlayParam != null) && (paramReadInJoyVideoAdHighLightBar != null)) {
      paramReadInJoyVideoAdHighLightBar.setText(a(paramVideoPlayParam, paramReadInJoyVideoAdHighLightBar.getContext()));
    }
  }
  
  public final void a(@Nullable VideoPlayParam paramVideoPlayParam, @Nullable IVideoPlayManager paramIVideoPlayManager, @Nullable RecommendADVideoFeedsManager paramRecommendADVideoFeedsManager)
  {
    Object localObject3 = null;
    Object localObject1;
    if (paramVideoPlayParam != null) {
      localObject1 = paramVideoPlayParam.a;
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof AdvertisementInfo)) {
      localObject2 = null;
    }
    localObject2 = (AdvertisementInfo)localObject2;
    if (localObject2 != null)
    {
      if ((int)((AdvertisementInfo)localObject2).mChannelID != 0) {
        return;
      }
      if (paramIVideoPlayManager != null)
      {
        localObject1 = paramIVideoPlayManager.a();
        if (localObject1 != null)
        {
          localObject1 = ((IVideoUIManager)localObject1).c();
          break label88;
        }
      }
      localObject1 = null;
      label88:
      ReadInJoyVideoAdHighLightBar localReadInJoyVideoAdHighLightBar = (ReadInJoyVideoAdHighLightBar)localObject1;
      localObject1 = localObject3;
      if (paramIVideoPlayManager != null)
      {
        IVideoUIManager localIVideoUIManager = paramIVideoPlayManager.a();
        localObject1 = localObject3;
        if (localIVideoUIManager != null) {
          localObject1 = localIVideoUIManager.b();
        }
      }
      localObject1 = (ReadInJoyAdVideoGuide)localObject1;
      localObject3 = ((AdvertisementInfo)localObject2).adExperimentData;
      int k = -1;
      if (localObject3 != null)
      {
        localObject3 = ((AdExperimentData)localObject3).a();
        if (localObject3 != null)
        {
          i = ((AdExperimentData.VideoGuide)localObject3).a();
          break label176;
        }
      }
      int i = -1;
      label176:
      localObject3 = ((AdvertisementInfo)localObject2).adExperimentData;
      int j = k;
      if (localObject3 != null)
      {
        localObject3 = ((AdExperimentData)localObject3).a();
        j = k;
        if (localObject3 != null) {
          j = ((AdExperimentData.VideoGuide)localObject3).b();
        }
      }
      long l1;
      if (paramIVideoPlayManager != null) {
        l1 = paramIVideoPlayManager.a();
      } else {
        l1 = 0L;
      }
      k = i * 1000;
      long l3 = l1 - j * 1000;
      long l2;
      if (paramIVideoPlayManager != null) {
        l2 = paramIVideoPlayManager.b();
      } else {
        l2 = -1L;
      }
      if (l1 <= 0L)
      {
        AdVideoButtonUIUtils.b((View)localReadInJoyVideoAdHighLightBar);
        AdVideoButtonUIUtils.b((View)localObject1);
        return;
      }
      if (i > 0)
      {
        long l4 = k;
        if ((l4 <= l3) && (l1 >= l3) ? (l4 <= l2) && (l3 > l2) : (l4 <= l2) && (l1 > l2))
        {
          bool1 = true;
          break label376;
        }
      }
      boolean bool1 = false;
      label376:
      boolean bool2;
      if ((!bool1) && (j > 0) && (l3 > 0L) && (l3 > k) && (l3 < l1) && (l1 > 7000) && (l3 <= l2) && (l1 > l2)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramIVideoPlayManager = new StringBuilder();
      paramIVideoPlayManager.append("inSecondArea = ");
      paramIVideoPlayManager.append(bool1);
      paramIVideoPlayManager.append("   inThirdArea = ");
      paramIVideoPlayManager.append(bool2);
      ReadInJoyAdLog.a("AdVideo185UIStateUtil", paramIVideoPlayManager.toString());
      if (bool1)
      {
        if (localReadInJoyVideoAdHighLightBar != null)
        {
          if ((localReadInJoyVideoAdHighLightBar.getTag() == null) || ((Intrinsics.areEqual(localReadInJoyVideoAdHighLightBar.getTag(), localObject2) ^ true)))
          {
            localReadInJoyVideoAdHighLightBar.setTag(localObject2);
            localReadInJoyVideoAdHighLightBar.setOnClickListener((View.OnClickListener)new AdVideo185UIStateUtil.onProgressUpdate..inlined.let.lambda.1(localReadInJoyVideoAdHighLightBar, (AdvertisementInfo)localObject2, paramRecommendADVideoFeedsManager, paramVideoPlayParam));
          }
          if (localReadInJoyVideoAdHighLightBar.getVisibility() == 8) {
            localReadInJoyVideoAdHighLightBar.setVisibility(0);
          }
        }
        return;
      }
      if (bool2)
      {
        if (localReadInJoyVideoAdHighLightBar != null) {
          localReadInJoyVideoAdHighLightBar.setVisibility(8);
        }
        if (localObject1 != null)
        {
          if ((((ReadInJoyAdVideoGuide)localObject1).getTag() == null) || ((Intrinsics.areEqual(((ReadInJoyAdVideoGuide)localObject1).getTag(), localObject2) ^ true)))
          {
            ((ReadInJoyAdVideoGuide)localObject1).setTag(localObject2);
            ((ReadInJoyAdVideoGuide)localObject1).setAdGuideClickListener((ReadInJoyAdVideoGuide.AdGuideClickListener)new AdVideo185UIStateUtil.onProgressUpdate..inlined.let.lambda.2((ReadInJoyAdVideoGuide)localObject1, (AdvertisementInfo)localObject2, paramRecommendADVideoFeedsManager, paramVideoPlayParam));
          }
          ((ReadInJoyAdVideoGuide)localObject1).a();
          if (((ReadInJoyAdVideoGuide)localObject1).getVisibility() == 8)
          {
            ((ReadInJoyAdVideoGuide)localObject1).setVisibility(0);
            a.a(0, 0, (View)localObject1, 200, 0);
          }
        }
        return;
      }
      AdVideoButtonUIUtils.b((View)localReadInJoyVideoAdHighLightBar);
      AdVideoButtonUIUtils.b((View)localObject1);
    }
  }
  
  public final void b(@Nullable VideoPlayParam paramVideoPlayParam, @Nullable ReadInJoyAdVideoGuide paramReadInJoyAdVideoGuide)
  {
    if (paramVideoPlayParam != null) {
      paramVideoPlayParam = paramVideoPlayParam.a;
    } else {
      paramVideoPlayParam = null;
    }
    VideoPlayParam localVideoPlayParam = paramVideoPlayParam;
    if (!(paramVideoPlayParam instanceof AdvertisementInfo)) {
      localVideoPlayParam = null;
    }
    paramVideoPlayParam = (AdvertisementInfo)localVideoPlayParam;
    if ((paramVideoPlayParam != null) && (paramReadInJoyAdVideoGuide != null)) {
      paramReadInJoyAdVideoGuide.setBtnInfo(a(paramVideoPlayParam, paramReadInJoyAdVideoGuide.getContext()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideo185UIStateUtil
 * JD-Core Version:    0.7.0.1
 */