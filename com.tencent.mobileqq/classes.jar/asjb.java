import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class asjb
{
  public static int a;
  public static String a;
  public static List<String> a;
  public static int b;
  public static int c;
  public static int d;
  
  static
  {
    jdField_a_of_type_Int = 3;
    jdField_b_of_type_Int = 30000;
    c = 7000;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilList = new ArrayList(3);
    jdField_d_of_type_Int = 7;
  }
  
  public static int a()
  {
    int j = aomj.a().jdField_b_of_type_Int;
    int i = j;
    if (j == 0) {
      i = jdField_d_of_type_Int;
    }
    return i;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGameConfigUtil", 2, "decode bitmap width = " + paramInt1 + " height=" + paramInt2 + "is error");
      }
      return null;
    }
    if ((paramInt2 == 0) && (paramInt1 == 0)) {}
    try
    {
      return BitmapFactory.decodeFile(paramString);
    }
    catch (Throwable paramString) {}
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    if (paramInt2 > 0) {}
    for (paramInt2 = localOptions.outHeight / paramInt2;; paramInt2 = 0)
    {
      if (paramInt1 > 0) {
        i = localOptions.outWidth / paramInt1;
      }
      localOptions.inJustDecodeBounds = false;
      if (paramInt2 > i) {}
      for (;;)
      {
        localOptions.inSampleSize = paramInt2;
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
        return paramString;
        paramInt2 = i;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QQGameConfigUtil", 2, "decode bitmap error : " + paramString.getMessage());
      return null;
    }
  }
  
  public static String a()
  {
    String str2 = aomj.a().jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "pauseDownload from=" + paramInt + ",appId=" + paramString);
    }
    bkel.a();
    bkel.a().a(paramInt, paramString);
  }
  
  public static void a(Context paramContext, FeedsItemData.GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {}
    while (bdem.a(paramContext, paramGameInfo.gamePkgName)) {
      return;
    }
    bkel.a();
    paramContext = new WadlParams();
    paramContext.jdField_d_of_type_Int = 6;
    paramContext.b(7);
    paramContext.jdField_d_of_type_JavaLangString = "10000144";
    paramContext.jdField_b_of_type_JavaLangString = paramGameInfo.gameApkUrl;
    paramContext.jdField_a_of_type_JavaLangString = paramGameInfo.gameAppId;
    paramContext.f = Integer.parseInt(paramGameInfo.gameVersionCode);
    paramContext.j = paramGameInfo.gamePkgName;
    paramContext.q = "biz_src_zf_games";
    paramContext.m = "publicAccount";
    paramContext.k = paramGameInfo.gameName;
    paramContext.l = paramGameInfo.gameIcon;
    paramContext.jdField_b_of_type_Int = 2;
    paramContext.n = "publicAccount";
    bkel.a().a(paramContext);
  }
  
  public static void a(Bundle paramBundle, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "downloadGame appId=" + paramString + ",req=" + paramBundle);
    }
    String str = paramBundle.getString("pkgName");
    if ((paramBundle == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str))) {
      return;
    }
    Object localObject2 = paramBundle.getString("apkChannel");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "10000144";
    }
    bkel.a();
    localObject2 = new WadlParams();
    ((WadlParams)localObject2).jdField_d_of_type_Int = 0;
    ((WadlParams)localObject2).b(7);
    ((WadlParams)localObject2).jdField_d_of_type_JavaLangString = ((String)localObject1);
    ((WadlParams)localObject2).jdField_b_of_type_JavaLangString = paramBundle.getString("apkUrl");
    ((WadlParams)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((WadlParams)localObject2).f = paramBundle.getInt("versionCode");
    ((WadlParams)localObject2).j = str;
    paramString = paramBundle.getString("appName");
    paramBundle = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramBundle = ((WadlParams)localObject2).j;
    }
    ((WadlParams)localObject2).k = paramBundle;
    ((WadlParams)localObject2).q = "biz_src_zf_games";
    ((WadlParams)localObject2).m = "provider";
    ((WadlParams)localObject2).jdField_b_of_type_Int = 2;
    bkel.a().a((WadlParams)localObject2);
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
    bkel.a();
    bkel.a().b(paramWadlParams);
  }
  
  public static boolean a()
  {
    aomi localaomi = aomj.a();
    if ((localaomi != null) && (localaomi.jdField_a_of_type_Int > 0))
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
  
  public static int b()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 6;
  }
  
  public static String b()
  {
    String str2 = aomj.a().jdField_b_of_type_JavaLangString;
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
  
  public static void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "deleteDownload from=" + paramInt + ",appId=" + paramString);
    }
    bkel.a();
    bkel.a().c(paramInt, paramString);
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    Object localObject = aomj.a();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((aomi)localObject).c > 0)
      {
        localObject = ((aomi)localObject).jdField_a_of_type_JavaLangString;
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bool1 = bool2;
          if (bhos.a((String)localObject)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static String c()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjb
 * JD-Core Version:    0.7.0.1
 */