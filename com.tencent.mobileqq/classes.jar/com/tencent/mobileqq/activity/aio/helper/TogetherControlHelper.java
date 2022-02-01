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
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TogetherTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private TogetherTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar;
  private TogetherWatchTroopTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramBaseChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData = new TogetherUIData();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("TogetherControlHelper mUIData=");
      paramBaseChatPie.append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
      QLog.d("TogetherControlHelper.helper", 2, paramBaseChatPie.toString());
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
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localBaseActivity != null) && (localBaseActivity.getIntent() != null))
    {
      if (!TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), paramTogetherSession, this.jdField_a_of_type_Boolean)) {
        return;
      }
      b(((TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(paramTogetherSession.jdField_e_of_type_Int));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "invokeJoinDialog activity or intent is null");
    }
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
    String str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131699410), new Object[] { paramString });
    paramString = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131699413), new Object[] { paramString });
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131690728);
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131694583);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null");
      }
      return false;
    }
    TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    if ((localTipsBarTask != null) && (localTipsBarTask != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "currTip is other");
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar, new Object[0]);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
    if (localObject != null)
    {
      if (((TogetherUIData)localObject).getTogetherSession() == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject instanceof TroopChatPie)) {
        ((TroopChatPie)localObject).aF();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject instanceof FriendChatPie)) {
        ((FriendChatPie)localObject).ap();
      }
    }
  }
  
  private boolean h()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return true;
    }
    return false;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar == null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(24)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar = new TogetherWatchTroopTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar);
    }
  }
  
  private void j()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click button too frequently pastTime=");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_b_of_type_Long);
        QLog.d("TogetherControlHelper.helper", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131720472, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
    if ((localObject != null) && (((TogetherUIData)localObject).getTogetherSession() != null))
    {
      TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      if (localTogetherControlManager == null) {
        return;
      }
      TogetherSession localTogetherSession = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
      boolean bool = localTogetherSession instanceof WatchTogetherSession;
      int i = 1;
      if (bool)
      {
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
        if (localObject == null) {
          return;
        }
        localObject = TogetherUtils.a(true, ((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0);
        i = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().j;
        if (i != 0)
        {
          if (i != 1)
          {
            if (localTogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TogetherControlHelper.helper", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
              }
            }
            else
            {
              localTogetherControlManager.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
              TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().k, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_JavaLangString, null, (Bundle)localObject, 1);
            }
          }
          else
          {
            localTogetherControlManager.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
            localTogetherControlManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), 1, 2, 1, (Bundle)localObject);
          }
        }
        else {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693100, 0).a();
        }
        localTogetherControlManager.a("video_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
        return;
      }
      if ((localTogetherSession instanceof SingTogetherSession))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "SING together is click");
        }
        localObject = null;
        Bundle localBundle = new Bundle();
        String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        String str2 = localTogetherSession.jdField_e_of_type_JavaLangString;
        int j = -1;
        bool = localTogetherControlManager.a(4, -1, str2);
        if (localTogetherSession.f == 1)
        {
          localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(localTogetherSession.jdField_e_of_type_JavaLangString);
          if (localObject == null) {
            return;
          }
          localBundle = TogetherUtils.a(bool, ((TroopInfo)localObject).isTroopOwner(str1), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, localTogetherSession.jdField_e_of_type_JavaLangString, 1);
          localTogetherControlManager.a("sing_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
          localObject = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
          j = 1;
        }
        else if (localTogetherSession.f == 2)
        {
          localBundle = TogetherUtils.a(bool, 4);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join", 0, 0, localTogetherSession.jdField_e_of_type_JavaLangString, "", "", "");
          localObject = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
          i = 2;
          j = 4;
        }
        else
        {
          i = -1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        if (bool)
        {
          localTogetherControlManager.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTogetherSession.jdField_e_of_type_JavaLangString, i, 4, j, localBundle);
          return;
        }
        localTogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTogetherSession.jdField_e_of_type_JavaLangString, i, 4, j, localBundle);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693100, 0).a();
  }
  
  private void k()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localBaseActivity != null) && (localBaseActivity.getIntent() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("open_together_panel", false))) {
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
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie instanceof TroopChatPie)) {
      TogetherControlManager.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (!(localObject instanceof TroopChatPie))
    {
      QLog.d("TogetherControlHelper.helper", 1, "chat pie not TroopChatPie");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel == null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel = new TogetherPanel(((BaseChatPie)localObject).a());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131364485);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (View)localObject, paramInt);
  }
  
  public void a(int paramInt, TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOtherTipsHide tip=");
      ((StringBuilder)localObject).append(paramTipsBarTask);
      ((StringBuilder)localObject).append(" type=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TogetherControlHelper.helper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
    if ((localObject != null) && (((TogetherUIData)localObject).getTogetherSession() != null))
    {
      boolean bool = true;
      if (paramInt == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar;
        if ((localObject != null) && (localObject != paramTipsBarTask))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip not equal TogetherTip");
          }
          if ((!TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession())) || (TogetherWatchFloatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f)) || (e())) {
            bool = false;
          }
          if (QLog.isColorLevel())
          {
            paramTipsBarTask = new StringBuilder();
            paramTipsBarTask.append("onOtherTipsHide expand=");
            paramTipsBarTask.append(bool);
            QLog.d("TogetherControlHelper.helper", 2, paramTipsBarTask.toString());
          }
          if (bool) {
            g();
          }
          h();
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide mUIData is null or session is null");
    }
  }
  
  public void a(String paramString)
  {
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
    if (localObject1 != null)
    {
      if (((TogetherUIData)localObject1).getTogetherSession() == null) {
        return;
      }
      boolean bool3 = a();
      boolean bool1 = false;
      boolean bool2;
      if (bool3)
      {
        bool2 = b();
      }
      else
      {
        if (!TogetherWatchFloatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f)) {
          bool1 = g();
        }
        bool2 = bool1;
        if (bool1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
          bool2 = bool1;
          if ((localObject1 instanceof WatchTogetherSession))
          {
            bool2 = bool1;
            if (((TogetherSession)localObject1).l == 2)
            {
              ((TogetherSession)localObject1).l = 1;
              bool2 = bool1;
            }
          }
        }
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onSubTitleClicked isPanelShow= ");
        ((StringBuilder)localObject1).append(bool3);
        ((StringBuilder)localObject1).append(" handle=");
        ((StringBuilder)localObject1).append(bool2);
        QLog.d("TogetherControlHelper.helper", 2, ((StringBuilder)localObject1).toString());
      }
      if (!bool2) {
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f;
      localObject1 = "clk_expand";
      Object localObject2;
      if (i == 2)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!bool3) {
          localObject1 = "clk_expand";
        } else {
          localObject1 = "clk_fold";
        }
        ReportController.b((AppRuntime)localObject2, "dc00899", "c2c_AIO", "", "sing_tab", (String)localObject1, 0, 2, paramString, "", "", "");
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int == 2)
      {
        localObject2 = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (bool3) {
          localObject1 = "clk_fold";
        }
        ((TogetherControlManager)localObject2).a("video_tab", (String)localObject1, 2, paramString);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int == 4)
      {
        localObject2 = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (bool3) {
          localObject1 = "clk_fold";
        }
        ((TogetherControlManager)localObject2).a("sing_tab", (String)localObject1, 2, paramString);
      }
      TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession(), bool3 ^ true);
      h();
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "curTip is togetherTip");
        }
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
    }
    return false;
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
    Object localObject1 = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getRuntimeService(IRedTouchManager.class, "");
    Object localObject2 = ((IRedTouchManager)localObject1).getAppInfo(10, String.valueOf(130500));
    if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
      ((IRedTouchManager)localObject1).onRedTouchItemClick((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
    ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_AIO", "", "hi_tab", "clk_hi", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
  }
  
  public void b(int paramInt, TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOtherTipsShow tip=");
      localStringBuilder.append(paramTipsBarTask);
      localStringBuilder.append(" type=");
      localStringBuilder.append(paramInt);
      QLog.d("TogetherControlHelper.helper", 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null))
    {
      TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
      if ((localTipsBarTask != null) && (localTipsBarTask == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherTipsBar))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "currTip is togetherTip");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
    }
    return false;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
    boolean bool2 = false;
    if ((localObject != null) && (((TogetherUIData)localObject).getTogetherSession() != null))
    {
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_Int != 3)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_Int != 0) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TogetherControlHelper isTogetherTime mUIData=");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
      QLog.d("TogetherControlHelper.helper", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onStop()");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null) {
      return;
    }
    int i;
    if (((BaseChatPie)localObject).b() == 1)
    {
      i = 1;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b();
      i = 2;
    }
    localObject = (WatchTogetherSession)TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(2, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
    if (localObject == null) {
      return;
    }
    if ((((TogetherSession)localObject).jdField_h_of_type_Int == 1) && (((TogetherSession)localObject).i != 2) && (((TogetherSession)localObject).l == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onStop() hideTogetherTip");
      }
      ((TogetherSession)localObject).l = 2;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
    if (localObject != null) {
      ((TogetherUIData)localObject).reset();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel;
    if (localObject != null)
    {
      ((TogetherPanel)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTogetherWatchTroopTipsBar = null;
  }
  
  public boolean e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
    if (localObject != null)
    {
      if (((TogetherUIData)localObject).getTogetherSession() == null) {
        return true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isHideTogetherTip = ");
        localStringBuilder.append(((TogetherSession)localObject).l);
        QLog.d("TogetherControlHelper.helper", 2, localStringBuilder.toString());
      }
      if (!(localObject instanceof WatchTogetherSession)) {
        return false;
      }
      return ((TogetherSession)localObject).l == 2;
    }
    return true;
  }
  
  public void f()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TogetherEntryBean localTogetherEntryBean = (TogetherEntryBean)QConfigManager.a().a(553);
    if ((localTogetherEntryBean != null) && (localTogetherEntryBean.jdField_a_of_type_Boolean) && (!((TroopManager)localObject).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      int i;
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        i = 2130850788;
      } else {
        i = 2130850789;
      }
      ((NavBarAIO)localObject).setRight2Icon(i);
      try
      {
        if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053);
          localObject = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130850789, i);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public boolean f()
  {
    TogetherPanel localTogetherPanel = this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanel;
    if ((localTogetherPanel != null) && (localTogetherPanel.a())) {
      return true;
    }
    return h();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131369211));
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131376320));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
        return;
      }
      Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject2 = (TogetherEntryBean)QConfigManager.a().a(553);
      if ((localObject2 != null) && (((TogetherEntryBean)localObject2).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!((TroopManager)localObject1).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!((TroopManager)localObject1).g(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        int i;
        if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          i = 2130850788;
        } else {
          i = 2130850789;
        }
        ((NavBarAIO)localObject1).setRight2Icon(i);
        localObject1 = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
        localObject2 = ((IRedTouchManager)localObject1).getAppInfo(4, String.valueOf(130500));
        if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((IRedTouchManager)localObject1).onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        try
        {
          if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
          {
            i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053);
            localObject1 = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130850789, i);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
        }
        if (AppSetting.d) {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131699411));
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ai();
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
        ReportController.b(localQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "exp_hi", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
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
    return new int[] { 4, 8, 7, 10, 11, 12, 15 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131378972) && (paramView.getId() != 2131378969))
    {
      if (paramView.getId() == 2131369211) {
        b(1);
      }
    }
    else {
      j();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15)
      {
        if (paramInt != 7)
        {
          if (paramInt != 8) {
            switch (paramInt)
            {
            default: 
              break;
            case 12: 
              d();
              break;
            case 11: 
              c();
              break;
            case 10: 
              i();
              break;
            }
          } else {
            k();
          }
        }
        else {
          b();
        }
      }
      else {
        e();
      }
    }
    else {
      a();
    }
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    if (localTogetherControlManager != null) {
      localTogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper
 * JD-Core Version:    0.7.0.1
 */