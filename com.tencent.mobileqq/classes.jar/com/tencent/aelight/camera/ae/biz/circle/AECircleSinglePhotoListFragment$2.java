package com.tencent.aelight.camera.ae.biz.circle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AECircleSinglePhotoListFragment$2
  extends RecyclerView.OnScrollListener
{
  AECircleSinglePhotoListFragment$2(AECircleSinglePhotoListFragment paramAECircleSinglePhotoListFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.a;
    AECircleSinglePhotoListFragment.a(paramRecyclerView, AECircleSinglePhotoListFragment.a(paramRecyclerView) + paramInt2);
    if ((AECircleSinglePhotoListFragment.a(this.a) >= this.a.b.f) && (!AECircleSinglePhotoListFragment.b(this.a)))
    {
      AEReportUtils.a(false);
      AECircleSinglePhotoListFragment.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleSinglePhotoListFragment.2
 * JD-Core Version:    0.7.0.1
 */