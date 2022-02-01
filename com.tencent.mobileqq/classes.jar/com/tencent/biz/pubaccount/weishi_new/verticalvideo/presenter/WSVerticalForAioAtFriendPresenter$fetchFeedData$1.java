package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WSVerticalForAioAtFriendPresenter$fetchFeedData$1
  implements Runnable
{
  WSVerticalForAioAtFriendPresenter$fetchFeedData$1(WSVerticalForAioAtFriendPresenter paramWSVerticalForAioAtFriendPresenter, boolean paramBoolean1, boolean paramBoolean2, WSVerticalPageContract.View paramView) {}
  
  public final void run()
  {
    WSVerticalRequestParams localWSVerticalRequestParams = new WSVerticalRequestParams(15, this.a, this.b).a(CollectionsKt.arrayListOf(new String[] { this.c.n() }));
    WSVerticalDataManager.a().a(localWSVerticalRequestParams, (IFetchDataRspListener)this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForAioAtFriendPresenter.fetchFeedData.1
 * JD-Core Version:    0.7.0.1
 */