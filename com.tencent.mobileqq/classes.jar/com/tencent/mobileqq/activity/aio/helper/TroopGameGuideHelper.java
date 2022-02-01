package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopGameGuideHelper
  implements ILifeCycleHelper
{
  protected Dialog a;
  protected View b;
  protected String c = "";
  protected String d = "";
  protected ITroopGameHandler e;
  protected Handler f = new TroopGameGuideHelper.2(this, Looper.getMainLooper());
  private BaseChatPie g;
  private TroopGameObserver h = new TroopGameGuideHelper.1(this);
  
  public TroopGameGuideHelper(BaseChatPie paramBaseChatPie)
  {
    this.g = paramBaseChatPie;
    paramBaseChatPie = this.g;
    if ((paramBaseChatPie != null) && (paramBaseChatPie.e != null)) {
      this.c = this.g.e.getString(2131917489);
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_GAME_GUIDE_");
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private boolean a(ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return false;
    }
    boolean bool = TextUtils.isEmpty(paramArkAppMessage.appId);
    String str2 = "";
    String str1;
    if (bool) {
      str1 = "";
    } else {
      str1 = paramArkAppMessage.appId;
    }
    if (TextUtils.isEmpty(paramArkAppMessage.appName)) {
      paramArkAppMessage = str2;
    } else {
      paramArkAppMessage = paramArkAppMessage.appName;
    }
    if ((!str1.equals("1104466820")) && (!paramArkAppMessage.equals("com.tencent.gamecenter.teamshare")) && (!paramArkAppMessage.equals("com.tencent.gamecenter.gameshare_sgame"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "isGameLink = true.");
    }
    this.f.sendEmptyMessage(1);
    return true;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_GAME_GUIDE_");
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramQQAppInterface = localStringBuilder.toString();
    localSharedPreferences.edit().putBoolean(paramQQAppInterface, true).commit();
  }
  
  private static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_GAME_GUIDE_");
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramQQAppInterface = localStringBuilder.toString();
    localSharedPreferences.edit().putBoolean(paramQQAppInterface, false).commit();
  }
  
  private void d()
  {
    if (TextUtils.isEmpty(this.d)) {
      return;
    }
    Object localObject = this.g;
    if ((localObject != null) && (((BaseChatPie)localObject).e != null))
    {
      if (this.g.aX() == null) {
        return;
      }
      if (!this.g.aY)
      {
        if (this.g.aX().isFinishing()) {
          return;
        }
        if (a(this.g.d, this.d)) {
          return;
        }
        localObject = this.a;
        if ((localObject != null) && (((Dialog)localObject).isShowing())) {
          return;
        }
        localObject = this.g;
        if ((localObject instanceof TroopChatPie))
        {
          localObject = (TroopChatPie)localObject;
          if ((((TroopChatPie)localObject).bF != null) && (((TroopChatPie)localObject).bF.isShowing()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopGameGuideHelper", 2, "showGameGuide troop notification window is already showing.");
            }
            return;
          }
        }
        if (this.a == null) {
          this.a = new ReportDialog(this.g.e, 2131953338);
        }
        if ((this.b == null) && (!e())) {
          return;
        }
        this.a.setContentView(this.b);
        this.a.setCanceledOnTouchOutside(false);
        this.a.show();
        b(this.g.d, this.d);
        TroopReportor.a("Grp_AIO", "AIO_exp", "game_tips_exp", 0, 0, new String[] { this.d });
        this.g.d.removeObserver(this.h);
      }
    }
  }
  
  private boolean e()
  {
    try
    {
      Object localObject1 = TroopGameCardResDownloadManager.b();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return false;
      }
      Object localObject2 = (ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("aio_game_popup_bg.png");
      localObject2 = ((ITroopGameCardUtilsApi)localObject2).getImageBitmap(((StringBuilder)localObject3).toString());
      localObject3 = (ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("aio_game_popup_close_btn.png");
      localObject1 = ((ITroopGameCardUtilsApi)localObject3).getImageBitmap(localStringBuilder.toString());
      if (localObject2 != null)
      {
        if (localObject1 == null) {
          return false;
        }
        this.b = LayoutInflater.from(this.g.e).inflate(2131624615, null);
        ((ImageView)this.b.findViewById(2131447959)).setImageBitmap((Bitmap)localObject2);
        localObject2 = (ImageView)this.b.findViewById(2131447955);
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
        ((ImageView)localObject2).setOnClickListener(new TroopGameGuideHelper.4(this));
        this.b.findViewById(2131447958).setOnClickListener(new TroopGameGuideHelper.5(this));
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      label205:
      break label205;
    }
    return true;
  }
  
  private void f()
  {
    b();
  }
  
  public void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      localObject = this.g;
      if ((localObject != null) && (((BaseChatPie)localObject).d != null) && (!TextUtils.isEmpty(this.d))) {
        c(this.g.d, this.d);
      }
    }
    b();
  }
  
  void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide");
    }
    if ("1104466820".equals(String.valueOf(paramTroopInfo.hlGuildAppid)))
    {
      this.f.sendEmptyMessage(1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide hlGuildAppid = game.");
      }
      return;
    }
    paramTroopInfo = (TroopGameCardConfig)QConfigManager.b().b(695);
    if (paramTroopInfo != null)
    {
      int i = paramTroopInfo.d();
      if (i > 0)
      {
        paramTroopInfo = this.g.d.getMessageFacade().a(this.d, 1, null, i).iterator();
        while (paramTroopInfo.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramTroopInfo.next();
          if ((localMessageRecord.msgtype == -5008) && ((localMessageRecord instanceof MessageForArkApp)) && (a(((MessageForArkApp)localMessageRecord).ark_app_message))) {
            this.f.sendEmptyMessage(1);
          }
        }
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.a.dismiss();
    }
    localObject = this.g;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null)) {
      this.g.d.removeObserver(this.h);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide");
    }
    Object localObject = this.g;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide mBaseChatPie = null");
      }
      return;
    }
    if (((BaseChatPie)localObject).ah == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide sessionInfo = null");
      }
      return;
    }
    this.d = this.g.ah.b;
    if (StudyModeManager.h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide studymode = true.");
      }
      return;
    }
    localObject = (TroopGameCardConfig)QConfigManager.b().b(695);
    if ((localObject != null) && (((TroopGameCardConfig)localObject).d(this.d)))
    {
      localObject = ((TroopManager)this.g.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.d);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide troopinfo=null");
        }
        return;
      }
      if (!((TroopInfo)localObject).isOwnerOrAdmin(this.g.d.getCurrentUin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide isOwnerOrAdmin = false.");
        }
        return;
      }
      if (((TroopInfo)localObject).isHomeworkTroop())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide homeworktroop");
        }
        return;
      }
      if (((TroopInfo)localObject).isTroopGameCardEnabled())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide isTroopGameCardEnabled = true.");
        }
        return;
      }
      if (a(this.g.d, this.d))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide hasShownGameGuide = true.");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide asyncCheckShouldShowGameGuide");
      }
      ThreadManager.getSubThreadHandler().post(new TroopGameGuideHelper.3(this, (TroopInfo)localObject));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide is not graytroop");
    }
  }
  
  public String getTag()
  {
    return "TroopGameGuideHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 9 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 9)
    {
      if (paramInt != 15) {
        return;
      }
      f();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper
 * JD-Core Version:    0.7.0.1
 */