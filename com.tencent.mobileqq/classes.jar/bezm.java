import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bezm
{
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("RobotUtils", 2, "RobotRed  get sp by app is null");
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      QLog.e("RobotUtils", 2, "RobotRed get sp by uin is null");
      return null;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("sp_robot_in_troop" + paramQQAppInterface, 0);
  }
  
  public static String a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAbsShareMsg != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label19;
      }
      localObject1 = localObject2;
    }
    label19:
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            localObject1 = localObject2;
          } while (paramAbsShareMsg.mMsgServiceID != 14);
          localObject1 = localObject2;
        } while (!a(paramAbsShareMsg.mMsgUrl));
        if (QLog.isColorLevel()) {
          QLog.d("RobotUtils", 2, "isTroopRobotQLog.isColorLevel()) {\n\t\t\tStringBuilder sb = new StringBuilder(300);\n\t\t\tsb.append(\"forwardTroopRobotCard [\")\n\t\t\t\t\t.append(\"nickname: \").append(strRobotName)\n\t\t\t\t\t.append(\", info: \").append(info)\n\t\t\t\t\t.append(\", url: \").append(strUrl)\n\t\t\t\t\t.append(\"]\");\n\t\t\tQLog.i(TAG, QLog.CLR, sb.toString());\n\t\t}\n\t}\n\n\tpublic static boolean isTroopRobotCard(String strUrl){\n\t\tif (TextUtils.isEmpty(strUrl)){\n\t\t\treturn false;\n\t\t}\n\n\t\tString strSrcUrl = getRobotProfileUrl(null, null);\n\t\tint nIndexEnd = strSrcUrl.indexOf(\"?\");\n\t\tif (nIndexEnd <= 0){\n\t\t\treturn false;\n\t\t}\n\n\t\tstrSrcUrl = strSrcUrl.substring(0, nIndexEnd);\n\n\t\tif (TextUtils.isEmpty(strSrcUrl)){\n\t\t\treturn false;\n\t\t}\n\n\t\tboolean bEqual = strSrcUrl.equalsIgnoreCase(strUrl.substring(0, strSrcUrl.length()));\n\t\tif (!bEqual){\n\t\t\treturn false;\n\t\t}\n\n\t\tString strRobotUin = getUrlParamValue(strUrl,\"robot_uin\");\n\t\tif (TextUtils.isEmpty(strRobotUin)){\n\t\t\treturn false;\n\t\t}\n\n\t\treturn true;\n\t}\n\n//\tpublic static void test(){\n//\t\tString strRet = null;\n//\t\tString s1 = \"http://web.qun.qq.com/qunrobot/data.html\";\n//\t\tstrRet = attchUrlTroopUin(s1, \"1234567\");\n//\t\tString s2 = \"http://web.qun.qq.com/qunrobot/data.html?\";\n//\t\tstrRet = attchUrlTroopUin(s2, \"7654321\");\n//\t\tString s3 = \"http://web.qun.qq.com/qunrobot/data.html?gc=11111\";\n//\t\tstrRet = attchUrlTroopUin(s3, \"2222222\");\n//\t\tString s4 = \"http://web.qun.qq.com/qunrobot/data.html?gc=11111&testp=ertyu\";\n//\t\tstrRet = attchUrlTroopUin(s4, \"33333\");\n//\t\tString s5 = \"http://web.qun.qq.com/qunrobot/data.html?gc=&testp=ertyu\";\n//\t\tstrRet = attchUrlTroopUin(s5, \"555555\");\n//\t\tString s6 = \"http://web.qun.qq.com/qunrobot/data.html?gc=&testp=\";\n//\t\tstrRet = attchUrlTroopUin(s6, \"666666\");\n//\t\tString s7 = \"http://web.qun.qq.com/qunrobot/data.html?testp=&gc=121212\";\n//\t\tstrRet = attchUrlTroopUin(s7, \"7777777\");\n//\n//\t\tQLog.d(TAG, QLog.CLR, strRet);\n//\t}\n\n\tpublic static String tryAttchTroopUinToRobotCard(AbsShareMsg shareMsg, String strTroopUin){\n\t\tif (shareMsg == null || TextUtils.isEmpty(strTroopUin)){\n\t\t\treturn null;\n\t\t}\n\n\t\tif (shareMsg.mMsgServiceID != AbsStructMsg.STRUCT_TYPE_RECOMMEND_BUDDY){\n\t\t\treturn null;\n\t\t}\n\n\t\tif (!RobotUtils.isTroopRobotCard(shareMsg.mMsgUrl)){\n\t\t\treturn null;\n\t\t}\n\t\t//!机器人 补充群信息\n\t\tif (QLog.isColorLevel()){\n\t\t\tQLog.d(TAG, QLog.CLR, \"isTroopRobotCard, url:\" + shareMsg.mMsgUrl + \" troopuin:\" + strTroopUin);\n\t\t}\n\n\t\tString strOldTroopUin = RobotUtils.getUrlParamValue(shareMsg.mMsgUrl,\"gc\");\n\t\tif (QLog.isColorLevel()){\n\t\t\tQLog.d(TAG, QLog.CLR, \"troopuin in url:\" + strOldTroopUin);\n\t\t}\n\n\t\tif (!TextUtils.isEmpty(strOldTroopUin) && strOldTroopUin.equals(strTroopUin)){\n\t\t\t//!已经替换过\n\t\t\tif (QLog.isColorLevel()){\n\t\t\t\tQLog.d(TAG, QLog.CLR, \"has troopuin:\" + shareMsg.mMsgUrl);\nCard, url:" + paramAbsShareMsg.mMsgUrl + " troopuin:" + paramString);
        }
        localObject1 = b(paramAbsShareMsg.mMsgUrl, "gc");
        if (QLog.isColorLevel()) {
          QLog.d("RobotUtils", 2, "troopuin in url:" + (String)localObject1);
        }
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(paramString))) {
          break;
        }
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("RobotUtils", 2, "has troopuin:" + paramAbsShareMsg.mMsgUrl);
      return null;
      paramString = a(paramAbsShareMsg.mMsgUrl, paramString);
      localObject1 = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "attach troopuin:" + paramAbsShareMsg.mMsgUrl);
    return paramString;
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (paramString != null) {
      str = "gc=" + paramString + "&";
    }
    paramString = "https://web.qun.qq.com/qunrobot/timingmessageedit?" + str + "r_uin=2854196310&f_id=41&type=2&slot=0&_wwv=128";
    if (QLog.isColorLevel()) {
      QLog.d("RobotUtils", 2, "url " + paramString);
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return paramString1;
    }
    return a(paramString1, "gc", paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return paramString1;
    }
    int i = paramString1.indexOf("?");
    if ((i <= 0) || (i >= paramString1.length())) {
      return paramString1 + "?" + paramString2 + "=" + paramString3;
    }
    String[] arrayOfString = paramString1.substring(i + 1).split("&");
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return paramString1 + paramString2 + "=" + paramString3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1.substring(0, i + 1));
    paramString1 = paramString2 + "=";
    int j = 0;
    int k = 0;
    i = 1;
    if (j < arrayOfString.length)
    {
      if (TextUtils.isEmpty(arrayOfString[j])) {}
      for (;;)
      {
        j += 1;
        break;
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          if (!paramString1.equalsIgnoreCase(arrayOfString[j].substring(0, paramString1.length()))) {
            break label257;
          }
          localStringBuilder.append(paramString1);
          localStringBuilder.append(paramString3);
          k = 1;
          break;
          localStringBuilder.append("&");
        }
        label257:
        localStringBuilder.append(arrayOfString[j]);
      }
    }
    if (k == 0)
    {
      localStringBuilder.append("&");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString3);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    String str2 = "";
    String str1 = str2;
    if (paramArrayList != null)
    {
      str1 = str2;
      if (paramArrayList.size() > 0)
      {
        str1 = "";
        int i = 0;
        while (i < paramArrayList.size())
        {
          str1 = str1 + (String)paramArrayList.get(i) + "_";
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("RobotUtils", 2, "RobotRed convertUinListToString  " + str1);
    }
    return str1;
  }
  
  public static ArrayList<String> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    Object localObject;
    if (paramQQAppInterface == null) {
      localObject = new ArrayList();
    }
    do
    {
      return localObject;
      localObject = a(paramQQAppInterface.getString("sp_new_robot_red_list", ""));
      paramQQAppInterface = (QQAppInterface)localObject;
      if (localObject == null) {
        paramQQAppInterface = new ArrayList();
      }
      localObject = paramQQAppInterface;
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "RobotRed getNewRobotListFromSp size  " + paramQQAppInterface.size());
    return paramQQAppInterface;
  }
  
  public static ArrayList<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("_");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int i = 0;
        if (i < arrayOfString.length)
        {
          if (!TextUtils.isEmpty(arrayOfString[i])) {
            localArrayList.add(arrayOfString[i]);
          }
          for (;;)
          {
            i += 1;
            break;
            QLog.e("RobotUtils", 2, "RobotRed SplitUinListFromString I empty " + i);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RobotUtils", 2, "RobotRed SplitUinListFromString size  " + localArrayList.size() + " listString " + paramString);
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("selfSet_leftViewText", amtj.a(2131712597));
    if (bgvh.a.containsKey("robotsummary")) {
      paramString2.putExtra("insertPluginsArray", new String[] { "robotsummary" });
    }
    paramContext.startActivity(paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RobotUtils", 2, "invokeRobotFunction, troopuin:" + paramString1 + " robotuin:" + paramString3 + " robotname:" + paramString4 + " offurl:" + paramString7 + " offtitle:" + paramString8 + " onurl:" + paramString5 + " ontitle:" + paramString6);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString8)) || (TextUtils.isEmpty(paramString7))) {}
    while (paramContext == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopuin", paramString1);
    localBundle.putString("robotuin", paramString3);
    localBundle.putString("robotname", paramString4);
    localBundle.putString("onurl", paramString5);
    localBundle.putString("ontitle", paramString6);
    localBundle.putString("offurl", paramString7);
    localBundle.putString("offtitle", paramString8);
    paramString5 = AIOUtils.setOpenAIOIntent(new Intent(paramContext, SplashActivity.class), null);
    if (paramInt == 1)
    {
      paramString5.putExtra("uin", paramString1);
      paramString5.putExtra("uintype", 1);
      paramString5.putExtra("uinname", paramString2);
    }
    for (;;)
    {
      paramString5.putExtra("key_invoke_troop_robot_function", localBundle);
      paramString5.putExtra("isBack2Root", true);
      paramContext.startActivity(paramString5);
      return;
      if (paramInt == 0)
      {
        paramString5.putExtra("uin", paramString3);
        paramString5.putExtra("uintype", 1043);
        paramString5.putExtra("uinname", paramString4);
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RobotUtils", 2, "openGroupManagerBookCard with empty troopUin");
      return;
    }
    paramString = a(paramString);
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("selfSet_leftViewText", amtj.a(2131712599));
    if (bgvh.a.containsKey("robotsummary")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "robotsummary" });
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      return;
      l = NetConnInfoCenter.getServerTime();
      paramQQAppInterface.edit().putLong("sp_robot_red_expire_time", paramLong).apply();
      paramQQAppInterface.edit().putLong("sp_robot_red_update_time", l).apply();
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "RobotRed setRobotRedInfoUpdate expireTime  " + paramLong + " update time: " + l);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      do
      {
        return;
      } while ((paramQQAppInterface != null) && (!b(paramQQAppInterface, paramString2)));
      Object localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString2;
      Object localObject2 = "AppCmd://OpenContactInfo/?uin=" + paramString2;
      paramQQAppInterface = c(paramString1, paramString2);
      paramString1 = amtj.a(2131712598) + paramString2;
      localObject2 = new bcgt(StructMsgForGeneralShare.class).c(14).a(amtj.a(2131712601) + paramString3).a(2).a(1).a("web", paramQQAppInterface, (String)localObject2, (String)localObject1, (String)localObject1).d(paramActivity.getResources().getString(2131717623)).a();
      bcla localbcla = new bcla();
      localbcla.b(1);
      localbcla.a(amtj.a(2131712600));
      bcjp localbcjp = new bcjp();
      localbcjp.b(1);
      localbcjp.a(new bciz((String)localObject1));
      localbcjp.a(new StructMsgItemTitle(paramString3));
      localbcjp.a(new bclv(paramString1));
      ((AbsShareMsg)localObject2).addItem(localbcla);
      ((AbsShareMsg)localObject2).addItem(localbcjp);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 42);
      ((Bundle)localObject1).putInt("structmsg_service_id", 14);
      ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      ((Bundle)localObject1).putBoolean("k_dataline", false);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtra("uin", paramString2);
      ((Intent)localObject2).putExtra("uinname", paramString3);
      atky.a(paramActivity, (Intent)localObject2, paramInt);
    } while (!QLog.isColorLevel());
    paramActivity = new StringBuilder(300);
    paramActivity.append("forwardTroopRobotCard [").append("nickname: ").append(paramString3).append(", info: ").append(paramString1).append(", url: ").append(paramQQAppInterface).append("]");
    QLog.i("RobotUtils", 2, paramActivity.toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Long.parseLong(paramString2);
      bcef.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", paramString3, "");
      return;
    }
    catch (Exception paramString2)
    {
      bcef.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "0", "", paramString3, "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RobotUtils", 2, "RobotRed setRobotItemRedShowed bShowed: " + paramBoolean);
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putBoolean("sp_robot_red_item_int_chat_setting", paramBoolean).apply();
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        return;
        localObject = (bfdm)((QQAppInterface)localObject).getManager(203);
      } while (localObject == null);
      ((bfdm)localObject).a(paramBoolean, paramString);
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (bfdm)paramQQAppInterface.getManager(203);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.isAdmin();
      }
      QLog.e("RobotUtils", 2, "ROBOT RED isTroopOwnerOrAdminOrMember troopInfo IS null");
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ArrayList<String> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramArrayList != null)
    {
      String str = a(paramArrayList);
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.edit().putString("sp_new_robot_red_list", str).apply();
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("RobotUtils", 2, "RobotRed setNewRobotListToSp size  " + paramArrayList.size());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      int i;
      do
      {
        return false;
        str = c(null, null);
        i = str.indexOf("?");
      } while (i <= 0);
      str = str.substring(0, i);
    } while ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramString.substring(0, str.length()))) || (TextUtils.isEmpty(b(paramString, "robot_uin"))));
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    if (!b(localQQAppInterface, paramString2))
    {
      QLog.i("RobotUtils", 2, "notifyMemChange err" + paramString2);
      return false;
    }
    ((anca)localQQAppInterface.getBusinessHandler(20)).a(paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean));
    return true;
  }
  
  public static String b(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ContactUtils.getTroopName((QQAppInterface)localAppRuntime, paramString, false);
    }
    return null;
  }
  
  public static final String b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    int i = paramString1.indexOf("?");
    if ((i <= 0) || (i >= paramString1.length())) {
      return null;
    }
    paramString1 = paramString1.substring(i + 1).split("&");
    if ((paramString1 == null) || (paramString1.length == 0)) {
      return null;
    }
    paramString2 = paramString2 + "=";
    i = 0;
    if (i < paramString1.length)
    {
      if (TextUtils.isEmpty(paramString1[i])) {}
      while (!paramString2.equalsIgnoreCase(paramString1[i].substring(0, paramString2.length())))
      {
        i += 1;
        break;
      }
      return paramString1[i].substring(paramString2.length());
    }
    return null;
  }
  
  public static ArrayList<String> b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    Object localObject;
    if (paramQQAppInterface == null) {
      localObject = new ArrayList();
    }
    do
    {
      return localObject;
      localObject = a(paramQQAppInterface.getString("sp_history_robot_red_list", ""));
      paramQQAppInterface = (QQAppInterface)localObject;
      if (localObject == null) {
        paramQQAppInterface = new ArrayList();
      }
      localObject = paramQQAppInterface;
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "RobotRed getHistoryRobotListFromSp size  " + paramQQAppInterface.size());
    return paramQQAppInterface;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RobotUtils", 2, "RobotRed setRobotRedForAllMembers bShowed: " + paramBoolean);
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putBoolean("sp_robot_red_limit_role_for_member", paramBoolean).apply();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.getBoolean("sp_robot_red_item_int_chat_setting", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "RobotRed getRobotItemRedShowed bNeedShowed: " + bool2);
    return bool2;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (bfdm)paramQQAppInterface.getManager(203);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b(paramString);
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, ArrayList<String> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramArrayList != null)
    {
      String str = a(paramArrayList);
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.edit().putString("sp_history_robot_red_list", str).apply();
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("RobotUtils", 2, "RobotRed setHistoryRobotListToSp size  " + paramArrayList.size());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static String c(String paramString1, String paramString2)
  {
    String str3 = "";
    String str2 = "robot_uin=";
    String str1 = str3;
    if (paramString1 != null)
    {
      str1 = str3;
      if (!paramString1.equals("0")) {
        str1 = "gc=" + paramString1 + "&";
      }
    }
    paramString1 = str2;
    if (paramString2 != null) {
      paramString1 = "robot_uin=" + paramString2;
    }
    return "https://web.qun.qq.com/qunrobot/data.html?" + str1 + paramString1 + "&_wwv=128&_wv=3";
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RobotUtils", 2, "RobotRed setHasShowRobotRedDotAio bShowed: " + paramBoolean);
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putBoolean("sp_robot_red_int_troop_aio", paramBoolean).apply();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.getBoolean("sp_robot_red_limit_role_for_member", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "RobotRed getIfTheRightRoleInTroopShowRobotRedDot bNeedShowed: " + bool2);
    return bool2;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (paramString == "0"))
    {
      QLog.e("RobotUtils", 2, "getNeedShowRobotRedDotAio WITH wrong troopUin");
      bool1 = bool2;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!d(paramQQAppInterface, paramString));
        paramQQAppInterface = a(paramQQAppInterface);
        bool1 = bool2;
      } while (paramQQAppInterface == null);
      bool2 = paramQQAppInterface.getBoolean("sp_robot_red_int_troop_aio", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "RobotRed needShowRobotRedDotAio bNeedShowed: " + bool2);
    return bool2;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      bool2 = bool1;
    }
    long l1;
    long l2;
    long l3;
    do
    {
      return bool2;
      l1 = paramQQAppInterface.getLong("sp_robot_red_expire_time", 3600L);
      l2 = paramQQAppInterface.getLong("sp_robot_red_update_time", 0L);
      l3 = NetConnInfoCenter.getServerTime();
      long l4 = l3 - l2;
      bool1 = bool2;
      if (l4 < l1)
      {
        bool1 = bool2;
        if (l4 > 0L) {
          bool1 = false;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "RobotRed getIfRobotRedInfoNeedUpdate: " + l1 + " update :" + l2 + " now：" + l3 + " needUpdate：" + bool1);
    return bool1;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (paramString == "0"))
    {
      QLog.e("RobotUtils", 2, "getNeedShowRobotRedDotAio WITH wrong troopUin");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      if (c(paramQQAppInterface)) {
        return true;
      }
      bool2 = a(paramQQAppInterface, paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("RobotUtils", 2, "RobotRed getIfTheRightRoleInTroopShowRobotRedDot isTroopOwnerOrAdminOrMember: " + bool2);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezm
 * JD-Core Version:    0.7.0.1
 */