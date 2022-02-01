package com.tencent.luggage.wxa.rx;

import android.text.Layout;
import android.util.Log;
import android.widget.TextView;
import com.tencent.neattextview.textview.layout.a;
import java.util.List;

class b$1
  implements a
{
  b$1(b paramb) {}
  
  public int a(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1;
      }
      return localLayout.getLineBaseline(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1;
    }
    return b.c(this.a).a(paramInt);
  }
  
  public int a(int paramInt, float paramFloat)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1;
      }
      return localLayout.getOffsetForHorizontal(paramInt, paramFloat);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1;
    }
    return b.c(this.a).a(paramInt, paramFloat);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (b.a(this.a))
    {
      paramInt1 -= this.a.getPaddingLeft();
      int i = this.a.getPaddingTop();
      Layout localLayout = this.a.getWrappedTextView().getLayout();
      if (localLayout != null)
      {
        paramInt2 = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(paramInt2 - i), paramInt1);
        if ((int)localLayout.getPrimaryHorizontal(paramInt2) > paramInt1) {
          return localLayout.getOffsetToLeftOf(paramInt2);
        }
        return paramInt2;
      }
      return -1;
    }
    if (b.c(this.a) == null) {
      return -1;
    }
    return b.c(this.a).a(paramInt1, paramInt2);
  }
  
  public List<com.tencent.luggage.wxa.rw.c> a()
  {
    if (b.a(this.a)) {
      return null;
    }
    if (b.c(this.a) == null) {
      return null;
    }
    return b.c(this.a).a();
  }
  
  public int b(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1;
      }
      return localLayout.getLineTop(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1;
    }
    return b.c(this.a).b(paramInt);
  }
  
  public int c(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1;
      }
      return localLayout.getLineBottom(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1;
    }
    return b.c(this.a).c(paramInt);
  }
  
  public int d(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1;
      }
      return localLayout.getLineForOffset(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1;
    }
    return b.c(this.a).d(paramInt);
  }
  
  public float e(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1.0F;
      }
      return localLayout.getPrimaryHorizontal(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1.0F;
    }
    return b.c(this.a).e(paramInt);
  }
  
  public float f(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1.0F;
      }
      return localLayout.getLineWidth(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1.0F;
    }
    return b.c(this.a).f(paramInt);
  }
  
  public int g(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1;
      }
      return localLayout.getLineStart(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1;
    }
    return b.c(this.a).g(paramInt);
  }
  
  public int h(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1;
      }
      return localLayout.getLineForVertical(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1;
    }
    return b.c(this.a).h(paramInt);
  }
  
  public float i(int paramInt)
  {
    if (b.a(this.a))
    {
      Layout localLayout = b.b(this.a);
      if (localLayout == null) {
        Log.e("NeatTextView", "layout is null!");
      }
      if (localLayout == null) {
        return -1.0F;
      }
      return localLayout.getLineRight(paramInt);
    }
    if (b.c(this.a) == null) {
      Log.e("NeatTextView", "mLayout is null!");
    }
    if (b.c(this.a) == null) {
      return -1.0F;
    }
    return b.c(this.a).i(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rx.b.1
 * JD-Core Version:    0.7.0.1
 */