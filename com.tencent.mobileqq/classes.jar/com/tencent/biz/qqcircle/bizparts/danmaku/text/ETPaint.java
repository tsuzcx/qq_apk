package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import android.util.SparseArray;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.tencent.biz.qcircleshadow.lib.QCircleHostFontHelper;
import com.tencent.qcircle.application.QCircleApplication;
import cooperation.qqcircle.utils.BaseConfig;
import java.lang.ref.SoftReference;

public class ETPaint
  extends Paint
{
  private static int b = -1;
  private static SoftReference<SparseArray<Bitmap>> f;
  private static int[] g;
  private static Canvas h;
  public boolean a = true;
  private IETFont c = QCircleHostFontHelper.createETFont(0, null, 0.0F);
  private Paint d;
  private Paint.FontMetrics e;
  
  public ETPaint()
  {
    this(0);
  }
  
  public ETPaint(int paramInt)
  {
    super(paramInt);
  }
  
  private Bitmap a(int paramInt)
  {
    try
    {
      if (f == null) {
        f = new SoftReference(new SparseArray(5));
      }
      Object localObject3 = (SparseArray)f.get();
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new SparseArray(5);
        f = new SoftReference(localObject1);
      }
      Bitmap localBitmap = (Bitmap)((SparseArray)localObject1).get(paramInt);
      localObject3 = localBitmap;
      if (localBitmap == null) {
        try
        {
          localObject3 = Bitmap.createBitmap(BaseConfig.getScreenWidth(), paramInt, Bitmap.Config.ARGB_8888);
          ((SparseArray)localObject1).put(paramInt, localObject3);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          return null;
        }
      }
      ((Bitmap)localObject3).eraseColor(0);
      return localObject3;
    }
    finally {}
  }
  
  private void a(Paint paramPaint)
  {
    setTextSize(paramPaint.getTextSize());
    setColor(paramPaint.getColor());
    setFakeBoldText(paramPaint.isFakeBoldText());
  }
  
  private boolean e()
  {
    return TextUtils.isEmpty(this.c.getPath()) ^ true;
  }
  
  private boolean f()
  {
    IETFont localIETFont = this.c;
    if (localIETFont == null) {
      return false;
    }
    if (TextUtils.isEmpty(localIETFont.getPath())) {
      return false;
    }
    if (!ETSpace.a().b().nativeIsFontLoaded(this.c.getId())) {
      return ETSpace.a().b().nativeLoadFont(this.c.getPath(), this.c.getId(), true);
    }
    return true;
  }
  
  public Paint a()
  {
    return this.d;
  }
  
  public void a(String paramString, int paramInt, float paramFloat1, float paramFloat2, Canvas paramCanvas, Bitmap paramBitmap)
  {
    if (!this.a) {
      return;
    }
    Object localObject;
    if (d())
    {
      localObject = ETSpace.a().c();
      if ((localObject != null) && (f()))
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          ((IETEngine)localObject).nativeSpaceDrawText(paramString, paramCanvas, paramBitmap, (int)paramFloat1, (int)paramFloat2, this.c, this.d);
          return;
        }
        paramBitmap = Bitmap.createBitmap(((IETEngine)localObject).nativeSpaceMeasureText(paramString, 0, paramString.length(), this.c, null), paramInt, Bitmap.Config.ARGB_8888);
        paramBitmap.eraseColor(0);
        if (h == null) {
          h = new Canvas();
        }
        h.setBitmap(paramBitmap);
        ((IETEngine)localObject).nativeSpaceDrawText(paramString, h, paramBitmap, 0, 0, this.c, this.d);
        paramCanvas.drawBitmap(paramBitmap, paramFloat1, paramFloat2, null);
        paramBitmap.recycle();
        return;
      }
      paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - ascent(), this.d);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = a(paramInt);
      if ((paramBitmap != null) && (ETSpace.a().b() != null) && (f()))
      {
        if (h == null) {
          h = new Canvas();
        }
        h.setBitmap(paramBitmap);
        ETSpace.a().b().nativeSpaceDrawText(paramString, h, paramBitmap, 0, 0, this.c, this.d);
        paramInt = paramBitmap.getWidth();
        int i = paramBitmap.getHeight();
        int j = paramInt * i;
        localObject = g;
        if ((localObject == null) || (localObject.length < j)) {}
        try
        {
          g = new int[j];
          paramBitmap.getPixels(g, 0, paramInt, 0, 0, paramInt, i);
          paramCanvas.drawBitmap(g, 0, paramInt, paramFloat1, paramFloat2, paramInt, i, true, this.d);
          return;
        }
        catch (OutOfMemoryError paramBitmap)
        {
          paramBitmap.printStackTrace();
          paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - ascent(), this.d);
          return;
        }
      }
      paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - ascent(), this.d);
      return;
    }
    if ((ETSpace.a().b() != null) && (f()))
    {
      ETSpace.a().b().nativeSpaceDrawText(paramString, paramCanvas, paramBitmap, (int)paramFloat1, (int)paramFloat2, this.c, this.d);
      return;
    }
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - ascent(), this.d);
  }
  
  public boolean a(int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.c.setId(paramInt1);
    this.c.setPath(paramString);
    this.c.setFontType(paramInt2);
    if (this.d == null) {
      this.d = paramPaint;
    }
    a(paramPaint);
    if (e())
    {
      if (b <= 0)
      {
        paramInt1 = QCircleApplication.APP.getResources().getDimensionPixelSize(2131296686);
        b = Math.max(paramInt1 * paramInt1 * 240 * 8, 1048576);
      }
      if (!ETSpace.a().a(8, b)) {
        return false;
      }
      if ((paramInt2 == 4) && (!ETSpace.a().e())) {
        return false;
      }
      if (ETSpace.a().b() == null) {
        return false;
      }
      if (!f()) {
        return false;
      }
      this.e = ETSpace.a().a(this.c);
    }
    return true;
  }
  
  public float ascent()
  {
    if (e())
    {
      Paint.FontMetrics localFontMetrics = this.e;
      if (localFontMetrics != null) {
        return localFontMetrics.ascent;
      }
    }
    return super.ascent();
  }
  
  public String b()
  {
    return this.c.getPath();
  }
  
  public IETFont c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.c.getFontType() == 4;
  }
  
  public float descent()
  {
    if (e())
    {
      Paint.FontMetrics localFontMetrics = this.e;
      if (localFontMetrics != null) {
        return localFontMetrics.descent;
      }
    }
    return super.descent();
  }
  
  public Paint.FontMetrics getFontMetrics()
  {
    Paint.FontMetrics localFontMetrics2 = this.e;
    Paint.FontMetrics localFontMetrics1 = localFontMetrics2;
    if (localFontMetrics2 == null) {
      localFontMetrics1 = super.getFontMetrics();
    }
    return localFontMetrics1;
  }
  
  public int getTextWidths(String paramString, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if (!e()) {
      return super.getTextWidths(paramString, paramInt1, paramInt2, paramArrayOfFloat);
    }
    if (paramString != null)
    {
      int i = paramInt2 - paramInt1;
      if ((paramInt1 | paramInt2 | i | paramString.length() - paramInt2) >= 0)
      {
        if (i <= paramArrayOfFloat.length)
        {
          if (paramString.length() != 0)
          {
            if (paramInt1 == paramInt2) {
              return 0;
            }
            ETSpace localETSpace = ETSpace.a();
            IETFont localIETFont = this.c;
            Paint localPaint = this.d;
            boolean bool;
            if (localIETFont.getFontType() == 4) {
              bool = true;
            } else {
              bool = false;
            }
            return localETSpace.a(paramString, paramInt1, paramInt2, localIETFont, localPaint, paramArrayOfFloat, bool);
          }
          return 0;
        }
        throw new ArrayIndexOutOfBoundsException();
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException("text cannot be null");
  }
  
  public float measureText(String paramString)
  {
    return measureText(paramString, 0, paramString.length());
  }
  
  public float measureText(String paramString, int paramInt1, int paramInt2)
  {
    if (!e()) {
      return super.measureText(paramString, paramInt1, paramInt2);
    }
    if (paramString != null)
    {
      if ((paramInt1 | paramInt2 | paramInt2 - paramInt1 | paramString.length() - paramInt2) >= 0)
      {
        if ((paramString.length() != 0) && (paramInt1 != paramInt2)) {
          return ETSpace.a().a(paramString, paramInt1, paramInt2, this.c, this.d);
        }
        return 0.0F;
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException("text cannot be null");
  }
  
  public void setColor(int paramInt)
  {
    super.setColor(paramInt);
    this.c.setColor(paramInt);
    Paint localPaint = this.d;
    if (localPaint != null) {
      localPaint.setColor(paramInt);
    }
  }
  
  public void setFakeBoldText(boolean paramBoolean)
  {
    super.setFakeBoldText(paramBoolean);
    Paint localPaint = this.d;
    if (localPaint != null) {
      localPaint.setFakeBoldText(paramBoolean);
    }
    this.c.setBold(paramBoolean);
    this.e = ETSpace.a().a(this.c);
  }
  
  public void setTextSize(float paramFloat)
  {
    super.setTextSize(paramFloat);
    this.c.setSize(paramFloat);
    Paint localPaint = this.d;
    if (localPaint != null) {
      localPaint.setTextSize(paramFloat);
    }
    this.e = ETSpace.a().a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ETPaint
 * JD-Core Version:    0.7.0.1
 */