package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWriteWatchWordPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IPresenter;", "model", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;", "(Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;)V", "view", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IView;", "attachView", "", "detachView", "fetchTopicWatchWord", "topicId", "", "url", "title", "fetchVideoWatchWord", "rowkey", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWriteWatchWordPresenter
  implements IRIJWriteWatchWordShareContract.IPresenter
{
  private final IRIJWriteWatchWordShareContract.IModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJWriteWatchWordShareContract$IModel;
  private IRIJWriteWatchWordShareContract.IView jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJWriteWatchWordShareContract$IView;
  
  public RIJWriteWatchWordPresenter(@NotNull IRIJWriteWatchWordShareContract.IModel paramIModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJWriteWatchWordShareContract$IModel = paramIModel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJWriteWatchWordShareContract$IView = ((IRIJWriteWatchWordShareContract.IView)null);
  }
  
  public void a(@NotNull IRIJWriteWatchWordShareContract.IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramIView, "view");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJWriteWatchWordShareContract$IView = paramIView;
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "topicId");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    IRIJWriteWatchWordShareContract.IModel localIModel = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJWriteWatchWordShareContract$IModel;
    if (paramString3 != null) {}
    for (String str = paramString3;; str = "")
    {
      localIModel.a(paramString1, paramString2, str, (Function3)new RIJWriteWatchWordPresenter.fetchTopicWatchWord.1(this, paramString3, paramString2));
      return;
    }
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowkey");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    IRIJWriteWatchWordShareContract.IModel localIModel = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpIRIJWriteWatchWordShareContract$IModel;
    if (paramString4 != null) {}
    for (String str = paramString4;; str = "")
    {
      localIModel.a(paramString1, paramString2, paramString3, str, (Function3)new RIJWriteWatchWordPresenter.fetchVideoWatchWord.1(this, paramString4, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter
 * JD-Core Version:    0.7.0.1
 */