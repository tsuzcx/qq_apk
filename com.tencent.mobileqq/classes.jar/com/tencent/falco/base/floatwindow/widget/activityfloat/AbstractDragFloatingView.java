package com.tencent.falco.base.floatwindow.widget.activityfloat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.falco.base.floatwindow.animmanager.FWActivityAnimatorManager;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnActivityFloatWindowAnimator;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.falco.base.floatwindow.interfaces.OnInvokeView;
import com.tencent.falco.base.floatwindow.utils.Logger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/widget/activityfloat/AbstractDragFloatingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomDistance", "config", "Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "getConfig", "()Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "setConfig", "(Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;)V", "floatRect", "Landroid/graphics/Rect;", "isCreated", "", "lastX", "lastY", "leftDistance", "minX", "minY", "parentHeight", "parentRect", "parentView", "Landroid/view/ViewGroup;", "parentWidth", "rightDistance", "topDistance", "enterAnim", "", "exitAnim", "exitAnim$floatwindow_release", "getLayoutId", "()Ljava/lang/Integer;", "initDistanceValue", "initParent", "initView", "onDetachedFromWindow", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onLayout", "changed", "l", "t", "r", "b", "onTouchEvent", "renderView", "view", "Landroid/view/View;", "sideAnim", "touchOver", "updateView", "Companion", "floatwindow_release"}, k=1, mv={1, 1, 15})
public abstract class AbstractDragFloatingView
  extends FrameLayout
{
  public static final AbstractDragFloatingView.Companion Companion = new AbstractDragFloatingView.Companion(null);
  private static final String TAG = "AbstractDragFloatingView";
  private static final String TRANSLATION_X = "translationX";
  private static final String TRANSLATION_Y = "translationY";
  private HashMap _$_findViewCache;
  private int bottomDistance;
  @NotNull
  private FloatWindowConfig config;
  private Rect floatRect = new Rect();
  private boolean isCreated;
  private int lastX;
  private int lastY;
  private int leftDistance;
  private int minX;
  private int minY;
  private int parentHeight;
  private Rect parentRect = new Rect();
  private ViewGroup parentView;
  private int parentWidth;
  private int rightDistance;
  private int topDistance;
  
  public AbstractDragFloatingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    new FrameLayout(paramContext, paramAttributeSet, paramInt);
    this.config = new FloatWindowConfig();
    initView(paramContext);
    setOnClickListener((View.OnClickListener)AbstractDragFloatingView.1.INSTANCE);
  }
  
  private final void enterAnim()
  {
    if (this.parentView == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.config.activityFloatAnimator;
      View localView = (View)this;
      ViewGroup localViewGroup = this.parentView;
      if (localViewGroup == null) {
        Intrinsics.throwNpe();
      }
      localObject = new FWActivityAnimatorManager((OnActivityFloatWindowAnimator)localObject, localView, localViewGroup, this.config.sidePattern).enterAnim();
      if (localObject != null) {
        ((Animator)localObject).addListener((Animator.AnimatorListener)new AbstractDragFloatingView.enterAnim.1(this));
      }
    } while (localObject == null);
    ((Animator)localObject).start();
  }
  
  private final void initDistanceValue()
  {
    getGlobalVisibleRect(this.floatRect);
    this.leftDistance = (this.floatRect.left - this.parentRect.left);
    this.rightDistance = (this.parentRect.right - this.floatRect.right);
    this.topDistance = (this.floatRect.top - this.parentRect.top);
    this.bottomDistance = (this.parentRect.bottom - this.floatRect.bottom);
    this.minX = Math.min(this.leftDistance, this.rightDistance);
    this.minY = Math.min(this.topDistance, this.bottomDistance);
    Logger.i(this.leftDistance + "   " + this.rightDistance + "   " + this.topDistance + "   " + this.bottomDistance);
  }
  
  private final void initParent()
  {
    if ((getParent() != null) && ((getParent() instanceof ViewGroup)))
    {
      Object localObject = getParent();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      this.parentView = ((ViewGroup)localObject);
      localObject = this.parentView;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.parentHeight = ((ViewGroup)localObject).getHeight();
      localObject = this.parentView;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.parentWidth = ((ViewGroup)localObject).getWidth();
      localObject = this.parentView;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((ViewGroup)localObject).getGlobalVisibleRect(this.parentRect);
      Logger.e("AbstractDragFloatingView", "parentRect: " + this.parentRect);
    }
  }
  
  private final void sideAnim()
  {
    float f1 = 0.0F;
    initDistanceValue();
    Object localObject;
    float f2;
    switch (this.config.sidePattern)
    {
    default: 
      localObject = "translationX";
      f2 = 0.0F;
    }
    for (;;)
    {
      localObject = ObjectAnimator.ofFloat(this, (String)localObject, new float[] { f2, f1 });
      ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new AbstractDragFloatingView.sideAnim.1(this));
      ((ObjectAnimator)localObject).start();
      return;
      localObject = "translationX";
      f2 = getTranslationX();
      f1 = -this.leftDistance + getTranslationX();
      continue;
      localObject = "translationX";
      f2 = getTranslationX();
      f1 = this.rightDistance + getTranslationX();
      continue;
      localObject = "translationX";
      f2 = getTranslationX();
      if (this.leftDistance < this.rightDistance)
      {
        f1 = -this.leftDistance + getTranslationX();
      }
      else
      {
        f1 = this.rightDistance + getTranslationX();
        continue;
        localObject = "translationY";
        f2 = getTranslationY();
        f1 = -this.topDistance + getTranslationY();
        continue;
        localObject = "translationY";
        f2 = getTranslationY();
        f1 = this.bottomDistance + getTranslationY();
        continue;
        localObject = "translationY";
        f2 = getTranslationY();
        if (this.topDistance < this.bottomDistance)
        {
          f1 = -this.topDistance + getTranslationY();
        }
        else
        {
          f1 = this.bottomDistance + getTranslationY();
          continue;
          if (this.minX < this.minY)
          {
            localObject = "translationX";
            f2 = getTranslationX();
            if (this.leftDistance < this.rightDistance) {
              f1 = -this.leftDistance + getTranslationX();
            } else {
              f1 = this.rightDistance + getTranslationX();
            }
          }
          else
          {
            localObject = "translationY";
            f2 = getTranslationY();
            if (this.topDistance < this.bottomDistance) {
              f1 = -this.topDistance + getTranslationY();
            } else {
              f1 = this.bottomDistance + getTranslationY();
            }
          }
        }
      }
    }
  }
  
  private final void touchOver()
  {
    this.config.isAnim = false;
    this.config.isDrag = false;
    OnFloatWindowCallbacks localOnFloatWindowCallbacks = this.config.callbacks;
    if (localOnFloatWindowCallbacks != null) {
      localOnFloatWindowCallbacks.dragEnd((View)this);
    }
  }
  
  private final void updateView(MotionEvent paramMotionEvent)
  {
    OnFloatWindowCallbacks localOnFloatWindowCallbacks = this.config.callbacks;
    if (localOnFloatWindowCallbacks != null) {
      localOnFloatWindowCallbacks.touchEvent((View)this, paramMotionEvent);
    }
    if ((!this.config.dragEnable) || (this.config.isAnim))
    {
      this.config.isDrag = false;
      setPressed(true);
    }
    label59:
    float f6;
    float f5;
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        return;
        f6 = this.config.horizontalMargin;
        f5 = this.config.verticalMargin;
        i = (int)paramMotionEvent.getRawX();
        j = (int)paramMotionEvent.getRawY();
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        default: 
          return;
        case 0: 
          this.config.isDrag = false;
          setPressed(true);
          this.lastX = i;
          this.lastY = j;
          getParent().requestDisallowInterceptTouchEvent(true);
          initParent();
          return;
        }
      } while ((this.parentHeight <= 0) || (this.parentWidth <= 0));
      k = i - this.lastX;
      m = j - this.lastY;
    } while ((!this.config.isDrag) && (k * k + m * m < 81));
    this.config.isDrag = true;
    float f3 = getX() + k;
    float f1 = getY() + m;
    float f2;
    label265:
    float f4;
    if (f3 < f6)
    {
      f2 = f6;
      if (f1 >= f5) {
        break label432;
      }
      f4 = f5;
      label276:
      f3 = f4;
      f1 = f6;
      switch (this.config.sidePattern)
      {
      case 6: 
      default: 
        f1 = f2;
        f3 = f4;
      }
    }
    for (;;)
    {
      setX(f1);
      setY(f3);
      this.lastX = i;
      this.lastY = j;
      localOnFloatWindowCallbacks = this.config.callbacks;
      if (localOnFloatWindowCallbacks == null) {
        break;
      }
      localOnFloatWindowCallbacks.drag((View)this, paramMotionEvent);
      return;
      f2 = f3;
      if (f3 <= this.parentWidth - getWidth() - f6) {
        break label265;
      }
      f2 = this.parentWidth - getWidth() - f6;
      break label265;
      label432:
      f4 = f1;
      if (f1 <= this.parentHeight - getHeight() - f5) {
        break label276;
      }
      f4 = this.parentHeight - getHeight() - f5;
      break label276;
      f1 = this.parentRect.right - getWidth() - f6;
      f3 = f4;
      continue;
      f3 = f5;
      f1 = f2;
      continue;
      f3 = this.parentRect.bottom - getHeight() - f5;
      f1 = f2;
      continue;
      if (i * 2 - this.parentRect.left > this.parentRect.right) {}
      for (f1 = this.parentRect.right - getWidth() - f6;; f1 = f6)
      {
        f3 = f4;
        break;
      }
      f1 = f5;
      if (j - this.parentRect.top > this.parentRect.bottom - j) {
        f1 = this.parentRect.bottom - getHeight() - f5;
      }
      f3 = f1;
      f1 = f2;
      continue;
      this.leftDistance = (i - this.parentRect.left);
      this.rightDistance = (this.parentRect.right - i);
      this.topDistance = (j - this.parentRect.top);
      this.bottomDistance = (this.parentRect.bottom - j);
      this.minX = Math.min(this.leftDistance, this.rightDistance);
      this.minY = Math.min(this.topDistance, this.bottomDistance);
      if (this.minX >= this.minY) {
        break label772;
      }
      f3 = f4;
      f1 = f6;
      if (this.leftDistance != this.minX)
      {
        f1 = this.parentWidth - getWidth() - f6;
        f3 = f4;
      }
    }
    label772:
    if (this.topDistance == this.minY) {}
    for (;;)
    {
      f3 = f5;
      f1 = f2;
      break;
      f5 = this.parentHeight - getHeight() - f5;
    }
    if (!this.config.isDrag) {}
    for (boolean bool = true;; bool = false)
    {
      setPressed(bool);
      switch (this.config.sidePattern)
      {
      default: 
        if (!this.config.isDrag) {
          break label59;
        }
        touchOver();
        return;
      }
    }
    sideAnim();
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
  
  public final void exitAnim$floatwindow_release()
  {
    if ((this.config.isAnim) || (this.parentView == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = this.config.activityFloatAnimator;
      View localView = (View)this;
      ViewGroup localViewGroup = this.parentView;
      if (localViewGroup == null) {
        Intrinsics.throwNpe();
      }
      localObject = new FWActivityAnimatorManager((OnActivityFloatWindowAnimator)localObject, localView, localViewGroup, this.config.sidePattern).exitAnim();
      if (localObject != null) {
        break;
      }
      localObject = this.parentView;
    } while (localObject == null);
    ((ViewGroup)localObject).removeView((View)this);
    return;
    ((Animator)localObject).addListener((Animator.AnimatorListener)new AbstractDragFloatingView.exitAnim.1(this));
    ((Animator)localObject).start();
  }
  
  @NotNull
  public final FloatWindowConfig getConfig()
  {
    return this.config;
  }
  
  @Nullable
  public abstract Integer getLayoutId();
  
  protected final void initView(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Integer localInteger = getLayoutId();
    if (localInteger == null) {}
    for (;;)
    {
      paramContext = LayoutInflater.from(paramContext);
      localInteger = getLayoutId();
      if (localInteger == null) {
        Intrinsics.throwNpe();
      }
      paramContext = paramContext.inflate(localInteger.intValue(), (ViewGroup)this);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…te(getLayoutId()!!, this)");
      renderView(paramContext);
      paramContext = this.config.invokeView;
      if (paramContext != null) {
        paramContext.invoke((View)this);
      }
      do
      {
        return;
      } while (localInteger.intValue() == -1);
    }
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
    if (paramMotionEvent != null) {
      updateView(paramMotionEvent);
    }
    return (this.config.isDrag) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.isCreated)
    {
      this.isCreated = true;
      if (!(Intrinsics.areEqual(this.config.locationPair, new Point(0, 0)) ^ true)) {
        break label90;
      }
      setX(this.config.locationPair.x);
      setY(this.config.locationPair.y);
    }
    for (;;)
    {
      initParent();
      initDistanceValue();
      enterAnim();
      return;
      label90:
      setX(getX() + this.config.offsetPair.x);
      setY(getY() + this.config.offsetPair.y);
    }
  }
  
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      updateView(paramMotionEvent);
    }
    return (this.config.isDrag) || (super.onTouchEvent(paramMotionEvent));
  }
  
  public abstract void renderView(@NotNull View paramView);
  
  public final void setConfig(@NotNull FloatWindowConfig paramFloatWindowConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatWindowConfig, "<set-?>");
    this.config = paramFloatWindowConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.activityfloat.AbstractDragFloatingView
 * JD-Core Version:    0.7.0.1
 */