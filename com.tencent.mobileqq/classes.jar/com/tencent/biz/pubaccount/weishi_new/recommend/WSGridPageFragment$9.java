package com.tencent.biz.pubaccount.weishi_new.recommend;

import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.recommend.adapter.WSFollowDramaListAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.adapter.WSFollowDramaListAdapter.ItemViewExposedListener;
import com.tencent.widget.pull2refresh.BaseViewHolder;

class WSGridPageFragment$9
  implements WSFollowDramaListAdapter.ItemViewExposedListener
{
  WSGridPageFragment$9(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void a(@NonNull BaseViewHolder<WSFollowDramaItemData> paramBaseViewHolder)
  {
    if (WSGridPageFragment.j(this.a)) {
      return;
    }
    int i = paramBaseViewHolder.getAdapterPosition();
    paramBaseViewHolder = (WSFollowDramaItemData)WSGridPageFragment.i(this.a).getItem(i);
    if (paramBaseViewHolder == null) {
      return;
    }
    WSGridBeaconReport.a(WSGridPageFragment.b(this.a), i, paramBaseViewHolder.a(), paramBaseViewHolder.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.9
 * JD-Core Version:    0.7.0.1
 */