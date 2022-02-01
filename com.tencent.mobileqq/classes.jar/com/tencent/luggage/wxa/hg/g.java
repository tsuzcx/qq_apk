package com.tencent.luggage.wxa.hg;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;

public class g
{
  public static int a(@NonNull Context paramContext)
  {
    return a(paramContext, 0);
  }
  
  public static int a(@NonNull Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getResources();
      int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
      int i = paramInt;
      if (j != 0) {
        i = paramContext.getDimensionPixelSize(j);
      }
      return i;
    }
    catch (Resources.NotFoundException paramContext)
    {
      o.a("MicroMsg.ResourceCompat", paramContext, "get res of status_bar_height fail", new Object[0]);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hg.g
 * JD-Core Version:    0.7.0.1
 */