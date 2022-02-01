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
    if (this.parentView == null) {
      return;
    }
    Object localObject = this.config.activityFloatAnimator;
    View localView = (View)this;
    ViewGroup localViewGroup = this.parentView;
    if (localViewGroup == null) {
      Intrinsics.throwNpe();
    }
    localObject = new FWActivityAnimatorManager((OnActivityFloatWindowAnimator)localObject, localView, localViewGroup, this.config.sidePattern).enterAnim();
    if (localObject != null) {
      ((Animator)localObject).addListener((Animator.AnimatorListener)new AbstractDragFloatingView.enterAnim.1(this));
    }
    if (localObject != null) {
      ((Animator)localObject).start();
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.leftDistance);
    localStringBuilder.append("   ");
    localStringBuilder.append(this.rightDistance);
    localStringBuilder.append("   ");
    localStringBuilder.append(this.topDistance);
    localStringBuilder.append("   ");
    localStringBuilder.append(this.bottomDistance);
    Logger.i(localStringBuilder.toString());
  }
  
  private final void initParent()
  {
    if ((getParent() != null) && ((getParent() instanceof ViewGroup)))
    {
      Object localObject = getParent();
      if (localObject != null)
      {
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parentRect: ");
        ((StringBuilder)localObject).append(this.parentRect);
        Logger.e("AbstractDragFloatingView", ((StringBuilder)localObject).toString());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
  }
  
  private final void sideAnim()
  {
    initDistanceValue();
    int i = this.config.sidePattern;
    float f1 = 0.0F;
    Object localObject = "translationX";
    int j;
    switch (i)
    {
    default: 
      f2 = 0.0F;
      break;
    case 15: 
      if (this.minX < this.minY)
      {
        f1 = getTranslationX();
        i = this.leftDistance;
        j = this.rightDistance;
        if (i < j) {
          f2 = -i;
        } else {
          f2 = j;
        }
        f3 = getTranslationX();
        break label339;
      }
      f1 = getTranslationY();
      i = this.topDistance;
      j = this.bottomDistance;
      if (i < j) {
        f2 = -i;
      } else {
        f2 = j;
      }
      f3 = getTranslationY();
      break;
    case 14: 
      f1 = getTranslationY();
      i = this.topDistance;
      j = this.bottomDistance;
      if (i < j) {
        f2 = -i;
      } else {
        f2 = j;
      }
      f3 = getTranslationY();
      break;
    case 13: 
      f1 = getTranslationX();
      i = this.leftDistance;
      j = this.rightDistance;
      if (i < j) {
        f2 = -i;
      } else {
        f2 = j;
      }
      f3 = getTranslationX();
      break;
    case 12: 
      f1 = getTranslationY();
      f2 = this.bottomDistance;
      f3 = getTranslationY();
      break;
    case 11: 
      f1 = getTranslationY();
      f2 = -this.topDistance;
      f3 = getTranslationY();
      f2 += f3;
      localObject = "translationY";
      break;
    case 10: 
      f1 = getTranslationX();
      f2 = this.rightDistance;
      f3 = getTranslationX();
      break;
    }
    f1 = getTranslationX();
    float f2 = -this.leftDistance;
    float f3 = getTranslationX();
    label339:
    f2 += f3;
    localObject = ObjectAnimator.ofFloat(this, (String)localObject, new float[] { f1, f2 });
    ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new AbstractDragFloatingView.sideAnim.1(this));
    ((ObjectAnimator)localObject).start();
  }
  
  private final void touchOver()
  {
    Object localObject = this.config;
    ((FloatWindowConfig)localObject).isAnim = false;
    ((FloatWindowConfig)localObject).isDrag = false;
    localObject = ((FloatWindowConfig)localObject).callbacks;
    if (localObject != null) {
      ((OnFloatWindowCallbacks)localObject).dragEnd((View)this);
    }
  }
  
  private final void updateView(MotionEvent paramMotionEvent)
  {
    OnFloatWindowCallbacks localOnFloatWindowCallbacks = this.config.callbacks;
    if (localOnFloatWindowCallbacks != null) {
      localOnFloatWindowCallbacks.touchEvent((View)this, paramMotionEvent);
    }
    if ((this.config.dragEnable) && (!this.config.isAnim))
    {
      float f5 = this.config.horizontalMargin;
      float f6 = this.config.verticalMargin;
      int j = (int)paramMotionEvent.getRawX();
      int k = (int)paramMotionEvent.getRawY();
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          if (this.parentHeight > 0)
          {
            if (this.parentWidth <= 0) {
              return;
            }
            i = j - this.lastX;
            int m = k - this.lastY;
            if ((!this.config.isDrag) && (i * i + m * m < 81)) {
              return;
            }
            this.config.isDrag = true;
            float f1 = getX();
            float f2 = i + f1;
            float f3 = getY() + m;
            if (f2 < f5)
            {
              f1 = f5;
            }
            else
            {
              f1 = f2;
              if (f2 > this.parentWidth - getWidth() - f5) {
                f1 = this.parentWidth - getWidth() - f5;
              }
            }
            if (f3 < f6)
            {
              f2 = f6;
            }
            else
            {
              f2 = f3;
              if (f3 > this.parentHeight - getHeight() - f6) {
                f2 = this.parentHeight - getHeight() - f6;
              }
            }
            f3 = f6;
            float f4 = f5;
            switch (this.config.sidePattern)
            {
            case 6: 
            default: 
              break;
            case 8: 
              this.leftDistance = (j - this.parentRect.left);
              this.rightDistance = (this.parentRect.right - j);
              this.topDistance = (k - this.parentRect.top);
              this.bottomDistance = (this.parentRect.bottom - k);
              this.minX = Math.min(this.leftDistance, this.rightDistance);
              this.minY = Math.min(this.topDistance, this.bottomDistance);
              i = this.minX;
              m = this.minY;
              if (i < m)
              {
                if (this.leftDistance == i)
                {
                  f4 = f5;
                  break label675;
                }
                f1 = this.parentWidth;
                i = getWidth();
              }
              else if (this.topDistance == m)
              {
                f3 = f6;
              }
              else
              {
                f2 = this.parentHeight;
                i = getHeight();
              }
              break;
            case 7: 
              f3 = f6;
              if (k - this.parentRect.top > this.parentRect.bottom - k)
              {
                f2 = this.parentRect.bottom;
                i = getHeight();
              }
              break;
            case 5: 
              f4 = f5;
              if (j * 2 - this.parentRect.left > this.parentRect.right)
              {
                f1 = this.parentRect.right;
                i = getWidth();
              }
              break;
            case 4: 
              f2 = this.parentRect.bottom;
              i = getHeight();
              f3 = f2 - i - f6;
            case 3: 
              f2 = f3;
              break;
            case 2: 
              f1 = this.parentRect.right;
              i = getWidth();
              f4 = f1 - i - f5;
            }
            label675:
            f1 = f4;
            setX(f1);
            setY(f2);
            this.lastX = j;
            this.lastY = k;
            localOnFloatWindowCallbacks = this.config.callbacks;
            if (localOnFloatWindowCallbacks == null) {
              break label851;
            }
            localOnFloatWindowCallbacks.drag((View)this, paramMotionEvent);
          }
        }
        else
        {
          setPressed(this.config.isDrag ^ true);
          switch (this.config.sidePattern)
          {
          default: 
            if (!this.config.isDrag) {
              break;
            }
            touchOver();
            return;
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
            sideAnim();
            return;
          }
        }
      }
      else
      {
        this.config.isDrag = false;
        setPressed(true);
        this.lastX = j;
        this.lastY = k;
        getParent().requestDisallowInterceptTouchEvent(true);
        initParent();
      }
      label851:
      return;
    }
    this.config.isDrag = false;
    setPressed(true);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    HashMap localHashMap = this._$_findViewCache;
    if (localHashMap != null) {
      localHashMap.clear();
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
    if (!this.config.isAnim)
    {
      if (this.parentView == null) {
        return;
      }
      Object localObject = this.config.activityFloatAnimator;
      View localView = (View)this;
      ViewGroup localViewGroup = this.parentView;
      if (localViewGroup == null) {
        Intrinsics.throwNpe();
      }
      localObject = new FWActivityAnimatorManager((OnActivityFloatWindowAnimator)localObject, localView, localViewGroup, this.config.sidePattern).exitAnim();
      if (localObject == null)
      {
        localObject = this.parentView;
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(localView);
        }
      }
      else
      {
        ((Animator)localObject).addListener((Animator.AnimatorListener)new AbstractDragFloatingView.exitAnim.1(this));
        ((Animator)localObject).start();
      }
    }
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
    if ((localInteger == null) || (localInteger.intValue() != -1))
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
    }
  }
  
  protected void onDetachedFromWindow()
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
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.isCreated)
    {
      this.isCreated = true;
      if ((true ^ Intrinsics.areEqual(this.config.locationPair, new Point(0, 0))))
      {
        setX(this.config.locationPair.x);
        setY(this.config.locationPair.y);
      }
      else
      {
        setX(getX() + this.config.offsetPair.x);
        setY(getY() + this.config.offsetPair.y);
      }
      initParent();
      initDistanceValue();
      enterAnim();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.activityfloat.AbstractDragFloatingView
 * JD-Core Version:    0.7.0.1
 */