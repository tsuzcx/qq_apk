package com.tencent.luggage.wxa.qz;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.MediaStore.Images.Media;
import java.lang.ref.WeakReference;

final class aa$1
  implements Runnable
{
  aa$1(Context paramContext, aa.a parama) {}
  
  public void run()
  {
    o.d("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", new Object[] { this.a, this.b, af.c() });
    try
    {
      if (this.a == null) {
        return;
      }
      if (this.b == null)
      {
        if (aa.a() != null)
        {
          this.a.getContentResolver().unregisterContentObserver(aa.a());
          aa.a(null);
        }
        if (aa.b() == null) {
          return;
        }
        aa.b().clear();
        aa.a(null);
        return;
      }
      aa.a(new WeakReference(this.b));
      if (aa.a() == null)
      {
        aa.a(new aa.b(this.a, aa.c()));
        this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, aa.a());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("summerscreenshot fail e:");
      localStringBuilder.append(localThrowable.getMessage());
      o.c("MicroMsg.ScreenShotUtil", localStringBuilder.toString());
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.aa.1
 * JD-Core Version:    0.7.0.1
 */