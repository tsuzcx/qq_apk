package com.tencent.mobileqq.app.parser;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.JumpActivity.ShareTask;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.parser.jumpcontroller.IJumpControllerInterface;
import com.tencent.mobileqq.app.parser.jumpcontroller.JumpActivityInjectUtil;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleLaunchParam;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpForwardPkgManager;
import com.tencent.mobileqq.utils.JumpForwardPkgUtil;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class JumpActivityHelper
{
  private static IJumpControllerInterface a;
  
  static
  {
    try
    {
      if (JumpActivityInjectUtil.a.size() > 0)
      {
        a = (IJumpControllerInterface)((Class)JumpActivityInjectUtil.a.get(0)).newInstance();
        QLog.d("JumpActivityHelper", 1, "JumpActivityHelper newInstance");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("JumpActivityHelper", 1, "JumpActivityHelper static statement: ", localException);
    }
  }
  
  public static int a(JumpActivity paramJumpActivity, Bundle paramBundle, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("req_type", Base64Util.encodeToString("5".getBytes(), 0));
    boolean bool = paramJumpActivity.getIntent().getAction().equals("android.intent.action.SEND");
    Object localObject1 = null;
    Object localObject3;
    if (bool)
    {
      localObject3 = paramBundle.get("android.intent.extra.STREAM");
      if (localObject3 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|action_send extra_stream null");
        }
        return 1;
      }
      if ((localObject3 instanceof Uri))
      {
        paramBundle = (Uri)localObject3;
      }
      else
      {
        paramBundle = (Bundle)localObject1;
        if ((localObject3 instanceof String)) {
          paramBundle = Uri.parse((String)localObject3);
        }
      }
      if (paramBundle == null) {
        return 1;
      }
      paramBundle = ((IQJumpApi)QRoute.api(IQJumpApi.class)).forwardGetFilePath(paramJumpActivity, paramBundle);
      if ((!TextUtils.isEmpty(paramBundle)) && (new File(paramBundle).exists()))
      {
        try
        {
          localObject1 = URLEncoder.encode(paramBundle, "UTF-8");
          paramHashMap.put("file_data", Base64Util.encodeToString(((String)localObject1).getBytes(), 0));
        }
        catch (UnsupportedEncodingException paramJumpActivity)
        {
          if (QLog.isColorLevel())
          {
            paramHashMap = new StringBuilder();
            paramHashMap.append("startSystemShareToQQFav|encode fail. path=");
            paramHashMap.append(paramBundle);
            paramHashMap.append(",exp:");
            paramHashMap.append(paramJumpActivity.getMessage());
            QLog.d("JumpActivityHelper", 2, paramHashMap.toString());
          }
          return 1;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramJumpActivity = new StringBuilder();
          paramJumpActivity.append("startSystemShareToQQFav|action_send file path invalid. path=");
          paramJumpActivity.append(paramBundle);
          QLog.d("JumpActivityHelper", 2, paramJumpActivity.toString());
        }
        return 1;
      }
    }
    else
    {
      try
      {
        paramBundle = (ArrayList)paramBundle.get("android.intent.extra.STREAM");
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        paramBundle = null;
      }
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|action_send_muti extra_stream null");
        }
        return 1;
      }
      localObject3 = new ArrayList();
      int i = 0;
      while (i < paramBundle.size())
      {
        localObject1 = (Uri)paramBundle.get(i);
        localObject1 = ((IQJumpApi)QRoute.api(IQJumpApi.class)).forwardGetFilePath(paramJumpActivity, (Uri)localObject1);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists())) {
          try
          {
            ((ArrayList)localObject3).add(URLEncoder.encode((String)localObject1, "UTF-8"));
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("startSystemShareToQQFav|action_send_muti path encode fail: %s");
              localStringBuilder.append(localUnsupportedEncodingException.getMessage());
              QLog.d("JumpActivityHelper", 2, localStringBuilder.toString());
            }
          }
        }
        i += 1;
      }
      if (((ArrayList)localObject3).isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|action_send_muti pathlist empty");
        }
        return 1;
      }
      paramBundle = "";
      i = 0;
      while (i < ((ArrayList)localObject3).size())
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramBundle);
        ((StringBuilder)localObject2).append((String)((ArrayList)localObject3).get(i));
        localObject2 = ((StringBuilder)localObject2).toString();
        paramBundle = (Bundle)localObject2;
        if (i != ((ArrayList)localObject3).size() - 1)
        {
          paramBundle = new StringBuilder();
          paramBundle.append((String)localObject2);
          paramBundle.append(";");
          paramBundle = paramBundle.toString();
        }
        i += 1;
      }
      paramHashMap.put("file_data", Base64Util.encodeToString(paramBundle.getBytes(), 0));
    }
    return paramJumpActivity.qqFavDoAction(paramHashMap);
  }
  
  public static int a(JumpActivity paramJumpActivity, Bundle paramBundle, HashMap<String, String> paramHashMap, Uri paramUri, String paramString)
  {
    boolean bool = paramBundle.containsKey("android.intent.extra.STREAM");
    paramBundle = "";
    if (!bool)
    {
      paramHashMap.put("req_type", Base64Util.encodeToString("6".getBytes(), 0));
      if (!TextUtils.isEmpty(paramString)) {
        paramBundle = Base64Util.encodeToString(paramString.getBytes(), 0);
      }
      paramHashMap.put("description", paramBundle);
    }
    else if (paramUri != null)
    {
      paramString = null;
      try
      {
        paramUri = paramJumpActivity.getContentResolver().openInputStream(paramUri);
        try
        {
          String str = a(paramUri);
          paramUri.close();
          if (TextUtils.isEmpty(str))
          {
            if (!QLog.isColorLevel()) {
              break label229;
            }
            QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|text, extra_stream, empty");
            return 1;
          }
          paramHashMap.put("req_type", Base64Util.encodeToString("6".getBytes(), 0));
          if (!TextUtils.isEmpty(str)) {
            paramBundle = Base64Util.encodeToString(str.getBytes(), 0);
          }
          paramHashMap.put("description", paramBundle);
        }
        catch (Exception paramJumpActivity)
        {
          paramBundle = paramUri;
        }
        paramHashMap = new StringBuilder();
      }
      catch (Exception paramJumpActivity)
      {
        paramBundle = paramString;
      }
      paramHashMap.append("startSystemShareToQQFav|text, extra_stream, exp:");
      paramHashMap.append(paramJumpActivity.getMessage());
      QLog.d("JumpActivityHelper", 1, paramHashMap.toString());
      if (paramBundle != null) {
        try
        {
          paramBundle.close();
          return 1;
        }
        catch (IOException paramJumpActivity)
        {
          paramJumpActivity.printStackTrace();
        }
      }
      return 1;
    }
    return paramJumpActivity.qqFavDoAction(paramHashMap);
    label229:
    return 1;
  }
  
  public static int a(JumpActivity paramJumpActivity, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      QLog.e("JumpActivityHelper", 1, "qqFavDoAction error: params are null");
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
    paramJumpActivity = JumpParser.a((BaseQQAppInterface)paramJumpActivity.getAppRuntime(), paramJumpActivity, localStringBuilder.toString());
    if (paramJumpActivity == null)
    {
      QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|jump parse fail");
      return 1;
    }
    paramJumpActivity.a();
    QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|end");
    return 0;
  }
  
  private static Uri a(Uri paramUri)
  {
    Object localObject1 = paramUri;
    Object localObject2;
    File localFile;
    if (paramUri != null)
    {
      localObject1 = paramUri;
      if ("file".equals(paramUri.getScheme()))
      {
        localObject2 = paramUri.getPath();
        localObject1 = paramUri;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localFile = new File((String)localObject2);
          localObject1 = paramUri;
          if (!localFile.exists()) {}
        }
      }
    }
    try
    {
      localObject1 = localFile.getCanonicalPath();
      QLog.d("JumpActivityHelper", 1, new Object[] { "checkAndRebuildFileUri path", localObject2, ", actFilePath=", localObject1 });
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(BaseForwardUtil.a());
      ((StringBuilder)localObject2).append(BaseApplication.getContext().getPackageName());
      if ((((String)localObject1).startsWith(((StringBuilder)localObject2).toString()) ^ true))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("file://");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = Uri.parse(((StringBuilder)localObject2).toString());
        return localObject1;
      }
      localObject1 = null;
      return localObject1;
    }
    catch (Exception localException) {}
    return paramUri;
  }
  
  /* Error */
  public static Uri a(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 327	android/content/Context
    //   6: astore 12
    //   8: aload_0
    //   9: iconst_1
    //   10: aaload
    //   11: checkcast 113	android/net/Uri
    //   14: astore 13
    //   16: ldc_w 329
    //   19: astore_2
    //   20: getstatic 335	com/tencent/mobileqq/app/AppConstants:SDCARD_SHARE_VCARD	Ljava/lang/String;
    //   23: astore 11
    //   25: aconst_null
    //   26: astore 8
    //   28: aconst_null
    //   29: astore 9
    //   31: aconst_null
    //   32: astore 6
    //   34: aconst_null
    //   35: astore 7
    //   37: aconst_null
    //   38: astore 10
    //   40: aload 12
    //   42: invokevirtual 336	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   45: aload 13
    //   47: iconst_1
    //   48: anewarray 64	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: ldc_w 338
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 342	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 5
    //   65: aload_2
    //   66: astore_0
    //   67: aload 5
    //   69: ifnull +46 -> 115
    //   72: aload_2
    //   73: astore_0
    //   74: aload_2
    //   75: astore_3
    //   76: aload_2
    //   77: astore 4
    //   79: aload 5
    //   81: invokeinterface 347 1 0
    //   86: ifeq +29 -> 115
    //   89: aload_2
    //   90: astore_3
    //   91: aload_2
    //   92: astore 4
    //   94: aload 5
    //   96: iconst_0
    //   97: invokeinterface 351 2 0
    //   102: astore_0
    //   103: aload_0
    //   104: astore_3
    //   105: aload_0
    //   106: astore 4
    //   108: aload 5
    //   110: invokeinterface 352 1 0
    //   115: aload_0
    //   116: astore_3
    //   117: aload_0
    //   118: astore 4
    //   120: aload 11
    //   122: invokestatic 357	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   125: ifne +21 -> 146
    //   128: aload_0
    //   129: astore_3
    //   130: aload_0
    //   131: astore 4
    //   133: new 137	java/io/File
    //   136: dup
    //   137: aload 11
    //   139: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: invokevirtual 360	java/io/File:mkdirs	()Z
    //   145: pop
    //   146: aload_0
    //   147: astore_3
    //   148: aload_0
    //   149: astore 4
    //   151: new 155	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   158: astore_2
    //   159: aload_0
    //   160: astore_3
    //   161: aload_0
    //   162: astore 4
    //   164: aload_2
    //   165: aload 11
    //   167: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_0
    //   172: astore_3
    //   173: aload_0
    //   174: astore 4
    //   176: aload_2
    //   177: aload_0
    //   178: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_0
    //   183: astore_3
    //   184: aload_0
    //   185: astore 4
    //   187: new 362	java/io/FileOutputStream
    //   190: dup
    //   191: new 137	java/io/File
    //   194: dup
    //   195: aload_2
    //   196: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: invokespecial 365	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   205: astore 6
    //   207: aload 8
    //   209: astore_2
    //   210: aload 9
    //   212: astore_3
    //   213: aload 12
    //   215: invokevirtual 336	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   218: aload 13
    //   220: ldc_w 367
    //   223: invokevirtual 371	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   226: astore 7
    //   228: aload 10
    //   230: astore 4
    //   232: aload 7
    //   234: ifnull +77 -> 311
    //   237: aload 8
    //   239: astore_2
    //   240: aload 9
    //   242: astore_3
    //   243: aload 7
    //   245: invokevirtual 377	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   248: astore 4
    //   250: aload 4
    //   252: astore_2
    //   253: aload 4
    //   255: astore_3
    //   256: sipush 1024
    //   259: newarray byte
    //   261: astore 7
    //   263: aload 4
    //   265: astore_2
    //   266: aload 4
    //   268: astore_3
    //   269: aload 4
    //   271: aload 7
    //   273: invokevirtual 381	java/io/InputStream:read	([B)I
    //   276: istore_1
    //   277: iload_1
    //   278: iconst_m1
    //   279: if_icmpeq +21 -> 300
    //   282: aload 4
    //   284: astore_2
    //   285: aload 4
    //   287: astore_3
    //   288: aload 6
    //   290: aload 7
    //   292: iconst_0
    //   293: iload_1
    //   294: invokevirtual 385	java/io/FileOutputStream:write	([BII)V
    //   297: goto -34 -> 263
    //   300: aload 4
    //   302: astore_2
    //   303: aload 4
    //   305: astore_3
    //   306: aload 6
    //   308: invokevirtual 388	java/io/FileOutputStream:flush	()V
    //   311: aload 5
    //   313: ifnull +10 -> 323
    //   316: aload 5
    //   318: invokeinterface 352 1 0
    //   323: aload 4
    //   325: ifnull +16 -> 341
    //   328: aload 4
    //   330: invokevirtual 226	java/io/InputStream:close	()V
    //   333: goto +8 -> 341
    //   336: astore_2
    //   337: aload_2
    //   338: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   341: aload 6
    //   343: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   346: goto +8 -> 354
    //   349: astore_2
    //   350: aload_2
    //   351: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   354: new 155	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   361: astore_3
    //   362: goto +146 -> 508
    //   365: astore_3
    //   366: aload 6
    //   368: astore 4
    //   370: aload_2
    //   371: astore 6
    //   373: goto +172 -> 545
    //   376: astore 7
    //   378: aload 6
    //   380: astore 4
    //   382: aload_0
    //   383: astore_2
    //   384: aload 7
    //   386: astore_0
    //   387: goto +31 -> 418
    //   390: astore_2
    //   391: aconst_null
    //   392: astore 4
    //   394: aload_3
    //   395: astore_0
    //   396: aload 7
    //   398: astore 6
    //   400: aload_2
    //   401: astore_3
    //   402: goto +143 -> 545
    //   405: astore_0
    //   406: aconst_null
    //   407: astore_3
    //   408: aload_3
    //   409: astore 6
    //   411: aload 4
    //   413: astore_2
    //   414: aload 6
    //   416: astore 4
    //   418: goto +30 -> 448
    //   421: astore_3
    //   422: aconst_null
    //   423: astore 5
    //   425: aload 5
    //   427: astore 4
    //   429: aload_2
    //   430: astore_0
    //   431: aload 7
    //   433: astore 6
    //   435: goto +110 -> 545
    //   438: astore_0
    //   439: aconst_null
    //   440: astore_3
    //   441: aload_3
    //   442: astore 4
    //   444: aload 6
    //   446: astore 5
    //   448: aload_0
    //   449: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   452: aload 5
    //   454: ifnull +10 -> 464
    //   457: aload 5
    //   459: invokeinterface 352 1 0
    //   464: aload_3
    //   465: ifnull +15 -> 480
    //   468: aload_3
    //   469: invokevirtual 226	java/io/InputStream:close	()V
    //   472: goto +8 -> 480
    //   475: astore_0
    //   476: aload_0
    //   477: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   480: aload 4
    //   482: ifnull +16 -> 498
    //   485: aload 4
    //   487: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   490: goto +8 -> 498
    //   493: astore_0
    //   494: aload_0
    //   495: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   498: new 155	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   505: astore_3
    //   506: aload_2
    //   507: astore_0
    //   508: aload_3
    //   509: ldc_w 324
    //   512: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_3
    //   517: aload 11
    //   519: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_3
    //   524: aload_0
    //   525: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload_3
    //   530: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 117	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   536: areturn
    //   537: astore_0
    //   538: aload_3
    //   539: astore 6
    //   541: aload_0
    //   542: astore_3
    //   543: aload_2
    //   544: astore_0
    //   545: aload 5
    //   547: ifnull +10 -> 557
    //   550: aload 5
    //   552: invokeinterface 352 1 0
    //   557: aload 6
    //   559: ifnull +16 -> 575
    //   562: aload 6
    //   564: invokevirtual 226	java/io/InputStream:close	()V
    //   567: goto +8 -> 575
    //   570: astore_2
    //   571: aload_2
    //   572: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   575: aload 4
    //   577: ifnull +16 -> 593
    //   580: aload 4
    //   582: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   585: goto +8 -> 593
    //   588: astore_2
    //   589: aload_2
    //   590: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   593: new 155	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   600: astore_2
    //   601: aload_2
    //   602: ldc_w 324
    //   605: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload_2
    //   610: aload 11
    //   612: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload_2
    //   617: aload_0
    //   618: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_2
    //   623: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 117	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   629: pop
    //   630: goto +5 -> 635
    //   633: aload_3
    //   634: athrow
    //   635: goto -2 -> 633
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramArrayOfObject	Object[]
    //   276	18	1	i	int
    //   19	284	2	localObject1	Object
    //   336	2	2	localIOException1	IOException
    //   349	22	2	localIOException2	IOException
    //   383	1	2	arrayOfObject	Object[]
    //   390	11	2	localObject2	Object
    //   413	131	2	localObject3	Object
    //   570	2	2	localIOException3	IOException
    //   588	2	2	localIOException4	IOException
    //   600	23	2	localStringBuilder	StringBuilder
    //   75	287	3	localObject4	Object
    //   365	30	3	localObject5	Object
    //   401	8	3	localObject6	Object
    //   421	1	3	localObject7	Object
    //   440	194	3	localObject8	Object
    //   77	504	4	localObject9	Object
    //   63	488	5	localObject10	Object
    //   32	531	6	localObject11	Object
    //   35	256	7	localObject12	Object
    //   376	56	7	localException	Exception
    //   26	212	8	localObject13	Object
    //   29	212	9	localObject14	Object
    //   38	191	10	localObject15	Object
    //   23	588	11	str	String
    //   6	208	12	localContext	Context
    //   14	205	13	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   328	333	336	java/io/IOException
    //   341	346	349	java/io/IOException
    //   213	228	365	finally
    //   243	250	365	finally
    //   256	263	365	finally
    //   269	277	365	finally
    //   288	297	365	finally
    //   306	311	365	finally
    //   213	228	376	java/lang/Exception
    //   243	250	376	java/lang/Exception
    //   256	263	376	java/lang/Exception
    //   269	277	376	java/lang/Exception
    //   288	297	376	java/lang/Exception
    //   306	311	376	java/lang/Exception
    //   79	89	390	finally
    //   94	103	390	finally
    //   108	115	390	finally
    //   120	128	390	finally
    //   133	146	390	finally
    //   151	159	390	finally
    //   164	171	390	finally
    //   176	182	390	finally
    //   187	207	390	finally
    //   79	89	405	java/lang/Exception
    //   94	103	405	java/lang/Exception
    //   108	115	405	java/lang/Exception
    //   120	128	405	java/lang/Exception
    //   133	146	405	java/lang/Exception
    //   151	159	405	java/lang/Exception
    //   164	171	405	java/lang/Exception
    //   176	182	405	java/lang/Exception
    //   187	207	405	java/lang/Exception
    //   40	65	421	finally
    //   40	65	438	java/lang/Exception
    //   468	472	475	java/io/IOException
    //   485	490	493	java/io/IOException
    //   448	452	537	finally
    //   562	567	570	java/io/IOException
    //   580	585	588	java/io/IOException
  }
  
  public static String a(Context paramContext)
  {
    return a.c(paramContext);
  }
  
  private static String a(InputStream paramInputStream)
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
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast localQQToast = QQToast.makeText(paramContext, paramInt2, paramInt1, 2000);
    paramInt1 = paramContext.getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(paramContext, 5.0F);
    paramContext = Looper.getMainLooper();
    if (Thread.currentThread() != paramContext.getThread())
    {
      new Handler(paramContext).post(new JumpActivityHelper.2(localQQToast, paramInt1));
      return;
    }
    localQQToast.show(paramInt1);
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
          String str = JumpActivity.getFragmentName(paramContext);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.getClass().getName());
          if (TextUtils.isEmpty(str))
          {
            paramContext = "";
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append("$");
            paramContext.append(str);
            paramContext = paramContext.toString();
          }
          ((StringBuilder)localObject).append(paramContext);
          paramIntent.putExtra("SourceActivityName", ((StringBuilder)localObject).toString());
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
      Object localObject1 = Uri.parse(str).getScheme();
      boolean bool2 = JumpActivity.isLegalScheme((String)localObject1);
      boolean bool1 = false;
      if (bool2) {
        bool1 = JumpActivity.needForceSetComponent((String)localObject1);
      }
      Object localObject2;
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processIntent, scheme[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("], isLegalScheme[");
        ((StringBuilder)localObject2).append(bool2);
        ((StringBuilder)localObject2).append("], needForceSetComponent[");
        ((StringBuilder)localObject2).append(bool1);
        ((StringBuilder)localObject2).append("]");
        QLog.w("JumpActivityHelper", 1, ((StringBuilder)localObject2).toString());
      }
      if ((bool2) && (bool1))
      {
        localObject1 = StatisticCollector.getInstance(BaseApplication.getContext());
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("URL", str);
        ((StatisticCollector)localObject1).collectPerformance("", "JA_ILLEGAL", true, 0L, 0L, (HashMap)localObject2, "");
        paramIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
      }
    }
  }
  
  public static void a(JumpActivity paramJumpActivity)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    RouteUtils.a(paramJumpActivity, localIntent, "/base/install");
    paramJumpActivity.finish();
  }
  
  public static void a(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    int i = 0;
    try
    {
      boolean bool = paramIntent.getBooleanExtra("IS_LOGIN_SUC_CALL", false);
      i = bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (!paramJumpActivity.getAppRuntime().isLogin())
    {
      if (i != 0)
      {
        paramJumpActivity.finish();
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67371008);
      localIntent.putExtra("QLINK_SHORTCUT_JUMP_KEY", paramIntent);
      RouteUtils.a(paramJumpActivity, localIntent, "/base/login");
      paramJumpActivity.finish();
      return;
    }
    a.a(paramJumpActivity);
    paramJumpActivity.finish();
  }
  
  public static void a(JumpActivity paramJumpActivity, Intent paramIntent, int paramInt)
  {
    try
    {
      if (paramJumpActivity.mBgThread == null)
      {
        paramJumpActivity.mBgThread = ThreadManager.newFreeHandlerThread("jump_action_thread", 0);
        paramJumpActivity.mBgThread.start();
        paramJumpActivity.mBgHandler = new MqqHandler(paramJumpActivity.mBgThread.getLooper());
      }
      a.a(paramJumpActivity, paramIntent, paramInt);
      return;
    }
    finally {}
  }
  
  public static void a(JumpActivity paramJumpActivity, Intent paramIntent, Bundle paramBundle)
  {
    new JumpActivityHelper.1(paramJumpActivity, paramIntent, paramBundle).run();
  }
  
  public static void a(JumpActivity paramJumpActivity, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str = paramBundle.getString("din");
      paramBundle = paramBundle.getString("qrurl");
      if (!TextUtils.isEmpty(str)) {
        a.a(paramJumpActivity, str, paramBundle);
      }
    }
    paramJumpActivity.finish();
  }
  
  private static void a(JumpActivity paramJumpActivity, JumpAction paramJumpAction, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpActivityHelper", 2, "JumpActivity is finish");
    }
    if ((paramJumpAction.d != null) && (paramJumpAction.e != null))
    {
      if (a(paramJumpAction, "gav", "request"))
      {
        if ((!"0".equals(paramJumpAction.b("relation_id"))) && (paramBoolean)) {
          paramJumpActivity.finish();
        }
      }
      else if ((!a(paramJumpAction, "videochat", "request")) && (!a(paramJumpAction, "randomavchat", "request")))
      {
        if (a(paramJumpAction, "wallet", "modify_pass"))
        {
          if (paramBoolean) {
            paramJumpActivity.finish();
          }
        }
        else if (paramJumpAction.m())
        {
          if (paramBoolean) {
            paramJumpActivity.finish();
          }
        }
        else
        {
          if (a(paramJumpAction, "qcircle", "opendetail"))
          {
            paramJumpActivity.finish();
            return;
          }
          if (a(paramJumpAction, "readinjoy", "open"))
          {
            QLog.i("JumpActivityHelper", 1, "[beforeFinish] kd open.");
            paramJumpActivity.finish();
            return;
          }
          if (b(paramJumpActivity, paramJumpAction))
          {
            QLog.d("JumpActivityHelper", 1, "asynShareJumpAction wait for finishing");
            return;
          }
          if (!c(paramJumpActivity, paramJumpAction))
          {
            if (paramJumpAction.v)
            {
              paramJumpActivity.finish();
              paramJumpActivity.overridePendingTransition(0, 0);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("JumpActivityHelper", 2, "wait for finishing");
            }
          }
          else
          {
            paramJumpActivity.initBroadcastReceiver();
          }
        }
      }
      else if (paramBoolean) {
        paramJumpActivity.finish();
      }
    }
    else {
      paramJumpActivity.finish();
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, String paramString)
  {
    if ((paramString != null) && (paramJumpActivity.callbackName != null) && (paramJumpActivity.callbackType != null))
    {
      if (paramJumpActivity.srcType == null) {
        return;
      }
      if ("app".equals(paramJumpActivity.srcType)) {
        return;
      }
      if ("web".equals(paramJumpActivity.srcType))
      {
        if ("javascript".equals(paramJumpActivity.callbackType))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("javascript:");
          ((StringBuilder)localObject).append(paramJumpActivity.callbackName);
          ((StringBuilder)localObject).append("('");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("')");
          paramString = ((StringBuilder)localObject).toString();
          localObject = new Intent();
          ((Intent)localObject).putExtra("uin", paramJumpActivity.getAppRuntime().getCurrentAccountUin());
          ((Intent)localObject).setData(Uri.parse(paramString));
          RouteUtils.a(paramJumpActivity, (Intent)localObject, "/base/browser");
        }
      }
      else {
        "internal".equals(paramJumpActivity.srcType);
      }
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, DevlockInfo paramDevlockInfo)
  {
    a.a(paramJumpActivity, paramDevlockInfo);
    paramJumpActivity.finish();
  }
  
  public static void a(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    Object localObject3 = paramJumpActivity.getIntent();
    Object localObject2 = ((Intent)localObject3).getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!paramJumpActivity.getAppRuntime().isLogin()))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras((Intent)localObject3);
      RouteUtils.a(paramJumpActivity, (Intent)localObject2, "/base/login", 24);
      return;
    }
    localObject2 = ((Intent)localObject3).getStringExtra("CONFIG_APPID");
    localObject1 = ((Intent)localObject3).getStringExtra("CONFIG_APPNAME");
    String str1 = ((Intent)localObject3).getStringExtra("CONFIG_APPICON");
    String str2 = ((Intent)localObject3).getStringExtra("MINI_CONFIG_DEV_DESC");
    int m = ((Intent)localObject3).getIntExtra("CONFIG_VER_TYPE", 3);
    int j = ((Intent)localObject3).getIntExtra("CONFIG_REPORTTYPE", 0);
    int i = ((Intent)localObject3).getIntExtra("CONFIG_ENGINETYPE", 0);
    int k = ((Intent)localObject3).getIntExtra("CONFIG_APPTYPE", -1);
    if (k != -1)
    {
      i = k;
      j = i;
    }
    k = ((Intent)localObject3).getIntExtra("MINI_CONFIG_SCENE", 10086);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)))
    {
      localObject3 = new SimpleMiniAppConfig.SimpleMiniAppInfo();
      ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject3).appId = ((String)localObject2);
      ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject3).name = ((String)localObject1);
      ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject3).iconUrl = str1;
      ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject3).setEngineType(i);
      ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject3).setReportType(j);
      ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject3).developerDesc = str2;
      ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject3).verType = m;
      localObject1 = new SimpleMiniAppConfig((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject3);
      ((SimpleMiniAppConfig)localObject1).launchParam = new SimpleMiniAppConfig.SimpleLaunchParam();
      ((SimpleMiniAppConfig)localObject1).launchParam.miniAppId = ((String)localObject2);
      ((SimpleMiniAppConfig)localObject1).launchParam.scene = k;
    }
    else
    {
      localObject1 = null;
    }
    if ((localObject1 != null) && (k == 1023) && (((SimpleMiniAppConfig)localObject1).config.isEngineTypeMiniGame())) {
      ((IQJumpApi)QRoute.api(IQJumpApi.class)).handleByColorNote();
    }
    if (localObject1 != null) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startApp(paramJumpActivity, (SimpleMiniAppConfig)localObject1, null);
    }
    paramJumpActivity.moveTaskToBack(true);
    paramJumpActivity.finish();
  }
  
  public static void a(JumpActivity paramJumpActivity, boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      paramJumpActivity.uiHandler.sendEmptyMessage(1);
      if ((paramBoolean) && (paramInt1 == 0) && (paramInt2 == 1))
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = new Intent();
          paramString2.putExtra("url", paramString1);
          paramString2.putExtra("hide_more_button", true);
          RouteUtils.a(paramJumpActivity, paramString2, "/base/browser");
        }
        paramJumpActivity.finish();
        return;
      }
      if ((!"android.intent.action.SEND".equals(paramString2)) && (!"android.intent.action.SEND_MULTIPLE".equals(paramString2)))
      {
        if ("android.intent.action.VIEW".equals(paramString2))
        {
          Intent localIntent = paramJumpActivity.getIntent();
          paramString2 = localIntent.getExtras();
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = new Bundle();
          }
          paramJumpActivity.doView(localIntent, paramString1);
        }
      }
      else
      {
        paramJumpActivity.doShare(paramJumpActivity.getIntent().getExtras());
        return;
      }
    }
    catch (Throwable paramJumpActivity)
    {
      QLog.e("JumpActivityHelper", 1, paramJumpActivity, new Object[0]);
    }
  }
  
  public static void a(JumpActivity paramJumpActivity, boolean paramBoolean, Intent paramIntent)
  {
    a.a(paramJumpActivity, paramBoolean, paramIntent);
  }
  
  public static void a(JumpActivity paramJumpActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = paramJumpActivity.getIntent();
    if ((paramBoolean1) && (!paramJumpActivity.getAppRuntime().isLogin()))
    {
      JumpActivity.sIsStartFromThirdParty = true;
      paramString = new Intent();
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      RouteUtils.a(paramJumpActivity, paramString, "/base/login", 26);
      return;
    }
    if ((paramBoolean2) && (((IQJumpApi)QRoute.api(IQJumpApi.class)).gestureGetJumpLock(paramJumpActivity, paramJumpActivity.getAppRuntime().getCurrentAccountUin())))
    {
      RouteUtils.a(paramJumpActivity, new Intent(), "/base/gesturePwdUnlock", 27);
      return;
    }
    JumpActivity.sIsStartFromThirdParty = false;
    localObject = ((Intent)localObject).getDataString();
    localObject = JumpParser.a((BaseQQAppInterface)paramJumpActivity.getAppRuntime(), paramJumpActivity, (String)localObject);
    ((JumpAction)localObject).c(paramString);
    ((JumpAction)localObject).d(paramJumpActivity.mPackageName);
    if (((JumpAction)localObject).a()) {
      paramJumpActivity.finish();
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initJASwitch with ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" inited=");
      localStringBuilder.append(JumpActivity.sSwitchInited);
      QLog.d("JumpActivityHelper", 2, localStringBuilder.toString());
    }
    if (JumpActivity.sSwitchInited) {
      return;
    }
    try
    {
      JumpActivity.sJASwitches = (int)Long.parseLong(paramString, 16);
      if (paramBoolean) {
        BaseApplication.getContext().getSharedPreferences("Jump_Action", 0).edit().putString("JASwitch", paramString).commit();
      }
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JumpActivityHelper", 2, "initJASwitch error", paramString);
      }
    }
    JumpActivity.sSwitchInited = true;
  }
  
  private static boolean a(JumpActivity paramJumpActivity, Intent paramIntent, JumpAction paramJumpAction, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool2 = a(paramJumpAction, "ptlogin", "qlogin");
    boolean bool1 = true;
    int i;
    if ((!bool2) && (!paramJumpAction.d.equals("qqreg")) && (!"invite_register".equals(paramJumpAction.e))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!paramJumpActivity.getAppRuntime().isLogin()) && (i != 0))
    {
      paramString2 = new Intent();
      paramString2.putExtra("scheme_content_original", paramString1);
      paramString4 = new StringBuilder();
      paramString4.append(paramString1);
      paramIntent = "?";
      if (paramString1.contains("?")) {
        paramIntent = "&";
      }
      paramString4.append(paramIntent);
      paramIntent = paramString4.toString();
      paramString1 = new StringBuilder();
      paramString1.append(paramIntent);
      paramString1.append("jfrom=login");
      paramString2.putExtra("scheme_content", paramString1.toString());
      paramString2.putExtra("pkg_name", paramString3);
      paramString2.setFlags(268435456);
      if (a(paramJumpAction, "profile", "sdk_face_collection")) {
        paramString2.putParcelableArrayListExtra("android.intent.extra.STREAM", paramJumpActivity.getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM"));
      }
      if (VersionUtils.e()) {
        paramString2.addFlags(32768);
      }
      RouteUtils.a(paramJumpActivity, paramString2, "/base/login");
    }
    else if (a.a(paramJumpActivity, paramString1))
    {
      QLog.d("JumpActivityHelper", 1, new Object[] { "to GesturePWDUnlockActivity pkgName=", paramString3 });
      paramIntent = new Intent();
      paramIntent.putExtra("key_gesture_from_jumpactivity", true);
      paramIntent.putExtra("scheme_content", paramString1);
      paramIntent.putExtra("pkg_name", paramString3);
      RouteUtils.a(paramJumpActivity, paramIntent, "/base/gesturePwdUnlock");
    }
    else
    {
      if (a(paramJumpAction, "devlock", "open"))
      {
        if (!NetworkUtil.isNetSupport(paramJumpActivity))
        {
          QQToast.makeText(paramJumpActivity, paramJumpActivity.getString(2131889169), 0).show(paramJumpActivity.getTitleBarHeight());
          return false;
        }
        ((IQJumpApi)QRoute.api(IQJumpApi.class)).checkDevLockStatus(paramJumpActivity);
        return false;
      }
      if (a(paramJumpAction, "gvideo", "open_plugin"))
      {
        a.a(paramJumpActivity, paramIntent);
        paramJumpActivity.finish();
        return false;
      }
      if (a(paramJumpAction, "nearby_videochat", "open_plugin"))
      {
        a.e(paramJumpActivity, paramIntent);
        return false;
      }
      if (a(paramJumpAction, "qwerewolf", "enterHomePage"))
      {
        ((IQJumpApi)QRoute.api(IQJumpApi.class)).nearByEnterNewGame(paramJumpActivity);
        paramJumpActivity.finish();
        return false;
      }
      if (paramString1.startsWith("mqqapi://tenpay/pay?"))
      {
        paramIntent = paramIntent.getStringExtra("url_app_info");
        if (!TextUtils.isEmpty(paramIntent)) {
          paramJumpAction.a("url_app_info", paramIntent);
        }
      }
      paramJumpAction.d(paramString3);
      paramJumpAction.e(paramString4);
      if ((paramJumpAction.d != null) && (paramJumpAction.e != null)) {
        paramJumpAction.a(paramJumpActivity);
      }
      bool1 = paramJumpAction.a();
    }
    a(paramJumpActivity, paramJumpAction, bool1);
    return false;
  }
  
  private static boolean a(JumpActivity paramJumpActivity, Bundle paramBundle, String paramString)
  {
    Object localObject = paramJumpActivity.getIntent().getAction();
    Intent localIntent = new Intent();
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_from_jump", true);
    localIntent.putExtra("forward_type", 0);
    localIntent.putExtra("system_share", true);
    localIntent.putExtra("selection_mode", 2);
    if (((String)localObject).equals("android.intent.action.SEND"))
    {
      localObject = paramBundle.get("android.intent.extra.STREAM");
      if (localObject != null)
      {
        if ((localObject instanceof Uri))
        {
          localObject = (Uri)localObject;
          if (("text/x-vcard".equals(paramString)) && ("content".equals(((Uri)localObject).getScheme())))
          {
            localIntent.putExtra("sendMultiple", false);
            localIntent.putExtras(paramBundle);
            paramJumpActivity.getClass();
            new JumpActivity.ShareTask(paramJumpActivity, localIntent).execute(new Object[] { paramJumpActivity.getApplicationContext(), localObject });
            return true;
          }
          paramString = ((Uri)localObject).getPath();
          localObject = a((Uri)localObject);
          if (localObject == null)
          {
            paramJumpActivity.finish();
            return true;
          }
          if ((((IQJumpApi)QRoute.api(IQJumpApi.class)).backToFileScheme()) && ("file".equals(((Uri)localObject).getScheme())))
          {
            QLog.d("JumpActivityHelper", 1, new Object[] { "doShare scheme uriPath=", paramString });
            if ((paramString != null) && (paramString.startsWith(BaseForwardUtil.a()))) {
              localIntent.putExtra("path_for_file_scheme", paramString);
            }
          }
          localIntent.setData((Uri)localObject);
        }
        else
        {
          if (!(localObject instanceof String)) {
            break label315;
          }
          localIntent.setData(Uri.parse((String)localObject));
        }
        localIntent.putExtra("sendMultiple", false);
        break label351;
        label315:
        paramJumpActivity.finish();
        return true;
      }
      else
      {
        paramJumpActivity.finish();
        return true;
      }
    }
    else
    {
      localIntent.putExtra("sendMultiple", true);
      localIntent.putExtra("forward_text", paramJumpActivity.getString(2131888019));
    }
    label351:
    localIntent.putExtras(paramBundle);
    a.a(localIntent, paramJumpActivity);
    return false;
  }
  
  public static boolean a(JumpActivity paramJumpActivity, JumpAction paramJumpAction)
  {
    if (paramJumpAction == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramJumpAction.b("share_id"))) {
      return false;
    }
    String str = paramJumpAction.b("req_type");
    paramJumpActivity = paramJumpAction.b("cflag");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    int i;
    try
    {
      str = b(str);
      if (!TextUtils.isEmpty(str)) {
        i = Integer.valueOf(str).intValue();
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("JumpActivityHelper", 1, "needToStartQZoneProcess catch NumberFormatException. ", localNumberFormatException);
      i = 1;
    }
    if (((i == 3) || (i == 4)) && ("qzone".equals(paramJumpAction.d)) && ("publish".equals(paramJumpAction.e)))
    {
      QLog.i("JumpActivityHelper", 1, "ShareShuoshuoOrVideoToQZone and the JumpActivity has not finish.");
      return true;
    }
    if (TextUtils.isEmpty(paramJumpActivity)) {
      return false;
    }
    int j;
    try
    {
      paramJumpActivity = b(paramJumpActivity);
      if (!TextUtils.isEmpty(paramJumpActivity)) {
        j = Integer.valueOf(paramJumpActivity).intValue();
      }
    }
    catch (NumberFormatException paramJumpActivity)
    {
      QLog.d("JumpActivityHelper", 1, "needToStartQZoneProcess catch NumberFormatException. ", paramJumpActivity);
      j = 0;
    }
    if ((i == 5) && ((j & 0x1) != 0))
    {
      QLog.i("JumpActivityHelper", 1, "SharePictureToQZone and the JumpActivity has not finish.");
      return true;
    }
    return false;
  }
  
  private static boolean a(JumpAction paramJumpAction, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString2 != null)
    {
      if (paramString1 == null) {
        return false;
      }
      bool1 = bool2;
      if (paramString1.equals(paramJumpAction.d))
      {
        bool1 = bool2;
        if (paramString2.equals(paramJumpAction.e)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    if (JumpActivity.sLegalPrefix == null) {
      try
      {
        if (JumpActivity.sLegalPrefix == null)
        {
          JumpActivity.sLegalPrefix = new HashMap();
          int i = 0;
          while (i < JumpActivity.sLegalPrefixes.length)
          {
            String str = JumpActivity.sLegalPrefixes[i];
            JumpActivity.sLegalPrefix.put(str, Integer.valueOf(i));
            i += 1;
          }
          if (!JumpActivity.sSwitchInited) {
            JumpActivity.initJASwitch();
          }
        }
      }
      finally {}
    }
    return JumpActivity.sLegalPrefix.containsKey(paramString);
  }
  
  public static boolean a(AppRuntime paramAppRuntime, JumpAction paramJumpAction)
  {
    if (paramJumpAction != null)
    {
      if (paramJumpAction.f == null) {
        return false;
      }
      try
      {
        IMiniAppService localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
        if (localIMiniAppService == null) {
          return false;
        }
        if (localIMiniAppService.asyncShareMiniProgram(paramJumpAction)) {
          return paramAppRuntime.isLogin();
        }
        return false;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("JumpActivityHelper", 1, "doRealAsynShareJumpAction", paramAppRuntime);
      }
    }
    return false;
  }
  
  public static int b(JumpActivity paramJumpActivity, Bundle paramBundle)
  {
    try
    {
      QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|beg");
      Uri localUri = (Uri)paramBundle.getParcelable("android.intent.extra.STREAM");
      if ((localUri != null) && ("file".equals(localUri.getScheme())) && (localUri.getPath().startsWith("/storage"))) {
        return 4;
      }
      String str1 = paramBundle.getString("android.intent.extra.TITLE");
      String str3 = paramBundle.getString("android.intent.extra.TEXT");
      String str2 = paramJumpActivity.getIntent().getType();
      if (TextUtils.isEmpty(str2))
      {
        QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|type null");
        return 1;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("src_type", "app");
      localHashMap.put("version", "1");
      localHashMap.put("cflag", Base64Util.encodeToString("1".getBytes(), 0));
      if (TextUtils.isEmpty(str1)) {
        str1 = "";
      } else {
        str1 = Base64Util.encodeToString(str1.getBytes(), 0);
      }
      localHashMap.put("title", str1);
      if (str2.startsWith("text")) {
        return paramJumpActivity.qqFavHandleTypeTxt(paramBundle, localHashMap, localUri, str3);
      }
      if (str2.startsWith("image")) {
        return paramJumpActivity.qqFavHandleTypeImage(paramBundle, localHashMap);
      }
      paramJumpActivity = new StringBuilder();
      paramJumpActivity.append("startSystemShareToQQFav|unknown type. type=");
      paramJumpActivity.append(str2);
      QLog.d("JumpActivityHelper", 1, paramJumpActivity.toString());
      return 1;
    }
    catch (OutOfMemoryError paramJumpActivity)
    {
      label256:
      break label256;
    }
    QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|outofmemoryerror");
    return 1;
  }
  
  public static Intent b(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    Intent localIntent = paramJumpActivity.getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!paramJumpActivity.getAppRuntime().isLogin()))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      RouteUtils.a(paramJumpActivity, (Intent)localObject2, "/base/login", 20);
      return null;
    }
    return localIntent;
  }
  
  private static String b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (!"".equals(paramString)) {
        if (paramString.length() == 0) {
          return null;
        }
      }
    }
    try
    {
      localObject1 = new String(Base64Util.decode(paramString, 0));
      return localObject1;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void b(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportJumpArguments action=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("; data=");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("JumpActivityHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("action", str);
    ((HashMap)localObject).put("data", paramIntent);
    QQBeaconReport.a("", "JA_ARGUMENTS", (Map)localObject);
  }
  
  public static void b(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getStringExtra("comicID");
      if ((!((String)localObject).equalsIgnoreCase("0")) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localObject = new Intent();
        ((Intent)localObject).setFlags(1073741824);
        ((Intent)localObject).putExtras(paramIntent);
        RouteUtils.a(paramJumpActivity, (Intent)localObject, "/base/browser");
      }
      else
      {
        localObject = new ActivityURIRequest(paramJumpActivity, "/base/vipcomic");
        ((ActivityURIRequest)localObject).extra().putAll(paramIntent.getExtras());
        QRoute.startUri((URIRequest)localObject, null);
      }
    }
    paramJumpActivity.finish();
  }
  
  private static void b(JumpActivity paramJumpActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle());
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_from_jump", true);
    localIntent.putExtra("k_favorites", true);
    localIntent.putExtra("system_share", true);
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra("forward_type", -1);
    localIntent.putExtra("forward_text", paramString);
    RouteUtils.a(paramJumpActivity, localIntent, "/base/forwardRecent");
  }
  
  public static void b(JumpActivity paramJumpActivity, DevlockInfo paramDevlockInfo)
  {
    Intent localIntent = new Intent(paramJumpActivity.getIntent());
    boolean bool2 = true;
    localIntent.putExtra("devlock_need_broadcast", true);
    if ((localIntent.getBooleanExtra("enable_open_allowset_dev", false)) && (paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 0) && (paramDevlockInfo.AllowSet == 1))
    {
      localIntent.putExtra("phone_num", paramDevlockInfo.Mobile);
      localIntent.putExtra("country_code", paramDevlockInfo.CountryCode);
      localIntent.putExtra("auth_dev_open", false);
      localIntent.putExtra("allow_set", true);
      RouteUtils.a(paramJumpActivity, localIntent, "/base/safe/authDevActivity");
    }
    else if ((paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 1))
    {
      localIntent.putExtra("phone_num", paramDevlockInfo.Mobile);
      localIntent.putExtra("country_code", paramDevlockInfo.CountryCode);
      boolean bool1;
      if (paramDevlockInfo.DevSetup == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localIntent.putExtra("auth_dev_open", bool1);
      if (paramDevlockInfo.AllowSet == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localIntent.putExtra("allow_set", bool1);
      RouteUtils.a(paramJumpActivity, localIntent, "/base/safe/authDevActivity");
    }
    else
    {
      localIntent.putExtra("DevlockInfo", paramDevlockInfo);
      RouteUtils.a(paramJumpActivity, localIntent, "/base/safe/authDevOpenActivity");
    }
    if (localIntent.getBooleanExtra("open_devlock_from_roam", false)) {
      paramJumpActivity.overridePendingTransition(2130771996, 2130771994);
    }
  }
  
  public static void b(JumpActivity paramJumpActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = paramJumpActivity.getIntent();
    if ((paramBoolean1) && (!paramJumpActivity.getAppRuntime().isLogin()))
    {
      JumpActivity.sIsStartFromWpa = true;
      paramString = new Intent();
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      RouteUtils.a(paramJumpActivity, paramString, "/base/login", 21);
      return;
    }
    if ((paramBoolean2) && (((IQJumpApi)QRoute.api(IQJumpApi.class)).gestureGetJumpLock(paramJumpActivity, paramJumpActivity.getAppRuntime().getCurrentAccountUin())))
    {
      RouteUtils.a(paramJumpActivity, new Intent(), "/base/gesturePwdUnlock", 22);
      return;
    }
    JumpActivity.sIsStartFromWpa = false;
    localObject = ((Intent)localObject).getDataString();
    localObject = JumpParser.a((BaseQQAppInterface)paramJumpActivity.getAppRuntime(), paramJumpActivity, (String)localObject);
    ((JumpAction)localObject).c(paramString);
    ((JumpAction)localObject).a();
    paramJumpActivity.finish();
  }
  
  public static boolean b(JumpActivity paramJumpActivity)
  {
    try
    {
      if (!JumpForwardPkgUtil.a(paramJumpActivity, true))
      {
        paramJumpActivity.finish();
        return true;
      }
    }
    catch (Throwable paramJumpActivity)
    {
      label14:
      break label14;
    }
    return false;
  }
  
  private static boolean b(JumpActivity paramJumpActivity, Intent paramIntent, JumpAction paramJumpAction, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramJumpAction.d.equals("qqidentifier")) && (paramString3 == null))
    {
      QLog.e("JumpActivityHelper", 1, "can not get caller");
      paramJumpActivity.finish();
      return false;
    }
    if ((paramJumpAction.d.equals("puzzle_verify_code")) && (paramJumpAction.e != null))
    {
      paramIntent = new Intent(paramJumpActivity.getIntent());
      if (paramJumpAction.e.equals("PUZZLEVERIFYCODE"))
      {
        a.a(paramJumpActivity);
        RouteUtils.a(paramJumpActivity, paramIntent, "/base/browser");
      }
      else if (paramJumpAction.e.equals("VERIFYCODE"))
      {
        RouteUtils.a(paramJumpActivity, paramIntent, "/base/verifyCode");
      }
      else if (paramJumpAction.e.equals("DEVLOCK_CODE"))
      {
        QPublicFragmentActivity.start(paramJumpActivity, paramIntent, ((ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class)).getNewAuthDevUgFragment());
      }
      else if (paramJumpAction.e.equals("GATEVERIFY"))
      {
        QPublicFragmentActivity.start(paramJumpActivity, paramIntent, ((ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class)).getNewAuthDevUgFragment());
      }
      paramJumpActivity.finish();
      return false;
    }
    if ((!paramString1.startsWith("mqqwpa://im")) && (!paramString1.startsWith("mqqwpaopenid://im")))
    {
      if ((paramString1.startsWith("mqqapi:")) && ((paramString3 == null) || ("com.tencent.mobileqq".equals(paramString3)))) {
        paramString3 = paramJumpActivity.getIntent().getStringExtra("pkg_name");
      }
      if ((!paramString1.startsWith("mqqapi://im")) && (!paramString1.startsWith("mqqapi://connect_miniapp"))) {
        return a(paramJumpActivity, paramIntent, paramJumpAction, paramString1, paramString2, paramString3, paramString4);
      }
      paramJumpActivity.mPackageName = paramString3;
      JumpActivity.doThirdPartyCheckLoginAndGesture(paramJumpActivity, true, paramString2, true);
      return false;
    }
    JumpActivity.dowpa(paramJumpActivity, true, paramString2, true);
    return false;
  }
  
  public static boolean b(JumpActivity paramJumpActivity, JumpAction paramJumpAction)
  {
    return a(paramJumpActivity.getAppRuntime(), paramJumpAction);
  }
  
  public static void c(JumpActivity paramJumpActivity)
  {
    a.b(paramJumpActivity);
    paramJumpActivity.finish();
  }
  
  public static void c(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Intent localIntent;
    if (!paramJumpActivity.getAppRuntime().isLogin())
    {
      localIntent = new Intent();
      localIntent.addFlags(67371008);
      localIntent.putExtra("QQCOMIC_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      RouteUtils.a(paramJumpActivity, localIntent, "/base/login");
      paramJumpActivity.finish();
      return;
    }
    if ((((IQJumpApi)QRoute.api(IQJumpApi.class)).gestureGetJumpLock(paramJumpActivity, paramJumpActivity.getAppRuntime().getCurrentAccountUin())) && (!BaseGesturePWDUtil.getAppForground(paramJumpActivity)))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      paramJumpActivity.gotoQQComic = new Intent();
      paramJumpActivity.gotoQQComic.putExtras(paramIntent);
      RouteUtils.a(paramJumpActivity, localIntent, "/base/gesturePwdUnlock", 572);
      return;
    }
    b(paramJumpActivity, paramIntent);
  }
  
  public static void c(JumpActivity paramJumpActivity, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("android.intent.extra.TEXT");
    String str2 = paramJumpActivity.getIntent().getType();
    Object localObject = paramBundle.getString("pkg_name");
    if (paramJumpActivity.qserIsOn().booleanValue()) {
      a.a(paramJumpActivity);
    }
    if ("cn.wps.moffice_eng".equals(localObject)) {
      ReportController.b(paramJumpActivity.getAppRuntime(), "CliOper", "", "", "0X8008810", "0X8008810", 0, 0, "", "", "", "");
    }
    if (TextUtils.isEmpty(str2)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forward form JumpActivity doShare type=");
      ((StringBuilder)localObject).append(str2);
      QLog.d("JumpActivityHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((str2.startsWith("text")) && (!paramBundle.containsKey("android.intent.extra.STREAM"))) {
      b(paramJumpActivity, str1);
    } else if (str2.startsWith("message")) {
      e(paramJumpActivity, paramBundle);
    } else if (str2.startsWith("image"))
    {
      if (!d(paramJumpActivity, paramBundle)) {}
    }
    else if (a(paramJumpActivity, paramBundle, str2)) {
      return;
    }
    paramBundle = paramJumpActivity.getIntent().getScheme();
    if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals("geo")))
    {
      paramBundle = new Intent();
      paramBundle.putExtras(new Bundle());
      paramBundle.putExtra("isFromShare", true);
      paramBundle.putExtra("forward_from_jump", true);
      paramBundle.putExtra("forward_type", -2);
      paramBundle.setData(paramJumpActivity.getIntent().getData());
      a.a(paramBundle, paramJumpActivity);
      paramJumpActivity.finish();
      return;
    }
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
    if (BaseForwardUtil.a(paramJumpActivity))
    {
      d(paramJumpActivity, paramBoolean);
      return;
    }
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShare", true, 0L, 0L, localHashMap, "");
    boolean bool = l(paramJumpActivity, localIntent);
    QLog.d("JumpActivityHelper", 1, new Object[] { "system share.doShare needGrantSDPermission=", Boolean.valueOf(bool) });
    if ((bool) && (Build.VERSION.SDK_INT >= 23))
    {
      a.a(paramJumpActivity, paramBoolean);
      return;
    }
    d(paramJumpActivity, paramBoolean);
  }
  
  public static boolean c(JumpActivity paramJumpActivity, JumpAction paramJumpAction)
  {
    return a(paramJumpActivity, paramJumpAction);
  }
  
  public static void d(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Intent localIntent;
    if (!paramJumpActivity.getAppRuntime().isLogin())
    {
      localIntent = new Intent();
      localIntent.addFlags(67371008);
      localIntent.putExtra("QFILE_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      RouteUtils.a(paramJumpActivity, localIntent, "/base/login");
      paramJumpActivity.finish();
      return;
    }
    if ((((IQJumpApi)QRoute.api(IQJumpApi.class)).gestureGetJumpLock(paramJumpActivity, paramJumpActivity.getAppRuntime().getCurrentAccountUin())) && (!BaseGesturePWDUtil.getAppForground(paramJumpActivity)))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramIntent.getExtras());
      RouteUtils.a(paramJumpActivity, localIntent, "/base/gesturePwdUnlock", 570);
      return;
    }
    c(paramJumpActivity);
  }
  
  public static void d(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    Intent localIntent = paramJumpActivity.getIntent();
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      QLog.i("JumpActivityHelper", 1, "system share.doShare error extra is null");
      paramJumpActivity.finish();
      return;
    }
    if ((paramBoolean) && (!paramJumpActivity.getAppRuntime().isLogin()))
    {
      localIntent = new Intent();
      localIntent.putExtra("isActionSend", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtras(localIntent);
      RouteUtils.a(paramJumpActivity, localIntent, "/base/login", 19);
      return;
    }
    if (localBundle.getBoolean("qqfav_extra_from_system_share", false))
    {
      int i = paramJumpActivity.doQfavShare(localBundle);
      if (i == 4) {
        a(paramJumpActivity, 2131896047, 1);
      } else if (i != 0) {
        a(paramJumpActivity, 2131896043, 1);
      }
      paramJumpActivity.finish();
      return;
    }
    a(paramJumpActivity, localIntent, 0);
  }
  
  public static boolean d(JumpActivity paramJumpActivity)
  {
    Intent localIntent = paramJumpActivity.getIntent();
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqdatamigration"))) {
      return true;
    }
    try
    {
      boolean bool = JumpForwardPkgManager.a(paramJumpActivity);
      if (bool) {
        return true;
      }
    }
    catch (Throwable paramJumpActivity)
    {
      label45:
      break label45;
    }
    return false;
  }
  
  private static boolean d(JumpActivity paramJumpActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_from_jump", true);
    localIntent.putExtra("k_favorites", true);
    localIntent.putExtra("system_share", true);
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtras(new Bundle());
    localIntent.putExtra("forward_type", 1);
    if (paramJumpActivity.getIntent().getAction().equals("android.intent.action.SEND"))
    {
      Object localObject = paramBundle.get("android.intent.extra.STREAM");
      if (localObject != null)
      {
        if ((localObject instanceof Uri))
        {
          localIntent.setData((Uri)localObject);
        }
        else
        {
          if (!(localObject instanceof String)) {
            break label150;
          }
          localIntent.setData(Uri.parse((String)localObject));
        }
        localIntent.putExtra("sendMultiple", false);
        break label186;
        label150:
        paramJumpActivity.finish();
        return true;
      }
      else
      {
        paramJumpActivity.finish();
        return true;
      }
    }
    else
    {
      localIntent.putExtra("sendMultiple", true);
      localIntent.putExtra("forward_text", paramJumpActivity.getString(2131888019));
    }
    label186:
    localIntent.putExtras(paramBundle);
    RouteUtils.a(paramJumpActivity, localIntent, "/base/forwardRecent");
    return false;
  }
  
  public static void e(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (!paramJumpActivity.getAppRuntime().isLogin())
    {
      f(paramJumpActivity);
      return;
    }
    if ((((IQJumpApi)QRoute.api(IQJumpApi.class)).gestureGetJumpLock(paramJumpActivity, paramJumpActivity.getAppRuntime().getCurrentAccountUin())) && (!BaseGesturePWDUtil.getAppForground(paramJumpActivity)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramIntent.getExtras());
      RouteUtils.a(paramJumpActivity, localIntent, "/base/gesturePwdUnlock", 573);
      return;
    }
    a(paramJumpActivity, paramIntent.getExtras());
  }
  
  private static void e(JumpActivity paramJumpActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle());
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_from_jump", true);
    localIntent.putExtra("k_favorites", true);
    localIntent.putExtra("forward_type", -1);
    localIntent.putExtra("forward_text", (SpannableString)paramBundle.get("android.intent.extra.TEXT"));
    RouteUtils.a(paramJumpActivity, localIntent, "/base/forwardRecent");
    paramJumpActivity.finish();
  }
  
  private static void f(JumpActivity paramJumpActivity)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(67371008);
    RouteUtils.a(paramJumpActivity, localIntent, "/base/login");
    paramJumpActivity.finish();
  }
  
  public static void f(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Object localObject = paramIntent.getData();
    String str;
    if (localObject != null)
    {
      str = new String(Base64Util.decode(((Uri)localObject).getQueryParameter("param"), 0));
      paramIntent = ((Uri)localObject).getQueryParameter("appname");
      ((Uri)localObject).getQueryParameter("src_type");
      ((Uri)localObject).getQueryParameter("version");
      localObject = ((Uri)localObject).getQueryParameter("share_id");
    }
    try
    {
      l = Long.parseLong((String)localObject);
    }
    catch (Exception localException)
    {
      long l;
      label78:
      break label78;
    }
    l = 0L;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (l != 0L))
    {
      if (!"wangzhe".equals(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpActivityHelper", 2, "app name is not wangzhe");
        }
        return;
      }
      paramIntent = null;
      try
      {
        str = new JSONObject(str).getString("url");
        paramIntent = str;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if ((!paramJumpActivity.getAppRuntime().isLogin()) && (!TextUtils.isEmpty(paramIntent)))
      {
        a.b(paramJumpActivity, l, paramIntent);
        return;
      }
      a.a(paramJumpActivity, l, paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpActivityHelper", 2, "app id is null,can not share");
    }
  }
  
  private static void g(JumpActivity paramJumpActivity)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    RouteUtils.a(paramJumpActivity, localIntent, "/base/start/splash");
    paramJumpActivity.finish();
  }
  
  public static void g(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getParcelableExtra(((IQJumpApi)QRoute.api(IQJumpApi.class)).getSecurityVerifyPluginDataKey());
      if ((!TextUtils.isEmpty(paramIntent.getStringExtra("url"))) && (((localObject instanceof InviteToGroupInfo)) || ((localObject instanceof JoinGroupInfo))))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramIntent);
        RouteUtils.a(paramJumpActivity, (Intent)localObject, "/base/browser", 25);
        return;
      }
      QLog.d("Q.security_verify", 1, "goToWebSecVerify, error param!");
    }
    catch (Exception paramIntent)
    {
      QLog.d("Q.security_verify", 1, "goToWebSecVerify", paramIntent);
    }
    paramJumpActivity.finish();
  }
  
  private static void h(JumpActivity paramJumpActivity)
  {
    Object localObject2 = JumpForwardPkgManager.c(paramJumpActivity);
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
    localObject1 = ((StringBuilder)localObject1).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (((String)localObject1).contains("com.tencent.mm"))
      {
        i = 1;
        break label148;
      }
      if (((String)localObject1).contains("com.alibaba.android.rimet"))
      {
        i = 2;
        break label148;
      }
      if (((String)localObject1).contains("com.tencent.wework"))
      {
        i = 3;
        break label148;
      }
      if (((String)localObject1).contains("com.ss.android.lark.lite"))
      {
        i = 4;
        break label148;
      }
    }
    int i = 5;
    label148:
    ReportController.b(paramJumpActivity.getAppRuntime(), "dc00898", "", "", "0X800B008", "0X800B008", i, 0, "", "", "", "");
  }
  
  public static boolean h(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (("android.intent.action.VIEW".equals(paramIntent.getAction())) && (paramIntent.getIntExtra("MINI_CONFIG_SCENE", -1) > 0) && (!TextUtils.isEmpty(paramIntent.getStringExtra("CONFIG_APPID"))))
    {
      JumpActivity.doJumpToMiniApp(paramJumpActivity, true);
      return false;
    }
    if ("from_nearby_pb".equals(paramIntent.getStringExtra("from")))
    {
      m(paramJumpActivity, paramIntent);
      return false;
    }
    if ("from_gesturemgr_download".equals(paramIntent.getAction()))
    {
      paramJumpActivity.finish();
      return false;
    }
    if ("from_webtool_launchshortvideo".equals(paramIntent.getAction()))
    {
      n(paramJumpActivity, paramIntent);
      return false;
    }
    if ((!"android.intent.action.SEND".equals(paramIntent.getAction())) && (!"android.intent.action.SEND_MULTIPLE".equals(paramIntent.getAction())))
    {
      if (("android.intent.action.VIEW".equals(paramIntent.getAction())) && (("file".equals(paramIntent.getScheme())) || ("content".equals(paramIntent.getScheme()))))
      {
        JumpActivity.doView(paramJumpActivity, true);
        return false;
      }
      return true;
    }
    JumpActivity.doShare(paramJumpActivity, true);
    return false;
  }
  
  private static void i(JumpActivity paramJumpActivity)
  {
    try
    {
      ((IQJumpApi)QRoute.api(IQJumpApi.class)).buildMapActivityProxy(paramJumpActivity.getAppRuntime().getAccount());
      RouteUtils.a(paramJumpActivity, new Intent().putExtra("uin", paramJumpActivity.getAppRuntime().getAccount()), "/base/qqmap", 18);
      return;
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    if (paramJumpActivity.doCallBack) {
      a(paramJumpActivity, "Google Map not exist");
    }
    paramJumpActivity.finish();
  }
  
  public static boolean i(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (b(paramJumpActivity)) {
      return false;
    }
    if (("android.intent.action.SENDTO".equals(paramIntent.getAction())) && ("imto".equals(paramIntent.getScheme())))
    {
      paramJumpActivity.doSumsungCallUp();
      return false;
    }
    if ("thridapp".equals(paramIntent.getStringExtra("share_from"))) {
      return a.c(paramJumpActivity, paramIntent);
    }
    if ((("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_qlink_shortcut", false))) || (paramIntent.getBooleanExtra("_goto_qlink_when_login_suc_", false)))
    {
      paramJumpActivity.doJumpQlink(paramIntent);
      return false;
    }
    if ("com.tencent.qqcomic.SHORT_CUT".equals(paramIntent.getAction()))
    {
      paramJumpActivity.doJumpQQComic(paramIntent);
      return false;
    }
    if ((("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_qfile_shortcut", false))) || (paramIntent.getBooleanExtra("_goto_qfile_when_login_suc_", false)))
    {
      paramJumpActivity.doJumpQfile(paramIntent);
      return false;
    }
    if ("com.tencent.smartdevice.SHORT_CUT".equals(paramIntent.getAction()))
    {
      paramJumpActivity.doJumpSmartDevice(paramIntent);
      return false;
    }
    if ("kandianugc".equals(paramIntent.getScheme()))
    {
      paramJumpActivity.doJumpReadInjoy(paramIntent);
      paramJumpActivity.finish();
      return false;
    }
    if (("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_kandian_shortcut", false)))
    {
      o(paramJumpActivity, paramIntent);
      return false;
    }
    if ("mqqdatamigration".equals(paramIntent.getScheme()))
    {
      p(paramJumpActivity, paramIntent);
      return false;
    }
    return true;
  }
  
  public static boolean j(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (("mqq".equals(paramIntent.getScheme())) && ("mqq://".equals(paramIntent.getDataString())))
    {
      g(paramJumpActivity);
      return false;
    }
    if ("mqqaudioassistant".equals(paramIntent.getScheme()))
    {
      q(paramJumpActivity, paramIntent);
      return false;
    }
    if ("com.tencent.security.VERIFY_WEB".equals(paramIntent.getAction()))
    {
      paramJumpActivity.goToWebSecVerify(paramIntent);
      return false;
    }
    if (a.f(paramJumpActivity, paramIntent))
    {
      paramJumpActivity.finish();
      return false;
    }
    return true;
  }
  
  public static boolean k(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    String str1 = paramJumpActivity.getIntent().getDataString();
    String str2 = paramJumpActivity.getIntent().getStringExtra("from");
    Object localObject6 = null;
    Object localObject7 = null;
    localObject1 = null;
    int i = 0;
    for (;;)
    {
      Object localObject3 = localObject7;
      Object localObject4 = localObject1;
      Object localObject5;
      if (i < 3) {
        localObject5 = localObject6;
      }
      try
      {
        localObject3 = paramJumpActivity.getCallingPackage();
        localObject2 = localObject3;
        localObject5 = localObject6;
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject5 = localObject6;
          localObject1 = localObject3;
          QLog.i("JumpActivityHelper", 1, "-->onCreate getCallingPackage returns null!");
          localObject5 = localObject6;
          localObject1 = localObject3;
          localObject2 = paramJumpActivity.getCallingActivity();
          if (localObject2 != null)
          {
            localObject5 = localObject6;
            localObject1 = localObject3;
            localObject3 = ((ComponentName)localObject2).getPackageName();
            localObject2 = localObject3;
            localObject5 = localObject6;
            localObject1 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject5 = localObject6;
              localObject1 = localObject3;
              QLog.i("JumpActivityHelper", 1, "-->onCreate get package from activity returns null!");
              localObject2 = localObject3;
            }
          }
          else
          {
            localObject5 = localObject6;
            localObject1 = localObject3;
            QLog.i("JumpActivityHelper", 1, "-->onCreate getCallingActivity returns null!");
            localObject2 = localObject3;
          }
        }
        localObject5 = localObject6;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject5 = localObject6;
          localObject1 = localObject2;
          Object localObject8 = paramJumpActivity.getPackageManager().getPackageInfo((String)localObject2, 64);
          localObject3 = localObject7;
          localObject4 = localObject2;
          if (localObject8 != null)
          {
            localObject5 = localObject6;
            localObject1 = localObject2;
            localObject8 = ((PackageInfo)localObject8).signatures;
            localObject3 = localObject7;
            localObject4 = localObject2;
            if (localObject8 != null)
            {
              localObject3 = localObject7;
              localObject4 = localObject2;
              localObject5 = localObject6;
              localObject1 = localObject2;
              if (localObject8.length > 0)
              {
                localObject5 = localObject6;
                localObject1 = localObject2;
                localObject3 = MessageDigest.getInstance("MD5");
                localObject5 = localObject6;
                localObject1 = localObject2;
                ((MessageDigest)localObject3).update(localObject8[0].toByteArray());
                localObject5 = localObject6;
                localObject1 = localObject2;
                localObject3 = HexUtil.bytes2HexStr(((MessageDigest)localObject3).digest());
                if (localObject3 == null)
                {
                  localObject3 = "";
                  localObject4 = localObject2;
                }
                else
                {
                  localObject5 = localObject3;
                  localObject1 = localObject2;
                  localObject3 = ((String)localObject3).toLowerCase();
                  localObject4 = localObject2;
                }
              }
            }
          }
        }
        else
        {
          i += 1;
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localObject3 = localObject5;
          localObject4 = localObject1;
        }
      }
    }
    if (localObject4 == null)
    {
      localObject1 = paramJumpActivity.getIntent().getStringExtra("pkg_name");
      localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
      localObject4 = new HashMap();
      ((HashMap)localObject4).put("osVersion", Build.VERSION.RELEASE);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(Build.MANUFACTURER);
      ((StringBuilder)localObject5).append("_");
      ((StringBuilder)localObject5).append(Build.MODEL);
      ((HashMap)localObject4).put("deviceName", ((StringBuilder)localObject5).toString());
      ((StatisticCollector)localObject2).collectPerformance("", "GetCallingPackageEmpty", true, 0L, 0L, (HashMap)localObject4, "");
    }
    else
    {
      localObject1 = localObject4;
    }
    if (str1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("jump url:");
        ((StringBuilder)localObject2).append(str1);
        QLog.d("JumpActivityHelper", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = JumpParser.a((BaseQQAppInterface)paramJumpActivity.getAppRuntime(), paramJumpActivity, str1);
      if (("webview".equals(str2)) && (localObject2 != null)) {
        ((JumpAction)localObject2).c(str2);
      }
      if ((localObject2 != null) && (((JumpAction)localObject2).d != null))
      {
        ((JumpAction)localObject2).g = true;
        return b(paramJumpActivity, paramIntent, (JumpAction)localObject2, str1, str2, (String)localObject1, (String)localObject3);
      }
    }
    paramIntent = paramJumpActivity.getIntent().getStringExtra("action");
    if (paramIntent == null)
    {
      paramJumpActivity.finish();
      return false;
    }
    paramJumpActivity.doCallBack = paramJumpActivity.getIntent().getBooleanExtra("doCallBack", false);
    paramJumpActivity.srcType = paramJumpActivity.getIntent().getStringExtra("src_type");
    paramJumpActivity.callbackType = paramJumpActivity.getIntent().getStringExtra("callback_type");
    paramJumpActivity.callbackName = paramJumpActivity.getIntent().getStringExtra("callback_name");
    if ("photo".equals(paramIntent)) {
      paramJumpActivity.isActionPhoto = true;
    } else if ("select_location".equals(paramIntent)) {
      paramJumpActivity.isActionSelectLocation = true;
    }
    if (paramJumpActivity.isActionPhoto) {
      return false;
    }
    if (paramJumpActivity.isActionSelectLocation) {
      i(paramJumpActivity);
    }
    return false;
  }
  
  public static boolean l(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    label258:
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getExtras();
        localObject1 = localObject3;
        StringBuilder localStringBuilder = new StringBuilder("system share.doShareCheckNeedSDPermission():");
        localObject1 = localObject3;
        localStringBuilder.append("phone info [mod:");
        localObject1 = localObject3;
        localStringBuilder.append(Build.MODEL);
        localObject1 = localObject3;
        localStringBuilder.append(",ver:");
        localObject1 = localObject3;
        localStringBuilder.append(Build.VERSION.SDK);
        localObject1 = localObject3;
        localStringBuilder.append(",maf:");
        localObject1 = localObject3;
        localStringBuilder.append(Build.MANUFACTURER);
        localObject1 = localObject3;
        localStringBuilder.append("]");
        localObject1 = localObject3;
        Object localObject4 = paramIntent.get("android.intent.extra.STREAM");
        paramIntent = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if ((localObject4 instanceof Uri))
          {
            localObject1 = localObject3;
            paramIntent = (Uri)localObject4;
            break label258;
          }
          paramIntent = localObject2;
          localObject1 = localObject3;
          if ((localObject4 instanceof String))
          {
            localObject1 = localObject3;
            paramIntent = Uri.parse((String)localObject4);
            break label258;
          }
        }
        localObject1 = paramIntent;
        localStringBuilder.append(",intent.extra=");
        localObject1 = paramIntent;
        localStringBuilder.append(paramIntent);
        localObject1 = paramIntent;
        QLog.i("JumpActivityHelper", 1, localStringBuilder.toString());
      }
      catch (Exception paramIntent)
      {
        QLog.e("JumpActivityHelper", 1, "system share.doShareCheckNeedSDPermission() e=", paramIntent);
        paramIntent = (Intent)localObject1;
      }
      paramJumpActivity = a.a(paramJumpActivity, paramIntent);
      if (paramJumpActivity != null) {
        return paramJumpActivity.booleanValue();
      }
      return false;
    }
  }
  
  private static void m(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getDataString();
      if (!TextUtils.isEmpty(paramIntent))
      {
        paramIntent = JumpParser.a((BaseQQAppInterface)paramJumpActivity.getAppRuntime(), paramJumpActivity, paramIntent);
        if (paramIntent != null) {
          paramIntent.l();
        }
      }
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nearby_pb|exception:");
        localStringBuilder.append(paramIntent.toString());
        QLog.d("Q.nearby", 2, localStringBuilder.toString());
      }
    }
    paramJumpActivity.finish();
  }
  
  private static void n(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    ((IQJumpApi)QRoute.api(IQJumpApi.class)).qzoneLaunchForPreview(paramJumpActivity, paramIntent);
    paramJumpActivity.finish();
  }
  
  private static void o(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    a.b(paramJumpActivity, paramIntent);
  }
  
  private static void p(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    a.d(paramJumpActivity, paramIntent);
  }
  
  private static void q(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    QLog.d("JumpActivityHelper", 1, "get mqqaudioassistant Jump");
    Uri localUri = paramIntent.getData();
    a.a(paramJumpActivity, paramIntent, localUri);
    paramJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActivityHelper
 * JD-Core Version:    0.7.0.1
 */