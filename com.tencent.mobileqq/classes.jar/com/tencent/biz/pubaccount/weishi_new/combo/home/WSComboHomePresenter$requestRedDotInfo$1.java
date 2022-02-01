package com.tencent.biz.pubaccount.weishi_new.combo.home;

import UserGrowth.stRedDotRsp;
import com.tencent.biz.pubaccount.weishi_new.combo.reddot.WSRedDotDataFetcher.ResponseModel;
import com.tencent.biz.pubaccount.weishi_new.data.IFetcherRspListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSRedDotPersonEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.util.WSRedDotUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomePresenter$requestRedDotInfo$1", "Lcom/tencent/biz/pubaccount/weishi_new/data/IFetcherRspListener;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher$ResponseModel;", "onFailed", "", "errorCode", "", "errorMsg", "", "isFirst", "", "isRefresh", "onSuccess", "rspModel", "extObject", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomePresenter$requestRedDotInfo$1
  implements IFetcherRspListener<WSRedDotDataFetcher.ResponseModel>
{
  public void a(int paramInt, @Nullable String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = (WSComboHomeContract.View)this.a.getView();
    if (paramString != null) {
      paramString.aI_();
    }
  }
  
  public void a(@NotNull WSRedDotDataFetcher.ResponseModel paramResponseModel, boolean paramBoolean1, boolean paramBoolean2, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramResponseModel, "rspModel");
    paramObject = (WSComboHomeContract.View)this.a.getView();
    if (paramObject != null) {
      paramObject.a(paramResponseModel);
    }
    WSRedDotUtil.a(paramResponseModel.a().menu);
    WSComboHomePresenter.a(this.a, paramResponseModel.a().user);
    WSSimpleEventBus.a().a((WSSimpleBaseEvent)new WSRedDotPersonEvent(paramResponseModel.a().user));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomePresenter.requestRedDotInfo.1
 * JD-Core Version:    0.7.0.1
 */