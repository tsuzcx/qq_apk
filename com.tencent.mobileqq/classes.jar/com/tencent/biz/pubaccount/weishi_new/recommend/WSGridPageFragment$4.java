package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.ItemViewExposeListener;
import com.tencent.widget.pull2refresh.BaseViewHolder;

class WSGridPageFragment$4
  implements WSRecommendAdapter.ItemViewExposeListener
{
  WSGridPageFragment$4(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void a(BaseViewHolder<stSimpleMetaFeed> paramBaseViewHolder)
  {
    int i;
    if ((((WSGridPageContract.Presenter)this.a.b()).a()) && (WSGridPageFragment.a(this.a)))
    {
      i = paramBaseViewHolder.getAdapterPosition();
      paramBaseViewHolder = (stSimpleMetaFeed)WSGridPageFragment.a(this.a).a(i);
      if (paramBaseViewHolder != null) {}
    }
    else
    {
      return;
    }
    WSGridPageFragment.a(this.a).a(paramBaseViewHolder, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.4
 * JD-Core Version:    0.7.0.1
 */