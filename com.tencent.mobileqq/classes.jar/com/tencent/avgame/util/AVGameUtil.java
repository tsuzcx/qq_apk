package com.tencent.avgame.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameLobbyConfBean;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.avgame.gamelogic.data.Player;>;

public final class AVGameUtil
{
  public static int a()
  {
    int i = AvGameConfigUtil.a().c();
    if (i != 0)
    {
      if (i != 1) {
        return 0;
      }
      return 1;
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      label7:
      break label7;
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Throwable paramString) {}
    return 0L;
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AvGameResDownloadUtil.c());
    ((StringBuilder)localObject1).append(paramString);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getImageBitmap suc: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("AVGameUtils", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = GlobalImageCache.a.get(localObject1);
      if ((localObject2 != null) && ((localObject2 instanceof Bitmap))) {
        return (Bitmap)localObject2;
      }
      try
      {
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inScaled = false;
        localObject2 = BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
        GlobalImageCache.a.put(localObject1, localObject2);
        return localObject2;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getBitmap error ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.i("AVGameUtils", 1, ((StringBuilder)localObject2).toString());
        return null;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getImageBitmap fail: ");
      paramString.append(localThrowable);
      QLog.d("AVGameUtils", 2, paramString.toString());
    }
    return null;
  }
  
  public static Drawable a(String paramString1, String paramString2, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cjAdLogo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    paramString1 = a(localStringBuilder.toString());
    if (paramString1 != null) {
      return new BitmapDrawable(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new StringBuilder();
      paramString1.append("getCJDrawable no local, get net ");
      paramString1.append(paramString2);
      QLog.d("AVGameUtils", 2, paramString1.toString());
      paramString1 = URLDrawable.getDrawable(paramString2, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a);
      if (paramURLDrawableListener != null) {
        paramString1.setURLDrawableListener(paramURLDrawableListener);
      }
      return paramString1;
    }
    return null;
  }
  
  public static StateListDrawable a(Resources paramResources, String paramString1, String paramString2)
  {
    paramString2 = a(paramString1);
    Object localObject = null;
    if (paramString2 != null) {
      paramString2 = new BitmapDrawable(paramResources, paramString2);
    } else {
      paramString2 = null;
    }
    Bitmap localBitmap = a(paramString1);
    paramString1 = localObject;
    if (localBitmap != null) {
      paramString1 = new BitmapDrawable(paramResources, localBitmap);
    }
    paramResources = new StateListDrawable();
    paramResources.addState(new int[] { 16842919 }, paramString1);
    paramResources.addState(new int[] { 16842908 }, paramString2);
    paramResources.addState(new int[] { 16842910 }, paramString2);
    paramResources.addState(new int[0], paramString2);
    return paramResources;
  }
  
  public static FontStyleConfig a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameUtils", 2, "parseFontConfig ");
    }
    String str = FileUtils.readFileContent(new File(AvGameResDownloadUtil.e()));
    FontStyleConfig localFontStyleConfig = new FontStyleConfig();
    localFontStyleConfig.a(str);
    return localFontStyleConfig;
  }
  
  public static String a(long paramLong)
  {
    String str = String.valueOf(paramLong);
    Object localObject = str;
    if (!TextUtils.isEmpty(str))
    {
      localObject = str;
      if (str.length() < 9)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("000000000".substring(0, 9 - str.length()));
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static String a(Context paramContext, List<Player> paramList)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramList != null)
    {
      localObject2 = paramList.iterator();
      StringBuilder localStringBuilder;
      for (paramList = (List<Player>)localObject1; ((Iterator)localObject2).hasNext(); paramList = localStringBuilder.toString())
      {
        localObject1 = (Player)((Iterator)localObject2).next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramList);
        localStringBuilder.append(((Player)localObject1).nick);
        localStringBuilder.append(",");
      }
      localObject1 = paramList;
      if (paramList.length() > 0) {
        localObject1 = paramList.substring(0, paramList.length() - 1);
      }
      localObject2 = String.format(paramContext.getString(2131690391), new Object[] { localObject1 });
    }
    return localObject2;
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity)
  {
    String str = paramActivity.getPackageName();
    if (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      Intent localIntent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent3.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent3.putExtra("extra_pkgname", str);
      try
      {
        paramActivity.startActivity(localIntent3);
        bool1 = true;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("openPermissionActivity e = ");
            localStringBuilder.append(localException3);
            QLog.e("AVGameUtils", 2, localStringBuilder.toString());
          }
          bool1 = false;
        }
      }
      j = 1;
      break label116;
    }
    StringBuilder localStringBuilder;
    boolean bool1 = false;
    int j = 0;
    label116:
    boolean bool2 = bool1;
    int i = j;
    if (!bool1)
    {
      bool2 = bool1;
      i = j;
      if (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
      {
        Intent localIntent4 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        localIntent4.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        localIntent4.putExtra("packageName", str);
        try
        {
          paramActivity.startActivity(localIntent4);
          bool2 = true;
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("openPermissionActivity e = ");
              localStringBuilder.append(localException4);
              QLog.e("AVGameUtils", 2, localStringBuilder.toString());
            }
            bool2 = false;
          }
        }
        i = 2;
      }
    }
    bool1 = bool2;
    j = i;
    if (!bool2)
    {
      bool1 = bool2;
      j = i;
      if (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
      {
        i = 3;
        Intent localIntent5 = new Intent();
        localIntent5.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        localIntent5.addFlags(268435456);
        try
        {
          paramActivity.startActivity(localIntent5);
          bool2 = true;
        }
        catch (Exception localException5)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("openPermissionActivity e = ");
            localStringBuilder.append(localException5);
            QLog.e("AVGameUtils", 2, localStringBuilder.toString());
          }
          bool2 = false;
        }
        bool1 = bool2;
        j = i;
        if (!bool2)
        {
          Intent localIntent6 = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
          try
          {
            paramActivity.startActivity(localIntent6);
            bool1 = true;
            j = i;
          }
          catch (Exception localException6)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("openPermissionActivity e = ");
              localStringBuilder.append(localException6);
              QLog.e("AVGameUtils", 2, localStringBuilder.toString());
            }
            bool1 = false;
            j = i;
          }
        }
      }
    }
    bool2 = bool1;
    Object localObject;
    if (!bool1)
    {
      j = 4;
      localObject = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      try
      {
        ((Intent)localObject).setData(Uri.fromParts("package", str, null));
        paramActivity.startActivity((Intent)localObject);
        bool2 = true;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("openPermissionActivity e = ");
          ((StringBuilder)localObject).append(localException1);
          QLog.e("AVGameUtils", 2, ((StringBuilder)localObject).toString());
        }
        bool2 = false;
      }
    }
    bool1 = bool2;
    i = j;
    if (!bool2)
    {
      bool1 = bool2;
      i = j;
      if (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))
      {
        i = 5;
        Intent localIntent1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        try
        {
          paramActivity.startActivity(localIntent1);
          bool1 = true;
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("openPermissionActivity e = ");
            ((StringBuilder)localObject).append(localException2);
            QLog.e("AVGameUtils", 2, ((StringBuilder)localObject).toString());
          }
          bool1 = false;
        }
      }
    }
    if (!bool1)
    {
      i = 6;
      Intent localIntent2 = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent2.putExtra("hide_left_button", false);
      localIntent2.putExtra("show_right_close_button", false);
      localIntent2.putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.b(paramActivity, "https://view.yutu.qq.com/yutu/activity/3857.html", 524288L, localIntent2, false, -1);
    }
    paramActivity = new StringBuilder();
    paramActivity.append("请求相机权限, which[");
    paramActivity.append(i);
    paramActivity.append("], openSuccess[");
    paramActivity.append(bool1);
    paramActivity.append("]");
    QLog.w("AVGameUtils", 1, paramActivity.toString());
  }
  
  public static void a(String paramString, Activity paramActivity)
  {
    AVGameHandler.a().b().post(new AVGameUtil.1(paramActivity, paramString));
  }
  
  public static boolean a(Activity paramActivity)
  {
    return (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR")) || (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC")) || (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) || (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  public static int b()
  {
    int j = AvGameConfigUtil.a().d();
    if (j != 0)
    {
      int i = 1;
      if (j != 1)
      {
        i = 2;
        if (j != 2) {
          return 0;
        }
      }
      return i;
    }
    return 0;
  }
  
  public static int c()
  {
    return AvGameConfigUtil.a().a();
  }
  
  public static int d()
  {
    return AvGameConfigUtil.a().b();
  }
  
  public static int e()
  {
    AvGameLobbyConfBean localAvGameLobbyConfBean = AvGameConfigUtil.a();
    if (localAvGameLobbyConfBean == null) {
      return 0;
    }
    return localAvGameLobbyConfBean.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameUtil
 * JD-Core Version:    0.7.0.1
 */