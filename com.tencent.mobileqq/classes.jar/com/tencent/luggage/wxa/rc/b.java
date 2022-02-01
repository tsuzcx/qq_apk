package com.tencent.luggage.wxa.rc;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.luggage.wxa.hg.e;
import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.File;
import java.util.Locale;

public class b
{
  @TargetApi(8)
  public static String a()
  {
    return a.f();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(String.format(Locale.US, "%s%d.%s", new Object[] { "mmexport", Long.valueOf(System.currentTimeMillis()), paramString }));
    return localStringBuilder.toString();
  }
  
  private static void a(Context paramContext, String paramString)
  {
    String str2 = d.b(paramString);
    if (str2 == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    Object localObject1;
    if (str2.contains("image"))
    {
      localObject2 = MediaStore.Images.Media.getContentUri("external");
      localObject1 = c(paramString);
      if (localObject1 == null) {
        return;
      }
      localContentValues.put("width", Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth));
      localContentValues.put("height", Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight));
      if (!str2.contains("jpeg"))
      {
        localObject1 = localObject2;
        if (!str2.contains("jpg")) {}
      }
      else
      {
        localContentValues.put("orientation", Integer.valueOf(d(paramString)));
        localObject1 = localObject2;
      }
    }
    else if (str2.contains("video"))
    {
      localObject1 = MediaStore.Video.Media.getContentUri("external");
      localObject2 = new com.tencent.luggage.wxa.hh.b();
      ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
      localContentValues.put("width", ((MediaMetadataRetriever)localObject2).extractMetadata(18));
      localContentValues.put("height", ((MediaMetadataRetriever)localObject2).extractMetadata(19));
      localContentValues.put("duration", ((MediaMetadataRetriever)localObject2).extractMetadata(9));
      localContentValues.put("orientation", ((MediaMetadataRetriever)localObject2).extractMetadata(24));
    }
    else
    {
      localObject1 = MediaStore.Files.getContentUri("external");
    }
    String str1 = k.c(paramString, false);
    Object localObject2 = str1;
    if (str1 == null) {
      localObject2 = paramString;
    }
    localContentValues.put("_data", (String)localObject2);
    localContentValues.put("_display_name", new i(paramString).d());
    localContentValues.put("title", k.l(paramString));
    localContentValues.put("_size", Long.valueOf(k.c(paramString)));
    localContentValues.put("mime_type", str2);
    paramContext.getContentResolver().insert((Uri)localObject1, localContentValues);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (af.c(paramString)) {
      return;
    }
    String str1 = k.c(paramString, false);
    if (str1 != null)
    {
      try
      {
        a(paramContext, str1);
      }
      catch (Throwable localThrowable)
      {
        o.a("Luggage.AndroidMediaUtil", localThrowable, "Cannot update media database", new Object[0]);
      }
      try
      {
        paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", f.a(paramContext, new i(str1))));
      }
      catch (Exception localException)
      {
        o.a("Luggage.AndroidMediaUtil", localException, "", new Object[0]);
      }
    }
    o.d("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
    if (Build.VERSION.SDK_INT > 28) {
      try
      {
        String str2 = d.b(paramString);
        MediaScannerConnection.scanFile(paramContext.getApplicationContext(), new String[] { str1 }, new String[] { str2 }, null);
        return;
      }
      catch (Throwable paramContext)
      {
        o.b("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", new Object[] { paramString, paramContext });
        return;
      }
    }
    try
    {
      paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", f.a(paramContext, new i(paramString))).addFlags(1));
      o.d("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
      return;
    }
    catch (Throwable paramContext)
    {
      o.b("Luggage.AndroidMediaUtil", "refreshMediaScanner with broadcast, path:%s, get exception:%s", new Object[] { paramString, paramContext });
    }
  }
  
  public static String b()
  {
    Object localObject1 = a.c();
    if (((String)localObject1).startsWith(a.b())) {
      localObject1 = new File((String)localObject1).getParentFile().getParentFile().getParentFile().getAbsolutePath();
    } else {
      localObject1 = a.a();
    }
    try
    {
      localObject2 = new File((String)localObject1).getCanonicalPath();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      label56:
      int i;
      break label56;
    }
    localObject2 = k.c(a(), true);
    i = ((String)localObject2).indexOf((String)localObject1);
    if (i >= 0)
    {
      localObject1 = ((String)localObject2).substring(i + ((String)localObject1).length());
      if (((String)localObject1).startsWith("/"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("/sdcard");
        ((StringBuilder)localObject2).append((String)localObject1);
        return ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/");
      ((StringBuilder)localObject2).append((String)localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public static String b(String paramString)
  {
    if (af.c(paramString)) {
      return "";
    }
    try
    {
      str1 = new File(paramString).getCanonicalPath();
    }
    catch (Throwable localThrowable)
    {
      String str1;
      label25:
      int i;
      String str2;
      break label25;
    }
    str1 = paramString;
    i = -1;
    if (str1.startsWith(a.b())) {
      i = a.b().length();
    } else if (str1.startsWith(a.a())) {
      i = a.a().length();
    }
    if (i < 0) {
      return paramString;
    }
    str2 = paramString.substring(i);
    if (str2.startsWith("/"))
    {
      paramString = new StringBuilder();
      str1 = "/sdcard";
    }
    else
    {
      paramString = new StringBuilder();
      str1 = "/sdcard/";
    }
    paramString.append(str1);
    paramString.append(str2);
    return paramString.toString();
  }
  
  /* Error */
  private static BitmapFactory.Options c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 298	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore_0
    //   5: new 91	android/graphics/BitmapFactory$Options
    //   8: dup
    //   9: invokespecial 299	android/graphics/BitmapFactory$Options:<init>	()V
    //   12: astore_1
    //   13: aload_1
    //   14: iconst_1
    //   15: putfield 303	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   18: aload_0
    //   19: aconst_null
    //   20: aload_1
    //   21: invokestatic 308	com/tencent/mm/graphics/MMBitmapFactory:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   24: pop
    //   25: aload_0
    //   26: invokestatic 311	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   29: aload_1
    //   30: areturn
    //   31: astore_1
    //   32: aload_0
    //   33: astore_2
    //   34: goto +8 -> 42
    //   37: astore_0
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_0
    //   41: astore_1
    //   42: aload_2
    //   43: invokestatic 311	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   46: aload_1
    //   47: athrow
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: invokestatic 311	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_0
    //   57: goto -9 -> 48
    //   60: astore_1
    //   61: goto -11 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramString	String
    //   12	18	1	localOptions	BitmapFactory.Options
    //   31	1	1	localObject	Object
    //   41	6	1	str1	String
    //   60	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   33	10	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	25	31	finally
    //   0	5	37	finally
    //   0	5	56	java/io/FileNotFoundException
    //   5	25	60	java/io/FileNotFoundException
  }
  
  private static int d(String paramString)
  {
    if (af.c(paramString))
    {
      o.e("Luggage.AndroidMediaUtil", "filepath is null or nil");
      return 0;
    }
    if (!k.h(paramString))
    {
      o.e("Luggage.AndroidMediaUtil", "file not exist:[%s]", new Object[] { paramString });
      return 0;
    }
    return e.b(paramString).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rc.b
 * JD-Core Version:    0.7.0.1
 */