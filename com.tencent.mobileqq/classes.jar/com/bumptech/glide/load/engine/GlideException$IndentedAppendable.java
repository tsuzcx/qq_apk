package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

final class GlideException$IndentedAppendable
  implements Appendable
{
  private final Appendable a;
  private boolean b = true;
  
  GlideException$IndentedAppendable(Appendable paramAppendable)
  {
    this.a = paramAppendable;
  }
  
  @NonNull
  private CharSequence a(@Nullable CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public Appendable append(char paramChar)
  {
    boolean bool2 = this.b;
    boolean bool1 = false;
    if (bool2)
    {
      this.b = false;
      this.a.append("  ");
    }
    if (paramChar == '\n') {
      bool1 = true;
    }
    this.b = bool1;
    this.a.append(paramChar);
    return this;
  }
  
  public Appendable append(@Nullable CharSequence paramCharSequence)
  {
    paramCharSequence = a(paramCharSequence);
    return append(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public Appendable append(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramCharSequence = a(paramCharSequence);
    boolean bool1 = this.b;
    boolean bool2 = false;
    if (bool1)
    {
      this.b = false;
      this.a.append("  ");
    }
    bool1 = bool2;
    if (paramCharSequence.length() > 0)
    {
      bool1 = bool2;
      if (paramCharSequence.charAt(paramInt2 - 1) == '\n') {
        bool1 = true;
      }
    }
    this.b = bool1;
    this.a.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.GlideException.IndentedAppendable
 * JD-Core Version:    0.7.0.1
 */