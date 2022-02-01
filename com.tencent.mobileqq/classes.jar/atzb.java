import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class atzb
{
  public static int a;
  public static String a;
  public static List<String> a;
  public static int b;
  public static int c;
  public static int d = 7;
  
  static
  {
    jdField_a_of_type_Int = 3;
    b = 30000;
    c = 7000;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilList = new ArrayList(3);
  }
  
  public static int a()
  {
    return aqbo.a().b;
  }
  
  public static String a()
  {
    String str2 = aqbm.a().jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  public static void a(Context paramContext, FeedsItemData.GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {}
    while (bfwv.a(paramContext, paramGameInfo.gamePkgName)) {
      return;
    }
    bldt.a();
    paramContext = new WadlParams();
    paramContext.d = 0;
    paramContext.b(7);
    paramContext.c = "10000144";
    paramContext.jdField_e_of_type_JavaLangString = paramGameInfo.gameApkUrl;
    paramContext.jdField_a_of_type_JavaLangString = paramGameInfo.gameAppId;
    paramContext.jdField_e_of_type_Int = Integer.parseInt(paramGameInfo.gameVersionCode);
    paramContext.jdField_f_of_type_JavaLangString = paramGameInfo.gamePkgName;
    paramContext.p = "biz_src_zf_games";
    paramContext.l = "publicAccount";
    paramContext.j = paramGameInfo.gameName;
    paramContext.k = paramGameInfo.gameIcon;
    paramContext.b = 2;
    paramContext.m = "publicAccount";
    bldt.a().a(paramContext);
  }
  
  public static void a(Bundle paramBundle, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "downloadGame appId=" + paramString + ",isRes=" + paramBoolean + ",resType=" + paramInt + ",req=" + paramBundle);
    }
    if ((paramBundle == null) || (TextUtils.isEmpty(paramString))) {}
    String str;
    do
    {
      return;
      str = paramBundle.getString("packageName");
    } while (TextUtils.isEmpty(str));
    Object localObject2 = paramBundle.getString("apkChannel");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "10000144";
    }
    bldt.a();
    localObject2 = new WadlParams();
    ((WadlParams)localObject2).d = paramBundle.getInt("from");
    ((WadlParams)localObject2).b(paramBundle.getInt("flags"));
    ((WadlParams)localObject2).c = ((String)localObject1);
    ((WadlParams)localObject2).jdField_e_of_type_JavaLangString = paramBundle.getString("apkUrl");
    ((WadlParams)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((WadlParams)localObject2).jdField_e_of_type_Int = paramBundle.getInt("versionCode");
    ((WadlParams)localObject2).jdField_f_of_type_JavaLangString = str;
    localObject1 = paramBundle.getString("appName");
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = ((WadlParams)localObject2).jdField_f_of_type_JavaLangString;
    }
    ((WadlParams)localObject2).j = paramString;
    ((WadlParams)localObject2).p = "biz_src_zf_games";
    ((WadlParams)localObject2).l = paramBundle.getString("via");
    ((WadlParams)localObject2).b = 2;
    ((WadlParams)localObject2).o = paramBundle.getString("ext");
    ((WadlParams)localObject2).m = paramBundle.getString("fromWebUrl", "");
    ((WadlParams)localObject2).jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      ((WadlParams)localObject2).jdField_g_of_type_Int = paramInt;
      ((WadlParams)localObject2).jdField_f_of_type_Int = paramBundle.getInt("resIndex");
      ((WadlParams)localObject2).h = paramBundle.getString("resName");
      ((WadlParams)localObject2).jdField_g_of_type_JavaLangString = paramBundle.getString("resVersionName");
      ((WadlParams)localObject2).i = paramBundle.getString("resMD5");
    }
    bldt.a().a((WadlParams)localObject2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    String str = "sp_key_game_center_feeds_show_float_window_date" + paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = "sp_key_game_center_feeds_float_window_showed_games" + paramQQAppInterface.getCurrentAccountUin();
    jdField_a_of_type_JavaLangString = localSharedPreferences.getString(str, "");
    if (c().equals(jdField_a_of_type_JavaLangString))
    {
      paramQQAppInterface = localSharedPreferences.getString(paramQQAppInterface, "");
      if ((TextUtils.isEmpty(paramQQAppInterface)) || (paramQQAppInterface.split(";").length == 0)) {
        jdField_a_of_type_JavaUtilList = new ArrayList(3);
      }
      for (;;)
      {
        return;
        paramQQAppInterface = paramQQAppInterface.split(";");
        jdField_a_of_type_JavaUtilList = new ArrayList(3);
        while (i < paramQQAppInterface.length)
        {
          jdField_a_of_type_JavaUtilList.add(paramQQAppInterface[i]);
          i += 1;
        }
      }
    }
    jdField_a_of_type_JavaLangString = c();
    jdField_a_of_type_JavaUtilList = new ArrayList(3);
  }
  
  public static void a(WadlParams paramWadlParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "installGame params=" + paramWadlParams);
    }
    bldt.a();
    bldt.a().b(paramWadlParams);
  }
  
  public static boolean a()
  {
    aqbl localaqbl = aqbm.a();
    if ((localaqbl != null) && (localaqbl.jdField_a_of_type_Int > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameConfigUtil", 2, "isPubAccountSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "isPubAccountSwitch = false");
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilList == null) {
      jdField_a_of_type_JavaUtilList = new ArrayList(3);
    }
    return (jdField_a_of_type_JavaUtilList.size() < 3) && (!jdField_a_of_type_JavaUtilList.contains(paramString));
  }
  
  public static String b()
  {
    String str2 = aqbm.a().jdField_b_of_type_JavaLangString;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
    }
    do
    {
      do
      {
        return str1;
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        str1 = str2;
      } while (str2.startsWith("http://"));
      str1 = str2;
    } while (str2.startsWith("https://"));
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
  }
  
  public static boolean b()
  {
    apxv localapxv = apxw.a();
    if ((localapxv != null) && (localapxv.b > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameConfigUtil", 2, "isGcMsgRemindOptimizeSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "isGcMsgRemindOptimizeSwitch = false");
    }
    return false;
  }
  
  public static String c()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    Object localObject = aqbm.a();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((aqbl)localObject).c > 0)
      {
        localObject = ((aqbl)localObject).jdField_a_of_type_JavaLangString;
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bool1 = bool2;
          if (bjnd.a((String)localObject)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static String d()
  {
    String str2 = aqbo.a().jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://imgcache.qq.com/ogame/sgame-official-account/precache.html";
    }
    return str1;
  }
  
  public static boolean d()
  {
    aqbn localaqbn = aqbo.a();
    if ((localaqbn != null) && (localaqbn.jdField_a_of_type_Int > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameConfigUtil", 2, "isPreloadSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "isPreloadSwitch = false");
    }
    return false;
  }
  
  public static boolean e()
  {
    aqbl localaqbl = aqbm.a();
    return (localaqbl != null) && (localaqbl.jdField_a_of_type_Boolean);
  }
  
  public static boolean f()
  {
    aqbl localaqbl = aqbm.a();
    return (localaqbl != null) && (localaqbl.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzb
 * JD-Core Version:    0.7.0.1
 */