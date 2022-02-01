package com.tencent.android.gldrawable.api.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.GLDrawableApi.State;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.ILoaderSucessCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/base/AsyncDrawable;", "Lcom/tencent/android/gldrawable/api/base/ScaleTypeDrawable;", "()V", "callbackProxy", "com/tencent/android/gldrawable/api/base/AsyncDrawable$callbackProxy$1", "Lcom/tencent/android/gldrawable/api/base/AsyncDrawable$callbackProxy$1;", "value", "Landroid/graphics/drawable/Drawable;", "currentDrawable", "getCurrentDrawable", "()Landroid/graphics/drawable/Drawable;", "setCurrentDrawable", "(Landroid/graphics/drawable/Drawable;)V", "doFailedDrawableBuild", "Lkotlin/Function0;", "doTargetDrawableBuild", "failedDrawableBuild", "getFailedDrawableBuild", "()Lkotlin/jvm/functions/Function0;", "setFailedDrawableBuild", "(Lkotlin/jvm/functions/Function0;)V", "isRecycle", "", "loaderUtils", "Lcom/tencent/android/gldrawable/api/ILoadUtils;", "targetDrawableBuild", "getTargetDrawableBuild", "setTargetDrawableBuild", "tmpalpha", "", "applyToBaseDrawable", "", "child", "applyToDrawable", "build", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getPadding", "padding", "Landroid/graphics/Rect;", "getResID", "", "isRecyclyed", "loadAndRefresh", "onBoundsChange", "bounds", "onDraw", "canvas", "Landroid/graphics/Canvas;", "left", "top", "right", "bottom", "onTouch", "x", "", "y", "recycle", "setAlpha", "alpha", "setBounds", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setVisible", "visible", "restart", "updateDrawableState", "MyAsyncLoaderCallback", "api_release"}, k=1, mv={1, 1, 16})
public final class AsyncDrawable
  extends ScaleTypeDrawable
{
  private final AsyncDrawable.callbackProxy.1 callbackProxy = new AsyncDrawable.callbackProxy.1(this);
  @Nullable
  private Drawable currentDrawable;
  private final Function0<Drawable> doFailedDrawableBuild = (Function0)new AsyncDrawable.doFailedDrawableBuild.1(this);
  private final Function0<Drawable> doTargetDrawableBuild = (Function0)new AsyncDrawable.doTargetDrawableBuild.1(this);
  @Nullable
  private Function0<? extends Drawable> failedDrawableBuild;
  private boolean isRecycle;
  private final ILoadUtils loaderUtils = GLDrawableApi.INSTANCE.getLoader().getLoaderUtils();
  @NotNull
  private Function0<? extends Drawable> targetDrawableBuild = (Function0)AsyncDrawable.targetDrawableBuild.1.INSTANCE;
  private int tmpalpha = 255;
  
  private final void applyToBaseDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof IGLDrawable))
    {
      if (this.isRecycle) {
        ((IGLDrawable)paramDrawable).recycle();
      }
      if ((paramDrawable instanceof Animatable)) {
        ((Animatable)paramDrawable).start();
      }
    }
  }
  
  private final void applyToDrawable(Drawable paramDrawable)
  {
    paramDrawable.setCallback((Drawable.Callback)this.callbackProxy);
    paramDrawable.setAlpha(this.tmpalpha);
    paramDrawable.setBounds(getBounds());
    paramDrawable.setVisible(isVisible(), false);
  }
  
  private final void loadAndRefresh()
  {
    AsyncDrawable.MyAsyncLoaderCallback localMyAsyncLoaderCallback = new AsyncDrawable.MyAsyncLoaderCallback(new WeakReference(this));
    if (GLDrawableApi.INSTANCE.getState().isStaticModel())
    {
      localMyAsyncLoaderCallback.onLoadSucceed();
      return;
    }
    if (GLDrawableApi.INSTANCE.getState().isDynamicReady())
    {
      localMyAsyncLoaderCallback.onLoadSucceed();
      return;
    }
    GLDrawableApi.INSTANCE.registerLoadSucessCallback$api_release((ILoaderSucessCallback)localMyAsyncLoaderCallback);
    GLDrawableApi.INSTANCE.loadDynamicSync$api_release();
  }
  
  private final void setCurrentDrawable(Drawable paramDrawable)
  {
    if ((Intrinsics.areEqual(paramDrawable, this.currentDrawable) ^ true))
    {
      this.currentDrawable = paramDrawable;
      updateDrawableState();
    }
  }
  
  private final void updateDrawableState()
  {
    this.loaderUtils.postUITask((Function0)new AsyncDrawable.updateDrawableState.1(this));
  }
  
  public final void build()
  {
    if ((!GLDrawableApi.INSTANCE.getState().isStaticModel()) && (!GLDrawableApi.INSTANCE.getState().isDynamicReady()))
    {
      Drawable localDrawable = (Drawable)this.doFailedDrawableBuild.invoke();
      if (localDrawable != null) {
        setCurrentDrawable(localDrawable);
      }
    }
    loadAndRefresh();
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      return localDrawable.getConstantState();
    }
    return null;
  }
  
  @Nullable
  public final Drawable getCurrentDrawable()
  {
    return this.currentDrawable;
  }
  
  @Nullable
  public final Function0<Drawable> getFailedDrawableBuild()
  {
    return this.failedDrawableBuild;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return -3;
  }
  
  public boolean getPadding(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "padding");
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      return localDrawable.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  @NotNull
  public String getResID()
  {
    Drawable localDrawable = this.currentDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof IGLDrawable))) {
      return ((IGLDrawable)localDrawable).getResID();
    }
    return "";
  }
  
  @NotNull
  public final Function0<Drawable> getTargetDrawableBuild()
  {
    return this.targetDrawableBuild;
  }
  
  public boolean isRecyclyed()
  {
    throw ((Throwable)new RuntimeException("can not call isRecyclyed()"));
  }
  
  protected void onBoundsChange(@Nullable Rect paramRect)
  {
    if (paramRect != null)
    {
      Drawable localDrawable = this.currentDrawable;
      if (localDrawable != null) {
        localDrawable.setBounds(paramRect);
      }
    }
    super.onBoundsChange(paramRect);
  }
  
  public void onDraw(@NotNull Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      localDrawable.draw(paramCanvas);
    }
  }
  
  public void onTouch(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = this.currentDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof IGLDrawable))) {
      ((IGLDrawable)localDrawable).onTouch(paramFloat1, paramFloat2);
    }
  }
  
  public void recycle()
  {
    Drawable localDrawable = this.currentDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof IGLDrawable))) {
      ((IGLDrawable)localDrawable).recycle();
    }
    this.isRecycle = true;
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
    this.tmpalpha = paramInt;
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
  }
  
  public final void setFailedDrawableBuild(@Nullable Function0<? extends Drawable> paramFunction0)
  {
    this.failedDrawableBuild = paramFunction0;
  }
  
  public final void setTargetDrawableBuild(@NotNull Function0<? extends Drawable> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.targetDrawableBuild = paramFunction0;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.currentDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AsyncDrawable
 * JD-Core Version:    0.7.0.1
 */