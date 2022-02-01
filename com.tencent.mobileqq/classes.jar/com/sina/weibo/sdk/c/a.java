package com.sina.weibo.sdk.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        continue;
      }
      paramIntent = paramContext.resolveActivity(paramIntent, 0);
      if (paramIntent == null) {
        continue;
      }
      paramIntent = paramIntent.activityInfo.packageName;
      try
      {
        paramContext = paramContext.getPackageInfo(paramIntent, 64).signatures;
        if (paramContext == null) {
          continue;
        }
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = "18da2bf10352443a00a5e046d9fca6bd".equals(d.a(paramContext[i].toByteArray()));
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static a.a c(Context paramContext)
  {
    Object localObject3 = new Intent("com.sina.weibo.action.sdkidentity");
    ((Intent)localObject3).addCategory("android.intent.category.DEFAULT");
    Iterator localIterator = null;
    Object localObject1 = null;
    Object localObject2 = localIterator;
    if (paramContext != null)
    {
      localObject3 = paramContext.getPackageManager().queryIntentServices((Intent)localObject3, 0);
      localObject2 = localIterator;
      if (localObject3 != null)
      {
        localObject2 = localIterator;
        if (!((List)localObject3).isEmpty()) {
          localIterator = ((List)localObject3).iterator();
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        localObject2 = (ResolveInfo)localIterator.next();
        if ((((ResolveInfo)localObject2).serviceInfo == null) || (((ResolveInfo)localObject2).serviceInfo.applicationInfo == null) || (TextUtils.isEmpty(((ResolveInfo)localObject2).serviceInfo.packageName))) {
          continue;
        }
        localObject3 = ((ResolveInfo)localObject2).serviceInfo.packageName;
        localObject2 = d(paramContext, (String)localObject3);
        if (localObject2 == null) {
          break label165;
        }
        localObject1 = localObject2;
      }
      label165:
      while (("com.sina.weibo".equals(localObject3)) || ("com.sina.weibog3".equals(localObject3)))
      {
        localObject2 = localObject1;
        return localObject2;
      }
    }
  }
  
  private static a.a d(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2).getAssets().open("weibo_for_sdk.json");
      Object localObject = new StringBuilder();
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = paramContext.read(arrayOfByte, 0, 4096);
        if (i == -1) {
          break;
        }
        ((StringBuilder)localObject).append(new String(arrayOfByte, 0, i));
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return null;
      paramContext = new JSONObject(((StringBuilder)localObject).toString());
      localObject = new a.a();
      ((a.a)localObject).an = paramContext.optInt("support_api", -1);
      ((a.a)localObject).am = paramContext.optString("authActivityName", null);
      ((a.a)localObject).packageName = paramString;
      return localObject;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */