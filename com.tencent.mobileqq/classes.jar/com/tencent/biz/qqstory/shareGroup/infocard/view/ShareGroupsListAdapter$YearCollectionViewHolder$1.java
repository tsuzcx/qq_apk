package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;

class ShareGroupsListAdapter$YearCollectionViewHolder$1
  implements View.OnClickListener
{
  ShareGroupsListAdapter$YearCollectionViewHolder$1(ShareGroupsListAdapter.YearCollectionViewHolder paramYearCollectionViewHolder) {}
  
  public void onClick(View paramView)
  {
    ShareGroupsListAdapter.ChangeVideoSortEvent localChangeVideoSortEvent = new ShareGroupsListAdapter.ChangeVideoSortEvent();
    if (this.a.a.a)
    {
      this.a.a.a = false;
      localChangeVideoSortEvent.a = 0;
    }
    else
    {
      this.a.a.a = true;
      localChangeVideoSortEvent.a = 1;
    }
    StoryDispatcher.a().dispatch(localChangeVideoSortEvent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.YearCollectionViewHolder.1
 * JD-Core Version:    0.7.0.1
 */