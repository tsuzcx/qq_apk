package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalViewHolder;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSVerticalFactory
{
  public static BaseViewHolder<WSVerticalItemData> a(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    switch (paramInt)
    {
    default: 
      return new WSVerticalAvatarBottomVideoHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
    case 1: 
      return new WSVerticalOperationRightVideoHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
    case 2: 
      return new WSVerticalOperationCenterBottomVideoHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
    }
    return new VasAdvWSVerticalViewHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalFactory
 * JD-Core Version:    0.7.0.1
 */