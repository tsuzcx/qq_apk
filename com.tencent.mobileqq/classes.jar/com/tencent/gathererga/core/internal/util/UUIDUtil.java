package com.tencent.gathererga.core.internal.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;
import org.json.JSONObject;

public class UUIDUtil
{
  public static final UUIDUtil a = new UUIDUtil();
  private volatile Boolean b = Boolean.valueOf(false);
  private volatile JSONObject c = null;
  
  private String a(JSONObject paramJSONObject, String paramString, long paramLong)
  {
    if ((a(paramJSONObject)) && (paramLong != -2147483648L) && (!TextUtils.isEmpty(paramString)))
    {
      paramJSONObject = String.format("%s%d%d%s", new Object[] { paramString, Integer.valueOf(paramJSONObject.optInt("version")), Long.valueOf(paramLong), paramJSONObject.optString("salt") });
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = Md5Util.a(paramJSONObject.toLowerCase());
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramString = paramJSONObject.toUpperCase();
          paramJSONObject = paramString;
          if (!TextUtils.isEmpty(paramString)) {
            return paramJSONObject;
          }
        }
      }
    }
    paramJSONObject = null;
    return paramJSONObject;
  }
  
  private JSONObject a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        return new JSONObject(paramString);
      }
      GLog.b("TangramUUID getSettings config is empty");
      return null;
    }
    catch (Exception paramString)
    {
      GLog.b("TangramUUID getUUIDSettings AdJson toObject failed", paramString);
    }
    return null;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (paramJSONObject.optInt("version") > 0) && (!TextUtils.isEmpty(paramJSONObject.optString("salt"))) && (paramJSONObject.optInt("maxLength") > 0);
  }
  
  private boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      if ((c(paramJSONObject1)) && (UUID.fromString(paramJSONObject1.optString("u")) != null) && (a(paramJSONObject2)) && (paramJSONObject1.optInt("v") == paramJSONObject2.optInt("version")))
      {
        paramJSONObject2 = a(paramJSONObject2, paramJSONObject1.optString("u"), paramJSONObject1.optLong("t"));
        boolean bool = TextUtils.equals(paramJSONObject1.optString("m"), paramJSONObject2);
        return bool;
      }
    }
    catch (Exception paramJSONObject1)
    {
      GLog.d(paramJSONObject1.getMessage());
    }
    return false;
  }
  
  private String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (Environment.getExternalStorageDirectory() == null)) {
      return null;
    }
    return new File(Environment.getExternalStorageDirectory(), paramString).getAbsolutePath();
  }
  
  private JSONObject b(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (a(paramJSONObject))) {
      try
      {
        UUID localUUID = UUID.randomUUID();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("v", paramJSONObject.optInt("version"));
        localJSONObject.put("u", localUUID.toString());
        localJSONObject.put("t", System.currentTimeMillis());
        localJSONObject.put("m", a(paramJSONObject, localJSONObject.optString("u"), localJSONObject.optLong("t")));
        return localJSONObject;
      }
      catch (Throwable paramJSONObject)
      {
        GLog.b("TangramUUID createUUID json exception.", paramJSONObject);
        return null;
      }
    }
    GLog.d("TangramUUID createUUID settings invalid");
    return null;
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (paramJSONObject.optInt("v") > 0) && (paramJSONObject.optLong("t") > 0L) && (!TextUtils.isEmpty(paramJSONObject.optString("u"))) && (!TextUtils.isEmpty(paramJSONObject.optString("m")));
  }
  
  public JSONObject a(Context paramContext, String paramString)
  {
    if (this.b.booleanValue()) {
      GLog.b("TangramUUID getUUID already write file");
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (this.b.booleanValue())
        {
          GLog.b("TangramUUID getUUID already write file");
        }
        else
        {
          JSONObject localJSONObject2 = a(paramString);
          if (!a(localJSONObject2))
          {
            GLog.b("TangramUUID getUUID failed. settings is empty or invalid");
          }
          else if (!PermissionUtil.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
          {
            GLog.b("TangramUUID getUUID failed. FAILED_WRITE_EXTERNAL_STORAGE");
          }
          else if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted"))
          {
            GLog.b("TangramUUID getUUID failed. FAILED_EXTERNAL_STORAGE_STATE");
          }
          else
          {
            AdFile localAdFile1 = new AdFile(b("Tencent/ams/cache"), "meta.dat", "UTF-8", true);
            AdFile localAdFile2 = new AdFile(b("Android/data/com.tencent.ams/cache"), "meta.dat", "UTF-8", true);
            if (localAdFile1.a())
            {
              boolean bool = localAdFile2.a();
              if (bool)
              {
                try
                {
                  int i = localJSONObject2.optInt("maxLength");
                  String str1 = localAdFile1.a(i);
                  localObject2 = null;
                  if (str1 == null) {
                    break label415;
                  }
                  paramContext = new JSONObject(str1);
                  String str2 = localAdFile2.a(i);
                  if (str2 == null) {
                    break label420;
                  }
                  paramString = new JSONObject(str2);
                  JSONObject localJSONObject1 = b(localJSONObject2);
                  if (localJSONObject1 == null) {
                    break label425;
                  }
                  localObject1 = localJSONObject1.toString();
                  if (a(paramContext, localJSONObject2))
                  {
                    GLog.b("TangramUUID getUUID from 正式文件");
                    paramString = str1;
                    localObject1 = paramContext;
                    paramContext = paramString;
                    paramString = (String)localObject1;
                  }
                  else if (a(paramString, localJSONObject2))
                  {
                    GLog.b("TangramUUID getUUID from 备份文件");
                    paramContext = str2;
                  }
                  else
                  {
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      break label431;
                    }
                    GLog.b("TangramUUID getUUID from 生成新id");
                    paramString = localJSONObject1;
                    paramContext = (Context)localObject1;
                  }
                  if ((localAdFile1.a(paramContext)) && (localAdFile2.a(paramContext)))
                  {
                    this.c = paramString;
                    GLog.b("TangramUUID 正式文件和备份文件写入成功");
                  }
                  this.b = Boolean.valueOf(true);
                  localAdFile1.b();
                  localAdFile2.b();
                }
                catch (Throwable paramContext)
                {
                  GLog.b("TangramUUID getUUID exception.", paramContext);
                }
                continue;
              }
            }
            localAdFile1.b();
            localAdFile2.b();
            GLog.b("TangramUUID getUUID failed. FAILED_FILE_LOCK");
          }
        }
        return this.c;
      }
      finally {}
      label415:
      paramContext = null;
      continue;
      label420:
      paramString = null;
      continue;
      label425:
      Object localObject1 = null;
      continue;
      label431:
      paramContext = null;
      paramString = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.UUIDUtil
 * JD-Core Version:    0.7.0.1
 */