package com.tencent.aelight.camera.ae.biz.circle.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class AECircleVideoPreviewItemView$2
  implements View.OnClickListener
{
  AECircleVideoPreviewItemView$2(AECircleVideoPreviewItemView paramAECircleVideoPreviewItemView) {}
  
  public void onClick(View paramView)
  {
    if (AECircleVideoPreviewItemView.f(this.a) == null) {
      return;
    }
    if (AECircleVideoPreviewItemView.f(this.a).isPlaying())
    {
      AECircleVideoPreviewItemView.f(this.a).pause();
      AECircleVideoPreviewItemView.b(this.a).setVisibility(0);
      return;
    }
    AECircleVideoPreviewItemView.f(this.a).resume();
    AECircleVideoPreviewItemView.a(this.a).setVisibility(8);
    AECircleVideoPreviewItemView.b(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.widget.AECircleVideoPreviewItemView.2
 * JD-Core Version:    0.7.0.1
 */