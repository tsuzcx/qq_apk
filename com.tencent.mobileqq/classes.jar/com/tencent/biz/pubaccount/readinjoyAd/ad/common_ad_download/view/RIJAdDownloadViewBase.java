package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.IDownloadStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJAdDownloadViewBase;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "vafContext", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;)V", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "getAdInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "setAdInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V", "buttonStyleJson", "Lorg/json/JSONObject;", "getButtonStyleJson", "()Lorg/json/JSONObject;", "setButtonStyleJson", "(Lorg/json/JSONObject;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "downloadData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "getDownloadData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "setDownloadData", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;)V", "downloadStyle", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "getDownloadStyle", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setDownloadStyle", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;)V", "progressStyleJson", "getProgressStyleJson", "setProgressStyleJson", "rijDownloadView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "getRijDownloadView", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "setRijDownloadView", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "checkAttribute", "", "convertJsonToButtonStyle", "convertJsonToProgressStyle", "getAdvertisementInfoFromParams", "value", "", "getComMeasuredHeight", "", "getComMeasuredWidth", "getNativeView", "initView", "onComLayout", "changed", "", "l", "t", "r", "b", "onComMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "setAdData", "advertisementInfo", "setAttribute", "key", "setDefaultDownloadStyle", "updateAdData", "Builder", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAdDownloadViewBase
  extends ViewBase
{
  private final Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private volatile AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  @Nullable
  private volatile IDownloadStyle jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
  @Nullable
  private RIJDownloadView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
  @Nullable
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  @Nullable
  private JSONObject b;
  
  public RIJAdDownloadViewBase(@NotNull VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    c();
  }
  
  private final AdvertisementInfo a(Object paramObject)
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)null;
    if ((paramObject instanceof AdvertisementInfo)) {
      localAdvertisementInfo = (AdvertisementInfo)paramObject;
    }
    if ((paramObject instanceof AdData)) {
      localAdvertisementInfo = ((AdData)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    }
    return localAdvertisementInfo;
  }
  
  private final void a(AdvertisementInfo paramAdvertisementInfo)
  {
    RIJDownloadView localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.setAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    }
    if (RIJAdDownloadUtil.a.a(paramAdvertisementInfo))
    {
      paramAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setOnClickListener((View.OnClickListener)new RIJAdDownloadViewBase.setAdData.1(this));
      }
    }
  }
  
  private final void a(JSONObject paramJSONObject)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle instanceof HorizontalProgressStyle))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
      if (localObject != null)
      {
        ((HorizontalProgressStyle)localObject).setBtnTextSize(paramJSONObject.optInt("buttonTextSize", 12));
        paramJSONObject = paramJSONObject.optString("buttonTextColor");
        if (!TextUtils.isEmpty((CharSequence)paramJSONObject))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
          if (localObject != null)
          {
            localObject = (HorizontalProgressStyle)localObject;
            if (paramJSONObject == null) {
              paramJSONObject = "#FF12B7F5";
            }
            ((HorizontalProgressStyle)localObject).setBtnTextColor(paramJSONObject);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle");
      }
    }
    else if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle instanceof RoundProgressStyle))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
      if (localObject != null)
      {
        RoundProgressStyle localRoundProgressStyle = (RoundProgressStyle)localObject;
        localObject = paramJSONObject.optString("buttonBackgroundColor");
        if (localObject == null) {
          localObject = "#12B7F5";
        }
        localRoundProgressStyle.setBtnDrawableNormalColor((String)localObject);
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
        if (localObject != null)
        {
          ((RoundProgressStyle)localObject).setBtnTextSize(paramJSONObject.optInt("buttonTextSize", 12));
          paramJSONObject = paramJSONObject.optString("buttonTextColor");
          if (!TextUtils.isEmpty((CharSequence)paramJSONObject))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
            if (localObject != null)
            {
              localObject = (RoundProgressStyle)localObject;
              if (paramJSONObject == null) {
                paramJSONObject = "#FFFFFF";
              }
              ((RoundProgressStyle)localObject).setBtnTextColor(paramJSONObject);
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
      }
    }
  }
  
  private final void b(JSONObject paramJSONObject)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle instanceof HorizontalProgressStyle))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
      if (localObject != null)
      {
        ((HorizontalProgressStyle)localObject).setProgressTextSize(paramJSONObject.optInt("textSize", 12));
        paramJSONObject = paramJSONObject.optString("textColor");
        if (!TextUtils.isEmpty((CharSequence)paramJSONObject))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
          if (localObject != null)
          {
            localObject = (HorizontalProgressStyle)localObject;
            if (paramJSONObject == null) {
              paramJSONObject = "#FFFFFF";
            }
            ((HorizontalProgressStyle)localObject).setProgressTextColor(paramJSONObject);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle");
      }
    }
    else if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle instanceof RoundProgressStyle))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
      if (localObject != null)
      {
        RoundProgressStyle localRoundProgressStyle = (RoundProgressStyle)localObject;
        localObject = paramJSONObject.optString("progressColor");
        if (localObject == null) {
          localObject = "#12B7F5";
        }
        localRoundProgressStyle.setPauseRectColor((String)localObject);
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
        if (localObject != null)
        {
          localRoundProgressStyle = (RoundProgressStyle)localObject;
          localObject = paramJSONObject.optString("progressColor");
          if (localObject == null) {
            localObject = "#12B7F5";
          }
          localRoundProgressStyle.setProgressColorHighLight((String)localObject);
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
          if (localObject != null)
          {
            localObject = (RoundProgressStyle)localObject;
            paramJSONObject = paramJSONObject.optString("progressBg");
            if (paramJSONObject == null) {
              paramJSONObject = "#CCCCCC";
            }
            ((RoundProgressStyle)localObject).setProgressColorNormal(paramJSONObject);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
    }
  }
  
  private final void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater");
    if (localObject1 != null)
    {
      Object localObject2 = (LayoutInflater)localObject1;
      localObject1 = null;
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject2).inflate(2131560059, null);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 != null) {
        localObject1 = (RIJDownloadView)((View)localObject2).findViewById(2131362106);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      if (localObject1 != null) {
        ((RIJDownloadView)localObject1).setDownloadScene(AdDownloadScene.PTSCard);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
  }
  
  private final void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    e();
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localObject != null) {
      b((JSONObject)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      a((JSONObject)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localObject != null) {
      ((RIJDownloadView)localObject).setProgressStyle(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle);
    }
  }
  
  private final void e()
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.isSoftAd() == true))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle = ((IDownloadStyle)RoundProgressStyle.FastWebSoftAd);
      return;
    }
    localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.isGameAd() == true))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle = ((IDownloadStyle)HorizontalProgressStyle.FastWebGameStyle);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle = ((IDownloadStyle)HorizontalProgressStyle.FastWebAppStyle);
  }
  
  @Nullable
  public final RIJDownloadView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
  }
  
  public final void a()
  {
    RIJDownloadView localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.a();
    }
  }
  
  public final void b()
  {
    RIJDownloadView localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.b();
    }
  }
  
  public int getComMeasuredHeight()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.getMeasuredWidth();
    }
    return 0;
  }
  
  @Nullable
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.measure(paramInt1, paramInt2);
    }
  }
  
  protected boolean setAttribute(int paramInt, @Nullable Object paramObject)
  {
    if (paramInt != 1042)
    {
      if (paramInt != 1054)
      {
        if (paramInt != 1055) {
          return super.setAttribute(paramInt, paramObject);
        }
        if ((paramObject instanceof JSONObject))
        {
          this.b = ((JSONObject)paramObject);
          d();
        }
        return true;
      }
      if ((paramObject instanceof JSONObject))
      {
        this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
        d();
      }
      return true;
    }
    AdvertisementInfo localAdvertisementInfo = a(paramObject);
    if ((localAdvertisementInfo != null) && ((Intrinsics.areEqual(getTag(), paramObject) ^ true)))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      if (localObject != null) {
        localObject = ((AdvertisementInfo)localObject).mAdTraceId;
      } else {
        localObject = null;
      }
      if ((Intrinsics.areEqual(localObject, localAdvertisementInfo.mAdTraceId) ^ true))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tag = ");
        ((StringBuilder)localObject).append(getTag());
        ((StringBuilder)localObject).append("  value = ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("AD_DOWNLOAD_TAG", 1, ((StringBuilder)localObject).toString());
        setTag(paramObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
        d();
        a(localAdvertisementInfo);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase
 * JD-Core Version:    0.7.0.1
 */