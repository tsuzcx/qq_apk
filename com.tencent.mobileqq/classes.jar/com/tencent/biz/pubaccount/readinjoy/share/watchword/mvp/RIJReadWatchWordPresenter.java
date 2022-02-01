package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IPresenter;", "model", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;", "(Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;)V", "view", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IView;", "attachView", "", "detachView", "requestWatchWordUrl", "watchWord", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJReadWatchWordPresenter
  implements IRIJReadWatchWordShareContract.IPresenter
{
  public static final RIJReadWatchWordPresenter.Companion a;
  private final IRIJReadWatchWordShareContract.IModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJReadWatchWordShareContract$IModel;
  private IRIJReadWatchWordShareContract.IView jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJReadWatchWordShareContract$IView;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordPresenter$Companion = new RIJReadWatchWordPresenter.Companion(null);
  }
  
  public RIJReadWatchWordPresenter(@NotNull IRIJReadWatchWordShareContract.IModel paramIModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJReadWatchWordShareContract$IModel = paramIModel;
  }
  
  public void a(@NotNull IRIJReadWatchWordShareContract.IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramIView, "view");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJReadWatchWordShareContract$IView = paramIView;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "watchWord");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJReadWatchWordShareContract$IModel.a(paramString, (Function5)new RIJReadWatchWordPresenter.requestWatchWordUrl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordPresenter
 * JD-Core Version:    0.7.0.1
 */