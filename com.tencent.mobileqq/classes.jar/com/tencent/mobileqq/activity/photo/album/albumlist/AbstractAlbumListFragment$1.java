package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbstractAlbumListFragment$1
  implements View.OnClickListener
{
  AbstractAlbumListFragment$1(AbstractAlbumListFragment paramAbstractAlbumListFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment.1
 * JD-Core Version:    0.7.0.1
 */