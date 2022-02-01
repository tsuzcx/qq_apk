package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class WSFollowFeedHolder$7
  implements ActionSheet.OnButtonClickListener
{
  WSFollowFeedHolder$7(WSFollowFeedHolder paramWSFollowFeedHolder, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.a(WSFollowFeedHolder.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder)))
    {
      ToastUtil.a().a(2131720447);
      return;
    }
    WSFollowFeedHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder).a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 2);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 2;
    WSFollowFeedHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder).setVisibility(0);
    WSFollowFeedHolder.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.7
 * JD-Core Version:    0.7.0.1
 */