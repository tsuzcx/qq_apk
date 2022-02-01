package com.tencent.aelight.camera.ae.album.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

class AENewPhotoListFragment$1
  extends RecyclerView.OnScrollListener
{
  AENewPhotoListFragment$1(AENewPhotoListFragment paramAENewPhotoListFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.b().a("list_photo", false);
      return;
    }
    DropFrameMonitor.b().a("list_photo");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment.1
 * JD-Core Version:    0.7.0.1
 */