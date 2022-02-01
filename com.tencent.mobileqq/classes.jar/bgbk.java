import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil.2;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import tencent.im.oidb.cmd0xece.oidb_0xece.ActiveAppTips;
import tencent.im.oidb.cmd0xece.oidb_0xece.App;
import tencent.im.oidb.cmd0xece.oidb_0xece.RspBody;

public class bgbk
{
  public static bgbm a(oidb_0xece.RspBody paramRspBody)
  {
    if ((paramRspBody == null) || (!paramRspBody.active_app_tips.has()) || (!((oidb_0xece.ActiveAppTips)paramRspBody.active_app_tips.get()).apps.has())) {
      return null;
    }
    paramRspBody = ((oidb_0xece.ActiveAppTips)paramRspBody.active_app_tips.get()).apps.get();
    if ((paramRspBody != null) && (paramRspBody.size() > 0))
    {
      paramRspBody = (oidb_0xece.App)paramRspBody.get(0);
      bgbm localbgbm = new bgbm();
      localbgbm.jdField_a_of_type_Long = paramRspBody.appid.get();
      localbgbm.jdField_a_of_type_JavaLangString = paramRspBody.app_name.get();
      localbgbm.jdField_b_of_type_Long = paramRspBody.source.get();
      localbgbm.jdField_b_of_type_JavaLangString = paramRspBody.url.get();
      return localbgbm;
    }
    return null;
  }
  
  private static BaseChatPie a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((BaseActivity.sTopActivity instanceof FragmentActivity)))
    {
      Object localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject != null) && ((localObject instanceof afzn)) && (((BaseChatPie)localObject).getCurrentAIOState() >= 2))
        {
          String str = ((BaseChatPie)localObject).getCurFriendUin();
          if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    bgbm localbgbm;
    do
    {
      do
      {
        return;
        localbgbm = new bgbm();
      } while (!localbgbm.a(paramString2));
      paramString2 = a(paramString1);
      if (paramString2 != null)
      {
        bgil.a(paramQQAppInterface, paramString2.mContext, paramString2.mActivity, paramString2.sessionInfo, localbgbm.jdField_a_of_type_Long, localbgbm.jdField_b_of_type_JavaLangString, 0, 0);
        return;
      }
    } while ((paramContext == null) || (!(paramContext instanceof BaseActivity)));
    paramString2 = new SessionInfo();
    paramString2.curFriendUin = paramString1;
    paramString2.curType = 1;
    bgil.a(paramQQAppInterface, paramContext, (BaseActivity)paramContext, paramString2, localbgbm.jdField_a_of_type_Long, localbgbm.jdField_b_of_type_JavaLangString, 0, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    bdla.b(null, "dc00898", "", paramString, "0X800B447", "0X800B447", 0, 0, String.valueOf(b(paramQQAppInterface, paramString)), "", "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.excute(new TroopShortcutBarUtil.2(paramQQAppInterface, paramString, paramLong), 32, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, bgbm parambgbm)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (parambgbm == null) || (TextUtils.isEmpty(parambgbm.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambgbm.jdField_b_of_type_JavaLangString))) {
      return;
    }
    bgbg localbgbg = (bgbg)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
    long l = localbgbg.a(paramString);
    if (l != 0L) {
      a(paramQQAppInterface, paramString, l);
    }
    String str1 = BaseApplicationImpl.getContext().getResources().getString(2131719723);
    String str2 = BaseApplicationImpl.getContext().getResources().getString(2131719724);
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131719726);
    String str3 = BaseApplicationImpl.getContext().getResources().getString(2131719725);
    String str4 = str1 + parambgbm.jdField_a_of_type_JavaLangString + str2 + (String)localObject + str3;
    localObject = new avhz(paramString, paramString, str4, 1, -5040, 131091, bcrg.a());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 62);
    localBundle.putString("textColor", "#40A0FF");
    localBundle.putString("key_action_DATA", parambgbm.a());
    ((avhz)localObject).a(str1.length(), str1.length() + parambgbm.jdField_a_of_type_JavaLangString.length(), localBundle);
    localBundle = new Bundle();
    localBundle.putInt("key_action", 63);
    localBundle.putString("textColor", "#40A0FF");
    localBundle.putString("key_action_DATA", parambgbm.a());
    ((avhz)localObject).a(str1.length() + parambgbm.jdField_a_of_type_JavaLangString.length() + str2.length(), str4.length() - str3.length(), localBundle);
    parambgbm = new MessageForUniteGrayTip();
    parambgbm.createMessageUniseq();
    parambgbm.initGrayTipMsg(paramQQAppInterface, (avhz)localObject);
    avia.a(paramQQAppInterface, parambgbm);
    localbgbg.b(paramString, parambgbm.uniseq);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    boolean bool1;
    bgbm localbgbm;
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (TroopInfo.isTroopMember(paramQQAppInterface, paramString1)) {
              break;
            }
          } while (BaseActivity.sTopActivity == null);
          QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131719717), 0).a();
          return;
          if ((TroopUtils.isTroopAdmin(paramQQAppInterface, paramString1, paramQQAppInterface.getCurrentUin())) || (TroopUtils.isTroopOwner(paramQQAppInterface, paramString1, paramQQAppInterface.getCurrentUin()))) {
            break;
          }
        } while (BaseActivity.sTopActivity == null);
        QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131719727), 0).a();
        return;
        bool1 = a(paramQQAppInterface, paramString1);
        localbgbm = new bgbm();
      } while (!localbgbm.a(paramString2));
      l = localbgbm.jdField_a_of_type_Long;
      boolean bool2 = a(paramQQAppInterface, paramString1, l);
      if ((!bool1) || (!bool2)) {
        break;
      }
    } while (BaseActivity.sTopActivity == null);
    QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131719718), 0).a();
    return;
    new bget(new bgbl(bool1, paramString1, paramQQAppInterface, l), paramString1, localbgbm.jdField_a_of_type_Long, localbgbm.jdField_b_of_type_Long, true, null).a(paramQQAppInterface);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      try
      {
        long l = Long.parseLong(paramString);
        paramQQAppInterface = ((bgbg)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(l));
        if (paramQQAppInterface == null) {
          continue;
        }
        if (paramQQAppInterface.b() == 0) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
        return false;
      }
      catch (Exception paramQQAppInterface) {}
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      try
      {
        long l = Long.parseLong(paramString);
        paramQQAppInterface = ((bgbg)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(l));
        if (paramQQAppInterface == null) {
          continue;
        }
        if (paramQQAppInterface.a(paramLong) != null) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
        return false;
      }
      catch (Exception paramQQAppInterface) {}
    }
  }
  
  private static long b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.dwGroupClassExt;
      }
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbk
 * JD-Core Version:    0.7.0.1
 */