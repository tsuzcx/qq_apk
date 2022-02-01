package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance
{
  @Nullable
  public final ColorStateList a;
  @Nullable
  public final ColorStateList b;
  @Nullable
  public final ColorStateList c;
  @Nullable
  public final ColorStateList d;
  @Nullable
  public final String e;
  public final int f;
  public final int g;
  public final boolean h;
  public final float i;
  public final float j;
  public final float k;
  public final boolean l;
  public final float m;
  public float n;
  @FontRes
  private final int o;
  private boolean p = false;
  private Typeface q;
  
  public TextAppearance(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.hL);
    this.n = localTypedArray.getDimension(R.styleable.hM, 0.0F);
    this.a = MaterialResources.a(paramContext, localTypedArray, R.styleable.hP);
    this.b = MaterialResources.a(paramContext, localTypedArray, R.styleable.hQ);
    this.c = MaterialResources.a(paramContext, localTypedArray, R.styleable.hR);
    this.f = localTypedArray.getInt(R.styleable.hO, 0);
    this.g = localTypedArray.getInt(R.styleable.hN, 1);
    int i1 = MaterialResources.a(localTypedArray, R.styleable.hX, R.styleable.hW);
    this.o = localTypedArray.getResourceId(i1, 0);
    this.e = localTypedArray.getString(i1);
    this.h = localTypedArray.getBoolean(R.styleable.hY, false);
    this.d = MaterialResources.a(paramContext, localTypedArray, R.styleable.hS);
    this.i = localTypedArray.getFloat(R.styleable.hT, 0.0F);
    this.j = localTypedArray.getFloat(R.styleable.hU, 0.0F);
    this.k = localTypedArray.getFloat(R.styleable.hV, 0.0F);
    localTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = paramContext.obtainStyledAttributes(paramInt, R.styleable.eO);
      this.l = paramContext.hasValue(R.styleable.eP);
      this.m = paramContext.getFloat(R.styleable.eP, 0.0F);
      paramContext.recycle();
      return;
    }
    this.l = false;
    this.m = 0.0F;
  }
  
  private void b()
  {
    if (this.q == null)
    {
      String str = this.e;
      if (str != null) {
        this.q = Typeface.create(str, this.f);
      }
    }
    if (this.q == null)
    {
      int i1 = this.g;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            this.q = Typeface.DEFAULT;
          } else {
            this.q = Typeface.MONOSPACE;
          }
        }
        else {
          this.q = Typeface.SERIF;
        }
      }
      else {
        this.q = Typeface.SANS_SERIF;
      }
      this.q = Typeface.create(this.q, this.f);
    }
  }
  
  private boolean b(Context paramContext)
  {
    return TextAppearanceConfig.a();
  }
  
  public Typeface a()
  {
    b();
    return this.q;
  }
  
  @NonNull
  @VisibleForTesting
  public Typeface a(@NonNull Context paramContext)
  {
    if (this.p) {
      return this.q;
    }
    if (!paramContext.isRestricted()) {}
    try
    {
      try
      {
        this.q = ResourcesCompat.getFont(paramContext, this.o);
        if (this.q != null) {
          this.q = Typeface.create(this.q, this.f);
        }
      }
      catch (Exception paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Error loading font ");
        localStringBuilder.append(this.e);
        Log.d("TextAppearance", localStringBuilder.toString(), paramContext);
      }
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext)
    {
      label92:
      break label92;
    }
    b();
    this.p = true;
    return this.q;
  }
  
  public void a(@NonNull Context paramContext, @NonNull TextPaint paramTextPaint, @NonNull TextAppearanceFontCallback paramTextAppearanceFontCallback)
  {
    a(paramTextPaint, a());
    a(paramContext, new TextAppearance.2(this, paramTextPaint, paramTextAppearanceFontCallback));
  }
  
  public void a(@NonNull Context paramContext, @NonNull TextAppearanceFontCallback paramTextAppearanceFontCallback)
  {
    if (b(paramContext)) {
      a(paramContext);
    } else {
      b();
    }
    if (this.o == 0) {
      this.p = true;
    }
    if (this.p)
    {
      paramTextAppearanceFontCallback.a(this.q, true);
      return;
    }
    try
    {
      ResourcesCompat.getFont(paramContext, this.o, new TextAppearance.1(this, paramTextAppearanceFontCallback), null);
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error loading font ");
      localStringBuilder.append(this.e);
      Log.d("TextAppearance", localStringBuilder.toString(), paramContext);
      this.p = true;
      paramTextAppearanceFontCallback.a(-3);
      return;
      this.p = true;
      paramTextAppearanceFontCallback.a(1);
      return;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label117:
      break label117;
    }
  }
  
  public void a(@NonNull TextPaint paramTextPaint, @NonNull Typeface paramTypeface)
  {
    paramTextPaint.setTypeface(paramTypeface);
    int i1 = this.f;
    i1 = (paramTypeface.getStyle() ^ 0xFFFFFFFF) & i1;
    boolean bool;
    if ((i1 & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramTextPaint.setFakeBoldText(bool);
    float f1;
    if ((i1 & 0x2) != 0) {
      f1 = -0.25F;
    } else {
      f1 = 0.0F;
    }
    paramTextPaint.setTextSkewX(f1);
    paramTextPaint.setTextSize(this.n);
    if ((Build.VERSION.SDK_INT >= 21) && (this.l)) {
      paramTextPaint.setLetterSpacing(this.m);
    }
  }
  
  public void b(@NonNull Context paramContext, @NonNull TextPaint paramTextPaint, @NonNull TextAppearanceFontCallback paramTextAppearanceFontCallback)
  {
    c(paramContext, paramTextPaint, paramTextAppearanceFontCallback);
    paramContext = this.a;
    int i1;
    if (paramContext != null) {
      i1 = paramContext.getColorForState(paramTextPaint.drawableState, this.a.getDefaultColor());
    } else {
      i1 = -16777216;
    }
    paramTextPaint.setColor(i1);
    float f1 = this.k;
    float f2 = this.i;
    float f3 = this.j;
    paramContext = this.d;
    if (paramContext != null) {
      i1 = paramContext.getColorForState(paramTextPaint.drawableState, this.d.getDefaultColor());
    } else {
      i1 = 0;
    }
    paramTextPaint.setShadowLayer(f1, f2, f3, i1);
  }
  
  public void c(@NonNull Context paramContext, @NonNull TextPaint paramTextPaint, @NonNull TextAppearanceFontCallback paramTextAppearanceFontCallback)
  {
    if (b(paramContext))
    {
      a(paramTextPaint, a(paramContext));
      return;
    }
    a(paramContext, paramTextPaint, paramTextAppearanceFontCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.resources.TextAppearance
 * JD-Core Version:    0.7.0.1
 */