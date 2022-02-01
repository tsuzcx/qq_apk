package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GifImageWithText
  extends NativeGifImage
{
  private ZhituTextManager.DrawTextParam a;
  private Paint b;
  private Paint c;
  private boolean d = false;
  
  public GifImageWithText(File paramFile, boolean paramBoolean, float paramFloat)
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    if ((QLog.isColorLevel()) && (!this.d))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" dst rect is ");
      localStringBuilder.append(paramRect);
      localStringBuilder.append(" but bitmap is ");
      localStringBuilder.append(getWidth());
      localStringBuilder.append(" / ");
      localStringBuilder.append(getHeight());
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
      this.d = true;
    }
    float f2 = paramRect.width() / getWidth();
    float f1;
    if (Math.abs(f2 - 1.0F) < 0.01D)
    {
      if (this.b == null)
      {
        this.b = this.a.c;
        this.c = this.a.d;
      }
      f1 = 1.0F;
    }
    else
    {
      f1 = f2;
      if (this.b == null)
      {
        this.b = new Paint(this.a.c);
        this.b.setTextSize(this.a.c.getTextSize() * f2);
        f1 = f2;
        if (this.a.d != null)
        {
          this.c = new Paint(this.a.d);
          this.c.setTextSize(this.a.d.getTextSize() * f2);
          f1 = f2;
        }
      }
    }
    int i = 0;
    while (i < this.a.a.length)
    {
      f2 = paramRect.top + this.a.a[i] * f1;
      if (this.c != null) {
        paramCanvas.drawText(this.a.b[i], paramRect.exactCenterX(), f2, this.c);
      }
      paramCanvas.drawText(this.a.b[i], paramRect.exactCenterX(), f2, this.b);
      i += 1;
    }
  }
  
  public int a()
  {
    return this.mMetaData[POST_INVALIDATION_TIME_INDEX];
  }
  
  public void a(Canvas paramCanvas)
  {
    Rect localRect = new Rect(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("draw text to file dst rect is ");
      localStringBuilder.append(localRect);
      localStringBuilder.append(" and bitmap is ");
      localStringBuilder.append(getWidth());
      localStringBuilder.append(" / ");
      localStringBuilder.append(getHeight());
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    a(paramCanvas, localRect);
  }
  
  public void a(ZhituTextManager.DrawTextParam paramDrawTextParam)
  {
    this.a = paramDrawTextParam;
  }
  
  public int b()
  {
    return this.mMetaData[FRAME_COUNT_INDEX];
  }
  
  public int c()
  {
    return this.mCurrentFrameIndex;
  }
  
  public Bitmap d()
  {
    return this.mCurrentFrameBitmap;
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
    a(paramCanvas, paramRect);
  }
  
  public void drawFirstFrame(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    super.drawFirstFrame(paramCanvas, paramRect, paramPaint);
    a(paramCanvas, paramRect);
  }
  
  public void e()
  {
    getNextFrame();
    applyNextFrame();
  }
  
  public int f()
  {
    return this.mMetaData[WIDTH_INDEX];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.GifImageWithText
 * JD-Core Version:    0.7.0.1
 */