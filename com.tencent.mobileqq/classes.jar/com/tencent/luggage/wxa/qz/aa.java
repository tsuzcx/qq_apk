package com.tencent.luggage.wxa.qz;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import com.tencent.luggage.wxa.sk.a;
import java.lang.ref.WeakReference;

public final class aa
{
  private static s a = new s(a.a("MicroMsg.ScreenShotUtil"));
  private static final Handler b = new Handler(Looper.getMainLooper());
  private static final String c = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  private static final String[] d = { "_display_name", "_data", "date_added" };
  private static ContentObserver e;
  private static WeakReference<aa.a> f;
  
  public static void a(Context paramContext, aa.a parama)
  {
    a.a(new aa.1(paramContext, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.aa
 * JD-Core Version:    0.7.0.1
 */