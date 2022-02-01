package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.qz.o;
import java.util.Locale;

public enum e$a
{
  public int g;
  public String h;
  
  private e$a(int paramInt, String paramString)
  {
    this.g = paramInt;
    this.h = paramString;
  }
  
  public static a a(String paramString, a parama)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return parama;
      }
      try
      {
        a locala = valueOf(paramString.toUpperCase(Locale.ENGLISH));
        return locala;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        o.b("Luggage.ILuggageRecorder.AudioSource", "valueOf(%s) e=[%s]", new Object[] { paramString, localIllegalArgumentException.getMessage() });
      }
    }
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.e.a
 * JD-Core Version:    0.7.0.1
 */