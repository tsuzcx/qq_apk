package com.tencent.mobileqq.activity.photo.album;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

class NewPhotoListActivity$1
  extends RecyclerView.OnScrollListener
{
  NewPhotoListActivity$1(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.a().a("list_photo", false);
      return;
    }
    DropFrameMonitor.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity.1
 * JD-Core Version:    0.7.0.1
 */