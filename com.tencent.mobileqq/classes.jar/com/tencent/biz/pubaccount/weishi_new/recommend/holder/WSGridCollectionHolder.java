package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;

public class WSGridCollectionHolder
  extends AbsWSGridBaseHolder<stSimpleMetaFeed>
{
  public WSGridCollectionHolder(ViewGroup paramViewGroup, int paramInt, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramViewGroup, 2131626467, paramInt, paramWSRecommendAdapter);
    ((WSGridCollectionItemView)this.a).a(paramWSRecommendAdapter);
  }
  
  public IWSItemView<stSimpleMetaFeed> a(int paramInt)
  {
    return new WSGridCollectionItemView(getContext(), this.itemView, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCollectionHolder
 * JD-Core Version:    0.7.0.1
 */