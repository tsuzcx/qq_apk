package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowTouchListener;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/widget/appfloat/ParentFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "config", "Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;Landroid/util/AttributeSet;I)V", "isCreated", "", "layoutListener", "Lcom/tencent/falco/base/floatwindow/widget/appfloat/ParentFrameLayout$OnLayoutListener;", "getLayoutListener", "()Lcom/tencent/falco/base/floatwindow/widget/appfloat/ParentFrameLayout$OnLayoutListener;", "setLayoutListener", "(Lcom/tencent/falco/base/floatwindow/widget/appfloat/ParentFrameLayout$OnLayoutListener;)V", "touchListener", "Lcom/tencent/falco/base/floatwindow/interfaces/OnFloatWindowTouchListener;", "getTouchListener", "()Lcom/tencent/falco/base/floatwindow/interfaces/OnFloatWindowTouchListener;", "setTouchListener", "(Lcom/tencent/falco/base/floatwindow/interfaces/OnFloatWindowTouchListener;)V", "onDetachedFromWindow", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onTouchEvent", "OnLayoutListener", "floatwindow_release"}, k=1, mv={1, 1, 15})
@SuppressLint({"ViewConstructor"})
public final class ParentFrameLayout
  extends FrameLayout
{
  private HashMap _$_findViewCache;
  private final FloatWindowConfig config;
  private boolean isCreated;
  @Nullable
  private ParentFrameLayout.OnLayoutListener layoutListener;
  @Nullable
  private OnFloatWindowTouchListener touchListener;
  
  public ParentFrameLayout(@NotNull Context paramContext, @NotNull FloatWindowConfig paramFloatWindowConfig, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.config = paramFloatWindowConfig;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @Nullable
  public final ParentFrameLayout.OnLayoutListener getLayoutListener()
  {
    return this.layoutListener;
  }
  
  @Nullable
  public final OnFloatWindowTouchListener getTouchListener()
  {
    return this.touchListener;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    OnFloatWindowCallbacks localOnFloatWindowCallbacks = this.config.callbacks;
    if (localOnFloatWindowCallbacks != null) {
      localOnFloatWindowCallbacks.dismiss();
    }
  }
  
  public boolean onInterceptTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      OnFloatWindowTouchListener localOnFloatWindowTouchListener = this.touchListener;
      if (localOnFloatWindowTouchListener != null) {
        localOnFloatWindowTouchListener.onFloatWindowTouch(paramMotionEvent);
      }
    }
    return (this.config.isDrag) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.isCreated)
    {
      this.isCreated = true;
      ParentFrameLayout.OnLayoutListener localOnLayoutListener = this.layoutListener;
      if (localOnLayoutListener != null) {
        localOnLayoutListener.onLayout();
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      OnFloatWindowTouchListener localOnFloatWindowTouchListener = this.touchListener;
      if (localOnFloatWindowTouchListener != null) {
        localOnFloatWindowTouchListener.onFloatWindowTouch(paramMotionEvent);
      }
    }
    return (this.config.isDrag) || (super.onTouchEvent(paramMotionEvent));
  }
  
  public final void setLayoutListener(@Nullable ParentFrameLayout.OnLayoutListener paramOnLayoutListener)
  {
    this.layoutListener = paramOnLayoutListener;
  }
  
  public final void setTouchListener(@Nullable OnFloatWindowTouchListener paramOnFloatWindowTouchListener)
  {
    this.touchListener = paramOnFloatWindowTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.ParentFrameLayout
 * JD-Core Version:    0.7.0.1
 */