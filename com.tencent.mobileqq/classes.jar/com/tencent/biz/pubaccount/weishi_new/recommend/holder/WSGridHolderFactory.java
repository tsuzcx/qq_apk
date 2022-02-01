package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSGridHolderFactory
{
  public static BaseViewHolder<stSimpleMetaFeed> a(int paramInt, ViewGroup paramViewGroup, WSRecommendAdapter paramWSRecommendAdapter)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        switch (paramInt)
        {
        default: 
          return new WSGridTitlePlayLikeInnerHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
        case 13: 
          return new WSGridTitleOuterTagBottomHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
        case 12: 
          return new WSGridDramaHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
        case 11: 
          return new WSGridCollectionHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
        case 10: 
          return new WSGridOnlyCoverHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
        case 9: 
          return new WSGridTitleInnerAvatarPlayOuterHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
        case 8: 
          return new WSGridTitleInnerAvatarLikeOuterHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
        case 7: 
          return new WSGridTitleAvatarPlayOuterHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
        }
        return new WSGridTitleAvatarLikeOuterHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
      }
      return new WSGridTitleAvatarPlayInnerHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
    }
    return new WSGridTitlePlayLikeInnerHolder(paramViewGroup, paramInt, paramWSRecommendAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridHolderFactory
 * JD-Core Version:    0.7.0.1
 */