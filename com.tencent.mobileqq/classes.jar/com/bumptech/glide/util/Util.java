package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class Util
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  private static final char[] b = new char[64];
  
  public static int a(float paramFloat)
  {
    return a(paramFloat, 17);
  }
  
  public static int a(float paramFloat, int paramInt)
  {
    return b(Float.floatToIntBits(paramFloat), paramInt);
  }
  
  public static int a(int paramInt1, int paramInt2, @Nullable Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * a(paramConfig);
  }
  
  private static int a(@Nullable Bitmap.Config paramConfig)
  {
    Bitmap.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = Bitmap.Config.ARGB_8888;
    }
    int i = Util.1.a[localConfig.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i != 4) {
          return 4;
        }
        return 8;
      }
      return 2;
    }
    return 1;
  }
  
  @TargetApi(19)
  public static int a(@NonNull Bitmap paramBitmap)
  {
    if ((paramBitmap.isRecycled()) || (Build.VERSION.SDK_INT >= 19)) {}
    try
    {
      int i = paramBitmap.getAllocationByteCount();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      label22:
      StringBuilder localStringBuilder;
      break label22;
    }
    return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot obtain size for recycled Bitmap: ");
    localStringBuilder.append(paramBitmap);
    localStringBuilder.append("[");
    localStringBuilder.append(paramBitmap.getWidth());
    localStringBuilder.append("x");
    localStringBuilder.append(paramBitmap.getHeight());
    localStringBuilder.append("] ");
    localStringBuilder.append(paramBitmap.getConfig());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public static int a(@Nullable Object paramObject, int paramInt)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    return b(i, paramInt);
  }
  
  public static int a(boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NonNull
  public static String a(@NonNull byte[] paramArrayOfByte)
  {
    synchronized (b)
    {
      paramArrayOfByte = a(paramArrayOfByte, b);
      return paramArrayOfByte;
    }
  }
  
  @NonNull
  private static String a(@NonNull byte[] paramArrayOfByte, @NonNull char[] paramArrayOfChar)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar = a;
      paramArrayOfChar[k] = arrayOfChar[(j >>> 4)];
      paramArrayOfChar[(k + 1)] = arrayOfChar[(j & 0xF)];
      i += 1;
    }
    return new String(paramArrayOfChar);
  }
  
  @NonNull
  public static <T> List<T> a(@NonNull Collection<T> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  public static <T> Queue<T> a(int paramInt)
  {
    return new ArrayDeque(paramInt);
  }
  
  public static void a()
  {
    if (c()) {
      return;
    }
    throw new IllegalArgumentException("You must call this method on the main thread");
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (c(paramInt1)) && (c(paramInt2));
  }
  
  public static boolean a(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static int b(int paramInt)
  {
    return b(paramInt, 17);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return paramInt2 * 31 + paramInt1;
  }
  
  public static void b()
  {
    if (d()) {
      return;
    }
    throw new IllegalArgumentException("You must call this method on a background thread");
  }
  
  public static boolean b(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    if ((paramObject1 instanceof Model)) {
      return ((Model)paramObject1).a(paramObject2);
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean c()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt > 0) || (paramInt == -2147483648);
  }
  
  public static boolean d()
  {
    return c() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.Util
 * JD-Core Version:    0.7.0.1
 */