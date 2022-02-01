package com.tencent.aelight.camera.aeeditor.view.playtrack.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IPlayTrackViewBitmapProvider;

public class PlayTrackExpandWidthView
  extends View
{
  private ScaleAdapter a;
  private Paint b = new Paint();
  private IPlayTrackViewBitmapProvider c;
  private int d;
  private int e;
  private int[] f = new int[2];
  private Rect g = new Rect(0, 0, 0, 0);
  private Rect h = new Rect(0, 0, 0, 0);
  
  public PlayTrackExpandWidthView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PlayTrackExpandWidthView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PlayTrackExpandWidthView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      paramInt1 = -paramInt2;
    }
    int i = 0;
    if (paramInt1 > 0)
    {
      i = this.d;
      return paramInt2 + paramInt1 % i - i;
    }
    paramInt2 = i;
    while (paramInt1 < 0)
    {
      paramInt1 += this.d;
      paramInt2 += 1;
    }
    if (paramInt2 != 0) {
      paramInt1 = (paramInt2 - 1) * this.d;
    }
    return paramInt1;
  }
  
  private void a()
  {
    this.e = getContext().getResources().getDisplayMetrics().widthPixels;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.b.setAntiAlias(true);
    if (this.c == null) {
      return;
    }
    getLocationOnScreen(this.f);
    int j = getMeasuredWidth();
    int k = getScrollX();
    int m = this.f[0];
    if ((m <= this.e) && (m + j >= 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    int i = a(m, k);
    while ((i < j + k) && (i < this.e + k - m))
    {
      long l = this.a.b(i);
      Bitmap localBitmap = this.c.getBitmap(l);
      int n = localBitmap.getHeight();
      int i1 = localBitmap.getWidth();
      int i2 = this.d;
      int i3 = getHeight();
      Rect localRect = this.g;
      localRect.left = (i1 - i2 >> 1);
      localRect.top = (n - i3 >> 1);
      localRect.right = (localRect.left + this.d);
      localRect = this.g;
      localRect.bottom = (localRect.top + getHeight());
      localRect = this.h;
      localRect.left = i;
      localRect.top = 0;
      localRect.right = (localRect.left + this.d);
      localRect = this.h;
      localRect.bottom = (localRect.top + getHeight());
      paramCanvas.drawBitmap(localBitmap, this.g, this.h, this.b);
      i += this.d;
    }
  }
  
  public void setPixelPerBitmap(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setScaleAdapter(ScaleAdapter paramScaleAdapter)
  {
    this.a = paramScaleAdapter;
  }
  
  public void setVideoThumbProvider(IPlayTrackViewBitmapProvider paramIPlayTrackViewBitmapProvider)
  {
    this.c = paramIPlayTrackViewBitmapProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.playtrack.view.PlayTrackExpandWidthView
 * JD-Core Version:    0.7.0.1
 */