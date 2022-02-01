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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bfaf
{
  public static Drawable a(Context paramContext, String paramString, float paramFloat1, float paramFloat2)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    int i = ViewUtils.dpToPx(paramFloat1);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130843744);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130843744);
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
          paramContext.setTag(bfol.b(i, i, ViewUtils.dpToPx(paramFloat2)));
          paramContext.setDecodeHandler(bfol.j);
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
      paramString2 = paramString2.replace("$GCODE$", paramString1).replace("$CLIENTVER$", "android8.4.8").replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
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
      localObject = (TroopManager)paramQQAppInterface.getManager(52);
      l1 = l2;
      if (localObject == null) {
        break label264;
      }
      localObject = ((TroopManager)localObject).b(String.valueOf(paramLong));
      l1 = l2;
      if (localObject == null) {
        break label264;
      }
      l2 = ((TroopInfo)localObject).dwGroupClassExt;
      if (!((TroopInfo)localObject).isTroopOwner(paramQQAppInterface.getCurrentUin())) {
        break label201;
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
        bcef.b(null, "dc00898", "", Long.toString(paramLong), "0X800AD0B", "0X800AD0B", 0, 0, String.valueOf(l1), "", "", "");
      }
      label201:
      while (paramInt != 2)
      {
        return;
        l1 = l2;
        if (!((TroopInfo)localObject).isTroopAdmin(paramQQAppInterface.getCurrentUin())) {
          break label264;
        }
        i = 2;
        l1 = l2;
        break;
      }
      bcef.b(null, "dc00898", "", Long.toString(paramLong), "0X800AFC6", "0X800AFC6", 0, 0, String.valueOf(l1), "", "", "");
      return;
      label264:
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
      localObject = (TroopManager)paramQQAppInterface.getManager(52);
      l1 = l2;
      if (localObject == null) {
        break label182;
      }
      localObject = ((TroopManager)localObject).b(String.valueOf(paramLong));
      l1 = l2;
      if (localObject == null) {
        break label182;
      }
      l2 = ((TroopInfo)localObject).dwGroupClassExt;
      if (!((TroopInfo)localObject).isTroopOwner(paramQQAppInterface.getCurrentUin())) {
        break label156;
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
      label156:
      l1 = l2;
      if (((TroopInfo)localObject).isTroopAdmin(paramQQAppInterface.getCurrentUin()))
      {
        i = 2;
        l1 = l2;
      }
      else
      {
        label182:
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
        paramImageView.setImageDrawable(paramContext.getResources().getDrawable(2130843744));
        a(paramImageView, false, 0.0F);
        return;
      }
    }
    paramImageView.setImageDrawable(paramContext.getResources().getDrawable(2130843744));
    a(paramImageView, false, 0.0F);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setOnTouchListener(new bfah());
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
    label267:
    label456:
    label464:
    label481:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.curFriendUin);
            if (localTroopInfo != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("TroopAppShortcutUtils", 2, "OnClickListener. troopInfo is null.");
          return;
          if (paramInt2 != 0) {
            bfdg.a(paramQQAppInterface, paramSessionInfo.curFriendUin, (int)paramLong);
          }
          if (paramLong == 101761547L)
          {
            auzn.b(paramQQAppInterface, paramContext, 1, paramSessionInfo.curFriendUin, 0);
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
        } while (njk.a(paramBaseActivity, paramSessionInfo.curFriendUin));
        paramContext = (mxn)paramQQAppInterface.getManager(373);
      } while (paramContext == null);
      paramContext.a(paramBaseActivity, 3, paramSessionInfo.curFriendUin, 0);
      if (paramInt1 == 0)
      {
        paramQQAppInterface = "0X800B4E4";
        if (!paramContext.a()) {
          break label267;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        bcef.b(null, "dc00898", "", "", paramQQAppInterface, paramQQAppInterface, paramInt1, 0, "", "", localTroopInfo.troopuin, "");
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
        bcqg.a(paramBaseActivity);
      }
      boolean bool;
      int i;
      if ((paramLong == 1101236949L) && (aqgr.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))))
      {
        bool = ancy.c(localTroopInfo.groupFreezeReason);
        if (!localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          break label554;
        }
        String str1 = paramSessionInfo.curFriendUin;
        if (bool)
        {
          i = 15;
          String str2 = VipUtils.a(0, i).toString();
          String str3 = amtj.a(2131700887);
          bfag localbfag = new bfag();
          if (!bool) {
            break label541;
          }
          paramBaseActivity = "0X800A57F";
          if (!bool) {
            break label548;
          }
          i = 1;
          VipUtils.a(paramContext, str1, str2, str3, localbfag, paramBaseActivity, i, bool);
        }
      }
      else
      {
        if (paramInt1 != 0) {
          break label563;
        }
      }
      for (paramInt1 = 4007;; paramInt1 = 4008)
      {
        if (!MiniAppLauncher.isMiniAppUrl(paramString)) {
          break label571;
        }
        MiniAppLauncher.startMiniApp(paramContext, a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramString, paramLong, localTroopInfo, true, paramInt2), paramInt1, TroopUtils.createEntryModel(localTroopInfo, paramSessionInfo.curFriendUin), null);
        return;
        i = 8;
        break;
        paramBaseActivity = "0X8009E38";
        break label456;
        i = 3;
        break label464;
        VipUtils.a(paramContext, bool);
        break label481;
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
    label541:
    label548:
    label554:
    label563:
    label571:
    paramBaseActivity = a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramString, paramLong, localTroopInfo, true, paramInt2);
    paramSessionInfo = new Intent(paramContext, JumpActivity.class);
    paramQQAppInterface = paramBaseActivity;
    if (paramLong == 1105981808L) {
      paramQQAppInterface = yns.a(paramSessionInfo, paramBaseActivity, null);
    }
    paramSessionInfo.setData(Uri.parse(paramQQAppInterface));
    paramContext.startActivity(paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, SessionInfo paramSessionInfo)
  {
    aqde localaqde = (aqde)apub.a().a(535);
    if ((localaqde == null) || (localaqde.a == null)) {
      QQToast.a(paramContext, 0, 2131692889, 0).a();
    }
    bdct localbdct;
    boolean bool;
    do
    {
      return;
      localbdct = (bdct)paramQQAppInterface.getManager(339);
      bool = localbdct.a(2, 1, paramTroopInfo.uin);
      paramSessionInfo = bddg.a(bool, paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramSessionInfo.curFriendUin, 0);
      switch (localaqde.a.a())
      {
      default: 
        if (!localbdct.a(paramContext, 2, paramTroopInfo.troopuin, 0)) {
          break label231;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAppShortcutUtils", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
    return;
    QQToast.a(paramContext, 0, 2131692889, 0).a();
    return;
    if (bool)
    {
      localbdct.b(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
      return;
    }
    localbdct.a(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramSessionInfo);
    return;
    label231:
    bddg.a(paramQQAppInterface, localaqde.a.b(), localaqde.a.a(), localaqde.a.b(), paramSessionInfo, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bexl parambexl, long paramLong)
  {
    if (parambexl == null) {}
    betw localbetw;
    do
    {
      do
      {
        do
        {
          return;
          localbetw = (betw)apub.a().a(590);
        } while (localbetw == null);
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.b(String.valueOf(paramLong));
    } while (paramQQAppInterface == null);
    parambexl.c = localbetw.a((int)paramQQAppInterface.dwGroupClassExt);
    if (localbetw.a == betw.c) {}
    for (boolean bool = true;; bool = false)
    {
      parambexl.d = bool;
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
    paramQQAppInterface = (bdct)paramQQAppInterface.getManager(339);
    boolean bool = paramQQAppInterface.a(4, -1, paramSessionInfo.curFriendUin);
    paramTroopInfo = bddg.a(bool, paramTroopInfo.isTroopOwner(str), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramSessionInfo.curFriendUin, 0);
    if (bool)
    {
      paramQQAppInterface.b(paramContext, paramSessionInfo.curFriendUin, 1, 4, 0, paramTroopInfo);
      return;
    }
    paramQQAppInterface.a(paramContext, paramSessionInfo.curFriendUin, 1, 4, 0, paramTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfaf
 * JD-Core Version:    0.7.0.1
 */