import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bgil
{
  public static Drawable a(Context paramContext, String paramString, float paramFloat1, float paramFloat2)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    int i = ViewUtils.dpToPx(paramFloat1);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130843782);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130843782);
    label119:
    do
    {
      try
      {
        paramContext = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        if (paramFloat2 > 0.0F) {}
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          paramContext.setTag(bgxc.b(i, i, ViewUtils.dpToPx(paramFloat2)));
          paramContext.setDecodeHandler(bgxc.j);
          localObject = paramContext;
          if (paramContext.getStatus() == 2)
          {
            paramContext.restartDownload();
            localObject = paramContext;
          }
          return localObject;
        }
        catch (Exception localException2)
        {
          Context localContext;
          break label119;
        }
        localException1 = localException1;
        paramContext = null;
      }
      localContext = paramContext;
    } while (!QLog.isColorLevel());
    QLog.e("TroopAppShortcutUtils", 2, "getIcon url: " + paramString);
    return paramContext;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, TroopInfo paramTroopInfo, boolean paramBoolean, int paramInt)
  {
    String str;
    if (paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))
    {
      str = "0";
      paramString2 = paramString2.replace("$GCODE$", paramString1).replace("$CLIENTVER$", "android8.4.10").replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (paramQQAppInterface = "1";; paramQQAppInterface = "2")
    {
      paramString1 = paramString2.replace("$ENTERSOURCE$", paramQQAppInterface).replace("$GUIN$", paramString1).replace("$UNREADNUM$", String.valueOf(paramInt));
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
  
  public static void a(int paramInt, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity)
  {
    long l2;
    Object localObject;
    long l1;
    int i;
    if (a(paramQQAppInterface, paramLong))
    {
      l2 = 0L;
      localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      l1 = l2;
      if (localObject == null) {
        break label275;
      }
      localObject = ((TroopManager)localObject).b(String.valueOf(paramLong));
      l1 = l2;
      if (localObject == null) {
        break label275;
      }
      l2 = ((TroopInfo)localObject).dwGroupClassExt;
      if (!((TroopInfo)localObject).isTroopOwner(paramQQAppInterface.getCurrentUin())) {
        break label207;
      }
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("url", "https://qun.qq.com/slidepanel/manage?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$&gfrom=$GFROM".replace("$GCODE$", Long.toString(paramLong)).replace("$GID$", Integer.toString(i)).replace("$GTYPE$", Long.toString(l1)).replace("$GFROM", Integer.toString(paramInt)));
      paramQQAppInterface.putExtra("webStyle", "noBottomBar");
      paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramBaseActivity.startActivityForResult(paramQQAppInterface, 20006);
      if (paramInt == 1) {
        bdla.b(null, "dc00898", "", Long.toString(paramLong), "0X800AD0B", "0X800AD0B", 0, 0, String.valueOf(l1), "", "", "");
      }
      label207:
      while (paramInt != 2)
      {
        return;
        l1 = l2;
        if (!((TroopInfo)localObject).isTroopAdmin(paramQQAppInterface.getCurrentUin())) {
          break label275;
        }
        i = 2;
        l1 = l2;
        break;
      }
      bdla.b(null, "dc00898", "", Long.toString(paramLong), "0X800AFC6", "0X800AFC6", 0, 0, String.valueOf(l1), "", "", "");
      return;
      label275:
      i = 0;
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity)
  {
    long l2;
    Object localObject;
    long l1;
    int i;
    if (a(paramQQAppInterface, paramLong))
    {
      l2 = 0L;
      localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      l1 = l2;
      if (localObject == null) {
        break label183;
      }
      localObject = ((TroopManager)localObject).b(String.valueOf(paramLong));
      l1 = l2;
      if (localObject == null) {
        break label183;
      }
      l2 = ((TroopInfo)localObject).dwGroupClassExt;
      if (!((TroopInfo)localObject).isTroopOwner(paramQQAppInterface.getCurrentUin())) {
        break label157;
      }
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("url", "https://qun.qq.com/slidepanel/search?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$".replace("$GCODE$", Long.toString(paramLong)).replace("$GID$", Integer.toString(i)).replace("$GTYPE$", Long.toString(l1)));
      paramQQAppInterface.putExtra("webStyle", "noBottomBar");
      paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramBaseActivity.startActivityForResult(paramQQAppInterface, 20007);
      return;
      label157:
      l1 = l2;
      if (((TroopInfo)localObject).isTroopAdmin(paramQQAppInterface.getCurrentUin()))
      {
        i = 2;
        l1 = l2;
      }
      else
      {
        label183:
        i = 0;
      }
    }
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramImageView == null)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      float f = paramFloat / 10.0F;
      try
      {
        paramImageView.setImageDrawable(a(paramContext, paramString, paramFloat, f));
        a(paramImageView, paramBoolean, f);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("TroopAppShortcutUtils", 1, "fetchDrawable: failed. ", paramString);
        paramImageView.setImageDrawable(paramContext.getResources().getDrawable(2130843782));
        a(paramImageView, false, 0.0F);
        return;
      }
    }
    paramImageView.setImageDrawable(paramContext.getResources().getDrawable(2130843782));
    a(paramImageView, false, 0.0F);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setOnTouchListener(new bgin());
  }
  
  public static void a(View paramView, boolean paramBoolean, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      int i = ViewUtils.dpToPx(0.5F);
      paramView.setPadding(i, i, i, i);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(ViewUtils.dpToPx(paramFloat));
      localGradientDrawable.setStroke(ViewUtils.dpToPx(0.5F), Color.parseColor("#FFE5E5E5"));
      paramView.setBackground(localGradientDrawable);
      return;
    }
    paramView.setPadding(0, 0, 0, 0);
    paramView.setBackground(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramBaseActivity == null) || (paramSessionInfo == null)) {}
    TroopInfo localTroopInfo;
    label274:
    label463:
    label471:
    label488:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramSessionInfo.curFriendUin);
            if (localTroopInfo != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("TroopAppShortcutUtils", 2, "OnClickListener. troopInfo is null.");
          return;
          if (paramInt2 != 0) {
            bglm.a(paramQQAppInterface, paramSessionInfo.curFriendUin, (int)paramLong);
          }
          if (paramLong == 101761547L)
          {
            awfq.b(paramQQAppInterface, paramContext, 1, paramSessionInfo.curFriendUin, 0);
            return;
          }
          if (paramLong == 101793773L)
          {
            a(paramQQAppInterface, paramContext, localTroopInfo, paramSessionInfo);
            return;
          }
          if (paramLong == 101817424L)
          {
            b(paramQQAppInterface, paramContext, localTroopInfo, paramSessionInfo);
            return;
          }
          if (paramLong == 101847770L)
          {
            paramQQAppInterface = TroopMemberListActivity.a(paramContext, paramSessionInfo.curFriendUin, 19);
            paramQQAppInterface.putExtra("TROOP_INFO_MEMBER_NUM", localTroopInfo.wMemberNum);
            paramContext.startActivity(paramQQAppInterface);
            return;
          }
          if (paramLong != 101872203L) {
            break;
          }
        } while (nqi.a(paramBaseActivity, paramSessionInfo.curFriendUin));
        paramContext = (ncz)paramQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
      } while (paramContext == null);
      paramContext.a(paramBaseActivity, 3, paramSessionInfo.curFriendUin, 0);
      if (paramInt1 == 0)
      {
        paramQQAppInterface = "0X800B4E4";
        if (!paramContext.a()) {
          break label274;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        bdla.b(null, "dc00898", "", "", paramQQAppInterface, paramQQAppInterface, paramInt1, 0, "", "", localTroopInfo.troopuin, "");
        return;
        paramQQAppInterface = "0X800B4E3";
        break;
      }
      if (paramLong == 101889454L)
      {
        paramBaseActivity = new Bundle();
        paramBaseActivity.putString("action", "click");
        paramBaseActivity.putString("page", "group_page");
        paramBaseActivity.putString("module", "studyroom_entry");
        paramBaseActivity.putString("room_id", paramSessionInfo.curFriendUin);
        bdxf.a(paramBaseActivity);
      }
      boolean bool;
      int i;
      if ((paramLong == 1101236949L) && (arjy.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))))
      {
        bool = aofp.c(localTroopInfo.groupFreezeReason);
        if (!localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          break label561;
        }
        String str1 = paramSessionInfo.curFriendUin;
        if (bool)
        {
          i = 15;
          String str2 = VipUtils.a(0, i).toString();
          String str3 = anvx.a(2131701238);
          bgim localbgim = new bgim();
          if (!bool) {
            break label548;
          }
          paramBaseActivity = "0X800A57F";
          if (!bool) {
            break label555;
          }
          i = 1;
          VipUtils.a(paramContext, str1, str2, str3, localbgim, paramBaseActivity, i, bool);
        }
      }
      else
      {
        if (paramInt1 != 0) {
          break label570;
        }
      }
      for (paramInt1 = 4007;; paramInt1 = 4008)
      {
        if (!MiniAppLauncher.isMiniAppUrl(paramString)) {
          break label578;
        }
        MiniAppLauncher.startMiniApp(paramContext, a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramString, paramLong, localTroopInfo, true, paramInt2), paramInt1, TroopUtils.createEntryModel(localTroopInfo, paramSessionInfo.curFriendUin), null);
        return;
        i = 8;
        break;
        paramBaseActivity = "0X8009E38";
        break label463;
        i = 3;
        break label471;
        VipUtils.a(paramContext, bool);
        break label488;
      }
      if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
      {
        paramBaseActivity = new Intent(paramContext, QQBrowserActivity.class);
        paramBaseActivity.putExtra("url", a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramString, paramLong, localTroopInfo, true, paramInt2));
        paramBaseActivity.putExtra("webStyle", "noBottomBar");
        paramBaseActivity.putExtra("startOpenPageTime", System.currentTimeMillis());
        paramContext.startActivity(paramBaseActivity);
        return;
      }
    } while (!paramString.startsWith("mqqapi"));
    label548:
    label555:
    label561:
    label570:
    label578:
    paramBaseActivity = a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramString, paramLong, localTroopInfo, true, paramInt2);
    paramSessionInfo = new Intent(paramContext, JumpActivity.class);
    paramQQAppInterface = paramBaseActivity;
    if (paramLong == 1105981808L) {
      paramQQAppInterface = zcl.a(paramSessionInfo, paramBaseActivity, null);
    }
    paramSessionInfo.setData(Uri.parse(paramQQAppInterface));
    paramContext.startActivity(paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, SessionInfo paramSessionInfo)
  {
    argl localargl = (argl)aqxe.a().a(535);
    if ((localargl == null) || (localargl.a == null)) {
      QQToast.a(paramContext, 0, 2131692995, 0).a();
    }
    bejv localbejv;
    boolean bool;
    do
    {
      return;
      localbejv = (bejv)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      bool = localbejv.a(2, 1, paramTroopInfo.uin);
      paramSessionInfo = beki.a(bool, paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramSessionInfo.curFriendUin, 0);
      switch (localargl.a.a())
      {
      default: 
        if (!localbejv.a(paramContext, 2, paramTroopInfo.troopuin, 0)) {
          break label231;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAppShortcutUtils", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
    return;
    QQToast.a(paramContext, 0, 2131692995, 0).a();
    return;
    if (bool)
    {
      localbejv.b(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
      return;
    }
    localbejv.a(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
    return;
    label231:
    beki.a(paramQQAppInterface, localargl.a.b(), localargl.a.a(), localargl.a.b(), paramSessionInfo, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bgex parambgex, long paramLong)
  {
    if (parambgex == null) {}
    bgbc localbgbc;
    do
    {
      do
      {
        do
        {
          return;
          localbgbc = (bgbc)aqxe.a().a(590);
        } while (localbgbc == null);
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.b(String.valueOf(paramLong));
    } while (paramQQAppInterface == null);
    parambgex.c = localbgbc.a((int)paramQQAppInterface.dwGroupClassExt);
    if (localbgbc.a == bgbc.c) {}
    for (boolean bool = true;; bool = false)
    {
      parambgex.d = bool;
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (TroopUtils.isTroopAdmin(paramQQAppInterface, Long.toString(paramLong), paramQQAppInterface.getCurrentUin())) || (TroopUtils.isTroopOwner(paramQQAppInterface, Long.toString(paramLong), paramQQAppInterface.getCurrentUin()));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, SessionInfo paramSessionInfo)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = (bejv)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = paramQQAppInterface.a(4, -1, paramSessionInfo.curFriendUin);
    paramTroopInfo = beki.a(bool, paramTroopInfo.isTroopOwner(str), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramSessionInfo.curFriendUin, 0);
    if (bool)
    {
      paramQQAppInterface.b(paramContext, paramSessionInfo.curFriendUin, 1, 4, 0, paramTroopInfo);
      return;
    }
    paramQQAppInterface.a(paramContext, paramSessionInfo.curFriendUin, 1, 4, 0, paramTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgil
 * JD-Core Version:    0.7.0.1
 */