package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class PttAudioChangeView
  extends PttThemeBaseView
{
  Bitmap a;
  private int b;
  
  public PttAudioChangeView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.b = paramInt1;
    a(paramInt2);
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    this.a = BitmapFactory.decodeResource(getResources(), this.b);
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.a, null, this.g, this.q);
  }
  
  protected boolean a()
  {
    if ((this.k != null) && (!this.k.isRecycled()))
    {
      Bitmap localBitmap = this.a;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    Bitmap localBitmap = this.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.a.recycle();
    }
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioChangeView
 * JD-Core Version:    0.7.0.1
 */