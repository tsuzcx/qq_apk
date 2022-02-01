package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class VideoLayerUIBase$MoveSmallViewAnimation
  implements Runnable
{
  private int a = 0;
  private float b = 0.0F;
  private float c = 0.0F;
  private int d = 1;
  private final int e = 9;
  
  private VideoLayerUIBase$MoveSmallViewAnimation(VideoLayerUIBase paramVideoLayerUIBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.b = ((paramInt4 - paramInt2) / 10.0F);
    this.c = ((paramInt5 - paramInt3) / 10.0F);
    this.d = paramInt1;
  }
  
  public void run()
  {
    if (this.this$0.X()) {
      return;
    }
    if (this.a == 9) {
      this.this$0.j(this.d);
    } else {
      this.this$0.e((int)this.b, (int)this.c);
    }
    this.a += 1;
    if (this.this$0.Y != null)
    {
      if (this.a <= 9)
      {
        this.this$0.Y.a().postDelayed(this, 10L);
        return;
      }
      this.this$0.O();
      this.this$0.Y.a(new Object[] { Integer.valueOf(121) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.MoveSmallViewAnimation
 * JD-Core Version:    0.7.0.1
 */