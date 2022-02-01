package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap.Config;
import android.support.annotation.VisibleForTesting;

public final class PreFillType
{
  @VisibleForTesting
  static final Bitmap.Config a = Bitmap.Config.RGB_565;
  private final int b;
  private final int c;
  private final Bitmap.Config d;
  private final int e;
  
  int a()
  {
    return this.b;
  }
  
  int b()
  {
    return this.c;
  }
  
  Bitmap.Config c()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof PreFillType;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (PreFillType)paramObject;
      bool1 = bool2;
      if (this.c == paramObject.c)
      {
        bool1 = bool2;
        if (this.b == paramObject.b)
        {
          bool1 = bool2;
          if (this.e == paramObject.e)
          {
            bool1 = bool2;
            if (this.d == paramObject.d) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return ((this.b * 31 + this.c) * 31 + this.d.hashCode()) * 31 + this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreFillSize{width=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", config=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", weight=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.prefill.PreFillType
 * JD-Core Version:    0.7.0.1
 */