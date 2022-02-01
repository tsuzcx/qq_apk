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
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    if (paramContext == null) {
      return false;
    }
    paramIntent = paramContext.resolveActivity(paramIntent, 0);
    if (paramIntent == null) {
      return false;
    }
    paramIntent = paramIntent.activityInfo.packageName;
    try
    {
      paramContext = paramContext.getPackageInfo(paramIntent, 64).signatures;
      if (paramContext == null) {
        return false;
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
    return false;
  }
  
  public static a.a c(Context paramContext)
  {
    Object localObject4 = new Intent("com.sina.weibo.action.sdkidentity");
    ((Intent)localObject4).addCategory("android.intent.category.DEFAULT");
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramContext != null)
    {
      localObject4 = paramContext.getPackageManager().queryIntentServices((Intent)localObject4, 0);
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = localObject3;
        if (!((List)localObject4).isEmpty())
        {
          localObject4 = ((List)localObject4).iterator();
          String str;
          do
          {
            do
            {
              localObject1 = localObject2;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject1 = (ResolveInfo)((Iterator)localObject4).next();
            } while ((((ResolveInfo)localObject1).serviceInfo == null) || (((ResolveInfo)localObject1).serviceInfo.applicationInfo == null) || (TextUtils.isEmpty(((ResolveInfo)localObject1).serviceInfo.packageName)));
            str = ((ResolveInfo)localObject1).serviceInfo.packageName;
            localObject1 = d(paramContext, str);
            localObject3 = localObject2;
            if (localObject1 != null) {
              localObject3 = localObject1;
            }
            localObject1 = localObject3;
            if ("com.sina.weibo".equals(str)) {
              break;
            }
            localObject2 = localObject3;
          } while (!"com.sina.weibog3".equals(str));
          localObject1 = localObject3;
        }
      }
    }
    return localObject1;
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
      paramContext = new JSONObject(((StringBuilder)localObject).toString());
      localObject = new a.a();
      ((a.a)localObject).an = paramContext.optInt("support_api", -1);
      ((a.a)localObject).am = paramContext.optString("authActivityName", null);
      ((a.a)localObject).packageName = paramString;
      return localObject;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */