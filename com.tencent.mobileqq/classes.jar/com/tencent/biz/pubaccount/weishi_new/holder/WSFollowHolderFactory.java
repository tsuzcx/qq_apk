package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSFollowHolderFactory
{
  public static BaseViewHolder<stFeed> a(int paramInt, ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    switch (paramInt)
    {
    default: 
      return WSFollowFeedHolder.a(paramViewGroup, paramWSFollowAdapter);
    case 1: 
      return WSFollowPersonHolder.a(paramViewGroup, paramWSFollowAdapter);
    case 2: 
      return WSFollowFeedHolder.a(paramViewGroup, paramWSFollowAdapter);
    case 101: 
      return WSFollowSeparateHolder1.a(paramViewGroup, paramWSFollowAdapter);
    case 102: 
      return WSFollowSeparateHolder2.a(paramViewGroup, paramWSFollowAdapter);
    }
    return WSFollowFriendCollectionHolder.a(paramViewGroup, paramWSFollowAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowHolderFactory
 * JD-Core Version:    0.7.0.1
 */