package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import anzj;
import bnqj;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import vhx;
import via;
import vjg;

public class EmoCell
  extends TextCell
{
  private static final long serialVersionUID = -3999833992135197771L;
  public String emoCode;
  public Drawable emoDrawable;
  
  public EmoCell()
  {
    this.type = 0;
  }
  
  public EmoCell(String paramString)
  {
    this.text = paramString;
  }
  
  public EmoCell(String paramString, Drawable paramDrawable)
  {
    super(0);
    this.emoCode = paramString;
    this.emoDrawable = paramDrawable;
  }
  
  public boolean canBreak()
  {
    return false;
  }
  
  public EmoCell cloneEmoCell()
  {
    EmoCell localEmoCell = new EmoCell();
    localEmoCell.emoDrawable = this.emoDrawable;
    localEmoCell.emoCode = this.emoCode;
    localEmoCell.needHighLight = this.needHighLight;
    localEmoCell.useDefaultFont = this.useDefaultFont;
    localEmoCell.useHanyiColorFont = this.useHanyiColorFont;
    localEmoCell.textColor = this.textColor;
    localEmoCell.uin = this.uin;
    localEmoCell.type = this.type;
    localEmoCell.text = this.text;
    localEmoCell.cellIndex = this.cellIndex;
    localEmoCell.linebreakSeq = this.linebreakSeq;
    localEmoCell.isPresseding = this.isPresseding;
    localEmoCell.isDrawableLoaded = this.isDrawableLoaded;
    localEmoCell.linebreak = this.linebreak;
    localEmoCell.post = this.post;
    localEmoCell.mShadowRadius = this.mShadowRadius;
    localEmoCell.mShadowX = this.mShadowX;
    localEmoCell.mShadowY = this.mShadowY;
    localEmoCell.mShadowColor = this.mShadowColor;
    localEmoCell.linkColor = this.linkColor;
    localEmoCell.fontSize = this.fontSize;
    localEmoCell.useSuperFont = this.useSuperFont;
    return localEmoCell;
  }
  
  public TextCell copy()
  {
    return this;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if ((!this.useDefaultFont) && ((paramPaint instanceof vhx)) && (((vhx)paramPaint).a()) && (!((vhx)paramPaint).a)) {}
    for (;;)
    {
      return;
      try
      {
        paramPaint = getEmoDrawable();
        if (paramPaint != null)
        {
          paramInt2 = paramRect.left;
          paramInt1 = paramRect.top - 1 + (paramInt1 - paramPaint.getBounds().height()) / 2;
          paramCanvas.translate(paramInt2, paramInt1);
          paramPaint.draw(paramCanvas);
          paramCanvas.translate(-paramInt2, -paramInt1);
          return;
        }
      }
      catch (Exception paramCanvas) {}
    }
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
    String str = anzj.a(2131702892);
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
    return this.emoDrawable;
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
    if (TextUtils.isEmpty(this.text))
    {
      this.text = bnqj.g(this.emoCode);
      if (this.text == null) {
        this.text = this.emoCode;
      }
    }
    return this.text;
  }
  
  public float getWidth(Paint paramPaint)
  {
    paramPaint = getEmoDrawable();
    if (paramPaint == null) {
      return 0.0F;
    }
    return paramPaint.getBounds().width();
  }
  
  public int getWidths(Paint paramPaint, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    paramPaint = getEmoDrawable();
    if (paramPaint == null) {}
    for (float f = 0.0F;; f = paramPaint.getBounds().width())
    {
      paramArrayOfFloat[0] = f;
      return 1;
    }
  }
  
  public boolean isEmo()
  {
    return true;
  }
  
  public void reloadDrawable(vjg paramvjg, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    via.a().a(this, paramvjg, paramImageLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoCell
 * JD-Core Version:    0.7.0.1
 */