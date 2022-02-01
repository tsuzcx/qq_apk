package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.apng.ApngDrawable;
import com.tencent.xaction.apng.ApngDrawable.ApngState;
import com.tencent.xaction.apng.GiftDiyDecorDrawable.GiftDiyDecorDrawableState;
import com.tencent.xaction.manager.InterpolatorManager;
import com.tencent.xaction.manager.InterpolatorManager.Companion;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/image/GiftDiyDrawable;", "Lcom/tencent/xaction/apng/ApngDrawable;", "Lcom/tencent/image/AnimationCallback;", "Lcom/tencent/xaction/api/IDrawable;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "allFrameIndex", "", "", "[Ljava/lang/Integer;", "alphaAnimDuration", "", "alphaAnimMaxDuration", "animStartTime", "apngBitmapCount", "cachedFrames", "Ljava/util/HashMap;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "defHeight", "defWidth", "elemInterval", "h", "interceptor", "Landroid/view/animation/Interpolator;", "interruptIndex", "lastDuration", "mCoordinates", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "stateNotify", "Lkotlin/Function3;", "", "w", "adjustElemInterval", "draw", "canvas", "Landroid/graphics/Canvas;", "drawApngFrame", "index", "drawRect", "Landroid/graphics/Rect;", "destRect", "paint", "Landroid/graphics/Paint;", "getAlphaAnimInput", "", "getAnimContinuedTime", "getCurrentFrameIndex", "getFrameIndex", "getResHeight", "getResWidth", "notifyAnimationEnd", "size", "alpha", "preStart", "state", "Lcom/tencent/xaction/apng/GiftDiyDecorDrawable$GiftDiyDecorDrawableState;", "list", "setInterceptor", "isFirstElement", "", "isValid", "nextFrameIndex", "toPx", "XAApng_release"}, k=1, mv={1, 1, 16})
public final class GiftDiyDrawable
  extends ApngDrawable
  implements AnimationCallback, IDrawable
{
  @NotNull
  private final String TAG = "GiftDiyDrawable";
  private Integer[] allFrameIndex = new Integer[0];
  private long alphaAnimDuration = 800L;
  private long alphaAnimMaxDuration = 4000L;
  private long animStartTime;
  private int apngBitmapCount;
  private HashMap<Integer, Bitmap> cachedFrames = new HashMap();
  private final int defHeight = 140;
  private final int defWidth = 140;
  private long elemInterval = 100L;
  private int h;
  private Interpolator interceptor = (Interpolator)new AccelerateDecelerateInterpolator();
  private int interruptIndex = -1;
  private long lastDuration = 1000L;
  private ArrayList<List<Integer>> mCoordinates = new ArrayList();
  private Function3<? super String, ? super String, ? super Long, Unit> stateNotify;
  private int w;
  
  private final void adjustElemInterval()
  {
    if (this.mCoordinates.size() < 2) {
      return;
    }
    long l = (this.alphaAnimMaxDuration - this.alphaAnimDuration) / (this.mCoordinates.size() - 1);
    if (this.elemInterval > l) {
      this.elemInterval = l;
    }
  }
  
  private final void drawApngFrame(int paramInt, Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint)
  {
    boolean bool = isFirstElement(paramInt);
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      localObject2 = getMApngState();
      if (localObject2 != null)
      {
        localObject2 = ((ApngDrawable.ApngState)localObject2).d();
        if (localObject2 != null) {
          ((ApngImage)localObject2).draw(paramCanvas, paramRect1, paramRect2, paramPaint, getMUseAnimation());
        }
      }
      if (this.cachedFrames.size() < this.apngBitmapCount)
      {
        paramCanvas = getMApngState();
        if (paramCanvas != null) {
          paramCanvas = paramCanvas.d();
        } else {
          paramCanvas = null;
        }
        if (paramCanvas == null) {
          Intrinsics.throwNpe();
        }
        paramInt = paramCanvas.mImageInfo[3];
        paramRect1 = getMApngState();
        paramCanvas = (Canvas)localObject1;
        if (paramRect1 != null)
        {
          paramRect1 = paramRect1.d();
          paramCanvas = (Canvas)localObject1;
          if (paramRect1 != null)
          {
            paramRect1 = paramRect1.getCurrentFrame();
            paramCanvas = (Canvas)localObject1;
            if (paramRect1 != null) {
              paramCanvas = paramRect1.copy(Bitmap.Config.ARGB_4444, true);
            }
          }
        }
        if (paramCanvas != null) {
          ((Map)this.cachedFrames).put(Integer.valueOf(paramInt), paramCanvas);
        }
      }
    }
    else
    {
      localObject1 = localObject2;
      if (paramPaint != null) {
        localObject1 = Integer.valueOf(paramPaint.getAlpha());
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((Integer)localObject1).intValue() > 0)
      {
        paramInt = getFrameIndex(paramInt);
        if ((paramInt >= 0) && (paramInt < this.cachedFrames.size()))
        {
          localObject1 = (Bitmap)this.cachedFrames.get(Integer.valueOf(paramInt));
          if (localObject1 != null) {
            paramCanvas.drawBitmap((Bitmap)localObject1, paramRect1, paramRect2, paramPaint);
          }
        }
      }
    }
  }
  
  private final float getAlphaAnimInput(int paramInt)
  {
    long l1 = getAnimContinuedTime();
    long l2 = this.elemInterval;
    long l3 = paramInt;
    if (l1 - l2 * l3 > this.alphaAnimDuration) {
      return 1.0F;
    }
    if (getAnimContinuedTime() - this.elemInterval * l3 >= 0L) {
      return (float)(getAnimContinuedTime() - this.elemInterval * l3) / (float)this.alphaAnimDuration;
    }
    return 0.0F;
  }
  
  private final long getAnimContinuedTime()
  {
    if (this.animStartTime == 0L)
    {
      this.animStartTime = System.currentTimeMillis();
      return 0L;
    }
    return System.currentTimeMillis() - this.animStartTime;
  }
  
  private final int getCurrentFrameIndex()
  {
    Object localObject = getMApngState();
    if (localObject != null) {
      localObject = ((ApngDrawable.ApngState)localObject).d();
    } else {
      localObject = null;
    }
    int i;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    try
    {
      Field localField = ApngImage.class.getDeclaredField("mImageInfo");
      Intrinsics.checkExpressionValueIsNotNull(localField, "desClass.getDeclaredField(fieldName)");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      if (localObject != null) {
        return ((int[])localObject)[3];
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.IntArray");
    }
    catch (Exception localException) {}
    throw ((Throwable)new IllegalArgumentException("parameter can not be null!".toString()));
    return 0;
  }
  
  private final int getFrameIndex(int paramInt)
  {
    if (nextFrameIndex(paramInt) >= this.apngBitmapCount)
    {
      this.allFrameIndex[paramInt] = Integer.valueOf(0);
    }
    else if (nextFrameIndex(paramInt) > this.cachedFrames.size() - 1)
    {
      this.interruptIndex = paramInt;
    }
    else
    {
      this.interruptIndex = -1;
      Integer[] arrayOfInteger = this.allFrameIndex;
      arrayOfInteger[paramInt] = Integer.valueOf(arrayOfInteger[paramInt].intValue() + 1);
    }
    return this.allFrameIndex[paramInt].intValue();
  }
  
  private final int getResHeight()
  {
    Object localObject = getMApngState();
    if (localObject != null)
    {
      localObject = ((ApngDrawable.ApngState)localObject).d();
      if (localObject != null) {
        return ((ApngImage)localObject).height;
      }
    }
    return this.defHeight;
  }
  
  private final int getResWidth()
  {
    Object localObject = getMApngState();
    if (localObject != null)
    {
      localObject = ((ApngDrawable.ApngState)localObject).d();
      if (localObject != null) {
        return ((ApngImage)localObject).width;
      }
    }
    return this.defWidth;
  }
  
  private final boolean isFirstElement(int paramInt)
  {
    return paramInt == 0;
  }
  
  private final boolean isValid(int paramInt)
  {
    return paramInt != 0;
  }
  
  private final int nextFrameIndex(int paramInt)
  {
    return this.allFrameIndex[paramInt].intValue() + 1;
  }
  
  private final void notifyAnimationEnd(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == paramInt1 - 1) && (paramInt3 > 254))
    {
      Function3 localFunction3 = this.stateNotify;
      if (localFunction3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("stateNotify");
      }
      localFunction3.invoke("gift_diy_drawable", "end", Long.valueOf(this.lastDuration));
    }
  }
  
  private final void setInterceptor(GiftDiyDecorDrawable.GiftDiyDecorDrawableState paramGiftDiyDecorDrawableState)
  {
    if (paramGiftDiyDecorDrawableState.getInpt() != null)
    {
      InterpolatorManager.Companion localCompanion = InterpolatorManager.a;
      paramGiftDiyDecorDrawableState = paramGiftDiyDecorDrawableState.getInpt();
      if (paramGiftDiyDecorDrawableState == null) {
        Intrinsics.throwNpe();
      }
      paramGiftDiyDecorDrawableState = localCompanion.a(paramGiftDiyDecorDrawableState);
      if (paramGiftDiyDecorDrawableState != null) {
        this.interceptor = paramGiftDiyDecorDrawableState;
      }
    }
  }
  
  private final int toPx(int paramInt)
  {
    return ScreenUnit.a.a(paramInt);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    int i;
    if (isValid(this.w)) {
      i = this.w;
    } else {
      i = getResWidth();
    }
    int j;
    if (isValid(this.h)) {
      j = this.h;
    } else {
      j = getResHeight();
    }
    Rect localRect1 = new Rect(0, 0, getResWidth(), getResHeight());
    Iterator localIterator = ((Iterable)this.mCoordinates).iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (k < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject = (List)localObject;
      int m = toPx(((Number)((List)localObject).get(0)).intValue()) - toPx(i) / 2;
      int n = toPx(((Number)((List)localObject).get(1)).intValue()) - toPx(j) / 2;
      Rect localRect2 = new Rect(m, n, toPx(i) + m, toPx(j) + n);
      localObject = getMApngState();
      if (localObject != null) {
        localObject = ((ApngDrawable.ApngState)localObject).c();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        ((Paint)localObject).setAlpha((int)(this.interceptor.getInterpolation(getAlphaAnimInput(k)) * 'ÿ'));
      }
      drawApngFrame(k, paramCanvas, localRect1, localRect2, (Paint)localObject);
      if (localObject != null)
      {
        m = ((Paint)localObject).getAlpha();
        notifyAnimationEnd(this.mCoordinates.size(), k, m);
      }
      k += 1;
    }
  }
  
  @NotNull
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void preStart(@NotNull GiftDiyDecorDrawable.GiftDiyDecorDrawableState paramGiftDiyDecorDrawableState, @NotNull ArrayList<List<Integer>> paramArrayList, @NotNull Function3<? super String, ? super String, ? super Long, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGiftDiyDecorDrawableState, "state");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "stateNotify");
    this.w = paramGiftDiyDecorDrawableState.getW();
    this.h = paramGiftDiyDecorDrawableState.getH();
    this.elemInterval = paramGiftDiyDecorDrawableState.getInterval();
    this.alphaAnimDuration = paramGiftDiyDecorDrawableState.getFadein();
    this.alphaAnimMaxDuration = paramGiftDiyDecorDrawableState.getMax();
    this.lastDuration = paramGiftDiyDecorDrawableState.getLast();
    this.mCoordinates = paramArrayList;
    int j = this.mCoordinates.size();
    paramArrayList = new Integer[j];
    int i = 0;
    while (i < j)
    {
      paramArrayList[i] = Integer.valueOf(0);
      i += 1;
    }
    this.allFrameIndex = paramArrayList;
    paramArrayList = getMApngState();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.d();
      if (paramArrayList != null)
      {
        paramArrayList = Integer.valueOf(paramArrayList.mFrameCount);
        break label156;
      }
    }
    paramArrayList = null;
    label156:
    if (paramArrayList == null) {
      Intrinsics.throwNpe();
    }
    this.apngBitmapCount = paramArrayList.intValue();
    this.stateNotify = paramFunction3;
    adjustElemInterval();
    setInterceptor(paramGiftDiyDecorDrawableState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.GiftDiyDrawable
 * JD-Core Version:    0.7.0.1
 */