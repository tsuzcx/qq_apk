package com.tencent.biz.pubaccount.weishi_new;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import upp;
import utp;
import uya;

class WSFollowFragment$3
  implements Runnable
{
  WSFollowFragment$3(WSFollowFragment paramWSFollowFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    RecyclerView.ViewHolder localViewHolder = this.this$0.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(((utp)this.this$0.jdField_a_of_type_Ujc).a());
    uya.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical getLastPosition:" + ((utp)this.this$0.jdField_a_of_type_Ujc).a() + ", holder:" + localViewHolder);
    if ((localViewHolder instanceof upp)) {
      this.this$0.a((upp)localViewHolder, this.a, this.b);
    }
    WSFollowFragment.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.3
 * JD-Core Version:    0.7.0.1
 */