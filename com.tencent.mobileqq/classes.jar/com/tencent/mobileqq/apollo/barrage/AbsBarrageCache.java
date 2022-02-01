package com.tencent.mobileqq.apollo.barrage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class AbsBarrageCache
{
  private static HashMap<Float, Float> b = new HashMap();
  private static HashMap<String, Integer> c = new HashMap();
  private static TextPaint d = new TextPaint(1);
  protected HashMap<String, WeakReference<Bitmap>> a = new HashMap();
  
  public static float a(float paramFloat)
  {
    Float localFloat = (Float)b.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      if (paramFloat != d.getTextSize()) {
        d.setTextSize(paramFloat);
      }
      localObject = d.getFontMetrics();
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent + ((Paint.FontMetrics)localObject).leading);
      b.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  public static float a(Barrage paramBarrage1, Barrage paramBarrage2)
  {
    if ((paramBarrage1 != null) && (paramBarrage2 != null))
    {
      float f1 = a(paramBarrage1.l);
      float f2 = paramBarrage1.t * 2;
      return (a(paramBarrage2.l) + paramBarrage2.t * 2) / (f1 + f2);
    }
    return 1.0F;
  }
  
  public void a(Barrage paramBarrage)
  {
    if ((paramBarrage != null) && (!TextUtils.isEmpty(paramBarrage.a)))
    {
      if (paramBarrage.b) {
        return;
      }
      if (d.getTextSize() != paramBarrage.l) {
        d.setTextSize(paramBarrage.l);
      }
      d.setColor(paramBarrage.k);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBarrage.a);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(Float.valueOf(paramBarrage.l));
      String str = ((StringBuilder)localObject).toString();
      Integer localInteger = (Integer)c.get(str);
      localObject = localInteger;
      if (localInteger == null)
      {
        localObject = Integer.valueOf((int)Math.ceil(StaticLayout.getDesiredWidth(paramBarrage.a, d)));
        c.put(str, localObject);
      }
      localObject = new StaticLayout(paramBarrage.a, d, ((Integer)localObject).intValue(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
      paramBarrage.q = (((StaticLayout)localObject).getWidth() + paramBarrage.s * 2);
      paramBarrage.r = (((StaticLayout)localObject).getHeight() + paramBarrage.t * 2);
      paramBarrage.b = true;
      paramBarrage.w = ((StaticLayout)localObject);
    }
  }
  
  public abstract void a(Barrage paramBarrage, Bitmap paramBitmap);
  
  public Bitmap b(Barrage paramBarrage)
  {
    Object localObject4;
    Object localObject1;
    Canvas localCanvas;
    if ((paramBarrage != null) && (paramBarrage.q != 0))
    {
      if (paramBarrage.r == 0) {
        return null;
      }
      localObject4 = c(paramBarrage);
      if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled()))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("find from cache: ");
          ((StringBuilder)localObject1).append(paramBarrage.a);
          QLog.d("[cmshow]AbsBarrageCache", 2, ((StringBuilder)localObject1).toString());
        }
        return localObject4;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("buildCache: ");
        ((StringBuilder)localObject1).append(paramBarrage.a);
        QLog.d("[cmshow]AbsBarrageCache", 2, ((StringBuilder)localObject1).toString());
      }
      localCanvas = new Canvas();
    }
    for (Object localObject3 = localObject4;; localObject3 = null)
    {
      Object localObject2;
      try
      {
        localObject2 = Bitmap.createBitmap(paramBarrage.q, paramBarrage.r, Bitmap.Config.ARGB_8888);
        localObject3 = localObject2;
        localObject4 = localObject2;
        localCanvas.setBitmap((Bitmap)localObject2);
        localObject3 = localObject2;
        localObject4 = localObject2;
        if (!TextUtils.isEmpty(paramBarrage.c))
        {
          localObject3 = localObject2;
          localObject4 = localObject2;
          localObject1 = (WeakReference)this.a.get(paramBarrage.c);
          if (localObject1 == null) {
            continue;
          }
          localObject3 = localObject2;
          localObject4 = localObject2;
          localObject1 = (Bitmap)((WeakReference)localObject1).get();
          localObject3 = localObject1;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = localObject3;
            localObject3 = localObject2;
            localObject4 = localObject2;
            if (new File(paramBarrage.c).exists())
            {
              localObject3 = localObject2;
              localObject4 = localObject2;
              localObject5 = new FileInputStream(paramBarrage.c);
              localObject3 = localObject2;
              localObject4 = localObject2;
              BufferedInputStream localBufferedInputStream = new BufferedInputStream((InputStream)localObject5);
              localObject3 = localObject2;
              localObject4 = localObject2;
              localObject1 = BitmapFactory.decodeStream(localBufferedInputStream);
              localObject3 = localObject2;
              localObject4 = localObject2;
              this.a.put(paramBarrage.c, new WeakReference(localObject1));
              localObject3 = localObject2;
              localObject4 = localObject2;
              localBufferedInputStream.close();
              localObject3 = localObject2;
              localObject4 = localObject2;
              ((FileInputStream)localObject5).close();
            }
          }
        }
        else
        {
          localObject1 = null;
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = localObject2;
          localObject4 = localObject2;
          localObject5 = (WeakReference)this.a.get("apollo_barrage_bg");
          localObject3 = localObject1;
          if (localObject5 != null)
          {
            localObject3 = localObject2;
            localObject4 = localObject2;
            localObject1 = (Bitmap)((WeakReference)localObject5).get();
            localObject3 = localObject1;
          }
        }
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject3 = localObject2;
          localObject4 = localObject2;
          localObject1 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130838466, null);
          localObject3 = localObject2;
          localObject4 = localObject2;
          this.a.put("apollo_barrage_bg", new WeakReference(localObject1));
        }
        localObject3 = localObject2;
        localObject4 = localObject2;
        Object localObject5 = ((Bitmap)localObject1).getNinePatchChunk();
        if (localObject5 != null)
        {
          localObject3 = localObject2;
          localObject4 = localObject2;
          new NinePatch((Bitmap)localObject1, (byte[])localObject5, null).draw(localCanvas, new Rect(0, 0, paramBarrage.q, paramBarrage.r), null);
        }
        else
        {
          localObject3 = localObject2;
          localObject4 = localObject2;
          localCanvas.drawBitmap((Bitmap)localObject1, new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight()), new Rect(0, 0, paramBarrage.q, paramBarrage.r), null);
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("[cmshow]AbsBarrageCache", 2, localException.getMessage());
          localObject2 = localObject3;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject2 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.e("[cmshow]AbsBarrageCache", 2, localOutOfMemoryError.getMessage());
          localObject2 = localObject4;
        }
      }
      if (paramBarrage.w != null)
      {
        localCanvas.translate(paramBarrage.s, paramBarrage.t);
        paramBarrage.w.draw(localCanvas);
      }
      a(paramBarrage, (Bitmap)localObject2);
      return localObject2;
      return null;
    }
  }
  
  public abstract Bitmap c(Barrage paramBarrage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.AbsBarrageCache
 * JD-Core Version:    0.7.0.1
 */