package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;

public class PttAudioPlayView
  extends PttThemeBaseView
{
  Bitmap a;
  Bitmap b;
  private final int v = 12;
  private boolean w = false;
  private int x = 2130838203;
  
  public PttAudioPlayView(Context paramContext)
  {
    super(paramContext);
    a(12);
  }
  
  public PttAudioPlayView(Context paramContext, int paramInt)
  {
    super(paramContext);
    a(paramInt);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(12);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    a(paramInt);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramInt2);
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    this.a = BitmapFactory.decodeResource(getResources(), this.x);
    this.b = BitmapFactory.decodeResource(getResources(), 2130838204);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (!this.w)
    {
      paramCanvas.drawBitmap(this.b, null, this.g, this.q);
      return;
    }
    paramCanvas.drawBitmap(this.a, null, this.g, this.q);
  }
  
  protected boolean a()
  {
    Bitmap localBitmap = this.b;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      localBitmap = this.a;
      if ((localBitmap != null) && (!localBitmap.isRecycled()) && (this.k != null) && (!this.k.isRecycled())) {
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
    localBitmap = this.b;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.b.recycle();
    }
    this.a = null;
    this.b = null;
  }
  
  public boolean getPlayState()
  {
    return this.w;
  }
  
  public void setPlayState(boolean paramBoolean)
  {
    this.w = paramBoolean;
    this.u = true;
    invalidate();
  }
  
  public void setPttPauseOrStopDrawable(@DrawableRes int paramInt)
  {
    this.x = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioPlayView
 * JD-Core Version:    0.7.0.1
 */