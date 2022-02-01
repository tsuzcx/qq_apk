import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class awfq
{
  static SimpleDateFormat a = new SimpleDateFormat("mm:ss");
  
  public static int a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString2);
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
        return anvx.a(2131693534);
      }
      if (paramInt3 == 2) {
        return anvx.a(2131693545);
      }
      if (paramInt3 == 1) {
        return anvx.a(2131693561);
      }
      return anvx.a(2131693555);
    }
    if (paramInt2 > 1) {
      return paramInt2 + anvx.a(2131693553);
    }
    if (paramInt2 == 1) {
      return paramInt2 + anvx.a(2131693571);
    }
    return anvx.a(2131693555);
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
        QLog.d("ListenTogetherUtils", 2, "getNickName, uin=" + paramString1 + ",sessionType=" + paramInt + ", frdUin=" + paramString2);
      }
      return paramQQAppInterface;
    }
    if (paramInt == 2) {
      str = ContactUtils.getFriendNick(paramQQAppInterface, paramString2);
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
        str = ContactUtils.getTroopMemberName(paramQQAppInterface, paramString1, paramString2);
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
    localIntent.putExtra("url", bkyp.a(bkyp.a(bkyp.a(bkyp.a(QzoneConfig.getInstance().getConfig("H5Url", "YQHMusicPersonalPlayerUrl", "https://zb.vip.qq.com/v2/musicTheme"), "uin", paramString), "uinType", String.valueOf(paramInt)), "type", "2"), "_wv", "5123"));
    paramActivity.startActivity(localIntent);
    bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A5C2", 1, 0, "", "", VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()), "");
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    if (paramInt == 1)
    {
      paramInt = 1;
      if (paramInt != 1) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      a(bool, "clk_join_bar", paramString);
      a(paramContext, paramInt, paramString, 2, true, null);
      return;
      paramInt = 2;
      break;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a((QQAppInterface)localObject);
    boolean bool1 = localListenTogetherManager.b(paramInt1, paramString1);
    boolean bool2 = localListenTogetherManager.a(paramInt1, paramString1);
    QLog.d("ListenTogetherUtils", 1, new Object[] { "onJoinClick sessionType=", Integer.valueOf(paramInt1), ",uin=", MobileQQ.getShortUinStr(paramString1), ",joinFrom=", Integer.valueOf(paramInt2), ",reopenIfNeed=", Boolean.valueOf(paramBoolean), ",songId=", paramString2, ",meJoined=", Boolean.valueOf(bool1), ",isOpened=", Boolean.valueOf(bool2) });
    if ((bool1) || (bool2)) {
      ListenTogetherManager.a((QQAppInterface)localObject).a((BaseActivity)paramContext, paramInt1, paramString1);
    }
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      localObject = bhdj.a(paramContext, 230);
      paramString2 = new awfr(paramInt1, paramString1, paramString2, paramInt2);
      ((QQCustomDialog)localObject).setTitle(2131693547);
      ((QQCustomDialog)localObject).setTitleMutiLine();
      ((QQCustomDialog)localObject).setMessage(null);
      ((QQCustomDialog)localObject).setNegativeButton(anvx.a(2131705661), paramString2);
      ((QQCustomDialog)localObject).setPositiveButton(anvx.a(2131693535), paramString2);
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
    } while (((BaseActivity)paramContext).isFinishing());
    ((QQCustomDialog)localObject).show();
    if (paramInt2 == 1)
    {
      paramContext = "exp_openframe";
      if (paramInt1 != 1) {
        break label301;
      }
    }
    label301:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean, paramContext, paramString1);
      return;
      paramContext = "exp_joinbar";
      break;
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, int paramInt, String paramString)
  {
    boolean bool1 = true;
    if ((paramBaseChatPie.getActivity() == null) || (paramBaseChatPie.getActivity().getIntent() == null)) {}
    QQCustomDialog localQQCustomDialog;
    do
    {
      boolean bool2;
      do
      {
        do
        {
          return;
        } while (!paramBaseChatPie.getActivity().getIntent().getBooleanExtra("key_from_listen_together_notify_msg", false));
        ListenTogetherManager.a(paramBaseChatPie.app);
        if (paramInt != 1) {
          break;
        }
        paramInt = 1;
        bool2 = b(paramBaseChatPie, paramInt, paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherUtils", 2, String.format("checkEnterAioByListenTogetherNotifyMsg sessionType=%d uin=%s isOpen=%b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool2) }));
        }
      } while (!bool2);
      localQQCustomDialog = bhdj.a(paramBaseChatPie.getActivity(), 230);
      awfs localawfs = new awfs(paramBaseChatPie, paramInt, paramString);
      localQQCustomDialog.setTitle(2131693546);
      localQQCustomDialog.setMessage(null);
      localQQCustomDialog.setNegativeButton(anvx.a(2131705661), localawfs);
      localQQCustomDialog.setPositiveButton(anvx.a(2131706501), localawfs);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
    } while (paramBaseChatPie.getActivity().isFinishing());
    localQQCustomDialog.show();
    if (paramInt == 1) {}
    for (;;)
    {
      a(bool1, "exp_joinframe", paramString);
      return;
      paramInt = 2;
      break;
      bool1 = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentUin(), 0).edit().putBoolean("sp_key_listen_together_has_show_guide", true).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", bkyp.a(bkyp.a(bkyp.a(bkyp.a("https://web.qun.qq.com/qunmusic/listener", "uin", paramString), "uinType", String.valueOf(paramInt)), "_wwv", "128"), "_wv", "2"));
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
      localObject = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
      if (localObject == null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = ((TroopInfo)localObject).isAdmin();; bool = false)
    {
      if (!bool)
      {
        localObject = ListenTogetherManager.a(paramQQAppInterface).a(paramInt1, paramString);
        if ((localObject == null) || (((ListenTogetherSession)localObject).h == 3))
        {
          QQToast.a(BaseApplication.getContext(), 2131693550, 0).a();
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
    for (String str = paramQQAppInterface.getCurrentUin();; str = "qq_listen_together_pref")
    {
      paramQQAppInterface.getApplication().getSharedPreferences(str, 0).edit().putBoolean(paramString, paramBoolean1).apply();
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    String str;
    if (paramBoolean)
    {
      str = "Grp_AIO";
      if (!paramBoolean) {
        break label43;
      }
    }
    for (;;)
    {
      bdla.b(null, "dc00899", str, "", "music_tab", paramString1, 0, 0, paramString2, "0", "", "");
      return;
      str = "c2c_AIO";
      break;
      label43:
      paramString2 = "0";
    }
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_YQHPersnoalPlayerEnbled", 1) != 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentUin(), 0).getBoolean("sp_key_listen_together_has_show_guide", false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramQQAppInterface == null) || (paramMessage == null) || (paramMessage.msgtype != -5008)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.getMsgItemByUniseq(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if (!(paramQQAppInterface instanceof MessageForArkApp)) {}
      }
      for (paramQQAppInterface = (MessageForArkApp)paramQQAppInterface; (paramQQAppInterface != null) && (paramQQAppInterface.ark_app_message != null) && ("com.tencent.together".equals(paramQQAppInterface.ark_app_message.appName)) && ("invite".equals(paramQQAppInterface.ark_app_message.appView)); paramQQAppInterface = null) {
        for (;;)
        {
          try
          {
            paramQQAppInterface = new JSONObject(paramQQAppInterface.ark_app_message.metaList);
            if (!paramQQAppInterface.has("invite")) {
              continue;
            }
            paramQQAppInterface = paramQQAppInterface.getJSONObject("invite");
            if (paramQQAppInterface == null) {
              continue;
            }
            paramQQAppInterface = paramQQAppInterface.optString("type", "");
            bool = paramQQAppInterface.equals("listen");
          }
          catch (Throwable paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("ListenTogetherUtils", 1, "handleListenTogetherIntentFromArkMsg", paramQQAppInterface);
            boolean bool = false;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherUtils", 2, String.format("checkIsTogetherOpenArkMsg uinType=%d uin=%s isListenTogether=%b", new Object[] { Integer.valueOf(paramMessage.istroop), MobileQQ.getShortUinStr(paramMessage.frienduin), Boolean.valueOf(bool) }));
          }
          return bool;
          paramQQAppInterface = null;
          continue;
          paramQQAppInterface = "";
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, Intent paramIntent)
  {
    boolean bool1;
    if ((paramQQAppInterface == null) || (paramMessage == null) || (paramMessage.msgtype != -5008)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = a(paramQQAppInterface, paramMessage);
      bool1 = bool2;
    } while (!bool2);
    paramIntent.putExtra("key_from_listen_together_notify_msg", bool2);
    return bool2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (String str = paramQQAppInterface.getCurrentUin();; str = "qq_listen_together_pref") {
      return paramQQAppInterface.getApplication().getSharedPreferences(str, 0).getBoolean(paramString, paramBoolean1);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (bejv.a(paramQQAppInterface).a(paramContext, 1, paramString, paramInt2)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    String str2 = bkyp.a("https://web.qun.qq.com/qunmusic/index", "uin", paramString);
    ListenTogetherManager localListenTogetherManager = (ListenTogetherManager)paramQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
    localListenTogetherManager.d();
    boolean bool = localListenTogetherManager.c(paramInt1, paramString);
    String str3 = a();
    String str1 = str2;
    if (!TextUtils.isEmpty(str3)) {
      str1 = bkyp.a(str2, "themeId", str3);
    }
    str2 = bkyp.a(str1, "uinType", String.valueOf(paramInt1));
    if (bool)
    {
      str1 = "1";
      str2 = bkyp.a(bkyp.a(bkyp.a(str2, "showlrc", str1), "_wv", "2"), "_wwv", "128");
      if (!localListenTogetherManager.b(paramInt1, paramString)) {
        break label260;
      }
      str1 = "1";
      label160:
      str2 = bkyp.a(bkyp.a(str2, "isJoin", str1), "from", String.valueOf(paramInt2));
      if (!a(paramQQAppInterface, "is_not_first_join_listen_together_" + paramInt1, false, false)) {
        break label267;
      }
    }
    label260:
    label267:
    for (str1 = "1";; str1 = "0")
    {
      localIntent.putExtra("url", bkyp.a(str2, "isNew", str1));
      paramContext.startActivity(localIntent);
      ListenTogetherManager.a(paramQQAppInterface).a(paramContext, paramInt1, paramString);
      return;
      str1 = "0";
      break;
      str1 = "0";
      break label160;
    }
  }
  
  private static boolean b(BaseChatPie paramBaseChatPie, int paramInt, String paramString)
  {
    boolean bool = ListenTogetherManager.a(paramBaseChatPie.getApp()).a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherUtils", 2, String.format("checkEnterAioByListenTogetherNotifyMsg sessionType=%d uin=%s isOpen=%b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool) }));
    }
    if (!bool) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131693550, 1).b(paramBaseChatPie.getTitleBarHeight());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfq
 * JD-Core Version:    0.7.0.1
 */