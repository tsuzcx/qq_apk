import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.LimitChatUtil.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class asli
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    paramQQAppInterface = b(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("sp_match_chat_gray_section_" + paramString, 0);
    }
    return i;
  }
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("LimitChatUtil", 2, "get sp by app is null");
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.c();
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      QLog.e("LimitChatUtil", 2, "get sp by uin is null");
      return null;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("sp_for_extendfriend_limit_chat" + paramQQAppInterface, 0);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = paramQQAppInterface.getString("sp_limit_chat_on_plus_panel_name", "");
      paramQQAppInterface = str;
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, "getLimitChatOnPlusName: " + str);
    return str;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "0";
    SharedPreferences localSharedPreferences = b(paramQQAppInterface);
    paramQQAppInterface = str;
    if (localSharedPreferences != null) {
      paramQQAppInterface = localSharedPreferences.getString("sp_match_chat_algorithm_id" + paramString, "0");
    }
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      QLog.e("LimitChatUtil", 2, "ExtendFriendLimitChat checkAndUpdateLimiteChatSetting app null");
    }
    while (!b(paramQQAppInterface)) {
      return;
    }
    paramQQAppInterface = (asfs)paramQQAppInterface.a(127);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(true);
      return;
    }
    QLog.e("LimitChatUtil", 2, "ExtendFriendLimitChat handler null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = b(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putInt("sp_match_chat_gray_section_" + paramString, paramInt).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = b(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putString("sp_match_chat_algorithm_id" + paramString1, paramString2).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    if (paramQQAppInterface == null) {
      QLog.e("LimitChatUtil", 2, "ExtendFriendLimitChat getLimitChatOnPlusExpireTime: app is null ");
    }
    long l;
    do
    {
      return;
      SharedPreferences localSharedPreferences = a(paramQQAppInterface);
      if (localSharedPreferences == null) {
        break;
      }
      paramQQAppInterface = paramString;
      if (paramString == null) {
        paramQQAppInterface = "";
      }
      localSharedPreferences.edit().putBoolean("sp_limit_chat_on_plus_panel_be_show", paramBoolean).apply();
      localSharedPreferences.edit().putLong("sp_limit_chat_on_plus_panel_chat_time", paramLong1).apply();
      localSharedPreferences.edit().putInt("sp_limit_chat_on_plus_panel_left_count", paramInt).apply();
      localSharedPreferences.edit().putString("sp_limit_chat_on_plus_panel_name", paramQQAppInterface).apply();
      localSharedPreferences.edit().putLong("sp_limit_chat_on_plus_panel_expire_time", paramLong2).apply();
      l = NetConnInfoCenter.getServerTime();
      localSharedPreferences.edit().putLong("sp_limit_chat_on_plus_panel_update_time", l).apply();
    } while (!QLog.isColorLevel());
    QLog.i("LimitChatUtil", 2, "ExtendFriendLimitChat setShowLimitChatOnPlus  bShow: " + paramBoolean + " chatTime:" + paramLong1 + " leftCount:" + paramInt + " funcName: " + paramQQAppInterface + " expireTime : " + paramLong2 + " nowTime: " + l);
    return;
    QLog.e("LimitChatUtil", 2, "ExtendFriendLimitChat setShowLimitChatOnPlus on null sp");
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("LimitChatUtil", 2, "reportInSubThread UIN EMPTY");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LimitChatUtil.1(paramString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.getBoolean("sp_limit_chat_on_plus_panel_be_show", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, "needShowLimitChatOnPlus: " + bool2);
    return bool2;
  }
  
  public static SharedPreferences b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("LimitChatUtil", 2, "get sp by app is null");
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.c();
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      QLog.e("LimitChatUtil", 2, "get matchSp is null");
      return null;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("sp_for_extendfriend_match_chat" + paramQQAppInterface, 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = b(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().clear().commit();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
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
      if (anpe.c())
      {
        QLog.i("LimitChatUtil", 2, "getLimitChatOnPlusExpireTime: by change local langauage");
        return true;
      }
      QLog.d("LimitChatUtil", 2, "getLimitChatOnPlusExpireTime: not ! by change local langauage");
      l1 = paramQQAppInterface.getLong("sp_limit_chat_on_plus_panel_expire_time", 10L);
      l2 = paramQQAppInterface.getLong("sp_limit_chat_on_plus_panel_update_time", 0L);
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
    QLog.d("LimitChatUtil", 2, "getLimitChatOnPlusExpireTime: " + l1 + " update :" + l2 + " now：" + l3 + " needUpdate：" + bool1);
    return bool1;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    aslk localaslk = aslc.a();
    return (localaslk != null) && (localaslk.a()) && (a(paramQQAppInterface)) && (!localaslk.b()) && (!bdch.a());
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    aslk localaslk = aslc.a();
    return (localaslk != null) && (localaslk.a()) && (a(paramQQAppInterface)) && (localaslk.b()) && (!bdch.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asli
 * JD-Core Version:    0.7.0.1
 */