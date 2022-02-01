package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
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
import android.os.Build.VERSION;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.AVLog;
import com.tencent.av.smallscreen.api.ISmallScreenUtilsApi;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class SmallScreenUtils
{
  static int a;
  public static final String[] a;
  static int jdField_b_of_type_Int;
  static String[] jdField_b_of_type_ArrayOfJavaLangString = { "com.qzone.preview.BasePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.QZoneVideoFloatActivity", "com.tencent.mobileqq.activity.FriendProfileImageActivity", "com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity", "com.tencent.mobileqq.activity.photo.PhotoPreviewActivity", "com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity", "com.tencent.av.gaudio.GaInviteDialogActivity", "com.tencent.av.ui.MultiIncomingCallsActivity", "com.tencent.av.ui.GAudioMembersCtrlActivity", "com.tencent.av.ui.VideoInviteActivity", "com.tencent.mobileqq.activity.selectmember.SelectMemberActivity", "cooperation.qzone.QzonePicturePluginProxyActivity", "com.tencent.av.utils.PopupDialog", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity", "com.miui.permcenter.permissions.AppPermissionsEditorActivity", "com.meizu.safe.security.AppSecActivity", "com.android.settings.Settings$AppDrawOverlaySettingsActivity", "com.tencent.biz.qrcode.activity.QRDisplayActivity", "com.tencent.mobileqq.activity.ForwardRecentActivity", "cooperation.qzone.share.QZoneShareActivity" };
  static int c;
  public static int d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "vivo Y51A", "2014011", "vivo Y67" };
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    c = -1;
    d = 0;
  }
  
  public static int a(int paramInt)
  {
    return ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).getFinishAnimId(paramInt);
  }
  
  /* Error */
  public static int a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 7
    //   8: astore 6
    //   10: aload 8
    //   12: astore 5
    //   14: aload_0
    //   15: invokevirtual 101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore 9
    //   20: aload 7
    //   22: astore 6
    //   24: aload 8
    //   26: astore 5
    //   28: ldc 103
    //   30: invokestatic 109	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   33: astore 10
    //   35: iconst_0
    //   36: istore 4
    //   38: iconst_0
    //   39: istore_3
    //   40: aload 7
    //   42: astore 6
    //   44: aload 8
    //   46: astore 5
    //   48: new 111	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   55: astore 11
    //   57: aload 7
    //   59: astore 6
    //   61: aload 8
    //   63: astore 5
    //   65: aload 11
    //   67: ldc 114
    //   69: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 7
    //   75: astore 6
    //   77: aload 8
    //   79: astore 5
    //   81: aload 11
    //   83: aload_0
    //   84: invokevirtual 122	android/content/Context:getPackageName	()Ljava/lang/String;
    //   87: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 7
    //   93: astore 6
    //   95: aload 8
    //   97: astore 5
    //   99: aload 11
    //   101: ldc 124
    //   103: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 7
    //   109: astore 6
    //   111: aload 8
    //   113: astore 5
    //   115: aload 11
    //   117: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 11
    //   122: aload 7
    //   124: astore 6
    //   126: aload 8
    //   128: astore 5
    //   130: aload 9
    //   132: aload 10
    //   134: iconst_1
    //   135: anewarray 14	java/lang/String
    //   138: dup
    //   139: iconst_0
    //   140: ldc 129
    //   142: aastore
    //   143: aload 11
    //   145: aconst_null
    //   146: aconst_null
    //   147: invokevirtual 135	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   150: astore 7
    //   152: iload 4
    //   154: istore_2
    //   155: aload 7
    //   157: ifnull +167 -> 324
    //   160: iload 4
    //   162: istore_2
    //   163: aload 7
    //   165: astore 6
    //   167: aload 7
    //   169: astore 5
    //   171: aload 7
    //   173: invokeinterface 141 1 0
    //   178: ifeq +146 -> 324
    //   181: aload 7
    //   183: astore 6
    //   185: aload 7
    //   187: astore 5
    //   189: aload 7
    //   191: iconst_0
    //   192: invokeinterface 144 2 0
    //   197: istore 4
    //   199: iload 4
    //   201: ifne +205 -> 406
    //   204: iload_3
    //   205: istore_2
    //   206: goto +3 -> 209
    //   209: aload 7
    //   211: astore 6
    //   213: aload 7
    //   215: astore 5
    //   217: new 111	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   224: astore 8
    //   226: aload 7
    //   228: astore 6
    //   230: aload 7
    //   232: astore 5
    //   234: aload 8
    //   236: ldc 146
    //   238: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 7
    //   244: astore 6
    //   246: aload 7
    //   248: astore 5
    //   250: aload 8
    //   252: iload 4
    //   254: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 7
    //   260: astore 6
    //   262: aload 7
    //   264: astore 5
    //   266: aload 8
    //   268: ldc 151
    //   270: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 7
    //   276: astore 6
    //   278: aload 7
    //   280: astore 5
    //   282: aload 8
    //   284: iload_2
    //   285: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 7
    //   291: astore 6
    //   293: aload 7
    //   295: astore 5
    //   297: aload 8
    //   299: ldc 153
    //   301: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 7
    //   307: astore 6
    //   309: aload 7
    //   311: astore 5
    //   313: ldc 155
    //   315: iconst_1
    //   316: aload 8
    //   318: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 161	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: iload_2
    //   325: istore_1
    //   326: aload 7
    //   328: ifnull +56 -> 384
    //   331: aload 7
    //   333: astore 5
    //   335: aload 5
    //   337: invokeinterface 164 1 0
    //   342: iload_2
    //   343: ireturn
    //   344: astore_0
    //   345: goto +41 -> 386
    //   348: astore 7
    //   350: aload 5
    //   352: astore 6
    //   354: ldc 155
    //   356: iconst_1
    //   357: ldc 166
    //   359: aload 7
    //   361: invokestatic 169	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   364: aload 5
    //   366: astore 6
    //   368: aload_0
    //   369: iload_1
    //   370: invokestatic 171	com/tencent/av/smallscreen/SmallScreenUtils:b	(Landroid/content/Context;I)I
    //   373: istore_2
    //   374: iload_2
    //   375: istore_1
    //   376: aload 5
    //   378: ifnull +6 -> 384
    //   381: goto -46 -> 335
    //   384: iload_1
    //   385: ireturn
    //   386: aload 6
    //   388: ifnull +10 -> 398
    //   391: aload 6
    //   393: invokeinterface 164 1 0
    //   398: goto +5 -> 403
    //   401: aload_0
    //   402: athrow
    //   403: goto -2 -> 401
    //   406: iconst_2
    //   407: istore_2
    //   408: goto -199 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramContext	Context
    //   0	411	1	paramInt	int
    //   154	254	2	i	int
    //   39	166	3	j	int
    //   36	217	4	k	int
    //   12	365	5	localObject1	Object
    //   8	384	6	localObject2	Object
    //   4	328	7	localCursor	android.database.Cursor
    //   348	12	7	localThrowable	Throwable
    //   1	316	8	localStringBuilder	StringBuilder
    //   18	113	9	localContentResolver	android.content.ContentResolver
    //   33	100	10	localUri	android.net.Uri
    //   55	89	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	20	344	finally
    //   28	35	344	finally
    //   48	57	344	finally
    //   65	73	344	finally
    //   81	91	344	finally
    //   99	107	344	finally
    //   115	122	344	finally
    //   130	152	344	finally
    //   171	181	344	finally
    //   189	199	344	finally
    //   217	226	344	finally
    //   234	242	344	finally
    //   250	258	344	finally
    //   266	274	344	finally
    //   282	289	344	finally
    //   297	305	344	finally
    //   313	324	344	finally
    //   354	364	344	finally
    //   368	374	344	finally
    //   14	20	348	java/lang/Throwable
    //   28	35	348	java/lang/Throwable
    //   48	57	348	java/lang/Throwable
    //   65	73	348	java/lang/Throwable
    //   81	91	348	java/lang/Throwable
    //   99	107	348	java/lang/Throwable
    //   115	122	348	java/lang/Throwable
    //   130	152	348	java/lang/Throwable
    //   171	181	348	java/lang/Throwable
    //   189	199	348	java/lang/Throwable
    //   217	226	348	java/lang/Throwable
    //   234	242	348	java/lang/Throwable
    //   250	258	348	java/lang/Throwable
    //   266	274	348	java/lang/Throwable
    //   282	289	348	java/lang/Throwable
    //   297	305	348	java/lang/Throwable
    //   313	324	348	java/lang/Throwable
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a(paramString);
    if (paramBoolean) {
      paramString = "pref_show_dialog_video";
    } else {
      paramString = "pref_show_dialog_audio";
    }
    int i = localSharedPreferences.getInt(paramString, 0);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getPrefShowDialog result = ");
      paramString.append(i);
      QLog.e("SmallScreenUtils", 2, paramString.toString());
    }
    return i;
  }
  
  static SharedPreferences a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.av.smallscreen");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      String str = "";
      while (i < j)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("ste[");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        localStringBuilder.append(arrayOfStackTraceElement[i].toString());
        localStringBuilder.append("\n");
        str = localStringBuilder.toString();
        i += 1;
      }
      QLog.d("SmallScreenUtils", 2, str);
    }
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext)
  {
    ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).actionOff(paramLong, paramInt, paramContext);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    d = paramInt;
    ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).actionOn(paramLong, paramInt, paramContext, paramBoolean1, paramString, paramBoolean2);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("isResume", paramBoolean);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("sendHideSmallScreenBroadcast:");
      paramContext.append(paramBoolean);
      QLog.d("SmallScreenUtils", 2, paramContext.toString());
    }
  }
  
  public static void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).startSetVisibleAnimation(paramView, paramBoolean1, paramBoolean2);
  }
  
  public static void a(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append("getTrace[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]\n");
    paramString = localStringBuilder.toString();
    int i = 1;
    while (i < j)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("ste[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      localStringBuilder.append(arrayOfStackTraceElement[i].toString());
      localStringBuilder.append("\n");
      paramString = localStringBuilder.toString();
      i += 1;
    }
    QLog.d("SmallScreenUtils", 1, paramString);
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a(paramString).edit();
    if (paramBoolean) {
      paramString = "pref_show_dialog_video";
    } else {
      paramString = "pref_show_dialog_audio";
    }
    localEditor.putInt(paramString, paramInt).commit();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("setPrefShowDialog value = ");
      paramString.append(paramInt);
      QLog.e("SmallScreenUtils", 2, paramString.toString());
    }
  }
  
  public static boolean a()
  {
    Object localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (Build.MODEL.equals(localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("useTypeToast, model[");
        ((StringBuilder)localObject1).append(Build.MODEL);
        ((StringBuilder)localObject1).append("]");
        QLog.w("SmallScreenUtils", 1, ((StringBuilder)localObject1).toString());
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(long paramLong, BaseVideoAppInterface paramBaseVideoAppInterface, int paramInt)
  {
    return ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).sendSmallScreenStateBroadcast(paramLong, paramBaseVideoAppInterface, paramInt);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    try
    {
      List localList = paramContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.HOME"), 0);
      bool2 = bool4;
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if (paramContext != null)
      {
        bool2 = bool4;
        paramContext = paramContext.iterator();
        do
        {
          bool2 = bool1;
          bool3 = bool1;
          if (!paramContext.hasNext()) {
            break;
          }
          bool2 = bool1;
          String str = ((ActivityManager.RunningTaskInfo)paramContext.next()).topActivity.getClassName();
          bool2 = bool1;
          Iterator localIterator = localList.iterator();
          do
          {
            bool3 = bool1;
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            bool2 = bool1;
            bool3 = ((ResolveInfo)localIterator.next()).activityInfo.name.equals(str);
          } while (!bool3);
          bool3 = true;
          bool1 = bool3;
        } while (!bool3);
        return bool3;
      }
    }
    catch (Exception paramContext)
    {
      AVLog.printErrorLog("SmallScreenUtils", paramContext.getMessage());
      bool3 = bool2;
    }
    return bool3;
  }
  
  public static boolean a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = e();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (d())
    {
      paramInt = a(paramContext, paramInt);
    }
    else
    {
      int i = b(paramContext, paramInt);
      paramInt = i;
      if (!paramBoolean)
      {
        paramInt = i;
        if (i != 0) {
          if (c()) {
            paramInt = 0;
          } else {
            paramInt = 2;
          }
        }
      }
    }
    paramBoolean = bool1;
    if (paramInt == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 5;
    boolean bool = false;
    if (!paramBoolean1) {}
    for (i = 1;; i = 100)
    {
      paramBoolean1 = true;
      break;
      if (e())
      {
        i = 7;
        paramBoolean1 = bool;
        break;
      }
      if (c(paramContext))
      {
        i = 2;
        paramBoolean1 = bool;
        break;
      }
      if (PhoneStatusTools.e(paramContext))
      {
        i = 3;
        paramBoolean1 = bool;
        break;
      }
      if (a(paramContext))
      {
        i = 4;
        paramBoolean1 = bool;
        break;
      }
      if (e(paramContext))
      {
        paramBoolean1 = bool;
        break;
      }
      if ((!TextUtils.isEmpty(paramString)) && (a(paramString, paramBoolean2) >= 5))
      {
        i = 6;
        paramBoolean1 = bool;
        break;
      }
      paramString = new Intent(paramContext, SmallScreenDialogActivity.class);
      paramString.addFlags(268435456);
      paramString.addFlags(536870912);
      paramString.addFlags(67108864);
      paramString.addFlags(131072);
      paramString.putExtra("is_video", paramBoolean2);
      paramContext.startActivity(paramString);
    }
    if (AudioHelper.b())
    {
      paramContext = new StringBuilder();
      paramContext.append("startSmallScreenDialogActivity, ret[");
      paramContext.append(paramBoolean1);
      paramContext.append("], code[");
      paramContext.append(i);
      paramContext.append("]");
      QLog.w("SmallScreenUtils", 1, paramContext.toString());
    }
    return paramBoolean1;
  }
  
  @TargetApi(23)
  public static int b(Context paramContext, int paramInt)
  {
    int j = 0;
    int m = 0;
    int k = 0;
    int i = m;
    for (;;)
    {
      try
      {
        try
        {
          boolean bool = b();
          if (bool)
          {
            i = m;
            if (!Settings.canDrawOverlays(paramContext)) {
              break label391;
            }
            j = k;
            i = j;
            m = j;
            if (QLog.isColorLevel())
            {
              i = j;
              paramContext = new StringBuilder();
              i = j;
              paramContext.append("checkOp_Common canDrawOve rlays, op[");
              i = j;
              paramContext.append(paramInt);
              i = j;
              paramContext.append("], result[");
              i = j;
              paramContext.append(j);
              i = j;
              paramContext.append("]");
              i = j;
              QLog.w("SmallScreenUtils", 1, paramContext.toString());
              m = j;
            }
          }
          else
          {
            i = m;
            Object localObject = paramContext.getSystemService("appops");
            i = m;
            paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localObject, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramContext.getApplicationInfo().uid), paramContext.getPackageName() });
            if (paramContext == null) {
              break label396;
            }
            i = m;
            k = ((Integer)paramContext).intValue();
            if (3 != k) {
              break label402;
            }
            i = m;
            if (Build.VERSION.SDK_INT >= 23) {
              break label402;
            }
            i = j;
            m = j;
            if (QLog.isColorLevel())
            {
              i = j;
              paramContext = new StringBuilder();
              i = j;
              paramContext.append("checkOp_Common suc, op[");
              i = j;
              paramContext.append(paramInt);
              i = j;
              paramContext.append("], mode[");
              i = j;
              paramContext.append(k);
              i = j;
              paramContext.append("], result[");
              i = j;
              paramContext.append(j);
              i = j;
              paramContext.append("]");
              i = j;
              QLog.w("SmallScreenUtils", 1, paramContext.toString());
              m = j;
            }
          }
        }
        catch (Exception paramContext)
        {
          m = i;
          if (QLog.isColorLevel())
          {
            QLog.e("SmallScreenUtils", 2, "checkOp_Common Exception", paramContext);
            m = i;
          }
        }
        return m;
      }
      catch (InvocationTargetException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenUtils", 2, "checkOp_Common InvocationTargetException", paramContext);
        }
        return 2;
      }
      label391:
      j = 2;
      continue;
      label396:
      k = 0;
      continue;
      label402:
      j = k;
    }
  }
  
  @TargetApi(23)
  static boolean b()
  {
    int i = jdField_a_of_type_Int;
    boolean bool = false;
    if (i == -1)
    {
      jdField_a_of_type_Int = 0;
      if (Build.VERSION.SDK_INT >= 28) {
        jdField_a_of_type_Int = 1;
      } else {
        i = Build.VERSION.SDK_INT;
      }
    }
    if (jdField_a_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(Context paramContext)
  {
    return ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).isLock(paramContext);
  }
  
  static boolean c()
  {
    int i = jdField_b_of_type_Int;
    boolean bool = false;
    if (i == -1)
    {
      jdField_b_of_type_Int = 0;
      if ((Build.MANUFACTURER.equals("vivo")) && (!"vivo X6D".equalsIgnoreCase(Build.MODEL)) && (!"vivo X6D".equalsIgnoreCase(Build.MODEL))) {
        jdField_b_of_type_Int = 1;
      }
    }
    if (jdField_b_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
  
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
    return (Build.VERSION.SDK_INT >= 21) && (Build.MANUFACTURER.equalsIgnoreCase("vivo"));
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool = true;
    if (!a(paramContext, 24, true))
    {
      if (a()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean e()
  {
    return false;
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
        localStringBuilder = null;
        paramContext = localStringBuilder;
        if (localList == null) {
          continue;
        }
        paramContext = localStringBuilder;
        if (localList.size() <= 0) {
          continue;
        }
        paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
      }
      catch (Throwable paramContext)
      {
        StringBuilder localStringBuilder;
        boolean bool;
        return false;
      }
      bool = ArrayUtils.contains(jdField_b_of_type_ArrayOfJavaLangString, paramContext.getClassName());
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkTopActivityHideSmallScreen, topActivity[");
        localStringBuilder.append(paramContext.getClassName());
        localStringBuilder.append("], check[");
        localStringBuilder.append(bool);
        localStringBuilder.append("]");
        QLog.w("SmallScreenUtils", 1, localStringBuilder.toString());
      }
      return bool;
    } while (paramContext != null);
    return false;
  }
  
  public static boolean f()
  {
    return ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).isSupportSmallScreen();
  }
  
  public static boolean f(Context paramContext)
  {
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localObject = null;
        paramContext = (Context)localObject;
        if (localList != null)
        {
          paramContext = (Context)localObject;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label268;
        }
        if (!QLog.isDevelopLevel()) {
          break label263;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isAppOnForeground componentName = ");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("SmallScreenUtils", 2, ((StringBuilder)localObject).toString());
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        if (!QLog.isDevelopLevel()) {
          break label261;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isAppOnForeground e = ");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("SmallScreenUtils", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          localObject = paramContext.iterator();
          if (((Iterator)localObject).hasNext())
          {
            paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((paramContext.importance != 100) || (!paramContext.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("isAppOnForeground appProcess.processName = ");
              ((StringBuilder)localObject).append(paramContext.processName);
              QLog.d("SmallScreenUtils", 2, ((StringBuilder)localObject).toString());
            }
            return true;
          }
        }
      }
      else
      {
        return bool;
      }
      label261:
      return false;
      label263:
      boolean bool = true;
      continue;
      label268:
      bool = false;
    }
  }
  
  public static boolean g()
  {
    return ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).isSupportSmallScreenVideo();
  }
  
  public static boolean h()
  {
    return ((ISmallScreenUtilsApi)QRoute.api(ISmallScreenUtilsApi.class)).isSupportSmallScreenAudio();
  }
  
  public static boolean i()
  {
    boolean bool1 = Build.MANUFACTURER.equalsIgnoreCase("meizu");
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (bool1) {}
    try
    {
      bool1 = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
    }
    catch (Exception localException)
    {
      label52:
      break label52;
    }
    bool1 = false;
    if (Build.DEVICE.equals("mx2")) {
      return true;
    }
    bool2 = bool3;
    if (!Build.DEVICE.equals("mx"))
    {
      if (Build.DEVICE.equals("m9")) {
        return false;
      }
      bool2 = bool1;
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenUtils
 * JD-Core Version:    0.7.0.1
 */