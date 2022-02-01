package com.tencent.luggage.wxa.nl;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fo.a;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qz.r;
import java.util.Locale;

public class o
{
  private static final o a = new o();
  private static final Uri b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://");
    localStringBuilder.append(a.a);
    localStringBuilder.append("/");
    localStringBuilder.append("LaunchWxaAppPBTable");
    b = Uri.parse(localStringBuilder.toString());
  }
  
  public static o a()
  {
    return a;
  }
  
  @Nullable
  public fb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        Cursor localCursor = r.a().getContentResolver().query(b, null, String.format(Locale.US, "%s=?", new Object[] { "appId" }), new String[] { paramString }, null, null);
        if (localCursor == null) {
          return null;
        }
        if ((!localCursor.isClosed()) && (localCursor.moveToFirst()))
        {
          Object localObject1 = new m();
          ((m)localObject1).a(localCursor);
          localCursor.close();
          if (localObject1 == null) {
            return null;
          }
          localObject1 = ((m)localObject1).c;
          return localObject1;
        }
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.LaunchWxaPBContentResolver", "getLaunchPB by appId[%s], get exception:%s", new Object[] { paramString, localSQLiteDatabaseCorruptException });
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  public boolean a(String paramString, fb paramfb)
  {
    if (paramfb != null) {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    try
    {
      paramfb = paramfb.b();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_SYNC_PROTO", paramfb);
      localContentValues.put("CONTENT_KEY_APPID", paramString);
      r.a().getContentResolver().insert(b, localContentValues);
      return true;
    }
    catch (Exception paramString)
    {
      label56:
      break label56;
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.LaunchWxaPBContentResolver", "setLaunchPB insert failed");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.o
 * JD-Core Version:    0.7.0.1
 */