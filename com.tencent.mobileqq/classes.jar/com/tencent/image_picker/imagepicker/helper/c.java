package com.tencent.image_picker.imagepicker.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import androidx.annotation.Nullable;
import com.tencent.image_picker.imagepicker.features.f;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class c
{
  public static File a(f paramf)
  {
    String str = paramf.a();
    if (paramf.b()) {
      paramf = new File(str);
    } else {
      paramf = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), str);
    }
    if ((!paramf.exists()) && (!paramf.mkdirs()))
    {
      paramf = d.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Oops! Failed create ");
      localStringBuilder.append(str);
      paramf.a(localStringBuilder.toString());
      return null;
    }
    str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IMG_");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    try
    {
      paramf = File.createTempFile(str, ".jpg", paramf);
      return paramf;
    }
    catch (IOException paramf)
    {
      label147:
      break label147;
    }
    paramf = d.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Oops! Failed create ");
    localStringBuilder.append(str);
    localStringBuilder.append(" file");
    paramf.a(localStringBuilder.toString());
    return null;
  }
  
  public static void a(Context paramContext, Intent paramIntent, Uri paramUri)
  {
    paramIntent = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).iterator();
    while (paramIntent.hasNext()) {
      paramContext.grantUriPermission(((ResolveInfo)paramIntent.next()).activityInfo.packageName, paramUri, 3);
    }
  }
  
  public static void a(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 3);
  }
  
  public static boolean a(com.tencent.luggage.wxa.az.b paramb)
  {
    return paramb.a().substring(paramb.a().lastIndexOf(".") + 1, paramb.a().length()).equalsIgnoreCase("gif");
  }
  
  public static boolean a(@Nullable String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString.contains(File.separator)) {
      str = paramString.substring(paramString.lastIndexOf(File.separator) + 1);
    }
    return str;
  }
  
  public static boolean b(com.tencent.luggage.wxa.az.b paramb)
  {
    try
    {
      String str = URLConnection.guessContentTypeFromName(paramb.a());
      if (str != null)
      {
        boolean bool = str.startsWith("video");
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.ry.b.a("ImagePickerUtils", "isVideoFormat fail. path:%s exception:%s", new Object[] { paramb.a(), localException });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.helper.c
 * JD-Core Version:    0.7.0.1
 */