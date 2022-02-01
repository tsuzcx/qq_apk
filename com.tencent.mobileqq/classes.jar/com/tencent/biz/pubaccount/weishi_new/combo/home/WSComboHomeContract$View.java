package com.tencent.biz.pubaccount.weishi_new.combo.home;

import com.tencent.biz.pubaccount.weishi_new.IWSBaseView;
import com.tencent.biz.pubaccount.weishi_new.combo.reddot.WSRedDotDataFetcher.ResponseModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/IWSBaseView;", "showRedDotFailureView", "", "showRedDotSuccessView", "resModel", "Lcom/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher$ResponseModel;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface WSComboHomeContract$View
  extends IWSBaseView
{
  public abstract void a(@NotNull WSRedDotDataFetcher.ResponseModel paramResponseModel);
  
  public abstract void aI_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomeContract.View
 * JD-Core Version:    0.7.0.1
 */