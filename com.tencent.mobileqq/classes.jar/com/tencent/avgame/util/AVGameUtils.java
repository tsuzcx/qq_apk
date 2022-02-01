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
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
import com.tencent.avgame.ui.AVGameBackAction;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.AvGameLobbyConfProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class AVGameUtils
{
  public static int a()
  {
    AvGameLobbyConfBean localAvGameLobbyConfBean = AvGameLobbyConfProcessor.a();
    if (localAvGameLobbyConfBean == null) {
      return 0;
    }
    switch (localAvGameLobbyConfBean.c())
    {
    case 0: 
    default: 
      return 0;
    }
    return 1;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
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
  
  public static Intent a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if ((paramQQAppInterface == null) || (paramMessage == null) || (paramMessage.msgtype != -5008)) {}
    label399:
    label533:
    label536:
    label548:
    for (;;)
    {
      return null;
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if (!(paramQQAppInterface instanceof MessageForArkApp)) {}
      }
      for (MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramQQAppInterface;; localMessageForArkApp = null)
      {
        if ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null) || (!"com.tencent.avgame".equals(localMessageForArkApp.ark_app_message.appName)) || (!"invite".equals(localMessageForArkApp.ark_app_message.appView))) {
          break label548;
        }
        int j = paramMessage.istroop;
        String str2 = paramMessage.frienduin;
        label167:
        label187:
        QQAppInterface localQQAppInterface;
        Object localObject;
        try
        {
          paramQQAppInterface = new JSONObject(localMessageForArkApp.ark_app_message.metaList);
          if (!paramQQAppInterface.has("invite")) {
            break label332;
          }
          paramQQAppInterface = paramQQAppInterface.getJSONObject("invite");
          if ((paramQQAppInterface == null) || (!paramQQAppInterface.has("extra"))) {
            break label337;
          }
          paramQQAppInterface = paramQQAppInterface.getJSONObject("extra");
          if ((paramQQAppInterface == null) || (!paramQQAppInterface.has("jump_url"))) {
            break label342;
          }
          paramQQAppInterface = paramQQAppInterface.getString("jump_url");
          localQQAppInterface = paramQQAppInterface;
        }
        catch (Throwable paramQQAppInterface)
        {
          label249:
          String str3;
          for (;;)
          {
            String[] arrayOfString;
            int i;
            int k;
            label325:
            label332:
            label337:
            label342:
            if (QLog.isColorLevel()) {
              QLog.i("AVGameUtils", 2, "getAVGameIntentFromArkMessage", paramQQAppInterface);
            }
            localQQAppInterface = null;
            continue;
            paramQQAppInterface = null;
          }
          label374:
          if (!"uin".equals(str3)) {
            break label533;
          }
        }
        if ((localQQAppInterface != null) && (localQQAppInterface.startsWith("mqqapi://avgame/join_room")))
        {
          paramQQAppInterface = localQQAppInterface.split("\\?");
          String str1;
          if (paramQQAppInterface.length == 2)
          {
            paramQQAppInterface = paramQQAppInterface[1];
            if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 0)) {
              break label536;
            }
            arrayOfString = paramQQAppInterface.split("&");
            i = 0;
            localObject = null;
            paramQQAppInterface = null;
            if (i >= arrayOfString.length) {
              break label399;
            }
            str1 = arrayOfString[i];
            if (str1.split("=").length != 2) {
              break label533;
            }
            k = str1.indexOf("=");
            str3 = str1.substring(0, k);
            str1 = str1.substring(k + 1);
            if ((!"room".equals(str3)) || (!TextUtils.isDigitsOnly(str1))) {
              break label374;
            }
            paramQQAppInterface = str1;
          }
          for (;;)
          {
            i += 1;
            break label249;
            paramQQAppInterface = null;
            break;
            paramQQAppInterface = null;
            break label167;
            paramQQAppInterface = null;
            break label187;
            if (!TextUtils.isDigitsOnly(str1)) {
              break label533;
            }
            localObject = str1;
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("AVGameUtils", 4, "getAVGameIntentFromArkMessage, room[" + paramQQAppInterface + "], uin[" + localObject + "], jump[" + localQQAppInterface + "], json[" + localMessageForArkApp.ark_app_message.metaList + "]");
          }
          if ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(localObject))) {
            break;
          }
          paramQQAppInterface = AvGameLoadingActivity.a(false, j, str2, paramQQAppInterface, 0, null);
          paramQQAppInterface.setClass(BaseApplicationImpl.getApplication(), PublicFragmentActivity.class);
          paramQQAppInterface.addFlags(268435456);
          paramQQAppInterface.putExtra("public_fragment_class", AvGameLoadingActivity.class.getName());
          AVGameBackAction.a(paramQQAppInterface, paramMessage);
          return paramQQAppInterface;
          break label325;
          localObject = null;
          paramQQAppInterface = null;
        }
      }
    }
  }
  
  public static Bitmap a(String paramString)
  {
    String str = AvGameResDownloadManager.c() + paramString;
    if (FileUtils.b(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameUtils", 2, "getImageBitmap suc: " + str);
      }
      Object localObject = GlobalImageCache.a.get(str);
      if ((localObject != null) && ((localObject instanceof Bitmap))) {
        return (Bitmap)localObject;
      }
      try
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inScaled = false;
        localObject = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
        GlobalImageCache.a.put(str, localObject);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("AVGameUtils", 1, "getBitmap error " + paramString + localThrowable.getMessage());
        return null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameUtils", 2, "getImageBitmap fail: " + localThrowable);
    }
    return null;
  }
  
  public static Drawable a(String paramString1, String paramString2, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString1 = a("cjAdLogo" + File.separator + paramString1);
    if (paramString1 != null) {
      paramString1 = new BitmapDrawable(paramString1);
    }
    do
    {
      return paramString1;
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
      QLog.d("AVGameUtils", 2, "getCJDrawable no local, get net " + paramString2);
      paramString2 = URLDrawable.getDrawable(paramString2, URLDrawableHelper.TRANSPARENT, URLDrawableHelper.TRANSPARENT);
      paramString1 = paramString2;
    } while (paramURLDrawableListener == null);
    paramString2.setURLDrawableListener(paramURLDrawableListener);
    return paramString2;
    return null;
  }
  
  public static StateListDrawable a(Resources paramResources, String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString2 = a(paramString1);
    if (paramString2 != null) {}
    for (paramString2 = new BitmapDrawable(paramResources, paramString2);; paramString2 = null)
    {
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
  }
  
  public static FontStyleConfig a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameUtils", 2, "parseFontConfig ");
    }
    String str = FileUtils.a(new File(AvGameResDownloadManager.e()));
    FontStyleConfig localFontStyleConfig = new FontStyleConfig();
    localFontStyleConfig.a(str);
    return localFontStyleConfig;
  }
  
  public static String a(long paramLong)
  {
    String str2 = String.valueOf(paramLong);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.length() < 9) {
        str1 = "000000000".substring(0, 9 - str2.length()) + str2;
      }
    }
    return str1;
  }
  
  public static String a(Context paramContext, List<Player> paramList)
  {
    Object localObject = "";
    if (paramList != null)
    {
      localObject = paramList.iterator();
      Player localPlayer;
      for (paramList = ""; ((Iterator)localObject).hasNext(); paramList = paramList + localPlayer.nick + ",") {
        localPlayer = (Player)((Iterator)localObject).next();
      }
      localObject = paramList;
      if (paramList.length() > 0) {
        localObject = paramList.substring(0, paramList.length() - 1);
      }
      localObject = String.format(paramContext.getString(2131690467), new Object[] { localObject });
    }
    return localObject;
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  public static void a(Activity paramActivity)
  {
    Object localObject = paramActivity.getPackageName();
    Intent localIntent;
    if (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    label666:
    for (;;)
    {
      try
      {
        paramActivity.startActivity(localIntent);
        j = 1;
        bool1 = true;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException3);
        j = 1;
        bool1 = false;
        continue;
      }
      int i = j;
      boolean bool2 = bool1;
      if (!bool1)
      {
        i = j;
        bool2 = bool1;
        if (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          localIntent.putExtra("packageName", (String)localObject);
        }
      }
      try
      {
        paramActivity.startActivity(localIntent);
        i = 2;
        bool2 = true;
      }
      catch (Exception localException4)
      {
        if (!QLog.isColorLevel()) {
          break label497;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException4);
        i = 2;
        bool2 = false;
        continue;
      }
      int j = i;
      boolean bool1 = bool2;
      if (!bool2)
      {
        j = i;
        bool1 = bool2;
        if (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
        {
          i = 3;
          localIntent = new Intent();
          localIntent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
          localIntent.addFlags(268435456);
        }
      }
      try
      {
        paramActivity.startActivity(localIntent);
        bool2 = true;
      }
      catch (Exception localException5)
      {
        if (!QLog.isColorLevel()) {
          break label540;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException5);
        bool2 = false;
        continue;
      }
      j = i;
      bool1 = bool2;
      if (!bool2) {
        localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
      }
      try
      {
        paramActivity.startActivity(localIntent);
        bool1 = true;
        j = i;
      }
      catch (Exception localException6)
      {
        if (!QLog.isColorLevel()) {
          break label581;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException6);
        bool1 = false;
        j = i;
        continue;
      }
      i = j;
      bool2 = bool1;
      if (!bool1) {
        localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      }
      try
      {
        localIntent.setData(Uri.fromParts("package", (String)localObject, null));
        paramActivity.startActivity(localIntent);
        i = 4;
        bool2 = true;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          break label623;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException1);
        i = 4;
        bool2 = false;
        continue;
        bool1 = bool2;
        continue;
      }
      if ((!bool2) && (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
      {
        i = 5;
        localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        try
        {
          paramActivity.startActivity((Intent)localObject);
          bool1 = true;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label666;
          }
          QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException2);
          bool1 = false;
          continue;
        }
        if (!bool1)
        {
          localObject = new Intent(paramActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("hide_left_button", false);
          ((Intent)localObject).putExtra("show_right_close_button", false);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, "https://view.yutu.qq.com/yutu/activity/3857.html", 524288L, (Intent)localObject, false, -1);
          i = 6;
        }
        QLog.w("AVGameUtils", 1, "请求相机权限, which[" + i + "], openSuccess[" + bool1 + "]");
        return;
      }
      label497:
      j = 0;
      label540:
      label581:
      label623:
      bool1 = false;
    }
  }
  
  public static void a(String paramString, Activity paramActivity)
  {
    AVGameHandler.a().b().post(new AVGameUtils.1(paramActivity, paramString));
  }
  
  public static boolean a(Activity paramActivity)
  {
    return (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR")) || (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC")) || (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) || (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  public static int b()
  {
    AvGameLobbyConfBean localAvGameLobbyConfBean = AvGameLobbyConfProcessor.a();
    if (localAvGameLobbyConfBean == null) {
      return 0;
    }
    switch (localAvGameLobbyConfBean.d())
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int c()
  {
    return AvGameLobbyConfProcessor.a().a();
  }
  
  public static int d()
  {
    return AvGameLobbyConfProcessor.a().b();
  }
  
  public static int e()
  {
    AvGameLobbyConfBean localAvGameLobbyConfBean = AvGameLobbyConfProcessor.a();
    if (localAvGameLobbyConfBean == null) {
      return 0;
    }
    return localAvGameLobbyConfBean.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameUtils
 * JD-Core Version:    0.7.0.1
 */