package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

final class WSVerticalPageBottomBarFactory$3
  implements WSVerticalPageBottomBarFactory.OnCreateTopBarControllerListener
{
  public AbsWsUIGroup<WSVerticalItemData> a(WSVerticalPageFragment paramWSVerticalPageFragment, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    return new WSVerticalItemBottomDramaCollectionController(paramWSVerticalPageFragment.getActivity(), paramWSVerticalVideoHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalPageBottomBarFactory.3
 * JD-Core Version:    0.7.0.1
 */