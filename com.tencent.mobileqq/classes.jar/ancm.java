import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ancm
{
  public static long a;
  public static String[] a;
  public static String[] b = { "14.17.42.125", "59.37.96.212", "180.163.32.167", "101.226.90.166" };
  public static String[] c = { "58.250.137.13", "163.177.90.55", "140.206.160.112", "140.207.123.182" };
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "117.144.242.75", "117.144.245.207" };
  }
  
  public static int a()
  {
    int i = 10060;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[getRecommendIp]");
    }
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt("game_rec_port", 10060);
    if (j <= 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "recom_port:" + i);
      }
      return i;
      i = j;
    }
  }
  
  public static String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[getRecommendIp]");
    }
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getString("game_rec_ip", "");
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "recom_ip:" + str2);
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = b();
      str1 = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloGameBasicEventUtil", 2, "random_ip:" + str2);
        str1 = str2;
      }
    }
    return str1;
  }
  
  public static String a(String[] paramArrayOfString)
  {
    String str1 = "14.17.42.125";
    if (paramArrayOfString != null) {}
    for (;;)
    {
      try
      {
        int i = paramArrayOfString.length;
        if (i != 0) {
          continue;
        }
        paramArrayOfString = str1;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloGameBasicEventUtil", 2, "[getRandomIp], retIp:" + "14.17.42.125");
          paramArrayOfString = str1;
        }
      }
      catch (Exception paramArrayOfString)
      {
        String str2;
        QLog.e("ApolloGameBasicEventUtil", 1, "[getRandomIp], errInfo->" + paramArrayOfString.getMessage());
        return "14.17.42.125";
      }
      finally
      {
        paramArrayOfString = str1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameBasicEventUtil", 2, "[getRandomIp], retIp:" + "14.17.42.125");
      }
      return paramArrayOfString;
      str2 = paramArrayOfString[awfd.a(paramArrayOfString.length)];
      paramArrayOfString = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloGameBasicEventUtil", 2, "[getRandomIp], retIp:" + str2);
        return str2;
      }
    }
    return "14.17.42.125";
  }
  
  public static JSONObject a(int paramInt, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        try
        {
          Object localObject = new JSONObject();
          if (paramInt == 0)
          {
            ((JSONObject)localObject).put("atlas", "def/basic/skeleton/role");
            ((JSONObject)localObject).put("json", "def/basic/skeleton/role");
            localJSONObject1.put("skltPath", localObject);
            localObject = new JSONArray();
            int j = paramArrayOfInt.length;
            int i = 0;
            if (i >= j) {
              continue;
            }
            localInteger = Integer.valueOf(paramArrayOfInt[i]);
            localJSONObject2 = new JSONObject();
            if (paramInt != 0) {
              continue;
            }
            localJSONObject2.put("atlas", "def/basic/dress/" + localInteger + "/dress");
            localJSONObject2.put("json", "def/basic/dress/" + localInteger + "/dress");
            ((JSONArray)localObject).put(localJSONObject2);
            i += 1;
            continue;
          }
          ((JSONObject)localObject).put("atlas", amzq.a(paramInt + "/role", 1));
          ((JSONObject)localObject).put("json", amzq.a(paramInt + "/role", 1));
          continue;
          QLog.e("ApolloGameBasicEventUtil", 1, "[notifyRoleDress], errInfo->" + localException1.getMessage());
        }
        catch (Exception localException1)
        {
          paramArrayOfInt = localJSONObject1;
        }
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject1;
        Integer localInteger;
        JSONObject localJSONObject2;
        paramArrayOfInt = null;
        continue;
      }
      return paramArrayOfInt;
      localJSONObject2.put("atlas", amzq.a(localInteger + "/dress", 2));
      localJSONObject2.put("json", amzq.a(localInteger + "/dress", 2));
    }
    localJSONObject1.put("dressPath", localException1);
    return localJSONObject1;
  }
  
  public static void a(int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, String paramString3, ancs paramancs)
  {
    amhd localamhd = (amhd)paramQQAppInterface.getManager(153);
    Object localObject = localamhd.b(paramString1);
    if (localObject != null)
    {
      paramInt2 = ((ApolloBaseInfo)localObject).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "uin: " + ((ApolloBaseInfo)localObject).uin + ", funcSwitch:" + paramInt2);
      }
      localObject = ((ApolloBaseInfo)localObject).getApolloDress(false);
      int i;
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        paramInt2 = 0;
        i = 0;
        if (paramInt2 < j)
        {
          amls localamls = localObject[paramInt2];
          i = localamls.jdField_b_of_type_Int;
          int[] arrayOfInt = localamls.a();
          if ((amzq.a(paramString1, localamls.jdField_a_of_type_Int, arrayOfInt, paramQQAppInterface, new ancq(paramancs, paramInt1, paramQQAppInterface, paramString2, paramString3, localamls, arrayOfInt))) && (localamls.jdField_a_of_type_Int != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameBasicEventUtil", 2, "valid role and dress RSC.");
            }
            if (paramancs != null) {
              paramancs.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, localamls.jdField_a_of_type_Int, arrayOfInt, 3);
            }
          }
        }
      }
      label282:
      label419:
      label423:
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameBasicEventUtil", 2, "try to get history dress ....");
        }
        paramInt2 += 1;
        break;
        if (paramancs != null)
        {
          if (i == 2)
          {
            paramInt2 = 2;
            paramancs.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt2, amxb.a(paramInt2), 1);
          }
        }
        else
        {
          amhd.a(paramQQAppInterface, paramString1, "apllo_game");
          paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.b(paramString1))) {
            continue;
          }
          paramQQAppInterface = localamhd.b(paramString1);
          if (paramQQAppInterface == null) {
            break label419;
          }
        }
        for (long l = paramQQAppInterface.apolloUpdateTime;; l = 0L)
        {
          if (NetConnInfoCenter.getServerTime() - l <= 300L) {
            break label423;
          }
          localamhd.a(paramString1, 2);
          return;
          paramInt2 = 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameBasicEventUtil", 2, "uin: " + paramString1 + " dress is null,try to pull player's dress info.");
          }
          amhd.a(paramQQAppInterface, paramString1, "apllo_game");
          if (paramancs == null) {
            break label282;
          }
          paramancs.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, 1, amxb.a(1), 1);
          break label282;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject);
    }
    if (paramancs != null) {
      paramancs.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt2, amxb.a(paramInt2), 1);
    }
    amhd.a(paramQQAppInterface, paramString1, "apllo_game");
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    int i;
    angn localangn;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame.sendmsg", 2, new Object[] { "[sendGameShareMsg],json:", paramString });
      }
      long l;
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("gameMode");
        l = paramString.optLong("roomId");
        localangn = new angn();
        localObject1 = ampj.a(paramInt);
        if (localObject1 != null)
        {
          localObject1 = ((amrk)localObject1).a();
          if ((localObject1 != null) && (((CmGameStartChecker.StartCheckParam)localObject1).game != null))
          {
            localangn.jdField_b_of_type_Int = ((CmGameStartChecker.StartCheckParam)localObject1).game.actionId;
            localangn.jdField_b_of_type_JavaLangString = ((CmGameStartChecker.StartCheckParam)localObject1).game.name;
          }
        }
        if (localangn.jdField_b_of_type_Int <= 0) {
          localangn.jdField_b_of_type_Int = 439;
        }
        localangn.jdField_a_of_type_Int = paramInt;
        localangn.jdField_a_of_type_JavaLangString = anni.a(2131699176);
        localangn.jdField_c_of_type_Int = i;
        localangn.jdField_a_of_type_Long = l;
        localangn.d = 4;
        Object localObject2 = paramString.optString("extendInfo");
        localObject1 = new JSONObject();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("extendInfo", localObject2);
        }
        localObject2 = paramString.optString("summary");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("summary", localObject2);
        }
        localObject2 = paramString.optString("picUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("picUrl", localObject2);
        }
        ((JSONObject)localObject1).put("xyRootSrc", amnl.a(paramInt));
        i = paramString.optInt("activityId");
        int j = paramString.optInt("reqCode");
        localObject2 = ampj.a(paramInt);
        if (localObject2 != null)
        {
          ((amrk)localObject2).jdField_b_of_type_Int = i;
          ((amrk)localObject2).jdField_c_of_type_Int = j;
        }
        localangn.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).toString();
        if (localangn.jdField_c_of_type_JavaLangString.length() >= 500)
        {
          QLog.w("cmgame.sendmsg", 1, "extendInfo is too long, len:" + localangn.jdField_c_of_type_JavaLangString.length() + ",content:" + localangn.jdField_c_of_type_JavaLangString);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame.sendmsg", 1, paramString, new Object[0]);
        return;
      }
      i = paramString.optInt("isSelectFriend");
      if (!paramString.has("isSelectFriend")) {
        i = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame.sendmsg", 2, new Object[] { "isSelectFriend:", Integer.valueOf(i) });
      }
      Object localObject1 = amrr.a();
      if ((localObject1 != null) && (((amrr)localObject1).a != null) && (0L != l)) {
        ((amrr)localObject1).a.roomId = l;
      }
      if (i == 0)
      {
        paramString.put("msgType", 4);
        amqz.a("cs.send_game_msg.local", paramString.toString(), true, null, paramInt);
        return;
      }
    } while (1 != i);
    a(localangn, paramActivity, 3);
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = (amhd)paramQQAppInterface.getManager(153);
    Object localObject2 = amhd.jdField_c_of_type_JavaLangString;
    localObject1 = amhd.jdField_b_of_type_JavaLangString;
    paramString = a(((String)localObject2).getBytes(), paramString.getBytes());
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("data", paramString.toString());
      ((JSONObject)localObject2).put("st", localObject1);
      ApolloCmdChannel.getChannel(paramQQAppInterface).callbackFromRequest(paramLong, 0, "cs.encrypt_data.local", ((JSONObject)localObject2).toString());
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 2, "doEncrypt fail e:" + paramQQAppInterface.toString());
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    try
    {
      paramString2 = new JSONObject(paramString2).optString("uin");
      if (!TextUtils.isEmpty(paramString2)) {
        QLog.i("ApolloGameBasicEventUtil", 1, "pass uin.");
      }
      for (;;)
      {
        a(paramLong, paramQQAppInterface, paramString2, "", 1, paramString1, new ancn());
        return;
        QLog.w("ApolloGameBasicEventUtil", 1, "This branch cann't be reached. If so, something illegal must have been happening.");
        paramString2 = "";
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[getUsrDressInfo], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, ancr paramancr)
  {
    amhd localamhd = (amhd)paramQQAppInterface.getManager(153);
    Object localObject = localamhd.b(paramString1);
    if (localObject != null)
    {
      paramInt = ((ApolloBaseInfo)localObject).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "uin: " + ((ApolloBaseInfo)localObject).uin + ", funcSwitch:" + paramInt);
      }
      localObject = ((ApolloBaseInfo)localObject).getApolloDress(false);
      int i;
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        paramInt = 0;
        i = 0;
        if (paramInt < j)
        {
          amls localamls = localObject[paramInt];
          i = localamls.jdField_b_of_type_Int;
          int[] arrayOfInt = localamls.a();
          if ((amzq.a(paramString1, localamls.jdField_a_of_type_Int, arrayOfInt, paramQQAppInterface, new ancp(paramancr, paramLong, paramQQAppInterface, paramString2, paramString3, localamls, arrayOfInt))) && (localamls.jdField_a_of_type_Int != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameBasicEventUtil", 2, "valid role and dress RSC.");
            }
            if (paramancr != null) {
              paramancr.a(paramLong, paramQQAppInterface, paramString1, paramString2, paramString3, localamls.jdField_a_of_type_Int, arrayOfInt, 3);
            }
          }
        }
      }
      label285:
      label421:
      label424:
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameBasicEventUtil", 2, "try to get history dress ....");
        }
        paramInt += 1;
        break;
        if (paramancr != null)
        {
          if (i == 2)
          {
            paramInt = 2;
            paramancr.a(paramLong, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, amxb.a(paramInt), 1);
          }
        }
        else
        {
          amhd.a(paramQQAppInterface, paramString1, "apllo_game");
          paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.b(paramString1))) {
            continue;
          }
          paramQQAppInterface = localamhd.b(paramString1);
          if (paramQQAppInterface == null) {
            break label421;
          }
        }
        for (paramLong = paramQQAppInterface.apolloUpdateTime;; paramLong = 0L)
        {
          if (NetConnInfoCenter.getServerTime() - paramLong <= 300L) {
            break label424;
          }
          localamhd.a(paramString1, 2);
          return;
          paramInt = 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameBasicEventUtil", 2, "uin: " + paramString1 + " dress is null,try to pull player's dress info.");
          }
          amhd.a(paramQQAppInterface, paramString1, "apllo_game");
          if (paramancr == null) {
            break label285;
          }
          paramancr.a(paramLong, paramQQAppInterface, paramString1, paramString2, paramString3, 1, amxb.a(1), 1);
          break label285;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject);
    }
    if (paramancr != null) {
      paramancr.a(paramLong, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, amxb.a(paramInt), 1);
    }
    amhd.a(paramQQAppInterface, paramString1, "apllo_game");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[openFloatTransparentView] context=", paramContext, ", jsonStr=", paramString });
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject(paramString);
      paramString = localJSONObject1.getString("url");
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[openFloatTransparentView] openUrl null");
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[openFloatTransparentView] exception=", paramContext);
      return;
    }
    Object localObject = paramString;
    if (localJSONObject1.has("param"))
    {
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("param");
      localObject = paramString;
      if (localJSONObject2 != null)
      {
        localObject = localJSONObject2.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramString = bkgj.a(paramString, str, localJSONObject2.getString(str));
        }
      }
    }
    for (;;)
    {
      int i = localJSONObject1.optInt("closeBtn");
      int j = localJSONObject1.optInt("fullScreen");
      paramString = new Intent(paramContext, ApolloFloatActivity.class);
      paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      paramString.putExtra("extra_key_click_time", System.currentTimeMillis());
      paramString.putExtra("extra_key_weburl", (String)localObject);
      if (i == 1)
      {
        bool = true;
        paramString.putExtra("extra_key_close_btn", bool);
        if (j != 1) {
          break label284;
        }
      }
      label284:
      for (boolean bool = true;; bool = false)
      {
        paramString.putExtra("extra_key_fullscreen", bool);
        paramContext.startActivity(paramString);
        return;
        bool = false;
        break;
      }
      localObject = paramString;
    }
  }
  
  public static void a(angn paramangn, Activity paramActivity, int paramInt)
  {
    if (paramangn == null)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[forwardGameMsg], Fail to forward gameMsg, msgInfo is null.");
      return;
    }
    paramangn.a();
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    localBundle.putInt("apollo.game.invite.from", paramInt);
    localBundle.putInt("forward.apollo.gameid", paramangn.jdField_a_of_type_Int);
    localBundle.putInt("forward.apollo.gameMode", paramangn.jdField_c_of_type_Int);
    localBundle.putInt("forward_type", 34);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[forwardGameMsg] gameId:" + paramangn.jdField_a_of_type_Int + ";fromtype:" + paramInt);
    }
    if (paramInt == 2)
    {
      localIntent.putExtras(localBundle);
      aufz.a(paramActivity, localIntent, 99999);
      return;
    }
    localBundle.putInt("forward.apollo.actionid", paramangn.jdField_b_of_type_Int);
    localBundle.putLong("forward.apollo.roomid", paramangn.jdField_a_of_type_Long);
    localBundle.putString("forward.apollo.gamename", paramangn.jdField_b_of_type_JavaLangString);
    localBundle.putString("forward.apollo.actionname", paramangn.jdField_a_of_type_JavaLangString);
    localBundle.putInt("forward.apollo.msgtype", paramangn.d);
    localBundle.putString("forward.apollo.sharejson", paramangn.jdField_c_of_type_JavaLangString);
    localIntent.putExtras(localBundle);
    aufz.a(paramActivity, localIntent, 20180426);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    int j = 0;
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramAppInterface = "";
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("enter")) {
          break label360;
        }
        i = ((JSONObject)localObject).getInt("enter");
        if (((JSONObject)localObject).has("result")) {
          j = ((JSONObject)localObject).getInt("result");
        }
        if (((JSONObject)localObject).has("actionName")) {
          paramAppInterface = ((JSONObject)localObject).getString("actionName");
        }
        if (!((JSONObject)localObject).has("r2")) {
          break label354;
        }
        paramString = ((JSONObject)localObject).getString("r2");
        if (!((JSONObject)localObject).has("r3")) {
          break label347;
        }
        str1 = ((JSONObject)localObject).getString("r3");
        if (!((JSONObject)localObject).has("r4")) {
          break label340;
        }
        str2 = ((JSONObject)localObject).getString("r4");
        if (((JSONObject)localObject).has("r5"))
        {
          localObject = ((JSONObject)localObject).getString("r5");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameBasicEventUtil", 2, "[reportData2Compass],entry:" + i + ",result:" + j + ",actionName:" + paramAppInterface + ",r2:" + paramString + ",r3:" + str1 + ",r4:" + str2 + ",r5:" + (String)localObject);
          }
          VipUtils.a(null, "cmshow", "Apollo", paramAppInterface, i, j, new String[] { paramString, str1, str2, localObject });
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[reportData2Compass], errInfo->" + paramAppInterface.getMessage());
        return;
      }
      Object localObject = "";
      continue;
      label340:
      String str2 = "";
      continue;
      label347:
      String str1 = "";
      continue;
      label354:
      paramString = "";
      continue;
      label360:
      int i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    try
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      paramString = new JSONObject(paramString);
      paramQQAppInterface = "";
      if (paramString.has("ip")) {
        paramQQAppInterface = paramString.getString("ip");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "[saveRecommendIp], ip:" + paramQQAppInterface);
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
      QLog.e("ApolloGameBasicEventUtil", 1, "[saveRecommendIp], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    while (System.currentTimeMillis() - jdField_a_of_type_Long <= 1000L) {
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[sendCmGameMsg],jsonParam:", paramString });
    }
    label427:
    label436:
    label446:
    label499:
    for (;;)
    {
      JSONObject localJSONObject;
      angn localangn;
      try
      {
        Object localObject = (ancd)paramQQAppInterface.getManager(155);
        localJSONObject = new JSONObject(paramString);
        int j = localJSONObject.optInt("gameMode");
        int k = localJSONObject.optInt("gameId");
        long l = localJSONObject.optLong("roomId");
        localangn = new angn();
        ApolloGameData localApolloGameData = ((ancd)localObject).a(k);
        paramString = anni.a(2131699158);
        if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
        {
          localObject = ((ancd)localObject).a(localApolloGameData.actionId);
          if (localObject == null) {
            break label499;
          }
          paramString = ((ApolloActionData)localObject).actionName;
          i = localApolloGameData.actionId;
          localangn.jdField_b_of_type_JavaLangString = localApolloGameData.name;
          if (0L == l) {
            QLog.w("cmgame.sendmsg", 1, "[sendCmGameMsg] roomId is invalid. gameId:" + k + ",gameMode:" + j);
          }
          localangn.jdField_a_of_type_JavaLangString = paramString;
          localangn.jdField_b_of_type_Int = i;
          localangn.jdField_c_of_type_Int = j;
          localangn.jdField_a_of_type_Long = l;
          localangn.jdField_a_of_type_Int = k;
          i = localJSONObject.optInt("msgType");
          if (i == 0) {
            break label427;
          }
          localangn.d = i;
          paramString = amrr.a();
          if ((paramString != null) && (paramString.a != null) && (0L != l)) {
            paramString.a.roomId = l;
          }
          paramString = localJSONObject.optString("extendInfo");
          localJSONObject = new JSONObject();
          if (TextUtils.isEmpty(paramString)) {
            break label446;
          }
          localJSONObject.put("extendInfo", paramString);
          if (paramString.length() < 500) {
            break label436;
          }
          QLog.w("cmgame.sendmsg", 1, "[sendCmGameMsg],extendInfo is too long, extendInfo:" + paramString);
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("cmgame.sendmsg", 1, paramQQAppInterface, new Object[0]);
        return;
      }
      localangn.jdField_b_of_type_JavaLangString = anni.a(2131699177);
      int i = 0;
      continue;
      localangn.d = 3;
      continue;
      localangn.jdField_c_of_type_JavaLangString = localJSONObject.toString();
      paramString = ((FragmentActivity)paramActivity).getChatFragment().a();
      if ((paramString == null) || (paramString.h() >= 7))
      {
        QLog.i("cmgame.sendmsg", 1, "aio is closed, choose a friend to send msg.");
        a(localangn, paramActivity, 3);
        return;
      }
      ApolloGameUtil.a(paramQQAppInterface, localangn, paramString.a());
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        paramString2 = localJSONObject.optString("uin");
        String str = localJSONObject.optString("openId");
        int i = localJSONObject.optInt("gameId");
        if (!TextUtils.isEmpty(paramString2))
        {
          QLog.i("ApolloGameBasicEventUtil", 1, "pass uin.");
          a(paramInt, paramQQAppInterface, paramString2, str, 1, paramString1, new anco(i));
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[getUsrDressInfo], errInfo->" + paramQQAppInterface.getMessage());
        return;
      }
      paramString2 = "";
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[sendEventToPage] jsonStr=", paramString });
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
      QLog.e("ApolloGameBasicEventUtil", 1, paramString, new Object[] { "[sendEventToPage] failed to send cast" });
    }
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[openWebViewWithoutUrl] context=", paramContext, ", jsonStr=", paramString, "gameId:", Integer.valueOf(paramInt1), ",taskId:", Integer.valueOf(paramInt2) });
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    for (;;)
    {
      int i;
      Intent localIntent;
      amrk localamrk;
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("businessType");
        localIntent = new Intent(paramContext, ApolloFloatActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        localamrk = ampj.a();
        if ((localamrk == null) || (localamrk.a() == null)) {
          break label724;
        }
        if (localamrk.a().game != null) {
          break label726;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, paramContext, new Object[] { "[openWebViewWithoutUrl]" });
        return false;
      }
      QLog.e("ApolloGameBasicEventUtil", 1, new Object[] { "[openWebViewWithoutUrl] not bustype", Integer.valueOf(i) });
      localIntent.putExtra("game_busid", "Android.H5");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, 9999);
      }
      paramInt2 = paramString.optInt("gameOrientation");
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      }
      if (paramInt1 == 2)
      {
        ApolloUtil.a(paramContext, 0, 0);
        break;
        int j = paramString.optInt("gameOrientation");
        i = j;
        if (j == 0) {
          i = 1;
        }
        String str = String.format("https://cmshow.qq.com/apollo/html/game-platform/buy-props.html?_wv=3&adtag=inside_game&gameId=%s&gameOrientation=%s&itemList=%s", new Object[] { Integer.valueOf(localamrk.a()), Integer.valueOf(i), URLEncoder.encode(paramString.optString("itemList"), "UTF-8") });
        localIntent.putExtra("extra_key_weburl", str);
        localIntent.putExtra("url", str);
        localIntent.putExtra("extra_key_transparent", paramString.optInt("transparent"));
        localIntent.putExtra("extra_key_fullscreen", true);
        localIntent.putExtra("extra_key_close_btn", true);
        localIntent.putExtra("extra_key_entratation", i);
        localIntent.putExtra("extra_key_from", 1);
        localIntent.putExtra("extra_key_gameid", paramInt1);
        localIntent.putExtra("extra_key_taskid", paramInt2);
        VipUtils.a(null, "cmshow", "Apollo", "open_webpage", 0, 0, new String[] { localamrk.a().mGameName });
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[openWebViewWithoutUrl] url ", str });
          continue;
          str = paramString.optString("url");
          if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str)))
          {
            QLog.e("ApolloGameBasicEventUtil", 1, "[openWebViewWithoutUrl] ill url " + str);
            return false;
          }
          j = paramString.optInt("gameOrientation");
          i = j;
          if (j == 0) {
            i = 1;
          }
          localIntent.putExtra("url", str);
          localIntent.putExtra("extra_key_weburl", str);
          localIntent.putExtra("extra_key_transparent", paramString.optInt("transparent"));
          localIntent.putExtra("extra_key_fullscreen", true);
          localIntent.putExtra("extra_key_close_btn", false);
          localIntent.putExtra("extra_key_entratation", i);
          localIntent.putExtra("extra_key_from", 1);
          localIntent.putExtra("extra_key_gameid", paramInt1);
          localIntent.putExtra("extra_key_taskid", paramInt2);
          localIntent.addFlags(65536);
          VipUtils.a(null, "cmshow", "Apollo", "open_webpage", 1, 0, new String[] { localamrk.a().mGameName });
        }
      }
      else
      {
        if (paramInt1 == 3)
        {
          ApolloUtil.a(paramContext, 4, 4);
          break;
        }
        ApolloUtil.a(paramContext, 1, 1);
        break;
        label724:
        return false;
        label726:
        switch (i)
        {
        }
      }
    }
    return true;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().encrypt(paramArrayOfByte2, paramArrayOfByte1);
  }
  
  private static String b()
  {
    String str = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getNetworkOperatorName();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[selectProperSvrAddr], opratorName:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      if ((anni.a(2131699185).equals(str)) || (str.contains(anni.a(2131699170)))) {
        return a(b);
      }
      if ((anni.a(2131699183).equals(str)) || (str.contains(anni.a(2131699144)))) {
        return a(c);
      }
      if ((anni.a(2131699156).equals(str)) || (str.contains(anni.a(2131699150)))) {
        return a(jdField_a_of_type_ArrayOfJavaLangString);
      }
      return a(b);
    }
    return a(b);
  }
  
  public static void b(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramString = b(amhd.jdField_c_of_type_JavaLangString.getBytes(), paramString.getBytes());
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", paramString.toString());
      ApolloCmdChannel.getChannel(paramQQAppInterface).callbackFromRequest(paramLong, 0, "cs.decrypt_data.local", localJSONObject.toString());
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 2, "doEncrypt fail e:" + paramQQAppInterface.toString());
    }
  }
  
  public static void b(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramString2 = b();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ip", paramString2);
      localJSONObject.put("port", 10060);
      ApolloCmdChannel.getChannel(paramQQAppInterface).callbackFromRequest(paramLong, 0, paramString1, localJSONObject.toString());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[getSvrIpPort], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[openWebView] context=", paramContext, ", jsonStr=", paramString });
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.getString("url");
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[openWebView] openUrl null");
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[openWebView] exception=", paramContext);
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
          paramString = bkgj.a(paramString, str, localJSONObject.getString(str));
        }
      }
    }
    paramString = new Intent(paramContext, QQBrowserActivity.class);
    paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, str, -1L, paramString, false, -1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i = 0;
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    boolean bool = false;
    String str4 = "";
    String str1 = "";
    String str2 = "";
    String str3 = "";
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("tvalue")) {
        i = localJSONObject.getInt("tvalue");
      }
      if (localJSONObject.has("uintp1")) {
        l1 = localJSONObject.getLong("uintp1");
      }
      if (localJSONObject.has("uintp2")) {
        l2 = localJSONObject.getLong("uintp2");
      }
      if (localJSONObject.has("uintp3")) {
        l3 = localJSONObject.getLong("uintp3");
      }
      if (localJSONObject.has("uintp4")) {
        l4 = localJSONObject.getLong("uintp4");
      }
      if (localJSONObject.has("isNeedMac")) {
        bool = localJSONObject.getBoolean("isNeedMac");
      }
      paramString = str4;
      if (localJSONObject.has("puin")) {
        paramString = localJSONObject.getString("puin");
      }
      if (localJSONObject.has("strp1")) {
        str1 = localJSONObject.getString("strp1");
      }
      if (localJSONObject.has("strp2")) {
        str2 = localJSONObject.getString("strp2");
      }
      if (localJSONObject.has("strp3")) {
        str3 = localJSONObject.getString("strp3");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "[reportData2BackStage],tValue:" + i + ",uintp1:" + l1 + ",uintp2:" + l2 + ",uintp3:" + l3 + ",uintp4:" + l4 + ",isNeedMac:" + bool + ",puin:" + paramString + ",strp1:" + str1 + ",strp2:" + str2 + ",strp3:" + str3);
      }
      ((odu)paramQQAppInterface.a(88)).a(i, paramString, str1, str2, str3, l1, l2, l3, l4, bool);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[reportData2BackStage], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().decrypt(paramArrayOfByte2, paramArrayOfByte1);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    String str = paramQQAppInterface.getAccount();
    int j = bgnt.b(paramQQAppInterface.getApp());
    long l1 = 0L;
    label199:
    label204:
    label210:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("isUp")) {
          break label204;
        }
        if (paramString.getInt("isUp") == 1)
        {
          bool = true;
          break label210;
          if (paramString.has("byteSize")) {
            l1 = paramString.getLong("byteSize");
          }
          if (!paramString.has("aioType")) {
            break label199;
          }
          i = paramString.getInt("aioType");
          long l2 = System.currentTimeMillis();
          paramQQAppInterface.sendAppDataIncerment(str, bool, j, 0, i, l1);
          l1 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloGameBasicEventUtil", 2, "flowReport cost:" + (l1 - l2));
          return;
        }
        bool = false;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[reportFlowData], errInfo->" + paramQQAppInterface.getMessage());
        return;
      }
      int i = 0;
      continue;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancm
 * JD-Core Version:    0.7.0.1
 */