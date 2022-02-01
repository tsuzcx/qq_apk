package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public enum e$a
{
  @ColorInt
  public final int c;
  
  private e$a(int paramInt)
  {
    this.c = paramInt;
  }
  
  @NonNull
  public static a a(@ColorInt int paramInt)
  {
    if (paramInt == -1) {
      return b;
    }
    return a;
  }
  
  @NonNull
  public static a a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala.name().equalsIgnoreCase(paramString)) {
          return locala;
        }
        i += 1;
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e.a
 * JD-Core Version:    0.7.0.1
 */