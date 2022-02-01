package com.tencent.biz.pubaccount.weishi_new;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

class WSFollowFragment$3
  implements Runnable
{
  WSFollowFragment$3(WSFollowFragment paramWSFollowFragment, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    RecyclerView.ViewHolder localViewHolder = this.this$0.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(((WSFollowPresenter)this.this$0.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a());
    WSLog.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical getLastPosition:" + ((WSFollowPresenter)this.this$0.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a() + ", holder:" + localViewHolder);
    if ((localViewHolder instanceof WSPlayableHolder)) {
      this.this$0.a((WSPlayableHolder)localViewHolder, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    }
    WSFollowFragment.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.3
 * JD-Core Version:    0.7.0.1
 */