package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgPageData;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragmentPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/presenter/WSBasePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgContract$Presenter;", "()V", "mDataFetcher", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgDataFetcher;", "mPageData", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgPageData;", "fetchData", "", "isFirst", "", "isRefresh", "getMsgPageData", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragmentPresenter
  extends WSBasePresenter<WSMsgContract.View>
  implements WSMsgContract.Presenter
{
  private WSMsgDataFetcher a = new WSMsgDataFetcher();
  private WSMsgPageData b;
  
  @Nullable
  public WSMsgPageData a()
  {
    return this.b;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    FetcherParams localFetcherParams = new FetcherParams(paramBoolean1, paramBoolean2);
    this.a.a(localFetcherParams, (IFetchDataListener)new WSMsgFragmentPresenter.fetchData.1(this, paramBoolean1, paramBoolean2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragmentPresenter
 * JD-Core Version:    0.7.0.1
 */