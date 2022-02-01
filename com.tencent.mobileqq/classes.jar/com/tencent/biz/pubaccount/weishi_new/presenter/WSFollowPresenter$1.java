package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager.OnDataReceivedListener;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSFollowView;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import java.util.List;

class WSFollowPresenter$1
  implements WSFeedDataManager.OnDataReceivedListener<stFeed>
{
  WSFollowPresenter$1(WSFollowPresenter paramWSFollowPresenter, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, List<stFeed> paramList, boolean paramBoolean2)
  {
    ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).a(this.jdField_a_of_type_Boolean, paramBoolean1, paramList, paramBoolean2);
    if (!paramBoolean1)
    {
      ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).a(paramList);
      return;
    }
    ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).a(paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).f();
    if (paramBoolean2) {
      ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).a(paramBoolean3);
    }
    if (!paramBoolean3)
    {
      ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).b(false, true);
      ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).a(paramBoolean1, paramBoolean2);
    }
    label206:
    for (;;)
    {
      return;
      if ((paramBoolean1) && ((paramObject instanceof stFollowFeedsRsp)))
      {
        stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramObject;
        WSFollowPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter, localstFollowFeedsRsp.config);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a() instanceof WSFollowFragment)) {
          ((WSFollowFragment)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).c(true);
        }
      }
      if ((!(paramObject instanceof stFollowFeedsRsp)) || (WSFeedUtils.a(((stFollowFeedsRsp)paramObject).feeds))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label206;
        }
        ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).b(true, true);
        if (!paramBoolean1) {
          break;
        }
        ((IWSFollowView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSFollowPresenter.a()).a(true, paramBoolean2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPresenter.1
 * JD-Core Version:    0.7.0.1
 */