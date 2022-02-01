package com.tencent.common.danmaku.edit.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.common.danmaku.R.styleable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/views/PressImageButton;", "Landroid/widget/ImageButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "enablePressEffect", "", "mIsDarkBg", "mIsScale", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"AppCompatCustomView"})
public class PressImageButton
  extends ImageButton
{
  private boolean a;
  private boolean b;
  private boolean c = true;
  
  public PressImageButton(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.i);
      this.a = paramContext.getBoolean(R.styleable.j, false);
      this.b = paramContext.getBoolean(R.styleable.k, false);
      paramContext.recycle();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (isEnabled()) && (this.c)) {
        PressView.a.b((View)this, this.a, this.b);
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    if ((isEnabled()) && (this.c))
    {
      PressView.a.a((View)this, this.a, this.b);
      super.onTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "changedView");
    clearAnimation();
    super.onVisibilityChanged(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.views.PressImageButton
 * JD-Core Version:    0.7.0.1
 */