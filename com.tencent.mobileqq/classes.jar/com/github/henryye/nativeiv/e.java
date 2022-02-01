package com.github.henryye.nativeiv;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;

@SuppressLint({"LongLogTag"})
public class e
{
  private static volatile e a;
  private e.b b = new e.a(this, null);
  
  private e()
  {
    this.b.a();
  }
  
  public static e a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new e();
        }
        e locale = a;
        return locale;
      }
      finally {}
    }
    return a;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    return this.b.a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.e
 * JD-Core Version:    0.7.0.1
 */