import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataMigrationService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.parser.JumpActivityHelper.1;
import com.tencent.mobileqq.app.parser.JumpActivityHelper.3;
import com.tencent.mobileqq.app.parser.JumpActivityHelper.4;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.buscard.BuscardHelper;
import cooperation.comic.VipComicJumpActivity;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class aoud
{
  public static int a(JumpActivity paramJumpActivity, Bundle paramBundle)
  {
    try
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|beg");
      Uri localUri = (Uri)paramBundle.getParcelable("android.intent.extra.STREAM");
      if ((localUri != null) && ("file".equals(localUri.getScheme())) && (localUri.getPath().startsWith("/storage"))) {
        return 4;
      }
      String str1 = paramBundle.getString("android.intent.extra.TITLE");
      String str2 = paramBundle.getString("android.intent.extra.TEXT");
      String str3 = paramJumpActivity.getIntent().getType();
      if (TextUtils.isEmpty(str3))
      {
        QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|type null");
        return 1;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("src_type", "app");
      localHashMap.put("version", "1");
      localHashMap.put("cflag", bhcu.encodeToString("1".getBytes(), 0));
      if (TextUtils.isEmpty(str1)) {}
      for (str1 = "";; str1 = bhcu.encodeToString(str1.getBytes(), 0))
      {
        localHashMap.put("title", str1);
        if (!str3.startsWith("text")) {
          break;
        }
        return paramJumpActivity.a(paramBundle, localHashMap, localUri, str2);
      }
      if (str3.startsWith("image")) {
        return paramJumpActivity.a(paramBundle, localHashMap);
      }
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|unknown type. type=" + str3);
      return 1;
    }
    catch (OutOfMemoryError paramJumpActivity)
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|outofmemoryerror");
    }
    return 1;
  }
  
  public static int a(JumpActivity paramJumpActivity, Bundle paramBundle, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("req_type", bhcu.encodeToString("5".getBytes(), 0));
    if (paramJumpActivity.getIntent().getAction().equals("android.intent.action.SEND"))
    {
      paramBundle = paramBundle.get("android.intent.extra.STREAM");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send extra_stream null");
        }
        return 1;
      }
      if ((paramBundle instanceof Uri)) {
        paramBundle = (Uri)paramBundle;
      }
    }
    for (;;)
    {
      if (paramBundle == null)
      {
        return 1;
        if ((paramBundle instanceof String)) {
          paramBundle = Uri.parse((String)paramBundle);
        }
      }
      else
      {
        paramBundle = ForwardFileOption.a(paramJumpActivity, paramBundle);
        if ((TextUtils.isEmpty(paramBundle)) || (!new File(paramBundle).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send file path invalid. path=" + paramBundle);
          }
          return 1;
        }
        for (;;)
        {
          String str1;
          try
          {
            str1 = URLEncoder.encode(paramBundle, "UTF-8");
            paramHashMap.put("file_data", bhcu.encodeToString(str1.getBytes(), 0));
            return paramJumpActivity.a(paramHashMap);
          }
          catch (UnsupportedEncodingException paramJumpActivity)
          {
            if (QLog.isColorLevel()) {
              QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|encode fail. path=" + paramBundle + ",exp:" + paramJumpActivity.getMessage());
            }
            return 1;
          }
          try
          {
            paramBundle = (ArrayList)paramBundle.get("android.intent.extra.STREAM");
            if (paramBundle == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti extra_stream null");
              }
              return 1;
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
              paramBundle = null;
            }
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            for (;;)
            {
              if (i < paramBundle.size())
              {
                str1 = ForwardFileOption.a(paramJumpActivity, (Uri)paramBundle.get(i));
                if ((!TextUtils.isEmpty(str1)) && (new File(str1).exists())) {}
                try
                {
                  localArrayList.add(URLEncoder.encode(str1, "UTF-8"));
                  i += 1;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti path encode fail: %s" + localUnsupportedEncodingException.getMessage());
                    }
                  }
                }
              }
            }
            if (localArrayList.isEmpty())
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti pathlist empty");
              }
              return 1;
            }
            paramBundle = "";
            i = 0;
            while (i < localArrayList.size())
            {
              String str2 = paramBundle + (String)localArrayList.get(i);
              paramBundle = str2;
              if (i != localArrayList.size() - 1) {
                paramBundle = str2 + ";";
              }
              i += 1;
            }
            paramHashMap.put("file_data", bhcu.encodeToString(paramBundle.getBytes(), 0));
          }
        }
      }
      paramBundle = null;
    }
  }
  
  /* Error */
  public static int a(JumpActivity paramJumpActivity, Bundle paramBundle, HashMap<String, String> paramHashMap, Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 6
    //   6: aload_1
    //   7: ldc 20
    //   9: invokevirtual 232	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   12: ifne +61 -> 73
    //   15: aload_2
    //   16: ldc 142
    //   18: ldc 234
    //   20: invokevirtual 100	java/lang/String:getBytes	()[B
    //   23: iconst_0
    //   24: invokestatic 106	bhcu:encodeToString	([BI)Ljava/lang/String;
    //   27: invokevirtual 90	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload 4
    //   33: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +24 -> 60
    //   39: ldc 108
    //   41: astore_1
    //   42: aload_2
    //   43: ldc 236
    //   45: aload_1
    //   46: invokevirtual 90	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: aload_0
    //   51: aload_2
    //   52: invokevirtual 191	com/tencent/mobileqq/activity/JumpActivity:a	(Ljava/util/HashMap;)I
    //   55: istore 5
    //   57: iload 5
    //   59: ireturn
    //   60: aload 4
    //   62: invokevirtual 100	java/lang/String:getBytes	()[B
    //   65: iconst_0
    //   66: invokestatic 106	bhcu:encodeToString	([BI)Ljava/lang/String;
    //   69: astore_1
    //   70: goto -28 -> 42
    //   73: aload_3
    //   74: ifnull -24 -> 50
    //   77: aload_0
    //   78: invokevirtual 240	com/tencent/mobileqq/activity/JumpActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   81: aload_3
    //   82: invokevirtual 246	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   85: astore_1
    //   86: aload_1
    //   87: invokestatic 249	aoud:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   90: astore_3
    //   91: aload_1
    //   92: invokevirtual 254	java/io/InputStream:close	()V
    //   95: aload_3
    //   96: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifeq +78 -> 177
    //   102: iload 6
    //   104: istore 5
    //   106: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq -52 -> 57
    //   112: ldc 10
    //   114: iconst_2
    //   115: ldc_w 256
    //   118: invokestatic 18	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_0
    //   124: aload 7
    //   126: astore_1
    //   127: ldc 10
    //   129: iconst_1
    //   130: new 122	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 258
    //   140: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 18	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: iload 6
    //   158: istore 5
    //   160: aload_1
    //   161: ifnull -104 -> 57
    //   164: aload_1
    //   165: invokevirtual 254	java/io/InputStream:close	()V
    //   168: iconst_1
    //   169: ireturn
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   175: iconst_1
    //   176: ireturn
    //   177: aload_2
    //   178: ldc 142
    //   180: ldc 234
    //   182: invokevirtual 100	java/lang/String:getBytes	()[B
    //   185: iconst_0
    //   186: invokestatic 106	bhcu:encodeToString	([BI)Ljava/lang/String;
    //   189: invokevirtual 90	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   192: pop
    //   193: aload_3
    //   194: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifeq +17 -> 214
    //   200: ldc 108
    //   202: astore_1
    //   203: aload_2
    //   204: ldc 236
    //   206: aload_1
    //   207: invokevirtual 90	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   210: pop
    //   211: goto -161 -> 50
    //   214: aload_3
    //   215: invokevirtual 100	java/lang/String:getBytes	()[B
    //   218: iconst_0
    //   219: invokestatic 106	bhcu:encodeToString	([BI)Ljava/lang/String;
    //   222: astore_1
    //   223: goto -20 -> 203
    //   226: astore_0
    //   227: goto -100 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramJumpActivity	JumpActivity
    //   0	230	1	paramBundle	Bundle
    //   0	230	2	paramHashMap	HashMap<String, String>
    //   0	230	3	paramUri	Uri
    //   0	230	4	paramString	String
    //   55	104	5	i	int
    //   4	153	6	j	int
    //   1	124	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	86	123	java/lang/Exception
    //   95	102	123	java/lang/Exception
    //   106	121	123	java/lang/Exception
    //   177	200	123	java/lang/Exception
    //   203	211	123	java/lang/Exception
    //   214	223	123	java/lang/Exception
    //   164	168	170	java/io/IOException
    //   86	95	226	java/lang/Exception
  }
  
  public static int a(JumpActivity paramJumpActivity, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      QLog.e("qqfav|QfavJumpActivity", 1, "qqFavDoAction error: params are null");
      return 1;
    }
    StringBuilder localStringBuilder = new StringBuilder("mqqapi://share/to_qqfav?");
    Set localSet = paramHashMap.keySet();
    Iterator localIterator = localSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append((String)paramHashMap.get(str));
      if (i != localSet.size() - 1) {
        localStringBuilder.append("&");
      }
      i += 1;
    }
    paramJumpActivity = bhey.a(paramJumpActivity.app, paramJumpActivity, localStringBuilder.toString());
    if (paramJumpActivity == null)
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|jump parse fail");
      return 1;
    }
    paramJumpActivity.a();
    QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|end");
    return 0;
  }
  
  public static Intent a(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    Intent localIntent = paramJumpActivity.getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    localObject2 = localIntent;
    if (paramBoolean)
    {
      localObject2 = localIntent;
      if (!paramJumpActivity.app.isLogin())
      {
        localObject2 = new Intent(paramJumpActivity, LoginActivity.class);
        ((Intent)localObject2).putExtra("isActionSend", true);
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ((Intent)localObject2).putExtras(localIntent);
        paramJumpActivity.startActivityForResult((Intent)localObject2, 20);
        localObject2 = null;
      }
    }
    return localObject2;
  }
  
  public static Uri a(Uri paramUri)
  {
    int i = 1;
    Object localObject = paramUri;
    String str;
    File localFile;
    if (paramUri != null)
    {
      localObject = paramUri;
      if ("file".equals(paramUri.getScheme()))
      {
        str = paramUri.getPath();
        localObject = paramUri;
        if (!TextUtils.isEmpty(str))
        {
          localFile = new File(str);
          localObject = paramUri;
          if (!localFile.exists()) {}
        }
      }
    }
    try
    {
      localObject = localFile.getCanonicalPath();
      QLog.d("JumpActivityHelper", 1, new Object[] { "checkAndRebuildFileUri path", str, ", actFilePath=", localObject });
      if (!((String)localObject).startsWith(ForwardUtils.getDataDataPath() + BaseApplicationImpl.getContext().getPackageName())) {}
      while (i != 0)
      {
        localObject = Uri.parse("file://" + (String)localObject);
        return localObject;
        i = 0;
      }
      return null;
    }
    catch (Exception localException) {}
    return paramUri;
  }
  
  /* Error */
  public static Uri a(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_0
    //   16: iconst_0
    //   17: aaload
    //   18: checkcast 381	android/content/Context
    //   21: astore 12
    //   23: aload_0
    //   24: iconst_1
    //   25: aaload
    //   26: checkcast 28	android/net/Uri
    //   29: astore 13
    //   31: getstatic 387	com/tencent/mobileqq/app/AppConstants:SDCARD_SHARE_VCARD	Ljava/lang/String;
    //   34: astore 11
    //   36: aload 12
    //   38: invokevirtual 388	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload 13
    //   43: iconst_1
    //   44: anewarray 36	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 390
    //   52: aastore
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 394	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +589 -> 650
    //   64: aload_2
    //   65: invokeinterface 399 1 0
    //   70: ifeq +580 -> 650
    //   73: aload_2
    //   74: iconst_0
    //   75: invokeinterface 402 2 0
    //   80: astore_0
    //   81: aload_0
    //   82: astore 4
    //   84: aload_0
    //   85: astore_3
    //   86: aload_2
    //   87: invokeinterface 403 1 0
    //   92: aload_0
    //   93: astore 4
    //   95: aload_0
    //   96: astore_3
    //   97: aload 11
    //   99: invokestatic 408	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   102: ifne +21 -> 123
    //   105: aload_0
    //   106: astore 4
    //   108: aload_0
    //   109: astore_3
    //   110: new 170	java/io/File
    //   113: dup
    //   114: aload 11
    //   116: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 411	java/io/File:mkdirs	()Z
    //   122: pop
    //   123: aload_0
    //   124: astore 4
    //   126: aload_0
    //   127: astore_3
    //   128: new 413	java/io/FileOutputStream
    //   131: dup
    //   132: new 170	java/io/File
    //   135: dup
    //   136: new 122	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   143: aload 11
    //   145: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: invokespecial 416	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   161: astore 7
    //   163: aload 6
    //   165: astore_3
    //   166: aload 9
    //   168: astore 4
    //   170: aload 12
    //   172: invokevirtual 388	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   175: aload 13
    //   177: ldc_w 418
    //   180: invokevirtual 422	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   183: astore 8
    //   185: aload 10
    //   187: astore 5
    //   189: aload 8
    //   191: ifnull +164 -> 355
    //   194: aload 6
    //   196: astore_3
    //   197: aload 9
    //   199: astore 4
    //   201: aload 8
    //   203: invokevirtual 428	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   206: astore 5
    //   208: aload 5
    //   210: astore_3
    //   211: aload 5
    //   213: astore 4
    //   215: sipush 1024
    //   218: newarray byte
    //   220: astore 6
    //   222: aload 5
    //   224: astore_3
    //   225: aload 5
    //   227: astore 4
    //   229: aload 5
    //   231: aload 6
    //   233: invokevirtual 432	java/io/InputStream:read	([B)I
    //   236: istore_1
    //   237: iload_1
    //   238: iconst_m1
    //   239: if_icmpeq +104 -> 343
    //   242: aload 5
    //   244: astore_3
    //   245: aload 5
    //   247: astore 4
    //   249: aload 7
    //   251: aload 6
    //   253: iconst_0
    //   254: iload_1
    //   255: invokevirtual 436	java/io/FileOutputStream:write	([BII)V
    //   258: goto -36 -> 222
    //   261: astore 6
    //   263: aload_2
    //   264: astore 4
    //   266: aload_3
    //   267: astore 5
    //   269: aload 7
    //   271: astore_3
    //   272: aload_0
    //   273: astore_2
    //   274: aload 4
    //   276: astore_0
    //   277: aload 6
    //   279: astore 4
    //   281: aload 4
    //   283: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   286: aload_0
    //   287: ifnull +9 -> 296
    //   290: aload_0
    //   291: invokeinterface 403 1 0
    //   296: aload 5
    //   298: ifnull +8 -> 306
    //   301: aload 5
    //   303: invokevirtual 254	java/io/InputStream:close	()V
    //   306: aload_3
    //   307: ifnull +7 -> 314
    //   310: aload_3
    //   311: invokevirtual 437	java/io/FileOutputStream:close	()V
    //   314: new 122	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 378
    //   324: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 11
    //   329: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_2
    //   333: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 163	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   342: areturn
    //   343: aload 5
    //   345: astore_3
    //   346: aload 5
    //   348: astore 4
    //   350: aload 7
    //   352: invokevirtual 440	java/io/FileOutputStream:flush	()V
    //   355: aload_2
    //   356: ifnull +9 -> 365
    //   359: aload_2
    //   360: invokeinterface 403 1 0
    //   365: aload 5
    //   367: ifnull +8 -> 375
    //   370: aload 5
    //   372: invokevirtual 254	java/io/InputStream:close	()V
    //   375: aload 7
    //   377: ifnull +8 -> 385
    //   380: aload 7
    //   382: invokevirtual 437	java/io/FileOutputStream:close	()V
    //   385: new 122	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 378
    //   395: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 11
    //   400: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 163	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   413: areturn
    //   414: astore_2
    //   415: aload_2
    //   416: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   419: goto -44 -> 375
    //   422: astore_2
    //   423: aload_2
    //   424: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   427: goto -42 -> 385
    //   430: astore_0
    //   431: aload_0
    //   432: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   435: goto -129 -> 306
    //   438: astore_0
    //   439: aload_0
    //   440: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   443: goto -129 -> 314
    //   446: astore_3
    //   447: aconst_null
    //   448: astore 6
    //   450: ldc_w 442
    //   453: astore_0
    //   454: aconst_null
    //   455: astore_2
    //   456: aload 8
    //   458: astore 4
    //   460: aload 6
    //   462: ifnull +10 -> 472
    //   465: aload 6
    //   467: invokeinterface 403 1 0
    //   472: aload 4
    //   474: ifnull +8 -> 482
    //   477: aload 4
    //   479: invokevirtual 254	java/io/InputStream:close	()V
    //   482: aload_2
    //   483: ifnull +7 -> 490
    //   486: aload_2
    //   487: invokevirtual 437	java/io/FileOutputStream:close	()V
    //   490: new 122	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 378
    //   500: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload 11
    //   505: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_0
    //   509: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 163	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   518: pop
    //   519: aload_3
    //   520: athrow
    //   521: astore 4
    //   523: aload 4
    //   525: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   528: goto -46 -> 482
    //   531: astore_2
    //   532: aload_2
    //   533: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   536: goto -46 -> 490
    //   539: astore_3
    //   540: ldc_w 442
    //   543: astore_0
    //   544: aconst_null
    //   545: astore 4
    //   547: aload_2
    //   548: astore 6
    //   550: aload 4
    //   552: astore_2
    //   553: aload 8
    //   555: astore 4
    //   557: goto -97 -> 460
    //   560: astore_3
    //   561: aconst_null
    //   562: astore 5
    //   564: aload_2
    //   565: astore 6
    //   567: aload 4
    //   569: astore_0
    //   570: aload 5
    //   572: astore_2
    //   573: aload 8
    //   575: astore 4
    //   577: goto -117 -> 460
    //   580: astore_3
    //   581: aload_2
    //   582: astore 6
    //   584: aload 7
    //   586: astore_2
    //   587: goto -127 -> 460
    //   590: astore 6
    //   592: aload_3
    //   593: astore 4
    //   595: aload 6
    //   597: astore_3
    //   598: aload_0
    //   599: astore 6
    //   601: aload_2
    //   602: astore_0
    //   603: aload 4
    //   605: astore_2
    //   606: aload 5
    //   608: astore 4
    //   610: goto -150 -> 460
    //   613: astore 4
    //   615: aconst_null
    //   616: astore_0
    //   617: ldc_w 442
    //   620: astore_2
    //   621: aconst_null
    //   622: astore_3
    //   623: goto -342 -> 281
    //   626: astore 4
    //   628: aload_2
    //   629: astore_0
    //   630: aconst_null
    //   631: astore_3
    //   632: ldc_w 442
    //   635: astore_2
    //   636: goto -355 -> 281
    //   639: astore 4
    //   641: aload_2
    //   642: astore_0
    //   643: aload_3
    //   644: astore_2
    //   645: aconst_null
    //   646: astore_3
    //   647: goto -366 -> 281
    //   650: ldc_w 442
    //   653: astore_0
    //   654: goto -562 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	paramArrayOfObject	Object[]
    //   236	19	1	i	int
    //   59	301	2	localObject1	Object
    //   414	2	2	localIOException1	java.io.IOException
    //   422	2	2	localIOException2	java.io.IOException
    //   455	32	2	localObject2	Object
    //   531	17	2	localIOException3	java.io.IOException
    //   552	93	2	localObject3	Object
    //   85	261	3	localObject4	Object
    //   446	74	3	localObject5	Object
    //   539	1	3	localObject6	Object
    //   560	1	3	localObject7	Object
    //   580	13	3	localObject8	Object
    //   597	50	3	localObject9	Object
    //   82	396	4	localObject10	Object
    //   521	3	4	localIOException4	java.io.IOException
    //   545	64	4	localObject11	Object
    //   613	1	4	localException1	Exception
    //   626	1	4	localException2	Exception
    //   639	1	4	localException3	Exception
    //   1	606	5	localObject12	Object
    //   13	239	6	arrayOfByte	byte[]
    //   261	17	6	localException4	Exception
    //   448	135	6	localObject13	Object
    //   590	6	6	localObject14	Object
    //   599	1	6	arrayOfObject	Object[]
    //   161	424	7	localFileOutputStream	java.io.FileOutputStream
    //   7	567	8	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   10	188	9	localObject15	Object
    //   4	182	10	localObject16	Object
    //   34	470	11	str	String
    //   21	150	12	localContext	Context
    //   29	147	13	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   170	185	261	java/lang/Exception
    //   201	208	261	java/lang/Exception
    //   215	222	261	java/lang/Exception
    //   229	237	261	java/lang/Exception
    //   249	258	261	java/lang/Exception
    //   350	355	261	java/lang/Exception
    //   370	375	414	java/io/IOException
    //   380	385	422	java/io/IOException
    //   301	306	430	java/io/IOException
    //   310	314	438	java/io/IOException
    //   36	60	446	finally
    //   477	482	521	java/io/IOException
    //   486	490	531	java/io/IOException
    //   64	81	539	finally
    //   86	92	560	finally
    //   97	105	560	finally
    //   110	123	560	finally
    //   128	163	560	finally
    //   170	185	580	finally
    //   201	208	580	finally
    //   215	222	580	finally
    //   229	237	580	finally
    //   249	258	580	finally
    //   350	355	580	finally
    //   281	286	590	finally
    //   36	60	613	java/lang/Exception
    //   64	81	626	java/lang/Exception
    //   86	92	639	java/lang/Exception
    //   97	105	639	java/lang/Exception
    //   110	123	639	java/lang/Exception
    //   128	163	639	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if ((paramContext instanceof FragmentActivity))
    {
      paramContext = ((FragmentActivity)paramContext).getSupportFragmentManager().getFragments();
      localObject1 = localObject2;
      if (paramContext != null)
      {
        if (paramContext.size() > 0) {
          break label42;
        }
        localObject1 = localObject2;
      }
    }
    return localObject1;
    label42:
    paramContext = paramContext.iterator();
    Fragment localFragment;
    do
    {
      localObject1 = localObject2;
      if (!paramContext.hasNext()) {
        break;
      }
      localFragment = (Fragment)paramContext.next();
    } while (!localFragment.isVisible());
    paramContext = localFragment.getClass().getName();
    if ((localFragment instanceof MainFragment))
    {
      localObject1 = (MainFragment)localFragment;
      paramContext = paramContext + "$" + ((MainFragment)localObject1).c();
    }
    for (;;)
    {
      localObject1 = paramContext;
      if (!(localFragment instanceof ChatFragment)) {
        break;
      }
      localObject2 = (ChatFragment)localFragment;
      localObject1 = paramContext;
      if (((ChatFragment)localObject2).a == null) {
        break;
      }
      return paramContext + "$" + ((ChatFragment)localObject2).a.getCurType();
    }
  }
  
  public static String a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(bhcu.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.getComponent() != null)
      {
        Object localObject = paramIntent.getComponent().getClassName();
        if ((localObject != null) && ((((String)localObject).contains("QQBrowserActivity")) || (((String)localObject).contains("QQBrowserDelegationActivity"))) && (!paramIntent.hasExtra("StartClickTime")))
        {
          paramIntent.putExtra("StartClickTime", SystemClock.elapsedRealtime());
          String str = JumpActivity.a(paramContext);
          localObject = new StringBuilder().append(paramContext.getClass().getName());
          if (TextUtils.isEmpty(str)) {}
          for (paramContext = "";; paramContext = "$" + str)
          {
            paramIntent.putExtra("SourceActivityName", paramContext);
            return;
          }
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Intent paramIntent)
  {
    String str = paramIntent.getDataString();
    if ((paramIntent.getComponent() == null) && (!TextUtils.isEmpty(str)))
    {
      Object localObject = Uri.parse(str).getScheme();
      boolean bool2 = JumpActivity.a((String)localObject);
      boolean bool1 = false;
      if (bool2) {
        bool1 = JumpActivity.b((String)localObject);
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("JumpActivityHelper", 1, "processIntent, scheme[" + (String)localObject + "], isLegalScheme[" + bool2 + "], needForceSetComponent[" + bool1 + "]");
      }
      if ((bool2) && (bool1))
      {
        localObject = StatisticCollector.getInstance(BaseApplication.getContext());
        HashMap localHashMap = new HashMap();
        localHashMap.put("URL", str);
        ((StatisticCollector)localObject).collectPerformance("", "JA_ILLEGAL", true, 0L, 0L, localHashMap, "");
        paramIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
      }
    }
  }
  
  public static void a(JumpActivity paramJumpActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramJumpActivity, LoginActivity.class);
    localIntent.addFlags(67371008);
    paramJumpActivity.startActivity(localIntent);
    paramJumpActivity.finish();
  }
  
  public static void a(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getDataString();
      if (!TextUtils.isEmpty(paramIntent))
      {
        paramIntent = bhey.a(paramJumpActivity.app, paramJumpActivity, paramIntent);
        if (paramIntent != null) {
          paramIntent.k();
        }
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby", 2, "nearby_pb|exception:" + paramIntent.toString());
        }
      }
    }
    paramJumpActivity.finish();
  }
  
  public static void a(JumpActivity paramJumpActivity, Intent paramIntent, int paramInt)
  {
    try
    {
      if (paramJumpActivity.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        paramJumpActivity.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("jump_action_thread", 0);
        paramJumpActivity.jdField_a_of_type_AndroidOsHandlerThread.start();
        paramJumpActivity.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(paramJumpActivity.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      aviq localaviq = new aviq(paramJumpActivity, paramJumpActivity);
      paramJumpActivity.q();
      paramJumpActivity.jdField_b_of_type_MqqOsMqqHandler.post(new JumpActivityHelper.1(localaviq, paramIntent, paramInt, paramJumpActivity));
      return;
    }
    finally {}
  }
  
  public static void a(JumpActivity paramJumpActivity, Intent paramIntent, Bundle paramBundle)
  {
    new JumpActivityHelper.3(paramJumpActivity, paramIntent, paramBundle).run();
  }
  
  public static void a(JumpActivity paramJumpActivity, Intent paramIntent, AppRuntime paramAppRuntime)
  {
    String str = paramIntent.getAction();
    if ("com.tencent.mobileqq.action.buscard".equals(str)) {
      BuscardHelper.a(paramAppRuntime, paramIntent, str);
    }
    for (;;)
    {
      paramJumpActivity.finish();
      return;
      if ("android.nfc.action.TECH_DISCOVERED".equals(str)) {
        BuscardHelper.a(paramJumpActivity.app.getCurrentAccountUin(), paramJumpActivity.getActivity(), paramIntent);
      }
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("din");
      paramBundle = paramBundle.getString("qrurl");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!"9971".equals(localObject)) {
          break label55;
        }
        absz.a(paramJumpActivity.app, paramJumpActivity, null, "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html?from=2", null);
      }
    }
    for (;;)
    {
      paramJumpActivity.finish();
      return;
      label55:
      abgm localabgm = (abgm)paramJumpActivity.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      DeviceInfo localDeviceInfo = localabgm.a(Long.parseLong((String)localObject));
      if ((localDeviceInfo != null) && (((String)localObject).equals(String.valueOf(localDeviceInfo.din))))
      {
        localabgm.a(paramJumpActivity, localDeviceInfo, false, null);
      }
      else if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(paramJumpActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramBundle);
        ((Intent)localObject).putExtra("title", anvx.a(2131705377));
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("selfSet_leftViewText", anvx.a(2131705385));
        ((Intent)localObject).putExtra("leftViewText", anvx.a(2131705383));
        paramJumpActivity.startActivity((Intent)localObject);
      }
      else
      {
        bjkv.a().a(anvx.a(2131705382));
      }
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, bheh parambheh, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpActivityHelper", 2, "JumpActivity is finish");
    }
    if ((parambheh.jdField_b_of_type_JavaLangString == null) || (parambheh.jdField_c_of_type_JavaLangString == null)) {
      paramJumpActivity.finish();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!a(parambheh, "gav", "request")) {
                break;
              }
            } while (("0".equals(parambheh.b("relation_id"))) || (!paramBoolean));
            paramJumpActivity.finish();
            return;
            if ((!a(parambheh, "videochat", "request")) && (!a(parambheh, "randomavchat", "request"))) {
              break;
            }
          } while (!paramBoolean);
          paramJumpActivity.finish();
          return;
          if (!a(parambheh, "wallet", "modify_pass")) {
            break;
          }
        } while (!paramBoolean);
        paramJumpActivity.finish();
        return;
        if (!parambheh.m()) {
          break;
        }
      } while (!paramBoolean);
      paramJumpActivity.finish();
      return;
      if (paramJumpActivity.a(parambheh))
      {
        QLog.d("JumpActivityHelper", 1, "asynShareJumpAction wait for finishing");
        return;
      }
      if (paramJumpActivity.b(parambheh)) {
        break;
      }
      if (parambheh.f)
      {
        paramJumpActivity.finish();
        paramJumpActivity.overridePendingTransition(0, 0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpActivityHelper", 2, "wait for finishing");
    return;
    paramJumpActivity.a();
  }
  
  public static void a(JumpActivity paramJumpActivity, String paramString)
  {
    if ((paramString == null) || (paramJumpActivity.jdField_c_of_type_JavaLangString == null) || (paramJumpActivity.jdField_b_of_type_JavaLangString == null) || (paramJumpActivity.jdField_a_of_type_JavaLangString == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ("app".equals(paramJumpActivity.jdField_a_of_type_JavaLangString));
        if (!"web".equals(paramJumpActivity.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!"javascript".equals(paramJumpActivity.jdField_b_of_type_JavaLangString));
      paramString = "javascript:" + paramJumpActivity.jdField_c_of_type_JavaLangString + "('" + paramString + "')";
      Intent localIntent = new Intent(paramJumpActivity, QQBrowserActivity.class);
      localIntent.putExtra("uin", paramJumpActivity.app.getCurrentAccountUin());
      localIntent.setData(Uri.parse(paramString));
      paramJumpActivity.startActivity(localIntent);
      return;
    } while (!"internal".equals(paramJumpActivity.jdField_a_of_type_JavaLangString));
  }
  
  public static void a(JumpActivity paramJumpActivity, DevlockInfo paramDevlockInfo)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    aslf localaslf = aslf.a();
    if ((localaslf != null) && (localaslf.a() == aslf.c))
    {
      localIntent = new Intent();
      localIntent.setAction("mqq.intent.action.DEVLOCK_ROAM");
      if (paramDevlockInfo != null) {
        if (paramDevlockInfo.DevSetup == 1)
        {
          localIntent.putExtra("auth_dev_open", bool1);
          localIntent.putExtra("guardphone_state", localaslf.a());
          if (paramDevlockInfo == null) {
            break label122;
          }
        }
      }
      label122:
      for (paramDevlockInfo = paramDevlockInfo.Mobile;; paramDevlockInfo = "")
      {
        localIntent.putExtra("guardphone_mask", paramDevlockInfo);
        paramJumpActivity.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
        paramJumpActivity.finish();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break;
      }
    }
    Intent localIntent = new Intent(paramJumpActivity.getIntent());
    localIntent.putExtra("devlock_need_broadcast", true);
    if ((localIntent.getBooleanExtra("enable_open_allowset_dev", false)) && (paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 0) && (paramDevlockInfo.AllowSet == 1))
    {
      localIntent.setClass(paramJumpActivity, AuthDevActivity.class);
      localIntent.putExtra("phone_num", paramDevlockInfo.Mobile);
      localIntent.putExtra("country_code", paramDevlockInfo.CountryCode);
      localIntent.putExtra("auth_dev_open", false);
      localIntent.putExtra("allow_set", true);
    }
    for (;;)
    {
      paramJumpActivity.startActivity(localIntent);
      if (!localIntent.getBooleanExtra("open_devlock_from_roam", false)) {
        break;
      }
      paramJumpActivity.overridePendingTransition(2130771979, 2130771977);
      break;
      if ((paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 1))
      {
        localIntent.setClass(paramJumpActivity, AuthDevActivity.class);
        localIntent.putExtra("phone_num", paramDevlockInfo.Mobile);
        localIntent.putExtra("country_code", paramDevlockInfo.CountryCode);
        if (paramDevlockInfo.DevSetup == 1)
        {
          bool1 = true;
          label327:
          localIntent.putExtra("auth_dev_open", bool1);
          if (paramDevlockInfo.AllowSet != 1) {
            break label365;
          }
        }
        label365:
        for (bool1 = bool2;; bool1 = false)
        {
          localIntent.putExtra("allow_set", bool1);
          break;
          bool1 = false;
          break label327;
        }
      }
      localIntent.setClass(paramJumpActivity, AuthDevOpenUgActivity.class);
      localIntent.putExtra("DevlockInfo", paramDevlockInfo);
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    Object localObject3 = paramJumpActivity.getIntent();
    Object localObject2 = ((Intent)localObject3).getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!paramJumpActivity.app.isLogin()))
    {
      localObject2 = new Intent(paramJumpActivity, LoginActivity.class);
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras((Intent)localObject3);
      paramJumpActivity.startActivityForResult((Intent)localObject2, 24);
      return;
    }
    localObject2 = ((Intent)localObject3).getStringExtra("CONFIG_APPID");
    localObject1 = ((Intent)localObject3).getStringExtra("CONFIG_APPNAME");
    String str1 = ((Intent)localObject3).getStringExtra("CONFIG_APPICON");
    String str2 = ((Intent)localObject3).getStringExtra("MINI_CONFIG_DEV_DESC");
    int m = ((Intent)localObject3).getIntExtra("CONFIG_VER_TYPE", 3);
    int j = ((Intent)localObject3).getIntExtra("CONFIG_REPORTTYPE", 0);
    int k = ((Intent)localObject3).getIntExtra("CONFIG_ENGINETYPE", 0);
    int i = ((Intent)localObject3).getIntExtra("CONFIG_APPTYPE", -1);
    if (i != -1) {
      j = i;
    }
    for (;;)
    {
      k = ((Intent)localObject3).getIntExtra("MINI_CONFIG_SCENE", 10086);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)))
      {
        localObject3 = new MiniAppInfo();
        ((MiniAppInfo)localObject3).appId = ((String)localObject2);
        ((MiniAppInfo)localObject3).name = ((String)localObject1);
        ((MiniAppInfo)localObject3).iconUrl = str1;
        ((MiniAppInfo)localObject3).setEngineType(i);
        ((MiniAppInfo)localObject3).setReportType(j);
        ((MiniAppInfo)localObject3).developerDesc = str2;
        ((MiniAppInfo)localObject3).verType = m;
        localObject1 = new MiniAppConfig((MiniAppInfo)localObject3);
        ((MiniAppConfig)localObject1).launchParam = new LaunchParam();
        ((MiniAppConfig)localObject1).launchParam.miniAppId = ((String)localObject2);
        ((MiniAppConfig)localObject1).launchParam.scene = k;
      }
      for (;;)
      {
        if ((localObject1 != null) && (k == 1023) && (((MiniAppConfig)localObject1).config.isEngineTypeMiniGame())) {
          aqnr.a(false, 0);
        }
        if (localObject1 != null) {
          MiniAppController.startApp(paramJumpActivity, (MiniAppConfig)localObject1, null);
        }
        paramJumpActivity.moveTaskToBack(true);
        paramJumpActivity.finish();
        return;
        localObject1 = null;
      }
      i = k;
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      paramJumpActivity.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      if ((paramBoolean) && (paramInt1 == 0) && (paramInt2 == 1))
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = new Intent(paramJumpActivity, QQBrowserActivity.class);
          paramString2.putExtra("url", paramString1);
          paramString2.putExtra("hide_more_button", true);
          paramJumpActivity.startActivity(paramString2);
        }
        paramJumpActivity.finish();
        return;
      }
      if (("android.intent.action.SEND".equals(paramString2)) || ("android.intent.action.SEND_MULTIPLE".equals(paramString2)))
      {
        paramJumpActivity.a(paramJumpActivity.getIntent().getExtras());
        return;
      }
    }
    catch (Throwable paramJumpActivity)
    {
      QLog.e("JumpActivityHelper", 1, paramJumpActivity, new Object[0]);
      return;
    }
    if ("android.intent.action.VIEW".equals(paramString2))
    {
      Intent localIntent = paramJumpActivity.getIntent();
      paramString2 = localIntent.getExtras();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = new Bundle();
      }
      paramJumpActivity.a(localIntent, paramString1);
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, boolean paramBoolean, Intent paramIntent)
  {
    Object localObject = paramJumpActivity.getIntent();
    if (localObject == null) {
      return;
    }
    try
    {
      i = ((Intent)localObject).getIntExtra("busi_type", -1);
      j = ((Intent)localObject).getIntExtra("verify_type", -1);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("ticket");
        if (QLog.isColorLevel()) {
          QLog.d("Q.security_verify", 2, String.format("onWebSecVerifyResult, isSuc: %s, busiType: %s, verifyType: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) }));
        }
        localObject = ((Intent)localObject).getParcelableExtra("extra_data");
        switch (i)
        {
        default: 
          paramJumpActivity.finish();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("JumpActivityHelper", 1, "onWebSecVerifyResult", localException);
        int j = -1;
        int i = -1;
        continue;
        if ((localObject instanceof InviteToGroupInfo))
        {
          localObject = (InviteToGroupInfo)localObject;
          aoep localaoep = (aoep)paramJumpActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          if ((paramBoolean) && (localObject != null) && (!TextUtils.isEmpty(paramIntent)))
          {
            ((InviteToGroupInfo)localObject).jdField_a_of_type_Int = j;
            ((InviteToGroupInfo)localObject).jdField_c_of_type_JavaLangString = paramIntent;
            localaoep.a((InviteToGroupInfo)localObject);
          }
          else
          {
            localaoep.notifyUI(6, false, new Object[] { Integer.valueOf(8), Integer.valueOf(-1) });
            continue;
            if ((localObject instanceof JoinGroupInfo))
            {
              localObject = (JoinGroupInfo)localObject;
              localaoep = (aoep)paramJumpActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
              if ((paramBoolean) && (localObject != null) && (!TextUtils.isEmpty(paramIntent)))
              {
                ((JoinGroupInfo)localObject).b = j;
                ((JoinGroupInfo)localObject).f = paramIntent;
                localaoep.a((JoinGroupInfo)localObject);
              }
              else
              {
                localaoep.notifyUI(6, false, new Object[] { Integer.valueOf(1), Integer.valueOf(-1) });
                continue;
                paramIntent = null;
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = paramJumpActivity.getIntent();
    if ((paramBoolean1) && (!paramJumpActivity.app.isLogin()))
    {
      JumpActivity.f = true;
      paramString = new Intent(paramJumpActivity, LoginActivity.class);
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      paramJumpActivity.startActivityForResult(paramString, 26);
    }
    do
    {
      return;
      if ((paramBoolean2) && (GesturePWDUtils.getJumpLock(paramJumpActivity, paramJumpActivity.app.getCurrentAccountUin())))
      {
        paramJumpActivity.startActivityForResult(new Intent(paramJumpActivity.getActivity(), GesturePWDUnlockActivity.class), 27);
        return;
      }
      JumpActivity.f = false;
      localObject = ((Intent)localObject).getDataString();
      localObject = bhey.a(paramJumpActivity.app, paramJumpActivity, (String)localObject);
      ((bheh)localObject).b(paramString);
      ((bheh)localObject).c(paramJumpActivity.d);
    } while (!((bheh)localObject).a());
    paramJumpActivity.finish();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpActivityHelper", 2, "initJASwitch with " + paramString + " inited=" + JumpActivity.g);
    }
    if (JumpActivity.g) {
      return;
    }
    try
    {
      JumpActivity.jdField_a_of_type_Int = (int)Long.parseLong(paramString, 16);
      if (paramBoolean) {
        BaseApplicationImpl.sApplication.getSharedPreferences("Jump_Action", 0).edit().putString("JASwitch", paramString).commit();
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("JumpActivityHelper", 2, "initJASwitch error", paramString);
        }
      }
    }
    JumpActivity.g = true;
  }
  
  public static boolean a(bheh parambheh, String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {}
    while ((!paramString1.equals(parambheh.jdField_b_of_type_JavaLangString)) || (!paramString2.equals(parambheh.jdField_c_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(JumpActivity paramJumpActivity)
  {
    try
    {
      if (!bhex.a(paramJumpActivity, true))
      {
        paramJumpActivity.finish();
        return true;
      }
    }
    catch (Throwable paramJumpActivity) {}
    return false;
  }
  
  public static boolean a(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (!aade.a().a(String.valueOf(Long.valueOf(paramIntent.getLongExtra("req_share_id", 0L)))))
    {
      paramJumpActivity.finish();
      return false;
    }
    Intent localIntent = new Intent(paramJumpActivity, SplashActivity.class);
    localIntent.putExtras(paramIntent.getExtras());
    paramJumpActivity.startActivity(AIOUtils.setOpenAIOIntent(localIntent, null));
    return false;
  }
  
  public static boolean a(JumpActivity paramJumpActivity, Intent paramIntent, bheh parambheh, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = true;
    if ((a(parambheh, "ptlogin", "qlogin")) || (parambheh.jdField_b_of_type_JavaLangString.equals("qqreg")) || ("invite_register".equals(parambheh.jdField_c_of_type_JavaLangString))) {}
    for (int i = 0;; i = 1)
    {
      if ((!paramJumpActivity.app.isLogin()) && (i != 0))
      {
        paramString2 = new StringBuilder().append(paramString1);
        if (paramString1.contains("?"))
        {
          paramIntent = "&";
          paramIntent = paramIntent;
          paramIntent = paramIntent + "jfrom=login";
          paramString1 = new Intent(paramJumpActivity, LoginActivity.class);
          paramString1.putExtra("scheme_content", paramIntent);
          paramString1.putExtra("pkg_name", paramString3);
          paramString1.putExtras(paramString1);
          paramString1.setFlags(268435456);
          if (VersionUtils.isHoneycomb()) {
            paramString1.addFlags(32768);
          }
          paramJumpActivity.startActivity(paramString1);
        }
      }
      for (;;)
      {
        a(paramJumpActivity, parambheh, bool);
        return false;
        paramIntent = "?";
        break;
        if ((GesturePWDUtils.getJumpLock(paramJumpActivity, paramJumpActivity.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(paramJumpActivity)) && (!PatternLockUtils.isOpenQWalletLockWhenJumpToQWallet(paramJumpActivity, paramJumpActivity.app, paramString1)))
        {
          QLog.d("JumpActivityHelper", 1, new Object[] { "to GesturePWDUnlockActivity pkgName=", paramString3 });
          paramIntent = new Intent(paramJumpActivity.getActivity(), GesturePWDUnlockActivity.class);
          paramIntent.putExtra("key_gesture_from_jumpactivity", true);
          paramIntent.putExtra("scheme_content", paramString1);
          paramIntent.putExtra("pkg_name", paramString3);
          paramJumpActivity.startActivity(paramIntent);
        }
        else
        {
          if (a(parambheh, "devlock", "open"))
          {
            if (!NetworkUtil.isNetSupport(paramJumpActivity))
            {
              QQToast.a(paramJumpActivity, paramJumpActivity.getString(2131692125), 0).b(paramJumpActivity.getTitleBarHeight());
              return false;
            }
            asll.a().a(paramJumpActivity.app, paramJumpActivity.app.getCurrentAccountUin(), paramJumpActivity.jdField_a_of_type_MqqObserverWtloginObserver);
            return false;
          }
          if (a(parambheh, "gvideo", "open_plugin"))
          {
            msj.a(paramJumpActivity.app, paramJumpActivity, paramIntent, 1);
            paramJumpActivity.finish();
            return false;
          }
          if (a(parambheh, "nearby_videochat", "open_plugin"))
          {
            parambheh = (bghm)paramJumpActivity.app.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
            NearbyVideoChatProxyActivity.a(paramJumpActivity.app, paramJumpActivity, paramIntent, parambheh.a(), null, 123987);
            return false;
          }
          if (a(parambheh, "qwerewolf", "enterHomePage"))
          {
            axss.a(paramJumpActivity, 16);
            paramJumpActivity.finish();
            return false;
          }
          if (paramString1.startsWith("mqqapi://tenpay/pay?"))
          {
            paramIntent = paramIntent.getStringExtra("url_app_info");
            if (!TextUtils.isEmpty(paramIntent)) {
              parambheh.a("url_app_info", paramIntent);
            }
          }
          parambheh.c(paramString3);
          parambheh.d(paramString4);
          if ((parambheh.jdField_b_of_type_JavaLangString != null) && (parambheh.jdField_c_of_type_JavaLangString != null)) {
            parambheh.a(paramJumpActivity);
          }
          bool = parambheh.a();
        }
      }
    }
  }
  
  public static boolean a(JumpActivity paramJumpActivity, bheh parambheh)
  {
    if (parambheh == null) {}
    String str;
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(parambheh.b("share_id")));
      str = parambheh.b("req_type");
      paramJumpActivity = parambheh.b("cflag");
    } while (TextUtils.isEmpty(str));
    for (;;)
    {
      for (;;)
      {
        try
        {
          str = a(str);
          if (TextUtils.isEmpty(str)) {
            break label200;
          }
          i = Integer.valueOf(str).intValue();
          if (((i == 3) || (i == 4)) && ("qzone".equals(parambheh.jdField_b_of_type_JavaLangString)) && ("publish".equals(parambheh.jdField_c_of_type_JavaLangString)))
          {
            QLog.i("JumpActivityHelper", 1, "ShareShuoshuoOrVideoToQZone and the JumpActivity has not finish.");
            return true;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.d("JumpActivityHelper", 1, "needToStartQZoneProcess catch NumberFormatException. ", localNumberFormatException);
          i = 1;
          continue;
        }
        if (TextUtils.isEmpty(paramJumpActivity)) {
          break;
        }
        try
        {
          paramJumpActivity = a(paramJumpActivity);
          if (!TextUtils.isEmpty(paramJumpActivity))
          {
            j = Integer.valueOf(paramJumpActivity).intValue();
            if ((i != 5) || ((j & 0x1) == 0)) {
              break;
            }
            QLog.i("JumpActivityHelper", 1, "SharePictureToQZone and the JumpActivity has not finish.");
            return true;
          }
        }
        catch (NumberFormatException paramJumpActivity)
        {
          for (;;)
          {
            QLog.d("JumpActivityHelper", 1, "needToStartQZoneProcess catch NumberFormatException. ", paramJumpActivity);
            int j = 0;
          }
        }
      }
      label200:
      int i = 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, bheh parambheh)
  {
    if ((parambheh == null) || (parambheh.jdField_a_of_type_JavaUtilHashMap == null)) {}
    while (!MiniProgramOpenSdkUtil.asyncShareMiniProgram(parambheh)) {
      return false;
    }
    return paramQQAppInterface.isLogin();
  }
  
  public static boolean a(String paramString)
  {
    if (JumpActivity.jdField_a_of_type_JavaUtilHashMap == null) {}
    try
    {
      if (JumpActivity.jdField_a_of_type_JavaUtilHashMap == null)
      {
        JumpActivity.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        int i = 0;
        while (i < JumpActivity.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          String str = JumpActivity.jdField_a_of_type_ArrayOfJavaLangString[i];
          JumpActivity.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(i));
          i += 1;
        }
        if (!JumpActivity.g) {
          JumpActivity.p();
        }
      }
      return JumpActivity.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
    }
    finally {}
  }
  
  public static void b(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.d("JumpActivityHelper", 2, "reportJumpArguments action=" + str + "; data=" + paramIntent);
    }
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", str);
    localHashMap.put("data", paramIntent);
    localStatisticCollector.collectPerformance("", "JA_ARGUMENTS", true, 0L, 0L, localHashMap, "");
  }
  
  public static void b(JumpActivity paramJumpActivity)
  {
    String str1 = paramJumpActivity.getPackageName();
    String str2 = InstallActivity.class.getName();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.setComponent(new ComponentName(str1, str2));
    paramJumpActivity.startActivity(localIntent);
    paramJumpActivity.finish();
  }
  
  public static void b(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    zcf.a().b(paramJumpActivity, paramIntent);
    paramJumpActivity.finish();
  }
  
  public static void b(JumpActivity paramJumpActivity, Bundle paramBundle)
  {
    new JumpActivityHelper.4(paramBundle, paramJumpActivity).run();
  }
  
  public static void b(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    Intent localIntent = paramJumpActivity.getIntent();
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      QLog.i("JumpActivityHelper", 1, "system share.doShare error extra is null");
      paramJumpActivity.finish();
      return;
    }
    if ((paramBoolean) && (!paramJumpActivity.app.isLogin()))
    {
      localIntent = new Intent(paramJumpActivity, LoginActivity.class);
      localIntent.putExtra("isActionSend", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtras(localIntent);
      paramJumpActivity.startActivityForResult(localIntent, 19);
      return;
    }
    if (localBundle.getBoolean("qqfav_extra_from_system_share", false))
    {
      int i = paramJumpActivity.a(localBundle);
      if (i == 4) {
        bmar.a(paramJumpActivity, 2131697882, 1);
      }
      for (;;)
      {
        paramJumpActivity.finish();
        return;
        if (i != 0) {
          bmar.a(paramJumpActivity, 2131697878, 1);
        }
      }
    }
    a(paramJumpActivity, localIntent, 0);
  }
  
  public static void b(JumpActivity paramJumpActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = paramJumpActivity.getIntent();
    if ((paramBoolean1) && (!paramJumpActivity.app.isLogin()))
    {
      JumpActivity.e = true;
      paramString = new Intent(paramJumpActivity, LoginActivity.class);
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      paramJumpActivity.startActivityForResult(paramString, 21);
      return;
    }
    if ((paramBoolean2) && (GesturePWDUtils.getJumpLock(paramJumpActivity, paramJumpActivity.app.getCurrentAccountUin())))
    {
      paramJumpActivity.startActivityForResult(new Intent(paramJumpActivity.getActivity(), GesturePWDUnlockActivity.class), 22);
      return;
    }
    JumpActivity.e = false;
    localObject = ((Intent)localObject).getDataString();
    localObject = bhey.a(paramJumpActivity.app, paramJumpActivity, (String)localObject);
    ((bheh)localObject).b(paramString);
    ((bheh)localObject).a();
    paramJumpActivity.finish();
  }
  
  public static boolean b(JumpActivity paramJumpActivity)
  {
    Intent localIntent = paramJumpActivity.getIntent();
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqdatamigration"))) {}
    for (;;)
    {
      return true;
      try
      {
        boolean bool = bhex.a(paramJumpActivity);
        if (bool) {}
      }
      catch (Throwable paramJumpActivity)
      {
        label43:
        break label43;
      }
    }
    return false;
  }
  
  public static boolean b(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getExtras();
        localObject1 = localObject3;
        StringBuilder localStringBuilder = new StringBuilder("system share.doShareCheckNeedSDPermission():");
        localObject1 = localObject3;
        localStringBuilder.append("phone info [mod:").append(Build.MODEL).append(",ver:").append(Build.VERSION.SDK).append(",maf:").append(Build.MANUFACTURER).append("]");
        localObject1 = localObject3;
        localObject4 = paramIntent.get("android.intent.extra.STREAM");
        paramIntent = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if (!(localObject4 instanceof Uri)) {
            continue;
          }
          localObject1 = localObject3;
          paramIntent = (Uri)localObject4;
        }
        localObject1 = paramIntent;
        localStringBuilder.append(",intent.extra=").append(paramIntent);
        localObject1 = paramIntent;
        QLog.i("JumpActivityHelper", 1, localStringBuilder.toString());
      }
      catch (Exception paramIntent)
      {
        Object localObject4;
        QLog.e("JumpActivityHelper", 1, "system share.doShareCheckNeedSDPermission() e=", paramIntent);
        paramIntent = (Intent)localObject1;
        continue;
        boolean bool = false;
        continue;
      }
      if (paramIntent == null) {
        break;
      }
      bool = avit.a(paramIntent, paramJumpActivity);
      QLog.d("JumpActivityHelper", 1, new Object[] { "system share.doShareCheckNeedSDPermission() canReadFromUri=", Boolean.valueOf(bool) });
      if (bool) {
        continue;
      }
      bool = true;
      return bool;
      paramIntent = localObject2;
      localObject1 = localObject3;
      if ((localObject4 instanceof String))
      {
        localObject1 = localObject3;
        paramIntent = Uri.parse((String)localObject4);
      }
    }
  }
  
  public static boolean b(JumpActivity paramJumpActivity, Intent paramIntent, bheh parambheh, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((parambheh.jdField_b_of_type_JavaLangString.equals("qqidentifier")) && (paramString3 == null))
    {
      QLog.e("JumpActivityHelper", 1, "can not get caller");
      paramJumpActivity.finish();
      return false;
    }
    if ((parambheh.jdField_b_of_type_JavaLangString.equals("puzzle_verify_code")) && (parambheh.jdField_c_of_type_JavaLangString != null))
    {
      paramIntent = new Intent(paramJumpActivity.getIntent());
      if (parambheh.jdField_c_of_type_JavaLangString.equals("PUZZLEVERIFYCODE"))
      {
        paramIntent.setClass(paramJumpActivity, QQBrowserActivity.class);
        bkki.a(paramJumpActivity.app);
        paramJumpActivity.startActivity(paramIntent);
      }
      for (;;)
      {
        paramJumpActivity.finish();
        return false;
        if (parambheh.jdField_c_of_type_JavaLangString.equals("VERIFYCODE"))
        {
          paramIntent.setClass(paramJumpActivity, VerifyCodeActivity.class);
          paramJumpActivity.startActivity(paramIntent);
        }
        else if (parambheh.jdField_c_of_type_JavaLangString.equals("DEVLOCK_CODE"))
        {
          paramIntent.setClass(paramJumpActivity, AuthDevUgActivity.class);
          paramJumpActivity.startActivity(paramIntent);
        }
        else if (parambheh.jdField_c_of_type_JavaLangString.equals("GATEVERIFY"))
        {
          PublicFragmentActivity.a(paramJumpActivity, paramIntent, NewAuthDevUgFragment.class);
        }
      }
    }
    if ((paramString1.startsWith("mqqwpa://im")) || (paramString1.startsWith("mqqwpaopenid://im")))
    {
      paramJumpActivity.b(true, paramString2, true);
      return false;
    }
    if ((paramString1.startsWith("mqqapi:")) && ((paramString3 == null) || ("com.tencent.mobileqq".equals(paramString3)))) {
      paramString3 = paramJumpActivity.getIntent().getStringExtra("pkg_name");
    }
    for (;;)
    {
      if ((paramString1.startsWith("mqqapi://im")) || (paramString1.startsWith("mqqapi://connect_miniapp")))
      {
        paramJumpActivity.d = paramString3;
        paramJumpActivity.a(true, paramString2, true);
        return false;
      }
      return a(paramJumpActivity, paramIntent, parambheh, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public static void c(JumpActivity paramJumpActivity)
  {
    auea.a(paramJumpActivity);
    audy.a("0X8005533");
    paramJumpActivity.finish();
  }
  
  public static void c(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    int i = 0;
    try
    {
      boolean bool = paramIntent.getBooleanExtra("IS_LOGIN_SUC_CALL", false);
      i = bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      Intent localIntent = new Intent();
      localIntent.setClass(paramJumpActivity, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QLINK_SHORTCUT_JUMP_KEY", paramIntent);
      paramJumpActivity.startActivity(localIntent);
      paramJumpActivity.finish();
      return;
    }
    if (!paramJumpActivity.app.isLogin()) {
      if (i != 0)
      {
        paramJumpActivity.finish();
        return;
      }
    }
    blyb.a(paramJumpActivity, 7, null);
    paramJumpActivity.finish();
  }
  
  public static void c(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    Intent localIntent = paramJumpActivity.getIntent();
    if (localIntent == null)
    {
      QLog.i("JumpActivityHelper", 1, "system share.doShare error intent is null");
      paramJumpActivity.finish();
      return;
    }
    if (localIntent.getExtras() == null)
    {
      QLog.i("JumpActivityHelper", 1, "system share.doShare error extra is null");
      paramJumpActivity.finish();
      return;
    }
    if (ForwardUtils.hasSDPermission(paramJumpActivity))
    {
      b(paramJumpActivity, paramBoolean);
      return;
    }
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShare", true, 0L, 0L, localHashMap, "");
    boolean bool = b(paramJumpActivity, localIntent);
    QLog.d("JumpActivityHelper", 1, new Object[] { "system share.doShare needGrantSDPermission=", Boolean.valueOf(bool) });
    if ((bool) && (Build.VERSION.SDK_INT >= 23))
    {
      PermissionUtils.requestStorePermission(paramJumpActivity, 3, new aoue(paramJumpActivity, paramBoolean));
      return;
    }
    b(paramJumpActivity, paramBoolean);
  }
  
  public static boolean c(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (("com.tencent.apollo.SHORT_CUT".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("jump_cm_game", false)))
    {
      if (!paramJumpActivity.app.isLogin())
      {
        a(paramJumpActivity);
        return false;
      }
      if (paramIntent.getBooleanExtra("jump_game_city", false))
      {
        ApolloGameUtil.a(paramJumpActivity.app, new aoug(paramJumpActivity, 0, null));
        return false;
      }
      if (paramIntent.getBooleanExtra("jump_cm_game", false))
      {
        int i = paramIntent.getIntExtra("jump_cm_game_id", -1);
        paramIntent = paramIntent.getStringExtra("jump_cm_extendinfo");
        ApolloGameUtil.a(paramJumpActivity.app, new aoug(paramJumpActivity, i, paramIntent));
        return false;
      }
    }
    if (("android.intent.action.VIEW".equals(paramIntent.getAction())) && (paramIntent.getIntExtra("MINI_CONFIG_SCENE", -1) > 0) && (!TextUtils.isEmpty(paramIntent.getStringExtra("CONFIG_APPID"))))
    {
      paramJumpActivity.a(true);
      return false;
    }
    if ("from_nearby_pb".equals(paramIntent.getStringExtra("from")))
    {
      a(paramJumpActivity, paramIntent);
      return false;
    }
    if ("from_gesturemgr_download".equals(paramIntent.getAction()))
    {
      paramJumpActivity.finish();
      return false;
    }
    if ("from_qavgpsomgr_download".equals(paramIntent.getAction()))
    {
      lmp.a();
      paramJumpActivity.finish();
      return false;
    }
    if ("from_webtool_launchshortvideo".equals(paramIntent.getAction()))
    {
      b(paramJumpActivity, paramIntent);
      return false;
    }
    if (("android.intent.action.SEND".equals(paramIntent.getAction())) || ("android.intent.action.SEND_MULTIPLE".equals(paramIntent.getAction())))
    {
      paramJumpActivity.c(true);
      return false;
    }
    if (("android.intent.action.VIEW".equals(paramIntent.getAction())) && (("file".equals(paramIntent.getScheme())) || ("content".equals(paramIntent.getScheme()))))
    {
      paramJumpActivity.b(true);
      return false;
    }
    return true;
  }
  
  public static void d(JumpActivity paramJumpActivity)
  {
    Intent localIntent = new Intent(paramJumpActivity, SplashActivity.class);
    localIntent.addFlags(268435456);
    paramJumpActivity.startActivity(localIntent);
    paramJumpActivity.finish();
  }
  
  public static void d(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramJumpActivity, QRBridgeActivity.class);
    localIntent.putExtras(paramIntent);
    paramJumpActivity.startActivity(localIntent);
    paramJumpActivity.finish();
  }
  
  public static boolean d(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (a(paramJumpActivity)) {
      return false;
    }
    if (("android.intent.action.SENDTO".equals(paramIntent.getAction())) && ("imto".equals(paramIntent.getScheme())))
    {
      paramJumpActivity.c();
      return false;
    }
    if ("thridapp".equals(paramIntent.getStringExtra("share_from"))) {
      return a(paramJumpActivity, paramIntent);
    }
    if ((("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_qlink_shortcut", false))) || (paramIntent.getBooleanExtra("_goto_qlink_when_login_suc_", false)))
    {
      paramJumpActivity.f(paramIntent);
      return false;
    }
    if (("com.tencent.qreader.SHORT_CUT".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("is_from_qreader_shortcut", false)))
    {
      paramJumpActivity.a(paramIntent);
      return false;
    }
    if ("com.tencent.qqcomic.SHORT_CUT".equals(paramIntent.getAction()))
    {
      paramJumpActivity.b(paramIntent);
      return false;
    }
    if ((("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_qfile_shortcut", false))) || (paramIntent.getBooleanExtra("_goto_qfile_when_login_suc_", false)))
    {
      paramJumpActivity.c(paramIntent);
      return false;
    }
    if ("com.tencent.smartdevice.SHORT_CUT".equals(paramIntent.getAction()))
    {
      paramJumpActivity.d(paramIntent);
      return false;
    }
    if ("kandianugc".equals(paramIntent.getScheme()))
    {
      paramJumpActivity.h(paramIntent);
      paramJumpActivity.finish();
      return false;
    }
    if (("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_kandian_shortcut", false)))
    {
      k(paramJumpActivity, paramIntent);
      return false;
    }
    if ("mqqdatamigration".equals(paramIntent.getScheme()))
    {
      l(paramJumpActivity, paramIntent);
      return false;
    }
    return true;
  }
  
  public static void e(JumpActivity paramJumpActivity)
  {
    Object localObject2 = bhex.a(paramJumpActivity);
    Object localObject1 = new StringBuilder();
    if ((localObject2 != null) && (!((HashSet)localObject2).isEmpty()))
    {
      localObject2 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append("|");
        }
        ((StringBuilder)localObject1).append(str);
      }
    }
    int j = 5;
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!((String)localObject1).contains("com.tencent.mm")) {
        break label140;
      }
      i = 1;
    }
    for (;;)
    {
      bdla.b(paramJumpActivity.app, "dc00898", "", "", "0X800B008", "0X800B008", i, 0, "", "", "", "");
      return;
      label140:
      if (((String)localObject1).contains("com.alibaba.android.rimet"))
      {
        i = 2;
      }
      else if (((String)localObject1).contains("com.tencent.wework"))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (((String)localObject1).contains("com.ss.android.lark.lite")) {
          i = 4;
        }
      }
    }
  }
  
  public static void e(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Intent localIntent;
    if (!paramJumpActivity.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(paramJumpActivity, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QREADER_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      paramJumpActivity.startActivity(localIntent);
      paramJumpActivity.finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(paramJumpActivity, paramJumpActivity.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(paramJumpActivity)))
    {
      localIntent = new Intent(paramJumpActivity.getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      paramJumpActivity.jdField_a_of_type_AndroidContentIntent = new Intent();
      paramJumpActivity.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
      paramJumpActivity.startActivityForResult(localIntent, 571);
      return;
    }
    d(paramJumpActivity, paramIntent);
  }
  
  public static boolean e(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (("mqq".equals(paramIntent.getScheme())) && ("mqq://".equals(paramIntent.getDataString())))
    {
      d(paramJumpActivity);
      return false;
    }
    if ("mqqaudioassistant".equals(paramIntent.getScheme()))
    {
      m(paramJumpActivity, paramIntent);
      return false;
    }
    if (("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction())) || ("com.tencent.mobileqq.action.buscard".equals(paramIntent.getAction())))
    {
      paramJumpActivity.e(paramIntent);
      return false;
    }
    if ("com.tencent.security.VERIFY_WEB".equals(paramIntent.getAction()))
    {
      paramJumpActivity.i(paramIntent);
      return false;
    }
    return true;
  }
  
  public static void f(JumpActivity paramJumpActivity)
  {
    try
    {
      if (paramJumpActivity.jdField_a_of_type_Aobq == null) {
        paramJumpActivity.jdField_a_of_type_Aobq = new aobq(paramJumpActivity.app.getAccount());
      }
      paramJumpActivity.startActivityForResult(new Intent(paramJumpActivity, QQMapActivity.class).putExtra("uin", paramJumpActivity.app.getAccount()), 18);
      return;
    }
    catch (Exception localException)
    {
      if (paramJumpActivity.jdField_c_of_type_Boolean) {
        a(paramJumpActivity, "Google Map not exist");
      }
      paramJumpActivity.finish();
    }
  }
  
  public static void f(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("comicID");
      if ((!((String)localObject).equalsIgnoreCase("0")) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        break label57;
      }
      localObject = new Intent(paramJumpActivity, VipComicJumpActivity.class);
    }
    for (;;)
    {
      ((Intent)localObject).putExtras(paramIntent);
      paramJumpActivity.startActivity((Intent)localObject);
      paramJumpActivity.finish();
      return;
      label57:
      localObject = new Intent(paramJumpActivity, QQBrowserActivity.class);
      ((Intent)localObject).setFlags(1073741824);
    }
  }
  
  public static boolean f(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    String str1 = paramJumpActivity.getIntent().getDataString();
    String str2 = paramJumpActivity.getIntent().getStringExtra("from");
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      Object localObject4 = localObject8;
      Object localObject6 = localObject1;
      if (i < 3) {
        localObject5 = localObject7;
      }
      for (;;)
      {
        try
        {
          localObject4 = paramJumpActivity.getCallingPackage();
          localObject2 = localObject4;
          localObject5 = localObject7;
          localObject1 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject5 = localObject7;
            localObject1 = localObject4;
            QLog.i("JumpActivityHelper", 1, "-->onCreate getCallingPackage returns null!");
            localObject5 = localObject7;
            localObject1 = localObject4;
            localObject2 = paramJumpActivity.getCallingActivity();
            if (localObject2 == null) {
              continue;
            }
            localObject5 = localObject7;
            localObject1 = localObject4;
            localObject4 = ((ComponentName)localObject2).getPackageName();
            localObject2 = localObject4;
            localObject5 = localObject7;
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject5 = localObject7;
              localObject1 = localObject4;
              QLog.i("JumpActivityHelper", 1, "-->onCreate get package from activity returns null!");
              localObject2 = localObject4;
            }
          }
          localObject5 = localObject7;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject5 = localObject7;
          localObject1 = localObject2;
          Object localObject9 = paramJumpActivity.getPackageManager().getPackageInfo((String)localObject2, 64);
          localObject4 = localObject8;
          localObject6 = localObject2;
          if (localObject9 != null)
          {
            localObject5 = localObject7;
            localObject1 = localObject2;
            localObject9 = ((PackageInfo)localObject9).signatures;
            localObject4 = localObject8;
            localObject6 = localObject2;
            if (localObject9 != null)
            {
              localObject4 = localObject8;
              localObject6 = localObject2;
              localObject5 = localObject7;
              localObject1 = localObject2;
              if (localObject9.length > 0)
              {
                localObject5 = localObject7;
                localObject1 = localObject2;
                localObject4 = MessageDigest.getInstance("MD5");
                localObject5 = localObject7;
                localObject1 = localObject2;
                ((MessageDigest)localObject4).update(localObject9[0].toByteArray());
                localObject5 = localObject7;
                localObject1 = localObject2;
                localObject4 = HexUtil.bytes2HexStr(((MessageDigest)localObject4).digest());
                if (localObject4 != null) {
                  continue;
                }
                localObject4 = "";
                localObject6 = localObject2;
              }
            }
          }
          localObject2 = localObject4;
          localObject1 = localObject6;
        }
        catch (Exception localException)
        {
          Object localObject2;
          Object localObject3 = localObject5;
          continue;
        }
        localObject4 = localObject1;
        if (localObject1 == null)
        {
          localObject4 = paramJumpActivity.getIntent().getStringExtra("pkg_name");
          localObject1 = StatisticCollector.getInstance(BaseApplication.getContext());
          localObject5 = new HashMap();
          ((HashMap)localObject5).put("osVersion", Build.VERSION.RELEASE);
          ((HashMap)localObject5).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
          ((StatisticCollector)localObject1).collectPerformance("", "GetCallingPackageEmpty", true, 0L, 0L, (HashMap)localObject5, "");
        }
        if (str1 == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpActivityHelper", 2, "jump url:" + str1);
        }
        localObject1 = bhey.a(paramJumpActivity.app, paramJumpActivity, str1);
        if (("webview".equals(str2)) && (localObject1 != null)) {
          ((bheh)localObject1).b(str2);
        }
        if ((localObject1 == null) || (((bheh)localObject1).jdField_b_of_type_JavaLangString == null)) {
          continue;
        }
        ((bheh)localObject1).jdField_a_of_type_Boolean = true;
        return b(paramJumpActivity, paramIntent, (bheh)localObject1, str1, str2, (String)localObject4, (String)localObject2);
        localObject5 = localObject7;
        localObject1 = localObject4;
        QLog.i("JumpActivityHelper", 1, "-->onCreate getCallingActivity returns null!");
        localObject2 = localObject4;
        continue;
        localObject5 = localObject4;
        localObject1 = localObject2;
        localObject4 = ((String)localObject4).toLowerCase();
        localObject6 = localObject2;
      }
      i += 1;
      localObject1 = localObject2;
    }
    paramIntent = paramJumpActivity.getIntent().getStringExtra("action");
    if (paramIntent == null)
    {
      paramJumpActivity.finish();
      return false;
    }
    paramJumpActivity.jdField_c_of_type_Boolean = paramJumpActivity.getIntent().getBooleanExtra("doCallBack", false);
    paramJumpActivity.jdField_a_of_type_JavaLangString = paramJumpActivity.getIntent().getStringExtra("src_type");
    paramJumpActivity.jdField_b_of_type_JavaLangString = paramJumpActivity.getIntent().getStringExtra("callback_type");
    paramJumpActivity.jdField_c_of_type_JavaLangString = paramJumpActivity.getIntent().getStringExtra("callback_name");
    if ("photo".equals(paramIntent))
    {
      paramJumpActivity.jdField_a_of_type_Boolean = true;
      if (!paramJumpActivity.jdField_a_of_type_Boolean) {
        break label704;
      }
    }
    for (;;)
    {
      return false;
      if (!"select_location".equals(paramIntent)) {
        break;
      }
      paramJumpActivity.jdField_b_of_type_Boolean = true;
      break;
      label704:
      if (paramJumpActivity.jdField_b_of_type_Boolean) {
        f(paramJumpActivity);
      }
    }
  }
  
  public static void g(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Intent localIntent;
    if (!paramJumpActivity.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(paramJumpActivity, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QQCOMIC_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      paramJumpActivity.startActivity(localIntent);
      paramJumpActivity.finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(paramJumpActivity, paramJumpActivity.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(paramJumpActivity)))
    {
      localIntent = new Intent(paramJumpActivity.getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      paramJumpActivity.jdField_b_of_type_AndroidContentIntent = new Intent();
      paramJumpActivity.jdField_b_of_type_AndroidContentIntent.putExtras(paramIntent);
      paramJumpActivity.startActivityForResult(localIntent, 572);
      return;
    }
    f(paramJumpActivity, paramIntent);
  }
  
  public static void h(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Intent localIntent;
    if (!paramJumpActivity.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(paramJumpActivity, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QFILE_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      paramJumpActivity.startActivity(localIntent);
      paramJumpActivity.finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(paramJumpActivity, paramJumpActivity.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(paramJumpActivity)))
    {
      localIntent = new Intent(paramJumpActivity.getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramIntent.getExtras());
      paramJumpActivity.startActivityForResult(localIntent, 570);
      return;
    }
    c(paramJumpActivity);
  }
  
  public static void i(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (!paramJumpActivity.app.isLogin())
    {
      a(paramJumpActivity);
      return;
    }
    if ((GesturePWDUtils.getJumpLock(paramJumpActivity, paramJumpActivity.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(paramJumpActivity)))
    {
      Intent localIntent = new Intent(paramJumpActivity.getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramIntent.getExtras());
      paramJumpActivity.startActivityForResult(localIntent, 573);
      return;
    }
    a(paramJumpActivity, paramIntent.getExtras());
  }
  
  public static void j(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Object localObject2 = paramIntent.getData();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new String(bhcu.decode(((Uri)localObject2).getQueryParameter("param"), 0));
      paramIntent = ((Uri)localObject2).getQueryParameter("appname");
      ((Uri)localObject2).getQueryParameter("src_type");
      ((Uri)localObject2).getQueryParameter("version");
      localObject2 = ((Uri)localObject2).getQueryParameter("share_id");
    }
    try
    {
      l = Long.parseLong((String)localObject2);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (l == 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpActivityHelper", 2, "app id is null,can not share");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      long l;
      do
      {
        do
        {
          for (;;)
          {
            l = 0L;
          }
          if ("wangzhe".equals(paramIntent)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("JumpActivityHelper", 2, "app name is not wangzhe");
        return;
        paramIntent = null;
        try
        {
          localObject1 = new JSONObject((String)localObject1).getString("url");
          paramIntent = (Intent)localObject1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
          Intent localIntent = new Intent(paramJumpActivity, ReadInJoyDeliverVideoActivity.class);
          localIntent.putExtra("arg_is_from_wang_zhe", true);
          localIntent.putExtra("arg_wang_zhe_app_id", l);
          paramJumpActivity.startActivity(localIntent);
        }
        if ((!paramJumpActivity.app.isLogin()) && (!TextUtils.isEmpty(paramIntent)))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(paramJumpActivity, LoginActivity.class);
          ((Intent)localObject1).putExtra("is_from_king_moment", true);
          ((Intent)localObject1).putExtra("king_moment_cover_url", paramIntent);
          ((Intent)localObject1).putExtra("arg_wang_zhe_app_id", l);
          paramJumpActivity.startActivity((Intent)localObject1);
          return;
        }
      } while (TextUtils.isEmpty(paramIntent));
      pvj.a().a(paramIntent, paramJumpActivity.app.getCurrentUin());
    }
  }
  
  public static void k(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    paramIntent.addFlags(524288);
    paramIntent.addFlags(134217728);
    paramIntent.putExtra("url", "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/bundle_feeds.js");
    paramIntent.putExtra(tvg.jdField_a_of_type_JavaLangString, "QQ看点");
    PublicFragmentActivity.a(paramJumpActivity.getActivity(), paramIntent, ViolaFragment.class);
    paramJumpActivity.getActivity().overridePendingTransition(2130771997, 0);
    paramJumpActivity.finish();
  }
  
  public static void l(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramJumpActivity, DataMigrationService.class);
    localIntent.setAction("com.tencent.mobileqq.action.MIGRATION_DATA");
    localIntent.putExtras(paramIntent);
    try
    {
      paramJumpActivity.startService(localIntent);
      paramJumpActivity.finish();
      return;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        QLog.e("JumpActivityHelper", 1, "mqqdatamigration", paramIntent);
      }
    }
  }
  
  public static void m(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    QLog.d("JumpActivityHelper", 1, "get mqqaudioassistant Jump");
    Object localObject1 = paramIntent.getData();
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((Uri)localObject1).getQueryParameter("jumpaction");
      QLog.d("JumpActivityHelper", 1, String.format("mqqaudioassistant Jump args host = %s, \nPath = %s, \ntype = %s \nEXTRA_TEXT = %s", new Object[] { ((Uri)localObject1).getHost(), ((Uri)localObject1).getPath(), ((Uri)localObject1).getQueryParameter("type"), paramIntent.getStringExtra("android.intent.extra.TEXT") }));
      Object localObject2 = (baki)paramJumpActivity.app.getManager(QQManagerFactory.QASSISTANT_MANAGER);
      localObject1 = ((Uri)localObject1).getHost();
      if (((baki)localObject2).a((String)localObject1))
      {
        localObject2 = ((baki)localObject2).a((String)localObject3, (String)localObject1);
        if (localObject2 != null)
        {
          if (((bakd)localObject2).jdField_a_of_type_JavaUtilHashMap.size() > 0)
          {
            localObject3 = ((bakd)localObject2).jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              String str1 = (String)((Iterator)localObject3).next();
              if (paramIntent.hasExtra(str1))
              {
                String str2 = paramIntent.getStringExtra(str1);
                if (!StringUtil.isEmpty(str2)) {
                  ((bakd)localObject2).jdField_a_of_type_JavaUtilHashMap.put(str1, str2);
                }
              }
            }
          }
          ((bakd)localObject2).g = ((String)localObject1);
          ((bakd)localObject2).a(paramJumpActivity);
        }
      }
    }
    for (;;)
    {
      paramJumpActivity.finish();
      return;
      bakg.a((String)localObject1, (String)localObject3, 2);
      QLog.d("JumpActivityHelper", 1, "mqqaudioassistant Jump item = null");
      continue;
      bakg.a((String)localObject1, "", 1);
      continue;
      bakg.a("", "", 101);
    }
  }
  
  public static void n(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getParcelableExtra("extra_data");
      if ((!TextUtils.isEmpty(paramIntent.getStringExtra("url"))) && (((localObject instanceof InviteToGroupInfo)) || ((localObject instanceof JoinGroupInfo))))
      {
        localObject = new Intent(paramJumpActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtras(paramIntent);
        paramJumpActivity.startActivityForResult((Intent)localObject, 25);
        return;
      }
      QLog.d("Q.security_verify", 1, "goToWebSecVerify, error param!");
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QLog.d("Q.security_verify", 1, "goToWebSecVerify", paramIntent);
      }
    }
    paramJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoud
 * JD-Core Version:    0.7.0.1
 */