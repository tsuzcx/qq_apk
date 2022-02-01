package com.tencent.biz.pubaccount.weishi_new;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import vdq;
import via;
import vmp;

class WSFollowFragment$3
  implements Runnable
{
  WSFollowFragment$3(WSFollowFragment paramWSFollowFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    RecyclerView.ViewHolder localViewHolder = this.this$0.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(((via)this.this$0.jdField_a_of_type_Uwz).a());
    vmp.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical getLastPosition:" + ((via)this.this$0.jdField_a_of_type_Uwz).a() + ", holder:" + localViewHolder);
    if ((localViewHolder instanceof vdq)) {
      this.this$0.a((vdq)localViewHolder, this.a, this.b);
    }
    WSFollowFragment.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.3
 * JD-Core Version:    0.7.0.1
 */