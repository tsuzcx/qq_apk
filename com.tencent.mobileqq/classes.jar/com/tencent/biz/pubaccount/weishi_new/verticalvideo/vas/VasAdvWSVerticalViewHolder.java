package com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalCommonVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalViewHolder;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/WSVerticalCommonVideoHolder;", "parent", "Landroid/view/ViewGroup;", "type", "", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalPageFragment;", "(Landroid/view/ViewGroup;ILcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalPageFragment;)V", "vasItemView", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalItemView;", "createItemView", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/AbsWSVideoItemView;", "getBottomBarHeight", "getVideoScaleType", "itemInfo", "LUserGrowth/stSimpleMetaFeed;", "isPlayLoop", "", "isShowMoreBtn", "onDoDestroy", "", "onDoPause", "onDoResume", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWSVerticalViewHolder
  extends WSVerticalCommonVideoHolder
{
  public static final VasAdvWSVerticalViewHolder.Companion a;
  private VasAdvWSVerticalItemView a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoVasVasAdvWSVerticalViewHolder$Companion = new VasAdvWSVerticalViewHolder.Companion(null);
  }
  
  public VasAdvWSVerticalViewHolder(@Nullable ViewGroup paramViewGroup, int paramInt, @Nullable WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt, paramWSVerticalPageFragment);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(@Nullable stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return -1;
  }
  
  @Nullable
  public AbsWSVideoItemView a(int paramInt)
  {
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoVasVasAdvWSVerticalItemView = new VasAdvWSVerticalItemView(localContext, (WSVerticalVideoHolder)this);
    return (AbsWSVideoItemView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoVasVasAdvWSVerticalItemView;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      Object localObject = this.jdField_a_of_type_JavaLangObject;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mItemData");
      stSimpleMetaFeed localstSimpleMetaFeed = ((WSVerticalItemData)localObject).a();
      localObject = localstSimpleMetaFeed;
      if (!(localstSimpleMetaFeed instanceof stSimpleMetaFeed)) {
        localObject = null;
      }
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoVasVasAdvWSVerticalItemView;
        if (localObject != null) {
          ((VasAdvWSVerticalItemView)localObject).e();
        }
        localObject = this.jdField_a_of_type_JavaLangObject;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mItemData");
        ((WSVerticalItemData)localObject).a().isGdtAdVidoReport = false;
      }
    }
    WSLog.a("VasAdWSVerticalViewHolder", "onDoResume: ");
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangObject;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mItemData");
      Object localObject2 = ((WSVerticalItemData)localObject1).a();
      localObject1 = localObject2;
      if (!(localObject2 instanceof stSimpleMetaFeed)) {
        localObject1 = null;
      }
      localObject2 = this.jdField_a_of_type_JavaLangObject;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mItemData");
      if ((((WSVerticalItemData)localObject2).a() != null) && (localObject1 != null) && (((stSimpleMetaFeed)localObject1).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject1).gdt_ad_info != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null))
      {
        localObject1 = this.jdField_a_of_type_JavaLangObject;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "mItemData");
        if (((WSVerticalItemData)localObject1).a().isGdtAdclicked)
        {
          GdtAdWsVideoReport.a((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false, 2);
          localObject1 = this.jdField_a_of_type_JavaLangObject;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "mItemData");
          ((WSVerticalItemData)localObject1).a().isGdtAdclicked = false;
        }
        else
        {
          GdtAdWsVideoReport.a((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false, 3);
        }
        localObject1 = this.jdField_a_of_type_JavaLangObject;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "mItemData");
        ((WSVerticalItemData)localObject1).a().isGdtAdVidoReport = true;
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mPlayerParam.mVideoPlayer");
        ((WSPlayerParam)localObject1).jdField_a_of_type_Long = ((WSPlayerWrapper)localObject2).a();
      }
    }
    WSLog.a("VasAdWSVerticalViewHolder", "onDoPause: ");
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void c()
  {
    VasAdvWSVerticalItemView localVasAdvWSVerticalItemView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoVasVasAdvWSVerticalItemView;
    if (localVasAdvWSVerticalItemView != null)
    {
      ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).unsubscribeAll("ws_video_ad_h5_cover");
      localVasAdvWSVerticalItemView.a();
    }
    ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).removeWebView();
    ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).unregisterAppReceiver();
    WSLog.a("VasAdWSVerticalViewHolder", "onDoDestroy: ");
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalViewHolder
 * JD-Core Version:    0.7.0.1
 */