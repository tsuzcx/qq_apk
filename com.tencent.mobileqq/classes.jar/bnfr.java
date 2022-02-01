import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.NotificationClickReceiver;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import cooperation.qzone.report.lp.LpReportInfo_dc01245;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class bnfr
{
  private static bnfr a;
  
  private int a(int paramInt)
  {
    int i = LocalMultiProcConfig.getInt("qzone_unreadcount" + paramInt, 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount" + paramInt, i + 1);
    return i + 1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return 0;
    case 1: 
    case 300: 
      return 241;
    case 2: 
      return 244;
    case 4: 
      return 242;
    case 8: 
      return 243;
    }
    switch (paramInt2)
    {
    default: 
      return 3000536;
    case 1: 
      return 3000532;
    case 2: 
      return 3000533;
    case 3: 
      return 3000534;
    }
    return 3000535;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = bmtd.a(paramQQAppInterface.getApp());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("src_type", "app");
    localIntent.putExtra("isFromQQ", "true");
    localIntent.putExtra("page", "tab_remind");
    localIntent.putExtra("version", "1");
    return localIntent;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.getApp(), TranslucentActivity.class);
    paramQQAppInterface.addFlags(268435456);
    if (paramIntent != null) {
      paramQQAppInterface.putExtras(paramIntent);
    }
    return paramQQAppInterface;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.a(paramQQAppInterface, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramQQAppInterface.putExtra("qqid", Long.parseLong(paramString));
    paramQQAppInterface.putExtra("qzone_entry", 0);
    return paramQQAppInterface;
  }
  
  private Intent a(String paramString)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localUri = Uri.parse(paramString);
        localBundle.putString("cellid", localUri.getQueryParameter("uid"));
        localObject = localUri.getQueryParameter("subid");
        if (paramString.contains("photonum"))
        {
          localHashMap = new HashMap();
          localHashMap.put(Integer.valueOf(7), localUri.getQueryParameter("photonum"));
          if (Integer.valueOf(localUri.getQueryParameter("photonum")).intValue() <= 1) {
            continue;
          }
          str = localUri.getQueryParameter("bid");
          localObject = str;
          if (paramString.contains("bid"))
          {
            localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
            localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
            localObject = str;
          }
          localBundle.putParcelable("businessparam", new MapParcelable(localHashMap));
        }
        localBundle.putString("subid", (String)localObject);
        localBundle.putLong("targetuin", Long.parseLong(localUri.getQueryParameter("uin")));
        localBundle.putInt("appid", Integer.parseInt(localUri.getQueryParameter("appid")));
      }
      catch (Exception paramString)
      {
        Uri localUri;
        Object localObject;
        HashMap localHashMap;
        String str;
        QLog.e("MsgNotification", 1, "getQZoneDetailIntent", paramString);
        continue;
      }
      paramString = bmtd.a();
      paramString.putExtras(localBundle);
      return paramString;
      str = "";
      localObject = str;
      if (paramString.contains("bid"))
      {
        localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
        localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
        localObject = str;
      }
    }
  }
  
  public static bnfr a()
  {
    if (a == null) {
      a = new bnfr();
    }
    return a;
  }
  
  private String a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (String str = paramString; paramInt == 0; str = BaseApplication.getContext().getString(2131718520)) {
      return str;
    }
    int i = a(paramInt);
    if (i <= 1) {
      return str;
    }
    if (paramInt == 3000532) {
      paramString = BaseApplication.getContext().getString(2131719101);
    }
    for (;;)
    {
      return str + "(" + BaseApplication.getContext().getString(2131692974) + i + BaseApplication.getContext().getString(2131718372) + paramString + ")";
      if (paramInt == 3000533)
      {
        paramString = BaseApplication.getContext().getString(2131719102);
      }
      else if (paramInt == 3000534)
      {
        paramString = BaseApplication.getContext().getString(2131719103);
      }
      else
      {
        if (paramInt != 3000535) {
          break;
        }
        paramString = BaseApplication.getContext().getString(2131719104);
      }
    }
    return str;
  }
  
  public static void a()
  {
    LocalMultiProcConfig.putInt("qzone_unreadcount3000532", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000533", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000534", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000535", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000536", 0);
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {}
    try
    {
      paramQQAppInterface.t();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MsgNotification", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str2 = "";
    String str1 = str2;
    Uri localUri;
    if (paramString1 != null)
    {
      localUri = Uri.parse(paramString1);
      if (!TextUtils.isEmpty(localUri.getQueryParameter("from"))) {
        break label148;
      }
      str1 = str2;
      if (localUri.getPathSegments().size() > 0) {
        str1 = (String)localUri.getPathSegments().get(0);
      }
    }
    if (paramBoolean) {
      LpReportInfo_dc00420.report(10, 0, str1, paramString2, 1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("pushReport", 2, "EXPOSE: uin: " + paramQQAppInterface.getAccount() + " schema: " + paramString1 + " pushstatkey: " + paramString2 + " fake:" + paramBoolean);
      }
      return;
      label148:
      str1 = localUri.getQueryParameter("from");
      break;
      LpReportInfo_dc00420.report(2, 0, str1, paramString2, 1);
    }
  }
  
  private Intent b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.a(paramQQAppInterface, "com.qzone.misc.web.QZoneTranslucentActivity");
    paramQQAppInterface.setAction("action_js2qzone");
    paramQQAppInterface.putExtra("cmd", "Schema");
    paramQQAppInterface.putExtra("schema", paramString);
    return paramQQAppInterface;
  }
  
  public static void b()
  {
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null)
    {
      localQQNotificationManager.cancel("MsgNotification", 3000532);
      localQQNotificationManager.cancel("MsgNotification", 3000533);
      localQQNotificationManager.cancel("MsgNotification", 3000534);
      localQQNotificationManager.cancel("MsgNotification", 3000535);
      localQQNotificationManager.cancel("MsgNotification", 3000536);
    }
    a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1, paramInt2);
    LocalMultiProcConfig.putInt("qzone_unreadcount" + paramInt1, LocalMultiProcConfig.getInt("qzone_unreadcount" + paramInt1, 0) + 1);
  }
  
  /* Error */
  public void a(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 63	android/content/Intent
    //   3: dup
    //   4: invokespecial 113	android/content/Intent:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc_w 327
    //   14: invokestatic 120	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   17: aload 7
    //   19: ldc_w 329
    //   22: invokevirtual 332	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   25: pop
    //   26: aload 7
    //   28: ldc_w 334
    //   31: ldc_w 336
    //   34: invokevirtual 67	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   37: pop
    //   38: aload 7
    //   40: ldc_w 338
    //   43: aload 4
    //   45: invokevirtual 67	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   48: pop
    //   49: new 63	android/content/Intent
    //   52: dup
    //   53: aload_1
    //   54: ldc 104
    //   56: invokespecial 107	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   59: astore 4
    //   61: aload 4
    //   63: ldc 108
    //   65: invokevirtual 85	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   68: pop
    //   69: aload 4
    //   71: aload 7
    //   73: invokevirtual 111	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   76: pop
    //   77: aload 4
    //   79: ldc_w 359
    //   82: sipush 245
    //   85: invokevirtual 136	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   88: pop
    //   89: aload_1
    //   90: sipush 245
    //   93: aload 4
    //   95: ldc_w 360
    //   98: invokestatic 366	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   101: astore 9
    //   103: aload_1
    //   104: invokevirtual 372	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   107: ldc_w 373
    //   110: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   113: astore 4
    //   115: aload 4
    //   117: astore 7
    //   119: aload 4
    //   121: ifnull +75 -> 196
    //   124: aload 4
    //   126: astore 7
    //   128: getstatic 385	android/os/Build$VERSION:SDK_INT	I
    //   131: bipush 11
    //   133: if_icmplt +63 -> 196
    //   136: aload_1
    //   137: invokevirtual 372	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   140: ldc_w 386
    //   143: invokevirtual 391	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   146: istore 5
    //   148: aload_1
    //   149: invokevirtual 372	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   152: ldc_w 392
    //   155: invokevirtual 391	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   158: istore 6
    //   160: iload 5
    //   162: aload 4
    //   164: invokevirtual 397	android/graphics/Bitmap:getWidth	()I
    //   167: if_icmpne +17 -> 184
    //   170: aload 4
    //   172: astore 7
    //   174: iload 6
    //   176: aload 4
    //   178: invokevirtual 400	android/graphics/Bitmap:getHeight	()I
    //   181: if_icmpeq +15 -> 196
    //   184: aload 4
    //   186: iload 5
    //   188: iload 6
    //   190: iconst_0
    //   191: invokestatic 404	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   194: astore 7
    //   196: getstatic 409	bhvl:e	Z
    //   199: ifne +175 -> 374
    //   202: invokestatic 414	bnfs:a	()Lbnfs;
    //   205: aload 9
    //   207: aload_1
    //   208: aload 7
    //   210: aload_2
    //   211: aload_3
    //   212: ldc_w 415
    //   215: invokevirtual 418	bnfs:a	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   218: astore_2
    //   219: aload_1
    //   220: iconst_0
    //   221: aload_2
    //   222: invokestatic 423	blgq:a	(Landroid/content/Context;ILandroid/app/Notification;)V
    //   225: invokestatic 344	com/tencent/commonsdk/util/notification/QQNotificationManager:getInstance	()Lcom/tencent/commonsdk/util/notification/QQNotificationManager;
    //   228: astore_1
    //   229: aload_1
    //   230: ifnull +14 -> 244
    //   233: aload_1
    //   234: ldc_w 425
    //   237: sipush 245
    //   240: aload_2
    //   241: invokevirtual 429	com/tencent/commonsdk/util/notification/QQNotificationManager:notify	(Ljava/lang/String;ILandroid/app/Notification;)V
    //   244: return
    //   245: astore 4
    //   247: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +33 -> 283
    //   253: ldc 224
    //   255: iconst_2
    //   256: new 14	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 431
    //   266: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 4
    //   271: invokevirtual 432	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   274: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aconst_null
    //   284: astore 4
    //   286: goto -171 -> 115
    //   289: astore 8
    //   291: aload_1
    //   292: invokevirtual 372	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   295: ldc_w 435
    //   298: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   301: astore 7
    //   303: aload 7
    //   305: astore 4
    //   307: ldc 224
    //   309: iconst_1
    //   310: ldc_w 437
    //   313: aload 8
    //   315: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload 4
    //   320: astore 7
    //   322: goto -126 -> 196
    //   325: astore 8
    //   327: aload 4
    //   329: astore 7
    //   331: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq -138 -> 196
    //   337: ldc 224
    //   339: iconst_2
    //   340: new 14	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 431
    //   350: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 8
    //   355: invokevirtual 432	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   358: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload 4
    //   369: astore 7
    //   371: goto -175 -> 196
    //   374: ldc_w 439
    //   377: invokestatic 444	bhlo:k	()Ljava/lang/String;
    //   380: invokevirtual 448	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   383: ifeq +23 -> 406
    //   386: invokestatic 414	bnfs:a	()Lbnfs;
    //   389: aload 9
    //   391: aload_1
    //   392: aload 7
    //   394: aload_2
    //   395: aload_3
    //   396: ldc_w 415
    //   399: invokevirtual 450	bnfs:b	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   402: astore_2
    //   403: goto -184 -> 219
    //   406: invokestatic 414	bnfs:a	()Lbnfs;
    //   409: aload 9
    //   411: aload_1
    //   412: aload 7
    //   414: aload_2
    //   415: aload_3
    //   416: ldc_w 415
    //   419: invokevirtual 453	bnfs:c	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   422: astore_2
    //   423: goto -204 -> 219
    //   426: astore_1
    //   427: ldc 224
    //   429: iconst_1
    //   430: ldc_w 455
    //   433: aload_1
    //   434: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   437: return
    //   438: astore 8
    //   440: goto -113 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	bnfr
    //   0	443	1	paramContext	android.content.Context
    //   0	443	2	paramString1	String
    //   0	443	3	paramString2	String
    //   0	443	4	paramString3	String
    //   146	41	5	i	int
    //   158	31	6	j	int
    //   7	406	7	localObject	Object
    //   289	25	8	localThrowable	Throwable
    //   325	29	8	localOutOfMemoryError1	OutOfMemoryError
    //   438	1	8	localOutOfMemoryError2	OutOfMemoryError
    //   101	309	9	localPendingIntent	PendingIntent
    // Exception table:
    //   from	to	target	type
    //   103	115	245	java/lang/OutOfMemoryError
    //   128	170	289	java/lang/Throwable
    //   174	184	289	java/lang/Throwable
    //   184	196	289	java/lang/Throwable
    //   307	318	325	java/lang/OutOfMemoryError
    //   225	229	426	java/lang/Exception
    //   233	244	426	java/lang/Exception
    //   291	303	438	java/lang/OutOfMemoryError
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, String paramString5, String paramString6, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    if (paramQQAppInterface == null) {}
    AppRuntime.Status localStatus;
    label25:
    do
    {
      return;
      localStatus = paramQQAppInterface.getOnlineStatus();
      if (localStatus == AppRuntime.Status.dnd) {
        break;
      }
      a(paramInt1, paramQQAppInterface);
    } while (FriendsStatusUtil.a(paramQQAppInterface.getApp()));
    a(paramInt1, paramQQAppInterface);
    paramInt1 = 1;
    Object localObject3 = (bcvn)paramQQAppInterface.getManager(10);
    Object localObject1;
    switch (paramInt2)
    {
    default: 
      localObject1 = null;
    }
    label898:
    label1557:
    label1560:
    for (;;)
    {
      label119:
      int i = a(paramInt2, paramInt3);
      localObject3 = new Intent();
      ((Intent)localObject3).setClass(paramQQAppInterface.getApp(), NotificationClickReceiver.class);
      ((Intent)localObject3).putExtra("realIntent", (Parcelable)localObject1);
      ((Intent)localObject3).putExtra("hostuin", paramQQAppInterface.getAccount());
      ((Intent)localObject3).putExtra("pushschema", paramString5);
      ((Intent)localObject3).putExtra("pushstatkey", paramString6);
      ((Intent)localObject3).putExtra("param_notifyid", i);
      Object localObject4 = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, (Intent)localObject3, 134217728);
      label240:
      Object localObject5;
      if (paramInt2 == 366)
      {
        paramString1 = a(paramString1, i);
        paramInt3 = 2130847527;
        localObject1 = null;
        localObject3 = null;
        if (paramInt2 != 8) {
          break label1082;
        }
        localObject5 = axdx.a(paramQQAppInterface);
        localObject1 = localObject3;
        if (((axdx)localObject5).a(paramString3, paramString4)) {
          localObject1 = ((axdx)localObject5).a(paramString3, paramString4, null);
        }
        paramString3 = (String)localObject1;
        label296:
        if (bhvl.e) {
          break label1390;
        }
        paramString1 = bnfs.a().a((PendingIntent)localObject4, paramQQAppInterface.getApp(), paramString3, paramString1, paramString2, paramInt3);
      }
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              if ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 300))
              {
                paramString2 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                paramString2.setPackage(MobileQQ.getContext().getPackageName());
                paramString2.putExtra("pushstatkey", paramString6);
                paramString2.putExtra("mergenum", paramInt1);
                paramString2.putExtra("pushtype", paramInt2);
                paramString1.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, paramString2, 134217728);
              }
              blgq.a(paramQQAppInterface.getApp(), 0, paramString1);
              if (localStatus != AppRuntime.Status.dnd) {
                break label1448;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MsgNotification", 2, "showQZoneMsgNotification, dnd shield hide notify");
              return;
              if (!QLog.isColorLevel()) {
                break label25;
              }
              QLog.d("MsgNotification", 2, "showQZoneMsgNotification, dnd shield sound");
              break label25;
              localObject1 = a(paramQQAppInterface);
              ((Intent)localObject1).putExtra("launch_time", System.currentTimeMillis());
              ((Intent)localObject1).putExtra("refer", "msg_notification");
              ((Intent)localObject1).putExtra("fling_action_key", 2);
              ((Intent)localObject1).putExtra("fling_code_key", hashCode());
              localObject1 = a(paramQQAppInterface, (Intent)localObject1);
              if (localObject3 == null) {
                break label1560;
              }
              paramInt1 = ((bcvn)localObject3).a(1);
              ((bcvn)localObject3).a(1, paramInt1);
              if (paramInt1 > 0) {
                break label1557;
              }
              paramInt1 = 1;
              break label119;
              localObject1 = a(paramQQAppInterface, a(paramString5));
              break label119;
              try
              {
                for (;;)
                {
                  localObject3 = b(paramQQAppInterface, paramString5);
                  localObject1 = localObject3;
                  try
                  {
                    for (;;)
                    {
                      localObject3 = a(paramQQAppInterface, (Intent)localObject3);
                      if (paramBoolean2)
                      {
                        localObject1 = localObject3;
                        localObject4 = new bmsx();
                        localObject1 = localObject3;
                        ((bmsx)localObject4).c = String.valueOf(322);
                        localObject1 = localObject3;
                        ((bmsx)localObject4).d = String.valueOf(2);
                        localObject1 = localObject3;
                        ((bmsx)localObject4).e = String.valueOf(6);
                        localObject1 = localObject3;
                        QZoneClickReport.report(paramQQAppInterface.getAccount(), (bmsx)localObject4, true);
                      }
                      localObject1 = localObject3;
                      localObject4 = Uri.parse(paramString5);
                      localObject1 = localObject3;
                      localObject5 = new bnft(((Uri)localObject4).getQueryParameter("room"), paramString2, paramBoolean1, paramInt2, paramString5, paramString6);
                      localObject1 = localObject3;
                      if (bcux.a == null)
                      {
                        localObject1 = localObject3;
                        bcux.a = Collections.synchronizedList(new ArrayList());
                      }
                      if (paramBoolean2)
                      {
                        localObject1 = localObject3;
                        bcux.a.add(localObject5);
                      }
                      try
                      {
                        LpReportInfo_dc01245.report(Long.parseLong(((Uri)localObject4).getQueryParameter("uin")), Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount()), 11, 0);
                        localObject1 = localObject3;
                      }
                      catch (Exception localException5)
                      {
                        for (;;)
                        {
                          localObject1 = localObject3;
                          QLog.e("MsgNotification", 1, localException5.getStackTrace());
                        }
                      }
                    }
                    QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_LIVE error", localException1);
                  }
                  catch (Exception localException1) {}
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  Intent localIntent;
                  Bitmap localBitmap;
                  int j;
                  int k;
                  Object localObject2 = null;
                }
              }
            }
            break label119;
            if ((paramString5 == null) || (!paramString5.startsWith("mqzonev2://arouse/openhomepage"))) {
              break label898;
            }
            try
            {
              localObject1 = a(paramQQAppInterface, Uri.parse(paramString5).getQueryParameter("uin"));
            }
            catch (Exception localException2)
            {
              try
              {
                localIntent = a(paramQQAppInterface, (Intent)localObject1);
                localObject1 = localIntent;
              }
              catch (Exception localException3)
              {
                break label884;
              }
              localException2 = localException2;
              localObject1 = null;
            }
          }
          label884:
          QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_SCHEMA error", localException2);
          break label119;
          localObject1 = a(paramQQAppInterface, b(paramQQAppInterface, paramString5));
          break label119;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("type", 2);
          break label119;
          if ((!TextUtils.isEmpty(paramString1)) && (paramInt2 == 8)) {
            break label240;
          }
          if (paramBoolean1)
          {
            if ((paramInt2 == 2) || (paramInt2 == 8) || (paramInt2 == 4))
            {
              paramString1 = BaseApplication.getContext().getString(2131717563);
              break label240;
            }
            paramString1 = BaseApplication.getContext().getString(2131717563) + "(" + BaseApplication.getContext().getString(2131692974) + paramInt1 + BaseApplication.getContext().getString(2131718372) + BaseApplication.getContext().getString(2131719100) + ")";
            break label240;
          }
          paramString1 = BaseApplication.getContext().getString(2131717563);
          break label240;
          label1082:
          if (paramInt2 == 366)
          {
            paramInt3 = 2130841403;
            localBitmap = bhgm.a(paramQQAppInterface.getApp().getResources(), 2130843971);
            localObject5 = axdx.a(paramQQAppInterface);
            localObject1 = localBitmap;
            if (((axdx)localObject5).a(paramString3, paramString4)) {
              localObject1 = ((axdx)localObject5).a(paramString3, paramString4, localBitmap);
            }
            paramString3 = (String)localObject1;
            break label296;
          }
          try
          {
            paramString3 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130848508);
            paramString4 = paramString3;
            if (paramString3 != null) {
              paramString4 = paramString3;
            }
          }
          catch (OutOfMemoryError paramString4)
          {
            try
            {
              do
              {
                if (Build.VERSION.SDK_INT >= 11)
                {
                  j = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104901);
                  k = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104902);
                  if (j == paramString3.getWidth())
                  {
                    paramString4 = paramString3;
                    if (k == paramString3.getHeight()) {}
                  }
                  else
                  {
                    paramString4 = Bitmap.createScaledBitmap(paramString3, j, k, false);
                  }
                }
                paramString3 = paramString4;
                break;
                paramString4 = paramString4;
                paramString3 = (String)localObject1;
              } while (!QLog.isColorLevel());
              QLog.e("MsgNotification", 2, "Exception:" + paramString4.toString());
              paramString3 = (String)localObject1;
            }
            catch (Throwable localThrowable)
            {
              try
              {
                paramString4 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130848405);
                paramString3 = paramString4;
                QLog.e("MsgNotification", 1, "use small icon ,exp:", localThrowable);
                paramString3 = paramString4;
              }
              catch (OutOfMemoryError paramString4)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("MsgNotification", 2, "Exception:" + paramString4.toString());
                }
              }
            }
          }
        }
        break label296;
        label1390:
        if ("oppo".equalsIgnoreCase(bhlo.k())) {
          paramString1 = bnfs.a().b(localException5, paramQQAppInterface.getApp(), paramString3, paramString1, paramString2, paramInt3);
        } else {
          paramString1 = bnfs.a().c(localException5, paramQQAppInterface.getApp(), paramString3, paramString1, paramString2, paramInt3);
        }
      }
      label1448:
      if (paramBoolean3) {
        try
        {
          a(paramQQAppInterface, paramString5, paramString6, true);
          return;
        }
        catch (Exception paramString1)
        {
          QLog.e("MsgNotification", 1, "MsgNotification.showQZoneMsgNotification notify exception ", paramString1);
        }
      }
      for (;;)
      {
        if (paramQQAppInterface != null)
        {
          bmtd.a(paramQQAppInterface, getClass().getSimpleName());
          if (GuardManager.a != null) {
            GuardManager.a.b(0, null);
          }
        }
        if (!paramBoolean2) {
          break;
        }
        a(paramQQAppInterface, paramString5, paramString6, false);
        return;
        paramString2 = QQNotificationManager.getInstance();
        if (paramString2 != null) {
          paramString2.notify("MsgNotification.showQZoneMsgNotification", i, paramString1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfr
 * JD-Core Version:    0.7.0.1
 */