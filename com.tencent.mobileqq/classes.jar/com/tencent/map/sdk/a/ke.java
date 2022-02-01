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
    return paramInt & 0xFF00FFFF & 0xFFFFFF00 | (paramInt & 0xFF) << 16 | (0xFF0000 & paramInt) >> 16;
  }
  
  public static boolean a(File paramFile, String paramString, byte[] paramArrayOfByte, Lock paramLock)
  {
    Object localObject;
    if (!nl.a(paramString))
    {
      if (paramArrayOfByte.length == 0) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(Arrays.hashCode(paramArrayOfByte));
      localObject = ((StringBuilder)localObject).toString();
    }
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
          return false;
        }
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = new File(paramFile, paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".bak");
        paramFile = new File(paramFile, localStringBuilder.toString());
        if ((paramFile.exists()) && (!paramFile.delete()))
        {
          paramFile.deleteOnExit();
          return false;
        }
        try
        {
          paramLock.lock();
          if ((paramArrayOfByte.exists()) && (!paramArrayOfByte.renameTo(paramFile)))
          {
            if (!((File)localObject).delete()) {
              ((File)localObject).deleteOnExit();
            }
            return false;
          }
          if (!((File)localObject).renameTo(paramArrayOfByte))
          {
            paramFile.renameTo(paramArrayOfByte);
            if (!((File)localObject).delete()) {
              ((File)localObject).deleteOnExit();
            }
            return false;
          }
          if (!paramFile.delete()) {
            paramFile.deleteOnExit();
          }
          return true;
        }
        finally
        {
          paramLock.unlock();
        }
      }
      return false;
    }
    catch (Exception paramFile) {}
    return false;
  }
  
  public final Bitmap a(String paramString, Bitmap.Config paramConfig)
  {
    Object localObject;
    if (new File(paramString).exists())
    {
      localObject = this.f;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return null;
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inPreferredConfig = paramConfig;
      }
    }
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
    return null;
  }
  
  public final IconImageInfo a(String paramString)
  {
    Object localObject1 = this.g;
    Paint localPaint = null;
    if (localObject1 == null) {
      return null;
    }
    localIconImageInfo = new IconImageInfo();
    localIconImageInfo.anchorPointX1 = 0.5F;
    localIconImageInfo.anchorPointY1 = 0.5F;
    if (paramString.startsWith("drawRoundRect"))
    {
      localIconImageInfo.scale = 1.0F;
      localObject1 = paramString.substring(14);
      if (nl.a((String)localObject1))
      {
        localObject1 = localPaint;
      }
      else
      {
        Object localObject3 = ((String)localObject1).split(", ");
        localObject1 = localPaint;
        if (localObject3 != null) {
          if (localObject3.length < 5)
          {
            localObject1 = localPaint;
          }
          else
          {
            int i = Integer.parseInt(localObject3[0]);
            int j = Integer.parseInt(localObject3[1]);
            long l1 = Long.parseLong(localObject3[2]);
            long l2 = Long.parseLong(localObject3[3]);
            float f1 = Float.parseFloat(localObject3[4]);
            localObject1 = localPaint;
            if (i >= 0) {
              if (j < 0)
              {
                localObject1 = localPaint;
              }
              else
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
      localIconImageInfo.bitmap = ((Bitmap)localObject1);
      if (localIconImageInfo.bitmap == null)
      {
        localObject1 = this.h;
        if (localObject1 != null) {
          ((jg)localObject1).a(System.currentTimeMillis(), paramString);
        }
      }
      return localIconImageInfo;
    }
    try
    {
      this.e.lock();
      this.g.a(paramString, localIconImageInfo);
      jg localjg;
      return localIconImageInfo;
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
          break label463;
        }
        this.h.a(System.currentTimeMillis(), paramString);
        return localIconImageInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (localIconImageInfo.bitmap != null) {
          break label461;
        }
        localjg = this.h;
        if (localjg == null) {
          break label461;
        }
        localjg.a(System.currentTimeMillis(), paramString);
        return null;
      }
      localObject2 = finally;
      this.e.unlock();
    }
  }
  
  public final void a()
  {
    this.d.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ke
 * JD-Core Version:    0.7.0.1
 */