package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.ItemViewExposeListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager;
import com.tencent.widget.pull2refresh.BaseViewHolder;

class WSGridPageFragment$4
  implements WSRecommendAdapter.ItemViewExposeListener
{
  WSGridPageFragment$4(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void a(BaseViewHolder<stSimpleMetaFeed> paramBaseViewHolder)
  {
    if ((((WSGridPageContract.Presenter)this.a.aO_()).g()) && (WSGridPageFragment.e(this.a)))
    {
      int i = paramBaseViewHolder.getAdapterPosition();
      paramBaseViewHolder = (stSimpleMetaFeed)WSGridPageFragment.f(this.a).getItem(i);
      if (paramBaseViewHolder == null) {
        return;
      }
      WSGridPageFragment.g(this.a).a(paramBaseViewHolder, i);
      WSExposeDataManager.a().a(paramBaseViewHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.4
 * JD-Core Version:    0.7.0.1
 */