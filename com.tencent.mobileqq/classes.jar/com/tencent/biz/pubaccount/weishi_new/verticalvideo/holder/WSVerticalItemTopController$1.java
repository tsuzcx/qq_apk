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
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.a(WSVerticalItemTopController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemTopController)))
    {
      ToastUtil.a().a(2131720447);
      return;
    }
    WSVerticalItemTopController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemTopController).a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 2);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 2;
    WSVerticalItemTopController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemTopController).setText("关注");
    WSVerticalItemTopController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemTopController).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTopController.1
 * JD-Core Version:    0.7.0.1
 */