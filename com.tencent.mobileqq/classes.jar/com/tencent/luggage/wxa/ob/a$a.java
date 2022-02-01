package com.tencent.luggage.wxa.ob;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.af;
import java.util.Locale;

public enum a$a
{
  public final int j = -10000 - ordinal();
  public final String k = null;
  public String l;
  
  private a$a() {}
  
  @NonNull
  public String toString()
  {
    return String.format(Locale.ENGLISH, "%s(%d %s)", new Object[] { name(), Integer.valueOf(this.j), af.b(this.k) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ob.a.a
 * JD-Core Version:    0.7.0.1
 */