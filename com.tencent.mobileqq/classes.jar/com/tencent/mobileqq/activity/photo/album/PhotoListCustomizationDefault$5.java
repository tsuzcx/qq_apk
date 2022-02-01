package com.tencent.mobileqq.activity.photo.album;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

class PhotoListCustomizationDefault$5
  extends RecyclerView.OnScrollListener
{
  PhotoListCustomizationDefault$5(PhotoListCustomizationDefault paramPhotoListCustomizationDefault) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.b().a("list_photo", false);
      return;
    }
    DropFrameMonitor.b().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.5
 * JD-Core Version:    0.7.0.1
 */