package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;

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
    paramInt = this.mContext.getResources().getDimensionPixelOffset(2131297299);
    this.emoDrawable.setBounds(0, 0, paramInt, paramInt);
  }
  
  public boolean canBreak()
  {
    return false;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if ((paramPaint instanceof ETPaint))
    {
      paramPaint = (ETPaint)paramPaint;
      if ((paramPaint.d()) && (!paramPaint.a)) {
        return;
      }
    }
    paramPaint = getEmoDrawable();
    if (paramPaint != null)
    {
      paramInt2 = paramRect.left;
      paramInt1 = paramRect.top - 1 + (paramInt1 - paramPaint.getBounds().height()) / 2;
      paramCanvas.translate(paramInt2, paramInt1);
      paramPaint.draw(paramCanvas);
      paramCanvas.translate(-paramInt2, -paramInt1);
    }
  }
  
  public boolean fadedDraw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, long paramLong)
  {
    double d1 = paramLong;
    double d2 = FADE_START_INTERVAL;
    Double.isNaN(d1);
    int j = (int)Math.floor(d1 / d2);
    int i = paramPaint.getAlpha();
    if (j - paramInt4 > 0)
    {
      draw(paramCanvas, paramPaint, paramInt1, paramRect, paramInt2, paramInt3, paramBitmap);
      return false;
    }
    String str = HardCodeUtil.a(2131903698);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(str);
    paramPaint.measureText(localStringBuilder.toString());
    paramPaint.measureText(str);
    d2 = paramInt4 + 1;
    double d3 = FADE_START_INTERVAL;
    Double.isNaN(d2);
    Double.isNaN(d1);
    d1 -= d2 * d3;
    if (d1 <= 0.0D)
    {
      paramPaint.setAlpha(i);
      return true;
    }
    d1 = d1 % FADE_SCALE / FADE_SCALE;
    paramInt4 = (int)(255.0D * d1);
    j = (int)((1.0D - d1) * FADE_LENGTH);
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
    Drawable localDrawable = this.emoDrawable;
    if (localDrawable != null) {
      return localDrawable;
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
    int i = ViewUtils.a(4.0F);
    return paramPaint.getBounds().width() + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ImageCell
 * JD-Core Version:    0.7.0.1
 */