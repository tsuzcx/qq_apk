package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TextDrawableHelper
{
  private final TextPaint a = new TextPaint(1);
  private final TextAppearanceFontCallback b = new TextDrawableHelper.1(this);
  private float c;
  private boolean d = true;
  @Nullable
  private WeakReference<TextDrawableHelper.TextDrawableDelegate> e = new WeakReference(null);
  @Nullable
  private TextAppearance f;
  
  public TextDrawableHelper(@Nullable TextDrawableHelper.TextDrawableDelegate paramTextDrawableDelegate)
  {
    a(paramTextDrawableDelegate);
  }
  
  private float a(@Nullable CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0.0F;
    }
    return this.a.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public float a(String paramString)
  {
    if (!this.d) {
      return this.c;
    }
    this.c = a(paramString);
    this.d = false;
    return this.c;
  }
  
  @NonNull
  public TextPaint a()
  {
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    this.f.b(paramContext, this.a, this.b);
  }
  
  public void a(@Nullable TextDrawableHelper.TextDrawableDelegate paramTextDrawableDelegate)
  {
    this.e = new WeakReference(paramTextDrawableDelegate);
  }
  
  public void a(@Nullable TextAppearance paramTextAppearance, Context paramContext)
  {
    if (this.f != paramTextAppearance)
    {
      this.f = paramTextAppearance;
      if (paramTextAppearance != null)
      {
        paramTextAppearance.c(paramContext, this.a, this.b);
        TextDrawableHelper.TextDrawableDelegate localTextDrawableDelegate = (TextDrawableHelper.TextDrawableDelegate)this.e.get();
        if (localTextDrawableDelegate != null) {
          this.a.drawableState = localTextDrawableDelegate.getState();
        }
        paramTextAppearance.b(paramContext, this.a, this.b);
        this.d = true;
      }
      paramTextAppearance = (TextDrawableHelper.TextDrawableDelegate)this.e.get();
      if (paramTextAppearance != null)
      {
        paramTextAppearance.f();
        paramTextAppearance.onStateChange(paramTextAppearance.getState());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  @Nullable
  public TextAppearance b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.TextDrawableHelper
 * JD-Core Version:    0.7.0.1
 */