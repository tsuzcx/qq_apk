package com.tencent.luggage.wxa.nl;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.fo.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Locale;

public class g
{
  private static final g a = new g();
  private static final Uri b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://");
    localStringBuilder.append(a.a);
    localStringBuilder.append("/");
    localStringBuilder.append("DevPkgLaunchExtInfo");
    b = Uri.parse(localStringBuilder.toString());
  }
  
  public static g a()
  {
    return a;
  }
  
  public String a(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    Cursor localCursor = r.a().getContentResolver().query(b, null, String.format(Locale.US, "%s=? And %s=?", new Object[] { "appId", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null);
    if (localCursor == null) {
      return null;
    }
    paramString = localObject;
    if (!localCursor.isClosed())
    {
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        paramString = new f();
        paramString.a(localCursor);
      }
    }
    localCursor.close();
    if (paramString != null) {
      return paramString.d;
    }
    return "";
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_VERSION_TYPE", Integer.valueOf(paramInt));
      localContentValues.put("CONTENT_KEY_EXT_INFO", paramString2);
      r.a().getContentResolver().insert(b, localContentValues);
      return true;
    }
    catch (Exception paramString1)
    {
      label53:
      break label53;
    }
    o.b("Luggage.DevPkgLaunchExtInfoContentResolver", "setExtInfo fail");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.g
 * JD-Core Version:    0.7.0.1
 */