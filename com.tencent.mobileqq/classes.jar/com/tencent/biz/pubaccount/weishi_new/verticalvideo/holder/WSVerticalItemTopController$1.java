package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class WSVerticalItemTopController$1
  implements ActionSheet.OnButtonClickListener
{
  WSVerticalItemTopController$1(WSVerticalItemTopController paramWSVerticalItemTopController, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.a(WSVerticalItemTopController.a(this.b)))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    WSVerticalItemTopController.b(this.b).a(this.a.id, 2);
    this.a.followStatus = 2;
    WSVerticalItemTopController.c(this.b).setText("关注");
    WSVerticalItemTopController.c(this.b).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTopController.1
 * JD-Core Version:    0.7.0.1
 */