package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils
{
  private static final Paint a = new Paint(6);
  private static final Paint b = new Paint(7);
  private static final Paint c;
  private static final Set<String> d = new HashSet(Arrays.asList(new String[] { "XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079" }));
  private static final Lock e;
  
  static
  {
    Object localObject;
    if (d.contains(Build.MODEL)) {
      localObject = new ReentrantLock();
    } else {
      localObject = new TransformationUtils.NoLock();
    }
    e = (Lock)localObject;
    c = new Paint(7);
    c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
    case 8: 
      return 270;
    case 5: 
    case 6: 
      return 90;
    }
    return 180;
  }
  
  @NonNull
  private static Bitmap.Config a(@NonNull Bitmap paramBitmap)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.RGBA_F16.equals(paramBitmap.getConfig()))) {
      return Bitmap.Config.RGBA_F16;
    }
    return Bitmap.Config.ARGB_8888;
  }
  
  private static Bitmap a(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = a(paramBitmap);
    if (localConfig.equals(paramBitmap.getConfig())) {
      return paramBitmap;
    }
    paramBitmapPool = paramBitmapPool.a(paramBitmap.getWidth(), paramBitmap.getHeight(), localConfig);
    new Canvas(paramBitmapPool).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    return paramBitmapPool;
  }
  
  public static Bitmap a(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt)
  {
    if (!b(paramInt)) {
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    a(paramInt, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    localMatrix.mapRect(localRectF);
    paramBitmapPool = paramBitmapPool.a(Math.round(localRectF.width()), Math.round(localRectF.height()), b(paramBitmap));
    localMatrix.postTranslate(-localRectF.left, -localRectF.top);
    a(paramBitmap, paramBitmapPool, localMatrix);
    return paramBitmapPool;
  }
  
  public static Bitmap a(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2)) {
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f3 = 0.0F;
    float f1;
    float f2;
    if (i * paramInt2 > j * paramInt1)
    {
      f1 = paramInt2 / paramBitmap.getHeight();
      f2 = (paramInt1 - paramBitmap.getWidth() * f1) * 0.5F;
    }
    else
    {
      f1 = paramInt1 / paramBitmap.getWidth();
      f3 = (paramInt2 - paramBitmap.getHeight() * f1) * 0.5F;
      f2 = 0.0F;
    }
    localMatrix.setScale(f1, f1);
    localMatrix.postTranslate((int)(f2 + 0.5F), (int)(f3 + 0.5F));
    paramBitmapPool = paramBitmapPool.a(paramInt1, paramInt2, b(paramBitmap));
    a(paramBitmap, paramBitmapPool);
    a(paramBitmap, paramBitmapPool, localMatrix);
    return paramBitmapPool;
  }
  
  public static Lock a()
  {
    return e;
  }
  
  @VisibleForTesting
  static void a(int paramInt, Matrix paramMatrix)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8: 
      paramMatrix.setRotate(-90.0F);
      return;
    case 7: 
      paramMatrix.setRotate(-90.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 6: 
      paramMatrix.setRotate(90.0F);
      return;
    case 5: 
      paramMatrix.setRotate(90.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 4: 
      paramMatrix.setRotate(180.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 3: 
      paramMatrix.setRotate(180.0F);
      return;
    }
    paramMatrix.setScale(-1.0F, 1.0F);
  }
  
  public static void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    paramBitmap2.setHasAlpha(paramBitmap1.hasAlpha());
  }
  
  private static void a(@NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2, Matrix paramMatrix)
  {
    e.lock();
    try
    {
      paramBitmap2 = new Canvas(paramBitmap2);
      paramBitmap2.drawBitmap(paramBitmap1, paramMatrix, a);
      a(paramBitmap2);
      return;
    }
    finally
    {
      e.unlock();
    }
  }
  
  private static void a(Canvas paramCanvas)
  {
    paramCanvas.setBitmap(null);
  }
  
  @NonNull
  private static Bitmap.Config b(@NonNull Bitmap paramBitmap)
  {
    if (paramBitmap.getConfig() != null) {
      return paramBitmap.getConfig();
    }
    return Bitmap.Config.ARGB_8888;
  }
  
  public static Bitmap b(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.a(bool, "roundingRadius must be greater than 0.");
    Object localObject1 = a(paramBitmap);
    Bitmap localBitmap = a(paramBitmapPool, paramBitmap);
    localObject1 = paramBitmapPool.a(localBitmap.getWidth(), localBitmap.getHeight(), (Bitmap.Config)localObject1);
    ((Bitmap)localObject1).setHasAlpha(true);
    Object localObject2 = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setShader((Shader)localObject2);
    localObject2 = new RectF(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
    e.lock();
    try
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      float f = paramInt;
      localCanvas.drawRoundRect((RectF)localObject2, f, f, localPaint);
      a(localCanvas);
      e.unlock();
      if (!localBitmap.equals(paramBitmap)) {
        paramBitmapPool.a(localBitmap);
      }
      return localObject1;
    }
    finally
    {
      e.unlock();
    }
  }
  
  public static Bitmap b(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "requested target size matches input, returning input");
      }
      return paramBitmap;
    }
    float f = Math.min(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight());
    int i = Math.round(paramBitmap.getWidth() * f);
    int j = Math.round(paramBitmap.getHeight() * f);
    if ((paramBitmap.getWidth() == i) && (paramBitmap.getHeight() == j))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "adjusted target size matches input, returning input");
      }
      return paramBitmap;
    }
    paramBitmapPool = paramBitmapPool.a((int)(paramBitmap.getWidth() * f), (int)(paramBitmap.getHeight() * f), b(paramBitmap));
    a(paramBitmap, paramBitmapPool);
    if (Log.isLoggable("TransformationUtils", 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramInt2);
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toFit:   ");
      ((StringBuilder)localObject).append(paramBitmap.getWidth());
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramBitmap.getHeight());
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toReuse: ");
      ((StringBuilder)localObject).append(paramBitmapPool.getWidth());
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramBitmapPool.getHeight());
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("minPct:   ");
      ((StringBuilder)localObject).append(f);
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f, f);
    a(paramBitmap, paramBitmapPool, (Matrix)localObject);
    return paramBitmapPool;
  }
  
  public static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static Bitmap c(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() <= paramInt1) && (paramBitmap.getHeight() <= paramInt2))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
      }
      return paramBitmap;
    }
    if (Log.isLoggable("TransformationUtils", 2)) {
      Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
    }
    return b(paramBitmapPool, paramBitmap, paramInt1, paramInt2);
  }
  
  public static Bitmap d(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(paramInt1, paramInt2);
    float f2 = paramInt1;
    float f1 = f2 / 2.0F;
    paramInt2 = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    float f3 = paramInt2;
    float f5 = f2 / f3;
    float f4 = i;
    f5 = Math.max(f5, f2 / f4);
    f3 *= f5;
    f4 = f5 * f4;
    f5 = (f2 - f3) / 2.0F;
    f2 = (f2 - f4) / 2.0F;
    RectF localRectF = new RectF(f5, f2, f3 + f5, f4 + f2);
    Bitmap localBitmap1 = a(paramBitmapPool, paramBitmap);
    Bitmap localBitmap2 = paramBitmapPool.a(paramInt1, paramInt1, a(paramBitmap));
    localBitmap2.setHasAlpha(true);
    e.lock();
    try
    {
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawCircle(f1, f1, f1, b);
      localCanvas.drawBitmap(localBitmap1, null, localRectF, c);
      a(localCanvas);
      e.unlock();
      if (!localBitmap1.equals(paramBitmap)) {
        paramBitmapPool.a(localBitmap1);
      }
      return localBitmap2;
    }
    finally
    {
      e.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.TransformationUtils
 * JD-Core Version:    0.7.0.1
 */