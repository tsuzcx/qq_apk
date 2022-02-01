package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSFollowHolderFactory
{
  public static BaseViewHolder<stFeed> a(int paramInt, ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 101)
          {
            if (paramInt != 102) {
              return WSFollowFeedHolder.a(paramViewGroup, paramWSFollowAdapter);
            }
            return WSFollowSeparateHolder2.a(paramViewGroup, paramWSFollowAdapter);
          }
          return WSFollowSeparateHolder1.a(paramViewGroup, paramWSFollowAdapter);
        }
        return WSFollowFriendCollectionHolder.a(paramViewGroup, paramWSFollowAdapter);
      }
      return WSFollowFeedHolder.a(paramViewGroup, paramWSFollowAdapter);
    }
    return WSFollowPersonHolder.a(paramViewGroup, paramWSFollowAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowHolderFactory
 * JD-Core Version:    0.7.0.1
 */