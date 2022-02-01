package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EditButtonManager
{
  private final int[][] a;
  @NonNull
  private final View b;
  @NonNull
  private final View c;
  private final Map<Integer, EditButtonManager.FunButton> d = new HashMap();
  private final List<EditButtonManager.FunGroup> e = new ArrayList();
  private final int f;
  private int g;
  private final int[] h = new int[2];
  private final int[] i = new int[2];
  private final int[] j = new int[2];
  private final int[] k = new int[2];
  @Nullable
  private ValueAnimator l;
  @Nullable
  private ValueAnimator m;
  private int n = 0;
  private int o = 0;
  private EditButtonManager.FunHandler p;
  
  public EditButtonManager(@NonNull View paramView, int[][] paramArrayOfInt)
  {
    this.a = paramArrayOfInt;
    this.b = paramView;
    this.b.getViewTreeObserver().addOnGlobalLayoutListener(new EditButtonManager.1(this));
    this.g = 0;
    this.f = a(this.g);
    this.c = this.b.findViewById(2131435046);
  }
  
  private int a(int paramInt)
  {
    this.d.clear();
    this.e.clear();
    int[][] arrayOfInt = this.a;
    int i4 = arrayOfInt.length;
    int i2 = 0;
    int i1;
    for (int i3 = 0; i2 < i4; i3 = i1)
    {
      int[] arrayOfInt1 = arrayOfInt[i2];
      i1 = arrayOfInt1.length;
      boolean bool2 = true;
      if (i1 == 1)
      {
        a(i3, arrayOfInt1[0], null);
        i1 = i3 + 1;
      }
      else
      {
        i1 = i3;
        if (arrayOfInt1.length == 4)
        {
          Object localObject = d(arrayOfInt1[0]);
          View localView = d(arrayOfInt1[1]);
          i1 = i3 + 1;
          localObject = new EditButtonManager.FunGroup(this, (View)localObject, localView, new int[] { i3, i1 });
          this.e.add(localObject);
          a(i3, arrayOfInt1[2], (EditButtonManager.FunGroup)localObject);
          a(i1, arrayOfInt1[3], (EditButtonManager.FunGroup)localObject);
          boolean bool1 = bool2;
          if (i3 != paramInt) {
            if (i1 == paramInt) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          a((EditButtonManager.FunGroup)localObject, bool1);
          i1 = i3 + 2;
        }
      }
      i2 += 1;
    }
    return i3;
  }
  
  private void a()
  {
    Object localObject = e(this.g);
    if (((EditButtonManager.FunButton)localObject).b.getVisibility() == 0) {
      ((EditButtonManager.FunButton)localObject).b.getLocationOnScreen(this.k);
    } else if (((EditButtonManager.FunButton)localObject).c != null) {
      ((EditButtonManager.FunButton)localObject).c.a.getLocationOnScreen(this.k);
    }
    if ((this.l == null) && (this.m == null))
    {
      this.n = this.k[0];
    }
    else
    {
      localObject = this.l;
      float f1;
      if (localObject == null) {
        f1 = 0.0F;
      } else {
        f1 = ((Float)((ValueAnimator)localObject).getAnimatedValue()).floatValue();
      }
      int i1 = this.n;
      this.n = (i1 + (int)((this.k[0] - i1) * f1));
    }
    b(this.n);
  }
  
  private void a(int paramInt1, @IdRes int paramInt2, EditButtonManager.FunGroup paramFunGroup)
  {
    EditButtonManager.FunButton localFunButton = new EditButtonManager.FunButton(this, paramInt1, d(paramInt2));
    localFunButton.b.setVisibility(0);
    localFunButton.c = paramFunGroup;
    this.d.put(Integer.valueOf(paramInt1), localFunButton);
  }
  
  private void a(EditButtonManager.FunButton paramFunButton1, EditButtonManager.FunButton paramFunButton2)
  {
    EditButtonManager.FunGroup localFunGroup1 = paramFunButton1.c;
    EditButtonManager.FunGroup localFunGroup2 = paramFunButton2.c;
    boolean bool;
    if (localFunGroup1 != localFunGroup2) {
      bool = true;
    } else {
      bool = false;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(Math.abs(paramFunButton2.a - paramFunButton1.a) * 25 + 150);
    localValueAnimator.addUpdateListener(new EditButtonManager.2(this, bool, paramFunButton2, localFunGroup1, paramFunButton1, localFunGroup2));
    localValueAnimator.addListener(new EditButtonManager.3(this, bool, localFunGroup1));
    paramFunButton1 = this.l;
    if (paramFunButton1 != null)
    {
      paramFunButton1.cancel();
      this.m = localValueAnimator;
      this.b.post(new EditButtonManager.4(this, localFunGroup1, localFunGroup2));
      return;
    }
    this.l = localValueAnimator;
    this.l.start();
    if ((localFunGroup1 != localFunGroup2) && (localFunGroup2 != null)) {
      a(localFunGroup2, true);
    }
  }
  
  private void a(@NonNull EditButtonManager.FunGroup paramFunGroup, boolean paramBoolean)
  {
    View localView = paramFunGroup.b;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localView.setVisibility(i1);
    paramFunGroup = paramFunGroup.c;
    int i3 = paramFunGroup.length;
    int i1 = 0;
    while (i1 < i3)
    {
      localView = e(paramFunGroup[i1]).b;
      int i2;
      if (paramBoolean) {
        i2 = 0;
      } else {
        i2 = 8;
      }
      localView.setVisibility(i2);
      i1 += 1;
    }
  }
  
  private void b()
  {
    Log.d("[EditButton]", "update FunGroup Layout");
    EditButtonManager.FunButton localFunButton = e(this.g);
    localFunButton.b.getMeasuredWidth();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      EditButtonManager.FunGroup localFunGroup = (EditButtonManager.FunGroup)localIterator.next();
      int i2 = localFunGroup.b.getMeasuredWidth();
      int i1 = i2;
      if (i2 <= 0) {
        i1 = e(localFunGroup.c[0]).b.getMeasuredWidth();
      }
      if (i1 > 0) {
        if (localFunGroup == localFunButton.c)
        {
          i1 *= 2;
          if (localFunGroup.a.getMeasuredWidth() != i1)
          {
            localFunGroup.a.getLayoutParams().width = i1;
            localFunGroup.a.requestLayout();
          }
        }
        else if (localFunGroup.a.getMeasuredWidth() != i1)
        {
          localFunGroup.a.getLayoutParams().width = i1;
          localFunGroup.a.requestLayout();
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.c.getLocationOnScreen(this.h);
    this.c.offsetLeftAndRight(paramInt - this.h[0]);
  }
  
  private void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f))
    {
      int i1 = this.g;
      if (i1 == paramInt) {
        return;
      }
      Object localObject = e(i1);
      EditButtonManager.FunButton localFunButton = e(paramInt);
      this.g = paramInt;
      a((EditButtonManager.FunButton)localObject, localFunButton);
      localObject = this.p;
      if (localObject != null) {
        ((EditButtonManager.FunHandler)localObject).a(localFunButton.b, paramInt);
      }
    }
  }
  
  @NonNull
  private View d(@IdRes int paramInt)
  {
    View localView = this.b.findViewById(paramInt);
    localView.getClass();
    return (View)localView;
  }
  
  @NonNull
  private EditButtonManager.FunButton e(int paramInt)
  {
    Object localObject = this.d.get(Integer.valueOf(paramInt));
    localObject.getClass();
    return (EditButtonManager.FunButton)localObject;
  }
  
  public void a(EditButtonManager.FunHandler paramFunHandler)
  {
    this.p = paramFunHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager
 * JD-Core Version:    0.7.0.1
 */