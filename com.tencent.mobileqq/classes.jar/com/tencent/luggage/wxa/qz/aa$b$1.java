package com.tencent.luggage.wxa.qz;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.lang.ref.WeakReference;

class aa$b$1
  implements Runnable
{
  aa$b$1(aa.b paramb, boolean paramBoolean, Uri paramUri) {}
  
  public void run()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("summerscreenshot onChange: ");
    localStringBuilder1.append(this.a);
    localStringBuilder1.append(", uri:");
    localStringBuilder1.append(this.b.toString());
    o.e("MicroMsg.ScreenShotUtil", localStringBuilder1.toString());
    try
    {
      if ((aa.b() != null) && (aa.b().get() != null))
      {
        if ((this.b.toString().matches(aa.d())) || (this.b.toString().contains(aa.d()))) {
          aa.b.a(this.c, aa.b.a(this.c), this.b);
        }
      }
      else
      {
        o.d("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", new Object[] { aa.b() });
        if (aa.a() != null)
        {
          aa.b.a(this.c).getContentResolver().unregisterContentObserver(aa.a());
          aa.a(null);
        }
        if (aa.b() != null)
        {
          aa.b().clear();
          aa.a(null);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("summerscreenshot fail e:");
      localStringBuilder2.append(localThrowable.getMessage());
      o.c("MicroMsg.ScreenShotUtil", localStringBuilder2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.aa.b.1
 * JD-Core Version:    0.7.0.1
 */