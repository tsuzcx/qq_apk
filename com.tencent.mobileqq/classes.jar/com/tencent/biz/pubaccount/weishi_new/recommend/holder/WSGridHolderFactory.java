package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSGridHolderFactory
{
  public static BaseViewHolder<stSimpleMetaFeed> a(int paramInt, ViewGroup paramViewGroup, WSRecommendAdapter paramWSRecommendAdapter)
  {
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      return new WSGridTitlePlayLikeInnerHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    case 1: 
      return new WSGridTitlePlayLikeInnerHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    case 3: 
      return new WSGridTitleAvatarPlayInnerHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    case 6: 
      return new WSGridTitleAvatarLikeOuterHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    case 7: 
      return new WSGridTitleAvatarPlayOuterHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    case 8: 
      return new WSGridTitleInnerAvatarLikeOuterHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    case 9: 
      return new WSGridTitleInnerAvatarPlayOuterHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    case 10: 
      return new WSGridOnlyCoverHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    }
    return new WSGridCollectionHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridHolderFactory
 * JD-Core Version:    0.7.0.1
 */