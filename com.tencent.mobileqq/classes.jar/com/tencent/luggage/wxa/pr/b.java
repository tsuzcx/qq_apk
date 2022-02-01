package com.tencent.luggage.wxa.pr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qt.c;

public abstract interface b
  extends com.tencent.luggage.wxa.ba.b
{
  @Nullable
  public abstract Drawable a(b.a parama);
  
  @Nullable
  public abstract Spannable a(Context paramContext, Spannable paramSpannable, int paramInt, c paramc, @NonNull Spannable.Factory paramFactory);
  
  @Nullable
  public abstract SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat);
  
  @Nullable
  public abstract b.a a(int paramInt);
  
  @Nullable
  public abstract b.a a(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pr.b
 * JD-Core Version:    0.7.0.1
 */