package com.tencent.mobileqq.apollo.api.player.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/player/impl/ApolloRepeatPngDrawable;", "Landroid/graphics/drawable/Drawable;", "key", "", "frameTime", "", "(Ljava/lang/String;I)V", "currentFrame", "Lcom/tencent/mobileqq/apollo/api/player/impl/FrameData;", "frameDataMap", "", "getKey", "()Ljava/lang/String;", "lastFrameDrawTime", "", "lowMemoryMode", "", "mainHandler", "Landroid/os/Handler;", "nextFrame", "addFrame", "", "index", "pixels", "", "width", "height", "currentPlayIndex", "decodeNextFrame", "nextIndex", "nextFrameTime", "draw", "canvas", "Landroid/graphics/Canvas;", "getNextIndex", "getOpacity", "isFrameExistByIndex", "recycle", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "totalFrameCount", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloRepeatPngDrawable
  extends Drawable
{
  public static final ApolloRepeatPngDrawable.Companion a;
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private FrameData jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final Map<Integer, FrameData> jdField_a_of_type_JavaUtilMap;
  private final boolean jdField_a_of_type_Boolean;
  private FrameData b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplApolloRepeatPngDrawable$Companion = new ApolloRepeatPngDrawable.Companion(null);
  }
  
  public ApolloRepeatPngDrawable(@NotNull String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = CmShowWnsUtils.p();
  }
  
  private final void a(int paramInt, long paramLong)
  {
    ThreadManager.excute((Runnable)new ApolloRepeatPngDrawable.decodeNextFrame.1(this, paramInt, paramLong), 16, null, false);
  }
  
  private final int c()
  {
    FrameData localFrameData;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData != null)
    {
      localFrameData = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData;
      if (localFrameData == null) {
        Intrinsics.throwNpe();
      }
    }
    int j;
    for (int i = localFrameData.a();; i = -1)
    {
      j = i + 1;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(j))) {
        return j;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      return i;
    }
    return 0;
    return j;
  }
  
  public final int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData != null)
    {
      FrameData localFrameData = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData;
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData;
    if (localObject != null) {
      ((FrameData)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData = ((FrameData)null);
    localObject = this.b;
    if (localObject != null) {
      ((FrameData)localObject).a();
    }
    this.b = ((FrameData)null);
    QLog.i("ApolloRepeatPngDrawable", 1, this + ' ' + this.jdField_a_of_type_JavaLangString + " recycle.");
  }
  
  public final void a(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1))) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), new FrameData(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4));
    } while (!QLog.isColorLevel());
    QLog.i("ApolloRepeatPngDrawable", 2, this + " add frame for " + this.jdField_a_of_type_JavaLangString + " index:" + paramInt1 + ", frameDataList:" + this.jdField_a_of_type_JavaUtilMap.keySet());
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
    long l1;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((FrameData)localObject1).b();
      l1 = SystemClock.uptimeMillis();
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData != null) && (this.b != null))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData;
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
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            ((FrameData)localObject2).a();
            localObject2 = this.jdField_a_of_type_JavaUtilMap;
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            ((Map)localObject2).remove(Integer.valueOf(((FrameData)localObject3).a()));
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder().append(this).append(" remove frame for ").append(this.jdField_a_of_type_JavaLangString).append(" index:");
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData;
              if (localObject2 == null) {
                break label376;
              }
            }
          }
        }
      }
    }
    label376:
    for (Object localObject2 = Integer.valueOf(((FrameData)localObject2).a());; localObject2 = null)
    {
      QLog.i("ApolloRepeatPngDrawable", 2, localObject2 + ", frameDataList:" + this.jdField_a_of_type_JavaUtilMap.keySet());
      this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData = this.b;
      this.b = ((FrameData)null);
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      if ((this.jdField_a_of_type_Long > 0L) && (QLog.isColorLevel())) {
        QLog.i("ApolloRepeatPngDrawable", 2, this + " draw new frame for " + this.jdField_a_of_type_JavaLangString + " interval " + (l1 - this.jdField_a_of_type_Long) + "ms");
      }
      this.jdField_a_of_type_Long = l1;
      long l2 = this.jdField_a_of_type_Int;
      a(c(), l2 + l1);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloRepeatPngDrawable
 * JD-Core Version:    0.7.0.1
 */