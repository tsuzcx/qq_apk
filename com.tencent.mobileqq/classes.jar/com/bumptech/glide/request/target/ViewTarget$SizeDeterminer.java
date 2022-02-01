package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@VisibleForTesting
final class ViewTarget$SizeDeterminer
{
  @Nullable
  @VisibleForTesting
  static Integer a;
  boolean b;
  private final View c;
  private final List<SizeReadyCallback> d = new ArrayList();
  @Nullable
  private ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener e;
  
  ViewTarget$SizeDeterminer(@NonNull View paramView)
  {
    this.c = paramView;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt3;
    if (i > 0) {
      return i;
    }
    if ((this.b) && (this.c.isLayoutRequested())) {
      return 0;
    }
    paramInt1 -= paramInt3;
    if (paramInt1 > 0) {
      return paramInt1;
    }
    if ((!this.c.isLayoutRequested()) && (paramInt2 == -2))
    {
      if (Log.isLoggable("ViewTarget", 4)) {
        Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
      }
      return a(this.c.getContext());
    }
    return 0;
  }
  
  private static int a(@NonNull Context paramContext)
  {
    if (a == null)
    {
      paramContext = ((WindowManager)Preconditions.a((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay();
      Point localPoint = new Point();
      paramContext.getSize(localPoint);
      a = Integer.valueOf(Math.max(localPoint.x, localPoint.y));
    }
    return a.intValue();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = new ArrayList(this.d).iterator();
    while (localIterator.hasNext()) {
      ((SizeReadyCallback)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt > 0) || (paramInt == -2147483648);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return (a(paramInt1)) && (a(paramInt2));
  }
  
  private int c()
  {
    int j = this.c.getPaddingTop();
    int k = this.c.getPaddingBottom();
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    int i;
    if (localLayoutParams != null) {
      i = localLayoutParams.height;
    } else {
      i = 0;
    }
    return a(this.c.getHeight(), i, j + k);
  }
  
  private int d()
  {
    int j = this.c.getPaddingLeft();
    int k = this.c.getPaddingRight();
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    int i;
    if (localLayoutParams != null) {
      i = localLayoutParams.width;
    } else {
      i = 0;
    }
    return a(this.c.getWidth(), i, j + k);
  }
  
  void a()
  {
    if (this.d.isEmpty()) {
      return;
    }
    int i = d();
    int j = c();
    if (!b(i, j)) {
      return;
    }
    a(i, j);
    b();
  }
  
  void a(@NonNull SizeReadyCallback paramSizeReadyCallback)
  {
    int i = d();
    int j = c();
    if (b(i, j))
    {
      paramSizeReadyCallback.a(i, j);
      return;
    }
    if (!this.d.contains(paramSizeReadyCallback)) {
      this.d.add(paramSizeReadyCallback);
    }
    if (this.e == null)
    {
      paramSizeReadyCallback = this.c.getViewTreeObserver();
      this.e = new ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener(this);
      paramSizeReadyCallback.addOnPreDrawListener(this.e);
    }
  }
  
  void b()
  {
    ViewTreeObserver localViewTreeObserver = this.c.getViewTreeObserver();
    if (localViewTreeObserver.isAlive()) {
      localViewTreeObserver.removeOnPreDrawListener(this.e);
    }
    this.e = null;
    this.d.clear();
  }
  
  void b(@NonNull SizeReadyCallback paramSizeReadyCallback)
  {
    this.d.remove(paramSizeReadyCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.ViewTarget.SizeDeterminer
 * JD-Core Version:    0.7.0.1
 */