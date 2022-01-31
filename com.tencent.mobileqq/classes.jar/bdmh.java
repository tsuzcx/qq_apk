import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.QQUtils.1;
import com.tencent.mobileqq.utils.QQUtils.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class bdmh
{
  private static String a = "QQUtils";
  
  public static Dialog a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    paramActivity = new Dialog(paramActivity, 2131755801);
    paramActivity.setContentView(2131561046);
    TextView localTextView3 = (TextView)paramActivity.findViewById(2131379146);
    TextView localTextView4 = (TextView)paramActivity.findViewById(2131379123);
    TextView localTextView1 = (TextView)paramActivity.findViewById(2131379118);
    TextView localTextView2 = (TextView)paramActivity.findViewById(2131379114);
    localTextView3.setText(paramString1);
    localTextView4.setText(new SpannableString(paramString2));
    paramString1 = (ImageView)paramActivity.findViewById(2131364126);
    ((ImageButton)paramActivity.findViewById(2131364340)).setOnClickListener(new bdmi(paramActivity));
    if (paramInt >= 0)
    {
      paramString1.setVisibility(0);
      localTextView2.setText("+");
      localTextView1.setText(String.valueOf(paramInt));
      return paramActivity;
    }
    localTextView2.setText("-");
    localTextView1.setText(String.valueOf(0 - paramInt));
    return paramActivity;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, String paramString, Map<String, Object> paramMap)
  {
    Intent localIntent = new Intent("intent.start.shortcut.guide");
    localIntent.setClassName(paramQQAppInterface.getApp(), ShortcutGuideActivity.class.getName());
    localIntent.addCategory("android.intent.category.LAUNCHER");
    String str = (String)paramMap.get("nickname");
    if (paramString.endsWith("sid"))
    {
      paramQQAppInterface = (String)paramMap.get("starHomeUrl");
      localIntent.putExtra("sid", (String)paramMap.get("starId"));
      localIntent.putExtra("from", "starShortcut");
      localIntent.putExtra("starhomeurl", paramQQAppInterface);
      paramQQAppInterface = str;
    }
    for (;;)
    {
      localIntent.putExtra("uinname", paramQQAppInterface);
      return localIntent;
      paramString = (String)paramMap.get("uin");
      int i = Integer.valueOf(paramMap.get("uinType").toString()).intValue();
      localIntent.putExtra("uin", paramString);
      if (str != null)
      {
        paramQQAppInterface = str;
        if (str.trim().length() != 0) {}
      }
      else
      {
        paramQQAppInterface = paramString;
      }
      if (i == 1024) {
        localIntent.putExtra("uintype", 1024);
      } else {
        localIntent.putExtra("uintype", 0);
      }
    }
  }
  
  /* Error */
  public static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 171	bdng:a	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: getstatic 172	bdng:a	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 178	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 184	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   25: aconst_null
    //   26: ldc 186
    //   28: iconst_1
    //   29: anewarray 66	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: aconst_null
    //   37: invokevirtual 192	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +60 -> 102
    //   45: aconst_null
    //   46: astore_2
    //   47: aload_0
    //   48: astore_1
    //   49: aload_0
    //   50: invokeinterface 198 1 0
    //   55: ifeq +33 -> 88
    //   58: aload_0
    //   59: astore_1
    //   60: aload_0
    //   61: aload_0
    //   62: ldc 200
    //   64: invokeinterface 204 2 0
    //   69: invokeinterface 208 2 0
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: aload_2
    //   78: iconst_0
    //   79: aload_2
    //   80: arraylength
    //   81: invokestatic 213	bdal:a	([BII)Landroid/graphics/Bitmap;
    //   84: astore_2
    //   85: goto -38 -> 47
    //   88: aload_2
    //   89: astore_1
    //   90: aload_0
    //   91: ifnull -82 -> 9
    //   94: aload_0
    //   95: invokeinterface 216 1 0
    //   100: aload_2
    //   101: areturn
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 216 1 0
    //   112: aconst_null
    //   113: areturn
    //   114: astore_2
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: astore_1
    //   119: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +34 -> 156
    //   125: aload_0
    //   126: astore_1
    //   127: getstatic 12	bdmh:a	Ljava/lang/String;
    //   130: iconst_2
    //   131: new 223	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   138: ldc 227
    //   140: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_2
    //   144: invokevirtual 232	java/lang/Exception:toString	()Ljava/lang/String;
    //   147: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: ifnull -45 -> 112
    //   160: aload_0
    //   161: invokeinterface 216 1 0
    //   166: goto -54 -> 112
    //   169: astore_0
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +9 -> 182
    //   176: aload_1
    //   177: invokeinterface 216 1 0
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: goto -13 -> 172
    //   188: astore_2
    //   189: goto -72 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString	String
    //   14	87	2	localObject	Object
    //   114	30	2	localException1	java.lang.Exception
    //   188	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   20	41	114	java/lang/Exception
    //   20	41	169	finally
    //   49	58	184	finally
    //   60	75	184	finally
    //   77	85	184	finally
    //   119	125	184	finally
    //   127	156	184	finally
    //   49	58	188	java/lang/Exception
    //   60	75	188	java/lang/Exception
    //   77	85	188	java/lang/Exception
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramString2 = a(paramString2);
    File localFile = new File(paramString2);
    if (!localFile.exists())
    {
      if (paramBoolean) {
        return QQAppInterface.a(a(paramQQAppInterface.getApp(), paramString3), 50, 50);
      }
      if (!HttpDownloadUtil.a(paramQQAppInterface, paramString1, localFile))
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        return null;
      }
    }
    return QQAppInterface.a(bdal.a(paramString2), 50, 50);
  }
  
  /* Error */
  public static SparseArray<String> a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 171	bdng:a	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: getstatic 172	bdng:a	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 178	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_2
    //   21: invokestatic 184	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: astore_2
    //   25: new 223	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 266
    //   35: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 268
    //   45: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_1
    //   52: aload_0
    //   53: aload_2
    //   54: iconst_2
    //   55: anewarray 66	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc_w 270
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc_w 272
    //   69: aastore
    //   70: aload_1
    //   71: aconst_null
    //   72: aconst_null
    //   73: invokevirtual 192	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +133 -> 211
    //   81: aload_1
    //   82: astore_0
    //   83: new 274	android/util/SparseArray
    //   86: dup
    //   87: invokespecial 275	android/util/SparseArray:<init>	()V
    //   90: astore_2
    //   91: aload_1
    //   92: astore_0
    //   93: aload_1
    //   94: invokeinterface 198 1 0
    //   99: ifeq +98 -> 197
    //   102: aload_1
    //   103: astore_0
    //   104: aload_1
    //   105: aload_1
    //   106: ldc_w 270
    //   109: invokeinterface 204 2 0
    //   114: invokeinterface 278 2 0
    //   119: astore_3
    //   120: aload_1
    //   121: astore_0
    //   122: aload_2
    //   123: aload_1
    //   124: aload_1
    //   125: ldc_w 272
    //   128: invokeinterface 204 2 0
    //   133: invokeinterface 282 2 0
    //   138: aload_3
    //   139: invokevirtual 286	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   142: goto -51 -> 91
    //   145: astore_2
    //   146: aload_1
    //   147: astore_0
    //   148: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +34 -> 185
    //   154: aload_1
    //   155: astore_0
    //   156: getstatic 12	bdmh:a	Ljava/lang/String;
    //   159: iconst_2
    //   160: new 223	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   167: ldc 227
    //   169: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_2
    //   173: invokevirtual 232	java/lang/Exception:toString	()Ljava/lang/String;
    //   176: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_1
    //   186: ifnull +9 -> 195
    //   189: aload_1
    //   190: invokeinterface 216 1 0
    //   195: aconst_null
    //   196: areturn
    //   197: aload_2
    //   198: astore_0
    //   199: aload_1
    //   200: ifnull -191 -> 9
    //   203: aload_1
    //   204: invokeinterface 216 1 0
    //   209: aload_2
    //   210: areturn
    //   211: aload_1
    //   212: ifnull -17 -> 195
    //   215: aload_1
    //   216: invokeinterface 216 1 0
    //   221: goto -26 -> 195
    //   224: astore_1
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: ifnull +9 -> 237
    //   231: aload_0
    //   232: invokeinterface 216 1 0
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: goto -13 -> 227
    //   243: astore_2
    //   244: aconst_null
    //   245: astore_1
    //   246: goto -100 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramContext	Context
    //   0	249	1	paramString	String
    //   14	109	2	localObject	Object
    //   145	65	2	localException1	java.lang.Exception
    //   243	1	2	localException2	java.lang.Exception
    //   119	20	3	str	String
    // Exception table:
    //   from	to	target	type
    //   83	91	145	java/lang/Exception
    //   93	102	145	java/lang/Exception
    //   104	120	145	java/lang/Exception
    //   122	142	145	java/lang/Exception
    //   20	77	224	finally
    //   83	91	239	finally
    //   93	102	239	finally
    //   104	120	239	finally
    //   122	142	239	finally
    //   148	154	239	finally
    //   156	185	239	finally
    //   20	77	243	java/lang/Exception
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramContext = paramContext.getPackageManager().getInstalledPackages(8);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
        if (arrayOfProviderInfo != null)
        {
          int j = arrayOfProviderInfo.length;
          int i = 0;
          while (i < j)
          {
            ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
            if (paramString.equals(localProviderInfo.readPermission)) {
              return localProviderInfo.authority;
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(alof.bP);
    String str = MD5.toMD5(paramString);
    str = MD5.toMD5(str + paramString);
    localStringBuilder.append(MD5.toMD5(str + paramString));
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 != null) {}
    for (localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();; localObject1 = null)
    {
      if (localObject1 == null) {
        paramConfigType = localObject2;
      }
      StringBuilder localStringBuilder;
      ServerConfigManager localServerConfigManager;
      do
      {
        return paramConfigType;
        if ((localObject1 instanceof QQAppInterface)) {
          return ((QQAppInterface)localObject1).a(paramConfigType, paramString);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
        localServerConfigManager = (ServerConfigManager)((AppRuntime)localObject1).getManager(4);
        if (localServerConfigManager == null) {
          break;
        }
        localObject1 = localServerConfigManager.getServerConfig(a(), paramConfigType);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label258;
        }
        String str = "<" + paramString + ">";
        i = ((String)localObject1).indexOf(str);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (-1 == i) {
          break label258;
        }
        i = str.length() + i;
        int j = ((String)localObject1).indexOf("</" + paramString + ">", i);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (-1 == j) {
          break label258;
        }
        paramString = ((String)localObject1).substring(i, j);
        localStringBuilder.append(paramString);
        paramConfigType = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("QQUtils", 2, localStringBuilder.toString());
      return paramString;
      paramConfigType = null;
      label258:
      paramString = new StringBuilder().append("null, configTextSize=");
      if (paramConfigType != null) {}
      for (int i = paramConfigType.length();; i = -1)
      {
        localStringBuilder.append(i).append(", scm=").append(localServerConfigManager);
        paramConfigType = localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQUtils", 2, localStringBuilder.toString());
        return null;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    bdqf.a().a(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", "QQ");
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramQQAppInterface.getApp().sendOrderedBroadcast(localIntent, null);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "deleteShortcut.finish.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    Intent localIntent = new Intent();
    bdqf.a().a(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    int i = bdgz.a(paramQQAppInterface.getApp());
    paramIntent = paramBitmap;
    if (i != paramBitmap.getWidth()) {
      if (bdqi.c) {
        break label128;
      }
    }
    label128:
    for (paramIntent = bdqf.a().a(paramBitmap, i);; paramIntent = Bitmap.createScaledBitmap(paramBitmap, i, i, false))
    {
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramIntent);
      localIntent.putExtra("duplicate", false);
      localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramQQAppInterface.getApp().sendOrderedBroadcast(localIntent, null);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "createShortcut.finish.");
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    SparseArray localSparseArray = a(paramQQAppInterface.getApp(), paramString);
    if (localSparseArray == null) {}
    for (;;)
    {
      return;
      int j = localSparseArray.size();
      int i = 0;
      label24:
      if (i >= j) {
        continue;
      }
      int k = localSparseArray.keyAt(i);
      Object localObject1 = (String)localSparseArray.get(k);
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = Intent.parseUri((String)localObject1, 0);
        }
      }
      catch (URISyntaxException localInterruptedException2)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              ((Intent)localObject1).addCategory("android.intent.category.BROWSABLE");
              ((Intent)localObject1).setComponent(null);
              localObject2 = localObject1;
              if (Build.VERSION.SDK_INT >= 15)
              {
                ((Intent)localObject1).setSelector(null);
                localObject2 = localObject1;
              }
              if (localObject2 == null) {
                break;
              }
              str = localObject2.getStringExtra("uinname");
              if (paramString.endsWith("sid"))
              {
                localObject1 = a(null, localObject2.getStringExtra("sid"), String.valueOf(k), paramQQAppInterface, true);
                a(paramQQAppInterface, localObject2);
              }
            }
            catch (URISyntaxException localURISyntaxException2)
            {
              String str;
              continue;
            }
            try
            {
              Thread.sleep(1000L);
              a(paramQQAppInterface, localObject2, str, (Bitmap)localObject1);
            }
            catch (InterruptedException localInterruptedException2)
            {
              try
              {
                Thread.sleep(1000L);
                i += 1;
                break label24;
                localURISyntaxException1 = localURISyntaxException1;
                localObject1 = null;
                localObject2 = localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.d(a, 2, "shortcutIntent parse exception " + localURISyntaxException1.getMessage());
                  localObject2 = localObject1;
                  continue;
                  localObject1 = bdeb.a(paramQQAppInterface.b(localObject2.getStringExtra("uin")));
                  continue;
                  localInterruptedException2 = localInterruptedException2;
                  if (QLog.isColorLevel()) {
                    QLog.d(a, 2, "thread sleep exception " + localInterruptedException2.getMessage());
                  }
                }
              }
              catch (InterruptedException localInterruptedException1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(a, 2, "thread sleep exception " + localInterruptedException1.getMessage());
                }
              }
            }
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("uin", paramString1);
    ((Map)localObject).put("nickname", paramString2);
    ((Map)localObject).put("uinType", Integer.valueOf(paramInt));
    Intent localIntent = a(paramQQAppInterface, "uin", (Map)localObject);
    localObject = paramQQAppInterface.a(1, paramString1, (byte)3, true, 0);
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = bdhj.a();
    }
    a(paramQQAppInterface, localIntent, paramString2, paramString1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, MqqHandler paramMqqHandler, int paramInt2, String paramString3, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "createShortcutWhihTips.begin.");
    }
    if (a(paramQQAppInterface.getApp(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.getApp().getString(2131692291);
      if (paramString1 != null) {
        paramMqqHandler.post(new QQUtils.1(paramQQAppInterface, paramString1, paramInt1));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "createShortcutWhihTips.no shortcut.");
    }
    a(paramQQAppInterface, paramString1, paramString2, paramInt3);
    paramMqqHandler.postDelayed(new QQUtils.2(a(paramQQAppInterface.getApp(), new String[] { paramString2 }), paramQQAppInterface, paramInt1, paramString3), paramInt2);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append(paramArrayList.get(i)).append(", ");
        i += 1;
      }
    }
    QLog.d(paramString1, paramInt, paramString2 + localStringBuilder.toString());
  }
  
  public static final boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    return bdng.a(paramContext, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmh
 * JD-Core Version:    0.7.0.1
 */