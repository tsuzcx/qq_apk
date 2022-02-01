package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager.OnDataReceivedListener;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSFollowView;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLoadMoreReportHelper;
import java.util.List;

class WSFollowPresenter$1
  implements WSFeedDataManager.OnDataReceivedListener<stFeed>
{
  WSFollowPresenter$1(WSFollowPresenter paramWSFollowPresenter, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, List<stFeed> paramList, boolean paramBoolean2)
  {
    ((IWSFollowView)this.b.getView()).a(this.a, paramBoolean1, paramList, paramBoolean2);
    if (!paramBoolean1)
    {
      ((IWSFollowView)this.b.getView()).a(paramList);
      return;
    }
    ((IWSFollowView)this.b.getView()).a(paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    ((IWSFollowView)this.b.getView()).u();
    if (paramBoolean2) {
      ((IWSFollowView)this.b.getView()).e(paramBoolean3);
    }
    int i = 0;
    if (!paramBoolean3)
    {
      ((IWSFollowView)this.b.getView()).c(false, true);
      ((IWSFollowView)this.b.getView()).b(paramBoolean1, paramBoolean2);
      return;
    }
    if ((paramBoolean1) && ((paramObject instanceof stFollowFeedsRsp)))
    {
      stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramObject;
      WSFollowPresenter.a(this.b, localstFollowFeedsRsp.config);
      if ((this.b.getView() instanceof WSFollowFragment)) {
        ((WSFollowFragment)this.b.getView()).g(true);
      }
    }
    if ((!(paramObject instanceof stFollowFeedsRsp)) || (WSFeedUtils.a(((stFollowFeedsRsp)paramObject).feeds))) {
      i = 1;
    }
    if (i != 0)
    {
      ((IWSFollowView)this.b.getView()).c(true, true);
      if (paramBoolean1) {
        ((IWSFollowView)this.b.getView()).b(true, paramBoolean2);
      }
    }
    WSFollowPresenter.a(this.b).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPresenter.1
 * JD-Core Version:    0.7.0.1
 */