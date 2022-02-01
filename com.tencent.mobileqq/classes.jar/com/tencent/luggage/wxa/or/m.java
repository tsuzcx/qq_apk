package com.tencent.luggage.wxa.or;

import android.app.ActivityManager.TaskDescription;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.oq.c.a;
import com.tencent.luggage.wxa.pd.w;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.graphics.MMBitmapFactory;

final class m
{
  static ActivityManager.TaskDescription a(c.a parama)
  {
    int i = w.a(parama.d());
    if (parama.c() > 0)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        return new ActivityManager.TaskDescription(parama.a(), parama.c(), i);
      }
      try
      {
        Object localObject = MMBitmapFactory.a(r.d(), parama.c());
        localObject = new ActivityManager.TaskDescription(parama.a(), (Bitmap)localObject, i);
        return localObject;
      }
      catch (Exception localException)
      {
        o.b("Luggage.WXA.WindowAndroidActivityFactory", "decode bitmap failed e=%s", new Object[] { localException });
        return new ActivityManager.TaskDescription(parama.a(), null, i);
      }
    }
    return new ActivityManager.TaskDescription(parama.a(), parama.b(), i);
  }
  
  static boolean a(Configuration paramConfiguration1, Configuration paramConfiguration2)
  {
    if (paramConfiguration1 != null)
    {
      if (paramConfiguration2 == null) {
        return true;
      }
      if ((paramConfiguration1.screenWidthDp == paramConfiguration2.screenWidthDp) && (paramConfiguration1.screenHeightDp == paramConfiguration2.screenHeightDp)) {
        return paramConfiguration1.smallestScreenWidthDp != paramConfiguration2.smallestScreenWidthDp;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.m
 * JD-Core Version:    0.7.0.1
 */