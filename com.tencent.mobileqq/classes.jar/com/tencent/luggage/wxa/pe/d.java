package com.tencent.luggage.wxa.pe;

import android.content.Intent;
import android.os.Build.VERSION;

class d
{
  c a(Intent paramIntent)
  {
    c localc = new c();
    localc.b = b(paramIntent);
    localc.a = c(paramIntent);
    return localc;
  }
  
  int b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return -1;
    }
    int i = paramIntent.getIntExtra("level", -1);
    int j = paramIntent.getIntExtra("scale", -1);
    if (j <= 0) {
      return -1;
    }
    if (i < 0) {
      return -1;
    }
    return Math.min(Math.max((int)Math.floor(i * 100.0F / j), 0), 100);
  }
  
  boolean c(Intent paramIntent)
  {
    boolean bool2 = false;
    if (paramIntent == null) {
      return false;
    }
    int i = paramIntent.getIntExtra("status", -1);
    int j = paramIntent.getIntExtra("plugged", 0);
    boolean bool1;
    if ((i != 2) && (j != 1) && (j != 2))
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 17)
      {
        bool1 = bool2;
        if (j != 4) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pe.d
 * JD-Core Version:    0.7.0.1
 */