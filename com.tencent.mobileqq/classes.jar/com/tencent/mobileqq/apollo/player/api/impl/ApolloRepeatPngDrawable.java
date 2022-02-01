package com.tencent.mobileqq.apollo.player.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.player.FrameData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/api/impl/ApolloRepeatPngDrawable;", "Landroid/graphics/drawable/Drawable;", "key", "", "frameTime", "", "(Ljava/lang/String;I)V", "currentFrame", "Lcom/tencent/mobileqq/apollo/player/FrameData;", "frameDataMap", "", "getKey", "()Ljava/lang/String;", "lastFrameDrawTime", "", "lowMemoryMode", "", "mainHandler", "Landroid/os/Handler;", "nextFrame", "addFrame", "", "index", "pixels", "", "dataWidth", "dataHeight", "targetWidth", "targetHeight", "currentPlayIndex", "decodeNextFrame", "nextIndex", "nextFrameTime", "draw", "canvas", "Landroid/graphics/Canvas;", "getNextIndex", "getOpacity", "isFrameExistByIndex", "recycle", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "totalFrameCount", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloRepeatPngDrawable
  extends Drawable
{
  public static final ApolloRepeatPngDrawable.Companion a;
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private FrameData jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final Map<Integer, FrameData> jdField_a_of_type_JavaUtilMap;
  private final boolean jdField_a_of_type_Boolean;
  private FrameData b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerApiImplApolloRepeatPngDrawable$Companion = new ApolloRepeatPngDrawable.Companion(null);
  }
  
  public ApolloRepeatPngDrawable(@NotNull String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = CmShowWnsUtils.r();
  }
  
  private final void a(int paramInt, long paramLong)
  {
    ThreadManager.excute((Runnable)new ApolloRepeatPngDrawable.decodeNextFrame.1(this, paramInt, paramLong), 16, null, false);
  }
  
  private final int c()
  {
    FrameData localFrameData = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData;
    int i;
    if (localFrameData != null)
    {
      if (localFrameData == null) {
        Intrinsics.throwNpe();
      }
      i = localFrameData.a();
    }
    else
    {
      i = -1;
    }
    int j = i + 1;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(j)))
    {
      if (this.jdField_a_of_type_Boolean) {
        return i;
      }
      return 0;
    }
    return j;
  }
  
  public final int a()
  {
    FrameData localFrameData = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData;
    if (localFrameData != null)
    {
      if (localFrameData == null) {
        Intrinsics.throwNpe();
      }
      return localFrameData.a();
    }
    return -1;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    Object localObject = ((Iterable)this.jdField_a_of_type_JavaUtilMap.values()).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FrameData)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData;
    if (localObject != null) {
      ((FrameData)localObject).a();
    }
    localObject = (FrameData)null;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData = ((FrameData)localObject);
    FrameData localFrameData = this.b;
    if (localFrameData != null) {
      localFrameData.a();
    }
    this.b = ((FrameData)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" recycle.");
    QLog.i("[cmshow]ApolloRepeatPngDrawable", 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1))) {
      return;
    }
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    paramArrayOfByte = new FrameData(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt6);
    paramArrayOfByte.a(paramInt4);
    paramArrayOfByte.b(paramInt5);
    localMap.put(Integer.valueOf(paramInt1), paramArrayOfByte);
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(this);
      paramArrayOfByte.append(" add frame for ");
      paramArrayOfByte.append(this.jdField_a_of_type_JavaLangString);
      paramArrayOfByte.append(" index:");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(", frameDataList:");
      paramArrayOfByte.append(this.jdField_a_of_type_JavaUtilMap.keySet());
      QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, paramArrayOfByte.toString());
    }
  }
  
  public final boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((FrameData)localObject1).b();
    } else {
      localObject1 = null;
    }
    long l1 = SystemClock.uptimeMillis();
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData;
        if ((localObject2 != null) && (this.b != null))
        {
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          int i = ((FrameData)localObject2).a();
          localObject2 = this.b;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          if (i != ((FrameData)localObject2).a())
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            ((FrameData)localObject2).a();
            localObject2 = this.jdField_a_of_type_JavaUtilMap;
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            ((Map)localObject2).remove(Integer.valueOf(((FrameData)localObject3).a()));
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(this);
              ((StringBuilder)localObject3).append(" remove frame for ");
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject3).append(" index:");
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData;
              if (localObject2 != null) {
                localObject2 = Integer.valueOf(((FrameData)localObject2).a());
              } else {
                localObject2 = null;
              }
              ((StringBuilder)localObject3).append(localObject2);
              ((StringBuilder)localObject3).append(", frameDataList:");
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaUtilMap.keySet());
              QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData = this.b;
      this.b = ((FrameData)null);
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      if ((this.jdField_a_of_type_Long > 0L) && (QLog.isColorLevel()))
      {
        paramCanvas = new StringBuilder();
        paramCanvas.append(this);
        paramCanvas.append(" draw new frame for ");
        paramCanvas.append(this.jdField_a_of_type_JavaLangString);
        paramCanvas.append(" interval ");
        paramCanvas.append(l1 - this.jdField_a_of_type_Long);
        paramCanvas.append("ms");
        QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, paramCanvas.toString());
      }
      this.jdField_a_of_type_Long = l1;
    }
    long l2 = this.jdField_a_of_type_Int;
    a(c(), l1 + l2);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloRepeatPngDrawable
 * JD-Core Version:    0.7.0.1
 */