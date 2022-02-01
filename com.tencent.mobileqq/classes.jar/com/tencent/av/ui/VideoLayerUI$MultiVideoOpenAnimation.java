package com.tencent.av.ui;

import android.graphics.Rect;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

public class VideoLayerUI$MultiVideoOpenAnimation
  implements Runnable
{
  private int a = 0;
  private int b = 0;
  private float c = 0.0F;
  
  public VideoLayerUI$MultiVideoOpenAnimation(VideoLayerUI paramVideoLayerUI, int paramInt)
  {
    this.a = paramInt;
    paramVideoLayerUI = paramVideoLayerUI.ae[this.a];
    Rect localRect = paramVideoLayerUI.f();
    this.c = (localRect.width() / 10.0F);
    paramInt = localRect.right;
    int i = localRect.width();
    paramVideoLayerUI.c(paramInt, localRect.top, i + paramInt, localRect.bottom);
    paramVideoLayerUI.m();
  }
  
  public void run()
  {
    if (this.b == 9)
    {
      this.this$0.c(false);
    }
    else
    {
      GLVideoView localGLVideoView = this.this$0.ae[this.a];
      Rect localRect = localGLVideoView.f();
      int i = (int)(localRect.left - this.c);
      int j = localRect.width();
      localGLVideoView.c(i, localRect.top, j + i, localRect.bottom);
      localGLVideoView.m();
    }
    this.b += 1;
    if (this.b <= 9) {
      this.this$0.Y.a().postDelayed(this, 30L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MultiVideoOpenAnimation
 * JD-Core Version:    0.7.0.1
 */