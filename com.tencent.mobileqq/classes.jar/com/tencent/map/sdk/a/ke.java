package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.tencent.map.sdk.engine.jni.models.IconImageInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ke
{
  public lg a;
  public md b;
  public float c = 1.0F;
  public Lock d = new ReentrantLock();
  public Lock e = new ReentrantLock();
  private WeakReference<Context> f;
  private lz g;
  private jg h;
  
  public ke(Context paramContext, lg paramlg, md parammd, lz paramlz)
  {
    this.f = new WeakReference(paramContext);
    this.a = paramlg;
    this.b = parammd;
    this.g = paramlz;
    this.c = pz.a(paramContext);
    if ((paramlg.c() != null) && (paramlg.c().get() != null)) {
      this.h = ((lf)paramlg.c().get()).c();
    }
  }
  
  private static int a(int paramInt)
  {
    return (0xFF0000 & paramInt) >> 16 | (paramInt & 0xFF) << 16 | 0xFF00FFFF & paramInt & 0xFFFFFF00;
  }
  
  public static boolean a(File paramFile, String paramString, byte[] paramArrayOfByte, Lock paramLock)
  {
    if ((nl.a(paramString)) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return false;
      Object localObject = paramString + "_" + Arrays.hashCode(paramArrayOfByte);
      label258:
      label269:
      try
      {
        if (!paramFile.exists()) {
          paramFile.mkdirs();
        }
        localObject = new File(paramFile, (String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        ((File)localObject).createNewFile();
        om.a((File)localObject, paramArrayOfByte);
        paramArrayOfByte = ou.a(paramArrayOfByte);
        try
        {
          boolean bool = paramArrayOfByte.equals(ou.a((File)localObject));
          if (!bool) {
            continue;
          }
        }
        catch (FileNotFoundException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
          }
          try
          {
            paramLock.lock();
            if ((!paramArrayOfByte.exists()) || (paramArrayOfByte.renameTo(paramFile))) {
              break label222;
            }
            if (((File)localObject).delete()) {
              break label214;
            }
            ((File)localObject).deleteOnExit();
            return false;
            if (((File)localObject).renameTo(paramArrayOfByte)) {
              break label258;
            }
            paramFile.renameTo(paramArrayOfByte);
            if (((File)localObject).delete()) {
              break label250;
            }
            ((File)localObject).deleteOnExit();
            return false;
            if (paramFile.delete()) {
              break label269;
            }
            paramFile.deleteOnExit();
            return true;
          }
          finally
          {
            paramLock.unlock();
          }
        }
        paramArrayOfByte = new File(paramFile, paramString);
        paramFile = new File(paramFile, paramString + ".bak");
        if ((paramFile.exists()) && (!paramFile.delete()))
        {
          paramFile.deleteOnExit();
          return false;
        }
        label214:
        label222:
        label250:
        return false;
      }
      catch (Exception paramFile) {}
    }
  }
  
  public final Bitmap a(String paramString, Bitmap.Config paramConfig)
  {
    if ((!new File(paramString).exists()) || (this.f == null) || (this.f.get() == null)) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = paramConfig;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public final IconImageInfo a(String paramString)
  {
    Paint localPaint = null;
    if (this.g == null) {}
    IconImageInfo localIconImageInfo;
    do
    {
      for (;;)
      {
        return null;
        localIconImageInfo = new IconImageInfo();
        localIconImageInfo.anchorPointX1 = 0.5F;
        localIconImageInfo.anchorPointY1 = 0.5F;
        if (paramString.startsWith("drawRoundRect"))
        {
          localIconImageInfo.scale = 1.0F;
          Object localObject1 = paramString.substring(14);
          if (nl.a((String)localObject1)) {
            localObject1 = localPaint;
          }
          for (;;)
          {
            localIconImageInfo.bitmap = ((Bitmap)localObject1);
            if ((localIconImageInfo.bitmap == null) && (this.h != null)) {
              this.h.a(System.currentTimeMillis(), paramString);
            }
            return localIconImageInfo;
            Object localObject3 = ((String)localObject1).split(", ");
            localObject1 = localPaint;
            if (localObject3 != null)
            {
              localObject1 = localPaint;
              if (localObject3.length >= 5)
              {
                int i = Integer.parseInt(localObject3[0]);
                int j = Integer.parseInt(localObject3[1]);
                long l1 = Long.parseLong(localObject3[2]);
                long l2 = Long.parseLong(localObject3[3]);
                float f1 = Float.parseFloat(localObject3[4]);
                localObject1 = localPaint;
                if (i >= 0)
                {
                  localObject1 = localPaint;
                  if (j >= 0)
                  {
                    localPaint = new Paint();
                    localPaint.setAntiAlias(true);
                    localPaint.setStrokeWidth(f1);
                    localPaint.setStyle(Paint.Style.STROKE);
                    localPaint.setColor(a((int)l2));
                    localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
                    localObject3 = new Canvas((Bitmap)localObject1);
                    ((Canvas)localObject3).drawColor(a((int)l1));
                    RectF localRectF = new RectF();
                    localRectF.left = 0.0F;
                    localRectF.top = 0.0F;
                    localRectF.right = i;
                    localRectF.bottom = j;
                    ((Canvas)localObject3).drawRoundRect(localRectF, i >> 3, j >> 3, localPaint);
                  }
                }
              }
            }
          }
        }
        try
        {
          this.e.lock();
          this.g.a(paramString, localIconImageInfo);
          if (localIconImageInfo.bitmap != null) {}
        }
        finally
        {
          try
          {
            this.e.unlock();
            if (localIconImageInfo.bitmap == null) {
              paramString.equals("compass.png");
            }
            if ((localIconImageInfo.bitmap != null) || (this.h == null)) {
              break label449;
            }
            this.h.a(System.currentTimeMillis(), paramString);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          localObject2 = finally;
          this.e.unlock();
          throw localObject2;
        }
      }
    } while (this.h == null);
    this.h.a(System.currentTimeMillis(), paramString);
    return null;
    label449:
    return localIconImageInfo;
  }
  
  public final void a()
  {
    this.d.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ke
 * JD-Core Version:    0.7.0.1
 */