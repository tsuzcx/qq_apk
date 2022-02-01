package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TogetherTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherEntryBean;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.together.ui.TogetherPanel;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class TogetherControlHelper
  implements Handler.Callback, View.OnClickListener, ILifeCycleHelper
{
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private TogetherTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new TogetherControlHelper.2(this);
  private TogetherObserver jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver = new TogetherControlHelper.1(this);
  private TogetherUIData jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
  TogetherPanel jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = 0L;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public TogetherControlHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData = new TogetherUIData();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
    }
  }
  
  private TogetherTipsBar a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar = new TogetherTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar;
  }
  
  private void a(TogetherSession paramTogetherSession)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "invokeJoinDialog activity or intent is null");
      }
    }
    while (!TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), paramTogetherSession, this.jdField_a_of_type_Boolean)) {
      return;
    }
    b(((TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(paramTogetherSession.jdField_e_of_type_Int));
  }
  
  private void b(String paramString)
  {
    ThreadManagerV2.executeOnSubThread(new TogetherControlHelper.3(this, paramString));
  }
  
  private void c(String paramString)
  {
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    localTogetherControlManager.a("video_tab", "exp_joinframe", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
    h();
    String str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131699305), new Object[] { paramString });
    paramString = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131699308), new Object[] { paramString });
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131690800);
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131694615);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, null, paramString, str2, str3, new TogetherControlHelper.4(this, localTogetherControlManager, str1), new TogetherControlHelper.5(this, localTogetherControlManager));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageMaxLine(1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "showTogetherTip");
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null");
      }
    }
    do
    {
      return false;
      TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
      if ((localTipsBarTask == null) || (localTipsBarTask == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlHelper.helper", 2, "currTip is other");
    return false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar, new Object[0]);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).bB();
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie));
    ((FriendChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).bi();
  }
  
  private boolean h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return true;
    }
    return false;
  }
  
  private void i()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
      }
    }
    TogetherControlManager localTogetherControlManager;
    TogetherSession localTogetherSession;
    int i;
    int j;
    Bundle localBundle;
    for (;;)
    {
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131720747, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693140, 0).a();
        return;
      }
      localTogetherControlManager = (TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      if (localTogetherControlManager != null)
      {
        localTogetherSession = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        Object localObject;
        if ((localTogetherSession instanceof WatchTogetherSession))
        {
          localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
          if (localObject != null)
          {
            localObject = TogetherUtils.a(true, ((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0);
            switch (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().j)
            {
            default: 
              if (localTogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), 1)) {
                if (QLog.isColorLevel()) {
                  QLog.d("TogetherControlHelper.helper", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
                }
              }
              break;
            }
            for (;;)
            {
              localTogetherControlManager.a("video_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
              return;
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693140, 0).a();
              continue;
              localTogetherControlManager.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
              localTogetherControlManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), 1, 2, 1, (Bundle)localObject);
              continue;
              localTogetherControlManager.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
              TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().k, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_JavaLangString, null, (Bundle)localObject, 1);
            }
          }
        }
        else if ((localTogetherSession instanceof SingTogetherSession))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, "SING together is click");
          }
          localObject = null;
          i = -1;
          j = -1;
          localBundle = new Bundle();
          String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          boolean bool = localTogetherControlManager.a(4, -1, localTogetherSession.jdField_e_of_type_JavaLangString);
          if (localTogetherSession.f == 1)
          {
            j = 1;
            localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(localTogetherSession.jdField_e_of_type_JavaLangString);
            if (localObject != null)
            {
              localBundle = TogetherUtils.a(bool, ((TroopInfo)localObject).isTroopOwner(str), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, localTogetherSession.jdField_e_of_type_JavaLangString, 1);
              localTogetherControlManager.a("sing_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
              i = 1;
              localObject = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
            }
          }
          else
          {
            while (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if (!bool) {
                break label742;
              }
              localTogetherControlManager.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTogetherSession.jdField_e_of_type_JavaLangString, i, 4, j, localBundle);
              return;
              if (localTogetherSession.f == 2)
              {
                localBundle = TogetherUtils.a(bool, 4);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join", 0, 0, localTogetherSession.jdField_e_of_type_JavaLangString, "", "", "");
                j = 4;
                i = 2;
                localObject = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
              }
            }
          }
        }
      }
    }
    label742:
    localTogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTogetherSession.jdField_e_of_type_JavaLangString, i, 4, j, localBundle);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("open_together_panel", false))) {
      a(3);
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) {
      return "";
    }
    boolean bool = a();
    return this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getSubTitleText(bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
    TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
      TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
  }
  
  public void a(int paramInt)
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie))
    {
      QLog.d("TogetherControlHelper.helper", 1, "chat pie not TroopChatPie");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel == null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel = new TogetherPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131364598);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localView, paramInt);
  }
  
  public void a(int paramInt, TipsBarTask paramTipsBarTask)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip=" + paramTipsBarTask + " type=" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar == paramTipsBarTask)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if ((TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession())) && (!TogetherWatchFloatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f)) && (!e())) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide expand=" + bool);
      }
      if (bool) {
        g();
      }
      h();
      return;
      bool = false;
    }
  }
  
  public void a(String paramString)
  {
    boolean bool3 = false;
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {}
    boolean bool4;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null));
      bool4 = a();
      if (!bool4) {
        break;
      }
      bool2 = b();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onSubTitleClicked isPanelShow= " + bool4 + " handle=" + bool2);
      }
    } while (!bool2);
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f == 2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool4)
      {
        localObject1 = "clk_expand";
        label142:
        ReportController.b((AppRuntime)localObject2, "dc00899", "c2c_AIO", "", "sing_tab", (String)localObject1, 0, 2, paramString, "", "", "");
        label173:
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        bool1 = bool3;
        if (!bool4) {
          bool1 = true;
        }
        TogetherUtils.a(paramString, (TogetherSession)localObject1, bool1);
        h();
        return;
        if (TogetherWatchFloatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f)) {
          break label425;
        }
      }
    }
    label425:
    for (boolean bool1 = g();; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
      bool2 = bool1;
      if (!(localObject1 instanceof WatchTogetherSession)) {
        break;
      }
      bool2 = bool1;
      if (((TogetherSession)localObject1).l != 2) {
        break;
      }
      ((TogetherSession)localObject1).l = 1;
      bool2 = bool1;
      break;
      localObject1 = "clk_fold";
      break label142;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int == 2)
      {
        localObject2 = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bool4) {}
        for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
        {
          ((TogetherControlManager)localObject2).a("video_tab", (String)localObject1, 2, paramString);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int != 4) {
        break label173;
      }
      localObject2 = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool4) {}
      for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
      {
        ((TogetherControlManager)localObject2).a("sing_tab", (String)localObject1, 2, paramString);
        break;
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a() != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onResume()");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void b(int paramInt)
  {
    a(paramInt);
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(10, String.valueOf(130500));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
      localRedTouchManager.a(localAppInfo, "");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "clk_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), "");
  }
  
  public void b(int paramInt, TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsShow tip=" + paramTipsBarTask + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    TipsBarTask localTipsBarTask;
    do
    {
      return false;
      localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    } while ((localTipsBarTask == null) || (localTipsBarTask != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar));
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "currTip is togetherTip");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onPause()");
    }
    this.jdField_a_of_type_Boolean = false;
    TipsManager localTipsManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    if (localTipsManager != null) {
      localTipsManager.a(1003, new Object[0]);
    }
    h();
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) && (QLog.isColorLevel())) {
        QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper isTogetherTime mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_Int == 0)) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onStop()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b() == 1) {
      i = 1;
    }
    for (;;)
    {
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(2, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
      if ((localWatchTogetherSession == null) || (localWatchTogetherSession.jdField_h_of_type_Int != 1) || (localWatchTogetherSession.i == 2) || (localWatchTogetherSession.l != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onStop() hideTogetherTip");
      }
      localWatchTogetherSession.l = 2;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b() == 0) {
        i = 2;
      } else {
        i = 2;
      }
    }
  }
  
  public boolean d()
  {
    return (c()) && (TogetherWatchFloatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onDestroy()");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
    TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) {
      b();
    }
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.reset();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel.a();
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      bool1 = true;
    }
    TogetherSession localTogetherSession;
    do
    {
      do
      {
        return bool1;
        localTogetherSession = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "isHideTogetherTip = " + localTogetherSession.l);
        }
        bool1 = bool2;
      } while (!(localTogetherSession instanceof WatchTogetherSession));
      bool1 = bool2;
    } while (localTogetherSession.l != 2);
    return true;
  }
  
  public void f()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TogetherEntryBean localTogetherEntryBean = (TogetherEntryBean)QConfigManager.a().a(553);
    if ((localTogetherEntryBean != null) && (localTogetherEntryBean.jdField_a_of_type_Boolean) && (!((TroopManager)localObject).o(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        break label148;
      }
    }
    for (int i = 2130850851;; i = 2130850852)
    {
      ((NavBarAIO)localObject).setRight2Icon(i);
      try
      {
        if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167030);
          localObject = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130850852, i);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        label148:
        QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel.a())) {
      return true;
    }
    return h();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131369496));
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131376828));
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = (TogetherEntryBean)QConfigManager.a().a(553);
    if ((localObject2 != null) && (((TogetherEntryBean)localObject2).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!((TroopManager)localObject1).o(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (localObject1 != null) && (!((TroopManager)localObject1).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      int i;
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        i = 2130850851;
      }
      for (;;)
      {
        ((NavBarAIO)localObject1).setRight2Icon(i);
        localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
        localObject2 = ((RedTouchManager)localObject1).a(4, String.valueOf(130500));
        if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((RedTouchManager)localObject1).b((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
        }
        try
        {
          for (;;)
          {
            if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
            {
              i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167030);
              localObject1 = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130850852, i);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
            }
            if (AppSetting.d) {
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131699306));
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.aO();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "exp_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), "");
            return;
            i = 2130850852;
            break;
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public String getTag()
  {
    return "TogetherControlHelper.helper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      c((String)paramMessage.obj);
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 6, 10, 11, 14 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131379628) || (paramView.getId() == 2131379625)) {
      i();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131369496) {
        b(1);
      }
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      if (localTogetherControlManager != null) {
        localTogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt);
      }
      return;
      a();
      continue;
      b();
      continue;
      c();
      continue;
      d();
      continue;
      e();
      continue;
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper
 * JD-Core Version:    0.7.0.1
 */