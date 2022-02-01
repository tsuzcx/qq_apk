package com.tencent.biz.pubaccount.weishi_new.profile;

import androidx.recyclerview.widget.GridLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.BaseViewHolder;

class WSProfileWorksFragment$4
  implements Runnable
{
  WSProfileWorksFragment$4(WSProfileWorksFragment paramWSProfileWorksFragment, BaseViewHolder paramBaseViewHolder) {}
  
  public void run()
  {
    int i = this.a.getAdapterPosition();
    if (i <= WSProfileWorksFragment.d(this.this$0).findLastVisibleItemPosition()) {
      WSProfileWorksFragment.a(this.this$0, i, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileWorksFragment.4
 * JD-Core Version:    0.7.0.1
 */