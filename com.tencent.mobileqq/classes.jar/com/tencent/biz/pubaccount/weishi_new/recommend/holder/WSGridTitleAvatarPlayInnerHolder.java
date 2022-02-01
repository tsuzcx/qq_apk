package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;

public class WSGridTitleAvatarPlayInnerHolder
  extends WSGridCommonHolder
{
  public WSGridTitleAvatarPlayInnerHolder(ViewGroup paramViewGroup, int paramInt, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramViewGroup, paramInt, paramWSRecommendAdapter);
  }
  
  public IWSItemView<stSimpleMetaFeed> a(int paramInt)
  {
    return new WSGridTitleAvatarPlayInnerItemView(a(), this.itemView, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleAvatarPlayInnerHolder
 * JD-Core Version:    0.7.0.1
 */