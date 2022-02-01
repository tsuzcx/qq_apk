package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class WSFollowFeedHolder$9
  implements ActionSheet.OnButtonClickListener
{
  WSFollowFeedHolder$9(WSFollowFeedHolder paramWSFollowFeedHolder, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.a(WSFollowFeedHolder.h(this.b)))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    WSFollowFeedHolder.i(this.b).a(this.a.id, 2);
    this.a.followStatus = 2;
    WSFollowFeedHolder.j(this.b).setVisibility(0);
    WSFollowFeedHolder.k(this.b).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.9
 * JD-Core Version:    0.7.0.1
 */