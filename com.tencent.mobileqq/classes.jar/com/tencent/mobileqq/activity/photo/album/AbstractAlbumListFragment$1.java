package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbstractAlbumListFragment$1
  implements View.OnClickListener
{
  AbstractAlbumListFragment$1(AbstractAlbumListFragment paramAbstractAlbumListFragment) {}
  
  public void onClick(View paramView)
  {
    ((AbstractPhotoListActivity)this.this$0.getActivity()).transAlbumList(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractAlbumListFragment.1
 * JD-Core Version:    0.7.0.1
 */