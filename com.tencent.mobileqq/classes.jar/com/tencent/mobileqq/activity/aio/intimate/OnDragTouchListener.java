package com.tencent.mobileqq.activity.aio.intimate;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.RelativeLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/intimate/OnDragTouchListener;", "Landroid/view/View$OnTouchListener;", "dragTopMargin", "", "(I)V", "CLICK_MIN_DISTANCE", "bottom", "distanceX", "", "distanceY", "fromX", "fromY", "left", "maxHeight", "maxWidth", "right", "top", "viewHeight", "viewWidth", "dip2px", "resources", "Landroid/content/res/Resources;", "dpValue", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class OnDragTouchListener
  implements View.OnTouchListener
{
  private final int a;
  private int b;
  private int c;
  private float d;
  private float e;
  private float f;
  private float g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private final int n;
  
  public OnDragTouchListener(int paramInt)
  {
    this.n = paramInt;
    this.a = 2;
  }
  
  public final int a(@NotNull Resources paramResources, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "resources");
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
          paramView.getParent().requestDisallowInterceptTouchEvent(false);
          return true;
        }
        if (this.l == 0) {
          this.l = paramView.getWidth();
        }
        if (this.m == 0) {
          this.m = paramView.getHeight();
        }
        this.h = ((int)(paramMotionEvent.getRawX() - this.f));
        this.i = ((int)(paramMotionEvent.getRawY() - this.g));
        i1 = this.h;
        int i2 = this.l;
        this.j = (i1 + i2);
        this.k = (this.i + this.m);
        if (i1 < 0)
        {
          this.h = 0;
          this.j = (this.h + i2);
        }
        i1 = this.i;
        i2 = this.n;
        if (i1 < i2)
        {
          this.i = i2;
          this.k = (this.i + this.m);
        }
        i1 = this.j;
        i2 = this.b;
        if (i1 > i2)
        {
          this.j = i2;
          this.h = (this.j - this.l);
        }
        i1 = this.k;
        i2 = this.c;
        if (i1 > i2)
        {
          this.k = i2;
          this.i = (this.k - this.m);
        }
        paramMotionEvent = paramView.getLayoutParams();
        if (paramMotionEvent != null)
        {
          paramMotionEvent = (RelativeLayout.LayoutParams)paramMotionEvent;
          paramMotionEvent.addRule(12, 0);
          paramMotionEvent.addRule(11, 0);
          paramMotionEvent.addRule(10);
          paramMotionEvent.addRule(9);
          localObject = (OnDragTouchListener)this;
          paramMotionEvent.bottomMargin = 0;
          paramMotionEvent.rightMargin = paramMotionEvent.bottomMargin;
          paramMotionEvent.topMargin = this.i;
          paramMotionEvent.leftMargin = this.h;
          paramView.setLayoutParams((ViewGroup.LayoutParams)paramMotionEvent);
          return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      }
      localObject = paramView.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "v.resources");
      i1 = a((Resources)localObject, this.a);
      float f1 = Math.abs(paramMotionEvent.getRawX() - this.d);
      float f2 = i1;
      if ((f1 < f2) && (Math.abs(paramMotionEvent.getRawY() - this.e) < f2)) {
        paramView.performClick();
      }
      paramView.getParent().requestDisallowInterceptTouchEvent(false);
      return true;
    }
    Object localObject = paramView.getParent();
    if (localObject != null)
    {
      this.b = ((View)localObject).getWidth();
      localObject = paramView.getParent();
      if (localObject != null)
      {
        this.c = ((View)localObject).getHeight();
        this.d = paramMotionEvent.getRawX();
        this.e = paramMotionEvent.getRawY();
        this.f = (paramMotionEvent.getRawX() - paramView.getLeft());
        this.g = (paramMotionEvent.getRawY() - paramView.getTop());
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.OnDragTouchListener
 * JD-Core Version:    0.7.0.1
 */