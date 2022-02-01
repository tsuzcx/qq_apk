package com.tencent.biz.pubaccount.weishi_new.recommend;

import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.recommend.adapter.WSFollowDramaListAdapter;
import com.tencent.widget.pull2refresh.BaseAdapter.OnItemClickListener;
import java.util.List;

class WSGridPageFragment$8
  implements BaseAdapter.OnItemClickListener
{
  WSGridPageFragment$8(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    paramView = this.a;
    WSGridPageFragment.a(paramView, paramInt, (WSFollowDramaItemData)WSGridPageFragment.i(paramView).getDataList().get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.8
 * JD-Core Version:    0.7.0.1
 */