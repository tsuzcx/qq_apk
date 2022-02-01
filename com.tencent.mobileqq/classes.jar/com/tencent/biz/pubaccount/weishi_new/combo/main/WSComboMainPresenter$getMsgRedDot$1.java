package com.tencent.biz.pubaccount.weishi_new.combo.main;

import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainPresenter$getMsgRedDot$1", "Lcom/tencent/biz/pubaccount/weishi_new/drama/cache/IFetchDataListener;", "", "onFailure", "", "errorCode", "errorMsg", "", "onSuccess", "count", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboMainPresenter$getMsgRedDot$1
  implements IFetchDataListener<Integer>
{
  public void a(int paramInt)
  {
    WSComboMainContract.View localView = (WSComboMainContract.View)this.a.getView();
    if (localView != null) {
      localView.a("message_tab", paramInt);
    }
  }
  
  public void a(int paramInt, @Nullable String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainPresenter.getMsgRedDot.1
 * JD-Core Version:    0.7.0.1
 */