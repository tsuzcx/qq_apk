package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class VideoDrawable
  extends Drawable
{
  private static Bitmap g;
  Paint a = new Paint(7);
  int b = 119;
  int c = 160;
  boolean d = false;
  private Bitmap e;
  private final Rect f = new Rect();
  private int h;
  private int i;
  
  public VideoDrawable(Bitmap paramBitmap, Resources paramResources)
  {
    this.c = paramResources.getDisplayMetrics().densityDpi;
    a(paramBitmap);
  }
  
  private void b()
  {
    Bitmap localBitmap = this.e;
    if (localBitmap != null)
    {
      this.h = localBitmap.getScaledWidth(this.c);
      this.i = this.e.getScaledHeight(this.c);
    }
  }
  
  public Bitmap a()
  {
    return this.e;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != this.e)
    {
      this.e = paramBitmap;
      b();
      invalidateSelf();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  @TargetApi(21)
  public void draw(Canvas paramCanvas)
  {
    if (this.e != null)
    {
      copyBounds(this.f);
      if ((this.d) && (g == null)) {
        try
        {
          g = Bitmap.createBitmap(this.f.width(), this.f.height(), Bitmap.Config.ARGB_4444);
          Canvas localCanvas = new Canvas(g);
          this.a.setColor(-1);
          localCanvas.drawOval(new RectF(0.0F, 0.0F, this.f.width(), this.f.height()), this.a);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.i("VideoDrawable", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        int j = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
        paramCanvas.drawBitmap(this.e, null, this.f, this.a);
        if ((this.d) && (g != null))
        {
          this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          paramCanvas.drawBitmap(g, null, this.f, this.a);
          this.a.setXfermode(null);
        }
        paramCanvas.restoreToCount(j);
        return;
      }
      paramCanvas.drawBitmap(this.e, null, this.f, this.a);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.i;
  }
  
  public int getIntrinsicWidth()
  {
    return this.h;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.a.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.a.setFilterBitmap(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawable
 * JD-Core Version:    0.7.0.1
 */