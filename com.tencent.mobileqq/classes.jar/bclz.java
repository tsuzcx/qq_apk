import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bclz
{
  private static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    String str;
    if (paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))
    {
      str = "0";
      paramString2 = paramString2.replace("$GCODE$", paramString1).replace("$CLIENTVER$", "android8.3.5").replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
      if (!paramBoolean) {
        break label143;
      }
    }
    label143:
    for (paramQQAppInterface = "1";; paramQQAppInterface = "2")
    {
      paramString1 = paramString2.replace("$ENTERSOURCE$", paramQQAppInterface).replace("$GUIN$", paramString1).replace("$UNREADNUM$", String.valueOf(0));
      paramQQAppInterface = paramString1;
      if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
        paramQQAppInterface = paramString1.replace("$GNAME$", paramTroopInfo.newTroopName);
      }
      return paramQQAppInterface;
      if (paramTroopInfo.isAdmin())
      {
        str = "1";
        break;
      }
      str = "2";
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, bbhh parambbhh)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.a);
    if (localTroopInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutUtils", 2, "OnClickListener. troopInfo is null.");
      }
    }
    String str1;
    label306:
    label314:
    label376:
    label383:
    do
    {
      return;
      azqs.b(null, "dc00898", "", "", "0X800AD09", "0X800AD09", 0, 0, "", paramSessionInfo.a, Long.toString(localTroopInfo.dwGroupClassExt), Long.toString(parambbhh.a));
      str1 = parambbhh.c;
      if (parambbhh.a == 101761547L)
      {
        atmr.b(paramQQAppInterface, paramContext, 1, paramSessionInfo.a, 0);
        return;
      }
      if (parambbhh.a == 101793773L)
      {
        a(paramQQAppInterface, paramContext, localTroopInfo, paramSessionInfo);
        return;
      }
      if (parambbhh.a == 101817424L)
      {
        b(paramQQAppInterface, paramContext, localTroopInfo, paramSessionInfo);
        return;
      }
      if (parambbhh.a == 101847770L)
      {
        paramQQAppInterface = TroopMemberListActivity.a(paramContext, paramSessionInfo.a, 19);
        paramQQAppInterface.putExtra("TROOP_INFO_MEMBER_NUM", localTroopInfo.wMemberNum);
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
      boolean bool;
      int i;
      if ((parambbhh.a == 1101236949L) && (aouu.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))))
      {
        bool = amel.c(localTroopInfo.groupFreezeReason);
        if (!localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          break label396;
        }
        String str2 = paramSessionInfo.a;
        if (!bool) {
          break label376;
        }
        i = 15;
        String str3 = VipUtils.a(0, i).toString();
        String str4 = alud.a(2131702125);
        bcma localbcma = new bcma();
        if (!bool) {
          break label383;
        }
        localObject = "0X800A57F";
        if (!bool) {
          break label390;
        }
        i = 1;
        VipUtils.a(paramContext, str2, str3, str4, localbcma, (String)localObject, i, bool);
      }
      for (;;)
      {
        if (!MiniAppLauncher.isMiniAppUrl(str1)) {
          break label405;
        }
        MiniAppLauncher.startMiniApp(paramContext, a(paramQQAppInterface, paramSessionInfo.a, str1, parambbhh.a, localTroopInfo, true), 2010, bcpx.a(localTroopInfo, paramSessionInfo.a), null);
        return;
        i = 8;
        break;
        localObject = "0X8009E38";
        break label306;
        i = 3;
        break label314;
        VipUtils.a(paramContext, bool);
      }
      if ((str1.startsWith("http")) || (str1.startsWith("https")))
      {
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", a(paramQQAppInterface, paramSessionInfo.a, str1, parambbhh.a, localTroopInfo, true));
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        paramContext.startActivity((Intent)localObject);
        return;
      }
    } while (!str1.startsWith("mqqapi"));
    label390:
    label396:
    label405:
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo.a, str1, parambbhh.a, localTroopInfo, true);
    Object localObject = new Intent(paramContext, JumpActivity.class);
    paramQQAppInterface = paramSessionInfo;
    if (parambbhh.a == 1105981808L) {
      paramQQAppInterface = xpq.a((Intent)localObject, paramSessionInfo, null);
    }
    ((Intent)localObject).setData(Uri.parse(paramQQAppInterface));
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, SessionInfo paramSessionInfo)
  {
    aorx localaorx = (aorx)aoks.a().a(535);
    if ((localaorx == null) || (localaorx.a == null)) {
      QQToast.a(paramContext, 0, 2131693338, 0).a();
    }
    baph localbaph;
    boolean bool;
    do
    {
      return;
      localbaph = (baph)paramQQAppInterface.getManager(339);
      bool = localbaph.a(2, 1, paramTroopInfo.uin);
      paramSessionInfo = bapu.a(bool, paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramSessionInfo.a, 0);
      switch (localaorx.a.a())
      {
      default: 
        if (!localbaph.a(paramContext, 2, paramTroopInfo.troopuin, 0)) {
          break label231;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAppShortcutUtils", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
    return;
    QQToast.a(paramContext, 0, 2131693338, 0).a();
    return;
    if (bool)
    {
      localbaph.b(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
      return;
    }
    localbaph.a(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
    return;
    label231:
    bapu.a(paramQQAppInterface, localaorx.a.b(), localaorx.a.a(), localaorx.a.b(), paramSessionInfo, 1);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, SessionInfo paramSessionInfo)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = (baph)paramQQAppInterface.getManager(339);
    boolean bool = paramQQAppInterface.a(4, -1, paramSessionInfo.a);
    paramTroopInfo = bapu.a(bool, paramTroopInfo.isTroopOwner(str), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramSessionInfo.a, 0);
    if (bool)
    {
      paramQQAppInterface.b(paramContext, paramSessionInfo.a, 1, 4, 0, paramTroopInfo);
      return;
    }
    paramQQAppInterface.a(paramContext, paramSessionInfo.a, 1, 4, 0, paramTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclz
 * JD-Core Version:    0.7.0.1
 */