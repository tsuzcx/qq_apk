package com.tencent.luggage.wxa.lp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public enum b$a
{
  private b$a() {}
  
  @Nullable
  public static a a(@NonNull String paramString)
  {
    paramString = paramString.trim();
    int i = paramString.hashCode();
    if (i != 0)
    {
      if (i != 111185)
      {
        if (i != 3452698)
        {
          if ((i == 1077886132) && (paramString.equals("pushAndPop")))
          {
            i = 3;
            break label93;
          }
        }
        else if (paramString.equals("push"))
        {
          i = 1;
          break label93;
        }
      }
      else if (paramString.equals("pop"))
      {
        i = 2;
        break label93;
      }
    }
    else if (paramString.equals(""))
    {
      i = 0;
      break label93;
    }
    i = -1;
    label93:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          return d;
        }
        return c;
      }
      return b;
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lp.b.a
 * JD-Core Version:    0.7.0.1
 */