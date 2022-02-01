package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.luggage.wxa.rx.b;
import com.tencent.neattextview.textview.layout.a;

public class TextLayoutUtil
{
  private static boolean a(View paramView, int paramInt)
  {
    return (paramInt > 0) && (getLineForOffset(paramView, paramInt) == getLineForOffset(paramView, paramInt - 1) + 1);
  }
  
  public static int getHysteresisOffset(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getLineForVertical(paramView, paramInt2);
    int i = paramInt3;
    if (a(paramView, paramInt3))
    {
      k = (int)getPrimaryHorizontal(paramView, paramInt3 - 1);
      m = (int)getLineRight(paramView, j);
      i = paramInt3;
      if (paramInt1 > m - (m - k) / 2) {
        i = paramInt3 - 1;
      }
    }
    i = getLineForOffset(paramView, i);
    int k = getLineTop(paramView, i);
    int m = getLineBottom(paramView, i);
    int n = (m - k) / 2;
    if (j == i + 1)
    {
      paramInt3 = i;
      if (paramInt2 - m < n) {}
    }
    else if ((j == i - 1) && (k - paramInt2 < n))
    {
      paramInt3 = i;
    }
    else
    {
      paramInt3 = j;
    }
    i = getOffsetForHorizontal(paramView, paramInt3, paramInt1);
    paramInt2 = i;
    if (i < getText(paramView).length() - 1)
    {
      j = i + 1;
      paramInt2 = i;
      if (a(paramView, j))
      {
        k = (int)getPrimaryHorizontal(paramView, i);
        paramInt3 = (int)getLineRight(paramView, paramInt3);
        paramInt2 = i;
        if (paramInt1 > paramInt3 - (paramInt3 - k) / 2) {
          paramInt2 = j;
        }
      }
    }
    return paramInt2;
  }
  
  public static int getLineBaseline(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.a(paramInt);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getLineBaseline(paramInt);
      }
    }
    return 0;
  }
  
  public static int getLineBottom(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.c(paramInt);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getLineBottom(paramInt);
      }
    }
    return 0;
  }
  
  public static int getLineForOffset(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.d(paramInt);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getLineForOffset(paramInt);
      }
    }
    return 0;
  }
  
  public static int getLineForVertical(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.h(paramInt);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getLineForVertical(paramInt);
      }
    }
    return 0;
  }
  
  public static int getLineHeight(View paramView)
  {
    if ((paramView instanceof b)) {
      return ((b)paramView).getLineHeight();
    }
    if ((paramView instanceof TextView)) {
      return ((TextView)paramView).getLineHeight();
    }
    return 0;
  }
  
  public static float getLineLeft(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.e(paramView.g(paramInt));
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getLineLeft(paramInt);
      }
    }
    return 0.0F;
  }
  
  public static float getLineRight(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.i(paramInt);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getLineRight(paramInt);
      }
    }
    return 0.0F;
  }
  
  public static int getLineStart(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.g(paramInt);
        break label60;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineStart(paramInt);
        break label60;
      }
    }
    paramInt = 0;
    label60:
    if (paramInt >= 0) {
      return paramInt;
    }
    return 0;
  }
  
  public static int getLineTop(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.b(paramInt);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getLineTop(paramInt);
      }
    }
    return 0;
  }
  
  public static float getLineWidth(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.f(paramInt);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getLineWidth(paramInt);
      }
    }
    return 0.0F;
  }
  
  public static int getOffsetForHorizontal(View paramView, int paramInt, float paramFloat)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.a(paramInt, paramFloat);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getOffsetForHorizontal(paramInt, paramFloat);
      }
    }
    return 0;
  }
  
  public static int getOffsetForPosition(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.a(paramInt1, paramInt2);
      }
    }
    else if ((paramView instanceof TextView))
    {
      return getPreciseOffset((TextView)paramView, paramInt1, paramInt2);
    }
    return 0;
  }
  
  public static TextPaint getPaint(View paramView)
  {
    if ((paramView instanceof b)) {
      return ((b)paramView).getPaint();
    }
    if ((paramView instanceof TextView)) {
      return ((TextView)paramView).getPaint();
    }
    return null;
  }
  
  public static int getPreciseOffset(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView = paramTextView.getLayout();
    if (paramTextView != null)
    {
      paramInt2 = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(paramInt2), paramInt1);
      if ((int)paramTextView.getPrimaryHorizontal(paramInt2) > paramInt1) {
        return paramTextView.getOffsetToLeftOf(paramInt2);
      }
      return paramInt2;
    }
    return -1;
  }
  
  public static float getPrimaryHorizontal(View paramView, int paramInt)
  {
    if ((paramView instanceof b))
    {
      paramView = ((b)paramView).getLayout();
      if (paramView != null) {
        return paramView.e(paramInt);
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null) {
        return paramView.getPrimaryHorizontal(paramInt);
      }
    }
    return 0.0F;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static CharSequence getText(View paramView)
  {
    if ((paramView instanceof b)) {
      return ((b)paramView).b();
    }
    if ((paramView instanceof TextView)) {
      return ((TextView)paramView).getText();
    }
    return "";
  }
  
  public static float getTextSize(View paramView)
  {
    if ((paramView instanceof b)) {
      return ((b)paramView).getTextSize();
    }
    if ((paramView instanceof TextView)) {
      return ((TextView)paramView).getTextSize();
    }
    return 0.0F;
  }
  
  public static void setText(View paramView, CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((paramView instanceof b))
    {
      ((b)paramView).a(paramCharSequence, paramBufferType);
      return;
    }
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setText(paramCharSequence, paramBufferType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.TextLayoutUtil
 * JD-Core Version:    0.7.0.1
 */