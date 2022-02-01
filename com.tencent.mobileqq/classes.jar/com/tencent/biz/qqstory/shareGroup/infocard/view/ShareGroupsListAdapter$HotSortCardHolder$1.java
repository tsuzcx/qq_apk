package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShareGroupsListAdapter$HotSortCardHolder$1
  implements View.OnClickListener
{
  ShareGroupsListAdapter$HotSortCardHolder$1(ShareGroupsListAdapter.HotSortCardHolder paramHotSortCardHolder, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.b.k != null) {
      this.b.k.a(null, 0, this.b.b, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.HotSortCardHolder.1
 * JD-Core Version:    0.7.0.1
 */