package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.smallscreen.config.SmallScreenConfigParser;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import jos;
import mqq.app.MobileQQ;

public class SmallScreenUtils
{
  public static final String[] a = { "vivo Y51A", "2014011" };
  static String[] b = { "com.qzone.preview.BasePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.QZoneVideoFloatActivity", "com.tencent.mobileqq.activity.FriendProfileImageActivity", "com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity", "com.tencent.mobileqq.activity.photo.PhotoPreviewActivity", "com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity", "com.tencent.av.gaudio.GaInviteDialogActivity", "com.tencent.av.ui.MultiIncomingCallsActivity", "com.tencent.av.ui.VideoInviteActivity", "com.tencent.mobileqq.activity.selectmember.SelectMemberActivity", "cooperation.qzone.QzonePicturePluginProxyActivity", "com.tencent.av.utils.PopupDialog" };
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return 2131034261;
    case 1: 
      return 2131034258;
    case 2: 
      return 2131034259;
    case 3: 
      return 2131034257;
    case 4: 
      return 2131034256;
    case 5: 
      return 2131034255;
    case 6: 
      return 2131034263;
    case 7: 
      return 2131034264;
    case 8: 
      return 2131034262;
    }
    return 2131034260;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a(paramString);
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      int i = localSharedPreferences.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "getPrefShowDialog result = " + i);
      }
      return i;
    }
  }
  
  static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("com.tencent.av.smallscreen" + paramString, 0);
  }
  
  static SmallScreenConfigParser a()
  {
    Object localObject = ConfigInfo.instance();
    if (localObject != null) {}
    for (localObject = ((ConfigInfo)localObject).getSharpConfigPayloadFromFile();; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new SmallScreenConfigParser((String)localObject);
        if (((SmallScreenConfigParser)localObject).a()) {}
      }
      while (!QLog.isColorLevel())
      {
        return null;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SmallScreenUtils", 2, "getSmallScreenConfigParser --> parseConfig fail");
        return localObject;
      }
      QLog.d("SmallScreenUtils", 2, "getSmallScreenConfigParser --> Can not get PlayLoad Config");
      return null;
      return localObject;
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      String str = "";
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        str = str + "WL_DEBUG ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
        i += 1;
      }
      QLog.d("SmallScreenUtils", 2, str);
    }
  }
  
  public static void a(Context paramContext)
  {
    QLog.d("SmallScreenUtils", 1, "avideo actionOff");
    Intent localIntent = new Intent(paramContext, SmallScreenService.class);
    try
    {
      paramContext.stopService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SmallScreenUtils", 2, "actionOff e = " + paramContext);
    }
  }
  
  public static void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.d;
    int j = paramSessionInfo.F;
    int k = paramSessionInfo.g;
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenUtils", 2, "reportActionOn SessionType = " + i);
      QLog.d("SmallScreenUtils", 2, "reportActionOn relationType = " + j);
      QLog.d("SmallScreenUtils", 2, "reportActionOn state = " + k);
    }
    if (paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b > 0) {
      if (paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.a > 0L) {
        paramSessionInfo = "0X8005A49";
      }
    }
    for (;;)
    {
      if ((paramSessionInfo != null) && (c(paramContext))) {
        ReportController.b(null, "CliOper", "", "", paramSessionInfo, paramSessionInfo, 0, 0, "", "", "", "");
      }
      return;
      if (paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b == 5)
      {
        paramSessionInfo = "0X8005A48";
      }
      else
      {
        paramSessionInfo = "0X8005A47";
        continue;
        switch (i)
        {
        }
        for (;;)
        {
          paramSessionInfo = null;
          break;
          switch (k)
          {
          case 2: 
          case 3: 
          default: 
            paramSessionInfo = null;
          }
          for (;;)
          {
            break;
            paramSessionInfo = "0X8005A44";
            continue;
            paramSessionInfo = "0X8005A43";
          }
          switch (k)
          {
          case 2: 
          case 3: 
          default: 
            paramSessionInfo = null;
          }
          for (;;)
          {
            break;
            paramSessionInfo = "0X80057DE";
            continue;
            paramSessionInfo = "0X80057DD";
          }
          switch (j)
          {
          default: 
            paramSessionInfo = null;
          }
          for (;;)
          {
            break;
            paramSessionInfo = "0X8005A46";
            continue;
            paramSessionInfo = "0X8005A45";
          }
          switch (j)
          {
          }
        }
        paramSessionInfo = "0X80057E0";
        continue;
        paramSessionInfo = "0X80057DF";
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("isResume", paramBoolean);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "sendHideSmallScreenBroadcast:" + paramBoolean);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    QLog.d("SmallScreenUtils", 1, "avideo actionOn isNeedStartDialog = " + paramBoolean1);
    Intent localIntent = new Intent(paramContext, SmallScreenService.class);
    try
    {
      paramContext.stopService(localIntent);
      paramContext.startService(localIntent);
      if (!b(BaseApplicationImpl.getContext())) {
        VideoNodeManager.a(32);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "actionOn isFloatWindowOpAllowed : " + c(paramContext) + ", isCalling : " + PhoneStatusTools.d(paramContext) + ", isHome : " + a(paramContext));
      }
      if ((!c(paramContext)) && (!PhoneStatusTools.d(paramContext)) && (!a(paramContext)))
      {
        if (paramBoolean1)
        {
          int i = a(paramString, paramBoolean2);
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenUtils", 2, "actionOn showDialog = " + i);
          }
          if (i < 5)
          {
            paramString = new Intent(paramContext, SmallScreenDialogActivity.class);
            paramString.addFlags(268435456);
            paramString.addFlags(536870912);
            paramString.addFlags(67108864);
            paramString.addFlags(131072);
            paramString.putExtra("is_video", paramBoolean2);
            paramContext.startActivity(paramString);
            if (QLog.isColorLevel()) {
              QLog.e("SmallScreenUtils", 2, "actionOn start SmallScreenDialogActivity");
            }
          }
        }
        ReportController.b(null, "CliOper", "", "", "0X80057D8", "0X80057D8", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "actionOn e = " + localException);
        }
      }
    }
  }
  
  public static void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    boolean bool;
    label49:
    label64:
    AnimationSet localAnimationSet;
    if (paramView != null)
    {
      localObject = paramView.getTag(2131362071);
      if (localObject != null) {
        break label190;
      }
      bool = false;
      if ((!paramBoolean2) || (!bool)) {
        break label236;
      }
      localObject = paramView.getTag(2131362070);
      if (localObject != null) {
        break label203;
      }
      bool = false;
      if ((paramView.getVisibility() != 0) || (!bool)) {
        break label216;
      }
      bool = true;
      if (bool != paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "startSetVisibleAnimation isVisible = " + paramBoolean1);
        }
        localAnimationSet = new AnimationSet(true);
        if (!paramBoolean1) {
          break label222;
        }
      }
    }
    label190:
    label203:
    label216:
    label222:
    for (Object localObject = new AlphaAnimation(0.0F, 1.0F);; localObject = new AlphaAnimation(1.0F, 0.0F))
    {
      ((AlphaAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setAnimationListener(new jos(paramView, paramBoolean1));
      paramView.startAnimation(localAnimationSet);
      paramView.setVisibility(0);
      paramView.setTag(2131362070, Boolean.valueOf(paramBoolean1));
      paramView.setTag(2131362071, Boolean.valueOf(paramBoolean2));
      return;
      bool = ((Boolean)localObject).booleanValue();
      break;
      bool = ((Boolean)localObject).booleanValue();
      break label49;
      bool = false;
      break label64;
    }
    label236:
    paramView.clearAnimation();
    if (paramBoolean1) {}
    for (;;)
    {
      paramView.setVisibility(i);
      break;
      i = 8;
    }
  }
  
  public static void a(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    paramString = "" + "getTrace[" + paramString + "]\n";
    int i = 1;
    while (i < j)
    {
      paramString = paramString + "ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
      i += 1;
    }
    QLog.d("SmallScreenUtils", 1, paramString);
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a(paramString).edit();
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      localEditor.putInt(paramString, paramInt).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "setPrefShowDialog value = " + paramInt);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (Build.MODEL.equals(str)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      bool2 = bool4;
      paramContext = paramContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.HOME"), 0);
      bool2 = bool4;
      localObject = ((ActivityManager)localObject).getRunningTasks(1);
      if (localObject != null)
      {
        bool2 = bool4;
        localObject = ((List)localObject).iterator();
        bool2 = bool1;
        bool3 = bool1;
        if (((Iterator)localObject).hasNext())
        {
          bool2 = bool1;
          String str = ((ActivityManager.RunningTaskInfo)((Iterator)localObject).next()).topActivity.getClassName();
          bool2 = bool1;
          Iterator localIterator = paramContext.iterator();
          do
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            bool2 = bool1;
            bool3 = ((ResolveInfo)localIterator.next()).activityInfo.name.equals(str);
          } while (!bool3);
          bool1 = true;
          for (;;)
          {
            if (bool1) {
              return bool1;
            }
            break;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      AVLog.e("SmallScreenUtils", paramContext.getMessage());
      return bool2;
    }
    return bool3;
  }
  
  @TargetApi(19)
  public static boolean a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    Object localObject = paramContext.getSystemService("appops");
    try
    {
      paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localObject, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramContext.getApplicationInfo().uid), paramContext.getPackageName() });
      if (paramContext == null) {
        break label239;
      }
      paramInt = ((Integer)paramContext).intValue();
    }
    catch (InvocationTargetException paramContext)
    {
      boolean bool3;
      if (!QLog.isColorLevel()) {
        break label200;
      }
      QLog.e("SmallScreenUtils", 2, "checkOp InvocationTargetException e.getCause() = " + paramContext.getCause());
      return false;
    }
    catch (Exception paramContext)
    {
      do
      {
        for (;;)
        {
          paramBoolean = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("SmallScreenUtils", 2, "checkOp e = " + paramContext);
          return true;
          paramInt = 0;
        }
      } while (!paramBoolean);
      if ((paramInt != 0) && (3 != paramInt)) {
        break label261;
      }
      paramBoolean = true;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("SmallScreenUtils", 2, "checkOp mode = " + paramInt);
      break label244;
      if ((paramInt != 0) && (3 != paramInt))
      {
        bool3 = Build.MANUFACTURER.equals("vivo");
        paramBoolean = bool2;
        if (!bool3) {}
      }
      else
      {
        paramBoolean = true;
      }
      break label259;
    }
    for (;;)
    {
      label200:
      label239:
      label244:
      return paramBoolean;
      label259:
      label261:
      paramBoolean = false;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    boolean bool2 = false;
    SmallScreenService.g = false;
    boolean bool1 = bool2;
    if (paramVideoAppInterface != null)
    {
      bool1 = bool2;
      if (paramVideoAppInterface.getApplication() != null)
      {
        bool1 = bool2;
        if (paramVideoAppInterface.getApp() != null)
        {
          bool1 = bool2;
          if (paramVideoAppInterface.a() != null)
          {
            bool1 = bool2;
            if (paramVideoAppInterface.a().a() != null)
            {
              Object localObject = paramVideoAppInterface.a().a();
              String str = ((SessionInfo)localObject).c;
              if ((((SessionInfo)localObject).d == 3) || (((SessionInfo)localObject).d == 4)) {
                str = ((SessionInfo)localObject).q;
              }
              localObject = new Intent("tencent.video.v2q.SmallScreenState");
              ((Intent)localObject).setPackage(paramVideoAppInterface.getApplication().getPackageName());
              ((Intent)localObject).putExtra("SmallScreenState", paramInt);
              ((Intent)localObject).putExtra("peerUin", str);
              paramVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
              if (QLog.isDevelopLevel()) {
                QLog.d("SmallScreenUtils", 2, "sendSmallScreenStateBroadcast:" + paramInt);
              }
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!ConfigSystemImpl.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreen --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreen result = " + bool1);
      }
      return bool1;
      SmallScreenConfigParser localSmallScreenConfigParser = a();
      bool1 = bool2;
      if (localSmallScreenConfigParser != null)
      {
        bool1 = bool2;
        if (localSmallScreenConfigParser.b > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    if ((Build.MANUFACTURER.equals("Xiaomi")) && ((Build.MODEL.equals("HM NOTE 1TD")) || (Build.MODEL.equals("MI 3C")) || (Build.MODEL.equals("HM NOTE 1S")))) {}
    for (int i = 1; (bool) && (i == 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean c()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!ConfigSystemImpl.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreenVideo --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreenVideo result = " + bool1);
      }
      return bool1;
      SmallScreenConfigParser localSmallScreenConfigParser = a();
      bool1 = bool2;
      if (localSmallScreenConfigParser != null)
      {
        bool1 = bool2;
        if (localSmallScreenConfigParser.d > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  @TargetApi(19)
  public static boolean c(Context paramContext)
  {
    boolean bool = false;
    if ((a(paramContext, 24, false)) || (a())) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!ConfigSystemImpl.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreenAudio --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreenAudio result = " + bool1);
      }
      return bool1;
      SmallScreenConfigParser localSmallScreenConfigParser = a();
      bool1 = bool2;
      if (localSmallScreenConfigParser != null)
      {
        bool1 = bool2;
        if (localSmallScreenConfigParser.e > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  @TargetApi(19)
  public static boolean d(Context paramContext)
  {
    return (a(paramContext, 24, true)) || (a());
  }
  
  public static boolean e()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {}
    boolean bool1;
    try
    {
      bool1 = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      if (Build.DEVICE.equals("mx2"))
      {
        bool2 = true;
        return bool2;
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            bool1 = false;
          }
          bool2 = bool3;
        } while (Build.DEVICE.equals("mx"));
        bool2 = bool3;
      } while (Build.DEVICE.equals("m9"));
    }
    return bool1;
  }
  
  public static boolean e(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    do
    {
      try
      {
        List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
        Object localObject = null;
        paramContext = localObject;
        if (localList == null) {
          continue;
        }
        paramContext = localObject;
        if (localList.size() <= 0) {
          continue;
        }
        paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        return false;
      }
      bool = ArrayUtils.a(b, paramContext.getClassName());
      return bool;
    } while (paramContext != null);
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    boolean bool2 = false;
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localRunningAppProcessInfo = null;
        paramContext = localRunningAppProcessInfo;
        if (localList != null)
        {
          paramContext = localRunningAppProcessInfo;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label260;
        }
        if (!QLog.isDevelopLevel()) {
          break label265;
        }
        QLog.d("SmallScreenUtils", 2, "WL_DEBUG isAppOnForeground componentName = " + paramContext);
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        bool1 = bool2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("SmallScreenUtils", 2, "WL_DEBUG isAppOnForeground e = " + paramContext);
        return false;
      }
      if (bool1)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if ((localRunningAppProcessInfo.importance != 100) || (!localRunningAppProcessInfo.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SmallScreenUtils", 2, "WL_DEBUG isAppOnForeground appProcess.processName = " + localRunningAppProcessInfo.processName);
            }
            bool1 = true;
            return bool1;
          }
        }
        bool1 = false;
        continue;
      }
      continue;
      label260:
      boolean bool1 = false;
      continue;
      label265:
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenUtils
 * JD-Core Version:    0.7.0.1
 */