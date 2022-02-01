package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController
{
  private final Context a;
  @NonNull
  private final TextInputLayout b;
  private LinearLayout c;
  private int d;
  private FrameLayout e;
  @Nullable
  private Animator f;
  private final float g;
  private int h;
  private int i;
  @Nullable
  private CharSequence j;
  private boolean k;
  @Nullable
  private TextView l;
  @Nullable
  private CharSequence m;
  private int n;
  @Nullable
  private ColorStateList o;
  private CharSequence p;
  private boolean q;
  @Nullable
  private TextView r;
  private int s;
  @Nullable
  private ColorStateList t;
  private Typeface u;
  
  public IndicatorViewController(@NonNull TextInputLayout paramTextInputLayout)
  {
    this.a = paramTextInputLayout.getContext();
    this.b = paramTextInputLayout;
    this.g = this.a.getResources().getDimensionPixelSize(R.dimen.s);
  }
  
  private int a(boolean paramBoolean, @DimenRes int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      paramInt2 = this.a.getResources().getDimensionPixelSize(paramInt1);
    }
    return paramInt2;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.g, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(AnimationUtils.d);
    return paramTextView;
  }
  
  private ObjectAnimator a(TextView paramTextView, boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f1 });
    paramTextView.setDuration(167L);
    paramTextView.setInterpolator(AnimationUtils.a);
    return paramTextView;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    TextView localTextView;
    if (paramInt2 != 0)
    {
      localTextView = d(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = d(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.h = paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.f = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.q, this.r, 2, paramInt1, paramInt2);
      a(localArrayList, this.k, this.l, 1, paramInt1, paramInt2);
      AnimatorSetCompat.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new IndicatorViewController.1(this, paramInt2, d(paramInt1), paramInt1, d(paramInt2)));
      localAnimatorSet.start();
    }
    else
    {
      a(paramInt1, paramInt2);
    }
    this.b.c();
    this.b.a(paramBoolean);
    this.b.i();
  }
  
  private void a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private void a(@Nullable TextView paramTextView, Typeface paramTypeface)
  {
    if (paramTextView != null) {
      paramTextView.setTypeface(paramTypeface);
    }
  }
  
  private void a(@NonNull List<Animator> paramList, boolean paramBoolean, @Nullable TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView != null)
    {
      if (!paramBoolean) {
        return;
      }
      if ((paramInt1 == paramInt3) || (paramInt1 == paramInt2))
      {
        if (paramInt3 == paramInt1) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramList.add(a(paramTextView, paramBoolean));
        if (paramInt3 == paramInt1) {
          paramList.add(a(paramTextView));
        }
      }
    }
  }
  
  private boolean a(@Nullable TextView paramTextView, @Nullable CharSequence paramCharSequence)
  {
    return (ViewCompat.isLaidOut(this.b)) && (this.b.isEnabled()) && ((this.i != this.h) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  @Nullable
  private TextView d(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return this.r;
    }
    return this.l;
  }
  
  private boolean e(int paramInt)
  {
    return (paramInt == 1) && (this.l != null) && (!TextUtils.isEmpty(this.j));
  }
  
  private boolean n()
  {
    return (this.c != null) && (this.b.getEditText() != null);
  }
  
  void a()
  {
    c();
    if (this.h == 2) {
      this.i = 0;
    }
    a(this.h, this.i, a(this.r, null));
  }
  
  void a(@Nullable ColorStateList paramColorStateList)
  {
    this.o = paramColorStateList;
    TextView localTextView = this.l;
    if ((localTextView != null) && (paramColorStateList != null)) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  void a(Typeface paramTypeface)
  {
    if (paramTypeface != this.u)
    {
      this.u = paramTypeface;
      a(this.l, paramTypeface);
      a(this.r, paramTypeface);
    }
  }
  
  void a(TextView paramTextView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.c == null) && (this.e == null))
    {
      this.c = new LinearLayout(this.a);
      this.c.setOrientation(0);
      this.b.addView(this.c, -1, -2);
      this.e = new FrameLayout(this.a);
      localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
      this.c.addView(this.e, localLayoutParams);
      if (this.b.getEditText() != null) {
        d();
      }
    }
    if (a(paramInt))
    {
      this.e.setVisibility(0);
      this.e.addView(paramTextView);
    }
    else
    {
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      this.c.addView(paramTextView, localLayoutParams);
    }
    this.c.setVisibility(0);
    this.d += 1;
  }
  
  void a(CharSequence paramCharSequence)
  {
    c();
    this.p = paramCharSequence;
    this.r.setText(paramCharSequence);
    if (this.h != 2) {
      this.i = 2;
    }
    a(this.h, this.i, a(this.r, paramCharSequence));
  }
  
  void a(boolean paramBoolean)
  {
    if (this.k == paramBoolean) {
      return;
    }
    c();
    if (paramBoolean)
    {
      this.l = new AppCompatTextView(this.a);
      this.l.setId(R.id.ag);
      if (Build.VERSION.SDK_INT >= 17) {
        this.l.setTextAlignment(5);
      }
      Typeface localTypeface = this.u;
      if (localTypeface != null) {
        this.l.setTypeface(localTypeface);
      }
      b(this.n);
      a(this.o);
      c(this.m);
      this.l.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(this.l, 1);
      a(this.l, 0);
    }
    else
    {
      b();
      b(this.l, 0);
      this.l = null;
      this.b.c();
      this.b.i();
    }
    this.k = paramBoolean;
  }
  
  boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  void b()
  {
    this.j = null;
    c();
    if (this.h == 1) {
      if ((this.q) && (!TextUtils.isEmpty(this.p))) {
        this.i = 2;
      } else {
        this.i = 0;
      }
    }
    a(this.h, this.i, a(this.l, null));
  }
  
  void b(@StyleRes int paramInt)
  {
    this.n = paramInt;
    TextView localTextView = this.l;
    if (localTextView != null) {
      this.b.a(localTextView, paramInt);
    }
  }
  
  void b(@Nullable ColorStateList paramColorStateList)
  {
    this.t = paramColorStateList;
    TextView localTextView = this.r;
    if ((localTextView != null) && (paramColorStateList != null)) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  void b(TextView paramTextView, int paramInt)
  {
    if (this.c == null) {
      return;
    }
    if (a(paramInt))
    {
      FrameLayout localFrameLayout = this.e;
      if (localFrameLayout != null)
      {
        localFrameLayout.removeView(paramTextView);
        break label41;
      }
    }
    this.c.removeView(paramTextView);
    label41:
    this.d -= 1;
    a(this.c, this.d);
  }
  
  void b(CharSequence paramCharSequence)
  {
    c();
    this.j = paramCharSequence;
    this.l.setText(paramCharSequence);
    if (this.h != 1) {
      this.i = 1;
    }
    a(this.h, this.i, a(this.l, paramCharSequence));
  }
  
  void b(boolean paramBoolean)
  {
    if (this.q == paramBoolean) {
      return;
    }
    c();
    if (paramBoolean)
    {
      this.r = new AppCompatTextView(this.a);
      this.r.setId(R.id.ah);
      if (Build.VERSION.SDK_INT >= 17) {
        this.r.setTextAlignment(5);
      }
      Typeface localTypeface = this.u;
      if (localTypeface != null) {
        this.r.setTypeface(localTypeface);
      }
      this.r.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(this.r, 1);
      c(this.s);
      b(this.t);
      a(this.r, 1);
    }
    else
    {
      a();
      b(this.r, 1);
      this.r = null;
      this.b.c();
      this.b.i();
    }
    this.q = paramBoolean;
  }
  
  void c()
  {
    Animator localAnimator = this.f;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  void c(@StyleRes int paramInt)
  {
    this.s = paramInt;
    TextView localTextView = this.r;
    if (localTextView != null) {
      TextViewCompat.setTextAppearance(localTextView, paramInt);
    }
  }
  
  void c(@Nullable CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    TextView localTextView = this.l;
    if (localTextView != null) {
      localTextView.setContentDescription(paramCharSequence);
    }
  }
  
  void d()
  {
    if (n())
    {
      EditText localEditText = this.b.getEditText();
      boolean bool = MaterialResources.a(this.a);
      ViewCompat.setPaddingRelative(this.c, a(bool, R.dimen.D, ViewCompat.getPaddingStart(localEditText)), a(bool, R.dimen.E, this.a.getResources().getDimensionPixelSize(R.dimen.C)), a(bool, R.dimen.D, ViewCompat.getPaddingEnd(localEditText)), 0);
    }
  }
  
  boolean e()
  {
    return this.k;
  }
  
  boolean f()
  {
    return this.q;
  }
  
  boolean g()
  {
    return e(this.i);
  }
  
  @Nullable
  CharSequence h()
  {
    return this.j;
  }
  
  CharSequence i()
  {
    return this.p;
  }
  
  @ColorInt
  int j()
  {
    TextView localTextView = this.l;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
  
  @Nullable
  ColorStateList k()
  {
    TextView localTextView = this.l;
    if (localTextView != null) {
      return localTextView.getTextColors();
    }
    return null;
  }
  
  @Nullable
  CharSequence l()
  {
    return this.m;
  }
  
  @ColorInt
  int m()
  {
    TextView localTextView = this.r;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.IndicatorViewController
 * JD-Core Version:    0.7.0.1
 */