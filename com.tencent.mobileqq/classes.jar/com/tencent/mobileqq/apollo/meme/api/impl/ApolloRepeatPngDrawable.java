package com.tencent.mobileqq.apollo.meme.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.meme.FrameData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/api/impl/ApolloRepeatPngDrawable;", "Landroid/graphics/drawable/Drawable;", "key", "", "frameTime", "", "(Ljava/lang/String;I)V", "currentFrame", "Lcom/tencent/mobileqq/apollo/meme/FrameData;", "frameDataMap", "", "getKey", "()Ljava/lang/String;", "lastFrameDrawTime", "", "lowMemoryMode", "", "mainHandler", "Landroid/os/Handler;", "nextFrame", "addFrame", "", "index", "pixels", "", "dataWidth", "dataHeight", "targetWidth", "targetHeight", "currentPlayIndex", "decodeNextFrame", "nextIndex", "nextFrameTime", "draw", "canvas", "Landroid/graphics/Canvas;", "getNextIndex", "getOpacity", "isFrameExistByIndex", "recycle", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "totalFrameCount", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloRepeatPngDrawable
  extends Drawable
{
  public static final ApolloRepeatPngDrawable.Companion a = new ApolloRepeatPngDrawable.Companion(null);
  private final Map<Integer, FrameData> b;
  private FrameData c;
  private FrameData d;
  private long e;
  private final Handler f;
  private final boolean g;
  @NotNull
  private final String h;
  private final int i;
  
  public ApolloRepeatPngDrawable(@NotNull String paramString, int paramInt)
  {
    this.h = paramString;
    this.i = paramInt;
    this.b = ((Map)new LinkedHashMap());
    this.f = new Handler(Looper.getMainLooper());
    this.g = CmShowWnsUtils.w();
  }
  
  private final void a(int paramInt, long paramLong)
  {
    ThreadManager.excute((Runnable)new ApolloRepeatPngDrawable.decodeNextFrame.1(this, paramInt, paramLong), 16, null, false);
  }
  
  private final int e()
  {
    FrameData localFrameData = this.c;
    int j;
    if (localFrameData != null)
    {
      if (localFrameData == null) {
        Intrinsics.throwNpe();
      }
      j = localFrameData.d();
    }
    else
    {
      j = -1;
    }
    int k = j + 1;
    if (!this.b.containsKey(Integer.valueOf(k)))
    {
      if (this.g) {
        return j;
      }
      return 0;
    }
    return k;
  }
  
  public final void a()
  {
    Object localObject = ((Iterable)this.b.values()).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FrameData)((Iterator)localObject).next()).c();
    }
    this.b.clear();
    localObject = this.c;
    if (localObject != null) {
      ((FrameData)localObject).c();
    }
    localObject = (FrameData)null;
    this.c = ((FrameData)localObject);
    FrameData localFrameData = this.d;
    if (localFrameData != null) {
      localFrameData.c();
    }
    this.d = ((FrameData)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(" recycle.");
    QLog.i("[cmshow]ApolloRepeatPngDrawable", 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (this.b.containsKey(Integer.valueOf(paramInt1))) {
      return;
    }
    Map localMap = this.b;
    paramArrayOfByte = new FrameData(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt6);
    paramArrayOfByte.a(paramInt4);
    paramArrayOfByte.b(paramInt5);
    localMap.put(Integer.valueOf(paramInt1), paramArrayOfByte);
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(this);
      paramArrayOfByte.append(" add frame for ");
      paramArrayOfByte.append(this.h);
      paramArrayOfByte.append(" index:");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(", frameDataList:");
      paramArrayOfByte.append(this.b.keySet());
      QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, paramArrayOfByte.toString());
    }
  }
  
  public final boolean a(int paramInt)
  {
    return this.b.containsKey(Integer.valueOf(paramInt));
  }
  
  public final int b()
  {
    FrameData localFrameData = this.c;
    if (localFrameData != null)
    {
      if (localFrameData == null) {
        Intrinsics.throwNpe();
      }
      return localFrameData.d();
    }
    return -1;
  }
  
  public final int c()
  {
    return this.b.size();
  }
  
  @NotNull
  public final String d()
  {
    return this.h;
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Object localObject1 = this.d;
    if (localObject1 != null) {
      localObject1 = ((FrameData)localObject1).b();
    } else {
      localObject1 = null;
    }
    long l1 = SystemClock.uptimeMillis();
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      if (this.g)
      {
        Object localObject2 = this.c;
        if ((localObject2 != null) && (this.d != null))
        {
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          int j = ((FrameData)localObject2).d();
          localObject2 = this.d;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          if (j != ((FrameData)localObject2).d())
          {
            localObject2 = this.c;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            ((FrameData)localObject2).c();
            localObject2 = this.b;
            Object localObject3 = this.c;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            ((Map)localObject2).remove(Integer.valueOf(((FrameData)localObject3).d()));
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(this);
              ((StringBuilder)localObject3).append(" remove frame for ");
              ((StringBuilder)localObject3).append(this.h);
              ((StringBuilder)localObject3).append(" index:");
              localObject2 = this.c;
              if (localObject2 != null) {
                localObject2 = Integer.valueOf(((FrameData)localObject2).d());
              } else {
                localObject2 = null;
              }
              ((StringBuilder)localObject3).append(localObject2);
              ((StringBuilder)localObject3).append(", frameDataList:");
              ((StringBuilder)localObject3).append(this.b.keySet());
              QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
      }
      this.c = this.d;
      this.d = ((FrameData)null);
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      if ((this.e > 0L) && (QLog.isColorLevel()))
      {
        paramCanvas = new StringBuilder();
        paramCanvas.append(this);
        paramCanvas.append(" draw new frame for ");
        paramCanvas.append(this.h);
        paramCanvas.append(" interval ");
        paramCanvas.append(l1 - this.e);
        paramCanvas.append("ms");
        QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, paramCanvas.toString());
      }
      this.e = l1;
    }
    long l2 = this.i;
    a(e(), l1 + l2);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.impl.ApolloRepeatPngDrawable
 * JD-Core Version:    0.7.0.1
 */