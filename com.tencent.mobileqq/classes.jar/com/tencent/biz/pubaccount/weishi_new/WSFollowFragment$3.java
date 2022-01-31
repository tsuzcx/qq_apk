package com.tencent.biz.pubaccount.weishi_new;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import tgd;
import tih;
import tlo;

class WSFollowFragment$3
  implements Runnable
{
  WSFollowFragment$3(WSFollowFragment paramWSFollowFragment) {}
  
  public void run()
  {
    RecyclerView.ViewHolder localViewHolder = this.this$0.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(((tih)this.this$0.jdField_a_of_type_Taw).a());
    tlo.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical getLastPosition:" + ((tih)this.this$0.jdField_a_of_type_Taw).a() + ", holder:" + localViewHolder);
    if ((localViewHolder instanceof tgd)) {
      this.this$0.a((tgd)localViewHolder);
    }
    WSFollowFragment.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.3
 * JD-Core Version:    0.7.0.1
 */