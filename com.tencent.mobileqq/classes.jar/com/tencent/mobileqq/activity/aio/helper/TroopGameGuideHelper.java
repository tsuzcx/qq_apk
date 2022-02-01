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
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager;
import com.tencent.mobileqq.util.TroopGameCardUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopGameGuideHelper
  implements ILifeCycleHelper
{
  protected Dialog a;
  protected Handler a;
  protected View a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopGameGuideHelper.1(this);
  protected TroopHandler a;
  protected String a;
  protected String b = "";
  
  public TroopGameGuideHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new TroopGameGuideHelper.2(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext != null)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131720151);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = "SP_GAME_GUIDE_" + paramQQAppInterface + "_" + paramString;
    localSharedPreferences.edit().putBoolean(paramQQAppInterface, true).commit();
  }
  
  private boolean a()
  {
    try
    {
      Object localObject2 = TroopGameCardResDownloadManager.a();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return false;
      }
      Object localObject1 = TroopGameCardUtil.a((String)localObject2 + "aio_game_popup_bg.png");
      localObject2 = TroopGameCardUtil.a((String)localObject2 + "aio_game_popup_close_btn.png");
      if ((localObject1 == null) || (localObject2 == null)) {
        break label159;
      }
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2131559088, null);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379893)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379889);
      ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      ((ImageView)localObject1).setOnClickListener(new TroopGameGuideHelper.4(this));
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379892).setOnClickListener(new TroopGameGuideHelper.5(this));
    }
    catch (Exception localException)
    {
      label153:
      break label153;
    }
    return true;
    label159:
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getBoolean("SP_GAME_GUIDE_" + paramQQAppInterface + "_" + paramString, false);
  }
  
  private boolean a(ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return false;
    }
    String str;
    if (TextUtils.isEmpty(paramArkAppMessage.appId))
    {
      str = "";
      if (!TextUtils.isEmpty(paramArkAppMessage.appName)) {
        break label92;
      }
    }
    label92:
    for (paramArkAppMessage = "";; paramArkAppMessage = paramArkAppMessage.appName)
    {
      if ((!str.equals("1104466820")) && (!paramArkAppMessage.equals("com.tencent.gamecenter.teamshare")) && (!paramArkAppMessage.equals("com.tencent.gamecenter.gameshare_sgame"))) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "isGameLink = true.");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return true;
      str = paramArkAppMessage.appId;
      break;
    }
    label100:
    return false;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = "SP_GAME_GUIDE_" + paramQQAppInterface + "_" + paramString;
    localSharedPreferences.edit().putBoolean(paramQQAppInterface, false).commit();
  }
  
  private void d()
  {
    if (TextUtils.isEmpty(this.b)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.I) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().isFinishing()) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b)) || ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())));
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
          break;
        }
        TroopChatPie localTroopChatPie = (TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((localTroopChatPie.a == null) || (!localTroopChatPie.a.isShowing())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopGameGuideHelper", 2, "showGameGuide troop notification window is already showing.");
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131755842);
      }
    } while ((this.jdField_a_of_type_AndroidViewView == null) && (!a()));
    this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidAppDialog.show();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b);
    TroopReportor.a("Grp_AIO", "AIO_exp", "game_tips_exp", 0, 0, new String[] { this.b });
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  private void e()
  {
    b();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.b))) {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b);
    }
    b();
  }
  
  void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {}
    MessageRecord localMessageRecord;
    do
    {
      return;
      while (!paramTroopInfo.hasNext())
      {
        int i;
        do
        {
          do
          {
            do
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide");
              }
              if (!"1104466820".equals(String.valueOf(paramTroopInfo.hlGuildAppid))) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
            } while (!QLog.isColorLevel());
            QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide hlGuildAppid = game.");
            return;
            paramTroopInfo = (TroopGameCardConfig)QConfigManager.a().a(695);
          } while (paramTroopInfo == null);
          i = paramTroopInfo.a();
        } while (i <= 0);
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.b, 1, null, i).iterator();
      }
      localMessageRecord = (MessageRecord)paramTroopInfo.next();
    } while ((localMessageRecord.msgtype != -5008) || (!(localMessageRecord instanceof MessageForArkApp)) || (!a(((MessageForArkApp)localMessageRecord).ark_app_message)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide mBaseChatPie = null");
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide sessionInfo = null");
                  return;
                  this.b = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                  if (!StudyModeManager.a()) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide studymode = true.");
                return;
                localObject = (TroopGameCardConfig)QConfigManager.a().a(695);
                if ((localObject != null) && (((TroopGameCardConfig)localObject).a(this.b))) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide is not graytroop");
              return;
              localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.b);
              if (localObject != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide troopinfo=null");
            return;
            if (((TroopInfo)localObject).isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide isOwnerOrAdmin = false.");
          return;
          if (!((TroopInfo)localObject).isHomeworkTroop()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide homeworktroop");
        return;
        if (!((TroopInfo)localObject).isTroopGameCardEnabled()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide isTroopGameCardEnabled = true.");
      return;
      if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide hasShownGameGuide = true.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide asyncCheckShouldShowGameGuide");
    }
    ThreadManager.getSubThreadHandler().post(new TroopGameGuideHelper.3(this, (TroopInfo)localObject));
  }
  
  public String getTag()
  {
    return "TroopGameGuideHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14, 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 14: 
      e();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper
 * JD-Core Version:    0.7.0.1
 */