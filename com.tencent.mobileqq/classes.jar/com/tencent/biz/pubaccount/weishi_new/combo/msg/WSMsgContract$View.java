package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import com.tencent.biz.pubaccount.weishi_new.IWSBaseView;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgPageData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/IWSBaseView;", "hideLoadingView", "", "onLoadDataFailed", "code", "", "msg", "", "isFirst", "", "onLoadDataSuccess", "pageData", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgPageData;", "isRefresh", "canLoadMore", "showRefreshView", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface WSMsgContract$View
  extends IWSBaseView
{
  public abstract void a(int paramInt, @NotNull String paramString, boolean paramBoolean);
  
  public abstract void a(@NotNull WSMsgPageData paramWSMsgPageData, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void aJ_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgContract.View
 * JD-Core Version:    0.7.0.1
 */