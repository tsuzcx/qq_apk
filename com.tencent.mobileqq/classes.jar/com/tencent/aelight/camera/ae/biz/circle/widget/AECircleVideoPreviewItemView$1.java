package com.tencent.aelight.camera.ae.biz.circle.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;

class AECircleVideoPreviewItemView$1
  implements VideoPlayerCallback
{
  AECircleVideoPreviewItemView$1(AECircleVideoPreviewItemView paramAECircleVideoPreviewItemView, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (AECircleVideoPreviewItemView.c(this.b) != null)
    {
      int i = (int)(AECircleVideoPreviewItemView.c(this.b).getMax() * ((float)paramLong2 / (float)this.a.mDuration));
      if (i >= AECircleVideoPreviewItemView.d(this.b))
      {
        AECircleVideoPreviewItemView.c(this.b).setProgress(i);
        AECircleVideoPreviewItemView.a(this.b, -1);
      }
    }
    if (AECircleVideoPreviewItemView.e(this.b) != null) {
      AECircleVideoPreviewItemView.e(this.b).setText(AECircleVideoPreviewItemView.a(this.b, paramLong2));
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (paramInt == 4)
    {
      AECircleVideoPreviewItemView.a(this.b).setVisibility(8);
      AECircleVideoPreviewItemView.b(this.b).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.widget.AECircleVideoPreviewItemView.1
 * JD-Core Version:    0.7.0.1
 */