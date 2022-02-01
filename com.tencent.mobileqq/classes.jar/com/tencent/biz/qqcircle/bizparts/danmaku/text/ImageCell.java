package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import anzj;
import bhtq;
import vhx;

public class ImageCell
  extends TextCell
{
  private static final long serialVersionUID = -3999833992135197771L;
  public Drawable emoDrawable;
  private Context mContext;
  public int resId;
  
  public ImageCell()
  {
    this.type = 0;
  }
  
  public ImageCell(int paramInt, Context paramContext)
  {
    this.mContext = paramContext;
    this.type = 0;
    this.resId = paramInt;
    this.emoDrawable = this.mContext.getResources().getDrawable(paramInt);
    paramInt = this.mContext.getResources().getDimensionPixelOffset(2131296860);
    this.emoDrawable.setBounds(0, 0, paramInt, paramInt);
  }
  
  public boolean canBreak()
  {
    return false;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (((paramPaint instanceof vhx)) && (((vhx)paramPaint).a()) && (!((vhx)paramPaint).a)) {}
    do
    {
      return;
      paramPaint = getEmoDrawable();
    } while (paramPaint == null);
    paramInt2 = paramRect.left;
    paramInt1 = paramRect.top - 1 + (paramInt1 - paramPaint.getBounds().height()) / 2;
    paramCanvas.translate(paramInt2, paramInt1);
    paramPaint.draw(paramCanvas);
    paramCanvas.translate(-paramInt2, -paramInt1);
  }
  
  public boolean fadedDraw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, long paramLong)
  {
    int j = (int)Math.floor(paramLong / FADE_START_INTERVAL);
    int i = paramPaint.getAlpha();
    if (j - paramInt4 > 0)
    {
      draw(paramCanvas, paramPaint, paramInt1, paramRect, paramInt2, paramInt3, paramBitmap);
      return false;
    }
    String str = anzj.a(2131704628);
    double d = paramPaint.measureText(str + str) - paramPaint.measureText(str) * 2.0F;
    d = paramLong - (paramInt4 + 1) * FADE_START_INTERVAL;
    if (d <= 0.0D)
    {
      paramPaint.setAlpha(i);
      return true;
    }
    d = d % FADE_SCALE / FADE_SCALE;
    paramInt4 = (int)(255.0D * d);
    j = (int)((1.0D - d) * FADE_LENGTH);
    int k = paramRect.left;
    paramRect = new Rect(paramRect);
    paramRect.left = (j + k);
    paramPaint.setAlpha(paramInt4);
    draw(paramCanvas, paramPaint, paramInt1, paramRect, paramInt2, paramInt3, paramBitmap);
    paramPaint.setAlpha(i);
    return false;
  }
  
  public Drawable getEmoDrawable()
  {
    if (this.emoDrawable != null) {
      return this.emoDrawable;
    }
    return this.mContext.getResources().getDrawable(this.resId);
  }
  
  public int getHeight(Paint paramPaint)
  {
    paramPaint = getEmoDrawable();
    if (paramPaint == null) {
      return 0;
    }
    return paramPaint.getBounds().height();
  }
  
  public int getLength()
  {
    return 1;
  }
  
  public String getText()
  {
    if (TextUtils.isEmpty(this.text)) {
      return "[image]";
    }
    return this.text;
  }
  
  public float getWidth(Paint paramPaint)
  {
    paramPaint = getEmoDrawable();
    if (paramPaint == null) {
      return 0.0F;
    }
    int i = bhtq.a(4.0F);
    return paramPaint.getBounds().width() + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ImageCell
 * JD-Core Version:    0.7.0.1
 */