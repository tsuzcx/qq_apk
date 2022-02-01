package com.tencent.aelight.camera.ae.biz.circle.widget;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class AECircleVideoPreviewItemView$3
  implements SeekBar.OnSeekBarChangeListener
{
  AECircleVideoPreviewItemView$3(AECircleVideoPreviewItemView paramAECircleVideoPreviewItemView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((AECircleVideoPreviewItemView.f(this.a) != null) && (AECircleVideoPreviewItemView.g(this.a) != null))
    {
      if (AECircleVideoPreviewItemView.e(this.a) == null) {
        return;
      }
      if (paramBoolean)
      {
        BaseVideoView localBaseVideoView = AECircleVideoPreviewItemView.f(this.a);
        float f = paramInt;
        localBaseVideoView.seekTo((int)(f / paramSeekBar.getMax() * (float)AECircleVideoPreviewItemView.g(this.a).mDuration));
        AECircleVideoPreviewItemView.a(this.a, paramInt);
        AECircleVideoPreviewItemView.e(this.a).setText(AECircleVideoPreviewItemView.a(this.a, (int)(f / paramSeekBar.getMax() * (float)AECircleVideoPreviewItemView.g(this.a).mDuration)));
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.widget.AECircleVideoPreviewItemView.3
 * JD-Core Version:    0.7.0.1
 */