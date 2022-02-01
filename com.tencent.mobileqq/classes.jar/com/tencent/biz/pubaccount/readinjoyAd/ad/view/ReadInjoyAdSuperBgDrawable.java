package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ReadInjoyAdSuperBgDrawable
  extends Drawable
{
  private Paint a = new Paint();
  private int b = 0;
  private int c = 0;
  private Bitmap d;
  
  public ReadInjoyAdSuperBgDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.a.setAntiAlias(true);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      ThreadManager.executeOnSubThread(new ReadInjoyAdSuperBgDrawable.1(this, paramDrawable, paramInt1, paramInt2));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramDrawable = new StringBuilder();
      paramDrawable.append("Illegal target: width=");
      paramDrawable.append(paramInt1);
      paramDrawable.append(", height=");
      paramDrawable.append(paramInt2);
      QLog.d("ReadInjoyAdSuperBgDrawable", 2, paramDrawable.toString());
    }
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    return Bitmap.createBitmap(paramBitmap, (paramInt1 - paramInt3) / 2, (paramInt2 - paramInt4) / 2, paramInt3, paramInt4);
  }
  
  private Bitmap a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i != 0)
    {
      if (j == 0) {
        return null;
      }
      Object localObject3;
      if ((i >= paramInt1) && (j >= paramInt2))
      {
        localObject1 = a(i, j, paramInt1, paramInt2, paramBitmap);
        localObject3 = null;
      }
      else
      {
        if ((i >= paramInt1) && (j < paramInt2)) {
          localObject1 = b(i, j, paramInt1, paramInt2, paramBitmap);
        } else if ((i < paramInt1) && (j >= paramInt2)) {
          localObject1 = c(i, j, paramInt1, paramInt2, paramBitmap);
        } else {
          localObject1 = d(i, j, paramInt1, paramInt2, paramBitmap);
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = a(localObject3.getWidth(), localObject3.getHeight(), paramInt1, paramInt2, localObject3);
        }
      }
      if ((localObject3 != null) && (!localObject3.isRecycled())) {
        localObject3.recycle();
      }
      localObject1 = localObject2;
      if (!paramBitmap.isRecycled())
      {
        paramBitmap.recycle();
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int m = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    int j = m;
    int i = k;
    if (f != 0.0D)
    {
      j = (int)(m / f);
      i = (int)(k / f);
    }
    try
    {
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      Object localObject = Bitmap.createBitmap(j, i, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, j, i);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  private Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    try
    {
      paramDrawable = a(paramInt1, paramInt2, a(paramDrawable));
      return paramDrawable;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  private Bitmap b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    if (paramInt2 <= 0) {
      return null;
    }
    float f = paramInt4 * 1.0F / paramInt2;
    return Bitmap.createScaledBitmap(paramBitmap, (int)(paramInt1 * f), paramInt4, false);
  }
  
  private Bitmap c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    if (paramInt1 <= 0) {
      return null;
    }
    float f = paramInt3 * 1.0F / paramInt1;
    return Bitmap.createScaledBitmap(paramBitmap, paramInt3, (int)(paramInt4 * f), false);
  }
  
  private Bitmap d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      float f2 = paramInt3;
      float f1 = paramInt1;
      f2 = f2 * 1.0F / f1;
      float f4 = paramInt4;
      float f3 = paramInt2;
      f4 = f4 * 1.0F / f3;
      if (f2 > f4) {
        paramInt4 = (int)(f3 * f2);
      } else {
        paramInt3 = (int)(f1 * f4);
      }
      return Bitmap.createScaledBitmap(paramBitmap, paramInt3, paramInt4, false);
    }
    return null;
  }
  
  public void a()
  {
    Bitmap localBitmap = this.d;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.d.recycle();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = paramInt2;
    if (this.d != null)
    {
      invalidateSelf();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyAdSuperBgDrawable", 2, "updateDrawRect mBitmap is NULL.");
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.d;
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, -this.c, this.b, this.a);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyAdSuperBgDrawable
 * JD-Core Version:    0.7.0.1
 */