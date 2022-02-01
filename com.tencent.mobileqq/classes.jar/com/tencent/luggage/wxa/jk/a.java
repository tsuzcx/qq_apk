package com.tencent.luggage.wxa.jk;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.File;

public class a
{
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = ContextCompat.getDataDir(paramContext);
      paramContext.getClass();
      paramContext = new i(((File)paramContext).getAbsolutePath(), "app_wxa");
      k.g(paramContext.l());
      paramContext = new i(paramContext, "wasae.dat").l();
      return paramContext;
    }
    catch (NullPointerException paramContext)
    {
      label51:
      break label51;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jk.a
 * JD-Core Version:    0.7.0.1
 */