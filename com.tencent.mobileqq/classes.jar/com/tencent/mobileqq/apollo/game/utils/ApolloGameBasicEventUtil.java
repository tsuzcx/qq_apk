package com.tencent.mobileqq.apollo.game.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloGameBasicEventUtil
{
  public static long a;
  public static String[] a;
  public static String[] b;
  public static String[] c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "117.144.242.75", "117.144.245.207" };
    b = new String[] { "14.17.42.125", "59.37.96.212", "180.163.32.167", "101.226.90.166" };
    c = new String[] { "58.250.137.13", "163.177.90.55", "140.206.160.112", "140.207.123.182" };
    jdField_a_of_type_Long = 0L;
  }
  
  public static int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, "[getRecommendIp]");
    }
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt("game_rec_port", 10060);
    int i = j;
    if (j <= 0) {
      i = 10060;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recom_port:");
      localStringBuilder.append(i);
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, "[getRecommendIp]");
    }
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getString("game_rec_ip", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recom_ip:");
      ((StringBuilder)localObject).append(str);
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      str = b();
      localObject = str;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("random_ip:");
        ((StringBuilder)localObject).append(str);
        QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, ((StringBuilder)localObject).toString());
        localObject = str;
      }
    }
    return localObject;
  }
  
  /* Error */
  public static String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +178 -> 179
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +6 -> 12
    //   9: goto +170 -> 179
    //   12: aload_0
    //   13: aload_0
    //   14: arraylength
    //   15: invokestatic 124	com/tencent/mobileqq/magicface/drawable/PngFrameUtil:a	(I)I
    //   18: aaload
    //   19: astore_0
    //   20: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +34 -> 57
    //   26: new 82	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 126
    //   37: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: aload_0
    //   43: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 54
    //   49: iconst_2
    //   50: aload_1
    //   51: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: areturn
    //   59: goto +79 -> 138
    //   62: astore_0
    //   63: new 82	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: ldc 128
    //   74: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: aload_0
    //   80: invokevirtual 131	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: ldc 54
    //   89: iconst_1
    //   90: aload_1
    //   91: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 134	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +35 -> 135
    //   103: new 82	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   110: astore_0
    //   111: aload_0
    //   112: ldc 126
    //   114: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_0
    //   119: ldc 21
    //   121: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: ldc 54
    //   127: iconst_2
    //   128: aload_0
    //   129: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: ldc 21
    //   137: areturn
    //   138: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +35 -> 176
    //   144: new 82	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   151: astore_0
    //   152: aload_0
    //   153: ldc 126
    //   155: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_0
    //   160: ldc 21
    //   162: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 54
    //   168: iconst_2
    //   169: aload_0
    //   170: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: ldc 21
    //   178: areturn
    //   179: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +35 -> 217
    //   185: new 82	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   192: astore_0
    //   193: aload_0
    //   194: ldc 126
    //   196: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_0
    //   201: ldc 21
    //   203: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: ldc 54
    //   209: iconst_2
    //   210: aload_0
    //   211: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: ldc 21
    //   219: areturn
    //   220: astore_0
    //   221: goto -162 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramArrayOfString	String[]
    //   33	58	1	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	9	62	java/lang/Exception
    //   12	20	62	java/lang/Exception
    //   4	9	220	finally
    //   12	20	220	finally
    //   63	97	220	finally
  }
  
  public static JSONObject a(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length == 0) {
        return null;
      }
      try
      {
        Object localObject1 = new JSONObject();
        try
        {
          Object localObject2 = new JSONObject();
          Object localObject3;
          if (paramInt == 0)
          {
            ((JSONObject)localObject2).put("atlas", "def/basic/skeleton/role");
            ((JSONObject)localObject2).put("json", "def/basic/skeleton/role");
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramInt);
            ((StringBuilder)localObject3).append("/role");
            ((JSONObject)localObject2).put("atlas", ApolloActionHelperImpl.getResAddPrefixPath(((StringBuilder)localObject3).toString(), 1));
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramInt);
            ((StringBuilder)localObject3).append("/role");
            ((JSONObject)localObject2).put("json", ApolloActionHelperImpl.getResAddPrefixPath(((StringBuilder)localObject3).toString(), 1));
          }
          ((JSONObject)localObject1).put("skltPath", localObject2);
          localObject2 = new JSONArray();
          int j = paramArrayOfInt.length;
          int i = 0;
          while (i < j)
          {
            localObject3 = Integer.valueOf(paramArrayOfInt[i]);
            JSONObject localJSONObject = new JSONObject();
            StringBuilder localStringBuilder2;
            if (paramInt == 0)
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("def/basic/dress/");
              localStringBuilder2.append(localObject3);
              localStringBuilder2.append("/dress");
              localJSONObject.put("atlas", localStringBuilder2.toString());
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("def/basic/dress/");
              localStringBuilder2.append(localObject3);
              localStringBuilder2.append("/dress");
              localJSONObject.put("json", localStringBuilder2.toString());
            }
            else
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append(localObject3);
              localStringBuilder2.append("/dress");
              localJSONObject.put("atlas", ApolloActionHelperImpl.getResAddPrefixPath(localStringBuilder2.toString(), 2));
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append(localObject3);
              localStringBuilder2.append("/dress");
              localJSONObject.put("json", ApolloActionHelperImpl.getResAddPrefixPath(localStringBuilder2.toString(), 2));
            }
            ((JSONArray)localObject2).put(localJSONObject);
            i += 1;
          }
          ((JSONObject)localObject1).put("dressPath", localObject2);
          return localObject1;
        }
        catch (Exception localException2)
        {
          paramArrayOfInt = (int[])localObject1;
          localObject1 = localException2;
        }
        localStringBuilder1 = new StringBuilder();
      }
      catch (Exception localException1)
      {
        paramArrayOfInt = null;
      }
      StringBuilder localStringBuilder1;
      localStringBuilder1.append("[notifyRoleDress], errInfo->");
      localStringBuilder1.append(localException1.getMessage());
      QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, localStringBuilder1.toString());
      return paramArrayOfInt;
    }
    return null;
  }
  
  public static void a(int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, String paramString3, ApolloGameBasicEventUtil.NotifyGameDressReady paramNotifyGameDressReady)
  {
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject2 = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject1 = ((ApolloDaoManagerServiceImpl)localObject2).getApolloBaseInfo(paramString1);
    if (localObject1 != null)
    {
      paramInt2 = ((ApolloBaseInfo)localObject1).apolloStatus;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin: ");
        localStringBuilder.append(((ApolloBaseInfo)localObject1).uin);
        localStringBuilder.append(", funcSwitch:");
        localStringBuilder.append(paramInt2);
        QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, localStringBuilder.toString());
      }
      int j = 0;
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress(false);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        paramInt2 = localObject1.length;
        int i = 0;
        while (i < paramInt2)
        {
          localStringBuilder = localObject1[i];
          j = localStringBuilder.mRoleGender;
          int[] arrayOfInt = localStringBuilder.getDressIds();
          if ((ApolloActionHelperImpl.isRscValid(paramString1, localStringBuilder.roleId, arrayOfInt, paramQQAppInterface, new ApolloGameBasicEventUtil.3(paramNotifyGameDressReady, paramInt1, paramQQAppInterface, paramString2, paramString3, localStringBuilder, arrayOfInt))) && (localStringBuilder.roleId != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, "valid role and dress RSC.");
            }
            if (paramNotifyGameDressReady != null) {
              paramNotifyGameDressReady.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, localStringBuilder.roleId, arrayOfInt, 3);
            }
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, "try to get history dress ....");
          }
          i += 1;
        }
        if (paramNotifyGameDressReady != null)
        {
          if (j == 2) {
            paramInt2 = 2;
          } else {
            paramInt2 = 1;
          }
          paramNotifyGameDressReady.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt2, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt2), 1);
        }
        localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("uin: ");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(" dress is null,try to pull player's dress info.");
          QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, ((StringBuilder)localObject1).toString());
        }
        localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
        if (paramNotifyGameDressReady != null) {
          paramNotifyGameDressReady.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, 1, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(1), 1);
        }
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.b(paramString1)))
      {
        paramQQAppInterface = ((ApolloDaoManagerServiceImpl)localObject2).getApolloBaseInfo(paramString1);
        long l;
        if (paramQQAppInterface != null) {
          l = paramQQAppInterface.apolloUpdateTime;
        } else {
          l = 0L;
        }
        if (NetConnInfoCenter.getServerTime() - l > 300L) {
          localApolloManagerServiceImpl.addToBulkPullMap(paramString1, 2);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, ((StringBuilder)localObject2).toString());
      }
      if (paramNotifyGameDressReady != null) {
        paramNotifyGameDressReady.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt2, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt2), 1);
      }
      localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1) {
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, new Object[] { "[openFloatTransparentView] context=", paramContext, ", jsonStr=", paramString });
    }
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        paramString = localJSONObject1.getString("url");
        if (TextUtils.isEmpty(paramString))
        {
          QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, "[openFloatTransparentView] openUrl null");
          return;
        }
        String str = paramString;
        if (localJSONObject1.has("param"))
        {
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject("param");
          str = paramString;
          if (localJSONObject2 != null)
          {
            Iterator localIterator = localJSONObject2.keys();
            str = paramString;
            if (localIterator.hasNext())
            {
              str = (String)localIterator.next();
              paramString = URLUtil.a(paramString, str, localJSONObject2.getString(str));
              continue;
            }
          }
        }
        int i = localJSONObject1.optInt("closeBtn");
        int j = localJSONObject1.optInt("fullScreen");
        paramString = new Intent(paramContext, ApolloFloatActivity.class);
        paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        paramString.putExtra("extra_key_click_time", System.currentTimeMillis());
        paramString.putExtra("extra_key_weburl", str);
        if (i != 1) {
          break label295;
        }
        bool1 = true;
        paramString.putExtra("extra_key_close_btn", bool1);
        bool1 = bool2;
        if (j == 1) {
          bool1 = true;
        }
        paramString.putExtra("extra_key_fullscreen", bool1);
        paramContext.startActivity(paramString);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, "[openFloatTransparentView] exception=", paramContext);
      }
      return;
      label295:
      bool1 = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("enter")) {
          break label406;
        }
        i = ((JSONObject)localObject).getInt("enter");
        if (!((JSONObject)localObject).has("result")) {
          break label411;
        }
        j = ((JSONObject)localObject).getInt("result");
        boolean bool = ((JSONObject)localObject).has("actionName");
        String str3 = "";
        if (!bool) {
          break label416;
        }
        paramAppInterface = ((JSONObject)localObject).getString("actionName");
        if (!((JSONObject)localObject).has("r2")) {
          break label422;
        }
        paramString = ((JSONObject)localObject).getString("r2");
        if (!((JSONObject)localObject).has("r3")) {
          break label428;
        }
        str1 = ((JSONObject)localObject).getString("r3");
        if (!((JSONObject)localObject).has("r4")) {
          break label435;
        }
        str2 = ((JSONObject)localObject).getString("r4");
        if (((JSONObject)localObject).has("r5")) {
          str3 = ((JSONObject)localObject).getString("r5");
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[reportData2Compass],entry:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",result:");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(",actionName:");
          ((StringBuilder)localObject).append(paramAppInterface);
          ((StringBuilder)localObject).append(",r2:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",r3:");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(",r4:");
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append(",r5:");
          ((StringBuilder)localObject).append(str3);
          QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, ((StringBuilder)localObject).toString());
        }
        VipUtils.a(null, "cmshow", "Apollo", paramAppInterface, i, j, new String[] { paramString, str1, str2, str3 });
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramString = new StringBuilder();
        paramString.append("[reportData2Compass], errInfo->");
        paramString.append(paramAppInterface.getMessage());
        QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, paramString.toString());
      }
      return;
      label406:
      int i = 0;
      continue;
      label411:
      int j = 0;
      continue;
      label416:
      paramAppInterface = "";
      continue;
      label422:
      paramString = "";
      continue;
      label428:
      String str1 = "";
      continue;
      label435:
      String str2 = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getApplication();
      int i = 0;
      SharedPreferences localSharedPreferences = paramQQAppInterface.getSharedPreferences("apollo_sp", 0);
      paramString = new JSONObject(paramString);
      paramQQAppInterface = "";
      if (paramString.has("ip")) {
        paramQQAppInterface = paramString.getString("ip");
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[saveRecommendIp], ip:");
        localStringBuilder.append(paramQQAppInterface);
        QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return;
      }
      localSharedPreferences.edit().putString("game_rec_ip", paramQQAppInterface).commit();
      if (paramString.has("port")) {
        i = paramString.getInt("port");
      }
      localSharedPreferences.edit().putInt("game_rec_port", i).commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("[saveRecommendIp], errInfo->");
      paramString.append(paramQQAppInterface.getMessage());
      QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, paramString.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        paramString2 = localJSONObject.optString("uin");
        String str = localJSONObject.optString("openId");
        int i = localJSONObject.optInt("gameId");
        if (!TextUtils.isEmpty(paramString2)) {
          QLog.i("[cmshow]ApolloGameBasicEventUtil", 1, "pass uin.");
        } else {
          paramString2 = "";
        }
        a(paramInt, paramQQAppInterface, paramString2, str, 1, paramString1, new ApolloGameBasicEventUtil.1(i));
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramString1 = new StringBuilder();
        paramString1.append("[getUsrDressInfo], errInfo->");
        paramString1.append(paramQQAppInterface.getMessage());
        QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, paramString1.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject2 = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject1 = ((ApolloDaoManagerServiceImpl)localObject2).getApolloBaseInfo(paramString1);
    if (localObject1 != null)
    {
      paramInt = ((ApolloBaseInfo)localObject1).apolloStatus;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin: ");
        localStringBuilder.append(((ApolloBaseInfo)localObject1).uin);
        localStringBuilder.append(", funcSwitch:");
        localStringBuilder.append(paramInt);
        QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, localStringBuilder.toString());
      }
      int i = 0;
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress(false);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        paramInt = 0;
        while (paramInt < j)
        {
          localStringBuilder = localObject1[paramInt];
          i = localStringBuilder.mRoleGender;
          int[] arrayOfInt = localStringBuilder.getDressIds();
          if ((ApolloActionHelperImpl.isRscValid(paramString1, localStringBuilder.roleId, arrayOfInt, paramQQAppInterface, new ApolloGameBasicEventUtil.2(paramNotifyDressReady, paramQQAppInterface, paramString2, paramString3, localStringBuilder, arrayOfInt))) && (localStringBuilder.roleId != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, "valid role and dress RSC.");
            }
            if (paramNotifyDressReady != null) {
              paramNotifyDressReady.a(paramQQAppInterface, paramString1, paramString2, paramString3, localStringBuilder.roleId, arrayOfInt, 3);
            }
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, "try to get history dress ....");
          }
          paramInt += 1;
        }
        if (paramNotifyDressReady != null)
        {
          if (i == 2) {
            paramInt = 2;
          } else {
            paramInt = 1;
          }
          paramNotifyDressReady.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt), 1);
        }
        localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("uin: ");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(" dress is null,try to pull player's dress info.");
          QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, ((StringBuilder)localObject1).toString());
        }
        localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
        if (paramNotifyDressReady != null) {
          paramNotifyDressReady.a(paramQQAppInterface, paramString1, paramString2, paramString3, 1, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(1), 1);
        }
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.b(paramString1)))
      {
        paramQQAppInterface = ((ApolloDaoManagerServiceImpl)localObject2).getApolloBaseInfo(paramString1);
        long l;
        if (paramQQAppInterface != null) {
          l = paramQQAppInterface.apolloUpdateTime;
        } else {
          l = 0L;
        }
        if (NetConnInfoCenter.getServerTime() - l > 300L) {
          localApolloManagerServiceImpl.addToBulkPullMap(paramString1, 2);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, ((StringBuilder)localObject2).toString());
      }
      if (paramNotifyDressReady != null) {
        paramNotifyDressReady.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt), 1);
      }
      localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, new Object[] { "[sendEventToPage] jsonStr=", paramString });
    }
    Intent localIntent = new Intent("action_apollo_game_event_notify");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("data", paramString);
    }
    try
    {
      localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, paramString, new Object[] { "[sendEventToPage] failed to send cast" });
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().encrypt(paramArrayOfByte2, paramArrayOfByte1);
  }
  
  public static String b()
  {
    String str = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getNetworkOperatorName();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[selectProperSvrAddr], opratorName:");
      localStringBuilder.append(str);
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str))
    {
      if ((!HardCodeUtil.a(2131700598).equals(str)) && (!str.contains(HardCodeUtil.a(2131700583))))
      {
        if ((!HardCodeUtil.a(2131700596).equals(str)) && (!str.contains(HardCodeUtil.a(2131700557))))
        {
          if ((!HardCodeUtil.a(2131700569).equals(str)) && (!str.contains(HardCodeUtil.a(2131700563)))) {
            return a(b);
          }
          return a(jdField_a_of_type_ArrayOfJavaLangString);
        }
        return a(c);
      }
      return a(b);
    }
    return a(b);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, new Object[] { "[openWebView] context=", paramContext, ", jsonStr=", paramString });
    }
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.getString("url");
        if (TextUtils.isEmpty(paramString))
        {
          QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, "[openWebView] openUrl null");
          return;
        }
        String str = paramString;
        if (localJSONObject.has("param"))
        {
          localJSONObject = localJSONObject.getJSONObject("param");
          str = paramString;
          if (localJSONObject != null)
          {
            Iterator localIterator = localJSONObject.keys();
            for (;;)
            {
              str = paramString;
              if (!localIterator.hasNext()) {
                break;
              }
              str = (String)localIterator.next();
              paramString = URLUtil.a(paramString, str, localJSONObject.getString(str));
            }
          }
        }
        paramString = new Intent(paramContext, QQBrowserActivity.class);
        paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.a(paramContext, str, -1L, paramString, false, -1);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, "[openWebView] exception=", paramContext);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    label527:
    label532:
    label537:
    label543:
    label549:
    label555:
    label561:
    label567:
    label574:
    label581:
    label588:
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("tvalue")) {
          break label527;
        }
        i = ((JSONObject)localObject).getInt("tvalue");
        if (!((JSONObject)localObject).has("uintp1")) {
          break label532;
        }
        l1 = ((JSONObject)localObject).getLong("uintp1");
        if (!((JSONObject)localObject).has("uintp2")) {
          break label537;
        }
        l2 = ((JSONObject)localObject).getLong("uintp2");
        if (!((JSONObject)localObject).has("uintp3")) {
          break label543;
        }
        l3 = ((JSONObject)localObject).getLong("uintp3");
        if (!((JSONObject)localObject).has("uintp4")) {
          break label549;
        }
        l4 = ((JSONObject)localObject).getLong("uintp4");
        if (!((JSONObject)localObject).has("isNeedMac")) {
          break label555;
        }
        bool1 = ((JSONObject)localObject).getBoolean("isNeedMac");
        boolean bool2 = ((JSONObject)localObject).has("puin");
        if (!bool2) {
          break label561;
        }
        paramString = ((JSONObject)localObject).getString("puin");
        if (!((JSONObject)localObject).has("strp1")) {
          break label567;
        }
        str1 = ((JSONObject)localObject).getString("strp1");
        if (!((JSONObject)localObject).has("strp2")) {
          break label574;
        }
        str2 = ((JSONObject)localObject).getString("strp2");
        if (!((JSONObject)localObject).has("strp3")) {
          break label581;
        }
        localObject = ((JSONObject)localObject).getString("strp3");
        if (!QLog.isColorLevel()) {
          break label588;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[reportData2BackStage],tValue:");
        localStringBuilder.append(i);
        localStringBuilder.append(",uintp1:");
        localStringBuilder.append(l1);
        localStringBuilder.append(",uintp2:");
        localStringBuilder.append(l2);
        localStringBuilder.append(",uintp3:");
        localStringBuilder.append(l3);
        localStringBuilder.append(",uintp4:");
        localStringBuilder.append(l4);
        localStringBuilder.append(",isNeedMac:");
        localStringBuilder.append(bool1);
        localStringBuilder.append(",puin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",strp1:");
        localStringBuilder.append(str1);
        localStringBuilder.append(",strp2:");
        localStringBuilder.append(str2);
        localStringBuilder.append(",strp3:");
        localStringBuilder.append((String)localObject);
        QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, localStringBuilder.toString());
        ((EcshopReportHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(i, paramString, str1, str2, (String)localObject, l1, l2, l3, l4, bool1);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramString = new StringBuilder();
        paramString.append("[reportData2BackStage], errInfo->");
        paramString.append(paramQQAppInterface.getMessage());
        QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, paramString.toString());
      }
      return;
      int i = 0;
      continue;
      long l1 = 0L;
      continue;
      long l2 = 0L;
      continue;
      long l3 = 0L;
      continue;
      long l4 = 0L;
      continue;
      boolean bool1 = false;
      continue;
      paramString = "";
      continue;
      String str1 = "";
      continue;
      String str2 = "";
      continue;
      Object localObject = "";
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().decrypt(paramArrayOfByte2, paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil
 * JD-Core Version:    0.7.0.1
 */