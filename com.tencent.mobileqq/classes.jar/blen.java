import MQQ.QqLiveMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class blen
{
  public static int a(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      str = str + "_" + a();
      paramInt = localSharedPreferences.getInt(str, 0);
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "get sp key:" + str + " value = " + paramInt);
      }
      return paramInt;
      str = "is_show_anchor_entrance";
      continue;
      str = "is_show_shop";
    }
  }
  
  public static blei a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).getString(str, "");
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "getIliveConfigBean get sp key:" + str + " json value = " + (String)localObject);
      }
      return blei.a((String)localObject);
      str = "ilive_plugin_new_data";
      continue;
      str = "ilive_plugin_last_use";
    }
  }
  
  private static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("IliveFileDbManager", 4, "getCurrentUin = " + localAppRuntime.getAccount());
      }
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).getString(str, "");
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "get sp key:" + str + " value = " + (String)localObject);
      }
      return localObject;
      str = "key_shop_title";
      continue;
      str = "key_shop_pic_url";
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    paramString = paramString + "_" + a();
    localObject = ((SharedPreferences)localObject).getString(paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("IliveFileDbManager", 1, "getIliveDrawerData sp key:" + paramString + " value = " + (String)localObject);
    }
    return localObject;
  }
  
  public static void a(int paramInt, QqLiveMsg paramQqLiveMsg)
  {
    QLog.i("IliveFileDbManager", 1, "saveIliveData isQQLivePgc = " + paramInt + " qqLiveMsg = " + paramQqLiveMsg);
    a(1, paramInt);
    if ((paramQqLiveMsg != null) || ((paramQqLiveMsg != null) && (!TextUtils.isEmpty(paramQqLiveMsg.anchorUrl)) && (!TextUtils.isEmpty(paramQqLiveMsg.viewerUrl))))
    {
      a(2, paramQqLiveMsg.isShopEntrance);
      a(paramQqLiveMsg);
      bleo.a().a(paramQqLiveMsg.isPreload);
    }
    if (paramQqLiveMsg != null)
    {
      a("drawer_plus_text", paramQqLiveMsg.plus_text);
      a("drawer_shop_jump_scheme", paramQqLiveMsg.recomm_room_schema);
      a(paramQqLiveMsg);
    }
  }
  
  private static void a(QqLiveMsg paramQqLiveMsg)
  {
    if (paramQqLiveMsg == null) {
      return;
    }
    blei localblei = new blei();
    localblei.jdField_a_of_type_Boolean = bleu.c();
    localblei.c = paramQqLiveMsg.anchorUrl;
    localblei.d = paramQqLiveMsg.anchorUrlMd5;
    localblei.jdField_a_of_type_JavaLangString = paramQqLiveMsg.viewerUrl;
    localblei.b = paramQqLiveMsg.viewerUrlMd5;
    QLog.e("IliveFileDbManager", 1, "saveIlivePluginConfig anchorMd5 = " + localblei.d + " mWatchPluginMd5 = " + localblei.b);
    a(1, localblei);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      str = str + "_" + a();
      boolean bool = localSharedPreferences.edit().putInt(str, paramInt2).commit();
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "set sp key:" + str + " value = " + paramInt2);
      }
      return bool;
      str = "is_show_anchor_entrance";
      continue;
      str = "is_show_shop";
    }
  }
  
  public static boolean a(int paramInt, blei paramblei)
  {
    if (paramblei == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramblei = blei.a(paramblei);
      boolean bool = localSharedPreferences.edit().putString(str, paramblei).commit();
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "saveIliveConfigBean set sp key:" + str + " json value = " + paramblei);
      }
      return bool;
      str = "ilive_plugin_new_data";
      continue;
      str = "ilive_plugin_last_use";
    }
  }
  
  private static boolean a(QqLiveMsg paramQqLiveMsg)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4).edit();
    if (TextUtils.isEmpty(paramQqLiveMsg.ShopText))
    {
      str = "";
      localEditor.putString("key_shop_title", str);
      if (!TextUtils.isEmpty(paramQqLiveMsg.ShopPicUrl)) {
        break label124;
      }
    }
    label124:
    for (String str = "";; str = paramQqLiveMsg.ShopPicUrl)
    {
      localEditor.putString("key_shop_pic_url", str);
      boolean bool = localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "set sp key:shop_drawer_enter value = " + paramQqLiveMsg.ShopText + "  " + paramQqLiveMsg.ShopPicUrl);
      }
      return bool;
      str = paramQqLiveMsg.ShopText;
      break;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    paramString1 = paramString1 + "_" + a();
    boolean bool = localSharedPreferences.edit().putString(paramString1, paramString2).commit();
    if (QLog.isColorLevel()) {
      QLog.d("IliveFileDbManager", 1, "saveIliveDrawerData sp key:" + paramString1 + " value = " + paramString2);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blen
 * JD-Core Version:    0.7.0.1
 */