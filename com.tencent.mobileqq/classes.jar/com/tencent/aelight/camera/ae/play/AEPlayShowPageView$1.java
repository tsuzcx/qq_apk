package com.tencent.aelight.camera.ae.play;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.image.ApngImage;

class AEPlayShowPageView$1
  extends RecyclerView.OnScrollListener
{
  AEPlayShowPageView$1(AEPlayShowPageView paramAEPlayShowPageView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      ApngImage.resumeAll();
    } else {
      ApngImage.pauseAll();
    }
    super.onScrollStateChanged(paramRecyclerView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPageView.1
 * JD-Core Version:    0.7.0.1
 */