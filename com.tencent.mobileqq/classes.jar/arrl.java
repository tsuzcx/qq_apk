import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.MobileQQ;

public class arrl
{
  static SimpleDateFormat a = new SimpleDateFormat("mm:ss");
  
  public static int a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(52)).c(paramString2);
      if (paramString2 != null)
      {
        if (paramString2.isTroopOwner(paramString1)) {
          return 0;
        }
        boolean bool = paramString2.isTroopAdmin(paramString1);
        if (bool) {
          return 1;
        }
        return 2;
      }
    }
    catch (Throwable paramString1)
    {
      return -1;
    }
    return -1;
  }
  
  public static String a()
  {
    String str = ThemeUtil.getCurrentThemeId();
    if (("3064".equals(str)) || ("3063".equals(str)) || ("3066".equals(str)) || ("3065".equals(str)) || ("3067".equals(str))) {
      return str;
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 2)
    {
      if (paramInt3 == 3) {
        return ajyc.a(2131693821);
      }
      if (paramInt3 == 2) {
        return ajyc.a(2131693832);
      }
      if (paramInt3 == 1) {
        return ajyc.a(2131693851);
      }
      return ajyc.a(2131693843);
    }
    if (paramInt2 > 1) {
      return paramInt2 + ajyc.a(2131693841);
    }
    if (paramInt2 == 1) {
      return paramInt2 + ajyc.a(2131693865);
    }
    return ajyc.a(2131693843);
  }
  
  public static final String a(int paramInt, String paramString)
  {
    return paramInt + "_" + paramString;
  }
  
  public static String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    return a.format(Long.valueOf(l));
  }
  
  @Nullable
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    String str = "";
    if (("0".equals(paramString2)) || ("10000".equals(paramString2)) || (TextUtils.isEmpty(paramString2)))
    {
      paramQQAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogetherUtils", 2, "getNickName, uin=" + paramString1 + ",type=" + paramInt + ", creatorUin=" + paramString2);
      }
      return paramQQAppInterface;
    }
    if (paramInt == 2) {
      str = bbcl.a(paramQQAppInterface, paramString2);
    }
    for (;;)
    {
      paramQQAppInterface = str;
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      paramQQAppInterface = paramString2;
      break;
      if (paramInt == 1) {
        str = bbcl.h(paramQQAppInterface, paramString1, paramString2);
      }
    }
  }
  
  public static String a(MusicInfo paramMusicInfo)
  {
    Object localObject = "";
    if (paramMusicInfo == null) {}
    String str;
    int j;
    int i;
    do
    {
      return localObject;
      str = paramMusicInfo.b.trim();
      if (paramMusicInfo.a == null) {
        break;
      }
      j = 1;
      i = 0;
      localObject = str;
    } while (i >= paramMusicInfo.a.size());
    localObject = (String)paramMusicInfo.a.get(i);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      i += 1;
      break;
      if (j != 0)
      {
        str = str + "—" + ((String)localObject).trim();
        j = 0;
      }
      else
      {
        str = str + "/" + ((String)localObject).trim();
      }
    }
    return str;
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", bfng.a(bfng.a(bfng.a(bfng.a(QzoneConfig.getInstance().getConfig("H5Url", "YQHMusicPersonalPlayerUrl", "https://zb.vip.qq.com/v2/musicTheme"), "uin", paramString), "uinType", String.valueOf(paramInt)), "type", "2"), "_wv", "5123"));
    paramActivity.startActivity(localIntent);
    axqw.b(null, "dc00898", "", "", "qq_vip", "0X800A5C2", 1, 0, "", "", VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()), "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.c(), 0).edit().putBoolean("sp_key_listen_together_has_show_guide", true).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", bfng.a(bfng.a(bfng.a(bfng.a("https://web.qun.qq.com/qunmusic/listener", "uin", paramString), "uinType", String.valueOf(paramInt)), "_wwv", "128"), "_wv", "2"));
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramContext == null) || (paramQQAppInterface == null))
    {
      QLog.d("ListenTogetherUtils", 1, "gotoListenTogetherSettingPage return");
      return;
    }
    Object localObject;
    if (paramInt1 == 1)
    {
      localObject = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
      if (localObject == null) {
        break label130;
      }
    }
    label130:
    for (boolean bool = ((TroopInfo)localObject).isAdmin();; bool = false)
    {
      if (!bool)
      {
        localObject = ListenTogetherManager.a(paramQQAppInterface).a(paramInt1, paramString);
        if ((localObject == null) || (((ListenTogetherSession)localObject).g == 3))
        {
          bcpw.a(BaseApplication.getContext(), 2131693837, 0).a();
          return;
        }
        b(paramQQAppInterface, paramContext, paramInt1, paramString, paramInt2);
        return;
      }
      b(paramQQAppInterface, paramContext, paramInt1, paramString, paramInt2);
      return;
      if (paramInt1 != 2) {
        break;
      }
      b(paramQQAppInterface, paramContext, paramInt1, paramString, paramInt2);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (String str = paramQQAppInterface.c();; str = "qq_listen_together_pref")
    {
      paramQQAppInterface.getApplication().getSharedPreferences(str, 0).edit().putBoolean(paramString, paramBoolean1).apply();
      return;
    }
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_YQHPersnoalPlayerEnbled", 1) != 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.c(), 0).getBoolean("sp_key_listen_together_has_show_guide", false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (String str = paramQQAppInterface.c();; str = "qq_listen_together_pref") {
      return paramQQAppInterface.getApplication().getSharedPreferences(str, 0).getBoolean(paramString, paramBoolean1);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (ayna.a(paramQQAppInterface).a(paramContext, 1, paramString, paramInt2)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    String str2 = bfng.a("https://web.qun.qq.com/qunmusic/index", "uin", paramString);
    ListenTogetherManager localListenTogetherManager = (ListenTogetherManager)paramQQAppInterface.getManager(331);
    localListenTogetherManager.d();
    boolean bool = localListenTogetherManager.c(paramInt1, paramString);
    String str3 = a();
    String str1 = str2;
    if (!TextUtils.isEmpty(str3)) {
      str1 = bfng.a(str2, "themeId", str3);
    }
    str2 = bfng.a(str1, "uinType", String.valueOf(paramInt1));
    if (bool)
    {
      str1 = "1";
      str2 = bfng.a(bfng.a(bfng.a(str2, "showlrc", str1), "_wv", "2"), "_wwv", "128");
      if (!localListenTogetherManager.b(paramInt1, paramString)) {
        break label260;
      }
      str1 = "1";
      label160:
      str2 = bfng.a(bfng.a(str2, "isJoin", str1), "from", String.valueOf(paramInt2));
      if (!a(paramQQAppInterface, "is_not_first_join_listen_together_" + paramInt1, false, false)) {
        break label267;
      }
    }
    label260:
    label267:
    for (str1 = "1";; str1 = "0")
    {
      localIntent.putExtra("url", bfng.a(str2, "isNew", str1));
      paramContext.startActivity(localIntent);
      ListenTogetherManager.a(paramQQAppInterface).a(paramContext, paramInt1, paramString);
      return;
      str1 = "0";
      break;
      str1 = "0";
      break label160;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrl
 * JD-Core Version:    0.7.0.1
 */