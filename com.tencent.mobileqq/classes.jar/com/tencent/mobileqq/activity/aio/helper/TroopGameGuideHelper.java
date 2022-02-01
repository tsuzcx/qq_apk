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
  protected Handler a;
  protected View a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected ITroopGameHandler a;
  private TroopGameObserver jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver = new TroopGameGuideHelper.1(this);
  protected String a;
  protected String b = "";
  
  public TroopGameGuideHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new TroopGameGuideHelper.2(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((paramBaseChatPie != null) && (paramBaseChatPie.jdField_a_of_type_AndroidContentContext != null)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131719884);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
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
  
  private boolean a()
  {
    try
    {
      Object localObject1 = TroopGameCardResDownloadManager.a();
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
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2131558982, null);
        ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379222)).setImageBitmap((Bitmap)localObject2);
        localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379218);
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
        ((ImageView)localObject2).setOnClickListener(new TroopGameGuideHelper.4(this));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131379221).setOnClickListener(new TroopGameGuideHelper.5(this));
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      label200:
      break label200;
    }
    return true;
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
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
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
    localSharedPreferences.edit().putBoolean(paramQQAppInterface, false).commit();
  }
  
  private void d()
  {
    if (TextUtils.isEmpty(this.b)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_AndroidContentContext != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null) {
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.B)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().isFinishing()) {
          return;
        }
        if (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b)) {
          return;
        }
        localObject = this.jdField_a_of_type_AndroidAppDialog;
        if ((localObject != null) && (((Dialog)localObject).isShowing())) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((localObject instanceof TroopChatPie))
        {
          localObject = (TroopChatPie)localObject;
          if ((((TroopChatPie)localObject).a != null) && (((TroopChatPie)localObject).a.isShowing()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopGameGuideHelper", 2, "showGameGuide troop notification window is already showing.");
            }
            return;
          }
        }
        if (this.jdField_a_of_type_AndroidAppDialog == null) {
          this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131756189);
        }
        if ((this.jdField_a_of_type_AndroidViewView == null) && (!a())) {
          return;
        }
        this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.show();
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b);
        TroopReportor.a("Grp_AIO", "AIO_exp", "game_tips_exp", 0, 0, new String[] { this.b });
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver);
      }
    }
  }
  
  private void e()
  {
    b();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.b))) {
        b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b);
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
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide hlGuildAppid = game.");
      }
      return;
    }
    paramTroopInfo = (TroopGameCardConfig)QConfigManager.a().a(695);
    if (paramTroopInfo != null)
    {
      int i = paramTroopInfo.a();
      if (i > 0)
      {
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.b, 1, null, i).iterator();
        while (paramTroopInfo.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramTroopInfo.next();
          if ((localMessageRecord.msgtype == -5008) && ((localMessageRecord instanceof MessageForArkApp)) && (a(((MessageForArkApp)localMessageRecord).ark_app_message))) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          }
        }
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide mBaseChatPie = null");
      }
      return;
    }
    if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide sessionInfo = null");
      }
      return;
    }
    this.b = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (StudyModeManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide studymode = true.");
      }
      return;
    }
    localObject = (TroopGameCardConfig)QConfigManager.a().a(695);
    if ((localObject != null) && (((TroopGameCardConfig)localObject).a(this.b)))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.b);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide troopinfo=null");
        }
        return;
      }
      if (!((TroopInfo)localObject).isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
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
      if (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b))
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
      e();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper
 * JD-Core Version:    0.7.0.1
 */